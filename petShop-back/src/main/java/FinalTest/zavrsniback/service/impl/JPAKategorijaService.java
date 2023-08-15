package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Kategorija;
import FinalTest.zavrsniback.repository.KategorijaRepository;
import FinalTest.zavrsniback.service.KategorijaService;

@Service
public class JPAKategorijaService implements KategorijaService {
	
	@Autowired
	private KategorijaRepository kategorijaRepository;

	@Override
	public List<Kategorija> findAll() {
		return kategorijaRepository.findAll();
	}

	@Override
	public Kategorija findOne(Long id) {
		Optional<Kategorija> kategorija = kategorijaRepository.findById(id);
		if (kategorija.isPresent()) {
			return kategorija.get();
		}
		return null;
	}

}
