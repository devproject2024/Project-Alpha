package com.paytm.paymentsettings.common.data;

public final class PaymentSettingsHelper {
    public static final Companion Companion = new Companion((byte) 0);
    /* access modifiers changed from: private */
    public static PaymentSettingsHelper mInstance;
    /* access modifiers changed from: private */
    public PaymentSettingsCallBacks paymentSettingCallback;

    public static final PaymentSettingsHelper getInstance() {
        return Companion.a();
    }

    public static final PaymentSettingsCallBacks getPaytmSettingsListener() {
        return Companion.b();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(byte b2) {
            this();
        }

        public final void init(PaymentSettingsCallBacks paymentSettingsCallBacks) {
            if (PaymentSettingsHelper.mInstance == null) {
                PaymentSettingsHelper.mInstance = new PaymentSettingsHelper();
                PaymentSettingsHelper access$getMInstance$cp = PaymentSettingsHelper.mInstance;
                if (access$getMInstance$cp != null) {
                    access$getMInstance$cp.paymentSettingCallback = paymentSettingsCallBacks;
                }
            }
        }

        public static PaymentSettingsHelper a() {
            return PaymentSettingsHelper.mInstance;
        }

        public static PaymentSettingsCallBacks b() {
            PaymentSettingsHelper access$getMInstance$cp = PaymentSettingsHelper.mInstance;
            if (access$getMInstance$cp != null) {
                return access$getMInstance$cp.paymentSettingCallback;
            }
            return null;
        }
    }
}
