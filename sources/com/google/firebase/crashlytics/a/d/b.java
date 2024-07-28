package com.google.firebase.crashlytics.a.d;

import android.content.Context;
import com.google.firebase.crashlytics.a.c.g;
import java.io.File;
import java.util.Set;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final C0629b f38332b = new C0629b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public a f38333a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f38334c;

    /* renamed from: d  reason: collision with root package name */
    private final a f38335d;

    public interface a {
        File a();
    }

    public b(Context context, a aVar) {
        this(context, aVar, (byte) 0);
    }

    private b(Context context, a aVar, byte b2) {
        this.f38334c = context;
        this.f38335d = aVar;
        this.f38333a = f38332b;
        a((String) null);
    }

    public final void a(String str) {
        this.f38333a.c();
        this.f38333a = f38332b;
        if (str != null) {
            if (!g.a(this.f38334c, "com.crashlytics.CollectCustomLogs")) {
                com.google.firebase.crashlytics.a.b.a().a(3);
            } else {
                a(b(str));
            }
        }
    }

    public final String a() {
        return this.f38333a.b();
    }

    public final void a(Set<String> set) {
        File[] listFiles = this.f38335d.a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(".temp");
                if (lastIndexOf != -1) {
                    name = name.substring(20, lastIndexOf);
                }
                if (!set.contains(name)) {
                    file.delete();
                }
            }
        }
    }

    private void a(File file) {
        this.f38333a = new d(file);
    }

    private File b(String str) {
        return new File(this.f38335d.a(), "crashlytics-userlog-" + str + ".temp");
    }

    /* renamed from: com.google.firebase.crashlytics.a.d.b$b  reason: collision with other inner class name */
    static final class C0629b implements a {
        public final void a(long j, String str) {
        }

        public final byte[] a() {
            return null;
        }

        public final String b() {
            return null;
        }

        public final void c() {
        }

        public final void d() {
        }

        private C0629b() {
        }

        /* synthetic */ C0629b(byte b2) {
            this();
        }
    }
}
