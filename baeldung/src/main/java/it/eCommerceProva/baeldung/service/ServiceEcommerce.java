package it.eCommerceProva.baeldung.service;

import java.util.List;

import it.eCommerceProva.baeldung.entity.Ordine;
import it.eCommerceProva.baeldung.entity.OrdineProdotto;
import it.eCommerceProva.baeldung.entity.Prodotto;

public interface ServiceEcommerce {

	Ordine create(Ordine ordine);

	Iterable<Ordine> getAllOrders();

	void update(Ordine ordine);

	List<Prodotto> findByNomeRicerca(String nome);

	OrdineProdotto create(OrdineProdotto ordineProdotto);

	Prodotto getProdottoService(long id);

	

}
