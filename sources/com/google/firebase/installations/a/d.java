package com.google.firebase.installations.a;

import com.google.firebase.installations.a.a;
import com.google.firebase.installations.a.c;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f38938a = m().a();

    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(c.a aVar);

        public abstract a a(String str);

        public abstract d a();

        public abstract a b(long j);

        public abstract a b(String str);

        public abstract a c(String str);

        public abstract a d(String str);
    }

    public abstract String a();

    public abstract c.a b();

    public abstract String c();

    public abstract String d();

    public abstract long e();

    public abstract long f();

    public abstract String g();

    public abstract a h();

    public final boolean i() {
        return b() == c.a.REGISTERED;
    }

    public final boolean j() {
        return b() == c.a.REGISTER_ERROR;
    }

    public final boolean k() {
        return b() == c.a.UNREGISTERED;
    }

    public final boolean l() {
        return b() == c.a.NOT_GENERATED || b() == c.a.ATTEMPT_MIGRATION;
    }

    public final d a(String str) {
        return h().d(str).a(c.a.REGISTER_ERROR).a();
    }

    public static a m() {
        return new a.C0649a().b(0).a(c.a.ATTEMPT_MIGRATION).a(0);
    }
}
