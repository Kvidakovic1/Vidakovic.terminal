package vidakovic.obrada;

import java.util.ArrayList;
import java.util.List;

import vidakovic.Pomocno;
import vidakovic.Start;
import vidakovic.model.Konobar;
import vidakovic.model.Narucivanje;
import vidakovic.model.Stol;
import vidakovic.model.Narudba;

public class Narucivanja {
	private List<Narucivanje> narucivanja;
	private Start start;

	public Narucivanja(Start start) {
		super();
		this.start = start;
		narucivanja = new ArrayList<>();
	}

	public Narucivanja(List<Narucivanje> narucivanja, Start start) {
		super();
		this.narucivanja = narucivanja;
		this.start = start;
	}

	public void izbornik() {
		System.out.println("");
		System.out.println("*Narucivanje izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih narucivanja");
		System.out.println("2. Unos novog narucivanja");
		System.out.println("3. Promjena postojećeg narucivanja");
		System.out.println("4. Brisanje narucivanja");
		System.out.println("5. Povratak na glavni izbornik");
		odabirIzbornika();
	}

	private void odabirIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odaberi opciju", 1, 5)) {
		case 1:
			pregled(true);
			break;
		case 2:
			unosNovog();
			break;
		case 3:
			if (narucivanja.size() == 0) {
				System.out.println("Nema narucivanja koje bi mjenjali!");
				izbornik();
			} else {
				promjena();
			}

			break;
		case 4:
			if (narucivanja.size() == 0) {
				System.out.println("Nema narucivanja koje bi obrisali!");
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
		int i = Pomocno.unosBrojaRaspon("Odaberite narucivanje koje zelite obrisati", 1, narucivanja.size());
		narucivanja.remove(i - 1);
		izbornik();

	}

	private void promjena() {
		pregled(false);
		int i = Pomocno.unosBrojaRaspon("Unesi narucivanje koje zelite promjeniti: ", 1, narucivanja.size());
		Narucivanje o = narucivanja.get(i - 1);
		start.getNarudbe().pregled(false);
		int j = Pomocno.unosBrojaRaspon("Unesite narudbu koju zelite mjenjati: ", 1,
				start.getNarudbe().getNarudbe().size());
		o.setNarudba(start.getNarudbe().getNarudbe().get(j - 1));
		o.getArtikli().clear();
		while (true) {
			
			start.getArtikli().pregled(false);
			int z = Pomocno.unosBrojaRaspon("Koje artikl zelite naruciti?", 1, start.getArtikli().getArtikli().size());

			o.getArtikli().add(start.getArtikli().getArtikli().get(i - 1));
			if (Pomocno.unosBrojaRaspon("0 za kraj dodavanja artikla", 0, Integer.MAX_VALUE) == 0) {
				break;

			}
		}
		o.setNapomena(Pomocno.unosTeksta("Imate li kakvu napomenu za narucivanje?"));

		izbornik();

	}

	private void unosNovog() {
		Narucivanje n = new Narucivanje();
		n.setSifra(Pomocno.unosBrojaRaspon("Unesi sifru narucivanja", 1, Integer.MAX_VALUE));

		start.getNarudbe().pregled(false);
		int j = Pomocno.unosBrojaRaspon("Za koju narudbu zelite obaviti narucivanje", 1,
				start.getNarudbe().getNarudbe().size());
		n.setNarudba(start.getNarudbe().getNarudbe().get(j - 1));

		while (true) {
			start.getArtikli().pregled(false);
			int i = Pomocno.unosBrojaRaspon("Koje artikl zelite naruciti?", 1, start.getArtikli().getArtikli().size());
			n.getArtikli().add(start.getArtikli().getArtikli().get(i - 1));
			if (Pomocno.unosBrojaRaspon("0 za kraj dodavanja artikla", 0, Integer.MAX_VALUE) == 0) {
				break;
			}
		}
		n.setNapomena(Pomocno.unosTeksta("Imate li kakvu napomenu za narucivanje?"));

		narucivanja.add(n);
		izbornik();

	}

	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Narucivanja u aplikaciji");
		System.out.println("---------");
		int rb = 1;
		for (Narucivanje n : narucivanja) {
			System.out.println(rb++ + ". " + n);
		}
		System.out.println("---------");
		if (prikaziIzbornik) {
			izbornik();
		}
	}

	public List<Narucivanje> getNarucivanja() {
		return narucivanja;
	}

	public void setNarucivanja(List<Narucivanje> narucivanja) {
		this.narucivanja = narucivanja;
	}

}
