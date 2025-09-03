class Solution {
    static boolean match(String wild, String pattern) {
        int i = 0, j = 0;               // pointers for wild and pattern
        int starIdx = -1, match = 0;    // last position of '*' in wild and matched index in pattern

        while (j < pattern.length()) {
            // Case 1: chars match or wild has '?'
            if (i < wild.length() && 
                (wild.charAt(i) == pattern.charAt(j) || wild.charAt(i) == '?')) {
                i++;
                j++;
            }
            // Case 2: wild has '*'
            else if (i < wild.length() && wild.charAt(i) == '*') {
                starIdx = i;      // record position of '*'
                match = j;        // record position in pattern
                i++;
            }
            // Case 3: mismatch, but we saw a '*', so backtrack
            else if (starIdx != -1) {
                i = starIdx + 1;  // move wild pointer right after '*'
                match++;          // expand '*' to cover one more char
                j = match;        // reset pattern pointer
            }
            // Case 4: mismatch with no '*' to backtrack
            else {
                return false;
            }
        }

        // Consume remaining '*' in wild
        while (i < wild.length() && wild.charAt(i) == '*') {
            i++;
        }

        return i == wild.length();
    }
}
