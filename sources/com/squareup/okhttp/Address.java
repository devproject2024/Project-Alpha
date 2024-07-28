package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address {
    final Authenticator authenticator;
    final CertificatePinner certificatePinner;
    final List<ConnectionSpec> connectionSpecs;
    final HostnameVerifier hostnameVerifier;
    final List<Protocol> protocols;
    final Proxy proxy;
    final ProxySelector proxySelector;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final String uriHost;
    final int uriPort;

    public Address(String str, int i2, SocketFactory socketFactory2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2, CertificatePinner certificatePinner2, Authenticator authenticator2, Proxy proxy2, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector2) {
        if (str == null) {
            throw new NullPointerException("uriHost == null");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: ".concat(String.valueOf(i2)));
        } else if (authenticator2 == null) {
            throw new IllegalArgumentException("authenticator == null");
        } else if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        } else if (proxySelector2 != null) {
            this.proxy = proxy2;
            this.uriHost = str;
            this.uriPort = i2;
            this.socketFactory = socketFactory2;
            this.sslSocketFactory = sSLSocketFactory;
            this.hostnameVerifier = hostnameVerifier2;
            this.certificatePinner = certificatePinner2;
            this.authenticator = authenticator2;
            this.protocols = Util.immutableList(list);
            this.connectionSpecs = Util.immutableList(list2);
            this.proxySelector = proxySelector2;
        } else {
            throw new IllegalArgumentException("proxySelector == null");
        }
    }

    public final String getUriHost() {
        return this.uriHost;
    }

    public final int getUriPort() {
        return this.uriPort;
    }

    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public final List<Protocol> getProtocols() {
        return this.protocols;
    }

    public final List<ConnectionSpec> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (!Util.equal(this.proxy, address.proxy) || !this.uriHost.equals(address.uriHost) || this.uriPort != address.uriPort || !Util.equal(this.sslSocketFactory, address.sslSocketFactory) || !Util.equal(this.hostnameVerifier, address.hostnameVerifier) || !Util.equal(this.certificatePinner, address.certificatePinner) || !Util.equal(this.authenticator, address.authenticator) || !Util.equal(this.protocols, address.protocols) || !Util.equal(this.connectionSpecs, address.connectionSpecs) || !Util.equal(this.proxySelector, address.proxySelector)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Proxy proxy2 = this.proxy;
        int i2 = 0;
        int hashCode = ((((((proxy2 != null ? proxy2.hashCode() : 0) + 527) * 31) + this.uriHost.hashCode()) * 31) + this.uriPort) * 31;
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
        int hashCode2 = (hashCode + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
        int hashCode3 = (hashCode2 + (hostnameVerifier2 != null ? hostnameVerifier2.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner2 = this.certificatePinner;
        if (certificatePinner2 != null) {
            i2 = certificatePinner2.hashCode();
        }
        return ((((((((hashCode3 + i2) * 31) + this.authenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode();
    }
}
