package fr.humanbooster.fx.poussettes.business;

public class Option {

	private Long id;
	private String nom;
	private static Long compteurId  = new Long(0);
	
	public Option(String nom) {
		id = ++compteurId;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", nom=" + nom + "]";
	}
	
}