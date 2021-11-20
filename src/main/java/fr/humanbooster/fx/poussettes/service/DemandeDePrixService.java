package fr.humanbooster.fx.poussettes.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.poussettes.business.DemandeDePrix;

public interface DemandeDePrixService {

	public List<DemandeDePrix> recupererDemandesDePrix();
	
	public DemandeDePrix recupererDemandeDePrix(Long id);
	
	public DemandeDePrix ajouterDemandeDePrix(String email, String nomPoussetteSelectionnee, Date dateDebut, Date dateFin, String informationComplementaire);
	
	public DemandeDePrix ajouterOption(Long idDemandeDePrix, Long idOption);

}
