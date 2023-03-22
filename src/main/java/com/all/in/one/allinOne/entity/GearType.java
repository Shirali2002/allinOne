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
@Table(name = "tb_gear_type")
@JsonIgnoreProperties({"adsList"})
public class GearType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "gear_type_code")
    private Integer gearTypeCode;

    @PrePersist
    void prePersist() {
        if (this.gearTypeCode == null) {
            this.gearTypeCode = -1;
        }
    }

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "gearType", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Ads> adsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GearType gearType = (GearType) o;
        return Objects.equals(id, gearType.id) && Objects.equals(gearTypeCode, gearType.gearTypeCode) && Objects.equals(name, gearType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gearTypeCode, name);
    }

    @Override
    public String toString() {
        return "GearType{" +
                "id=" + id +
                ", gearTypeCode=" + gearTypeCode +
                ", name='" + name + '\'' +
                '}';
    }

}
