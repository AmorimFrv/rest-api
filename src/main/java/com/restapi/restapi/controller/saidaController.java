package com.restapi.restapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.restapi.restapi.model.Saida;
import com.restapi.restapi.model.Produto;
import com.restapi.restapi.repository.SaidaRepository;
import com.restapi.restapi.repository.ProdutoRepository;



@Controller
public class saidaController {
	
	@Autowired
	private SaidaRepository saidaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	
	@GetMapping("/saida")
	public ModelAndView home() {
		List<Produto> produtos = produtoRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastrarSaida");
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@PostMapping("/saida")
	public String create (Saida saida) {
		saidaRepository.save(saida);
		return "redirect:/listarSaida";
	}
	
	
	
	@GetMapping("/listarSaida")
	public ModelAndView listar() {
		List<Saida> saidas = saidaRepository.findAll();
		//Long valoresSomados = saidaRepository.somarValores();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarSaida");
		mv.addObject("saidas", saidas);
		//mv.addObject("valores", valoresSomados);
		return mv;
	}
	
	@GetMapping("/deletarSaida/{id}")
	public String deletar (Saida saida, @PathVariable(name = "id") Long id) {
		saidaRepository.deleteById(id);
		return "redirect:/listarSaida";
		
	}
	@GetMapping("/editarSaida/{id}")
	public ModelAndView listarEdicao (Saida saida, @PathVariable(name = "id") Long id) {
		Saida saidaEdicao = saidaRepository.findById(id).get();
		List<Produto> produtos = produtoRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarSaida");
		mv.addObject("saida",saidaEdicao);
		mv.addObject("produto", produtos);
		return mv;
		
	}
	
	@PostMapping("/saidaEditar")
	public String update (Saida saida) {
		saidaRepository.save(saida);
		return "redirect:/listarSaida";
	}
	
}

