package com.restapi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.engine.AttributeName;

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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarProdutos");
		mv.addObject("produtos", produtos);
		return mv;
	}
}
