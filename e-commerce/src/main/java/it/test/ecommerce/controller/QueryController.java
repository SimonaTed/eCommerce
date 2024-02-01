package it.test.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.test.ecommerce.entity.QueryEntity;
import it.test.ecommerce.service.ServiceECommerce;

@RestController
public class QueryController {
	
	@Autowired
	ServiceECommerce service;
	
	/*
	@GetMapping("/ecommerce/{sigla}")
	public List<QueryEntity> findbySigla(@PathVariable("sigla") String sigla){
		return service.findQuerybySigla(sigla); 
	}
	
	
	@GetMapping("/ecommerceTotale")
	public ResponseEntity<List<Object>> search(@RequestParam("sigla") String sigla) {
	    List<Object> risultati = service.trovati(sigla);
	    return ResponseEntity.ok().body(risultati);
	}*/


	
	@GetMapping("/ricerca")
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView("ricerca");
		mv.addObject("allItems");
		return mv;
	}
	
	@GetMapping("/elenco-risultati/{sigla}")
	public ModelAndView elencoQuery(@PathVariable String sigla) {
		ModelAndView mv = new ModelAndView("elenco-risultati");
		List<Object> trovati=service.trovatiBySigla(sigla);
		mv.addObject("trovati", trovati);
		return mv;
	}
	
}
