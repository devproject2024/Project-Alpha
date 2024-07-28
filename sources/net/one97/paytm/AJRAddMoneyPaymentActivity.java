package net.one97.paytm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.localbroadcastmanager.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.b;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.wallet.FeeDetails;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.RiskConvFeeModel;
import net.one97.paytm.utils.r;
import net.one97.paytm.wallet.d.c;

public class AJRAddMoneyPaymentActivity extends AJRRechargePaymentActivity implements PaytmSDKRequestClient {
    public void applyAnotherOffer(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
    }

    public void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
    }

    public void onOtherPayModeSelected(boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
    }

    public void onCreate(Bundle bundle) {
        c cVar;
        CJRRechargeCart cJRRechargeCart;
        super.onCreate(bundle);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        ArrayList arrayList = new ArrayList();
        b.a aVar = b.f48395b;
        WeakReference<c> weakReference = b.f48396d.f48397a;
        if (!(weakReference == null || (cVar = (c) weakReference.get()) == null || (cJRRechargeCart = cVar.t) == null || cJRRechargeCart.getCart() == null || cJRRechargeCart.getCart().getFee_details() == null)) {
            Iterator<FeeDetails> it2 = cJRRechargeCart.getCart().getFee_details().iterator();
            while (it2.hasNext()) {
                FeeDetails next = it2.next();
                arrayList.add(new RiskConvFeeModel(next.getCardHash(), next.getFeeAmount(), next.getPayMethod()));
            }
        }
        instance.setRiskConvFeeData(arrayList);
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z, String str, PaytmSDKRequestClient paytmSDKRequestClient) {
        if (paytmSDKRequestClient == null) {
            r.a("AJRAddMoneyPaymentActivity", "creating deferred client:null");
            super.a(z, str, (PaytmSDKRequestClient) this);
            return;
        }
        r.a("AJRAddMoneyPaymentActivity", "creating deferred client:not-null");
        super.a(z, str, paytmSDKRequestClient);
    }

    /* access modifiers changed from: private */
    public static PaytmSDKRequestClient.VerifyResponseData b(FeeDetails feeDetails, c cVar) {
        SpannableString spannableString;
        String str;
        String str2;
        String str3;
        String str4;
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
        PaytmSDKRequestClient.ConvFeeResponse convFeeResponse = new PaytmSDKRequestClient.ConvFeeResponse();
        if (feeDetails != null && cVar != null) {
            convFeeResponse.setConvFeeLabel(feeDetails.getMsg());
            convFeeResponse.setTotalAmtIncConvFee(feeDetails.getPayableAmount());
            convFeeResponse.setFeePercent(feeDetails.getFeePercent());
            convFeeResponse.setAggregatePGConvFee(feeDetails.getFeeAmount());
            convFeeResponse.setTotalAmtExConvFee(feeDetails.getOrderAmount());
            convFeeResponse.setOfferMsg(feeDetails.getOfferMsg());
            boolean isToShowUpiOnboardingView = SDKUtils.isToShowUpiOnboardingView();
            String str5 = "";
            if (feeDetails == null || feeDetails.getFeeDetailsBreakupList() == null) {
                str = str5;
                str3 = str;
                str2 = str3;
            } else {
                if (feeDetails.getFeeDetailsBreakupList().size() == 1) {
                    str = String.format(cVar.f70164a.getString(R.string.am_no_slab_fee_text), new Object[]{c.a(feeDetails.getFeeDetailsBreakupList().get(0).getSlabFeePercentage().doubleValue())});
                } else if (feeDetails.getFeeDetailsBreakupList().size() != 2) {
                    str = str5;
                } else if (feeDetails.getFeeDetailsBreakupList().get(0).getSlabFeePercentage().compareTo(Double.valueOf(0.0d)) != 0 && feeDetails.getFeeDetailsBreakupList().get(1).getSlabFeePercentage().compareTo(Double.valueOf(0.0d)) != 0) {
                    str = String.format(cVar.f70164a.getString(R.string.am_two_slab_fee_text), new Object[]{c.a(feeDetails.getFeeDetailsBreakupList().get(0).getSlabFeePercentage().doubleValue()), c.a(feeDetails.getFeeDetailsBreakupList().get(0).getSlabTxnAmount().doubleValue()), c.a(feeDetails.getFeeDetailsBreakupList().get(1).getSlabFeePercentage().doubleValue()), c.a(feeDetails.getFeeDetailsBreakupList().get(1).getSlabTxnAmount().doubleValue())});
                } else if (feeDetails.getFeeDetailsBreakupList().get(0).getSlabFeePercentage().compareTo(Double.valueOf(0.0d)) != 0) {
                    str = String.format(cVar.f70164a.getString(R.string.am_one_slab_fee_text), new Object[]{c.a(feeDetails.getFeeDetailsBreakupList().get(0).getSlabFeePercentage().doubleValue()), c.a(feeDetails.getFeeDetailsBreakupList().get(0).getSlabTxnAmount().doubleValue())});
                } else if (feeDetails.getFeeDetailsBreakupList().get(1).getSlabFeePercentage().compareTo(Double.valueOf(0.0d)) != 0) {
                    str = String.format(cVar.f70164a.getString(R.string.am_one_slab_fee_text), new Object[]{c.a(feeDetails.getFeeDetailsBreakupList().get(1).getSlabFeePercentage().doubleValue()), c.a(feeDetails.getFeeDetailsBreakupList().get(1).getSlabTxnAmount().doubleValue())});
                } else {
                    spannableString = new SpannableString(str5);
                    convFeeResponse.setSpannableConvFeeText(spannableString);
                }
                String string = cVar.f70164a.getString(R.string.am_common_fee_text_part_1);
                if (isToShowUpiOnboardingView) {
                    String str6 = str5;
                    str5 = cVar.f70164a.getString(R.string.am_common_fee_text_part_2);
                    str4 = str6;
                } else {
                    str4 = cVar.f70164a.getResources().getString(R.string.am_please);
                }
                String str7 = string;
                str2 = str4 + cVar.f70164a.getString(R.string.am_common_fee_text_part_3);
                str3 = str5;
                str5 = str7;
            }
            SpannableString spannableString2 = new SpannableString(str + str5 + str3 + str2);
            spannableString2.setSpan(new ForegroundColorSpan(cVar.f70164a.getResources().getColor(R.color.black)), 0, str.length(), 17);
            spannableString2.setSpan(new ForegroundColorSpan(cVar.f70164a.getResources().getColor(R.color.color_747D84)), str.length(), str.length() + str5.length(), 33);
            if (!TextUtils.isEmpty(str3)) {
                spannableString2.setSpan(new StyleSpan(1), spannableString2.toString().indexOf(str3), (spannableString2.toString().indexOf(str3) + str3.length()) - 1, 17);
                spannableString2.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        a.a((Context) c.this.f70164a).a(new Intent(SDKConstants.ONBOARDING_BROADCAST));
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(c.this.f70164a.getResources().getColor(R.color.paytm_blue));
                    }
                }, spannableString2.toString().indexOf(str3), (spannableString2.toString().indexOf(str3) + str3.length()) - 1, 17);
            }
            spannableString2.setSpan(new ForegroundColorSpan(cVar.f70164a.getResources().getColor(R.color.color_747D84)), spannableString2.length() - str2.length(), spannableString2.length(), 17);
            spannableString = spannableString2;
            convFeeResponse.setSpannableConvFeeText(spannableString);
        } else if (cVar != null) {
            convFeeResponse.setTotalAmtIncConvFee(cVar.f70165b);
            convFeeResponse.setAggregatePGConvFee("0");
            convFeeResponse.setTotalAmtExConvFee(cVar.f70165b);
        }
        verifyResponseData.setConvFeeResponse(convFeeResponse);
        return verifyResponseData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = (net.one97.paytm.wallet.d.c) r0.get();
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void verifyCart(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.CallbackData r9, final net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.OnVerifyResponse r10) {
        /*
            r8 = this;
            net.one97.paytm.addmoney.b$a r0 = net.one97.paytm.addmoney.b.f48395b
            net.one97.paytm.addmoney.b r0 = net.one97.paytm.addmoney.b.f48396d
            java.lang.ref.WeakReference<net.one97.paytm.wallet.d.c> r0 = r0.f48397a
            if (r0 == 0) goto L_0x018b
            java.lang.Object r0 = r0.get()
            net.one97.paytm.wallet.d.c r0 = (net.one97.paytm.wallet.d.c) r0
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.util.ArrayList r1 = r9.getPaymentIntents()
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentIntent r1 = (net.one97.paytm.nativesdk.common.model.PaymentIntent) r1
            java.lang.String r3 = r1.getCardHash()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 1
            if (r3 != 0) goto L_0x0040
            net.one97.paytm.j.c.a()
            java.lang.String r3 = "addMoneyConvFeeSupportedMode"
            java.lang.String r5 = "CREDIT_CARD"
            java.lang.String r3 = net.one97.paytm.j.c.a((java.lang.String) r3, (java.lang.String) r5)
            java.lang.String r1 = r1.getMode()
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0040
            r1 = 1
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            r3 = 0
            if (r1 != 0) goto L_0x004c
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData r9 = b(r3, r0)
            r10.onVerifySuccess(r9)
            return
        L_0x004c:
            java.util.ArrayList r1 = r9.getPaymentIntents()
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentIntent r1 = (net.one97.paytm.nativesdk.common.model.PaymentIntent) r1
            java.lang.String r1 = r1.getCardHash()
            net.one97.paytm.common.entity.CJRRechargeCart r5 = r0.t
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x009a
            if (r5 == 0) goto L_0x009a
            net.one97.paytm.common.entity.shopping.CJRCart r6 = r5.getCart()
            if (r6 == 0) goto L_0x009a
            net.one97.paytm.common.entity.shopping.CJRCart r6 = r5.getCart()
            java.util.ArrayList r6 = r6.getFee_details()
            if (r6 == 0) goto L_0x009a
            net.one97.paytm.common.entity.shopping.CJRCart r5 = r5.getCart()
            java.util.ArrayList r5 = r5.getFee_details()
            java.util.Iterator r5 = r5.iterator()
        L_0x0080:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x009a
            java.lang.Object r6 = r5.next()
            net.one97.paytm.common.entity.wallet.FeeDetails r6 = (net.one97.paytm.common.entity.wallet.FeeDetails) r6
            java.lang.String r7 = r6.getCardHash()
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0080
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$VerifyResponseData r3 = b(r6, r0)
        L_0x009a:
            if (r3 == 0) goto L_0x00a0
            r10.onVerifySuccess(r3)
            return
        L_0x00a0:
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.util.ArrayList r9 = r9.getPaymentIntents()
            java.lang.String r9 = r1.a((java.lang.Object) r9)
            r0.c((java.lang.String) r9)
            net.one97.paytm.AJRAddMoneyPaymentActivity$1 r9 = new net.one97.paytm.AJRAddMoneyPaymentActivity$1
            r9.<init>(r10, r0)
            android.app.Activity r10 = r0.f70164a
            if (r10 == 0) goto L_0x018b
            android.app.Activity r10 = r0.f70164a
            boolean r10 = r10.isFinishing()
            if (r10 == 0) goto L_0x00c3
            goto L_0x018b
        L_0x00c3:
            r0.f70169f = r4
            java.lang.String r10 = r0.f70166c
            org.json.JSONObject r10 = r0.f(r10)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r1.put(r3, r4)
            android.app.Activity r3 = r0.f70164a
            java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r3)
            java.lang.String r4 = "x-user-id"
            r1.put(r4, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            net.one97.paytm.helper.c r4 = net.one97.paytm.helper.a.b()
            java.lang.String r5 = "addMoneyCartVerifyV2"
            java.lang.String r4 = r4.f((java.lang.String) r5)
            r3.append(r4)
            java.lang.String r4 = "?payment_info_version=2"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.f70167d = r3
            android.app.Activity r3 = r0.f70164a
            java.lang.String r4 = r0.f70167d
            java.lang.String r3 = com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r4)
            r0.f70167d = r3
            net.one97.paytm.wallet.utility.f r3 = net.one97.paytm.wallet.utility.f.f72321a
            java.lang.String r3 = r0.f70167d
            java.lang.String r3 = net.one97.paytm.wallet.utility.f.a(r3)
            r0.f70167d = r3
            net.one97.paytm.wallet.utility.f r3 = net.one97.paytm.wallet.utility.f.f72321a
            java.lang.String r3 = r0.f70167d
            java.lang.String r3 = net.one97.paytm.wallet.utility.f.b(r3)
            r0.f70167d = r3
            net.one97.paytm.helper.c r3 = net.one97.paytm.helper.a.b()
            java.lang.String r4 = r0.f70167d
            java.lang.String r3 = r3.i((java.lang.String) r4)
            r0.f70167d = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.f70167d
            r3.append(r4)
            java.lang.String r4 = "&source=paytm-app"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.f70167d = r3
            android.app.Activity r3 = r0.f70164a
            boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)
            if (r3 == 0) goto L_0x0187
            r0.b()
            com.paytm.network.b r3 = net.one97.paytm.addmoney.common.a.b()
            android.app.Activity r4 = r0.f70164a
            android.content.Context r4 = r4.getApplicationContext()
            r3.f42877a = r4
            java.lang.String r10 = r10.toString()
            r3.f42884h = r10
            net.one97.paytm.common.entity.CJRRechargeCart r10 = new net.one97.paytm.common.entity.CJRRechargeCart
            r10.<init>()
            r3.f42885i = r10
            r3.f42882f = r1
            r3.k = r2
            net.one97.paytm.wallet.d.c$2 r10 = new net.one97.paytm.wallet.d.c$2
            r10.<init>(r9)
            r3.j = r10
            java.lang.String r9 = r0.f70167d
            r3.f42880d = r9
            com.paytm.network.a r9 = r3.l()
            android.app.Activity r10 = r0.f70164a
            java.lang.Class r10 = r10.getClass()
            java.lang.String r10 = r10.getSimpleName()
            r9.a((java.lang.Object) r10)
            r9.a()
            return
        L_0x0187:
            r0.e()
        L_0x018b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRAddMoneyPaymentActivity.verifyCart(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$CallbackData, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnVerifyResponse):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = (net.one97.paytm.wallet.d.c) r0.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doCheckout(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.CallbackData r4, final net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.OnCheckoutResponse r5) {
        /*
            r3 = this;
            net.one97.paytm.addmoney.b$a r0 = net.one97.paytm.addmoney.b.f48395b
            net.one97.paytm.addmoney.b r0 = net.one97.paytm.addmoney.b.f48396d
            java.lang.ref.WeakReference<net.one97.paytm.wallet.d.c> r0 = r0.f48397a
            if (r0 == 0) goto L_0x0054
            java.lang.Object r0 = r0.get()
            net.one97.paytm.wallet.d.c r0 = (net.one97.paytm.wallet.d.c) r0
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            if (r4 == 0) goto L_0x004c
            java.util.ArrayList r1 = r4.getPaymentIntents()
            if (r1 == 0) goto L_0x0046
            java.util.ArrayList r1 = r4.getPaymentIntents()
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x0036
            java.util.ArrayList r1 = r4.getPaymentIntents()
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.nativesdk.common.model.PaymentIntent r1 = (net.one97.paytm.nativesdk.common.model.PaymentIntent) r1
            double r1 = r1.getConvFee()
            r0.u = r1
        L_0x0036:
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.util.ArrayList r2 = r4.getPaymentIntents()
            java.lang.String r1 = r1.a((java.lang.Object) r2)
            r0.c((java.lang.String) r1)
        L_0x0046:
            double r1 = r4.getRcf()
            r0.f70168e = r1
        L_0x004c:
            net.one97.paytm.AJRAddMoneyPaymentActivity$2 r4 = new net.one97.paytm.AJRAddMoneyPaymentActivity$2
            r4.<init>(r0, r5)
            r0.a((com.paytm.network.listener.b) r4)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJRAddMoneyPaymentActivity.doCheckout(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$CallbackData, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnCheckoutResponse):void");
    }

    public boolean isConvFeeEnabled() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("addMoneyIsConvFeeEnabled", true);
    }
}
