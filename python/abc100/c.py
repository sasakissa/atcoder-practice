n = int(input())
a_list = list(map(int, input().split()))


def count(num):
    _num = num
    count = 0
    while _num / 2 >= 1 and _num % 2 == 0:
        _num = _num // 2
        count += 1
    return count


cnt_list = [count(a) for a in a_list]
cnt = sum(cnt_list)

print(cnt)