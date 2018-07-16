from functools import reduce
s = input()
w = int(input())

a = len(s)//w + 1 if len(s) % w != 0 else len(s)//w

ans = [s[w*i] for i in range(a)]
print(reduce(lambda a, b: a+b, ans))