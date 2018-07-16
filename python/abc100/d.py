
n, m = list(map(int, input().split()))
score_list = [list(map(int, input().split())) for i in range(n)]
maxn = 0
for i in range(8):
    vec = []
    for j in range(n):
        s = 0
        for k in range(3):
            if (i / (1 << k)) % 2 == 0:
                s += score_list[j][k]
            else:
                s -= score_list[j][k]
        vec.append(s)
    ans = 0
    vec.sort()
    vec.reverse()
    for j in range(m):
        ans += vec[j]
    maxn = max(maxn, ans)
print(maxn)