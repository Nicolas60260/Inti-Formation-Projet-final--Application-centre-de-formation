package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;

public interface ICategorieDao extends JpaRepository <Categorie,Integer>{
	
	
	@Query("from Categorie c where c.id=:n")
	public Categorie searchByIdAnnonce(@Param("n") int idAnnonce);
	
}
