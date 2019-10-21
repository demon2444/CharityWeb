package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("select SUM(d.quantity) FROM Donation d")
    Long countAllByQuantity();

    @Query("select count(distinct d.institution) from Donation d")
    Long countDistinctByInstitution();

    Donation findFirstById(Long id);


    @Query("select SUM(d.quantity) FROM Donation d where d.user.id = :id")
    Long countAllQuantitByUserId(Long id);



    @Query("select d from Donation d where d.user.id = :id")
    List<Donation> findAllByOrderByIdAsc(Long id);

   // List<Donation> findAllByPickedIsTrue();

    //List<Donation> findAllByPickedIsTrue();

}
