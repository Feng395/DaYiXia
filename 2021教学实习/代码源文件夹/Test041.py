# 用Python语言实现顺序查找和折半查找

# 顺序查找
def SeqSearch(seqlist, item):
    # 初始查找位置
    pos = 0
    # 未找到数据对象
    found = False
    while pos < len(seqlist) and not found:
        if seqlist[pos] == item:  # 找到匹配对象，返回TRUE
            found = True
        else:  # 否则查找位置  + 1
            pos = pos + 1
    return found


if __name__ == '__main__':
    testlist = [3, 5, 6, 21, 25, 26, 27, 31, 72, 75]
    if SeqSearch(testlist, 21):
        print('查找值找到了！')
    else:
        print('查找值没有找到！')
