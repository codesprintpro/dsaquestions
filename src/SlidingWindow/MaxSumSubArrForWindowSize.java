package SlidingWindow;

public class MaxSumSubArrForWindowSize {
    public static void main(String[] args) {

        int[] arr = {2, 5, 2, 6, 8, 2, 1, 4, 8, 1};
        int k = 3;
        int maxSum = 0;
        int sum = 0;
        int i = 0, j = 0;

        //the array will move till the j reaches end of length
        while (j < arr.length) {
            //sum will keep adding next element
            sum = sum + arr[j];
            //this block will only execute once till we reach first k block
            if (j - i + 1 < k) {
                j++;
                continue;
            } else if (j - i + 1 == k) { // this block will hit everytime once k block count is reached the first loop
                if (maxSum < sum) {
                    maxSum = sum;
                }
                // this we need to do because we will be moving i to the right so its calculation added in sum should be removed
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        System.out.println(maxSum);
    }
}
