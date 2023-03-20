package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.entity.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AdsService {

//    public static Ads elan1;
//    public static Ads elan2;
//    public static Ads elan3;
//    public static Ads elan4;
//
//    static {
//        elan1 = new Ads();
//        elan1.setAdsLink("https://turbo.az/autos/6927679-lada-vaz-2115");
//        elan1.setImageLink("https://turbo.azstatic.com/uploads/f460x343/2022%2F12%2F20%2F12%2F17%2F15%2F415ab5f2-66dd-44a1-af40-eab5db650af6%2F1322_0F3BY6c14SD109VMTLVBvA.jpg");
//        elan1.setPrice("8000 AZN");
//        elan1.setProductName("LADA (VAZ) 2115");
//        elan1.setYear("2012");
//        elan1.setMileage("155 000 Km");
//        elan1.setEngineVolume("1.6 L");
//        elan1.setCity("Gəncə");
//        elan1.setPublishDate("bugün 12:26");
//
//        elan2 = new Ads();
//        elan2.setAdsLink("https://turbo.az/autos/6909389-opel-astra");
//        elan2.setImageLink("https://turbo.azstatic.com/uploads/f460x343/2022%2F12%2F14%2F11%2F01%2F32%2Fe75c4611-750a-4912-b5c1-bd7ff36902c7%2F92861_zZkbqIJ7fV2TVfPNb_QSCw.jpg");
//        elan2.setPrice("11 700 AZN");
//        elan2.setProductName("Opel Astra");
//        elan2.setYear("2009");
//        elan2.setMileage("246 000 Km");
//        elan2.setEngineVolume("1.3 L");
//        elan2.setCity("Baki");
//        elan2.setPublishDate("17.10.2022 21:43");
//
//        elan3 = new Ads();
//        elan3.setAdsLink("https://turbo.az/autos/6909389-opel-astra");
//        elan3.setImageLink("https://turbo.azstatic.com/uploads/f460x343/2022%2F12%2F14%2F11%2F01%2F32%2Fe75c4611-750a-4912-b5c1-bd7ff36902c7%2F92861_zZkbqIJ7fV2TVfPNb_QSCw.jpg");
//        elan3.setPrice("20 980 AZN");
//        elan3.setProductName("Mercedes");
//        elan3.setYear("2022");
//        elan3.setMileage("7 000 Km");
//        elan3.setEngineVolume("4.7 L");
//        elan3.setCity("Baki");
//        elan3.setPublishDate("12.12.2022 20:03");
//
//        elan4 = new Ads();
//        elan4.setAdsLink("https://turbo.az/autos/6927679-lada-vaz-2115");
//        elan4.setImageLink("https://turbo.azstatic.com/uploads/f460x343/2022%2F12%2F20%2F12%2F17%2F15%2F415ab5f2-66dd-44a1-af40-eab5db650af6%2F1322_0F3BY6c14SD109VMTLVBvA.jpg");
//        elan4.setPrice("23 000 AZN");
//        elan4.setProductName("BMW");
//        elan4.setYear("2019");
//        elan4.setMileage("70 000 Km");
//        elan4.setEngineVolume("2.6 L");
//        elan4.setCity("Sumqayıt");
//        elan4.setPublishDate("dünən 18:15");
//    }

//    public List<Ads> getAds(Integer page) {
//
//        log.info("page {} fetched", page);
//        List<Ads> adsList;
//        if (Objects.equals(page, 1)) {
//            adsList = new LinkedList<>();
//            adsList.add(elan1);
//            adsList.add(elan2);
//            adsList.add(elan1);
//            adsList.add(elan2);
//            adsList.add(elan1);
//            adsList.add(elan2);
//            adsList.add(elan2);
//            adsList.add(elan1);
//            adsList.add(elan2);
//            adsList.add(elan1);
//        } else if (Objects.equals(page, 2)) {
//            adsList = new LinkedList<>();
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//            adsList.add(elan3);
//        } else if (Objects.equals(page, 3)) {
//            adsList = new LinkedList<>();
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//            adsList.add(elan4);
//        } else {
//            throw ServiceException.of(ErrorCodes.PAGE_NOT_FOUND, "page not found");
//        }
//
//        return adsList;
//    }

}
