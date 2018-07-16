n = int(input())
a_list = list(map(int, input().split()))

min = pow(10, 9)
max = 0

for a in a_list:
    if max < a:
        max = a
    if min > a:
        min = a

print(max-min)