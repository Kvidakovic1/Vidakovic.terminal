package vidakovic.obrada;

import java.util.ArrayList;
import java.util.List;

import vidakovic.Pomocno;
import vidakovic.Start;
import vidakovic.model.Narudba;

public class Narudbe {

	private List<Narudba> narudbe;
	private Start start;

	public Narudbe(Start start) {
		super();
		this.start = start;
		narudbe = new ArrayList<>();
	}

	public Narudbe(List<Narudba> narudbe, Start start) {
		super();
		this.narudbe = narudbe;
		this.start = start;

	}

	public void izbornik() {
		System.out.println("");
		System.out.println("*Narudba izbornik*");
		System.out.println("Dostupne opcije");
		System.out.println("1. Pregled svih narudbi");
		System.out.println("2. Unos nove narudbe");
		System.out.println("3. Promjena postojece narudbe");
		System.out.println("4. Brisanje narudbe");
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
		case 5:
			start.glavniIzbornik();
		}

	}

	private void unosNovog() {
		Narudba n = new Narudba();
		n.setSifra(Pomocno.unosBrojaRaspon("Unesi sifru narudbe: ", 0, Integer.MAX_VALUE));

		start.getStolovi().pregled(false);
		int i = Pomocno.unosBrojaRaspon("Unesite na koji stol zelite dodati goste: ", 1,
				start.getStolovi().getStolovi().size());
		n.setStol(start.getStolovi().getStolovi().get(i - 1));

		while (true) {
			start.getGosti().pregled(false);
			i = Pomocno.unosBrojaRaspon("Odaberite goste za dodavanje na stol: ", 1,
					start.getGosti().getGosti().size());
			n.getGosti().add(start.getGosti().getGosti().get(i-1));
		}

		narudbe.add(n);
		izbornik();

	}

	private void pregled(boolean prikaziIzbornik) {
		System.out.println("Trenutne narudbe");
		System.out.println("---------");
		int rb = 1;
		for (Narudba n : narudbe) {
			System.out.println(rb++ + ". " + n);
		}
		System.out.println("---------");
		if (prikaziIzbornik) {
			izbornik();
		}

	}

	public List<Narudba> getNarudbe() {
		return narudbe;
	}

	public void setNarudbe(List<Narudba> narudbe) {
		this.narudbe = narudbe;
	}

}
