package FinalTest.zavrsniback.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Ljubimac;

@Repository
public interface LjubimacRepository extends JpaRepository<Ljubimac, Long> {

	@Query("SELECT l FROM Ljubimac l WHERE " + 
			"(:kategorijaId IS NULL OR l.kategorija.id LIKE :kategorijaId) AND " +
			"(:pol IS NULL OR l.pol LIKE %:pol%) AND " +
			"(:opis IS NULL OR l.opis LIKE %:opis%)")		
	Page<Ljubimac> searc(@Param("kategorijaId") Long kategorijaId,@Param("pol") String pol, @Param("opis") String opis, Pageable pageable);
}
