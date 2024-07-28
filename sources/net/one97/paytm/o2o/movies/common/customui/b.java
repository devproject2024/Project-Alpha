package net.one97.paytm.o2o.movies.common.customui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.utility.RoboTextView;
import kotlin.g.b.k;
import kotlin.m;
import kotlin.u;
import net.one97.paytm.o2o.movies.R;

public final class b {

    /* renamed from: g  reason: collision with root package name */
    public static final a f75096g = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final LayoutInflater f75097a;

    /* renamed from: b  reason: collision with root package name */
    public int f75098b;

    /* renamed from: c  reason: collision with root package name */
    public c f75099c;

    /* renamed from: d  reason: collision with root package name */
    public View f75100d;

    /* renamed from: e  reason: collision with root package name */
    public Snackbar f75101e;

    /* renamed from: f  reason: collision with root package name */
    public Snackbar.SnackbarLayout f75102f;

    /* renamed from: h  reason: collision with root package name */
    private int f75103h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f75104i;

    public enum c {
        INDEFINITE,
        SHORT,
        LONG
    }

    private b(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.f75097a = (LayoutInflater) systemService;
            this.f75099c = c.SHORT;
            this.f75099c = c.LONG;
            this.f75103h = -1;
            this.f75098b = -1;
            this.f75104i = true;
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public /* synthetic */ b(Context context, byte b2) {
        this(context);
    }

    public final View a() {
        View view = this.f75100d;
        if (view == null) {
            k.a("contentView");
        }
        return view;
    }

    public final b a(c cVar) {
        k.c(cVar, AppConstants.DURATION);
        this.f75099c = cVar;
        return this;
    }

    public final b a(View view, String str, View.OnClickListener onClickListener) {
        Snackbar snackbar;
        k.c(view, "view");
        k.c(str, "mText");
        k.c(onClickListener, "onClickListener");
        if (this.f75098b != -1) {
            int i2 = c.f75109a[this.f75099c.ordinal()];
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
            this.f75101e = snackbar;
            Snackbar snackbar2 = this.f75101e;
            if (snackbar2 == null) {
                k.a("snackbar");
            }
            View b2 = snackbar2.b();
            if (b2 != null) {
                this.f75102f = (Snackbar.SnackbarLayout) b2;
                Snackbar.SnackbarLayout snackbarLayout = this.f75102f;
                if (snackbarLayout == null) {
                    k.a("snackbarView");
                }
                snackbarLayout.setPadding(0, 0, 0, 0);
                Snackbar snackbar3 = this.f75101e;
                if (snackbar3 == null) {
                    k.a("snackbar");
                }
                snackbar3.b().setPadding(0, 0, 0, 0);
                View inflate = this.f75097a.inflate(this.f75098b, (ViewGroup) null);
                k.a((Object) inflate, "layoutInflater.inflate(layout, null)");
                this.f75100d = inflate;
                View view2 = this.f75100d;
                if (view2 == null) {
                    k.a("contentView");
                }
                View findViewById = view2.findViewById(R.id.snackbar_text);
                k.a((Object) findViewById, "contentView.findViewById…View>(R.id.snackbar_text)");
                ((RoboTextView) findViewById).setText(str);
                View view3 = this.f75100d;
                if (view3 == null) {
                    k.a("contentView");
                }
                ((AppCompatImageView) view3.findViewById(R.id.snackbar_cross)).setOnClickListener(new d(this, onClickListener));
                Snackbar.SnackbarLayout snackbarLayout2 = this.f75102f;
                if (snackbarLayout2 == null) {
                    k.a("snackbarView");
                }
                View view4 = this.f75100d;
                if (view4 == null) {
                    k.a("contentView");
                }
                snackbarLayout2.addView(view4, 0);
                return this;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        }
        throw new C1485b(this, "layout must be setted");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f75105a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f75106b;

        d(b bVar, View.OnClickListener onClickListener) {
            this.f75105a = bVar;
            this.f75106b = onClickListener;
        }

        public final void onClick(View view) {
            this.f75106b.onClick(this.f75105a.a());
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f75107a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f75108b;

        public e(b bVar, View.OnClickListener onClickListener) {
            this.f75107a = bVar;
            this.f75108b = onClickListener;
        }

        public final void onClick(View view) {
            this.f75108b.onClick(this.f75107a.a());
        }
    }

    public final void b() {
        Snackbar snackbar = this.f75101e;
        if (snackbar == null) {
            k.a("snackbar");
        }
        snackbar.c();
    }

    public final void c() {
        Snackbar snackbar = this.f75101e;
        if (snackbar == null) {
            k.a("snackbar");
        }
        snackbar.d();
    }

    /* renamed from: net.one97.paytm.o2o.movies.common.customui.b$b  reason: collision with other inner class name */
    public final class C1485b extends RuntimeException {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1485b(b bVar, String str) {
            super(str);
            k.c(str, "detailMessage");
            this.this$0 = bVar;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(Context context) {
            k.c(context, "context");
            return new b(context, (byte) 0);
        }
    }
}
