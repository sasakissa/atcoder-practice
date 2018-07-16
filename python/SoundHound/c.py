n, m, d = [int(i) for i in input().split()]

c = 0
if d ==0:
    c = n
elif n > 2*d:
    c = 2*(n-2*d) + 2*d
else:
    c = 2*(n-d)

p = c / pow(n, 2)
print(c*(m-1) / pow(n, 2))