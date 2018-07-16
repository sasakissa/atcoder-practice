n = int(input())

dp = [0 for i in range(max(n+1, 36))]

for i in range(35):
    j = i // 9
    cand = []
    for k in range(j+1):
       _i = i
       _i -= 9*k
       l = _i // 6
       for m in range(l+1):
           __i = _i
           __i -= 6*m
           cand.append(k+m+__i)
    dp[i] = min(cand)
nine_list = [pow(9, i) for i in range(1, 6)]
six_list = [pow(6, i) for i in range(1, 7)]
for i in range(35, n+1):
    max_nine = nine_list[len(nine_list) - 1]
    max_six = six_list[len(six_list) - 1]
    for j in range(len(nine_list)):
        if nine_list[j] > i:
            max_nine = nine_list[j-1]
            break
    for j in range(len(six_list)):
        if six_list[j] > i:
            max_six = six_list[j-1]
            break
    dp[i] = min(dp[i-max_nine]+1, dp[i-max_six]+1)

print(dp[n])