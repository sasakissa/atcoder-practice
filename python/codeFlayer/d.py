h, w = list(map(int, input().split()))
n, m = list(map(int, input().split()))
hanko = [input() for i in range(m)]

comp_h = h
comp_w = w
if h > n * 2:
    comp_h = n * 2 + 1
if w > m * 2:
    comp_w = m * 2 + 1

move_x = comp_w - m
move_y = comp_h - n

mp = [[0 for _ in range(comp_w)] for _ in range(comp_h)]

for y in range(n):
    for x in range(m):
        if hanko[y][x] == "#":
            mp[y][x] += 1
            tx, ty = x + move_x + 1, y + move_y + 1
            if ty < comp_h:
                mp[ty][x] -= 1
            if tx < comp_w:
                mp[y][tx] -= 1
            if ty < comp_h and tx < comp_w:
                mp[ty][tx] += 1

    # def printmp():
    #  for line in mp:
    #    print(line)
    #  print()

for y in range(comp_h):
    mpy = mp[y]
    for x in range(comp_w - 1):
        mpy[x + 1] += mpy[x]

for y in range(comp_h - 1):
    mpy = mp[y]
    mpy1 = mp[y + 1]
    for x in range(comp_w):
        mpy1[x] += mpy[x]

ans = 0
if w <= m * 2 and h <= n * 2:
    for y in range(comp_h):
        mpy = mp[y]
        for x in range(comp_w):
            ans += (mpy[x] > 0)

elif w > m * 2 and h <= n * 2:
    for y in range(comp_h):
        mpy = mp[y]
        for x in range(comp_w):
            rate = 1
            if x == m:
                rate *= (w - m * 2)
            ans += (mpy[x] > 0) * rate

elif w <= m * 2 and h > n * 2:
    for y in range(comp_h):
        mpy = mp[y]
        for x in range(comp_w):
            rate = 1
            if y == n:
                rate *= (h - n * 2)
            ans += (mpy[x] > 0) * rate

elif w > m * 2 and h > n * 2:
    for y in range(comp_h):
        mpy = mp[y]
        for x in range(comp_w):
            rate = 1
            if x == m:
                rate *= (w - m * 2)
            if y == n:
                rate *= (h - n * 2)
            ans += (mpy[x] > 0) * rate

print(ans)