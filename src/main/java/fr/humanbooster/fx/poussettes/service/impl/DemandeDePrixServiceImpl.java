package fr.humanbooster.fx.poussettes.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.poussettes.business.DemandeDePrix;
import fr.humanbooster.fx.poussettes.service.DemandeDePrixService;
import fr.humanbooster.fx.poussettes.service.OptionService;
import fr.humanbooster.fx.poussettes.service.PoussetteService;

public class DemandeDePrixServiceImpl implements DemandeDePrixService {

	private static List<DemandeDePrix> demandesDePrix = new ArrayList<>();
	private OptionService os = new OptionServiceImpl();
	private PoussetteService ps = new PoussetteServiceImpl();
	
	@Override
	public List<DemandeDePrix> recupererDemandesDePrix() {
		return demandesDePrix;
	}

	@Override
	public DemandeDePrix recupererDemandeDePrix(Long id) {
		for (DemandeDePrix demandeDePrix : demandesDePrix) {
			if (demandeDePrix.getId().equals(id)) {
				return demandeDePrix;
			}
		}
		return null;
	}

	@Override
	public DemandeDePrix ajouterDemandeDePrix(String email, String nomPoussetteSelectionnee, Date dateDebut,
			Date dateFin, String informationComplementaire) {
		DemandeDePrix demandeDePrix = new DemandeDePrix(email, ps.recupererPoussette(nomPoussetteSelectionnee), dateDebut, dateFin, informationComplementaire);
		return demandeDePrix;
	}

	@Override
	public DemandeDePrix ajouterOption(Long idDemandeDePrix, Long idOption) {
		DemandeDePrix demandeDePrix = recupererDemandeDePrix(idDemandeDePrix);
		if (demandeDePrix != null) {
			demandeDePrix.getOptions().add(os.recupererOption(idOption));
		}
		return demandeDePrix;
	}

}
