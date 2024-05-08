# 用Python语言实现起泡排序和快速排序

# 起泡排序
def BubbleSort(arr):
    for i in range(1, len(arr)):
        for j in range(0, len(arr) - i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


# 快速排序
def partition(arr, low, high):
    # 最小元素索引
    i = (low - 1)
    pivot = arr[high]
    for j in range(low, high):
        # 当前元素小于或等于 pivot
        if arr[j] <= pivot:
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    return (i + 1)


def quickSort(arr, low, high):
    if low < high:
        temp = partition(arr, low, high)
        quickSort(arr, low, temp - 1)
        quickSort(arr, temp + 1, high)


array1 = [3, 25, 75, 72, 31, 26, 27, 5, 6, 21]
array2 = [25, 47, 28, 9, 11, 5, 13, 38, 21]
print("起泡排序前的数组:", array1)
print("快速排序前的数组:", array2)
BubbleSort(array1)
quickSort(array2, 0, len(array2) - 1)
print("起泡排序后的数组:", array1)
print("快速排序后的数组:", array2)
