package fr.humanbooster.fx.poussettes.business;

public class Poussette {

	private Long id;
	private String nom;
	private String description;

	private Couleur couleur;
	
	private byte nbRoues;
	private float poids;

	private static Long compteurId  = new Long(0);

	public Poussette(String nom, String description, Couleur couleur, byte nbRoues, float poids) {
		super();
		this.id = ++compteurId;
		this.nom = nom;
		this.description = description;
		this.couleur = couleur;
		this.nbRoues = nbRoues;
		this.poids = poids;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getNbRoues() {
		return nbRoues;
	}

	public void setNbRoues(byte nbRoues) {
		this.nbRoues = nbRoues;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Poussette [id=" + id + ", nom=" + nom + ", description=" + description + ", couleur=" + couleur
				+ ", nbRoues=" + nbRoues + ", poids=" + poids + "]";
	}
}