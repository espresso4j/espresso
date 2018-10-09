package io.github.espresso4j;

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

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public IntoBody getBody() {
        return body;
    }

    public void setBody(File body) {
        this.body = IntoBody.from(body);
    }

    public void setBody(String body) {
        this.body = IntoBody.from(body);
    }

    public void setBody(InputStream body) {
        this.body = IntoBody.from(body);
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
