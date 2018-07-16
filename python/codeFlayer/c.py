n, d = list(map(int, input().split()))
x_list = list(map(int, input().split()))

R = [0 for i in range(n)]
L = [0 for i in range(n)]

right, left = 0, 0
for mid in range(n):
    while right < n and (x_list[right] - x_list[mid]) <= d:
        right += 1
    while left < mid and (x_list[mid] - x_list[left]) > d:
        left += 1
    R[mid] = right - 1
    L[mid] = left

ans = 0
for mid in range(n):
    ans += (R[mid] - mid) * (mid - L[mid])
for left in range(n):
    ans -= (R[left] - left) * (R[left] - left - 1) // 2
print(ans)