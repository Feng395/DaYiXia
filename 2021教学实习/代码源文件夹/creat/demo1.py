from PIL import Image

# 生成缩略图
src = Image.open('pic01.jpg')
src.thumbnail((100, 100))
src.save('pic01_small.jpg')
