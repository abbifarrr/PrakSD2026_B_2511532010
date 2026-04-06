package pekan2_2511532010;

public class DaftarKataDriver_2511532010 {


	    public static void main(String[] args) {
	        DaftarKata_2511532010 al = new DaftarKata_2511532010();

	        // Menambah elemen (akhir)
	        al.tambah_2511532010("Kami");
	        al.tambah_2511532010("Informatika");

	        // Menyisipkan elemen pada indeks 1
	        al.tambahPada_2511532010(1, "Mahasiswa");

	        // Cetak isi awal
	        System.out.println("Awal           : " + al);

	        // Mengubah elemen (index 1)
	        al.ubahElemen_2511532010(1, "Departemen");
	        System.out.println("Setelah Ubah   : " + al);

	        // Menghapus elemen (hapus index 0)
	        String terhapus = al.hapusElemen_2511532010(0);
	        System.out.println("Terhapus       : " + terhapus);
	        System.out.println("Setelah Hapus  : " + al);

	        // Iterasi pada ArrayList (cetak setiap elemen)
	        System.out.print("Iterasi: ");
	        al.iterasiCetak_2511532010();
	        System.out.println();
	    
	}
}
