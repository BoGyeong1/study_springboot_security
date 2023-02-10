package com.study.study_springboot_security.configurations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalUser implements UserDetails {

    private Map userInfo;
    private String memberName;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public PrincipalUser(Map userInfo) {
        this.userInfo = userInfo;
        this.memberName = (String) userInfo.get("NAME");
        int i = 1;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // 권한들
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(new SimpleGrantedAuthority((String) userInfo.get("AUTHORITY")));
        return collections;
    }

    @Override // password
    public String getPassword() {

        return (String) userInfo.get("PASSWORD");
    }

    @Override // ID
    public String getUsername() {

        return (String) userInfo.get("MEMBER_ID");
    }

    @Override // 계정만료여부
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override // 계정을 일시적으로 잠굴때. 계정잠길여부
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override // 비밀번호변경 기간 만료
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override // 휴면 계정 여부
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
