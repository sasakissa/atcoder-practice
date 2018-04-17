# todo: TLE
if __name__ == '__main__':
    N = int(input())
    X = list(map(int, input().split()))
    x = sorted(X[:])
    min_median = x[int(N/2-1)]
    max_median = x[int(N/2)]
    for i in range(N):
        if X[i] <= min_median:
            print(max_median)
        else:
            print(min_median)
