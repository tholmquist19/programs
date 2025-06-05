#!  /usr/bin/env python3


def merge(A, p, q, r):
    n1 = q - p + 1
    n2 = r - q

    # create temp arrays
    L = [0] * (n1)
    R = [0] * (n2)

    # Copy data to temp arrays L[] and R[]
    for i in range(0, n1):
        L[i] = A[p + i]

    for j in range(0, n2):
        R[j] = A[q + 1 + j]

    #if len(L)>1:
    #    mergeSort(L,0,len(L)-1)
    #if len(R)>1:
    #    mergeSort(R,0,len(R)-1)

    # Merge the temp arrays back into arr[l..r]
    i = 0  # Initial index of first subarray
    j = 0  # Initial index of second subarray
    k = p  # Initial index of merged subarray

    while i < n1 and j < n2:
        if L[i] <= R[j]:
            A[k] = L[i]
            i += 1
        else:
            A[k] = R[j]
            j += 1
        k += 1

    # Copy the remaining elements of L[], if there
    # are any
    while i < n1:
        A[k] = L[i]
        i += 1
        k += 1

    # Copy the remaining elements of R[], if there
    # are any
    while j < n2:
        A[k] = R[j]
        j += 1
        k += 1


# l is for left index and r is right index of the
# sub-array of arr to be sorted


def mergeSort(A, p, r):
    if p < r:
        # Same as (l+r)//2, but avoids overflow for
        # large l and h
        m = int((p + r) / 2)
        f = int(m/2)
        f2 = int((p+r)/2)

        # Sort first and second halves
        mergeSort(A, p, f)
        mergeSort(A, f+1, m)
        mergeSort(A, m+1, f2)
        mergeSort(A, f2+1, r)
        if p+1!=r:
            mergeSort(A,p,m)
        merge(A, p, m, r)
    return A



A = [3,2,9,8,4,5,1,6,11,12,3,2,9,8,4,5,1,6,11,12]
print(mergeSort(A,0,19))

