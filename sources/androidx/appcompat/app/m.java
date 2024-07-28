package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.b;
import androidx.appcompat.view.h;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.o;
import androidx.core.h.aa;
import androidx.core.h.u;
import androidx.core.h.x;
import androidx.core.h.y;
import androidx.core.h.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class m extends ActionBar implements ActionBarOverlayLayout.a {
    private static final Interpolator s = new AccelerateInterpolator();
    private static final Interpolator t = new DecelerateInterpolator();
    private ArrayList<Object> A = new ArrayList<>();
    private boolean B;
    private int C = 0;
    private boolean D;
    private boolean E = true;
    private boolean F;

    /* renamed from: a  reason: collision with root package name */
    Context f1146a;

    /* renamed from: b  reason: collision with root package name */
    ActionBarOverlayLayout f1147b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarContainer f1148c;

    /* renamed from: d  reason: collision with root package name */
    o f1149d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContextView f1150e;

    /* renamed from: f  reason: collision with root package name */
    View f1151f;

    /* renamed from: g  reason: collision with root package name */
    ScrollingTabContainerView f1152g;

    /* renamed from: h  reason: collision with root package name */
    a f1153h;

    /* renamed from: i  reason: collision with root package name */
    b f1154i;
    b.a j;
    boolean k = true;
    boolean l;
    boolean m;
    h n;
    boolean o;
    final y p = new z() {
        public final void onAnimationEnd(View view) {
            if (m.this.k && m.this.f1151f != null) {
                m.this.f1151f.setTranslationY(0.0f);
                m.this.f1148c.setTranslationY(0.0f);
            }
            m.this.f1148c.setVisibility(8);
            m.this.f1148c.setTransitioning(false);
            m mVar = m.this;
            mVar.n = null;
            if (mVar.j != null) {
                mVar.j.a(mVar.f1154i);
                mVar.f1154i = null;
                mVar.j = null;
            }
            if (m.this.f1147b != null) {
                u.z(m.this.f1147b);
            }
        }
    };
    final y q = new z() {
        public final void onAnimationEnd(View view) {
            m mVar = m.this;
            mVar.n = null;
            mVar.f1148c.requestLayout();
        }
    };
    final aa r = new aa() {
        public final void a() {
            ((View) m.this.f1148c.getParent()).invalidate();
        }
    };
    private Context u;
    private Activity v;
    private ArrayList<Object> w = new ArrayList<>();
    private int x = -1;
    private boolean y;
    private boolean z;

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    public m(Activity activity, boolean z2) {
        this.v = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (!z2) {
            this.f1151f = decorView.findViewById(16908290);
        }
    }

    public m(Dialog dialog) {
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.f1147b = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1147b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1149d = b(view.findViewById(R.id.action_bar));
        this.f1150e = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        this.f1148c = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        o oVar = this.f1149d;
        if (oVar == null || this.f1150e == null || this.f1148c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1146a = oVar.b();
        if ((this.f1149d.m() & 4) != 0) {
            this.y = true;
        }
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(this.f1146a);
        a2.d();
        i(a2.b());
        TypedArray obtainStyledAttributes = this.f1146a.obtainStyledAttributes((AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            h();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private static o b(View view) {
        if (view instanceof o) {
            return (o) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public final void a(float f2) {
        u.g((View) this.f1148c, f2);
    }

    public final void a(Configuration configuration) {
        i(androidx.appcompat.view.a.a(this.f1146a).b());
    }

    private void i(boolean z2) {
        this.B = z2;
        if (!this.B) {
            this.f1149d.a((ScrollingTabContainerView) null);
            this.f1148c.setTabContainer(this.f1152g);
        } else {
            this.f1148c.setTabContainer((ScrollingTabContainerView) null);
            this.f1149d.a(this.f1152g);
        }
        boolean z3 = true;
        boolean z4 = q() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.f1152g;
        if (scrollingTabContainerView != null) {
            if (z4) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f1147b;
                if (actionBarOverlayLayout != null) {
                    u.z(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f1149d.a(!this.B && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f1147b;
        if (this.B || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    public final void g(int i2) {
        this.C = i2;
    }

    public final void e(boolean z2) {
        h hVar;
        this.F = z2;
        if (!z2 && (hVar = this.n) != null) {
            hVar.b();
        }
    }

    public final void f(boolean z2) {
        if (z2 != this.z) {
            this.z = z2;
            int size = this.A.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A.get(i2);
            }
        }
    }

    public final void a(int i2) {
        this.f1149d.a(LayoutInflater.from(g()).inflate(i2, this.f1149d.a(), false));
    }

    public final void a(boolean z2) {
        a(z2 ? 2 : 0, 2);
    }

    public final void b(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    public final void c(boolean z2) {
        a(z2 ? 8 : 0, 8);
    }

    public final void b() {
        a(16, 16);
    }

    public final void d(int i2) {
        a((CharSequence) this.f1146a.getString(i2));
    }

    public final void a(CharSequence charSequence) {
        this.f1149d.b(charSequence);
    }

    public final void b(CharSequence charSequence) {
        this.f1149d.a(charSequence);
    }

    public final void a() {
        this.f1149d.c(16);
    }

    private void a(int i2, int i3) {
        int m2 = this.f1149d.m();
        if ((i3 & 4) != 0) {
            this.y = true;
        }
        this.f1149d.c((i2 & i3) | ((~i3) & m2));
    }

    public final void a(Drawable drawable) {
        this.f1148c.setPrimaryBackground(drawable);
    }

    private int q() {
        return this.f1149d.n();
    }

    public final int c() {
        return this.f1149d.m();
    }

    public final b a(b.a aVar) {
        a aVar2 = this.f1153h;
        if (aVar2 != null) {
            aVar2.c();
        }
        this.f1147b.setHideOnContentScrollEnabled(false);
        this.f1150e.c();
        a aVar3 = new a(this.f1150e.getContext(), aVar);
        if (!aVar3.e()) {
            return null;
        }
        this.f1153h = aVar3;
        aVar3.d();
        this.f1150e.a(aVar3);
        h(true);
        this.f1150e.sendAccessibilityEvent(32);
        return aVar3;
    }

    public final int d() {
        return this.f1148c.getHeight();
    }

    public final void g(boolean z2) {
        this.k = z2;
    }

    public final void e() {
        if (this.l) {
            this.l = false;
            j(false);
        }
    }

    private void r() {
        if (!this.D) {
            this.D = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1147b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            j(false);
        }
    }

    public final void n() {
        if (this.m) {
            this.m = false;
            j(true);
        }
    }

    public final void f() {
        if (!this.l) {
            this.l = true;
            j(false);
        }
    }

    private void s() {
        if (this.D) {
            this.D = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1147b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            j(false);
        }
    }

    public final void o() {
        if (!this.m) {
            this.m = true;
            j(true);
        }
    }

    public final void h() {
        if (this.f1147b.f1408b) {
            this.o = true;
            this.f1147b.setHideOnContentScrollEnabled(true);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    private void j(boolean z2) {
        if (a(this.l, this.m, this.D)) {
            if (!this.E) {
                this.E = true;
                k(z2);
            }
        } else if (this.E) {
            this.E = false;
            l(z2);
        }
    }

    private void k(boolean z2) {
        View view;
        View view2;
        h hVar = this.n;
        if (hVar != null) {
            hVar.b();
        }
        this.f1148c.setVisibility(0);
        if (this.C != 0 || (!this.F && !z2)) {
            this.f1148c.setAlpha(1.0f);
            this.f1148c.setTranslationY(0.0f);
            if (this.k && (view = this.f1151f) != null) {
                view.setTranslationY(0.0f);
            }
            this.q.onAnimationEnd((View) null);
        } else {
            this.f1148c.setTranslationY(0.0f);
            float f2 = (float) (-this.f1148c.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.f1148c.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.f1148c.setTranslationY(f2);
            h hVar2 = new h();
            x c2 = u.s(this.f1148c).c(0.0f);
            c2.a(this.r);
            hVar2.a(c2);
            if (this.k && (view2 = this.f1151f) != null) {
                view2.setTranslationY(f2);
                hVar2.a(u.s(this.f1151f).c(0.0f));
            }
            hVar2.a(t);
            hVar2.c();
            hVar2.a(this.q);
            this.n = hVar2;
            hVar2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1147b;
        if (actionBarOverlayLayout != null) {
            u.z(actionBarOverlayLayout);
        }
    }

    private void l(boolean z2) {
        View view;
        h hVar = this.n;
        if (hVar != null) {
            hVar.b();
        }
        if (this.C != 0 || (!this.F && !z2)) {
            this.p.onAnimationEnd((View) null);
            return;
        }
        this.f1148c.setAlpha(1.0f);
        this.f1148c.setTransitioning(true);
        h hVar2 = new h();
        float f2 = (float) (-this.f1148c.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.f1148c.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        x c2 = u.s(this.f1148c).c(f2);
        c2.a(this.r);
        hVar2.a(c2);
        if (this.k && (view = this.f1151f) != null) {
            hVar2.a(u.s(view).c(f2));
        }
        hVar2.a(s);
        hVar2.c();
        hVar2.a(this.p);
        this.n = hVar2;
        hVar2.a();
    }

    public final void h(boolean z2) {
        x xVar;
        x xVar2;
        if (z2) {
            r();
        } else {
            s();
        }
        if (u.J(this.f1148c)) {
            if (z2) {
                xVar = this.f1149d.a(4, 100);
                xVar2 = this.f1150e.a(0, 200);
            } else {
                xVar2 = this.f1149d.a(0, 200);
                xVar = this.f1150e.a(8, 100);
            }
            h hVar = new h();
            hVar.a(xVar, xVar2);
            hVar.a();
        } else if (z2) {
            this.f1149d.f(4);
            this.f1150e.setVisibility(0);
        } else {
            this.f1149d.f(0);
            this.f1150e.setVisibility(8);
        }
    }

    public final Context g() {
        if (this.u == null) {
            TypedValue typedValue = new TypedValue();
            this.f1146a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.u = new ContextThemeWrapper(this.f1146a, i2);
            } else {
                this.u = this.f1146a;
            }
        }
        return this.u;
    }

    public final void b(Drawable drawable) {
        this.f1149d.b(drawable);
    }

    public final void e(int i2) {
        this.f1149d.d(i2);
    }

    public final void f(int i2) {
        this.f1149d.e(i2);
    }

    public final void p() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.b();
            this.n = null;
        }
    }

    public final boolean l() {
        o oVar = this.f1149d;
        if (oVar == null || !oVar.c()) {
            return false;
        }
        this.f1149d.d();
        return true;
    }

    public class a extends b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final g f1158a;

        /* renamed from: e  reason: collision with root package name */
        private final Context f1160e;

        /* renamed from: f  reason: collision with root package name */
        private b.a f1161f;

        /* renamed from: g  reason: collision with root package name */
        private WeakReference<View> f1162g;

        public a(Context context, b.a aVar) {
            this.f1160e = context;
            this.f1161f = aVar;
            g gVar = new g(context);
            gVar.f1339e = 1;
            this.f1158a = gVar;
            this.f1158a.a((g.a) this);
        }

        public final MenuInflater a() {
            return new androidx.appcompat.view.g(this.f1160e);
        }

        public final Menu b() {
            return this.f1158a;
        }

        public final void c() {
            if (m.this.f1153h == this) {
                if (!m.a(m.this.l, m.this.m, false)) {
                    m mVar = m.this;
                    mVar.f1154i = this;
                    mVar.j = this.f1161f;
                } else {
                    this.f1161f.a(this);
                }
                this.f1161f = null;
                m.this.h(false);
                m.this.f1150e.b();
                m.this.f1149d.a().sendAccessibilityEvent(32);
                m.this.f1147b.setHideOnContentScrollEnabled(m.this.o);
                m.this.f1153h = null;
            }
        }

        public final void d() {
            if (m.this.f1153h == this) {
                this.f1158a.e();
                try {
                    this.f1161f.b(this, this.f1158a);
                } finally {
                    this.f1158a.f();
                }
            }
        }

        public final boolean e() {
            this.f1158a.e();
            try {
                return this.f1161f.a((b) this, (Menu) this.f1158a);
            } finally {
                this.f1158a.f();
            }
        }

        public final void a(View view) {
            m.this.f1150e.setCustomView(view);
            this.f1162g = new WeakReference<>(view);
        }

        public final void a(CharSequence charSequence) {
            m.this.f1150e.setSubtitle(charSequence);
        }

        public final void b(CharSequence charSequence) {
            m.this.f1150e.setTitle(charSequence);
        }

        public final void a(int i2) {
            b((CharSequence) m.this.f1146a.getResources().getString(i2));
        }

        public final void b(int i2) {
            a((CharSequence) m.this.f1146a.getResources().getString(i2));
        }

        public final CharSequence f() {
            return m.this.f1150e.getTitle();
        }

        public final CharSequence g() {
            return m.this.f1150e.getSubtitle();
        }

        public final void a(boolean z) {
            super.a(z);
            m.this.f1150e.setTitleOptional(z);
        }

        public final boolean h() {
            return m.this.f1150e.f1401g;
        }

        public final View i() {
            WeakReference<View> weakReference = this.f1162g;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public final boolean a(g gVar, MenuItem menuItem) {
            b.a aVar = this.f1161f;
            if (aVar != null) {
                return aVar.a((b) this, menuItem);
            }
            return false;
        }

        public final void a(g gVar) {
            if (this.f1161f != null) {
                d();
                m.this.f1150e.a();
            }
        }
    }

    public final void a(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f1149d.a(view);
    }

    public final void b(int i2) {
        this.f1149d.a(i2);
    }

    public final void c(int i2) {
        this.f1149d.b(i2);
    }

    public final void d(boolean z2) {
        if (!this.y) {
            b(z2);
        }
    }

    public final boolean a(int i2, KeyEvent keyEvent) {
        g gVar;
        a aVar = this.f1153h;
        if (aVar == null || (gVar = aVar.f1158a) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        gVar.setQwertyMode(z2);
        return gVar.performShortcut(i2, keyEvent, 0);
    }
}
