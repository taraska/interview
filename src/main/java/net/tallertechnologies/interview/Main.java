package net.tallertechnologies.interview;

public class Main {
    public static void main(String[] args) {

        /*
        Find the n’th term in Look-and-say (Or Count and Say) Sequence. The look-and-say sequence is the sequence of the below integers:
        1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, …

        The first term is "1"
        Second term is "11", generated by reading first term as "One 1"
        (There is one 1 in previous term)
        Third term is "21", generated by reading second term as "Two 1"
        Fourth term is "1211", generated by reading third term as "One 2 One 1"
        and so on

        How to find n’th term?
        Example:

        Input: n = 3
        Output: 21
        Input: n = 5
        Output: 111221
         *
         * */

        String foo = new Main().foo(5);
        String foo1 = new Main().foo(6);
        String foo2 = new Main().foo(10);
        System.out.println(foo); //5.  - 111221
        System.out.println(foo1); //6  - 312211
        System.out.println(foo2); //10 - 13211311123113112211
    }

    public String foo(int n) {
        String str = "" + 1;
        for (int i = 1; i < n; i++) {
            str = generate(str);
        }
        return str;
    }

    public String generate(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;

        //first is always amount of figure
        //second is exact figure;
        for (int i = 1; i < str.length(); i++) {

            if(str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                stringBuilder.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }

        stringBuilder.append(count).append(str.charAt(str.length() -1));
        return stringBuilder.toString();
    }
}
