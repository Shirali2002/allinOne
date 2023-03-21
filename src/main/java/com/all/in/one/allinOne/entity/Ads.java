package com.all.in.one.allinOne.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_ads")
public class Ads implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ads_link")
    private String adsLink;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "city_id", insertable = false, updatable = false, nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "model_id", referencedColumnName = "model_code", insertable = false, updatable = false)
    private Model model;

    @Column(name = "year")
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ban_type_id", insertable = false, updatable = false, nullable = false)
    private BanType banType;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "colour_id", insertable = false, updatable = false, nullable = false)
    private Colour colour;

    @Column(name = "engine_power")
    private String enginePower;

    @Column(name = "engine_horse_power")
    private String engineHorsePower;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fuel_type_id", insertable = false, updatable = false, nullable = false)
    private FuelType fuelType;

    @Column(name = "destination")
    private Long destination;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "dest_id", insertable = false, updatable = false, nullable = false)
    private DestinationMeasure destinationMeasure;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "gear_box_type_id", insertable = false, updatable = false, nullable = false)
    private GearBoxType gearBoxType;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "gear_type_id", insertable = false, updatable = false, nullable = false)
    private GearType gearType;

    @Column(name = "used")
    private Boolean used;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "price")
    private String price;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "currency_id", insertable = false, updatable = false, nullable = false)
    private Currency currency;

    @Column(name = "ttl")
    private LocalDateTime ttl;

}
