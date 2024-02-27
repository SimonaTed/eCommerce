package it.eCommerceProva.baeldung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eCommerceProva.baeldung.entity.OrdineProdotto;
import it.eCommerceProva.baeldung.entity.OrdineProdottoPK;

public interface OrdineProdottoRepository extends JpaRepository<OrdineProdotto,OrdineProdottoPK>{

}
