import numpy as np

n, c = list(map(int, input().split()))
d_mat = [list(map(int, input().split())) for _ in range(c)]
c_mat = [list(map(int, input().split())) for _ in range(n)]

zero_cnt_list = [0 for i in range(c)]
one_cnt_list = [0 for i in range(c)]
two_cnt_list = [0 for i in range(c)]

for i in range(n):
    for j in range(n):
        if ((i+1)+(j+1)) % 3 == 0:
            zero_cnt_list[c_mat[i][j] - 1] += 1
        elif ((i+1)+(j+1)) % 3 == 1:
            one_cnt_list[c_mat[i][j] - 1] += 1
        elif ((i+1)+(j+1)) % 3 == 2:
            two_cnt_list[c_mat[i][j] - 1] += 1

cost_list = []
for i in range(c):
    zero_cost = sum(np.array(zero_cnt_list) * np.array([d_mat[l][i] for l in range(c)]))
    for j in range(c):
        if j == i:
            continue
        one_cost = sum(np.array(one_cnt_list) * np.array([d_mat[l][j] for l in range(c)]))
        for k in range(c):
            if k == i or k == j:
                continue
            two_cost = sum(np.array(two_cnt_list) * np.array([d_mat[l][k] for l in range(c)]))
            cost_list.append(zero_cost + one_cost + two_cost)
print(cost_list)
print(min(cost_list))

