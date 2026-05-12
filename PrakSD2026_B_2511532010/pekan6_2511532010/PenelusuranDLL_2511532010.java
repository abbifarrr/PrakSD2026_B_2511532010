package pekan6_2511532010;
import java.util.*;
public class PenelusuranDLL_2511532010 {
static void forwardTransversal_2010 (NodeDLL_2511532010 head_2010) {
	NodeDLL_2511532010 curr_2010 = head_2010;
	
	while (curr_2010 != null){
		System.out.print (curr_2010.data_2010 + " <-> ");
		curr_2010 = curr_2010.next_2010;
	}
	System.out.println();
}

static void backwardTransversal_2010 (NodeDLL_2511532010 tail_2010) {
	NodeDLL_2511532010 curr_2010 = tail_2010;
	while (curr_2010!= null) {
		System.out.print (curr_2010.data_2010 + " <-> ");
		curr_2010 = curr_2010.prev_2010;
	}
	System.out.println();
}

public static void main(String[] args) {
	NodeDLL_2511532010 head_2010 = new NodeDLL_2511532010(1);
	NodeDLL_2511532010 second_2010 = new NodeDLL_2511532010(2);
	NodeDLL_2511532010 third_2010 = new NodeDLL_2511532010(3);
	
	head_2010.next_2010 = second_2010;
	second_2010.prev_2010 = head_2010;
	second_2010.next_2010 = third_2010;
	third_2010.prev_2010 = second_2010;
			
			System.out.println ("Penelusuran Maju : ");
			forwardTransversal_2010(head_2010);
			
			System.out.println ("Penelusuran Mundur :");
			backwardTransversal_2010 (third_2010);
			
}
}
