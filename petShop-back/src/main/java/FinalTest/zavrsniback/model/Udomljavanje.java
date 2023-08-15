package FinalTest.zavrsniback.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Udomljavanje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime datum;

	@OneToOne(mappedBy = "udomljavanje")
	private Ljubimac ljubimac;

	public Udomljavanje() {
	}

	public Udomljavanje(LocalDateTime datum, Ljubimac ljubimac) {
		this.datum = datum;
		this.ljubimac = ljubimac;
	}
	
	

	public Udomljavanje(LocalDateTime datum) {
		this.datum = datum;
	}

	public Udomljavanje(Long id, LocalDateTime datum, Ljubimac ljubimac) {
		this.id = id;
		this.datum = datum;
		this.ljubimac = ljubimac;
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
	public LocalDateTime getDatum() {
		return datum;
	}

	/**
	 * @param datum the datum to set
	 */
	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	/**
	 * @return the ljubimac
	 */
	public Ljubimac getLjubimac() {
		return ljubimac;
	}

	/**
	 * @param ljubimac the ljubimac to set
	 */
	public void setLjubimac(Ljubimac ljubimac) {
		this.ljubimac = ljubimac;
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
		if (!(obj instanceof Udomljavanje)) {
			return false;
		}
		Udomljavanje other = (Udomljavanje) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Udomljavanje [id=" + id + ", datum=" + datum + ", ljubimac=" + ljubimac + "]";
	}

}
