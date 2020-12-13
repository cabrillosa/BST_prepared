public class BSTree {
    Node root;

    public void add(int data) {
        root = addRecursive(root, data);
    }

    public Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }
        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) {
                return current.left;
            } else if (current.left == null) {
                return current.right;
            } else {
                int smallestValue = findSmallestValue(current.right);
                current.data = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }

        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public boolean searchBST(int value) {
        return containsNodeRecursive(root, value);
    }

    public void display() {
        displayInorderRecursive(root);
    }

    public void displayInorderRecursive(Node n) {
        if (n != null) {
            displayInorderRecursive(n.left);
            System.out.println(n.data);
            displayInorderRecursive(n.right);
        }
    }
}
