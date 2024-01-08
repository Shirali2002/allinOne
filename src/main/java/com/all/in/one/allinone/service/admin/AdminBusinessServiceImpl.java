package com.all.in.one.allinone.service.admin;

import com.all.in.one.allinone.model.dto.DocumentStorage;
import com.all.in.one.allinone.model.dto.request.FillDbRequest;
import com.all.in.one.allinone.model.enums.FieldType;
import com.all.in.one.allinone.model.enums.WebSiteType;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@Slf4j
@Service
public class AdminBusinessServiceImpl implements AdminBusinessService {

    private final Map<WebSiteType, AdminService> webSiteTypeStorage;
    private final Map<FieldType, Consumer<DocumentStorage>> fieldTypeStorage;

    public AdminBusinessServiceImpl(@Qualifier("adminServiceMainImpl") AdminService adminServiceMain) {
        this.webSiteTypeStorage = new HashMap<>();
        this.webSiteTypeStorage.put(WebSiteType.MAIN, adminServiceMain);
//        adminServiceStorage.put(WebSiteType.TURBO_AZ, adminServiceTurboAz);

        this.fieldTypeStorage = new HashMap<>();
        this.fieldTypeStorage.put(FieldType.BAN_TYPE, ds -> ds.getAdminService().truncateAndFillBanType(ds.getDocument()));
        this.fieldTypeStorage.put(FieldType.BRAND, ds -> ds.getAdminService().truncateAndFillBrand(ds.getDocument()));
        this.fieldTypeStorage.put(FieldType.CITY, ds -> ds.getAdminService().truncateAndFillCity(ds.getDocument()));
        this.fieldTypeStorage.put(FieldType.COLOUR, ds -> ds.getAdminService().truncateAndFillColour(ds.getDocument()));
        this.fieldTypeStorage.put(FieldType.FUEL_TYPE, ds -> ds.getAdminService().truncateAndFillFuelType(ds.getDocument()));
        this.fieldTypeStorage.put(FieldType.GEAR_BOX_TYPE, ds -> ds.getAdminService().truncateAndFillGearBoxType(ds.getDocument()));
        this.fieldTypeStorage.put(FieldType.GEAR_TYPE, ds -> ds.getAdminService().truncateAndFillGearType(ds.getDocument()));
        this.fieldTypeStorage.put(FieldType.MODEL, ds -> ds.getAdminService().truncateAndFillModel(ds.getDocument()));
    }

    @Transactional
    @Override
    public void fillDb(FillDbRequest fillDbRequest) {
        Set<WebSiteType> webSiteTypes = fillDbRequest.getWebSiteTypes();
        Set<FieldType> fieldTypes = fillDbRequest.getFieldTypes();

        if (webSiteTypes.contains(WebSiteType.ALL)) {
            webSiteTypeStorage.keySet()
                    .forEach(webSiteType -> fillByWebSiteTypeList(webSiteType, fieldTypes));
            return;
        }

        webSiteTypes.forEach(webSiteType -> fillByWebSiteTypeList(webSiteType, fieldTypes));
    }

    private void fillByWebSiteTypeList(WebSiteType webSiteType, Set<FieldType> fieldTypes) {
        AdminService adminService = webSiteTypeStorage.get(webSiteType);
        fillByFieldTypeList(adminService, fieldTypes);
    }

    private void fillByFieldTypeList(AdminService adminService, Set<FieldType> fieldTypes) {
        Document document = adminService.getDocument();

        if (fieldTypes.contains(FieldType.ALL)) {
            fieldTypeStorage.keySet()
                    .forEach(fieldType -> acceptFieldTypeConsumer(adminService, document, fieldType));
            return;
        }

        fieldTypes.forEach(fieldType -> acceptFieldTypeConsumer(adminService, document, fieldType));
    }

    private void acceptFieldTypeConsumer(AdminService adminService, Document document, FieldType fieldType) {
        DocumentStorage documentStorage = DocumentStorage.singletonOf(adminService, document);
        Consumer<DocumentStorage> consumer = fieldTypeStorage.get(fieldType);
        consumer.accept(documentStorage);
    }

}
