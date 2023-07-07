package com.restapi.restapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restapi.restapi.model.Usuario;
import com.restapi.restapi.repository.UsuarioRepository;


@Controller
public class loginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
				
	@PostMapping("/listarProdutos")
	public ModelAndView produto (Usuario userParam, String lembrar) {
		Usuario user = this.usuarioRepository.Login(userParam.getNome(), userParam.getSenha());
		if (user != null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("listarProdutos");
			return mv;
	}	
		ModelAndView mv = new ModelAndView("redirect:/login");
		mv.setViewName("login");
		mv.addObject("erro","Usuário ou senha inválidos" );
		return mv;
	}
}
