package com.intiFormation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur extends Personne{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Utilisateur(int id, String mail, String nom, String prenom, Long telephone, int id2, String username,
			String password, Role role) {
		super(id, mail, nom, prenom, telephone);
		id = id2;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(int id, String mail, String nom, String prenom, Long telephone) {
		super(id, mail, nom, prenom, telephone);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
