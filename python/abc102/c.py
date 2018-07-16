import statistics
n = int(input())
a_list = list(map(int, input().split()))

pro_list = [a_list[i-1] - i for i in range(1, n+1)]
ave = int(statistics.mean(pro_list))
med = int(statistics.median(pro_list))
b_list = [ave - 1 for i in range(10)] + [ave + i for i in range(10)]
b_list += [med - 1 for i in range(10)] + [med + i for i in range(10)]

ans = [sum([abs(pro-b)for pro in pro_list]) for b in b_list]
print(min(ans))