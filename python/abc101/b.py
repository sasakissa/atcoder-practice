n_str = input()
n = int(n_str)

s = 0
for i in n_str:
    s += int(i)

if n % s == 0:
    print('Yes')
else:
    print('No')
