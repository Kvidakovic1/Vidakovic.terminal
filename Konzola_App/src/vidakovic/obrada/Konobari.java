package vidakovic.obrada;

import java.util.ArrayList;
import java.util.List;

import vidakovic.Pomocno;
import vidakovic.Start;
import vidakovic.model.Konobar;

public class Konobari {

	private List<Konobar> konobari;
	private Start start;

	public Konobari(Start start) {
		super();
		this.start = start;
		konobari = new ArrayList<>();
		testPodaci();
	}

	private void testPodaci() {
//		if(Pomocno.DEV) {
		konobari.add(new Konobar(1, "Marko", "Maric", "12345678910", "HR12308948334213012365"));
		konobari.add(new Konobar(2, "Iva", "Ivic", "12345378911", "HR12308948334213012333"));
		konobari.add(new Konobar(3, "Rajko", "Mlinac", "12345678510", "HR12308948334213012988"));
//		}

	}

	public Konobari(Start start, List<Konobar> konobari) {
		super();
		this.konobari = konobari;
		this.start = start;
		testPodaci();
	}

	public void izbornik() {
		System.out.println("");
		System.out.println("*Konobar izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih konobara");
		System.out.println("2. Unos novog konobara");
		System.out.println("3. Promjena postojećeg konobara");
		System.out.println("4. Brisanje konobara");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju za konobara: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (konobari.size() == 0) {
				System.out.println("Nema konobara kojeg bi mjenjali");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (konobari.size() == 0) {
				System.out.println("Nema konobra kojeg bi obrisali");
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
		int rb = Pomocno.unosBrojaRaspon("Odaberite konobara kojeg želite izbrisati", 1, konobari.size());
		konobari.remove(rb - 1);
		izbornik();

	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojaRaspon("Unesite konobara kojeg želite promjeniti", 1, konobari.size());
		Konobar k = konobari.get(rb - 1);
		k.setIme(Pomocno.unosTeksta("Unesite ime konobara: "));
		k.setPrezime(Pomocno.unosTeksta("Unesite prezimeime konobara: "));
		k.setOib(Pomocno.unosTeksta("Unesite OIB konobara: "));
		k.setIban(Pomocno.unosTeksta("Unesite IBAN konobara: "));
		izbornik();
	}

	private void unosNovog() {
		konobari.add(unesiNovogKonobara());
		izbornik();

	}

	private Konobar unesiNovogKonobara() {
		Konobar k = new Konobar();
		k.setSifra(Pomocno.unosBrojaRaspon("Unesi sifru konobara", 0, Integer.MAX_VALUE));
		k.setIme(Pomocno.unosTeksta("Unesite ime konobara: "));
		k.setPrezime(Pomocno.unosTeksta("Unesite prezime konobara: "));
		k.setOib(Pomocno.unosTeksta("Unesite oib: "));
		k.setIban(Pomocno.unosTeksta("Unesite iban: "));

		return k;

	}

	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Konobari u aplikaciji");
		System.out.println("---------");
		int rb = 1;
		for (Konobar k : konobari) {
			System.out.println(rb++ + ". " + k);
		}
		System.out.println("---------");
		if (prikaziIzbornik) {
			izbornik();
		}

	}

	public List<Konobar> getKonobari() {
		return konobari;
	}

	public void setKonobari(List<Konobar> konobari) {
		this.konobari = konobari;
	}

}
