#! /usr/bin/env/ python3

import numpy as np
import pandas as pd
import logistic_regression as logic
import sys
sys.path.append('..')
from code_misc.utils import MyUtils
def main():
    data_set = 'ionosphere'
    df_X_train = pd.read_csv(data_set + '/' + 'X_train.csv', header=None)
    df_y_train = pd.read_csv(data_set + '/' + 'y_train.csv', header=None)
    df_X_test = pd.read_csv(data_set + '/' + 'X_test.csv', header=None)
    df_y_test = pd.read_csv(data_set + '/' + 'y_test.csv', header=None)
    X_train = df_X_train.to_numpy()
    y_train = df_y_train.to_numpy()
    X_test = df_X_test.to_numpy()
    y_test = df_y_test.to_numpy()

    # get training set size
    n_train = X_train.shape[0]

    # normalize all features to [0,1] or [-1,1]
    if data_set == 'ionosphere':
        X_all = MyUtils.normalize_neg1_pos1(np.concatenate((X_train, X_test), axis=0))
    X_train = X_all[:n_train]
    X_test = X_all[n_train:]
    log = logic.LogisticRegression()
    log.fit(X_train, y_train, lam=0, eta=0.1, iterations=50000, SGD=True, mini_batch_size=20, degree=3)

if __name__ == "__main__":
    main()
