package com.example.BEF.Disability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisabilityRepository extends JpaRepository<DisabilityEntity, Long> {
    boolean existsByDisabilityNumber(Long number);
    DisabilityEntity findByName(String name);
    DisabilityEntity findDisabilityByDisabilityNumber(Long number);
}
