s = input()

p = 0
m = 0

for i in s:
    if i == "+":
        p += 1
    if i == "-":
        m += 1

print(1*p + (-1)*m)
