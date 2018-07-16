n = int(input())
a_list = list(map(int, input().split()))

sum = [[0 for j in range(n)] for i in range(n)]
xor = [[0 for j in range(n)] for i in range(n)]
ans = n

for i in range(n):
    sum[i][i] = a_list[i]
    xor[i][i] = a_list[i]
for r in range(n):
    for l in range(r+1, n):
        sum[r][l] = sum[r][l-1] + a_list[l]
        xor[r][l] = xor[r][l - 1] ^ a_list[l]
        if sum[r][l] == xor[r][l]:
            ans += 1

print(ans)
