package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.os.Bundle;

public interface PaymentProvider {
    boolean openPayment(Activity activity, Bundle bundle);
}
