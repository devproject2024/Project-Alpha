package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.b.b;
import com.google.android.exoplayer2.extractor.c.d;
import com.google.android.exoplayer2.extractor.d.c;
import com.google.android.exoplayer2.extractor.g.a;
import com.google.android.exoplayer2.extractor.g.ab;
import com.google.android.exoplayer2.extractor.g.u;
import com.google.android.exoplayer2.extractor.mp4.g;
import java.lang.reflect.Constructor;

public final class e implements j {

    /* renamed from: a  reason: collision with root package name */
    private static final Constructor<? extends g> f31783a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31784b;

    /* renamed from: c  reason: collision with root package name */
    private int f31785c;

    /* renamed from: d  reason: collision with root package name */
    private int f31786d;

    /* renamed from: e  reason: collision with root package name */
    private int f31787e;

    /* renamed from: f  reason: collision with root package name */
    private int f31788f;

    /* renamed from: g  reason: collision with root package name */
    private int f31789g;

    /* renamed from: h  reason: collision with root package name */
    private int f31790h;

    /* renamed from: i  reason: collision with root package name */
    private int f31791i = 1;
    private int j;

    static {
        Constructor<? extends U> constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(g.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f31783a = constructor;
    }

    public final synchronized g[] createExtractors() {
        g[] gVarArr;
        gVarArr = new g[(f31783a == null ? 13 : 14)];
        gVarArr[0] = new d(this.f31787e);
        int i2 = 1;
        gVarArr[1] = new com.google.android.exoplayer2.extractor.mp4.e(this.f31789g);
        gVarArr[2] = new g(this.f31788f);
        gVarArr[3] = new c(this.f31790h | (this.f31784b ? 1 : 0));
        gVarArr[4] = new com.google.android.exoplayer2.extractor.g.e(this.f31785c | (this.f31784b ? 1 : 0));
        gVarArr[5] = new a();
        gVarArr[6] = new ab(this.f31791i, this.j);
        gVarArr[7] = new b();
        gVarArr[8] = new com.google.android.exoplayer2.extractor.e.c();
        gVarArr[9] = new u();
        gVarArr[10] = new com.google.android.exoplayer2.extractor.h.a();
        int i3 = this.f31786d;
        if (!this.f31784b) {
            i2 = 0;
        }
        gVarArr[11] = new com.google.android.exoplayer2.extractor.a.a(i2 | i3);
        gVarArr[12] = new com.google.android.exoplayer2.extractor.g.c();
        if (f31783a != null) {
            try {
                gVarArr[13] = (g) f31783a.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
            }
        }
        return gVarArr;
    }
}
