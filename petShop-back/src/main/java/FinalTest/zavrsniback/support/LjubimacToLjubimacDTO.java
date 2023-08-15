package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Ljubimac;
import FinalTest.zavrsniback.web.dto.LjubimacDTO;

@Component
public class LjubimacToLjubimacDTO implements Converter<Ljubimac, LjubimacDTO> {

	@Override
	public LjubimacDTO convert(Ljubimac ljubimac) {
		LjubimacDTO ljubimacDTO = new LjubimacDTO();

		ljubimacDTO.setId(ljubimac.getId());
		ljubimacDTO.setIme(ljubimac.getIme());
		ljubimacDTO.setStarost(ljubimac.getStarost());
		ljubimacDTO.setVakcinisan(ljubimac.isVakcinisan());
		ljubimacDTO.setPol(ljubimac.getPol());
		ljubimacDTO.setTezina(ljubimac.getTezina());
		ljubimacDTO.setOpis(ljubimac.getOpis());
		ljubimacDTO.setKategorijaId(ljubimac.getKategorija().getId());
		ljubimacDTO.setNazivKategorije(ljubimac.getKategorija().getNaziv());
		ljubimacDTO.setUdomljavanjeId(ljubimac.getUdomljavanje().getId());
			
		return ljubimacDTO;
	}
	
	public List<LjubimacDTO> convert(List<Ljubimac> ljubimaci) {
		List<LjubimacDTO> LjubimacDTOS = new ArrayList<>();

		for (Ljubimac ljubimac : ljubimaci) {
			LjubimacDTOS.add(convert(ljubimac));
		}
		return LjubimacDTOS;
	}

}
