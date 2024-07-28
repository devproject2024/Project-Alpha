package com.google.android.exoplayer2.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.n;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.g.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class n implements ad, d {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, int[]> f32412a;

    /* renamed from: b  reason: collision with root package name */
    public static final long[] f32413b = {5400000, 3400000, 1900000, 1100000, 400000};

    /* renamed from: c  reason: collision with root package name */
    public static final long[] f32414c = {170000, 139000, 122000, 107000, 90000};

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f32415d = {2100000, 1300000, 960000, 770000, 450000};

    /* renamed from: e  reason: collision with root package name */
    public static final long[] f32416e = {6000000, 3400000, 2100000, 1400000, 570000};

    /* renamed from: f  reason: collision with root package name */
    private final Context f32417f;

    /* renamed from: g  reason: collision with root package name */
    private final SparseArray<Long> f32418g;

    /* renamed from: h  reason: collision with root package name */
    private final h<d.a> f32419h;

    /* renamed from: i  reason: collision with root package name */
    private final w f32420i;
    private final com.google.android.exoplayer2.g.b j;
    private int k;
    private long l;
    private long m;
    private int n;
    private long o;
    private long p;
    private long q;
    private long r;
    private boolean s;
    private int t;

    public final ad a() {
        return this;
    }

    public /* synthetic */ n(Context context, SparseArray sparseArray, int i2, com.google.android.exoplayer2.g.b bVar, boolean z, byte b2) {
        this(context, sparseArray, i2, bVar, z);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f32421a;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<Long> f32422b;

        /* renamed from: c  reason: collision with root package name */
        public int f32423c;

        /* renamed from: d  reason: collision with root package name */
        public com.google.android.exoplayer2.g.b f32424d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f32425e;

        public a(Context context) {
            Context context2;
            if (context == null) {
                context2 = null;
            } else {
                context2 = context.getApplicationContext();
            }
            this.f32421a = context2;
            int[] iArr = n.f32412a.get(ae.b(context));
            iArr = iArr == null ? new int[]{2, 2, 2, 2} : iArr;
            SparseArray<Long> sparseArray = new SparseArray<>(6);
            sparseArray.append(0, 1000000L);
            sparseArray.append(2, Long.valueOf(n.f32413b[iArr[0]]));
            sparseArray.append(3, Long.valueOf(n.f32414c[iArr[1]]));
            sparseArray.append(4, Long.valueOf(n.f32415d[iArr[2]]));
            sparseArray.append(5, Long.valueOf(n.f32416e[iArr[3]]));
            sparseArray.append(7, Long.valueOf(n.f32413b[iArr[0]]));
            this.f32422b = sparseArray;
            this.f32423c = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
            this.f32424d = com.google.android.exoplayer2.g.b.f32508a;
            this.f32425e = true;
        }
    }

    @Deprecated
    public n() {
        this((Context) null, new SparseArray(), H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY, com.google.android.exoplayer2.g.b.f32508a, false);
    }

    private n(Context context, SparseArray<Long> sparseArray, int i2, com.google.android.exoplayer2.g.b bVar, boolean z) {
        Context context2;
        int i3;
        if (context == null) {
            context2 = null;
        } else {
            context2 = context.getApplicationContext();
        }
        this.f32417f = context2;
        this.f32418g = sparseArray;
        this.f32419h = new h<>();
        this.f32420i = new w(i2);
        this.j = bVar;
        if (context == null) {
            i3 = 0;
        } else {
            i3 = ae.a(context);
        }
        this.n = i3;
        this.q = a(this.n);
        if (context != null && z) {
            b.a(context).a(this);
        }
    }

    public final synchronized long b() {
        return this.q;
    }

    public final void a(Handler handler, d.a aVar) {
        this.f32419h.a(handler, aVar);
    }

    public final void a(d.a aVar) {
        this.f32419h.a(aVar);
    }

    public final synchronized void a(i iVar, l lVar, boolean z) {
        if (z) {
            if (this.k == 0) {
                this.l = this.j.a();
            }
            this.k++;
        }
    }

    public final synchronized void a(i iVar, l lVar, boolean z, int i2) {
        if (z) {
            this.m += (long) i2;
        }
    }

    public final synchronized void b(i iVar, l lVar, boolean z) {
        w.a aVar;
        float f2;
        if (z) {
            int i2 = 0;
            com.google.android.exoplayer2.g.a.b(this.k > 0);
            long a2 = this.j.a();
            int i3 = (int) (a2 - this.l);
            long j2 = (long) i3;
            this.o += j2;
            this.p += this.m;
            if (i3 > 0) {
                float f3 = (float) ((this.m * 8000) / j2);
                w wVar = this.f32420i;
                int sqrt = (int) Math.sqrt((double) this.m);
                if (wVar.f32582f != 1) {
                    Collections.sort(wVar.f32580d, w.f32577a);
                    wVar.f32582f = 1;
                }
                if (wVar.f32585i > 0) {
                    w.a[] aVarArr = wVar.f32581e;
                    int i4 = wVar.f32585i - 1;
                    wVar.f32585i = i4;
                    aVar = aVarArr[i4];
                } else {
                    aVar = new w.a((byte) 0);
                }
                int i5 = wVar.f32583g;
                wVar.f32583g = i5 + 1;
                aVar.f32586a = i5;
                aVar.f32587b = sqrt;
                aVar.f32588c = f3;
                wVar.f32580d.add(aVar);
                wVar.f32584h += sqrt;
                while (wVar.f32584h > wVar.f32579c) {
                    int i6 = wVar.f32584h - wVar.f32579c;
                    w.a aVar2 = wVar.f32580d.get(0);
                    if (aVar2.f32587b <= i6) {
                        wVar.f32584h -= aVar2.f32587b;
                        wVar.f32580d.remove(0);
                        if (wVar.f32585i < 5) {
                            w.a[] aVarArr2 = wVar.f32581e;
                            int i7 = wVar.f32585i;
                            wVar.f32585i = i7 + 1;
                            aVarArr2[i7] = aVar2;
                        }
                    } else {
                        aVar2.f32587b -= i6;
                        wVar.f32584h -= i6;
                    }
                }
                if (this.o >= 2000 || this.p >= 524288) {
                    w wVar2 = this.f32420i;
                    if (wVar2.f32582f != 0) {
                        Collections.sort(wVar2.f32580d, w.f32578b);
                        wVar2.f32582f = 0;
                    }
                    float f4 = ((float) wVar2.f32584h) * 0.5f;
                    int i8 = 0;
                    while (true) {
                        if (i2 < wVar2.f32580d.size()) {
                            w.a aVar3 = wVar2.f32580d.get(i2);
                            i8 += aVar3.f32587b;
                            if (((float) i8) >= f4) {
                                f2 = aVar3.f32588c;
                                break;
                            }
                            i2++;
                        } else {
                            f2 = wVar2.f32580d.isEmpty() ? Float.NaN : wVar2.f32580d.get(wVar2.f32580d.size() - 1).f32588c;
                        }
                    }
                    this.q = (long) f2;
                }
                a(i3, this.m, this.q);
                this.l = a2;
                this.m = 0;
            }
            this.k--;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c() {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.s     // Catch:{ all -> 0x0063 }
            r1 = 0
            if (r0 == 0) goto L_0x0009
            int r0 = r10.t     // Catch:{ all -> 0x0063 }
            goto L_0x0015
        L_0x0009:
            android.content.Context r0 = r10.f32417f     // Catch:{ all -> 0x0063 }
            if (r0 != 0) goto L_0x000f
            r0 = 0
            goto L_0x0015
        L_0x000f:
            android.content.Context r0 = r10.f32417f     // Catch:{ all -> 0x0063 }
            int r0 = com.google.android.exoplayer2.g.ae.a((android.content.Context) r0)     // Catch:{ all -> 0x0063 }
        L_0x0015:
            int r2 = r10.n     // Catch:{ all -> 0x0063 }
            if (r2 != r0) goto L_0x001b
            monitor-exit(r10)
            return
        L_0x001b:
            r10.n = r0     // Catch:{ all -> 0x0063 }
            r2 = 1
            if (r0 == r2) goto L_0x0061
            if (r0 == 0) goto L_0x0061
            r2 = 8
            if (r0 != r2) goto L_0x0027
            goto L_0x0061
        L_0x0027:
            long r2 = r10.a((int) r0)     // Catch:{ all -> 0x0063 }
            r10.q = r2     // Catch:{ all -> 0x0063 }
            com.google.android.exoplayer2.g.b r0 = r10.j     // Catch:{ all -> 0x0063 }
            long r2 = r0.a()     // Catch:{ all -> 0x0063 }
            int r0 = r10.k     // Catch:{ all -> 0x0063 }
            if (r0 <= 0) goto L_0x003e
            long r4 = r10.l     // Catch:{ all -> 0x0063 }
            long r4 = r2 - r4
            int r0 = (int) r4     // Catch:{ all -> 0x0063 }
            r5 = r0
            goto L_0x003f
        L_0x003e:
            r5 = 0
        L_0x003f:
            long r6 = r10.m     // Catch:{ all -> 0x0063 }
            long r8 = r10.q     // Catch:{ all -> 0x0063 }
            r4 = r10
            r4.a((int) r5, (long) r6, (long) r8)     // Catch:{ all -> 0x0063 }
            r10.l = r2     // Catch:{ all -> 0x0063 }
            r2 = 0
            r10.m = r2     // Catch:{ all -> 0x0063 }
            r10.p = r2     // Catch:{ all -> 0x0063 }
            r10.o = r2     // Catch:{ all -> 0x0063 }
            com.google.android.exoplayer2.g.w r0 = r10.f32420i     // Catch:{ all -> 0x0063 }
            java.util.ArrayList<com.google.android.exoplayer2.g.w$a> r2 = r0.f32580d     // Catch:{ all -> 0x0063 }
            r2.clear()     // Catch:{ all -> 0x0063 }
            r2 = -1
            r0.f32582f = r2     // Catch:{ all -> 0x0063 }
            r0.f32583g = r1     // Catch:{ all -> 0x0063 }
            r0.f32584h = r1     // Catch:{ all -> 0x0063 }
            monitor-exit(r10)
            return
        L_0x0061:
            monitor-exit(r10)
            return
        L_0x0063:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.n.c():void");
    }

    private void a(int i2, long j2, long j3) {
        if (i2 != 0 || j2 != 0 || j3 != this.r) {
            this.r = j3;
            this.f32419h.a(new h.a(i2, j2, j3) {
                private final /* synthetic */ int f$0;
                private final /* synthetic */ long f$1;
                private final /* synthetic */ long f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r4;
                }

                public final void sendTo(Object obj) {
                    ((d.a) obj).k();
                }
            });
        }
    }

    private long a(int i2) {
        Long l2 = this.f32418g.get(i2);
        if (l2 == null) {
            l2 = this.f32418g.get(0);
        }
        if (l2 == null) {
            l2 = 1000000L;
        }
        return l2.longValue();
    }

    static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static b f32426a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f32427b = new Handler(Looper.getMainLooper());

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<WeakReference<n>> f32428c = new ArrayList<>();

        public static synchronized b a(Context context) {
            b bVar;
            synchronized (b.class) {
                if (f32426a == null) {
                    f32426a = new b();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.registerReceiver(f32426a, intentFilter);
                }
                bVar = f32426a;
            }
            return bVar;
        }

        private b() {
        }

        public final synchronized void a(n nVar) {
            a();
            this.f32428c.add(new WeakReference(nVar));
            this.f32427b.post(new Runnable(nVar) {
                private final /* synthetic */ n f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    n.b.this.b(this.f$1);
                }
            });
        }

        public final synchronized void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                a();
                for (int i2 = 0; i2 < this.f32428c.size(); i2++) {
                    n nVar = (n) this.f32428c.get(i2).get();
                    if (nVar != null) {
                        nVar.c();
                    }
                }
            }
        }

        private void a() {
            for (int size = this.f32428c.size() - 1; size >= 0; size--) {
                if (((n) this.f32428c.get(size).get()) == null) {
                    this.f32428c.remove(size);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(n nVar) {
            nVar.c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("AD", new int[]{1, 0, 0, 1});
        hashMap.put("AE", new int[]{1, 4, 4, 4});
        hashMap.put("AF", new int[]{4, 4, 3, 3});
        hashMap.put("AG", new int[]{3, 2, 1, 1});
        hashMap.put("AI", new int[]{1, 0, 1, 3});
        hashMap.put("AL", new int[]{1, 2, 1, 1});
        hashMap.put("AM", new int[]{2, 2, 3, 2});
        hashMap.put("AO", new int[]{3, 4, 2, 0});
        hashMap.put("AQ", new int[]{4, 2, 2, 2});
        hashMap.put("AR", new int[]{2, 3, 2, 2});
        hashMap.put("AS", new int[]{3, 3, 4, 1});
        hashMap.put("AT", new int[]{0, 2, 0, 0});
        hashMap.put("AU", new int[]{0, 1, 1, 1});
        hashMap.put("AW", new int[]{1, 1, 0, 2});
        hashMap.put("AX", new int[]{0, 2, 1, 0});
        hashMap.put("AZ", new int[]{3, 3, 2, 2});
        hashMap.put("BA", new int[]{1, 1, 1, 2});
        hashMap.put("BB", new int[]{0, 1, 0, 0});
        hashMap.put("BD", new int[]{2, 2, 3, 2});
        hashMap.put("BE", new int[]{0, 0, 0, 1});
        hashMap.put("BF", new int[]{4, 4, 3, 1});
        hashMap.put("BG", new int[]{0, 1, 0, 0});
        hashMap.put("BH", new int[]{2, 1, 3, 4});
        hashMap.put("BI", new int[]{4, 3, 4, 4});
        hashMap.put("BJ", new int[]{4, 3, 4, 4});
        hashMap.put("BL", new int[]{1, 0, 2, 3});
        hashMap.put("BM", new int[]{1, 0, 0, 0});
        hashMap.put("BN", new int[]{4, 2, 3, 3});
        hashMap.put("BO", new int[]{2, 2, 3, 2});
        hashMap.put("BQ", new int[]{1, 0, 3, 4});
        hashMap.put("BR", new int[]{2, 3, 3, 2});
        hashMap.put("BS", new int[]{2, 0, 1, 4});
        hashMap.put("BT", new int[]{3, 0, 2, 1});
        hashMap.put(P4BSettlementsDataHelperMP.MERCHANT_TYPE_BW_GA, new int[]{4, 4, 1, 2});
        hashMap.put("BY", new int[]{0, 1, 1, 2});
        hashMap.put("BZ", new int[]{2, 2, 3, 1});
        hashMap.put("CA", new int[]{0, 3, 3, 3});
        hashMap.put("CD", new int[]{4, 4, 3, 2});
        hashMap.put("CF", new int[]{4, 3, 3, 4});
        hashMap.put("CG", new int[]{4, 4, 4, 4});
        hashMap.put("CH", new int[]{0, 0, 1, 1});
        hashMap.put("CI", new int[]{3, 4, 3, 3});
        hashMap.put("CK", new int[]{2, 4, 1, 0});
        hashMap.put("CL", new int[]{2, 2, 2, 3});
        hashMap.put("CM", new int[]{3, 4, 2, 1});
        hashMap.put("CN", new int[]{2, 2, 2, 3});
        hashMap.put("CO", new int[]{2, 3, 2, 2});
        hashMap.put("CR", new int[]{2, 2, 4, 4});
        hashMap.put("CU", new int[]{4, 4, 3, 1});
        hashMap.put("CV", new int[]{2, 3, 2, 4});
        hashMap.put("CW", new int[]{1, 0, 0, 0});
        hashMap.put("CX", new int[]{2, 2, 2, 2});
        hashMap.put("CY", new int[]{1, 1, 1, 1});
        hashMap.put("CZ", new int[]{0, 1, 0, 0});
        hashMap.put("DE", new int[]{0, 2, 2, 2});
        hashMap.put("DJ", new int[]{3, 3, 4, 0});
        hashMap.put("DK", new int[]{0, 0, 0, 0});
        hashMap.put("DM", new int[]{1, 0, 0, 3});
        hashMap.put("DO", new int[]{3, 3, 4, 4});
        hashMap.put("DZ", new int[]{3, 3, 4, 4});
        hashMap.put("EC", new int[]{2, 4, 4, 2});
        hashMap.put("EE", new int[]{0, 0, 0, 0});
        hashMap.put("EG", new int[]{3, 4, 2, 2});
        hashMap.put("EH", new int[]{2, 0, 3, 3});
        hashMap.put("ER", new int[]{4, 2, 2, 2});
        hashMap.put("ES", new int[]{0, 1, 1, 1});
        hashMap.put("ET", new int[]{4, 4, 4, 0});
        hashMap.put("FI", new int[]{0, 0, 1, 0});
        hashMap.put("FJ", new int[]{3, 1, 3, 3});
        hashMap.put("FK", new int[]{4, 2, 2, 3});
        hashMap.put("FM", new int[]{4, 2, 4, 0});
        hashMap.put("FO", new int[]{0, 0, 0, 0});
        hashMap.put("FR", new int[]{1, 0, 3, 1});
        hashMap.put("GA", new int[]{3, 3, 2, 1});
        hashMap.put("GB", new int[]{0, 1, 3, 3});
        hashMap.put("GD", new int[]{2, 0, 4, 4});
        hashMap.put("GE", new int[]{1, 1, 0, 3});
        hashMap.put("GF", new int[]{1, 2, 4, 4});
        hashMap.put("GG", new int[]{0, 0, 0, 0});
        hashMap.put("GH", new int[]{3, 3, 3, 2});
        hashMap.put("GI", new int[]{0, 0, 0, 1});
        hashMap.put("GL", new int[]{2, 2, 3, 4});
        hashMap.put("GM", new int[]{4, 3, 3, 2});
        hashMap.put("GN", new int[]{4, 4, 4, 0});
        hashMap.put("GP", new int[]{2, 2, 1, 3});
        hashMap.put("GQ", new int[]{4, 3, 3, 0});
        hashMap.put("GR", new int[]{1, 1, 0, 1});
        hashMap.put("GT", new int[]{3, 3, 3, 4});
        hashMap.put("GU", new int[]{1, 2, 4, 4});
        hashMap.put("GW", new int[]{4, 4, 4, 0});
        hashMap.put("GY", new int[]{3, 4, 1, 0});
        hashMap.put("HK", new int[]{0, 1, 4, 4});
        hashMap.put("HN", new int[]{3, 3, 2, 2});
        hashMap.put("HR", new int[]{1, 0, 0, 2});
        hashMap.put("HT", new int[]{3, 4, 4, 3});
        hashMap.put("HU", new int[]{0, 0, 1, 0});
        hashMap.put("ID", new int[]{3, 2, 3, 4});
        hashMap.put("IE", new int[]{0, 0, 3, 2});
        hashMap.put("IL", new int[]{0, 1, 2, 3});
        hashMap.put("IM", new int[]{0, 0, 0, 1});
        hashMap.put("IN", new int[]{2, 2, 4, 4});
        hashMap.put(H5ThreadType.IO, new int[]{4, 4, 2, 2});
        hashMap.put("IQ", new int[]{3, 3, 4, 4});
        hashMap.put("IR", new int[]{1, 0, 1, 0});
        hashMap.put("IS", new int[]{0, 0, 0, 0});
        hashMap.put("IT", new int[]{1, 0, 1, 1});
        hashMap.put("JE", new int[]{1, 0, 0, 1});
        hashMap.put("JM", new int[]{3, 2, 2, 1});
        hashMap.put("JO", new int[]{1, 1, 1, 2});
        hashMap.put("JP", new int[]{0, 2, 2, 2});
        hashMap.put("KE", new int[]{3, 3, 3, 3});
        hashMap.put("KG", new int[]{1, 1, 2, 3});
        hashMap.put("KH", new int[]{2, 0, 4, 4});
        hashMap.put("KI", new int[]{4, 4, 4, 4});
        hashMap.put("KM", new int[]{4, 4, 3, 3});
        hashMap.put("KN", new int[]{1, 0, 1, 4});
        hashMap.put("KP", new int[]{1, 2, 0, 2});
        hashMap.put("KR", new int[]{0, 3, 0, 2});
        hashMap.put("KW", new int[]{2, 2, 1, 2});
        hashMap.put("KY", new int[]{1, 1, 0, 2});
        hashMap.put("KZ", new int[]{1, 2, 2, 2});
        hashMap.put("LA", new int[]{2, 1, 1, 0});
        hashMap.put("LB", new int[]{3, 2, 0, 0});
        hashMap.put("LC", new int[]{2, 1, 0, 0});
        hashMap.put("LI", new int[]{0, 0, 2, 2});
        hashMap.put("LK", new int[]{1, 1, 2, 2});
        hashMap.put("LR", new int[]{3, 4, 4, 1});
        hashMap.put("LS", new int[]{3, 3, 2, 0});
        hashMap.put("LT", new int[]{0, 0, 0, 0});
        hashMap.put("LU", new int[]{0, 1, 0, 0});
        hashMap.put("LV", new int[]{0, 0, 0, 0});
        hashMap.put("LY", new int[]{4, 3, 4, 4});
        hashMap.put("MA", new int[]{2, 1, 2, 2});
        hashMap.put("MC", new int[]{1, 0, 1, 0});
        hashMap.put("MD", new int[]{1, 1, 0, 0});
        hashMap.put("ME", new int[]{1, 2, 2, 3});
        hashMap.put("MF", new int[]{1, 4, 2, 1});
        hashMap.put("MG", new int[]{3, 4, 1, 3});
        hashMap.put("MH", new int[]{4, 0, 2, 3});
        hashMap.put("MK", new int[]{1, 0, 0, 0});
        hashMap.put("ML", new int[]{4, 4, 4, 3});
        hashMap.put("MM", new int[]{2, 3, 1, 2});
        hashMap.put("MN", new int[]{2, 3, 2, 4});
        hashMap.put("MO", new int[]{0, 0, 4, 4});
        hashMap.put("MP", new int[]{0, 2, 4, 4});
        hashMap.put("MQ", new int[]{1, 1, 1, 3});
        hashMap.put("MR", new int[]{4, 4, 4, 4});
        hashMap.put("MS", new int[]{1, 4, 0, 3});
        hashMap.put("MT", new int[]{0, 1, 0, 0});
        hashMap.put("MU", new int[]{2, 2, 3, 4});
        hashMap.put("MV", new int[]{3, 2, 1, 1});
        hashMap.put("MW", new int[]{4, 2, 1, 1});
        hashMap.put("MX", new int[]{2, 4, 3, 2});
        hashMap.put("MY", new int[]{2, 2, 2, 3});
        hashMap.put("MZ", new int[]{3, 4, 2, 2});
        hashMap.put("NA", new int[]{3, 2, 2, 1});
        hashMap.put("NC", new int[]{2, 1, 3, 2});
        hashMap.put("NE", new int[]{4, 4, 4, 3});
        hashMap.put("NF", new int[]{1, 2, 2, 2});
        hashMap.put("NG", new int[]{3, 4, 3, 2});
        hashMap.put("NI", new int[]{3, 3, 3, 4});
        hashMap.put("NL", new int[]{0, 2, 4, 3});
        hashMap.put(H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO, new int[]{0, 1, 0, 0});
        hashMap.put("NP", new int[]{3, 3, 2, 2});
        hashMap.put("NR", new int[]{4, 0, 4, 0});
        hashMap.put("NU", new int[]{2, 2, 2, 1});
        hashMap.put("NZ", new int[]{0, 0, 0, 1});
        hashMap.put("OM", new int[]{2, 2, 1, 3});
        hashMap.put("PA", new int[]{1, 3, 3, 4});
        hashMap.put("PE", new int[]{2, 3, 4, 4});
        hashMap.put("PF", new int[]{3, 1, 0, 1});
        hashMap.put("PG", new int[]{4, 3, 1, 1});
        hashMap.put("PH", new int[]{3, 0, 4, 4});
        hashMap.put("PK", new int[]{3, 3, 3, 3});
        hashMap.put("PL", new int[]{1, 1, 1, 3});
        hashMap.put("PM", new int[]{0, 2, 0, 0});
        hashMap.put("PR", new int[]{2, 1, 3, 3});
        hashMap.put("PS", new int[]{3, 3, 1, 4});
        hashMap.put("PT", new int[]{1, 1, 0, 1});
        hashMap.put("PW", new int[]{2, 2, 1, 1});
        hashMap.put("PY", new int[]{3, 1, 3, 3});
        hashMap.put("QA", new int[]{2, 3, 0, 1});
        hashMap.put("RE", new int[]{1, 0, 2, 2});
        hashMap.put("RO", new int[]{0, 1, 1, 2});
        hashMap.put("RS", new int[]{1, 2, 0, 0});
        hashMap.put("RU", new int[]{0, 1, 1, 1});
        hashMap.put("RW", new int[]{3, 4, 2, 4});
        hashMap.put("SA", new int[]{2, 2, 1, 2});
        hashMap.put("SB", new int[]{4, 4, 3, 0});
        hashMap.put("SC", new int[]{4, 2, 0, 1});
        hashMap.put("SD", new int[]{4, 4, 4, 2});
        hashMap.put("SE", new int[]{0, 1, 0, 0});
        hashMap.put("SG", new int[]{1, 2, 3, 3});
        hashMap.put("SH", new int[]{4, 4, 2, 3});
        hashMap.put("SI", new int[]{0, 1, 0, 1});
        hashMap.put("SJ", new int[]{0, 0, 2, 0});
        hashMap.put("SK", new int[]{0, 1, 0, 1});
        hashMap.put("SL", new int[]{4, 3, 2, 4});
        hashMap.put("SM", new int[]{0, 0, 1, 3});
        hashMap.put("SN", new int[]{4, 4, 4, 3});
        hashMap.put("SO", new int[]{4, 4, 4, 4});
        hashMap.put("SR", new int[]{3, 2, 2, 4});
        hashMap.put("SS", new int[]{4, 2, 4, 2});
        hashMap.put("ST", new int[]{3, 4, 2, 2});
        hashMap.put("SV", new int[]{2, 3, 3, 4});
        hashMap.put("SX", new int[]{2, 4, 1, 0});
        hashMap.put("SY", new int[]{4, 4, 1, 0});
        hashMap.put("SZ", new int[]{3, 4, 2, 3});
        hashMap.put("TC", new int[]{1, 1, 3, 1});
        hashMap.put("TD", new int[]{4, 4, 4, 3});
        hashMap.put("TG", new int[]{3, 3, 1, 0});
        hashMap.put("TH", new int[]{1, 3, 4, 4});
        hashMap.put("TJ", new int[]{4, 4, 4, 4});
        hashMap.put("TL", new int[]{4, 2, 4, 4});
        hashMap.put("TM", new int[]{4, 1, 2, 3});
        hashMap.put("TN", new int[]{2, 1, 1, 1});
        hashMap.put("TO", new int[]{3, 3, 3, 1});
        hashMap.put("TR", new int[]{1, 2, 0, 1});
        hashMap.put("TT", new int[]{2, 3, 1, 2});
        hashMap.put("TV", new int[]{4, 2, 2, 4});
        hashMap.put("TW", new int[]{0, 0, 0, 1});
        hashMap.put("TZ", new int[]{3, 3, 4, 3});
        hashMap.put("UA", new int[]{0, 2, 1, 2});
        hashMap.put("UG", new int[]{4, 3, 2, 3});
        hashMap.put("US", new int[]{0, 1, 3, 3});
        hashMap.put("UY", new int[]{2, 2, 2, 2});
        hashMap.put("UZ", new int[]{3, 2, 2, 2});
        hashMap.put("VA", new int[]{1, 2, 2, 2});
        hashMap.put("VC", new int[]{2, 1, 0, 0});
        hashMap.put("VE", new int[]{4, 4, 4, 3});
        hashMap.put("VG", new int[]{2, 1, 1, 2});
        hashMap.put("VI", new int[]{1, 0, 2, 4});
        hashMap.put("VN", new int[]{0, 2, 4, 4});
        hashMap.put("VU", new int[]{4, 1, 3, 1});
        hashMap.put("WS", new int[]{3, 2, 3, 1});
        hashMap.put("XK", new int[]{1, 2, 1, 0});
        hashMap.put("YE", new int[]{4, 4, 4, 2});
        hashMap.put("YT", new int[]{2, 0, 2, 3});
        hashMap.put("ZA", new int[]{2, 3, 2, 2});
        hashMap.put("ZM", new int[]{3, 3, 2, 1});
        hashMap.put("ZW", new int[]{3, 3, 3, 1});
        f32412a = Collections.unmodifiableMap(hashMap);
    }
}
