package com.google.android.gms.internal.p001firebaseperf;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.gms.internal.p001firebaseperf.dq;
import net.one97.paytm.upi.util.UpiConstants;

/* renamed from: com.google.android.gms.internal.firebase-perf.bj  reason: invalid package */
public final class bj extends dq<bj, b> implements ez {
    private static volatile fi<bj> zzin;
    /* access modifiers changed from: private */
    public static final bj zzky = new bj();
    public int zzii;
    private er<String, String> zziz = er.zzii();
    public String zzkm = "";
    private int zzkn;
    public long zzko;
    public long zzkp;
    private int zzkq;
    public int zzkr;
    private String zzks = "";
    public long zzkt;
    public long zzku;
    public long zzkv;
    public long zzkw;
    public dz<bq> zzkx = fn.d();

    /* renamed from: com.google.android.gms.internal.firebase-perf.bj$a */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final ep<String, String> f9509a = ep.a(gu.STRING, "", gu.STRING, "");
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bj$c */
    public enum c implements ds {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        zzlf(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        
        private static final dv<c> zzjf = null;
        private final int value;

        public final int zzdp() {
            return this.value;
        }

        public static c zzm(int i2) {
            switch (i2) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return zzlf;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static du zzdq() {
            return bl.f9510a;
        }

        private c(int i2) {
            this.value = i2;
        }

        static {
            zzjf = new bk();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bj$d */
    public enum d implements ds {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        
        private static final dv<d> zzjf = null;
        private final int value;

        public final int zzdp() {
            return this.value;
        }

        public static du zzdq() {
            return bm.f9511a;
        }

        private d(int i2) {
            this.value = i2;
        }

        static {
            zzjf = new bn();
        }
    }

    private bj() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.bj$b */
    public static final class b extends dq.a<bj, b> implements ez {
        private b() {
            super(bj.zzky);
        }

        public final b a(String str) {
            h();
            bj.a((bj) this.f9565a, str);
            return this;
        }

        public final b a(c cVar) {
            h();
            bj.a((bj) this.f9565a, cVar);
            return this;
        }

        public final b a(long j) {
            h();
            bj.a((bj) this.f9565a, j);
            return this;
        }

        public final b b(long j) {
            h();
            bj.b((bj) this.f9565a, j);
            return this;
        }

        public final b a(d dVar) {
            h();
            bj.a((bj) this.f9565a, dVar);
            return this;
        }

        public final boolean a() {
            return ((bj) this.f9565a).c();
        }

        public final b a(int i2) {
            h();
            bj.a((bj) this.f9565a, i2);
            return this;
        }

        public final b b(String str) {
            h();
            bj.b((bj) this.f9565a, str);
            return this;
        }

        public final b b() {
            h();
            bj.a((bj) this.f9565a);
            return this;
        }

        public final boolean c() {
            return ((bj) this.f9565a).d();
        }

        public final b c(long j) {
            h();
            bj.c((bj) this.f9565a, j);
            return this;
        }

        public final b d(long j) {
            h();
            bj.d((bj) this.f9565a, j);
            return this;
        }

        public final long d() {
            return ((bj) this.f9565a).zzkv;
        }

        public final b e(long j) {
            h();
            bj.e((bj) this.f9565a, j);
            return this;
        }

        public final boolean e() {
            return ((bj) this.f9565a).e();
        }

        public final b f(long j) {
            h();
            bj.f((bj) this.f9565a, j);
            return this;
        }

        public final b a(Iterable<? extends bq> iterable) {
            h();
            bj.a((bj) this.f9565a, (Iterable) iterable);
            return this;
        }

        public final b f() {
            h();
            ((bj) this.f9565a).zzkx = fn.d();
            return this;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final c a() {
        c zzm = c.zzm(this.zzkn);
        return zzm == null ? c.HTTP_METHOD_UNKNOWN : zzm;
    }

    public final boolean b() {
        return (this.zzii & 8) != 0;
    }

    public final boolean c() {
        return (this.zzii & 32) != 0;
    }

    public final boolean d() {
        return (this.zzii & 128) != 0;
    }

    public final boolean e() {
        return (this.zzii & TarConstants.EOF_BLOCK) != 0;
    }

    public static b f() {
        return (b) zzky.l();
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2) {
        switch (bi.f9508a[i2 - 1]) {
            case 1:
                return new bj();
            case 2:
                return new b((byte) 0);
            case 3:
                return a((ex) zzky, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0004\u0005\u0006\b\u0006\u0007\u0002\u0007\b\u0002\b\t\u0002\t\n\u0002\n\u000b\f\u0004\f2\r\u001b", new Object[]{"zzii", "zzkm", "zzkn", c.zzdq(), "zzko", "zzkp", "zzkr", "zzks", "zzkt", "zzku", "zzkv", "zzkw", "zzkq", d.zzdq(), "zziz", a.f9509a, "zzkx", bq.class});
            case 4:
                return zzky;
            case 5:
                fi<bj> fiVar = zzin;
                if (fiVar == null) {
                    synchronized (bj.class) {
                        fiVar = zzin;
                        if (fiVar == null) {
                            fiVar = new dq.c<>(zzky);
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

    public static bj g() {
        return zzky;
    }

    static {
        dq.a(bj.class, zzky);
    }

    static /* synthetic */ void a(bj bjVar, String str) {
        if (str != null) {
            bjVar.zzii |= 1;
            bjVar.zzkm = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bj bjVar, c cVar) {
        if (cVar != null) {
            bjVar.zzii |= 2;
            bjVar.zzkn = cVar.zzdp();
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bj bjVar, long j) {
        bjVar.zzii |= 4;
        bjVar.zzko = j;
    }

    static /* synthetic */ void b(bj bjVar, long j) {
        bjVar.zzii |= 8;
        bjVar.zzkp = j;
    }

    static /* synthetic */ void a(bj bjVar, d dVar) {
        if (dVar != null) {
            bjVar.zzii |= 16;
            bjVar.zzkq = dVar.zzdp();
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bj bjVar, int i2) {
        bjVar.zzii |= 32;
        bjVar.zzkr = i2;
    }

    static /* synthetic */ void b(bj bjVar, String str) {
        if (str != null) {
            bjVar.zzii |= 64;
            bjVar.zzks = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void a(bj bjVar) {
        bjVar.zzii &= -65;
        bjVar.zzks = zzky.zzks;
    }

    static /* synthetic */ void c(bj bjVar, long j) {
        bjVar.zzii |= 128;
        bjVar.zzkt = j;
    }

    static /* synthetic */ void d(bj bjVar, long j) {
        bjVar.zzii |= UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        bjVar.zzku = j;
    }

    static /* synthetic */ void e(bj bjVar, long j) {
        bjVar.zzii |= 512;
        bjVar.zzkv = j;
    }

    static /* synthetic */ void f(bj bjVar, long j) {
        bjVar.zzii |= TarConstants.EOF_BLOCK;
        bjVar.zzkw = j;
    }

    static /* synthetic */ void a(bj bjVar, Iterable iterable) {
        if (!bjVar.zzkx.a()) {
            bjVar.zzkx = dq.a(bjVar.zzkx);
        }
        ci.a(iterable, bjVar.zzkx);
    }
}
