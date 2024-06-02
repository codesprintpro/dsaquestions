package SlidingWindow;

public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int reqSum = 5;
        int maxK = 0;
        int curSum = 0;

        int i = 0, j = 0;
        while (j < arr.length) {
            curSum += arr[j];//keep adding the element
            j++;
            //check if we meet the required sum condition
            if (curSum == reqSum) {
                //if we match then j-i will give that window size, check if its more then the previous max window size
                maxK = Math.max(maxK, j - i);
            } else if (curSum > reqSum) {
                //if we hit sum more then required sum remove increase the i index and remove its sum from the curSum variable.
                curSum = curSum - arr[i];
                i++;
            }
        }
        System.out.println(maxK);
    }
}

