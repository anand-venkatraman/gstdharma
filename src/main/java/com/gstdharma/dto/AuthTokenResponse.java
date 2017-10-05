package com.gstdharma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * Response payload for the authentication request.
 *
 * @see <pre>http://developer.gstsystem.co.in/apiportal/taxpayer/tauthentication/apilist/v0.2</pre>
 * @author avenkatraman
 */
public class AuthTokenResponse {
    
    @JsonProperty("auth_token")
    private String authToken;
    
    @JsonProperty("expiry")
    private int expiry;
    
    @JsonProperty("sek")
    private String sek;
    
    @JsonProperty("status_cd")
    private String statusCode;

    public String getAuthToken() {
        return authToken;
    }

    public AuthTokenResponse setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public int getExpiry() {
        return expiry;
    }

    public AuthTokenResponse setExpiry(int expiry) {
        this.expiry = expiry;
        return this;
    }

    public String getSek() {
        return sek;
    }

    public AuthTokenResponse setSek(String sek) {
        this.sek = sek;
        return this;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public AuthTokenResponse setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthTokenResponse that = (AuthTokenResponse) o;
        return expiry == that.expiry &&
                Objects.equals(authToken, that.authToken) &&
                Objects.equals(sek, that.sek) &&
                Objects.equals(statusCode, that.statusCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authToken, expiry, sek, statusCode);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("authToken", authToken)
                .add("expiry", expiry)
                .add("sek", sek)
                .add("statusCode", statusCode)
                .toString();
    }
}
