package net.one97.paytm.p2mNewDesign.nativeOTP;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.p2mNewDesign.entity.BankForm;
import net.one97.paytm.p2mNewDesign.entity.DirectForm;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.TxnInfo;
import net.one97.paytm.p2mNewDesign.nativeOTP.a;
import net.one97.paytm.p2mNewDesign.nativeOTP.b;
import net.one97.paytm.wallet.R;

public final class AJRNativeOTPActivity extends PaytmActivity implements e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f56938a;

    /* renamed from: b  reason: collision with root package name */
    private final int f56939b = 1001;

    /* renamed from: c  reason: collision with root package name */
    private BankForm f56940c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, String> f56941d;

    /* renamed from: e  reason: collision with root package name */
    private c f56942e;

    /* renamed from: f  reason: collision with root package name */
    private String f56943f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.material.bottomsheet.b f56944g;

    /* renamed from: h  reason: collision with root package name */
    private com.google.android.material.bottomsheet.b f56945h;

    /* renamed from: i  reason: collision with root package name */
    private AppCompatTextView f56946i;
    private AppCompatTextView j;
    private AppCompatTextView k;

    public enum a {
        RESEND,
        SUBMIT,
        CANCEL,
        PAYONBANK
    }

    public static final /* synthetic */ AppCompatTextView a(AJRNativeOTPActivity aJRNativeOTPActivity) {
        AppCompatTextView appCompatTextView = aJRNativeOTPActivity.f56946i;
        if (appCompatTextView == null) {
            k.a("lytSuccessTv");
        }
        return appCompatTextView;
    }

    public static final /* synthetic */ AppCompatTextView b(AJRNativeOTPActivity aJRNativeOTPActivity) {
        AppCompatTextView appCompatTextView = aJRNativeOTPActivity.j;
        if (appCompatTextView == null) {
            k.a("lytErrorTv");
        }
        return appCompatTextView;
    }

    public static final /* synthetic */ AppCompatTextView c(AJRNativeOTPActivity aJRNativeOTPActivity) {
        AppCompatTextView appCompatTextView = aJRNativeOTPActivity.k;
        if (appCompatTextView == null) {
            k.a("lytNoInternetTv");
        }
        return appCompatTextView;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_native_otp);
        if (getIntent().hasExtra("bankForm")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("bankForm");
            if (serializableExtra != null) {
                this.f56940c = (BankForm) serializableExtra;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.entity.BankForm");
            }
        }
        if (getIntent().hasExtra("data")) {
            Serializable serializableExtra2 = getIntent().getSerializableExtra("data");
            if (serializableExtra2 != null) {
                this.f56941d = (HashMap) serializableExtra2;
            } else {
                throw new u("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
            }
        }
        this.f56943f = getIntent().getStringExtra("oneClickInfoForSCP");
        View findViewById = findViewById(R.id.lyt_success_tv);
        k.a((Object) findViewById, "findViewById(R.id.lyt_success_tv)");
        this.f56946i = (AppCompatTextView) findViewById;
        View findViewById2 = findViewById(R.id.lyt_error_tv);
        k.a((Object) findViewById2, "findViewById(R.id.lyt_error_tv)");
        this.j = (AppCompatTextView) findViewById2;
        View findViewById3 = findViewById(R.id.lyt_no_internet);
        k.a((Object) findViewById3, "findViewById(R.id.lyt_no_internet)");
        this.k = (AppCompatTextView) findViewById3;
        b.a aVar = b.f56961a;
        b.f56962h = this.f56940c;
        this.f56944g = new b();
        com.google.android.material.bottomsheet.b bVar = this.f56944g;
        if (bVar == null) {
            k.a("mainFragment");
        }
        bVar.setCancelable(false);
        a.b bVar2 = a.f56951a;
        BankForm bankForm = this.f56940c;
        a aVar2 = new a();
        a.f56952f = bankForm;
        this.f56945h = aVar2;
        com.google.android.material.bottomsheet.b bVar3 = this.f56945h;
        if (bVar3 == null) {
            k.a("cancelFragment");
        }
        bVar3.setCancelable(false);
        g();
        Application application = getApplication();
        k.a((Object) application, "this.application");
        ai a2 = new al((ao) this, (al.b) new d(application)).a(c.class);
        k.a((Object) a2, "ViewModelProvider(this, …OTPViewModel::class.java)");
        this.f56942e = (c) a2;
    }

    private final void g() {
        if (!isFinishing() && !isDestroyed()) {
            q a2 = getSupportFragmentManager().a();
            k.a((Object) a2, "supportFragmentManager.beginTransaction()");
            com.google.android.material.bottomsheet.b bVar = this.f56944g;
            if (bVar == null) {
                k.a("mainFragment");
            }
            if (bVar.isAdded()) {
                com.google.android.material.bottomsheet.b bVar2 = this.f56944g;
                if (bVar2 == null) {
                    k.a("mainFragment");
                }
                a2.c(bVar2);
                a2.c();
            } else {
                com.google.android.material.bottomsheet.b bVar3 = this.f56944g;
                if (bVar3 == null) {
                    k.a("mainFragment");
                }
                bVar3.show(a2, "MAIN");
            }
            com.google.android.material.bottomsheet.b bVar4 = this.f56945h;
            if (bVar4 == null) {
                k.a("cancelFragment");
            }
            if (bVar4.isAdded()) {
                com.google.android.material.bottomsheet.b bVar5 = this.f56945h;
                if (bVar5 == null) {
                    k.a("cancelFragment");
                }
                a2.b((Fragment) bVar5);
            }
        }
    }

    public final void a(a aVar, TxnInfo txnInfo) {
        k.c(aVar, "type");
        if (aVar == a.RESEND) {
            AppCompatTextView appCompatTextView = this.f56946i;
            if (appCompatTextView == null) {
                k.a("lytSuccessTv");
            }
            appCompatTextView.setText(getString(R.string.native_otp_sheet_desc));
            AppCompatTextView appCompatTextView2 = this.f56946i;
            if (appCompatTextView2 == null) {
                k.a("lytSuccessTv");
            }
            appCompatTextView2.setVisibility(0);
            AppCompatTextView appCompatTextView3 = this.j;
            if (appCompatTextView3 == null) {
                k.a("lytErrorTv");
            }
            appCompatTextView3.setVisibility(8);
            AppCompatTextView appCompatTextView4 = this.k;
            if (appCompatTextView4 == null) {
                k.a("lytNoInternetTv");
            }
            appCompatTextView4.setVisibility(8);
            AppCompatTextView appCompatTextView5 = this.f56946i;
            if (appCompatTextView5 == null) {
                k.a("lytSuccessTv");
            }
            appCompatTextView5.postDelayed(new d(this), 5000);
        } else if (aVar == a.SUBMIT || aVar == a.CANCEL) {
            Intent intent = new Intent();
            intent.putExtra("extra_data", new f().b(txnInfo));
            setResult(-1, intent);
            finish();
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRNativeOTPActivity f56949a;

        d(AJRNativeOTPActivity aJRNativeOTPActivity) {
            this.f56949a = aJRNativeOTPActivity;
        }

        public final void run() {
            AJRNativeOTPActivity.a(this.f56949a).setVisibility(8);
        }
    }

    public final void a(a aVar, String str) {
        k.c(aVar, "type");
        k.c(str, "message");
        CharSequence charSequence = str;
        if (charSequence.length() > 0) {
            AppCompatTextView appCompatTextView = this.j;
            if (appCompatTextView == null) {
                k.a("lytErrorTv");
            }
            appCompatTextView.setText(charSequence);
        }
        AppCompatTextView appCompatTextView2 = this.j;
        if (appCompatTextView2 == null) {
            k.a("lytErrorTv");
        }
        appCompatTextView2.setVisibility(0);
        AppCompatTextView appCompatTextView3 = this.f56946i;
        if (appCompatTextView3 == null) {
            k.a("lytSuccessTv");
        }
        appCompatTextView3.setVisibility(8);
        AppCompatTextView appCompatTextView4 = this.k;
        if (appCompatTextView4 == null) {
            k.a("lytNoInternetTv");
        }
        appCompatTextView4.setVisibility(8);
        AppCompatTextView appCompatTextView5 = this.j;
        if (appCompatTextView5 == null) {
            k.a("lytErrorTv");
        }
        appCompatTextView5.postDelayed(new b(this), 5000);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRNativeOTPActivity f56947a;

        b(AJRNativeOTPActivity aJRNativeOTPActivity) {
            this.f56947a = aJRNativeOTPActivity;
        }

        public final void run() {
            AJRNativeOTPActivity.b(this.f56947a).setVisibility(8);
        }
    }

    public final void a(String str) {
        k.c(str, "remainingSeconds");
        AppCompatTextView appCompatTextView = this.f56946i;
        if (appCompatTextView == null) {
            k.a("lytSuccessTv");
        }
        appCompatTextView.setVisibility(8);
        AppCompatTextView appCompatTextView2 = this.j;
        if (appCompatTextView2 == null) {
            k.a("lytErrorTv");
        }
        aa aaVar = aa.f47921a;
        String string = getString(R.string.native_page_expiry_alert);
        k.a((Object) string, "getString(R.string.native_page_expiry_alert)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        appCompatTextView2.setText(format);
        AppCompatTextView appCompatTextView3 = this.j;
        if (appCompatTextView3 == null) {
            k.a("lytErrorTv");
        }
        appCompatTextView3.setVisibility(0);
        AppCompatTextView appCompatTextView4 = this.j;
        if (appCompatTextView4 == null) {
            k.a("lytErrorTv");
        }
        appCompatTextView4.postDelayed(new c(this), 5000);
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRNativeOTPActivity f56948a;

        c(AJRNativeOTPActivity aJRNativeOTPActivity) {
            this.f56948a = aJRNativeOTPActivity;
        }

        public final void run() {
            AJRNativeOTPActivity.b(this.f56948a).setVisibility(8);
        }
    }

    public final void a() {
        q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        com.google.android.material.bottomsheet.b bVar = this.f56945h;
        if (bVar == null) {
            k.a("cancelFragment");
        }
        bVar.show(a2, TransactionType.CANCEL);
        com.google.android.material.bottomsheet.b bVar2 = this.f56944g;
        if (bVar2 == null) {
            k.a("mainFragment");
        }
        if (bVar2.isAdded()) {
            com.google.android.material.bottomsheet.b bVar3 = this.f56944g;
            if (bVar3 == null) {
                k.a("mainFragment");
            }
            a2.b((Fragment) bVar3);
        }
    }

    public final void b() {
        Intent intent = new Intent();
        intent.putExtra("is_select_another_payment_mode", true);
        intent.putExtra("is_otp_limit_breach", this.f56938a);
        setResult(-1, intent);
        finish();
    }

    public final void b(String str) {
        k.c(str, "msg");
        Intent intent = new Intent();
        intent.putExtra("is_select_another_payment_mode", true);
        intent.putExtra(BaseDialogFragment.ERROR_MESSAGE, str);
        setResult(-1, intent);
        finish();
    }

    public final void c() {
        ArrayList<DirectForm> directForms;
        Map a2;
        BankForm bankForm = this.f56940c;
        if (bankForm != null && (directForms = bankForm.getDirectForms()) != null) {
            for (DirectForm directForm : directForms) {
                k.a((Object) directForm, "it");
                if (k.a((Object) directForm.getType(), (Object) DirectFormItemType.PAYONBANK)) {
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                    k.a((Object) f2, "DirectPaymentBl.getInstance()");
                    InstrumentInfo l = f2.l();
                    k.a((Object) l, "DirectPaymentBl.getInsta…().selectedInstrumentInfo");
                    k.c(directForm, "form");
                    CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
                    HashMap hashMap = new HashMap();
                    if (directForm.getContent() != null) {
                        HashMap<String, String> content = directForm.getContent();
                        if (content != null) {
                            hashMap.putAll(content);
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.collections.Map<out kotlin.String, kotlin.String>");
                        }
                    }
                    HashMap<String, String> hashMap2 = this.f56941d;
                    if (!(hashMap2 == null || (a2 = ae.a(hashMap2)) == null)) {
                        hashMap.putAll(a2);
                    }
                    cJRRechargePayment.setmPGParams(hashMap);
                    HashMap<String, String> hashMap3 = this.f56941d;
                    cJRRechargePayment.setmMID(hashMap3 != null ? hashMap3.get("mid") : null);
                    cJRRechargePayment.setmOrderId(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d());
                    cJRRechargePayment.setmPGUrlToHit(directForm.getActionUrl());
                    Intent rechargeActivityIntent = net.one97.paytm.wallet.communicator.b.a().getRechargeActivityIntent(this);
                    boolean z = true;
                    rechargeActivityIntent.putExtra("intent_extra_is_offline_pg", true);
                    rechargeActivityIntent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
                    rechargeActivityIntent.putExtra("is_postpaid", k.a((Object) l.getPayMode(), (Object) "PAYTM_DIGITAL_CREDIT"));
                    rechargeActivityIntent.putExtra("is_ppb_transaction", k.a((Object) l.getPayMode(), (Object) SDKConstants.AI_KEY_PPBL));
                    rechargeActivityIntent.putExtra("is_upi", k.a((Object) l.getPayMode(), (Object) "UPI"));
                    if (!k.a((Object) l.getPayMode(), (Object) SDKConstants.DEBIT) && !p.a(l.getPayMode(), SDKConstants.CREDIT, true)) {
                        z = false;
                    }
                    rechargeActivityIntent.putExtra("is_card_transaction", z);
                    rechargeActivityIntent.putExtra("is_net_banking_transaction", k.a((Object) l.getPayMode(), (Object) "NET_BANKING"));
                    if (!TextUtils.isEmpty(l.getCardFirstSixDigit()) && !TextUtils.isEmpty(l.getCardLastFourDigit()) && !TextUtils.isEmpty(l.getExpiryDate()) && !TextUtils.isEmpty(this.f56943f)) {
                        rechargeActivityIntent.putExtra("card_first_six_digit", l.getCardFirstSixDigit());
                        rechargeActivityIntent.putExtra("card_last_four_digit", l.getCardLastFourDigit());
                        rechargeActivityIntent.putExtra("card_expiry_date", l.getExpiryDate());
                        rechargeActivityIntent.putExtra("one_click_info", this.f56943f);
                    }
                    startActivityForResult(rechargeActivityIntent, this.f56939b);
                }
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f56939b) {
            setResult(i3, intent);
            finish();
        }
    }

    public final void d() {
        g();
    }

    public final void e() {
        this.f56938a = true;
    }

    public final void f() {
        AppCompatTextView appCompatTextView = this.j;
        if (appCompatTextView == null) {
            k.a("lytErrorTv");
        }
        appCompatTextView.setVisibility(8);
        AppCompatTextView appCompatTextView2 = this.f56946i;
        if (appCompatTextView2 == null) {
            k.a("lytSuccessTv");
        }
        appCompatTextView2.setVisibility(8);
        AppCompatTextView appCompatTextView3 = this.k;
        if (appCompatTextView3 == null) {
            k.a("lytNoInternetTv");
        }
        appCompatTextView3.setVisibility(0);
        AppCompatTextView appCompatTextView4 = this.k;
        if (appCompatTextView4 == null) {
            k.a("lytNoInternetTv");
        }
        appCompatTextView4.postDelayed(new e(this), 5000);
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRNativeOTPActivity f56950a;

        e(AJRNativeOTPActivity aJRNativeOTPActivity) {
            this.f56950a = aJRNativeOTPActivity;
        }

        public final void run() {
            AJRNativeOTPActivity.c(this.f56950a).setVisibility(8);
        }
    }
}
