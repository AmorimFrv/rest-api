package com.restapi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restapi.restapi.model.Usuario;
import com.restapi.restapi.repository.UsuarioRepository;



@Controller
public class usuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@GetMapping("/usuario")
	public String home() {
		return "cadastrarUsuario.html";
	}
	
	@PostMapping("/usuario")
	public String create (Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/listarUsuario";
	}
	
	@GetMapping("/listarUsuario")
	public ModelAndView listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarUsuario");
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@GetMapping("/deletarUsuario/{id}")
	public String deletar (Usuario usuario, @PathVariable(name = "id") Long id) {
		usuarioRepository.deleteById(id);
		return "redirect:/listarUsuario";
		
	}
	@GetMapping("/editarUsuario/{id}")
	public ModelAndView listarEdicao (Usuario usuario, @PathVariable(name = "id") Long id) {
		Usuario usuarioEdicao = usuarioRepository.findById(id).get();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarUsuario");
		mv.addObject("usuario",usuarioEdicao);
		return mv;
		
	}
	
	@PostMapping("/usuarioEditar")
	public String update (Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/listarUsuario";
	}
	
}
