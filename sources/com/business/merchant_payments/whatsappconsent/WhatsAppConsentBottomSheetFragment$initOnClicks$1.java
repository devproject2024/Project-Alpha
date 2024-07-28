package com.business.merchant_payments.whatsappconsent;

import android.content.Context;
import android.view.View;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.ups.UPSDataProvider;

public final class WhatsAppConsentBottomSheetFragment$initOnClicks$1 implements View.OnClickListener {
    public final /* synthetic */ WhatsAppConsentBottomSheetFragment this$0;

    public WhatsAppConsentBottomSheetFragment$initOnClicks$1(WhatsAppConsentBottomSheetFragment whatsAppConsentBottomSheetFragment) {
        this.this$0 = whatsAppConsentBottomSheetFragment;
    }

    public final void onClick(View view) {
        WhatsAppConsentBottomSheetFragment.access$getMConsentButton$p(this.this$0).setEnabled(false);
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.this$0.activityContext, "HomePage", "Bottom pop up", "", "Whatsapp consent", "Promo Click");
        Context access$getActivityContext$p = this.this$0.activityContext;
        if (access$getActivityContext$p != null) {
            new UPSDataProvider(access$getActivityContext$p).updateWhatsConsentStatusAPI("true", new WhatsAppConsentBottomSheetFragment$initOnClicks$1$1$1(this.this$0));
        }
    }
}
