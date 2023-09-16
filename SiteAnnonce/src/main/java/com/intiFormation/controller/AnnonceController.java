package com.intiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IAnnonceService;
import com.intiFormation.service.ICategorieService;
import com.intiFormation.service.IUtilisateurService;

@Controller
public class AnnonceController {
	//injection par type
			@Autowired
			IAnnonceService service;
			@Autowired
			ICategorieService service2;
			@Autowired
			IUtilisateurService service3;
			
			//----------------------------------------------Partie Admin-------------------------------------------------------//
			
			@RequestMapping("/afficherAnnonces")
			public String afficherPersonnes(Model model)
			{
				System.out.println("--------------------------------------Test");
				
				Utilisateur utilisateur = new Utilisateur();
				model.addAttribute("utilisateur", utilisateur);
				
				List <Utilisateur> utilisateurs =service3.afficherAll();
				model.addAttribute("utilisateurs", utilisateurs);
				
				Annonce a = new Annonce();
				model.addAttribute("a", a);
				
				Categorie c = new Categorie();
				model.addAttribute("categorie", c);
				
				List<Annonce> annonces=service.afficherAll();
				model.addAttribute("annonces", annonces);
				
				List<Categorie> categories=service2.afficherAll();
				model.addAttribute("categories", categories);
				
				return "jspAnnonce2";
			}
			
			@RequestMapping("/saveAnnonce")
			public String savePersonne(@ModelAttribute("a") Annonce a,@RequestParam("file") MultipartFile file,HttpSession session)
			{
				String path=session.getServletContext().getRealPath("/"); 
				String filename= file.getOriginalFilename();
				a.setImage("/dossierimage/"+filename);
				service.ajouter(a);
				
				try{  
			        byte barr[]=file.getBytes();  
			          
			        BufferedOutputStream bout=new BufferedOutputStream(  
			                 new FileOutputStream(path+"/dossierimage/"+filename));  
			        bout.write(barr);  
			        bout.flush();  
			        bout.close();  
			          
			        	}catch(Exception e){System.out.println(e);
			        } 
				
				return "redirect:/afficherAnnonces";
			}
			
			@RequestMapping("/SupprimerAnnonce")
			public String supprimer(@RequestParam("id") int id)
			{
				service.supprimer(id);
				return "redirect:/afficherAnnonces";
			}
			
			@RequestMapping("/modifierAnnonce")
			public String modifier(@RequestParam("id") int id,Model model)
			
			{
				Annonce a=service.afficherParId(id);
				model.addAttribute("a", a);
				
				List<Annonce> annonces= service.afficherAll();
				model.addAttribute("annonces", annonces);
				
				List<Categorie> categories= service2.afficherAll();
				model.addAttribute("categories", categories);
				
				return "jspAnnonce";
			}
			
			@RequestMapping("/afficherAnnonceParCat")
			public String afficherAnnonceParCat(@RequestParam("id") int idCat,Model model) {
				
				
			List<Annonce> listeAnnonce =service2.afficherParId(idCat).getListeAnnonce();
			model.addAttribute("listeAnnonce", listeAnnonce);
			
			Annonce a = new Annonce();
			model.addAttribute("a", a);
			
			Categorie c = new Categorie();
			model.addAttribute("categorie", c);
			
			List<Annonce> annonces=service.afficherAll();
			model.addAttribute("annonces", annonces);
			
			List<Categorie> categories=service2.afficherAll();
			model.addAttribute("categories", categories);
			
			Utilisateur utilisateur = new Utilisateur();
			model.addAttribute("utilisateur", utilisateur);
			List <Utilisateur> utilisateurs =service3.afficherAll();
			model.addAttribute("utilisateurs", utilisateurs);
			
			return "jspAnnonce";
			
			}
			
