public class BSTree {
    Node root;

    /* PUBLIC API FUNCTIONS */
    public void add(int data) {
        root = addRecursive(root, data);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public boolean searchBST(int value) {
        return containsNodeRecursive(root, value);
    }

    public void displayInorder() {
        displayInorderRecursive(root);
    }

    public void displayPreorder() {
        displayPreorderRecursive(root);
    }

    public void displayPostorder() {
        displayPostorderRecursive(root);
    }

    /* PRIVATE/RECURSIVE FUNCTIONS */
    private Node createNode(int data) {
        return new Node(data);
    }

    private Node addRecursive(Node current, int data) {
        // if reached the correct spot, insert the newnode
        if (current == null) {
            return createNode(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }
        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        // value NOT found return false
        if (current == null) {
            return false;
        }
        // value is found, return true
        if (value == current.data) {
            return true;
        }
        if (value < current.data) {
            return containsNodeRecursive(current.left, value);
        } else {
            return containsNodeRecursive(current.right, value);
        }
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        // value searched is found. decide which case to implement : case 1 2 or 3?
        if (value == current.data) {
            // case 1: delete a node without a child
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.right == null) { // case2: delete a node with 1 child (either left or right child)
                return current.left;
            } else if (current.left == null) {
                return current.right;
            } else { // case 3: delete a node with two child
                //find the smallest successor
                int smallestValue = findSmallestValue(current.right);
                current.data = smallestValue;
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }

        // call itself until value to delete is found or it reached the end of leaf node
        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
            return current;
        } else {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
    }

    private void displayInorderRecursive(Node n) {
        if (n != null) {
            displayInorderRecursive(n.left);
            System.out.println(n.data);
            displayInorderRecursive(n.right);
        }
    }

    private void displayPreorderRecursive(Node n) {
        if (n != null) {
            System.out.println(n.data);
            displayPreorderRecursive(n.left);
            displayPreorderRecursive(n.right);
        }
    }

    private void displayPostorderRecursive(Node n) {
        if (n != null) {
            displayPostorderRecursive(n.left);
            displayPostorderRecursive(n.right);
            System.out.println(n.data);
        }
    }

    /* UTILITY FUNCTION */
    private int findSmallestValue(Node root) {
        if (root.left == null) {
            return root.data;
        } else {
            return findSmallestValue(root.left);
        }
    }
}
