package fr.humanbooster.fx.poussettes.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.poussettes.business.Poussette;
import fr.humanbooster.fx.poussettes.service.CouleurService;
import fr.humanbooster.fx.poussettes.service.PoussetteService;

public class PoussetteServiceImpl implements PoussetteService {

	private static List<Poussette> poussettes = new ArrayList<>();
	private CouleurService cs = new CouleurServiceImpl();

	public PoussetteServiceImpl() {
		if (poussettes.isEmpty()) {
			poussettes.add(new Poussette("Bimby1", "Bimby1", cs.recupererCouleur(1L), (byte) 3, 5f));
			poussettes.add(new Poussette("Bimby1", "Bimby1", cs.recupererCouleur(1L), (byte) 3, 5f));
			poussettes.add(new Poussette("Bimby2", "Bimby2", cs.recupererCouleur(2L), (byte) 4, 6f));
			poussettes.add(new Poussette("Bimby2", "Bimby2", cs.recupererCouleur(3L), (byte) 4, 6f));
			poussettes.add(new Poussette("Bimby3", "Bimby3", cs.recupererCouleur(4L), (byte) 3, 7f));
		}
	}

	@Override
	public List<Poussette> recupererPoussettes() {
		return poussettes;
	}

	@Override
	public List<Poussette> recupererPoussettes(String nom, Long idCouleur, Byte nbRoues) {
		List<Poussette> resultat = new ArrayList<>();

		for (Poussette poussette : poussettes) {
			// Les trois paramètres ont été transmis
			if (nom!=null && poussette.getNom().indexOf(nom) > 0 && nbRoues!=null && poussette.getNbRoues() == (byte) nbRoues && idCouleur!=null && idCouleur > 0 && poussette.getCouleur().getId() == idCouleur)
			{
				resultat.add(poussette);
			}
			// nom et couleur ont été transmis
			else if (nom!=null && poussette.getNom().indexOf(nom) > 0 && nbRoues==null && idCouleur!=null && idCouleur > 0 && poussette.getCouleur().getId() == idCouleur)
			{
				resultat.add(poussette);
			}			
			// nb roues et couleur ont été transmis
			else if (nom==null && nbRoues!=null && poussette.getNbRoues() == (byte) nbRoues && idCouleur!=null && idCouleur > 0 && poussette.getCouleur().getId() == idCouleur)
			{
				resultat.add(poussette);				
			}
			// nb roues a été transmi
			else if (nom==null && nbRoues!=null && poussette.getNbRoues() == (byte) nbRoues && idCouleur==null)
			{
				resultat.add(poussette);				
			}
			// nb roues et nom ont été transmis
			else if (nom!=null && poussette.getNom().indexOf(nom) > 0 && nbRoues!=null && poussette.getNbRoues() == (byte) nbRoues && idCouleur==null)
			{
				resultat.add(poussette);
			}
			// nom a été transmi
			else if (nom!=null && poussette.getNom().indexOf(nom) > 0 && nbRoues==null && idCouleur==null)
			{
				resultat.add(poussette);
			}
			// couleur a été transmi
			else if (nom==null && nbRoues==null && idCouleur!=null && poussette.getCouleur().getId() == idCouleur)
			{
				resultat.add(poussette);
			}

		}
		return resultat;
	}
	
	@Override
	public Poussette recupererPoussette(Long idPoussette) {
		for (Poussette poussette : poussettes) {
			if (poussette.getId().equals(idPoussette)) {
				return poussette;
			}
		}
		return null;
	}

	@Override
	public Poussette recupererPoussette(String nom) {
		for (Poussette poussette : poussettes) {
			if (poussette.getNom().equals(nom))
				return poussette;
		}
		return null;
	}

}