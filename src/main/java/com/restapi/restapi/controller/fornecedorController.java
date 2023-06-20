package com.restapi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restapi.restapi.model.Fornecedor;
import com.restapi.restapi.repository.FornecedorRepository;



@Controller
public class fornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	
	@GetMapping("/fornecedor")
	public String home() {
		return "cadastrarFornecedor.html";
	}
	
	@PostMapping("/fornecedor")
	public String create (Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return "redirect:/listarFornecedor";
	}
	
	@GetMapping("/listarFornecedor")
	public ModelAndView listar() {
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarFornecedor");
		mv.addObject("fornecedor", fornecedores);
		return mv;
	}
	
	@GetMapping("/deletarFornecedor/{id}")
	public String deletar (Fornecedor fornecedor, @PathVariable(name = "id") Long id) {
		fornecedorRepository.deleteById(id);
		return "redirect:/listarFornecedor";
		
	}
	@GetMapping("/editarFornecedor/{id}")
	public ModelAndView listarEdicao (Fornecedor fornecedor, @PathVariable(name = "id") Long id) {
		Fornecedor fornecedorEdicao = fornecedorRepository.findById(id).get();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarFornecedor");
		mv.addObject("fornecedor",fornecedorEdicao);
		return mv;
		
	}
	
	@PostMapping("/fornecedorEditar")
	public String update (Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return "redirect:/listarFornecedor";
	}
	
}