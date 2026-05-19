package pekan7_2511532010;

public class InsertionSort_2511532010 {

    public static void insertionSort_2010(int[] arr_2010) {
        int n_2010 = arr_2010.length;
        for (int i_2010 = 1; i_2010 < arr_2010.length; i_2010++) {
            int key_2010 = arr_2010[i_2010];
            int j_2010 = i_2010 - 1;
            
            while (j_2010 >= 0 && arr_2010[j_2010] > key_2010) {
                arr_2010[j_2010 + 1] = arr_2010[j_2010];
                j_2010--;
            }
            arr_2010[j_2010 + 1] = key_2010;
        }
    }

    public static void main(String[] args_2010) {
        int[] arr_2010 = {23, 78, 45, 8, 32, 56, 1};
        int n_2010 = arr_2010.length;

        System.out.printf("array yang belum terurut: \n");
        for (int i_2010 = 0; i_2010 < n_2010; i_2010++) {
            System.out.print(arr_2010[i_2010] + " ");
        }
        System.out.println();

        // Memanggil fungsi sorting
        insertionSort_2010(arr_2010);

        System.out.printf("array yang terurut: \n");
        for (int i_2010 = 0; i_2010 < n_2010; i_2010++) {
            System.out.print(arr_2010[i_2010] + " ");
        }
        System.out.println();
    }
}