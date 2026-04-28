package pekan4_2511532010;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class ReverseData_2511532010 {

	public static void main(String[] args) {
		Queue<Integer> q_2010 = new LinkedList<Integer>();
		q_2010.add(1);
		q_2010.add(2);
		q_2010.add(3);
		System.out.println ("Sebelum reverse " + q_2010);
		Stack<Integer> s_2010 = new Stack<Integer>();
		while (!q_2010.isEmpty()) {
			s_2010.push(q_2010.remove());
		}
		while (!s_2010.isEmpty()) {
			q_2010.add(s_2010.pop());
		}
		
		System.out.println ("sesudah reverse = " + q_2010);

	}

}
