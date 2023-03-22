package com.all.in.one.allinOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

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
@Data
@Table(name = "tb_ban_type")
@JsonIgnoreProperties({"adsList"})
public class BanType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ban_type_code")
    private Integer banTypeCode;

    @PrePersist
    void prePersist() {
        if (this.banTypeCode == null) {
            this.banTypeCode = -1;
        }
    }

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "banType", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Ads> adsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BanType banType = (BanType) o;
        return Objects.equals(id, banType.id) && Objects.equals(banTypeCode, banType.banTypeCode) && Objects.equals(name, banType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, banTypeCode, name);
    }

    @Override
    public String toString() {
        return "BanType{" +
                "id=" + id +
                ", banTypeCode=" + banTypeCode +
                ", name='" + name + '\'' +
                '}';
    }

}
