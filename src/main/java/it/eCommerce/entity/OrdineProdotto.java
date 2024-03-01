package it.eCommerce.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class OrdineProdotto {


	    @EmbeddedId
	    @JsonIgnore //forse si deve togliere?
	    private OrdineProdottoPK pk;

	    @Column(nullable = false)
		private Integer quantita;

	    
	    public OrdineProdotto() {
	    	
	    }

	    public OrdineProdotto(Ordine ordine, Prodotto prodotto, Integer quantita) {
	        pk = new OrdineProdottoPK();
	        pk.setOrdine(ordine);
	        pk.setProdotto(prodotto);
	        this.quantita = quantita;
	    }

	    @Transient
	    public Prodotto getProduct() {
	        return this.pk.getProdotto();
	    }

	    @Transient
	    public Double getTotalPrice() {
	        return getProduct().getPrezzo() * getQuantita();
	    }

		public OrdineProdottoPK getPk() {
			return pk;
		}

		public void setPk(OrdineProdottoPK pk) {
			this.pk = pk;
		}

		public Integer getQuantita() {
			return quantita;
		}

		public void setQuantita(Integer quantita) {
			this.quantita = quantita;
		}

		@Override
		public int hashCode() {
			return Objects.hash(pk, quantita);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrdineProdotto other = (OrdineProdotto) obj;
			return Objects.equals(pk, other.pk) && Objects.equals(quantita, other.quantita);
		}

	 
}
