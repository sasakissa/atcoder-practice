a, b = list(map(int, input().split()))

c = b - a
n = 0
for i in range(c):
    n += i

print(n-a)

