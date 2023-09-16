package com.intiFormation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String titre;
private String description;
private String image;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date datePublication;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "dd/MM/yyyy")
private Date dateExpiration;
private Boolean statut;
@JsonIgnore
@ManyToOne
@JoinColumn(name="idutilisateur")
private Utilisateur utilisateur;
@OneToMany(mappedBy = "annonce")
private List<Commentaire> listeCommentaire;
@JsonIgnore
@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
@JoinColumn(name="idcategorie")
private Categorie categorie;
public Annonce() {
	super();
	// TODO Auto-generated constructor stub
}
public Annonce(int id, String titre, String description, String image, Date datePublication, Date dateExpiration,
		Boolean statut, Utilisateur utilisateur, List<Commentaire> listeCommentaire, Categorie categorie) {
	super();
	this.id = id;
	this.titre = titre;
	this.description = description;
	this.image = image;
	this.datePublication = datePublication;
	this.dateExpiration = dateExpiration;
	this.statut = statut;
	this.utilisateur = utilisateur;
	this.listeCommentaire = listeCommentaire;
	this.categorie = categorie;
}


public Annonce(String titre, String description, Date datePublication, Date dateExpiration, Boolean statut,
		Utilisateur utilisateur, Categorie categorie) {
	super();
	this.titre = titre;
	this.description = description;
	this.datePublication = datePublication;
	this.dateExpiration = dateExpiration;
	this.statut = statut;
	this.utilisateur = utilisateur;
	this.categorie = categorie;
}
public Annonce(int id, String titre) {
	super();
	this.id = id;
	this.titre = titre;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Date getDatePublication() {
	return datePublication;
}
public void setDatePublication(Date datePublication) {
	this.datePublication = datePublication;
}
public Date getDateExpiration() {
	return dateExpiration;
}
public void setDateExpiration(Date dateExpiration) {
	this.dateExpiration = dateExpiration;
}
public Boolean getStatut() {
	return statut;
}
public void setStatut(Boolean statut) {
	this.statut = statut;
}
public Utilisateur getUtilisateur() {
	return utilisateur;
}
public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}
public List<Commentaire> getListeCommentaire() {
	return listeCommentaire;
}
public void setListeCommentaire(List<Commentaire> listeCommentaire) {
	this.listeCommentaire = listeCommentaire;
}
public Categorie getCategorie() {
	return categorie;
}
public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}
@Override
public String toString() {
	return "Annonce [id=" + id + ", titre=" + titre + ", description=" + description + ", image=" + image
			+ ", datePublication=" + datePublication + ", dateExpiration=" + dateExpiration + ", statut=" + statut
			+ "]";
}

}
