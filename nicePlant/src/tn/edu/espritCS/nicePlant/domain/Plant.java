package tn.edu.espritCS.nicePlant.domain;

public class Plant {

	private int id_plant;
	private String name;
	private String saison;

	public Plant() {
		
	}

	public Plant(String name, String saison) {
		super();
		this.name = name;
		this.saison = saison;
	}

	public int getId_plant() {
		return id_plant;
	}

	public void setId_plant(int id_plant) {
		this.id_plant = id_plant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSaison() {
		return saison;
	}

	public void setSaison(String saison) {
		this.saison = saison;
	}
}
