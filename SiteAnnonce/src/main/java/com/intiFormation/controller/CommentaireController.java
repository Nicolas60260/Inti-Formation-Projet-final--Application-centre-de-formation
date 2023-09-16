package com.intiFormation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IAnnonceService;
import com.intiFormation.service.ICommentaireService;

@Controller
public class CommentaireController {
	
	@Autowired
	ICommentaireService service;
	
	@Autowired
	IAnnonceService serviceAnnonce;
	
	@RequestMapping("/ajoutterUnCommentaireToutesLesAnnonces")
	public String ajoutterUnCommentaireToutesLesAnnonces(HttpSession session,Model model,@RequestParam("id") int idAnnonce)
	{
		
		Utilisateur u = (Utilisateur)session.getAttribute("utilisateur");
		
		if(u!=null) {
			List<Annonce> annonces=serviceAnnonce.afficherAll();
			model.addAttribute("annonces", annonces);
			
			Boolean bol = true;
			model.addAttribute("bol", bol);
			
			Boolean enregistre = false;
			model.addAttribute("enregistre", enregistre);
			
			Commentaire c = new Commentaire();
			model.addAttribute("c", c);
			
			model.addAttribute("idAnnonce", idAnnonce);
			
			return "jspToutesLesAnnonces";
		}else {
			List<Annonce> annonces=serviceAnnonce.afficherAll();
			model.addAttribute("annonces", annonces);
			
			Boolean bol = false;
			model.addAttribute("bol", bol);
			
			Commentaire c = new Commentaire();
			model.addAttribute("c", c);
			
			Boolean enregistre = true;
			model.addAttribute("enregistre", enregistre);
			
			return "jspToutesLesAnnonces";
		}
		
		
	}
	
	@RequestMapping("/enregistrerCommentaireToutesLesAnnonces")
	public String enregistrerCommentaireToutesLesAnnonces(@ModelAttribute("c") Commentaire c,HttpSession session,Model model,@RequestParam("idAnnonce") int idAnnonce)
	{
		Utilisateur u = (Utilisateur)session.getAttribute("utilisateur");
		c.setUtilisateur(u);
		Annonce annonce = serviceAnnonce.afficherParId(idAnnonce);
		c.setAnnonce(annonce);
		service.ajouter(c);
		
		
		//annonce.getListeCommentaire().add(c);
		
		//------------------------------Affichage-----------------------------------//
		List<Annonce> annonces=serviceAnnonce.afficherAll();
		model.addAttribute("annonces", annonces);
		
		Boolean bol = false;
		model.addAttribute("bol", bol);
		
		Boolean enregistre = false;
		model.addAttribute("enregistre", enregistre);
		
		Commentaire com = new Commentaire();
		model.addAttribute("c", com);
		//------------------------------Fin Affichage-----------------------------------//
		
		return "jspToutesLesAnnonces";
	}
}
