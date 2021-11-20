package fr.humanbooster.fx.poussettes.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.poussettes.business.Option;
import fr.humanbooster.fx.poussettes.service.OptionService;

public class OptionServiceImpl implements OptionService {

	private static List<Option> options = new ArrayList<>();

	public OptionServiceImpl() {
		if (options.isEmpty()) {
			options.add(new Option("Ombrelle"));
			options.add(new Option("Panier"));
			options.add(new Option("Couverture"));
			options.add(new Option("Planche à roulettes"));
			options.add(new Option("Porte-gobelet"));
			options.add(new Option("Sac organisateur"));
		}
	}

	@Override
	public List<Option> recupererOptions() {
		return options;
	}

	@Override
	public Option recupererOption(Long id) {
		for (Option option : options) {
			if (option.getId().equals(id)) {
				return option;
			}
		}
		return null;
	}

}
