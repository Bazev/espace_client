package fr.humanbooster.fx.poussettes.service;

import java.util.List;

import fr.humanbooster.fx.poussettes.business.Poussette;

public interface PoussetteService {

	public List<Poussette> recupererPoussettes();
	
	public List<Poussette> recupererPoussettes(String nom, Long idCouleur, Byte nbRoues);
	
	public Poussette recupererPoussette(String nom);
	
	public Poussette recupererPoussette(Long id);

}
