package fr.humanbooster.fx.poussettes.service;

import java.util.List;

import fr.humanbooster.fx.poussettes.business.Option;

public interface OptionService {

	public List<Option> recupererOptions();

	public Option recupererOption(Long id);
}
