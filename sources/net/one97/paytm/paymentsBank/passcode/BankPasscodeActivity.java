package net.one97.paytm.paymentsBank.passcode;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.model.BankToken;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.model.slfd.SlfdModel;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDTrialRedeemAmount;
import net.one97.paytm.paymentsBank.utils.k;
import net.one97.paytm.paymentsBank.utils.m;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.CJRGTMConstants;

public class BankPasscodeActivity extends PBBaseActivity implements PinEntryView.b {
    /* access modifiers changed from: private */
    public static final int A = A;
    public static final a r = new a((byte) 0);
    /* access modifiers changed from: private */
    public static final String w = w;
    /* access modifiers changed from: private */
    public static final String x = x;
    /* access modifiers changed from: private */
    public static final String y = "from";
    /* access modifiers changed from: private */
    public static final String z = z;
    private HashMap B;

    /* renamed from: b  reason: collision with root package name */
    public a f18582b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f18583c;

    /* renamed from: d  reason: collision with root package name */
    public PinEntryView f18584d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f18585e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18586f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18587g;

    /* renamed from: h  reason: collision with root package name */
    public Button f18588h;

    /* renamed from: i  reason: collision with root package name */
    public SlfdModel f18589i;
    public FDTrialRedeemAmount j;
    public TextView k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public LinearLayout o;
    public LinearLayout p;
    public CheckBox q;
    private boolean s;
    private String t;
    private String u = "0.0";
    private String v;

