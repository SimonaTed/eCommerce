package it.test.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.test.ecommerce.entity.HtmlEntity;
import it.test.ecommerce.entity.QueryEntity;
import it.test.ecommerce.repository.HtmlRepository;
import it.test.ecommerce.repository.QueryRepository;

@Service
public class ServiceEcommerceImpl implements ServiceECommerce {

	@Autowired
	QueryRepository queryrepository;

	@Autowired
	HtmlRepository htmlrepository;;

	@Override
	public List<QueryEntity> findQuerybySigla(String sigla) {
		return (List<QueryEntity>) queryrepository.findBySiglaContainingIgnoreCase(sigla);
	}

	@Override
	public List<HtmlEntity> findTotalebySigla(String sigla) {
		return (List<HtmlEntity>) htmlrepository.findBySiglaContainingIgnoreCase(sigla);
	}

	@Override
	public List<Object> trovatiBySigla(String sigla) {

		List<Object> risultati = new ArrayList<>();

		List<QueryEntity> queries = queryrepository.findBySiglaContainingIgnoreCase(sigla);
		risultati.addAll(queries);

		List<HtmlEntity> htmls = htmlrepository.findBySiglaContainingIgnoreCase(sigla);
		risultati.addAll(htmls);

		return risultati;
	}

	@Override
	public List<Object> findAllItems() {
		List<Object> all = new ArrayList<Object>();

		List<QueryEntity> allQueries = queryrepository.findAll();
		all.addAll(allQueries);

		List<HtmlEntity> allHtml = htmlrepository.findAll();
		all.addAll(allHtml);

		return all;
	}

}
