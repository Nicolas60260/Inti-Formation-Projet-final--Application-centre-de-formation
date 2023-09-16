package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Commentaire;

public interface ICommentaireService {
	public List<Commentaire> afficherAll();
	public Commentaire afficherParId(int id);
	public void ajouter(Commentaire c);
	public void supprimer(int id);
	public void modifier(Commentaire c);
}
