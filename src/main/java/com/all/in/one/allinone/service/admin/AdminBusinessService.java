package com.all.in.one.allinone.service.admin;

import com.all.in.one.allinone.model.dto.request.FillDbRequest;
import org.springframework.transaction.annotation.Transactional;

public interface AdminBusinessService {

    @Transactional
    void fillDb(FillDbRequest fillDbRequest);
}