			@RequestMapping("/afficherAnnonceParUtilisateur")
			public String afficherAnnonceParUtilisateur(@RequestParam("id") int idUtilisateur,Model model) {
				
			System.out.println(idUtilisateur);
				
			List<Annonce> listeAnnonce =service3.afficherParId(idUtilisateur).getListeAnnonce();
			model.addAttribute("listeAnnonceParUtilisateur", listeAnnonce);
			
			System.out.println(listeAnnonce);
			Annonce a = new Annonce();
			model.addAttribute("a", a);
			
			Categorie c = new Categorie();
			model.addAttribute("categorie", c);
			
			List<Annonce> annonces=service.afficherAll();
			model.addAttribute("annonces", annonces);
			
			List<Categorie> categories=service2.afficherAll();
			model.addAttribute("categories", categories);
			
			Utilisateur utilisateur = new Utilisateur();
			model.addAttribute("utilisateur", utilisateur);
			
			List <Utilisateur> utilisateurs =service3.afficherAll();
			model.addAttribute("utilisateurs", utilisateurs);
			
			return "jspAnnonce";
			
			}
			
			//----------------------------------------Partie Visiteur -----------------------------------------//
			
			
			@RequestMapping("/afficherEspacePersonnelAnnonce")
			public String savePersonne(HttpSession session,Model model)
			{
				Utilisateur u=(Utilisateur)session.getAttribute("utilisateur");
				int id = u.getId();
				
				List<Annonce> listeAnnonces = service.afficherAll();
				
				List <Annonce> ListeAnnoncesUtilisateur = new ArrayList <Annonce>();
				
				for(Annonce a:listeAnnonces) {
					if(a.getUtilisateur()!=null && a.getUtilisateur().getId()==id) {
						ListeAnnoncesUtilisateur.add(a);
					}
				}
				model.addAttribute("annonces",ListeAnnoncesUtilisateur);
				
				List<Categorie> categories=service2.afficherAll();
				model.addAttribute("categories", categories);
				
				Annonce annonce = new Annonce();
				model.addAttribute("a", annonce);
				
				
				return "jspEspacePersonnelAnnonce";
			}
			
			@RequestMapping("/enregistrerAnnonceEspacePersonnel")
			public String enregistrerAnnonceEspacePersonnel(@ModelAttribute("a") Annonce annonce,HttpSession session,Model model,@RequestParam("file") MultipartFile file)
			{
				Utilisateur u=(Utilisateur)session.getAttribute("utilisateur");
				annonce.setUtilisateur(u);
				
				String path=session.getServletContext().getRealPath("/"); 
				String filename= file.getOriginalFilename();
				annonce.setImage("/dossierimage/"+filename);
				
				try{  
			        byte barr[]=file.getBytes();  
			          
			        BufferedOutputStream bout=new BufferedOutputStream(  
			                 new FileOutputStream(path+"/dossierimage/"+filename));  
			        bout.write(barr);  
			        bout.flush();  
			        bout.close();  
			          
			        	}catch(Exception e){System.out.println(e);
			        }
				service.ajouter(annonce);
				
				// -----------------------------------------Partie Affichage----------------------------------------------------------
				
				int id = u.getId();
				
				List<Annonce> listeAnnonces = service.afficherAll();
				
				List <Annonce> ListeAnnoncesUtilisateur = new ArrayList <Annonce>();
				
				for(Annonce a:listeAnnonces) {
					if(a.getUtilisateur()!=null && a.getUtilisateur().getId()==id) {
						ListeAnnoncesUtilisateur.add(a);
					}
				}
				model.addAttribute("annonces",ListeAnnoncesUtilisateur);
				
				List<Categorie> categories=service2.afficherAll();
				model.addAttribute("categories", categories);
				
				Annonce annonce2 = new Annonce();
				model.addAttribute("a", annonce2);
				
				//--------------------------------------Fin partie Affichage --------------------------------------------------------
				
				return "jspEspacePersonnelAnnonce";
			}
			
			@RequestMapping("/afficherVisiteursToutesLesAnnonces")
			public String VisiteursToutesLesAnnonces(HttpSession session,Model model)
			{
				Boolean bol = false;
				model.addAttribute("bol", bol);
				
				List<Annonce> annonces=service.afficherAll();
				model.addAttribute("annonces", annonces);
				
				
				return "jspToutesLesAnnonces";
			}
			
			
}
