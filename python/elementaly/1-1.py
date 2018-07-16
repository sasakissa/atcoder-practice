def calc_score(num, m):
    if num <= m:
        return num
    else:
        return 0

n, m = list(map(int, input().split()))
p_list = [int(input()) for i in range(n)]

p_list = reversed(sorted(p_list))

dp = [[0 for j in range(n)] for i in range(m+1)]


for i in range(1, m+1):
    dp[i][n-1] = calc_score(p_list[n-1], m)

for i in range(1, m+1):
    for j in range(n-1, -1, -1):
        dp[i][j] = max()
