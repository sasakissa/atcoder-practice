n, m = list(map(int, input().split()))
p_list = list(map(int, input().split()))
x_list = []
y_list = []


def get_reachable_nodes(current, _reachable_nodes, _edge_list):
    candidate_nodes = _edge_list[current]
    if all([j in _reachable_nodes for j in candidate_nodes]):
        return _reachable_nodes

    for j in candidate_nodes:
        if j not in _reachable_nodes:
            next_reachable_nodes = _reachable_nodes.copy()
            next_reachable_nodes.append(j)
            _reachable_nodes.extend(get_reachable_nodes(j, next_reachable_nodes, _edge_list))
    return list(set(_reachable_nodes))


for i in range(m):
    x, y = list(map(int, input().split()))
    x_list.append(x)
    y_list.append(y)

edge_list = [[] for i in range(n)]
for i in range(m):
    edge_list[x_list[i] - 1].append(y_list[i] - 1)
    edge_list[y_list[i] - 1].append(x_list[i] - 1)

reachable_nodes_list = [get_reachable_nodes(i, [], edge_list) for i in range(n)]
reachable_nodes_set = []
for reachable_nodes in reachable_nodes_list:
    if reachable_nodes not in reachable_nodes_set and len(reachable_nodes) > 0:
        reachable_nodes_set.append(reachable_nodes)
reachable_nodes_list = reachable_nodes_set
# print(reachable_nodes_list)

a = 0
for reachable_nodes in reachable_nodes_list:
    for node in reachable_nodes:
        if p_list[node] - 1 in reachable_nodes:
            a += 1
# print('a = %s'%(a))
all_reachable_nodes = []
for reachable_nodes in reachable_nodes_list:
    all_reachable_nodes.extend(reachable_nodes)

unreachable_nodes = [i for i in range(n) if i not in all_reachable_nodes]

b = 0
for node in unreachable_nodes:
    if p_list[node]-1 == node:
     b += 1
# print('b = %s'%(b))
print(a+b)

