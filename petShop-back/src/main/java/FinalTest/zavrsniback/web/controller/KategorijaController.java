package FinalTest.zavrsniback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Kategorija;
import FinalTest.zavrsniback.service.KategorijaService;
import FinalTest.zavrsniback.support.KategorijaToKategorijaDTO;
import FinalTest.zavrsniback.web.dto.KategorijaDTO;

@RestController
@RequestMapping(value = "/api/kategorije", produces = MediaType.APPLICATION_JSON_VALUE)
public class KategorijaController {

	@Autowired
	private KategorijaService kategorijaService;

	@Autowired
	private KategorijaToKategorijaDTO toKategorijaDTO;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<KategorijaDTO>> getAll() {

		List<Kategorija> kategorija = kategorijaService.findAll();

		return new ResponseEntity<>(toKategorijaDTO.convert(kategorija), HttpStatus.OK);

	}

}
