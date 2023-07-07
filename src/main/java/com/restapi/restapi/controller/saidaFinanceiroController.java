package com.restapi.restapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.restapi.restapi.model.SaidaFinanceiro;

import com.restapi.restapi.repository.SaidaFinanceiroRepository;




@Controller
public class saidaFinanceiroController {
	
	@Autowired
	private SaidaFinanceiroRepository saidaFinanceiroRepository;
	
	@GetMapping("/saidaFinanceiro")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastrarSaidaFinanceiro");
		return mv;
	}
	
	@PostMapping("/saidaFinanceiro")
	public String create (SaidaFinanceiro saidaFinanceiro) {
		saidaFinanceiroRepository.save(saidaFinanceiro);
		return "redirect:/listarSaidaFinanceiro";
	}
	
	
	
	@GetMapping("/listarSaidaFinanceiro")
	public ModelAndView listar() {
		List<SaidaFinanceiro>	saidasFinanceiro = saidaFinanceiroRepository.findAll();
		//Long valoresSomados = entradaFinanceiroRepository.somarValores();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarSaidaFinanceiro");
		mv.addObject("saidasFinanceiro", saidasFinanceiro);
		//mv.addObject("valores", valoresSomados);
		return mv;
	}
	
	@GetMapping("/deletarSaidaFinanceiro/{id}")
	public String deletar (SaidaFinanceiro saidaFinanceiro, @PathVariable(name = "id") Long id) {
		saidaFinanceiroRepository.deleteById(id);
		return "redirect:/listarSaidaFinanceiro";
		
	}
	@GetMapping("/editarSaidaFinanceiro/{id}")
	public ModelAndView listarEdicao (SaidaFinanceiro saidaFinanceiro, @PathVariable(name = "id") Long id) {
		SaidaFinanceiro saidaFinanceiroEdicao = saidaFinanceiroRepository.findById(id).get();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarSaidaFinanceiro");
		mv.addObject("saidaFinanceiro",saidaFinanceiroEdicao);
		return mv;
		
	}
	
	@PostMapping("/saidaEditarFinanceiro")
	public String update (SaidaFinanceiro saidaFinanceiro) {
		saidaFinanceiroRepository.save(saidaFinanceiro);
		return "redirect:/listarSaidaFinanceiro";
	}
	
}

