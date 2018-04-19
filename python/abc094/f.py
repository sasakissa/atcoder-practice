import copy

def dfs(tree, route=[0]):
    current = route[-1]
    if len(tree[current]) == 0:
        return route
    deepest_route = []
    for next in tree[current]:
        _tree = copy.deepcopy(tree)
        _tree[current].remove(next)
        _tree[next].remove(current)
        _route = copy.deepcopy(route)
        _route.append(next)
        tmp_route = dfs(_tree, _route)
        if len(tmp_route) > len(deepest_route):
            deepest_route = tmp_route
    return tmp_route

if __name__ == '__main__':
    n = int(input())
    tree = [[] for i in range(n)]
    for i in range(n-1):
        v, w = map(int, input().split())
        tree[v-1].append(w-1)
        tree[w-1].append(v-1)
    tmp_route = dfs(tree)
    body = dfs(tree, [tmp_route[-1]])

    is_enable = True
    for i in range(n):
        if i not in body and not any(j in body for j in tree[i]):
            is_enable = False
            break
    print(is_enable)

# todo: 枝を数えて順列に直す



