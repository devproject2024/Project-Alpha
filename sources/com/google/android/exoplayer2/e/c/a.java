package com.google.android.exoplayer2.e.c;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import net.one97.paytm.upi.util.UpiConstants;

public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private final r f31510c = new r();

    /* renamed from: d  reason: collision with root package name */
    private final r f31511d = new r();

    /* renamed from: e  reason: collision with root package name */
    private final C0536a f31512e = new C0536a();

    /* renamed from: f  reason: collision with root package name */
    private Inflater f31513f;

    public a() {
        super("PgsDecoder");
    }

    public final e a(byte[] bArr, int i2, boolean z) throws g {
        int f2;
        this.f31510c.a(bArr, i2);
        r rVar = this.f31510c;
        if (rVar.b() > 0 && (rVar.f32566a[rVar.f32567b] & 255) == 120) {
            if (this.f31513f == null) {
                this.f31513f = new Inflater();
            }
            if (ae.a(rVar, this.f31511d, this.f31513f)) {
                rVar.a(this.f31511d.f32566a, this.f31511d.f32568c);
            }
        }
        this.f31512e.b();
        ArrayList arrayList = new ArrayList();
        while (this.f31510c.b() >= 3) {
            r rVar2 = this.f31510c;
            C0536a aVar = this.f31512e;
            int i3 = rVar2.f32568c;
            int c2 = rVar2.c();
            int d2 = rVar2.d();
            int i4 = rVar2.f32567b + d2;
            b bVar = null;
            if (i4 > i3) {
                rVar2.c(i3);
            } else {
                if (c2 != 128) {
                    switch (c2) {
                        case 20:
                            aVar.a(rVar2, d2);
                            break;
                        case 21:
                            if (d2 >= 4) {
                                rVar2.d(3);
                                int i5 = d2 - 4;
                                if ((rVar2.c() & 128) != 0) {
                                    if (i5 >= 7 && (f2 = rVar2.f()) >= 4) {
                                        aVar.f31519f = rVar2.d();
                                        aVar.f31520g = rVar2.d();
                                        aVar.f31514a.a(f2 - 4);
                                        i5 -= 7;
                                    }
                                }
                                int i6 = aVar.f31514a.f32567b;
                                int i7 = aVar.f31514a.f32568c;
                                if (i6 < i7 && i5 > 0) {
                                    int min = Math.min(i5, i7 - i6);
                                    rVar2.a(aVar.f31514a.f32566a, i6, min);
                                    aVar.f31514a.c(i6 + min);
                                    break;
                                }
                            }
                            break;
                        case 22:
                            if (d2 >= 19) {
                                aVar.f31515b = rVar2.d();
                                aVar.f31516c = rVar2.d();
                                rVar2.d(11);
                                aVar.f31517d = rVar2.d();
                                aVar.f31518e = rVar2.d();
                                break;
                            }
                            break;
                    }
                } else {
                    bVar = aVar.a();
                    aVar.b();
                }
                rVar2.c(i4);
            }
            if (bVar != null) {
                arrayList.add(bVar);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }

    /* renamed from: com.google.android.exoplayer2.e.c.a$a  reason: collision with other inner class name */
    static final class C0536a {

        /* renamed from: a  reason: collision with root package name */
        final r f31514a = new r();

        /* renamed from: b  reason: collision with root package name */
        int f31515b;

        /* renamed from: c  reason: collision with root package name */
        int f31516c;

        /* renamed from: d  reason: collision with root package name */
        int f31517d;

        /* renamed from: e  reason: collision with root package name */
        int f31518e;

        /* renamed from: f  reason: collision with root package name */
        int f31519f;

        /* renamed from: g  reason: collision with root package name */
        int f31520g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f31521h = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];

        /* renamed from: i  reason: collision with root package name */
        private boolean f31522i;

        /* access modifiers changed from: package-private */
        public final void a(r rVar, int i2) {
            if (i2 % 5 == 2) {
                rVar.d(2);
                Arrays.fill(this.f31521h, 0);
                int i3 = i2 / 5;
                int i4 = 0;
                while (i4 < i3) {
                    int c2 = rVar.c();
                    int c3 = rVar.c();
                    int c4 = rVar.c();
                    int c5 = rVar.c();
                    int c6 = rVar.c();
                    double d2 = (double) c3;
                    double d3 = (double) (c4 - 128);
                    int i5 = i4;
                    double d4 = (double) (c5 - 128);
                    int[] iArr = this.f31521h;
                    int a2 = ae.a((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, (int) PriceRangeSeekBar.INVALID_POINTER_ID) << 8;
                    iArr[c2] = ae.a((int) (d2 + (d4 * 1.772d)), 0, (int) PriceRangeSeekBar.INVALID_POINTER_ID) | a2 | (c6 << 24) | (ae.a((int) ((1.402d * d3) + d2), 0, (int) PriceRangeSeekBar.INVALID_POINTER_ID) << 16);
                    i4 = i5 + 1;
                }
                this.f31522i = true;
            }
        }

        public final b a() {
            int i2;
            int i3;
            int i4;
            if (this.f31515b == 0 || this.f31516c == 0 || this.f31519f == 0 || this.f31520g == 0 || this.f31514a.f32568c == 0 || this.f31514a.f32567b != this.f31514a.f32568c || !this.f31522i) {
                return null;
            }
            this.f31514a.c(0);
            int[] iArr = new int[(this.f31519f * this.f31520g)];
            int i5 = 0;
            while (i5 < iArr.length) {
                int c2 = this.f31514a.c();
                if (c2 != 0) {
                    i4 = i5 + 1;
                    iArr[i5] = this.f31521h[c2];
                } else {
                    int c3 = this.f31514a.c();
                    if (c3 != 0) {
                        if ((c3 & 64) == 0) {
                            i2 = c3 & 63;
                        } else {
                            i2 = ((c3 & 63) << 8) | this.f31514a.c();
                        }
                        if ((c3 & 128) == 0) {
                            i3 = 0;
                        } else {
                            i3 = this.f31521h[this.f31514a.c()];
                        }
                        i4 = i2 + i5;
                        Arrays.fill(iArr, i5, i4, i3);
                    }
                }
                i5 = i4;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, this.f31519f, this.f31520g, Bitmap.Config.ARGB_8888);
            int i6 = this.f31515b;
            float f2 = ((float) this.f31517d) / ((float) i6);
            int i7 = this.f31516c;
            return new b(createBitmap, f2, ((float) this.f31518e) / ((float) i7), 0, ((float) this.f31519f) / ((float) i6), ((float) this.f31520g) / ((float) i7));
        }

        public final void b() {
            this.f31515b = 0;
            this.f31516c = 0;
            this.f31517d = 0;
            this.f31518e = 0;
            this.f31519f = 0;
            this.f31520g = 0;
            this.f31514a.a(0);
            this.f31522i = false;
        }
    }
}
