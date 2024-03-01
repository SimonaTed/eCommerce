package it.eCommerce.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prodotto {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)//forse è auto?
		@Column(name ="id_Prodotto")
	    private Long idProdotto;

		@Column(nullable = false)
	    private String nome;

	    private Double prezzo;

	    private String path;

	    @Column(length = 2000)
	    private String descrizione;
	    
	    public Prodotto() {
	    	
	    }
	    
	    public Prodotto(Long idProdotto, String nome, Double prezzo, String path, String descrizione) {
		this.idProdotto = idProdotto;
		this.nome = nome;
		this.prezzo = prezzo;
		this.path = path;
		this.descrizione = descrizione;
	}

		public Long getIdProdotto() {
			return idProdotto;
		}

		public void setIdProdotti(Long idProdotto) {
			this.idProdotto = idProdotto;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Double getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(Double prezzo) {
			this.prezzo = prezzo;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

	
	    
	    
	    
}
