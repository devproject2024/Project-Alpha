package com.alipay.mobile.rome.syncsdk.service.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.d.d.a.a;
import com.alipay.mobile.rome.syncsdk.d.d.a.b;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.j;
import org.apache.http.HttpHost;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15120a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final com.alipay.mobile.rome.syncsdk.service.c f15121b;

    public c(com.alipay.mobile.rome.syncsdk.service.c cVar) {
        this.f15121b = cVar;
    }

    public void run() {
        a aVar;
        String a2 = com.alipay.mobile.rome.syncsdk.d.a.a();
        String str = f15120a;
        h.b(str, "ConnectTask: run [ transChannel=" + a2 + " ]");
        this.f15121b.d();
        if (this.f15121b.p()) {
            h.c(f15120a, "run: ConnectTask: [ already connected ] [ isConnected=ture ]");
        } else if (TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().h()) || TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().i())) {
            h.d(f15120a, "run: ConnectTask: [ host or port is null ]");
        } else {
            this.f15121b.a();
            h.b(f15120a, "connectByHttps: ");
            HttpHost a3 = j.a();
            if (a3 != null) {
                aVar = new a(b.HTTP, a3.getHostName(), a3.getPort());
            } else {
                aVar = new a(b.NONE, (String) null, 0);
            }
            com.alipay.mobile.rome.syncsdk.d.d.c cVar = new com.alipay.mobile.rome.syncsdk.d.d.c(com.alipay.mobile.rome.syncsdk.a.a.a().h(), Integer.parseInt(com.alipay.mobile.rome.syncsdk.a.a.a().i()), aVar);
            cVar.f15071c = com.alipay.mobile.rome.syncsdk.a.a.a().j();
            cVar.f15072d = com.alipay.mobile.rome.syncsdk.a.a.a().k();
            com.alipay.mobile.rome.syncsdk.d.a.a aVar2 = new com.alipay.mobile.rome.syncsdk.d.a.a(cVar);
            try {
                aVar2.f15058f = this.f15121b.m();
                this.f15121b.t();
                long currentTimeMillis = System.currentTimeMillis();
                aVar2.c();
                aVar2.a();
                aVar2.b();
                aVar2.f15053a = new com.alipay.mobile.rome.syncsdk.d.c.b(this.f15121b);
                this.f15121b.a((com.alipay.mobile.rome.syncsdk.d.d.a) aVar2);
                this.f15121b.c(System.currentTimeMillis() - currentTimeMillis);
                this.f15121b.g();
            } catch (Exception e2) {
                String str2 = f15120a;
                h.d(str2, "connectByHttps: [ Exception=" + e2 + " ]");
                this.f15121b.a();
                this.f15121b.a((com.alipay.mobile.rome.syncsdk.d.d.a) null);
                this.f15121b.a(e2.toString());
                aVar2.d();
                com.alipay.mobile.rome.syncsdk.a.c.c();
                if (!com.alipay.mobile.rome.syncsdk.a.c.a() && com.alipay.mobile.rome.syncsdk.a.c.f()) {
                    com.alipay.mobile.rome.syncsdk.service.h.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
                }
            }
        }
    }
}
