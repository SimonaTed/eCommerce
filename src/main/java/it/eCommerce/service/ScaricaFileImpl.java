package it.eCommerce.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eCommerce.bean.FilePdfBean;
import it.eCommerce.repository.ProdottoRepository;
import it.eCommerce.utils.Utils;


@Service
public class ScaricaFileImpl implements ScaricaFile {

	

	@Autowired
	private ProdottoRepository prodottoRepository;
	
	
	
	@Override
	 public FilePdfBean scaricaFileService(Long idProdotto) {
	        FilePdfBean bean = new FilePdfBean("ERRORE", new byte[0]);
	       prodottoRepository.findById(idProdotto).ifPresent(entity -> {
	            try {
	                File file = new File(entity.getPath() + File.separator + entity.getNome());
	                bean.setNomePdf(entity.getNome());
	                bean.setContent(Utils.readFileToByteArray(file));
	            } catch (IOException e) {
	               // log.error("Errore nel recupero del file", e);
	            }
	        });
	        return bean;
	    }
}
