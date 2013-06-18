package tn.edu.espritCS.nicePlant.domain;

public class Malady {

	private int id_malady;
	private String name_mal;
	private String tige;
	private String feuille;
	private String fleur;
	private String solution;

	public Malady() {

	}

	public Malady(String name_mal, String tige, String feuille, String fleur,
			String solution) {
		super();
		this.name_mal = name_mal;
		this.tige = tige;
		this.feuille = feuille;
		this.fleur = fleur;
		this.solution = solution;
	}

	public Malady(int id_malady, String name_mal, String tige, String feuille,
			String fleur, String solution) {
		super();
		this.id_malady = id_malady;
		this.name_mal = name_mal;
		this.tige = tige;
		this.feuille = feuille;
		this.solution = solution;
		this.fleur = fleur;
	}

	public int getId_malady() {
		return id_malady;
	}

	public void setId_malady(int id_malady) {
		this.id_malady = id_malady;
	}

	public String getName_mal() {
		return name_mal;
	}

	public void setName_mal(String name_mal) {
		this.name_mal = name_mal;
	}

	public String getTige() {
		return tige;
	}

	public void setTige(String tige) {
		this.tige = tige;
	}

	public String getFeuille() {
		return feuille;
	}

	public void setFeuille(String feuille) {
		this.feuille = feuille;
	}

	public String getFleur() {
		return fleur;
	}

	public void setFleur(String fleur) {
		this.fleur = fleur;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

}
