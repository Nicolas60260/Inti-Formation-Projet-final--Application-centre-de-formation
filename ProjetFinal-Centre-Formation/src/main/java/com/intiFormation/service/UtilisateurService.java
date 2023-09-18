package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IUtilisateurDao;
import com.intiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService{
	@Autowired
	IUtilisateurDao dao;
	
	public List<Utilisateur> afficherAll()
	{
		return dao.findAll();
	}
	
	public Utilisateur afficherParId(int id)
	{
		return dao.findById(id).get();
	}
	
	public void ajouter(Utilisateur a)
	{
		dao.save(a);
	}
	
	public void supprimer(int id)
	{
		dao.deleteById(id);
	}
	
	public void modifier(Utilisateur p)
	{
		dao.save(p);
	}
	
	public Utilisateur findByMailAndMdp(String mail, String mdp) {
		return dao.findByMailAndMdp(mail, mdp);
	}
	
	public Utilisateur loadUserBynomUtilisateur (String nomUtilisateur) {
		return dao.findByNomUtilisateur(nomUtilisateur);
	}

	@Override
	public Utilisateur loadUserByEmail(String email) {
		
		return dao.findByMail(email);
	}
	
	
}
