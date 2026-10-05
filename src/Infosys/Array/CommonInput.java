package Infosys.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CommonInput {

    public static StringTokenizer tk ;

    public static String next(BufferedReader br)  throws IOException {

        while (tk == null || !tk.hasMoreTokens()) {
            tk = new StringTokenizer(br.readLine());
        }
        return tk.nextToken();
    }
}
