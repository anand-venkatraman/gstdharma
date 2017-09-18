package com.gstdharma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gstdharma.dto.AuthTokenRequest;
import com.gstdharma.http.HttpModule;
import in.gov.gst.crypto.AESEncryption;
import in.gov.gst.crypto.EncryptionUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import sun.plugin2.util.SystemUtil;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static in.gov.gst.crypto.AESEncryption.decodeBase64StringTOByte;
import static in.gov.gst.crypto.AESEncryption.encryptEK;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

/**
 * Module to take care of Authentication specific requests/responses.
 *
 * @see <pre>http://developer.gstsystem.co.in/pages/apiportal/data/Authentication/Overview.pdf</pre>
 * @author avenkatraman
 */
public class AuthenticationModule {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private String userName;
    private String otp;
    private final String encodedAppKey;
    private final String encodedEncryptedAppKey;
    private String clientId;
    private String clientSecret;
    private HttpModule httpModule = new HttpModule();

    public AuthenticationModule() {
        try {
            this.encodedAppKey = AESEncryption.generateSecureKey();
            this.encodedEncryptedAppKey = EncryptionUtil.encrypt(SystemUtil.decodeBase64(encodedAppKey));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String authenticate() {
        try {
            AuthTokenRequest request = new AuthTokenRequest();
            ////////////////////////////////////////////////////////////////////////////////////////
            // request headers, listed here -
            // http://developer.gstsystem.co.in/apiportal/taxpayer/tauthentication
            ////////////////////////////////////////////////////////////////////////////////////////
            Map<String, String> headers = newHashMap();
            headers.put("clientid", this.clientId);
            headers.put("client-secret", this.clientSecret);
            headers.put("state-cd", "19");
            headers.put("ip-usr", "117.239.66.73");
            headers.put("txn", randomAlphanumeric(20));
            ////////////////////////////////////////////////////////////////////////////////////////
            // request payload, detailed here
            // http://developer.gstsystem.co.in/apiportal/taxpayer/tauthentication/apilist/v0.2
            ////////////////////////////////////////////////////////////////////////////////////////
            String encryptedOtp = encryptEK(otp.getBytes(), decodeBase64StringTOByte(this.encodedAppKey));
            request.setAppKey(encodedEncryptedAppKey);
            request.setOtp(encryptedOtp);
            request.setUserName(userName);
            String body = MAPPER.writeValueAsString(request);
            System.out.println(body);
            HttpResponse response = httpModule.post("http://devapi.gstsystem.co.in/taxpayerapi/v0.2/authenticate", headers, body);
            String responseBody = IOUtils.toString(response.getEntity().getContent());
            System.out.println("Status: " + response.getStatusLine().getStatusCode());
            System.out.println("Body: " + responseBody);
            return responseBody;
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public AuthenticationModule setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public AuthenticationModule setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public AuthenticationModule setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public AuthenticationModule setOtp(String otp) {
        this.otp = otp;
        return this;
    }
}
