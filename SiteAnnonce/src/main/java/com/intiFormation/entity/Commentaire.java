package com.intiFormation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String leCommentaire;
@ManyToOne
@JoinColumn(name="idutilisateur")
private Utilisateur utilisateur;
@ManyToOne
@JoinColumn(name="idannonce")
private Annonce annonce;

public Commentaire() {
	super();
	// TODO Auto-generated constructor stub
}
public Commentaire(int id, String leCommentaire, Utilisateur utilisateur, Annonce annonce) {
	super();
	this.id = id;
	this.leCommentaire = leCommentaire;
	this.utilisateur = utilisateur;
	this.annonce = annonce;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLeCommentaire() {
	return leCommentaire;
}
public void setLeCommentaire(String leCommentaire) {
	this.leCommentaire = leCommentaire;
}
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public Annonce getAnnonce() {
	return annonce;
}
public void setAnnonce(Annonce annonce) {
	this.annonce = annonce;
}
@Override
public String toString() {
	return "Commentaire [id=" + id + ", leCommentaire=" + leCommentaire + "]";
}

}
