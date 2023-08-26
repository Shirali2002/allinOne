package com.all.in.one.allinone.parser.turboAz;

import com.all.in.one.allinone.model.dto.FieldStorage;
import com.all.in.one.allinone.model.error.exception.JsoupConnectException;
import com.all.in.one.allinone.model.mybatis.BanType;
import com.all.in.one.allinone.model.mybatis.Brand;
import com.all.in.one.allinone.model.mybatis.City;
import com.all.in.one.allinone.model.mybatis.Colour;
import com.all.in.one.allinone.model.mybatis.FuelType;
import com.all.in.one.allinone.model.mybatis.GearBoxType;
import com.all.in.one.allinone.model.mybatis.GearType;
import com.all.in.one.allinone.model.mybatis.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class TurboAzFieldsParser {

    public List<City> getCities(Document document) {
        return getFields(
                document,
                "input select required auto_region",
                "[id=auto_region_id]",
                (s) -> {
                    City city = new City();
                    city.setCityCode(s.getCode());
                    city.setName(s.getName());
                    return city;
                }
        );
    }

    public List<Colour> getColours(Document document) {
        return getFields(
                document,
                "input select required auto_color",
                "[id=auto_color_id]",
                (s) -> {
                    Colour colour = new Colour();
                    colour.setColourCode(s.getCode());
                    colour.setName(s.getName());
                    return colour;
                }
        );
    }

    public List<BanType> getBanTypes(Document document) {
        return getFields(
                document,
                "input select required auto_category",
                "[id=auto_category_id]",
                (s) -> {
                    BanType banType = new BanType();
                    banType.setBanTypeCode(s.getCode());
                    banType.setName(s.getName());
                    return banType;
                }
        );
    }

    public List<GearBoxType> getGearBoxTypes(Document document) {
        return getFields(
                document,
                "input select required auto_transmission",
                "[id=auto_transmission_id]",
                (s) -> {
                    GearBoxType gearBoxType = new GearBoxType();
                    gearBoxType.setGearBoxCode(s.getCode());
                    gearBoxType.setName(s.getName());
                    return gearBoxType;
                }
        );
    }

    public List<GearType> getGearTypes(Document document) {
        return getFields(
                document,
                "input select required auto_gear",
                "[id=auto_gear_id]",
                (s) -> {
                    GearType gearType = new GearType();
                    gearType.setGearTypeCode(s.getCode());
                    gearType.setName(s.getName());
                    return gearType;
                }
        );
    }

    public List<FuelType> getFuelTypes(Document document) {
        return getFields(
                document,
                "input select required auto_fuel_type",
                "[id=auto_fuel_type_id]",
                (s) -> {
                    FuelType fuelType = new FuelType();
                    fuelType.setFuelTypeCode(s.getCode());
                    fuelType.setName(s.getName());
                    return fuelType;
                }
        );
    }

    public List<Brand> getBrands(Document document) {
        return getFields(
                document,
                "input string required auto_make_id",
                "[id=auto_make_id]",
                (s) -> {
                    Brand brand = new Brand();
                    brand.setBrandCode(s.getCode());
                    brand.setName(s.getName());
                    return brand;
                }
        );
    }

    public List<Model> getModels(Document document) {
        Element elementByClass = document.getElementsByClass("input string required auto_model").get(0);
        Element elementById = elementByClass.select("[id=auto_model_id]").get(0);
        Elements optionElementList = elementById.select("option");

        List<Model> models = new LinkedList<>();

        for (int i = 2; i < optionElementList.size(); i++) {
            Element e = optionElementList.get(i);
            Integer brandId = Integer.valueOf(e.attr("class"));
            Integer modelCode = Integer.valueOf(e.attr("value"));
            String name = e.ownText();

            Model model = new Model();
            model.setBrandCode(brandId);
            model.setModelCode(modelCode);
            model.setName(name);

            models.add(model);
        }

        return models;
    }

    public Document getDocumentFromLink(String link) {
        try {
            return Jsoup.connect(link).get();
        } catch (IOException e) {
            throw new JsoupConnectException("error occured when connect to page with jsoup");
        }
    }

    private <T> List<T> getFields(Document document, String className, String selectQuery, Function<FieldStorage, T> function) {
//        Document document = getDocumentFromLink("https://turbo.az/autos/new");
        Element elementByClass = document.getElementsByClass(className).get(0);
        Element elementById = elementByClass.select(selectQuery).get(0);
        Elements optionsElementList = elementById.select("option");

        List<T> tList = new LinkedList<>();

        for (int i = 1; i < optionsElementList.size(); i++) {
            Element el = optionsElementList.get(i);
            Integer value = Integer.valueOf(el.attr("value"));
            String text = el.ownText();

            FieldStorage fieldStorage = FieldStorage.singletonOf(value, text);

            T t = function.apply(fieldStorage);

            tList.add(t);
        }

        return tList;
    }

}
