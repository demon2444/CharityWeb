package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Category, Long> {

    Institution findFirstById(Long id);

    List<Institution> findByName(String name);

    /*@Query("SELECT i from Institution")
    List<Institution> findAllInstitution();*/
}
