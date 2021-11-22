package fr.humanbooster.fx.poussettes;

import fr.humanbooster.fx.poussettes.service.CouleurService;
import fr.humanbooster.fx.poussettes.service.PoussetteService;
import fr.humanbooster.fx.poussettes.service.impl.CouleurServiceImpl;
import fr.humanbooster.fx.poussettes.service.impl.PoussetteServiceImpl;

public class App {

	private static PoussetteService ps = new PoussetteServiceImpl();
	private static CouleurService cs = new CouleurServiceImpl();
	
	public static void main(String[] args) {
		System.out.println(ps.recupererPoussettes());
		System.out.println(cs.recupererCouleurs());
		System.out.println(cs.recupererCouleur(4L));
		// Affiche la poussette rouge avec 4 roues et dont le nom contient by2
		System.out.println(ps.recupererPoussettes("by2", 2L, (long) 4 ));
		// Affiche les poussettes disposant de 4 roues
		System.out.println("4 roues: " + ps.recupererPoussettes(null, null, (long) 4 ));
		// Affiche les poussettes disposant de 4 roues et dont le nom contient by2
		System.out.println(ps.recupererPoussettes("by2", null, (long) 4 ));

		// Affiche les poussettes disposant de 4 roues et dont le nom contient by2
		System.out.println(ps.recupererPoussettes("by1", null, null));

		// Affiche les poussettes rouges
		System.out.println("noir:" + ps.recupererPoussettes(null, 1L, null));

		System.out.println("by2 et rouge:" + ps.recupererPoussettes("by2", 2L, null));
		
	}
}
