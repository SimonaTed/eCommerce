package it.eCommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import it.eCommerce.dto.OrdineProdottoDTO;
import it.eCommerce.eccezioni.ResourceNotFoundException;
import it.eCommerce.entity.Ordine;
import it.eCommerce.entity.OrdineProdotto;
import it.eCommerce.entity.OrdineStato;
import it.eCommerce.entity.Prodotto;
import it.eCommerce.service.ServiceCarelloRicerca;

@RestController
public class ControllerCarello {
	
	@Autowired
	private ServiceCarelloRicerca serviceEccomerce;
	
	@PostMapping("/ecommerceTotale")
	public ResponseEntity<Ordine> create(@RequestBody OrderForm form) {
			List<OrdineProdottoDTO> formDtos = form.getProductOrders();
	        validateProductsExistence(formDtos);
	        Ordine order = new Ordine();
	        order.setStatus(OrdineStato.Pagato.name());
	        order = this.serviceEccomerce.create(order);

	        List<OrdineProdotto> orderProducts = new ArrayList<>();
	        for (OrdineProdottoDTO dto : formDtos) {
	        	if(formDtos.contains(dto)) {
	            orderProducts.add( serviceEccomerce.create(new OrdineProdotto(order,  serviceEccomerce.getProdottoService(dto
	              .getProdotto()
	              .getIdProdotto()), dto.getQuantita())));
	        }
	        	}

	        order.setOrdiniProdotti(orderProducts);

	        this.serviceEccomerce.update(order);

	        String uri = ServletUriComponentsBuilder
	          .fromCurrentServletMapping()
	          .path("/orders/{id}")
	          .buildAndExpand(order.getId())
	          .toString();
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Location", uri);

	        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}
	


	@GetMapping("/ecommerceTotale")
	public ResponseEntity<List<Prodotto>> search(@RequestParam("nome") String nome) {
	    List<Prodotto> risultati = serviceEccomerce.findByNomeRicerca(nome);
	    return ResponseEntity.ok().body(risultati);
	}
		
	
	 private void validateProductsExistence(List<OrdineProdottoDTO> orderProducts) {
	        List<OrdineProdottoDTO> list = orderProducts
	          .stream()
	          .filter(op -> Objects.isNull(serviceEccomerce.getProdottoService(op
	            .getProdotto()
	            .getIdProdotto())))
	          .collect(Collectors.toList());

	        if (!CollectionUtils.isEmpty(list)) {
	            new ResourceNotFoundException("Product not found");
	        }
	    }
	
	 /*Prodotto p=new Prodotto((long) 4,"query",1.85,"pathprova","query per ricerca");
	 OrderForm f=new OrderForm(p,2);*/
	 
	
	  public static class OrderForm {
		  

	        private List<OrdineProdottoDTO> productOrders;

	       /* public OrderForm(Prodotto p, int i) {
	        	
	        }*/
	        
			public List<OrdineProdottoDTO> getProductOrders() {
	            return productOrders;
	        }

	        public void setProductOrders(List<OrdineProdottoDTO> productOrders) {
	            this.productOrders = productOrders;
	        }
	        
	       
	    }
	
	

	
}
