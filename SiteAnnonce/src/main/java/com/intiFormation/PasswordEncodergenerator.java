package com.intiFormation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodergenerator {

	public static final String PASSWORD = "123";
	
	public static void main(String[] args) {
		
		// class qui permet de crypter les mots de passe 
		BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
		
		// cryptage avec la méthode endode()
		String hashedPassword = passwordEncoder.encode(PASSWORD);
		
		System.out.println(hashedPassword);
	}// fin du main
} // fin de la classe
