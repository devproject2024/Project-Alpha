package com.alipay.mobile.rome.syncsdk.d.d;

import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.d.b.b;
import com.alipay.mobile.rome.syncsdk.d.b.c;
import com.alipay.mobile.rome.syncsdk.e.e;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.o;
import java.io.DataInputStream;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15075a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Thread f15076b = new e(this);

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f15077c = false;

    /* renamed from: d  reason: collision with root package name */
    private DataInputStream f15078d;

    /* renamed from: e  reason: collision with root package name */
    private a f15079e;

    public d(a aVar) {
        this.f15079e = aVar;
        this.f15078d = aVar.f15055c;
        this.f15076b.setName("longLink Packet Reader");
        this.f15076b.setDaemon(true);
    }

    static /* synthetic */ void a(d dVar) {
        h.b(f15075a, "parsePackets: reader ");
        while (!dVar.f15077c) {
            try {
                byte[] bArr = new byte[b.f15029c];
                dVar.f15078d.readFully(bArr, 0, b.f15029c);
                a a2 = c.a(dVar.f15079e.f15058f);
                a2.c(bArr);
                int c2 = a2.c();
                h.b(f15075a, "parsePackets: reader dataLen:".concat(String.valueOf(c2)));
                if (c2 < 0 || c2 > 10485760) {
                    throw new Exception("parsePackets dataLen exception [ dataLen=" + c2 + " ][" + a2.f() + "]");
                }
                byte[] bArr2 = new byte[c2];
                dVar.f15078d.readFully(bArr2, 0, c2);
                if (a2.d() == 1) {
                    a2.b(bArr2);
                } else {
                    a2.a(bArr2);
                }
                h.a(f15075a, "recvPacket: reader  ");
                if (!a.a(a2)) {
                    h.d(f15075a, "recvPacket: it's unsupported packet!");
                } else {
                    a aVar = dVar.f15079e;
                    if (aVar.f15053a != null && aVar.f15053a.b(a2)) {
                        o.f15102a.a(e.SYNC_RECEIVE, new b(aVar, a2));
                    }
                }
            } catch (Exception e2) {
                String str = f15075a;
                h.d(str, "parsePackets: [ link is disconnected ][ Exception=" + e2 + " ][ isDone=" + dVar.f15077c + " ]");
                if (!dVar.f15077c) {
                    dVar.f15077c = true;
                    dVar.f15079e.a(e2);
                    return;
                }
                return;
            }
        }
    }
}
