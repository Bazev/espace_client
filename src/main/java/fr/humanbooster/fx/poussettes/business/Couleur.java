package fr.humanbooster.fx.poussettes.business;

public class Couleur {

	private Long id;
	private String nom;
	private static Long compteurId = new Long(0);

	public Couleur(String nom) {
		this.nom = nom;
		id = ++compteurId;
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
		return "Couleur [id=" + id + ", nom=" + nom + "]";
	}

}
