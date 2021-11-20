package fr.humanbooster.fx.poussettes.business;

import java.util.Date;
import java.util.List;

public class DemandeDePrix {

	private Long id;
	private Date dateDemande;
	
	private String email;
	
	private Poussette poussetteSelectionnee;
	private List<Option> options;
	private Date dateDebut;
	private Date dateFin;
	
	private String informationComplementaire;

	private static Long compteurId  = new Long(0);
	
	public DemandeDePrix(String email, Poussette poussetteSelectionnee, Date dateDebut, Date dateFin,
			String informationComplementaire) {
		id = ++compteurId;
		dateDemande = new Date();
		this.email = email;
		this.poussetteSelectionnee = poussetteSelectionnee;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.informationComplementaire = informationComplementaire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Poussette getPoussetteSelectionnee() {
		return poussetteSelectionnee;
	}

	public void setPoussetteSelectionnee(Poussette poussetteSelectionnee) {
		this.poussetteSelectionnee = poussetteSelectionnee;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getInformationComplementaire() {
		return informationComplementaire;
	}

	public void setInformationComplementaire(String informationComplementaire) {
		this.informationComplementaire = informationComplementaire;
	}

	@Override
	public String toString() {
		return "DemandeDePrix [id=" + id + ", dateDemande=" + dateDemande + ", email=" + email
				+ ", poussetteSelectionnee=" + poussetteSelectionnee + ", options=" + options + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", informationComplementaire=" + informationComplementaire + "]";
	}
	
}
