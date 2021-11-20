package fr.humanbooster.fx.poussettes.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.poussettes.business.Couleur;
import fr.humanbooster.fx.poussettes.service.CouleurService;

public class CouleurServiceImpl implements CouleurService {

	private static List<Couleur> couleurs = new ArrayList<>();

	public CouleurServiceImpl() {
		if (couleurs.isEmpty()) {
			couleurs.add(new Couleur("Noir"));
			couleurs.add(new Couleur("Rouge"));
			couleurs.add(new Couleur("Rose"));
			couleurs.add(new Couleur("Bleu"));
		}
	}

	@Override
	public List<Couleur> recupererCouleurs() {
		return couleurs;
	}

	@Override
	public Couleur recupererCouleur(Long id) {
		for (Couleur couleur : couleurs) {
			if (couleur.getId().equals(id)) {
				return couleur;
			}
		}
		return null;
	}

}
