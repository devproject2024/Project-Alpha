package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import net.one97.paytm.h5.c;

public class H5LocationProvider implements PaytmH5LocationProvider {
    public void getCurrentLocation(Activity activity, PaytmH5LocationProviderCallback paytmH5LocationProviderCallback) {
        c cVar = c.f50543a;
        c.a(new c.a() {
            public final void onLocationUpdate(double d2, double d3, long j) {
                PaytmH5LocationProviderCallback.this.onLocationFound(d2, d3);
            }
        });
    }
}
