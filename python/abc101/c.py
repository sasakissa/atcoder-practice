n, k = list(map(int, input().split()))
a_list = list(map(int, input().split()))


def count(num, k):
    if num == 0:
        return 0
    elif num % (k - 1) == 0:
        return num // (k - 1)
    else:
        return num // (k - 1) + 1


min_index = a_list.index(1)
res = []
for i in range(k):
    pre_end_index = max(min_index - (k-1) + i, 0)
    suf_start_index = min(min_index + i, n-1)
    pre = count(pre_end_index, k)
    suf = count(n-1-suf_start_index, k)
    res.append(pre+suf+1)

print(int(min(res)))