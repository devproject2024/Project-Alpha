package com.google.android.exoplayer2.e.g;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.charset.Charset;
import java.util.List;

public final class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static final int f31585c = ae.h("styl");

    /* renamed from: d  reason: collision with root package name */
    private static final int f31586d = ae.h("tbox");

    /* renamed from: e  reason: collision with root package name */
    private final r f31587e = new r();

    /* renamed from: f  reason: collision with root package name */
    private boolean f31588f;

    /* renamed from: g  reason: collision with root package name */
    private int f31589g;

    /* renamed from: h  reason: collision with root package name */
    private int f31590h;

    /* renamed from: i  reason: collision with root package name */
    private String f31591i;
    private float j;
    private int k;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = "sans-serif";
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f31589g = bArr[24];
            this.f31590h = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f31591i = "Serif".equals(ae.a(bArr, 43, bArr.length - 43)) ? "serif" : str;
            this.k = bArr[25] * 20;
            this.f31588f = (bArr[0] & 32) != 0 ? true : z;
            if (this.f31588f) {
                this.j = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) this.k);
                this.j = ae.a(this.j, 0.0f, 0.95f);
                return;
            }
            this.j = 0.85f;
            return;
        }
        this.f31589g = 0;
        this.f31590h = -1;
        this.f31591i = str;
        this.f31588f = false;
        this.j = 0.85f;
    }

    public final e a(byte[] bArr, int i2, boolean z) throws g {
        String str;
        char c2;
        this.f31587e.a(bArr, i2);
        r rVar = this.f31587e;
        a(rVar.b() >= 2);
        int d2 = rVar.d();
        if (d2 == 0) {
            str = "";
        } else if (rVar.b() < 2 || !((c2 = (char) (((rVar.f32566a[rVar.f32567b] & 255) << 8) | (rVar.f32566a[rVar.f32567b + 1] & 255))) == 65279 || c2 == 65534)) {
            str = rVar.a(d2, Charset.forName(AppConstants.UTF_8));
        } else {
            str = rVar.a(d2, Charset.forName("UTF-16"));
        }
        if (str.isEmpty()) {
            return b.f31592a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        a(spannableStringBuilder2, this.f31589g, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder2, this.f31590h, -1, 0, spannableStringBuilder.length(), 16711680);
        String str2 = this.f31591i;
        int length = spannableStringBuilder.length();
        if (str2 != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str2), 0, length, 16711713);
        }
        float f2 = this.j;
        while (this.f31587e.b() >= 8) {
            int i3 = this.f31587e.f32567b;
            int i4 = this.f31587e.i();
            int i5 = this.f31587e.i();
            if (i5 == f31585c) {
                a(this.f31587e.b() >= 2);
                int d3 = this.f31587e.d();
                for (int i6 = 0; i6 < d3; i6++) {
                    r rVar2 = this.f31587e;
                    a(rVar2.b() >= 12);
                    int d4 = rVar2.d();
                    int d5 = rVar2.d();
                    rVar2.d(2);
                    int c3 = rVar2.c();
                    rVar2.d(1);
                    int i7 = rVar2.i();
                    SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
                    int i8 = d4;
                    int i9 = d5;
                    a(spannableStringBuilder3, c3, this.f31589g, i8, i9, 0);
                    b(spannableStringBuilder3, i7, this.f31590h, i8, i9, 0);
                }
            } else if (i5 == f31586d && this.f31588f) {
                a(this.f31587e.b() >= 2);
                f2 = ae.a(((float) this.f31587e.d()) / ((float) this.k), 0.0f, 0.95f);
            }
            this.f31587e.c(i3 + i4);
        }
        return new b(new b((CharSequence) spannableStringBuilder, (Layout.Alignment) null, f2, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            int i7 = i6 | 33;
            boolean z = true;
            boolean z2 = (i2 & 1) != 0;
            boolean z3 = (i2 & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            }
            if ((i2 & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
            }
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & PriceRangeSeekBar.INVALID_POINTER_ID) << 24)), i4, i5, i6 | 33);
        }
    }

    private static void a(boolean z) throws g {
        if (!z) {
            throw new g("Unexpected subtitle format.");
        }
    }
}
