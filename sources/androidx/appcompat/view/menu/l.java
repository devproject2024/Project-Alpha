package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.m;
import androidx.core.h.e;
import androidx.core.h.u;

public class l {

    /* renamed from: a  reason: collision with root package name */
    protected View f1370a;

    /* renamed from: b  reason: collision with root package name */
    public int f1371b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow.OnDismissListener f1372c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f1373d;

    /* renamed from: e  reason: collision with root package name */
    private final g f1374e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1375f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1376g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1377h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1378i;
    private m.a j;
    private k k;
    private final PopupWindow.OnDismissListener l;

    public l(Context context, g gVar, View view, boolean z, int i2) {
        this(context, gVar, view, z, i2, 0);
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f1371b = 8388611;
        this.l = new PopupWindow.OnDismissListener() {
            public final void onDismiss() {
                l.this.e();
            }
        };
        this.f1373d = context;
        this.f1374e = gVar;
        this.f1370a = view;
        this.f1375f = z;
        this.f1376g = i2;
        this.f1377h = i3;
    }

    public final void a(boolean z) {
        this.f1378i = z;
        k kVar = this.k;
        if (kVar != null) {
            kVar.b(z);
        }
    }

    public final void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [androidx.appcompat.view.menu.k] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.q] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.appcompat.view.menu.k b() {
        /*
            r14 = this;
            androidx.appcompat.view.menu.k r0 = r14.k
            if (r0 != 0) goto L_0x0083
            android.content.Context r0 = r14.f1373d
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x0022
            r0.getRealSize(r1)
            goto L_0x0025
        L_0x0022:
            r0.getSize(r1)
        L_0x0025:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f1373d
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.R.dimen.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x003d
            r0 = 1
            goto L_0x003e
        L_0x003d:
            r0 = 0
        L_0x003e:
            if (r0 == 0) goto L_0x0051
            androidx.appcompat.view.menu.d r0 = new androidx.appcompat.view.menu.d
            android.content.Context r2 = r14.f1373d
            android.view.View r3 = r14.f1370a
            int r4 = r14.f1376g
            int r5 = r14.f1377h
            boolean r6 = r14.f1375f
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0063
        L_0x0051:
            androidx.appcompat.view.menu.q r0 = new androidx.appcompat.view.menu.q
            android.content.Context r8 = r14.f1373d
            androidx.appcompat.view.menu.g r9 = r14.f1374e
            android.view.View r10 = r14.f1370a
            int r11 = r14.f1376g
            int r12 = r14.f1377h
            boolean r13 = r14.f1375f
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0063:
            androidx.appcompat.view.menu.g r1 = r14.f1374e
            r0.a((androidx.appcompat.view.menu.g) r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.l
            r0.a((android.widget.PopupWindow.OnDismissListener) r1)
            android.view.View r1 = r14.f1370a
            r0.a((android.view.View) r1)
            androidx.appcompat.view.menu.m$a r1 = r14.j
            r0.a((androidx.appcompat.view.menu.m.a) r1)
            boolean r1 = r14.f1378i
            r0.b((boolean) r1)
            int r1 = r14.f1371b
            r0.a((int) r1)
            r14.k = r0
        L_0x0083:
            androidx.appcompat.view.menu.k r0 = r14.k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.l.b():androidx.appcompat.view.menu.k");
    }

    public final boolean c() {
        if (f()) {
            return true;
        }
        if (this.f1370a == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, boolean z, boolean z2) {
        k b2 = b();
        b2.c(z2);
        if (z) {
            if ((e.a(this.f1371b, u.j(this.f1370a)) & 7) == 5) {
                i2 -= this.f1370a.getWidth();
            }
            b2.b(i2);
            b2.c(i3);
            int i4 = (int) ((this.f1373d.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b2.f1369g = new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4);
        }
        b2.a_();
    }

    public final void d() {
        if (f()) {
            this.k.d();
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.k = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1372c;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final boolean f() {
        k kVar = this.k;
        return kVar != null && kVar.e();
    }

    public final void a(m.a aVar) {
        this.j = aVar;
        k kVar = this.k;
        if (kVar != null) {
            kVar.a(aVar);
        }
    }
}
