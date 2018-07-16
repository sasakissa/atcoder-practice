A = int(input())
B = int(input())

for i in range(A, 0, -1):

    if i % B == 0:
        print(i)
        break