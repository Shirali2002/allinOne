package com.all.in.one.allinone.service.admin;

import com.all.in.one.allinone.mapper.mybatisMapper.MainFieldsMapper;
import com.all.in.one.allinone.model.mybatis.BanType;
import com.all.in.one.allinone.model.mybatis.Brand;
import com.all.in.one.allinone.model.mybatis.City;
import com.all.in.one.allinone.model.mybatis.Colour;
import com.all.in.one.allinone.model.mybatis.FuelType;
import com.all.in.one.allinone.model.mybatis.GearBoxType;
import com.all.in.one.allinone.model.mybatis.GearType;
import com.all.in.one.allinone.model.mybatis.Model;
import com.all.in.one.allinone.parser.turboAz.TurboAzFieldsParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceMainImpl implements AdminService {

    private final MainFieldsMapper mainFieldsMapper;
    private final TurboAzFieldsParser turboAzFieldsParser;

    @Override
    public Document getDocument() {
        return turboAzFieldsParser.getDocumentFromLink("https://turbo.az/autos/new");
    }

    @Transactional
    @Override
    public void truncateAndFillBanType(Document document) {
        List<BanType> banTypes = turboAzFieldsParser.getBanTypes(document);
        truncateDbBanType();
        fillDbBanType(banTypes);
    }

    @Transactional
    @Override
    public void truncateAndFillBrand(Document document) {
        List<Brand> brands = turboAzFieldsParser.getBrands(document);
        truncateDbBrand();
        fillDbBrand(brands);
    }

    @Transactional
    @Override
    public void truncateAndFillCity(Document document) {
        List<City> cities = turboAzFieldsParser.getCities(document);
        truncateDbCity();
        fillDbCity(cities);
    }

    @Transactional
    @Override
    public void truncateAndFillColour(Document document) {
        List<Colour> colours = turboAzFieldsParser.getColours(document);
        truncateDbColour();
        fillDbColour(colours);
    }

    @Transactional
    @Override
    public void truncateAndFillFuelType(Document document) {
        List<FuelType> fuelTypes = turboAzFieldsParser.getFuelTypes(document);
        truncateDbFuelType();
        fillDbFuelType(fuelTypes);
    }

    @Transactional
    @Override
    public void truncateAndFillGearBoxType(Document document) {
        List<GearBoxType> gearBoxTypes = turboAzFieldsParser.getGearBoxTypes(document);
        truncateDbGearBoxType();
        fillDbGearBoxType(gearBoxTypes);
    }

    @Transactional
    @Override
    public void truncateAndFillGearType(Document document) {
        List<GearType> gearTypes = turboAzFieldsParser.getGearTypes(document);
        truncateDbGearType();
        fillDbGearType(gearTypes);
    }

    @Transactional
    @Override
    public void truncateAndFillModel(Document document) {
        List<Model> models = turboAzFieldsParser.getModels(document);
        truncateDbModel();
        fillDbModel(models);
    }

    @Transactional
    @Override
    public void fillDbBanType(List<BanType> banTypes) {
        mainFieldsMapper.insertBanTypes(banTypes);
    }

    @Transactional
    @Override
    public void fillDbBrand(List<Brand> brands) {
        mainFieldsMapper.insertBrands(brands);
    }

    @Transactional
    @Override
    public void fillDbModel(List<Model> models) {
        mainFieldsMapper.insertModels(models);
    }

    @Transactional
    @Override
    public void fillDbCity(List<City> cities) {
        mainFieldsMapper.insertCities(cities);
    }

    @Transactional
    @Override
    public void fillDbColour(List<Colour> colours) {
        mainFieldsMapper.insertColours(colours);
    }

    @Transactional
    @Override
    public void fillDbFuelType(List<FuelType> fuelTypes) {
        mainFieldsMapper.insertFuelTypes(fuelTypes);
    }

    @Transactional
    @Override
    public void fillDbGearType(List<GearType> gearTypes) {
        mainFieldsMapper.insertGearTypes(gearTypes);
    }

    @Transactional
    @Override
    public void fillDbGearBoxType(List<GearBoxType> gearBoxTypes) {
        mainFieldsMapper.insertGearBoxTypes(gearBoxTypes);
    }

    @Transactional
    @Override
    public void truncateDbBanType() {
        mainFieldsMapper.truncateBanTypes();
    }

    @Transactional
    @Override
    public void truncateDbBrand() {
        mainFieldsMapper.truncateBrands();
    }

    @Transactional
    @Override
    public void truncateDbModel() {
        mainFieldsMapper.truncateModels();
    }

    @Transactional
    @Override
    public void truncateDbCity() {
        mainFieldsMapper.truncateCities();
    }

    @Transactional
    @Override
    public void truncateDbColour() {
        mainFieldsMapper.truncateColours();
    }

    @Transactional
    @Override
    public void truncateDbFuelType() {
        mainFieldsMapper.truncateFuelTypes();
    }

    @Transactional
    @Override
    public void truncateDbGearType() {
        mainFieldsMapper.truncateGearTypes();
    }

    @Transactional
    @Override
    public void truncateDbGearBoxType() {
        mainFieldsMapper.truncateGearBoxTypes();
    }

}
