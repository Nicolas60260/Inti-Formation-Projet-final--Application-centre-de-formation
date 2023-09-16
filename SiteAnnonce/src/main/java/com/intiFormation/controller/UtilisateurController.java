package com.intiFormation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IUtilisateurService;

@Controller
public class UtilisateurController {
	//injection par type
	@Autowired
	IUtilisateurService service;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/afficherPageIdentification")
	public String afficherPageIdentification(Model model)
	{
		Utilisateur utilisateur = new Utilisateur ();
		model.addAttribute("utilisateur", utilisateur);
		
		Boolean bol = false;
		
		model.addAttribute("bol", bol);
		
		return "jspAuthentification";
	}
	
	
	@RequestMapping("/authentificationUtilisateur")
	public String authentificationUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur,Model model)
	{
		
		Utilisateur u = service.findByMailAndMdp(utilisateur.getMail(), utilisateur.getMdp());
		System.out.println(u);
		if(u!=null) {
			session.setAttribute("utilisateur", u);
			return "jspPageAccueil";
		}else {
			Utilisateur utili = new Utilisateur ();
			model.addAttribute("utilisateur", utili);
			
			Boolean bol = true;
			model.addAttribute("bol", bol);
			return "jspAuthentification";
		}
		
		
	}
	
	@RequestMapping("/afficherPageInscription")
	public String afficherPageInscription(Model model)
	{
		Utilisateur utilisateur = new Utilisateur ();
		model.addAttribute("utilisateur", utilisateur);
		
		return "jspInscription";
	}
	
	@RequestMapping("/enregistrerUtilisateur")
	public String enregistrerUtilisateur(@ModelAttribute("utilisateur") Utilisateur utilisateur,Model model)
	{
		service.ajouter(utilisateur);
		
		return "redirect:/afficherPageIdentification";
	}
	
	
	
}
