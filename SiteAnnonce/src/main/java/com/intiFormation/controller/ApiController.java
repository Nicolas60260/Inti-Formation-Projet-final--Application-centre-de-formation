package com.intiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.config.AuthentificationRequest;
import com.intiFormation.config.AuthentificationResponse;
import com.intiFormation.config.jwtUtil;
import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IAnnonceService;
import com.intiFormation.service.ICategorieService;
import com.intiFormation.service.IUtilisateurService;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin("http://localhost:4200")
public class ApiController {
	
	/*-----------------------Utilisateur--------------------------*/
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private UserDetailsService custemUserDetailsService;
	
	
	@Autowired
	private jwtUtil jwtokenUtil;
	
	@Autowired
	IUtilisateurService iUtilisateurService;
	
	@Autowired
	IAnnonceService iAnnonceService;
	
	@Autowired
	ICategorieService iCategorieService;
	
	@GetMapping(path = "/admin/listUsers")
	public List<Utilisateur> listeUtilisateur(){
		return iUtilisateurService.afficherAll();
	}
	
	@GetMapping(path = "/admin/person/{id}")
	public Utilisateur PersonneById(@PathVariable("id") int  id){
		return iUtilisateurService.afficherParId(id);
	}
	
	@PostMapping(path = "/admin/addNewUser")
	public void SaveUser(@RequestBody Utilisateur personne) {
		iUtilisateurService.ajouter(personne);
	}
	
	@PostMapping(path = "/admin/modifyUser")
	public void ModifyUser(@RequestBody Utilisateur personne) {
		iUtilisateurService.modifier(personne);
	}
	
	@DeleteMapping("/admin/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") int  id) {
		System.out.println("test");
		iUtilisateurService.supprimer(id);
	}
	
	/*-----------------------Annonces--------------------------*/
	
	
	@GetMapping(path = "/public/listAnnonce")
	public List<Annonce> listeAnnonce(){
		return iAnnonceService.afficherAll();
	}
	
	@PostMapping(path = "/public/AjoutAnnonce")
	public void ajoutAnnonce(@RequestBody Annonce annonce){
		iAnnonceService.ajouter(annonce);
	}
	
	@PostMapping(path = "/public/AjoutAnnonce2")
	public void ajoutAnnonce2(@RequestParam("titre") String titre,@RequestParam("description") String description,@RequestParam("image") MultipartFile fichier,@RequestParam("datePublication") Date datePublication,@RequestParam("dateExpiration") Date dateExpiration,@RequestParam("statut") Boolean statut,@RequestParam("idutilisateur") int idutilisateur,@RequestParam("idcategorie") int idcategorie,HttpSession session){
		
		Utilisateur utilisateur = iUtilisateurService.afficherParId(idutilisateur);
		Categorie categorie = iCategorieService.afficherParId(idcategorie);
		
		Annonce annonce = new Annonce(titre,description,datePublication,dateExpiration,statut,utilisateur,categorie);
		
		String path = session.getServletContext().getRealPath("/"); 
		String filename= fichier.getOriginalFilename();
		annonce.setImage("/dossierimage/"+filename);
		
		try{  
	        byte barr[]=fichier.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/dossierimage/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        	}catch(Exception e){
	        		System.out.println(e);
	        } 
		
		iAnnonceService.ajouter(annonce);
	}
	
	@DeleteMapping("/admin/deleteAnnonce/{id}")
	public void deleteAnnonce(@PathVariable("id") int  id) {
		
		iAnnonceService.supprimer(id);
	}
	/*-----------------------Catégorie--------------------------*/
	
	@GetMapping(path = "/public/listCategories")
	public List<Categorie> listeCategorie(){
		return iCategorieService.afficherAll();
	}
	
	@GetMapping(path = "/public/categorie/{id}")
	public Categorie UneCategorie(@PathVariable("id") int  id){
		return iCategorieService.afficherParId(id);
	}
	
	@GetMapping(path = "/public/queryAnnonce/{id}")
	public Categorie queryAnnonce(@PathVariable("id") int  idAnnonce){
		
		Annonce annonce = iAnnonceService.afficherParId(idAnnonce);
		Categorie categorie = iCategorieService.afficherParId(annonce.getCategorie().getId());
		return categorie;
	}
	
	
	
	
	
	@RequestMapping(value="/loginUserJwt" ,method =RequestMethod.POST)
	public AuthentificationResponse authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {
			System.out.println("-----------------------------------------------");
			System.out.println(authentificationRequest.getUsername());
			System.out.println(authentificationRequest.getPassword());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("incorrect username ou password",e);
		}
		
		final UserDetails userdetails=custemUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		
		return new AuthentificationResponse(jwt);
	}
}
