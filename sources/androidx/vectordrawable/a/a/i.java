package androidx.vectordrawable.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.c;
import com.alipay.mobile.nebula.util.H5TabbarUtils;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class i extends h {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f4884a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    g f4885b;

    /* renamed from: d  reason: collision with root package name */
    boolean f4886d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuffColorFilter f4887e;

    /* renamed from: f  reason: collision with root package name */
    private ColorFilter f4888f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4889g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable.ConstantState f4890h;

    /* renamed from: i  reason: collision with root package name */
    private final float[] f4891i;
    private final Matrix j;
    private final Rect k;

    public final /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    i() {
        this.f4886d = true;
        this.f4891i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f4885b = new g();
    }

    i(g gVar) {
        this.f4886d = true;
        this.f4891i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f4885b = gVar;
        this.f4887e = a(gVar.f4921c, gVar.f4922d);
    }

    public final Drawable mutate() {
        if (this.f4883c != null) {
            this.f4883c.mutate();
            return this;
        }
        if (!this.f4889g && super.mutate() == this) {
            this.f4885b = new g(this.f4885b);
            this.f4889g = true;
        }
        return this;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.f4883c != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.f4883c.getConstantState());
        }
        this.f4885b.f4919a = getChangingConfigurations();
        return this.f4885b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00df, code lost:
        if ((r1 == r6.f4924f.getWidth() && r3 == r6.f4924f.getHeight()) == false) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            android.graphics.drawable.Drawable r0 = r10.f4883c
            if (r0 == 0) goto L_0x000a
            android.graphics.drawable.Drawable r0 = r10.f4883c
            r0.draw(r11)
            return
        L_0x000a:
            android.graphics.Rect r0 = r10.k
            r10.copyBounds(r0)
            android.graphics.Rect r0 = r10.k
            int r0 = r0.width()
            if (r0 <= 0) goto L_0x0179
            android.graphics.Rect r0 = r10.k
            int r0 = r0.height()
            if (r0 > 0) goto L_0x0021
            goto L_0x0179
        L_0x0021:
            android.graphics.ColorFilter r0 = r10.f4888f
            if (r0 != 0) goto L_0x0027
            android.graphics.PorterDuffColorFilter r0 = r10.f4887e
        L_0x0027:
            android.graphics.Matrix r1 = r10.j
            r11.getMatrix(r1)
            android.graphics.Matrix r1 = r10.j
            float[] r2 = r10.f4891i
            r1.getValues(r2)
            float[] r1 = r10.f4891i
            r2 = 0
            r1 = r1[r2]
            float r1 = java.lang.Math.abs(r1)
            float[] r3 = r10.f4891i
            r4 = 4
            r3 = r3[r4]
            float r3 = java.lang.Math.abs(r3)
            float[] r4 = r10.f4891i
            r5 = 1
            r4 = r4[r5]
            float r4 = java.lang.Math.abs(r4)
            float[] r6 = r10.f4891i
            r7 = 3
            r6 = r6[r7]
            float r6 = java.lang.Math.abs(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0062
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0066
        L_0x0062:
            r1 = 1065353216(0x3f800000, float:1.0)
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x0066:
            android.graphics.Rect r4 = r10.k
            int r4 = r4.width()
            float r4 = (float) r4
            float r4 = r4 * r1
            int r1 = (int) r4
            android.graphics.Rect r4 = r10.k
            int r4 = r4.height()
            float r4 = (float) r4
            float r4 = r4 * r3
            int r3 = (int) r4
            r4 = 2048(0x800, float:2.87E-42)
            int r1 = java.lang.Math.min(r4, r1)
            int r3 = java.lang.Math.min(r4, r3)
            if (r1 <= 0) goto L_0x0179
            if (r3 > 0) goto L_0x008a
            goto L_0x0179
        L_0x008a:
            int r4 = r11.save()
            android.graphics.Rect r6 = r10.k
            int r6 = r6.left
            float r6 = (float) r6
            android.graphics.Rect r9 = r10.k
            int r9 = r9.top
            float r9 = (float) r9
            r11.translate(r6, r9)
            int r6 = android.os.Build.VERSION.SDK_INT
            r9 = 17
            if (r6 < r9) goto L_0x00af
            boolean r6 = r10.isAutoMirrored()
            if (r6 == 0) goto L_0x00af
            int r6 = androidx.core.graphics.drawable.a.h(r10)
            if (r6 != r5) goto L_0x00af
            r6 = 1
            goto L_0x00b0
        L_0x00af:
            r6 = 0
        L_0x00b0:
            if (r6 == 0) goto L_0x00c1
            android.graphics.Rect r6 = r10.k
            int r6 = r6.width()
            float r6 = (float) r6
            r11.translate(r6, r8)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11.scale(r6, r7)
        L_0x00c1:
            android.graphics.Rect r6 = r10.k
            r6.offsetTo(r2, r2)
            androidx.vectordrawable.a.a.i$g r6 = r10.f4885b
            android.graphics.Bitmap r7 = r6.f4924f
            if (r7 == 0) goto L_0x00e1
            android.graphics.Bitmap r7 = r6.f4924f
            int r7 = r7.getWidth()
            if (r1 != r7) goto L_0x00de
            android.graphics.Bitmap r7 = r6.f4924f
            int r7 = r7.getHeight()
            if (r3 != r7) goto L_0x00de
            r7 = 1
            goto L_0x00df
        L_0x00de:
            r7 = 0
        L_0x00df:
            if (r7 != 0) goto L_0x00eb
        L_0x00e1:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r1, r3, r7)
            r6.f4924f = r7
            r6.k = r5
        L_0x00eb:
            boolean r6 = r10.f4886d
            if (r6 != 0) goto L_0x00f5
            androidx.vectordrawable.a.a.i$g r6 = r10.f4885b
            r6.a(r1, r3)
            goto L_0x0139
        L_0x00f5:
            androidx.vectordrawable.a.a.i$g r6 = r10.f4885b
            boolean r7 = r6.k
            if (r7 != 0) goto L_0x0119
            android.content.res.ColorStateList r7 = r6.f4925g
            android.content.res.ColorStateList r8 = r6.f4921c
            if (r7 != r8) goto L_0x0119
            android.graphics.PorterDuff$Mode r7 = r6.f4926h
            android.graphics.PorterDuff$Mode r8 = r6.f4922d
            if (r7 != r8) goto L_0x0119
            boolean r7 = r6.j
            boolean r8 = r6.f4923e
            if (r7 != r8) goto L_0x0119
            int r7 = r6.f4927i
            androidx.vectordrawable.a.a.i$f r6 = r6.f4920b
            int r6 = r6.getRootAlpha()
            if (r7 != r6) goto L_0x0119
            r6 = 1
            goto L_0x011a
        L_0x0119:
            r6 = 0
        L_0x011a:
            if (r6 != 0) goto L_0x0139
            androidx.vectordrawable.a.a.i$g r6 = r10.f4885b
            r6.a(r1, r3)
            androidx.vectordrawable.a.a.i$g r1 = r10.f4885b
            android.content.res.ColorStateList r3 = r1.f4921c
            r1.f4925g = r3
            android.graphics.PorterDuff$Mode r3 = r1.f4922d
            r1.f4926h = r3
            androidx.vectordrawable.a.a.i$f r3 = r1.f4920b
            int r3 = r3.getRootAlpha()
            r1.f4927i = r3
            boolean r3 = r1.f4923e
            r1.j = r3
            r1.k = r2
        L_0x0139:
            androidx.vectordrawable.a.a.i$g r1 = r10.f4885b
            android.graphics.Rect r3 = r10.k
            androidx.vectordrawable.a.a.i$f r6 = r1.f4920b
            int r6 = r6.getRootAlpha()
            r7 = 255(0xff, float:3.57E-43)
            if (r6 >= r7) goto L_0x0148
            r2 = 1
        L_0x0148:
            r6 = 0
            if (r2 != 0) goto L_0x014f
            if (r0 != 0) goto L_0x014f
            r0 = r6
            goto L_0x0171
        L_0x014f:
            android.graphics.Paint r2 = r1.l
            if (r2 != 0) goto L_0x015f
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r1.l = r2
            android.graphics.Paint r2 = r1.l
            r2.setFilterBitmap(r5)
        L_0x015f:
            android.graphics.Paint r2 = r1.l
            androidx.vectordrawable.a.a.i$f r5 = r1.f4920b
            int r5 = r5.getRootAlpha()
            r2.setAlpha(r5)
            android.graphics.Paint r2 = r1.l
            r2.setColorFilter(r0)
            android.graphics.Paint r0 = r1.l
        L_0x0171:
            android.graphics.Bitmap r1 = r1.f4924f
            r11.drawBitmap(r1, r6, r3, r0)
            r11.restoreToCount(r4)
        L_0x0179:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.i.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        if (this.f4883c != null) {
            return androidx.core.graphics.drawable.a.b(this.f4883c);
        }
        return this.f4885b.f4920b.getRootAlpha();
    }

    public final void setAlpha(int i2) {
        if (this.f4883c != null) {
            this.f4883c.setAlpha(i2);
        } else if (this.f4885b.f4920b.getRootAlpha() != i2) {
            this.f4885b.f4920b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f4883c != null) {
            this.f4883c.setColorFilter(colorFilter);
            return;
        }
        this.f4888f = colorFilter;
        invalidateSelf();
    }

    public final ColorFilter getColorFilter() {
        if (this.f4883c != null) {
            return androidx.core.graphics.drawable.a.d(this.f4883c);
        }
        return this.f4888f;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i2) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, colorStateList);
            return;
        }
        g gVar = this.f4885b;
        if (gVar.f4921c != colorStateList) {
            gVar.f4921c = colorStateList;
            this.f4887e = a(colorStateList, gVar.f4922d);
            invalidateSelf();
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, mode);
            return;
        }
        g gVar = this.f4885b;
        if (gVar.f4922d != mode) {
            gVar.f4922d = mode;
            this.f4887e = a(gVar.f4921c, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.f4883c != null) {
            return this.f4883c.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        g gVar = this.f4885b;
        if (gVar == null) {
            return false;
        }
        if (!gVar.f4920b.a()) {
            return this.f4885b.f4921c != null && this.f4885b.f4921c.isStateful();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        if (this.f4883c != null) {
            return this.f4883c.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f4885b;
        if (!(gVar.f4921c == null || gVar.f4922d == null)) {
            this.f4887e = a(gVar.f4921c, gVar.f4922d);
            invalidateSelf();
            z = true;
        }
        if (!gVar.f4920b.a()) {
            return z;
        }
        boolean a2 = gVar.f4920b.f4912c.a(iArr);
        gVar.k |= a2;
        if (!a2) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.f4883c != null) {
            return this.f4883c.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.f4883c != null) {
            return this.f4883c.getIntrinsicWidth();
        }
        return (int) this.f4885b.f4920b.f4913d;
    }

    public final int getIntrinsicHeight() {
        if (this.f4883c != null) {
            return this.f4883c.getIntrinsicHeight();
        }
        return (int) this.f4885b.f4920b.f4914e;
    }

    public final boolean canApplyTheme() {
        if (this.f4883c == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.c(this.f4883c);
        return false;
    }

    public final boolean isAutoMirrored() {
        if (this.f4883c != null) {
            return androidx.core.graphics.drawable.a.a(this.f4883c);
        }
        return this.f4885b.f4923e;
    }

    public final void setAutoMirrored(boolean z) {
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, z);
        } else {
            this.f4885b.f4923e = z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[Catch:{ IOException | XmlPullParserException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038 A[Catch:{ IOException | XmlPullParserException -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.a.a.i a(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x001f
            androidx.vectordrawable.a.a.i r0 = new androidx.vectordrawable.a.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.f.a((android.content.res.Resources) r4, (int) r5, (android.content.res.Resources.Theme) r6)
            r0.f4883c = r4
            androidx.vectordrawable.a.a.i$h r4 = new androidx.vectordrawable.a.a.i$h
            android.graphics.drawable.Drawable r5 = r0.f4883c
            android.graphics.drawable.Drawable$ConstantState r5 = r5.getConstantState()
            r4.<init>(r5)
            r0.f4890h = r4
            return r0
        L_0x001f:
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)     // Catch:{ IOException | XmlPullParserException -> 0x0040 }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)     // Catch:{ IOException | XmlPullParserException -> 0x0040 }
        L_0x0027:
            int r1 = r5.next()     // Catch:{ IOException | XmlPullParserException -> 0x0040 }
            r2 = 2
            if (r1 == r2) goto L_0x0031
            r3 = 1
            if (r1 != r3) goto L_0x0027
        L_0x0031:
            if (r1 != r2) goto L_0x0038
            androidx.vectordrawable.a.a.i r4 = a(r4, r5, r0, r6)     // Catch:{ IOException | XmlPullParserException -> 0x0040 }
            return r4
        L_0x0038:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ IOException | XmlPullParserException -> 0x0040 }
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)     // Catch:{ IOException | XmlPullParserException -> 0x0040 }
            throw r4     // Catch:{ IOException | XmlPullParserException -> 0x0040 }
        L_0x0040:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.a.a.i.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.a.a.i");
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f4883c != null) {
            this.f4883c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        ColorStateList colorStateList;
        Resources resources2 = resources;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        if (this.f4883c != null) {
            androidx.core.graphics.drawable.a.a(this.f4883c, resources2, xmlPullParser2, attributeSet2, theme2);
            return;
        }
        g gVar = this.f4885b;
        gVar.f4920b = new f();
        TypedArray a2 = androidx.core.content.b.g.a(resources2, theme2, attributeSet2, a.f4857a);
        g gVar2 = this.f4885b;
        f fVar = gVar2.f4920b;
        int a3 = androidx.core.content.b.g.a(a2, xmlPullParser2, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (a3 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (a3 == 5) {
            mode = PorterDuff.Mode.SRC_IN;
        } else if (a3 != 9) {
            switch (a3) {
                case 14:
                    mode = PorterDuff.Mode.MULTIPLY;
                    break;
                case 15:
                    mode = PorterDuff.Mode.SCREEN;
                    break;
                case 16:
                    mode = PorterDuff.Mode.ADD;
                    break;
            }
        } else {
            mode = PorterDuff.Mode.SRC_ATOP;
        }
        gVar2.f4922d = mode;
        if (androidx.core.content.b.g.a(xmlPullParser2, "tint")) {
            TypedValue typedValue = new TypedValue();
            a2.getValue(1, typedValue);
            if (typedValue.type != 2) {
                colorStateList = (typedValue.type < 28 || typedValue.type > 31) ? androidx.core.content.b.a.a(a2.getResources(), a2.getResourceId(1, 0), theme2) : ColorStateList.valueOf(typedValue.data);
            } else {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: ".concat(String.valueOf(typedValue)));
            }
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            gVar2.f4921c = colorStateList;
        }
        gVar2.f4923e = androidx.core.content.b.g.a(a2, xmlPullParser2, "autoMirrored", 5, gVar2.f4923e);
        fVar.f4915f = androidx.core.content.b.g.a(a2, xmlPullParser2, "viewportWidth", 7, fVar.f4915f);
        fVar.f4916g = androidx.core.content.b.g.a(a2, xmlPullParser2, "viewportHeight", 8, fVar.f4916g);
        if (fVar.f4915f <= 0.0f) {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.f4916g > 0.0f) {
            fVar.f4913d = a2.getDimension(3, fVar.f4913d);
            fVar.f4914e = a2.getDimension(2, fVar.f4914e);
            if (fVar.f4913d <= 0.0f) {
                throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.f4914e > 0.0f) {
                fVar.setAlpha(androidx.core.content.b.g.a(a2, xmlPullParser2, "alpha", 4, fVar.getAlpha()));
                String string = a2.getString(0);
                if (string != null) {
                    fVar.f4918i = string;
                    fVar.k.put(string, fVar);
                }
                a2.recycle();
                gVar.f4919a = getChangingConfigurations();
                gVar.k = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.f4887e = a(gVar.f4921c, gVar.f4922d);
            } else {
                throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(a2.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Resources resources2 = resources;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AttributeSet attributeSet2 = attributeSet;
        Resources.Theme theme2 = theme;
        g gVar = this.f4885b;
        f fVar = gVar.f4920b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f4912c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        for (int i2 = 1; eventType != i2 && (xmlPullParser.getDepth() >= depth || eventType != 3); i2 = 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if (H5TabbarUtils.MATCH_TYPE_PATH.equals(name)) {
                    b bVar = new b();
                    TypedArray a2 = androidx.core.content.b.g.a(resources2, theme2, attributeSet2, a.f4859c);
                    bVar.a(a2, xmlPullParser2, theme2);
                    a2.recycle();
                    cVar.f4902b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.k.put(bVar.getPathName(), bVar);
                    }
                    gVar.f4919a = bVar.o | gVar.f4919a;
                    z = false;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    if (androidx.core.content.b.g.a(xmlPullParser2, "pathData")) {
                        TypedArray a3 = androidx.core.content.b.g.a(resources2, theme2, attributeSet2, a.f4860d);
                        aVar.a(a3, xmlPullParser2);
                        a3.recycle();
                    }
                    cVar.f4902b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.k.put(aVar.getPathName(), aVar);
                    }
                    gVar.f4919a = aVar.o | gVar.f4919a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    TypedArray a4 = androidx.core.content.b.g.a(resources2, theme2, attributeSet2, a.f4858b);
                    cVar2.l = null;
                    cVar2.f4903c = androidx.core.content.b.g.a(a4, xmlPullParser2, "rotation", 5, cVar2.f4903c);
                    cVar2.f4904d = a4.getFloat(1, cVar2.f4904d);
                    cVar2.f4905e = a4.getFloat(2, cVar2.f4905e);
                    cVar2.f4906f = androidx.core.content.b.g.a(a4, xmlPullParser2, "scaleX", 3, cVar2.f4906f);
                    cVar2.f4907g = androidx.core.content.b.g.a(a4, xmlPullParser2, "scaleY", 4, cVar2.f4907g);
                    cVar2.f4908h = androidx.core.content.b.g.a(a4, xmlPullParser2, "translateX", 6, cVar2.f4908h);
                    cVar2.f4909i = androidx.core.content.b.g.a(a4, xmlPullParser2, "translateY", 7, cVar2.f4909i);
                    String string = a4.getString(0);
                    if (string != null) {
                        cVar2.m = string;
                    }
                    cVar2.a();
                    a4.recycle();
                    cVar.f4902b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.k.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f4919a = cVar2.k | gVar.f4919a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        if (this.f4883c != null) {
            this.f4883c.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.f4883c != null) {
            return this.f4883c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4885b.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.f4883c != null) {
            this.f4883c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j2) {
        if (this.f4883c != null) {
            this.f4883c.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.f4883c != null) {
            return this.f4883c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.f4883c != null) {
            this.f4883c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f4928a;

        public h(Drawable.ConstantState constantState) {
            this.f4928a = constantState;
        }

        public final Drawable newDrawable() {
            i iVar = new i();
            iVar.f4883c = (VectorDrawable) this.f4928a.newDrawable();
            return iVar;
        }

        public final Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f4883c = (VectorDrawable) this.f4928a.newDrawable(resources);
            return iVar;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f4883c = (VectorDrawable) this.f4928a.newDrawable(resources, theme);
            return iVar;
        }

        public final boolean canApplyTheme() {
            return this.f4928a.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.f4928a.getChangingConfigurations();
        }
    }

    static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f4919a;

        /* renamed from: b  reason: collision with root package name */
        f f4920b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f4921c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f4922d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4923e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f4924f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f4925g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f4926h;

        /* renamed from: i  reason: collision with root package name */
        int f4927i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.f4921c = null;
            this.f4922d = i.f4884a;
            if (gVar != null) {
                this.f4919a = gVar.f4919a;
                this.f4920b = new f(gVar.f4920b);
                if (gVar.f4920b.f4911b != null) {
                    this.f4920b.f4911b = new Paint(gVar.f4920b.f4911b);
                }
                if (gVar.f4920b.f4910a != null) {
                    this.f4920b.f4910a = new Paint(gVar.f4920b.f4910a);
                }
                this.f4921c = gVar.f4921c;
                this.f4922d = gVar.f4922d;
                this.f4923e = gVar.f4923e;
            }
        }

        public final void a(int i2, int i3) {
            this.f4924f.eraseColor(0);
            this.f4920b.a(new Canvas(this.f4924f), i2, i3);
        }

        public g() {
            this.f4921c = null;
            this.f4922d = i.f4884a;
            this.f4920b = new f();
        }

        public final Drawable newDrawable() {
            return new i(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public final int getChangingConfigurations() {
            return this.f4919a;
        }
    }

    static class f {
        private static final Matrix n = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        Paint f4910a;

        /* renamed from: b  reason: collision with root package name */
        Paint f4911b;

        /* renamed from: c  reason: collision with root package name */
        final c f4912c;

        /* renamed from: d  reason: collision with root package name */
        float f4913d;

        /* renamed from: e  reason: collision with root package name */
        float f4914e;

        /* renamed from: f  reason: collision with root package name */
        float f4915f;

        /* renamed from: g  reason: collision with root package name */
        float f4916g;

        /* renamed from: h  reason: collision with root package name */
        int f4917h;

        /* renamed from: i  reason: collision with root package name */
        String f4918i;
        Boolean j;
        final androidx.a.a<String, Object> k;
        private final Path l;
        private final Path m;
        private final Matrix o;
        private PathMeasure p;
        private int q;

        public f() {
            this.o = new Matrix();
            this.f4913d = 0.0f;
            this.f4914e = 0.0f;
            this.f4915f = 0.0f;
            this.f4916g = 0.0f;
            this.f4917h = PriceRangeSeekBar.INVALID_POINTER_ID;
            this.f4918i = null;
            this.j = null;
            this.k = new androidx.a.a<>();
            this.f4912c = new c();
            this.l = new Path();
            this.m = new Path();
        }

        public final void setRootAlpha(int i2) {
            this.f4917h = i2;
        }

        public final int getRootAlpha() {
            return this.f4917h;
        }

        public final void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public final float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public f(f fVar) {
            this.o = new Matrix();
            this.f4913d = 0.0f;
            this.f4914e = 0.0f;
            this.f4915f = 0.0f;
            this.f4916g = 0.0f;
            this.f4917h = PriceRangeSeekBar.INVALID_POINTER_ID;
            this.f4918i = null;
            this.j = null;
            this.k = new androidx.a.a<>();
            this.f4912c = new c(fVar.f4912c, this.k);
            this.l = new Path(fVar.l);
            this.m = new Path(fVar.m);
            this.f4913d = fVar.f4913d;
            this.f4914e = fVar.f4914e;
            this.f4915f = fVar.f4915f;
            this.f4916g = fVar.f4916g;
            this.q = fVar.q;
            this.f4917h = fVar.f4917h;
            this.f4918i = fVar.f4918i;
            String str = fVar.f4918i;
            if (str != null) {
                this.k.put(str, this);
            }
            this.j = fVar.j;
        }

        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r11v1, types: [boolean] */
        /* JADX WARNING: type inference failed for: r11v2 */
        private void a(c cVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            f fVar;
            f fVar2 = this;
            c cVar2 = cVar;
            Canvas canvas2 = canvas;
            ColorFilter colorFilter2 = colorFilter;
            cVar2.f4901a.set(matrix);
            cVar2.f4901a.preConcat(cVar2.j);
            canvas.save();
            ? r11 = 0;
            int i4 = 0;
            while (i4 < cVar2.f4902b.size()) {
                d dVar = cVar2.f4902b.get(i4);
                if (dVar instanceof c) {
                    a((c) dVar, cVar2.f4901a, canvas, i2, i3, colorFilter);
                } else if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    float f2 = ((float) i2) / fVar2.f4915f;
                    float f3 = ((float) i3) / fVar2.f4916g;
                    float min = Math.min(f2, f3);
                    Matrix matrix2 = cVar2.f4901a;
                    fVar2.o.set(matrix2);
                    fVar2.o.postScale(f2, f3);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float f4 = min;
                    float f5 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot((double) fArr[r11], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f5) / max : 0.0f;
                    if (abs != 0.0f) {
                        fVar = this;
                        eVar.a(fVar.l);
                        Path path = fVar.l;
                        fVar.m.reset();
                        if (eVar.a()) {
                            fVar.m.setFillType(eVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            fVar.m.addPath(path, fVar.o);
                            canvas2.clipPath(fVar.m);
                        } else {
                            b bVar = (b) eVar;
                            if (!(bVar.f4897f == 0.0f && bVar.f4898g == 1.0f)) {
                                float f6 = (bVar.f4897f + bVar.f4899h) % 1.0f;
                                float f7 = (bVar.f4898g + bVar.f4899h) % 1.0f;
                                if (fVar.p == null) {
                                    fVar.p = new PathMeasure();
                                }
                                fVar.p.setPath(fVar.l, r11);
                                float length = fVar.p.getLength();
                                float f8 = f6 * length;
                                float f9 = f7 * length;
                                path.reset();
                                if (f8 > f9) {
                                    fVar.p.getSegment(f8, length, path, true);
                                    fVar.p.getSegment(0.0f, f9, path, true);
                                } else {
                                    fVar.p.getSegment(f8, f9, path, true);
                                }
                                path.rLineTo(0.0f, 0.0f);
                            }
                            fVar.m.addPath(path, fVar.o);
                            if (bVar.f4894c.c()) {
                                androidx.core.content.b.b bVar2 = bVar.f4894c;
                                if (fVar.f4911b == null) {
                                    fVar.f4911b = new Paint(1);
                                    fVar.f4911b.setStyle(Paint.Style.FILL);
                                }
                                Paint paint = fVar.f4911b;
                                if (bVar2.a()) {
                                    Shader shader = bVar2.f2827a;
                                    shader.setLocalMatrix(fVar.o);
                                    paint.setShader(shader);
                                    paint.setAlpha(Math.round(bVar.f4896e * 255.0f));
                                } else {
                                    paint.setShader((Shader) null);
                                    paint.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
                                    paint.setColor(i.a(bVar2.f2828b, bVar.f4896e));
                                }
                                paint.setColorFilter(colorFilter2);
                                fVar.m.setFillType(bVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas2.drawPath(fVar.m, paint);
                            }
                            if (bVar.f4892a.c()) {
                                androidx.core.content.b.b bVar3 = bVar.f4892a;
                                if (fVar.f4910a == null) {
                                    fVar.f4910a = new Paint(1);
                                    fVar.f4910a.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint2 = fVar.f4910a;
                                if (bVar.j != null) {
                                    paint2.setStrokeJoin(bVar.j);
                                }
                                if (bVar.f4900i != null) {
                                    paint2.setStrokeCap(bVar.f4900i);
                                }
                                paint2.setStrokeMiter(bVar.k);
                                if (bVar3.a()) {
                                    Shader shader2 = bVar3.f2827a;
                                    shader2.setLocalMatrix(fVar.o);
                                    paint2.setShader(shader2);
                                    paint2.setAlpha(Math.round(bVar.f4895d * 255.0f));
                                } else {
                                    paint2.setShader((Shader) null);
                                    paint2.setAlpha(PriceRangeSeekBar.INVALID_POINTER_ID);
                                    paint2.setColor(i.a(bVar3.f2828b, bVar.f4895d));
                                }
                                paint2.setColorFilter(colorFilter2);
                                paint2.setStrokeWidth(bVar.f4893b * abs * f4);
                                canvas2.drawPath(fVar.m, paint2);
                            }
                        }
                    } else {
                        fVar = this;
                    }
                    i4++;
                    fVar2 = fVar;
                    r11 = 0;
                }
                int i5 = i2;
                int i6 = i3;
                fVar = fVar2;
                i4++;
                fVar2 = fVar;
                r11 = 0;
            }
            f fVar3 = fVar2;
            canvas.restore();
        }

        public final void a(Canvas canvas, int i2, int i3) {
            a(this.f4912c, n, canvas, i2, i3, (ColorFilter) null);
        }

        public final boolean a() {
            if (this.j == null) {
                this.j = Boolean.valueOf(this.f4912c.b());
            }
            return this.j.booleanValue();
        }
    }

    static abstract class d {
        public boolean a(int[] iArr) {
            return false;
        }

        public boolean b() {
            return false;
        }

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static class c extends d {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f4901a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<d> f4902b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        float f4903c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        float f4904d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        float f4905e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        float f4906f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        float f4907g = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        float f4908h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        float f4909i = 0.0f;
        final Matrix j = new Matrix();
        int k;
        int[] l;
        String m = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(c cVar, androidx.a.a<String, Object> aVar) {
            super((byte) 0);
            e eVar;
            this.f4903c = cVar.f4903c;
            this.f4904d = cVar.f4904d;
            this.f4905e = cVar.f4905e;
            this.f4906f = cVar.f4906f;
            this.f4907g = cVar.f4907g;
            this.f4908h = cVar.f4908h;
            this.f4909i = cVar.f4909i;
            this.l = cVar.l;
            this.m = cVar.m;
            this.k = cVar.k;
            String str = this.m;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(cVar.j);
            ArrayList<d> arrayList = cVar.f4902b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = arrayList.get(i2);
                if (dVar instanceof c) {
                    this.f4902b.add(new c((c) dVar, aVar));
                } else {
                    if (dVar instanceof b) {
                        eVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        eVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f4902b.add(eVar);
                    if (eVar.m != null) {
                        aVar.put(eVar.m, eVar);
                    }
                }
            }
        }

        public c() {
            super((byte) 0);
        }

        public final String getGroupName() {
            return this.m;
        }

        public final Matrix getLocalMatrix() {
            return this.j;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.j.reset();
            this.j.postTranslate(-this.f4904d, -this.f4905e);
            this.j.postScale(this.f4906f, this.f4907g);
            this.j.postRotate(this.f4903c, 0.0f, 0.0f);
            this.j.postTranslate(this.f4908h + this.f4904d, this.f4909i + this.f4905e);
        }

        public final float getRotation() {
            return this.f4903c;
        }

        public final void setRotation(float f2) {
            if (f2 != this.f4903c) {
                this.f4903c = f2;
                a();
            }
        }

        public final float getPivotX() {
            return this.f4904d;
        }

        public final void setPivotX(float f2) {
            if (f2 != this.f4904d) {
                this.f4904d = f2;
                a();
            }
        }

        public final float getPivotY() {
            return this.f4905e;
        }

        public final void setPivotY(float f2) {
            if (f2 != this.f4905e) {
                this.f4905e = f2;
                a();
            }
        }

        public final float getScaleX() {
            return this.f4906f;
        }

        public final void setScaleX(float f2) {
            if (f2 != this.f4906f) {
                this.f4906f = f2;
                a();
            }
        }

        public final float getScaleY() {
            return this.f4907g;
        }

        public final void setScaleY(float f2) {
            if (f2 != this.f4907g) {
                this.f4907g = f2;
                a();
            }
        }

        public final float getTranslateX() {
            return this.f4908h;
        }

        public final void setTranslateX(float f2) {
            if (f2 != this.f4908h) {
                this.f4908h = f2;
                a();
            }
        }

        public final float getTranslateY() {
            return this.f4909i;
        }

        public final void setTranslateY(float f2) {
            if (f2 != this.f4909i) {
                this.f4909i = f2;
                a();
            }
        }

        public final boolean b() {
            for (int i2 = 0; i2 < this.f4902b.size(); i2++) {
                if (this.f4902b.get(i2).b()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f4902b.size(); i2++) {
                z |= this.f4902b.get(i2).a(iArr);
            }
            return z;
        }
    }

    static abstract class e extends d {
        protected c.b[] l = null;
        String m;
        int n = 0;
        int o;

        public boolean a() {
            return false;
        }

        public e() {
            super((byte) 0);
        }

        public e(e eVar) {
            super((byte) 0);
            this.m = eVar.m;
            this.o = eVar.o;
            this.l = androidx.core.graphics.c.a(eVar.l);
        }

        public final void a(Path path) {
            path.reset();
            c.b[] bVarArr = this.l;
            if (bVarArr != null) {
                c.b.a(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.m;
        }

        public c.b[] getPathData() {
            return this.l;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!androidx.core.graphics.c.a(this.l, bVarArr)) {
                this.l = androidx.core.graphics.c.a(bVarArr);
                return;
            }
            c.b[] bVarArr2 = this.l;
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                bVarArr2[i2].f2979a = bVarArr[i2].f2979a;
                for (int i3 = 0; i3 < bVarArr[i2].f2980b.length; i3++) {
                    bVarArr2[i2].f2980b[i3] = bVarArr[i2].f2980b[i3];
                }
            }
        }
    }

    static class a extends e {
        public final boolean a() {
            return true;
        }

        a() {
        }

        a(a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.l = androidx.core.graphics.c.b(string2);
            }
            this.n = androidx.core.content.b.g.a(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    static class b extends e {

        /* renamed from: a  reason: collision with root package name */
        androidx.core.content.b.b f4892a;

        /* renamed from: b  reason: collision with root package name */
        float f4893b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        androidx.core.content.b.b f4894c;

        /* renamed from: d  reason: collision with root package name */
        float f4895d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f4896e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f4897f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        float f4898g = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        float f4899h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        Paint.Cap f4900i = Paint.Cap.BUTT;
        Paint.Join j = Paint.Join.MITER;
        float k = 4.0f;
        private int[] p;

        b() {
        }

        b(b bVar) {
            super(bVar);
            this.p = bVar.p;
            this.f4892a = bVar.f4892a;
            this.f4893b = bVar.f4893b;
            this.f4895d = bVar.f4895d;
            this.f4894c = bVar.f4894c;
            this.n = bVar.n;
            this.f4896e = bVar.f4896e;
            this.f4897f = bVar.f4897f;
            this.f4898g = bVar.f4898g;
            this.f4899h = bVar.f4899h;
            this.f4900i = bVar.f4900i;
            this.j = bVar.j;
            this.k = bVar.k;
        }

        /* access modifiers changed from: package-private */
        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.p = null;
            if (androidx.core.content.b.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.l = androidx.core.graphics.c.b(string2);
                }
                this.f4894c = androidx.core.content.b.g.a(typedArray, xmlPullParser, theme, "fillColor", 1);
                this.f4896e = androidx.core.content.b.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f4896e);
                int a2 = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1);
                Paint.Cap cap = this.f4900i;
                if (a2 == 0) {
                    cap = Paint.Cap.BUTT;
                } else if (a2 == 1) {
                    cap = Paint.Cap.ROUND;
                } else if (a2 == 2) {
                    cap = Paint.Cap.SQUARE;
                }
                this.f4900i = cap;
                int a3 = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1);
                Paint.Join join = this.j;
                if (a3 == 0) {
                    join = Paint.Join.MITER;
                } else if (a3 == 1) {
                    join = Paint.Join.ROUND;
                } else if (a3 == 2) {
                    join = Paint.Join.BEVEL;
                }
                this.j = join;
                this.k = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.k);
                this.f4892a = androidx.core.content.b.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3);
                this.f4895d = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f4895d);
                this.f4893b = androidx.core.content.b.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f4893b);
                this.f4898g = androidx.core.content.b.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f4898g);
                this.f4899h = androidx.core.content.b.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f4899h);
                this.f4897f = androidx.core.content.b.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.f4897f);
                this.n = androidx.core.content.b.g.a(typedArray, xmlPullParser, "fillType", 13, this.n);
            }
        }

        public final boolean b() {
            return this.f4894c.b() || this.f4892a.b();
        }

        public final boolean a(int[] iArr) {
            return this.f4892a.a(iArr) | this.f4894c.a(iArr);
        }

        /* access modifiers changed from: package-private */
        public final int getStrokeColor() {
            return this.f4892a.f2828b;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeColor(int i2) {
            this.f4892a.f2828b = i2;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeWidth() {
            return this.f4893b;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeWidth(float f2) {
            this.f4893b = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getStrokeAlpha() {
            return this.f4895d;
        }

        /* access modifiers changed from: package-private */
        public final void setStrokeAlpha(float f2) {
            this.f4895d = f2;
        }

        /* access modifiers changed from: package-private */
        public final int getFillColor() {
            return this.f4894c.f2828b;
        }

        /* access modifiers changed from: package-private */
        public final void setFillColor(int i2) {
            this.f4894c.f2828b = i2;
        }

        /* access modifiers changed from: package-private */
        public final float getFillAlpha() {
            return this.f4896e;
        }

        /* access modifiers changed from: package-private */
        public final void setFillAlpha(float f2) {
            this.f4896e = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathStart() {
            return this.f4897f;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathStart(float f2) {
            this.f4897f = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathEnd() {
            return this.f4898g;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathEnd(float f2) {
            this.f4898g = f2;
        }

        /* access modifiers changed from: package-private */
        public final float getTrimPathOffset() {
            return this.f4899h;
        }

        /* access modifiers changed from: package-private */
        public final void setTrimPathOffset(float f2) {
            this.f4899h = f2;
        }
    }
}
