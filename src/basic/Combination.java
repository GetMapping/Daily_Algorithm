package basic;

/*
 * 조합
 * 서로 다른 n개에서 순서 없이 r개를 뽑는 경우의 수
 * ex) [1, 2]와 [2, 1]은 같다.
 * */
public class Combination {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // int n = 5;
        int r = 2;

        combin(arr, new boolean[arr.length], 0, 0, r);
    }

    private static void combin(int[] arr, boolean[] visited, int start, int dept, int r) {
        if (dept == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combin(arr, visited, i + 1, dept + 1, r);
                visited[i] = false;
            }
        }
    }
}
