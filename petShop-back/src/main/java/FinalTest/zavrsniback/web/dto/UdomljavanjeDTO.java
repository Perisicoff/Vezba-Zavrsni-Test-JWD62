package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.Positive;

public class UdomljavanjeDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	private String datum;

	private Long ljubimacId;
	
	private String nazivLjubimca;

	public UdomljavanjeDTO() {
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
	 * @return the datum
	 */
	public String getDatum() {
		return datum;
	}

	/**
	 * @param datum the datum to set
	 */
	public void setDatum(String datum) {
		this.datum = datum;
	}

	/**
	 * @return the ljubimacId
	 */
	public Long getLjubimacId() {
		return ljubimacId;
	}

	/**
	 * @param ljubimacId the ljubimacId to set
	 */
	public void setLjubimacId(Long ljubimacId) {
		this.ljubimacId = ljubimacId;
	}

	/**
	 * @return the nazivLjubimca
	 */
	public String getNazivLjubimca() {
		return nazivLjubimca;
	}

	/**
	 * @param nazivLjubimca the nazivLjubimca to set
	 */
	public void setNazivLjubimca(String nazivLjubimca) {
		this.nazivLjubimca = nazivLjubimca;
	}
	
}
