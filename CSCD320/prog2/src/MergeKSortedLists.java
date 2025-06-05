mergeKLists(lists):
        if size of lists is 1:
        return the single list

        mid = size of lists / 2
        left = mergeKLists(first half of lists)
        right = mergeKLists(second half of lists)

        return merge(left, right)

        merge(left, right):
        result = empty array of size left.length + right.length
        l = 0, r = 0, idx = 0

        while l < left.length and r < right.length:
        if left[l] < right[r]:
        result[idx] = left[l]
        idx++
        l++
        else:
        result[idx] = right[r]
        idx++
        r++

        while l < left.length:
        result[idx] = left[l]
        idx++
        l++

        while r < right.length:
        result[idx] = right[r]
        idx++
        r++

        return result