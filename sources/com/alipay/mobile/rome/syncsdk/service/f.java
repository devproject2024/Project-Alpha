package com.alipay.mobile.rome.syncsdk.service;

import com.alipay.mobile.rome.longlinkservice.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import java.util.Observable;

public final class f extends Observable {
    public final void a(a aVar) {
        try {
            setChanged();
            super.notifyObservers(aVar);
        } catch (Throwable th) {
            String str = "[notifyObservers] Exception: " + th.toString();
            if (h.f15097a == null) {
                h.f15097a = com.alipay.mobile.b.a.a.a.a();
            }
            h.f15097a.e("sync_".concat("ConnectionStateObservable"), str);
        }
    }
}
