package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;

@Service
public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	IUtilisateurService iUtilisateurService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur u = iUtilisateurService.loadUserByEmail(username);
		
		if(u == null)
		{
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> authorities=getGrantedAuthority(u);
		
		return new org.springframework.security.core.userdetails.User(u.getMail(),u.getMdp(),authorities);
	}
	
	private List <GrantedAuthority> getGrantedAuthority(Utilisateur u){
		List<GrantedAuthority> liste= new ArrayList<>();
		Role role = u.getRole();
//		for(Role r:roles)
//		{
//			liste.add(new SimpleGrantedAuthority(r.getRoleName()));
//		}
		liste.add(new SimpleGrantedAuthority(role.getNomRole()));
		return liste;
	}

}
