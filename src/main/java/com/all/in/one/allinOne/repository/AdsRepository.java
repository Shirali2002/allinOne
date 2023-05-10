package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.Ads;
import com.all.in.one.allinOne.repository.query.Queries;
import com.all.in.one.allinOne.repository.query.QueryHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
        params.put("imageLink", ads.getImageLink());
        params.put("numberOfSeats", ads.getNumberOfSeats());
        params.put("price", ads.getPrice());
        LocalDateTime ttl = ads.getTtl() == null ? LocalDateTime.now() : ads.getTtl();
        params.put("ttl", ttl);
        params.put("used", ads.getUsed());
        params.put("year", ads.getYear());
        params.put("banType", ads.getBanType());
        params.put("city", ads.getCity());
        params.put("colour", ads.getColour());
        params.put("currency", ads.getCurrency());
        params.put("destMeasure", ads.getDestinationMeasure());
        params.put("fuelType", ads.getFuelType());
        params.put("gearBoxType", ads.getGearBoxType());
        params.put("gearType", ads.getGearType());
        params.put("model", ads.getModel());
        params.put("brand", ads.getBrand());

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

    public Integer findCountOfAdsByAdsLink(String adsLink) {
        return jdbcTemplate.queryForObject(
                queryHolder.get(Queries.FIND_COUNT_OF_ADS_BY_ADS_LINK),
                Map.of("adsLink", adsLink),
                Integer.class);
    }

}
