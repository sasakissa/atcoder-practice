n = int(input())
a_list = [int(i) for i in input().split()]

ans = 0
tmp = 0
before = 0
a_list.append(100000)

for a in a_list:

    if a == before:
        tmp += 1
    elif tmp > 0:

        ans += (tmp+1) // 2
        tmp = 0
    before = a
print(ans)