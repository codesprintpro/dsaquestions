package SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MaximumOfAllSubArrayForSizeK {
    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> nosArr = new ArrayList<>();

        int i = 0, j = 0;

        while (j < arr.length) {
            //creating copy because if we remove from same array on which we are iterating it will create IndexOutOfBoundException
            List<Integer> subArray = new ArrayList<>(nosArr);
            for (Integer integer : subArray) {
                if (integer < arr[j]) {
                    // removing element which are smaller than current element getting inserted
                    nosArr.remove(integer);
                }
            }
            nosArr.add(arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // first element will always be greater in that k block
                System.out.println(nosArr.get(0));

                // before moving i index check if the max element is same as that i index if yes remove.
                if (Objects.equals(arr[i], nosArr.get(0)))
                    nosArr.remove(0);
                i++;
                j++;
            }
        }
    }
}

