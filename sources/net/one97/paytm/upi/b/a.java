package net.one97.paytm.upi.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.util.UpiUtils;

public abstract class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private final int f66590a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f66591b;

    public void k() {
        HashMap hashMap = this.f66591b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        k();
    }

    public a(int i2) {
        this.f66590a = i2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(this.f66590a, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void a(UpiCustomVolleyError upiCustomVolleyError, boolean z) {
        String str = null;
        if (!p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError != null ? upiCustomVolleyError.getMessage() : null, true)) {
            if (!p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError != null ? upiCustomVolleyError.getmErrorCode() : null, true)) {
                if (upiCustomVolleyError != null) {
                    str = upiCustomVolleyError.getmErrorCode();
                }
                if (!p.a("410", str, true)) {
                    return;
                }
            }
        }
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        new UpiCustomVolleyError();
        UpiLandingPageActivity.class.getName();
        a2.b().e(requireActivity());
    }
}
