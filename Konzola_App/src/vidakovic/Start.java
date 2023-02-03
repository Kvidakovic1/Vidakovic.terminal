package vidakovic;

public class Start {

	public Start() {

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
	}

	private void pozdravnaPoruka() {
		System.out.println("Dobrodošli u Restoran terminal aplikaciju");

	}
	
	public static void main(String[] args) {
		new Start();
	}

}
