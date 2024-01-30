package it.test.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QueryEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQuery;
	@Column
	private String sigla;
	@Column
	private String path;
	@Column
	private String file;
	
	
	public int getIdQuery() {
		return idQuery;
	}
	public void setIdQuery(int idQuery) {
		this.idQuery = idQuery;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
	
	public QueryEntity() {
		
	}
	
		
	public QueryEntity(int idQuery, String sigla, String path, String file) {
		super();
		this.idQuery = idQuery;
		this.sigla = sigla;
		this.path = path;
		this.file = file;
	}
	
	

}
