package net.one97.paytm.paymentsBank.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity;
import net.one97.paytm.i.f;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class o extends f implements g.a, g.b<IJRPaytmDataModel> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BottomSheetBehavior f18539a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f18540b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f18541c;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        if (r8.equals("NOT_APPLIED") != false) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void onResponse(java.lang.Object r8) {
        /*
            r7 = this;
            com.paytm.network.model.IJRPaytmDataModel r8 = (com.paytm.network.model.IJRPaytmDataModel) r8
            com.airbnb.lottie.LottieAnimationView r0 = r7.f18540b
            r7.b((com.airbnb.lottie.LottieAnimationView) r0)
            boolean r0 = r8 instanceof net.one97.paytm.bankCommon.model.CustProductList
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x011d
            net.one97.paytm.bankCommon.model.CustProductList r8 = (net.one97.paytm.bankCommon.model.CustProductList) r8
            java.lang.String r0 = r8.getErrorMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002b
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r7.getString(r1)
            java.lang.String r8 = r8.getErrorMessage()
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r8)
            return
        L_0x002b:
            java.lang.String r0 = r8.getIsaStatus()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x011c
            java.lang.String r8 = r8.getIsaStatus()
            r0 = -1
            int r3 = r8.hashCode()
            switch(r3) {
                case -2125830485: goto L_0x0087;
                case -1757359925: goto L_0x007d;
                case -1395063325: goto L_0x0073;
                case -604548089: goto L_0x0069;
                case -287297839: goto L_0x0060;
                case 2332508: goto L_0x0056;
                case 35394935: goto L_0x004c;
                case 2066319421: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0091
        L_0x0042:
            java.lang.String r1 = "FAILED"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0091
            r1 = 3
            goto L_0x0092
        L_0x004c:
            java.lang.String r1 = "PENDING"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0091
            r1 = 6
            goto L_0x0092
        L_0x0056:
            java.lang.String r1 = "LEAD"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0091
            r1 = 2
            goto L_0x0092
        L_0x0060:
            java.lang.String r2 = "NOT_APPLIED"
            boolean r8 = r8.equals(r2)
            if (r8 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0069:
            java.lang.String r1 = "IN_PROGRESS"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0091
            r1 = 4
            goto L_0x0092
        L_0x0073:
            java.lang.String r1 = "NOT_ELIGIBLE"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0091
            r1 = 0
            goto L_0x0092
        L_0x007d:
            java.lang.String r1 = "INITIATED"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0091
            r1 = 5
            goto L_0x0092
        L_0x0087:
            java.lang.String r1 = "ISSUED"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0091
            r1 = 7
            goto L_0x0092
        L_0x0091:
            r1 = -1
        L_0x0092:
            switch(r1) {
                case 0: goto L_0x0109;
                case 1: goto L_0x00b9;
                case 2: goto L_0x00b9;
                case 3: goto L_0x00a8;
                case 4: goto L_0x00a8;
                case 5: goto L_0x00a8;
                case 6: goto L_0x00a8;
                case 7: goto L_0x0097;
                default: goto L_0x0095;
            }
        L_0x0095:
            goto L_0x011c
        L_0x0097:
            net.one97.paytm.paymentsBank.h.a r8 = net.one97.paytm.paymentsBank.utils.o.a()
            android.content.Context r8 = r8.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r0 = net.one97.paytm.bankCommon.model.AccountStatus.ISSUED
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r8, (net.one97.paytm.bankCommon.model.AccountStatus) r0)
            r7.dismiss()
            goto L_0x011c
        L_0x00a8:
            net.one97.paytm.paymentsBank.h.a r8 = net.one97.paytm.paymentsBank.utils.o.a()
            android.content.Context r8 = r8.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r0 = net.one97.paytm.bankCommon.model.AccountStatus.PROCESSING
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r8, (net.one97.paytm.bankCommon.model.AccountStatus) r0)
            r7.dismiss()
            return
        L_0x00b9:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x0108
            boolean r8 = r7.isResumed()
            if (r8 == 0) goto L_0x0108
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.Class r8 = r7.getClass()
            java.lang.String r8 = r8.getSimpleName()
            java.lang.String r0 = "screen_name"
            r6.put(r0, r8)
            net.one97.paytm.paymentsBank.utils.j.a()
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            com.paytm.network.a$c r4 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r5 = com.paytm.network.a.b.USER_FACING
            java.lang.String r1 = "ISA"
            r2 = r7
            r3 = r7
            net.one97.paytm.bankCommon.g.f r8 = net.one97.paytm.paymentsBank.b.a.b((android.content.Context) r0, (java.lang.String) r1, (net.one97.paytm.bankCommon.g.g.b<com.paytm.network.model.IJRPaytmDataModel>) r2, (net.one97.paytm.bankCommon.g.g.a) r3, (com.paytm.network.a.c) r4, (com.paytm.network.a.b) r5, (java.util.HashMap<java.lang.String, java.lang.String>) r6)
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0108
            com.airbnb.lottie.LottieAnimationView r0 = r7.f18540b
            r7.a((com.airbnb.lottie.LottieAnimationView) r0)
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            r0.getApplicationContext()
            net.one97.paytm.bankCommon.g.c r0 = new net.one97.paytm.bankCommon.g.c
            r0.<init>()
            net.one97.paytm.bankCommon.g.c.a(r8)
        L_0x0108:
            return
        L_0x0109:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            int r0 = net.one97.paytm.paymentsBank.R.string.alert
            java.lang.String r0 = r7.getString(r0)
            int r1 = net.one97.paytm.paymentsBank.R.string.pb_not_eligible_apply
            java.lang.String r1 = r7.getString(r1)
            com.paytm.utility.b.b((android.content.Context) r8, (java.lang.String) r0, (java.lang.String) r1)
        L_0x011c:
            return
        L_0x011d:
            boolean r0 = r8 instanceof net.one97.paytm.bankCommon.model.CustProductStatus
            if (r0 == 0) goto L_0x01d8
            net.one97.paytm.bankCommon.model.CustProductStatus r8 = (net.one97.paytm.bankCommon.model.CustProductStatus) r8
            java.lang.String r0 = r8.getProduct()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01d8
            java.lang.String r0 = r8.getProduct()
            java.lang.String r3 = "ISA"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x01d8
            java.lang.String r0 = r8.getPasscode()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x015e
            java.lang.String r0 = r8.getPasscode()
            java.lang.String r3 = "Y"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x0157
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r0, (boolean) r1)
            goto L_0x015e
        L_0x0157:
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r0, (boolean) r2)
        L_0x015e:
            java.lang.String r0 = r8.getKYC()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0173
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r1 = r8.getKYC()
            net.one97.paytm.bankCommon.h.b.b((android.content.Context) r0, (java.lang.String) r1)
        L_0x0173:
            java.lang.String r0 = r8.getNominee()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0188
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r1 = r8.getNominee()
            net.one97.paytm.bankCommon.h.b.d((android.content.Context) r0, (java.lang.String) r1)
        L_0x0188:
            java.lang.String r0 = r8.getAadhaarRec()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x019d
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r1 = r8.getAadhaarRec()
            net.one97.paytm.bankCommon.h.b.e((android.content.Context) r0, (java.lang.String) r1)
        L_0x019d:
            java.lang.String r0 = r8.getPanRec()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01b2
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r1 = r8.getPanRec()
            net.one97.paytm.bankCommon.h.b.f(r0, r1)
        L_0x01b2:
            java.lang.String r0 = r8.getForm60Rec()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01c7
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            java.lang.String r8 = r8.getForm60Rec()
            net.one97.paytm.bankCommon.h.b.g(r0, r8)
        L_0x01c7:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x01d8
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            r0 = 0
            net.one97.paytm.bankOpen.d.b.a(r8, r0)
            r7.dismiss()
        L_0x01d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.fragment.o.onResponse(java.lang.Object):void");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                o.this.a(dialogInterface);
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
        frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        if (frameLayout != null) {
            this.f18539a = BottomSheetBehavior.from(frameLayout);
        }
        this.f18539a.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    o.this.getActivity().getApplicationContext();
                    net.one97.paytm.bankCommon.mapping.g.a();
                    if (d.a("full_kyc_pop_up_mandate", false)) {
                        o.this.f18539a.setState(3);
                    }
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(net.one97.paytm.paymentsBank.R.layout.pb_fragment_open_account_bottom_sheet, viewGroup, false);
        Button button = (Button) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.open_acc_btn);
        ImageView imageView = (ImageView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_cross_iv);
        TextView textView = (TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_know_more_tv);
        this.f18540b = (LottieAnimationView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.wallet_loader);
        this.f18541c = (ViewGroup) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.buttonLayout);
        getActivity();
        net.one97.paytm.bankCommon.mapping.g.a();
        if (!TextUtils.isEmpty(d.a("saving_acc_interest"))) {
            getActivity();
            net.one97.paytm.bankCommon.mapping.g.a();
            String[] split = d.a("saving_acc_interest").split("##");
            if (split.length > 1) {
                str = split[1];
                ((TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_yellow_strip_complete_kyc_tv)).setText(getString(net.one97.paytm.paymentsBank.R.string.pb_earn_interest_upto, str));
                getDialog().setCanceledOnTouchOutside(true);
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        o.this.c(view);
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        o.this.b(view);
                    }
                });
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        o.this.a(view);
                    }
                });
                c.a(getActivity(), "bank_saving_account", "popup", "popup_viewed", "", "/", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                return inflate;
            }
        }
        str = "6.85%";
        ((TextView) inflate.findViewById(net.one97.paytm.paymentsBank.R.id.full_kyc_yellow_strip_complete_kyc_tv)).setText(getString(net.one97.paytm.paymentsBank.R.string.pb_earn_interest_upto, str));
        getDialog().setCanceledOnTouchOutside(true);
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.c(view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.b(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.a(view);
            }
        });
        c.a(getActivity(), "bank_saving_account", "popup", "popup_viewed", "", "/", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        c.a(getActivity(), "bank_saving_account", "popup", "open_your_savings_account_clicked", "", "/", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        net.one97.paytm.bankCommon.g.f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) getActivity(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        if (b.c((Context) getActivity())) {
            a(this.f18540b);
            getActivity().getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(a2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent(getActivity(), PaymentsBankBaseActivity.class);
        intent.putExtra("extraDefaultFrame", 5);
        startActivity(intent);
        dismissAllowingStateLoss();
    }

    private void a(LottieAnimationView lottieAnimationView) {
        this.f18541c.setVisibility(8);
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    private void b(LottieAnimationView lottieAnimationView) {
        this.f18541c.setVisibility(0);
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b(this.f18540b);
        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
            net.one97.paytm.bankCommon.utils.f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
        }
        dismissAllowingStateLoss();
    }
}
