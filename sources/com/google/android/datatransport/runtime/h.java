package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class h {
    public abstract String a();

    public abstract Integer b();

    public abstract g c();

    public abstract long d();

    public abstract long e();

    /* access modifiers changed from: protected */
    public abstract Map<String, String> f();

    public final Map<String, String> g() {
        return Collections.unmodifiableMap(f());
    }

    public final int a(String str) {
        String str2 = f().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long b(String str) {
        String str2 = f().get(str);
        if (str2 == null) {
            return 0;
        }
        return Long.valueOf(str2).longValue();
    }

    public final String c(String str) {
        String str2 = f().get(str);
        return str2 == null ? "" : str2;
    }

    public final a h() {
        return new a.C0114a().a(a()).a(b()).a(c()).a(d()).b(e()).a((Map<String, String>) new HashMap(f()));
    }

    public static a i() {
        a.C0114a aVar = new a.C0114a();
        aVar.f7727a = new HashMap();
        return aVar;
    }

    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(g gVar);

        public abstract a a(Integer num);

        public abstract a a(String str);

        /* access modifiers changed from: protected */
        public abstract a a(Map<String, String> map);

        /* access modifiers changed from: protected */
        public abstract Map<String, String> a();

        public abstract a b(long j);

        public abstract h b();

        public final a a(String str, String str2) {
            a().put(str, str2);
            return this;
        }

        public final a a(String str, long j) {
            a().put(str, String.valueOf(j));
            return this;
        }

        public final a a(String str, int i2) {
            a().put(str, String.valueOf(i2));
            return this;
        }
    }
}
