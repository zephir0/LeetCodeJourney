package LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.execute();
    }
}

class Solution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = lengthOfLongestSubstring(input);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String input) {
        if (input == null || input.isEmpty()) return 0;

        int maxLength = 0;
        int counter = 0;
        Set<Character> uniqueCharacters = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            while (uniqueCharacters.contains(currentChar)) {
                uniqueCharacters.remove(input.charAt(counter));
                counter++;
            }
            uniqueCharacters.add(currentChar);
            maxLength = Math.max(maxLength, i - counter + 1);
        }
        return maxLength;
    }

}

