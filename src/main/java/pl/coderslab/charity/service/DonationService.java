package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Transactional
public class DonationService {

    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm:ss");

    private DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Long sumQuantity() {
        Long sum = donationRepository.countAllByQuantity();
        if(sum == null) {
            return 0l;
        } else{
            return sum;
        }

    }

    public Long donateInstitutions() {
        Long sum = donationRepository.countDistinctByInstitution();
        if(sum == null) {
            return 0l;
        } else{
            return sum;
        }

    }

    public Donation findDonationById(Long id) {
        return donationRepository.findFirstById(id);
    }

    public void donationSave(Donation donation) {
        donationRepository.save(donation);
    }

    public Date setTimeeTosave(String time) {
        Date dateTime = new Date();
        try {
            dateTime = SDF_TIME.parse(time);
        } catch ( ParseException ex) {

        }
        return dateTime;
    }


}
