package com.alipay.imobile.network.quake.b;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public interface a {

    /* renamed from: com.alipay.imobile.network.quake.b.a$a  reason: collision with other inner class name */
    public static class C0201a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f14718a;

        /* renamed from: b  reason: collision with root package name */
        public String f14719b;

        /* renamed from: c  reason: collision with root package name */
        public long f14720c;

        /* renamed from: d  reason: collision with root package name */
        public long f14721d;

        /* renamed from: e  reason: collision with root package name */
        public long f14722e;

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f14723f = Collections.emptyMap();
    }

    C0201a a(String str) throws IOException;

    void a(String str, C0201a aVar) throws IOException;

    boolean a();

    void b();

    void b(String str);
}
