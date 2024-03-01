package it.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.eCommerce.entity.Ordine;


public interface OrdineRepository extends JpaRepository<Ordine,Long>{

}
