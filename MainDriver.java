public class MainDriver {
    public static void main(String[] args) {
        // instantiate binary search tree
        BSTree bst = new BSTree();
        bst.add(10);
        bst.add(6);
        bst.add(20);
        bst.add(4);
        bst.add(8);
        bst.add(15);
        bst.add(21);
        bst.add(15);
        bst.add(21);
        bst.add(11);
        bst.add(15);
        bst.add(22);
        bst.add(14);
        bst.add(17);
        System.out.println("Displaying In-order:");
        bst.displayInorder();
        System.out.println("Displaying Pre-order:");
        bst.displayPreorder();
        System.out.println("Displaying Post-order:");
        bst.displayPostorder();
        System.out.println("searching.. 11-> " + bst.searchBST(4));
        System.out.println("Deleting 20");
        bst.delete(20);
        System.out.println("Displaying In-order:");
        bst.displayInorder();
        System.out.println("Displaying Pre-order:");
        bst.displayPreorder();
        System.out.println("Displaying Post-order:");
        bst.displayPostorder();
    }
}
