package fr.humanbooster.fx.poussettes.service;

import java.util.List;

import fr.humanbooster.fx.poussettes.business.Couleur;

public interface CouleurService {

	public List<Couleur> recupererCouleurs();
	
	public Couleur recupererCouleur(Long id);
}
