import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    public Node(int item) {
        data = item;
        left = right = null;
    }

}

public class Preorder {

    static Node root;

    static void Preorders(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        s.push(root);

        while (!s.isEmpty()) {

            Node myNode = s.peek();

            System.out.print(myNode.data + " ");
            s.pop();

            if (myNode.right != null) {
                s.push(myNode.right);
            }
            if (myNode.left != null) {
                s.push(myNode.left);
            }
        }
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        Stack<Node> s1 = new Stack<Node>();

        Node curr = root;

        while (curr != null || s1.size() > 0) {

            while (curr != null) {
                s1.push(curr);
                curr = curr.left;
            }

            curr = s1.pop();

            System.out.print(curr.data + " ");

            curr = curr.right;

        }
    }

    static void Postorder(Node root) {

        if (root == null)
            return;

        Stack<Node> s2 = new Stack<Node>();

        s2.push(root);

        Stack<Integer> out = new Stack();

        while (!s2.isEmpty()) {
            Node curr = s2.pop();
            out.push(curr.data);

            if (curr.left != null) {
                s2.push(curr.left);
            }
            if (curr.right != null) {
                s2.push(curr.right);
            }
        }
        while (!out.isEmpty()) {
            System.out.print(out.pop() + " ");
        }

    }

    static boolean isBST(Node root) {
        return BST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean BST(Node root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data > max)
            return false;

        return BST(root.left, min, root.data) && BST(root.right, root.data, max);

    }

    static int countleft(Node root) {
        int count = 0;
        if (root == null)
            return 0;

        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    static int countright(Node root) {
        int count = 0;
        if (root == null)
            return 0;

        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    static int countNodes(Node root) {

        if (root == null)
            return 0;

        int lh = countleft(root.left);
        int rh = countright(root.right);
        int rh1 = countright(root.left);

        if (lh == rh) {
            return (1 << lh + 1) - 1;
        } else {
            if (lh == rh1) {
                return 1 + countNodes(root.left) + (1 << lh + 1) - 1;
            } else {
                return 1 + countNodes(root.right) + (1 << rh + 1) - 1;
            }

        }

    }

    public static void main(String[] args) {

        root = new Node(1);
        Preorder.root.left = new Node(2);
        Preorder.root.right = new Node(3);
        Preorder.root.left.left = new Node(4);
        Preorder.root.left.right = new Node(5);
        System.out.println("Preorder");
        Preorder.Preorders(root);
        System.out.println();
        System.out.println("Inorder");
        Preorder.inorder(root);
        System.out.println();
        System.out.println("Postorder");
        Preorder.Postorder(root);
        System.out.println();
        System.out.println("Is it a BST or Not");

        System.out.println(Preorder.isBST(root));

        System.out.println(Preorder.countNodes(root));

    }
}