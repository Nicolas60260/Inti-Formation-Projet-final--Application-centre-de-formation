package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IAnnonceDao;
import com.intiFormation.entity.Annonce;

@Service
public class AnnonceService implements IAnnonceService{
	
	@Autowired
	IAnnonceDao dao;
	
	public List<Annonce> afficherAll()
	{
		return dao.findAll();
	}
	
	public Annonce afficherParId(int id)
	{
		return dao.findById(id).get();
	}
	
	public void ajouter(Annonce a)
	{
		dao.save(a);
	}
	
	public void supprimer(int id)
	{
		dao.deleteById(id);
	}
	
	public void modifier(Annonce p)
	{
		dao.save(p);
	}
	
	
}
