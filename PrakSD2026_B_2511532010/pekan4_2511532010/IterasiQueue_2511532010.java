package pekan4_2511532010;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

public class IterasiQueue_2511532010 {

	public static void main(String[] args) {
		Queue<String> q_2010 = new LinkedList<>();
		q_2010.add("Praktikum");
		q_2010.add("Struktur");
		q_2010.add("Data");
		q_2010.add("Dan");
		q_2010.add("Algoritma");
		Iterator <String> iterator_2010 = q_2010.iterator ();
		while (iterator_2010.hasNext()) {
			System.out.print(iterator_2010.next() + " ");
		}

	}

}
