package com.business.merchant_payments.common.viewmodel;

import android.content.Context;
import androidx.databinding.a;
import com.business.merchant_payments.PaymentsConfig;

public abstract class BaseViewModel extends a {
    public Context getContext() {
        return PaymentsConfig.getInstance().getAppContext();
    }
}
