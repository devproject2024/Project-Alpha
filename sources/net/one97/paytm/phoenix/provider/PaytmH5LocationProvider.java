package net.one97.paytm.phoenix.provider;

import android.app.Activity;

public interface PaytmH5LocationProvider {
    void getCurrentLocation(Activity activity, PaytmH5LocationProviderCallback paytmH5LocationProviderCallback);
}
