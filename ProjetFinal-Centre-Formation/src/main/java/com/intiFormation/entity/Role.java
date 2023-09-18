package com.intiFormation.entity;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Role {

	private int id;
	private String nom;
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private List<Utilisateur> listeUtilisateur;
}
