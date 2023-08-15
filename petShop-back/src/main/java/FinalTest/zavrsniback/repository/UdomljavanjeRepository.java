package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Udomljavanje;

@Repository
public interface UdomljavanjeRepository extends JpaRepository<Udomljavanje, Long> {

}
