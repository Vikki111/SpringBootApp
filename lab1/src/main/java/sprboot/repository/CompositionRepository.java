package sprboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sprboot.model.Composition;

import java.util.List;

public interface CompositionRepository extends JpaRepository<Composition, Integer> {

    @Query(value = "select * from composition where lower(comp_name) = LOWER(?1) ",
            nativeQuery = true)
    List<Composition> findAllByCompName(String compName);
    List<Composition> findAllByOrderByCompNameAsc();
    List<Composition> findAllByOrderByCompNameDesc();
}
