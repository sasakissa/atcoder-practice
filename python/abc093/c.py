A, B, C = map(int, input().split())

is_odd_list = [A % 2 == 0, B % 2 == 0, C % 2 == 0]
if all(is_odd_list) or not any(is_odd_list):
    ans = 0
else:
    if sum(is_odd_list) == 1:
        is_odd_list = [not i for i in is_odd_list]
    A = A + is_odd_list[0]
    B = B + is_odd_list[1]
    C = C + is_odd_list[2]
    ans = 1

num_list = sorted([A, B, C])
ans += (num_list[2] - num_list[0]) / 2 + (num_list[2] - num_list[1]) / 2
print(int(ans))