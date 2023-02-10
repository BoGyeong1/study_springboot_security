package com.study.study_springboot_security.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.study_springboot_security.dao.SherdDao;
import com.study.study_springboot_security.utils.CommonUtils;

@Service
public class MemberWithAuthorityService {

    @Autowired
    SherdDao sherdDao;

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;

    public Object insert(Object dataMap) {
        String sqlMapId = "Memberwithauthority.insertWithUID";
        ((Map) dataMap).put("USERS_UID", commonUtils.getUniqueSequence());
        ((Map) dataMap).put("role", "ROLE_USER");
        // normal to crypto password
        String password = (String) ((Map) dataMap).get("password");
        ((Map) dataMap).put("password", bcryptPasswordEncoder.encode(password));

        Object result = sherdDao.insert(sqlMapId, dataMap);
        return result;
    }
}
