package pekan5_2511532010;

public class Pasien_2511532010 {
    private String namaPasien_2010;
    private String keluhan_2010;
    private int nomorAntrian_2010;
    private Pasien_2511532010 next_2010;

    // Constructor
    public Pasien_2511532010(String namaPasien_2010, String keluhan_2010, int nomorAntrian_2010) {
        this.namaPasien_2010 = namaPasien_2010;
        this.keluhan_2010 = keluhan_2010;
        this.nomorAntrian_2010 = nomorAntrian_2010;
        this.next_2010 = null;
    }

    // Selektor (Getter)
    public String getNamaPasien_2010() { return namaPasien_2010; }
    public String getKeluhan_2010() { return keluhan_2010; }
    public int getNomorAntrian_2010() { return nomorAntrian_2010; }
    public Pasien_2511532010 getNext_2010() { return next_2010; }

    // Mutator (Setter)
    public void setNamaPasien_2010(String nama_2010) { this.namaPasien_2010 = nama_2010; }
    public void setKeluhan_2010(String keluhan_2010) { this.keluhan_2010 = keluhan_2010; }
    public void setNomorAntrian_2010(int nomor_2010) { this.nomorAntrian_2010 = nomor_2010; }
    public void setNext_2010(Pasien_2511532010 next_2010) { this.next_2010 = next_2010; }
}