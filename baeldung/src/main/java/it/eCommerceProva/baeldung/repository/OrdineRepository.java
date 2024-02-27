package it.eCommerceProva.baeldung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eCommerceProva.baeldung.entity.Ordine;


public interface OrdineRepository extends JpaRepository<Ordine,Long>{

}
