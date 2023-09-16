package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nomCategorie;
@OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL, fetch=FetchType.EAGER)// par défaut la relation One to Many ne fait pas de jointure. avec Eager, on lui demande de faire une jointure
private List<Annonce> listeAnnonce;
public Categorie() {
	super();
	// TODO Auto-generated constructor stub
}
public Categorie(int id, String nomCategorie, List<Annonce> listeAnnonce) {
	super();
	this.id = id;
	this.nomCategorie = nomCategorie;
	this.listeAnnonce = listeAnnonce;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomCategorie() {
	return nomCategorie;
}
public void setNomCategorie(String nomCategorie) {
	this.nomCategorie = nomCategorie;
}
public List<Annonce> getListeAnnonce() {
	return listeAnnonce;
}
public void setListeAnnonce(List<Annonce> listeAnnonce) {
	this.listeAnnonce = listeAnnonce;
}
@Override
public String toString() {
	return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + "]";
}

}
