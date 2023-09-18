package TwoOutofThree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.execute();
    }
}

class Solution {
    public void execute() {
        int[] nums1 = readInput();
        int[] nums2 = readInput();
        int[] nums3 = readInput();

        List<Integer> result = twoOutOfThree(nums1, nums2, nums3);
        System.out.println(result);
    }

    private int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public List<Integer> twoOutOfThree(int[] nums1,
                                       int[] nums2,
                                       int[] nums3) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> seen1 = new HashSet<>();
        Set<Integer> seen2 = new HashSet<>();

        for (int num : nums1) {
            seen1.add(num);
        }
        for (int num : nums2) {
            if (seen1.contains(num)) result.add(num);
            seen2.add(num);
        }
        for (int num : nums3) {
            if (seen1.contains(num) || seen2.contains(num)) result.add(num);
        }
        return new ArrayList<>(result);
    }
}
