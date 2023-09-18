package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICategorieDao;
import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;

@Service
public class CategorieService implements ICategorieService{
	//injection Par type
		@Autowired
		ICategorieDao dao;
		
		public List<Categorie> afficherAll()
		{
			return dao.findAll();
		}
		
		public Categorie afficherParId(int id)
		{
			return dao.findById(id).get();
		}
		
		public void ajouter(Categorie p)
		{
			
			dao.save(p);
		}
		
		public void supprimer(int id)
		{
			dao.deleteById(id);
		}
		
		public void modifier(Categorie p)
		{
			dao.save(p);
		}
		
		public List<Annonce> annonceParNomCat(int id){
			return null;
		}

}
