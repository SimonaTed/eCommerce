package it.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eCommerce.entity.OrdineProdotto;
import it.eCommerce.entity.OrdineProdottoPK;

public interface OrdineProdottoRepository extends JpaRepository<OrdineProdotto,OrdineProdottoPK>{

}
