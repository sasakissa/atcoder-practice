if __name__ == '__main__':
    A, B, X = map(int, input().split())
    if A > X or A + B < X:
        print('NO')
    else:
        print('YES')
