package net.one97.paytm.nativesdk.transactionsummary;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.y;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.Details;
import net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse;
import net.one97.paytm.nativesdk.transcation.PayUtility;

public final class TxnSummaryActivity extends PaytmActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public TxnSummaryResponse mTxnStatusResponse;
    private TxnSummaryVM vModel;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_subscription_payment_status);
        Application application = getApplication();
        k.a((Object) application, "this.application");
        ai a2 = new al((ao) this, (al.b) new TxnSummaryVmFactory(application, PaymentRepository.Companion.getInstance(this))).a(TxnSummaryVM.class);
        k.a((Object) a2, "ViewModelProvider(this, …TxnSummaryVM::class.java)");
        this.vModel = (TxnSummaryVM) a2;
        registerObserver();
        initUI();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01a3, code lost:
        if (android.text.TextUtils.isEmpty(r0.getNextPaymentValue()) == false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001a, code lost:
        r1 = (r1 = r1.getBody()).getMerchantDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initUI() {
        /*
            r7 = this;
            net.one97.paytm.nativesdk.MerchantBL r0 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r2 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r1 = r1.getCjPayMethodResponse()
            r3 = 0
            if (r1 == 0) goto L_0x0025
            net.one97.paytm.nativesdk.common.model.Body r1 = r1.getBody()
            if (r1 == 0) goto L_0x0025
            net.one97.paytm.nativesdk.common.model.MerchantDetails r1 = r1.getMerchantDetails()
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.getMerchantLogo()
            goto L_0x0026
        L_0x0025:
            r1 = r3
        L_0x0026:
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r4 = r4.getCjPayMethodResponse()
            if (r4 == 0) goto L_0x0044
            net.one97.paytm.nativesdk.common.model.Body r4 = r4.getBody()
            if (r4 == 0) goto L_0x0044
            net.one97.paytm.nativesdk.common.model.MerchantDetails r4 = r4.getMerchantDetails()
            if (r4 == 0) goto L_0x0044
            java.lang.String r4 = r4.getMerchantName()
            goto L_0x0045
        L_0x0044:
            r4 = r3
        L_0x0045:
            int r5 = net.one97.paytm.nativesdk.R.id.tv_paid_successfully_to_merchant_asps
            android.view.View r5 = r7._$_findCachedViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.String r6 = "tv_paid_successfully_to_merchant_asps"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
            int r4 = net.one97.paytm.nativesdk.R.id.tv_order_id_asps
            android.view.View r4 = r7._$_findCachedViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r5 = "tv_order_id_asps"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Order ID "
            r5.<init>(r6)
            java.lang.String r6 = "this"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            java.lang.String r0 = r0.getOrderId()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00a7
            net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader.getFallBackMerchantLogoUrl()
            android.content.Context r0 = r7.getBaseContext()
            com.bumptech.glide.i r0 = com.bumptech.glide.b.b(r0)
            com.bumptech.glide.h r0 = r0.a((java.lang.String) r1)
            int r1 = net.one97.paytm.nativesdk.R.id.iv_merchant_logo_asps
            android.view.View r1 = r7._$_findCachedViewById(r1)
            net.one97.paytm.nativesdk.Utils.CircleImageView r1 = (net.one97.paytm.nativesdk.Utils.CircleImageView) r1
            r0.a((android.widget.ImageView) r1)
            goto L_0x00be
        L_0x00a7:
            android.content.Context r0 = r7.getBaseContext()
            com.bumptech.glide.i r0 = com.bumptech.glide.b.b(r0)
            com.bumptech.glide.h r0 = r0.a((java.lang.String) r1)
            int r1 = net.one97.paytm.nativesdk.R.id.iv_merchant_logo_asps
            android.view.View r1 = r7._$_findCachedViewById(r1)
            net.one97.paytm.nativesdk.Utils.CircleImageView r1 = (net.one97.paytm.nativesdk.Utils.CircleImageView) r1
            r0.a((android.widget.ImageView) r1)
        L_0x00be:
            int r0 = net.one97.paytm.nativesdk.R.id.tv_amount_paid_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_amount_paid_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "₹ "
            r1.<init>(r4)
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r5 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getAmount()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            if (r0 == 0) goto L_0x00ff
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            goto L_0x0100
        L_0x00ff:
            r0 = r3
        L_0x0100:
            if (r0 == 0) goto L_0x01fd
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            java.lang.String r1 = "DirectPaymentBL.getInstance().cjPayMethodResponse"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            java.lang.String r4 = "DirectPaymentBL.getInsta….cjPayMethodResponse.body"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo r0 = r0.getSubscriptionDetailsInfo()
            if (r0 == 0) goto L_0x01fa
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo r0 = r0.getSubscriptionDetailsInfo()
            java.lang.String r5 = "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.nativesdk.common.model.Details r0 = r0.getDetails()
            if (r0 == 0) goto L_0x01f6
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo r0 = r0.getSubscriptionDetailsInfo()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.nativesdk.common.model.Details r0 = r0.getDetails()
            java.lang.String r6 = "DirectPaymentBL.getInsta…iptionDetailsInfo.details"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            java.lang.String r0 = r0.getFrequencyValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01a5
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo r0 = r0.getSubscriptionDetailsInfo()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.nativesdk.common.model.Details r0 = r0.getDetails()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            java.lang.String r0 = r0.getNextPaymentValue()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01fa
        L_0x01a5:
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x01ca
            net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo r0 = r0.getSubscriptionDetailsInfo()
            if (r0 == 0) goto L_0x01ca
            net.one97.paytm.nativesdk.common.model.Details r0 = r0.getDetails()
            if (r0 == 0) goto L_0x01ca
            java.lang.String r0 = r0.getFrequencyValue()
            goto L_0x01cb
        L_0x01ca:
            r0 = r3
        L_0x01cb:
            r7.handleFrequencyWidget(r0)
            net.one97.paytm.nativesdk.DirectPaymentBL r0 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r0 = r0.getCjPayMethodResponse()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.nativesdk.common.model.Body r0 = r0.getBody()
            if (r0 == 0) goto L_0x01f2
            net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo r0 = r0.getSubscriptionDetailsInfo()
            if (r0 == 0) goto L_0x01f2
            net.one97.paytm.nativesdk.common.model.Details r0 = r0.getDetails()
            if (r0 == 0) goto L_0x01f2
            java.lang.String r3 = r0.getNextPaymentValue()
        L_0x01f2:
            r7.handleNextPaymentWidet(r3)
            goto L_0x01fd
        L_0x01f6:
            r7.hideSubsDetailWidget()
            goto L_0x01fd
        L_0x01fa:
            r7.hideSubsDetailWidget()
        L_0x01fd:
            int r0 = net.one97.paytm.nativesdk.R.id.iv_passbook_forward_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$2 r1 = new net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$2
            r1.<init>(r7)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_view_passbook_title_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$3 r1 = new net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$3
            r1.<init>(r7)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_need_help_title_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$4 r1 = new net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$4
            r1.<init>(r7)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.iv_back_arrow_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$5 r1 = new net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$5
            r1.<init>(r7)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.iv_share_icon_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$6 r1 = new net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$initUI$6
            r1.<init>(r7)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity.initUI():void");
    }

    /* access modifiers changed from: private */
    public final void closeSdk() {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().onTransactionResponse((Bundle) null);
        }
        PayUtility.killBroadcast(this);
        finish();
    }

    private final void handlePassBookWidget(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        if (str.equals("PPI") || str.equals(SDKConstants.AI_KEY_PPBL)) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_view_passbook_title_asps);
            k.a((Object) textView, "tv_view_passbook_title_asps");
            textView.setVisibility(0);
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_passbook_forward_asps);
            k.a((Object) imageView, "iv_passbook_forward_asps");
            imageView.setVisibility(0);
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.iv_passbok_asps);
            k.a((Object) imageView2, "iv_passbok_asps");
            imageView2.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(R.id.v_balance_divider_asps);
            k.a((Object) _$_findCachedViewById, "v_balance_divider_asps");
            _$_findCachedViewById.setVisibility(0);
        }
    }

    private final void handleNextPaymentWidet(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_next_payment_due_on_asps);
            k.a((Object) textView, "tv_next_payment_due_on_asps");
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance.getCjPayMethodResponse();
            k.a((Object) cjPayMethodResponse, "DirectPaymentBL.getInstance().cjPayMethodResponse");
            Body body = cjPayMethodResponse.getBody();
            k.a((Object) body, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
            SubscriptionDetailsInfo subscriptionDetailsInfo = body.getSubscriptionDetailsInfo();
            k.a((Object) subscriptionDetailsInfo, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
            Details details = subscriptionDetailsInfo.getDetails();
            k.a((Object) details, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
            textView.setText(details.getNextPaymentKey());
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_next_payment_date_asps);
            k.a((Object) textView2, "tv_next_payment_date_asps");
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse2 = instance2.getCjPayMethodResponse();
            k.a((Object) cjPayMethodResponse2, "DirectPaymentBL.getInstance().cjPayMethodResponse");
            Body body2 = cjPayMethodResponse2.getBody();
            k.a((Object) body2, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
            SubscriptionDetailsInfo subscriptionDetailsInfo2 = body2.getSubscriptionDetailsInfo();
            k.a((Object) subscriptionDetailsInfo2, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
            Details details2 = subscriptionDetailsInfo2.getDetails();
            k.a((Object) details2, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
            textView2.setText(details2.getNextPaymentValue());
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_next_payment_due_on_asps);
        k.a((Object) textView3, "tv_next_payment_due_on_asps");
        textView3.setVisibility(8);
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.tv_next_payment_date_asps);
        k.a((Object) textView4, "tv_next_payment_date_asps");
        textView4.setVisibility(8);
    }

    private final void handleFrequencyWidget(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_subscription_frequency_asps);
            k.a((Object) textView, "tv_subscription_frequency_asps");
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse = instance.getCjPayMethodResponse();
            k.a((Object) cjPayMethodResponse, "DirectPaymentBL.getInstance().cjPayMethodResponse");
            Body body = cjPayMethodResponse.getBody();
            k.a((Object) body, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
            SubscriptionDetailsInfo subscriptionDetailsInfo = body.getSubscriptionDetailsInfo();
            k.a((Object) subscriptionDetailsInfo, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
            Details details = subscriptionDetailsInfo.getDetails();
            k.a((Object) details, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
            textView.setText(details.getFrequencyKey());
            StringBuilder sb = new StringBuilder("₹ ");
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse2 = instance2.getCjPayMethodResponse();
            k.a((Object) cjPayMethodResponse2, "DirectPaymentBL.getInstance().cjPayMethodResponse");
            Body body2 = cjPayMethodResponse2.getBody();
            k.a((Object) body2, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
            SubscriptionDetailsInfo subscriptionDetailsInfo2 = body2.getSubscriptionDetailsInfo();
            k.a((Object) subscriptionDetailsInfo2, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
            Details details2 = subscriptionDetailsInfo2.getDetails();
            k.a((Object) details2, "DirectPaymentBL.getInsta…iptionDetailsInfo.details");
            sb.append(details2.getFrequencyValue());
            String sb2 = sb.toString();
            DirectPaymentBL instance3 = DirectPaymentBL.getInstance();
            k.a((Object) instance3, "DirectPaymentBL.getInstance()");
            CJPayMethodResponse cjPayMethodResponse3 = instance3.getCjPayMethodResponse();
            k.a((Object) cjPayMethodResponse3, "DirectPaymentBL.getInstance().cjPayMethodResponse");
            Body body3 = cjPayMethodResponse3.getBody();
            k.a((Object) body3, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
            SubscriptionDetailsInfo subscriptionDetailsInfo3 = body3.getSubscriptionDetailsInfo();
            k.a((Object) subscriptionDetailsInfo3, "DirectPaymentBL.getInsta…y.subscriptionDetailsInfo");
            if (k.a((Object) subscriptionDetailsInfo3.getSubsType(), (Object) "VARIABLE")) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("upto ".concat(String.valueOf(sb2)));
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.7f), 0, 4, 33);
                CharSequence charSequence2 = sb2;
                spannableStringBuilder.setSpan(new StyleSpan(1), p.a(charSequence2, FilterPriceSliderFragment.RUPEE_SYMBOL, 0, false, 6), spannableStringBuilder.length(), 33);
                if (Build.VERSION.SDK_INT >= 28) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(Typeface.SANS_SERIF), p.a(charSequence2, FilterPriceSliderFragment.RUPEE_SYMBOL, 0, false, 6), spannableStringBuilder.length(), 33);
                } else {
                    spannableStringBuilder.setSpan(new TypefaceSpan("sans-serif-medium"), p.a(charSequence2, FilterPriceSliderFragment.RUPEE_SYMBOL, 0, false, 6), spannableStringBuilder.length(), 33);
                }
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_subscription_amount_asps);
                k.a((Object) textView2, "tv_subscription_amount_asps");
                textView2.setText(spannableStringBuilder);
                return;
            }
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_subscription_amount_asps);
            k.a((Object) textView3, "tv_subscription_amount_asps");
            textView3.setText(sb2);
            return;
        }
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.tv_subscription_frequency_asps);
        k.a((Object) textView4, "tv_subscription_frequency_asps");
        textView4.setVisibility(8);
        TextView textView5 = (TextView) _$_findCachedViewById(R.id.tv_subscription_amount_asps);
        k.a((Object) textView5, "tv_subscription_amount_asps");
        textView5.setVisibility(8);
    }

    private final void registerObserver() {
        TxnSummaryVM txnSummaryVM = this.vModel;
        if (txnSummaryVM == null) {
            k.a("vModel");
        }
        y<Boolean> loaderVisibilty = txnSummaryVM.getLoaderVisibilty();
        if (loaderVisibilty != null) {
            loaderVisibilty.observe(this, new TxnSummaryActivity$registerObserver$1(this));
        }
        TxnSummaryVM txnSummaryVM2 = this.vModel;
        if (txnSummaryVM2 == null) {
            k.a("vModel");
        }
        y<TxnSummaryResponse> responseTxnSummary = txnSummaryVM2.getResponseTxnSummary();
        if (responseTxnSummary != null) {
            responseTxnSummary.observe(this, new TxnSummaryActivity$registerObserver$2(this));
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        PayUtility.finishSdk(this, (String) null);
    }

    public final void onBackPressed() {
        super.onBackPressed();
        closeSdk();
    }

    private final void handleApiError() {
        ((ImageView) _$_findCachedViewById(R.id.iv_payment_status_asps)).setImageDrawable(getResources().getDrawable(R.drawable.ic_pending));
        Context context = this;
        ((TextView) _$_findCachedViewById(R.id.tv_payment_status_asps)).setTextColor(b.c(context, R.color.red));
        ((TextView) _$_findCachedViewById(R.id.tv_status_message_asps)).setPadding(10, 50, 10, 50);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_payment_status_asps);
        k.a((Object) textView, "tv_payment_status_asps");
        textView.setText(getString(R.string.payment_pending_subscription));
        ((TextView) _$_findCachedViewById(R.id.tv_status_message_asps)).setBackgroundColor(b.c(context, R.color.pending_color));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0042, code lost:
        r4 = r7.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handlePending(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse r7) {
        /*
            r6 = this;
            int r0 = net.one97.paytm.nativesdk.R.id.iv_payment_status_asps
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.content.res.Resources r1 = r6.getResources()
            int r2 = net.one97.paytm.nativesdk.R.drawable.ic_pending
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            r0.setImageDrawable(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_payment_status_asps
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = r6
            android.content.Context r1 = (android.content.Context) r1
            int r2 = net.one97.paytm.nativesdk.R.color.red
            int r2 = androidx.core.content.b.c(r1, r2)
            r0.setTextColor(r2)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_amount_paid_asps
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tv_amount_paid_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "₹ "
            r2.<init>(r3)
            r3 = 0
            if (r7 == 0) goto L_0x004d
            net.one97.paytm.nativesdk.transactionsummary.model.Body r4 = r7.getBody()
            if (r4 == 0) goto L_0x004d
            java.lang.String r4 = r4.getLastOrderAmount()
            goto L_0x004e
        L_0x004d:
            r4 = r3
        L_0x004e:
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_status_message_asps
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2 = 50
            r4 = 10
            r0.setPadding(r4, r2, r4, r2)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_payment_status_asps
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tv_payment_status_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r2 = net.one97.paytm.nativesdk.R.string.payment_pending_subscription
            java.lang.String r2 = r6.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            if (r7 == 0) goto L_0x0089
            net.one97.paytm.nativesdk.transactionsummary.model.Body r0 = r7.getBody()
            goto L_0x008a
        L_0x0089:
            r0 = r3
        L_0x008a:
            r6.setOrderIdText(r0)
            if (r7 == 0) goto L_0x0094
            net.one97.paytm.nativesdk.transactionsummary.model.Head r0 = r7.getHead()
            goto L_0x0095
        L_0x0094:
            r0 = r3
        L_0x0095:
            if (r0 != 0) goto L_0x009a
            kotlin.g.b.k.a()
        L_0x009a:
            java.lang.String r0 = r0.getTimestamp()
            net.one97.paytm.nativesdk.transactionsummary.model.Body r2 = r7.getBody()
            if (r2 == 0) goto L_0x00a9
            java.lang.String r2 = r2.getRespMsg()
            goto L_0x00aa
        L_0x00a9:
            r2 = r3
        L_0x00aa:
            java.lang.String r4 = "tv_status_message_asps"
            if (r2 != 0) goto L_0x00c5
            int r2 = net.one97.paytm.nativesdk.R.id.tv_status_message_asps
            android.view.View r2 = r6._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.content.res.Resources r4 = r6.getResources()
            int r5 = net.one97.paytm.nativesdk.R.string.subs_pending_text
            java.lang.String r4 = r4.getString(r5)
            goto L_0x00dc
        L_0x00c5:
            int r2 = net.one97.paytm.nativesdk.R.id.tv_status_message_asps
            android.view.View r2 = r6._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.nativesdk.transactionsummary.model.Body r4 = r7.getBody()
            if (r4 == 0) goto L_0x00db
            java.lang.String r4 = r4.getRespMsg()
            goto L_0x00dc
        L_0x00db:
            r4 = r3
        L_0x00dc:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            int r2 = net.one97.paytm.nativesdk.R.id.tv_status_message_asps
            android.view.View r2 = r6._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r4 = net.one97.paytm.nativesdk.R.color.pending_color
            int r1 = androidx.core.content.b.c(r1, r4)
            r2.setBackgroundColor(r1)
            java.lang.String r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.formatDateinMonthName(r0)
            java.lang.String r1 = "SDKUtility.formatDateinMonthName(payTimeStamp)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = net.one97.paytm.nativesdk.R.id.tv_date_time_asps
            android.view.View r1 = r6._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "tv_date_time_asps"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            net.one97.paytm.nativesdk.transactionsummary.model.Body r7 = r7.getBody()
            if (r7 == 0) goto L_0x011e
            net.one97.paytm.nativesdk.transactionsummary.model.SubsPaymentInstDetails r7 = r7.getSubsPaymentInstDetails()
            if (r7 == 0) goto L_0x011e
            java.lang.String r3 = r7.getPaymentMode()
        L_0x011e:
            r6.handlePassBookWidget(r3)
            int r7 = net.one97.paytm.nativesdk.R.id.parentView
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            java.lang.String r0 = "parentView"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r0 = 0
            r7.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity.handlePending(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0047, code lost:
        r3 = r8.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleSuccess(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse r8) {
        /*
            r7 = this;
            int r0 = net.one97.paytm.nativesdk.R.id.iv_payment_status_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.content.res.Resources r1 = r7.getResources()
            int r2 = net.one97.paytm.nativesdk.R.drawable.ic_success_icon
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)
            r0.setImageDrawable(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_payment_status_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_payment_status_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r1 = net.one97.paytm.nativesdk.R.string.subscription_payment_success
            java.lang.String r1 = r7.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_amount_paid_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_amount_paid_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "₹ "
            r1.<init>(r2)
            r2 = 0
            if (r8 == 0) goto L_0x0052
            net.one97.paytm.nativesdk.transactionsummary.model.Body r3 = r8.getBody()
            if (r3 == 0) goto L_0x0052
            java.lang.String r3 = r3.getLastOrderAmount()
            goto L_0x0053
        L_0x0052:
            r3 = r2
        L_0x0053:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            if (r8 == 0) goto L_0x0066
            net.one97.paytm.nativesdk.transactionsummary.model.Body r0 = r8.getBody()
            goto L_0x0067
        L_0x0066:
            r0 = r2
        L_0x0067:
            r7.setOrderIdText(r0)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_paid_successfully_to_merchant_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_paid_successfully_to_merchant_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            if (r8 == 0) goto L_0x0085
            net.one97.paytm.nativesdk.transactionsummary.model.Body r1 = r8.getBody()
            if (r1 == 0) goto L_0x0085
            java.lang.String r1 = r1.getMerchantName()
            goto L_0x0086
        L_0x0085:
            r1 = r2
        L_0x0086:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_status_message_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_status_message_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            kotlin.g.b.aa r1 = kotlin.g.b.aa.f47921a
            int r1 = net.one97.paytm.nativesdk.R.string.paid_succ_message
            java.lang.String r1 = r7.getString(r1)
            java.lang.String r3 = "getString(R.string.paid_succ_message)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            if (r8 == 0) goto L_0x00b6
            net.one97.paytm.nativesdk.transactionsummary.model.Body r5 = r8.getBody()
            if (r5 == 0) goto L_0x00b6
            java.lang.String r5 = r5.getMerchantName()
            goto L_0x00b7
        L_0x00b6:
            r5 = r2
        L_0x00b7:
            r6 = 0
            r4[r6] = r5
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r4, r3)
            java.lang.String r1 = java.lang.String.format(r1, r3)
            java.lang.String r3 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            if (r8 == 0) goto L_0x00d9
            net.one97.paytm.nativesdk.transactionsummary.model.Body r0 = r8.getBody()
            if (r0 == 0) goto L_0x00d9
            java.lang.String r0 = r0.getLastOrderCreationDate()
            goto L_0x00da
        L_0x00d9:
            r0 = r2
        L_0x00da:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r3 = "tv_date_time_asps"
            if (r1 != 0) goto L_0x00fb
            java.lang.String r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.formatDateinMonthName(r0)
            int r1 = net.one97.paytm.nativesdk.R.id.tv_date_time_asps
            android.view.View r1 = r7._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            goto L_0x010b
        L_0x00fb:
            int r0 = net.one97.paytm.nativesdk.R.id.tv_date_time_asps
            android.view.View r0 = r7._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r1 = 8
            r0.setVisibility(r1)
        L_0x010b:
            if (r8 == 0) goto L_0x011d
            net.one97.paytm.nativesdk.transactionsummary.model.Body r8 = r8.getBody()
            if (r8 == 0) goto L_0x011d
            net.one97.paytm.nativesdk.transactionsummary.model.SubsPaymentInstDetails r8 = r8.getSubsPaymentInstDetails()
            if (r8 == 0) goto L_0x011d
            java.lang.String r2 = r8.getPaymentMode()
        L_0x011d:
            r7.handlePassBookWidget(r2)
            int r8 = net.one97.paytm.nativesdk.R.id.parentView
            android.view.View r8 = r7._$_findCachedViewById(r8)
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            java.lang.String r0 = "parentView"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)
            r8.setVisibility(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity.handleSuccess(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse):void");
    }

    private final void setOrderIdText(net.one97.paytm.nativesdk.transactionsummary.model.Body body) {
        String orderId = body != null ? body.getOrderId() : null;
        String string = getString(R.string.native_order_id, new Object[]{orderId});
        k.a((Object) string, "getString(R.string.native_order_id, ordId)");
        CharSequence charSequence = string;
        if (orderId == null) {
            k.a();
        }
        if (p.a(charSequence, orderId, 0, false, 6) != -1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new StyleSpan(1), p.a(charSequence, orderId, 0, false, 6), spannableStringBuilder.length(), 33);
            TextView textView = (TextView) _$_findCachedViewById(R.id.tv_order_id_asps);
            k.a((Object) textView, "tv_order_id_asps");
            textView.setText(spannableStringBuilder);
        }
    }

    public final int firstIndexofsubString(String str, String str2, String str3) {
        k.c(str, "$this$firstIndexofsubString");
        if (str2 == null) {
            k.a();
        }
        int length = str2.length();
        if (str3 == null) {
            k.a();
        }
        return length - str3.length();
    }

    private final String getFormatedDate(String str) {
        Calendar instance = Calendar.getInstance(Locale.ENGLISH);
        k.a((Object) instance, "Calendar.getInstance(Locale.ENGLISH)");
        instance.setTimeInMillis(Long.parseLong(str));
        return DateFormat.format("dd-MM-yyyy hh:mm:ss", instance).toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r2 = r5.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleFailText(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse r5) {
        /*
            r4 = this;
            int r0 = net.one97.paytm.nativesdk.R.id.tv_paid_successfully_to_merchant_asps
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_paid_successfully_to_merchant_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            if (r5 == 0) goto L_0x001c
            net.one97.paytm.nativesdk.transactionsummary.model.Body r2 = r5.getBody()
            if (r2 == 0) goto L_0x001c
            java.lang.String r2 = r2.getMerchantName()
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            int r0 = net.one97.paytm.nativesdk.R.id.iv_payment_status_asps
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.content.res.Resources r2 = r4.getResources()
            int r3 = net.one97.paytm.nativesdk.R.drawable.ic_failed_icon
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            r0.setImageDrawable(r2)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_payment_status_asps
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2 = r4
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.nativesdk.R.color.red
            int r2 = androidx.core.content.b.c(r2, r3)
            r0.setTextColor(r2)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_payment_status_asps
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tv_payment_status_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r2 = net.one97.paytm.nativesdk.R.string.payment_failed_subscription
            java.lang.String r2 = r4.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            if (r5 == 0) goto L_0x006b
            net.one97.paytm.nativesdk.transactionsummary.model.Body r0 = r5.getBody()
            goto L_0x006c
        L_0x006b:
            r0 = r1
        L_0x006c:
            r4.setOrderIdText(r0)
            int r0 = net.one97.paytm.nativesdk.R.id.tv_status_message_asps
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "tv_status_message_asps"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.nativesdk.transactionsummary.model.Body r2 = r5.getBody()
            if (r2 == 0) goto L_0x0088
            java.lang.String r2 = r2.getRespMsg()
            goto L_0x0089
        L_0x0088:
            r2 = r1
        L_0x0089:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            if (r5 == 0) goto L_0x0095
            net.one97.paytm.nativesdk.transactionsummary.model.Head r0 = r5.getHead()
            goto L_0x0096
        L_0x0095:
            r0 = r1
        L_0x0096:
            if (r0 != 0) goto L_0x009b
            kotlin.g.b.k.a()
        L_0x009b:
            java.lang.String r0 = r0.getTimestamp()
            java.lang.String r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.formatDateinMonthName(r0)
            java.lang.String r2 = "SDKUtility.formatDateinMonthName(payTimeStamp)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r2 = net.one97.paytm.nativesdk.R.id.tv_date_time_asps
            android.view.View r2 = r4._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "tv_date_time_asps"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
            net.one97.paytm.nativesdk.transactionsummary.model.Body r5 = r5.getBody()
            if (r5 == 0) goto L_0x00cb
            net.one97.paytm.nativesdk.transactionsummary.model.SubsPaymentInstDetails r5 = r5.getSubsPaymentInstDetails()
            if (r5 == 0) goto L_0x00cb
            java.lang.String r1 = r5.getPaymentMode()
        L_0x00cb:
            r4.handlePassBookWidget(r1)
            int r5 = net.one97.paytm.nativesdk.R.id.parentView
            android.view.View r5 = r4._$_findCachedViewById(r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            java.lang.String r0 = "parentView"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            r0 = 0
            r5.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity.handleFailText(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse):void");
    }

    /* access modifiers changed from: private */
    public final void hideShimmer() {
        ((ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_view)).stopShimmerAnimation();
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_view);
        k.a((Object) shimmerFrameLayout, "shimmer_view");
        shimmerFrameLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showShimmer() {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_view);
        k.a((Object) shimmerFrameLayout, "shimmer_view");
        shimmerFrameLayout.setVisibility(0);
        ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) _$_findCachedViewById(R.id.shimmer_view);
        k.a((Object) shimmerFrameLayout2, "shimmer_view");
        ExtensionsKt.startAnimation(shimmerFrameLayout2);
    }

    private final void hideSubsDetailWidget() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_subscription_details_asps);
        k.a((Object) textView, "tv_subscription_details_asps");
        textView.setVisibility(8);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.v_subscription_details_asps);
        k.a((Object) _$_findCachedViewById, "v_subscription_details_asps");
        _$_findCachedViewById.setVisibility(8);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_subscription_details_asps);
        k.a((Object) textView2, "tv_subscription_details_asps");
        textView2.setVisibility(8);
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_subscription_frequency_asps);
        k.a((Object) textView3, "tv_subscription_frequency_asps");
        textView3.setVisibility(8);
        TextView textView4 = (TextView) _$_findCachedViewById(R.id.tv_subscription_amount_asps);
        k.a((Object) textView4, "tv_subscription_amount_asps");
        textView4.setVisibility(8);
        TextView textView5 = (TextView) _$_findCachedViewById(R.id.tv_next_payment_due_on_asps);
        k.a((Object) textView5, "tv_next_payment_due_on_asps");
        textView5.setVisibility(8);
        TextView textView6 = (TextView) _$_findCachedViewById(R.id.tv_next_payment_date_asps);
        k.a((Object) textView6, "tv_next_payment_date_asps");
        textView6.setVisibility(8);
    }
}
