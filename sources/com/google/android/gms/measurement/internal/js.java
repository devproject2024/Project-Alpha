package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class js extends SSLSocket {

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocket f12294a;

    js(SSLSocket sSLSocket) {
        this.f12294a = sSLSocket;
    }

    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f12294a.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f12294a.setEnabledProtocols(strArr);
    }

    public final String[] getSupportedCipherSuites() {
        return this.f12294a.getSupportedCipherSuites();
    }

    public final String[] getEnabledCipherSuites() {
        return this.f12294a.getEnabledCipherSuites();
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        this.f12294a.setEnabledCipherSuites(strArr);
    }

    public final String[] getSupportedProtocols() {
        return this.f12294a.getSupportedProtocols();
    }

    public final String[] getEnabledProtocols() {
        return this.f12294a.getEnabledProtocols();
    }

    public final SSLSession getSession() {
        return this.f12294a.getSession();
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f12294a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f12294a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    public final void startHandshake() throws IOException {
        this.f12294a.startHandshake();
    }

    public final void setUseClientMode(boolean z) {
        this.f12294a.setUseClientMode(z);
    }

    public final boolean getUseClientMode() {
        return this.f12294a.getUseClientMode();
    }

    public final void setNeedClientAuth(boolean z) {
        this.f12294a.setNeedClientAuth(z);
    }

    public final void setWantClientAuth(boolean z) {
        this.f12294a.setWantClientAuth(z);
    }

    public final boolean getNeedClientAuth() {
        return this.f12294a.getNeedClientAuth();
    }

    public final boolean getWantClientAuth() {
        return this.f12294a.getWantClientAuth();
    }

    public final void setEnableSessionCreation(boolean z) {
        this.f12294a.setEnableSessionCreation(z);
    }

    public final boolean getEnableSessionCreation() {
        return this.f12294a.getEnableSessionCreation();
    }

    public final void bind(SocketAddress socketAddress) throws IOException {
        this.f12294a.bind(socketAddress);
    }

    public final synchronized void close() throws IOException {
        this.f12294a.close();
    }

    public final void connect(SocketAddress socketAddress) throws IOException {
        this.f12294a.connect(socketAddress);
    }

    public final void connect(SocketAddress socketAddress, int i2) throws IOException {
        this.f12294a.connect(socketAddress, i2);
    }

    public final SocketChannel getChannel() {
        return this.f12294a.getChannel();
    }

    public final InetAddress getInetAddress() {
        return this.f12294a.getInetAddress();
    }

    public final InputStream getInputStream() throws IOException {
        return this.f12294a.getInputStream();
    }

    public final boolean getKeepAlive() throws SocketException {
        return this.f12294a.getKeepAlive();
    }

    public final InetAddress getLocalAddress() {
        return this.f12294a.getLocalAddress();
    }

    public final int getLocalPort() {
        return this.f12294a.getLocalPort();
    }

    public final SocketAddress getLocalSocketAddress() {
        return this.f12294a.getLocalSocketAddress();
    }

    public final boolean getOOBInline() throws SocketException {
        return this.f12294a.getOOBInline();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.f12294a.getOutputStream();
    }

    public final int getPort() {
        return this.f12294a.getPort();
    }

    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.f12294a.getReceiveBufferSize();
    }

    public final SocketAddress getRemoteSocketAddress() {
        return this.f12294a.getRemoteSocketAddress();
    }

    public final boolean getReuseAddress() throws SocketException {
        return this.f12294a.getReuseAddress();
    }

    public final synchronized int getSendBufferSize() throws SocketException {
        return this.f12294a.getSendBufferSize();
    }

    public final int getSoLinger() throws SocketException {
        return this.f12294a.getSoLinger();
    }

    public final synchronized int getSoTimeout() throws SocketException {
        return this.f12294a.getSoTimeout();
    }

    public final boolean getTcpNoDelay() throws SocketException {
        return this.f12294a.getTcpNoDelay();
    }

    public final int getTrafficClass() throws SocketException {
        return this.f12294a.getTrafficClass();
    }

    public final boolean isBound() {
        return this.f12294a.isBound();
    }

    public final boolean isClosed() {
        return this.f12294a.isClosed();
    }

    public final boolean isConnected() {
        return this.f12294a.isConnected();
    }

    public final boolean isInputShutdown() {
        return this.f12294a.isInputShutdown();
    }

    public final boolean isOutputShutdown() {
        return this.f12294a.isOutputShutdown();
    }

    public final void sendUrgentData(int i2) throws IOException {
        this.f12294a.sendUrgentData(i2);
    }

    public final void setKeepAlive(boolean z) throws SocketException {
        this.f12294a.setKeepAlive(z);
    }

    public final void setOOBInline(boolean z) throws SocketException {
        this.f12294a.setOOBInline(z);
    }

    public final void setPerformancePreferences(int i2, int i3, int i4) {
        this.f12294a.setPerformancePreferences(i2, i3, i4);
    }

    public final synchronized void setReceiveBufferSize(int i2) throws SocketException {
        this.f12294a.setReceiveBufferSize(i2);
    }

    public final void setReuseAddress(boolean z) throws SocketException {
        this.f12294a.setReuseAddress(z);
    }

    public final synchronized void setSendBufferSize(int i2) throws SocketException {
        this.f12294a.setSendBufferSize(i2);
    }

    public final void setSoLinger(boolean z, int i2) throws SocketException {
        this.f12294a.setSoLinger(z, i2);
    }

    public final synchronized void setSoTimeout(int i2) throws SocketException {
        this.f12294a.setSoTimeout(i2);
    }

    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.f12294a.setTcpNoDelay(z);
    }

    public final void setTrafficClass(int i2) throws SocketException {
        this.f12294a.setTrafficClass(i2);
    }

    public final void shutdownInput() throws IOException {
        this.f12294a.shutdownInput();
    }

    public final void shutdownOutput() throws IOException {
        this.f12294a.shutdownOutput();
    }

    public final String toString() {
        return this.f12294a.toString();
    }

    public final boolean equals(Object obj) {
        return this.f12294a.equals(obj);
    }
}
