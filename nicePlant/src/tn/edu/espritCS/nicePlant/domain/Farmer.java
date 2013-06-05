package tn.edu.espritCS.nicePlant.domain;

public class Farmer {

	private int id_farmer;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String mail;

	public Farmer() {

	}

	public Farmer(String firstName, String lastName, String login,
			String password, String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}

	public int getId_farmer() {
		return id_farmer;
	}

	public void setId_farmer(int id_farmer) {
		this.id_farmer = id_farmer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
