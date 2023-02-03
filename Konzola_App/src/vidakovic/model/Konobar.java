package vidakovic.model;

public class Konobar extends Entitet {

	private String ime;
	private String prezime;
	private String oib;
	private String iban;

	public Konobar() {
		super();
	}

	public Konobar(int sifra, String ime, String prezime, String oib, String iban) {
		super(sifra);
		this.ime = ime;
		this.prezime = prezime;
		this.oib = oib;
		this.iban = iban;
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

	public String getOib() {
		return oib;
	}

	public void setOib(String oib) {
		this.oib = oib;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}
