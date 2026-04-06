package pekan2_2511532010;
import java.util.ArrayList;
public class ArrayList_2511532010 {

	public static void main(String[] args) {
		int n=5;
		//Declaring the Arraylist with initial size n
		ArrayList<Integer> arrli = new ArrayList<Integer>(n);
		// Appending new elements at the end of the list
		for (int i=1; i<=n; i++)
			arrli.add(i);
		// Printing elements
		System.out.println(arrli);
		// Remove element at index 3
		arrli.remove(3);
		// Displaying the Arraylist
		// after deletion
		System.out.println(arrli);
		// printing elements one by one
		for (int i=0; i< arrli.size(); i++)
			System.out.print(arrli.get(i) + " ");
		
		

	}

}
