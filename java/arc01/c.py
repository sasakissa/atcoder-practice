import copy

def update_candidate(row, col, _arr):
    for j in range(8):
        # 横列
        if _arr[row][j] != 1:
            _arr[row][j] = 2

        # 縦列
        if _arr[j][col] != 1:
            _arr[j][col] = 2


     # 斜め列
    for j in range(8):
        for k in range(8):
            if  abs(row - j) == abs(col - k) and _arr[j][k] != 1:
                _arr[j][k] = 2
     # クイーン
    _arr[row][col] = 1
    return _arr

def validate_queen_pos(row, col, _arr):
    return _arr[row][col] == 0

def check_finished(_arr):
    count = 0
    for i in range(8):
        for j in range(8):
            if(_arr[i][j] == 1):
                count += 1
    if count == 8:
        return True
    else:
        return False

def check_init(arr):
    for row in range(8):
        for col in range(8):
            if arr[row][col] == 1:
                if arr[row].count(1) > 1 or [ row[col] for row in arr ].count(1) > 1:
                    return False
                for k in range(8):
                    for l in range(8):
                        if abs(row - k) == abs(col - l) and row != k and arr[k][l] == 1:
                            return False
    return True

def calc(_arr):
    if check_finished(_arr):
        return _arr

    for i in range(8):
        for j in range(8):
            if validate_queen_pos(i, j, copy.deepcopy(_arr)):
                updated_arr = update_candidate(i, j, copy.deepcopy(_arr))
                res = calc(updated_arr)
                if res is None :
                    continue
                else:
                    return res
    return None

def process_ans(_arr):
    ans = ""
    for i in range(8):
        for j in range(8):
            if _arr[i][j] == 1 :
                ans+='Q'
            else:
                ans+='.'
        ans+='\n'
    return ans

def main():
    arr = [ [0 for i in range(8)] for j in range(8)]
    ans = "No Answer"
    # 初期状態の読み込み
    for row in range(8):
       input_str = input()
       col = input_str.find('Q')
       if col > 0:
           arr = update_candidate(row, col, copy.deepcopy(arr))

    if not check_init(copy.deepcopy(arr)):
        print(ans)
        return

    for i in range(8):
        for j in range(8):
            if validate_queen_pos(i, j, copy.deepcopy(arr)):
                if calc(update_candidate(i, j, copy.deepcopy(arr))) is not None:
                    ans = process_ans(calc(update_candidate(i, j, copy.deepcopy(arr))))
    print(ans)

if __name__ == '__main__':
    main()
