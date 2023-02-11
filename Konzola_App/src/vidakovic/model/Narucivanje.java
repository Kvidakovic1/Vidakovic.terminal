package vidakovic.model;

import java.util.ArrayList;
import java.util.List;

public class Narucivanje extends Entitet{
	
	private Narudba narudba;
	private List<Artikl> artikli;
	private String napomena;
	private int kolicina;
	
	
	public Narucivanje() {
		super();
		artikli = new ArrayList<>();
	}
	public Narucivanje(int sifra, Narudba narudba, List<Artikl> artikli, String napomena, int kolicina) {
		super(sifra);
		this.narudba = narudba;
		this.artikli = artikli;
		this.napomena = napomena;
		this.kolicina = kolicina;
	}
	public Narudba getNarudba() {
		return narudba;
	}
	public void setNarudba(Narudba narudba) {
		this.narudba = narudba;
	}
	public List<Artikl> getArtikli() {
		return artikli;
	}
	public void setArtikli(List<Artikl> artikli) {
		this.artikli = artikli;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	@Override
	public String toString() {
		return narudba.getStol().toString() + " ima naruceno " +   artikli.toString() + "(" + napomena + ")";
	}
	

}
