if __name__ == '__main__':
    N, M, X = map(int, input().split())
    A = map(int, input().split())
    cost_map = {}
    for i in A:
        cost_map[i] = 1
    cost_to_0 = [0 for i in range(N+1)]
    cost_to_N = [0 for i in range(N+1)]
    for i in range(1, N+1):
        if i in cost_map:
            cost_to_0[i] = cost_to_0[i-1] + 1
        else:
            cost_to_0[i] = cost_to_0[i-1]

    for i in range(0, N)[::-1]:
        if i in cost_map:
            cost_to_N[i] = cost_to_N[i+1] + 1
        else:
            cost_to_N[i] = cost_to_N[i+1]
    print(min(cost_to_0[X], cost_to_N[X]))
