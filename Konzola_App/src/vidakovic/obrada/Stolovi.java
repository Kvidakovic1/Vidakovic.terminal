package vidakovic.obrada;

import java.util.ArrayList;
import java.util.List;

import vidakovic.Pomocno;
import vidakovic.Start;
import vidakovic.model.Konobar;
import vidakovic.model.Stol;

public class Stolovi {

	private List<Stol> stolovi;
	private Start start;

	public Stolovi(Start start) {
		super();
		this.start = start;
		stolovi = new ArrayList<>();
		testPodaci();
	}

	private void testPodaci() {
		stolovi.add(new Stol(1, 1, new Konobar(1, "Petar", "Petric", "00112233441", "HR021305784949329432")));
		stolovi.add(new Stol(2, 2, new Konobar(1, "Iva", "Ivancica", "00112233556", "HR021305591949329432")));
	}

	public Stolovi(List<Stol> stolovi, Start start) {
		super();
		this.stolovi = stolovi;
		this.start = start;
		testPodaci();
	}

	public void izbornik() {
		System.out.println("");
		System.out.println("*Stol izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih stolova");
		System.out.println("2. Unos novog stola");
		System.out.println("3. Promjena postojećeg stola");
		System.out.println("4. Brisanje stola");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (stolovi.size() == 0) {
				System.out.println("Nema stolova kojeg bi mjenjali!");
				izbornik();
			} else {
				promjena();
			}
		case 4:
			if (stolovi.size() == 0) {
				System.out.println("Nema stola kojeg bi obrisali");
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
		int rb = Pomocno.unosBrojaRaspon("Odaberite stol koji zelite obrisati: ", 1, stolovi.size());
		stolovi.remove(rb - 1);
		izbornik();

	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojaRaspon("Unesite stol koji zelite mjenjati", 1, stolovi.size());
		Stol s = stolovi.get(rb - 1);
		s.setBrojStola(Pomocno.unosBrojaRaspon("Unesi broj stola: ", 0, Integer.MAX_VALUE));

		start.getKonobari().pregled(false);
		int i = Pomocno.unosBrojaRaspon("Unesite kojeg konobara zelite za stol: ", 1,
				start.getKonobari().getKonobari().size());
		s.setKonobar(start.getKonobari().getKonobari().get(i - 1));
		izbornik();

	}

	private void unosNovog() {
		Stol s = new Stol();
		s.setSifra(Pomocno.unosBrojaRaspon("Unesi sifru stola: ", 0, Integer.MAX_VALUE));
		s.setBrojStola(Pomocno.unosBrojaRaspon("Unesi broj stola: ", 0, Integer.MAX_VALUE));

		start.getKonobari().pregled(false);
		int rb = Pomocno.unosBrojaRaspon("Unesite kojeg konobara zelite za stol: ", 1,
				start.getKonobari().getKonobari().size());
		s.setKonobar(start.getKonobari().getKonobari().get(rb - 1));

		stolovi.add(s);
		izbornik();

	}

	public void pregled(boolean prikaziIzbornik) {
		System.out.println("Stolovi u aplikaciji");
		System.out.println("---------");
		int rb = 1;
		for (Stol s : stolovi) {
			System.out.println(rb++ + ". " + s);
		}
		System.out.println("---------");
		if (prikaziIzbornik) {
			izbornik();
		}

	}

	public List<Stol> getStolovi() {
		return stolovi;
	}

	public void setStolovi(List<Stol> stolovi) {
		this.stolovi = stolovi;
	}

}
