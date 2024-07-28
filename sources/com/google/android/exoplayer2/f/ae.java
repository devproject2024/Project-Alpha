package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public final class ae extends e {

    /* renamed from: a  reason: collision with root package name */
    private final int f32361a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f32362b;

    /* renamed from: c  reason: collision with root package name */
    private final DatagramPacket f32363c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f32364d;

    /* renamed from: e  reason: collision with root package name */
    private DatagramSocket f32365e;

    /* renamed from: f  reason: collision with root package name */
    private MulticastSocket f32366f;

    /* renamed from: g  reason: collision with root package name */
    private InetAddress f32367g;

    /* renamed from: h  reason: collision with root package name */
    private InetSocketAddress f32368h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f32369i;
    private int j;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public ae() {
        this((byte) 0);
    }

    private ae(byte b2) {
        this(0);
    }

    private ae(char c2) {
        super(true);
        this.f32361a = 8000;
        this.f32362b = new byte[H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY];
        this.f32363c = new DatagramPacket(this.f32362b, 0, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY);
    }

    public final long a(l lVar) throws a {
        this.f32364d = lVar.f32395a;
        String host = this.f32364d.getHost();
        int port = this.f32364d.getPort();
        d();
        try {
            this.f32367g = InetAddress.getByName(host);
            this.f32368h = new InetSocketAddress(this.f32367g, port);
            if (this.f32367g.isMulticastAddress()) {
                this.f32366f = new MulticastSocket(this.f32368h);
                this.f32366f.joinGroup(this.f32367g);
                this.f32365e = this.f32366f;
            } else {
                this.f32365e = new DatagramSocket(this.f32368h);
            }
            try {
                this.f32365e.setSoTimeout(this.f32361a);
                this.f32369i = true;
                b(lVar);
                return -1;
            } catch (SocketException e2) {
                throw new a(e2);
            }
        } catch (IOException e3) {
            throw new a(e3);
        }
    }

    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        if (this.j == 0) {
            try {
                this.f32365e.receive(this.f32363c);
                this.j = this.f32363c.getLength();
                a(this.j);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int length = this.f32363c.getLength();
        int i4 = this.j;
        int min = Math.min(i4, i3);
        System.arraycopy(this.f32362b, length - i4, bArr, i2, min);
        this.j -= min;
        return min;
    }

    public final Uri a() {
        return this.f32364d;
    }

    public final void c() {
        this.f32364d = null;
        MulticastSocket multicastSocket = this.f32366f;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f32367g);
            } catch (IOException unused) {
            }
            this.f32366f = null;
        }
        DatagramSocket datagramSocket = this.f32365e;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f32365e = null;
        }
        this.f32367g = null;
        this.f32368h = null;
        this.j = 0;
        if (this.f32369i) {
            this.f32369i = false;
            e();
        }
    }
}
