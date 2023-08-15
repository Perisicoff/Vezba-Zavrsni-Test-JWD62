package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Kategorija;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {

}
