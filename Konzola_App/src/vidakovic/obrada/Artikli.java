package vidakovic.obrada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import vidakovic.Pomocno;
import vidakovic.Start;
import vidakovic.model.Artikl;
import vidakovic.model.Konobar;

public class Artikli {
	
	private List<Artikl> artikli;
	private Start start;
	
	public Artikli(Start start) {
		super();
		this.start = start;
		artikli = new ArrayList<>();
		testPodaci();
	}
	
	private void testPodaci() {
		artikli.add(new Artikl(1, "Sendvic", new BigDecimal("3.4"), "Hrana"));
		artikli.add(new Artikl(2, "Pizza", new BigDecimal("6.59"), "Hrana"));
		artikli.add(new Artikl(3, "Coca cola", new BigDecimal("2.89"), "Hrana"));
		
	}

	public void izbornik() {
		System.out.println("");
		System.out.println("*Artikl izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih artikala");
		System.out.println("2. Unos novog artikla");
		System.out.println("3. Promjena postojećeg artikla");
		System.out.println("4. Brisanje artikla");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}
	
	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju za artikl: ", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (artikli.size() == 0) {
				System.out.println("Nema artikla kojeg bi mjenjali");
				izbornik();
			} else {
				promjena();
			}
			break;
		case 4:
			if (artikli.size() == 0) {
				System.out.println("Nema artikla kojeg bi obrisali");
				izbornik();
			} else {
				brisanje();
			}
			break;

		case 5:
			start.glavniIzbornik();
			
		}

	}
	
	private void brisanje() {
		pregled(false);
		int rb = Pomocno.unosBrojaRaspon("Odaberite artikl koji zelite obrisati: ", 1, artikli.size());
		artikli.remove(rb -1);
		izbornik();
		
	}

	private void promjena() {
		pregled(false);
		int rb = Pomocno.unosBrojaRaspon("Unesite artikl kojie zelite mjenjati: ", 1, artikli.size());
		Artikl a = artikli.get(rb -1);
		a.setNaziv(Pomocno.unosTeksta("Unesite naziv novog artikla: "));
		a.setCijena(Pomocno.unosCijene("Unesite cijenu novog artikla: "));
		a.setKategorija(Pomocno.unosTeksta("Unesite kategoriju novog artikla"));
		izbornik();
	}

	private void unosNovog() {
		artikli.add(unesiNoviArtikl());
		izbornik();

	}
	
	private Artikl unesiNoviArtikl() {
		Artikl a = new Artikl();
		a.setSifra(Pomocno.unosBrojaRaspon("Unesi sifru artikla: ", 0, Integer.MAX_VALUE));
		a.setNaziv(Pomocno.unosTeksta("Unesite ime artikla: "));
		a.setKategorija(Pomocno.unosTeksta("Unesite kategoriju artikla: "));
		a.setCijena(Pomocno.unosCijene("Unesite cijenu artikla: "));
		
		

		return a;

	}
	
	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Artikli u aplikaciji");
		System.out.println("---------");
		int rb = 1;
		for (Artikl a : artikli) {
			System.out.println(rb++ + ". " + a);
		}
		System.out.println("---------");
		if (prikaziIzbornik) {
			izbornik();
		}

	}
	
	

	public Artikli(List<Artikl> artikli, Start start) {
		super();
		this.artikli = artikli;
		this.start = start;
	}



	public List<Artikl> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<Artikl> artikli) {
		this.artikli = artikli;
	}
	
	
	

}
