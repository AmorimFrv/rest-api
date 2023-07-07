package com.restapi.restapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.restapi.restapi.model.EntradaFinanceiro;

import com.restapi.restapi.repository.EntradaFinanceiroRepository;




@Controller
public class entradaFinanceiroController {
	
	@Autowired
	private EntradaFinanceiroRepository entradaFinanceiroRepository;
	
	@GetMapping("/entradaFinanceiro")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastrarEntradaFinanceiro");
		return mv;
	}
	
	@PostMapping("/entradaFinanceiro")
	public String create (EntradaFinanceiro entradaFinanceiro) {
		entradaFinanceiroRepository.save(entradaFinanceiro);
		return "redirect:/listarEntradaFinanceiro";
	}
	
	
	
	@GetMapping("/listarEntradaFinanceiro")
	public ModelAndView listar() {
		List<EntradaFinanceiro> entradasFinanceiro = entradaFinanceiroRepository.findAll();
		//Long valoresSomados = entradaFinanceiroRepository.somarValores();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarEntradaFinanceiro");
		mv.addObject("entradasFinanceiro", entradasFinanceiro);
		//mv.addObject("valores", valoresSomados);
		return mv;
	}
	
	@GetMapping("/deletarEntradaFinanceiro/{id}")
	public String deletar (EntradaFinanceiro entradaFinanceiro, @PathVariable(name = "id") Long id) {
		entradaFinanceiroRepository.deleteById(id);
		return "redirect:/listarEntradaFinanceiro";
		
	}
	@GetMapping("/editarEntradaFinanceiro/{id}")
	public ModelAndView listarEdicao (EntradaFinanceiro entradaFinanceiro, @PathVariable(name = "id") Long id) {
		EntradaFinanceiro entradaFinanceiroEdicao = entradaFinanceiroRepository.findById(id).get();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarEntradaFinanceiro");
		mv.addObject("entradaFinanceiro",entradaFinanceiroEdicao);
		return mv;
		
	}
	
	@PostMapping("/entradaEditarFinanceiro")
	public String update (EntradaFinanceiro entradaFinanceiro) {
		entradaFinanceiroRepository.save(entradaFinanceiro);
		return "redirect:/listarEntradaFinanceiro";
	}
	
}

