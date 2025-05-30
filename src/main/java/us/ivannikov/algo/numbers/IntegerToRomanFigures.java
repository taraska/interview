package us.ivannikov.algo.numbers;

import java.util.HashMap;

class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");


        String strNum = num + "";
        int len = strNum.length();
        String result = "";
        for (int n = 0; n < len; n++) {
            //which length is now
            int nn = Integer.valueOf(strNum.charAt(n) + "");
            int level = len - n;
            if (level >= 4) {
                //what if 30
                for (int b = 0; b < nn; b++) {
                    result = result + "M";
                }
                continue;

            }

            if (level == 3) {
                if (nn == 4) {
                    result = result + "CD";
                    continue;
                }
                if (nn == 9) {
                    result = result + "CM";
                    continue;
                }
                if (nn >= 5) {
                    result = result + "D";
                    int bbb = nn - 5;
                    for (int i = 0; i < bbb; i++) {
                        result = result + "C";
                    }
                } else {
                    for (int i = 0; i < nn; i++) {
                        result = result + "C";
                    }
                }
            }

            if (level == 2) {
                if (nn == 4) {
                    result = result + "XL";
                    continue;
                }
                if (nn == 9) {
                    result = result + "XC";
                    continue;
                }
                if (nn >= 5) {
                    result = result + "L";
                    int bbb = nn - 5;
                    for (int i = 0; i < bbb; i++) {
                        result = result + "X";
                    }
                } else {
                    for (int i = 0; i < nn; i++) {
                        result = result + "X";
                    }
                }
            }

            if (level == 1) {
                if (nn == 4) {
                    result = result + "IV";
                    continue;
                }
                if (nn == 9) {
                    result = result + "IX";
                    continue;
                }
                if (nn >= 5) {
                    result = result + "V";
                    int bbb = nn - 5;
                    for (int i = 0; i < bbb; i++) {
                        result = result + "I";
                    }
                } else {
                    for (int i = 0; i < nn; i++) {
                        result = result + "I";
                    }
                }
            }
        }

        return result;
    }
}

public class IntegerToRomanFigures {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.intToRoman(3749);
        System.out.println(s); //MMMDCCXLIX
    }
}
