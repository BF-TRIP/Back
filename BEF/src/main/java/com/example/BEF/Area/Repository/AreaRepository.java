package com.example.BEF.Area.Repository;

import com.example.BEF.Area.Domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {
    Area findByAreaCode(Long areaCode);
}
