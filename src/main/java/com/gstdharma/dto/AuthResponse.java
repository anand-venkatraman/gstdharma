package com.gstdharma.dto;

import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * @author avenkatraman
 */
public class AuthResponse {
    
    private AuthTokenResponse tokenResponse;
    private String rawResponse;

    public AuthResponse(AuthTokenResponse tokenResponse, String rawResponse) {
        this.tokenResponse = tokenResponse;
        this.rawResponse = rawResponse;
    }

    public AuthTokenResponse getTokenResponse() {
        return tokenResponse;
    }

    public String getRawResponse() {
        return rawResponse;
    }
    
    public boolean isAuthSucessful() {
        return tokenResponse != null && tokenResponse.getStatusCode().equals("1");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthResponse that = (AuthResponse) o;
        return Objects.equals(tokenResponse, that.tokenResponse) &&
                Objects.equals(rawResponse, that.rawResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenResponse, rawResponse);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tokenResponse", tokenResponse)
                .add("rawResponse", rawResponse)
                .toString();
    }
}
