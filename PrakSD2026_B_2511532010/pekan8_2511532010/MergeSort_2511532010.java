package pekan8_2511532010;

public class MergeSort_2511532010 {
    
    void merge_2010(int[] arr_2010, int l_2010, int m_2010, int r_2010) {

        int n1_2010 = m_2010 - l_2010 + 1;
        int n2_2010 = r_2010 - m_2010;

        int[] L_2010 = new int[n1_2010];
        int[] R_2010 = new int[n2_2010];

        for (int i_2010 = 0; i_2010 < n1_2010; ++i_2010) {
            L_2010[i_2010] = arr_2010[l_2010 + i_2010];
        }
        for (int j_2010 = 0; j_2010 < n2_2010; ++j_2010) {
            R_2010[j_2010] = arr_2010[m_2010 + 1 + j_2010];
        }
        
        int i_2010 = 0, j_2010 = 0;
        int k_2010 = l_2010;
        
        while (i_2010 < n1_2010 && j_2010 < n2_2010) {
            if (L_2010[i_2010] <= R_2010[j_2010]) {
                arr_2010[k_2010] = L_2010[i_2010];
                i_2010++;
            } else {
                arr_2010[k_2010] = R_2010[j_2010];
                j_2010++;
            }
            k_2010++;
        }
        
        while (i_2010 < n1_2010) {
            arr_2010[k_2010] = L_2010[i_2010];
            i_2010++;
            k_2010++;
        }
        
        while (j_2010 < n2_2010) {
            arr_2010[k_2010] = R_2010[j_2010];
            j_2010++;
            k_2010++;
        }
    }
    
    void sort(int arr_2010[], int l_2010, int r_2010) {
        if (l_2010 < r_2010) {
            int m_2010 = (l_2010 + r_2010) / 2;
            
            sort(arr_2010, l_2010, m_2010);
            
            // PERBAIKAN: Mengganti m_2010 + l_2010 menjadi m_2010 + 1
            sort(arr_2010, m_2010 + 1, r_2010); 
            
            merge_2010(arr_2010, l_2010, m_2010, r_2010);
        }
    }
    
    static void printArray(int[] arr_2010) {
        int n_2010 = arr_2010.length;
        for (int i_2010 = 0; i_2010 < n_2010; ++i_2010) {
            System.out.print(arr_2010[i_2010] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args_2010) {
        int[] arr_2010 = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Sebelum terurut:");
        printArray(arr_2010);
        
        MergeSort_2511532010 ob_2010 = new MergeSort_2511532010();
        ob_2010.sort(arr_2010, 0, arr_2010.length - 1);
        
        System.out.println("\nSesudah Terurut menggunakan Merge Sort:");
        printArray(arr_2010);
    }
}