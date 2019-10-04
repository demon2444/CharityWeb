package pl.coderslab.charity.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@Transactional
public class InstitutionService {

    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public Institution findById(Long id) {
        return institutionRepository.findFirstById(id);
    }

    public List<Institution> findByName(String name) {
        return institutionRepository.findByName(name);
    }

    public List<Institution> findAllFirstHalf(){
        return institutionRepository.findAllFirstHalf();
    }

    public List<Institution> findAllSecondHalf() {
        return institutionRepository.findAllSecondHalf();
    }

}
