package com.sitio.mvc.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sitio.mvc.domain.Vacasp;
import com.sitio.mvc.service.VacaspService;

@Controller
@RequestMapping("/vacasp")
public class VacaspController {
	
	@Autowired
	private VacaspService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Vacasp vacasp) {
		return "vacasp/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("vacasp", service.buscarTodos());
		return "vacasp/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Vacasp vacasp, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "vacasp/cadastro";
		}
		
		service.salvar(vacasp);
		attr.addFlashAttribute("success", "VacasP inserido com sucesso.");
		return "redirect:/vacasp/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("vacasp", service.buscarPorId(id));
		return "vacasp/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Vacasp vacasp, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "vacasp/cadastro";
		}
		
		service.editar(vacasp);
		attr.addFlashAttribute("success", "VacasP editado com sucesso.");
		return "redirect:/vacasp/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		if (service.vacaspTemGados(id)) {
			model.addAttribute("fail", "VacasP não removido. Possui gado(s) vinculado(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "VacasP excluído com sucesso.");
		}
		
		return listar(model);
	}
	
	
}
