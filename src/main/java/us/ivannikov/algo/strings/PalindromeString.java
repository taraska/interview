package us.ivannikov.algo.strings;


public class PalindromeString {

    public static void main(String[] args) {
        String str = "abc";
        String strOne = "aaa";

        PalindromeString palindromeString = new PalindromeString();
        int numberOfPalindromes = palindromeString.getNumberOfPalindromes(str);
        System.out.println("abc: " + numberOfPalindromes); //3

        int numberOfPalindromes1 = palindromeString.getNumberOfPalindromes(strOne);
        System.out.println("aaa: " + numberOfPalindromes1); //a a a aa aa aaa

        int x = palindromeString.countPalindrome(strOne);
        System.out.println(x); //6

        int y = palindromeString.countPalindrome(str);
        System.out.println(y); //3
    }


    public int getNumberOfPalindromes(String s) {

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num += foo(s, i, i);
            num += foo(s, i, i + 1);
        }

        return num;
    }

    //aaa 0 2
    public int foo(String str, int left, int right) {
        int num = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
            num++;
        }
        return num;
    }

    public int countPalindrome(String string) {
        int count = 0;

        for (int n = 0; n < string.length(); n++) {
            count += foo1(string, n, n);
            count += foo1(string, n + 1, n);
        }

        return count;
    }

    public int foo1(String string, int left, int right) {
        int count = 0;
        while (right >= 0 &&
            left < string.length() &&
            string.charAt(left) == string.charAt(right)) {

            count++;
            left++;
            right--;
        }

        return count;
    }
}
