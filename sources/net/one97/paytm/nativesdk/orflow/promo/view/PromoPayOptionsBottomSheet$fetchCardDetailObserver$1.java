package net.one97.paytm.nativesdk.orflow.promo.view;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse;

public final class PromoPayOptionsBottomSheet$fetchCardDetailObserver$1 implements z<GetCardDetailsResponse> {
    final /* synthetic */ PromoPayOptionsBottomSheet this$0;

    PromoPayOptionsBottomSheet$fetchCardDetailObserver$1(PromoPayOptionsBottomSheet promoPayOptionsBottomSheet) {
        this.this$0 = promoPayOptionsBottomSheet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r7.getBody()).getResultInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.orflow.promo.model.Body r1 = r7.getBody()
            if (r1 == 0) goto L_0x0014
            net.one97.paytm.nativesdk.orflow.promo.model.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = r1.getResultStatus()
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            if (r1 != 0) goto L_0x001c
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r7 = r6.this$0
            r1 = r7
            goto L_0x01ae
        L_0x001c:
            net.one97.paytm.nativesdk.orflow.promo.model.Body r1 = r7.getBody()
            if (r1 == 0) goto L_0x002d
            net.one97.paytm.nativesdk.orflow.promo.model.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r1.getResultStatus()
            goto L_0x002e
        L_0x002d:
            r1 = r0
        L_0x002e:
            r2 = 1
            java.lang.String r3 = "S"
            boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x019c
            net.one97.paytm.nativesdk.orflow.promo.model.Body r1 = r7.getBody()
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.nativesdk.orflow.promo.model.CardDetails r1 = r1.getCardDetails()
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.nativesdk.orflow.promo.model.BinDetails r1 = r1.getBinDetail()
            if (r1 == 0) goto L_0x004e
            java.lang.String r1 = r1.getPaymentMode()
            goto L_0x004f
        L_0x004e:
            r1 = r0
        L_0x004f:
            if (r1 == 0) goto L_0x0083
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r1 = r6.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = r1.selectedPayOption
            if (r1 == 0) goto L_0x005e
            java.lang.String r1 = r1.getMode()
            goto L_0x005f
        L_0x005e:
            r1 = r0
        L_0x005f:
            net.one97.paytm.nativesdk.orflow.promo.model.Body r3 = r7.getBody()
            if (r3 == 0) goto L_0x0076
            net.one97.paytm.nativesdk.orflow.promo.model.CardDetails r3 = r3.getCardDetails()
            if (r3 == 0) goto L_0x0076
            net.one97.paytm.nativesdk.orflow.promo.model.BinDetails r3 = r3.getBinDetail()
            if (r3 == 0) goto L_0x0076
            java.lang.String r3 = r3.getPaymentMode()
            goto L_0x0077
        L_0x0076:
            r3 = r0
        L_0x0077:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r1 != 0) goto L_0x0083
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r7 = r6.this$0
            r7.showErrorDebitInCreditCard()
            return
        L_0x0083:
            net.one97.paytm.nativesdk.orflow.promo.model.Body r1 = r7.getBody()
            if (r1 == 0) goto L_0x009a
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r2 = r6.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r2 = r2.selectedPayOption
            if (r2 == 0) goto L_0x0096
            java.lang.String r2 = r2.getCardNumber()
            goto L_0x0097
        L_0x0096:
            r2 = r0
        L_0x0097:
            r1.setCardNumber(r2)
        L_0x009a:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r1 = r6.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = r1.selectedPayOption
            if (r1 == 0) goto L_0x00a8
            r2 = r7
            net.one97.paytm.nativesdk.common.model.BaseDataModel r2 = (net.one97.paytm.nativesdk.common.model.BaseDataModel) r2
            r1.setData(r2)
        L_0x00a8:
            net.one97.paytm.nativesdk.common.model.PaymentIntent r1 = new net.one97.paytm.nativesdk.common.model.PaymentIntent
            r1.<init>()
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r2 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r2 = r2.getInstance()
            double r2 = r2.getAmount()
            r1.setTxnAmount(r2)
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r2 = r6.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r2 = r2.selectedPayOption
            if (r2 == 0) goto L_0x00e8
            java.lang.String r2 = r2.getCardNumber()
            if (r2 == 0) goto L_0x00e8
            r3 = 0
            java.lang.String r4 = "-"
            java.lang.String r5 = ""
            java.lang.String r2 = kotlin.m.p.a(r2, r4, r5, r3)
            if (r2 == 0) goto L_0x00e8
            if (r2 == 0) goto L_0x00e0
            r4 = 6
            java.lang.String r2 = r2.substring(r3, r4)
            java.lang.String r3 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            goto L_0x00e9
        L_0x00e0:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r0)
            throw r7
        L_0x00e8:
            r2 = r0
        L_0x00e9:
            r1.setBin6(r2)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r2 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r2 = r2.getInstance()
            boolean r2 = r2.is8DigitBin()
            if (r2 == 0) goto L_0x0113
            net.one97.paytm.nativesdk.orflow.promo.model.Body r2 = r7.getBody()
            if (r2 == 0) goto L_0x010f
            net.one97.paytm.nativesdk.orflow.promo.model.CardDetails r2 = r2.getCardDetails()
            if (r2 == 0) goto L_0x010f
            net.one97.paytm.nativesdk.orflow.promo.model.BinDetails r2 = r2.getBinDetail()
            if (r2 == 0) goto L_0x010f
            java.lang.String r2 = r2.getBin()
            goto L_0x0110
        L_0x010f:
            r2 = r0
        L_0x0110:
            r1.setBin8(r2)
        L_0x0113:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r2 = r6.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r2 = r2.selectedPayOption
            if (r2 == 0) goto L_0x0120
            java.lang.String r2 = r2.getMode()
            goto L_0x0121
        L_0x0120:
            r2 = r0
        L_0x0121:
            r1.setMode(r2)
            net.one97.paytm.nativesdk.orflow.promo.model.Body r2 = r7.getBody()
            if (r2 == 0) goto L_0x012f
            java.lang.String r2 = r2.getCardHash()
            goto L_0x0130
        L_0x012f:
            r2 = r0
        L_0x0130:
            r1.setCardHash(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.setBanks(r2)
            java.util.ArrayList r2 = r1.getBanks()
            net.one97.paytm.nativesdk.orflow.promo.model.Body r3 = r7.getBody()
            if (r3 == 0) goto L_0x0156
            net.one97.paytm.nativesdk.orflow.promo.model.CardDetails r3 = r3.getCardDetails()
            if (r3 == 0) goto L_0x0156
            net.one97.paytm.nativesdk.orflow.promo.model.BinDetails r3 = r3.getBinDetail()
            if (r3 == 0) goto L_0x0156
            java.lang.String r3 = r3.getIssuingBankCode()
            goto L_0x0157
        L_0x0156:
            r3 = r0
        L_0x0157:
            r2.add(r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.setChannels(r2)
            java.util.ArrayList r2 = r1.getChannels()
            net.one97.paytm.nativesdk.orflow.promo.model.Body r7 = r7.getBody()
            if (r7 == 0) goto L_0x017c
            net.one97.paytm.nativesdk.orflow.promo.model.CardDetails r7 = r7.getCardDetails()
            if (r7 == 0) goto L_0x017c
            net.one97.paytm.nativesdk.orflow.promo.model.BinDetails r7 = r7.getBinDetail()
            if (r7 == 0) goto L_0x017c
            java.lang.String r0 = r7.getChannelCode()
        L_0x017c:
            r2.add(r0)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r7.add(r1)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r1 = r6.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = r1.selectedPayOption
            if (r1 != 0) goto L_0x0198
            kotlin.g.b.k.a()
        L_0x0198:
            r0.onPaymentModeSelected(r7, r1)
            return
        L_0x019c:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r1 = r6.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.Body r7 = r7.getBody()
            if (r7 == 0) goto L_0x01ae
            net.one97.paytm.nativesdk.orflow.promo.model.ResultInfo r7 = r7.getResultInfo()
            if (r7 == 0) goto L_0x01ae
            java.lang.String r0 = r7.getResultMsg()
        L_0x01ae:
            r1.onNonPromoError(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet$fetchCardDetailObserver$1.onChanged(net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse):void");
    }
}
