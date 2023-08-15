package FinalTest.zavrsniback.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ljubimac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String ime = "";

	@Column
	private int starost;

	@Column(nullable = false)
	private boolean vakcinisan;

	@Column(nullable = false)
	private String pol = "";

	@Column(nullable = false)
	private double tezina;

	@Column(nullable = false)
	private String opis = "";

	@ManyToOne
	private Kategorija kategorija;

	@OneToOne(cascade = CascadeType.ALL)
	private Udomljavanje udomljavanje;

	public Ljubimac() {
	}

	public Ljubimac(String ime, int starost, boolean vakcinisan, String pol, double tezina, String opis,
			Kategorija kategorija, Udomljavanje udomljavanje) {
		this.ime = ime;
		this.starost = starost;
		this.vakcinisan = vakcinisan;
		this.pol = pol;
		this.tezina = tezina;
		this.opis = opis;
		this.kategorija = kategorija;
		this.udomljavanje = udomljavanje;
	}

	public Ljubimac(Long id, String ime, int starost, boolean vakcinisan, String pol, double tezina, String opis,
			Kategorija kategorija, Udomljavanje udomljavanje) {
		this.id = id;
		this.ime = ime;
		this.starost = starost;
		this.vakcinisan = vakcinisan;
		this.pol = pol;
		this.tezina = tezina;
		this.opis = opis;
		this.kategorija = kategorija;
		this.udomljavanje = udomljavanje;
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
	 * @return the kategorija
	 */
	public Kategorija getKategorija() {
		return kategorija;
	}

	/**
	 * @param kategorija the kategorija to set
	 */
	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	/**
	 * @return the udomljavanje
	 */
	public Udomljavanje getUdomljavanje() {
		return udomljavanje;
	}

	/**
	 * @param udomljavanje the udomljavanje to set
	 */
	public void setUdomljavanje(Udomljavanje udomljavanje) {
		this.udomljavanje = udomljavanje;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Ljubimac)) {
			return false;
		}
		Ljubimac other = (Ljubimac) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ljubimac [id=" + id + ", ime=" + ime + ", starost=" + starost + ", vakcinisan=" + vakcinisan + ", pol="
				+ pol + ", tezina=" + tezina + ", opis=" + opis + ", kategorija=" + kategorija + ", udomljavanje="
				+ udomljavanje + "]";
	}

}
