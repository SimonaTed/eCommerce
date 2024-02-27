package it.eCommerceProva.baeldung.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Ordine {

	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private LocalDate dataCreazione;

	    private String status;

	    @JsonManagedReference
	    @OneToMany(mappedBy = "pk.ordine")
	    private List<OrdineProdotto> ordiniProdotti = new ArrayList<>();

	    @Transient
	    public Double getTotaleprezzo() {
	        double sum = 0D;
	        List<OrdineProdotto> orderProducts = getOrdiniProdotti();
	        for (OrdineProdotto op : orderProducts) {
	            sum += op.getTotalPrice();
	        }
	        return sum;
	    }

	    @Transient
	    public int getNumerodiProdotti() {
	        return this.ordiniProdotti.size();
	    }
	    
	    public Ordine(Long id, LocalDate dataCreazione, String status, List<OrdineProdotto> ordiniProdotti) {
		super();
		this.id = id;
		this.dataCreazione = dataCreazione;
		this.status = status;
		this.ordiniProdotti = ordiniProdotti;
		}
	    
	    public Ordine() {
	    	
	    }
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getDataCreazione() {
			return dataCreazione;
		}

		public void setDataCreazione(LocalDate dataCreazione) {
			this.dataCreazione = dataCreazione;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<OrdineProdotto> getOrdiniProdotti() {
			return ordiniProdotti;
		}

		public void setOrdiniProdotti(List<OrdineProdotto> ordiniProdotti) {
			this.ordiniProdotti = ordiniProdotti;
		}

	   
	}
	

