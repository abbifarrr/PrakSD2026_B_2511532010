package pekan6_2511532010;
import java.util.*;
public class Musik_2511532010 {
    private Lagu_2511532010 head_2010;
    private Lagu_2511532010 tail_2010;

    public Musik_2511532010() {
        this.head_2010 = null;
        this.tail_2010 = null;
    }

    // Menambah lagu di AKHIR
    public void tambahLagu_2010(String judul, String penyanyi) {
        Lagu_2511532010 laguBaru = new Lagu_2511532010(judul, penyanyi);
        if (head_2010 == null) {
            head_2010 = tail_2010 = laguBaru;
        } else {
            tail_2010.setnext_2010(laguBaru);
            laguBaru.setprev_2010(tail_2010);
            tail_2010 = laguBaru;
        }
        System.out.println("Lagu \"" + judul + "\" berhasil ditambahkan.");
    }

    // Menghapus lagu PERTAMA
    public void hapusLaguAwal_2010() {
        if (head_2010 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        System.out.println("Menghapus: " + head_2010.getjudul_2010());
        if (head_2010 == tail_2010) {
            head_2010 = tail_2010 = null;
        } else {
            head_2010 = head_2010.getnext_2010();
            head_2010.setprev_2010(null);
        }
    }

    // Tampil MAJU
    public void tampilMaju_2010() {
        if (head_2010 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511532010 current = head_2010;
        System.out.println("\n--- Playlist (Maju) ---");
        while (current != null) {
            System.out.println(current.getjudul_2010() + " - " + current.getpenyanyi_2010());
            current = current.getnext_2010();
        }
    }

    // Tampil MUNDUR
    public void tampilMundur_2010() {
        if (tail_2010 == null) {
            System.out.println("Playlist kosong.");
            return;
        }
        Lagu_2511532010 current = tail_2010;
        System.out.println("\n--- Playlist (Mundur) ---");
        while (current != null) {
            System.out.println(current.getjudul_2010() + " - " + current.getpenyanyi_2010());
            current = current.getprev_2010();
        }
    }

    // CARI lagu
    public void cariLagu_2010(String judul) {
        Lagu_2511532010 current = head_2010;
        while (current != null) {
            if (current.getjudul_2010().equalsIgnoreCase(judul)) {
                System.out.println("Ditemukan: " + current.getjudul_2010() + " [" + current.getpenyanyi_2010() + "]");
                return;
            }
            current = current.getnext_2010();
        }
        System.out.println("Lagu tidak ditemukan.");
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Musik_2511532010 playlist = new Musik_2511532010();
        int pilih;

        do {
            System.out.println("\n=== Playlist Musik NIM: 2511532010 ===");
            System.out.println("1. Tambah Lagu\n2. Hapus Lagu Pertama\n3. Lihat Playlist (Maju)");
            System.out.println("4. Lihat Playlist (Mundur)\n5. Cari Lagu\n6. Keluar");
            System.out.print("Pilihan: ");
            pilih = sc.nextInt();
            sc.nextLine(); 

            switch (pilih) {
                case 1:
                    System.out.print("Judul: "); String j = sc.nextLine();
                    System.out.print("Penyanyi: "); String p = sc.nextLine();
                    playlist.tambahLagu_2010(j, p);
                    break;
                case 2: playlist.hapusLaguAwal_2010(); break;
                case 3: playlist.tampilMaju_2010(); break;
                case 4: playlist.tampilMundur_2010(); break;
                case 5:
                    System.out.print("Cari Judul: "); String c = sc.nextLine();
                    playlist.cariLagu_2010(c);
                    break;
            }
        } while (pilih != 6);
        sc.close();
    }
}