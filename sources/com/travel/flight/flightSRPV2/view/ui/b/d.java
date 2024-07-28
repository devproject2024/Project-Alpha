package com.travel.flight.flightSRPV2.view.ui.b;

import java.util.HashMap;
import net.one97.paytm.i.h;

public abstract class d extends h {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f24309a;

    public void a() {
        HashMap hashMap = this.f24309a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }
}
