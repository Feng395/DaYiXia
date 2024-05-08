# 1. 数据类型
# 利用Python语言中的组合数据类型对学号和姓名进行存储，并实现利用学号访问姓名和利用姓名访问学号的操作。

# 初始化一个字典存储学号和姓名信息
stus = {'001': '张三', '002': '李四', '003': '王五', '004': '赵六'}

while True:
    ope = input('请输入操作（1按学号查找，2按姓名查找，0退出）：')
    if ope == '1':
        number = input('请输入查找的学号：')
        if stus.get(number) != None:
            print('该学号对应的学生姓名为：', stus.get(number))
        else:
            print('没有符合条件的学生!')
    elif ope == '2':
        name = input('请输入查找的姓名：')
        stu_number = [k for k, v in stus.items() if v == name]
        if stu_number != []:
            print('该姓名对应的学生学号为：', stu_number[0])
        else:
            print('没有符合条件的学生!')
    elif ope == '0':
        print('退出')
        break
    else:
        print('您的输入不对，请重新输入')
        continue
