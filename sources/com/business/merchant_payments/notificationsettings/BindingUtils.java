package com.business.merchant_payments.notificationsettings;

import android.content.Context;
import com.business.merchant_payments.PaymentsConfig;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class BindingUtils {
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String string(int i2) {
            PaymentsConfig instance = PaymentsConfig.getInstance();
            k.b(instance, "PaymentsConfig.getInstance()");
            Context appContext = instance.getAppContext();
            k.b(appContext, "PaymentsConfig.getInstan…              .appContext");
            return appContext.getResources().getString(i2);
        }
    }
}
