package com.sitio.mvc.web.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sitio.mvc.domain.Gado;
import com.sitio.mvc.domain.Vacasp;
import com.sitio.mvc.service.GadoService;
import com.sitio.mvc.service.VacaspService;

@Controller
@RequestMapping("/gado")
public class GadoController {
	
	@Autowired
	private GadoService gadoService;
	@Autowired
	private VacaspService vacaspService;

	@GetMapping("/cadastrar")
	public String cadastrar(Gado gado) {
		return "gado/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("gado", gadoService.buscarTodos());
		return "gado/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Gado gado, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "gado/cadastro";
		}
		
		gadoService.salvar(gado);
		attr.addFlashAttribute("success", "Gado inserido com sucesso.");
		return "redirect:/gado/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("gado", gadoService.buscarPorId(id));
		return "gado/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Gado gado, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "gado/cadastro";
		}	
		
		gadoService.editar(gado);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/gado/cadastrar";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		gadoService.excluir(id);
		attr.addFlashAttribute("success", "Gado removido com sucesso.");
		return "redirect:/gado/listar";
	}	
	
	@ModelAttribute("vacasp")
	public List<Vacasp> listaDeDepartamentos() {
		return vacaspService.buscarTodos();
	}	
}
