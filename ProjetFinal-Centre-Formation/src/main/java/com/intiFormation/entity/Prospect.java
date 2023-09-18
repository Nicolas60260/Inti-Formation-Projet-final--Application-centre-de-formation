package com.intiFormation.entity;

public class Prospect extends Personne{
	private int id;
	private String statut;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Prospect(int id, String mail, String nom, String prenom, Long telephone, int id2, String statut) {
		super(id, mail, nom, prenom, telephone);
		id = id2;
		this.statut = statut;
	}
	public Prospect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prospect(int id, String mail, String nom, String prenom, Long telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
