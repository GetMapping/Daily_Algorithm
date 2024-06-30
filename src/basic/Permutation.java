package basic;

/*
 * 순열
 * 서로 다른 n개에서 r개를 뽑아서 정렬하는 경우의 수
 * ex) [1, 2]와 [2, 1]은 다르다.
 * */
public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // int n = 5;
        int r = 2;

        permute(arr, new int[r], new boolean[5], 0, r);
    }

    private static void permute(int[] arr, int[] answer, boolean[] visited, int depth, int r) {
        if (depth == r) {
            for (int number : answer) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                permute(arr, answer, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
