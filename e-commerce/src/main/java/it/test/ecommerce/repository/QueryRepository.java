package it.test.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.test.ecommerce.entity.QueryEntity;


public interface QueryRepository extends JpaRepository<QueryEntity,Integer>  {

	List<QueryEntity> findBySiglaContainingIgnoreCase(String sigla);

	

}
