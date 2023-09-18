package com.intiFormation.service;

import java.util.List;


import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;

public interface ICategorieService {
	public List<Categorie> afficherAll();
	public Categorie afficherParId(int id);
	public void ajouter(Categorie p);
	public void supprimer(int id);
	public void modifier(Categorie p);
	public List<Annonce> annonceParNomCat(int id);
}
