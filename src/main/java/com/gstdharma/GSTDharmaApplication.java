package com.gstdharma;

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
        module.authenticate();
    }

}
