package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] target = bufferedReader.readLine().split("");
        String bomb = bufferedReader.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < target.length; i++) {
            sb.append(target[i]);

            if (sb.length() >= bomb.length()) {
                boolean isSame = true;

                for (int j = 0; j < bomb.length(); j++) {
                    if (sb.charAt(sb.length() - bomb.length() + j) == bomb.charAt(j)) {
                        continue;
                    } else {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
