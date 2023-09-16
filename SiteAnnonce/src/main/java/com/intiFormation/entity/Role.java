package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomRole;
	@OneToMany(mappedBy = "role")
	@JsonIgnore
	private List<Utilisateur>listeUtilisateur;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int id, String nomRole, List<Utilisateur> listeUtilisateur) {
		super();
		this.id = id;
		this.nomRole = nomRole;
		this.listeUtilisateur = listeUtilisateur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	public List<Utilisateur> getListeUtilisateur() {
		return listeUtilisateur;
	}
	public void setListeUtilisateur(List<Utilisateur> listeUtilisateur) {
		this.listeUtilisateur = listeUtilisateur;
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomRole=" + nomRole + "]";
	}
	
}
