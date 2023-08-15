package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Ljubimac;
import FinalTest.zavrsniback.repository.LjubimacRepository;
import FinalTest.zavrsniback.service.LjubimacService;

@Service
public class JPALjubimacService implements LjubimacService {
	
	@Autowired
	private LjubimacRepository ljubimacRepository;

	@Override
	public Ljubimac findOne(Long id) {
		Optional<Ljubimac> ljubimac = ljubimacRepository.findById(id);
		if (ljubimac.isPresent()) {
			return ljubimac.get();
		}
		return null;
	}

	@Override
	public List<Ljubimac> findAll() {
		return ljubimacRepository.findAll();
	}

	@Override
	public Page<Ljubimac> findAll(int brojStranice) {
		return ljubimacRepository.findAll(PageRequest.of(brojStranice, 3));
	}

	@Override
	public Ljubimac save(Ljubimac ljubimac) {
		return ljubimacRepository.save(ljubimac);
	}

	@Override
	public Ljubimac update(Ljubimac ljubimac) {
		return ljubimacRepository.save(ljubimac);
	}

	@Override
	public Ljubimac delete(Long id) {
		Ljubimac ljubimac = findOne(id);
		if (ljubimac != null) {
			ljubimacRepository.deleteById(id);
			return ljubimac;
		}
		return null;
	}

	@Override
	public Page<Ljubimac> searc(Long kategorijaId, String pol, String opis, int brojStranice) {
		return ljubimacRepository.searc(kategorijaId, pol, opis, PageRequest.of(brojStranice, 3));
	}

	@Override
	public void vakcinacija(Ljubimac ljubimac) {
		boolean isVakcinisan = ljubimac.isVakcinisan();
		boolean novaVrednost = !isVakcinisan;
		ljubimac.setVakcinisan(novaVrednost);
		ljubimacRepository.save(ljubimac);
	}

}
