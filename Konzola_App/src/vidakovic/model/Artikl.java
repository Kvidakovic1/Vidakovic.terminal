package vidakovic.model;

import java.math.BigDecimal;

public class Artikl extends Entitet {

	private String naziv;
	private BigDecimal cijena;
	private String kategorija;

	public Artikl() {
		super();
	}

	public Artikl(int sifra, String naziv, BigDecimal cijena, String kategorija) {
		super(sifra);
		this.naziv = naziv;
		this.cijena = cijena;
		this.kategorija = kategorija;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	@Override
	public String toString() {
		return naziv + " " + cijena;
	}
}
