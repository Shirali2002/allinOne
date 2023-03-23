package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.BanType;
import com.all.in.one.allinOne.entity.Brand;
import com.all.in.one.allinOne.entity.City;
import com.all.in.one.allinOne.entity.Colour;
import com.all.in.one.allinOne.entity.Currency;
import com.all.in.one.allinOne.entity.DestinationMeasure;
import com.all.in.one.allinOne.entity.FuelType;
import com.all.in.one.allinOne.entity.GearBoxType;
import com.all.in.one.allinOne.entity.GearType;
import com.all.in.one.allinOne.entity.Model;
import com.all.in.one.allinOne.repository.query.Queries;
import com.all.in.one.allinOne.repository.query.QueryHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UtilityRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final QueryHolder queryHolder;

    public void saveCurrency(Currency currency) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_CURRENCY),
                Map.of("code", currency.getCurrencyCode(),
                        "name", currency.getName()));
    }

    public void saveBanType(BanType banType) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_BAN_TYPE),
                Map.of("code", banType.getBanTypeCode(),
                        "name", banType.getName()));
    }

    public void saveBrand(Brand brand) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_BRAND),
                Map.of("code", brand.getBrandCode(),
                        "name", brand.getName()));
    }

    public void saveCity(City city) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_CITY),
                Map.of("code", city.getCityCode(),
                        "name", city.getName()));
    }

    public void saveColour(Colour colour) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_COLOUR),
                Map.of("code", colour.getColourCode(),
                        "name", colour.getName()));
    }

    public void saveDestinationMeasure(DestinationMeasure dest) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_DEST_MEASURE),
                Map.of("code", dest.getDestCode(),
                        "name", dest.getName()));
    }

    public void saveFuelType(FuelType fuelType) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_FUEL_TYPE),
                Map.of("code", fuelType.getFuelTypeCode(),
                        "name", fuelType.getName()));
    }

    public void saveGearBoxType(GearBoxType gearBoxType) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_GEAR_BOX_TYPE),
                Map.of("code", gearBoxType.getGearBoxCode(),
                        "name", gearBoxType.getName()));
    }

    public void saveGearType(GearType gearType) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_GEAR_TYPE),
                Map.of("code", gearType.getGearTypeCode(),
                        "name", gearType.getName()));
    }

    public void saveModel(Model model) {
        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_MODEL),
                Map.of("model", model.getModelCode(),
                        "name", model.getName(),
                        "brandId", model.getBrandCode()));
    }

    public List<BanType> findAllBanType() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_BAN_TYPE),
                new BeanPropertyRowMapper<>(BanType.class));
    }

    public List<Brand> findAllBrand() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_BRAND),
                new BeanPropertyRowMapper<>(Brand.class));
    }

    public List<City> findAllCity() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_CITY),
                new BeanPropertyRowMapper<>(City.class));
    }

    public List<Colour> findAllColour() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_COLOUR),
                new BeanPropertyRowMapper<>(Colour.class));
    }

    public List<Currency> findAllCurrency() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_CURRENCY),
                new BeanPropertyRowMapper<>(Currency.class));
    }

    public List<DestinationMeasure> findAllDestinationMeasure() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_DESTINATION_MEASURE),
                new BeanPropertyRowMapper<>(DestinationMeasure.class));
    }

    public List<FuelType> findAllFuelType() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_FUEL_TYPE),
                new BeanPropertyRowMapper<>(FuelType.class));
    }

    public List<GearBoxType> findAllGearBoxType() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_GEAR_BOX_TYPE),
                new BeanPropertyRowMapper<>(GearBoxType.class));
    }

    public List<GearType> findAllGearType() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_GEAR_TYPE),
                new BeanPropertyRowMapper<>(GearType.class));
    }

    public List<Model> findAllModel() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_MODEL),
                new BeanPropertyRowMapper<>(Model.class));
    }

    public List<Model> findAllModelByBrandCode(Integer brandCode) {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_MODEL_BY_BRAND_CODE),
                Map.of("brandCode", brandCode),
                new BeanPropertyRowMapper<>(Model.class));
    }

}
