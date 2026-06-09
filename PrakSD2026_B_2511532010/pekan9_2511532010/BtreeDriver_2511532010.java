package pekan9_2511532010;

public class BtreeDriver_2511532010 {
	public static void main (String[] args) {
		// Membuat Pohon
		BTree_2511532010 tree = new BTree_2511532010();
		System.out.print("Jumlah Simpul awal pohon: ");
		// PERBAIKAN: Ganti null menjadi tree.getRoot()
		System.out.println(tree.countNodes(tree.getRoot()));
		
		//Menambahkan simpul data 1
		Node_2511532010 root = new Node_2511532010 (1);
		// Menjadikan simpul 1 sebagai root
		tree.setRoot (root);
		System.out.println("Jumlah simpul jika hanya ada root");
		// PERBAIKAN: Ganti null menjadi tree.getRoot()
		System.out.println(tree.countNodes(tree.getRoot()));
		
		Node_2511532010 node2 = new Node_2511532010 (2);
		Node_2511532010 node3 = new Node_2511532010 (3);
		Node_2511532010 node4 = new Node_2511532010 (4);
		Node_2511532010 node5 = new Node_2511532010 (5);
		Node_2511532010 node6 = new Node_2511532010 (6);
		Node_2511532010 node7 = new Node_2511532010 (7);
		Node_2511532010 node8 = new Node_2511532010 (8);
		Node_2511532010 node9 = new Node_2511532010 (9);
		
		root.setLeft(node2);
		node2.setLeft(node4);
		node2.setRight(node5);
		node4.setRight(node8);
		root.setRight(node3);
		node3.setLeft(node6);
		node3.setRight(node7);
		node6.setLeft(node9);
		
		//Set root
		tree.setCurrent(tree.getRoot());
		System.out.println("menampilkan simpul terakhir: ");
		System.out.println(tree.getCurrent().getData());
		
		System.out.println("Jumlah simpul setelah semua simpul ditambahkan: ");
		// PERBAIKAN: Ganti null menjadi tree.getRoot()
		System.out.println(tree.countNodes(tree.getRoot()));
		
		System.out.println("InOrder: ");
		tree.printInorder();
		System.out.println("\nPreorder: ");
		tree.printPreOrder();
		System.out.println("\nPostorder: ");
		tree.printPostOrder();
		System.out.println("\nMenampilkan simpul dalam bentuk pohon");
		tree.print();
	}
}