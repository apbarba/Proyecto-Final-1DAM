package com.salesianostriana.dam.banda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.banda.model.Usuarios;
import com.salesianostriana.dam.banda.repository.UsuariosRepository;

@Controller
public class AdminController {

	@Autowired
	private UsuariosRepository usuarioRepository;
	
    @GetMapping("/admin")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {
       
    	Optional<Usuarios> usuario = usuarioRepository.findUserByUsername(user.getUsername());
    	
        return "/admin/indexAdmin";
    }
}
