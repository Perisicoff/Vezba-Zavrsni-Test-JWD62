package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Kategorija;
import FinalTest.zavrsniback.web.dto.KategorijaDTO;

@Component
public class KategorijaToKategorijaDTO implements Converter<Kategorija, KategorijaDTO> {

	@Override
	public KategorijaDTO convert(Kategorija kategorija) {
		KategorijaDTO kategorijaDTO = new KategorijaDTO();

		kategorijaDTO.setId(kategorija.getId());
		kategorijaDTO.setNaziv(kategorija.getNaziv());
		
		return kategorijaDTO;
	}
	
	public List<KategorijaDTO> convert(List<Kategorija> kategorije) {
		List<KategorijaDTO> kategorijaDTOS = new ArrayList<>();

		for (Kategorija kategorija : kategorije) {
			kategorijaDTOS.add(convert(kategorija));
		}
		return kategorijaDTOS;
	}

}
