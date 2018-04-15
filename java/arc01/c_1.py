perm = []

def make_perm(n, m = 0):
    if n == m:
        # 順列の生成終了
    else:
        for i in range(1, n + 1):
            if i in perm:
                continue
            perm.append(i)
            make_perm(n, m+1)
            perm.pop()

def check(n):
    for y in range(1, n):
        if conflict()

def main():

if __name__ == '__main__':
    main()
