package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Kategorija;

public interface KategorijaService {

	Kategorija findOne(Long id);
	
	List<Kategorija> findAll();
}
