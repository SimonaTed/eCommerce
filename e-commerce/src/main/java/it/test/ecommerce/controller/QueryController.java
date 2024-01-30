package it.test.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.test.ecommerce.entity.QueryEntity;
import it.test.ecommerce.service.ServiceECommerce;

@RestController
public class QueryController {
	
	@Autowired
	ServiceECommerce service;
	
	
	@GetMapping("/ecommerce/{sigla}")
	public List<QueryEntity> findbySigla(@PathVariable("sigla") String sigla){
		return service.findQuerybySigla(sigla); 
	}
	
	
	@GetMapping("/ecommerceTotale/{sigla}")
	public  ResponseEntity<List<Object>> search(@PathVariable("sigla") String sigla){
		 List<Object> risultati=service.trovati(sigla);
		 return ResponseEntity.ok().body(risultati);
	}
	
}
