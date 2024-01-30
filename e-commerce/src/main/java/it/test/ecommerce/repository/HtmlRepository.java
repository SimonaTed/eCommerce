package it.test.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.test.ecommerce.entity.HtmlEntity;
import it.test.ecommerce.entity.QueryEntity;

public interface HtmlRepository extends JpaRepository<HtmlEntity,Integer>{
	
	List<HtmlEntity> findBySiglaContainingIgnoreCase(String sigla);

}
