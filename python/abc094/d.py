import sys

if __name__ == '__main__':
    n = int(input())
    a = list(map(int, input().split()))
    a_sorted = sorted(a)
    distance = sys.maxsize
    r = -1
    for i in a:
        if abs(i - a_sorted[n-1]/2) <= distance:
            distance = abs(i - a_sorted[n-1]/2)
            r = i
    print(str(a_sorted[n-1]) + ' ' + str(r))

