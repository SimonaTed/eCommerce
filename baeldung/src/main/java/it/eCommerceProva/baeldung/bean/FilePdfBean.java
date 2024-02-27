package it.eCommerceProva.baeldung.bean;

public class FilePdfBean {



	private String nomePdf;
	  
	  private  byte[] content;
	  
	 public FilePdfBean() {
		  
	  }
	  
	public FilePdfBean(String nomePdf, byte[] content) {
		super();
		this.nomePdf = nomePdf;
		this.content = content;
	}

	public String getNomePdf() {
		return nomePdf;
	}

	public void setNomePdf(String nomePdf) {
		this.nomePdf = nomePdf;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	} 
	
	
	
	  
}
