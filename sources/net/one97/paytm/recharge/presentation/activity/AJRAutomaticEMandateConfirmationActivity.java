package net.one97.paytm.recharge.presentation.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.presentation.b.k;
import net.one97.paytm.recharge.widgets.c.h;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class AJRAutomaticEMandateConfirmationActivity extends PaytmActivity implements View.OnClickListener, net.one97.paytm.recharge.widgets.b.a {

    /* renamed from: a  reason: collision with root package name */
    private CJRPayChannelOptions f64633a;

    /* renamed from: b  reason: collision with root package name */
    private String f64634b;

    /* renamed from: c  reason: collision with root package name */
    private String f64635c;

    /* renamed from: d  reason: collision with root package name */
    private String f64636d;

    /* renamed from: e  reason: collision with root package name */
    private String f64637e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Object> f64638f;

    /* renamed from: g  reason: collision with root package name */
    private final int f64639g = IuserActions.ON_FLASHSALE_CLICK;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.recharge.presentation.g.a f64640h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.recharge.widgets.widget.a f64641i;
    private int j = 3;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public String l;
    private long m;
    private String n;
    private String o;
    private int p;
    private boolean q;
    private final int r = 6;
    /* access modifiers changed from: private */
    public k s;
    private HashMap t;

    public final View a(int i2) {
        if (this.t == null) {
            this.t = new HashMap();
        }
        View view = (View) this.t.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.t.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class f extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJROrderSummary>, x> {
        final /* synthetic */ AJRAutomaticEMandateConfirmationActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
            super(1);
            this.this$0 = aJRAutomaticEMandateConfirmationActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJROrderSummary>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJROrderSummary> bVar) {
            if (bVar != null) {
                net.one97.paytm.recharge.presentation.g.c cVar = bVar.f64955c;
                int[] iArr = b.f64712a;
                cVar.ordinal();
                CJROrderSummary cJROrderSummary = (CJROrderSummary) bVar.f64954b;
                if (cJROrderSummary != null) {
                    AJRAutomaticEMandateConfirmationActivity.a(this.this$0, cJROrderSummary);
                }
                NetworkCustomError networkCustomError = bVar.f64953a;
                if (networkCustomError != null) {
                    k a2 = this.this$0.s;
                    if (a2 != null) {
                        a2.dismissAllowingStateLoss();
                    }
                    net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                    net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this.this$0, networkCustomError, (int) IuserActions.ON_FLASHSALE_CLICK);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0205  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            int r9 = net.one97.paytm.recharge.automatic.R.layout.activity_emandate_confirmation
            r8.setContentView((int) r9)
            int r9 = net.one97.paytm.recharge.automatic.R.id.toolbar
            android.view.View r9 = r8.a((int) r9)
            androidx.appcompat.widget.Toolbar r9 = (androidx.appcompat.widget.Toolbar) r9
            r8.setSupportActionBar(r9)
            androidx.appcompat.app.ActionBar r9 = r8.getSupportActionBar()
            java.lang.String r0 = ""
            if (r9 == 0) goto L_0x0021
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r9.a((java.lang.CharSequence) r1)
        L_0x0021:
            androidx.appcompat.app.ActionBar r9 = r8.getSupportActionBar()
            r1 = 1
            if (r9 == 0) goto L_0x002b
            r9.b((boolean) r1)
        L_0x002b:
            android.content.Intent r9 = r8.getIntent()
            r2 = 0
            r3 = 0
            if (r9 == 0) goto L_0x0120
            android.content.Intent r4 = r8.getIntent()
            java.lang.String r5 = "pay_channel"
            java.io.Serializable r4 = r4.getSerializableExtra(r5)
            boolean r5 = r4 instanceof net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions
            if (r5 != 0) goto L_0x0042
            r4 = r3
        L_0x0042:
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r4 = (net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions) r4
            r8.f64633a = r4
            android.content.Intent r4 = r8.getIntent()
            java.lang.String r5 = "key_account"
            java.lang.String r4 = r4.getStringExtra(r5)
            r8.f64636d = r4
            android.content.Intent r4 = r8.getIntent()
            java.lang.String r5 = "key_ifsc_code"
            java.lang.String r4 = r4.getStringExtra(r5)
            r8.f64634b = r4
            android.content.Intent r4 = r8.getIntent()
            java.lang.String r5 = "key_account_holder_name"
            java.lang.String r4 = r4.getStringExtra(r5)
            r8.f64635c = r4
            android.content.Intent r4 = r8.getIntent()
            java.lang.String r5 = "choose_auth_mode"
            java.lang.String r4 = r4.getStringExtra(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x00b8
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r4 = r8.f64633a
            if (r4 == 0) goto L_0x0085
            java.util.ArrayList r4 = r4.getMandateAuthMode()
            goto L_0x0086
        L_0x0085:
            r4 = r3
        L_0x0086:
            if (r4 == 0) goto L_0x00c2
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r4 = r8.f64633a
            if (r4 == 0) goto L_0x0091
            java.util.ArrayList r4 = r4.getMandateAuthMode()
            goto L_0x0092
        L_0x0091:
            r4 = r3
        L_0x0092:
            if (r4 != 0) goto L_0x0097
            kotlin.g.b.k.a()
        L_0x0097:
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r1
            if (r4 == 0) goto L_0x00c2
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r4 = r8.f64633a
            if (r4 == 0) goto L_0x00a9
            java.util.ArrayList r4 = r4.getMandateAuthMode()
            goto L_0x00aa
        L_0x00a9:
            r4 = r3
        L_0x00aa:
            if (r4 != 0) goto L_0x00af
            kotlin.g.b.k.a()
        L_0x00af:
            java.lang.Object r4 = r4.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r8.f64637e = r4
            goto L_0x00c2
        L_0x00b8:
            android.content.Intent r4 = r8.getIntent()
            java.lang.String r4 = r4.getStringExtra(r5)
            r8.f64637e = r4
        L_0x00c2:
            java.lang.String r4 = "e_mandate_bundle"
            boolean r5 = r9.hasExtra(r4)
            if (r5 == 0) goto L_0x00d7
            java.io.Serializable r9 = r9.getSerializableExtra(r4)
            boolean r4 = r9 instanceof java.util.HashMap
            if (r4 != 0) goto L_0x00d3
            r9 = r3
        L_0x00d3:
            java.util.HashMap r9 = (java.util.HashMap) r9
            r8.f64638f = r9
        L_0x00d7:
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r4 = "key_action"
            boolean r9 = r9.hasExtra(r4)
            if (r9 == 0) goto L_0x00ed
            android.content.Intent r9 = r8.getIntent()
            int r9 = r9.getIntExtra(r4, r2)
            r8.p = r9
        L_0x00ed:
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r4 = "ga_label_key"
            boolean r9 = r9.hasExtra(r4)
            if (r9 == 0) goto L_0x0103
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r9 = r9.getStringExtra(r4)
            r8.o = r9
        L_0x0103:
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r8.f64638f
            if (r9 == 0) goto L_0x0120
            java.lang.String r4 = "from"
            boolean r9 = r9.containsKey(r4)
            if (r9 != r1) goto L_0x0120
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r8.f64638f
            if (r9 != 0) goto L_0x0116
            kotlin.g.b.k.a()
        L_0x0116:
            java.lang.Object r9 = r9.get(r4)
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r8.n = r9
        L_0x0120:
            int r9 = net.one97.paytm.recharge.automatic.R.id.proceed_btn
            android.view.View r9 = r8.a((int) r9)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r9
            if (r9 == 0) goto L_0x0133
            int r4 = net.one97.paytm.recharge.automatic.R.string.confirm_and_proceed
            java.lang.String r4 = r8.getString(r4)
            r9.setProceedBtnText(r4)
        L_0x0133:
            int r9 = net.one97.paytm.recharge.automatic.R.id.tv_bank_account
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r4 = "tv_bank_account"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r4 = r8.f64633a
            if (r4 == 0) goto L_0x0170
            if (r4 != 0) goto L_0x0149
            kotlin.g.b.k.a()
        L_0x0149:
            java.lang.String r4 = r4.getChannelName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0170
            int r4 = net.one97.paytm.recharge.automatic.R.string.label_bankname
            java.lang.Object[] r5 = new java.lang.Object[r1]
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r6 = r8.f64633a
            if (r6 != 0) goto L_0x0160
            kotlin.g.b.k.a()
        L_0x0160:
            java.lang.String r6 = r6.getChannelName()
            r5[r2] = r6
            java.lang.String r4 = r8.getString(r4, r5)
            java.lang.String r5 = "getString(R.string.label…nnelOption!!.channelName)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            goto L_0x0171
        L_0x0170:
            r4 = r0
        L_0x0171:
            java.lang.String r5 = r8.f64636d
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x01cf
            java.lang.String r5 = r8.f64636d
            if (r5 != 0) goto L_0x0182
            kotlin.g.b.k.a()
        L_0x0182:
            int r5 = r5.length()
            r6 = 4
            if (r5 <= r6) goto L_0x01cf
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = " XX"
            r5.append(r4)
            java.lang.String r4 = r8.f64636d
            if (r4 != 0) goto L_0x019d
            kotlin.g.b.k.a()
        L_0x019d:
            java.lang.String r7 = r8.f64636d
            if (r7 != 0) goto L_0x01a4
            kotlin.g.b.k.a()
        L_0x01a4:
            int r7 = r7.length()
            int r7 = r7 - r6
            java.lang.String r6 = r8.f64636d
            if (r6 != 0) goto L_0x01b0
            kotlin.g.b.k.a()
        L_0x01b0:
            int r6 = r6.length()
            if (r4 == 0) goto L_0x01c7
            java.lang.String r4 = r4.substring(r7, r6)
            java.lang.String r6 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x01cf
        L_0x01c7:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r9.<init>(r0)
            throw r9
        L_0x01cf:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r9.setText(r4)
            int r9 = net.one97.paytm.recharge.automatic.R.id.ifsc_code
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r4 = "ifsc_code"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            java.lang.String r4 = r8.f64634b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01fc
            int r0 = net.one97.paytm.recharge.automatic.R.string.label_ifsc_code
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r4 = r8.f64634b
            r1[r2] = r4
            java.lang.String r0 = r8.getString(r0, r1)
            java.lang.String r1 = "getString(R.string.label_ifsc_code, ifscCode)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
        L_0x01fc:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r9 = r8.f64633a
            if (r9 == 0) goto L_0x0234
            if (r9 != 0) goto L_0x020a
            kotlin.g.b.k.a()
        L_0x020a:
            java.lang.String r9 = r9.getIconUrl()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0234
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions r0 = r8.f64633a
            if (r0 != 0) goto L_0x0221
            kotlin.g.b.k.a()
        L_0x0221:
            java.lang.String r0 = r0.getIconUrl()
            com.squareup.picasso.aa r9 = r9.a((java.lang.String) r0)
            int r0 = net.one97.paytm.recharge.automatic.R.id.ic_bank_logo
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r9.a((android.widget.ImageView) r0)
        L_0x0234:
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_account_holder_name
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0245
            java.lang.String r0 = r8.f64635c
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        L_0x0245:
            int r9 = net.one97.paytm.recharge.automatic.R.id.proceed_btn
            android.view.View r9 = r8.a((int) r9)
            net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8 r9 = (net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8) r9
            if (r9 == 0) goto L_0x0255
            r0 = r8
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
        L_0x0255:
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            java.lang.String r0 = "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEATESTDEAL4D2C244AF/150.png"
            com.squareup.picasso.aa r9 = r9.a((java.lang.String) r0)
            int r0 = net.one97.paytm.recharge.automatic.R.id.nach
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r9.a((android.widget.ImageView) r0)
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            java.lang.String r0 = "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEATESTDEAL4D2C244AF/149.png"
            com.squareup.picasso.aa r9 = r9.a((java.lang.String) r0)
            int r0 = net.one97.paytm.recharge.automatic.R.id.npci
            android.view.View r0 = r8.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r9.a((android.widget.ImageView) r0)
            r9 = r8
            androidx.fragment.app.FragmentActivity r9 = (androidx.fragment.app.FragmentActivity) r9
            net.one97.paytm.recharge.presentation.e.a r0 = new net.one97.paytm.recharge.presentation.e.a
            r0.<init>()
            androidx.lifecycle.al$b r0 = (androidx.lifecycle.al.b) r0
            androidx.lifecycle.al r9 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r9, (androidx.lifecycle.al.b) r0)
            java.lang.Class<net.one97.paytm.recharge.presentation.g.a> r0 = net.one97.paytm.recharge.presentation.g.a.class
            androidx.lifecycle.ai r9 = r9.a(r0)
            net.one97.paytm.recharge.presentation.g.a r9 = (net.one97.paytm.recharge.presentation.g.a) r9
            r8.f64640h = r9
            net.one97.paytm.recharge.presentation.g.a r9 = r8.f64640h
            if (r9 == 0) goto L_0x029d
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.common.entity.shopping.CJROrderSummary>> r3 = r9.j
        L_0x029d:
            androidx.lifecycle.LiveData r3 = (androidx.lifecycle.LiveData) r3
            net.one97.paytm.recharge.presentation.activity.AJRAutomaticEMandateConfirmationActivity$f r9 = new net.one97.paytm.recharge.presentation.activity.AJRAutomaticEMandateConfirmationActivity$f
            r9.<init>(r8)
            kotlin.g.a.b r9 = (kotlin.g.a.b) r9
            java.lang.String r0 = "$this$observeLiveData"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "body"
            kotlin.g.b.k.c(r9, r0)
            if (r3 == 0) goto L_0x02bc
            net.one97.paytm.recharge.widgets.c.c r0 = new net.one97.paytm.recharge.widgets.c.c
            r0.<init>(r9)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r3.observe(r8, r0)
        L_0x02bc:
            int r9 = net.one97.paytm.recharge.automatic.R.string.txt_proceed_info
            java.lang.String r9 = r8.getString(r9)
            java.lang.String r0 = "getString(R.string.txt_proceed_info)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.text.SpannableString r0 = new android.text.SpannableString
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r0.<init>(r9)
            net.one97.paytm.recharge.presentation.activity.AJRAutomaticEMandateConfirmationActivity$d r1 = new net.one97.paytm.recharge.presentation.activity.AJRAutomaticEMandateConfirmationActivity$d
            r1.<init>(r8)
            int r3 = net.one97.paytm.recharge.automatic.R.string.index_term
            java.lang.String r3 = r8.getString(r3)
            java.lang.String r4 = "getString(R.string.index_term)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r4 = 6
            int r9 = kotlin.m.p.a((java.lang.CharSequence) r9, (java.lang.String) r3, (int) r2, (boolean) r2, (int) r4)
            int r2 = net.one97.paytm.recharge.automatic.R.string.text_to_span
            java.lang.String r2 = r8.getString(r2)
            java.lang.String r3 = "getString(R.string.text_to_span)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            if (r9 < 0) goto L_0x0333
            int r3 = r2.length()
            int r3 = r3 + r9
            r4 = 33
            r0.setSpan(r1, r9, r3, r4)
            android.text.style.ForegroundColorSpan r1 = new android.text.style.ForegroundColorSpan
            r3 = r8
            android.content.Context r3 = (android.content.Context) r3
            int r5 = net.one97.paytm.recharge.automatic.R.color.color_00b9f5
            int r3 = androidx.core.content.b.c(r3, r5)
            r1.<init>(r3)
            int r2 = r2.length()
            int r2 = r2 + r9
            r0.setSpan(r1, r9, r2, r4)
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_note_info
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x031f
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        L_0x031f:
            int r9 = net.one97.paytm.recharge.automatic.R.id.txt_note_info
            android.view.View r9 = r8.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            java.lang.String r0 = "txt_note_info"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.text.method.MovementMethod r0 = android.text.method.LinkMovementMethod.getInstance()
            r9.setMovementMethod(r0)
        L_0x0333:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticEMandateConfirmationActivity.onCreate(android.os.Bundle):void");
    }

    public final void onClick(View view) {
        Integer num = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.proceed_btn);
        if (cJRProceedWidgetV8 != null) {
            num = Integer.valueOf(cJRProceedWidgetV8.getId());
        }
        if (!kotlin.g.b.k.a((Object) valueOf, (Object) num)) {
            int i2 = R.id.retry_button;
            if (valueOf != null && valueOf.intValue() == i2 && SystemClock.elapsedRealtime() - this.m >= 2000) {
                this.m = SystemClock.elapsedRealtime();
                if (com.paytm.utility.b.c((Context) this)) {
                    q a2 = getSupportFragmentManager().a();
                    net.one97.paytm.recharge.widgets.widget.a aVar = this.f64641i;
                    if (aVar == null) {
                        kotlin.g.b.k.a();
                    }
                    a2.a((Fragment) aVar).b();
                    FrameLayout frameLayout = (FrameLayout) a(R.id.offline_lyt_container);
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    String str = this.k;
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    a(str, this.l);
                }
            }
        } else if (!com.paytm.utility.b.c((Context) this)) {
            net.one97.paytm.recharge.automatic.c.a.a aVar2 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this, (NetworkCustomError) new h(), 0);
        } else if (view == null || !net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(view)) {
            CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) a(R.id.proceed_btn);
            if (cJRProceedWidgetV82 != null) {
                cJRProceedWidgetV82.setEnabled(false);
            }
            b();
            TextView textView = (TextView) a(R.id.txt_account_holder_name);
            if (textView != null) {
                textView.postDelayed(new e(this), 1000);
            }
            try {
                net.one97.paytm.recharge.automatic.c.a.a aVar3 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = this;
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a3 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar5 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String I = net.one97.paytm.recharge.automatic.b.a.a.L;
                String str2 = this.o;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                a.C1160a aVar6 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(context, a3, I, "", str3, net.one97.paytm.recharge.automatic.b.a.a.P, (Object) null, 64);
            } catch (Throwable unused) {
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticEMandateConfirmationActivity f64646a;

        e(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
            this.f64646a = aJRAutomaticEMandateConfirmationActivity;
        }

        public final void run() {
            AJRAutomaticEMandateConfirmationActivity.b(this.f64646a);
            k a2 = this.f64646a.s;
            if (a2 != null) {
                a2.dismissAllowingStateLoss();
            }
            AJRAutomaticEMandateConfirmationActivity.c(this.f64646a);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticEMandateConfirmationActivity f64642a;

        a(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
            this.f64642a = aJRAutomaticEMandateConfirmationActivity;
        }

        public final void run() {
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f64642a.a(R.id.proceed_btn);
            if (cJRProceedWidgetV8 != null) {
                cJRProceedWidgetV8.setEnabled(true);
            }
        }
    }

    public final void a(String str, Bundle bundle) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1600546415) {
                if (hashCode == -1588683517 && str.equals("tag.alert.order.failed")) {
                    Intent intent = new Intent();
                    intent.putExtra("is_subscription_failed", true);
                    setResult(-1, intent);
                    finish();
                }
            } else if (str.equals("tag.alert.order.pending")) {
                a(false);
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == 0) {
            k kVar = this.s;
            if (kVar != null) {
                kVar.dismissAllowingStateLoss();
            }
            Intent intent2 = new Intent();
            intent2.putExtra("is_subscription_failed", true);
            setResult(-1, intent2);
            finish();
        } else if (i2 == this.f64639g) {
            String str = null;
            this.k = intent != null ? intent.getStringExtra("intent_extra_wallet_order_id") : null;
            if (this.k == null && intent != null && intent.hasExtra("order_id")) {
                this.k = intent.getStringExtra("order_id");
            }
            if (intent != null) {
                str = intent.getStringExtra("pg_screen");
            }
            this.l = str;
            if (!TextUtils.isEmpty(this.k)) {
                String str2 = this.k;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                a(str2, this.l);
                return;
            }
            k kVar2 = this.s;
            if (kVar2 != null) {
                kVar2.dismissAllowingStateLoss();
            }
        } else if (i2 == 1012) {
            String str3 = this.k;
            if (str3 == null) {
                kotlin.g.b.k.a();
            }
            a(str3, this.l);
        }
    }

    private final void a(String str, String str2) {
        Context context = this;
        if (!com.paytm.utility.d.c(context)) {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this, (int) IuserActions.ON_FLASHSALE_CLICK);
        } else if (com.paytm.utility.b.c(context)) {
            b();
            net.one97.paytm.recharge.presentation.g.a aVar2 = this.f64640h;
            if (aVar2 != null) {
                aVar2.a(context, str, str2);
            }
        } else {
            a();
        }
    }

    private final void a() {
        this.f64641i = new net.one97.paytm.recharge.widgets.widget.a();
        net.one97.paytm.recharge.widgets.widget.a aVar = this.f64641i;
        if (aVar != null) {
            aVar.a(this);
        }
        q a2 = getSupportFragmentManager().a();
        int i2 = R.id.offline_lyt_container;
        net.one97.paytm.recharge.widgets.widget.a aVar2 = this.f64641i;
        if (aVar2 == null) {
            kotlin.g.b.k.a();
        }
        a2.a(i2, aVar2, "").e();
        FrameLayout frameLayout = (FrameLayout) a(R.id.offline_lyt_container);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticEMandateConfirmationActivity f64643a;

        b(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
            this.f64643a = aJRAutomaticEMandateConfirmationActivity;
        }

        public final void run() {
            net.one97.paytm.recharge.presentation.g.a e2;
            if (!TextUtils.isEmpty(this.f64643a.k) && com.paytm.utility.b.c((Context) this.f64643a) && (e2 = this.f64643a.f64640h) != null) {
                AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity = this.f64643a;
                Context context = aJRAutomaticEMandateConfirmationActivity;
                String d2 = aJRAutomaticEMandateConfirmationActivity.k;
                if (d2 == null) {
                    kotlin.g.b.k.a();
                }
                e2.a(context, d2, this.f64643a.l);
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticEMandateConfirmationActivity f64644a;

        c(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
            this.f64644a = aJRAutomaticEMandateConfirmationActivity;
        }

        public final void run() {
            this.f64644a.a(true);
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        Object obj;
        Intent intent = new Intent();
        intent.putExtra("isSubscribed", false);
        intent.putExtra("isPending", z);
        intent.putExtra("key_action", this.p);
        intent.putExtra("is_from_edit_emandate", true);
        intent.putExtra("is_redirect_flow", true);
        setResult(-1, intent);
        if (this.q) {
            Intent intent2 = new Intent();
            intent2.putExtra("is_refresh_needed", false);
            setResult(-1, intent2);
        } else {
            Intent intent3 = null;
            if (!p.a("manage_screen", this.n, true)) {
                intent3 = new Intent(this, AJRAutomaticSubscriptionListActivity.class);
            } else if (p.a("manage_screen", this.n, true)) {
                intent3 = new Intent(this, AJRAutomaticSubscriptionManageActivity.class);
            }
            if (intent3 != null) {
                intent3.putExtra("isSubscribed", false);
            }
            if (intent3 != null) {
                intent3.putExtra("isPending", z);
            }
            if (intent3 != null) {
                intent3.putExtra("from", this.n);
            }
            if (intent3 != null) {
                intent3.putExtra("is_redirect_flow", true);
            }
            if (intent3 != null) {
                intent3.putExtra("is_from_edit_emandate", true);
            }
            HashMap<String, Object> hashMap = this.f64638f;
            if (hashMap == null || (obj = hashMap.get("recharge_number")) == null) {
                obj = "";
            }
            kotlin.g.b.k.a(obj, "mBundle?.get(AutomaticCo…tant.RECHARGE_NUMBER)?:\"\"");
            if (intent3 != null) {
                intent3.putExtra("recharge_number", obj.toString());
            }
            if (intent3 != null) {
                intent3.addFlags(67108864);
            }
            if (intent3 != null) {
                intent3.addFlags(268435456);
            }
            startActivity(intent3);
        }
        finish();
    }

    private final void b() {
        k.a aVar = k.f64792a;
        this.s = new k();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_bank_mandate_enabled", true);
        k kVar = this.s;
        if (kVar != null) {
            kVar.setArguments(bundle);
        }
        k kVar2 = this.s;
        if (kVar2 != null) {
            kVar2.show(getSupportFragmentManager(), k.class.getSimpleName());
        }
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public static final class d extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticEMandateConfirmationActivity f64645a;

        d(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
            this.f64645a = aJRAutomaticEMandateConfirmationActivity;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "widget");
            if (!com.paytm.utility.b.c((Context) this.f64645a)) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a((Activity) this.f64645a, (NetworkCustomError) new h(), 0);
                return;
            }
            AJRAutomaticEMandateConfirmationActivity.h(this.f64645a);
        }
    }

    public static final /* synthetic */ void a(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity, CJROrderSummary cJROrderSummary) {
        String str;
        int i2;
        int orderStatus = cJROrderSummary.getOrderStatus();
        if (orderStatus == 2) {
            ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
            if (orderedCartList != null && (!orderedCartList.isEmpty())) {
                CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
                kotlin.g.b.k.a((Object) cJROrderedCart, "cjrOrderSummary.orderedCartList[0]");
                if (!kotlin.g.b.k.a((Object) "6", (Object) cJROrderedCart.getItemStatus())) {
                    CJROrderedCart cJROrderedCart2 = cJROrderSummary.getOrderedCartList().get(0);
                    kotlin.g.b.k.a((Object) cJROrderedCart2, "cjrOrderSummary.orderedCartList[0]");
                    if (!kotlin.g.b.k.a((Object) "210", (Object) cJROrderedCart2.getItemStatus()) && (i2 = aJRAutomaticEMandateConfirmationActivity.j) != 0) {
                        aJRAutomaticEMandateConfirmationActivity.j = i2 - 1;
                        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) aJRAutomaticEMandateConfirmationActivity.a(R.id.proceed_btn);
                        if (cJRProceedWidgetV8 != null) {
                            cJRProceedWidgetV8.postDelayed(new b(aJRAutomaticEMandateConfirmationActivity), 1000);
                            return;
                        }
                        return;
                    }
                }
                CJROrderedCart cJROrderedCart3 = cJROrderSummary.getOrderedCartList().get(0);
                kotlin.g.b.k.a((Object) cJROrderedCart3, "cjrOrderSummary.orderedCartList[0]");
                boolean a2 = kotlin.g.b.k.a((Object) "210", (Object) cJROrderedCart3.getItemStatus());
                k kVar = aJRAutomaticEMandateConfirmationActivity.s;
                if (kVar != null) {
                    kVar.dismissAllowingStateLoss();
                }
                if (!a2) {
                    CJROrderedCart cJROrderedCart4 = cJROrderSummary.getOrderedCartList().get(0);
                    kotlin.g.b.k.a((Object) cJROrderedCart4, "cjrOrderSummary.orderedCartList[0]");
                    String itemStatus = cJROrderedCart4.getItemStatus();
                    if (itemStatus != null && itemStatus.hashCode() == 54 && itemStatus.equals("6")) {
                        str = aJRAutomaticEMandateConfirmationActivity.getString(R.string.automatic_subscription_failed);
                        kotlin.g.b.k.a((Object) str, "getString(R.string.automatic_subscription_failed)");
                    } else {
                        str = aJRAutomaticEMandateConfirmationActivity.getString(R.string.automatic_subscription_pending);
                        kotlin.g.b.k.a((Object) str, "getString(R.string.automatic_subscription_pending)");
                    }
                    g.b(aJRAutomaticEMandateConfirmationActivity, "", str);
                }
            }
        } else if (orderStatus == 4 || orderStatus == 8) {
            k kVar2 = aJRAutomaticEMandateConfirmationActivity.s;
            if (kVar2 != null) {
                kVar2.dismissAllowingStateLoss();
            }
            g.a((g.a) new net.one97.paytm.recharge.widgets.a.a("tag.alert.order.failed", aJRAutomaticEMandateConfirmationActivity));
            com.paytm.utility.b.b((Context) aJRAutomaticEMandateConfirmationActivity, "", aJRAutomaticEMandateConfirmationActivity.getString(R.string.emandate_transation_failed_msg));
        } else if (orderStatus == aJRAutomaticEMandateConfirmationActivity.r) {
            k kVar3 = aJRAutomaticEMandateConfirmationActivity.s;
            if (kVar3 != null) {
                kVar3.dismissAllowingStateLoss();
            }
            CJRProceedWidgetV8 cJRProceedWidgetV82 = (CJRProceedWidgetV8) aJRAutomaticEMandateConfirmationActivity.a(R.id.proceed_btn);
            if (cJRProceedWidgetV82 != null) {
                cJRProceedWidgetV82.postDelayed(new c(aJRAutomaticEMandateConfirmationActivity), 50);
            }
        } else if (orderStatus == 1) {
            k kVar4 = aJRAutomaticEMandateConfirmationActivity.s;
            if (kVar4 != null) {
                kVar4.dismissAllowingStateLoss();
            }
            g.a((g.a) new net.one97.paytm.recharge.widgets.a.a("tag.alert.order.pending", aJRAutomaticEMandateConfirmationActivity));
            com.paytm.utility.b.b((Context) aJRAutomaticEMandateConfirmationActivity, "", aJRAutomaticEMandateConfirmationActivity.getString(R.string.emandate_transation_failed_msg));
        } else {
            k kVar5 = aJRAutomaticEMandateConfirmationActivity.s;
            if (kVar5 != null) {
                kVar5.dismissAllowingStateLoss();
            }
        }
    }

    public static final /* synthetic */ void b(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
        String str;
        String str2;
        Activity activity = aJRAutomaticEMandateConfirmationActivity;
        int i2 = aJRAutomaticEMandateConfirmationActivity.f64639g;
        String str3 = aJRAutomaticEMandateConfirmationActivity.f64636d;
        String str4 = aJRAutomaticEMandateConfirmationActivity.f64634b;
        String str5 = aJRAutomaticEMandateConfirmationActivity.f64635c;
        CJRPayChannelOptions cJRPayChannelOptions = aJRAutomaticEMandateConfirmationActivity.f64633a;
        if (cJRPayChannelOptions == null || (str = cJRPayChannelOptions.getChannelName()) == null) {
            str = "";
        }
        String str6 = aJRAutomaticEMandateConfirmationActivity.f64637e;
        CJRPayChannelOptions cJRPayChannelOptions2 = aJRAutomaticEMandateConfirmationActivity.f64633a;
        if (cJRPayChannelOptions2 == null || (str2 = cJRPayChannelOptions2.getChannelCode()) == null) {
            str2 = "";
        }
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        HashMap<String, Object> hashMap = aJRAutomaticEMandateConfirmationActivity.f64638f;
        if (hashMap != null) {
            if (hashMap == null) {
                kotlin.g.b.k.a();
            }
            cJRRechargePayment.setmMID(String.valueOf(hashMap.get("key_mid")));
            HashMap<String, Object> hashMap2 = aJRAutomaticEMandateConfirmationActivity.f64638f;
            if (hashMap2 == null) {
                kotlin.g.b.k.a();
            }
            cJRRechargePayment.setmOrderId(String.valueOf(hashMap2.get("key_order_id")));
            HashMap<String, Object> hashMap3 = aJRAutomaticEMandateConfirmationActivity.f64638f;
            if (hashMap3 == null) {
                kotlin.g.b.k.a();
            }
            cJRRechargePayment.setmTxnToken(String.valueOf(hashMap3.get("txn_token")));
            HashMap<String, Object> hashMap4 = aJRAutomaticEMandateConfirmationActivity.f64638f;
            if (hashMap4 == null) {
                kotlin.g.b.k.a();
            }
            cJRRechargePayment.setTxnAmount(String.valueOf(hashMap4.get("txn_amount")));
            HashMap<String, Object> hashMap5 = aJRAutomaticEMandateConfirmationActivity.f64638f;
            if (hashMap5 == null) {
                kotlin.g.b.k.a();
            }
            cJRRechargePayment.setmStatus(String.valueOf(hashMap5.get(CJRGTMConstants.MT_V4_TXN_STATUS)));
            HashMap<String, Object> hashMap6 = aJRAutomaticEMandateConfirmationActivity.f64638f;
            if (hashMap6 == null) {
                kotlin.g.b.k.a();
            }
            cJRRechargePayment.setmNativeEnabled(String.valueOf(hashMap6.get("key_native_withdraw")));
        }
        HashMap<String, Object> hashMap7 = aJRAutomaticEMandateConfirmationActivity.f64638f;
        if (hashMap7 == null) {
            kotlin.g.b.k.a();
        }
        String valueOf = String.valueOf(hashMap7.get("paymentMode"));
        HashMap<String, Object> hashMap8 = aJRAutomaticEMandateConfirmationActivity.f64638f;
        if (hashMap8 == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.recharge.automatic.b.a.c.a(activity, i2, str3, str4, str5, str, str6, str2, cJRRechargePayment, valueOf, String.valueOf(hashMap8.get(UpiConstants.EXTRA_SUBSCRIPTION_ID)));
    }

    public static final /* synthetic */ void c(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) aJRAutomaticEMandateConfirmationActivity.a(R.id.proceed_btn);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.postDelayed(new a(aJRAutomaticEMandateConfirmationActivity), 500);
        }
    }

    public static final /* synthetic */ void h(AJRAutomaticEMandateConfirmationActivity aJRAutomaticEMandateConfirmationActivity) {
        Intent intent = new Intent(aJRAutomaticEMandateConfirmationActivity, AJRAutomaticSubscriptionTnCWebView.class);
        intent.putExtra("url", "https://www.paytmbank.com/Terms&Conditions");
        aJRAutomaticEMandateConfirmationActivity.startActivity(intent);
    }
}
