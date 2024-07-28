package net.one97.paytm.addmoney.towallet.c;

import android.app.Application;
import android.content.Context;
import androidx.databinding.i;
import androidx.lifecycle.y;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.wallet.newdesign.addmoney.c.c;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public d f48830a;

    /* renamed from: b  reason: collision with root package name */
    public CJROrderSummary f48831b;

    /* renamed from: c  reason: collision with root package name */
    public i<String> f48832c = new i<>();

    /* renamed from: d  reason: collision with root package name */
    public i<String> f48833d = new i<>();

    /* renamed from: e  reason: collision with root package name */
    public i<String> f48834e = new i<>();

    /* renamed from: f  reason: collision with root package name */
    public i<String> f48835f = new i<>();

    /* renamed from: g  reason: collision with root package name */
    public i<String> f48836g = new i<>();

    /* renamed from: h  reason: collision with root package name */
    public i<String> f48837h = new i<>();

    /* renamed from: i  reason: collision with root package name */
    public i<String> f48838i = new i<>();
    public i<String> j = new i<>();
    public i<String> k = new i<>();
    public i<String> l = new i<>();
    public y<Integer> m = new y<>();
    public y<String> n = new y<>();
    public i<String> o = new i<>();
    public i<String> p = new i<>();
    public i<String> q = new i<>();
    public i<Boolean> r = new i<>();
    public i<Boolean> s = new i<>();
    public i<String> t = new i<>();
    public boolean u;
    public double v;
    public double w;
    public double x;
    public double y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    /* renamed from: net.one97.paytm.addmoney.towallet.c.a$a  reason: collision with other inner class name */
    public static final class C0860a implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48839a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f48840b;

        public C0860a(a aVar, Context context) {
            this.f48839a = aVar;
            this.f48840b = context;
        }

        public final void a() {
            this.f48839a.u = true;
            this.f48839a.n.setValue(j.a(this.f48840b));
        }
    }

    public final boolean a() {
        return this.f48830a == d.SUCCESS_DETAIL || this.f48830a == d.SUCCESS_INITIAL;
    }
}
