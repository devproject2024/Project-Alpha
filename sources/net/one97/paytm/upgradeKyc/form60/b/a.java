package net.one97.paytm.upgradeKyc.form60.b;

import android.app.Activity;
import com.android.volley.VolleyError;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.upgradeKyc.Form60Model;
import net.one97.paytm.upgradeKyc.form60.a.a;

public final class a implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private a.c f66004a;

    /* renamed from: b  reason: collision with root package name */
    private a.C1316a f66005b = new Form60Model(this);

    public a(a.c cVar) {
        this.f66004a = cVar;
    }

    public final Activity a() {
        return this.f66004a.aD_();
    }

    public final void b() {
        a.C1316a aVar = this.f66005b;
        if (aVar != null) {
            aVar.onDestroy();
            this.f66005b = null;
        }
    }

    public final void c() {
        this.f66004a.f();
    }

    public final void d() {
        this.f66004a.e();
        this.f66004a.g();
    }

    public final void e() {
        this.f66005b.fetchForm60TncApiCall();
    }

    public final void a(ArrayList<TncData> arrayList) {
        this.f66004a.d();
        this.f66005b.saveForm60TncApiCall(arrayList);
    }

    public final void f() {
        this.f66004a.h();
    }

    public final void a(String str, String str2, String str3, String str4) {
        this.f66005b.saveForm60DetailsApiCall(str, str2, str3, str4);
    }

    public final void a(String str) {
        this.f66004a.e();
        this.f66004a.a(str);
    }

    public final void a(VolleyError volleyError) {
        if (volleyError != null) {
            this.f66004a.e();
        }
    }

    public final void b(ArrayList<TncData> arrayList) {
        this.f66004a.a(arrayList);
    }

    public final void a(NetworkCustomError networkCustomError) {
        this.f66004a.a(networkCustomError);
    }
}
