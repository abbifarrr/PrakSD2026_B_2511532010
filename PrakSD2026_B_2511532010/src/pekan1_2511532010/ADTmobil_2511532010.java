package pekan1_2511532010;

public class ADTmobil_2511532010 {
	private String nama;
	private int tahun;
	private String merk;
	private int harga;
	private int cc;
	
	public ADTmobil_2511532010(String n, int t, int c, int h, String m) {
	    this.nama = n;
	    this.tahun = t;
	    this.cc = c;
	    this.harga = h;
	    this.merk = m;
	}

//SELEKTOR
public String getnama(){return nama;}
public int gettahun() {return tahun;}
public String getmerk () {return merk;}
public int getharga () {return harga;}
public int getcc () {return cc;}

//MUTATOR
public void setnama (String n) {this.nama=n;}
public void settahun (int t) {this.tahun=t;}
public void setmerk (String m) {this.merk=m;}
public void setharga (int h) {this.harga=h;}
public void setcc (int c) {this.cc=c;}

//OVERRIDING
public String toString() {
    return String.format("Mobil: %-10s | Tahun: %d | CC: %d | Harga: Rp %,d |Merk: %-8s", 
            nama, tahun, cc, harga, merk);
}































public static void main(String[] args) {
	// TODO Auto-generated method stub

}
}