package net.one97.paytm.passbook.paytmBalance.e;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.landing.repositories.m;
import net.one97.paytm.passbook.mapping.a.f;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<net.one97.paytm.passbook.landing.e.a> f58219a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<Boolean> f58220b = new y<>();

    /* renamed from: net.one97.paytm.passbook.paytmBalance.e.a$a  reason: collision with other inner class name */
    static final class C1122a<T> implements z<f<? extends CJRLedger>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58221a;

        C1122a(a aVar) {
            this.f58221a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f fVar = (f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f58221a.f58219a;
            k.a((Object) fVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.paytmBalance.b.b(fVar));
        }
    }

    static final class b<T> implements z<f<? extends CJRCashWallet>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58222a;

        b(a aVar) {
            this.f58222a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f fVar = (f) obj;
            y<net.one97.paytm.passbook.landing.e.a> yVar = this.f58222a.f58219a;
            k.a((Object) fVar, "it");
            yVar.setValue(new net.one97.paytm.passbook.paytmBalance.b.a(fVar));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a() {
        net.one97.paytm.passbook.mapping.f b2 = d.b();
        k.a((Object) b2, "PassbookHelper.getImplListener()");
        Context b3 = b2.b();
        k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
        if (!net.one97.paytm.passbook.utility.f.a(b3)) {
            this.f58220b.setValue(Boolean.TRUE);
        } else {
            m.f57814b.b().observeForever(new b(this));
        }
    }

    public final void a(int i2, String str) {
        k.c(str, "selectedFilter");
        net.one97.paytm.passbook.mapping.f b2 = d.b();
        k.a((Object) b2, "PassbookHelper.getImplListener()");
        Context b3 = b2.b();
        k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
        if (!net.one97.paytm.passbook.utility.f.a(b3)) {
            this.f58220b.setValue(Boolean.TRUE);
            return;
        }
        net.one97.paytm.passbook.paytmBalance.c.a aVar = net.one97.paytm.passbook.paytmBalance.c.a.f58205b;
        net.one97.paytm.passbook.paytmBalance.c.a.a(str, i2).observeForever(new C1122a(this));
    }
}
