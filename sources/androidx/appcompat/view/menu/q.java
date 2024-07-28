package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuPopupWindow;

final class q extends k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, m {

    /* renamed from: e  reason: collision with root package name */
    private static final int f1381e = R.layout.abc_popup_menu_item_layout;

    /* renamed from: a  reason: collision with root package name */
    final MenuPopupWindow f1382a;

    /* renamed from: b  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f1383b = new ViewTreeObserver.OnGlobalLayoutListener() {
        public final void onGlobalLayout() {
            if (q.this.e() && !q.this.f1382a.o) {
                View view = q.this.f1384c;
                if (view == null || !view.isShown()) {
                    q.this.d();
                } else {
                    q.this.f1382a.a_();
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    View f1384c;

    /* renamed from: d  reason: collision with root package name */
    ViewTreeObserver f1385d;

    /* renamed from: f  reason: collision with root package name */
    private final Context f1386f;

    /* renamed from: h  reason: collision with root package name */
    private final g f1387h;

    /* renamed from: i  reason: collision with root package name */
    private final f f1388i;
    private final boolean j;
    private final int k;
    private final int l;
    private final int m;
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener() {
        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (q.this.f1385d != null) {
                if (!q.this.f1385d.isAlive()) {
                    q.this.f1385d = view.getViewTreeObserver();
                }
                q.this.f1385d.removeGlobalOnLayoutListener(q.this.f1383b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private PopupWindow.OnDismissListener o;
    private View p;
    private m.a q;
    private boolean r;
    private boolean s;
    private int t;
    private int u = 0;
    private boolean v;

    public final void a(Parcelable parcelable) {
    }

    public final void a(g gVar) {
    }

    public final boolean a() {
        return false;
    }

    public final Parcelable f() {
        return null;
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.f1386f = context;
        this.f1387h = gVar;
        this.j = z;
        this.f1388i = new f(gVar, LayoutInflater.from(context), this.j, f1381e);
        this.l = i2;
        this.m = i3;
        Resources resources = context.getResources();
        this.k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.p = view;
        this.f1382a = new MenuPopupWindow(this.f1386f, this.l, this.m);
        gVar.a((m) this, context);
    }

    public final void b(boolean z) {
        this.f1388i.f1330b = z;
    }

    public final void a(int i2) {
        this.u = i2;
    }

    public final void d() {
        if (e()) {
            this.f1382a.d();
        }
    }

    public final boolean e() {
        return !this.r && this.f1382a.p.isShowing();
    }

    public final void onDismiss() {
        this.r = true;
        this.f1387h.close();
        ViewTreeObserver viewTreeObserver = this.f1385d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1385d = this.f1384c.getViewTreeObserver();
            }
            this.f1385d.removeGlobalOnLayoutListener(this.f1383b);
            this.f1385d = null;
        }
        this.f1384c.removeOnAttachStateChangeListener(this.n);
        PopupWindow.OnDismissListener onDismissListener = this.o;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void a(boolean z) {
        this.s = false;
        f fVar = this.f1388i;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    public final void a(m.a aVar) {
        this.q = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(androidx.appcompat.view.menu.r r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L_0x006f
            androidx.appcompat.view.menu.l r0 = new androidx.appcompat.view.menu.l
            android.content.Context r3 = r9.f1386f
            android.view.View r5 = r9.f1384c
            boolean r6 = r9.j
            int r7 = r9.l
            int r8 = r9.m
            r2 = r0
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            androidx.appcompat.view.menu.m$a r2 = r9.q
            r0.a((androidx.appcompat.view.menu.m.a) r2)
            boolean r2 = androidx.appcompat.view.menu.k.b((androidx.appcompat.view.menu.g) r10)
            r0.a((boolean) r2)
            android.widget.PopupWindow$OnDismissListener r2 = r9.o
            r0.f1372c = r2
            r2 = 0
            r9.o = r2
            androidx.appcompat.view.menu.g r2 = r9.f1387h
            r2.a((boolean) r1)
            androidx.appcompat.widget.MenuPopupWindow r2 = r9.f1382a
            int r2 = r2.f1559g
            androidx.appcompat.widget.MenuPopupWindow r3 = r9.f1382a
            int r3 = r3.c()
            int r4 = r9.u
            android.view.View r5 = r9.p
            int r5 = androidx.core.h.u.j(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L_0x0052
            android.view.View r4 = r9.p
            int r4 = r4.getWidth()
            int r2 = r2 + r4
        L_0x0052:
            boolean r4 = r0.f()
            r5 = 1
            if (r4 == 0) goto L_0x005b
        L_0x0059:
            r0 = 1
            goto L_0x0065
        L_0x005b:
            android.view.View r4 = r0.f1370a
            if (r4 != 0) goto L_0x0061
            r0 = 0
            goto L_0x0065
        L_0x0061:
            r0.a(r2, r3, r5, r5)
            goto L_0x0059
        L_0x0065:
            if (r0 == 0) goto L_0x006f
            androidx.appcompat.view.menu.m$a r0 = r9.q
            if (r0 == 0) goto L_0x006e
            r0.a(r10)
        L_0x006e:
            return r5
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.q.a(androidx.appcompat.view.menu.r):boolean");
    }

    public final void a(g gVar, boolean z) {
        if (gVar == this.f1387h) {
            d();
            m.a aVar = this.q;
            if (aVar != null) {
                aVar.a(gVar, z);
            }
        }
    }

    public final void a(View view) {
        this.p = view;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        d();
        return true;
    }

    public final void a(PopupWindow.OnDismissListener onDismissListener) {
        this.o = onDismissListener;
    }

    public final ListView g() {
        return this.f1382a.f1557e;
    }

    public final void b(int i2) {
        this.f1382a.f1559g = i2;
    }

    public final void c(int i2) {
        this.f1382a.a(i2);
    }

    public final void c(boolean z) {
        this.v = z;
    }

    public final void a_() {
        View view;
        boolean z = true;
        if (!e()) {
            if (this.r || (view = this.p) == null) {
                z = false;
            } else {
                this.f1384c = view;
                this.f1382a.a((PopupWindow.OnDismissListener) this);
                MenuPopupWindow menuPopupWindow = this.f1382a;
                menuPopupWindow.l = this;
                menuPopupWindow.i();
                View view2 = this.f1384c;
                boolean z2 = this.f1385d == null;
                this.f1385d = view2.getViewTreeObserver();
                if (z2) {
                    this.f1385d.addOnGlobalLayoutListener(this.f1383b);
                }
                view2.addOnAttachStateChangeListener(this.n);
                MenuPopupWindow menuPopupWindow2 = this.f1382a;
                menuPopupWindow2.k = view2;
                menuPopupWindow2.f1560h = this.u;
                if (!this.s) {
                    this.t = a(this.f1388i, (ViewGroup) null, this.f1386f, this.k);
                    this.s = true;
                }
                this.f1382a.d(this.t);
                this.f1382a.j();
                this.f1382a.a(this.f1369g);
                this.f1382a.a_();
                DropDownListView dropDownListView = this.f1382a.f1557e;
                dropDownListView.setOnKeyListener(this);
                if (this.v && this.f1387h.f1340f != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1386f).inflate(R.layout.abc_popup_menu_header_item_layout, dropDownListView, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f1387h.f1340f);
                    }
                    frameLayout.setEnabled(false);
                    dropDownListView.addHeaderView(frameLayout, (Object) null, false);
                }
                this.f1382a.a((ListAdapter) this.f1388i);
                this.f1382a.a_();
            }
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }
}
