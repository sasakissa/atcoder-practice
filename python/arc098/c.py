n = input()
s = input()


e_cnt = 0
for i in range(1, len(s)):
    if s[i] == 'E':
        e_cnt += 1
res = []
res.append(e_cnt)
for i in range(1, len(s)):
    add = 0
    if s[i-1] == 'W':
        add += 1
    if s[i] == 'E':
        add -= 1
    res.append(res[i-1] + add)

print(min(res))