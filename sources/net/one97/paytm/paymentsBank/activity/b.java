package net.one97.paytm.paymentsBank.activity;

import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.c;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankOpen.b.d;

public final class b extends d {

    /* renamed from: b  reason: collision with root package name */
    private HashMap f17420b;

    public final void h() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof e)) {
            activity = null;
        }
        e eVar = (e) activity;
        if (eVar != null) {
            eVar.a(10);
        }
    }

    public final void i() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof c)) {
            activity = null;
        }
        c cVar = (c) activity;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f17420b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
