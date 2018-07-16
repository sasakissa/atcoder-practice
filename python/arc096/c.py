a, b, c, x, y = map(int, input().split())

_1 = a*x + b*y
if x >= y:
    _2 = 2*y*c + (x - y)*a
    _3 = 2*x*c
else:
    _2 = 2*x*c + (y - x)*b
    _3 = 2*y*c
print(min(min(_1, _2), _3))
