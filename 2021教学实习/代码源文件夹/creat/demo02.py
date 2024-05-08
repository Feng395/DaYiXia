from PIL import Image
from PIL import ImageFilter

src = Image.open('pic2.jpg')
src2 = src.filter(ImageFilter.CONTOUR)
src2.save('pic2Contour.jpg')
