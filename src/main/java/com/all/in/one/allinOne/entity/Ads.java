package com.all.in.one.allinOne.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_ads")
public class Ads implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adsLink")
    private String adsLink;

    @Column(name = "imageLink")
    private String imageLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private Model model;

    @Column(name = "year")
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private BanType banType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private Colour colour;

    @Column(name = "enginePower")
    private String enginePower;

    @Column(name = "engineHorsePower")
    private String engineHorsePower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private FuelType fuelType;

    @Column(name = "destination")
    private Long destination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private DestinationMeasure destinationMeasure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private GearBoxType gearBoxType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private GearType gearType;

    @Column(name = "used")
    private Boolean used;

    @Column(name = "numberOfSeats")
    private Integer numberOfSeats;

    @Column(name = "price")
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false, nullable = false)
    private Currency currency;

}
