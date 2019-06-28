package com.sitio.mvc.web.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sitio.mvc.domain.Pessoa;
import com.sitio.mvc.domain.UF;
import com.sitio.mvc.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "pessoa/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarTodos());
		return "pessoa/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "pessoa/cadastro";
		}
		
		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("success", "Pessoa inserida com sucesso.");
		return "redirect:/pessoa/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		return "pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "pessoa/cadastro";
		}
		
		pessoaService.editar(pessoa);
		attr.addFlashAttribute("success", "Pessoa editada com sucesso.");
		return "redirect:/pessoa/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pessoaService.excluir(id);
		attr.addFlashAttribute("success", "Pessoa removido com sucesso.");
		return "redirect:/pessoa/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("pessoa", pessoaService.buscarPorNome(nome));
		return "pessoa/lista";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
