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

import com.sitio.mvc.domain.Fazenda;
import com.sitio.mvc.service.FazendaService;


@Controller
@RequestMapping("/fazenda")
public class FazendaController {
	
	@Autowired
	private FazendaService fazendaService;

	@GetMapping("/cadastrar")
	public String cadastrar(Fazenda fazenda) {
		return "fazenda/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("fazenda", fazendaService.buscarTodos());
		return "fazenda/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Fazenda fazenda, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "fazenda/cadastro";
		}
		
		fazendaService.salvar(fazenda);
		attr.addFlashAttribute("success", "Fazenda inserido com sucesso.");
		return "redirect:/fazenda/cadastrar";
	}
	
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("fazenda", fazendaService.buscarPorId(id));
		return "fazenda/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Fazenda fazenda, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "fazenda/cadastro";
		}	
		
		fazendaService.editar(fazenda);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/fazenda/cadastrar";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		fazendaService.excluir(id);
		attr.addFlashAttribute("success", "Fazenda removido com sucesso.");
		return "redirect:/fazenda/listar";
	}	
	
}
