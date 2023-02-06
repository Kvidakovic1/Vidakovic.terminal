//cd /d E:\java 
//E:\Java\Vidakovic.terminal\Konzola_App\bin>java vidakovic.Start dev

package vidakovic;

import java.util.Scanner;

import vidakovic.obrada.Artikli;
import vidakovic.obrada.Gosti;
import vidakovic.obrada.Konobari;

public class Start {

	private Konobari konobari;
	private Gosti gosti;
	private Artikli artikli;

	public Start() {

		Pomocno.ulaz = new Scanner(System.in);
		konobari = new Konobari(this);
		gosti = new Gosti(this);
		artikli = new Artikli(this);
		pozdravnaPoruka();
		glavniIzbornik();
	}

	public void glavniIzbornik() {
		System.out.println("");
		System.out.println("**GLAVNI IZBORNIK**");
		System.out.println("Dostupne opcije");
		System.out.println("1. Konobar");
		System.out.println("2. Gost");
		System.out.println("3. Artikl");
		System.out.println("7. Izlaz iz programa");
		odabirGlavnogIzbornika();
	}

	private void odabirGlavnogIzbornika() {
		switch (Pomocno.unosBrojaRaspon("Odabrana opcija", 1, 7)) {
		case 1:
			konobari.izbornik();
			break;
		case 2:
			gosti.izbornik();
			break;
		case 3:
			artikli.izbornik();
			
		case 7:
			System.out.println("Doviđenja!");
			break;

		}

	}

	private void pozdravnaPoruka() {
		System.out.println("Dobrodošli u Restoran terminal aplikaciju");

	}

	public static void main(String[] args) {
		if (args.length == 1) {
			Pomocno.DEV = true;
		} else {
			Pomocno.DEV = false;
		}
		new Start();
	}

}
