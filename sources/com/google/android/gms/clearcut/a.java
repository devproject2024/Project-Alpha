package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.clearcut.cy;
import com.google.android.gms.internal.clearcut.fd;
import com.google.android.gms.internal.clearcut.ga;
import com.google.android.gms.internal.clearcut.gd;
import com.google.android.gms.internal.clearcut.gj;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.ArrayList;
import java.util.TimeZone;

public final class a {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<Object> f8298a = new com.google.android.gms.common.api.a<>("ClearcutLogger.API", f8300c, f8299b);

    /* renamed from: b  reason: collision with root package name */
    private static final a.g<gd> f8299b = new a.g<>();

    /* renamed from: c  reason: collision with root package name */
    private static final a.C0125a<gd, Object> f8300c = new b();

    /* renamed from: d  reason: collision with root package name */
    private static final ExperimentTokens[] f8301d = new ExperimentTokens[0];

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f8302e = new String[0];

    /* renamed from: f  reason: collision with root package name */
    private static final byte[][] f8303f = new byte[0][];
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f8304g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f8305h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final int f8306i;
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public String l;
    private String m;
    /* access modifiers changed from: private */
    public final boolean n;
    /* access modifiers changed from: private */
    public fd.v.b o;
    /* access modifiers changed from: private */
    public final c p;
    /* access modifiers changed from: private */
    public final e q;
    /* access modifiers changed from: private */
    public d r;
    /* access modifiers changed from: private */
    public final b s;

    /* renamed from: com.google.android.gms.clearcut.a$a  reason: collision with other inner class name */
    public class C0123a {

        /* renamed from: a  reason: collision with root package name */
        public final ga f8307a;

        /* renamed from: b  reason: collision with root package name */
        private int f8308b;

        /* renamed from: c  reason: collision with root package name */
        private String f8309c;

        /* renamed from: d  reason: collision with root package name */
        private String f8310d;

        /* renamed from: e  reason: collision with root package name */
        private String f8311e;

        /* renamed from: f  reason: collision with root package name */
        private fd.v.b f8312f;

        /* renamed from: g  reason: collision with root package name */
        private final c f8313g;

        /* renamed from: h  reason: collision with root package name */
        private ArrayList<Integer> f8314h;

        /* renamed from: i  reason: collision with root package name */
        private ArrayList<String> f8315i;
        private ArrayList<Integer> j;
        private ArrayList<ExperimentTokens> k;
        private ArrayList<byte[]> l;
        private boolean m;
        private boolean n;

        private C0123a(a aVar, byte[] bArr) {
            this(bArr, (byte) 0);
        }

        private C0123a(byte[] bArr, byte b2) {
            this.f8308b = a.this.k;
            this.f8309c = a.this.j;
            this.f8310d = a.this.l;
            this.f8311e = null;
            this.f8312f = a.this.o;
            this.f8314h = null;
            this.f8315i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = true;
            this.f8307a = new ga();
            this.n = false;
            this.f8310d = a.this.l;
            this.f8311e = null;
            this.f8307a.f9390i = com.google.android.gms.internal.clearcut.b.a(a.this.f8304g);
            this.f8307a.f9384c = a.this.q.a();
            this.f8307a.f9385d = a.this.q.b();
            ga gaVar = this.f8307a;
            d unused = a.this.r;
            gaVar.f9388g = (long) (TimeZone.getDefault().getOffset(this.f8307a.f9384c) / 1000);
            if (bArr != null) {
                this.f8307a.f9387f = bArr;
            }
            this.f8313g = null;
        }

        /* synthetic */ C0123a(a aVar, byte[] bArr, char c2) {
            this(aVar, bArr);
        }

        public final void a() {
            if (!this.n) {
                this.n = true;
                zze zze = new zze(new zzr(a.this.f8305h, a.this.f8306i, this.f8308b, this.f8309c, this.f8310d, this.f8311e, a.this.n, this.f8312f), this.f8307a, a.a(), a.a(), this.m);
                if (a.this.s.a(zze)) {
                    a.this.p.a(zze);
                } else {
                    h.a(Status.f8354a, (com.google.android.gms.common.api.e) null);
                }
            } else {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
        }
    }

    public interface b {
        boolean a(zze zze);
    }

    public interface c {
        byte[] a();
    }

    public static class d {
    }

    public a(Context context, String str) {
        this(context, str, false, cy.a(context), com.google.android.gms.common.util.h.d(), new gj(context));
    }

    private a(Context context, String str, boolean z, c cVar, e eVar, b bVar) {
        this.k = -1;
        this.o = fd.v.b.DEFAULT;
        this.f8304g = context;
        this.f8305h = context.getPackageName();
        this.f8306i = a(context);
        this.k = -1;
        this.j = str;
        this.l = null;
        this.m = null;
        this.n = z;
        this.p = cVar;
        this.q = eVar;
        this.r = new d();
        this.o = fd.v.b.DEFAULT;
        this.s = bVar;
        if (z) {
            s.b(true, "can't be anonymous with an upload account");
        }
    }

    private static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.wtf("ClearcutLogger", "This can't happen.", e2);
            return 0;
        }
    }

    public static a a(Context context, String str) {
        return new a(context, str, true, cy.a(context), com.google.android.gms.common.util.h.d(), new gj(context));
    }

    static /* synthetic */ int[] a() {
        return null;
    }

    public final C0123a a(byte[] bArr) {
        return new C0123a(this, bArr, 0);
    }
}
