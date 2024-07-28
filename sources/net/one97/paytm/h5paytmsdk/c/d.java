package net.one97.paytm.h5paytmsdk.c;

import com.alipay.mobile.nebula.provider.H5ActivityProvider;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5TransActivity;

public final class d implements H5ActivityProvider {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17091a;

    public /* synthetic */ d() {
        this(false);
    }

    public d(boolean z) {
        this.f17091a = z;
    }

    public final Class<?> getH5ActivityImpl() {
        return this.f17091a ? PaytmH5TransActivity.class : PaytmH5Activity.class;
    }
}
