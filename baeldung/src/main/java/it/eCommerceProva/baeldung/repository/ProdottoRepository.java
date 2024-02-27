package it.eCommerceProva.baeldung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eCommerceProva.baeldung.entity.Prodotto;


public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {

	List<Prodotto> findAllBynomeContainingIgnoreCase(String nome);
}
