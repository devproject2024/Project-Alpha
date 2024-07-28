package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.m;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.trackselection.g;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class f implements q {

    /* renamed from: a  reason: collision with root package name */
    private final m f32300a;

    /* renamed from: b  reason: collision with root package name */
    private final long f32301b;

    /* renamed from: c  reason: collision with root package name */
    private final long f32302c;

    /* renamed from: d  reason: collision with root package name */
    private final long f32303d;

    /* renamed from: e  reason: collision with root package name */
    private final long f32304e;

    /* renamed from: f  reason: collision with root package name */
    private final long f32305f;

    /* renamed from: g  reason: collision with root package name */
    private final int f32306g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f32307h;

    /* renamed from: i  reason: collision with root package name */
    private final long f32308i;
    private final boolean j;
    private int k;
    private boolean l;
    private boolean m;

    public f() {
        this(new m());
    }

    @Deprecated
    private f(m mVar) {
        this(mVar, (byte) 0);
    }

    private f(m mVar, byte b2) {
        a(2500, 0, "bufferForPlaybackMs", "0");
        a(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(15000, 2500, "minBufferAudioMs", "bufferForPlaybackMs");
        a(AppConstants.NOT_TIME, 2500, "minBufferVideoMs", "bufferForPlaybackMs");
        a(15000, 5000, "minBufferAudioMs", "bufferForPlaybackAfterRebufferMs");
        a(AppConstants.NOT_TIME, 5000, "minBufferVideoMs", "bufferForPlaybackAfterRebufferMs");
        a(AppConstants.NOT_TIME, 15000, "maxBufferMs", "minBufferAudioMs");
        a(AppConstants.NOT_TIME, AppConstants.NOT_TIME, "maxBufferMs", "minBufferVideoMs");
        a(0, 0, "backBufferDurationMs", "0");
        this.f32300a = mVar;
        this.f32301b = c.b(15000);
        this.f32302c = c.b(50000);
        this.f32303d = c.b(50000);
        this.f32304e = c.b(2500);
        this.f32305f = c.b(5000);
        this.f32306g = -1;
        this.f32307h = true;
        this.f32308i = c.b(0);
        this.j = false;
    }

    public final void a() {
        a(false);
    }

    public final void b() {
        a(true);
    }

    public final void c() {
        a(true);
    }

    public final b d() {
        return this.f32300a;
    }

    public final long e() {
        return this.f32308i;
    }

    public final boolean f() {
        return this.j;
    }

    public final boolean a(long j2, float f2) {
        boolean z = true;
        boolean z2 = this.f32300a.e() >= this.k;
        long j3 = this.m ? this.f32302c : this.f32301b;
        if (f2 > 1.0f) {
            j3 = Math.min(ae.a(j3, f2), this.f32303d);
        }
        if (j2 < j3) {
            if (!this.f32307h && z2) {
                z = false;
            }
            this.l = z;
        } else if (j2 >= this.f32303d || z2) {
            this.l = false;
        }
        return this.l;
    }

    public final boolean a(long j2, float f2, boolean z) {
        long b2 = ae.b(j2, f2);
        long j3 = z ? this.f32305f : this.f32304e;
        if (j3 <= 0 || b2 >= j3) {
            return true;
        }
        return !this.f32307h && this.f32300a.e() >= this.k;
    }

    private void a(boolean z) {
        this.k = 0;
        this.l = false;
        if (z) {
            this.f32300a.d();
        }
    }

    private static void a(int i2, int i3, String str, String str2) {
        boolean z = i2 >= i3;
        a.a(z, (Object) str + " cannot be less than " + str2);
    }

    public final void a(ab[] abVarArr, g gVar) {
        boolean z;
        int i2;
        int i3 = 0;
        while (true) {
            if (i3 < abVarArr.length) {
                if (abVarArr[i3].a() == 2 && gVar.f33505b[i3] != null) {
                    z = true;
                    break;
                }
                i3++;
            } else {
                z = false;
                break;
            }
        }
        this.m = z;
        int i4 = this.f32306g;
        if (i4 == -1) {
            int i5 = 0;
            for (int i6 = 0; i6 < abVarArr.length; i6++) {
                if (gVar.f33505b[i6] != null) {
                    switch (abVarArr[i6].a()) {
                        case 0:
                            i2 = 36438016;
                            break;
                        case 1:
                            i2 = 3538944;
                            break;
                        case 2:
                            i2 = 32768000;
                            break;
                        case 3:
                        case 4:
                        case 5:
                            i2 = 131072;
                            break;
                        case 6:
                            i2 = 0;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    i5 += i2;
                }
            }
            i4 = i5;
        }
        this.k = i4;
        this.f32300a.a(this.k);
    }
}
