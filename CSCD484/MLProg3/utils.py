# Various tools for data manipulation.
# Author: Bojian Xu, bojianxu@ewu.edu


import numpy as np
import math


class MyUtils:
    def rand_matrix(nb_rows=1, nb_cols=1):
        ''' return a nb_row x nb_col matrix of random numbers from (-1,1)
        '''
        X = np.random.rand(nb_rows, nb_cols) * np.sign(np.random.rand(nb_rows, nb_cols) - 0.5)

        return X

    def normalize_0_1(X):
        ''' Normalize the value of every feature into the [0,1] range, using formula: x = (x-x_min)/(x_max - x_min)
            1) First shift all feature values to be non-negative by subtracting the min of each column
               if that min is negative.
            2) Then divide each feature value by the max of the column if that max is not zero.

            X: n x d matrix of samples, excluding the x_0 = 1 feature. X can have negative numbers.
            return: the n x d matrix of samples where each feature value belongs to [0,1]
        '''

        n, d = X.shape
        X_norm = X.astype('float64')  # Have a copy of the data in float

        for i in range(d):
            col_min = min(X_norm[:, i])
            col_max = max(X_norm[:, i])
            gap = col_max - col_min
            if gap:
                X_norm[:, i] = (X_norm[:, i] - col_min) / gap
            else:
                X_norm[:, i] = 0  # X_norm[:,i] - X_norm[:,i]

        return X_norm

    def normalize_neg1_pos1(X):
        ''' Normalize the value of every feature into the [-1,+1] range.

            X: n x d matrix of samples, excluding the x_0 = 1 feature. X can have negative numbers.
            return: the n x d matrix of samples where each feature value belongs to [-1,1]
        '''
        # To be implemented
        n, d = X.shape
        X_norm = X.astype('float64')  # Have a copy of the data in float

        for i in range(d):
            col_min = min(X_norm[:, i])
            col_max = max(X_norm[:, i])
            col_mid = (col_max + col_min) / 2
            gap = (col_max - col_min) / 2
            if gap:
                X_norm[:, i] = (X_norm[:, i] - col_mid) / gap
            else:
                X_norm[:, i] = 0  # X_norm[:,i] - X_norm[:,i]

        return X_norm

    def z_transform(X, degree=2):
        ''' Transforming traing samples to the Z space
            X: n x d matrix of samples, excluding the x_0 = 1 bias feature
            degree: the degree of the Z space
            return: the n x d' matrix of samples in the Z space, excluding the z_0 = 1 feature.
            It can be mathematically calculated: d' = \sum_{k=1}^{degree} (k+d-1) \choose (d-1)
        '''

        if degree == 1:
            return X
        ### BEGIN YOUR SOLUTION
        r = degree
        dimensions = np.shape(X)
        n, d = dimensions
        l = np.zeros(d, int)
        Z = X
        for i in range(d):  # Creating l
            l[i] = int(i + 1)
        q = 0  # total size of all buckets before previous bucket
        p = d  # total size of all previous buckets
        g = d  # index of the new column in Z that is being computed
        B = np.zeros(d)  # Bucket
        h = 0  # used to calculate bucket input
        while h < d:  # filling out bucket
            t = h + d - 1
            f = 0
            y = 0
            for s in range(t + 1):
                f += s
            for s in range(d + 1):
                y += s
            n = f / y
            B[h] = n
            h += 1  # Done filling out bucket

        i = 2  # Create the following buckets
        while i <= r:
            j = q  # j gets total size of all buckets before previous bucket
            b_size = 0
            while j < p:  # process the buckets being used to calculate new bucket
                k = l[j] - 1
                while k < d:
                    temp = Z[:, j] * X[:, k]
                    Z = np.append(Z, temp.reshape(-1, 1), 1)
                    l = np.append(l, k + 1)
                    g += 1
                    k += 1
                    b_size += 1
                j += 1
            i += 1
            q = p
            p = p + b_size
        return Z

        # raise NotImplementedError()
        ### END YOUR SOLUTION



