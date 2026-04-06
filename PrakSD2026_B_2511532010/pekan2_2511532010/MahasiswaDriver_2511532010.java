package pekan2_2511532010;
import java.util.Scanner;
import java.util.ArrayList;

public class MahasiswaDriver_2511532010 {
    public static void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Semua Mahasiswa");
        System.out.println("3. Hapus Mahasiswa Berdasarkan NIM");
        System.out.println("4. Cari Mahasiswa Berdasarkan NIM");
        System.out.println("5. Keluar");
    }

    public static void tambahMahasiswa_2511532010(ArrayList<Mahasiswa_2511532010> list, Scanner sc) {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();

        System.out.print("Masukkan Prodi: ");
        String prodi = sc.nextLine();

        list.add(new Mahasiswa_2511532010(nim, nama, prodi));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public static void tampilkanSemuaMahasiswa_2511532010(ArrayList<Mahasiswa_2511532010> list) {
        if (list.isEmpty()) {
            System.out.println("Daftar mahasiswa kosong.");
        } else {
            System.out.println("\n--- Data Mahasiswa ---");
            for (Mahasiswa_2511532010 mhs : list) {
                System.out.println(mhs);
            }
        }
    }

    public static void hapusMahasiswa_2511532010(ArrayList<Mahasiswa_2511532010> list, Scanner sc) {
        System.out.print("Masukkan NIM yang akan dihapus: ");
        String nimHapus = sc.nextLine();
        boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus));
        
        if (removed) {
            System.out.println("Data dengan NIM " + nimHapus + " berhasil dihapus.");
        } else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    public static void cariMahasiswa_2511532010(ArrayList<Mahasiswa_2511532010> list, Scanner sc) {
        System.out.print("Masukkan NIM yang dicari: ");
        String nimCari = sc.nextLine();
        boolean ditemukan = false;

        for (Mahasiswa_2511532010 mhs : list) {
            if (mhs.nim.equals(nimCari)) {
                System.out.println("Hasil Pencarian: " + mhs);
                ditemukan = true;
                break;
            }
        }
        // Perbaikan logika: jika TIDAK ditemukan (!ditemukan)
        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        ArrayList<Mahasiswa_2511532010> mahasiswaList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            tampilkanMenu();
            System.out.print("Pilih menu : ");
            
            // Validasi agar tidak error jika input bukan angka
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // PENTING: Membersihkan buffer newline setelah nextInt()
            } else {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // Membersihkan input yang salah
                continue;
            }

            switch (choice) {
                case 1:
                    tambahMahasiswa_2511532010(mahasiswaList, scanner);
                    break;
                case 2:
                    tampilkanSemuaMahasiswa_2511532010(mahasiswaList);
                    break;
                case 3:
                    hapusMahasiswa_2511532010(mahasiswaList, scanner);
                    break;
                case 4:
                    cariMahasiswa_2511532010(mahasiswaList, scanner);
                    break;
                case 5:
                    System.out.println("Program selesai. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}