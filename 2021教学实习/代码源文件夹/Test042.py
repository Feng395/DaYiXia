# 用Python语言实现顺序查找和折半查找

# 折半查找
def BinSearch(arr, m):
    low = 0
    high = len(arr) - 1
    k = -1
    while low <= high:
        mid = (low + high) // 2
        if m < arr[mid]:
            high = mid - 1
        else:
            if m > arr[mid]:
                low = mid + 1
            else:
                k = mid
                break
    return k


arr = [5, 9, 11, 13, 21, 25, 28, 38, 47]
if BinSearch(arr, 13):
    print('Value found!')
else:
    print("Not be found!")
