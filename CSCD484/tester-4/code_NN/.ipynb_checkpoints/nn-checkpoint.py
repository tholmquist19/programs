# Place your EWU ID and Name here. 

### Delete every `pass` statement below and add in your own code. 



# Implementation of the forwardfeed neural network using stachastic gradient descent via backpropagation
# Support parallel/batch mode: process every (mini)batch as a whole in one forward-feed/backtracking round trip. 



import numpy as np
import math
from . import math_util as mu
from . import nn_layer


class NeuralNetwork:
    
    def __init__(self):
        self.layers = []     # the list of L+1 layers, including the input layer. 
        self.L = -1          # Number of layers, excluding the input layer. 
                             # Initting it as -1 is to exclude the input layer in L. 
    
    
    def add_layer(self, d = 1, act = 'tanh'):
        ''' The newly added layer is always added AFTER all existing layers.
            The firstly added layer is the input layer.
            The most recently added layer is the output layer. 
            
            d: the number of nodes, excluding the bias node, which will always be added by the program. 
            act: the choice of activation function. The input layer will never use an activation function even if it is given. 
            
            So far, the set of supported activation functions are (new functions can be easily added into `math_util.py`): 
            - 'tanh': the tanh function
            - 'logis': the logistic function
            - 'iden': the identity function
            - 'relu': the ReLU function
        '''

        self.L += 1
        self.layers.append(nn_layer.NeuralLayer(d=d, act=act))



    def _init_weights(self):
        ''' Initialize every layer's edge weights with random numbers from [-1/sqrt(d),1/sqrt(d)], 
            where d is the number of nonbias node of the layer
        '''

        l = 1
        while l < len(self.layers):
            cur = self.layers[l].d
            prev = self.layers[l - 1].d
            # Initialize weights with shape (d_prev + 1, d_cur), transpose to match the expected shape
            self.layers[l].W = np.random.uniform(-1 / np.sqrt(prev), 1 / np.sqrt(prev), (prev + 1, cur))
            l += 1


    def fit(self, X, Y, eta = 0.01, iterations = 1000, SGD = True, mini_batch_size = 1):
        ''' Find the fitting weight matrices for every hidden layer and the output layer. Save them in the layers.
          
            X: n x d matrix of samples, where d >= 1 is the number of features in each training sample
            Y: n x k vector of lables, where k >= 1 is the number of classes in the multi-class classification
            eta: the learning rate used in gradient descent
            iterations: the maximum iterations used in gradient descent
            SGD: True - use SGD; False: use batch GD
            mini_batch_size: the size of each mini batch size, if SGD is True.  
        '''

        self._init_weights()  # Initialize the edge weight matrices with random numbers.

        n = X.shape[0]

        for _ in range(iterations):
            if SGD:
                indices = np.random.permutation(n)
                X_shuffled = X[indices]
                Y_shuffled = Y[indices]
                for i in range(0, n, mini_batch_size):
                    X_batch = X_shuffled[i:i + mini_batch_size]
                    Y_batch = Y_shuffled[i:i + mini_batch_size]
                    self._fit_batch(X_batch, Y_batch, eta)
            else:
                self._fit_batch(X, Y, eta)



    def _fit_batch(self, X, Y, eta):

        n = X.shape[0]
        A = [X]

        # Forward propagation
        for l in range(1, len(self.layers)):
            A.append(mu.MyMath.tanh(np.dot(np.hstack([A[-1], np.ones((A[-1].shape[0], 1))]), self.layers[l].W)))

        # Backward propagation
        delta = [None] * (self.L + 1)
        delta[self.L] = A[-1] - Y
        for l in range(self.L, 0, -1):
            delta[l - 1] = mu.MyMath.tanh_de(A[l - 1]) * np.dot(delta[l], self.layers[l].W[1:, :].T)

        # Update weights
        for l in range(1, len(self.layers)):
            ones_column = np.ones((A[l - 1].shape[0], 1))
            A_with_bias = np.concatenate((ones_column, A[l - 1]), axis=1)
            self.layers[l].W -= eta * np.dot(A_with_bias.T, delta[l]) / n

    # I will leave you to decide how you want to organize the rest of the code, but below is what I used and recommend. Decompose them into private components/functions.

        ## prep the data: add bias column; randomly shuffle data training set. 

        ## for every iteration:
        #### get a minibatch and use it for:
        ######### forward feeding
        ######### calculate the error of this batch if you want to track/observe the error trend for viewing purpose.
        ######### back propagation to calculate the gradients of all the weights
        ######### use the gradients to update all the weight matrices.


    def predict(self, X):
        ''' X: n x d matrix, the sample batch, excluding the bias feature 1 column.
            
            return: n x 1 matrix, n is the number of samples, every row is the predicted class id.
            
            Note that the return of this function is NOT the sames as the return of the `NN_Predict` method
            in the lecture slides. In fact, every element in the vector returned by this function is the column
            index of the largest number of each row in the matrix returned by the `NN_Predict` method in the 
            lecture slides.
         '''
        A = X
        for l in range(1, len(self.layers)):
            A = mu.MyMath.tanh(np.dot(np.hstack([A, np.ones((A.shape[0], 1))]), self.layers[l].W))
        return np.argmax(A, axis=1).reshape(-1, 1)



    
    
    def error(self, X, Y):
        ''' X: n x d matrix, the sample batch, excluding the bias feature 1 column. 
               n is the number of samples. 
               d is the number of (non-bias) features of each sample. 
            Y: n x k matrix, the labels of the input n samples. Each row is the label of one sample, 
               where only one entry is 1 and the rest are all 0. 
               Y[i,j]=1 indicates the ith sample belongs to class j.
               k is the number of classes. 
            
            return: the percentage of misclassfied samples
        '''
        Y_pred = self.predict(X)
        return np.sum(Y_pred != Y.reshape(-1, 1)) / X.shape[0]

 
