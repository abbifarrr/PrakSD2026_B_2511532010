package pekan7_2511532010;

public class SelectionSort_2511532010 {

    public static void selectionSort_2010(int[] arr_2010) {
        int n_2010 = arr_2010.length;
        
        for (int i_2010 = 0; i_2010 < n_2010; i_2010++) {
            int minIndex_2010 = i_2010;
            
           
            for (int j_2010 = i_2010 + 1; j_2010 < n_2010; j_2010++) {
                if (arr_2010[j_2010] < arr_2010[minIndex_2010]) {
                    minIndex_2010 = j_2010;
                }
            }
            

            int temp_2010 = arr_2010[i_2010];
            arr_2010[i_2010] = arr_2010[minIndex_2010];
            arr_2010[minIndex_2010] = temp_2010;
        }
    }

    public static void main(String[] args) {
        int arr_2010 [] = {23, 78, 45, 8, 32, 56, 1};
        int n_2010 = arr_2010.length;

        System.out.printf("array yang belum terurut:\n");
        for (int i_2010 = 0; i_2010 < n_2010; i_2010++) {
            System.out.print(arr_2010[i_2010] + " ");
        }
        System.out.println();

        selectionSort_2010(arr_2010);

        System.out.printf("array yang terurut:\n");
        for (int i_2010 = 0; i_2010 < n_2010; i_2010++) {
            System.out.print(arr_2010[i_2010] + " ");
        }
        System.out.println();
    }
}