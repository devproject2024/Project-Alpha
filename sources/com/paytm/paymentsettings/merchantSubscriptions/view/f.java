package com.paytm.paymentsettings.merchantSubscriptions.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.common.widget.CircularImageView;
import com.paytm.paymentsettings.common.widget.OtpEditText;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsCustomerDetails;
import com.paytm.utility.b;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;

public final class f extends h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f43517b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    TextView f43518a;

    /* renamed from: c  reason: collision with root package name */
    private String f43519c = "";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.paytm.paymentsettings.merchantSubscriptions.a.a f43520d;

    /* renamed from: e  reason: collision with root package name */
    private String f43521e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f43522f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f43523g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f43524h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f43525i;
    private CircularImageView j;
    private TextView k;
    private OtpEditText l;
    private TextView m;
    private Button n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private ActiveSubscriptionDetailsItem t;
    private String u;
    private HashMap v;

    public final void onCreate(Bundle bundle) {
        ActiveSubscriptionsCustomerDetails customerDetails;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        String str = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("item") : null;
        if (serializable != null) {
            this.t = (ActiveSubscriptionDetailsItem) serializable;
            Bundle arguments2 = getArguments();
            this.u = arguments2 != null ? arguments2.getString("state") : null;
            ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem = this.t;
            this.o = activeSubscriptionDetailsItem != null ? activeSubscriptionDetailsItem.getMerchantName() : null;
            ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem2 = this.t;
            this.p = activeSubscriptionDetailsItem2 != null ? activeSubscriptionDetailsItem2.getSubscriptionId() : null;
            ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem3 = this.t;
            this.q = activeSubscriptionDetailsItem3 != null ? activeSubscriptionDetailsItem3.getMerchantLogo() : null;
            ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem4 = this.t;
            this.f43521e = activeSubscriptionDetailsItem4 != null ? activeSubscriptionDetailsItem4.getNextRenewalDate() : null;
            getContext();
            this.r = b.b(this.f43521e, getString(R.string.date_output_format_details), getString(R.string.date_output_format));
            ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem5 = this.t;
            this.s = activeSubscriptionDetailsItem5 != null ? activeSubscriptionDetailsItem5.getSubscriptionAmount() : null;
            ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem6 = this.t;
            if (!(activeSubscriptionDetailsItem6 == null || (customerDetails = activeSubscriptionDetailsItem6.getCustomerDetails()) == null)) {
                str = customerDetails.getCustomerMobile();
            }
            this.f43519c = str;
            return;
        }
        throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_confirm_cancellation_subscription, viewGroup, false);
    }

    /* JADX WARNING: type inference failed for: r6v55, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onActivityCreated(r6)
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            r0 = 0
            if (r6 == 0) goto L_0x0013
            int r1 = com.paytm.paymentsettings.R.id.iv_back_arrow_csc
            android.view.View r6 = r6.findViewById(r1)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            goto L_0x0014
        L_0x0013:
            r6 = r0
        L_0x0014:
            r5.f43522f = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x0025
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_detail_name_csc
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            goto L_0x0026
        L_0x0025:
            r6 = r0
        L_0x0026:
            r5.f43523g = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x0037
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_detail_subscription_id_csc
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            goto L_0x0038
        L_0x0037:
            r6 = r0
        L_0x0038:
            r5.f43524h = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x0049
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_payment_detail_csc
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            goto L_0x004a
        L_0x0049:
            r6 = r0
        L_0x004a:
            r5.f43525i = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x005b
            int r1 = com.paytm.paymentsettings.R.id.iv_merchant_detail_logo_csc
            android.view.View r6 = r6.findViewById(r1)
            com.paytm.paymentsettings.common.widget.CircularImageView r6 = (com.paytm.paymentsettings.common.widget.CircularImageView) r6
            goto L_0x005c
        L_0x005b:
            r6 = r0
        L_0x005c:
            r5.j = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x006d
            int r1 = com.paytm.paymentsettings.R.id.tv_mobile_number_csc
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            goto L_0x006e
        L_0x006d:
            r6 = r0
        L_0x006e:
            r5.k = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x007f
            int r1 = com.paytm.paymentsettings.R.id.et_otp_csc
            android.view.View r6 = r6.findViewById(r1)
            com.paytm.paymentsettings.common.widget.OtpEditText r6 = (com.paytm.paymentsettings.common.widget.OtpEditText) r6
            goto L_0x0080
        L_0x007f:
            r6 = r0
        L_0x0080:
            r5.l = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x0091
            int r1 = com.paytm.paymentsettings.R.id.tv_otp_not_received_csc
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            goto L_0x0092
        L_0x0091:
            r6 = r0
        L_0x0092:
            r5.m = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x00a3
            int r1 = com.paytm.paymentsettings.R.id.tv_invalid_otp_csc
            android.view.View r6 = r6.findViewById(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            goto L_0x00a4
        L_0x00a3:
            r6 = r0
        L_0x00a4:
            r5.f43518a = r6
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x00b5
            int r0 = com.paytm.paymentsettings.R.id.btn_confirm_cancellation_csc
            android.view.View r6 = r6.findViewById(r0)
            r0 = r6
            android.widget.Button r0 = (android.widget.Button) r0
        L_0x00b5:
            r5.n = r0
            android.widget.ImageView r6 = r5.f43522f
            if (r6 == 0) goto L_0x00c1
            r0 = r5
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
        L_0x00c1:
            android.widget.Button r6 = r5.n
            if (r6 == 0) goto L_0x00cb
            r0 = r5
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
        L_0x00cb:
            android.widget.TextView r6 = r5.m
            if (r6 == 0) goto L_0x00d5
            r0 = r5
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
        L_0x00d5:
            android.widget.TextView r6 = r5.m
            if (r6 == 0) goto L_0x00e4
            java.lang.String r0 = "Didn’t receive OTP?  <font color=#00b9f5>Request Another OTP </font>"
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
        L_0x00e4:
            java.lang.String r6 = r5.o
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00f9
            android.widget.TextView r6 = r5.f43523g
            if (r6 == 0) goto L_0x00f9
            java.lang.String r0 = r5.o
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
        L_0x00f9:
            java.lang.String r6 = r5.q
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x011a
            com.squareup.picasso.w r6 = com.squareup.picasso.w.a()
            java.lang.String r0 = r5.q
            com.squareup.picasso.aa r6 = r6.a((java.lang.String) r0)
            int r0 = com.paytm.paymentsettings.R.drawable.img_no_active_subscriptions
            com.squareup.picasso.aa r6 = r6.a((int) r0)
            com.paytm.paymentsettings.common.widget.CircularImageView r0 = r5.j
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r6.a((android.widget.ImageView) r0)
        L_0x011a:
            java.lang.String r6 = r5.s
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r0 = ""
            r1 = 0
            r2 = 1
            if (r6 != 0) goto L_0x017a
            java.lang.String r6 = r5.s
            java.lang.String r6 = com.paytm.utility.b.T((java.lang.String) r6)
            java.lang.String r3 = "CJRAppCommonUtility.priceToString(mAmount)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            java.lang.String r3 = r5.r
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x015b
            int r3 = com.paytm.paymentsettings.R.string.subscription_payment_date
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r6
            java.lang.String r6 = r5.r
            r4[r2] = r6
            java.lang.String r6 = r5.getString(r3, r4)
            java.lang.String r3 = "getString(R.string.subsc…e, paymentText, mEndDate)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            android.widget.TextView r3 = r5.f43525i
            if (r3 == 0) goto L_0x0184
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
            goto L_0x0184
        L_0x015b:
            int r6 = com.paytm.paymentsettings.R.string.subscription_payment_date_missing
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = r5.s
            java.lang.String r4 = com.paytm.utility.b.T((java.lang.String) r4)
            r3[r1] = r4
            java.lang.String r6 = r5.getString(r6, r3)
            java.lang.String r3 = "getString(R.string.subsc…y.priceToString(mAmount))"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
            android.widget.TextView r3 = r5.f43525i
            if (r3 == 0) goto L_0x0184
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r3.setText(r6)
            goto L_0x0184
        L_0x017a:
            android.widget.TextView r6 = r5.f43525i
            if (r6 == 0) goto L_0x0184
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r6.setText(r3)
        L_0x0184:
            java.lang.String r6 = r5.p
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01a3
            android.widget.TextView r6 = r5.f43524h
            if (r6 == 0) goto L_0x01a3
            int r3 = com.paytm.paymentsettings.R.string.id
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = r5.p
            r2[r1] = r4
            java.lang.String r1 = r5.getString(r3, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
        L_0x01a3:
            java.lang.String r6 = r5.f43519c
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01b9
            android.widget.TextView r6 = r5.k
            if (r6 == 0) goto L_0x01b8
            java.lang.String r0 = r5.f43519c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
        L_0x01b8:
            return
        L_0x01b9:
            android.widget.TextView r6 = r5.k
            if (r6 == 0) goto L_0x01c2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.view.f.onActivityCreated(android.os.Bundle):void");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onClick(View view) {
        Editable text;
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.iv_back_arrow_csc;
        if (valueOf != null && valueOf.intValue() == i2) {
            j fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.d();
                return;
            }
            return;
        }
        int i3 = R.id.tv_otp_not_received_csc;
        if (valueOf != null && valueOf.intValue() == i3) {
            com.paytm.paymentsettings.merchantSubscriptions.a.a aVar = this.f43520d;
            if (aVar == null) {
                k.a();
            }
            aVar.f43460g = true;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((ActiveSubscriptionActivity) activity).callEditSubscriptionAPI(TransactionType.CANCEL);
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity");
        }
        int i4 = R.id.btn_confirm_cancellation_csc;
        if (valueOf != null && valueOf.intValue() == i4) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                ActiveSubscriptionActivity activeSubscriptionActivity = (ActiveSubscriptionActivity) activity2;
                String str2 = this.u;
                OtpEditText otpEditText = this.l;
                if (!(otpEditText == null || (text = otpEditText.getText()) == null)) {
                    str = text.toString();
                }
                activeSubscriptionActivity.callAuthorisedEditSubscriptionAPI(str2, str);
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.v;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
