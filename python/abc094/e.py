# todo

# 列の入れ替えのみで点対称にできるか
def is_enable_by_shifting_rows(H, W, S):
    check_list = [False for i in range(W)]
    middle = len(W) % 2 == 0
    for i in range(W):
        if check_list[i]:
            continue
        is_paird = False
        a = [S[k][i] for k in range(H)]
        for j in range(j+1, W):
            if check_list[j]:
                continue
            b = [S[k][j] for k in range(H)]
            if is_eqaual_list(a, b[::-1]):
                check_list[i] = True
                check_list[j] = True
                is_paird = True
                break
        if not is_paird and not middle and is_symmetric_list(a):
            check_list[i] = True
            middle = True
        else:
            return False
    return True

def is_eqaual_list(a, b):
    for i in range(len(a)):
        if a[i] != b[i]:
            return False
    return True

def is_symmetric_list(a):
    for i in range(len(a)//2):
        if a[i] != a[len(a)-i-1]:
            return False
    return True

# 行の入れ替えパターンを生成


if __name__ == '__main__':
    H, W = map(int, input().split())
    S = [(map(int, input().split())) for i in range(H)]


