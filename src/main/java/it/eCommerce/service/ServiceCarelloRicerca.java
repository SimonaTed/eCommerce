package it.eCommerce.service;

import java.util.List;

import it.eCommerce.entity.Ordine;
import it.eCommerce.entity.OrdineProdotto;
import it.eCommerce.entity.Prodotto;

public interface ServiceCarelloRicerca {

	Ordine create(Ordine ordine);

	Iterable<Ordine> getAllOrders();

	void update(Ordine ordine);

	List<Prodotto> findByNomeRicerca(String nome);

	OrdineProdotto create(OrdineProdotto ordineProdotto);

	Prodotto getProdottoService(long id);

	

}
