package pekan8_2511532010;

//Simpan file ini dengan nama: Sorting_2511532010.java
import java.util.Scanner;

public class Sorting_2511532010 {

 // Array menyimpan maksimal 20 lagu dengan tipe data Lagu_2511532010
 static Lagu_2511532010[] dataLagu_2010 = new Lagu_2511532010[20];
 static int jumlahLagu_2010 = 0;

 // Method untuk mengisi data secara manual dari input user
 public static void inputData_2010(Scanner scanner_2010) {
     System.out.print("\nMasukkan jumlah lagu yang ingin diinput (maks 20): ");
     jumlahLagu_2010 = scanner_2010.nextInt();
     scanner_2010.nextLine(); // Membersihkan buffer enter

     if (jumlahLagu_2010 > 20) {
         jumlahLagu_2010 = 20;
         System.out.println("Batas maksimal adalah 20. Program akan membatasi input menjadi 20 lagu.");
     }

     for (int i_2010 = 0; i_2010 < jumlahLagu_2010; i_2010++) {
         System.out.println("Lagu ke-" + (i_2010 + 1));
         System.out.print("Judul          : ");
         String judul_2010 = scanner_2010.nextLine();
         
         System.out.print("Penyanyi       : ");
         String penyanyi_2010 = scanner_2010.nextLine();
         
         System.out.print("Durasi (detik) : ");
         int durasi_2010 = scanner_2010.nextInt();
         scanner_2010.nextLine(); // Membersihkan buffer enter
         
         // Instansiasi objek baru sesuai dengan nama class yang baru
         dataLagu_2010[i_2010] = new Lagu_2511532010(judul_2010, penyanyi_2010, durasi_2010);
         System.out.println();
     }
 }

 // Method untuk menampilkan sebelum dan sesudah sorting
 public static void tampilData_2010(String pesan_2010) {
     System.out.println(pesan_2010);
     for (int i_2010 = 0; i_2010 < jumlahLagu_2010; i_2010++) {
         System.out.println((i_2010 + 1) + ". " + dataLagu_2010[i_2010].judul_2010 + " - " + dataLagu_2010[i_2010].durasi_2010 + " detik");
     }
 }

 // Algoritma 1: Shell Sort (Berdasarkan Judul A-Z)
 public static void shellSort_2010() {
     for (int gap_2010 = jumlahLagu_2010 / 2; gap_2010 > 0; gap_2010 /= 2) {
         for (int i_2010 = gap_2010; i_2010 < jumlahLagu_2010; i_2010++) {
             Lagu_2511532010 temp_2010 = dataLagu_2010[i_2010];
             int j_2010;
             for (j_2010 = i_2010; j_2010 >= gap_2010 && dataLagu_2010[j_2010 - gap_2010].judul_2010.compareToIgnoreCase(temp_2010.judul_2010) > 0; j_2010 -= gap_2010) {
                 dataLagu_2010[j_2010] = dataLagu_2010[j_2010 - gap_2010];
             }
             dataLagu_2010[j_2010] = temp_2010;
         }
     }
 }

 // Algoritma 2: Quick Sort (Berdasarkan Durasi Ascending)
 public static void quickSort_2010(int low_2010, int high_2010) {
     if (low_2010 < high_2010) {
         int pi_2010 = partition_2010(low_2010, high_2010);
         quickSort_2010(low_2010, pi_2010 - 1);
         quickSort_2010(pi_2010 + 1, high_2010);
     }
 }

 // Partition untuk Quick Sort
 private static int partition_2010(int low_2010, int high_2010) {
     int pivot_2010 = dataLagu_2010[high_2010].durasi_2010;
     int i_2010 = (low_2010 - 1);
     for (int j_2010 = low_2010; j_2010 < high_2010; j_2010++) {
         if (dataLagu_2010[j_2010].durasi_2010 <= pivot_2010) {
             i_2010++;
             Lagu_2511532010 temp_2010 = dataLagu_2010[i_2010];
             dataLagu_2010[i_2010] = dataLagu_2010[j_2010];
             dataLagu_2010[j_2010] = temp_2010;
         }
     }
     Lagu_2511532010 temp_2010 = dataLagu_2010[i_2010 + 1];
     dataLagu_2010[i_2010 + 1] = dataLagu_2010[high_2010];
     dataLagu_2010[high_2010] = temp_2010;
     return i_2010 + 1;
 }

 // Algoritma 3: Merge Sort (Berdasarkan Judul A-Z)
 public static void mergeSort_2010(int left_2010, int right_2010) {
     if (left_2010 < right_2010) {
         int mid_2010 = left_2010 + (right_2010 - left_2010) / 2;
         mergeSort_2010(left_2010, mid_2010);
         mergeSort_2010(mid_2010 + 1, right_2010);
         merge_2010(left_2010, mid_2010, right_2010);
     }
 }

 // Proses penggabungan untuk Merge Sort
 private static void merge_2010(int left_2010, int mid_2010, int right_2010) {
     int n1_2010 = mid_2010 - left_2010 + 1;
     int n2_2010 = right_2010 - mid_2010;

     Lagu_2511532010[] L_2010 = new Lagu_2511532010[n1_2010];
     Lagu_2511532010[] R_2010 = new Lagu_2511532010[n2_2010];

     for (int i_2010 = 0; i_2010 < n1_2010; ++i_2010) {
         L_2010[i_2010] = dataLagu_2010[left_2010 + i_2010];
     }
     for (int j_2010 = 0; j_2010 < n2_2010; ++j_2010) {
         R_2010[j_2010] = dataLagu_2010[mid_2010 + 1 + j_2010];
     }

     int i_2010 = 0, j_2010 = 0;
     int k_2010 = left_2010;

     while (i_2010 < n1_2010 && j_2010 < n2_2010) {
         if (L_2010[i_2010].judul_2010.compareToIgnoreCase(R_2010[j_2010].judul_2010) <= 0) {
             dataLagu_2010[k_2010] = L_2010[i_2010];
             i_2010++;
         } else {
             dataLagu_2010[k_2010] = R_2010[j_2010];
             j_2010++;
         }
         k_2010++;
     }

     while (i_2010 < n1_2010) {
         dataLagu_2010[k_2010] = L_2010[i_2010];
         i_2010++;
         k_2010++;
     }

     while (j_2010 < n2_2010) {
         dataLagu_2010[k_2010] = R_2010[j_2010];
         j_2010++;
         k_2010++;
     }
 }

 public static void main(String[] args) {
     Scanner scanner_2010 = new Scanner(System.in);
     
     System.out.println("=== Sorting Playlist NIM: 2511532010 ===");
     System.out.print("Pilih Algoritma (1=Shell, 2=Quick, 3=Merge): ");
     int pilihan_2010 = scanner_2010.nextInt();

     // Panggil method input dengan mengirimkan scanner
     inputData_2010(scanner_2010);
     
     tampilData_2010("Data Sebelum Sorting:");

     switch (pilihan_2010) {
         case 1:
             shellSort_2010();
             tampilData_2010("\nData Setelah Shell Sort (Judul A-Z):");
             break;
         case 2:
             quickSort_2010(0, jumlahLagu_2010 - 1);
             tampilData_2010("\nData Setelah Quick Sort (Durasi Asc):");
             break;
         case 3:
             mergeSort_2010(0, jumlahLagu_2010 - 1);
             tampilData_2010("\nData Setelah Merge Sort (Judul A-Z):");
             break;
         default:
             System.out.println("\nPilihan tidak valid. Silakan jalankan ulang program.");
     }
     
     scanner_2010.close();
 }
}