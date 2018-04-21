A, B, K = map(int, input().split())

if A + K >= B or A >= B - K:
    ans = [i for i in range(A, B+1)]
else:
    ans = [i for i in range(A, A+K)]
    ans.extend([j for j in range(B - K + 1, B+1)])
    ans = sorted(list(set(ans)))
for i in ans:
    print(i)