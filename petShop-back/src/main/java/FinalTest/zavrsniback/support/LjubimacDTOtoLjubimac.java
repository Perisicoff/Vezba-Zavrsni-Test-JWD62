package FinalTest.zavrsniback.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Ljubimac;
import FinalTest.zavrsniback.service.KategorijaService;
import FinalTest.zavrsniback.service.LjubimacService;
import FinalTest.zavrsniback.web.dto.LjubimacDTO;

@Component
public class LjubimacDTOtoLjubimac implements Converter<LjubimacDTO, Ljubimac> {
	
	@Autowired
	private LjubimacService ljubimacService;
	
	@Autowired
	private KategorijaService kategorijaService;

	@Override
	public Ljubimac convert(LjubimacDTO ljubimacDTO) {
		Ljubimac entity = null;

		if (ljubimacDTO.getId() == null) {
			entity = new Ljubimac();
		} else {
			Ljubimac ljubimac = ljubimacService.findOne(ljubimacDTO.getId());
			if (ljubimac != null) {
				entity = ljubimac;
			}
		}

		if (entity != null) {
			entity.setIme(ljubimacDTO.getIme());
			entity.setStarost(ljubimacDTO.getStarost());
			entity.setVakcinisan(false);
			entity.setPol(ljubimacDTO.getPol());
			entity.setTezina(ljubimacDTO.getTezina());
			entity.setOpis(ljubimacDTO.getOpis());
			entity.setKategorija(kategorijaService.findOne(ljubimacDTO.getKategorijaId()));
		}

		return entity;
	}

}
