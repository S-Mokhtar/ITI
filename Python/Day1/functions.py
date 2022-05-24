import math
import sys
from typing import Counter
# def distance():
#     x1=float(input('Enter X1: \n'))
#     y1=float(input('Enter Y1: \n'))
#     x2=float(input('Enter X2: \n'))
#     y2=float(input('Enter Y2: \n'))
#     return print(math.sqrt(pow(x2-x1,2)+pow(y2-y1,2)))
# result= distance()

# def list():
#     l=[1,2,2,3,3,4,5]
#     return print(set(l))
# result= list()

# def halves(s1,s2):
#     mid_s1=math.ceil(len(s1)/2)
#     mid_s2=math.ceil(len(s2)/2)
#     return print(s1[:mid_s1]+s2[:mid_s2],s1[mid_s1:]+s2[mid_s2:])
# result= halves("abcd","wxyzq")

# def file():
#     f = open(sys.argv[len(sys.argv)-1], 'w')
#     f.write("the the session session day day day year year year month month month jan jan jan break break break")
#     f.close()
#     f2= open('test.txt','r')
#     content = f2.read()
#     splited = content.split()
#     counter=Counter(splited)
#     most_occur = counter.most_common(20)
#     f2.close()
#     f1=open('popular_words.txt', 'w')
#     f1.write(str(most_occur))
#     f1.close()
#     return print('Done')
# result = file()

# def vowels():
#     string = 'Mahitab Shaimaa'
#     vowels = ('a', 'e', 'i', 'o', 'u')
#     for x in string.lower():
#         if x in vowels:
#             string = string.replace(x,"")
#     print(string)
# result = vowels()

ini_string = 'abcdefcc'
c = "c"
res = []
for i in range(0, len(ini_string)):
	if ini_string[i] == c:
		res.append(i + 1)
print ("Character {} is present at {}".format(c, str(res)))
