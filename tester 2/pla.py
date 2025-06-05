# Implementation of the perceptron learning algorithm. Support the pocket version for linearly unseparatable data.
# Authro: Bojian Xu, bojianxu@ewu.edu

# Important observation:
#    - The PLA can increase or decrease $w[0]$ by 1 per update, so if there is a big difference between $w^*[0]$ and the #initial value of $w[0]$, the PLA is likely to take a long time before it halts. However, the theoretical bound $O((L/d)^2)$ #step of course still holds, where $L = \max\{\lVert x\rVert\}$ and $d$ is the margine size.
#    - This can solved by always have feature values within [0,1], because by doing so, the $x_0=1$ becomes relatively larger (or one can also say $x_0$ becomes fairly as important as other feathers), which makes the changes to $w[0]$ much faster. This is partially why nueral network requires all feature value to be [0,1] --- the so-called data normalization process!!!

# Another reason for normalizing the feature into [0,1] is: no matter which Z space the samples are tranformed to, the Z-space sample features will still be in the [0,1] range.

import numpy as np


# import sys
# sys.path.append("..")

from utils import MyUtils


class PLA:
    def __init__(self, degree=1):
        self.w = None
        self.degree = degree

    def fit(self, X, y, pocket=True, epochs=100):
        ''' find the classifer weight vector and save it in self.w
            X: n x d matrix, i.e., the bias feature is not included.
            It is assumed that X is already normalized be data preprocessing.
            y: n x 1 vector of {+1, -1}
            degree: the degree of the Z space
            return self.w
        '''

        if (self.degree > 1):
            X = MyUtils.z_transform(X, degree=self.degree)

        ### BEGIN YOUR SOLUTION
        dimensions = np.shape(X)
        n, d = dimensions
        self.w = np.zeros(d+1)
        X = np.insert(X,0,1, axis=1)
        change = True

        if not pocket:
            while change:
                change = False
                for i in range(n):
                    delt = np.sign(X[i] @ self.w)
                    if delt != y[i]:
                        change = True
                        self.w += (y[i] * X[i])
            return self.w
        else:
            new_w = np.random.rand(self.w.size)
            while change and epochs > 0:
                change = False
                epochs -= 1
                for i in range(n):
                    delt = np.sign(X[i] @ self.w)
                    if delt != y[i]:
                        change = True
                        self.w += (y[i] * X[i])
                        check_self = np.sum(self.w*X[i])/np.sum(y)
                        check_new = np.sum(new_w*X[i])/np.sum(y)
                        ls = np.array([check_self, check_new])
                        check = np.abs(ls-0)
                        check_self = check[0]
                        min = np.min(check)
                        if min == check_self:
                            new_w = np.copy(self.w)
            return new_w

        # raise NotImplementedError()
        ### END YOUR SOLUTION

        #return self.w

    def predict(self, X):
        ''' x: n x d matrix, i.e., the bias feature is not included.
            return: n x 1 vector, the labels of samples in X
        '''
        if (self.degree > 1):
            X = MyUtils.z_transform(X, degree=self.degree)

        ### BEGIN YOUR SOLUTION

        a = np.insert(X, 0, 1, axis=1)
        y = np.dot(a, self.w)
        y_pred = np.where(y > 0, 1, 0)
        return y_pred
        # raise NotImplementedError()
        ### END YOUR SOLUTION

    def error(self, X, y):
        ''' X: n x d matrix, i.e., the bias feature is not included.
            y: n x 1 vector
            return the number of misclassifed elements in X using self.w
        '''

        if (self.degree > 1):
            X = MyUtils.z_transform(X, degree=self.degree)

        ### BEGIN YOUR SOLUTION




        dimensions = np.shape(X)
        n, d = dimensions
        if np.sum(X[:,0]) != n:
            a = np.insert(X, 0, 1,axis=1)
        else:
            a = X
        w = self.w
        dim = np.shape(a)
        l, s = dim
        if w.size != s:
            w = np.append(self.w, np.random.rand(s-self.w.size))
        y_pred = np.sign(a @ w)

        r = np.sum(y_pred)
        s = np.sum(y)
        return r-s

        # raise NotImplementedError()
        ### END YOUR SOLUTION