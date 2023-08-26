package com.all.in.one.allinone.model.dto.request;

import com.all.in.one.allinone.model.enums.FieldType;
import com.all.in.one.allinone.model.enums.WebSiteType;
import lombok.Data;

import java.util.Set;

@Data
public class FillDbRequest {

    private Set<WebSiteType> webSiteTypes;
    private Set<FieldType> fieldTypes;

}
