package pekan5_2511532010;
import java.util.*;
public class PencarianSLL_2511532010 {
static boolean searchKey(NodeSLL_2511532010 head_2010, int key_2010) {
	NodeSLL_2511532010 curr_2010 = head_2010;
	while (curr_2010 != null) {
		if (curr_2010.data_2010 == key_2010)
			return true;
		curr_2010 = curr_2010.next_2010;
	}
	return false;
}
public static void traversal (NodeSLL_2511532010 head_2010) {
	NodeSLL_2511532010 curr_2010 = head_2010;
	while (curr_2010!=null) {
		System.out.print (" " + curr_2010.data_2010);
		curr_2010 = curr_2010.next_2010;}
		System.out.println();}
public static void main(String[] args) {
    NodeSLL_2511532010 head = new NodeSLL_2511532010(14);
    head.next_2010 = new NodeSLL_2511532010(21);
    head.next_2010.next_2010 = new NodeSLL_2511532010(13);
    head.next_2010.next_2010.next_2010 = new NodeSLL_2511532010(30);
    head.next_2010.next_2010.next_2010.next_2010 = new NodeSLL_2511532010(10);
    System.out.print("Penelusuran SLL: ");
    traversal(head); 
    int key = 30;
    System.out.print("Cari data " + key + " = ");
    
    if (searchKey(head, key)) {
        System.out.println("ketemu");
    } else {
        System.out.println("tidak ada");
    }
}
	

	
}
