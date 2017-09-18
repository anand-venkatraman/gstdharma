package com.gstdharma;

/**
 * @author avenkatraman
 */
public class GSTDharmaApplication {

    public static void main(String[] args) {
        AuthenticationModule module = new AuthenticationModule()
                .setUserName("GSTIN")
                .setClientId("0")
                .setClientSecret("0")
                .setOtp("575757");
        module.authenticate();
    }

}
