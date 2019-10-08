package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("select SUM(d.quantity) FROM Donation d")
    Long countAllByQuantity();

    @Query("select count(distinct d.institution) from Donation d")
    Long countDistinctByInstitution();

}
