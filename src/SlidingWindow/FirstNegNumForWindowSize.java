package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegNumForWindowSize {
    public static void main(String[] args) {

        int[] arr = {12, -1, -7, -15, 30, 16, 28};
        int k = 3;
        List<Integer> negNum = new ArrayList<>();

        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] < 0)
                negNum.add(arr[j]); // for storing all the negative number in a k block
            //this block will only execute once till we reach first k block
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) { // this block will hit everytime once k block count is reached the first loop
                if (negNum.isEmpty())
                    System.out.println(0);
                else {
                    // if the list is not empty and we hit k block condition then first one will the first negative element in that block
                    System.out.println(negNum.get(0));
                    if (arr[i] == negNum.get(0))
                        negNum.remove(0);// as we are i to right we should remove that element from if present
                }

                j++;
                i++;
            }
        }
    }
}
