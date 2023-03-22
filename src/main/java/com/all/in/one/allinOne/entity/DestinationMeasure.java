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
@Table(name = "tb_dest_measure")
@JsonIgnoreProperties({"adsList"})
public class DestinationMeasure implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dest_code")
    private Integer destCode;

    @PrePersist
    void prePersist() {
        if (this.destCode == null) {
            this.destCode = -1;
        }
    }

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "destinationMeasure", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Ads> adsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationMeasure that = (DestinationMeasure) o;
        return Objects.equals(id, that.id) && Objects.equals(destCode, that.destCode) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destCode, name);
    }

    @Override
    public String toString() {
        return "DestinationMeasure{" +
                "id=" + id +
                ", destCode=" + destCode +
                ", name='" + name + '\'' +
                '}';
    }

}
