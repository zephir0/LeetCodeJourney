package TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.execute();
    }
}

class Solution {
    Scanner scanner = new Scanner(System.in);

    public void execute() {
        int[] numbers = getInput();
        int target = getTarget();
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] getInput() {
        String[] input = scanner.nextLine().split("\\s+");
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }

    public int getTarget() {
        return scanner.nextInt();
    }

    public int[] twoSum(int[] nums,
                        int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int neededValue = target - nums[i];
            if (numToIndex.containsKey(neededValue)) {
                return new int[]{numToIndex.get(neededValue), i};
            }
            numToIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
