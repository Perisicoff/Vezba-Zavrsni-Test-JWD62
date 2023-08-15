package FinalTest.zavrsniback.service;

import java.util.List;

import org.springframework.data.domain.Page;

import FinalTest.zavrsniback.model.Ljubimac;

public interface LjubimacService {

	Ljubimac findOne(Long id);

	List<Ljubimac> findAll();

	Page<Ljubimac> findAll(int brojStranice);
	
	Page<Ljubimac> searc(Long kategorijaId, String pol, String opis, int brojStranice);

	Ljubimac save(Ljubimac ljubimac);
	
	void vakcinacija(Ljubimac ljubimac);
	
	Ljubimac update(Ljubimac ljubimac);

	Ljubimac delete(Long id);
}
