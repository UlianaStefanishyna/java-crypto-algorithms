package com.crypto.algorithms;

public class Mongomeri {

    public static void main(String[] args) {
        int a = 17, e = 11, m = 19;
        int n = (int) (Math.log(e) / Math.log(2) + 1);
        int r = (int) Math.pow(2, (int) (Math.log(m) / Math.log(2) + 1));
        int p = r % m;
        int j = n;
        int b = montgomery(a, (r * r) % m, m);
        do {
            p = montgomery(p, p, m);
            if ((e >> j) % 2 == 1) {
                p = montgomery(p, b, m);
            }
            j--;
        } while (j >= 0);
        p = montgomery(p, 1, m);
        System.out.println(p);
    }

    private static int montgomery(int a, int b, int m) {
        int y = 0, j = 0;
        int n = (int) (Math.log(m) / Math.log(2) + 1);
        do {
            y += ((b >> j) % 2) * a;
            if (y % 2 == 1) {
                y += m;
            }
            y = y >> 1;
            j++;
        } while (j < n);
        if (y >= m) {
            y -= m;
        }
        return y;
    }

}
