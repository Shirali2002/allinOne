package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.repository.query.Queries;
import com.all.in.one.allinOne.repository.query.QueryHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AdsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final QueryHolder queryHolder;

    public void saveAds(Ads ads) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("linkAds", ads.getAdsLink());
        params.put("destination", ads.getDestination());
        params.put("horsePower", ads.getEngineHorsePower());
        params.put("enginePower", ads.getEnginePower());
        params.put("imangeLink", ads.getImageLink());
        params.put("numberOfSeats", ads.getNumberOfSeats());
        params.put("price", ads.getPrice());
        params.put("ttl", ads.getTtl());
        params.put("used", ads.getUsed());
        params.put("year", ads.getYear());
        params.put("banTypeId", ads.getBanTypeCode());
        params.put("cityId", ads.getCityCode());
        params.put("colourId", ads.getColourCode());
        params.put("currencyId", ads.getCurrencyCode());
        params.put("destMeasureId", ads.getDestinationMeasureCode());
        params.put("fuelTypeId", ads.getFuelTypeCode());
        params.put("gearBoxTypeId", ads.getGearBoxTypeCode());
        params.put("gearTypeId", ads.getGearTypeCode());
        params.put("modelId", ads.getModelCode());


        jdbcTemplate.update(
                queryHolder.get(Queries.SAVE_ADS),
                params);
    }

    public List<Ads> findAllAds() {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_ADS),
                new BeanPropertyRowMapper<>(Ads.class));
    }

    public List<Ads> findAllAdsPageByPage(Integer from, Integer limit) {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_ALL_ADS_PAGE_BY_PAGE),
                Map.of("limit", limit,
                        "from", from),
                new BeanPropertyRowMapper<>(Ads.class));
    }

}
