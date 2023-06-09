package com.restapi.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
=======

>>>>>>> fc8912f3244f27f7719ec89e6841a56c83f21a96
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
	
	@PostMapping("/produtoEditar{id}")
	public String update (Produto produto, @PathVariable(name="id") Long id) {
		produtoRepository.findById(id).get();
		produtoRepository.save(produto);
		return "redirect:/listarProdutos";
	}
	
	@GetMapping("/listarProdutos")
	public ModelAndView listar() {
		List<Produto> produtos = produtoRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarProdutos");
		mv.addObject("produtos", produtos);
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
	
}
