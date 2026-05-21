package pekan7_2511532010;


public class Mahasiswa_2511532010 {
 private String nama_2010;
 private String nim_2010;
 private String prodi_2010;


 public Mahasiswa_2511532010(String nama_2010, String nim_2010, String prodi_2010) {
     this.nama_2010 = nama_2010;
     this.nim_2010 = nim_2010;
     this.prodi_2010 = prodi_2010;
 }

 
 public String getNama_2010() {return nama_2010;}
 public String getNim_2010() {return nim_2010;}
 public String getProdi_2010() {return prodi_2010;}

 
 public void setNama_2010(String nama_2010) {this.nama_2010 = nama_2010; }
 public void setNim_2010(String nim_2010) {this.nim_2010 = nim_2010;}
 public void setProdi_2010(String prodi_2010) {this.prodi_2010 = prodi_2010;}

 public String toString_2010() {return nama_2010 + " - " + nim_2010 + " (" + prodi_2010 + ")";}
}
