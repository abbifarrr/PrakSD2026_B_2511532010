package pekan2_2511532010;

public class Mahasiswa_2511532010 {
	
	String nama;
	String nim;
	String prodi;
	Mahasiswa_2511532010(String nim, String nama, String prodi) {
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
	}
	
	@Override
	
	public String toString() {
		return "Nim: " + nim + ", Nama:" + nama + ", Prodi: " + prodi;
	}

}
