package com.travel.train.a;

import com.travel.train.a.a.b;
import java.util.HashMap;
import kotlin.g.b.k;
import org.json.JSONObject;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0484a f25797a = new C0484a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f25798c;

    /* renamed from: b  reason: collision with root package name */
    private final b f25799b;

    public static final a a(b bVar) {
        return f25797a.a(bVar);
    }

    public a(b bVar) {
        k.c(bVar, "trainRemoteDataSource");
        this.f25799b = bVar;
    }

    /* renamed from: com.travel.train.a.a$a  reason: collision with other inner class name */
    public static final class C0484a {
        private C0484a() {
        }

        public /* synthetic */ C0484a(byte b2) {
            this();
        }

        public final a a(b bVar) {
            a aVar;
            k.c(bVar, "trainRemoteDataSource");
            a b2 = a.f25798c;
            if (b2 != null) {
                return b2;
            }
            synchronized (this) {
                aVar = new a(bVar);
                a.f25798c = aVar;
            }
            return aVar;
        }
    }

    public final com.paytm.network.a a() {
        return this.f25799b.a();
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f25799b.a(bVar, bVar2, hashMap, hashMap2, jSONObject);
    }

    public final void b(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        b bVar3 = this.f25799b;
        if (bVar3 != null) {
            bVar3.b(bVar, bVar2, hashMap, hashMap2, jSONObject);
        }
    }

    public final void c(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f25799b.c(bVar, bVar2, hashMap, hashMap2, jSONObject);
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f25799b.a(bVar, bVar2, hashMap, hashMap2);
    }

    public final void b(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f25799b.b(bVar, bVar2, hashMap, hashMap2);
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, String str) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(str, "trainNumber");
        this.f25799b.a(bVar, bVar2, hashMap, str);
    }

    public final void c(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        b bVar3 = this.f25799b;
        if (bVar3 != null) {
            bVar3.c(bVar, bVar2, hashMap, hashMap2);
        }
    }

    public final void d(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f25799b.d(bVar, bVar2, hashMap, hashMap2);
    }

    public final void a(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        this.f25799b.a(bVar, bVar2, hashMap);
    }

    public final void b(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        this.f25799b.b(bVar, bVar2, hashMap);
    }

    public final void c(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        this.f25799b.c(bVar, bVar2, hashMap);
    }

    public final void e(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f25799b.e(bVar, bVar2, hashMap, hashMap2);
    }

    public final void d(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        this.f25799b.d(bVar, bVar2, hashMap);
    }

    public final void f(com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f25799b.f(bVar, bVar2, hashMap, hashMap2);
    }

    public final void a(String str, com.paytm.network.listener.b bVar, com.paytm.network.listener.b bVar2, HashMap<String, String> hashMap) {
        k.c(str, "url");
        k.c(bVar, "onApiSuccess");
        k.c(bVar2, "handleErrorCode");
        k.c(hashMap, "headers");
        this.f25799b.a(str, bVar, bVar2, hashMap);
    }
}
