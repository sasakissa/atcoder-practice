import math
x = int(input())
cand_list = [1]
for i in range(int(math.sqrt(x)), 1, -1):
    ans = i
    while(ans <= x):
        cand_list.append(ans)
        ans *= i

print(max(cand_list))