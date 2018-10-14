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
public class Request {

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

    private Map<Class<? extends Espresso>, Object> extensions = new HashMap<>();

    @Nonnull
    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(@Nonnull Integer serverPort) {
        this.serverPort = serverPort;
    }

    @Nonnull
    public String getServerName() {
        return serverName;
    }

    public void setServerName(@Nonnull String serverName) {
        this.serverName = serverName;
    }

    @Nonnull
    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(@Nonnull String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    @Nonnull
    public String getUri() {
        return uri;
    }

    public void setUri(@Nonnull String uri) {
        this.uri = uri;
    }

    @Nullable
    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(@Nullable String queryString) {
        this.queryString = queryString;
    }

    @Nonnull
    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(@Nonnull Scheme scheme) {
        this.scheme = scheme;
    }

    @Nonnull
    public Method getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(@Nonnull Method requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Nonnull
    public String getProtcol() {
        return protcol;
    }

    public void setProtcol(@Nonnull String protcol) {
        this.protcol = protcol;
    }

    @Nullable
    public X509Certificate getSslClientCert() {
        return sslClientCert;
    }

    public void setSslClientCert(@Nullable X509Certificate sslClientCert) {
        this.sslClientCert = sslClientCert;
    }

    @Nonnull
    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(@Nonnull Map<String, String> headers) {
        this.headers = headers;
    }

    @Nullable
    public InputStream getBody() {
        return body;
    }

    public void setBody(@Nullable InputStream body) {
        this.body = body;
    }

    @Nonnull
    public Map<Class<? extends Espresso>, Object> getExtensions() {
        return extensions;
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
