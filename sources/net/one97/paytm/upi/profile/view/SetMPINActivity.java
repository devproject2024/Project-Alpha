package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.profile.a.d;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomSnackbar;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class SetMPINActivity extends PaytmActivity implements View.OnClickListener, d.c {
    /* access modifiers changed from: private */
    public EditText A;
    /* access modifiers changed from: private */
    public EditText B;
    /* access modifiers changed from: private */
    public EditText C;
    private a D;
    private b E;
    private c F;
    private d G;
    private boolean H;
    private boolean I;
    private View.OnKeyListener J = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67) {
                return false;
            }
            if (view == SetMPINActivity.this.z) {
                return SetMPINActivity.a(SetMPINActivity.this.z, (EditText) null);
            }
            if (view == SetMPINActivity.this.A) {
                return SetMPINActivity.a(SetMPINActivity.this.A, SetMPINActivity.this.z);
            }
            if (view == SetMPINActivity.this.B) {
                return SetMPINActivity.a(SetMPINActivity.this.B, SetMPINActivity.this.A);
            }
            if (view == SetMPINActivity.this.C) {
                return SetMPINActivity.a(SetMPINActivity.this.C, SetMPINActivity.this.B);
            }
            return true;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private EditText f68133a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f68134b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f68135c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f68136d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68137e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f68138f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f68139g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f68140h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f68141i;
    private TextView j;
    private TextView k;
    private TextView l;
    private LinearLayout m;
    private ScrollView n;
    private UserUpiDetails o;
    private d.b p;
    private ProgressDialog q;
    private TextView r;
    private ImageView s;
    private androidx.appcompat.app.c t;
    private boolean u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    /* access modifiers changed from: private */
    public EditText z;

    public final /* synthetic */ void a(Object obj) {
        this.p = (d.b) obj;
        this.p.e();
    }

    public static void a(Activity activity, UserUpiDetails userUpiDetails, int i2, boolean z2) {
        Intent intent = new Intent(activity, SetMPINActivity.class);
        intent.putExtra("user_upi_details", userUpiDetails);
        intent.putExtra(UpiConstants.EXTRA_IS_FOR_FORGOT_MPIN, true);
        intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, z2);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Fragment fragment, UserUpiDetails userUpiDetails) {
        Intent intent = new Intent(fragment.getContext(), SetMPINActivity.class);
        intent.putExtra("user_upi_details", userUpiDetails);
        fragment.startActivityForResult(intent, 20);
    }

    private int o() {
        return getIntent().getIntExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0);
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_set_mpin_card);
        this.u = getIntent().getBooleanExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, false);
        ((ImageView) findViewById(R.id.tv_toolbar_title)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SetMPINActivity.this.setResult(0);
                SetMPINActivity.this.finish();
            }
        });
        this.f68137e = (TextView) findViewById(R.id.tv_skip);
        if (o() == UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal()) {
            this.f68137e.setVisibility(0);
        } else {
            this.f68137e.setVisibility(8);
        }
        this.f68137e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CJRSendGTMTag.sendNewCustomGTMEvents(SetMPINActivity.this, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "set_pin_screen_do_it_later", "", "", "", "/bhim-upi/setmpin", "wallet");
                SetMPINActivity.this.setResult(0);
                SetMPINActivity.this.finish();
            }
        });
        if (this.u) {
            final CustomSnackbar build = CustomSnackbar.Builder(this).layout(R.layout.layout_upi_snack_bar).background(R.color.upi_pin_green).duration(CustomSnackbar.LENGTH.INDEFINITE).swipe(true).build(findViewById(R.id.ll_container));
            build.show();
            ((TextView) build.getContentView().findViewById(R.id.tv_snack_bar_title)).setText(getString(R.string.upi_congratulations_text));
            ((TextView) build.getContentView().findViewById(R.id.tv_snack_bar_message)).setText(getString(R.string.upi_success_add_bank));
            Button button = (Button) build.getContentView().findViewById(R.id.btn_action);
            button.setText(getString(R.string.upi_ok));
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    build.dismiss();
                }
            });
        }
        this.k = (TextView) findViewById(R.id.tv_set_mpin_card_msg);
        this.f68133a = (EditText) findViewById(R.id.edt_card_no);
        this.f68134b = (EditText) findViewById(R.id.edt_expiry_month);
        this.f68135c = (EditText) findViewById(R.id.edt_expiry_year);
        this.f68136d = (TextView) findViewById(R.id.tv_proceed);
        this.f68139g = (TextView) findViewById(R.id.tv_date_error);
        this.f68140h = (TextView) findViewById(R.id.tv_card_error);
        this.f68138f = (TextView) findViewById(R.id.tv_bank_acc_no);
        this.r = (TextView) findViewById(R.id.tv_bank_name);
        this.s = (ImageView) findViewById(R.id.iv_bank_icon);
        this.f68141i = (TextView) findViewById(R.id.securityText);
        this.m = (LinearLayout) findViewById(R.id.ll_passcode_container);
        this.n = (ScrollView) findViewById(R.id.sv_mpin_card_container);
        this.v = (TextView) findViewById(R.id.tv_set_mpin_option);
        this.j = (TextView) findViewById(R.id.tv_maestro_expiry_msg);
        this.w = (TextView) findViewById(R.id.tv_passcode_title);
        this.x = (TextView) findViewById(R.id.tv_forgot_passcode);
        this.y = (TextView) findViewById(R.id.tv_passcode_error);
        this.l = (TextView) findViewById(R.id.remOldPin);
        this.l.setOnClickListener(this);
        this.x.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (UpiAppUtils.isNetworkAvailable(SetMPINActivity.this)) {
                    i.a().m.a((Activity) SetMPINActivity.this);
                }
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SetMPINActivity.e(SetMPINActivity.this);
            }
        });
        this.z = (EditText) findViewById(R.id.et_passcode_char1);
        this.A = (EditText) findViewById(R.id.et_passcode_char2);
        this.B = (EditText) findViewById(R.id.et_passcode_char3);
        this.C = (EditText) findViewById(R.id.et_passcode_char4);
        this.D = new a(this, (byte) 0);
        this.E = new b(this, (byte) 0);
        this.F = new c(this, (byte) 0);
        this.G = new d(this, (byte) 0);
        this.z.addTextChangedListener(this.D);
        this.A.addTextChangedListener(this.E);
        this.B.addTextChangedListener(this.F);
        this.C.addTextChangedListener(this.G);
        this.z.setOnKeyListener(this.J);
        this.A.setOnKeyListener(this.J);
        this.B.setOnKeyListener(this.J);
        this.C.setOnKeyListener(this.J);
        if (bundle != null) {
            this.o = (UserUpiDetails) bundle.getSerializable("user_upi_details");
        } else if (getIntent() != null) {
            this.o = (UserUpiDetails) getIntent().getSerializableExtra("user_upi_details");
            this.I = getIntent().getBooleanExtra(UpiConstants.EXTRA_REFRESH_BANK_ACCOUNT, true);
            if (this.u) {
                this.I = false;
            }
        }
        this.f68136d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SetMPINActivity.f(SetMPINActivity.this);
            }
        });
        this.f68133a.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SetMPINActivity.this.f68140h.setVisibility(8);
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (!TextUtils.isEmpty(obj) && obj.length() == 6) {
                    SetMPINActivity.this.f68134b.requestFocus();
                }
            }
        });
        this.f68134b.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SetMPINActivity.this.f68139g.setVisibility(8);
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (!TextUtils.isEmpty(obj) && obj.length() == 2) {
                    SetMPINActivity.this.f68135c.requestFocus();
                }
            }
        });
        this.f68135c.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SetMPINActivity.this.f68139g.setVisibility(8);
            }
        });
        new net.one97.paytm.upi.profile.presenter.d(g.a(), g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null), this, this.o, this.I);
        if (getIntent().getBooleanExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, false)) {
            this.l.setVisibility(8);
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(getApplicationContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", this.o.getSelectedBankAccount().getBankName(), "", "", GAConstants.SCREEN_NAME.UPI_ONB_SET_MPIN, "wallet");
    }

    public void onClick(View view) {
        if (view.getId() != R.id.remOldPin) {
            return;
        }
        if (PaytmUpiPrefUtil.getPref(getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true)) {
            this.p.b();
        } else {
            a(12);
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        String str;
        if (bankAccount == null || TextUtils.isEmpty(bankAccount.getIfsc()) || bankAccount.getCredsAllowed() == null) {
            Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
            finish();
            return;
        }
        Iterator<BankAccountDetails.BankAccountCredentials> it2 = bankAccount.getCredsAllowed().getChild().iterator();
        while (true) {
            if (!it2.hasNext()) {
                str = "0";
                break;
            }
            BankAccountDetails.BankAccountCredentials next = it2.next();
            if ("MPIN".equals(next.getCredsAllowedSubType())) {
                str = next.getCredsAllowedDLength();
                break;
            }
        }
        this.k.setText(getString(R.string.upi_set_mpin_card_msg_new, new Object[]{str}));
        if (o() == UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal()) {
            this.k.setText(getString(R.string.upi_set_mpin_card_msg_new_1, new Object[]{str, bankAccount.getBankName()}));
        }
        this.r.setText(getString(R.string.upi_bank_debit_card, new Object[]{bankAccount.getBankName()}));
        this.f68138f.setText(String.format(getString(R.string.upi_bank_account_no), new Object[]{UpiUtils.maskNumber(bankAccount.getAccRefNumber())}));
        if (!TextUtils.isEmpty(bankAccount.getBankLogoUrl())) {
            w.a().a(bankAccount.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.s, (e) null);
        } else {
            UpiUtils.setBankIcon(this.s, bankAccount.getIfsc(), getApplicationContext());
        }
        if (bankAccount.getIfsc().contains("PYTM")) {
            this.H = true;
            this.n.setVisibility(8);
            this.m.setVisibility(0);
            this.v.setVisibility(0);
        } else {
            this.n.setVisibility(0);
            this.m.setVisibility(8);
            this.v.setVisibility(8);
            String bankName = !TextUtils.isEmpty(bankAccount.getBankName()) ? bankAccount.getBankName() : "";
            this.f68141i.setText(getString(R.string.upi_set_pin_security_message, new Object[]{bankName, bankName}));
        }
        this.j.setVisibility(0);
        if (!bankAccount.isMpinSet()) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
    }

    /* renamed from: net.one97.paytm.upi.profile.view.SetMPINActivity$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f68147a = new int[d.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.upi.profile.a.d$a[] r0 = net.one97.paytm.upi.profile.a.d.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f68147a = r0
                int[] r0 = f68147a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.upi.profile.a.d$a r1 = net.one97.paytm.upi.profile.a.d.a.INVALID_CARDNUM     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f68147a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.upi.profile.a.d$a r1 = net.one97.paytm.upi.profile.a.d.a.INVALID_MONTH     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f68147a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.upi.profile.a.d$a r1 = net.one97.paytm.upi.profile.a.d.a.INVALID_YEAR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f68147a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.upi.profile.a.d$a r1 = net.one97.paytm.upi.profile.a.d.a.INVALID_DATE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.profile.view.SetMPINActivity.AnonymousClass3.<clinit>():void");
        }
    }

    public final void a(d.a aVar) {
        int i2 = AnonymousClass3.f68147a[aVar.ordinal()];
        if (i2 == 1) {
            this.f68140h.setVisibility(0);
            this.f68140h.setText(getString(R.string.invalid_card_no));
            this.f68133a.requestFocus();
        } else if (i2 == 2) {
            this.f68134b.setError(getString(R.string.err_valid_expiry));
            this.f68134b.requestFocus();
        } else if (i2 == 3) {
            this.f68135c.setError(getString(R.string.err_valid_expiry));
            this.f68135c.requestFocus();
        } else if (i2 == 4) {
            this.f68139g.setVisibility(0);
            this.f68139g.setText(getString(R.string.err_valid_expiry));
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError, String str, String str2) {
        d();
        if ("1006".equals(str)) {
            a(200);
        } else if ("ZT".equals(str)) {
            Toast.makeText(this, String.valueOf(str2), 1).show();
        } else if ("INT-1095".equals(str)) {
            Toast.makeText(this, String.valueOf(str2), 1).show();
        } else if ("INT-1096".equals(str)) {
            Toast.makeText(this, String.valueOf(str2), 1).show();
        } else {
            String str3 = upiCustomVolleyError.getmErrorCode();
            if (TextUtils.isEmpty(str3) || !UpiConstants.NETWORK_ERROR_CODE.equals(str3)) {
                Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        }
    }

    public final void a() {
        this.p.a();
    }

    public final void b() {
        c();
        a(false);
        p();
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError, String str) {
        e();
        String str2 = upiCustomVolleyError.getmErrorCode();
        if (TextUtils.isEmpty(str2) || !UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
            this.y.setText(str);
            a(true);
            return;
        }
        CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
    }

    public final void a(List<GetCredentialsResponse> list, String str) {
        this.p.a(list, str);
    }

    public final void a(UserUpiDetails userUpiDetails) {
        e();
        if (this.u) {
            Intent intent = getIntent();
            intent.setClass(getApplicationContext(), UPISettingsActivity.class);
            intent.putExtra(UpiConstants.EXTRA_IS_MPIN_SET, true);
            startActivity(intent);
            finish();
            CJRSendGTMTag.sendNewCustomGTMEvents(getApplicationContext(), GAConstants.CATEGORY.UPI_ONB_V1, "", "set_mpin_success", userUpiDetails.getSelectedBankAccount().getBankName(), "", GAConstants.SCREEN_NAME.UPI_ONB_SET_MPIN, "wallet");
            return;
        }
        Toast.makeText(this, R.string.upi_reset_mpin_success, 1).show();
        Intent intent2 = new Intent();
        if (userUpiDetails.getSelectedBankAccount() != null) {
            intent2.putExtra(UpiConstants.EXTRA_SELECTED_BANK, userUpiDetails.getSelectedBankAccount().getBankName());
        }
        setResult(-1, intent2);
        finish();
    }

    public final void b(UpiCustomVolleyError upiCustomVolleyError, String str) {
        e();
        if (!TextUtils.isEmpty(str)) {
            if ("ZR".equals(str)) {
                Toast.makeText(this, R.string.upi_invalid_otp, 1).show();
            } else if ("XL".equals(str) || "XN".equals(str) || "XR".equals(str) || "XM".equals(str) || "XM".equals(str)) {
                Toast.makeText(this, R.string.upi_card_details, 1).show();
            } else if ("ZT".equals(str)) {
                Toast.makeText(this, R.string.upi_max_otp_limit_exceeded, 1).show();
            } else if ("1006".equals(str)) {
                a(201);
            } else if (this.u) {
                Intent intent = getIntent();
                intent.setClass(getApplicationContext(), UPISettingsActivity.class);
                intent.putExtra(UpiConstants.EXTRA_IS_MPIN_SET, false);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, R.string.upi_some_went_wrong, 0).show();
            }
            CJRSendGTMTag.sendNewCustomGTMEvents(getApplicationContext(), GAConstants.CATEGORY.UPI_ONB_V1, "", "set_mpin_failure", str, this.o.getSelectedBankAccount().getBankName(), GAConstants.SCREEN_NAME.UPI_ONB_SET_MPIN, "wallet");
            return;
        }
        String str2 = upiCustomVolleyError.getmErrorCode();
        if (!TextUtils.isEmpty(str2) && UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
            CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        } else if (this.u) {
            Intent intent2 = getIntent();
            intent2.setClass(getApplicationContext(), UPISettingsActivity.class);
            intent2.putExtra(UpiConstants.EXTRA_IS_MPIN_SET, false);
            startActivity(intent2);
            finish();
        } else {
            Toast.makeText(this, R.string.upi_some_went_wrong, 0).show();
        }
        CJRSendGTMTag.sendNewCustomGTMEvents(getApplicationContext(), GAConstants.CATEGORY.UPI_ONB_V1, "", "set_mpin_failure", this.o.getSelectedBankAccount().getBankName(), "", GAConstants.SCREEN_NAME.UPI_ONB_SET_MPIN, "wallet");
    }

    public final void b(UserUpiDetails userUpiDetails) {
        if (this.t == null) {
            c.a aVar = new c.a(this);
            View inflate = getLayoutInflater().inflate(R.layout.fragment_get_otp_waiting, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_otp_waiting);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_bank_icon);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress);
            if (Build.VERSION.SDK_INT < 21) {
                Drawable f2 = androidx.core.graphics.drawable.a.f(progressBar.getIndeterminateDrawable());
                androidx.core.graphics.drawable.a.a(f2, androidx.core.content.b.c(this, R.color.upi_pin_green));
                progressBar.setIndeterminateDrawable(androidx.core.graphics.drawable.a.g(f2));
            } else {
                progressBar.getIndeterminateDrawable().setColorFilter(androidx.core.content.b.c(this, R.color.upi_pin_green), PorterDuff.Mode.SRC_IN);
            }
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            if (selectedBankAccount != null) {
                w.a().a(selectedBankAccount.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(imageView, (e) null);
                textView.setText(getString(R.string.upi_waiting_for_otp, new Object[]{selectedBankAccount.getBankName()}));
            }
            aVar.a(inflate);
            aVar.a(false);
            this.t = aVar.a();
            this.t.show();
        }
    }

    public final void d() {
        androidx.appcompat.app.c cVar = this.t;
        if (cVar != null && cVar.isShowing()) {
            this.t.dismiss();
            this.t = null;
        }
    }

    public final void c() {
        if (this.q == null) {
            this.q = new ProgressDialog(this);
            this.q.setMessage(getString(R.string.please_wait));
            this.q.setCancelable(false);
            this.q.show();
        }
    }

    public final void l() {
        Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
    }

    public final void e() {
        ProgressDialog progressDialog = this.q;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.q.dismiss();
            this.q = null;
        }
    }

    public final void f() {
        d();
        Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
    }

    public final void g() {
        e();
        d();
        Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
    }

    public final void h() {
        Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
        e();
        a(false);
    }

    private void a(int i2) {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", i2);
        startActivityForResult(intent, i2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1002 && i3 == -1) {
            if (intent != null && intent.hasExtra("forgot_passcode_access")) {
                i.a();
            }
        } else if (i2 == 12) {
            if (i3 == -1) {
                this.p.b();
            }
        } else if (i2 == 200 && i3 == -1) {
            this.p.c();
        }
    }

    public final void i() {
        q();
    }

    public final void j() {
        c();
    }

    public final void k() {
        e();
    }

    public final void a(String str) {
        e();
        if (UpiUtils.isAuthenticationFailure(str)) {
            k kVar = i.a().k;
            new UpiCustomVolleyError();
            SetMPINActivity.class.getName();
            kVar.e(this);
            return;
        }
        Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("user_upi_details", this.o);
    }

    private void p() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private void q() {
        this.z.removeTextChangedListener(this.D);
        this.A.removeTextChangedListener(this.E);
        this.B.removeTextChangedListener(this.F);
        this.C.removeTextChangedListener(this.G);
        this.z.setText("");
        this.A.setText("");
        this.B.setText("");
        this.C.setText("");
        this.z.requestFocus();
        this.z.addTextChangedListener(this.D);
        this.A.addTextChangedListener(this.E);
        this.B.addTextChangedListener(this.F);
        this.C.addTextChangedListener(this.G);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            q();
            b(true);
            this.y.setVisibility(0);
            return;
        }
        b(false);
        this.y.setVisibility(8);
    }

    private void b(boolean z2) {
        Drawable drawable;
        int i2 = z2 ? R.drawable.passcode_edt_error_bg : R.drawable.passcode_edt_bg;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = getResources().getDrawable(i2, getTheme());
        } else {
            drawable = getResources().getDrawable(i2);
        }
        this.z.setBackground(drawable);
        this.A.setBackground(drawable);
        this.B.setBackground(drawable);
        this.C.setBackground(drawable);
    }

    public void onDestroy() {
        super.onDestroy();
        this.p.f();
    }

    class a implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private a() {
        }

        /* synthetic */ a(SetMPINActivity setMPINActivity, byte b2) {
            this();
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SetMPINActivity.this.a(false);
        }

        public final void afterTextChanged(Editable editable) {
            SetMPINActivity.this.A.requestFocus();
        }
    }

    class b implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private b() {
        }

        /* synthetic */ b(SetMPINActivity setMPINActivity, byte b2) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
            SetMPINActivity.this.B.requestFocus();
        }
    }

    class c implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private c() {
        }

        /* synthetic */ c(SetMPINActivity setMPINActivity, byte b2) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
            SetMPINActivity.this.C.requestFocus();
        }
    }

    class d implements TextWatcher {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        private d() {
        }

        /* synthetic */ d(SetMPINActivity setMPINActivity, byte b2) {
            this();
        }

        public final void afterTextChanged(Editable editable) {
            SetMPINActivity.this.p.a(SetMPINActivity.this.z.getText().toString() + SetMPINActivity.this.A.getText().toString() + SetMPINActivity.this.B.getText().toString() + SetMPINActivity.this.C.getText().toString());
        }
    }

    public final void m() {
        k kVar = i.a().k;
        new UpiCustomVolleyError();
        kVar.e(this);
    }

    public final void c(UpiCustomVolleyError upiCustomVolleyError, String str) {
        e();
        if (TextUtils.isEmpty(str)) {
            String str2 = upiCustomVolleyError.getmErrorCode();
            if (TextUtils.isEmpty(str2) || !UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
                Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else if ("ZM".equals(str) || "RM".equals(str)) {
            Toast.makeText(this, R.string.upi_incorrect_mpin, 1).show();
        } else if ("1006".equals(str)) {
            a(12);
        } else {
            Toast.makeText(this, R.string.upi_reset_mpin_error, 1).show();
        }
    }

    public final void n() {
        e();
        Toast.makeText(this, R.string.upi_reset_mpin_success, 1).show();
        finish();
    }

    static /* synthetic */ boolean a(EditText editText, EditText editText2) {
        if (TextUtils.isEmpty(editText.getText().toString())) {
            if (editText2 != null) {
                editText2.setText("");
                editText2.setEnabled(true);
                editText2.requestFocus();
            }
            return true;
        } else if (editText.getSelectionStart() != 0 || editText.getSelectionEnd() != 0) {
            return false;
        } else {
            editText.setText("");
            if (editText2 != null) {
                editText2.requestFocus();
            }
            return true;
        }
    }

    static /* synthetic */ void e(SetMPINActivity setMPINActivity) {
        setMPINActivity.H = !setMPINActivity.H;
        if (!setMPINActivity.H) {
            setMPINActivity.n.setVisibility(0);
            setMPINActivity.m.setVisibility(8);
            setMPINActivity.v.setText(R.string.upi_set_mpin_using_passcode);
            return;
        }
        setMPINActivity.n.setVisibility(8);
        setMPINActivity.m.setVisibility(0);
        setMPINActivity.v.setText(R.string.upi_set_mpin_using_card);
    }

    static /* synthetic */ void f(SetMPINActivity setMPINActivity) {
        String obj = setMPINActivity.f68133a.getText().toString();
        String obj2 = setMPINActivity.f68134b.getText().toString();
        String obj3 = setMPINActivity.f68135c.getText().toString();
        setMPINActivity.p();
        setMPINActivity.p.a(obj, obj2, obj3);
        if (setMPINActivity.o() == UpiConstants.SourceOfOnBoarding.WALLET_SIGNUP.getVal()) {
            CJRSendGTMTag.sendNewCustomGTMEvents(setMPINActivity, CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "set_pin_screen_proceed", "", "", "", "/bhim-upi/setmpin", "wallet");
        }
    }
}
