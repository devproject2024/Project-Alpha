package com.alipay.imobile.network.quake.h.a;

import com.alipay.imobile.network.quake.c;
import com.alipay.imobile.network.quake.d.a.a;
import com.alipay.imobile.network.quake.e;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public final class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private a f14861c;

    public d() {
        try {
            this.f14861c = new a();
            String str = c.f14737a;
            com.alipay.iap.android.common.b.c.e();
        } catch (ClassNotFoundException unused) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                this.f14861c = new i(com.alipay.imobile.network.b.a.a(instance.getSocketFactory()));
                String str2 = c.f14737a;
                com.alipay.iap.android.common.b.c.e();
            } catch (GeneralSecurityException unused2) {
                String str3 = c.f14737a;
                com.alipay.iap.android.common.b.c.e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final f a(e eVar, Map<String, String> map) throws IOException, com.alipay.mobile.b.b.a {
        return this.f14861c.a(eVar, map);
    }

    public final void a(e eVar, com.alipay.imobile.network.quake.h.d dVar) {
        this.f14861c.a(eVar, dVar);
    }
}
