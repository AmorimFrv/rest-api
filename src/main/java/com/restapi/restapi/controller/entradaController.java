package com.restapi.restapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.restapi.restapi.model.Entrada;
import com.restapi.restapi.model.Produto;
import com.restapi.restapi.repository.EntradaRepository;
import com.restapi.restapi.repository.ProdutoRepository;



@Controller
public class entradaController {
	
	@Autowired
	private EntradaRepository entradaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	
	@GetMapping("/entrada")
	public ModelAndView home() {
		List<Produto> produtos = produtoRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastrarEntrada");
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@PostMapping("/entrada")
	public String create (Entrada entrada) {
		entradaRepository.save(entrada);
		return "redirect:/listarEntrada";
	}
	
	
	
	@GetMapping("/listarEntrada")
	public ModelAndView listar() {
		List<Entrada> entradas = entradaRepository.findAll();
		//Long valoresSomados = entradaRepository.somarValores();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarEntrada");
		mv.addObject("entradas", entradas);
		//mv.addObject("valores", valoresSomados);
		return mv;
	}
	
	@GetMapping("/deletarEntrada/{id}")
	public String deletar (Entrada entrada, @PathVariable(name = "id") Long id) {
		entradaRepository.deleteById(id);
		return "redirect:/listarEntrada";
		
	}
	@GetMapping("/editarEntrada/{id}")
	public ModelAndView listarEdicao (Entrada entrada, @PathVariable(name = "id") Long id) {
		Entrada entradaEdicao = entradaRepository.findById(id).get();
		List<Produto> produtos = produtoRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarEntrada");
		mv.addObject("entrada",entradaEdicao);
		mv.addObject("produto", produtos);
		return mv;
		
	}
	
	@PostMapping("/entradaEditar")
	public String update (Entrada entrada) {
		entradaRepository.save(entrada);
		return "redirect:/listarEntrada";
	}
	
}

