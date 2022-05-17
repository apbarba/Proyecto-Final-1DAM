package com.salesianostriana.dam.banda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.banda.model.Usuarios.Usuario;
import com.salesianostriana.dam.banda.repository.UsuariosRepository;

@Controller
public class AdminController {

	@Autowired
	private UsuariosRepository usuarioRepo;
	
    @GetMapping("/admin")
    public String adminIndex(Model model, @AuthenticationPrincipal UserDetails user) {
       
        //model.addAttribute("usuario", user.getUsername());
//    	Optional<Usuario> elUsuario = usuarioRepo.findUserByUsername(user.getUsername());
    	
        return "indexAdmin";
    }
}
