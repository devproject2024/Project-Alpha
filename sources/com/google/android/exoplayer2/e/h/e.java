package com.google.android.exoplayer2.e.h;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.g.l;

public final class e extends b {
    public final long p;
    public final long q;

    public e(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private e(CharSequence charSequence, byte b2) {
        this(0, 0, charSequence, (Layout.Alignment) null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(long j, long j2, CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4);
        this.p = j;
        this.q = j2;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f31614a;

        /* renamed from: b  reason: collision with root package name */
        long f31615b;

        /* renamed from: c  reason: collision with root package name */
        SpannableStringBuilder f31616c;

        /* renamed from: d  reason: collision with root package name */
        Layout.Alignment f31617d;

        /* renamed from: e  reason: collision with root package name */
        float f31618e;

        /* renamed from: f  reason: collision with root package name */
        int f31619f;

        /* renamed from: g  reason: collision with root package name */
        int f31620g;

        /* renamed from: h  reason: collision with root package name */
        float f31621h;

        /* renamed from: i  reason: collision with root package name */
        int f31622i;
        float j;

        public a() {
            a();
        }

        public final void a() {
            this.f31614a = 0;
            this.f31615b = 0;
            this.f31616c = null;
            this.f31617d = null;
            this.f31618e = Float.MIN_VALUE;
            this.f31619f = Integer.MIN_VALUE;
            this.f31620g = Integer.MIN_VALUE;
            this.f31621h = Float.MIN_VALUE;
            this.f31622i = Integer.MIN_VALUE;
            this.j = Float.MIN_VALUE;
        }

        public final e b() {
            if (this.f31621h != Float.MIN_VALUE && this.f31622i == Integer.MIN_VALUE) {
                c();
            }
            return new e(this.f31614a, this.f31615b, this.f31616c, this.f31617d, this.f31618e, this.f31619f, this.f31620g, this.f31621h, this.f31622i, this.j);
        }

        private a c() {
            if (this.f31617d == null) {
                this.f31622i = Integer.MIN_VALUE;
            } else {
                int i2 = AnonymousClass1.f31613a[this.f31617d.ordinal()];
                if (i2 == 1) {
                    this.f31622i = 0;
                } else if (i2 == 2) {
                    this.f31622i = 1;
                } else if (i2 != 3) {
                    new StringBuilder("Unrecognized alignment: ").append(this.f31617d);
                    l.c();
                    this.f31622i = 0;
                } else {
                    this.f31622i = 2;
                }
            }
            return this;
        }
    }

    /* renamed from: com.google.android.exoplayer2.e.h.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31613a = new int[Layout.Alignment.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31613a = r0
                int[] r0 = f31613a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f31613a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f31613a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.h.e.AnonymousClass1.<clinit>():void");
        }
    }
}
