package net.one97.paytm.bankOpen.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import java.util.HashMap;
import net.one97.paytm.bankCommon.d.b;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBHelpVideoModel;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.a.a;
import net.one97.paytm.bankOpen.activity.BankAccProcessingActivity;
import net.one97.paytm.bankOpen.f;

public class e extends b implements View.OnClickListener, g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    private Context f16390b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f16391c;

    /* renamed from: d  reason: collision with root package name */
    private View f16392d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f16393e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f16394f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f16395g;

    /* renamed from: h  reason: collision with root package name */
    private View f16396h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f16397i;
    private AppCompatButton j;
    private boolean k;
    private PBHelpVideoModel l;
    private TextView m;
    private View n;
    private View o;
    private LottieAnimationView p;
    private int q;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f16390b = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_payment_bank_open_account, (ViewGroup) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityCreated(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onActivityCreated(r8)
            android.view.View r8 = r7.getView()
            int r0 = net.one97.paytm.bankOpen.R.id.main_lyt
            android.view.View r0 = r8.findViewById(r0)
            r7.n = r0
            int r0 = net.one97.paytm.bankOpen.R.id.loading_lyt
            android.view.View r0 = r8.findViewById(r0)
            r7.o = r0
            int r0 = net.one97.paytm.bankOpen.R.id.loading_view
            android.view.View r0 = r8.findViewById(r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            r7.p = r0
            int r0 = net.one97.paytm.bankOpen.R.id.fragment_open_account_iv_close
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r7.f16394f = r0
            int r0 = net.one97.paytm.bankOpen.R.id.iv_motif
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r7.f16393e = r0
            int r0 = net.one97.paytm.bankOpen.R.id.iv_bank_cityscape
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r7.f16395g = r0
            int r0 = net.one97.paytm.bankOpen.R.id.layout_bank_header_bar_toolbar
            android.view.View r0 = r8.findViewById(r0)
            r7.f16396h = r0
            int r0 = net.one97.paytm.bankOpen.R.id.lyt_unexpanded
            android.view.View r0 = r8.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r7.f16391c = r0
            int r0 = net.one97.paytm.bankOpen.R.id.paytments_bank_open_btn_proceed
            android.view.View r0 = r8.findViewById(r0)
            androidx.appcompat.widget.AppCompatButton r0 = (androidx.appcompat.widget.AppCompatButton) r0
            r7.j = r0
            androidx.appcompat.widget.AppCompatButton r0 = r7.j
            r0.setOnClickListener(r7)
            int r0 = net.one97.paytm.bankOpen.R.id.tv_error
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r7.m = r0
            int r0 = net.one97.paytm.bankOpen.R.id.payments_bank_info_btn_close
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r7)
            int r0 = net.one97.paytm.bankOpen.R.id.videosLayout
            android.view.View r0 = r8.findViewById(r0)
            r7.f16392d = r0
            android.view.View r0 = r7.f16392d
            r0.setOnClickListener(r7)
            android.widget.ImageView r0 = r7.f16394f
            r0.setOnClickListener(r7)
            int r0 = net.one97.paytm.bankOpen.R.id.pb_bank_promotion_title1_tv
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.bankOpen.R.id.pb_bank_promotion_title2_tv
            android.view.View r8 = r8.findViewById(r1)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r7.getActivity()
            net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r1 = "saving_acc_interest"
            java.lang.String r2 = net.one97.paytm.bankCommon.utils.d.a(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x00c1
            r7.getActivity()
            net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r1 = net.one97.paytm.bankCommon.utils.d.a(r1)
            java.lang.String r2 = "##"
            java.lang.String[] r1 = r1.split(r2)
            int r2 = r1.length
            if (r2 <= r3) goto L_0x00c1
            r2 = r1[r4]
            r1 = r1[r3]
            goto L_0x00c5
        L_0x00c1:
            java.lang.String r2 = "4%"
            java.lang.String r1 = "7.03%"
        L_0x00c5:
            int r5 = net.one97.paytm.bankOpen.R.string.pb_bank_promotion_title1
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r4] = r2
            java.lang.String r2 = r7.getString(r5, r6)
            r0.setText(r2)
            int r0 = net.one97.paytm.bankOpen.R.string.pb_bank_promotion_title2
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r1
            java.lang.String r0 = r7.getString(r0, r2)
            r8.setText(r0)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.String r0 = "new_wallet_screen_type"
            java.lang.String r1 = "passbook"
            r8.put(r0, r1)
            java.lang.String r0 = "open_account_screen_type"
            java.lang.String r1 = "fullscreen"
            r8.put(r0, r1)
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r0)
            java.lang.String r1 = "user_id"
            r8.put(r1, r0)
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r1 = "new_wallet_passbook_open_account_screen_loaded"
            net.one97.paytm.bankCommon.mapping.c.a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r8, (android.content.Context) r0)
            android.os.Bundle r8 = r7.getArguments()
            r0 = 8
            if (r8 == 0) goto L_0x018b
            android.os.Bundle r8 = r7.getArguments()
            java.lang.String r1 = "acc_opening_type"
            int r8 = r8.getInt(r1)
            r7.q = r8
            int r8 = r7.q
            if (r8 != r3) goto L_0x012a
            android.view.View r8 = r7.n
            r8.setVisibility(r0)
            r7.e()
            goto L_0x018b
        L_0x012a:
            android.view.View r8 = r7.n
            r8.setVisibility(r4)
            android.os.Bundle r8 = r7.getArguments()
            java.lang.String r1 = "SHOW_ONLY_KNOW_MORE"
            boolean r8 = r8.getBoolean(r1, r4)
            r7.f16397i = r8
            boolean r8 = r7.f16397i
            if (r8 == 0) goto L_0x015e
            android.widget.LinearLayout r8 = r7.f16391c
            r8.setVisibility(r4)
            android.view.View r8 = r7.f16396h
            r8.setVisibility(r0)
            android.widget.ImageView r8 = r7.f16393e
            r8.setVisibility(r0)
            android.widget.ImageView r8 = r7.f16394f
            r8.setVisibility(r4)
            android.widget.ImageView r8 = r7.f16395g
            r8.setVisibility(r0)
            androidx.appcompat.widget.AppCompatButton r8 = r7.j
            r8.setVisibility(r0)
            return
        L_0x015e:
            android.os.Bundle r8 = r7.getArguments()
            java.lang.String r1 = "check_account_status"
            boolean r8 = r8.getBoolean(r1, r4)
            r7.k = r8
            android.os.Bundle r8 = r7.getArguments()
            java.lang.String r1 = "no_top_bar"
            boolean r8 = r8.getBoolean(r1, r4)
            if (r8 == 0) goto L_0x0181
            android.view.View r8 = r7.f16396h
            r8.setVisibility(r0)
            android.widget.ImageView r8 = r7.f16393e
            r8.setVisibility(r0)
            goto L_0x018b
        L_0x0181:
            android.view.View r8 = r7.f16396h
            r8.setVisibility(r4)
            android.widget.ImageView r8 = r7.f16393e
            r8.setVisibility(r4)
        L_0x018b:
            boolean r8 = r7.k
            java.lang.String r1 = "banksavingsaccount"
            if (r8 == 0) goto L_0x01ae
            r7.getActivity()
            net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r8 = "bank_applied_customer_error"
            java.lang.String r8 = net.one97.paytm.bankCommon.utils.d.a(r8)
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()
            java.lang.String r3 = "/bank/savings-account/check-account-opening-status"
            net.one97.paytm.bankCommon.mapping.c.a((java.lang.String) r3, (java.lang.String) r1, (android.content.Context) r2)
            androidx.appcompat.widget.AppCompatButton r1 = r7.j
            int r2 = net.one97.paytm.bankOpen.R.string.check_account_opening_status
            r1.setText(r2)
            goto L_0x01c3
        L_0x01ae:
            r7.getActivity()
            net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r8 = "bank_new_customer_error"
            java.lang.String r8 = net.one97.paytm.bankCommon.utils.d.a(r8)
            androidx.fragment.app.FragmentActivity r2 = r7.getActivity()
            java.lang.String r3 = "/bank/savings-account/proceed-to-open"
            net.one97.paytm.bankCommon.mapping.c.a((java.lang.String) r3, (java.lang.String) r1, (android.content.Context) r2)
        L_0x01c3:
            r7.getActivity()
            net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r1 = "is_bank_account_opening_enabled"
            boolean r1 = net.one97.paytm.bankCommon.utils.d.a(r1, r4)
            if (r1 == 0) goto L_0x01dc
            androidx.appcompat.widget.AppCompatButton r8 = r7.j
            r8.setVisibility(r4)
            android.widget.TextView r8 = r7.m
            r8.setVisibility(r0)
            return
        L_0x01dc:
            androidx.appcompat.widget.AppCompatButton r1 = r7.j
            r1.setVisibility(r0)
            android.widget.TextView r0 = r7.m
            r0.setVisibility(r4)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 != 0) goto L_0x01f2
            android.widget.TextView r0 = r7.m
            r0.setText(r8)
            return
        L_0x01f2:
            android.widget.TextView r8 = r7.m
            int r0 = net.one97.paytm.bankOpen.R.string.pb_something_wrong_try_again
            r8.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.b.e.onActivityCreated(android.os.Bundle):void");
    }

    public void onViewCreated(final View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                e.a(e.this);
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public void onResume() {
        super.onResume();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.paytments_bank_open_btn_proceed) {
            if (this.k) {
                Intent intent = new Intent(getContext(), BankAccProcessingActivity.class);
                intent.setFlags(67108864);
                startActivity(intent);
                return;
            }
            if (getArguments() != null) {
                String string = getArguments().getString("vertical");
                if (!TextUtils.isEmpty(string)) {
                    string.equalsIgnoreCase("kyc");
                }
            }
            e();
        } else if (id == R.id.payments_bank_info_btn_close) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                getActivity().finish();
            }
        } else if (id == R.id.videosLayout) {
            if (this.l != null) {
                f.a().openYoutubePlayerFragment(getActivity(), this.l.getUrl());
            }
        } else if (id != R.id.fragment_open_account_iv_close) {
        } else {
            if (this.f16397i) {
                getActivity().finish();
                return;
            }
            this.f16391c.setVisibility(0);
            this.f16396h.setVisibility(0);
            this.f16393e.setVisibility(0);
            this.f16394f.setVisibility(8);
            this.f16395g.setVisibility(0);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(com.paytm.network.model.IJRPaytmDataModel r10) {
        /*
            r9 = this;
            super.onResponse((com.paytm.network.model.IJRPaytmDataModel) r10)
            int r0 = r9.q
            r1 = 1
            if (r0 != r1) goto L_0x000c
            r9.d()
            goto L_0x000f
        L_0x000c:
            r9.W_()
        L_0x000f:
            boolean r0 = r9.isResumed()
            if (r0 != 0) goto L_0x0016
            return
        L_0x0016:
            boolean r0 = r10 instanceof net.one97.paytm.bankCommon.model.bankstatus.BankStatusModel
            r2 = 4
            r3 = 0
            if (r0 == 0) goto L_0x013b
            net.one97.paytm.bankCommon.model.bankstatus.BankStatusModel r10 = (net.one97.paytm.bankCommon.model.bankstatus.BankStatusModel) r10
            java.lang.String r0 = r10.getErrorMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x003a
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            int r1 = net.one97.paytm.bankOpen.R.string.error
            java.lang.String r1 = r9.getString(r1)
            java.lang.String r10 = r10.getErrorMessage()
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r10)
            return
        L_0x003a:
            java.lang.String r0 = r10.getAccountStatus()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x013a
            java.lang.String r10 = r10.getAccountStatus()
            r0 = -1
            int r4 = r10.hashCode()
            switch(r4) {
                case -2125830485: goto L_0x0097;
                case -1757359925: goto L_0x008d;
                case -1395063325: goto L_0x0083;
                case -604548089: goto L_0x0079;
                case -287297839: goto L_0x006f;
                case 2332508: goto L_0x0065;
                case 35394935: goto L_0x005b;
                case 2066319421: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x00a1
        L_0x0051:
            java.lang.String r2 = "FAILED"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a1
            r10 = 3
            goto L_0x00a2
        L_0x005b:
            java.lang.String r2 = "PENDING"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a1
            r10 = 6
            goto L_0x00a2
        L_0x0065:
            java.lang.String r2 = "LEAD"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a1
            r10 = 2
            goto L_0x00a2
        L_0x006f:
            java.lang.String r2 = "NOT_APPLIED"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a1
            r10 = 1
            goto L_0x00a2
        L_0x0079:
            java.lang.String r3 = "IN_PROGRESS"
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L_0x00a1
            r10 = 4
            goto L_0x00a2
        L_0x0083:
            java.lang.String r2 = "NOT_ELIGIBLE"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a1
            r10 = 0
            goto L_0x00a2
        L_0x008d:
            java.lang.String r2 = "INITIATED"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a1
            r10 = 5
            goto L_0x00a2
        L_0x0097:
            java.lang.String r2 = "ISSUED"
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x00a1
            r10 = 7
            goto L_0x00a2
        L_0x00a1:
            r10 = -1
        L_0x00a2:
            switch(r10) {
                case 0: goto L_0x0127;
                case 1: goto L_0x00ce;
                case 2: goto L_0x00ce;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00bb;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00a7;
                default: goto L_0x00a5;
            }
        L_0x00a5:
            goto L_0x013a
        L_0x00a7:
            net.one97.paytm.bankOpen.c r10 = net.one97.paytm.bankOpen.f.a()
            android.content.Context r10 = r10.getApplicationContext()
            net.one97.paytm.bankCommon.h.b.l(r10)
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            r10.finish()
            goto L_0x013a
        L_0x00bb:
            net.one97.paytm.bankOpen.c r10 = net.one97.paytm.bankOpen.f.a()
            android.content.Context r10 = r10.getApplicationContext()
            net.one97.paytm.bankCommon.h.b.k(r10)
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            r10.finish()
            return
        L_0x00ce:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x0126
            boolean r10 = r9.isResumed()
            if (r10 == 0) goto L_0x0126
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.Class r10 = r9.getClass()
            java.lang.String r10 = r10.getSimpleName()
            java.lang.String r0 = "screen_name"
            r8.put(r0, r10)
            android.content.Context r2 = r9.f16390b
            com.paytm.network.a$c r6 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r7 = com.paytm.network.a.b.USER_FACING
            java.lang.String r3 = "ISA"
            r4 = r9
            r5 = r9
            net.one97.paytm.bankCommon.g.f r10 = net.one97.paytm.bankOpen.a.a.a((android.content.Context) r2, (java.lang.String) r3, (net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel>) r4, (net.one97.paytm.bankCommon.g.g.a) r5, (com.paytm.network.a.c) r6, (com.paytm.network.a.b) r7, (java.util.HashMap<java.lang.String, java.lang.String>) r8)
            android.content.Context r0 = r9.f16390b
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0123
            int r0 = r9.q
            if (r0 != r1) goto L_0x010a
            r9.f()
            goto L_0x0115
        L_0x010a:
            android.content.Context r0 = r9.f16390b
            int r1 = net.one97.paytm.bankOpen.R.string.pb_please_wait
            java.lang.String r1 = r9.getString(r1)
            r9.b(r0, r1)
        L_0x0115:
            android.content.Context r0 = r9.f16390b
            r0.getApplicationContext()
            net.one97.paytm.bankCommon.g.c r0 = new net.one97.paytm.bankCommon.g.c
            r0.<init>()
            net.one97.paytm.bankCommon.g.c.a(r10)
            return
        L_0x0123:
            r9.a((net.one97.paytm.bankCommon.g.f) r10)
        L_0x0126:
            return
        L_0x0127:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            int r0 = net.one97.paytm.bankOpen.R.string.alert
            java.lang.String r0 = r9.getString(r0)
            int r1 = net.one97.paytm.bankOpen.R.string.pb_not_eligible_apply
            java.lang.String r1 = r9.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r10, (java.lang.String) r0, (java.lang.String) r1)
        L_0x013a:
            return
        L_0x013b:
            boolean r0 = r10 instanceof net.one97.paytm.bankCommon.model.CustProductStatus
            if (r0 == 0) goto L_0x0202
            net.one97.paytm.bankCommon.model.CustProductStatus r10 = (net.one97.paytm.bankCommon.model.CustProductStatus) r10
            java.lang.String r0 = r10.getProduct()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0201
            java.lang.String r0 = r10.getProduct()
            java.lang.String r2 = "ISA"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0201
            java.lang.String r0 = r10.getPasscode()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x017c
            java.lang.String r0 = r10.getPasscode()
            java.lang.String r2 = "Y"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0175
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r0, (boolean) r1)
            goto L_0x017c
        L_0x0175:
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r0, (boolean) r3)
        L_0x017c:
            java.lang.String r0 = r10.getKYC()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0191
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            java.lang.String r1 = r10.getKYC()
            net.one97.paytm.bankCommon.h.b.b((android.content.Context) r0, (java.lang.String) r1)
        L_0x0191:
            java.lang.String r0 = r10.getNominee()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01a6
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            java.lang.String r1 = r10.getNominee()
            net.one97.paytm.bankCommon.h.b.d((android.content.Context) r0, (java.lang.String) r1)
        L_0x01a6:
            java.lang.String r0 = r10.getAadhaarRec()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01bb
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            java.lang.String r1 = r10.getAadhaarRec()
            net.one97.paytm.bankCommon.h.b.e((android.content.Context) r0, (java.lang.String) r1)
        L_0x01bb:
            java.lang.String r0 = r10.getPanRec()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01d0
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            java.lang.String r1 = r10.getPanRec()
            net.one97.paytm.bankCommon.h.b.f(r0, r1)
        L_0x01d0:
            java.lang.String r0 = r10.getForm60Rec()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01e5
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            java.lang.String r10 = r10.getForm60Rec()
            net.one97.paytm.bankCommon.h.b.g(r0, r10)
        L_0x01e5:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x01fd
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            boolean r10 = r10 instanceof net.one97.paytm.bankCommon.f.e
            if (r10 == 0) goto L_0x01fd
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()
            net.one97.paytm.bankCommon.f.e r10 = (net.one97.paytm.bankCommon.f.e) r10
            r9.a((net.one97.paytm.bankCommon.f.e) r10)
            return
        L_0x01fd:
            r10 = 0
            r9.a((net.one97.paytm.bankCommon.f.e) r10)
        L_0x0201:
            return
        L_0x0202:
            boolean r0 = r10 instanceof net.one97.paytm.bankCommon.model.PBHelpVideoResponse
            if (r0 == 0) goto L_0x0250
            net.one97.paytm.bankCommon.model.PBHelpVideoResponse r10 = (net.one97.paytm.bankCommon.model.PBHelpVideoResponse) r10
            if (r10 == 0) goto L_0x0250
            java.util.List r0 = r10.getVideo()
            if (r0 == 0) goto L_0x0250
            r0 = 0
        L_0x0211:
            java.util.List r1 = r10.getVideo()
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0250
            java.util.List r1 = r10.getVideo()
            java.lang.Object r1 = r1.get(r0)
            net.one97.paytm.bankCommon.model.PBHelpVideoModel r1 = (net.one97.paytm.bankCommon.model.PBHelpVideoModel) r1
            java.lang.String r4 = r1.getTag()
            java.lang.String r5 = "SA"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x024d
            r9.l = r1
            r9.getActivity()
            net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r10 = "is_bank_account_opening_enabled"
            boolean r10 = net.one97.paytm.bankCommon.utils.d.a(r10, r3)
            if (r10 == 0) goto L_0x0247
            android.view.View r10 = r9.f16392d
            r10.setVisibility(r3)
            return
        L_0x0247:
            android.view.View r10 = r9.f16392d
            r10.setVisibility(r2)
            return
        L_0x024d:
            int r0 = r0 + 1
            goto L_0x0211
        L_0x0250:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.b.e.onResponse(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (this.q == 1) {
            d();
        } else {
            W_();
        }
        if (networkCustomError == null) {
            return;
        }
        if (this.q == 1) {
            net.one97.paytm.bankCommon.g.e eVar = new net.one97.paytm.bankCommon.g.e(networkCustomError);
            eVar.setOkListener(new g.a() {
                public final void onOkClick() {
                    e.this.getActivity().finish();
                }
            });
            net.one97.paytm.bankCommon.utils.f.a((Context) getActivity(), (NetworkCustomError) eVar, i2);
            return;
        }
        net.one97.paytm.bankCommon.utils.f.a((Context) getActivity(), networkCustomError, i2);
    }

    private void d() {
        this.o.setVisibility(8);
        net.one97.paytm.bankCommon.utils.f.b(this.p);
    }

    private void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.f a2 = a.a(this.f16390b, this, this, a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
        if (com.paytm.utility.b.c(this.f16390b)) {
            if (this.q == 1) {
                f();
            } else {
                Context context = this.f16390b;
                b(context, context.getString(R.string.pb_please_wait));
            }
            this.f16390b.getApplicationContext();
            new c();
            c.a(a2);
            return;
        }
        a(a2);
    }

    private void f() {
        this.o.setVisibility(0);
        net.one97.paytm.bankCommon.utils.f.a(this.p);
    }

    private void b(Context context, String str) {
        if (getActivity() != null && isAdded()) {
            if (context == null && !getActivity().isFinishing()) {
                return;
            }
            if (this.f16232a == null || !this.f16232a.isShowing()) {
                this.f16232a = new ProgressDialog(context);
                try {
                    this.f16232a.setProgressStyle(0);
                    this.f16232a.setMessage(str);
                    this.f16232a.setCancelable(false);
                    this.f16232a.setCanceledOnTouchOutside(false);
                    this.f16232a.show();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (Exception unused) {
                }
            } else {
                this.f16232a.setMessage(str);
            }
        }
    }

    public final void W_() {
        if (getActivity() != null && !isDetached() && this.f16232a != null && this.f16232a.isShowing() && !getActivity().isFinishing()) {
            this.f16232a.dismiss();
            this.f16232a = null;
        }
    }

    private void a(net.one97.paytm.bankCommon.f.e eVar) {
        net.one97.paytm.bankOpen.d.b.a(getActivity(), eVar);
        if (getArguments() != null && getArguments().containsKey("vertical") && "kyc".equals(getArguments().get("vertical")) && getActivity() != null) {
            getActivity().finish();
        }
    }

    static /* synthetic */ void a(e eVar) {
        if (eVar.isAdded()) {
            try {
                if (eVar.isAdded()) {
                    int b2 = com.paytm.utility.b.b((Activity) eVar.getActivity());
                    int height = eVar.getView().findViewById(R.id.scrollview).getHeight();
                    int height2 = eVar.getView().findViewById(R.id.layout_bank_header_bar_toolbar).getHeight();
                    if (height > 0 && height < b2 && (eVar.f16395g.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eVar.f16395g.getLayoutParams();
                        marginLayoutParams.setMargins(0, b2 - (height + height2), 0, 0);
                        eVar.f16395g.setLayoutParams(marginLayoutParams);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
