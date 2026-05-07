package pekan5_2511532010;

import java.util.*;

public class RumahSakit_2511532010 {
    private static Pasien_2511532010 head_2010 = null;
    private static Pasien_2511532010 tail_2010 = null;
    private static int counter_2010 = 0;

    // 1. Daftarkan Pasien (Insert at Tail)
    public static void daftarkanPasien_2010(String nama_2010, String keluhan_2010) {
        counter_2010++;
        Pasien_2511532010 baru_2010 = new Pasien_2511532010(nama_2010, keluhan_2010, counter_2010);
        
        if (head_2010 == null) {
            head_2010 = tail_2010 = baru_2010;
        } else {
            tail_2010.setNext_2010(baru_2010);
            tail_2010 = baru_2010;
        }
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counter_2010);
    }

    // 2. Panggil Pasien (Delete Head)
    public static void panggilPasien_2010() {
        if (head_2010 == null) {
            System.out.println("Antrian Kosong!");
            return;
        }
        System.out.println("Memanggil Pasien: " + head_2010.getNamaPasien_2010() + " [Antrian: " + head_2010.getNomorAntrian_2010() + "]");
        head_2010 = head_2010.getNext_2010();
        if (head_2010 == null) tail_2010 = null;
    }

    // 3. Tampilkan Antrian (Display)
    public static void tampilkanAntrian_2010() {
        if (head_2010 == null) {
            System.out.println("Antrian Kosong!");
            return;
        }
        Pasien_2511532010 curr_2010 = head_2010;
        System.out.println("=== Daftar Antrian ===");
        while (curr_2010 != null) {
            System.out.println("No: " + curr_2010.getNomorAntrian_2010() + " | Nama: " + curr_2010.getNamaPasien_2010() + " | Keluhan: " + curr_2010.getKeluhan_2010());
            curr_2010 = curr_2010.getNext_2010();
        }
    }

    // 4. Cari Pasien (Search - Case Insensitive)
    public static void cariPasien_2010(String cariNama_2010) {
        Pasien_2511532010 curr_2010 = head_2010;
        boolean ketemu_2010 = false;
        while (curr_2010 != null) {
            if (curr_2010.getNamaPasien_2010().equalsIgnoreCase(cariNama_2010)) {
                System.out.println("Pasien ditemukan! No Antrian: " + curr_2010.getNomorAntrian_2010() + ", Keluhan: " + curr_2010.getKeluhan_2010());
                ketemu_2010 = true;
                break;
            }
            curr_2010 = curr_2010.getNext_2010();
        }
        if (!ketemu_2010) System.out.println("Pasien dengan nama '" + cariNama_2010 + "' tidak ditemukan.");
    }

    // 5. Cek Status Antrian
    public static void cekStatusAntrian_2010() {
        if (head_2010 == null) {
            System.out.println("List Kosong.");
            return;
        }
        int total_2010 = 0;
        Pasien_2511532010 curr_2010 = head_2010;
        while (curr_2010 != null) {
            total_2010++;
            curr_2010 = curr_2010.getNext_2010();
        }
        System.out.println("Total Pasien dalam Antrian: " + total_2010);
        System.out.println("Pasien Terdepan: " + head_2010.getNamaPasien_2010() + " (No: " + head_2010.getNomorAntrian_2010() + ")");
    }

    public static void main(String[] args) {
        Scanner sc_2010 = new Scanner(System.in);
        int pilihan_2010;

        do {
            System.out.println("\n=== Antrian Rumah Sakit NIM: 2511532010 ===");
            System.out.println("1. Daftarkan Pasien (Insert)");
            System.out.println("2. Panggil Pasien (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            pilihan_2010 = sc_2010.nextInt();
            sc_2010.nextLine(); // consume newline

            switch (pilihan_2010) {
                case 1:
                    System.out.print("Masukkan Nama Pasien: ");
                    String n_2010 = sc_2010.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String k_2010 = sc_2010.nextLine();
                    daftarkanPasien_2010(n_2010, k_2010);
                    break;
                case 2:
                    panggilPasien_2010();
                    break;
                case 3:
                    tampilkanAntrian_2010();
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    cariPasien_2010(sc_2010.nextLine());
                    break;
                case 5:
                    cekStatusAntrian_2010();
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan_2010 != 6);
        sc_2010.close();
    }
}