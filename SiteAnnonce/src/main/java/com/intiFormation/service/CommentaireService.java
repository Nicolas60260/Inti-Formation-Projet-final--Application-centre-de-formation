package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.ICommentaireDao;
import com.intiFormation.entity.Commentaire;

@Service
public class CommentaireService implements ICommentaireService{
	//injection Par type
			@Autowired
			ICommentaireDao dao;
			
			public List<Commentaire> afficherAll()
			{
				return dao.findAll();
			}
			
			public Commentaire afficherParId(int id)
			{
				return dao.findById(id).get();
			}
			
			public void ajouter(Commentaire p)
			{
				
				dao.save(p);
			}
			
			public void supprimer(int id)
			{
				dao.deleteById(id);
			}
			
			public void modifier(Commentaire p)
			{
				dao.save(p);
			}
			
}
