package com.paytm.paymentsettings.merchantSubscriptions.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.common.widget.CircularImageView;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.i.h;

public final class d extends h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43497a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private RoboTextView f43498b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f43499c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f43500d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f43501e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f43502f;

    /* renamed from: g  reason: collision with root package name */
    private RoboTextView f43503g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f43504h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f43505i;
    private RoboTextView j;
    private ImageView k;
    private ImageView l;
    private CircularImageView m;
    private ActiveSubscriptionDetailsItem n;
    private String o;
    private HashMap p;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("dataList") : null;
        if (serializable != null) {
            this.n = (ActiveSubscriptionDetailsItem) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.activity_active_subscription_detail_view, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:229:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x06a3  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x06a8  */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x0783  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.os.Bundle r11) {
        /*
            r10 = this;
            super.onActivityCreated(r11)
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            r0 = 0
            if (r11 == 0) goto L_0x0013
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_detail_name
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x0014
        L_0x0013:
            r11 = r0
        L_0x0014:
            r10.f43498b = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0025
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_detail_subscription_id
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x0026
        L_0x0025:
            r11 = r0
        L_0x0026:
            r10.f43499c = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0037
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_payment_detail
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x0038
        L_0x0037:
            r11 = r0
        L_0x0038:
            r10.f43500d = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0049
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_detail_subscription_amount
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x004a
        L_0x0049:
            r11 = r0
        L_0x004a:
            r10.f43501e = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x005b
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_detail_subscription_cycle
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x005c
        L_0x005b:
            r11 = r0
        L_0x005c:
            r10.f43502f = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x006d
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_subscription_payment_instrument_name
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x006e
        L_0x006d:
            r11 = r0
        L_0x006e:
            r10.f43503g = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x007f
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_subscription_payment_instrument_detail
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x0080
        L_0x007f:
            r11 = r0
        L_0x0080:
            r10.f43504h = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0091
            int r1 = com.paytm.paymentsettings.R.id.iv_information_merchant_subscription
            android.view.View r11 = r11.findViewById(r1)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            goto L_0x0092
        L_0x0091:
            r11 = r0
        L_0x0092:
            r10.f43505i = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x00a3
            int r1 = com.paytm.paymentsettings.R.id.tv_merchant_subscription_cancel
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r11 = (com.paytm.utility.RoboTextView) r11
            goto L_0x00a4
        L_0x00a3:
            r11 = r0
        L_0x00a4:
            r10.j = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x00b5
            int r1 = com.paytm.paymentsettings.R.id.iv_merchant_subscription_payment_instrument_detail_logo
            android.view.View r11 = r11.findViewById(r1)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            goto L_0x00b6
        L_0x00b5:
            r11 = r0
        L_0x00b6:
            r10.k = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x00c7
            int r1 = com.paytm.paymentsettings.R.id.iv_merchant_detail_logo
            android.view.View r11 = r11.findViewById(r1)
            com.paytm.paymentsettings.common.widget.CircularImageView r11 = (com.paytm.paymentsettings.common.widget.CircularImageView) r11
            goto L_0x00c8
        L_0x00c7:
            r11 = r0
        L_0x00c8:
            r10.m = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x00d9
            int r1 = com.paytm.paymentsettings.R.id.iv_back_arrow_asd
            android.view.View r11 = r11.findViewById(r1)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            goto L_0x00da
        L_0x00d9:
            r11 = r0
        L_0x00da:
            r10.l = r11
            android.widget.ImageView r11 = r10.l
            if (r11 == 0) goto L_0x00e6
            r1 = r10
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r11.setOnClickListener(r1)
        L_0x00e6:
            android.widget.ImageView r11 = r10.f43505i
            if (r11 == 0) goto L_0x00f0
            r1 = r10
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r11.setOnClickListener(r1)
        L_0x00f0:
            com.paytm.utility.RoboTextView r11 = r10.j
            if (r11 == 0) goto L_0x00fa
            r1 = r10
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r11.setOnClickListener(r1)
        L_0x00fa:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0813
            if (r11 == 0) goto L_0x0105
            java.lang.String r11 = r11.getMerchantName()
            goto L_0x0106
        L_0x0105:
            r11 = r0
        L_0x0106:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0121
            com.paytm.utility.RoboTextView r11 = r10.f43498b
            if (r11 == 0) goto L_0x0121
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x011b
            java.lang.String r1 = r1.getMerchantName()
            goto L_0x011c
        L_0x011b:
            r1 = r0
        L_0x011c:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r11.setText(r1)
        L_0x0121:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x012a
            java.lang.String r11 = r11.getSubscriptionId()
            goto L_0x012b
        L_0x012a:
            r11 = r0
        L_0x012b:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            r1 = 1
            r2 = 0
            if (r11 != 0) goto L_0x0152
            com.paytm.utility.RoboTextView r11 = r10.f43499c
            if (r11 == 0) goto L_0x0152
            int r3 = com.paytm.paymentsettings.R.string.id
            java.lang.Object[] r4 = new java.lang.Object[r1]
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r5 = r10.n
            if (r5 == 0) goto L_0x0146
            java.lang.String r5 = r5.getSubscriptionId()
            goto L_0x0147
        L_0x0146:
            r5 = r0
        L_0x0147:
            r4[r2] = r5
            java.lang.String r3 = r10.getString(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r11.setText(r3)
        L_0x0152:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x015b
            java.lang.String r11 = r11.getSubscriptionAmount()
            goto L_0x015c
        L_0x015b:
            r11 = r0
        L_0x015c:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r3 = ""
            if (r11 != 0) goto L_0x0303
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x016f
            java.lang.String r11 = r11.getSubscriptionAmount()
            goto L_0x0170
        L_0x016f:
            r11 = r0
        L_0x0170:
            java.lang.String r11 = com.paytm.utility.b.T((java.lang.String) r11)
            java.lang.String r4 = "CJRAppCommonUtility.pric…Item?.subscriptionAmount)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = com.paytm.paymentsettings.R.string.rupees
            java.lang.String r5 = r10.getString(r5)
            r4.append(r5)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r5 = r10.n
            if (r5 == 0) goto L_0x0197
            java.lang.String r5 = r5.getSubscriptionAmount()
            goto L_0x0198
        L_0x0197:
            r5 = r0
        L_0x0198:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x02c8
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r5 = r10.n
            if (r5 == 0) goto L_0x01a9
            java.lang.String r5 = r5.getNextRenewalDate()
            goto L_0x01aa
        L_0x01a9:
            r5 = r0
        L_0x01aa:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x01c2
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r5 = r10.n
            if (r5 == 0) goto L_0x01bb
            java.lang.String r5 = r5.getNextRenewalDate()
            goto L_0x01bc
        L_0x01bb:
            r5 = r0
        L_0x01bc:
            if (r5 != 0) goto L_0x01c3
            kotlin.g.b.k.a()
            goto L_0x01c3
        L_0x01c2:
            r5 = r3
        L_0x01c3:
            r10.getContext()
            int r6 = com.paytm.paymentsettings.R.string.date_output_format_details
            java.lang.String r6 = r10.getString(r6)
            int r7 = com.paytm.paymentsettings.R.string.date_output_format
            java.lang.String r7 = r10.getString(r7)
            java.lang.String r5 = com.paytm.utility.b.b((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7)
            java.lang.String r6 = "CJRAppCommonUtility.form…put_format)\n            )"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r6 = r10.n
            if (r6 == 0) goto L_0x01e4
            java.lang.String r6 = r6.getSubscriptionAmountType()
            goto L_0x01e5
        L_0x01e4:
            r6 = r0
        L_0x01e5:
            java.lang.String r7 = "VARIABLE"
            boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r2)
            java.lang.String r7 = "context?.resources!!.get…ate\n                    )"
            r8 = 2
            if (r6 == 0) goto L_0x0262
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x022e
            android.content.Context r6 = r10.getContext()
            if (r6 == 0) goto L_0x0204
            android.content.res.Resources r6 = r6.getResources()
            goto L_0x0205
        L_0x0204:
            r6 = r0
        L_0x0205:
            if (r6 != 0) goto L_0x020a
            kotlin.g.b.k.a()
        L_0x020a:
            int r9 = com.paytm.paymentsettings.R.string.subscription_payment_date_upto
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r2] = r11
            r8[r1] = r5
            java.lang.String r11 = r6.getString(r9, r8)
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            com.paytm.utility.RoboTextView r5 = r10.f43501e
            if (r5 == 0) goto L_0x02be
            int r6 = com.paytm.paymentsettings.R.string.subscription_amount_upto
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r7[r2] = r4
            java.lang.String r4 = r10.getString(r6, r7)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
            goto L_0x02be
        L_0x022e:
            android.content.Context r5 = r10.getContext()
            if (r5 == 0) goto L_0x0239
            android.content.res.Resources r5 = r5.getResources()
            goto L_0x023a
        L_0x0239:
            r5 = r0
        L_0x023a:
            if (r5 != 0) goto L_0x023f
            kotlin.g.b.k.a()
        L_0x023f:
            int r6 = com.paytm.paymentsettings.R.string.subscription_payment_date_non_renewal
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r7[r2] = r11
            java.lang.String r11 = r5.getString(r6, r7)
            java.lang.String r5 = "context?.resources!!.get…             paymentText)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            com.paytm.utility.RoboTextView r5 = r10.f43501e
            if (r5 == 0) goto L_0x02be
            int r6 = com.paytm.paymentsettings.R.string.subscription_amount_upto
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r7[r2] = r4
            java.lang.String r4 = r10.getString(r6, r7)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
            goto L_0x02be
        L_0x0262:
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0295
            android.content.Context r6 = r10.getContext()
            if (r6 == 0) goto L_0x0276
            android.content.res.Resources r6 = r6.getResources()
            goto L_0x0277
        L_0x0276:
            r6 = r0
        L_0x0277:
            if (r6 != 0) goto L_0x027c
            kotlin.g.b.k.a()
        L_0x027c:
            int r9 = com.paytm.paymentsettings.R.string.subscription_payment_date
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r2] = r11
            r8[r1] = r5
            java.lang.String r11 = r6.getString(r9, r8)
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r7)
            com.paytm.utility.RoboTextView r5 = r10.f43501e
            if (r5 == 0) goto L_0x02be
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
            goto L_0x02be
        L_0x0295:
            android.content.Context r5 = r10.getContext()
            if (r5 == 0) goto L_0x02a0
            android.content.res.Resources r5 = r5.getResources()
            goto L_0x02a1
        L_0x02a0:
            r5 = r0
        L_0x02a1:
            if (r5 != 0) goto L_0x02a6
            kotlin.g.b.k.a()
        L_0x02a6:
            int r6 = com.paytm.paymentsettings.R.string.subscription_payment_date_non_renewal
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r7[r2] = r11
            java.lang.String r11 = r5.getString(r6, r7)
            java.lang.String r5 = "context?.resources!!.get…xt\n\n                    )"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            com.paytm.utility.RoboTextView r5 = r10.f43501e
            if (r5 == 0) goto L_0x02be
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
        L_0x02be:
            com.paytm.utility.RoboTextView r4 = r10.f43500d
            if (r4 == 0) goto L_0x030e
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r4.setText(r11)
            goto L_0x030e
        L_0x02c8:
            int r11 = com.paytm.paymentsettings.R.string.subscription_payment_date_missing
            java.lang.Object[] r5 = new java.lang.Object[r1]
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r6 = r10.n
            if (r6 == 0) goto L_0x02d5
            java.lang.String r6 = r6.getSubscriptionAmount()
            goto L_0x02d6
        L_0x02d5:
            r6 = r0
        L_0x02d6:
            java.lang.String r6 = com.paytm.utility.b.T((java.lang.String) r6)
            r5[r2] = r6
            java.lang.String r11 = r10.getString(r11, r5)
            java.lang.String r5 = "getString(\n             …tionAmount)\n            )"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            com.paytm.utility.RoboTextView r11 = r10.f43501e
            if (r11 == 0) goto L_0x02f8
            int r5 = com.paytm.paymentsettings.R.string.subscription_amount_upto
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r4
            java.lang.String r4 = r10.getString(r5, r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11.setText(r4)
        L_0x02f8:
            com.paytm.utility.RoboTextView r11 = r10.f43500d
            if (r11 == 0) goto L_0x030e
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11.setText(r4)
            goto L_0x030e
        L_0x0303:
            com.paytm.utility.RoboTextView r11 = r10.f43500d
            if (r11 == 0) goto L_0x030e
            java.lang.String r4 = r10.o
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11.setText(r4)
        L_0x030e:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0317
            java.lang.String r11 = r11.getFrequencyUnit()
            goto L_0x0318
        L_0x0317:
            r11 = r0
        L_0x0318:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x041e
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x032d
            int r11 = r11.getFrequency()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x032e
        L_0x032d:
            r11 = r0
        L_0x032e:
            if (r11 != 0) goto L_0x0333
            kotlin.g.b.k.a()
        L_0x0333:
            int r11 = r11.intValue()
            long r4 = (long) r11
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0341
            java.lang.String r11 = r11.getFrequencyUnit()
            goto L_0x0342
        L_0x0341:
            r11 = r0
        L_0x0342:
            com.paytm.utility.RoboTextView r6 = r10.f43502f
            if (r6 == 0) goto L_0x0349
            r6.setVisibility(r2)
        L_0x0349:
            r6 = 0
            java.lang.String r8 = "ONDEMAND"
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x03ea
            if (r11 != 0) goto L_0x0356
            kotlin.g.b.k.a()
        L_0x0356:
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x035e
            goto L_0x03ea
        L_0x035e:
            java.lang.String r6 = "BI_MONTHLY"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0373
            int r4 = com.paytm.paymentsettings.R.string.subscription_frequency_cycle_bi_monthly
            java.lang.String r4 = r10.getString(r4)
            java.lang.String r5 = "getString(\n             …_bi_monthly\n            )"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            goto L_0x03f5
        L_0x0373:
            java.lang.String r6 = "SEMI_ANNUALLY"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0388
            int r4 = com.paytm.paymentsettings.R.string.subscription_frequency_cycle_semi_annually
            java.lang.String r4 = r10.getString(r4)
            java.lang.String r5 = "getString(\n             …mi_annually\n            )"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            goto L_0x03f5
        L_0x0388:
            r6 = 1
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x03c8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r5 = r10.n
            if (r5 == 0) goto L_0x03a0
            int r5 = r5.getFrequency()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x03a1
        L_0x03a0:
            r5 = r0
        L_0x03a1:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r4.append(r5)
            java.lang.String r5 = " "
            r4.append(r5)
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r5 = r10.n
            if (r5 == 0) goto L_0x03b6
            java.lang.String r5 = r5.getFrequencyUnit()
            goto L_0x03b7
        L_0x03b6:
            r5 = r0
        L_0x03b7:
            java.lang.String r5 = com.paytm.utility.b.A((java.lang.String) r5)
            r4.append(r5)
            java.lang.String r5 = "s"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x03f5
        L_0x03c8:
            if (r9 != 0) goto L_0x03de
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r4 = r10.n
            if (r4 == 0) goto L_0x03d3
            java.lang.String r4 = r4.getFrequencyUnit()
            goto L_0x03d4
        L_0x03d3:
            r4 = r0
        L_0x03d4:
            java.lang.String r4 = com.paytm.utility.b.A((java.lang.String) r4)
            java.lang.String r5 = "CJRAppCommonUtility.toCa…etailItem?.frequencyUnit)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            goto L_0x03f5
        L_0x03de:
            com.paytm.utility.RoboTextView r4 = r10.f43502f
            if (r4 == 0) goto L_0x03e8
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
        L_0x03e8:
            r4 = r3
            goto L_0x03f5
        L_0x03ea:
            int r4 = com.paytm.paymentsettings.R.string.subscription_frequency_cycle_on_demand
            java.lang.String r4 = r10.getString(r4)
            java.lang.String r5 = "getString(\n             …e_on_demand\n            )"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
        L_0x03f5:
            if (r11 != 0) goto L_0x03fa
            kotlin.g.b.k.a()
        L_0x03fa:
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r8)
            if (r11 == 0) goto L_0x040a
            com.paytm.utility.RoboTextView r11 = r10.f43502f
            if (r11 == 0) goto L_0x0429
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11.setText(r4)
            goto L_0x0429
        L_0x040a:
            com.paytm.utility.RoboTextView r11 = r10.f43502f
            if (r11 == 0) goto L_0x0429
            int r5 = com.paytm.paymentsettings.R.string.subscription_frequency_cycle
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r4
            java.lang.String r4 = r10.getString(r5, r6)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11.setText(r4)
            goto L_0x0429
        L_0x041e:
            com.paytm.utility.RoboTextView r11 = r10.f43502f
            if (r11 == 0) goto L_0x0429
            java.lang.String r4 = r10.o
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11.setText(r4)
        L_0x0429:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0432
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            goto L_0x0433
        L_0x0432:
            r11 = r0
        L_0x0433:
            if (r11 == 0) goto L_0x07e2
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0444
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x0444
            java.lang.String r11 = r11.getPaymode()
            goto L_0x0445
        L_0x0444:
            r11 = r0
        L_0x0445:
            r10.a((boolean) r1)
            java.lang.String r4 = "PPI"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r4)
            if (r4 != 0) goto L_0x078f
            java.lang.String r4 = "NORMAL"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x045a
            goto L_0x078f
        L_0x045a:
            java.lang.String r4 = "PPBL"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x04a1
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x049c
            com.paytm.utility.RoboTextView r1 = r10.f43504h
            if (r1 == 0) goto L_0x047d
            if (r11 == 0) goto L_0x0477
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsCustomerDetails r11 = r11.getCustomerDetails()
            if (r11 == 0) goto L_0x0477
            java.lang.String r11 = r11.getCustomerMobile()
            goto L_0x0478
        L_0x0477:
            r11 = r0
        L_0x0478:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
        L_0x047d:
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x0486
            int r1 = com.paytm.paymentsettings.R.drawable.ic_ppb
            r11.setImageResource(r1)
        L_0x0486:
            int r11 = com.paytm.paymentsettings.R.string.paytm_payment_bank
            java.lang.String r11 = r10.getString(r11)
            java.lang.String r1 = "getString(R.string.paytm_payment_bank)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            com.paytm.utility.RoboTextView r1 = r10.f43503g
            if (r1 == 0) goto L_0x07e5
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
            goto L_0x07e5
        L_0x049c:
            r10.a((boolean) r2)
            goto L_0x07e5
        L_0x04a1:
            int r4 = com.paytm.paymentsettings.R.string.subscription_paymode_dc
            java.lang.String r4 = r10.getString(r4)
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r4)
            r5 = 8
            if (r4 != 0) goto L_0x05ae
            int r4 = com.paytm.paymentsettings.R.string.subscription_paymode_cc
            java.lang.String r4 = r10.getString(r4)
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x04bd
            goto L_0x05ae
        L_0x04bd:
            java.lang.String r1 = "BANK_MANDATE"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x057d
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x04cc
            r11.getSubsPaymentInstDetails()
        L_0x04cc:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x04dc
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x04dc
            java.lang.String r11 = r11.getIssuingBank()
            if (r11 != 0) goto L_0x04dd
        L_0x04dc:
            r11 = r3
        L_0x04dd:
            java.lang.String r11 = a((java.lang.String) r11)
            com.paytm.utility.RoboTextView r1 = r10.f43503g
            if (r1 == 0) goto L_0x04ea
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
        L_0x04ea:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x04f9
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x04f9
            java.lang.String r11 = r11.getMaskedAccountNumber()
            goto L_0x04fa
        L_0x04f9:
            r11 = r0
        L_0x04fa:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x051c
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0511
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x0511
            java.lang.String r11 = r11.getMaskedAccountNumber()
            goto L_0x0512
        L_0x0511:
            r11 = r0
        L_0x0512:
            com.paytm.utility.RoboTextView r1 = r10.f43504h
            if (r1 == 0) goto L_0x0525
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
            goto L_0x0525
        L_0x051c:
            com.paytm.utility.RoboTextView r11 = r10.f43504h
            if (r11 == 0) goto L_0x0525
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r11.setText(r3)
        L_0x0525:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0534
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x0534
            java.lang.String r11 = r11.getIssuingBankLogo()
            goto L_0x0535
        L_0x0534:
            r11 = r0
        L_0x0535:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0574
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x054c
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x054c
            java.lang.String r11 = r11.getIssuingBankLogo()
            goto L_0x054d
        L_0x054c:
            r11 = r0
        L_0x054d:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x07e5
            com.squareup.picasso.w r11 = com.squareup.picasso.w.a()
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x0568
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r1 = r1.getSubsPaymentInstDetails()
            if (r1 == 0) goto L_0x0568
            java.lang.String r1 = r1.getIssuingBankLogo()
            goto L_0x0569
        L_0x0568:
            r1 = r0
        L_0x0569:
            com.squareup.picasso.aa r11 = r11.a((java.lang.String) r1)
            android.widget.ImageView r1 = r10.k
            r11.a((android.widget.ImageView) r1)
            goto L_0x07e5
        L_0x0574:
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            r11.setVisibility(r5)
            goto L_0x07e5
        L_0x057d:
            java.lang.String r1 = "UPI"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x05a9
            com.paytm.utility.RoboTextView r1 = r10.f43503g
            if (r1 == 0) goto L_0x058e
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
        L_0x058e:
            com.paytm.utility.RoboTextView r11 = r10.f43504h
            if (r11 == 0) goto L_0x07e5
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x05a1
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r1 = r1.getSubsPaymentInstDetails()
            if (r1 == 0) goto L_0x05a1
            java.lang.String r1 = r1.getMaskedVpa()
            goto L_0x05a2
        L_0x05a1:
            r1 = r0
        L_0x05a2:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r11.setText(r1)
            goto L_0x07e5
        L_0x05a9:
            r10.a((boolean) r2)
            goto L_0x07e5
        L_0x05ae:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r4 = r10.n
            if (r4 == 0) goto L_0x05bd
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r4 = r4.getSubsPaymentInstDetails()
            if (r4 == 0) goto L_0x05bd
            java.lang.String r4 = r4.getIssuingBank()
            goto L_0x05be
        L_0x05bd:
            r4 = r0
        L_0x05be:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x05ca
            int r4 = r4.length()
            if (r4 != 0) goto L_0x05c9
            goto L_0x05ca
        L_0x05c9:
            r1 = 0
        L_0x05ca:
            if (r1 != 0) goto L_0x078b
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x05dc
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r1 = r1.getSubsPaymentInstDetails()
            if (r1 == 0) goto L_0x05dc
            java.lang.String r1 = r1.getIssuingBank()
            if (r1 != 0) goto L_0x05dd
        L_0x05dc:
            r1 = r3
        L_0x05dd:
            int r4 = com.paytm.paymentsettings.R.string.subscription_paymode_cc
            java.lang.String r4 = r10.getString(r4)
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x05f0
            int r11 = com.paytm.paymentsettings.R.string.subscriptions_paymode_credit_card
            java.lang.String r11 = r10.getString(r11)
            goto L_0x0605
        L_0x05f0:
            int r4 = com.paytm.paymentsettings.R.string.subscription_paymode_dc
            java.lang.String r4 = r10.getString(r4)
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r4)
            if (r11 == 0) goto L_0x0603
            int r11 = com.paytm.paymentsettings.R.string.subscriptions_paymode_debit_card
            java.lang.String r11 = r10.getString(r11)
            goto L_0x0605
        L_0x0603:
            java.lang.String r11 = r10.o
        L_0x0605:
            java.lang.String r1 = a((java.lang.String) r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r11)
            java.lang.String r11 = r4.toString()
            com.paytm.utility.RoboTextView r1 = r10.f43503g
            if (r1 == 0) goto L_0x0621
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
        L_0x0621:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0630
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x0630
            java.lang.String r11 = r11.getBin()
            goto L_0x0631
        L_0x0630:
            r11 = r0
        L_0x0631:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x068f
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x0648
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x0648
            java.lang.String r11 = r11.getLastFourDigits()
            goto L_0x0649
        L_0x0648:
            r11 = r0
        L_0x0649:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x068f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x0665
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r1 = r1.getSubsPaymentInstDetails()
            if (r1 == 0) goto L_0x0665
            java.lang.String r1 = r1.getBin()
            goto L_0x0666
        L_0x0665:
            r1 = r0
        L_0x0666:
            r11.append(r1)
            java.lang.String r1 = "XXXXXX"
            r11.append(r1)
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x067d
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r1 = r1.getSubsPaymentInstDetails()
            if (r1 == 0) goto L_0x067d
            java.lang.String r1 = r1.getLastFourDigits()
            goto L_0x067e
        L_0x067d:
            r1 = r0
        L_0x067e:
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            com.paytm.utility.RoboTextView r1 = r10.f43504h
            if (r1 == 0) goto L_0x0699
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
            goto L_0x0699
        L_0x068f:
            com.paytm.utility.RoboTextView r11 = r10.f43504h
            if (r11 == 0) goto L_0x0699
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r11.setText(r1)
        L_0x0699:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x06a8
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x06a8
            java.lang.String r11 = r11.getCardScheme()
            goto L_0x06a9
        L_0x06a8:
            r11 = r0
        L_0x06a9:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0783
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x06c1
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r11 = r11.getSubsPaymentInstDetails()
            if (r11 == 0) goto L_0x06c1
            java.lang.String r11 = r11.getCardScheme()
            if (r11 != 0) goto L_0x06c2
        L_0x06c1:
            r11 = r3
        L_0x06c2:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x06d1
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsPaymentInstrumentDetails r1 = r1.getSubsPaymentInstDetails()
            if (r1 == 0) goto L_0x06d1
            java.lang.String r1 = r1.getCardSchemeLogo()
            goto L_0x06d2
        L_0x06d1:
            r1 = r0
        L_0x06d2:
            android.widget.ImageView r3 = r10.k
            if (r3 == 0) goto L_0x06d9
            r3.setVisibility(r2)
        L_0x06d9:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x06f1
            com.squareup.picasso.w r11 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r11 = r11.a((java.lang.String) r1)
            android.widget.ImageView r1 = r10.k
            r11.a((android.widget.ImageView) r1)
            goto L_0x07e5
        L_0x06f1:
            int r1 = com.paytm.paymentsettings.R.string.subscription_paymode_card_type_visa
            java.lang.String r1 = r10.getString(r1)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0708
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            int r1 = com.paytm.paymentsettings.R.drawable.ic_visa
            r11.setImageResource(r1)
            goto L_0x07e5
        L_0x0708:
            int r1 = com.paytm.paymentsettings.R.string.subscription_paymode_card_type_master
            java.lang.String r1 = r10.getString(r1)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x071f
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            int r1 = com.paytm.paymentsettings.R.drawable.ic_mastercard
            r11.setImageResource(r1)
            goto L_0x07e5
        L_0x071f:
            int r1 = com.paytm.paymentsettings.R.string.subscription_paymode_card_type_rupay
            java.lang.String r1 = r10.getString(r1)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0736
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            int r1 = com.paytm.paymentsettings.R.drawable.ic_rupay
            r11.setImageResource(r1)
            goto L_0x07e5
        L_0x0736:
            int r1 = com.paytm.paymentsettings.R.string.subscription_paymode_card_type_amex
            java.lang.String r1 = r10.getString(r1)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x074d
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            int r1 = com.paytm.paymentsettings.R.drawable.ic_amex
            r11.setImageResource(r1)
            goto L_0x07e5
        L_0x074d:
            int r1 = com.paytm.paymentsettings.R.string.subscription_paymode_card_type_maestro
            java.lang.String r1 = r10.getString(r1)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0764
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            int r1 = com.paytm.paymentsettings.R.drawable.ic_maestro
            r11.setImageResource(r1)
            goto L_0x07e5
        L_0x0764:
            int r1 = com.paytm.paymentsettings.R.string.subscription_paymode_card_type_diners
            java.lang.String r1 = r10.getString(r1)
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r11 == 0) goto L_0x077b
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            int r1 = com.paytm.paymentsettings.R.drawable.ic_diners
            r11.setImageResource(r1)
            goto L_0x07e5
        L_0x077b:
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            r11.setVisibility(r5)
            goto L_0x07e5
        L_0x0783:
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07e5
            r11.setVisibility(r5)
            goto L_0x07e5
        L_0x078b:
            r10.a((boolean) r2)
            goto L_0x07e5
        L_0x078f:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x079e
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsCustomerDetails r11 = r11.getCustomerDetails()
            if (r11 == 0) goto L_0x079e
            java.lang.String r11 = r11.getCustomerMobile()
            goto L_0x079f
        L_0x079e:
            r11 = r0
        L_0x079f:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x07de
            com.paytm.utility.RoboTextView r11 = r10.f43504h
            if (r11 == 0) goto L_0x07c0
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x07ba
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsCustomerDetails r1 = r1.getCustomerDetails()
            if (r1 == 0) goto L_0x07ba
            java.lang.String r1 = r1.getCustomerMobile()
            goto L_0x07bb
        L_0x07ba:
            r1 = r0
        L_0x07bb:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r11.setText(r1)
        L_0x07c0:
            android.widget.ImageView r11 = r10.k
            if (r11 == 0) goto L_0x07c9
            int r1 = com.paytm.paymentsettings.R.drawable.ic_wallet
            r11.setImageResource(r1)
        L_0x07c9:
            int r11 = com.paytm.paymentsettings.R.string.paytm_wallet
            java.lang.String r11 = r10.getString(r11)
            java.lang.String r1 = "getString(R.string.paytm_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            com.paytm.utility.RoboTextView r1 = r10.f43503g
            if (r1 == 0) goto L_0x07e5
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
            goto L_0x07e5
        L_0x07de:
            r10.a((boolean) r2)
            goto L_0x07e5
        L_0x07e2:
            r10.a((boolean) r2)
        L_0x07e5:
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r11 = r10.n
            if (r11 == 0) goto L_0x07ee
            java.lang.String r11 = r11.getMerchantLogo()
            goto L_0x07ef
        L_0x07ee:
            r11 = r0
        L_0x07ef:
            boolean r11 = android.webkit.URLUtil.isValidUrl(r11)
            if (r11 == 0) goto L_0x081b
            com.squareup.picasso.w r11 = com.squareup.picasso.w.a()
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = r10.n
            if (r1 == 0) goto L_0x0801
            java.lang.String r0 = r1.getMerchantLogo()
        L_0x0801:
            com.squareup.picasso.aa r11 = r11.a((java.lang.String) r0)
            int r0 = com.paytm.paymentsettings.R.drawable.img_no_active_subscriptions
            com.squareup.picasso.aa r11 = r11.a((int) r0)
            com.paytm.paymentsettings.common.widget.CircularImageView r0 = r10.m
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r11.a((android.widget.ImageView) r0)
            return
        L_0x0813:
            java.lang.String.valueOf(r10)
            java.lang.String r11 = "No Subscription Found"
            com.paytm.utility.q.d(r11)
        L_0x081b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.view.d.onActivityCreated(android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        r3 = r3.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r3) {
        /*
            r2 = this;
            java.lang.String r0 = "v"
            kotlin.g.b.k.c(r3, r0)
            int r3 = r3.getId()
            int r0 = com.paytm.paymentsettings.R.id.iv_information_merchant_subscription
            if (r3 != r0) goto L_0x0027
            com.paytm.paymentsettings.merchantSubscriptions.view.c$a r3 = com.paytm.paymentsettings.merchantSubscriptions.view.c.f43488a
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r3 = r2.n
            if (r3 != 0) goto L_0x0017
            kotlin.g.b.k.a()
        L_0x0017:
            java.lang.String r0 = "information"
            com.paytm.paymentsettings.merchantSubscriptions.view.c r3 = com.paytm.paymentsettings.merchantSubscriptions.view.c.a.a(r3, r0)
            androidx.fragment.app.j r0 = r2.getChildFragmentManager()
            java.lang.String r1 = "information_active_subscription_fragment"
            r3.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            return
        L_0x0027:
            int r0 = com.paytm.paymentsettings.R.id.tv_merchant_subscription_cancel
            if (r3 != r0) goto L_0x0044
            com.paytm.paymentsettings.merchantSubscriptions.view.c$a r3 = com.paytm.paymentsettings.merchantSubscriptions.view.c.f43488a
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r3 = r2.n
            if (r3 != 0) goto L_0x0034
            kotlin.g.b.k.a()
        L_0x0034:
            java.lang.String r0 = "cancel"
            com.paytm.paymentsettings.merchantSubscriptions.view.c r3 = com.paytm.paymentsettings.merchantSubscriptions.view.c.a.a(r3, r0)
            androidx.fragment.app.j r0 = r2.getChildFragmentManager()
            java.lang.String r1 = "cancel_active_subscription_fragment"
            r3.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            return
        L_0x0044:
            int r0 = com.paytm.paymentsettings.R.id.iv_back_arrow_asd
            if (r3 != r0) goto L_0x0092
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x0057
            androidx.fragment.app.j r3 = r3.getSupportFragmentManager()
            if (r3 == 0) goto L_0x0057
            r3.b()
        L_0x0057:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x006c
            androidx.fragment.app.j r3 = r3.getSupportFragmentManager()
            if (r3 == 0) goto L_0x006c
            int r3 = r3.f()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x006d
        L_0x006c:
            r3 = 0
        L_0x006d:
            if (r3 != 0) goto L_0x0072
            kotlin.g.b.k.a()
        L_0x0072:
            int r3 = r3.intValue()
            r0 = 1
            if (r3 <= r0) goto L_0x0089
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x0088
            androidx.fragment.app.j r3 = r3.getSupportFragmentManager()
            if (r3 == 0) goto L_0x0088
            r3.d()
        L_0x0088:
            return
        L_0x0089:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L_0x0092
            r3.finish()
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.view.d.onClick(android.view.View):void");
    }

    private final void a(boolean z) {
        int i2 = z ? 0 : 8;
        RoboTextView roboTextView = this.f43503g;
        if (roboTextView != null) {
            roboTextView.setVisibility(i2);
        }
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setVisibility(i2);
        }
        RoboTextView roboTextView2 = this.f43504h;
        if (roboTextView2 != null) {
            roboTextView2.setVisibility(i2);
        }
    }

    private static String a(String str) {
        if (!Pattern.compile(Pattern.quote(CJRPGTransactionRequestUtils.PAYER_BANK_NAME), 2).matcher(str).find()) {
            return str + " Bank - ";
        }
        return str + " - ";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
