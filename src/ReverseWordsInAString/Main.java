package ReverseWordsInAString;

import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println(reverseWords(input));
    }

    public String reverseWords(String input) {
        input = input.trim();
        String[] words = input.split("\\s+");

        int i = 0, j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", words);
    }
}
