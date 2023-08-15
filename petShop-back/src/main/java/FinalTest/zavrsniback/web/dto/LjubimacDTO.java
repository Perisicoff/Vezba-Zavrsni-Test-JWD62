package FinalTest.zavrsniback.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


public class LjubimacDTO {

	@Positive(message = "Id mora biti pozitivan broj.")
	private Long id;

	@NotBlank
	private String ime = "";

	private int starost;

	private boolean vakcinisan;

	private String pol = "";

	@Positive
	private double tezina;

	private String opis = "";

	private Long kategorijaId;
	
	private String nazivKategorije;
	
	private Long udomljavanjeId;

	public LjubimacDTO() {
	}

	
	/**
	 * @return the udomljavanjeId
	 */
	public Long getUdomljavanjeId() {
		return udomljavanjeId;
	}


	/**
	 * @param udomljavanjeId the udomljavanjeId to set
	 */
	public void setUdomljavanjeId(Long udomljavanjeId) {
		this.udomljavanjeId = udomljavanjeId;
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
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * @return the starost
	 */
	public int getStarost() {
		return starost;
	}

	/**
	 * @param starost the starost to set
	 */
	public void setStarost(int starost) {
		this.starost = starost;
	}

	/**
	 * @return the vakcinisan
	 */
	public boolean isVakcinisan() {
		return vakcinisan;
	}

	/**
	 * @param vakcinisan the vakcinisan to set
	 */
	public void setVakcinisan(boolean vakcinisan) {
		this.vakcinisan = vakcinisan;
	}

	/**
	 * @return the pol
	 */
	public String getPol() {
		return pol;
	}

	/**
	 * @param pol the pol to set
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * @return the tezina
	 */
	public double getTezina() {
		return tezina;
	}

	/**
	 * @param tezina the tezina to set
	 */
	public void setTezina(double tezina) {
		this.tezina = tezina;
	}

	/**
	 * @return the opis
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * @param opis the opis to set
	 */
	public void setOpis(String opis) {
		this.opis = opis;
	}

	/**
	 * @return the kategorijaId
	 */
	public Long getKategorijaId() {
		return kategorijaId;
	}

	/**
	 * @param kategorijaId the kategorijaId to set
	 */
	public void setKategorijaId(Long kategorijaId) {
		this.kategorijaId = kategorijaId;
	}

	/**
	 * @return the nazivKategorije
	 */
	public String getNazivKategorije() {
		return nazivKategorije;
	}

	/**
	 * @param nazivKategorije the nazivKategorije to set
	 */
	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

}
