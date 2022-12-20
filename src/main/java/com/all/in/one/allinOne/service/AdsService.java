package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.dto.Ads;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class AdsService {

    public static Ads elan1;
    public static Ads elan2;

    static {
        elan1 = new Ads();
        elan1.setAdsLink("https://turbo.az/autos/6927679-lada-vaz-2115");
        elan1.setImageLink("https://turbo.azstatic.com/uploads/f460x343/2022%2F12%2F20%2F12%2F17%2F15%2F415ab5f2-66dd-44a1-af40-eab5db650af6%2F1322_0F3BY6c14SD109VMTLVBvA.jpg");
        elan1.setPrice("8000 AZN");
        elan1.setProductName("LADA (VAZ) 2115");
        elan1.setYear("2012");
        elan1.setMileage("155 000 Km");
        elan1.setEngineVolume("1.6 L");
        elan1.setCity("Gəncə");
        elan1.setPublishDate("bugün 12:26");

        elan2 = new Ads();
        elan2.setAdsLink("https://turbo.az/autos/6909389-opel-astra");
        elan2.setImageLink("https://turbo.azstatic.com/uploads/f460x343/2022%2F12%2F14%2F11%2F01%2F32%2Fe75c4611-750a-4912-b5c1-bd7ff36902c7%2F92861_zZkbqIJ7fV2TVfPNb_QSCw.jpg");
        elan2.setPrice("11 700 AZN");
        elan2.setProductName("Opel Astra");
        elan2.setYear("2009");
        elan2.setMileage("246 000 Km");
        elan2.setEngineVolume("1.3 L");
        elan2.setCity("Baki");
        elan2.setPublishDate("17.12.2022 21:43");
    }

    public List<Ads> getAds(Integer page) {
        List<Ads> adsList = new LinkedList<>();
        adsList.add(elan1);
        adsList.add(elan2);
        adsList.add(elan1);
        adsList.add(elan2);
        adsList.add(elan1);
        adsList.add(elan2);
        adsList.add(elan2);
        adsList.add(elan1);
        adsList.add(elan2);
        adsList.add(elan1);

        return adsList;
    }

}
