package com.business.merchant_payments.whatsappconsent;

import android.content.Context;
import kotlin.g.a.q;
import kotlin.g.b.j;
import kotlin.g.b.k;
import kotlin.x;

public final /* synthetic */ class WhatsAppConsentBottomSheetFragment$initOnClicks$1$1$1 extends j implements q<String, Boolean, Context, x> {
    public WhatsAppConsentBottomSheetFragment$initOnClicks$1$1$1(WhatsAppConsentBottomSheetFragment whatsAppConsentBottomSheetFragment) {
        super(3, whatsAppConsentBottomSheetFragment, WhatsAppConsentBottomSheetFragment.class, "statusRecieved", "statusRecieved(Ljava/lang/String;ZLandroid/content/Context;)V", 0);
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, ((Boolean) obj2).booleanValue(), (Context) obj3);
        return x.f47997a;
    }

    public final void invoke(String str, boolean z, Context context) {
        k.d(str, "p1");
        ((WhatsAppConsentBottomSheetFragment) this.receiver).statusRecieved(str, z, context);
    }
}
