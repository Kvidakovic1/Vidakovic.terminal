package vidakovic.model;

import java.util.ArrayList;
import java.util.List;

import vidakovic.obrada.Gosti;

public class Narudba extends Entitet {
	
	
	private Stol stol;
	private List<Gost> gosti;
	
	
	public Narudba() {
		super();
		gosti = new ArrayList<>();
	}
	public Narudba(int sifra, Stol stol, List<Gost> gosti) {
		super(sifra);
		this.stol = stol;
		this.gosti = gosti;
	}
	public Stol getStol() {
		return stol;
	}
	public void setStol(Stol stol) {
		this.stol = stol;
	}
	public List<Gost> getGosti() {
		return gosti;
	}
	public void setGosti(List<Gost> gosti) {
		this.gosti = gosti;
	}
	
	@Override
	public String toString() {
		return getStol().toString();
	}
	
}
