s = input()
k = int(input())

cand_list = []
for i in range(len(s)):
    for j in range(len(s)+1-i):
        _s = s[i:i+j+1]
        cand_list.append(_s)
        cand_list = sorted(set(cand_list))
        if len(cand_list) > k and cand_list[len(cand_list) - 1] == _s:
            cand_list.remove(_s)
            break
        elif len(cand_list) > k:
            cand_list.pop(len(cand_list) - 1)

print(sorted(cand_list)[k-1])