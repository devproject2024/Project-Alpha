package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.b.f;
import androidx.core.widget.b;
import java.lang.ref.WeakReference;

final class l {

    /* renamed from: a  reason: collision with root package name */
    final m f1759a;

    /* renamed from: b  reason: collision with root package name */
    int f1760b = 0;

    /* renamed from: c  reason: collision with root package name */
    Typeface f1761c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1762d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f1763e;

    /* renamed from: f  reason: collision with root package name */
    private aa f1764f;

    /* renamed from: g  reason: collision with root package name */
    private aa f1765g;

    /* renamed from: h  reason: collision with root package name */
    private aa f1766h;

    /* renamed from: i  reason: collision with root package name */
    private aa f1767i;
    private aa j;
    private aa k;
    private aa l;
    private int m = -1;

    l(TextView textView) {
        this.f1763e = textView;
        this.f1759a = new m(this.f1763e);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.util.AttributeSet r19, int r20) {
        /*
            r18 = this;
            r7 = r18
            r6 = r19
            r8 = r20
            android.widget.TextView r0 = r7.f1763e
            android.content.Context r9 = r0.getContext()
            androidx.appcompat.widget.f r10 = androidx.appcompat.widget.f.b()
            int[] r0 = androidx.appcompat.R.styleable.AppCompatTextHelper
            r11 = 0
            androidx.appcompat.widget.ac r12 = androidx.appcompat.widget.ac.a(r9, r6, r0, r8, r11)
            android.widget.TextView r0 = r7.f1763e
            android.content.Context r1 = r0.getContext()
            int[] r2 = androidx.appcompat.R.styleable.AppCompatTextHelper
            android.content.res.TypedArray r4 = r12.f1669a
            r3 = r19
            r5 = r20
            androidx.core.h.u.a(r0, r1, r2, r3, r4, r5)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_textAppearance
            r13 = -1
            int r0 = r12.g(r0, r13)
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft
            boolean r1 = r12.g(r1)
            if (r1 == 0) goto L_0x0043
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableLeft
            int r1 = r12.g(r1, r11)
            androidx.appcompat.widget.aa r1 = a(r9, r10, r1)
            r7.f1764f = r1
        L_0x0043:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop
            boolean r1 = r12.g(r1)
            if (r1 == 0) goto L_0x0057
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableTop
            int r1 = r12.g(r1, r11)
            androidx.appcompat.widget.aa r1 = a(r9, r10, r1)
            r7.f1765g = r1
        L_0x0057:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight
            boolean r1 = r12.g(r1)
            if (r1 == 0) goto L_0x006b
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableRight
            int r1 = r12.g(r1, r11)
            androidx.appcompat.widget.aa r1 = a(r9, r10, r1)
            r7.f1766h = r1
        L_0x006b:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom
            boolean r1 = r12.g(r1)
            if (r1 == 0) goto L_0x007f
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableBottom
            int r1 = r12.g(r1, r11)
            androidx.appcompat.widget.aa r1 = a(r9, r10, r1)
            r7.f1767i = r1
        L_0x007f:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 17
            if (r1 < r2) goto L_0x00ad
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart
            boolean r1 = r12.g(r1)
            if (r1 == 0) goto L_0x0099
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableStart
            int r1 = r12.g(r1, r11)
            androidx.appcompat.widget.aa r1 = a(r9, r10, r1)
            r7.j = r1
        L_0x0099:
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd
            boolean r1 = r12.g(r1)
            if (r1 == 0) goto L_0x00ad
            int r1 = androidx.appcompat.R.styleable.AppCompatTextHelper_android_drawableEnd
            int r1 = r12.g(r1, r11)
            androidx.appcompat.widget.aa r1 = a(r9, r10, r1)
            r7.k = r1
        L_0x00ad:
            android.content.res.TypedArray r1 = r12.f1669a
            r1.recycle()
            android.widget.TextView r1 = r7.f1763e
            android.text.method.TransformationMethod r1 = r1.getTransformationMethod()
            boolean r1 = r1 instanceof android.text.method.PasswordTransformationMethod
            r2 = 26
            r4 = 23
            if (r0 == r13) goto L_0x0145
            int[] r5 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.ac r0 = androidx.appcompat.widget.ac.a((android.content.Context) r9, (int) r0, (int[]) r5)
            if (r1 != 0) goto L_0x00d9
            int r5 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r5 = r0.g(r5)
            if (r5 == 0) goto L_0x00d9
            int r5 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r5 = r0.a((int) r5, (boolean) r11)
            r14 = r5
            r5 = 1
            goto L_0x00db
        L_0x00d9:
            r5 = 0
            r14 = 0
        L_0x00db:
            r7.a((android.content.Context) r9, (androidx.appcompat.widget.ac) r0)
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 >= r4) goto L_0x0118
            int r15 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            boolean r15 = r0.g(r15)
            if (r15 == 0) goto L_0x00f1
            int r15 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            android.content.res.ColorStateList r15 = r0.e(r15)
            goto L_0x00f2
        L_0x00f1:
            r15 = 0
        L_0x00f2:
            int r3 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            boolean r3 = r0.g(r3)
            if (r3 == 0) goto L_0x0101
            int r3 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r3 = r0.e(r3)
            goto L_0x0102
        L_0x0101:
            r3 = 0
        L_0x0102:
            int r12 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            boolean r12 = r0.g(r12)
            if (r12 == 0) goto L_0x0116
            int r12 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r12 = r0.e(r12)
            r17 = r15
            r15 = r12
            r12 = r17
            goto L_0x011b
        L_0x0116:
            r12 = r15
            goto L_0x011a
        L_0x0118:
            r3 = 0
            r12 = 0
        L_0x011a:
            r15 = 0
        L_0x011b:
            int r13 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r13 = r0.g(r13)
            if (r13 == 0) goto L_0x012a
            int r13 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            java.lang.String r13 = r0.d(r13)
            goto L_0x012b
        L_0x012a:
            r13 = 0
        L_0x012b:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r2) goto L_0x013e
            int r4 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r4 = r0.g(r4)
            if (r4 == 0) goto L_0x013e
            int r4 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            java.lang.String r4 = r0.d(r4)
            goto L_0x013f
        L_0x013e:
            r4 = 0
        L_0x013f:
            android.content.res.TypedArray r0 = r0.f1669a
            r0.recycle()
            goto L_0x014c
        L_0x0145:
            r3 = 0
            r4 = 0
            r5 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x014c:
            int[] r0 = androidx.appcompat.R.styleable.TextAppearance
            androidx.appcompat.widget.ac r0 = androidx.appcompat.widget.ac.a(r9, r6, r0, r8, r11)
            if (r1 != 0) goto L_0x0165
            int r2 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r2 = r0.g(r2)
            if (r2 == 0) goto L_0x0165
            int r2 = androidx.appcompat.R.styleable.TextAppearance_textAllCaps
            boolean r14 = r0.a((int) r2, (boolean) r11)
            r16 = 1
            goto L_0x0167
        L_0x0165:
            r16 = r5
        L_0x0167:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r2 >= r5) goto L_0x0197
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            boolean r2 = r0.g(r2)
            if (r2 == 0) goto L_0x017b
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textColor
            android.content.res.ColorStateList r12 = r0.e(r2)
        L_0x017b:
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            boolean r2 = r0.g(r2)
            if (r2 == 0) goto L_0x0189
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r3 = r0.e(r2)
        L_0x0189:
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            boolean r2 = r0.g(r2)
            if (r2 == 0) goto L_0x0197
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r15 = r0.e(r2)
        L_0x0197:
            int r2 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            boolean r2 = r0.g(r2)
            if (r2 == 0) goto L_0x01a5
            int r2 = androidx.appcompat.R.styleable.TextAppearance_textLocale
            java.lang.String r13 = r0.d(r2)
        L_0x01a5:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            if (r2 < r5) goto L_0x01b9
            int r2 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            boolean r2 = r0.g(r2)
            if (r2 == 0) goto L_0x01b9
            int r2 = androidx.appcompat.R.styleable.TextAppearance_fontVariationSettings
            java.lang.String r4 = r0.d(r2)
        L_0x01b9:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r2 < r5) goto L_0x01d6
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            boolean r2 = r0.g(r2)
            if (r2 == 0) goto L_0x01d6
            int r2 = androidx.appcompat.R.styleable.TextAppearance_android_textSize
            r5 = -1
            int r2 = r0.e(r2, r5)
            if (r2 != 0) goto L_0x01d6
            android.widget.TextView r2 = r7.f1763e
            r5 = 0
            r2.setTextSize(r11, r5)
        L_0x01d6:
            r7.a((android.content.Context) r9, (androidx.appcompat.widget.ac) r0)
            android.content.res.TypedArray r0 = r0.f1669a
            r0.recycle()
            if (r12 == 0) goto L_0x01e5
            android.widget.TextView r0 = r7.f1763e
            r0.setTextColor(r12)
        L_0x01e5:
            if (r3 == 0) goto L_0x01ec
            android.widget.TextView r0 = r7.f1763e
            r0.setHintTextColor(r3)
        L_0x01ec:
            if (r15 == 0) goto L_0x01f3
            android.widget.TextView r0 = r7.f1763e
            r0.setLinkTextColor(r15)
        L_0x01f3:
            if (r1 != 0) goto L_0x01fa
            if (r16 == 0) goto L_0x01fa
            r7.a((boolean) r14)
        L_0x01fa:
            android.graphics.Typeface r0 = r7.f1761c
            if (r0 == 0) goto L_0x0210
            int r1 = r7.m
            r2 = -1
            if (r1 != r2) goto L_0x020b
            android.widget.TextView r1 = r7.f1763e
            int r2 = r7.f1760b
            r1.setTypeface(r0, r2)
            goto L_0x0210
        L_0x020b:
            android.widget.TextView r1 = r7.f1763e
            r1.setTypeface(r0)
        L_0x0210:
            if (r4 == 0) goto L_0x0217
            android.widget.TextView r0 = r7.f1763e
            r0.setFontVariationSettings(r4)
        L_0x0217:
            if (r13 == 0) goto L_0x0242
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x0229
            android.widget.TextView r0 = r7.f1763e
            android.os.LocaleList r1 = android.os.LocaleList.forLanguageTags(r13)
            r0.setTextLocales(r1)
            goto L_0x0242
        L_0x0229:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x0242
            r0 = 44
            int r0 = r13.indexOf(r0)
            java.lang.String r0 = r13.substring(r11, r0)
            android.widget.TextView r1 = r7.f1763e
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            r1.setTextLocale(r0)
        L_0x0242:
            androidx.appcompat.widget.m r0 = r7.f1759a
            r0.a((android.util.AttributeSet) r6, (int) r8)
            boolean r0 = androidx.core.widget.b.f3188d
            if (r0 == 0) goto L_0x0288
            androidx.appcompat.widget.m r0 = r7.f1759a
            int r0 = r0.f1775a
            if (r0 == 0) goto L_0x0288
            androidx.appcompat.widget.m r0 = r7.f1759a
            int[] r0 = r0.f1779e
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0288
            android.widget.TextView r1 = r7.f1763e
            int r1 = r1.getAutoSizeStepGranularity()
            float r1 = (float) r1
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0283
            android.widget.TextView r0 = r7.f1763e
            androidx.appcompat.widget.m r1 = r7.f1759a
            float r1 = r1.f1777c
            int r1 = java.lang.Math.round(r1)
            androidx.appcompat.widget.m r2 = r7.f1759a
            float r2 = r2.f1778d
            int r2 = java.lang.Math.round(r2)
            androidx.appcompat.widget.m r3 = r7.f1759a
            float r3 = r3.f1776b
            int r3 = java.lang.Math.round(r3)
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r11)
            goto L_0x0288
        L_0x0283:
            android.widget.TextView r1 = r7.f1763e
            r1.setAutoSizeTextTypeUniformWithPresetSizes(r0, r11)
        L_0x0288:
            int[] r0 = androidx.appcompat.R.styleable.AppCompatTextView
            androidx.appcompat.widget.ac r8 = androidx.appcompat.widget.ac.a((android.content.Context) r9, (android.util.AttributeSet) r6, (int[]) r0)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x029d
            android.graphics.drawable.Drawable r0 = r10.a((android.content.Context) r9, (int) r0)
            r2 = r0
            goto L_0x029e
        L_0x029d:
            r2 = 0
        L_0x029e:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTopCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02ac
            android.graphics.drawable.Drawable r0 = r10.a((android.content.Context) r9, (int) r0)
            r3 = r0
            goto L_0x02ad
        L_0x02ac:
            r3 = 0
        L_0x02ad:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableRightCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02bb
            android.graphics.drawable.Drawable r0 = r10.a((android.content.Context) r9, (int) r0)
            r4 = r0
            goto L_0x02bc
        L_0x02bb:
            r4 = 0
        L_0x02bc:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableBottomCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02ca
            android.graphics.drawable.Drawable r0 = r10.a((android.content.Context) r9, (int) r0)
            r5 = r0
            goto L_0x02cb
        L_0x02ca:
            r5 = 0
        L_0x02cb:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableStartCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02d9
            android.graphics.drawable.Drawable r0 = r10.a((android.content.Context) r9, (int) r0)
            r6 = r0
            goto L_0x02da
        L_0x02d9:
            r6 = 0
        L_0x02da:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableEndCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02e8
            android.graphics.drawable.Drawable r0 = r10.a((android.content.Context) r9, (int) r0)
            r9 = r0
            goto L_0x02e9
        L_0x02e8:
            r9 = 0
        L_0x02e9:
            r0 = r18
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r9
            r0.a(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint
            boolean r0 = r8.g(r0)
            if (r0 == 0) goto L_0x0307
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTint
            android.content.res.ColorStateList r0 = r8.e(r0)
            android.widget.TextView r1 = r7.f1763e
            androidx.core.widget.i.a((android.widget.TextView) r1, (android.content.res.ColorStateList) r0)
        L_0x0307:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode
            boolean r0 = r8.g(r0)
            if (r0 == 0) goto L_0x0321
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_drawableTintMode
            r1 = -1
            int r0 = r8.a((int) r0, (int) r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.p.a(r0, r2)
            android.widget.TextView r2 = r7.f1763e
            androidx.core.widget.i.a((android.widget.TextView) r2, (android.graphics.PorterDuff.Mode) r0)
            goto L_0x0322
        L_0x0321:
            r1 = -1
        L_0x0322:
            int r0 = androidx.appcompat.R.styleable.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.e(r0, r1)
            int r2 = androidx.appcompat.R.styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.e(r2, r1)
            int r3 = androidx.appcompat.R.styleable.AppCompatTextView_lineHeight
            int r3 = r8.e(r3, r1)
            android.content.res.TypedArray r4 = r8.f1669a
            r4.recycle()
            if (r0 == r1) goto L_0x0340
            android.widget.TextView r4 = r7.f1763e
            androidx.core.widget.i.b(r4, r0)
        L_0x0340:
            if (r2 == r1) goto L_0x0347
            android.widget.TextView r0 = r7.f1763e
            androidx.core.widget.i.c(r0, r2)
        L_0x0347:
            if (r3 == r1) goto L_0x034e
            android.widget.TextView r0 = r7.f1763e
            androidx.core.widget.i.d(r0, r3)
        L_0x034e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l.a(android.util.AttributeSet, int):void");
    }

    private void a(Context context, ac acVar) {
        int i2;
        String d2;
        this.f1760b = acVar.a(R.styleable.TextAppearance_android_textStyle, this.f1760b);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            this.m = acVar.a(R.styleable.TextAppearance_android_textFontWeight, -1);
            if (this.m != -1) {
                this.f1760b = (this.f1760b & 2) | 0;
            }
        }
        if (acVar.g(R.styleable.TextAppearance_android_fontFamily) || acVar.g(R.styleable.TextAppearance_fontFamily)) {
            this.f1761c = null;
            if (acVar.g(R.styleable.TextAppearance_fontFamily)) {
                i2 = R.styleable.TextAppearance_fontFamily;
            } else {
                i2 = R.styleable.TextAppearance_android_fontFamily;
            }
            final int i3 = this.m;
            final int i4 = this.f1760b;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f1763e);
                try {
                    Typeface a2 = acVar.a(i2, this.f1760b, (f.a) new f.a() {
                        public final void a(int i2) {
                        }

                        public final void a(Typeface typeface) {
                            int i2;
                            if (Build.VERSION.SDK_INT >= 28 && (i2 = i3) != -1) {
                                typeface = Typeface.create(typeface, i2, (i4 & 2) != 0);
                            }
                            l lVar = l.this;
                            WeakReference weakReference = weakReference;
                            if (lVar.f1762d) {
                                lVar.f1761c = typeface;
                                TextView textView = (TextView) weakReference.get();
                                if (textView != null) {
                                    textView.setTypeface(typeface, lVar.f1760b);
                                }
                            }
                        }
                    });
                    if (a2 != null) {
                        if (Build.VERSION.SDK_INT < 28 || this.m == -1) {
                            this.f1761c = a2;
                        } else {
                            this.f1761c = Typeface.create(Typeface.create(a2, 0), this.m, (this.f1760b & 2) != 0);
                        }
                    }
                    this.f1762d = this.f1761c == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1761c == null && (d2 = acVar.d(i2)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.m == -1) {
                    this.f1761c = Typeface.create(d2, this.f1760b);
                    return;
                }
                Typeface create = Typeface.create(d2, 0);
                int i5 = this.m;
                if ((this.f1760b & 2) != 0) {
                    z = true;
                }
                this.f1761c = Typeface.create(create, i5, z);
            }
        } else if (acVar.g(R.styleable.TextAppearance_android_typeface)) {
            this.f1762d = false;
            int a3 = acVar.a(R.styleable.TextAppearance_android_typeface, 1);
            if (a3 == 1) {
                this.f1761c = Typeface.SANS_SERIF;
            } else if (a3 == 2) {
                this.f1761c = Typeface.SERIF;
            } else if (a3 == 3) {
                this.f1761c = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, int i2) {
        String d2;
        ColorStateList e2;
        ac a2 = ac.a(context, i2, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_textAllCaps)) {
            a(a2.a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a2.g(R.styleable.TextAppearance_android_textColor) && (e2 = a2.e(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f1763e.setTextColor(e2);
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize) && a2.e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1763e.setTextSize(0, 0.0f);
        }
        a(context, a2);
        if (Build.VERSION.SDK_INT >= 26 && a2.g(R.styleable.TextAppearance_fontVariationSettings) && (d2 = a2.d(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f1763e.setFontVariationSettings(d2);
        }
        a2.f1669a.recycle();
        Typeface typeface = this.f1761c;
        if (typeface != null) {
            this.f1763e.setTypeface(typeface, this.f1760b);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.f1763e.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!(this.f1764f == null && this.f1765g == null && this.f1766h == null && this.f1767i == null)) {
            Drawable[] compoundDrawables = this.f1763e.getCompoundDrawables();
            a(compoundDrawables[0], this.f1764f);
            a(compoundDrawables[1], this.f1765g);
            a(compoundDrawables[2], this.f1766h);
            a(compoundDrawables[3], this.f1767i);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.j != null || this.k != null) {
            Drawable[] compoundDrawablesRelative = this.f1763e.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.j);
            a(compoundDrawablesRelative[2], this.k);
        }
    }

    private void a(Drawable drawable, aa aaVar) {
        if (drawable != null && aaVar != null) {
            f.a(drawable, aaVar, this.f1763e.getDrawableState());
        }
    }

    private static aa a(Context context, f fVar, int i2) {
        ColorStateList c2 = fVar.c(context, i2);
        if (c2 == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.f1667d = true;
        aaVar.f1664a = c2;
        return aaVar;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (!b.f3188d) {
            this.f1759a.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, float f2) {
        if (!b.f3188d && !this.f1759a.b()) {
            b(i2, f2);
        }
    }

    private void b(int i2, float f2) {
        this.f1759a.a(i2, f2);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f1759a.a(i2);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f1759a.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public final void a(int[] iArr, int i2) throws IllegalArgumentException {
        this.f1759a.a(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList c() {
        aa aaVar = this.l;
        if (aaVar != null) {
            return aaVar.f1664a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (this.l == null) {
            this.l = new aa();
        }
        aa aaVar = this.l;
        aaVar.f1664a = colorStateList;
        aaVar.f1667d = colorStateList != null;
        e();
    }

    /* access modifiers changed from: package-private */
    public final PorterDuff.Mode d() {
        aa aaVar = this.l;
        if (aaVar != null) {
            return aaVar.f1665b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(PorterDuff.Mode mode) {
        if (this.l == null) {
            this.l = new aa();
        }
        aa aaVar = this.l;
        aaVar.f1665b = mode;
        aaVar.f1666c = mode != null;
        e();
    }

    private void e() {
        aa aaVar = this.l;
        this.f1764f = aaVar;
        this.f1765g = aaVar;
        this.f1766h = aaVar;
        this.f1767i = aaVar;
        this.j = aaVar;
        this.k = aaVar;
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1763e.getCompoundDrawablesRelative();
            TextView textView = this.f1763e;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1763e.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f1763e;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1763e.getCompoundDrawables();
            TextView textView3 = this.f1763e;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }
}
