package com.example.BEF.Location.Controller;

import com.example.BEF.Location.DTO.LocationInfoRes;
import com.example.BEF.Location.Service.LocationService;
import com.example.BEF.User.Service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @Autowired
    UserRepository userRepository;

    // 유저 장애 정보 기반 관광지 리스트 검색
    @GetMapping("/recommend")
    public ResponseEntity<List<LocationInfoRes>> getRecLocations(@RequestParam("userNumber") Long userNumber) {
        // 존재하지 않는 유저인 경우
        if (userRepository.findUserByUserNumber(userNumber) == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        // 필터링된 관광지 리스트 리턴
        return new ResponseEntity<>(locationService.filteringLocations(userNumber), HttpStatus.OK);
    }

    // 지역(구) 기반 관광지 리스트 검색
    @GetMapping("/district")
    public ResponseEntity<List<LocationInfoRes>> getDistrictLocations(@RequestParam("state") String state, @RequestParam("city") String city) {
        // 존재하지 않는 지역명인 경우
        if (state == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        // 필터링된 관광지 리스트 리턴
        return new ResponseEntity<>(locationService.findLocationWithDistrict(state, city), HttpStatus.OK);
    }
}
