package tn.edu.espritCS.nicePlant.domain;

public class Event {
private int id_evt;
private String name_evt;
private String periode;

public Event(String name_evt, String periode, int id_evt) {
	super();
	this.name_evt = name_evt;
	this.periode = periode;
	this.id_evt = id_evt;
}

public Event() {

}

public Event(String name_evt, String periode) {
	super();
	this.name_evt = name_evt;
	this.periode = periode;
}

public int getId_evt() {
	return id_evt;
}

public void setId_evt(int id_evt) {
	this.id_evt = id_evt;
}

public String getName_evt() {
	return name_evt;
}

public void setName_evt(String name_evt) {
	this.name_evt = name_evt;
}

public String getPeriode() {
	return periode;
}

public void setPeriode(String periode) {
	this.periode = periode;
}


}
