package FinalTest.zavrsniback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Udomljavanje;
import FinalTest.zavrsniback.repository.UdomljavanjeRepository;
import FinalTest.zavrsniback.service.UdomljavanjeService;

@Service
public class JPAUdomljavanjeService implements UdomljavanjeService {
	
	@Autowired
	private UdomljavanjeRepository udomljavanjeRepository;

	@Override
	public Udomljavanje save(Udomljavanje udomljavanje) {
		return udomljavanjeRepository.save(udomljavanje);
	}

}
