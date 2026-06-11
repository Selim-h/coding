public class UniqueFiveDigit {

    public static void main(String[] args) {
        int count = 0;
        for (int a = 1; a <= 5; a++) for (int b = 1; b <= 5; b++) if (
            b != a
        ) for (int c = 1; c <= 5; c++) if (c != a && c != b) for (
            int d = 1;
            d <= 5;
            d++
        ) if (d != a && d != b && d != c) for (int e = 1; e <= 5; e++) if (
            e != a && e != b && e != c && e != d
        ) {
            System.out.println("" + a + b + c + d + e);
            count++;
        }
        System.out.println("Total unique numbers: " + count); // should be 120
    }
}
