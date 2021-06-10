package lesson6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private List<E> values = new ArrayList<>();
    private final int MAX_DEPTH;

    @Override
    public boolean add(Node<E> node) {

        if (maxDepth(root) < MAX_DEPTH) {
            if (node != null && !values.contains(node.getValue())) {
                values.add(node.getValue());

                if (isEmpty()) {
                    root = node;
                    return true;
                }

                build(root, node);

                return true;
            }
        }
        return false;
    }


    private void build(Node<E> previous, Node<E> next) {

        if (previous == null) {
            previous = next;
        }

        if (previous.getValue().compareTo(next.getValue()) > 0) {
            if (previous.getLeft() != null) {
                build(previous.getLeft(), next);
            } else {
                previous.setLeft(next);
            }
        } else {
            if (previous.getRight() != null) {
                build(previous.getRight(), next);
            } else {
                previous.setRight(next);

            }
        }
    }


    private int maxDepth(Node<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
    }


    @Override
    public boolean contains(Node<E> node) {
        return find(root, node) != null;
    }


    private Node<E> find(Node<E> parent, Node<E> child) {

        if (parent == null) {
            return null;
        }

        if (parent.equals(child)) {
            return parent;
        }

        Node<E> left = find(parent.getLeft(), child);
        Node<E> right = find(parent.getRight(), child);

        return left != null ? left : right;

    }

    @Override
    public boolean remove(Node<E> node) {
        values.remove((E) node.getValue());
        root = null;
        for (E e : values) {
            if (root == null) {
                root = new Node<>(e);
                continue;
            }

            build(root, new Node<>(e));
        }
        return !contains(node);
    }


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void display() {

        System.out.println("Right " + root.getRight());
        System.out.println("-------");
        System.out.println("Left " + root.getLeft());


    }

}
