package com.all.in.one.allinOne.repository.query;

public enum Queries {

    SAVE_CURRENCY("saveCurrency"),
    SAVE_BAN_TYPE("saveBanType"),
    SAVE_BRAND("saveBrand"),
    SAVE_CITY("saveCity"),
    SAVE_COLOUR("saveColour"),
    SAVE_DEST_MEASURE("saveDestMeasure"),
    SAVE_FUEL_TYPE("saveFuelType"),
    SAVE_GEAR_BOX_TYPE("saveGearBoxType"),
    SAVE_GEAR_TYPE("saveGearType"),
    SAVE_MODEL("saveModel"),
    SAVE_ADS("saveAds"),
    SAVE_USER("saveUser"),
    FIND_ALL_ADS("findAllAds"),
    FIND_ALL_ADS_PAGE_BY_PAGE("findAllAdsPageByPage"),
    FIND_ALL_BAN_TYPE("findAllBanType"),
    FIND_ALL_BRAND("findAllBrand"),
    FIND_ALL_CITY("findAllCity"),
    FIND_ALL_COLOUR("findAllColour"),
    FIND_ALL_CURRENCY("findAllCurrency"),
    FIND_ALL_DESTINATION_MEASURE("findAllDestMeasure"),
    FIND_ALL_FUEL_TYPE("findAllFuelType"),
    FIND_ALL_GEAR_BOX_TYPE("findAllGearBoxType"),
    FIND_ALL_GEAR_TYPE("findAllGearType"),
    FIND_ALL_MODEL("findAllModel"),
    FIND_ALL_MODEL_BY_BRAND_CODE("findAllModelByBrandCode"),
    FIND_ALL_USER("findAllUser"),
    FIND_USER_BY_EMAIL("findUserByEmail"),
    FIND_USER_BY_RESET_PASSWORD_TOKEN("findUserByResetPasswordToken"),
    UPDATE_USER_BY_EMAIL("updateUserByEmail");

    private final String key;

    Queries(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

}