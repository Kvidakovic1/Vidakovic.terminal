package vidakovic.model;

public class Gost extends Entitet {

	private String ime;
	private String prezime;
	private String broj_telefona;

	public Gost() {
		super();
	}

	public Gost(int sifra, String ime, String prezime, String broj_telefona) {
		super(sifra);
		this.ime = ime;
		this.prezime = prezime;
		this.broj_telefona = broj_telefona;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBroj_telefona() {
		return broj_telefona;
	}

	public void setBroj_telefona(String broj_telefona) {
		this.broj_telefona = broj_telefona;
	}

}
