package vidakovic;

import java.math.BigDecimal;
import java.util.Scanner;

public class Pomocno {

	public static Scanner ulaz;
	public static boolean DEV;

	public static int unosBrojaRaspon(String poruka, int min, int max) {
		int i;
		while (true) {
			try {
				System.out.println(poruka);
				i = Integer.parseInt(ulaz.nextLine());
				if (i < min || i > max) {
					System.out.println("Broj mora biti izmeđe " + min + " i " + max);
					continue;
				}
				return i;
			} catch (Exception e) {
				System.out.println("Niste unijeli broj");

			}

		}

	}

	public static String unosTeksta(String poruka) {
		String s;
		while (true) {
			try {
				System.out.println(poruka);
				s = ulaz.nextLine();
				if (s.trim().isEmpty()) {
					System.out.println("Obavezan unos");
					continue;

				}
				return s;
			} catch (Exception e) {
				System.out.println("Niste unijeli nista");
			}
		}
	}
	
	public static BigDecimal unosCijene(String poruka) {
		BigDecimal i;
		
		while(true) {
			
				System.out.println(poruka);
				i = ulaz.nextBigDecimal();
				
			return i;
			
			
		}
		
		
	}
}
