package com.alipay.mobile.rome.syncsdk.d.d.a;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import javax.net.SocketFactory;

final class c extends SocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private int f15063a = 15;

    public final void a(int i2) {
        if (i2 > 0) {
            this.f15063a = i2;
        }
    }

    public final Socket createSocket(String str, int i2) {
        Socket socket = new Socket(Proxy.NO_PROXY);
        socket.connect(new InetSocketAddress(str, i2), this.f15063a * 1000);
        return socket;
    }

    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        return new Socket(str, i2, inetAddress, i3);
    }

    public final Socket createSocket(InetAddress inetAddress, int i2) {
        Socket socket = new Socket(Proxy.NO_PROXY);
        socket.connect(new InetSocketAddress(inetAddress, i2), this.f15063a * 1000);
        return socket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        return new Socket(inetAddress, i2, inetAddress2, i3);
    }
}
