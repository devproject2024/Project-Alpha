package net.one97.paytm.paymentsBank.createfd.b;

import android.view.View;
import java.util.HashMap;

public final class d extends g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f18106a;

    public final View a(int i2) {
        if (this.f18106a == null) {
            this.f18106a = new HashMap();
        }
        View view = (View) this.f18106a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f18106a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void e() {
        HashMap hashMap = this.f18106a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        e();
    }
}
