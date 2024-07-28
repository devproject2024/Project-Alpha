package com.business.merchant_payments.notificationsettings.viewmodel;

import androidx.arch.core.c.a;
import androidx.lifecycle.LiveData;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.notificationsettings.model.MerchantProfileResponse;
import kotlin.g.b.k;

public final class EmailAndSmsNotificationViewModel$removeSecondaryLiveData$1<I, O> implements a<Boolean, LiveData<b<MerchantProfileResponse>>> {
    public final /* synthetic */ EmailAndSmsNotificationViewModel this$0;

    public EmailAndSmsNotificationViewModel$removeSecondaryLiveData$1(EmailAndSmsNotificationViewModel emailAndSmsNotificationViewModel) {
        this.this$0 = emailAndSmsNotificationViewModel;
    }

    public final LiveData<b<MerchantProfileResponse>> apply(Boolean bool) {
        k.b(bool, "flag");
        if (bool.booleanValue()) {
            return this.this$0.callInsertUpdateDataAPI();
        }
        return com.business.common_module.utilities.a.a.a();
    }
}
