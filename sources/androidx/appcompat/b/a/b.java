package androidx.appcompat.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

class b extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    C0023b f1178a;

    /* renamed from: b  reason: collision with root package name */
    int f1179b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Rect f1180c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f1181d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1182e;

    /* renamed from: f  reason: collision with root package name */
    private int f1183f = PriceRangeSeekBar.INVALID_POINTER_ID;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1184g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1185h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f1186i;
    private long j;
    private long k;
    private a l;

    b() {
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1182e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1178a.getChangingConfigurations();
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        C0023b bVar = this.f1178a;
        Rect rect2 = null;
        boolean z2 = true;
        if (!bVar.k) {
            if (bVar.m != null || bVar.l) {
                rect2 = bVar.m;
            } else {
                bVar.c();
                Rect rect3 = new Rect();
                int i2 = bVar.j;
                Drawable[] drawableArr = bVar.f1195i;
                Rect rect4 = null;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect3)) {
                        if (rect4 == null) {
                            rect4 = new Rect(0, 0, 0, 0);
                        }
                        if (rect3.left > rect4.left) {
                            rect4.left = rect3.left;
                        }
                        if (rect3.top > rect4.top) {
                            rect4.top = rect3.top;
                        }
                        if (rect3.right > rect4.right) {
                            rect4.right = rect3.right;
                        }
                        if (rect3.bottom > rect4.bottom) {
                            rect4.bottom = rect3.bottom;
                        }
                    }
                }
                bVar.l = true;
                bVar.m = rect4;
                rect2 = rect4;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            z = (((rect2.left | rect2.top) | rect2.bottom) | rect2.right) != 0;
        } else {
            Drawable drawable = this.f1181d;
            if (drawable != null) {
                z = drawable.getPadding(rect);
            } else {
                z = super.getPadding(rect);
            }
        }
        if (!isAutoMirrored() || androidx.core.graphics.drawable.a.h(this) != 1) {
            z2 = false;
        }
        if (z2) {
            int i4 = rect.left;
            rect.left = rect.right;
            rect.right = i4;
        }
        return z;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public void setAlpha(int i2) {
        if (!this.f1184g || this.f1183f != i2) {
            this.f1184g = true;
            this.f1183f = i2;
            Drawable drawable = this.f1181d;
            if (drawable == null) {
                return;
            }
            if (this.j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public int getAlpha() {
        return this.f1183f;
    }

    public void setDither(boolean z) {
        if (this.f1178a.z != z) {
            C0023b bVar = this.f1178a;
            bVar.z = z;
            Drawable drawable = this.f1181d;
            if (drawable != null) {
                drawable.setDither(bVar.z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        C0023b bVar = this.f1178a;
        bVar.G = true;
        if (bVar.F != colorFilter) {
            this.f1178a.F = colorFilter;
            Drawable drawable = this.f1181d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        C0023b bVar = this.f1178a;
        bVar.J = true;
        if (bVar.H != colorStateList) {
            this.f1178a.H = colorStateList;
            androidx.core.graphics.drawable.a.a(this.f1181d, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        C0023b bVar = this.f1178a;
        bVar.K = true;
        if (bVar.I != mode) {
            this.f1178a.I = mode;
            androidx.core.graphics.drawable.a.a(this.f1181d, mode);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1182e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1181d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean isStateful() {
        C0023b bVar = this.f1178a;
        if (bVar.v) {
            return bVar.w;
        }
        bVar.c();
        int i2 = bVar.j;
        Drawable[] drawableArr = bVar.f1195i;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            } else if (drawableArr[i3].isStateful()) {
                z = true;
                break;
            } else {
                i3++;
            }
        }
        bVar.w = z;
        bVar.v = true;
        return z;
    }

    public void setAutoMirrored(boolean z) {
        if (this.f1178a.E != z) {
            C0023b bVar = this.f1178a;
            bVar.E = z;
            Drawable drawable = this.f1181d;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.a(drawable, bVar.E);
            }
        }
    }

    public boolean isAutoMirrored() {
        return this.f1178a.E;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f1182e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1182e = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1181d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1184g) {
                this.f1181d.setAlpha(this.f1183f);
            }
        }
        if (this.k != 0) {
            this.k = 0;
            z = true;
        }
        if (this.j != 0) {
            this.j = 0;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f1180c;
        if (rect == null) {
            this.f1180c = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, i2, i3, i4, i5);
        }
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f1180c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1182e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1181d;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f1182e;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f1181d;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    public boolean onLayoutDirectionChanged(int i2) {
        C0023b bVar = this.f1178a;
        int i3 = this.f1179b;
        int i4 = bVar.j;
        Drawable[] drawableArr = bVar.f1195i;
        boolean z = false;
        for (int i5 = 0; i5 < i4; i5++) {
            if (drawableArr[i5] != null) {
                boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                if (i5 == i3) {
                    z = layoutDirection;
                }
            }
        }
        bVar.B = i2;
        return z;
    }

    public int getIntrinsicWidth() {
        if (this.f1178a.n) {
            C0023b bVar = this.f1178a;
            if (!bVar.o) {
                bVar.d();
            }
            return bVar.p;
        }
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getIntrinsicHeight() {
        if (this.f1178a.n) {
            C0023b bVar = this.f1178a;
            if (!bVar.o) {
                bVar.d();
            }
            return bVar.q;
        }
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getMinimumWidth() {
        if (this.f1178a.n) {
            C0023b bVar = this.f1178a;
            if (!bVar.o) {
                bVar.d();
            }
            return bVar.r;
        }
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getMinimumHeight() {
        if (this.f1178a.n) {
            C0023b bVar = this.f1178a;
            if (!bVar.o) {
                bVar.d();
            }
            return bVar.s;
        }
        Drawable drawable = this.f1181d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        C0023b bVar = this.f1178a;
        if (bVar != null) {
            bVar.b();
        }
        if (drawable == this.f1181d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f1181d && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f1181d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f1182e;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f1181d;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public int getOpacity() {
        Drawable drawable = this.f1181d;
        int i2 = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        C0023b bVar = this.f1178a;
        if (bVar.t) {
            return bVar.u;
        }
        bVar.c();
        int i3 = bVar.j;
        Drawable[] drawableArr = bVar.f1195i;
        if (i3 > 0) {
            i2 = drawableArr[0].getOpacity();
        }
        int i4 = i2;
        for (int i5 = 1; i5 < i3; i5++) {
            i4 = Drawable.resolveOpacity(i4, drawableArr[i5].getOpacity());
        }
        bVar.u = i4;
        bVar.t = true;
        return i4;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2) {
        if (i2 == this.f1179b) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f1178a.D > 0) {
            Drawable drawable = this.f1182e;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f1181d;
            if (drawable2 != null) {
                this.f1182e = drawable2;
                this.k = ((long) this.f1178a.D) + uptimeMillis;
            } else {
                this.f1182e = null;
                this.k = 0;
            }
        } else {
            Drawable drawable3 = this.f1181d;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i2 < 0 || i2 >= this.f1178a.j) {
            this.f1181d = null;
            this.f1179b = -1;
        } else {
            Drawable b2 = this.f1178a.b(i2);
            this.f1181d = b2;
            this.f1179b = i2;
            if (b2 != null) {
                if (this.f1178a.C > 0) {
                    this.j = uptimeMillis + ((long) this.f1178a.C);
                }
                a(b2);
            }
        }
        if (!(this.j == 0 && this.k == 0)) {
            Runnable runnable = this.f1186i;
            if (runnable == null) {
                this.f1186i = new Runnable() {
                    public final void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    private void a(Drawable drawable) {
        if (this.l == null) {
            this.l = new a();
        }
        a aVar = this.l;
        aVar.f1188a = drawable.getCallback();
        drawable.setCallback(aVar);
        try {
            if (this.f1178a.C <= 0 && this.f1184g) {
                drawable.setAlpha(this.f1183f);
            }
            if (this.f1178a.G) {
                drawable.setColorFilter(this.f1178a.F);
            } else {
                if (this.f1178a.J) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f1178a.H);
                }
                if (this.f1178a.K) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f1178a.I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1178a.z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f1178a.E);
            }
            Rect rect = this.f1180c;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.l.a());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1184g = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1181d
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0020
            int r9 = r13.f1183f
            r3.setAlpha(r9)
            goto L_0x0038
        L_0x0020:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.b.a.b$b r9 = r13.f1178a
            int r9 = r9.C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.f1181d
            int r3 = 255 - r3
            int r10 = r13.f1183f
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.j = r7
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.f1182e
            if (r9 == 0) goto L_0x0065
            long r10 = r13.k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f1182e = r0
            goto L_0x0065
        L_0x0050:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.b.a.b$b r4 = r13.f1178a
            int r4 = r4.D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.f1182e
            int r5 = r13.f1183f
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L_0x0068
        L_0x0065:
            r13.k = r7
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r14 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0074
            java.lang.Runnable r14 = r13.f1186i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.b.a(boolean):void");
    }

    public Drawable getCurrent() {
        return this.f1181d;
    }

    public void applyTheme(Resources.Theme theme) {
        C0023b bVar = this.f1178a;
        if (theme != null) {
            bVar.c();
            int i2 = bVar.j;
            Drawable[] drawableArr = bVar.f1195i;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                    drawableArr[i3].applyTheme(theme);
                    bVar.f1193g |= drawableArr[i3].getChangingConfigurations();
                }
            }
            bVar.a(theme.getResources());
        }
    }

    public boolean canApplyTheme() {
        return this.f1178a.canApplyTheme();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f1178a.e()) {
            return null;
        }
        this.f1178a.f1192f = getChangingConfigurations();
        return this.f1178a;
    }

    public Drawable mutate() {
        if (!this.f1185h && super.mutate() == this) {
            C0023b b2 = b();
            b2.a();
            a(b2);
            this.f1185h = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public C0023b b() {
        return this.f1178a;
    }

    /* renamed from: androidx.appcompat.b.a.b$b  reason: collision with other inner class name */
    static abstract class C0023b extends Drawable.ConstantState {
        boolean A;
        int B;
        int C;
        int D;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        PorterDuff.Mode I;
        boolean J;
        boolean K;

        /* renamed from: c  reason: collision with root package name */
        final b f1189c;

        /* renamed from: d  reason: collision with root package name */
        Resources f1190d;

        /* renamed from: e  reason: collision with root package name */
        int f1191e = 160;

        /* renamed from: f  reason: collision with root package name */
        int f1192f;

        /* renamed from: g  reason: collision with root package name */
        int f1193g;

        /* renamed from: h  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f1194h;

        /* renamed from: i  reason: collision with root package name */
        Drawable[] f1195i;
        int j;
        boolean k;
        boolean l;
        Rect m;
        boolean n;
        boolean o;
        int p;
        int q;
        int r;
        int s;
        boolean t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        C0023b(C0023b bVar, b bVar2, Resources resources) {
            Resources resources2;
            this.k = false;
            this.n = false;
            this.z = true;
            this.C = 0;
            this.D = 0;
            this.f1189c = bVar2;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = bVar != null ? bVar.f1190d : null;
            }
            this.f1190d = resources2;
            this.f1191e = b.a(resources, bVar != null ? bVar.f1191e : 0);
            if (bVar != null) {
                this.f1192f = bVar.f1192f;
                this.f1193g = bVar.f1193g;
                this.x = true;
                this.y = true;
                this.k = bVar.k;
                this.n = bVar.n;
                this.z = bVar.z;
                this.A = bVar.A;
                this.B = bVar.B;
                this.C = bVar.C;
                this.D = bVar.D;
                this.E = bVar.E;
                this.F = bVar.F;
                this.G = bVar.G;
                this.H = bVar.H;
                this.I = bVar.I;
                this.J = bVar.J;
                this.K = bVar.K;
                if (bVar.f1191e == this.f1191e) {
                    if (bVar.l) {
                        this.m = new Rect(bVar.m);
                        this.l = true;
                    }
                    if (bVar.o) {
                        this.p = bVar.p;
                        this.q = bVar.q;
                        this.r = bVar.r;
                        this.s = bVar.s;
                        this.o = true;
                    }
                }
                if (bVar.t) {
                    this.u = bVar.u;
                    this.t = true;
                }
                if (bVar.v) {
                    this.w = bVar.w;
                    this.v = true;
                }
                Drawable[] drawableArr = bVar.f1195i;
                this.f1195i = new Drawable[drawableArr.length];
                this.j = bVar.j;
                SparseArray<Drawable.ConstantState> sparseArray = bVar.f1194h;
                if (sparseArray != null) {
                    this.f1194h = sparseArray.clone();
                } else {
                    this.f1194h = new SparseArray<>(this.j);
                }
                int i2 = this.j;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f1194h.put(i3, constantState);
                        } else {
                            this.f1195i[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f1195i = new Drawable[10];
            this.j = 0;
        }

        public int getChangingConfigurations() {
            return this.f1192f | this.f1193g;
        }

        public final int a(Drawable drawable) {
            int i2 = this.j;
            if (i2 >= this.f1195i.length) {
                b(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1189c);
            this.f1195i[i2] = drawable;
            this.j++;
            this.f1193g = drawable.getChangingConfigurations() | this.f1193g;
            b();
            this.m = null;
            this.l = false;
            this.o = false;
            this.x = false;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.t = false;
            this.v = false;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f1194h;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f1195i[this.f1194h.keyAt(i2)] = b(this.f1194h.valueAt(i2).newDrawable(this.f1190d));
                }
                this.f1194h = null;
            }
        }

        private Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f1189c);
            return mutate;
        }

        public final Drawable b(int i2) {
            int indexOfKey;
            Drawable drawable = this.f1195i[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f1194h;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable b2 = b(this.f1194h.valueAt(indexOfKey).newDrawable(this.f1190d));
            this.f1195i[i2] = b2;
            this.f1194h.removeAt(indexOfKey);
            if (this.f1194h.size() == 0) {
                this.f1194h = null;
            }
            return b2;
        }

        /* access modifiers changed from: package-private */
        public final void a(Resources resources) {
            if (resources != null) {
                this.f1190d = resources;
                int a2 = b.a(resources, this.f1191e);
                int i2 = this.f1191e;
                this.f1191e = a2;
                if (i2 != a2) {
                    this.o = false;
                    this.l = false;
                }
            }
        }

        public boolean canApplyTheme() {
            int i2 = this.j;
            Drawable[] drawableArr = this.f1195i;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f1194h.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2 = this.j;
            Drawable[] drawableArr = this.f1195i;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null) {
                    drawableArr[i3].mutate();
                }
            }
            this.A = true;
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            this.o = true;
            c();
            int i2 = this.j;
            Drawable[] drawableArr = this.f1195i;
            this.q = -1;
            this.p = -1;
            this.s = 0;
            this.r = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.p) {
                    this.p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.q) {
                    this.q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.r) {
                    this.r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.s) {
                    this.s = minimumHeight;
                }
            }
        }

        public void b(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.f1195i, 0, drawableArr, 0, i2);
            this.f1195i = drawableArr;
        }

        public final synchronized boolean e() {
            if (this.x) {
                return this.y;
            }
            c();
            this.x = true;
            int i2 = this.j;
            Drawable[] drawableArr = this.f1195i;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.y = false;
                    return false;
                }
            }
            this.y = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0023b bVar) {
        this.f1178a = bVar;
        int i2 = this.f1179b;
        if (i2 >= 0) {
            this.f1181d = bVar.b(i2);
            Drawable drawable = this.f1181d;
            if (drawable != null) {
                a(drawable);
            }
        }
        this.f1182e = null;
    }

    static class a implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        Drawable.Callback f1188a;

        public final void invalidateDrawable(Drawable drawable) {
        }

        a() {
        }

        public final Drawable.Callback a() {
            Drawable.Callback callback = this.f1188a;
            this.f1188a = null;
            return callback;
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f1188a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f1188a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int a(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }
}
