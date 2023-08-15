package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

public class KategorijaDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	
	private String naziv = "";


	public KategorijaDTO() {
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the naziv
	 */
	public String getNaziv() {
		return naziv;
	}


	/**
	 * @param naziv the naziv to set
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
