package pekan3_2511532010;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2511532010 {
    public static void main(String[] args) {
        ArrayList<Musik_2511532010> daftarLagu = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n=== Playlist Musik NIM: 2511532010 ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Playlist");
            System.out.println("3. Hapus Lagu");
            System.out.println("4. Cek Kapasitas");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                	//Tambah Lagu
                    System.out.print("Masukkan Judul: ");
                    String judul = input.nextLine();
                    
                    System.out.print("Masukkan Penyanyi: ");
                    String penyanyi = input.nextLine();
                    
                    System.out.print("Masukkan Durasi (detik): ");
                    int durasi = input.nextInt();
                    input.nextLine(); 
                    
                    Musik_2511532010 laguBaru = new Musik_2511532010(judul, penyanyi, durasi);
                    daftarLagu.add(laguBaru);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:
                    // Lihat Playlist
                    System.out.println("\n--- Daftar Lagu ---");
                    if (daftarLagu.isEmpty()) {
                        System.out.println("Playlist masih kosong.");
                    } else {
                        for (int i = 0; i < daftarLagu.size(); i++) {
                            Musik_2511532010 m = daftarLagu.get(i);
                            System.out.println((i + 1) + ". " + m.getJudul_2010() + " - " + 
                                               m.getPenyanyi_2010() + " (" + m.getDurasi_2010() + " detik)");}
                    }break;

                case 3:
                    // Hapus Lagu
                    if (daftarLagu.isEmpty()) {
                        System.out.println("Tidak ada lagu untuk dihapus.");
                    } else {
                        System.out.print("Masukkan nomor urut yang ingin dihapus (1-" + daftarLagu.size() + "): ");
                        int nomor = input.nextInt();
                        input.nextLine();
                        
                        if (nomor > 0 && nomor <= daftarLagu.size()) {
                            daftarLagu.remove(nomor - 1);
                            System.out.println("Lagu berhasil dihapus!");
                        } else {
                            System.out.println("Nomor tidak valid!");
                        }
                    }
                    break;

                case 4:
                    // Cek Kapasitas
                    System.out.println("Total lagu dalam playlist saat ini: " + daftarLagu.size());
                    break;

                case 5:
                	//Keluar
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilih != 5);

        input.close();
    }
}