package pekan3_2511532010;
import java.util.Stack;
public class latihanStack_2511532010 {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer> ();
		s.push(42);
		s.push(-3);
		s.push(17);
		
		System.out.println("Nilai statck =  " + s);
		System.out.println("Nilai pop = " + s.pop());
		System.out.println("Nilai stack setelah pop = " + s);
		System.out.println ("nilai peek" +s.peek());
		System.out.println("Nilai stack setelah peek" +s);}

}
