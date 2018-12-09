package io.github.espresso4j.espresso;

import io.lacuna.bifurcan.IMap;
import io.lacuna.bifurcan.LinearMap;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

/**
 * The HTTP response object.
 *
 * A response object is consisted with HTTP status code, headers and an optional body.
 * The response can also carry extensions from middlewares.
 *
 */
public class Response extends ExtensionHolder {

    private Integer status = 200;

    private IMap<String, String> headers = new LinearMap<>();

    private IntoBody body;

    /**
     * Get to status code stored in this response
     *
     * @return the status code
     */
    public Integer status() {
        return status;
    }

    /**
     * Set the status code.
     *
     * @param status the status code to set
     * @return self
     */
    public Response status(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * Get the headers stored in this response
     *
     * @return map of headers
     */
    public IMap<String, String> headers() {
        return headers;
    }

    /**
     * Set header by key and value
     *
     * @param header the header name
     * @param value the header value
     * @return self
     */
    public Response header(String header, String value) {
        this.headers().put(header, value);
        return this;
    }

    /**
     * Get the stored body
     *
     * @return the body wrapped as IntoBody type
     */
    public IntoBody body() {
        return body;
    }

    /**
     * Set body using a java.io.File
     *
     * @param body the File
     * @return self
     */
    public Response body(File body) {
        this.body = IntoBody.from(body);
        return this;
    }

    /**
     * Set body as a string
     *
     * @param body the body string
     * @return self
     */
    public Response body(String body) {
        this.body = IntoBody.from(body);
        return this;
    }

    /**
     * Set body from an java.io.InputStream
     *
     * @param body the input stream
     * @return self
     */
    public Response body(InputStream body) {
        this.body = IntoBody.from(body);
        return this;
    }

    /**
     * Set body from a string iterator, each string within the iterator will be write into http body
     *
     * @param strs the string iterator
     * @return self
     */
    public Response body(Iterator<String> strs) {
        this.body = IntoBody.from(strs);
        return this;
    }

    /**
     * Set body to a IntoBody implementation
     *
     * @param intoBody the instance of IntoBody implementation
     * @param <T> the actual inner type
     * @return self
     */
    public <T> Response body(IntoBody<T> intoBody) {
        this.body = intoBody;
        return this;
    }

    /**
     * Build a response instance from a status code
     *
     * @param status the status code
     * @return an empty response with the status code
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
                "} " + super.toString();
    }
}
