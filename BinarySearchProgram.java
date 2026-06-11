import java.util.*;

public class CharRhombus {

    static String line(int k) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < k; i++) s.append((char) ('A' + i)); // up
        for (int i = k - 2; i >= 0; i--) s.append((char) ('A' + i)); // down
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number (1..26): ");
        int n = sc.nextInt();
        if (n < 1) n = 1;
        if (n > 26) n = 26;

        for (int i = 1; i <= n; i++) System.out.println(line(i));
        for (int i = n - 1; i >= 1; i--) System.out.println(line(i));
    }
}
