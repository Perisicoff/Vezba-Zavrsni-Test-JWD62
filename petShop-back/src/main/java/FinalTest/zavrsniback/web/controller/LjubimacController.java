package FinalTest.zavrsniback.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Ljubimac;
import FinalTest.zavrsniback.model.Udomljavanje;
import FinalTest.zavrsniback.service.LjubimacService;
import FinalTest.zavrsniback.service.UdomljavanjeService;
import FinalTest.zavrsniback.support.LjubimacDTOtoLjubimac;
import FinalTest.zavrsniback.support.LjubimacToLjubimacDTO;
import FinalTest.zavrsniback.web.dto.LjubimacDTO;

@RestController
@RequestMapping(value = "/api/ljubimci", produces = MediaType.APPLICATION_JSON_VALUE)
public class LjubimacController {
	
	@Autowired
	private LjubimacService ljubimacService;
	
	@Autowired
	private LjubimacToLjubimacDTO toLjubimacDTO;
	
	@Autowired
	private LjubimacDTOtoLjubimac toLjubimac;
	
	@Autowired
	private UdomljavanjeService udomljavanjeService;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<LjubimacDTO>> getAll(@RequestParam(required = false, defaultValue = "") Long kategorijaId,
													@RequestParam(required = false, defaultValue = "") String pol,
													@RequestParam(required = false, defaultValue = "") String opis,
													@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {

		Page<Ljubimac> ljubimci = ljubimacService.searc(kategorijaId, pol, opis, pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(ljubimci.getTotalPages()));

		return new ResponseEntity<>(toLjubimacDTO.convert(ljubimci.getContent()), headers, HttpStatus.OK);

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Ljubimac obrisanLjubimac = ljubimacService.delete(id);

		if (obrisanLjubimac != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<LjubimacDTO> getOne(@PathVariable Long id) {
		Ljubimac ljubimac = ljubimacService.findOne(id);
		
		if (ljubimac != null) {
			return new ResponseEntity<>(toLjubimacDTO.convert(ljubimac), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LjubimacDTO> create(@Valid @RequestBody LjubimacDTO ljubimacDTO) {
		Ljubimac ljubimac = toLjubimac.convert(ljubimacDTO);

		if (ljubimac.getKategorija() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Ljubimac sacuvaniLjubimac = ljubimacService.save(ljubimac);

		return new ResponseEntity<>(toLjubimacDTO.convert(sacuvaniLjubimac), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/{id}")
	public ResponseEntity<Void> udomljavanje(@PathVariable Long id) {
		Ljubimac ljubimac = ljubimacService.findOne(id);

		if (ljubimac.getKategorija() == null || ljubimac.getUdomljavanje() != null || !ljubimac.isVakcinisan()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Udomljavanje udomljavanje = new Udomljavanje(LocalDateTime.now());
		Udomljavanje udomljenaZivotinja = udomljavanjeService.save(udomljavanje);
		
		ljubimac.setUdomljavanje(udomljenaZivotinja);
		ljubimacService.save(ljubimac);
		return new ResponseEntity<>( HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LjubimacDTO> update(@PathVariable Long id, @Valid @RequestBody LjubimacDTO ljubimacDTO) {

		if (!id.equals(ljubimacDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Ljubimac ljubimac = toLjubimac.convert(ljubimacDTO);

		if (ljubimac.getKategorija() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Ljubimac sacuvaniLjubimac = ljubimacService.update(ljubimac);

		return new ResponseEntity<>(toLjubimacDTO.convert(sacuvaniLjubimac), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}/vakcinacija")
	public ResponseEntity<Void> vakcinacija(@PathVariable Long id) {
		Ljubimac ljubimac = ljubimacService.findOne(id);

		if (ljubimac.getKategorija() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ljubimacService.vakcinacija(ljubimac);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
