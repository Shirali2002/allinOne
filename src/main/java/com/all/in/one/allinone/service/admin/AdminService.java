package com.all.in.one.allinone.service.admin;

import com.all.in.one.allinone.model.mybatis.BanType;
import com.all.in.one.allinone.model.mybatis.Brand;
import com.all.in.one.allinone.model.mybatis.City;
import com.all.in.one.allinone.model.mybatis.Colour;
import com.all.in.one.allinone.model.mybatis.FuelType;
import com.all.in.one.allinone.model.mybatis.GearBoxType;
import com.all.in.one.allinone.model.mybatis.GearType;
import com.all.in.one.allinone.model.mybatis.Model;
import org.jsoup.nodes.Document;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminService {

    Document getDocument();

    @Transactional
    void fillDbBanType(List<BanType> banTypes);

    @Transactional
    void fillDbBrand(List<Brand> brands);

    @Transactional
    void fillDbModel(List<Model> models);

    @Transactional
    void fillDbCity(List<City> cities);

    @Transactional
    void fillDbColour(List<Colour> colours);

    @Transactional
    void fillDbFuelType(List<FuelType> fuelTypes);

    @Transactional
    void fillDbGearType(List<GearType> gearTypes);

    @Transactional
    void fillDbGearBoxType(List<GearBoxType> gearBoxTypes);

    @Transactional
    void truncateDbBanType();

    @Transactional
    void truncateDbBrand();

    @Transactional
    void truncateDbModel();

    @Transactional
    void truncateDbCity();

    @Transactional
    void truncateDbColour();

    @Transactional
    void truncateDbFuelType();

    @Transactional
    void truncateDbGearType();

    @Transactional
    void truncateDbGearBoxType();

    @Transactional
    void truncateAndFillBanType(Document document);

    @Transactional
    void truncateAndFillBrand(Document document);

    @Transactional
    void truncateAndFillCity(Document document);

    @Transactional
    void truncateAndFillColour(Document document);

    @Transactional
    void truncateAndFillFuelType(Document document);

    @Transactional
    void truncateAndFillGearBoxType(Document document);

    @Transactional
    void truncateAndFillGearType(Document document);

    @Transactional
    void truncateAndFillModel(Document document);
}
