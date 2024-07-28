package com.google.firebase.perf.network;

import com.google.android.gms.internal.p001firebaseperf.t;
import com.google.android.gms.internal.p001firebaseperf.zzbg;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class c extends HttpsURLConnection {

    /* renamed from: a  reason: collision with root package name */
    private final f f39290a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpsURLConnection f39291b;

    c(HttpsURLConnection httpsURLConnection, zzbg zzbg, t tVar) {
        super(httpsURLConnection.getURL());
        this.f39291b = httpsURLConnection;
        this.f39290a = new f(httpsURLConnection, zzbg, tVar);
    }

    public final void connect() throws IOException {
        this.f39290a.a();
    }

    public final void disconnect() {
        this.f39290a.b();
    }

    public final Object getContent() throws IOException {
        return this.f39290a.c();
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        return this.f39290a.a(clsArr);
    }

    public final InputStream getInputStream() throws IOException {
        return this.f39290a.d();
    }

    public final long getLastModified() {
        return this.f39290a.e();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.f39290a.f();
    }

    public final Permission getPermission() throws IOException {
        return this.f39290a.g();
    }

    public final int getResponseCode() throws IOException {
        return this.f39290a.h();
    }

    public final String getResponseMessage() throws IOException {
        return this.f39290a.i();
    }

    public final long getExpiration() {
        return this.f39290a.j();
    }

    public final String getHeaderField(int i2) {
        return this.f39290a.a(i2);
    }

    public final String getHeaderField(String str) {
        return this.f39290a.a(str);
    }

    public final long getHeaderFieldDate(String str, long j) {
        return this.f39290a.a(str, j);
    }

    public final int getHeaderFieldInt(String str, int i2) {
        return this.f39290a.a(str, i2);
    }

    public final long getHeaderFieldLong(String str, long j) {
        return this.f39290a.b(str, j);
    }

    public final String getHeaderFieldKey(int i2) {
        return this.f39290a.b(i2);
    }

    public final Map<String, List<String>> getHeaderFields() {
        return this.f39290a.k();
    }

    public final String getContentEncoding() {
        return this.f39290a.l();
    }

    public final int getContentLength() {
        return this.f39290a.m();
    }

    public final long getContentLengthLong() {
        return this.f39290a.n();
    }

    public final String getContentType() {
        return this.f39290a.o();
    }

    public final long getDate() {
        return this.f39290a.p();
    }

    public final void addRequestProperty(String str, String str2) {
        this.f39290a.a(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.f39290a.equals(obj);
    }

    public final boolean getAllowUserInteraction() {
        return this.f39290a.f39296a.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.f39290a.f39296a.getConnectTimeout();
    }

    public final boolean getDefaultUseCaches() {
        return this.f39290a.f39296a.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.f39290a.f39296a.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.f39290a.f39296a.getDoOutput();
    }

    public final InputStream getErrorStream() {
        return this.f39290a.q();
    }

    public final long getIfModifiedSince() {
        return this.f39290a.f39296a.getIfModifiedSince();
    }

    public final boolean getInstanceFollowRedirects() {
        return this.f39290a.f39296a.getInstanceFollowRedirects();
    }

    public final int getReadTimeout() {
        return this.f39290a.f39296a.getReadTimeout();
    }

    public final String getRequestMethod() {
        return this.f39290a.f39296a.getRequestMethod();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.f39290a.f39296a.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.f39290a.b(str);
    }

    public final URL getURL() {
        return this.f39290a.f39296a.getURL();
    }

    public final boolean getUseCaches() {
        return this.f39290a.f39296a.getUseCaches();
    }

    public final int hashCode() {
        return this.f39290a.hashCode();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.f39290a.a(z);
    }

    public final void setChunkedStreamingMode(int i2) {
        this.f39290a.c(i2);
    }

    public final void setConnectTimeout(int i2) {
        this.f39290a.d(i2);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.f39290a.b(z);
    }

    public final void setDoInput(boolean z) {
        this.f39290a.c(z);
    }

    public final void setDoOutput(boolean z) {
        this.f39290a.d(z);
    }

    public final void setFixedLengthStreamingMode(int i2) {
        this.f39290a.e(i2);
    }

    public final void setFixedLengthStreamingMode(long j) {
        this.f39290a.a(j);
    }

    public final void setIfModifiedSince(long j) {
        this.f39290a.b(j);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.f39290a.e(z);
    }

    public final void setReadTimeout(int i2) {
        this.f39290a.f(i2);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        this.f39290a.c(str);
    }

    public final void setRequestProperty(String str, String str2) {
        this.f39290a.b(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.f39290a.f(z);
    }

    public final String toString() {
        return this.f39290a.toString();
    }

    public final boolean usingProxy() {
        return this.f39290a.f39296a.usingProxy();
    }

    public final String getCipherSuite() {
        return this.f39291b.getCipherSuite();
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.f39291b.getHostnameVerifier();
    }

    public final Certificate[] getLocalCertificates() {
        return this.f39291b.getLocalCertificates();
    }

    public final Principal getLocalPrincipal() {
        return this.f39291b.getLocalPrincipal();
    }

    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.f39291b.getPeerPrincipal();
    }

    public final Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return this.f39291b.getServerCertificates();
    }

    public final SSLSocketFactory getSSLSocketFactory() {
        return this.f39291b.getSSLSocketFactory();
    }

    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f39291b.setHostnameVerifier(hostnameVerifier);
    }

    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f39291b.setSSLSocketFactory(sSLSocketFactory);
    }
}
