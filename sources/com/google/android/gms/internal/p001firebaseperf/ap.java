package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.ak;
import com.google.android.gms.internal.p001firebaseperf.dq;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.ap  reason: invalid package */
public final class ap extends dq<ap, a> implements ez {
    private static volatile fi<ap> zzin;
    /* access modifiers changed from: private */
    public static final ap zzja = new ap();
    public int zzii;
    private String zzit = "";
    private String zziu = "";
    private ak zziv;
    private bf zziw;
    private ce zzix;
    private int zziy;
    private er<String, String> zziz = er.zzii();

    /* renamed from: com.google.android.gms.internal.firebase-perf.ap$b */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final ep<String, String> f9499a = ep.a(gu.STRING, "", gu.STRING, "");
    }

    private ap() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.ap$a */
    public static final class a extends dq.a<ap, a> implements ez {
        private a() {
            super(ap.zzja);
        }

        public final a a(String str) {
            h();
            ap.a((ap) this.f9565a, str);
            return this;
        }

        public final boolean a() {
            return ((ap) this.f9565a).a();
        }

        public final a b(String str) {
            h();
            ap.b((ap) this.f9565a, str);
            return this;
        }

        public final a a(ak.a aVar) {
            h();
            ap.a((ap) this.f9565a, aVar);
            return this;
        }

        public final a a(ar arVar) {
            h();
            ap.a((ap) this.f9565a, arVar);
            return this;
        }

        public final a a(Map<String, String> map) {
            h();
            ap.a((ap) this.f9565a).putAll(map);
            return this;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean a() {
        return (this.zzii & 2) != 0;
    }

    public final ak b() {
        ak akVar = this.zziv;
        return akVar == null ? ak.b() : akVar;
    }

    public static a c() {
        return (a) zzja.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (aq.f9500a[i2 - 1]) {
            case 1:
                return new ap();
            case 2:
                return new a((byte) 0);
            case 3:
                return a((ex) zzja, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\t\u0002\u0004\t\u0003\u0005\f\u0005\u00062\u0007\t\u0004", new Object[]{"zzii", "zzit", "zziu", "zziv", "zziw", "zziy", ar.zzdq(), "zziz", b.f9499a, "zzix"});
            case 4:
                return zzja;
            case 5:
                fi<ap> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (ap.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzja);
                            zzin = fiVar;
                        }
                    }
                }
                return fiVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static ap d() {
        return zzja;
    }

    static {
        dq.a(ap.class, zzja);
    }

    static /* synthetic */ void a(ap apVar, String str) {
        if (str != null) {
            apVar.zzii |= 1;
            apVar.zzit = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void b(ap apVar, String str) {
        if (str != null) {
            apVar.zzii |= 2;
            apVar.zziu = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(ap apVar, ak.a aVar) {
        apVar.zziv = (ak) aVar.k();
        apVar.zzii |= 4;
    }

    static /* synthetic */ void a(ap apVar, ar arVar) {
        if (arVar != null) {
            apVar.zzii |= 32;
            apVar.zziy = arVar.zzdp();
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ Map a(ap apVar) {
        if (!apVar.zziz.isMutable()) {
            apVar.zziz = apVar.zziz.zzij();
        }
        return apVar.zziz;
    }
}
