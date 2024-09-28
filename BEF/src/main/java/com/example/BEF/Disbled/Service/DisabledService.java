package com.example.BEF.Disbled.Service;

import com.example.BEF.Disbled.Domain.Disabled;
import com.example.BEF.User.DTO.UserDisabledDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DisabledService {
    // 관광지 장애 정보 필터링
    public List<Disabled> filteringDisabled(UserDisabledDTO userDiabledDTO, List<Disabled> disabledList) {
        List<Disabled> filteredList = new ArrayList<>();

        for (Disabled location : disabledList) {
            if (userDiabledDTO.getSenior() && seniorAvail(location))
            {
                log.info("노약자 관광지 : {}", location);
                filteredList.add(location);
            }
            else if (userDiabledDTO.getWheelchair() && wheelchiarAvail(location))
            {
                log.info("휠체어 관광지 : {}", location);
                filteredList.add(location);
            }
            else if (userDiabledDTO.getBlind_handicap() && blindAvail(location))
            {
                log.info("시각 장애 관광지 : {}", location);
                filteredList.add(location);
            }
            else if (userDiabledDTO.getHearing_handicap() && hearingAvail(location))
            {
                log.info("청각 장애 관광지 : {}", location);
                filteredList.add(location);
            }
            else if (userDiabledDTO.getInfants_family() && infantsAvail(location))
            {
                log.info("영유아 관광지 : {}", location);
                filteredList.add(location);
            }
        }

        return (filteredList);
    }

    // 관광지 - 노약자 관련 필터링
    public Boolean seniorAvail(Disabled location) {
//        if (location.getParking() != null)
//            return (true);
        if (!location.getRoute().isBlank())
            return (true);
//        else if (location.getPublicTransport() != null)
//            return (true);
//        else if (location.getEntrance() != null)
//            return (true);
        else
            return (!location.getElevator().isBlank());
//        else
//            return location.getPromotion() != null;
    }

    // 관광지 - 휠체어 관련 필터링
    public Boolean wheelchiarAvail(Disabled location) {
//        if (location.getParking() != null)
//            return (true);
//        else if (location.getRoute() != null)
//            return (true);
        if (!location.getPublicTransport().isBlank())
            return (true);
        else if (!location.getWheelchair().isBlank())
            return (true);
        else if (!location.getEntrance().isBlank())
            return (true);
        else if (!location.getElevator().isBlank())
            return (true);
//        else if (location.getRestroom() != null)
//            return (true);
        else if (!location.getAuditorium().isBlank())
            return (true);
        else if (!location.getRoom().isBlank())
            return (true);
        else
            return (!location.getHandicapEtc().isBlank());
    }

    // 관광지 - 시각 장애 관련 필터링
    public Boolean blindAvail(Disabled location) {
        if (!location.getBraileBlock().isBlank())
            return (true);
        else if (!location.getHelpDog().isBlank())
            return (true);
        else if (!location.getGuideHuman().isBlank())
            return (true);
        else if (!location.getAudioGuide().isBlank())
            return (true);
        else if (!location.getBigPrint().isBlank())
            return (true);
        else if (!location.getBrailePromotion().isBlank())
            return (true);
        else if (!location.getGuideSystem().isBlank())
            return (true);
        else
            return (!location.getBlindHandicapEtc().isBlank());
    }

    // 관광지 - 청각 장애 관련 필터링
    public Boolean hearingAvail(Disabled location) {
        if (!location.getSignGuide().isBlank())
            return (true);
        else if (!location.getVideoGuide().isBlank())
            return (true);
        else if (!location.getHearingRoom().isBlank())
            return (true);
        else
            return (!location.getHearingHandicapEtc().isBlank());
    }

    // 관광지 - 영유아 관련 필터링
    public Boolean infantsAvail(Disabled location) {
        if (!location.getStroller().isBlank())
            return (true);
        else if (!location.getLactationRoom().isBlank())
            return (true);
        else if (!location.getBabySpareChair().isBlank())
            return (true);
        else
            return (!location.getInfantsFamilyEtc().isBlank());
    }
}
