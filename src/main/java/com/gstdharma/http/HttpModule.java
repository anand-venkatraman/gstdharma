package com.gstdharma.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.util.Map;

/**
 * @author avenkatraman
 */
public class HttpModule {

    private HttpClient httpClient;

    public HttpModule() {
        httpClient = HttpClientBuilder.create().build();
    }

    public HttpResponse post(String url, Map<String, String> headers, String body) {
        try {
            HttpPost post = new HttpPost(url);
            post.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));
            headers.entrySet().forEach(kv -> post.addHeader(kv.getKey(), kv.getValue()));
            return httpClient.execute(post);
        } catch (IOException ex) {
            throw new RuntimeException("Error executing post request", ex);
        }
    }

}
