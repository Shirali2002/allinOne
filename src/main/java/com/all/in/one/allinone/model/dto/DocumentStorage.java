package com.all.in.one.allinone.model.dto;

import com.all.in.one.allinone.service.admin.AdminService;
import lombok.Data;
import org.jsoup.nodes.Document;

@Data
public class DocumentStorage {

    private final static DocumentStorage INSTANCE = new DocumentStorage();

    private AdminService adminService;
    private Document document;

    private DocumentStorage() {
    }

    public static DocumentStorage singletonOf(AdminService adminService, Document document) {
        INSTANCE.setAdminService(adminService);
        INSTANCE.setDocument(document);

        return INSTANCE;
    }

}
