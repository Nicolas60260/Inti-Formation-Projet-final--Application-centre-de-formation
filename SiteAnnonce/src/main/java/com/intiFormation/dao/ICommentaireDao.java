package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commentaire;


public interface ICommentaireDao extends JpaRepository <Commentaire,Integer>{

}
