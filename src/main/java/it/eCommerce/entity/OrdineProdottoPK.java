package it.eCommerce.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrdineProdottoPK implements Serializable{

		@JsonBackReference
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "ordine_id")
	    private Ordine ordine;

	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "prodotto_id")
	    private Prodotto prodotto;

		public Ordine getOrdine() {
			return ordine;
		}

		public void setOrdine(Ordine ordine) {
			this.ordine = ordine;
		}

		public Prodotto getProdotto() {
			return prodotto;
		}

		public void setProdotto(Prodotto prodotto) {
			this.prodotto = prodotto;
		}

		@Override
		public int hashCode() {
			return Objects.hash(ordine, prodotto);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			OrdineProdottoPK other = (OrdineProdottoPK) obj;
			return Objects.equals(ordine, other.ordine) && Objects.equals(prodotto, other.prodotto);
		}

	   
	
}
