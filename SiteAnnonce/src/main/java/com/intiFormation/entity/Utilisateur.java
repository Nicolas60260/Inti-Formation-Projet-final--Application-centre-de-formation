package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomUtilisateur;
	private String mail;
	private String mdp;
	private Boolean bloque;
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	@OneToMany(mappedBy = "utilisateur")
	@JsonIgnore
	private List<Commentaire>listeCommentaire;
	@OneToMany(mappedBy = "utilisateur",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Annonce>listeAnnonce;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur(int id, String nomUtilisateur, String mail, String mdp, Boolean bloque, Role role,
			List<Commentaire> listeCommentaire, List<Annonce> listeAnnonce) {
		super();
		this.id = id;
		this.nomUtilisateur = nomUtilisateur;
		this.mail = mail;
		this.mdp = mdp;
		this.bloque = bloque;
		this.role = role;
		this.listeCommentaire = listeCommentaire;
		this.listeAnnonce = listeAnnonce;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Boolean getBloque() {
		return bloque;
	}
	public void setBloque(Boolean bloque) {
		this.bloque = bloque;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Commentaire> getListeCommentaire() {
		return listeCommentaire;
	}
	public void setListeCommentaire(List<Commentaire> listeCommentaire) {
		this.listeCommentaire = listeCommentaire;
	}
	public List<Annonce> getListeAnnonce() {
		return listeAnnonce;
	}
	public void setListeAnnonce(List<Annonce> listeAnnonce) {
		this.listeAnnonce = listeAnnonce;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nomUtilisateur=" + nomUtilisateur + ", mail=" + mail + ", bloque=" + bloque
				+ ", role=" + role + "]";
	}
	
	

}
