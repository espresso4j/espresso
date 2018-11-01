package io.github.espresso4j.espresso;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 */
public class Response {

    private Integer status;

    private Map<String, String> headers = new HashMap<>();

    private IntoBody body;

    private Map<Class<?>, Object> extensions = new HashMap<>();

    public Integer status() {
        return status;
    }

    public Response status(Integer status) {
        this.status = status;
        return this;
    }

    public Map<String, String> headers() {
        return headers;
    }

    public Response header(String header, String value) {
        this.headers().put(header, value);
        return this;
    }

    public IntoBody body() {
        return body;
    }

    public Response body(File body) {
        this.body = IntoBody.from(body);
        return this;
    }

    public Response body(String body) {
        this.body = IntoBody.from(body);
        return this;
    }

    public Response body(InputStream body) {
        this.body = IntoBody.from(body);
        return this;
    }

    public Response body(Iterator<String> strs) {
        this.body = IntoBody.from(strs);
        return this;
    }

    public <T> Response body(IntoBody<T> intoBody) {
        this.body = intoBody;
        return this;
    }

    @Nonnull
    public Map<Class<?>, Object> extensions() {
        return extensions;
    }

    public Response extension(Class<? extends Espresso> key, Object value) {
        this.extensions.put(key, value);
        return this;
    }

    /**
     *
     * @param status
     * @return
     */
    public static Response of(int status) {
        Response response = new Response();
        return response.status(status);
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", headers=" + headers +
                ", body=" + body +
                ", extensions=" + extensions +
                '}';
    }
}
