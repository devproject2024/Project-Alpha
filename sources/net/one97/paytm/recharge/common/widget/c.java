package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.alipay.mobile.h5container.api.H5Event;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.u;

public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final a f62144e = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public int f62145a;

    /* renamed from: b  reason: collision with root package name */
    public View f62146b;

    /* renamed from: c  reason: collision with root package name */
    public Snackbar f62147c;

    /* renamed from: d  reason: collision with root package name */
    public Snackbar.SnackbarLayout f62148d;

    /* renamed from: f  reason: collision with root package name */
    private final LayoutInflater f62149f;

    /* renamed from: g  reason: collision with root package name */
    private int f62150g;

    /* renamed from: h  reason: collision with root package name */
    private b f62151h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f62152i;

    public enum b {
        INDEFINITE,
        SHORT,
        LONG
    }

    private c(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.f62149f = (LayoutInflater) systemService;
            this.f62151h = b.SHORT;
            this.f62151h = b.LONG;
            this.f62150g = -1;
            this.f62145a = -1;
            this.f62152i = true;
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public /* synthetic */ c(Context context, byte b2) {
        this(context);
    }

    public final View a() {
        View view = this.f62146b;
        if (view == null) {
            k.a("contentView");
        }
        return view;
    }

    public final boolean b() {
        Snackbar snackbar = this.f62147c;
        if (snackbar == null) {
            k.a("snackbar");
        }
        return snackbar.e();
    }

    public final c a(b bVar) {
        k.c(bVar, AppConstants.DURATION);
        this.f62151h = bVar;
        return this;
    }

    public final c a(View view) {
        Snackbar snackbar;
        k.c(view, "view");
        int i2 = d.f62153a[this.f62151h.ordinal()];
        if (i2 == 1) {
            snackbar = Snackbar.a(view, (CharSequence) "", -2);
            k.a((Object) snackbar, "Snackbar.make(view, \"\", …ackbar.LENGTH_INDEFINITE)");
        } else if (i2 == 2) {
            snackbar = Snackbar.a(view, (CharSequence) "", -1);
            k.a((Object) snackbar, "Snackbar.make(view, \"\", Snackbar.LENGTH_SHORT)");
        } else if (i2 == 3) {
            snackbar = Snackbar.a(view, (CharSequence) "", 0);
            k.a((Object) snackbar, "Snackbar.make(view, \"\", Snackbar.LENGTH_LONG)");
        } else {
            throw new m();
        }
        this.f62147c = snackbar;
        Snackbar snackbar2 = this.f62147c;
        if (snackbar2 == null) {
            k.a("snackbar");
        }
        View b2 = snackbar2.b();
        if (b2 != null) {
            this.f62148d = (Snackbar.SnackbarLayout) b2;
            Snackbar.SnackbarLayout snackbarLayout = this.f62148d;
            if (snackbarLayout == null) {
                k.a("snackbarView");
            }
            snackbarLayout.setPadding(0, 0, 0, 0);
            Snackbar snackbar3 = this.f62147c;
            if (snackbar3 == null) {
                k.a("snackbar");
            }
            snackbar3.b().setPadding(0, 0, 0, 0);
            View inflate = this.f62149f.inflate(this.f62145a, (ViewGroup) null);
            k.a((Object) inflate, "layoutInflater.inflate(layout, null)");
            this.f62146b = inflate;
            Snackbar.SnackbarLayout snackbarLayout2 = this.f62148d;
            if (snackbarLayout2 == null) {
                k.a("snackbarView");
            }
            View view2 = this.f62146b;
            if (view2 == null) {
                k.a("contentView");
            }
            snackbarLayout2.addView(view2, 0);
            return this;
        }
        throw new u("null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
    }

    public final void c() {
        Snackbar snackbar = this.f62147c;
        if (snackbar == null) {
            k.a("snackbar");
        }
        snackbar.c();
    }

    public final void d() {
        Snackbar snackbar = this.f62147c;
        if (snackbar == null) {
            k.a("snackbar");
        }
        snackbar.d();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(Context context) {
            k.c(context, "context");
            return new c(context, (byte) 0);
        }
    }

    public final boolean e() {
        return this.f62147c != null;
    }

    public final ViewTreeObserver f() {
        Snackbar snackbar = this.f62147c;
        if (snackbar == null) {
            k.a("snackbar");
        }
        View b2 = snackbar.b();
        k.a((Object) b2, "snackbar.view");
        return b2.getViewTreeObserver();
    }

    public final int g() {
        Snackbar snackbar = this.f62147c;
        if (snackbar == null) {
            k.a("snackbar");
        }
        View b2 = snackbar.b();
        k.a((Object) b2, "snackbar.view");
        return b2.getHeight();
    }

    public final Snackbar a(Snackbar.a aVar) {
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        Snackbar snackbar = this.f62147c;
        if (snackbar == null) {
            k.a("snackbar");
        }
        BaseTransientBottomBar a2 = snackbar.a(aVar);
        k.a((Object) a2, "snackbar.addCallback(callback)");
        return (Snackbar) a2;
    }
}
