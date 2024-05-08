from PIL import Image
from PIL import ImageFilter

im = Image.open('pic3.jpg')

# 模糊
im2 = im.filter(ImageFilter.BLUR)
# 轮廓滤波
im3 = im.filter(ImageFilter.CONTOUR)
# 边缘增强滤波（锐化）
im4 = im.filter(ImageFilter.EDGE_ENHANCE)
# 浮雕滤波
im5 = im.filter(ImageFilter.EMBOSS)
# 寻找边缘信息的滤波
im6 = im.filter(ImageFilter.FIND_EDGES)

im2.save('pic3_BLUR.jpg')
im3.save('pic3_CONTOUR.jpg')
im4.save('pic3_EDGE_ENHANCE.jpg')
im5.save('pic3_EMBOSS.jpg')
im6.save('pic3_FIND_EDGES.jpg')
