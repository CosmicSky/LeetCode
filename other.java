/*
public int dp(arr, total, i, mem){
    key = str(total) + ':' + str(i);
    if key in mem{
        return mem[key];
    }
    if (total == 0) {
        return 1;
    } else if (total < 0 || i < 0) {
        return 0;
    } else if (total < arr[i]) {
        returned = dp(arr, total, i-1, mem);
    } else {
        returned = (dp(arr, total - arr[i], i - 1, mem) + dp(arr, total, i - 1, mem))
    }
    mem[key] = returned;
    return returned
}
*/