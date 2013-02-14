package com.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: marcin
 * Date: 2/13/13
 * Time: 8:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoogleJsonResponseDummy implements GoogleJsonResponse{
    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<String, Object>();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<String>();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getTokenType() {
        return "toke_type";  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isExpired() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Date getExpiration() {
        return new Date();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getExpiresIn() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getValue() {
        return "val";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
