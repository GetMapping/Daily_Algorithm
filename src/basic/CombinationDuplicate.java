package basic;

/*
 * 중복 조합
 * 서로 다른 n개에서 순서 없이, 중복 가능하게 r개를 뽑는 경우의 수.(중복을 허용한다)
 * ex) [1, 1], [2, 2]와 같이 중복 허용
 * */
public class CombinationDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // int n = 5;
        int r = 2;

        combin(arr, new int[r], 0, 0, r);
    }

    private static void combin(int[] arr, int[] answer, int start, int dept, int r) {
        if (dept == r) {
            for (int number : answer) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            answer[dept] = arr[i];
            combin(arr, answer, i, dept + 1, r);
        }
    }
}
