package io.github.espresso4j.espresso;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * Espresso request
 */
public class Request extends ExtensionHolder {

    private Integer serverPort;

    private String serverName;

    private String remoteAddr;

    private String uri;

    private String queryString;

    private Scheme scheme;

    private Method requestMethod;

    private String protcol;

    private X509Certificate sslClientCert;

    private Map<String, String> headers = new HashMap<>();

    private InputStream body;

    /**
     * Get the serving port of current server
     *
     * @return the port number
     */
    @Nonnull
    public Integer getServerPort() {
        return serverPort;
    }

    /**
     * Set the serving port of current server
     *
     * @param serverPort the port number
     */
    public void setServerPort(@Nonnull Integer serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * Get the hostname of current server
     *
     * @return the hostname
     */
    @Nonnull
    public String getServerName() {
        return serverName;
    }

    /**
     * Set the hostname of current server
     *
     * @param serverName the hostname
     */
    public void setServerName(@Nonnull String serverName) {
        this.serverName = serverName;
    }

    /**
     * Get the client address string
     *
     * @return the client address
     */
    @Nonnull
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * Set the client address string
     *
     * @param remoteAddr the address string
     */
    public void setRemoteAddr(@Nonnull String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    /**
     * Get the request URI
     *
     * @return the URI
     */
    @Nonnull
    public String getUri() {
        return uri;
    }

    /**
     * Set the request URI
     *
     * @param uri the URI
     */
    public void setUri(@Nonnull String uri) {
        this.uri = uri;
    }

    /**
     * Get the query string part of request URL, typically it's the string after "?"
     *
     * @return the query string line
     */
    @Nullable
    public String getQueryString() {
        return queryString;
    }

    /**
     * Set the query string
     *
     * @param queryString the query string
     */
    public void setQueryString(@Nullable String queryString) {
        this.queryString = queryString;
    }

    /**
     * Get the request scheme, HTTP or HTTPS
     *
     * @return the scheme
     */
    @Nonnull
    public Scheme getScheme() {
        return scheme;
    }

    /**
     * Set current request scheme, HTTP or HTTPS
     *
     * @param scheme the scheme
     */
    public void setScheme(@Nonnull Scheme scheme) {
        this.scheme = scheme;
    }

    /**
     * Get the HTTP request method
     *
     * @return the method
     */
    @Nonnull
    public Method getRequestMethod() {
        return requestMethod;
    }

    /**
     * Set the request method
     *
     * @param requestMethod the method
     */
    public void setRequestMethod(@Nonnull Method requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * Get the protocol line of http request, http/1.1 or http/2 for example.
     *
     * @return the protocol line
     */
    @Nonnull
    public String getProtcol() {
        return protcol;
    }

    /**
     * Set the protocol line
     *
     * @param protcol the protocol line
     */
    public void setProtcol(@Nonnull String protcol) {
        this.protcol = protcol;
    }

    /**
     * Get the TLS client certificate if available
     *
     * @return the certificate
     */
    @Nullable
    public X509Certificate getSslClientCert() {
        return sslClientCert;
    }

    /**
     * Set the certificate for current request if any
     *
     * @param sslClientCert the certificate
     */
    public void setSslClientCert(@Nullable X509Certificate sslClientCert) {
        this.sslClientCert = sslClientCert;
    }

    /**
     * Get request headers
     *
     * @return the header map
     */
    @Nonnull
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Set the request headers
     *
     * @param headers the header map
     */
    public void setHeaders(@Nonnull Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Get HTTP request body as InputStream
     *
     * @return the InputStream
     */
    @Nullable
    public InputStream getBody() {
        return body;
    }

    /**
     * Set the HTTP request body
     *
     * @param body the InputStream
     */
    public void setBody(@Nullable InputStream body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Request{" +
                "serverPort=" + serverPort +
                ", serverName='" + serverName + '\'' +
                ", remoteAddr='" + remoteAddr + '\'' +
                ", uri='" + uri + '\'' +
                ", queryString='" + queryString + '\'' +
                ", scheme=" + scheme +
                ", requestMethod=" + requestMethod +
                ", protcol='" + protcol + '\'' +
                ", sslClientCert=" + sslClientCert +
                ", headers=" + headers +
                ", body=" + body +
                ", extensions=" + extensions +
                '}';
    }

    public enum Method {
        GET,
        POST,
        PUT,
        DELETE,
        HEAD,
        OPTION;

        public static Method from(@Nonnull String value) {
            return Method.valueOf(value.toUpperCase());
        }
    }

    public enum Scheme {
        HTTP,
        HTTPS;

        public static Scheme from(@Nonnull String value) {
            return Scheme.valueOf(value.toUpperCase());
        }
    }

}
