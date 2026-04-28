package pekan4_2511532010;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList_2511532010 {

	public static void main(String[] args) {
		Queue<Integer> q_2010 = new LinkedList<>();
		for (int i =0; i<6; i++) {
			q_2010.add(i);}
		
		System.out.println ("Elemen Antrian " + q_2010);
		int hapus_2010 = q_2010.remove ();
		System.out.println ("Hapus elemen =  "+ hapus_2010);
		System.out.println (q_2010);
		int depan = q_2010.peek();
		System.out.println ("kepala antrian = " + depan);
		
		int banyak = q_2010.size();
		
		System.out.println ("Size Antrian = " + banyak);
	}

}
