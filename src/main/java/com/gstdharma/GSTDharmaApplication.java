package com.gstdharma;

import com.gstdharma.dto.AuthResponse;
import static org.apache.commons.lang3.StringUtils.rightPad;

/**
 * @author avenkatraman
 */
public class GSTDharmaApplication {

    public static void main(String[] args) {
        AuthenticationModule module = new AuthenticationModule()
                .setUserName("Ray.MH.TP.1")
                .setClientId("l7xx5cd4f3f1203a48638c6e92f004b744ab")
                .setClientSecret("2afda27febdf4193b78a52f87445e081")
                .setOtp("575757");
        AuthResponse authResponse = module.authenticate();
        System.out.println(rightPad("", 100, "*"));
        if(authResponse.isAuthSucessful()) {
            System.out.println("Authentication successful");
            System.out.println("\t\tAuth token: " + authResponse.getTokenResponse().getAuthToken());
            System.out.println("\t\tReceived SEK: " + authResponse.getTokenResponse().getSek());
        } else {
            System.out.println("Authentication failed. Raw response: " + authResponse.getRawResponse());
        }
        System.out.println(rightPad("", 100, "*"));
    }

}
