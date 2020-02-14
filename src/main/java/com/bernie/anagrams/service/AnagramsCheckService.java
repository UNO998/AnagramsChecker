package com.bernie.anagrams.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnagramsCheckService {
    /**
     * Valid input string only contains character: 'a'~'z' || 'A'~'Z' || ' '
     *
     * @param str1
     * @param str2
     * @return    Optional[true] when str1, str2 are valid and are anagrams to each other
     * 			  Optional[false] when str1, str2 are valid and are not anagrams to each other
     * 			  Optional.empty  when one of str1, str2 is not valid
     */
    public Optional<Boolean> checkAnagrams(String str1, String str2) {
        // 'a~z' && ' ', space saved in index 26
        final int NUM_OF_CHAR = 27;

        if (str1 == null || str2 == null) {
            return Optional.empty();
        }

        // check the valid of input string
        if (!validInput(str1) || !validInput(str2)) {
            return Optional.empty();
        }

        if (str1.length() != str2.length()) {
            return Optional.of(false);
        }

        // convert string to lowercase
        char[] strArr1 = str1.toLowerCase().toCharArray();
        char[] strArr2 = str2.toLowerCase().toCharArray();

        int[] charArr = new int[NUM_OF_CHAR];

        for (int i = 0; i < strArr1.length; i++) {
            char ch1 = strArr1[i];
            char ch2 = strArr2[i];

            if (ch1 == ' ') {
                charArr[26]++;
            }

            if (ch2 == ' ') {
                charArr[26]--;
            }
            if (ch1 != ' ') {
                charArr[ch1 - 'a']++;
            }

            if (ch2 != ' ') {
                charArr[ch2 - 'a']--;
            }

        }

        for (int i = 0; i < NUM_OF_CHAR; i++) {
            if (charArr[i] != 0) return Optional.of(false);
        }

        return Optional.of(true);
    }

    // check the input string only contains 'a~z' || 'A~Z' || ' '
    private boolean validInput(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isLowerCase(ch) && !Character.isUpperCase(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }
}