    public final View a(int i2) {
        if (this.B == null) {
            this.B = new HashMap();
        }
        View view = (View) this.B.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.B.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<net.one97.paytm.bankCommon.b.c<? extends IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankPasscodeActivity f18590a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18591b;

        b(BankPasscodeActivity bankPasscodeActivity, String str) {
            this.f18590a = bankPasscodeActivity;
            this.f18591b = str;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            if (cVar == null) {
                return;
            }
            if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                this.f18590a.ah_();
                T t = cVar.f16217b;
                if (t != null) {
                    BankToken bankToken = (BankToken) t;
                    if (TextUtils.isEmpty(bankToken.getmMessage())) {
                        net.one97.paytm.bankCommon.mapping.c.a(this.f18590a, "biometric_settings_setup", "passcode_input_sucess", "", "", "/bank/biometric_settings_setup/validate_passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        BankPasscodeActivity bankPasscodeActivity = this.f18590a;
                        m.a(bankPasscodeActivity, "passcode_right", "passcode ppbl", BankPasscodeActivity.b(bankPasscodeActivity), "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                        Intent intent = new Intent();
                        if (this.f18590a.getIntent().hasExtra("flow") && k.a((Object) this.f18590a.getIntent().getStringExtra("flow"), (Object) "flow_biometric")) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("xCode", this.f18591b);
                            this.f18590a.setResult(-1, intent2);
                            this.f18590a.onBackPressed();
                        }
                        if (this.f18590a.getIntent().hasExtra("flow") && k.a((Object) this.f18590a.getIntent().getStringExtra("flow"), (Object) "flow_h5")) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("passcode", bankToken.getAccessToken());
                            this.f18590a.setResult(-1, intent3);
                            this.f18590a.onBackPressed();
                        }
                        if (this.f18590a.getIntent().getBooleanExtra("r_token", false)) {
                            intent.putExtra("passcode", bankToken.getAccessToken());
                            this.f18590a.setResult(-1, intent);
                            this.f18590a.finish();
                        } else if (this.f18590a.getIntent().hasExtra("r_intent")) {
                            Parcelable parcelableExtra = this.f18590a.getIntent().getParcelableExtra("r_intent");
                            if (parcelableExtra != null) {
                                Intent intent4 = (Intent) parcelableExtra;
                                intent4.putExtra("passcode", bankToken.getAccessToken());
                                this.f18590a.startActivity(intent4);
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.content.Intent");
                        } else {
                            new Intent();
                            this.f18590a.setResult(-1);
                            this.f18590a.finish();
                        }
                    } else {
                        BankPasscodeActivity bankPasscodeActivity2 = this.f18590a;
                        m.a(bankPasscodeActivity2, "passcode_wrong", "passcode ppbl", BankPasscodeActivity.b(bankPasscodeActivity2), "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                        net.one97.paytm.bankCommon.mapping.c.a(this.f18590a, "biometric_settings_setup", "passcode_input_failure", bankToken.getmMessage(), "", "/bank/biometric_settings_setup/validate_passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        this.f18590a.f().a();
                        TextView textView = (TextView) this.f18590a.a(R.id.tv_passcode_error);
                        k.a((Object) textView, "tv_passcode_error");
                        textView.setText(bankToken.getmMessage());
                        this.f18590a.a(true);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.model.BankToken");
                }
            } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.PROGRESS) {
                BankPasscodeActivity bankPasscodeActivity3 = this.f18590a;
                bankPasscodeActivity3.a(bankPasscodeActivity3, bankPasscodeActivity3.getString(R.string.please_wait_progress_msg));
            } else {
                this.f18590a.ah_();
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankPasscodeActivity f18596a;

        g(BankPasscodeActivity bankPasscodeActivity) {
            this.f18596a = bankPasscodeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            if (cVar != null) {
                this.f18596a.ah_();
                boolean z = false;
                if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                    T t = cVar.f16217b;
                    if (t != null) {
                        String str = (String) t;
                        net.one97.paytm.bankCommon.mapping.c.a(this.f18596a, "biometric_settings_setup", "passcode_input_sucess", "", "", "/bank/biometric_settings_setup/validate_passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        BankPasscodeActivity bankPasscodeActivity = this.f18596a;
                        m.a(bankPasscodeActivity, "passcode_right", "passcode ppbl", BankPasscodeActivity.b(bankPasscodeActivity), "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                        Intent intent = new Intent();
                        if (this.f18596a.getIntent().hasExtra("flow") && k.a((Object) this.f18596a.getIntent().getStringExtra("flow"), (Object) "flow_biometric")) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("xCode", this.f18596a.e().f18600b);
                            this.f18596a.setResult(-1, intent2);
                            this.f18596a.onBackPressed();
                        }
                        if (this.f18596a.getIntent().hasExtra("flow") && k.a((Object) this.f18596a.getIntent().getStringExtra("flow"), (Object) "flow_h5")) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("passcode", str);
                            this.f18596a.setResult(-1, intent3);
                            this.f18596a.onBackPressed();
                        }
                        if (this.f18596a.getIntent().getBooleanExtra("r_token", false)) {
                            intent.putExtra("passcode", str);
                            this.f18596a.setResult(-1, intent);
                            this.f18596a.finish();
                        } else if (this.f18596a.getIntent().hasExtra("r_intent")) {
                            Parcelable parcelableExtra = this.f18596a.getIntent().getParcelableExtra("r_intent");
                            if (parcelableExtra != null) {
                                Intent intent4 = (Intent) parcelableExtra;
                                intent4.putExtra("passcode", this.f18596a.e().f18600b);
                                this.f18596a.startActivity(intent4);
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.content.Intent");
                        } else {
                            new Intent();
                            this.f18596a.setResult(-1);
                            this.f18596a.finish();
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (cVar.f16216a == net.one97.paytm.bankCommon.b.d.ERROR) {
                    Throwable th = cVar.f16218c;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        BankPasscodeActivity bankPasscodeActivity2 = this.f18596a;
                        m.a(bankPasscodeActivity2, "passcode_wrong", "passcode ppbl", BankPasscodeActivity.b(bankPasscodeActivity2), "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                        String str2 = null;
                        net.one97.paytm.bankCommon.mapping.c.a(this.f18596a, "biometric_settings_setup", "passcode_input_failure", networkCustomError != null ? networkCustomError.getAlertMessage() : null, "", "/bank/biometric_settings_setup/validate_passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        this.f18596a.f().a();
                        CharSequence alertMessage = networkCustomError != null ? networkCustomError.getAlertMessage() : null;
                        if (alertMessage == null || alertMessage.length() == 0) {
                            z = true;
                        }
                        if (!z) {
                            TextView textView = (TextView) this.f18596a.a(R.id.tv_passcode_error);
                            k.a((Object) textView, "tv_passcode_error");
                            if (networkCustomError != null) {
                                str2 = networkCustomError.getAlertMessage();
                            }
                            textView.setText(str2);
                            this.f18596a.a(true);
                            return;
                        }
                        BankPasscodeActivity bankPasscodeActivity3 = this.f18596a;
                        com.paytm.utility.b.b((Context) bankPasscodeActivity3, bankPasscodeActivity3.getString(R.string.error), this.f18596a.getString(R.string.some_went_wrong));
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                }
            }
        }
    }

    public static final /* synthetic */ String b(BankPasscodeActivity bankPasscodeActivity) {
        String str = bankPasscodeActivity.t;
        if (str == null) {
            k.a("source");
        }
        return str;
    }

    public final void a(String str) {
        b(false);
        b(str);
    }

    public final void af_() {
        a(false);
    }

    public final a e() {
        a aVar = this.f18582b;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public final PinEntryView f() {
        PinEntryView pinEntryView = this.f18584d;
        if (pinEntryView == null) {
            k.a("pinEntryView");
        }
        return pinEntryView;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Activity activity, String str) {
            k.c(activity, "ctx");
            k.c(str, "title");
            Intent intent = new Intent(activity, BankPasscodeActivity.class);
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", str);
            intent.putExtra("r_token", true);
            intent.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
            activity.startActivityForResult(intent, 121);
        }

        public static void a(Activity activity, String str, String str2, int i2) {
            k.c(activity, "ctx");
            k.c(str, "title");
            k.c(str2, BankPasscodeActivity.w);
            Intent intent = new Intent(activity, BankPasscodeActivity.class);
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", str);
            intent.putExtra(BankPasscodeActivity.w, str2);
            intent.putExtra("r_token", true);
            intent.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
            activity.startActivityForResult(intent, i2);
        }

        public static void a(Activity activity, String str, String str2, String str3) {
            k.c(activity, "ctx");
            k.c(str, "title");
            k.c(str2, BankPasscodeActivity.w);
            k.c(str3, BankPasscodeActivity.x);
            Intent intent = new Intent(activity, BankPasscodeActivity.class);
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", str);
            intent.putExtra(BankPasscodeActivity.w, str2);
            intent.putExtra(BankPasscodeActivity.x, str3);
            intent.putExtra("r_token", true);
            intent.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
            activity.startActivityForResult(intent, 121);
        }
    }

    public void onCreate(Bundle bundle) {
        com.paytm.utility.b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_passcode);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        if (getIntent().hasExtra(y)) {
            this.v = getIntent().getStringExtra(y);
        }
        View findViewById = findViewById(R.id.titlePasscodeScreen);
        k.a((Object) findViewById, "findViewById(R.id.titlePasscodeScreen)");
        this.f18587g = (TextView) findViewById;
        TextView textView = this.f18587g;
        if (textView == null) {
            k.a("titlePasscodeScreen");
        }
        textView.setText(getIntent().getStringExtra("title"));
        this.s = getIntent().getBooleanExtra("bank_scope", false);
        if (!TextUtils.isEmpty(this.v)) {
            p.a(this.v, z, false);
        }
        if (getIntent().hasExtra(w)) {
            TextView textView2 = (TextView) a(R.id.desc);
            k.a((Object) textView2, w);
            textView2.setText(getIntent().getStringExtra(w));
            TextView textView3 = (TextView) a(R.id.desc);
            k.a((Object) textView3, w);
            textView3.setVisibility(0);
        }
        if (getIntent().hasExtra(x)) {
            TextView textView4 = (TextView) a(R.id.hint_tv);
            k.a((Object) textView4, "hint_tv");
            textView4.setVisibility(0);
        }
        k.a aVar = net.one97.paytm.paymentsBank.utils.k.f19520a;
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "application");
        ai a2 = new al((ao) this, (al.b) k.a.a(application)).a(a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProvider(this,P…t(PasscodeVM::class.java)");
        this.f18582b = (a) a2;
        View findViewById2 = findViewById(R.id.ll_center_header_wrapper);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.ll_center_header_wrapper)");
        this.o = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.ll_left_header_wrapper);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.ll_left_header_wrapper)");
        this.p = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.iv_back);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById<ImageView>(R.id.iv_back)");
        this.f18583c = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.tv_passcode_error);
        kotlin.g.b.k.a((Object) findViewById5, "findViewById<TextView>(R.id.tv_passcode_error)");
        this.f18585e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.tv_forgot_passcode);
        kotlin.g.b.k.a((Object) findViewById6, "findViewById<TextView>(R.id.tv_forgot_passcode)");
        this.f18586f = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.btn_proceed);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById<Button>(R.id.btn_proceed)");
        this.f18588h = (Button) findViewById7;
        View findViewById8 = findViewById(R.id.otpView);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById<PinEntryView>(R.id.otpView)");
        this.f18584d = (PinEntryView) findViewById8;
        PinEntryView pinEntryView = this.f18584d;
        if (pinEntryView == null) {
            kotlin.g.b.k.a("pinEntryView");
        }
        pinEntryView.setOnPinEnteredListener(this);
        TextView textView5 = this.f18586f;
        if (textView5 == null) {
            kotlin.g.b.k.a("tvForgotPass");
        }
        textView5.setOnClickListener(new c(this));
        ImageView imageView = this.f18583c;
        if (imageView == null) {
            kotlin.g.b.k.a("img_back");
        }
        imageView.setOnClickListener(new d(this));
        View findViewById9 = findViewById(R.id.tv_requested_amount_value);
        kotlin.g.b.k.a((Object) findViewById9, "findViewById<TextView>(R…v_requested_amount_value)");
        this.k = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.tv_interest_earned_value);
        kotlin.g.b.k.a((Object) findViewById10, "findViewById<TextView>(R…tv_interest_earned_value)");
        this.l = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.tv_total_transfer_amount_value);
        kotlin.g.b.k.a((Object) findViewById11, "findViewById<TextView>(R…al_transfer_amount_value)");
        this.m = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.rl_int_wrapper);
        kotlin.g.b.k.a((Object) findViewById12, "findViewById<RelativeLayout>(R.id.rl_int_wrapper)");
        this.n = (RelativeLayout) findViewById12;
        if (getIntent().hasExtra("A")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("A");
            if (serializableExtra != null) {
                this.f18589i = (SlfdModel) serializableExtra;
                SlfdModel slfdModel = this.f18589i;
                if (slfdModel == null) {
                    kotlin.g.b.k.a("slfdModel");
                }
                if (slfdModel != null) {
                    RelativeLayout relativeLayout = this.n;
                    if (relativeLayout == null) {
                        kotlin.g.b.k.a("interestWrapper");
                    }
                    relativeLayout.setVisibility(0);
                    SlfdModel slfdModel2 = this.f18589i;
                    if (slfdModel2 == null) {
                        kotlin.g.b.k.a("slfdModel");
                    }
                    TextView textView6 = this.l;
                    if (textView6 == null) {
                        kotlin.g.b.k.a("tvInterestEarned");
                    }
                    textView6.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(slfdModel2.getInterestEarned()))}));
                    TextView textView7 = this.k;
                    if (textView7 == null) {
                        kotlin.g.b.k.a("tvRequestedAmount");
                    }
                    textView7.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(slfdModel2.getNetInvestedAmount()))}));
                    TextView textView8 = this.m;
                    if (textView8 == null) {
                        kotlin.g.b.k.a("tvTotalTransferAmount");
                    }
                    textView8.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(slfdModel2.getNetInvestedAmount() + slfdModel2.getInterestEarned()))}));
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.model.slfd.SlfdModel");
            }
        } else if (getIntent().hasExtra("extra_fd_trial_redeem")) {
            Serializable serializableExtra2 = getIntent().getSerializableExtra("extra_fd_trial_redeem");
            if (serializableExtra2 != null) {
                this.j = (FDTrialRedeemAmount) serializableExtra2;
                FDTrialRedeemAmount fDTrialRedeemAmount = this.j;
                if (fDTrialRedeemAmount == null) {
                    kotlin.g.b.k.a("fdTrialRedeemAmount");
                }
                if (fDTrialRedeemAmount != null) {
                    RelativeLayout relativeLayout2 = this.n;
                    if (relativeLayout2 == null) {
                        kotlin.g.b.k.a("interestWrapper");
                    }
                    relativeLayout2.setVisibility(0);
                    String stringExtra = getIntent().getStringExtra("slfd_amount");
                    kotlin.g.b.k.a((Object) stringExtra, "intent.getStringExtra(SlfdConstants.EXTRA_AMOUNT)");
                    this.u = stringExtra;
                    FDTrialRedeemAmount fDTrialRedeemAmount2 = this.j;
                    if (fDTrialRedeemAmount2 == null) {
                        kotlin.g.b.k.a("fdTrialRedeemAmount");
                    }
                    try {
                        double parseDouble = Double.parseDouble(this.u);
                        double d2 = 0.0d;
                        for (FDTrialRedeemAmount.a next : fDTrialRedeemAmount2.getFdList()) {
                            kotlin.g.b.k.a((Object) next, "fd");
                            d2 += next.getInterestEarned();
                        }
                        TextView textView9 = this.l;
                        if (textView9 == null) {
                            kotlin.g.b.k.a("tvInterestEarned");
                        }
                        textView9.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(d2))}));
                        TextView textView10 = this.k;
                        if (textView10 == null) {
                            kotlin.g.b.k.a("tvRequestedAmount");
                        }
                        textView10.setText(getString(R.string.rs_str, new Object[]{this.u}));
                        TextView textView11 = this.m;
                        if (textView11 == null) {
                            kotlin.g.b.k.a("tvTotalTransferAmount");
                        }
                        textView11.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(parseDouble + d2))}));
                    } catch (Exception unused) {
                        RelativeLayout relativeLayout3 = this.n;
                        if (relativeLayout3 == null) {
                            kotlin.g.b.k.a("interestWrapper");
                        }
                        relativeLayout3.setVisibility(8);
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.slfd.interestprojection.model.FDTrialRedeemAmount");
            }
        } else {
            RelativeLayout relativeLayout4 = this.n;
            if (relativeLayout4 == null) {
                kotlin.g.b.k.a("interestWrapper");
            }
            relativeLayout4.setVisibility(8);
        }
        Button button = this.f18588h;
        if (button == null) {
            kotlin.g.b.k.a("btnProceed");
        }
        button.setOnClickListener(new e(this));
        View findViewById13 = findViewById(R.id.payment_bank_set_passcode_img_show_hide);
        kotlin.g.b.k.a((Object) findViewById13, "findViewById<CheckBox>(R…t_passcode_img_show_hide)");
        this.q = (CheckBox) findViewById13;
        CheckBox checkBox = this.q;
        if (checkBox == null) {
            kotlin.g.b.k.a("mBtnShowHide");
        }
        checkBox.setOnClickListener(new f(this));
        b(true);
        if (getIntent().hasExtra("src")) {
            String stringExtra2 = getIntent().getStringExtra("src");
            kotlin.g.b.k.a((Object) stringExtra2, "intent.getStringExtra(ARG_SOURCE)");
            this.t = stringExtra2;
        } else {
            this.t = "";
        }
        Context context = this;
        String str = this.t;
        if (str == null) {
            kotlin.g.b.k.a("source");
        }
        m.a(context, "passcode_screen_load_successful", "passcode ppbl", str, "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        a aVar2 = this.f18582b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        aVar2.f18599a.observe(this, new g(this));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankPasscodeActivity f18594a;

        e(BankPasscodeActivity bankPasscodeActivity) {
            this.f18594a = bankPasscodeActivity;
        }

        public final void onClick(View view) {
            String obj = this.f18594a.f().getText().toString();
            if (obj.length() != this.f18594a.f().getDigits()) {
                ((TextView) this.f18594a.a(R.id.tv_passcode_error)).setText(R.string.pb_forgot_passwrd_invalid_passcode);
                this.f18594a.a(true);
            } else if (this.f18594a.getIntent().getBooleanExtra("r_token", false)) {
                this.f18594a.b(obj);
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankPasscodeActivity f18595a;

        f(BankPasscodeActivity bankPasscodeActivity) {
            this.f18595a = bankPasscodeActivity;
        }

        public final void onClick(View view) {
            CheckBox checkBox = this.f18595a.q;
            if (checkBox == null) {
                kotlin.g.b.k.a("mBtnShowHide");
            }
            if (!checkBox.isChecked()) {
                m.a(this.f18595a, "passcode_hide", "forgot passcode", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                this.f18595a.f().setMask("•");
                this.f18595a.f().setText(this.f18595a.f().getText().toString());
                return;
            }
            m.a(this.f18595a, "passcode_show", "forgot passcode", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            this.f18595a.f().setMask((String) null);
            this.f18595a.f().setText(this.f18595a.f().getText().toString());
        }
    }

    private void b(int i2) {
        PinEntryView pinEntryView = this.f18584d;
        if (pinEntryView == null) {
            kotlin.g.b.k.a("pinEntryView");
        }
        if (pinEntryView != null) {
            PinEntryView pinEntryView2 = this.f18584d;
            if (pinEntryView2 == null) {
                kotlin.g.b.k.a("pinEntryView");
            }
            pinEntryView2.setDigitBackground(i2);
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2) {
        if (z2) {
            b(R.color.fp_color_ffefef);
            TextView textView = (TextView) a(R.id.tv_passcode_error);
            kotlin.g.b.k.a((Object) textView, "tv_passcode_error");
            textView.setVisibility(0);
        } else {
            b(R.color.prv_passcode_color);
            TextView textView2 = (TextView) a(R.id.tv_passcode_error);
            kotlin.g.b.k.a((Object) textView2, "tv_passcode_error");
            textView2.setVisibility(4);
        }
        if (z2) {
            int i2 = net.one97.paytm.bankOpen.R.drawable.pin_view_red_bg;
        } else {
            int i3 = R.drawable.pin_view_gray_bg;
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankPasscodeActivity f18592a;

        c(BankPasscodeActivity bankPasscodeActivity) {
            this.f18592a = bankPasscodeActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
            if (net.one97.paytm.payments.c.c.b.b()) {
                net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                net.one97.paytm.payments.c.c.b.d(this.f18592a, new Bundle());
                return;
            }
            BankPasscodeActivity bankPasscodeActivity = this.f18592a;
            m.a(bankPasscodeActivity, "passcode_forgot", "passcode ppbl", BankPasscodeActivity.b(bankPasscodeActivity), "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            if (net.one97.paytm.bankCommon.mapping.a.c((Context) this.f18592a)) {
                ForgotPasscodeChallengesActivity.a((Context) this.f18592a);
            } else {
                this.f18592a.d();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankPasscodeActivity f18593a;

        d(BankPasscodeActivity bankPasscodeActivity) {
            this.f18593a = bankPasscodeActivity;
        }

        public final void onClick(View view) {
            this.f18593a.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        if (getIntent().hasExtra("flow") && kotlin.g.b.k.a((Object) getIntent().getStringExtra("flow"), (Object) "flow_biometric")) {
            net.one97.paytm.bankCommon.mapping.c.a(this, "biometric_settings_setup", "passcode_input", "", "", "/bank/biometric_settings_setup/validate_passcode", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        }
        a aVar = this.f18582b;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        if (str == null) {
            kotlin.g.b.k.a();
        }
        aVar.a(str);
        net.one97.paytm.bankCommon.utils.d.b();
        Boolean Q = net.one97.paytm.bankCommon.utils.d.Q();
        kotlin.g.b.k.a((Object) Q, "PBGTMHelper.getInstance(…nkScopeTokenFlowEnabled()");
        if (!Q.booleanValue() || !this.s) {
            if (this.f18582b == null) {
                kotlin.g.b.k.a("viewModel");
            }
            a.a((Context) this, str).observe(this, new b(this, str));
            return;
        }
        a(this, getString(R.string.please_wait_progress_msg));
        kotlin.g.b.k.a((Object) net.one97.paytm.bankCommon.utils.d.b(), "PBGTMHelper.getInstance()");
        String a2 = com.paytm.e.a.b.a(net.one97.paytm.bankCommon.utils.d.O(), str);
        kotlin.g.b.k.a((Object) a2, "OfflineDataEncryption.en…PasscodeRsaKey, passcode)");
        a aVar2 = this.f18582b;
        if (aVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String name = BankPasscodeActivity.class.getName();
        kotlin.g.b.k.a((Object) name, "BankPasscodeActivity::class.java.name");
        aVar2.a(a2, name);
    }

    public static final class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankPasscodeActivity f18597a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18598b;

        h(BankPasscodeActivity bankPasscodeActivity, boolean z) {
            this.f18597a = bankPasscodeActivity;
            this.f18598b = z;
        }

        public final void run() {
            try {
                this.f18597a.f().getEditText().requestFocus();
                Object systemService = this.f18597a.getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    if (inputMethodManager != null && this.f18598b) {
                        inputMethodManager.showSoftInput(this.f18597a.f().getEditText(), 0);
                    } else if (inputMethodManager != null && !this.f18598b) {
                        inputMethodManager.hideSoftInputFromWindow(this.f18597a.f().getWindowToken(), 0);
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private final void b(boolean z2) {
        PinEntryView pinEntryView = this.f18584d;
        if (pinEntryView == null) {
            kotlin.g.b.k.a("pinEntryView");
        }
        pinEntryView.getEditText().postDelayed(new h(this, z2), 200);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 9856 && i3 == -1) {
            o.a().launchMainActivityWithBankTab(this);
        }
        if (i2 == 7 && i3 == -1 && intent != null && intent.hasExtra("forgot_passcode_access")) {
            net.one97.paytm.paymentsBank.h.a a2 = o.a();
            kotlin.g.b.k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
            Intent intent2 = new Intent(this, a2.getAJRForgotPasscodeClass());
            intent2.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
            startActivityForResult(intent2, 9856);
        }
    }
}
