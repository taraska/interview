package us.ivannikov.algo.strings;

public class ZigzagConversion {
    public static void main(String[] args) {
        var s = "Aaidoeswrprsnmeoohreunefnttacneedhsmwynihrietowtgnrlloacsoajsmnsoucutoadodiiesplnrmiaodhaeubrrtesqecouishtabrateaeaietedrciniheeaalwnefrdutettpntainnwrdvdr.";
        var numRows = 2;
        String convert = new ZigzagConversion().convert(s, numRows);
        System.out.println(convert);
    }

    public String convert(String s, int numRows) {
        //string
        //rows
        int length = s.length();
        int x = 0;
        int y = 0;
        int z = 0;
        boolean down = true;
        char[][] matrix = new char[numRows][length];
        while (x < length) {
            char ch = s.charAt(x);

            if (numRows == 1) {
                y = 0;
                matrix[y][x] = ch;
                x++;
                continue;
            }

            if (y == numRows) {
                down = false;
                y--;
            }
            if (y < 1) {
                down = true;
                y = 0;
            }
            if (down) {
                if (Character.isLetterOrDigit(matrix[y][z])) {
                    y++;
                }
                matrix[y][z] = ch;
                y++;
            }
            if (!down) {
                z++;
                y--;
                matrix[y][z] = ch;
            }
            x++;
        }

        String finalString = "";
        for (int nn = 0; nn < numRows; nn++) {
            for (int nnn = 0; nnn < length; nnn++) {
                if (Character.isLetterOrDigit(matrix[nn][nnn])) {
                    finalString += matrix[nn][nnn];
                }
            }
        }

        return finalString;

    }
}
