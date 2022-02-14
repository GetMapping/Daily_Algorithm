package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BOJ_1991 {

    private static List<String> preorderAnswer;   // 전위 순회
    private static List<String> inorderAnswer;    // 중위 순회
    private static List<String> postorderAnswer;  // 후위 순회
    private static HashMap<String, Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nodeQuantity = Integer.parseInt(bufferedReader.readLine());

        nodes = new HashMap<>();

        for (int i = 0; i < nodeQuantity; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            if (input[1].equals(".")) {
                input[1] = null;
            }
            if (input[2].equals(".")) {
                input[2] = null;
            }

            nodes.put(input[0], new Node(input[0], input[1], input[2]));
        }

        preorderAnswer = new ArrayList<>();
        inorderAnswer = new ArrayList<>();
        postorderAnswer = new ArrayList<>();

        preOrder("A");
        inOrder("A");
        postOrder("A");

        System.out.println(String.join("", preorderAnswer));
        System.out.println(String.join("", inorderAnswer));
        System.out.println(String.join("", postorderAnswer));

    }

    public static void preOrder(String target) { // PLR
        Node node = nodes.get(target);

        preorderAnswer.add(target);

        if (node.left != null && !preorderAnswer.contains(node.left)) {
            preOrder(node.left);
        }

        if (node.right != null && !preorderAnswer.contains(node.right)) {
            preOrder(node.right);
        }
    }

    public static void inOrder(String target) { // LPR
        Node node = nodes.get(target);

        if (node.left != null && !inorderAnswer.contains(node.left)) {
            inOrder(node.left);
        }

        inorderAnswer.add(target);

        if (node.right != null && !inorderAnswer.contains(node.right)) {
            inOrder(node.right);
        }
    }

    public static void postOrder(String target) { // LRP
        Node node = nodes.get(target);

        if (node.left == null && node.right == null) {
            postorderAnswer.add(target);
            return;
        }

        if (node.left != null && !postorderAnswer.contains(node.left)) {
            postOrder(node.left);
        }

        if (node.right != null && !postorderAnswer.contains(node.right)) {
            postOrder(node.right);
        }

        postorderAnswer.add(target);
    }

    static class Node {

        String name;
        String left;
        String right;

        public Node(String name, String left, String right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }
}
