package pekan4_2511532010;

import java.util.Scanner;

public class AntrianLoket_2511532010 {
    public static void main(String[] args) {
        Scanner input_2010 = new Scanner(System.in);
        // Menginisialisasi antrian dengan kapasitas 5
        Queue_2511532010 loket_2010 = new Queue_2511532010(5);
        int pilih_2010;

        do {
            System.out.println("\n=== PROGRAM ANTRIAN LOKET ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Reverse");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            // Validasi input agar tidak error jika user memasukkan huruf
            while (!input_2010.hasNextInt()) {
                System.out.println("Masukkan angka 1-5!");
                input_2010.next();
            }
            
            pilih_2010 = input_2010.nextInt();
            input_2010.nextLine(); // clear buffer

            switch (pilih_2010) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = input_2010.nextLine();
                    loket_2010.enqueue_2010(nama);
                    break;
                case 2:
                    loket_2010.dequeue_2010();
                    break;
                case 3:
                    loket_2010.display_2010();
                    break;
                case 4:
                    // Memanggil method reverse dari class sebelah
                    loket_2010.reverse_2010();
                    System.out.println("Antrian berhasil dibalik.");
                    loket_2010.display_2010();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilih_2010 != 5);

        input_2010.close();
    }
}