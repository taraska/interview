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
}
