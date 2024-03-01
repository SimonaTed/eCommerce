package it.eCommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eCommerce.entity.Prodotto;


public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {

	List<Prodotto> findAllBynomeContainingIgnoreCase(String nome);
}
