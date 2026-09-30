package Infosys.Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BasicTemplate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // this is when we know the lines and format
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//
//        int[] a = new int[n];
//        st = new StringTokenizer(br.readLine());          // all n numbers on one line
//        for (int i = 0; i < n; i++) System.out.println(a[i] = Integer.parseInt(st.nextToken()));
//        // numbers on separate lines: a[i] = Integer.parseInt(br.readLine().trim());
//
//        StringBuilder out = new StringBuilder();
//
//        out.append("silu").append('\n');
//        System.out.print(out);

        int[] a = new int[Integer.parseInt(next(br))];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(next(br));
        }
        System.out.println(Arrays.toString(a));
    }

    static StringTokenizer tk;

    // this is the most robust method when we don't know the line and structure
    static String next(BufferedReader br) throws IOException {
        while (tk == null || !tk.hasMoreTokens()) tk = new StringTokenizer(br.readLine());
        return tk.nextToken();
    }
}
