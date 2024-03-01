package it.eCommerce.dto;


import it.eCommerce.entity.Prodotto;

public class OrdineProdottoDTO {
   
	private Prodotto prodotto;
    private Integer quantita;

    
    public OrdineProdottoDTO() {
    	
    }

	public OrdineProdottoDTO(Prodotto prodotto, Integer quantita) {
		super();
		this.prodotto = prodotto;
		this.quantita = quantita;
	}
	
	public Prodotto getProdotto() {
		return prodotto;
	}


	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}


	public Integer getQuantita() {
		return quantita;
	}


	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}


    
    

   
}

