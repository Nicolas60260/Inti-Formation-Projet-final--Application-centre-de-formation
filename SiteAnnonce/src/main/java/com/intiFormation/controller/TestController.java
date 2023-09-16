package com.intiFormation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.AuthentificationOk;

@RestController
@CrossOrigin("http://localhost:4200")
public class TestController {
	
	@GetMapping("/api/testcontroller")
	public AuthentificationOk authentification(){
		return new AuthentificationOk("Utilisateur présent dans la base de donnée");
	}
}


