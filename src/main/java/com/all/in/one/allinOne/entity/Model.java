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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_model")
@JsonIgnoreProperties({"brand"})
public class Model implements Serializable {

//    @Id
//    @Column(name = "id")
//    private Integer id;

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_code")
    private Integer modelCode;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    @JoinColumn(name = "brand_id", referencedColumnName = "code", insertable = false, updatable = false)
    private Brand brand;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Ads> adsList;

    public Model() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getModelCode() {
        return modelCode;
    }

    public void setModelCode(Integer modelCode) {
        this.modelCode = modelCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Ads> getAdsList() {
        return adsList;
    }

    public void setAdsList(List<Ads> adsList) {
        this.adsList = adsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(id, model.id) && Objects.equals(modelCode, model.modelCode) && Objects.equals(name, model.name) && Objects.equals(brand, model.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelCode, name, brand);
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", modelCode=" + modelCode +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                '}';
    }

}
