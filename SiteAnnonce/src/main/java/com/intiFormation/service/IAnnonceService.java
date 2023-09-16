package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Annonce;

public interface IAnnonceService {
	
	public List<Annonce> afficherAll();
	
	public Annonce afficherParId(int id);
	
	public void ajouter(Annonce a);
	
	public void supprimer(int id);
	
	public void modifier(Annonce a);
	
}
