package it.eCommerceProva.baeldung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.eCommerceProva.baeldung.bean.FilePdfBean;
import it.eCommerceProva.baeldung.service.ScaricaFile;



@RestController
public class ControllerScaricaFile {
	
	@Autowired
	private ScaricaFile scaricaFile;
	
	// forse usare una lista idProdotto?
	 @GetMapping(value = "/scaricaFile", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Object> scaricaFileController(@RequestParam Long idProdotto) {
       // log.info("API /scaricaEstrattoConto Carico il file : Scarico il file id allegato: " + idAllegato);
        FilePdfBean pdf = scaricaFile.scaricaFileService(idProdotto);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + pdf.getNomePdf())
                .body(pdf.getContent());
    }

}
