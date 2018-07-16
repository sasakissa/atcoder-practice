d, n = list(map(int, input().split()))

cnt = 0
for i in range(1, n+1):
    cnt+=1
    if i % 100 == 0 and i // 100 >= 1:
        cnt+=1
print(pow(100, d)*cnt)

