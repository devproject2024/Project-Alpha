package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.u;
import androidx.core.h.x;
import androidx.core.h.y;
import androidx.core.h.z;

public final class ad implements o {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1672a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f1673b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f1674c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1675d;

    /* renamed from: e  reason: collision with root package name */
    private int f1676e;

    /* renamed from: f  reason: collision with root package name */
    private View f1677f;

    /* renamed from: g  reason: collision with root package name */
    private View f1678g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f1679h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f1680i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private ActionMenuPresenter n;
    private int o;
    private int p;
    private Drawable q;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ad(androidx.appcompat.widget.Toolbar r3, boolean r4) {
        /*
            r2 = this;
            int r0 = androidx.appcompat.R.string.abc_action_bar_up_description
            int r1 = androidx.appcompat.R.drawable.abc_ic_ab_back_material
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ad.<init>(androidx.appcompat.widget.Toolbar, boolean):void");
    }

    private ad(Toolbar toolbar, boolean z, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f1672a = toolbar;
        this.f1673b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.f1673b != null;
        this.j = toolbar.getNavigationIcon();
        ac a2 = ac.a(toolbar.getContext(), (AttributeSet) null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.q = a2.a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c2 = a2.c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(c2)) {
                b(c2);
            }
            CharSequence c3 = a2.c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c3)) {
                this.l = c3;
                if ((this.f1676e & 8) != 0) {
                    this.f1672a.setSubtitle(c3);
                }
            }
            Drawable a3 = a2.a(R.styleable.ActionBar_logo);
            if (a3 != null) {
                d(a3);
            }
            Drawable a4 = a2.a(R.styleable.ActionBar_icon);
            if (a4 != null) {
                a(a4);
            }
            if (this.j == null && (drawable = this.q) != null) {
                b(drawable);
            }
            c(a2.a(R.styleable.ActionBar_displayOptions, 0));
            int g2 = a2.g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f1672a.getContext()).inflate(g2, this.f1672a, false));
                c(this.f1676e | 16);
            }
            int f2 = a2.f(R.styleable.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1672a.getLayoutParams();
                layoutParams.height = f2;
                this.f1672a.setLayoutParams(layoutParams);
            }
            int d2 = a2.d(R.styleable.ActionBar_contentInsetStart, -1);
            int d3 = a2.d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (d2 >= 0 || d3 >= 0) {
                this.f1672a.setContentInsetsRelative(Math.max(d2, 0), Math.max(d3, 0));
            }
            int g3 = a2.g(R.styleable.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f1672a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f1672a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(R.styleable.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f1672a.setPopupTheme(g5);
            }
        } else {
            int i3 = 11;
            if (this.f1672a.getNavigationIcon() != null) {
                i3 = 15;
                this.q = this.f1672a.getNavigationIcon();
            }
            this.f1676e = i3;
        }
        a2.f1669a.recycle();
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f1672a.getNavigationContentDescription())) {
                e(this.p);
            }
        }
        this.m = this.f1672a.getNavigationContentDescription();
        this.f1672a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a  reason: collision with root package name */
            final a f1681a = new a(ad.this.f1672a.getContext(), ad.this.f1673b);

            public final void onClick(View view) {
                if (ad.this.f1674c != null && ad.this.f1675d) {
                    ad.this.f1674c.onMenuItemSelected(0, this.f1681a);
                }
            }
        });
    }

    public final ViewGroup a() {
        return this.f1672a;
    }

    public final Context b() {
        return this.f1672a.getContext();
    }

    public final boolean c() {
        return this.f1672a.hasExpandedActionView();
    }

    public final void d() {
        this.f1672a.collapseActionView();
    }

    public final void a(Window.Callback callback) {
        this.f1674c = callback;
    }

    public final void a(CharSequence charSequence) {
        if (!this.k) {
            c(charSequence);
        }
    }

    public final CharSequence e() {
        return this.f1672a.getTitle();
    }

    public final void b(CharSequence charSequence) {
        this.k = true;
        c(charSequence);
    }

    private void c(CharSequence charSequence) {
        this.f1673b = charSequence;
        if ((this.f1676e & 8) != 0) {
            this.f1672a.setTitle(charSequence);
        }
    }

    public final void a(Drawable drawable) {
        this.f1679h = drawable;
        q();
    }

    private void d(Drawable drawable) {
        this.f1680i = drawable;
        q();
    }

    private void q() {
        Drawable drawable;
        int i2 = this.f1676e;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f1680i;
            if (drawable == null) {
                drawable = this.f1679h;
            }
        } else {
            drawable = this.f1679h;
        }
        this.f1672a.setLogo(drawable);
    }

    public final boolean f() {
        return this.f1672a.canShowOverflowMenu();
    }

    public final boolean g() {
        return this.f1672a.isOverflowMenuShowing();
    }

    public final boolean h() {
        return this.f1672a.isOverflowMenuShowPending();
    }

    public final boolean i() {
        return this.f1672a.showOverflowMenu();
    }

    public final boolean j() {
        return this.f1672a.hideOverflowMenu();
    }

    public final void k() {
        this.f1675d = true;
    }

    public final void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            this.n = new ActionMenuPresenter(this.f1672a.getContext());
            this.n.f1295h = R.id.action_menu_presenter;
        }
        ActionMenuPresenter actionMenuPresenter = this.n;
        actionMenuPresenter.f1293f = aVar;
        this.f1672a.setMenu((g) menu, actionMenuPresenter);
    }

    public final void l() {
        this.f1672a.dismissPopupMenus();
    }

    public final int m() {
        return this.f1676e;
    }

    public final void c(int i2) {
        View view;
        int i3 = this.f1676e ^ i2;
        this.f1676e = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    s();
                }
                r();
            }
            if ((i3 & 3) != 0) {
                q();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f1672a.setTitle(this.f1673b);
                    this.f1672a.setSubtitle(this.l);
                } else {
                    this.f1672a.setTitle((CharSequence) null);
                    this.f1672a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.f1678g) != null) {
                if ((i2 & 16) != 0) {
                    this.f1672a.addView(view);
                } else {
                    this.f1672a.removeView(view);
                }
            }
        }
    }

    public final void a(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.f1677f;
        if (view != null && view.getParent() == (toolbar = this.f1672a)) {
            toolbar.removeView(this.f1677f);
        }
        this.f1677f = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.o == 2) {
            this.f1672a.addView(this.f1677f, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f1677f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.f991a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public final void a(boolean z) {
        this.f1672a.setCollapsible(z);
    }

    public final int n() {
        return this.o;
    }

    public final void a(View view) {
        View view2 = this.f1678g;
        if (!(view2 == null || (this.f1676e & 16) == 0)) {
            this.f1672a.removeView(view2);
        }
        this.f1678g = view;
        if (view != null && (this.f1676e & 16) != 0) {
            this.f1672a.addView(this.f1678g);
        }
    }

    public final x a(final int i2, long j2) {
        return u.s(this.f1672a).a(i2 == 0 ? 1.0f : 0.0f).a(j2).a((y) new z() {

            /* renamed from: c  reason: collision with root package name */
            private boolean f1685c = false;

            public final void onAnimationStart(View view) {
                ad.this.f1672a.setVisibility(0);
            }

            public final void onAnimationEnd(View view) {
                if (!this.f1685c) {
                    ad.this.f1672a.setVisibility(i2);
                }
            }

            public final void onAnimationCancel(View view) {
                this.f1685c = true;
            }
        });
    }

    public final void b(Drawable drawable) {
        this.j = drawable;
        r();
    }

    private void r() {
        if ((this.f1676e & 4) != 0) {
            Toolbar toolbar = this.f1672a;
            Drawable drawable = this.j;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1672a.setNavigationIcon((Drawable) null);
    }

    private void d(CharSequence charSequence) {
        this.m = charSequence;
        s();
    }

    private void s() {
        if ((this.f1676e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.m)) {
            this.f1672a.setNavigationContentDescription(this.p);
        } else {
            this.f1672a.setNavigationContentDescription(this.m);
        }
    }

    public final void c(Drawable drawable) {
        u.a((View) this.f1672a, drawable);
    }

    public final int o() {
        return this.f1672a.getHeight();
    }

    public final void f(int i2) {
        this.f1672a.setVisibility(i2);
    }

    public final void a(m.a aVar, g.a aVar2) {
        this.f1672a.setMenuCallbacks(aVar, aVar2);
    }

    public final Menu p() {
        return this.f1672a.getMenu();
    }

    public final void a(int i2) {
        a(i2 != 0 ? androidx.appcompat.a.a.a.b(this.f1672a.getContext(), i2) : null);
    }

    public final void b(int i2) {
        d(i2 != 0 ? androidx.appcompat.a.a.a.b(this.f1672a.getContext(), i2) : null);
    }

    public final void d(int i2) {
        b(i2 != 0 ? androidx.appcompat.a.a.a.b(this.f1672a.getContext(), i2) : null);
    }

    public final void e(int i2) {
        String str;
        if (i2 == 0) {
            str = null;
        } else {
            str = this.f1672a.getContext().getString(i2);
        }
        d((CharSequence) str);
    }
}
