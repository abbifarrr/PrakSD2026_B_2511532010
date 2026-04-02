package pekan1_2511532010;

import java.util.Scanner;

public class Driver_2511532010 {
    private static ADTmobil_2511532010[] daftarMobil = new ADTmobil_2511532010[100];
    private static int jumlahMobil = 0; // NIM: 2511532010

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean berjalan = true;

        System.out.println("=== Program Management Mobil 2511532010 ===");

        while (berjalan) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Mobil");
            System.out.println("2. Hapus Mobil (Berdasarkan Nama)");
            System.out.println("3. Lihat Semua Mobil");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            String pilihan = input.nextLine();

            if (pilihan.equals("1")) {tambahMobil(input);} 
            else if (pilihan.equals("2")) {hapusMobil(input);} 
            else if (pilihan.equals("3")) {tampilkanMobil();} 
            else if (pilihan.equals("4")) {
                System.out.println("Keluar program...");
                berjalan = false;} 
            else {System.out.println("Pilihan tidak valid!");}}
        input.close();}

    private static void tambahMobil(Scanner sc) {
        if (jumlahMobil < daftarMobil.length) {
            System.out.println("\n--- Input Data Mobil ---");           
            System.out.print("Nama Mobil   : "); String nama = sc.nextLine();            
            System.out.print("Tahun Terbit : "); int tahun = Integer.parseInt(sc.nextLine());            
            System.out.print("Kapasitas CC : "); int cc = Integer.parseInt(sc.nextLine());
            System.out.print("Harga Mobil  : "); int harga = Integer.parseInt(sc.nextLine());
            System.out.print("Merk Mobil   : "); String merk = sc.nextLine();
            daftarMobil[jumlahMobil] = new ADTmobil_2511532010(nama, tahun, cc, harga, merk);
            
            jumlahMobil++;
            System.out.println("[Berhasil] Mobil disimpan.");} 
        else {System.out.println("[Gagal] Kapasitas penuh!");}}

    private static void hapusMobil(Scanner sc) {
        if (jumlahMobil == 0) {System.out.println("Daftar kosong.");
            return;}

        System.out.print("Masukkan nama mobil yang ingin dihapus: ");	String cari = sc.nextLine();
        int indeksDitemukan = -1;

        for (int i = 0; i < jumlahMobil; i++) {
            if (daftarMobil[i].getnama().equalsIgnoreCase(cari)) {indeksDitemukan = i;
                break;}}

        if (indeksDitemukan != -1) {
            for (int i = indeksDitemukan; i < jumlahMobil - 1; i++) {daftarMobil[i] = daftarMobil[i + 1];}
            daftarMobil[jumlahMobil - 1] = null;
            jumlahMobil--;
            System.out.println("[Berhasil] Mobil '" + cari + "' dihapus.");}
        else {System.out.println("[Gagal] Mobil tidak ditemukan.");}}

    private static void tampilkanMobil() {
        if (jumlahMobil == 0) {System.out.println("Daftar kosong.");}
        else {System.out.println("\n--- DAFTAR MOBIL ---");
            for (int i = 0; i < jumlahMobil; i++) {
                System.out.println((i + 1) + ". " + daftarMobil[i].toString());
            }
        }
    }
}