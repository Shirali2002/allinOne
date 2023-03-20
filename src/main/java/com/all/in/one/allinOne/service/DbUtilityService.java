package com.all.in.one.allinOne.service;

import com.all.in.one.allinOne.dto.BanType;
import com.all.in.one.allinOne.repository.BanTypeRepository;
import com.all.in.one.allinOne.repository.BrandRepository;
import com.all.in.one.allinOne.repository.CityRepository;
import com.all.in.one.allinOne.repository.ColourRepository;
import com.all.in.one.allinOne.repository.CurrencyRepository;
import com.all.in.one.allinOne.repository.DestinationMeasureRepository;
import com.all.in.one.allinOne.repository.FuelTypeRepository;
import com.all.in.one.allinOne.repository.GearBoxTypeRepository;
import com.all.in.one.allinOne.repository.GearTypeRepository;
import com.all.in.one.allinOne.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DbUtilityService {

    private final BanTypeRepository banTypeRepository;
    private final BrandRepository brandRepository;
    private final CityRepository cityRepository;
    private final ColourRepository colourRepository;
    private final CurrencyRepository currencyRepository;
    private final DestinationMeasureRepository destinationMeasureRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final GearBoxTypeRepository gearBoxTypeRepository;
    private final GearTypeRepository gearTypeRepository;
    private final ModelRepository modelRepository;

    @Transactional
    public void dbFill() {
        Arrays.stream(BanType.values())
                .forEach(banType -> {
                    com.all.in.one.allinOne.entity.BanType banTypeEntity = new com.all.in.one.allinOne.entity.BanType();
                    banTypeEntity.setId(banType.getId());
                    banTypeEntity.setName(banType.getValue());
                    banTypeRepository.save(banTypeEntity);
                });
    }

}