package com.restapi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restapi.restapi.model.Categoria;
import com.restapi.restapi.repository.CategoriaRepository;



@Controller
public class categoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@GetMapping("/categoria")
	public String home() {
		return "cadastrarCategoria.html";
	}
	
	@PostMapping("/categoria")
	public String create (Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/listarCategoria";
	}
	
	@GetMapping("/listarCategoria")
	public ModelAndView listar() {
		List<Categoria> categorias = categoriaRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarCategoria");
		mv.addObject("categorias", categorias);
		return mv;
	}
}