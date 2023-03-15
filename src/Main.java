import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //task 1 test
        int[] arr = {10, 10, 20, 30,20};
//        System.out.println(singleNumber(arr));

        //task 2 test
//        minSplit(521);

        //task 3 test
        int[] arr1 = {1, 3, 6, 4, 1, 2};
//        System.out.println(notContains(arr1));

        //task 4 test
        System.out.println(binarySum("1010","1011"));

        //task 5 test
        System.out.println(countVariants(9));

        //task 6 test
        newStructure deletableArr = new newStructure(arr1);
        deletableArr.delete(3);
        System.out.println(deletableArr);
    }

    //task 1
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
    //task 2
    public static void minSplit(int amount) {
        int[] counter = new int[5];
        int[] coins = {50, 20, 10, 5, 1};
        int index = 0;
        while (amount > 0 && index < coins.length) {
            int count = amount / coins[index];
            counter[index] = count;
            amount -= count * coins[index];
            index++;
        }
        System.out.println("Min coins:");
        for (int i = 0; i < coins.length; i++) {
            if (counter[i] > 0) {
                System.out.println(coins[i]+": "+ counter[i]);
            }
        }
    }

    //task 3
    public static int notContains(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                set.add(arr[i]);
            }
        }
        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }

    //task 4
    public static String binarySum(String a, String b) {
        int numA = Integer.parseInt(a, 2);
        int numB = Integer.parseInt(b, 2);
        int sum = numA + numB;
        return Integer.toBinaryString(sum);
    }

    //task 5
    public static int countVariants(int stairCount) {
        if (stairCount == 0 || stairCount == 1) {
            return 1;
        }
        return countVariants(stairCount - 1) + countVariants(stairCount - 2);
    }

    //task 6
    public static class newStructure {
        @Override
        public String toString() {
            return "newStructure{" +
                    "arr=" + Arrays.toString(arr) +
                    '}';
        }

        private int[] arr;
        private int size;

        public newStructure(int[] arr) {
            this.arr = arr;
            this.size = arr.length;
        }

        public void delete(int element) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (arr[i] == element) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return;
            }
            int lastIndex = size - 1;
            arr[index] = arr[lastIndex];
            size--;
            arr = Arrays.copyOf(arr,arr.length-1);
        }

    }

}