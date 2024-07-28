package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.widget.ImageView;
import com.android.volley.VolleyError;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public final class PromoNewCardViewHolder$fetchBinDetails$2 implements PaymentMethodDataSource.Callback<BinResponse> {
    final /* synthetic */ String $bin;
    final /* synthetic */ PromoNewCardViewHolder this$0;

    PromoNewCardViewHolder$fetchBinDetails$2(PromoNewCardViewHolder promoNewCardViewHolder, String str) {
        this.this$0 = promoNewCardViewHolder;
        this.$bin = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        r1 = (r1 = r1.getBody()).getBinDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r5) {
        /*
            r4 = this;
            net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder r0 = r4.this$0
            r1 = 0
            r0.binApiCallInProgress = r1
            net.one97.paytm.nativesdk.ApiSession r0 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            java.lang.String r2 = r4.$bin
            if (r2 == 0) goto L_0x005c
            r3 = 6
            java.lang.String r1 = r2.substring(r1, r3)
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r0.setBinResponse(r1, r5)
            net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder r0 = r4.this$0
            net.one97.paytm.nativesdk.ApiSession r1 = net.one97.paytm.nativesdk.ApiSession.getInstance()
            java.lang.String r2 = r4.$bin
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse r1 = r1.getBinResposne(r2)
            if (r1 == 0) goto L_0x003a
            net.one97.paytm.nativesdk.common.model.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x003a
            net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail r1 = r1.getBinDetail()
            if (r1 == 0) goto L_0x003a
            java.lang.String r1 = r1.getChannelCode()
            goto L_0x003b
        L_0x003a:
            r1 = 0
        L_0x003b:
            r0.newCardType = r1
            if (r5 == 0) goto L_0x0051
            net.one97.paytm.nativesdk.common.model.Body r0 = r5.getBody()
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r0.getIconUrl()
            if (r0 == 0) goto L_0x0051
            net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder r1 = r4.this$0
            r1.setCardIcon(r0)
        L_0x0051:
            net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder r0 = r4.this$0
            r0.setEmiText(r5)
            net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder r0 = r4.this$0
            r0.showInputErrorText(r5)
            return
        L_0x005c:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoNewCardViewHolder$fetchBinDetails$2.onResponse(net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse):void");
    }

    public final void onErrorResponse(VolleyError volleyError, BinResponse binResponse) {
        this.this$0.binApiCallInProgress = false;
        ImageView imageView = (ImageView) this.this$0.getMView().findViewById(R.id.iv_card_logo);
        k.a((Object) imageView, "mView.iv_card_logo");
        imageView.setVisibility(8);
        this.this$0.showInputErrorText(binResponse);
    }
}
