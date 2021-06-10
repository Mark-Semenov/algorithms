package lesson6;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    public static double balanced;

    public static void main(String[] args) {

        List<TreeImpl<Integer>> trees = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            trees.add(new TreeImpl<>(6));
        }

        for (TreeImpl<Integer> tree : trees) {
            for (int i = 0; i < 300; i++) {
                tree.add(new Node<>((int) (Math.random() * 200 - 100)));
            }
        }

        for (TreeImpl<Integer> tree : trees) {
            tree.display();
            if (isBalanced(tree.getRoot())) {
                balanced++;
            }
            System.out.println("Дерево сбалансировано: " + isBalanced(tree.getRoot()));
        }
        System.out.println("% сбалансированных деревьев: " + balanced / 20 * 100);

    }

    public static boolean isBalanced(Node<Integer> node) {
        return (node == null) ||
                isBalanced(node.getLeft()) &&
                        isBalanced(node.getRight()) &&
                        Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1;
    }

    private static int height(Node<Integer> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
}
