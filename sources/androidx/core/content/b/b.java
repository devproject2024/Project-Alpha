package androidx.core.content.b;

import android.content.res.ColorStateList;
import android.graphics.Shader;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Shader f2827a;

    /* renamed from: b  reason: collision with root package name */
    public int f2828b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorStateList f2829c;

    private b(Shader shader, ColorStateList colorStateList, int i2) {
        this.f2827a = shader;
        this.f2829c = colorStateList;
        this.f2828b = i2;
    }

    static b a(int i2) {
        return new b((Shader) null, (ColorStateList) null, i2);
    }

    public final boolean a() {
        return this.f2827a != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f2829c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b() {
        /*
            r1 = this;
            android.graphics.Shader r0 = r1.f2827a
            if (r0 != 0) goto L_0x0010
            android.content.res.ColorStateList r0 = r1.f2829c
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.b.b.b():boolean");
    }

    public final boolean a(int[] iArr) {
        if (b()) {
            ColorStateList colorStateList = this.f2829c;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f2828b) {
                this.f2828b = colorForState;
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        return a() || this.f2828b != 0;
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r19v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r14v4, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.content.b.b a(android.content.res.Resources r26, int r27, android.content.res.Resources.Theme r28) {
        /*
            r0 = r26
            r1 = r28
            java.lang.String r2 = "centerColor"
            android.content.res.XmlResourceParser r4 = r26.getXml(r27)     // Catch:{ Exception -> 0x017d }
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r4)     // Catch:{ Exception -> 0x017d }
        L_0x000e:
            int r6 = r4.next()     // Catch:{ Exception -> 0x017d }
            r7 = 2
            r8 = 1
            if (r6 == r7) goto L_0x0018
            if (r6 != r8) goto L_0x000e
        L_0x0018:
            if (r6 != r7) goto L_0x0175
            java.lang.String r6 = r4.getName()     // Catch:{ Exception -> 0x017d }
            r9 = -1
            int r10 = r6.hashCode()     // Catch:{ Exception -> 0x017d }
            r11 = 89650992(0x557f730, float:1.01546526E-35)
            java.lang.String r12 = "gradient"
            r13 = 0
            if (r10 == r11) goto L_0x003b
            r11 = 1191572447(0x4705f3df, float:34291.87)
            if (r10 == r11) goto L_0x0031
            goto L_0x0042
        L_0x0031:
            java.lang.String r10 = "selector"
            boolean r10 = r6.equals(r10)     // Catch:{ Exception -> 0x017d }
            if (r10 == 0) goto L_0x0042
            r9 = 0
            goto L_0x0042
        L_0x003b:
            boolean r10 = r6.equals(r12)     // Catch:{ Exception -> 0x017d }
            if (r10 == 0) goto L_0x0042
            r9 = 1
        L_0x0042:
            if (r9 == 0) goto L_0x0164
            if (r9 != r8) goto L_0x0146
            java.lang.String r6 = r4.getName()     // Catch:{ Exception -> 0x017d }
            boolean r9 = r6.equals(r12)     // Catch:{ Exception -> 0x017d }
            if (r9 == 0) goto L_0x0128
            int[] r6 = androidx.core.R.styleable.GradientColor     // Catch:{ Exception -> 0x017d }
            android.content.res.TypedArray r6 = androidx.core.content.b.g.a((android.content.res.Resources) r0, (android.content.res.Resources.Theme) r1, (android.util.AttributeSet) r5, (int[]) r6)     // Catch:{ Exception -> 0x017d }
            java.lang.String r9 = "startX"
            int r10 = androidx.core.R.styleable.GradientColor_android_startX     // Catch:{ Exception -> 0x017d }
            r11 = 0
            float r15 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r9, (int) r10, (float) r11)     // Catch:{ Exception -> 0x017d }
            java.lang.String r9 = "startY"
            int r10 = androidx.core.R.styleable.GradientColor_android_startY     // Catch:{ Exception -> 0x017d }
            float r16 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r9, (int) r10, (float) r11)     // Catch:{ Exception -> 0x017d }
            java.lang.String r9 = "endX"
            int r10 = androidx.core.R.styleable.GradientColor_android_endX     // Catch:{ Exception -> 0x017d }
            float r17 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r9, (int) r10, (float) r11)     // Catch:{ Exception -> 0x017d }
            java.lang.String r9 = "endY"
            int r10 = androidx.core.R.styleable.GradientColor_android_endY     // Catch:{ Exception -> 0x017d }
            float r18 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r9, (int) r10, (float) r11)     // Catch:{ Exception -> 0x017d }
            java.lang.String r9 = "centerX"
            int r10 = androidx.core.R.styleable.GradientColor_android_centerX     // Catch:{ Exception -> 0x017d }
            float r9 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r9, (int) r10, (float) r11)     // Catch:{ Exception -> 0x017d }
            java.lang.String r10 = "centerY"
            int r12 = androidx.core.R.styleable.GradientColor_android_centerY     // Catch:{ Exception -> 0x017d }
            float r10 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r10, (int) r12, (float) r11)     // Catch:{ Exception -> 0x017d }
            java.lang.String r12 = "type"
            int r14 = androidx.core.R.styleable.GradientColor_android_type     // Catch:{ Exception -> 0x017d }
            int r12 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r12, (int) r14, (int) r13)     // Catch:{ Exception -> 0x017d }
            java.lang.String r14 = "startColor"
            int r3 = androidx.core.R.styleable.GradientColor_android_startColor     // Catch:{ Exception -> 0x017d }
            int r3 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r14, (int) r3)     // Catch:{ Exception -> 0x017d }
            boolean r14 = androidx.core.content.b.g.a(r4, r2)     // Catch:{ Exception -> 0x017d }
            int r7 = androidx.core.R.styleable.GradientColor_android_centerColor     // Catch:{ Exception -> 0x017d }
            int r2 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r2, (int) r7)     // Catch:{ Exception -> 0x017d }
            java.lang.String r7 = "endColor"
            int r8 = androidx.core.R.styleable.GradientColor_android_endColor     // Catch:{ Exception -> 0x017d }
            int r7 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r7, (int) r8)     // Catch:{ Exception -> 0x017d }
            java.lang.String r8 = "tileMode"
            int r11 = androidx.core.R.styleable.GradientColor_android_tileMode     // Catch:{ Exception -> 0x017d }
            int r8 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r8, (int) r11, (int) r13)     // Catch:{ Exception -> 0x017d }
            java.lang.String r11 = "gradientRadius"
            int r13 = androidx.core.R.styleable.GradientColor_android_gradientRadius     // Catch:{ Exception -> 0x017d }
            r21 = r9
            r9 = 0
            float r22 = androidx.core.content.b.g.a((android.content.res.TypedArray) r6, (org.xmlpull.v1.XmlPullParser) r4, (java.lang.String) r11, (int) r13, (float) r9)     // Catch:{ Exception -> 0x017d }
            r6.recycle()     // Catch:{ Exception -> 0x017d }
            androidx.core.content.b.d$a r0 = androidx.core.content.b.d.a(r0, r4, r5, r1)     // Catch:{ Exception -> 0x017d }
            if (r0 == 0) goto L_0x00c6
            goto L_0x00d3
        L_0x00c6:
            if (r14 == 0) goto L_0x00ce
            androidx.core.content.b.d$a r0 = new androidx.core.content.b.d$a     // Catch:{ Exception -> 0x017d }
            r0.<init>(r3, r2, r7)     // Catch:{ Exception -> 0x017d }
            goto L_0x00d3
        L_0x00ce:
            androidx.core.content.b.d$a r0 = new androidx.core.content.b.d$a     // Catch:{ Exception -> 0x017d }
            r0.<init>((int) r3, (int) r7)     // Catch:{ Exception -> 0x017d }
        L_0x00d3:
            r1 = 1
            if (r12 == r1) goto L_0x00f8
            r1 = 2
            if (r12 == r1) goto L_0x00ec
            android.graphics.LinearGradient r1 = new android.graphics.LinearGradient     // Catch:{ Exception -> 0x017d }
            int[] r2 = r0.f2840a     // Catch:{ Exception -> 0x017d }
            float[] r0 = r0.f2841b     // Catch:{ Exception -> 0x017d }
            android.graphics.Shader$TileMode r21 = androidx.core.content.b.d.a(r8)     // Catch:{ Exception -> 0x017d }
            r14 = r1
            r19 = r2
            r20 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x017d }
            goto L_0x0116
        L_0x00ec:
            android.graphics.SweepGradient r1 = new android.graphics.SweepGradient     // Catch:{ Exception -> 0x017d }
            int[] r2 = r0.f2840a     // Catch:{ Exception -> 0x017d }
            float[] r0 = r0.f2841b     // Catch:{ Exception -> 0x017d }
            r3 = r21
            r1.<init>(r3, r10, r2, r0)     // Catch:{ Exception -> 0x017d }
            goto L_0x0116
        L_0x00f8:
            r3 = r21
            r1 = 0
            int r1 = (r22 > r1 ? 1 : (r22 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0120
            android.graphics.RadialGradient r1 = new android.graphics.RadialGradient     // Catch:{ Exception -> 0x017d }
            int[] r2 = r0.f2840a     // Catch:{ Exception -> 0x017d }
            float[] r0 = r0.f2841b     // Catch:{ Exception -> 0x017d }
            android.graphics.Shader$TileMode r25 = androidx.core.content.b.d.a(r8)     // Catch:{ Exception -> 0x017d }
            r19 = r1
            r20 = r3
            r21 = r10
            r23 = r2
            r24 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x017d }
        L_0x0116:
            androidx.core.content.b.b r0 = new androidx.core.content.b.b     // Catch:{ Exception -> 0x017d }
            r2 = 0
            r3 = 0
            r0.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x011e }
            return r0
        L_0x011e:
            r0 = r2
            goto L_0x017e
        L_0x0120:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x017d }
            java.lang.String r1 = "<gradient> tag requires 'gradientRadius' attribute with radial type"
            r0.<init>(r1)     // Catch:{ Exception -> 0x017d }
            throw r0     // Catch:{ Exception -> 0x017d }
        L_0x0128:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x017d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017d }
            r1.<init>()     // Catch:{ Exception -> 0x017d }
            java.lang.String r2 = r4.getPositionDescription()     // Catch:{ Exception -> 0x017d }
            r1.append(r2)     // Catch:{ Exception -> 0x017d }
            java.lang.String r2 = ": invalid gradient color tag "
            r1.append(r2)     // Catch:{ Exception -> 0x017d }
            r1.append(r6)     // Catch:{ Exception -> 0x017d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x017d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x017d }
            throw r0     // Catch:{ Exception -> 0x017d }
        L_0x0146:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x017d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017d }
            r1.<init>()     // Catch:{ Exception -> 0x017d }
            java.lang.String r2 = r4.getPositionDescription()     // Catch:{ Exception -> 0x017d }
            r1.append(r2)     // Catch:{ Exception -> 0x017d }
            java.lang.String r2 = ": unsupported complex color tag "
            r1.append(r2)     // Catch:{ Exception -> 0x017d }
            r1.append(r6)     // Catch:{ Exception -> 0x017d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x017d }
            r0.<init>(r1)     // Catch:{ Exception -> 0x017d }
            throw r0     // Catch:{ Exception -> 0x017d }
        L_0x0164:
            android.content.res.ColorStateList r0 = androidx.core.content.b.a.a(r0, r4, r5, r1)     // Catch:{ Exception -> 0x017d }
            androidx.core.content.b.b r1 = new androidx.core.content.b.b     // Catch:{ Exception -> 0x017d }
            int r2 = r0.getDefaultColor()     // Catch:{ Exception -> 0x017d }
            r3 = 0
            r1.<init>(r3, r0, r2)     // Catch:{ Exception -> 0x0173 }
            return r1
        L_0x0173:
            r0 = r3
            goto L_0x017e
        L_0x0175:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x017d }
            java.lang.String r1 = "No start tag found"
            r0.<init>(r1)     // Catch:{ Exception -> 0x017d }
            throw r0     // Catch:{ Exception -> 0x017d }
        L_0x017d:
            r0 = 0
        L_0x017e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.b.b.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.b.b");
    }
}
