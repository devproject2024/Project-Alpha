package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.b;
import com.google.firebase.crashlytics.a.e.c;
import com.google.firebase.crashlytics.a.e.d;
import com.google.firebase.crashlytics.a.e.e;
import com.google.firebase.crashlytics.a.e.f;
import com.google.firebase.crashlytics.a.e.g;
import com.google.firebase.crashlytics.a.e.i;
import com.google.firebase.crashlytics.a.e.j;
import com.google.firebase.crashlytics.a.e.k;
import com.google.firebase.crashlytics.a.e.l;
import com.google.firebase.crashlytics.a.e.m;
import com.google.firebase.crashlytics.a.e.n;
import com.google.firebase.crashlytics.a.e.o;
import com.google.firebase.crashlytics.a.e.p;
import com.google.firebase.crashlytics.a.e.q;
import com.google.firebase.crashlytics.a.e.r;
import com.google.firebase.crashlytics.a.e.s;
import com.google.firebase.crashlytics.a.e.t;
import com.google.firebase.crashlytics.a.e.u;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;

public abstract class v {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f38572a = Charset.forName(AppConstants.UTF_8);

    public static abstract class a {
        public abstract a a(int i2);

        public abstract a a(c cVar);

        public abstract a a(d dVar);

        public abstract a a(String str);

        public abstract v a();

        public abstract a b(String str);

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(String str);
    }

    public enum e {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    public abstract String a();

    public abstract String b();

    public abstract int c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract d g();

    public abstract c h();

    /* access modifiers changed from: protected */
    public abstract a i();

    public static a j() {
        return new b.a();
    }

    public final e k() {
        if (g() != null) {
            return e.JAVA;
        }
        if (h() != null) {
            return e.NATIVE;
        }
        return e.INCOMPLETE;
    }

