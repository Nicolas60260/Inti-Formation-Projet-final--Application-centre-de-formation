package com.intiFormation.entity;

public class Personne {
	private int id;
	private String mail;
	private String nom;
	private String prenom;
	private Long telephone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public Personne(int id, String mail, String nom, String prenom, Long telephone) {
		super();
		this.id = id;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
