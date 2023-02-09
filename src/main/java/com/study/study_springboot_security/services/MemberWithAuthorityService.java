package com.study.study_springboot_security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.study_springboot_security.dao.SherdDao;

@Service
public class MemberWithAuthorityService {

    @Autowired
    SherdDao sherdDao;

    public Object insert(Object dataMap) {
        String sqlMapId = "Memberwithauthority.insertWithUID";
        Object result = sherdDao.insert(sqlMapId, dataMap);
        return result;
    }
}
