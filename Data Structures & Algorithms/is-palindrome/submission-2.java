class Solution {
    public boolean isPalindrome(String s) {
        int front = 0;
        int back = s.length() - 1;

        while (front < back) {
            while (!((s.charAt(front) >= 'a' && s.charAt(front) <= 'z')
                || (s.charAt(front) >= 'A' && s.charAt(front) <= 'Z')
                || (s.charAt(front) >= '0' && s.charAt(front) <= '9'))) {
                front++;
                if (front == back) {
                    return true;
                }
            }

            while (!((s.charAt(back) >= 'a' && s.charAt(back) <= 'z')
                || (s.charAt(back) >= 'A' && s.charAt(back) <= 'Z')
                || (s.charAt(back) >= '0' && s.charAt(back) <= '9'))) {
                back--;
                if (front == back) {
                    return true;
                }
            }

            char first = s.charAt(front);
            if (first >= 'A' && first <= 'Z') {
                first = (char) (first + 'a' - 'A');
            }

            char second = s.charAt(back);
            if (second >= 'A' && second <= 'Z') {
                second = (char) (second + 'a' - 'A');
            }
            if (first != second) {
                return false;
            }

            front++;
            back--;
        }

        return true;
    }
}
