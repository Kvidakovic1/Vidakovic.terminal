package vidakovic.obrada;

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
//			if (artikli.size() == 0) {
//				System.out.println("Nema konobara kojeg bi mjenjali");
//				izbornik();
//			} else {
//				promjena();
//			}
		case 4:
//			if (artikli.size() == 0) {
//				System.out.println("Nema konobra kojeg bi obrisali");
//				izbornik();
//			} else {
//				brisanje();
//			}

		case 5:
			start.glavniIzbornik();
		}

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
