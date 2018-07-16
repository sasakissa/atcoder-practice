def split_med(cum_list, start, end):
    e = pow(10, 10)
    med_ind = 0
    for i in range(start, end):
        a = cum_list[i] - cum_list[start-1]
        b = cum_list[end] - cum_list[i]
        if abs(a - b) < e:
            e = abs(a - b)
            med_ind = i
    return med_ind

def calc_score(cum_list, left_index, med_index, right_index):
    p = cum_list[left_index]
    q = cum_list[med_index] - p
    r = cum_list[right_index] - p - q
    s = cum_list[len(cum_list)-1] - p - q - r
    return max([p, q, r, s]) - min([p, q, r, s])

n = int(input())
a_list = list(map(int, input().split()))
cum_list = [sum(a_list[:i]) for i in range(1, len(a_list)+1)]
left_index = 0
right_index = 0
scores = []
for i in range(1, len(a_list)-2):
    left_index = split_med(cum_list, left_index, i)
    right_index = split_med(cum_list, i+1, len(cum_list)-1)

    scores.append(calc_score(cum_list, left_index, i, right_index))

print(min(scores))