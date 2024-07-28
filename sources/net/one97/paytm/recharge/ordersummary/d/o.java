package net.one97.paytm.recharge.ordersummary.d;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;

public final class o extends d {

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64172h;

    public final View a(int i2) {
        if (this.f64172h == null) {
            this.f64172h = new HashMap();
        }
        View view = (View) this.f64172h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64172h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f64172h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    /* access modifiers changed from: protected */
    public final void a(View view, Bundle bundle) {
        k.c(view, "view");
        super.a(view, bundle);
        b();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        b();
    }
}
