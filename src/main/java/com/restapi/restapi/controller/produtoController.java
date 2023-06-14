package com.restapi.restapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.restapi.restapi.model.Produto;
import com.restapi.restapi.repository.ProdutoRepository;



@Controller
public class produtoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	
	@GetMapping("/produto")
	public String home() {
		return "cadastrarProdutos.html";
	}
	
	@PostMapping("/produto")
	public String create (Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/listarProdutos";
	}
	
	
	
	@GetMapping("/listarProdutos")
	public ModelAndView listar() {
		List<Produto> produtos = produtoRepository.findAll();
		Long valoresSomados = produtoRepository.somarValores();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarProdutos");
		mv.addObject("produtos", produtos);
		mv.addObject("valores", valoresSomados);
		return mv;
	}
	
	@GetMapping("/deletarProduto/{id}")
	public String deletar (Produto produto, @PathVariable(name = "id") Long id) {
		produtoRepository.deleteById(id);
		return "redirect:/listarProdutos";
		
	}
	@GetMapping("/editarProduto/{id}")
	public ModelAndView listarEdicao (Produto produto, @PathVariable(name = "id") Long id) {
		Produto produtoEdicao = produtoRepository.findById(id).get();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarProdutos");
		mv.addObject("produto",produtoEdicao);
		return mv;
		
	}
	
	@PostMapping("/produtoEditar")
	public String update (Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/listarProdutos";
	}
	
}
