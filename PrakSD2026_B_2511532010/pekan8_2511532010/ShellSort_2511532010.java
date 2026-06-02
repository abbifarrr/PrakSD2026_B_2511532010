package pekan8_2511532010;
import java.util.*;

public class ShellSort_2511532010 {
    public static void shellsort(int[] A_2010) {
        int n_2010 = A_2010.length;
        int gap_2010 = n_2010 / 2;
        
        while (gap_2010 > 0) {
            for (int i_2010 = gap_2010; i_2010 < n_2010; i_2010++) {
                int temp_2010 = A_2010[i_2010];
                
                
                int j_2010 = i_2010; 
                
                while (j_2010 >= gap_2010 && A_2010[j_2010 - gap_2010] > temp_2010) {
                    A_2010[j_2010] = A_2010[j_2010 - gap_2010];
                    j_2010 = j_2010 - gap_2010;
                }
                A_2010[j_2010] = temp_2010;
            }
            gap_2010 = gap_2010 / 2;
        }
    }
    
    public static void main(String[] args_2010) {
        int[] data_2010 = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
        
        System.out.print("Sebelum: ");
        printArray(data_2010);
        
        shellsort(data_2010);
        
        System.out.print("Sesudah (Shell Sort): ");
        printArray(data_2010);
    }
    
    public static void printArray(int[] arr_2010) {
        for (int i_2010 : arr_2010) {
            System.out.print(i_2010 + " ");
        }
        System.out.println();
    }
}