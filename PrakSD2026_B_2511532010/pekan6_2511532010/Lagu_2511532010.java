package pekan6_2511532010;

public class Lagu_2511532010 {
private String judul_2010;
private String penyanyi_2010;
private Lagu_2511532010 next_2010;
private Lagu_2511532010 prev_2010;

public Lagu_2511532010 (String judul_2010, String penyanyi_2010) {
	this.judul_2010 = judul_2010;
	this.penyanyi_2010 = penyanyi_2010;
	this.next_2010 = null;
	this.prev_2010 = null;
}

public String getjudul_2010() {return judul_2010;}
public String getpenyanyi_2010() {return penyanyi_2010;}
public Lagu_2511532010 getnext_2010() {return next_2010;}
public Lagu_2511532010 getprev_2010() {return prev_2010;}

public void setjudul_2010 (String judul_2010) {this.judul_2010 = judul_2010;}
public void setpenyanyi_2010 (String penyanyi_2010) {this.penyanyi_2010 = penyanyi_2010;}
public void setnext_2010 (Lagu_2511532010 next_2010) {this.next_2010 = next_2010;}
public void setprev_2010 (Lagu_2511532010 prev_2010) {this.prev_2010 = prev_2010;}
}
