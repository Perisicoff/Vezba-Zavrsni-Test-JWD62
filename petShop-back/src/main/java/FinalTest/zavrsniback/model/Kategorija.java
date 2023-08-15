package FinalTest.zavrsniback.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategorija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String naziv = "";

	@OneToMany(mappedBy = "kategorija")
	private List<Ljubimac> ljubimci = new ArrayList<>();

	public Kategorija() {
	}

	public Kategorija(String naziv, List<Ljubimac> ljubimci) {
		this.naziv = naziv;
		this.ljubimci = ljubimci;
	}

	public Kategorija(Long id, String naziv, List<Ljubimac> ljubimci) {
		this.id = id;
		this.naziv = naziv;
		this.ljubimci = ljubimci;
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

	/**
	 * @return the ljubimci
	 */
	public List<Ljubimac> getLjubimci() {
		return ljubimci;
	}

	/**
	 * @param ljubimci the ljubimci to set
	 */
	public void setLjubimci(List<Ljubimac> ljubimci) {
		this.ljubimci = ljubimci;
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
		if (!(obj instanceof Kategorija)) {
			return false;
		}
		Kategorija other = (Kategorija) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Kategorija [id=" + id + ", naziv=" + naziv + ", ljubimci=" + ljubimci + "]";
	}

}
