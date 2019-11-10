package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution findFirstById(Long id);

    List<Institution> findByName(String name);




    @Query("select i from Institution i where i.id % 2 = 1")
    List<Institution> findAllFirstHalf();

    @Query("select i from Institution i where i.id % 2 = 0")
    List<Institution> findAllSecondHalf();

}
