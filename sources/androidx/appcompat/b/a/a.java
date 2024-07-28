package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.a.h;
import androidx.appcompat.b.a.b;
import androidx.appcompat.b.a.e;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.u;
import androidx.core.content.b.g;
import androidx.vectordrawable.a.a.i;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends e implements androidx.core.graphics.drawable.e {

    /* renamed from: c  reason: collision with root package name */
    private static final String f1163c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private b f1164d;

    /* renamed from: e  reason: collision with root package name */
    private f f1165e;

    /* renamed from: f  reason: collision with root package name */
    private int f1166f;

    /* renamed from: g  reason: collision with root package name */
    private int f1167g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1168h;

    public boolean isStateful() {
        return true;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i2) {
        return super.onLayoutDirectionChanged(i2);
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i2) {
        super.setAlpha(i2);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public a() {
        this((b) null, (Resources) null);
    }

    a(b bVar, Resources resources) {
        super((byte) 0);
        this.f1166f = -1;
        this.f1167g = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
            aVar.setVisible(a2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
            b bVar = aVar.f1164d;
            if (Build.VERSION.SDK_INT >= 21) {
                bVar.f1192f |= a2.getChangingConfigurations();
            }
            bVar.k = a2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k);
            bVar.n = a2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, bVar.n);
            bVar.C = a2.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C);
            bVar.D = a2.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D);
            aVar.setDither(a2.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, bVar.z));
            aVar.f1178a.a(resources);
            a2.recycle();
            aVar.b(context, resources, xmlPullParser, attributeSet, theme);
            aVar.onStateChange(aVar.getState());
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f1165e != null && (visible || z2)) {
            if (z) {
                this.f1165e.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.f1165e;
        if (fVar != null) {
            fVar.b();
            this.f1165e = null;
            a(this.f1166f);
            this.f1166f = -1;
            this.f1167g = -1;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00eb, code lost:
        if (a(r2) == false) goto L_0x00ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onStateChange(int[] r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            androidx.appcompat.b.a.a$b r2 = r0.f1164d
            int r2 = r2.a((int[]) r1)
            int r3 = r0.f1179b
            r4 = 1
            r5 = 0
            if (r2 == r3) goto L_0x00ee
            androidx.appcompat.b.a.a$f r3 = r0.f1165e
            if (r3 == 0) goto L_0x0035
            int r6 = r0.f1166f
            if (r2 != r6) goto L_0x001b
        L_0x0018:
            r3 = 1
            goto L_0x00e5
        L_0x001b:
            int r6 = r0.f1167g
            if (r2 != r6) goto L_0x002f
            boolean r6 = r3.c()
            if (r6 == 0) goto L_0x002f
            r3.d()
            int r3 = r0.f1167g
            r0.f1166f = r3
            r0.f1167g = r2
            goto L_0x0018
        L_0x002f:
            int r6 = r0.f1166f
            r3.b()
            goto L_0x0037
        L_0x0035:
            int r6 = r0.f1179b
        L_0x0037:
            r3 = 0
            r0.f1165e = r3
            r3 = -1
            r0.f1167g = r3
            r0.f1166f = r3
            androidx.appcompat.b.a.a$b r3 = r0.f1164d
            int r7 = r3.a((int) r6)
            int r8 = r3.a((int) r2)
            if (r8 == 0) goto L_0x00e4
            if (r7 != 0) goto L_0x004f
            goto L_0x00e4
        L_0x004f:
            long r9 = androidx.appcompat.b.a.a.b.a(r7, r8)
            androidx.a.d<java.lang.Long> r11 = r3.f1170a
            r12 = -1
            java.lang.Long r14 = java.lang.Long.valueOf(r12)
            java.lang.Object r9 = r11.a(r9, r14)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            int r10 = (int) r9
            if (r10 >= 0) goto L_0x006a
            goto L_0x00e4
        L_0x006a:
            long r14 = androidx.appcompat.b.a.a.b.a(r7, r8)
            androidx.a.d<java.lang.Long> r9 = r3.f1170a
            java.lang.Long r11 = java.lang.Long.valueOf(r12)
            java.lang.Object r9 = r9.a(r14, r11)
            java.lang.Long r9 = (java.lang.Long) r9
            long r14 = r9.longValue()
            r16 = 8589934592(0x200000000, double:4.243991582E-314)
            long r14 = r14 & r16
            r16 = 0
            int r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r9 == 0) goto L_0x008d
            r9 = 1
            goto L_0x008e
        L_0x008d:
            r9 = 0
        L_0x008e:
            r0.a((int) r10)
            android.graphics.drawable.Drawable r10 = r18.getCurrent()
            boolean r11 = r10 instanceof android.graphics.drawable.AnimationDrawable
            if (r11 == 0) goto L_0x00c2
            long r7 = androidx.appcompat.b.a.a.b.a(r7, r8)
            androidx.a.d<java.lang.Long> r3 = r3.f1170a
            java.lang.Long r11 = java.lang.Long.valueOf(r12)
            java.lang.Object r3 = r3.a(r7, r11)
            java.lang.Long r3 = (java.lang.Long) r3
            long r7 = r3.longValue()
            r11 = 4294967296(0x100000000, double:2.121995791E-314)
            long r7 = r7 & r11
            int r3 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x00b9
            r3 = 1
            goto L_0x00ba
        L_0x00b9:
            r3 = 0
        L_0x00ba:
            androidx.appcompat.b.a.a$d r7 = new androidx.appcompat.b.a.a$d
            android.graphics.drawable.AnimationDrawable r10 = (android.graphics.drawable.AnimationDrawable) r10
            r7.<init>(r10, r3, r9)
            goto L_0x00d9
        L_0x00c2:
            boolean r3 = r10 instanceof androidx.vectordrawable.a.a.c
            if (r3 == 0) goto L_0x00ce
            androidx.appcompat.b.a.a$c r7 = new androidx.appcompat.b.a.a$c
            androidx.vectordrawable.a.a.c r10 = (androidx.vectordrawable.a.a.c) r10
            r7.<init>(r10)
            goto L_0x00d9
        L_0x00ce:
            boolean r3 = r10 instanceof android.graphics.drawable.Animatable
            if (r3 == 0) goto L_0x00e4
            androidx.appcompat.b.a.a$a r7 = new androidx.appcompat.b.a.a$a
            android.graphics.drawable.Animatable r10 = (android.graphics.drawable.Animatable) r10
            r7.<init>(r10)
        L_0x00d9:
            r7.a()
            r0.f1165e = r7
            r0.f1167g = r6
            r0.f1166f = r2
            goto L_0x0018
        L_0x00e4:
            r3 = 0
        L_0x00e5:
            if (r3 != 0) goto L_0x00ef
            boolean r2 = r0.a((int) r2)
            if (r2 == 0) goto L_0x00ee
            goto L_0x00ef
        L_0x00ee:
            r4 = 0
        L_0x00ef:
            android.graphics.drawable.Drawable r2 = r18.getCurrent()
            if (r2 == 0) goto L_0x00fa
            boolean r1 = r2.setState(r1)
            r4 = r4 | r1
        L_0x00fa:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.a.onStateChange(int[]):boolean");
    }

    static abstract class f {
        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$a  reason: collision with other inner class name */
    static class C0022a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f1169a;

        C0022a(Animatable animatable) {
            super((byte) 0);
            this.f1169a = animatable;
        }

        public final void a() {
            this.f1169a.start();
        }

        public final void b() {
            this.f1169a.stop();
        }
    }

    static class d extends f {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f1173a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1174b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super((byte) 0);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i2, i3});
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.f1175a);
            ofInt.setInterpolator(eVar);
            this.f1174b = z2;
            this.f1173a = ofInt;
        }

        public final boolean c() {
            return this.f1174b;
        }

        public final void a() {
            this.f1173a.start();
        }

        public final void d() {
            this.f1173a.reverse();
        }

        public final void b() {
            this.f1173a.cancel();
        }
    }

    static class c extends f {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.vectordrawable.a.a.c f1172a;

        c(androidx.vectordrawable.a.a.c cVar) {
            super((byte) 0);
            this.f1172a = cVar;
        }

        public final void a() {
            this.f1172a.start();
        }

        public final void b() {
            this.f1172a.stop();
        }
    }

    private void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int next;
        AttributeSet attributeSet2 = attributeSet;
        int depth2 = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1 && ((depth = xmlPullParser.getDepth()) >= depth2 || next2 != 3)) {
                if (next2 != 2 || depth > depth2) {
                    Context context2 = context;
                    Resources resources2 = resources;
                    Resources.Theme theme2 = theme;
                } else if (xmlPullParser.getName().equals("item")) {
                    TypedArray a2 = g.a(resources, theme, attributeSet2, R.styleable.AnimatedStateListDrawableItem);
                    int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
                    Drawable drawable = null;
                    int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
                    if (resourceId2 > 0) {
                        drawable = u.a().a(context, resourceId2);
                    } else {
                        Context context3 = context;
                    }
                    a2.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i2 = 0;
                    for (int i3 = 0; i3 < attributeCount; i3++) {
                        int attributeNameResource = attributeSet2.getAttributeNameResource(i3);
                        if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                            int i4 = i2 + 1;
                            if (!attributeSet2.getAttributeBooleanValue(i3, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i2] = attributeNameResource;
                            i2 = i4;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr, i2);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next != 2) {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        } else if (xmlPullParser.getName().equals("vector")) {
                            drawable = i.a(resources, xmlPullParser, attributeSet, theme);
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        }
                    }
                    if (drawable != null) {
                        b bVar = this.f1164d;
                        int a3 = bVar.a(drawable);
                        bVar.L[a3] = trimStateSet;
                        bVar.f1171b.b(a3, Integer.valueOf(resourceId));
                    } else {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                } else {
                    Context context4 = context;
                    Resources resources3 = resources;
                    Resources.Theme theme3 = theme;
                    if (xmlPullParser.getName().equals("transition")) {
                        c(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            }
        }
    }

    private int c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable a3 = resourceId3 > 0 ? u.a().a(context, resourceId3) : null;
        boolean z = a2.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (a3 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                a3 = androidx.vectordrawable.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (a3 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f1164d.a(resourceId, resourceId2, a3, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    public Drawable mutate() {
        if (!this.f1168h && super.mutate() == this) {
            this.f1164d.a();
            this.f1168h = true;
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public b b() {
        return new b(this.f1164d, this, (Resources) null);
    }

    static class b extends e.a {

        /* renamed from: a  reason: collision with root package name */
        androidx.a.d<Long> f1170a;

        /* renamed from: b  reason: collision with root package name */
        h<Integer> f1171b;

        static long a(int i2, int i3) {
            return ((long) i3) | (((long) i2) << 32);
        }

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.f1170a = bVar.f1170a;
                this.f1171b = bVar.f1171b;
                return;
            }
            this.f1170a = new androidx.a.d<>();
            this.f1171b = new h<>();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f1170a = this.f1170a.clone();
            this.f1171b = this.f1171b.clone();
        }

        /* access modifiers changed from: package-private */
        public final int a(int i2, int i3, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long a3 = a(i2, i3);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a2;
            this.f1170a.c(a3, Long.valueOf(j2 | j));
            if (z) {
                this.f1170a.c(a(i3, i2), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final int a(int[] iArr) {
            int b2 = super.b(iArr);
            if (b2 >= 0) {
                return b2;
            }
            return super.b(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        public final int a(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.f1171b.a(i2, 0).intValue();
        }

        public final Drawable newDrawable() {
            return new a(this, (Resources) null);
        }

        public final Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(b.C0023b bVar) {
        super.a(bVar);
        if (bVar instanceof b) {
            this.f1164d = (b) bVar;
        }
    }

    static class e implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        int f1175a;

        /* renamed from: b  reason: collision with root package name */
        private int[] f1176b;

        /* renamed from: c  reason: collision with root package name */
        private int f1177c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        private int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1177c = numberOfFrames;
            int[] iArr = this.f1176b;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f1176b = new int[numberOfFrames];
            }
            int[] iArr2 = this.f1176b;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f1175a = i2;
            return i2;
        }

        public final float getInterpolation(float f2) {
            int i2 = (int) ((f2 * ((float) this.f1175a)) + 0.5f);
            int i3 = this.f1177c;
            int[] iArr = this.f1176b;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (((float) i4) / ((float) i3)) + (i4 < i3 ? ((float) i2) / ((float) this.f1175a) : 0.0f);
        }
    }
}
