package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intiFormation.entity.Categorie;
import com.intiFormation.service.ICategorieService;

@Controller
public class CategorieController {
	//injection par type
		@Autowired
		ICategorieService service;
		
		@RequestMapping("/afficherCategories")
		public String afficherPersonnes(Model model)
		{
			
			Categorie c = new Categorie();
			model.addAttribute("c", c);
			List<Categorie> categories= service.afficherAll();
			System.out.println(categories);
			model.addAttribute("categories", categories);
			return "jspCategorie";
		}
		
		@RequestMapping("/saveCategorie")
		public String savePersonne(@ModelAttribute("c") Categorie c)
		{
			service.ajouter(c);
			return "redirect:/afficherCategories";
		}
		
		@RequestMapping("/SupprimerCategorie")
		public String supprimer(@RequestParam("id") int id)
		{
			service.supprimer(id);
			return "redirect:/afficherCategories";
		}
		
		@RequestMapping("/modifierCategorie")
		public String modifier(@RequestParam("id") int id,Model model)
		{
			Categorie c=service.afficherParId(id);
			model.addAttribute("c", c);
			
			List<Categorie> categories= service.afficherAll();
			model.addAttribute("categories", categories);
			
			return "jspCategorie";
		}
}
