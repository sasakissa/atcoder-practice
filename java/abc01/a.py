a = float(input())/1000

if a < 0.1:
    v = 0
elif 0.1 <= a <= 5:
    v = 10*a
elif 6 <= a <= 30:
    v = a+50
elif 35 <= a <= 70:
    v = (a-30)/5+80
elif 70 < a:
    v = 89

ans = '{0:02d}'.format(int(v))
print(ans)
