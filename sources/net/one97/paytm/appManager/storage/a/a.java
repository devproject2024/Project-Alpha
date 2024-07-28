package net.one97.paytm.appManager.storage.a;

import android.util.LruCache;
import kotlin.g.b.k;
import kotlin.x;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0865a f49048b = new C0865a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f49049c;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, Object> f49050a;

    private a() {
        this.f49050a = new LruCache<>(200);
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public final void a(String str, Object obj) {
        synchronized (a.class) {
            this.f49050a.put(str, obj);
        }
    }

    public final Object a(String str) {
        return this.f49050a.get(str);
    }

    /* renamed from: net.one97.paytm.appManager.storage.a.a$a  reason: collision with other inner class name */
    public static final class C0865a {
        private C0865a() {
        }

        public /* synthetic */ C0865a(byte b2) {
            this();
        }

        public static a a() {
            if (a.f49049c == null) {
                synchronized (a.class) {
                    if (a.f49049c == null) {
                        a.f49049c = new a((byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            a a2 = a.f49049c;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
