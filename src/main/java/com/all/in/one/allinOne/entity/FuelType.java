package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_fuel_type")
@JsonIgnoreProperties({"adsList"})
public class FuelType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fuel_type_code")
    private Integer fuelTypeCode;

    @PrePersist
    void prePersist() {
        if (this.fuelTypeCode == null) {
            this.fuelTypeCode = -1;
        }
    }

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fuelType", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Ads> adsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelType fuelType = (FuelType) o;
        return Objects.equals(id, fuelType.id) && Objects.equals(fuelTypeCode, fuelType.fuelTypeCode) && Objects.equals(name, fuelType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fuelTypeCode, name);
    }

    @Override
    public String toString() {
        return "FuelType{" +
                "id=" + id +
                ", fuelTypeCode=" + fuelTypeCode +
                ", name='" + name + '\'' +
                '}';
    }

}
