#-- coding utf8 --#
from collections import Counter


N = input()
ansStr = input()

counter = Counter(ansStr)

res_1 = counter['1']
res_2 = counter['2']
res_3 = counter['3']
res_4 = counter['4']
_max = max([res_1, res_2, res_3, res_4])
_min = min([res_1, res_2, res_3, res_4])
print(str(_max) + ' ' + str(_min))
