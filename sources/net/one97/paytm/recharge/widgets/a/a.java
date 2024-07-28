package net.one97.paytm.recharge.widgets.a;

import android.os.Bundle;
import com.paytm.utility.g;

public final class a implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private String f64957a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f64958b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.recharge.widgets.b.a f64959c;

    public a(String str, net.one97.paytm.recharge.widgets.b.a aVar) {
        this.f64957a = str;
        this.f64959c = aVar;
    }

    public a(String str, net.one97.paytm.recharge.widgets.b.a aVar, Bundle bundle) {
        this.f64957a = str;
        this.f64958b = bundle;
        this.f64959c = aVar;
    }

    public final void onOkClick() {
        net.one97.paytm.recharge.widgets.b.a aVar = this.f64959c;
        if (aVar != null) {
            aVar.a(this.f64957a, this.f64958b);
        }
    }
}
