public class MainDriver {
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.add(20);
        bst.add(15);
        bst.add(10);
        bst.add(25);
        bst.add(5);
        bst.add(30);
        bst.add(2);
        bst.display();
        System.out.println("searching.. 10-> "+bst.searchBST(100));
        bst.delete(1);
        bst.display();
    }
}