    public final v a(w<d.C0634d> wVar) {
        if (g() != null) {
            return i().a(g().l().a(wVar).a()).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public final v a(long j, boolean z, String str) {
        a i2 = i();
        if (g() != null) {
            d.b l = g().l();
            l.a(Long.valueOf(j));
            l.a(z);
            if (str != null) {
                l.a(d.f.b().a(str).a()).a();
            }
            i2.a(l.a());
        }
        return i2.a();
    }

    public static abstract class c {

        public static abstract class a {
            public abstract a a(w<b> wVar);

            public abstract a a(String str);

            public abstract c a();
        }

        public abstract w<b> a();

        public abstract String b();

        public static a c() {
            return new d.a();
        }

        public static abstract class b {

            public static abstract class a {
                public abstract a a(String str);

                public abstract a a(byte[] bArr);

                public abstract b a();
            }

            public abstract String a();

            public abstract byte[] b();

            public static a c() {
                return new e.a();
            }
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract a a(String str);

            public abstract b a();

            public abstract a b(String str);
        }

        public abstract String a();

        public abstract String b();

        public static a c() {
            return new c.a();
        }
    }

    public static abstract class d {

        public static abstract class b {
            public abstract b a(int i2);

            public abstract b a(long j);

            public abstract b a(a aVar);

            public abstract b a(c cVar);

            public abstract b a(e eVar);

            public abstract b a(f fVar);

            public abstract b a(w<C0634d> wVar);

            public abstract b a(Long l);

            public abstract b a(String str);

            public abstract b a(boolean z);

            public abstract d a();

            public abstract b b(String str);
        }

        public abstract String a();

        public abstract String b();

        public abstract long c();

        public abstract Long d();

        public abstract boolean e();

        public abstract a f();

        public abstract f g();

        public abstract e h();

        public abstract c i();

        public abstract w<C0634d> j();

        public abstract int k();

        public abstract b l();

        public static b m() {
            return new f.a().a(false);
        }

        public static abstract class f {

            public static abstract class a {
                public abstract a a(String str);

                public abstract f a();
            }

            public abstract String a();

            public static a b() {
                return new u.a();
            }
        }

        public static abstract class a {

            /* renamed from: com.google.firebase.crashlytics.a.e.v$d$a$a  reason: collision with other inner class name */
            public static abstract class C0633a {
                public abstract C0633a a(String str);

                public abstract a a();

                public abstract C0633a b(String str);

                public abstract C0633a c(String str);

                public abstract C0633a d(String str);
            }

            public static abstract class b {
                public abstract String a();
            }

            public abstract String a();

            public abstract String b();

            public abstract String c();

            public abstract b d();

            public abstract String e();

            public static C0633a f() {
                return new g.a();
            }
        }

        public static abstract class e {

            public static abstract class a {
                public abstract a a(int i2);

                public abstract a a(String str);

                public abstract a a(boolean z);

                public abstract e a();

                public abstract a b(String str);
            }

            public abstract int a();

            public abstract String b();

            public abstract String c();

            public abstract boolean d();

            public static a e() {
                return new t.a();
            }
        }

        public static abstract class c {

            public static abstract class a {
                public abstract a a(int i2);

                public abstract a a(long j);

                public abstract a a(String str);

                public abstract a a(boolean z);

                public abstract c a();

                public abstract a b(int i2);

                public abstract a b(long j);

                public abstract a b(String str);

                public abstract a c(int i2);

                public abstract a c(String str);
            }

            public abstract int a();

            public abstract String b();

            public abstract int c();

            public abstract long d();

            public abstract long e();

            public abstract boolean f();

            public abstract int g();

            public abstract String h();

            public abstract String i();

            public static a j() {
                return new i.a();
            }
        }

        /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d  reason: collision with other inner class name */
        public static abstract class C0634d {

            /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$b */
            public static abstract class b {
                public abstract b a(long j);

                public abstract b a(a aVar);

                public abstract b a(c cVar);

                public abstract b a(C0645d dVar);

                public abstract b a(String str);

                public abstract C0634d a();
            }

            public abstract long a();

            public abstract String b();

            public abstract a c();

            public abstract c d();

            public abstract C0645d e();

            public abstract b f();

            public static b g() {
                return new j.a();
            }

            /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a */
            public static abstract class a {

                /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$a  reason: collision with other inner class name */
                public static abstract class C0635a {
                    public abstract C0635a a(int i2);

                    public abstract C0635a a(b bVar);

                    public abstract C0635a a(w<b> wVar);

                    public abstract C0635a a(Boolean bool);

                    public abstract a a();
                }

                public abstract b a();

                public abstract w<b> b();

                public abstract Boolean c();

                public abstract int d();

                public abstract C0635a e();

                public static C0635a f() {
                    return new k.a();
                }

                /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b */
                public static abstract class b {

                    /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$b  reason: collision with other inner class name */
                    public static abstract class C0638b {
                        public abstract C0638b a(c cVar);

                        public abstract C0638b a(C0640d dVar);

                        public abstract C0638b a(w<e> wVar);

                        public abstract b a();

                        public abstract C0638b b(w<C0636a> wVar);
                    }

                    public abstract w<e> a();

                    public abstract c b();

                    public abstract C0640d c();

                    public abstract w<C0636a> d();

                    public static C0638b e() {
                        return new l.a();
                    }

                    /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$e */
                    public static abstract class e {

                        /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$e$a  reason: collision with other inner class name */
                        public static abstract class C0642a {
                            public abstract C0642a a(int i2);

                            public abstract C0642a a(w<C0643b> wVar);

                            public abstract C0642a a(String str);

                            public abstract e a();
                        }

                        public abstract String a();

                        public abstract int b();

                        public abstract w<C0643b> c();

                        public static C0642a d() {
                            return new p.a();
                        }

                        /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$e$b  reason: collision with other inner class name */
                        public static abstract class C0643b {

                            /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$e$b$a  reason: collision with other inner class name */
                            public static abstract class C0644a {
                                public abstract C0644a a(int i2);

                                public abstract C0644a a(long j);

                                public abstract C0644a a(String str);

                                public abstract C0643b a();

                                public abstract C0644a b(long j);

                                public abstract C0644a b(String str);
                            }

                            public abstract long a();

                            public abstract String b();

                            public abstract String c();

                            public abstract long d();

                            public abstract int e();

                            public static C0644a f() {
                                return new q.a();
                            }
                        }
                    }

                    /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$c */
                    public static abstract class c {

                        /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$c$a  reason: collision with other inner class name */
                        public static abstract class C0639a {
                            public abstract C0639a a(int i2);

                            public abstract C0639a a(c cVar);

                            public abstract C0639a a(w<e.C0643b> wVar);

                            public abstract C0639a a(String str);

                            public abstract c a();

                            public abstract C0639a b(String str);
                        }

                        public abstract String a();

                        public abstract String b();

                        public abstract w<e.C0643b> c();

                        public abstract c d();

                        public abstract int e();

                        public static C0639a f() {
                            return new n.a();
                        }
                    }

                    /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$d  reason: collision with other inner class name */
                    public static abstract class C0640d {

                        /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$d$a  reason: collision with other inner class name */
                        public static abstract class C0641a {
                            public abstract C0641a a(long j);

                            public abstract C0641a a(String str);

                            public abstract C0640d a();

                            public abstract C0641a b(String str);
                        }

                        public abstract String a();

                        public abstract String b();

                        public abstract long c();

                        public static C0641a d() {
                            return new o.a();
                        }
                    }

                    /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$a  reason: collision with other inner class name */
                    public static abstract class C0636a {

                        /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$a$b$a$a  reason: collision with other inner class name */
                        public static abstract class C0637a {
                            public abstract C0637a a(long j);

                            public abstract C0637a a(String str);

                            public abstract C0636a a();

                            public abstract C0637a b(long j);

                            public abstract C0637a b(String str);
                        }

                        public abstract long a();

                        public abstract long b();

                        public abstract String c();

                        public abstract String d();

                        public static C0637a e() {
                            return new m.a();
                        }
                    }
                }
            }

            /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$c */
            public static abstract class c {

                /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$c$a */
                public static abstract class a {
                    public abstract a a(int i2);

                    public abstract a a(long j);

                    public abstract a a(Double d2);

                    public abstract a a(boolean z);

                    public abstract c a();

                    public abstract a b(int i2);

                    public abstract a b(long j);
                }

                public abstract Double a();

                public abstract int b();

                public abstract boolean c();

                public abstract int d();

                public abstract long e();

                public abstract long f();

                public static a g() {
                    return new r.a();
                }
            }

            /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$d  reason: collision with other inner class name */
            public static abstract class C0645d {

                /* renamed from: com.google.firebase.crashlytics.a.e.v$d$d$d$a */
                public static abstract class a {
                    public abstract a a(String str);

                    public abstract C0645d a();
                }

                public abstract String a();

                public static a b() {
                    return new s.a();
                }
            }
        }
    }
}
