package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;

public interface IAnnonceDao extends JpaRepository <Annonce,Integer>{
	/*
	@Query("select a.categorie from Annonce a where a.id=:idaanonce ")
	public Categorie chercherParIdAnnonce(@Param("idaanonce") int idaanonce);*/
	
	
}
