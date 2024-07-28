package net.one97.paytm.paymentsBank.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.biometric.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aj;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import javax.crypto.Cipher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRLogoutAllDevices;
import net.one97.paytm.bankCommon.model.PBVerifyPasscodeResponse;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.payments.activity.AadharValidatePasscode;
import net.one97.paytm.payments.b.b.a;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.BlockedActivity;
import net.one97.paytm.paymentsBank.activity.PBEnteringFlowPasscodeActivity;
import net.one97.paytm.paymentsBank.activity.PBWalletPassBookBridgeActivity;
import net.one97.paytm.paymentsBank.biometricAuthWall.e;
import net.one97.paytm.paymentsBank.biometricAuthWall.f;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.fragment.BankTabPasscodeFragment;
import net.one97.paytm.paymentsBank.i.a;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.k;
import net.one97.paytm.paymentsBank.utils.l;
import net.one97.paytm.paymentsBank.utils.m;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class BankTabPasscodeFragment extends h implements g.a, g.b<IJRPaytmDataModel>, e.a {

    /* renamed from: e  reason: collision with root package name */
    private static int f18447e = 131;
    private Runnable A = new Runnable() {
        public final void run() {
            BankTabPasscodeFragment.k(BankTabPasscodeFragment.this);
            BankTabPasscodeFragment.this.k.clearFocus();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    BroadcastReceiver f18448a = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            try {
                if ("templogout".equalsIgnoreCase(intent.getAction())) {
                    BankTabPasscodeFragment.this.k.setText("");
                    BankTabPasscodeFragment.b(BankTabPasscodeFragment.this);
                    if (BankTabPasscodeFragment.this.getActivity() != null && o.a().isInstanceOfAJRMainActivity(BankTabPasscodeFragment.this.getActivity())) {
                        o.a().setBankPassCodeInAJRMainActivity(BankTabPasscodeFragment.this.getActivity(), true);
                    }
                }
            } catch (Exception unused) {
            }
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public View f18449b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f18450c;

    /* renamed from: d  reason: collision with root package name */
    BroadcastReceiver f18451d = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            try {
                if (BankTabPasscodeFragment.this.isAdded() && "open_keyboard_bank_action".equalsIgnoreCase(intent.getAction())) {
                    BankTabPasscodeFragment.this.k.getEditText().postDelayed(new Runnable() {
                        public final void run() {
                            BankTabPasscodeFragment.AnonymousClass2.this.a();
                        }
                    }, 200);
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a() {
            try {
                BankTabPasscodeFragment.this.k.getEditText().requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) BankTabPasscodeFragment.this.getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(BankTabPasscodeFragment.this.k.getEditText(), 0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private Fragment f18452f;

    /* renamed from: g  reason: collision with root package name */
    private Context f18453g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressDialog f18454h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f18455i;
    /* access modifiers changed from: private */
    public TextView j;
    /* access modifiers changed from: private */
    public PinEntryView k;
    private Handler l = new Handler();
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public Intent n;
    /* access modifiers changed from: private */
    public a o;
    private TextView p;
    private boolean q = false;
    private CheckBox r;
    private RelativeLayout s;
    private f t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private boolean x;
    private boolean y;
    private Runnable z = new Runnable() {
        public final void run() {
            if (BankTabPasscodeFragment.this.getUserVisibleHint() && BankTabPasscodeFragment.this.m) {
                BankTabPasscodeFragment.this.k.setText("");
                BankTabPasscodeFragment.this.j.setText("");
                BankTabPasscodeFragment.this.b(false);
                BankTabPasscodeFragment bankTabPasscodeFragment = BankTabPasscodeFragment.this;
                bankTabPasscodeFragment.k.getEditText().postDelayed(new Runnable(bankTabPasscodeFragment.k.getEditText()) {
                    private final /* synthetic */ View f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        BankTabPasscodeFragment.this.e(this.f$1);
                    }
                }, 100);
            }
        }
    };

    public /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (isAdded()) {
            a(false);
            if (iJRPaytmDataModel instanceof PBVerifyPasscodeResponse) {
                PBVerifyPasscodeResponse pBVerifyPasscodeResponse = (PBVerifyPasscodeResponse) iJRPaytmDataModel;
                if (pBVerifyPasscodeResponse.getError() == null) {
                    b(false);
                    if (!TextUtils.isEmpty(pBVerifyPasscodeResponse.getAccessToken())) {
                        int i2 = this.f18455i;
                        if (i2 == 0) {
                            Intent intent = new Intent();
                            intent.putExtra("passcode", pBVerifyPasscodeResponse.getAccessToken());
                            getActivity().setResult(-1, intent);
                            getActivity().finish();
                        } else if (i2 == 100) {
                            d(pBVerifyPasscodeResponse.getAccessToken());
                            this.k.setText("");
                        }
                    }
                } else if (pBVerifyPasscodeResponse.getResponseCodeLocal() == 504) {
                    f();
                    b.b((Context) getActivity(), getString(R.string.error), pBVerifyPasscodeResponse.getErrorDescription());
                } else {
                    this.j.setText(pBVerifyPasscodeResponse.getErrorDescription());
                    b(true);
                    startActivity(new Intent(getActivity(), PBEnteringFlowPasscodeActivity.class));
                }
            } else if (!(iJRPaytmDataModel instanceof PBCJRLogoutAllDevices)) {
            } else {
                if (((PBCJRLogoutAllDevices) iJRPaytmDataModel).getResponseCode().equalsIgnoreCase("127")) {
                    startActivityForResult(new Intent(getActivity(), AadharValidatePasscode.class), CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
                } else {
                    b.b((Context) getActivity(), getString(R.string.error), getString(R.string.pb_bank_passcode_error));
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bank_enter_passcode, viewGroup, false);
        this.f18453g = getContext();
        this.f18453g.getResources().getString(R.string.passcode_saving_account);
        if (bundle != null && o.a().isInstanceOfAJRMainActivity(getActivity())) {
            o.a().setBankPassCodeInAJRMainActivity(getActivity(), bundle.getBoolean("showPasscode"));
        }
        this.f18449b = inflate.findViewById(R.id.iv_fingerprint_validate);
        this.f18450c = (TextView) inflate.findViewById(R.id.tv_fingerprint_error);
        this.s = (RelativeLayout) inflate.findViewById(R.id.scrollview_child);
        this.p = (TextView) inflate.findViewById(R.id.bottominfo_tv);
        this.w = (ImageView) inflate.findViewById(R.id.iv_bottom);
        View findViewById = inflate.findViewById(R.id.root_lyt);
        if (getArguments() != null) {
            this.f18455i = getArguments().getInt("redirectTo", 0);
            this.n = (Intent) getArguments().getParcelable("r_intent");
        }
        if (this.f18455i != 100) {
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), 0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, (int) (60.0f / (((float) getActivity().getResources().getDisplayMetrics().densityDpi) / 160.0f)));
            this.s.setLayoutParams(layoutParams);
        }
        Button button = (Button) inflate.findViewById(R.id.btn_proceed);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_forgot_passcode);
        this.j = (TextView) inflate.findViewById(R.id.tv_passcode_error);
        this.k = (PinEntryView) inflate.findViewById(R.id.otpView);
        this.u = (TextView) inflate.findViewById(R.id.titlePasscodeScreen);
        this.v = (TextView) inflate.findViewById(R.id.subtitlePasscodeScreen);
        if (getArguments() != null) {
            if (getArguments().containsKey(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK)) {
                if (getArguments().getBoolean(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK)) {
                    this.u.setText(getString(R.string.pb_fd_enter_paytm_payments_bank_npasscode_to_view_passbook));
                }
            } else if (getArguments().getBoolean("isFromH5", false)) {
                this.u.setText(getString(R.string.login_enter_passcode_title));
                this.v.setVisibility(0);
            } else if (getArguments() != null && getArguments().containsKey("show_feature_specific_view")) {
                String string = getArguments().getString("show_feature_specific_view");
                if (!TextUtils.isEmpty(string)) {
                    if (string.equals(a.b.DEVICE_BINDING_WALLET.name())) {
                        this.u.setText(getString(R.string.pb_passcode_device_binding_title));
                        this.p.setText(getString(R.string.pb_passcode_device_binding_bottom_text));
                        this.p.setVisibility(0);
                    } else if (string.equals(a.b.DEVICE_BINDING_PASSBOOK.name())) {
                        this.u.setText(getString(R.string.pb_passcode_consent_passbook_device_binding_title));
                        this.p.setText(getString(R.string.pb_setpasscode_device_binding_bottom_text));
                        this.p.setVisibility(0);
                    }
                }
            }
        }
        this.k.setOnPinEnteredListener(new PinEntryView.b() {
            public final void a(String str) {
                if (BankTabPasscodeFragment.this.getArguments() != null && BankTabPasscodeFragment.this.getArguments().containsKey("show_feature_specific_view")) {
                    String string = BankTabPasscodeFragment.this.getArguments().getString("show_feature_specific_view");
                    if (!TextUtils.isEmpty(string)) {
                        net.one97.paytm.paymentsBank.e.a.a(BankTabPasscodeFragment.this.getContext(), string, "pc_enter_passcode");
                    }
                }
                BankTabPasscodeFragment.k(BankTabPasscodeFragment.this);
                BankTabPasscodeFragment.this.a(str, false);
            }

            public final void af_() {
                BankTabPasscodeFragment.this.b(false);
            }
        });
        this.r = (CheckBox) inflate.findViewById(R.id.payment_bank_set_passcode_img_show_hide);
        ((ImageView) inflate.findViewById(R.id.iv_back)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankTabPasscodeFragment.this.d(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankTabPasscodeFragment.this.c(view);
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankTabPasscodeFragment.this.b(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankTabPasscodeFragment.this.a(view);
            }
        });
        this.f18454h = new ProgressDialog(this.f18453g);
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.f18448a, new IntentFilter("templogout"));
        getActivity().registerReceiver(this.f18451d, new IntentFilter("open_keyboard_bank_action"));
        b();
        d.b();
        if (d.Q().booleanValue()) {
            this.o = (net.one97.paytm.paymentsBank.i.a) new al((ao) getActivity(), (al.b) k.a(getActivity().getApplication())).a(net.one97.paytm.paymentsBank.i.a.class);
            this.o.f18547a.observe(getViewLifecycleOwner(), new z<c<Object>>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    c cVar = (c) obj;
                    BankTabPasscodeFragment.this.a(false);
                    if (cVar == null) {
                        return;
                    }
                    if (cVar.f16216a.equals(net.one97.paytm.bankCommon.b.d.SUCCESS)) {
                        ValidateTokenApiResponse validateTokenApiResponse = (ValidateTokenApiResponse) cVar.f16217b;
                        if (validateTokenApiResponse == null) {
                            return;
                        }
                        if (validateTokenApiResponse.getResponseCode() == null || validateTokenApiResponse.getResponseCode().intValue() != 200) {
                            net.one97.paytm.bankCommon.mapping.c.a(BankTabPasscodeFragment.this.getActivity(), BankTabPasscodeFragment.this.o.f18549c ? "biometric_login" : "normal_login", "login_failure", validateTokenApiResponse.getMessage(), "", "/bank/saving-account/login", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                            if (validateTokenApiResponse.getResponseCode() != null && validateTokenApiResponse.getResponseCode().intValue() == 4003) {
                                Intent intent = new Intent(BankTabPasscodeFragment.this.getActivity(), BlockedActivity.class);
                                intent.putExtra("message", validateTokenApiResponse.getMessage());
                                BankTabPasscodeFragment.this.startActivity(intent);
                                BankTabPasscodeFragment.this.getActivity().finish();
                            }
                            if (validateTokenApiResponse.getResponseCode() == null || validateTokenApiResponse.getResponseCode().intValue() != 1103 || !BankTabPasscodeFragment.this.o.f18549c) {
                                BankTabPasscodeFragment.this.j.setText(validateTokenApiResponse.getMessage());
                            } else {
                                BankTabPasscodeFragment.this.j.setText(BankTabPasscodeFragment.this.getString(R.string.pb_passcode_changed));
                                net.one97.paytm.bankCommon.h.b.i(o.a().getApplicationContext(), "notsetupedyet");
                                BankTabPasscodeFragment.this.f18449b.setVisibility(8);
                                BankTabPasscodeFragment.this.f18450c.setVisibility(8);
                            }
                            BankTabPasscodeFragment.this.b(true);
                            if (validateTokenApiResponse.getResponseCode().intValue() == 1903) {
                                BankTabPasscodeFragment.this.startActivity(new Intent(BankTabPasscodeFragment.this.getActivity(), PBEnteringFlowPasscodeActivity.class));
                                return;
                            }
                            return;
                        }
                        BankTabPasscodeFragment.this.b(false);
                        BankTabPasscodeFragment.this.k.setText("");
                        net.one97.paytm.bankCommon.mapping.c.a(BankTabPasscodeFragment.this.getActivity(), BankTabPasscodeFragment.this.o.f18549c ? "biometric_login" : "normal_login", "login_success", "", "", "/bank/saving-account/login", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                        int g2 = BankTabPasscodeFragment.this.f18455i;
                        if (g2 != 0) {
                            if (g2 == 100) {
                                BankTabPasscodeFragment bankTabPasscodeFragment = BankTabPasscodeFragment.this;
                                bankTabPasscodeFragment.d(bankTabPasscodeFragment.o.f18550d);
                                BankTabPasscodeFragment.this.j.setText("");
                            }
                        } else if (BankTabPasscodeFragment.this.n != null) {
                            BankTabPasscodeFragment.this.n.putExtra("xCode", BankTabPasscodeFragment.this.o.f18550d);
                            BankTabPasscodeFragment bankTabPasscodeFragment2 = BankTabPasscodeFragment.this;
                            bankTabPasscodeFragment2.startActivity(bankTabPasscodeFragment2.n);
                            BankTabPasscodeFragment.this.getActivity().finish();
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("passcode", "");
                            intent2.putExtra("loginStatus", true);
                            BankTabPasscodeFragment.this.getActivity().setResult(-1, intent2);
                            BankTabPasscodeFragment.this.getActivity().finish();
                        }
                    } else if (cVar.f16216a.equals(net.one97.paytm.bankCommon.b.d.ERROR)) {
                        BankTabPasscodeFragment.this.a(false);
                        NetworkCustomError networkCustomError = (NetworkCustomError) cVar.f16218c;
                        net.one97.paytm.bankCommon.utils.f.a((Context) BankTabPasscodeFragment.this.getActivity(), networkCustomError, networkCustomError.getStatusCode());
                    }
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("action") && "open_passcode_screen".equals(arguments.getString("action"))) {
            this.y = true;
        }
        m.a(getActivity(), "passcode_screen_load_successful", "passcode ppbl", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        return inflate;
    }

    private void a(int i2) {
        PinEntryView pinEntryView = this.k;
        if (pinEntryView != null) {
            pinEntryView.setDigitBackground(i2);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (j.c() && getActivity() != null && this.t == null) {
            this.t = (f) am.a(getActivity()).a(f.class);
            h();
            this.f18449b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BankTabPasscodeFragment.this.f(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        d();
    }

    private void c() {
        this.f18449b.setVisibility(8);
        this.f18450c.setVisibility(8);
    }

    private void d() {
        if (net.one97.paytm.bankCommon.h.b.L(o.a().getApplicationContext()) == null || net.one97.paytm.bankCommon.h.b.L(o.a().getApplicationContext()).isEmpty()) {
            this.f18450c.setText("");
            this.f18450c.setVisibility(8);
            this.f18449b.setVisibility(8);
            return;
        }
        e.b bVar = e.f17453d;
        e eVar = new e(this, e.b.a(getString(R.string.pb_finger_print_login_header), "", getString(R.string.pb_finger_print_login_desc), getString(R.string.pb_use_passcode)));
        String K = net.one97.paytm.bankCommon.h.b.K(o.a().getApplicationContext());
        String L = net.one97.paytm.bankCommon.h.b.L(o.a().getApplicationContext());
        kotlin.g.b.k.c(this, "fragment");
        kotlin.g.b.k.c(K, "iv");
        kotlin.g.b.k.c(L, "encryptedXCode");
        try {
            eVar.f17455b = new androidx.biometric.c((Fragment) this, androidx.core.content.b.f(requireContext()), (c.a) new e.c(eVar, L));
            Cipher cipher = eVar.f17454a;
            if (cipher == null) {
                kotlin.g.b.k.a("deCipher");
            }
            if (eVar.a(cipher, "bank_biometric_key", K)) {
                androidx.biometric.c cVar = eVar.f17455b;
                if (cVar == null) {
                    kotlin.g.b.k.a();
                }
                c.d dVar = eVar.f17456c;
                Cipher cipher2 = eVar.f17454a;
                if (cipher2 == null) {
                    kotlin.g.b.k.a("deCipher");
                }
                cVar.a(dVar, new c.C0197c(cipher2));
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        view.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f18453g.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput((EditText) view, 2);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2) {
        if (!this.y) {
            d.b();
            if (d.Q().booleanValue()) {
                net.one97.paytm.paymentsBank.i.a aVar = this.o;
                if (aVar != null) {
                    aVar.f18549c = z2;
                    kotlin.g.b.k.c(str, "<set-?>");
                    aVar.f18550d = str;
                    try {
                        d.b();
                        String a2 = com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), str);
                        a(true);
                        b(false);
                        e();
                        net.one97.paytm.paymentsBank.i.a aVar2 = this.o;
                        String simpleName = getClass().getSimpleName();
                        kotlin.g.b.k.c(a2, "enteredToken");
                        kotlin.g.b.k.c(simpleName, SDKConstants.EVENT_KEY_SCREEN_NAME);
                        try {
                            Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(aVar2), (kotlin.d.f) null, (CoroutineStart) null, new a.b(aVar2, a2, simpleName, (kotlin.d.d) null), 3, (Object) null);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        try {
            if (b.c(this.f18453g)) {
                a(true);
                d.b();
                String a3 = com.paytm.e.a.b.a(d.a("pb_passcode_rsa_key"), str);
                net.one97.paytm.bankCommon.utils.g gVar = net.one97.paytm.bankCommon.utils.g.f16329a;
                net.one97.paytm.bankCommon.g.f a4 = net.one97.paytm.bankCommon.utils.g.a(this.f18453g, a3, new g.b(z2, str) {
                    private final /* synthetic */ boolean f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onResponse(Object obj) {
                        BankTabPasscodeFragment.this.a(this.f$1, this.f$2, (IJRPaytmDataModel) obj);
                    }
                }, new g.a() {
                    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        BankTabPasscodeFragment.this.a(i2, iJRPaytmDataModel, networkCustomError);
                    }
                }, a.c.PAYMENTSBANK, a.b.SILENT, getClass().getSimpleName());
                a(true);
                b(false);
                e();
                this.f18453g.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(a4);
                return;
            }
            this.j.setText(getString(R.string.check_your_network));
            b(true);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2, String str, IJRPaytmDataModel iJRPaytmDataModel) {
        String str2 = str;
        if (isResumed()) {
            a(false);
            ValidatePasscode validatePasscode = (ValidatePasscode) iJRPaytmDataModel;
            if (validatePasscode.getResponseCode() == 1100 || validatePasscode.getResponseCode() == 1102) {
                b(false);
                this.k.setText("");
                if (z2) {
                    m.a(getActivity(), "biometric_validated", "biometric passcode", "", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                } else {
                    m.a(getActivity(), "passcode_right", "passcode ppbl", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                }
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), z2 ? "biometric_login" : "normal_login", "login_success", "", "", "/bank/saving-account/login", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                int i2 = this.f18455i;
                if (i2 == 0) {
                    Intent intent = this.n;
                    if (intent != null) {
                        intent.putExtra("xCode", str2);
                        startActivity(this.n);
                        getActivity().finish();
                        return;
                    }
                    if (getActivity() != null && (getActivity() instanceof PBWalletPassBookBridgeActivity)) {
                        ((PBWalletPassBookBridgeActivity) getActivity()).g();
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("passcode", "");
                    getActivity().setResult(-1, intent2);
                    getActivity().finish();
                } else if (i2 == 100) {
                    d(str2);
                    this.j.setText("");
                }
            } else {
                net.one97.paytm.bankCommon.mapping.c.a(getActivity(), z2 ? "biometric_login" : "normal_login", "login_failure", validatePasscode.getMessage(), "", "/bank/saving-account/login", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
                m.a(getActivity(), "passcode_wrong", "passcode ppbl", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
                if (validatePasscode.getResponseCode() != 1103 || !z2) {
                    this.j.setText(validatePasscode.getMessage());
                } else {
                    this.j.setText(getString(R.string.pb_passcode_changed));
                    net.one97.paytm.bankCommon.h.b.i(o.a().getApplicationContext(), "notsetupedyet");
                    this.f18449b.setVisibility(8);
                    this.f18450c.setVisibility(8);
                }
                a(R.color.fp_color_ffefef);
                b(true);
                if (validatePasscode.getResponseCode() == 1903) {
                    startActivity(new Intent(getActivity(), PBEnteringFlowPasscodeActivity.class));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isResumed()) {
            a(false);
            net.one97.paytm.bankCommon.utils.f.a((Context) getActivity(), networkCustomError, i2);
        }
    }

    private void e() {
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            if (!this.f18454h.isShowing()) {
                this.f18454h = ProgressDialog.show(getActivity(), "", getString(R.string.pb_please_wait_progress_msg), true);
            }
        } else if (this.f18454h.isShowing()) {
            this.f18454h.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        if (getView() != null) {
            getView().findViewById(R.id.fragment_enter_passcode_lyt_bank_tab).setVisibility(0);
            if (getChildFragmentManager().c("BankTab") == null) {
                net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
                if (net.one97.paytm.payments.c.c.b.f()) {
                    if (!i()) {
                        net.one97.paytm.payments.c.c.c cVar = net.one97.paytm.payments.c.c.c.f17266a;
                        net.one97.paytm.payments.c.c.c.a(str);
                    }
                    Bundle bundle = new Bundle();
                    l a2 = l.a();
                    if (!v.a(a2.f19527d)) {
                        bundle.putString("fd_id", a2.f19527d);
                    }
                    if (!v.a(a2.f19524a)) {
                        bundle.putString("goToScreen", a2.f19524a);
                    }
                    if (!v.a(a2.f19525b)) {
                        bundle.putString("order_id", a2.f19525b);
                    }
                    if (!v.a(a2.f19526c)) {
                        bundle.putString("pdc_qrcode_id", a2.f19526c);
                    }
                    net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
                    net.one97.paytm.payments.c.c.b.e(getActivity(), bundle);
                    a2.f19524a = null;
                    a2.f19528e = null;
                    this.x = true;
                } else {
                    if (i()) {
                        str = null;
                    }
                    this.f18452f = b.c(str);
                    getChildFragmentManager().a().b(R.id.fragment_enter_passcode_lyt_bank_tab, this.f18452f, "BankTab").c();
                }
            }
            getView().findViewById(R.id.fragment_enter_passcode_lyt).setVisibility(8);
            m.a(getActivity(), "passcode_successful", "passcode ppbl", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            if (o.a().isInstanceOfAJRMainActivity(getActivity())) {
                o.a().setBankPassCodeInAJRMainActivity(getActivity(), false);
            }
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isAdded()) {
            if (!b.c((Context) getActivity())) {
                this.k.setText("");
            }
            a(false);
            net.one97.paytm.bankCommon.utils.f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
        }
    }

    private void f() {
        this.k.setText("");
        this.k.requestFocus();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public void onPause() {
        a(false);
        super.onPause();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 9856 && i3 != -1 && o.a().isInstanceOfAJRMainActivity(getActivity())) {
            getActivity().onBackPressed();
        }
        if (i2 == 7 && i3 == -1 && intent != null && intent.hasExtra("forgot_passcode_access")) {
            Intent intent2 = new Intent(getActivity(), AJRForgotPasscode.class);
            intent2.putExtra("forgot_passcode_access", intent.getStringExtra("forgot_passcode_access"));
            startActivityForResult(intent2, 9856);
        }
    }

    public void onDestroyView() {
        getActivity().unregisterReceiver(this.f18451d);
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.f18448a);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (o.a().isInstanceOfAJRMainActivity(getActivity())) {
            bundle.putBoolean("showPasscode", o.a().showBankPassCode(getActivity()));
        }
        super.onSaveInstanceState(bundle);
    }

    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
        if (getView() == null || getView().findViewById(R.id.fragment_enter_passcode_lyt).getVisibility() == 8) {
            this.m = false;
            this.l.removeCallbacks(this.z);
            this.l.removeCallbacks(this.A);
            this.l.postDelayed(this.A, 500);
        } else if (!j.c()) {
            c();
            g();
        } else if (isAdded() && getActivity() != null) {
            if (net.one97.paytm.bankCommon.h.b.j(o.a().getApplicationContext(), "notsetupedyet").equals("turnedon")) {
                this.f18449b.setVisibility(0);
                this.f18450c.setVisibility(0);
                this.f18450c.setText("");
                d();
                return;
            }
            c();
            g();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        e();
        this.l.postDelayed(new Runnable() {
            public final void run() {
                if (BankTabPasscodeFragment.this.getActivity() != null) {
                    BankTabPasscodeFragment.this.getActivity().onBackPressed();
                }
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        net.one97.paytm.payments.c.c.b bVar = net.one97.paytm.payments.c.c.b.f17264a;
        if (net.one97.paytm.payments.c.c.b.b()) {
            net.one97.paytm.payments.c.c.b bVar2 = net.one97.paytm.payments.c.c.b.f17264a;
            net.one97.paytm.payments.c.c.b.d(getContext(), new Bundle());
            return;
        }
        m.a(getActivity(), "passcode_forgot", "passcode ppbl", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        if (net.one97.paytm.bankCommon.mapping.a.c((Context) getActivity())) {
            ForgotPasscodeChallengesActivity.a((Context) getActivity());
        } else if (getActivity() != null && !isDetached()) {
            k.a().show(getFragmentManager().a(), "dialog");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        String obj = this.k.getText().toString();
        if (!this.r.isChecked()) {
            m.a(getActivity(), "passcode_hide", "forgot passcode", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            this.k.setMask("*");
            this.k.setText(obj);
            return;
        }
        this.k.setMask((String) null);
        m.a(getActivity(), "passcode_show", "forgot passcode", "login", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.k.setText(obj);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String obj = this.k.getText().toString();
        if (obj.length() == this.k.getDigits()) {
            a(obj, false);
            return;
        }
        this.j.setText(R.string.pb_forgot_passwrd_invalid_passcode);
        b(true);
    }

    private void g() {
        this.m = true;
        this.l.removeCallbacks(this.z);
        this.l.removeCallbacks(this.A);
        this.l.postDelayed(this.z, 100);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2) {
            f();
            this.j.setVisibility(0);
        } else {
            a(R.color.prv_passcode_color);
            this.j.setVisibility(8);
        }
        if (z2) {
            int i2 = net.one97.paytm.bankOpen.R.drawable.pin_view_red_bg;
        } else {
            int i3 = R.drawable.pin_view_gray_bg;
        }
    }

    private void h() {
        this.t.f17467a.observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                BankTabPasscodeFragment.this.a((net.one97.paytm.paymentsBank.utils.g) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.paymentsBank.utils.g gVar) {
        net.one97.paytm.paymentsBank.biometricAuthWall.c cVar = (net.one97.paytm.paymentsBank.biometricAuthWall.c) gVar.a();
        FragmentActivity activity = getActivity();
        if (activity != null && cVar != null && "Proceed FingerPrint".equals(cVar.f17450b) && cVar.f17449a != null) {
            e.b bVar = e.f17453d;
            new e(this, e.b.a(getString(R.string.pb_finger_print_signup_header), "", getString(R.string.pb_finger_print_signup_desc), getString(R.string.pb_cancel))).a(activity, cVar.f17449a);
            net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "biometric_first_setup", "biometric_validate_success", "", "", "/bank/biometric_first_setup/validate_biometric", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        } else if (cVar != null && cVar.f17450b.equals("Will do it later")) {
            net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "biometric_first_setup", "intent_no", "", "", "/bank/biometric_first_setup", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
            net.one97.paytm.bankCommon.h.b.k(o.a().getApplicationContext(), "willdoitlater");
        }
    }

    private static boolean i() {
        if (net.one97.paytm.bankCommon.h.b.j(o.a().getApplicationContext(), "notsetupedyet").equals("notsetupedyet") && j.c()) {
            return false;
        }
        return true;
    }

    public final void a() {
        g();
    }

    public final void a(String str) {
        a(str, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r9 != 10) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            java.lang.String r0 = "decryption_flow"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x0058
            r11 = 7
            if (r9 == r11) goto L_0x001c
            r11 = 13
            if (r9 == r11) goto L_0x0018
            r11 = 9
            if (r9 == r11) goto L_0x001c
            r11 = 10
            if (r9 == r11) goto L_0x0018
            goto L_0x0045
        L_0x0018:
            r8.g()
            goto L_0x0045
        L_0x001c:
            android.view.View r9 = r8.f18449b
            r11 = 8
            r9.setVisibility(r11)
            android.widget.TextView r9 = r8.f18450c
            r11 = 0
            r9.setVisibility(r11)
            r9 = 2
            java.lang.Object[] r9 = new java.lang.Object[r9]
            int r0 = net.one97.paytm.paymentsBank.R.string.bank_fingerprint_access
            java.lang.String r0 = r8.getString(r0)
            r9[r11] = r0
            r11 = 1
            r9[r11] = r10
            java.lang.String r0 = "%s %s"
            java.lang.String r9 = java.lang.String.format(r0, r9)
            android.widget.TextView r0 = r8.f18450c
            r0.setText(r9)
            r8.b((boolean) r11)
        L_0x0045:
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()
            java.lang.String r2 = "biometric_login"
            java.lang.String r3 = "login_failure"
            java.lang.String r5 = ""
            java.lang.String r6 = "/bank/saving-account/login"
            java.lang.String r7 = "banksavingsaccount"
            r4 = r10
            net.one97.paytm.bankCommon.mapping.c.a(r1, r2, r3, r4, r5, r6, r7)
            return
        L_0x0058:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.a((java.lang.Integer) r9, (java.lang.String) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.fragment.BankTabPasscodeFragment.a(int, java.lang.String, java.lang.String):void");
    }

    private void a(Integer num, String str) {
        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "biometric_first_setup", "biometric_validate_failure", num + ": " + str, "", "/bank/biometric_first_setup/validate_biometric", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        net.one97.paytm.bankCommon.h.b.k(o.a().getApplicationContext(), "willdoitlater");
        if (num.intValue() != -1 && num.intValue() != 13 && num.intValue() != 10) {
            this.t.f17468b.postValue(new net.one97.paytm.paymentsBank.biometricAuthWall.d(num.intValue(), str));
        }
    }

    public final void b(String str) {
        if (str.equals("encryption_flow")) {
            a((Integer) -1, "onAuthenticationFailed");
        } else {
            net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "biometric_login", "login_failure", "onAuthenticationFailed", "", "/bank/saving-account/login", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        }
    }

    public final void c(String str) {
        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "biometric_login", "login_failure", "keyInvalidated", "", "/bank/saving-account/login", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        this.f18450c.setVisibility(0);
        this.f18450c.setText(getString(R.string.pb_biometric_changes_detected));
        b(true);
        this.f18449b.setVisibility(8);
        net.one97.paytm.bankCommon.h.b.i(o.a().getApplicationContext(), "willdoitlater");
    }

    public final void a(String str, String str2) {
        net.one97.paytm.bankCommon.mapping.c.a(getActivity(), "biometric_first_setup", "biometric_validate_success", "", "", "/bank/biometric_first_setup/validate_biometric", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        this.f18449b.setVisibility(0);
        this.f18450c.setVisibility(0);
        this.f18450c.setText("");
        Fragment fragment = this.f18452f;
        if (fragment != null && fragment.isAdded()) {
            ((b) this.f18452f).e();
        }
        net.one97.paytm.bankCommon.h.b.a(o.a().getApplicationContext(), str, str2, "turnedon");
    }

    public void onStop() {
        super.onStop();
        if (this.x) {
            getActivity().finish();
        }
    }

    static /* synthetic */ void b(BankTabPasscodeFragment bankTabPasscodeFragment) {
        bankTabPasscodeFragment.getView().findViewById(R.id.fragment_enter_passcode_lyt_bank_tab).setVisibility(8);
        bankTabPasscodeFragment.getView().findViewById(R.id.fragment_enter_passcode_lyt).setVisibility(0);
        if (bankTabPasscodeFragment.f18452f != null) {
            bankTabPasscodeFragment.getChildFragmentManager().a().a(bankTabPasscodeFragment.f18452f).c();
        }
    }

    static /* synthetic */ void k(BankTabPasscodeFragment bankTabPasscodeFragment) {
        if (bankTabPasscodeFragment.getActivity() != null) {
            ((InputMethodManager) bankTabPasscodeFragment.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(bankTabPasscodeFragment.k.getWindowToken(), 2);
        }
    }
}
