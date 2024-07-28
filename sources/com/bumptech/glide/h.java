package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.a.b;
import com.bumptech.glide.e.a.d;
import com.bumptech.glide.e.a.k;
import com.bumptech.glide.e.c;
import com.bumptech.glide.e.f;
import com.bumptech.glide.e.g;
import com.bumptech.glide.g.e;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.d.a.n;
import com.bumptech.glide.load.d.a.s;
import com.bumptech.glide.load.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public final class h<TranscodeType> extends a<h<TranscodeType>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected static final com.bumptech.glide.e.h f6658a = ((com.bumptech.glide.e.h) ((com.bumptech.glide.e.h) ((com.bumptech.glide.e.h) new com.bumptech.glide.e.h().a(j.f6877c)).a(f.LOW)).a(true));
    private final Context C;
    private final i D;
    private final Class<TranscodeType> E;
    private final b F;
    private final d G;
    private j<?, ? super TranscodeType> H;
    private Object I;
    private List<g<TranscodeType>> J;
    private h<TranscodeType> K;
    private Float L;
    private boolean M = true;
    private boolean N;
    private boolean O;

    /* renamed from: b  reason: collision with root package name */
    public h<TranscodeType> f6659b;

    protected h(b bVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.F = bVar;
        this.D = iVar;
        this.E = cls;
        this.C = context;
        this.H = iVar.a(cls);
        this.G = bVar.f6426b;
        for (g<Object> b2 : iVar.f6668d) {
            b(b2);
        }
        b((a<?>) iVar.g());
    }

    public final h<TranscodeType> a(g<TranscodeType> gVar) {
        this.J = null;
        return b(gVar);
    }

    public final h<TranscodeType> b(g<TranscodeType> gVar) {
        if (gVar != null) {
            if (this.J == null) {
                this.J = new ArrayList();
            }
            this.J.add(gVar);
        }
        return this;
    }

    public final h<TranscodeType> a(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.L = Float.valueOf(f2);
        return this;
    }

    public final h<TranscodeType> a(Object obj) {
        return b(obj);
    }

    public final h<TranscodeType> b(Object obj) {
        this.I = obj;
        this.N = true;
        return this;
    }

    public final h<TranscodeType> a(Drawable drawable) {
        return b((Object) drawable).b((a<?>) com.bumptech.glide.e.h.b(j.f6876b));
    }

    public final h<TranscodeType> a(String str) {
        return b((Object) str);
    }

    public final h<TranscodeType> a(Integer num) {
        return b((Object) num).b((a<?>) com.bumptech.glide.e.h.b(com.bumptech.glide.f.a.a(this.C)));
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public h<TranscodeType> clone() {
        h<TranscodeType> hVar = (h) super.clone();
        hVar.H = hVar.H.clone();
        return hVar;
    }

    public final <Y extends com.bumptech.glide.e.a.j<TranscodeType>> Y a(Y y) {
        return a(y, (g) null, e.a());
    }

    private <Y extends com.bumptech.glide.e.a.j<TranscodeType>> Y a(Y y, g<TranscodeType> gVar, Executor executor) {
        return a(y, gVar, this, executor);
    }

    public final k<ImageView, TranscodeType> a(ImageView imageView) {
        a aVar;
        com.bumptech.glide.e.a.j jVar;
        com.bumptech.glide.g.k.a();
        com.bumptech.glide.g.j.a(imageView, "Argument must not be null");
        if (!super.d((int) EmiUtil.EMI_PLAN_REQUEST_CODE) && this.p && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f6660a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = clone().a(n.f7154e, (m<Bitmap>) new com.bumptech.glide.load.d.a.j());
                    break;
                case 2:
                    aVar = clone().h();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = super.a(n.f7152c, (m<Bitmap>) new s(), false);
                    break;
                case 6:
                    aVar = clone().h();
                    break;
            }
        }
        aVar = this;
        Class<TranscodeType> cls = this.E;
        if (Bitmap.class.equals(cls)) {
            jVar = new b(imageView);
        } else if (Drawable.class.isAssignableFrom(cls)) {
            jVar = new d(imageView);
        } else {
            throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
        }
        return (k) a(jVar, (g) null, aVar, e.a());
    }

    /* renamed from: com.bumptech.glide.h$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6660a = new int[ImageView.ScaleType.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f6661b = new int[f.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        static {
            /*
                com.bumptech.glide.f[] r0 = com.bumptech.glide.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6661b = r0
                r0 = 1
                int[] r1 = f6661b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bumptech.glide.f r2 = com.bumptech.glide.f.LOW     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f6661b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bumptech.glide.f r3 = com.bumptech.glide.f.NORMAL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f6661b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.bumptech.glide.f r4 = com.bumptech.glide.f.HIGH     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f6661b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.bumptech.glide.f r5 = com.bumptech.glide.f.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f6660a = r4
                int[] r4 = f6660a     // Catch:{ NoSuchFieldError -> 0x0048 }
                android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f6660a     // Catch:{ NoSuchFieldError -> 0x0052 }
                android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f6660a     // Catch:{ NoSuchFieldError -> 0x005c }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f6660a     // Catch:{ NoSuchFieldError -> 0x0066 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                int[] r0 = f6660a     // Catch:{ NoSuchFieldError -> 0x0071 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f6660a     // Catch:{ NoSuchFieldError -> 0x007c }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                int[] r0 = f6660a     // Catch:{ NoSuchFieldError -> 0x0087 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f6660a     // Catch:{ NoSuchFieldError -> 0x0093 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.h.AnonymousClass1.<clinit>():void");
        }
    }

    private f b(f fVar) {
        int i2 = AnonymousClass1.f6661b[fVar.ordinal()];
        if (i2 == 1) {
            return f.NORMAL;
        }
        if (i2 == 2) {
            return f.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return f.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + this.f6508f);
    }

    private com.bumptech.glide.e.d b(com.bumptech.glide.e.a.j<TranscodeType> jVar, g<TranscodeType> gVar, a<?> aVar, Executor executor) {
        return a(new Object(), jVar, gVar, (com.bumptech.glide.e.e) null, this.H, aVar.f6508f, aVar.m, aVar.l, aVar, executor);
    }

    private com.bumptech.glide.e.d a(Object obj, com.bumptech.glide.e.a.j<TranscodeType> jVar, g<TranscodeType> gVar, com.bumptech.glide.e.e eVar, j<?, ? super TranscodeType> jVar2, f fVar, int i2, int i3, a<?> aVar, Executor executor) {
        com.bumptech.glide.e.b bVar;
        com.bumptech.glide.e.b bVar2;
        a<?> aVar2 = aVar;
        if (this.K != null) {
            bVar2 = new com.bumptech.glide.e.b(obj, eVar);
            bVar = bVar2;
        } else {
            Object obj2 = obj;
            bVar = null;
            bVar2 = eVar;
        }
        com.bumptech.glide.e.d b2 = b(obj, jVar, gVar, bVar2, jVar2, fVar, i2, i3, aVar, executor);
        if (bVar == null) {
            return b2;
        }
        int i4 = this.K.m;
        int i5 = this.K.l;
        if (com.bumptech.glide.g.k.a(i2, i3) && !this.K.n()) {
            i4 = aVar2.m;
            i5 = aVar2.l;
        }
        h<TranscodeType> hVar = this.K;
        com.bumptech.glide.e.b bVar3 = bVar;
        bVar3.a(b2, hVar.a(obj, jVar, gVar, (com.bumptech.glide.e.e) bVar3, hVar.H, hVar.f6508f, i4, i5, (a<?>) this.K, executor));
        return bVar3;
    }

    /* JADX WARNING: type inference failed for: r28v0, types: [com.bumptech.glide.e.a<?>, com.bumptech.glide.e.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.e.d b(java.lang.Object r20, com.bumptech.glide.e.a.j<TranscodeType> r21, com.bumptech.glide.e.g<TranscodeType> r22, com.bumptech.glide.e.e r23, com.bumptech.glide.j<?, ? super TranscodeType> r24, com.bumptech.glide.f r25, int r26, int r27, com.bumptech.glide.e.a<?> r28, java.util.concurrent.Executor r29) {
        /*
            r19 = this;
            r11 = r19
            r12 = r20
            r5 = r23
            r13 = r25
            r14 = r28
            com.bumptech.glide.h<TranscodeType> r0 = r11.f6659b
            if (r0 == 0) goto L_0x008f
            boolean r1 = r11.O
            if (r1 != 0) goto L_0x0087
            com.bumptech.glide.j<?, ? super TranscodeType> r1 = r0.H
            boolean r0 = r0.M
            if (r0 == 0) goto L_0x001b
            r15 = r24
            goto L_0x001c
        L_0x001b:
            r15 = r1
        L_0x001c:
            com.bumptech.glide.h<TranscodeType> r0 = r11.f6659b
            r1 = 8
            boolean r0 = super.d((int) r1)
            if (r0 == 0) goto L_0x002b
            com.bumptech.glide.h<TranscodeType> r0 = r11.f6659b
            com.bumptech.glide.f r0 = r0.f6508f
            goto L_0x002f
        L_0x002b:
            com.bumptech.glide.f r0 = r11.b((com.bumptech.glide.f) r13)
        L_0x002f:
            r16 = r0
            com.bumptech.glide.h<TranscodeType> r0 = r11.f6659b
            int r0 = r0.m
            com.bumptech.glide.h<TranscodeType> r1 = r11.f6659b
            int r1 = r1.l
            boolean r2 = com.bumptech.glide.g.k.a((int) r26, (int) r27)
            if (r2 == 0) goto L_0x004b
            com.bumptech.glide.h<TranscodeType> r2 = r11.f6659b
            boolean r2 = r2.n()
            if (r2 != 0) goto L_0x004b
            int r0 = r14.m
            int r1 = r14.l
        L_0x004b:
            r17 = r0
            r18 = r1
            com.bumptech.glide.e.k r10 = new com.bumptech.glide.e.k
            r10.<init>(r12, r5)
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r28
            r5 = r10
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r13 = r10
            r10 = r29
            com.bumptech.glide.e.d r14 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.e.a<?>) r4, (com.bumptech.glide.e.e) r5, r6, (com.bumptech.glide.f) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            r0 = 1
            r11.O = r0
            com.bumptech.glide.h<TranscodeType> r9 = r11.f6659b
            r0 = r9
            r4 = r13
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            com.bumptech.glide.e.d r0 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.e.e) r4, r5, (com.bumptech.glide.f) r6, (int) r7, (int) r8, (com.bumptech.glide.e.a<?>) r9, (java.util.concurrent.Executor) r10)
            r1 = 0
            r11.O = r1
            r13.a(r14, r0)
            return r13
        L_0x0087:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()"
            r0.<init>(r1)
            throw r0
        L_0x008f:
            java.lang.Float r0 = r11.L
            if (r0 == 0) goto L_0x00d2
            com.bumptech.glide.e.k r15 = new com.bumptech.glide.e.k
            r15.<init>(r12, r5)
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r28
            r5 = r15
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r29
            com.bumptech.glide.e.d r10 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.e.a<?>) r4, (com.bumptech.glide.e.e) r5, r6, (com.bumptech.glide.f) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            com.bumptech.glide.e.a r0 = r28.clone()
            java.lang.Float r1 = r11.L
            float r1 = r1.floatValue()
            com.bumptech.glide.e.a r4 = r0.b((float) r1)
            com.bumptech.glide.f r7 = r11.b((com.bumptech.glide.f) r13)
            r0 = r19
            r1 = r20
            r12 = r10
            r10 = r29
            com.bumptech.glide.e.d r0 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.e.a<?>) r4, (com.bumptech.glide.e.e) r5, r6, (com.bumptech.glide.f) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            r15.a(r12, r0)
            return r15
        L_0x00d2:
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r28
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r29
            com.bumptech.glide.e.d r0 = r0.a((java.lang.Object) r1, r2, r3, (com.bumptech.glide.e.a<?>) r4, (com.bumptech.glide.e.e) r5, r6, (com.bumptech.glide.f) r7, (int) r8, (int) r9, (java.util.concurrent.Executor) r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.h.b(java.lang.Object, com.bumptech.glide.e.a.j, com.bumptech.glide.e.g, com.bumptech.glide.e.e, com.bumptech.glide.j, com.bumptech.glide.f, int, int, com.bumptech.glide.e.a, java.util.concurrent.Executor):com.bumptech.glide.e.d");
    }

    private com.bumptech.glide.e.d a(Object obj, com.bumptech.glide.e.a.j<TranscodeType> jVar, g<TranscodeType> gVar, a<?> aVar, com.bumptech.glide.e.e eVar, j<?, ? super TranscodeType> jVar2, f fVar, int i2, int i3, Executor executor) {
        Context context = this.C;
        d dVar = this.G;
        return com.bumptech.glide.e.j.a(context, dVar, obj, this.I, this.E, aVar, i2, i3, fVar, jVar, gVar, this.J, eVar, dVar.f6484f, jVar2.f6674a, executor);
    }

    /* renamed from: a */
    public final h<TranscodeType> b(a<?> aVar) {
        com.bumptech.glide.g.j.a(aVar, "Argument must not be null");
        return (h) super.b(aVar);
    }

    public final h<TranscodeType> a(j<?, ? super TranscodeType> jVar) {
        this.H = (j) com.bumptech.glide.g.j.a(jVar, "Argument must not be null");
        this.M = false;
        return this;
    }

    private <Y extends com.bumptech.glide.e.a.j<TranscodeType>> Y a(Y y, g<TranscodeType> gVar, a<?> aVar, Executor executor) {
        com.bumptech.glide.g.j.a(y, "Argument must not be null");
        if (this.N) {
            com.bumptech.glide.e.d b2 = b(y, gVar, aVar, executor);
            com.bumptech.glide.e.d d2 = y.d();
            if (!b2.a(d2) || a(aVar, d2)) {
                this.D.a((com.bumptech.glide.e.a.j<?>) y);
                y.a(b2);
                this.D.a(y, b2);
                return y;
            }
            if (!((com.bumptech.glide.e.d) com.bumptech.glide.g.j.a(d2, "Argument must not be null")).d()) {
                d2.a();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private static boolean a(a<?> aVar, com.bumptech.glide.e.d dVar) {
        return !aVar.k && dVar.e();
    }

    public final c<TranscodeType> a() {
        f fVar = new f();
        return (c) a(fVar, fVar, e.b());
    }

    public final com.bumptech.glide.e.a.j<TranscodeType> b() {
        return a(com.bumptech.glide.e.a.g.a(this.D));
    }
}
