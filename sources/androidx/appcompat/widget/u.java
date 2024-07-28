package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.a.g;
import androidx.a.h;
import androidx.vectordrawable.a.a.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f1804a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static u f1805b;

    /* renamed from: c  reason: collision with root package name */
    private static final c f1806c = new c();

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<Context, h<ColorStateList>> f1807d;

    /* renamed from: e  reason: collision with root package name */
    private g<String, d> f1808e;

    /* renamed from: f  reason: collision with root package name */
    private h<String> f1809f;

    /* renamed from: g  reason: collision with root package name */
    private final WeakHashMap<Context, androidx.a.d<WeakReference<Drawable.ConstantState>>> f1810g = new WeakHashMap<>(0);

    /* renamed from: h  reason: collision with root package name */
    private TypedValue f1811h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1812i;
    private e j;

    interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    interface e {
        ColorStateList a(Context context, int i2);

        PorterDuff.Mode a(int i2);

        Drawable a(u uVar, Context context, int i2);

        boolean a(Context context, int i2, Drawable drawable);

        boolean b(Context context, int i2, Drawable drawable);
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            if (f1805b == null) {
                u uVar2 = new u();
                f1805b = uVar2;
                if (Build.VERSION.SDK_INT < 24) {
                    uVar2.a("vector", (d) new f());
                    uVar2.a("animated-vector", (d) new b());
                    uVar2.a("animated-selector", (d) new a());
                }
            }
            uVar = f1805b;
        }
        return uVar;
    }

    public final synchronized void a(e eVar) {
        this.j = eVar;
    }

    public final synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    public final synchronized void a(Context context) {
        androidx.a.d dVar = this.f1810g.get(context);
        if (dVar != null) {
            dVar.d();
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (p.c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable f2 = androidx.core.graphics.drawable.a.f(drawable);
            androidx.core.graphics.drawable.a.a(f2, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return f2;
            }
            androidx.core.graphics.drawable.a.a(f2, a2);
            return f2;
        }
        e eVar = this.j;
        if ((eVar == null || !eVar.a(context, i2, drawable)) && !a(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    private Drawable c(Context context, int i2) {
        int next;
        g<String, d> gVar = this.f1808e;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        h<String> hVar = this.f1809f;
        if (hVar != null) {
            String a2 = hVar.a(i2, null);
            if ("appcompat_skip_skip".equals(a2) || (a2 != null && this.f1808e.get(a2) == null)) {
                return null;
            }
        } else {
            this.f1809f = new h<>();
        }
        if (this.f1811h == null) {
            this.f1811h = new TypedValue();
        }
        TypedValue typedValue = this.f1811h;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a3 = a(typedValue);
        Drawable a4 = a(context, a3);
        if (a4 != null) {
            return a4;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    String name = xml.getName();
                    this.f1809f.c(i2, name);
                    d dVar = this.f1808e.get(name);
                    if (dVar != null) {
                        a4 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (a4 != null) {
                        a4.setChangingConfigurations(typedValue.changingConfigurations);
                        a(context, a3, a4);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception unused) {
            }
        }
        if (a4 == null) {
            this.f1809f.c(i2, "appcompat_skip_skip");
        }
        return a4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable a(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.a.d<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1810g     // Catch:{ all -> 0x0045 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0045 }
            androidx.a.d r0 = (androidx.a.d) r0     // Catch:{ all -> 0x0045 }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.a(r5, r1)     // Catch:{ all -> 0x0045 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0045 }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0045 }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x0045 }
            monitor-exit(r3)
            return r4
        L_0x0028:
            long[] r4 = r0.f936c     // Catch:{ all -> 0x0045 }
            int r2 = r0.f938e     // Catch:{ all -> 0x0045 }
            int r4 = androidx.a.c.a((long[]) r4, (int) r2, (long) r5)     // Catch:{ all -> 0x0045 }
            if (r4 < 0) goto L_0x0043
            java.lang.Object[] r5 = r0.f937d     // Catch:{ all -> 0x0045 }
            r5 = r5[r4]     // Catch:{ all -> 0x0045 }
            java.lang.Object r6 = androidx.a.d.f934a     // Catch:{ all -> 0x0045 }
            if (r5 == r6) goto L_0x0043
            java.lang.Object[] r5 = r0.f937d     // Catch:{ all -> 0x0045 }
            java.lang.Object r6 = androidx.a.d.f934a     // Catch:{ all -> 0x0045 }
            r5[r4] = r6     // Catch:{ all -> 0x0045 }
            r4 = 1
            r0.f935b = r4     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r3)
            return r1
        L_0x0045:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.a.d dVar = this.f1810g.get(context);
        if (dVar == null) {
            dVar = new androidx.a.d();
            this.f1810g.put(context, dVar);
        }
        dVar.b(j2, new WeakReference(constantState));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized Drawable a(Context context, ah ahVar, int i2) {
        Drawable c2 = c(context, i2);
        if (c2 == null) {
            c2 = ahVar.a(i2);
        }
        if (c2 == null) {
            return null;
        }
        return a(context, i2, false, c2);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Context context, int i2, Drawable drawable) {
        e eVar = this.j;
        return eVar != null && eVar.b(context, i2, drawable);
    }

    private void a(String str, d dVar) {
        if (this.f1808e == null) {
            this.f1808e = new g<>();
        }
        this.f1808e.put(str, dVar);
    }

    private PorterDuff.Mode a(int i2) {
        e eVar = this.j;
        if (eVar == null) {
            return null;
        }
        return eVar.a(i2);
    }

    static class c extends androidx.a.e<Integer, PorterDuffColorFilter> {
        public c() {
            super(6);
        }

        static int a(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }
    }

    static void a(Drawable drawable, aa aaVar, int[] iArr) {
        if (!p.c(drawable) || drawable.mutate() == drawable) {
            if (aaVar.f1667d || aaVar.f1666c) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                ColorStateList colorStateList = aaVar.f1667d ? aaVar.f1664a : null;
                PorterDuff.Mode mode = aaVar.f1666c ? aaVar.f1665b : f1804a;
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (u.class) {
            porterDuffColorFilter = (PorterDuffColorFilter) f1806c.get(Integer.valueOf(c.a(i2, mode)));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i2, mode);
                f1806c.put(Integer.valueOf(c.a(i2, mode)), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    static class f implements d {
        f() {
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    static class b implements d {
        b() {
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    static class a implements d {
        a() {
        }

        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.drawable.Drawable a(android.content.Context r5, int r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f1812i     // Catch:{ all -> 0x0084 }
            r1 = 1
            if (r0 != 0) goto L_0x0036
            r4.f1812i = r1     // Catch:{ all -> 0x0084 }
            int r0 = androidx.appcompat.resources.R.drawable.abc_vector_test     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r0 = r4.a((android.content.Context) r5, (int) r0)     // Catch:{ all -> 0x0084 }
            r2 = 0
            if (r0 == 0) goto L_0x002c
            boolean r3 = r0 instanceof androidx.vectordrawable.a.a.i     // Catch:{ all -> 0x0084 }
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = "android.graphics.drawable.VectorDrawable"
            java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0084 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            if (r0 == 0) goto L_0x002c
            goto L_0x0036
        L_0x002c:
            r4.f1812i = r2     // Catch:{ all -> 0x0084 }
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r5.<init>(r6)     // Catch:{ all -> 0x0084 }
            throw r5     // Catch:{ all -> 0x0084 }
        L_0x0036:
            android.graphics.drawable.Drawable r0 = r4.c(r5, r6)     // Catch:{ all -> 0x0084 }
            if (r0 != 0) goto L_0x0071
            android.util.TypedValue r0 = r4.f1811h     // Catch:{ all -> 0x0084 }
            if (r0 != 0) goto L_0x0047
            android.util.TypedValue r0 = new android.util.TypedValue     // Catch:{ all -> 0x0084 }
            r0.<init>()     // Catch:{ all -> 0x0084 }
            r4.f1811h = r0     // Catch:{ all -> 0x0084 }
        L_0x0047:
            android.util.TypedValue r0 = r4.f1811h     // Catch:{ all -> 0x0084 }
            android.content.res.Resources r2 = r5.getResources()     // Catch:{ all -> 0x0084 }
            r2.getValue(r6, r0, r1)     // Catch:{ all -> 0x0084 }
            long r1 = a((android.util.TypedValue) r0)     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r3 = r4.a((android.content.Context) r5, (long) r1)     // Catch:{ all -> 0x0084 }
            if (r3 != 0) goto L_0x0070
            androidx.appcompat.widget.u$e r3 = r4.j     // Catch:{ all -> 0x0084 }
            if (r3 != 0) goto L_0x0060
            r3 = 0
            goto L_0x0066
        L_0x0060:
            androidx.appcompat.widget.u$e r3 = r4.j     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r3 = r3.a((androidx.appcompat.widget.u) r4, (android.content.Context) r5, (int) r6)     // Catch:{ all -> 0x0084 }
        L_0x0066:
            if (r3 == 0) goto L_0x0070
            int r0 = r0.changingConfigurations     // Catch:{ all -> 0x0084 }
            r3.setChangingConfigurations(r0)     // Catch:{ all -> 0x0084 }
            r4.a((android.content.Context) r5, (long) r1, (android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x0084 }
        L_0x0070:
            r0 = r3
        L_0x0071:
            if (r0 != 0) goto L_0x0077
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r5, (int) r6)     // Catch:{ all -> 0x0084 }
        L_0x0077:
            if (r0 == 0) goto L_0x007d
            android.graphics.drawable.Drawable r0 = r4.a(r5, r6, r7, r0)     // Catch:{ all -> 0x0084 }
        L_0x007d:
            if (r0 == 0) goto L_0x0082
            androidx.appcompat.widget.p.b(r0)     // Catch:{ all -> 0x0084 }
        L_0x0082:
            monitor-exit(r4)
            return r0
        L_0x0084:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.u.a(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    /* access modifiers changed from: package-private */
    public final synchronized ColorStateList b(Context context, int i2) {
        ColorStateList colorStateList;
        h hVar;
        ColorStateList colorStateList2 = null;
        if (this.f1807d == null || (hVar = this.f1807d.get(context)) == null) {
            colorStateList = null;
        } else {
            colorStateList = (ColorStateList) hVar.a(i2, null);
        }
        if (colorStateList == null) {
            if (this.j != null) {
                colorStateList2 = this.j.a(context, i2);
            }
            colorStateList = colorStateList2;
            if (colorStateList != null) {
                if (this.f1807d == null) {
                    this.f1807d = new WeakHashMap<>();
                }
                h hVar2 = this.f1807d.get(context);
                if (hVar2 == null) {
                    hVar2 = new h();
                    this.f1807d.put(context, hVar2);
                }
                hVar2.c(i2, colorStateList);
            }
        }
        return colorStateList;
    }
}
