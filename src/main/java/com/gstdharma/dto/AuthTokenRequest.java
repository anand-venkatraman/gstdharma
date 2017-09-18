package com.gstdharma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * Request payload for the authentication request.
 *
 * @see <pre>http://developer.gstsystem.co.in/apiportal/taxpayer/tauthentication/apilist/v0.2</pre>
 * @author avenkatraman
 */
public class AuthTokenRequest {

    private String action = Actions.ACCESS_TOKEN;
    private String userName;
    private String appKey;
    private String otp;

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("username")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("app_key")
    public String getAppKey() {
        return appKey;
    }

    @JsonProperty("otp")
    public String getOtp() {
        return otp;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthTokenRequest that = (AuthTokenRequest) o;
        return Objects.equals(action, that.action) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(appKey, that.appKey) &&
                Objects.equals(otp, that.otp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, userName, appKey, otp);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("action", action)
                .add("userName", userName)
                .add("appKey", appKey)
                .add("otp", otp)
                .toString();
    }
}
