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
@Table(name = "tb_colour")
@JsonIgnoreProperties({"adsList"})
public class Colour implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "colour_code")
    private Integer colourCode;

    @PrePersist
    void prePersist() {
        if (this.colourCode == null) {
            this.colourCode = -1;
        }
    }

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "colour", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Ads> adsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return Objects.equals(id, colour.id) && Objects.equals(colourCode, colour.colourCode) && Objects.equals(name, colour.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colourCode, name);
    }

    @Override
    public String toString() {
        return "Colour{" +
                "id=" + id +
                ", colourCode=" + colourCode +
                ", name='" + name + '\'' +
                '}';
    }

}
