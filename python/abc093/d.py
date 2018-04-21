from math import sqrt
from math import floor

Q = int(input())
A_list = []
B_list = []

for i in range(Q):
    A, B = map(int, input().split())
    A_list.append(A)
    B_list.append(B)

for A, B in zip(A_list, B_list):
    if A == B:
        print(2*A-2)
        continue
    if abs( A - B) == 1:
        print(2*min(A, B)-2)
        continue
    C = int(floor(sqrt(A*B)))
    if C*C >= A*B:
        C -= 1
    if C * (C + 1) >= A*B:
        print(2*C-2)
        continue
    print(2*C-1)



# my ans TLE
# for A, B in zip(A_list, B_list):
#     ans = 0
#     former_used = {A: True}
#     second_used = {B: True}
#     for i in range(1, int((sqrt(A*B))) + 1):
#         candidate = int(A*B // i) if A*B % i != 0 else int(A*B // i - 1)
#         if i == candidate:
#             if i*candidate < A*B:
#                 ans += 1
#                 former_used[i] = True
#                 second_used[i] = True
#             break
#         # 使用済みかチェック
#         if i not in former_used and candidate not in second_used:
#             ans += 1
#             former_used[i] = True
#             second_used[candidate] = True
#         if i not in second_used and candidate not in former_used:
#             ans += 1
#             former_used[candidate] = True
#             second_used[i] = True
#
#     print(ans)
