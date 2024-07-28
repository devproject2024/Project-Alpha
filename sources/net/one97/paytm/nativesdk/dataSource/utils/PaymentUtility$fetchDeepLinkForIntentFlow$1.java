package net.one97.paytm.nativesdk.dataSource.utils;

import android.content.Context;
import android.content.pm.ActivityInfo;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.listeners.TransactionProcessorListener;

public final class PaymentUtility$fetchDeepLinkForIntentFlow$1 implements TransactionProcessorListener {
    final /* synthetic */ ActivityInfo $activityInfo;
    final /* synthetic */ Context $context;

    public final void onIntentFlowComplete() {
    }

    PaymentUtility$fetchDeepLinkForIntentFlow$1(Context context, ActivityInfo activityInfo) {
        this.$context = context;
        this.$activityInfo = activityInfo;
    }

    public final void onProcessTransactionResponse(Object obj) {
        k.c(obj, Payload.RESPONSE);
        PaymentUtility.INSTANCE.onResponse(this.$context, obj, this.$activityInfo);
    }
}
