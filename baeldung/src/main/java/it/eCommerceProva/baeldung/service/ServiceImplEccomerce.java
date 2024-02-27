package it.eCommerceProva.baeldung.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eCommerceProva.baeldung.eccezioni.ResourceNotFoundException;
import it.eCommerceProva.baeldung.entity.Ordine;
import it.eCommerceProva.baeldung.entity.OrdineProdotto;
import it.eCommerceProva.baeldung.entity.Prodotto;
import it.eCommerceProva.baeldung.repository.OrdineProdottoRepository;
import it.eCommerceProva.baeldung.repository.OrdineRepository;
import it.eCommerceProva.baeldung.repository.ProdottoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceImplEccomerce implements ServiceEcommerce{

	
		@Autowired
		private OrdineRepository ordineRepository;
		
		@Autowired
		private ProdottoRepository prodottoRepository;
		
		@Autowired
		private OrdineProdottoRepository ordineProdottoRepository;
		
		
		@Override
		public List<Prodotto> findByNomeRicerca(String nome){
			return this.prodottoRepository.findAllBynomeContainingIgnoreCase(nome);
		}

	    @Override
	    public Iterable<Ordine> getAllOrders() {
	        return this.ordineRepository.findAll();
	    }
		
	    @Override
	    public Ordine create(Ordine ordine) {
	        ordine.setDataCreazione(LocalDate.now());
	        return this.ordineRepository.save(ordine);
	    }

	    @Override
	    public void update(Ordine ordine) {
	        this.ordineRepository.save(ordine);
	    }
	    
	    @Override
	    public OrdineProdotto create(OrdineProdotto ordineProdotto) {
	        return this.ordineProdottoRepository.save(ordineProdotto);
	    }

	    @Override
	    public Prodotto getProdottoService(long id) {
	        return prodottoRepository
	          .findById(id)
	          .orElseThrow(() -> new ResourceNotFoundException("Prodotto non trovato"));
	    }
}
