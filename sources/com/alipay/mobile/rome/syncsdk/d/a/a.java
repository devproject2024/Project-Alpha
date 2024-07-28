package com.alipay.mobile.rome.syncsdk.d.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.d.d.a.b;
import com.alipay.mobile.rome.syncsdk.d.d.c;
import com.alipay.mobile.rome.syncsdk.d.d.d;
import com.alipay.mobile.rome.syncsdk.d.d.f;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.LongLinkService;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class a extends com.alipay.mobile.rome.syncsdk.d.d.a {

    /* renamed from: g  reason: collision with root package name */
    private static final String f15016g = a.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private volatile Socket f15017h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f15018i = false;
    private volatile f j;
    private volatile d k;

    public a(c cVar) {
        super(cVar);
    }

    public final void a() {
        h.b(f15016g, "setConnected [ true ]");
        this.f15018i = true;
    }

    public final void b() {
        h.b(f15016g, "initReaderWriter: ");
        try {
            this.f15055c = new DataInputStream(this.f15017h.getInputStream());
            this.f15056d = new DataOutputStream(this.f15017h.getOutputStream());
            this.j = new f(this);
            this.k = new d(this);
            this.k.f15076b.start();
        } catch (Exception e2) {
            String str = f15016g;
            h.d(str, "initReaderWriter: [ Exception=" + e2 + " ]");
            throw e2;
        }
    }

    public final void c() {
        String str = this.f15057e.f15069a;
        int i2 = this.f15057e.f15070b;
        boolean z = this.f15057e.f15071c;
        com.alipay.mobile.rome.syncsdk.d.d.a.a aVar = this.f15057e.f15073e;
        String str2 = f15016g;
        h.b(str2, "connect: [ host=" + str + " ][ port=" + i2 + " ][ sslUsed=" + z + " ][ verifyInfo=" + this.f15057e.f15072d + " ][ proxyInfo=" + aVar + " ]");
        if (!z) {
            try {
                this.f15017h = this.f15057e.f15073e.a().createSocket(str, i2);
            } catch (Exception e2) {
                String str3 = f15016g;
                h.d(str3, "connect: [ connectUsingConfiguration failed ][ Exception=" + e2 + " ]");
                if (this.f15017h != null) {
                    this.f15017h.close();
                }
                throw e2;
            }
        } else {
            String str4 = this.f15057e.f15072d;
            if (b.HTTP == aVar.f15062d) {
                this.f15017h = this.f15057e.f15073e.a().createSocket(str, i2);
                this.f15017h.setTcpNoDelay(true);
                SSLSocket sSLSocket = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(this.f15017h, str, i2, true);
                sSLSocket.setUseClientMode(true);
                sSLSocket.setSoTimeout(aVar.f15061c * 1000);
                sSLSocket.startHandshake();
                sSLSocket.setSoTimeout(0);
                if (!TextUtils.isEmpty(str4)) {
                    SSLSession session = sSLSocket.getSession();
                    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str4, session)) {
                        h.d(f15016g, "ssl hostname verify failed!");
                        StringBuilder sb = new StringBuilder();
                        sb.append("proxyHost:" + this.f15057e.f15073e.f15059a);
                        sb.append(" proxyPort:" + this.f15057e.f15073e.f15060b);
                        sb.append(" hostname:".concat(String.valueOf(str)));
                        sb.append(" err:hostname verify failed");
                        sb.append(" PeerPrincipal:" + session.getPeerPrincipal());
                        throw new Exception(sb.toString());
                    }
                }
                this.f15017h = sSLSocket;
            } else {
                this.f15017h = this.f15057e.f15073e.a().createSocket(str, i2);
                this.f15017h.setTcpNoDelay(true);
                SSLSocket sSLSocket2 = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(this.f15017h, str, i2, true);
                sSLSocket2.setUseClientMode(true);
                sSLSocket2.setSoTimeout(aVar.f15061c * 1000);
                sSLSocket2.startHandshake();
                sSLSocket2.setSoTimeout(0);
                if (!TextUtils.isEmpty(str4)) {
                    SSLSession session2 = sSLSocket2.getSession();
                    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str4, session2)) {
                        h.d(f15016g, "ssl hostname verify failed!");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("proxy:null ");
                        sb2.append("hostname:" + str + " ");
                        sb2.append("err:hostname verify failed ");
                        sb2.append("PeerPrincipal:" + session2.getPeerPrincipal());
                        throw new Exception(sb2.toString());
                    }
                }
                this.f15017h = sSLSocket2;
            }
        }
        if (this.f15017h != null) {
            h.b(f15016g, "connect: [ connectUsingConfiguration success ]");
            return;
        }
        throw new Exception("create socket failed");
    }

    public final void d() {
        h.b(f15016g, "disconnect: ");
        if (this.f15018i && LongLinkService.b() != null) {
            LongLinkService.b().u();
        }
        this.f15018i = false;
        this.f15053a = null;
        this.f15054b = null;
        try {
            if (this.k != null) {
                d dVar = this.k;
                h.b(d.f15075a, "shutdown: ");
                dVar.f15077c = true;
                if (dVar.f15076b != null && dVar.f15076b.isAlive()) {
                    dVar.f15076b.interrupt();
                }
                this.k = null;
            }
            if (this.j != null) {
                f fVar = this.j;
                h.b(f.f15081a, "shutdown: ");
                fVar.f15084d = true;
                this.j = null;
            }
        } catch (Exception e2) {
            String str = f15016g;
            h.d(str, "disconnect: shutdown[ Exception " + e2 + " ]");
        }
        if (this.f15055c != null) {
            try {
                this.f15055c.close();
            } catch (Exception e3) {
                String str2 = f15016g;
                h.d(str2, "disconnect: reader close[ Exception " + e3 + " ]");
            }
            this.f15055c = null;
        }
        if (this.f15056d != null) {
            try {
                this.f15056d.close();
            } catch (Exception e4) {
                String str3 = f15016g;
                h.d(str3, "disconnect: writer close[ Exception " + e4 + " ]");
            }
            this.f15056d = null;
        }
        try {
            if (this.f15017h != null) {
                this.f15017h.close();
            }
        } catch (Exception e5) {
            String str4 = f15016g;
            h.d(str4, "disconnect: socket close[ Exception " + e5 + " ]");
        }
        this.f15017h = null;
    }

    public final void a(Exception exc) {
        String str = f15016g;
        h.d(str, "notifyError: [ Exception" + exc + " ]");
        h.b(f15016g, "onConnectionError: [ LongLinkConnection ] ");
        LongLinkService.b().a();
        LongLinkService.b().a((com.alipay.mobile.rome.syncsdk.d.d.a) null);
        d();
        com.alipay.mobile.rome.syncsdk.a.c.c();
        if (!com.alipay.mobile.rome.syncsdk.a.c.a() && com.alipay.mobile.rome.syncsdk.a.c.f()) {
            com.alipay.mobile.rome.syncsdk.service.h.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
        }
    }

    public final void a(com.alipay.mobile.rome.syncsdk.d.b.a aVar) {
        String str = f15016g;
        h.b(str, "isConnected [" + this.f15018i + " ]");
        if (!this.f15018i) {
            throw new IllegalStateException("not connected to server");
        } else if (aVar != null) {
            try {
                f fVar = this.j;
                h.b(f.f15081a, "sendPacket ");
                if (fVar.f15084d) {
                    throw new Exception("already done");
                } else if (aVar == null) {
                    try {
                        String str2 = f.f15081a;
                        h.d(str2, "sendPacket: [ packet=" + aVar + " ]");
                    } catch (Exception e2) {
                        String str3 = f.f15081a;
                        h.d(str3, "sendPacket: [ link is disconnected ][ Exception" + e2 + " ][ isDone " + fVar.f15084d + " ]");
                        if (!fVar.f15084d) {
                            fVar.f15084d = true;
                            fVar.f15083c.a(e2);
                        }
                    }
                } else {
                    fVar.f15082b.write(aVar.g());
                    fVar.f15082b.flush();
                }
            } catch (Exception e3) {
                String str4 = f15016g;
                h.d(str4, "sendPacket: [ Exception=" + e3 + " ]");
                throw e3;
            }
        } else {
            throw new Exception("Packet is null");
        }
    }
}
