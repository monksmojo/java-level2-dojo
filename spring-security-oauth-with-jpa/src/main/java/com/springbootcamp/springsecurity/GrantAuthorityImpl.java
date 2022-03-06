package com.springbootcamp.springsecurity;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class GrantAuthorityImpl implements GrantedAuthority {

    List<Role> authority;

    public GrantAuthorityImpl(List<Role> authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        for (Role auth :authority)
        {
            System.out.println(".....//////////"+auth.getAuthority());
            return String.valueOf(auth.getAuthority());
        }
        return null;
    }
}