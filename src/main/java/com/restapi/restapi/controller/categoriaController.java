package com.restapi.restapi.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restapi.restapi.model.Categoria;
import com.restapi.restapi.repository.CategoriaRepository;
import com.restapi.restapi.model.CategoriaLog;
import com.restapi.restapi.repository.CategoriaLogRepository;



@Controller
public class categoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CategoriaLogRepository categoriaLogRepository;

	
	@GetMapping("/categoria")
	public String home() {
		return "cadastrarCategoria.html";
	}
	
	@PostMapping("/categoria")
	public String create (Categoria categoria) {
		//Salvando categoria
		categoriaRepository.save(categoria);
		//Salvando log
		Categoria categoriaEdicao = categoriaRepository.findById(categoria.getId()).get();
		Calendar data = Calendar.getInstance();
		CategoriaLog categoriaLog = new CategoriaLog();
		categoriaLog.setId_Categoria(categoriaEdicao.getId());
		categoriaLog.setOperacao("Insert");
		categoriaLog.setDataAtualizacao(data.getTime().toString());
		categoriaLog.setNome(categoriaEdicao.getNome());
		categoriaLogRepository.save(categoriaLog);
		//Redirecionando
		return "redirect:/listarCategoria";
	}
	
	@GetMapping("/listarCategoria")
	public ModelAndView listar() {
		List<Categoria> categorias = categoriaRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listarCategorias");
		mv.addObject("categorias", categorias);
		for(int i = 0; i< categorias.size(); i++ ) {
			System.out.println(categorias.get(i).getNome()); 
		}
		return mv;
	}
	
	@GetMapping("/deletarCategoria/{id}")
	public String deletar (Categoria categoria, @PathVariable(name = "id") Long id) {
		categoriaRepository.deleteById(id);
		return "redirect:/listarCategoria";
		
	}
	@GetMapping("/editarCategorias/{id}")
	public ModelAndView listarEdicao (Categoria categoria, @PathVariable(name = "id") Long id) {
		Categoria categoriaEdicao = categoriaRepository.findById(id).get();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editarCategorias");
		mv.addObject("categoria",categoriaEdicao);
		return mv;
		
	}
	
	@PostMapping("/categoriaEditar")
	public String update (Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/listarCategoria";
	}
	
}