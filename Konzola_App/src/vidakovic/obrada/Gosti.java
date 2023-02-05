package vidakovic.obrada;

import java.util.ArrayList;
import java.util.List;

import vidakovic.Pomocno;
import vidakovic.Start;
import vidakovic.model.Gost;

public class Gosti {

	private List<Gost> gosti;
	private Start start;

	public Gosti(Start start) {
		super();
		this.start = start;
		gosti = new ArrayList<>();
		testPodaci();
	}

	private void testPodaci() {
//		if(Pomocno.DEV) {
		gosti.add(new Gost(1, "Predrag", "Rodic", "091-589-7222"));
		gosti.add(new Gost(2, "Savo", "Markovic", "091-632-1422"));
		gosti.add(new Gost(3, "Josipa", "Jadran", "091-445-6512"));
//		}

	}

	public Gosti(Start start, List<Gost> gosti) {
		super();
		this.gosti = gosti;
		this.start = start;
		testPodaci();
	}

	public void izbornik() {
		System.out.println("");
		System.out.println("*Gost izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih gostiju");
		System.out.println("2. Unos novog gosta");
		System.out.println("3. Promjena postojećeg gosta");
		System.out.println("4. Brisanje gosta");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju za gosta: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (gosti.size() == 0) {
				System.out.println("Nema gosta kojeg bi mjenjali");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (gosti.size() == 0) {
				System.out.println("Nema gosta kojeg bi obrisali");
				izbornik();
			} else {
				brisanje();
			}

		case 5:
			start.glavniIzbornik();
		}

	}

	private void brisanje() {
		pregled(false);
		int rb = Pomocno.unosBrojaRaspon("Odaberite gosta kojeg želite izbrisati", 1, gosti.size());
		gosti.remove(rb - 1);
		izbornik();

	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojaRaspon("Unesite gosta kojeg želite promjeniti", 1, gosti.size());
		Gost k = gosti.get(rb - 1);
		k.setIme(Pomocno.unosTeksta("Unesite ime gosta: "));
		k.setPrezime(Pomocno.unosTeksta("Unesite prezime gosta: "));
		k.setBroj_telefona(Pomocno.unosTeksta("Unesite broj telefona: "));
		
		izbornik();
	}

	private void unosNovog() {
		gosti.add(unesiNovogGosta());
		izbornik();

	}

	private Gost unesiNovogGosta() {
		Gost k = new Gost();
		k.setSifra(Pomocno.unosBrojaRaspon("Unesi sifru gosta: ", 0, Integer.MAX_VALUE));
		k.setIme(Pomocno.unosTeksta("Unesite ime gosta: "));
		k.setPrezime(Pomocno.unosTeksta("Unesite prezime gosta: "));
		k.setBroj_telefona(Pomocno.unosTeksta("Unesite broj telefona: "));
		

		return k;

	}

	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Gosti u aplikaciji");
		System.out.println("---------");
		int rb = 1;
		for (Gost k : gosti) {
			System.out.println(rb++ + ". " + k);
		}
		System.out.println("---------");
		if (prikaziIzbornik) {
			izbornik();
		}

	}

	public List<Gost> getGosti() {
		return gosti;
	}

	public void setGosti(List<Gost> gosti) {
		this.gosti = gosti;
	}

	
}
