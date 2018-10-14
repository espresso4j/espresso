package io.github.espresso4j.espresso;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Response {

    private Integer status;

    private Map<String, String> headers = new HashMap<>();

    private IntoBody body;

    public Integer getStatus() {
        return status;
    }

    public Response setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Response addHeader(String header, String value) {
        this.getHeaders().put(header, value);
        return this;
    }

    public IntoBody getBody() {
        return body;
    }

    public Response setBody(File body) {
        this.body = IntoBody.from(body);
        return this;
    }

    public Response setBody(String body) {
        this.body = IntoBody.from(body);
        return this;
    }

    public Response setBody(InputStream body) {
        this.body = IntoBody.from(body);
        return this;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", headers=" + headers +
                ", body=" + body +
                '}';
    }
}
