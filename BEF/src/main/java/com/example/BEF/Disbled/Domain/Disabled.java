package com.example.BEF.Disbled.Domain;

import com.example.BEF.Location.Domain.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "disabled")
@Getter @Setter
public class Disabled {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disabled_number")
    private Long disabledNumber;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private Location location;

    @Column(name = "parking")
    private String parking;

    @Column(name = "route")
    private String route;

    @Column(name = "public_transport")
    private String publicTransport;

    @Column(name = "ticket_office")
    private String ticketOffice;

    @Column(name = "promotion")
    private String promotion;

    @Column(name = "wheelchair")
    private String wheelchair;

    @Column(name = "entrance")
    private String entrance;

    @Column(name = "elevator")
    private String elevator;

    @Column(name = "restroom")
    private String restroom;

    @Column(name = "auditorium")
    private String auditorium;

    @Column(name = "room")
    private String room;

    @Column(name = "handicap_etc")
    private String handicapEtc;

    @Column(name = "braile_block")
    private String braileBlock;

    @Column(name = "help_dog")
    private String helpDog;

    @Column(name = "guide_human")
    private String guideHuman;

    @Column(name = "audio_guide")
    private String audioGuide;

    @Column(name = "big_print")
    private String bigPrint;

    @Column(name = "braile_promotion")
    private String brailePromotion;

    @Column(name = "guide_system")
    private String guideSystem;

    @Column(name = "blind_handicap_etc")
    private String blindHandicapEtc;

    @Column(name = "sign_guide")
    private String signGuide;

    @Column(name = "video_guide")
    private String videoGuide;

    @Column(name = "hearing_room")
    private String hearingRoom;

    @Column(name = "hearing_handicap_etc")
    private String hearingHandicapEtc;

    @Column(name = "stroller")
    private String stroller;

    @Column(name = "lactation_room")
    private String lactationRoom;

    @Column(name = "baby_spare_chair")
    private String babySpareChair;

    @Column(name = "infants_family_etc")
    private String infantsFamilyEtc;
}