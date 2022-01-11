package cn.shijianka.array;

public class Arrays {

    private Arrays() {
    }
    /**
     * 判断int数组是否有序(无序返回false，升、降、不变返回true),
     */
    public static boolean isOrderly(int[] arr) {
        if (arr.length < 3) {
            return true;
        }
        int temp = arr[0] - arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            if (temp == 0) {
                if (arr[i - 1] - arr[i] != 0) {
                    return false;
                }
            } else {
                if (Math.abs(temp) == temp) {
                    if (arr[i - 1] - arr[i] < 0) {
                        return false;
                    }
                } else {
                    if (arr[i - 1] - arr[i] > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
