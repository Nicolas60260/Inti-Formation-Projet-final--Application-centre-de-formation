package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurService {
	
	public List<Utilisateur> afficherAll();
	
	public Utilisateur afficherParId(int id);
	
	public void ajouter(Utilisateur a);
	
	public void supprimer(int id);
	
	public void modifier(Utilisateur p);
	
	public Utilisateur findByMailAndMdp(String mail, String mdp);
	
	public Utilisateur loadUserBynomUtilisateur (String nomUtilisateur);
	
	public Utilisateur loadUserByEmail (String email);
	
	
}
