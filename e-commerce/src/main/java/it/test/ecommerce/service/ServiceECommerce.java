package it.test.ecommerce.service;

import java.util.List;

import it.test.ecommerce.entity.HtmlEntity;
import it.test.ecommerce.entity.QueryEntity;

public interface ServiceECommerce {


	List<QueryEntity> findQuerybySigla(String sigla);

	List<HtmlEntity> findTotalebySigla(String sigla);

	List<Object> trovatiBySigla(String sigla);
	
	List<Object> findAllItems();



}
