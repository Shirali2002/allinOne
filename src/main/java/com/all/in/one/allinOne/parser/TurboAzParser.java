package com.all.in.one.allinOne.parser;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.error.exception.JsoupConnectException;
import com.all.in.one.allinOne.error.exception.ParseException;
import com.all.in.one.allinOne.service.AdsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.all.in.one.allinOne.util.Constants.TA_ELANLAR_SECTION_ID;
import static com.all.in.one.allinOne.util.Constants.TA_URL;

@Slf4j
@Component
@RequiredArgsConstructor
public class TurboAzParser {

    private final AdsService adsService;

    @Transactional
    public Integer parse(Integer page) {
        Map<Integer, String> links = getHrefsFromPage(page);
        int breaker = 0;

        for (int i = 0; i < 24; i++) {
            String adsLink = links.get(i);
            adsLink = String.format("%s%s", TA_URL, adsLink);
            Integer countOfAds = adsService.getCountOfAdsByAdsLink(adsLink);

            if (breaker >= 10) return -1;

            if (countOfAds == 0) {
                breaker = 0;
                Ads ads = getAds(adsLink);

                if (ads == null) continue;

                adsService.saveAds(ads);
            } else {
                breaker++;
            }
        }

        return page + 1;
    }

    private Ads getAds(String adsLink) {
        int year;
        int enginePower;
        int engineHorsePower;
        int destination;
        int price;
        Integer numberOfSeats;
        String imageLink;
        String currency;
        String destinationMeasureStr;
        String brandStr;
        String cityStr;
        String banTypeStr;
        String colourStr;
        String modelStr;
        String gearBoxTypeStr;
        String gearTypeStr;
        String fuelType;
        Boolean used;

        try {

            Document adsFromLink = getDocumentFromLink(adsLink);
            Element productProperties = adsFromLink.getElementsByClass("product-properties tz-d-flex tz-justify-between tz-gap-10").first();

            if (Objects.isNull(productProperties))
                throw new ParseException("productProperties is null");

            //image link
            Element photoProperty = adsFromLink.getElementsByClass("product-photos__slider-nav-i_picture").get(0);
            String style = photoProperty.attr("style");
            imageLink = style.substring(style.indexOf("(") + 2, style.indexOf(")")-1);

            //price
            Element priceProperties = adsFromLink.getElementsByClass("product-price__i product-price__i--bold").get(0);
            String priceInfos = priceProperties.ownText().replace(" ", "");
            currency = priceInfos.substring(priceInfos.length() - 3);
            String priceStr = priceInfos.substring(0, priceInfos.length() - 3);
            price = Integer.parseInt(priceStr);

            // all other properties
            Elements allProperties = productProperties.getElementsByClass("product-properties__column");
            Elements leftProperties = allProperties.get(0).getElementsByClass("product-properties__i");
            Elements rightProperties = allProperties.get(1).getElementsByClass("product-properties__i");

            // left properties
            cityStr = selectTextFromElementProperties(leftProperties, 0);

            brandStr = selectTextFromElementPropertiesWithA(leftProperties, 0);

            modelStr = selectTextFromElementPropertiesWithA(leftProperties, 1);

            String yearStr = selectTextFromElementPropertiesWithA(leftProperties, 2);
            year = Integer.parseInt(yearStr);

            banTypeStr = selectTextFromElementProperties(leftProperties, 4);

            colourStr = selectTextFromElementProperties(leftProperties, 5);

            String motorInfos = selectTextFromElementProperties(leftProperties, 6);
            String[] motorArr = motorInfos.split("/");
            String enginePowerStr = motorArr[0].replace(" L", "").replace(".", "");
            enginePower = Integer.parseInt(enginePowerStr) * 100;
            String engineHorsePowerStr = motorArr[1].replace(" a.g.", "");
            engineHorsePower = Integer.parseInt(engineHorsePowerStr);
            fuelType = motorArr[2];

            String distanceInfos = selectTextFromElementProperties(leftProperties, 7).replace(" ", "");
            String destinationStr = distanceInfos.substring(0, distanceInfos.length() - 2);
            destination = Integer.parseInt(destinationStr);
            destinationMeasureStr = distanceInfos.substring(distanceInfos.length() - 2);


            //right properties
            gearBoxTypeStr = selectTextFromElementProperties(rightProperties, 0);

            gearTypeStr = selectTextFromElementProperties(rightProperties, 1);

            String usedStr = selectTextFromElementProperties(rightProperties, 2);
            used = null;
            if (usedStr.equals("Xeyr")) {
                used = Boolean.TRUE;
            } else if (usedStr.startsWith("B") && usedStr.endsWith("li")) {
                used = Boolean.FALSE;
            }

            try {
                String numberOfSeatsStr = selectTextFromElementPropertiesForNumberOfSeats(rightProperties, 3);
                numberOfSeats = Integer.valueOf(numberOfSeatsStr);
            } catch (Exception e) {
                numberOfSeats = null;
            }

        } catch (Exception e) {
            log.info("exception occurred during parse. adsLink: {}, exception: {}", adsLink, e.getMessage());
            e.printStackTrace();
            return null;
        }

        // ads
        Ads ads = new Ads();
        ads.setAdsLink(adsLink);
        ads.setImageLink(imageLink);
        ads.setPrice(price);
        ads.setCurrency(currency);
        ads.setDestination(destination);
        ads.setDestinationMeasure(destinationMeasureStr);
        ads.setBrand(brandStr);
        ads.setUsed(used);
        ads.setYear(year);
        ads.setNumberOfSeats(numberOfSeats);
        ads.setCity(cityStr);
        ads.setBanType(banTypeStr);
        ads.setColour(colourStr);
        ads.setEngineHorsePower(engineHorsePower);
        ads.setEnginePower(enginePower);
        ads.setModel(modelStr);
        ads.setGearBoxType(gearBoxTypeStr);
        ads.setGearType(gearTypeStr);
        ads.setFuelType(fuelType);
        ads.setTtl(LocalDateTime.now(ZoneId.of("Asia/Baku")));

        return ads;
    }

    private String selectTextFromElementProperties(Elements properties, int n) {
        Element property = properties.select("span.product-properties__i-value").get(n);
        return property.ownText();
    }

    private String selectTextFromElementPropertiesWithA(Elements properties, int n) {
        Element property = properties.select("span.product-properties__i-value a").get(n);
        return property.ownText();
    }

    private String selectTextFromElementPropertiesForNumberOfSeats(Elements properties, int n) throws Exception {
        Element property = properties.select("span.product-properties__i-value").get(n);
        Element numberProperty = property.select("span.translation_missing").get(0);
        return numberProperty.ownText();
    }

    private Map<Integer, String> getHrefsFromPage(Integer pageNumber) {
        Map<Integer, String> links = new HashMap<>();
        Document page = getDocumentFromLink(String.format("%s/autos?page=%d", TA_URL, pageNumber));
        Elements products = page.getElementsByClass("products");
        Element product = products.get(TA_ELANLAR_SECTION_ID);
        Elements productsIs = product.getElementsByClass("products-i");

        for (int i = 0; i < productsIs.size(); i++) {
            Element productsILink = productsIs.get(i).getElementsByClass("products-i__link").first();

            if (Objects.isNull(productsILink)) throw new ParseException("productsILink is null");

            String link = productsILink.attr("href");
            links.put(i, link);
        }

        return links;
    }

    private Document getDocumentFromLink(String link) {
        try {
            return Jsoup.connect(link).get();
        } catch (IOException e) {
            throw new JsoupConnectException("error occured when connect to page with jsoup");
        }
    }

}
