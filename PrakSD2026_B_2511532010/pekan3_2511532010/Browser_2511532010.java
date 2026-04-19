package pekan3_2511532010;

import java.util.Stack;
import java.util.Scanner;

public class Browser_2511532010 {
    public static void main(String[] args) {
        // Menggunakan Stack untuk menyimpan objek Website
        Stack<Website_2511532010> history = new Stack<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Browser History NIM: 2511532010 ===");
            System.out.println("1. Kunjungi Website (Push)");
            System.out.println("2. Tombol Back (Pop)");
            System.out.println("3. Lihat Halaman Aktif (Peek)");
            System.out.println("4. Cek Status History (Size/Empty)");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    // Kunjungi Website (Push)
                    System.out.print("Masukkan Judul Website: ");
                    String judul = input.nextLine();
                    System.out.print("Masukkan URL Website: ");
                    String url = input.nextLine();
                    
                    Website_2511532010 webBaru = new Website_2511532010(judul, url);
                    history.push(webBaru);
                    System.out.println("Website berhasil dikunjungi!");
                    break;

                case 2:
                    // Tombol Back (Pop)
                    if (!history.isEmpty()) {
                        Website_2511532010 hapus = history.pop();
                        System.out.println("Berhasil kembali dari: " + hapus.getJudulWebsite_2010());
                    } else {
                        System.out.println("History kosong, tidak bisa kembali!");
                    }
                    break;

                case 3:
                    // Lihat Halaman Saat Ini (Peek)
                    if (!history.isEmpty()) {
                        Website_2511532010 aktif = history.peek();
                        System.out.println("\n--- Halaman Aktif Saat Ini ---");
                        System.out.println("Judul: " + aktif.getJudulWebsite_2010());
                        System.out.println("URL  : " + aktif.getUrlWebsite_2010());
                    } else {
                        System.out.println("Tidak ada halaman yang sedang dibuka.");
                    }
                    break;

                case 4:
                    // Cek Status History
                    if (history.isEmpty()) {
                        System.out.println("Status: Riwayat penjelajahan kosong.");
                    } else {
                        System.out.println("Status: Terdapat " + history.size() + " halaman dalam riwayat.");
                    }
                    break;

                case 5:
                    System.out.println("Menutup Browser...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);

        input.close();
    }
}