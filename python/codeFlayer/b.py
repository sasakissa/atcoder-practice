a, b, n = map(int, input().split())
x = input()

for i in x:
    if i == 'S' and a > 0:
        a -= 1
    elif i == 'C' and b > 0:
        b -= 1
    elif i == "E":
        if a > b and a > 0:
            a -= 1
        elif a == b and a > 0:
            a -= 1
        elif b > a and b > 0:
            b -= 1
print(a)
print(b)

