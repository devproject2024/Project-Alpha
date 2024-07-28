package net.one97.paytm.recharge.emandate.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticEMandateConfirmationActivity;
import net.one97.paytm.recharge.presentation.b.c;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class AJRBankAccountDetailsActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f62758a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int f62759e = 1001;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJRPayChannelOptions f62760b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Object> f62761c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f62762d;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f62763f;

    public final View a(int i2) {
        if (this.f62763f == null) {
            this.f62763f = new HashMap();
        }
        View view = (View) this.f62763f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f62763f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_account_details);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("pay_channel")) {
            Intent intent2 = getIntent();
            Serializable serializableExtra = intent2 != null ? intent2.getSerializableExtra("pay_channel") : null;
            if (!(serializableExtra instanceof CJRPayChannelOptions)) {
                serializableExtra = null;
            }
            this.f62760b = (CJRPayChannelOptions) serializableExtra;
        }
        Intent intent3 = getIntent();
        if (intent3 != null && intent3.hasExtra("ga_label_key")) {
            Intent intent4 = getIntent();
            this.f62762d = intent4 != null ? intent4.getStringExtra("ga_label_key") : null;
        }
        Intent intent5 = getIntent();
        if (intent5 != null && intent5.hasExtra("e_mandate_bundle")) {
            Intent intent6 = getIntent();
            Serializable serializableExtra2 = intent6 != null ? intent6.getSerializableExtra("e_mandate_bundle") : null;
            if (!(serializableExtra2 instanceof HashMap)) {
                serializableExtra2 = null;
            }
            this.f62761c = (HashMap) serializableExtra2;
        }
        setSupportActionBar((Toolbar) a(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.a((CharSequence) "");
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.b(true);
        }
        TextView textView = (TextView) a(R.id.txt_find_ifsc_code);
        if (textView != null) {
            textView.setOnClickListener(new b(this));
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.proceed_btn);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setOnClickListener(new c(this));
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) a(R.id.bank_account_number);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnFocusChangeListener(new d(this));
        }
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) a(R.id.bank_account_number);
        if (autoCompleteTextView2 != null) {
            autoCompleteTextView2.addTextChangedListener(new e(this));
        }
        AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) a(R.id.ifsc_code);
        if (autoCompleteTextView3 != null) {
            autoCompleteTextView3.setOnFocusChangeListener(new f(this));
        }
        AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) a(R.id.ifsc_code);
        if (autoCompleteTextView4 != null) {
            autoCompleteTextView4.addTextChangedListener(new g(this));
        }
        AutoCompleteTextView autoCompleteTextView5 = (AutoCompleteTextView) a(R.id.account_holder_name);
        if (autoCompleteTextView5 != null) {
            autoCompleteTextView5.setOnFocusChangeListener(new h(this));
        }
        AutoCompleteTextView autoCompleteTextView6 = (AutoCompleteTextView) a(R.id.account_holder_name);
        if (autoCompleteTextView6 != null) {
            autoCompleteTextView6.addTextChangedListener(new i(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62764a;

        b(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62764a = aJRBankAccountDetailsActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            a aVar2 = AJRBankAccountDetailsActivity.f62758a;
            net.one97.paytm.recharge.automatic.c.a.a.a((Context) this.f62764a, AJRBankAccountDetailsActivity.f62759e);
            AJRBankAccountDetailsActivity.a(this.f62764a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62765a;

        c(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62765a = aJRBankAccountDetailsActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.recharge.widgets.c.e eVar = net.one97.paytm.recharge.widgets.c.e.INSTANCE;
            CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) this.f62765a.a(R.id.proceed_btn);
            k.a((Object) cJRProceedWidgetV8, "proceed_btn");
            if (!eVar.validateIsAlreadyClicked(cJRProceedWidgetV8)) {
                if (AJRBankAccountDetailsActivity.b(this.f62765a)) {
                    AJRBankAccountDetailsActivity.c(this.f62765a);
                    AJRBankAccountDetailsActivity.d(this.f62765a);
                    if (this.f62765a.f62760b != null) {
                        CJRPayChannelOptions e2 = this.f62765a.f62760b;
                        if (e2 == null) {
                            k.a();
                        }
                        if (e2.getMandateAuthMode() != null) {
                            CJRPayChannelOptions e3 = this.f62765a.f62760b;
                            if (e3 == null) {
                                k.a();
                            }
                            ArrayList<String> mandateAuthMode = e3.getMandateAuthMode();
                            if (mandateAuthMode == null) {
                                k.a();
                            }
                            if (mandateAuthMode.size() > 1) {
                                if (this.f62765a.f62761c != null) {
                                    HashMap f2 = this.f62765a.f62761c;
                                    if (f2 == null) {
                                        k.a();
                                    }
                                    f2.put("ga_label_key", this.f62765a.f62762d);
                                }
                                c.a aVar = net.one97.paytm.recharge.presentation.b.c.f64735b;
                                HashMap f3 = this.f62765a.f62761c;
                                CJRPayChannelOptions e4 = this.f62765a.f62760b;
                                if (e4 == null) {
                                    k.a();
                                }
                                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f62765a.a(R.id.bank_account_number);
                                Editable editable = null;
                                String valueOf = String.valueOf(autoCompleteTextView != null ? autoCompleteTextView.getText() : null);
                                AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) this.f62765a.a(R.id.ifsc_code);
                                String valueOf2 = String.valueOf(autoCompleteTextView2 != null ? autoCompleteTextView2.getText() : null);
                                AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) this.f62765a.a(R.id.account_holder_name);
                                if (autoCompleteTextView3 != null) {
                                    editable = autoCompleteTextView3.getText();
                                }
                                String valueOf3 = String.valueOf(editable);
                                k.c(e4, "payOption");
                                k.c(valueOf, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                                k.c(valueOf2, "ifscCode");
                                k.c(valueOf3, "accountHolderName");
                                net.one97.paytm.recharge.presentation.b.c cVar = new net.one97.paytm.recharge.presentation.b.c();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("pay_channel", e4);
                                bundle.putString("key_account", valueOf);
                                bundle.putString("key_ifsc_code", valueOf2);
                                bundle.putString("key_account_holder_name", valueOf3);
                                bundle.putSerializable("e_mandate_bundle", f3);
                                cVar.setArguments(bundle);
                                cVar.show(this.f62765a.getSupportFragmentManager(), y.b(net.one97.paytm.recharge.presentation.b.c.class).b());
                                return;
                            }
                        }
                    }
                    AJRBankAccountDetailsActivity.h(this.f62765a);
                    return;
                }
                Toast.makeText(this.f62765a, R.string.validation_failed_mandatory_fields, 1).show();
            }
        }
    }

    static final class d implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62766a;

        d(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62766a = aJRBankAccountDetailsActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            TextInputLayout textInputLayout;
            if (z && (textInputLayout = (TextInputLayout) this.f62766a.a(R.id.bank_account_number_layout)) != null) {
                textInputLayout.setErrorEnabled(false);
            }
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62767a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        e(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62767a = aJRBankAccountDetailsActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TextInputLayout textInputLayout;
            if (!TextUtils.isEmpty(charSequence) && (textInputLayout = (TextInputLayout) this.f62767a.a(R.id.bank_account_number_layout)) != null) {
                textInputLayout.setErrorEnabled(false);
            }
        }
    }

    static final class f implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62768a;

        f(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62768a = aJRBankAccountDetailsActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            TextInputLayout textInputLayout;
            if (z && (textInputLayout = (TextInputLayout) this.f62768a.a(R.id.ifsc_code_layout)) != null) {
                textInputLayout.setErrorEnabled(false);
            }
        }
    }

    public static final class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62769a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        g(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62769a = aJRBankAccountDetailsActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TextInputLayout textInputLayout;
            if (!TextUtils.isEmpty(charSequence) && (textInputLayout = (TextInputLayout) this.f62769a.a(R.id.ifsc_code_layout)) != null) {
                textInputLayout.setErrorEnabled(false);
            }
        }
    }

    static final class h implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62770a;

        h(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62770a = aJRBankAccountDetailsActivity;
        }

        public final void onFocusChange(View view, boolean z) {
            TextInputLayout textInputLayout;
            if (z && (textInputLayout = (TextInputLayout) this.f62770a.a(R.id.account_holder_name_layout)) != null) {
                textInputLayout.setErrorEnabled(false);
            }
        }
    }

    public static final class i implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRBankAccountDetailsActivity f62771a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        i(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
            this.f62771a = aJRBankAccountDetailsActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            TextInputLayout textInputLayout;
            if (!TextUtils.isEmpty(charSequence) && (textInputLayout = (TextInputLayout) this.f62771a.a(R.id.account_holder_name_layout)) != null) {
                textInputLayout.setErrorEnabled(false);
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AutoCompleteTextView autoCompleteTextView;
        if (!(intent == null || intent.getExtras() == null)) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                k.a();
            }
            if (extras.containsKey("intent_extra_ifsc_code")) {
                Bundle extras2 = intent.getExtras();
                if (extras2 == null) {
                    k.a();
                }
                CharSequence string = extras2.getString("intent_extra_ifsc_code");
                if (!TextUtils.isEmpty(string) && (autoCompleteTextView = (AutoCompleteTextView) a(R.id.ifsc_code)) != null) {
                    autoCompleteTextView.setText(string);
                }
            }
        }
        if (!(i2 != 1001 || intent == null || intent.getExtras() == null)) {
            if (intent.hasExtra("is_subscription_failed") && intent.getBooleanExtra("is_subscription_failed", false)) {
                finish();
            } else if (intent.hasExtra("is_redirect_flow") && intent.getBooleanExtra("is_redirect_flow", false)) {
                Intent intent2 = new Intent();
                intent2.putExtra("is_redirect_flow", true);
                intent2.putExtra("isPending", intent.getBooleanExtra("isPending", false));
                setResult(-1, intent2);
                finish();
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public static final /* synthetic */ void a(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
        try {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = aJRBankAccountDetailsActivity;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String F = net.one97.paytm.recharge.automatic.b.a.a.I;
            String str = aJRBankAccountDetailsActivity.f62762d;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, F, "", str2, net.one97.paytm.recharge.automatic.b.a.a.P, (Object) null, 64);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ boolean b(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.bank_account_number);
        Editable editable = null;
        String valueOf = String.valueOf(autoCompleteTextView != null ? autoCompleteTextView.getText() : null);
        if (valueOf != null) {
            if (!TextUtils.isEmpty(p.b(valueOf).toString())) {
                AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.ifsc_code);
                String valueOf2 = String.valueOf(autoCompleteTextView2 != null ? autoCompleteTextView2.getText() : null);
                if (valueOf2 == null) {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                } else if (!TextUtils.isEmpty(p.b(valueOf2).toString())) {
                    AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.ifsc_code);
                    if (String.valueOf(autoCompleteTextView3 != null ? autoCompleteTextView3.getText() : null).length() == 11) {
                        AutoCompleteTextView autoCompleteTextView4 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.account_holder_name);
                        String valueOf3 = String.valueOf(autoCompleteTextView4 != null ? autoCompleteTextView4.getText() : null);
                        if (valueOf3 == null) {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        } else if (!TextUtils.isEmpty(p.b(valueOf3).toString())) {
                            return true;
                        }
                    }
                }
            }
            AutoCompleteTextView autoCompleteTextView5 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.bank_account_number);
            String valueOf4 = String.valueOf(autoCompleteTextView5 != null ? autoCompleteTextView5.getText() : null);
            if (valueOf4 != null) {
                if (!TextUtils.isEmpty(p.b(valueOf4).toString())) {
                    AutoCompleteTextView autoCompleteTextView6 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.bank_account_number);
                    if (String.valueOf(autoCompleteTextView6 != null ? autoCompleteTextView6.getText() : null).length() >= 9) {
                        AutoCompleteTextView autoCompleteTextView7 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.ifsc_code);
                        String valueOf5 = String.valueOf(autoCompleteTextView7 != null ? autoCompleteTextView7.getText() : null);
                        if (valueOf5 != null) {
                            if (!TextUtils.isEmpty(p.b(valueOf5).toString())) {
                                AutoCompleteTextView autoCompleteTextView8 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.ifsc_code);
                                if (String.valueOf(autoCompleteTextView8 != null ? autoCompleteTextView8.getText() : null).length() >= 11) {
                                    AutoCompleteTextView autoCompleteTextView9 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.account_holder_name);
                                    if (autoCompleteTextView9 != null) {
                                        editable = autoCompleteTextView9.getText();
                                    }
                                    String valueOf6 = String.valueOf(editable);
                                    if (valueOf6 != null) {
                                        if (TextUtils.isEmpty(p.b(valueOf6).toString())) {
                                            TextInputLayout textInputLayout = (TextInputLayout) aJRBankAccountDetailsActivity.a(R.id.account_holder_name_layout);
                                            if (textInputLayout != null) {
                                                textInputLayout.setError(aJRBankAccountDetailsActivity.getString(R.string.error_account_holder_name));
                                            }
                                            TextInputLayout textInputLayout2 = (TextInputLayout) aJRBankAccountDetailsActivity.a(R.id.account_holder_name_layout);
                                            if (textInputLayout2 != null) {
                                                textInputLayout2.setErrorEnabled(true);
                                            }
                                        }
                                        return false;
                                    }
                                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                                }
                            }
                            TextInputLayout textInputLayout3 = (TextInputLayout) aJRBankAccountDetailsActivity.a(R.id.ifsc_code_layout);
                            if (textInputLayout3 != null) {
                                textInputLayout3.setError(aJRBankAccountDetailsActivity.getString(R.string.error_ifsc_code));
                            }
                            TextInputLayout textInputLayout4 = (TextInputLayout) aJRBankAccountDetailsActivity.a(R.id.ifsc_code_layout);
                            if (textInputLayout4 != null) {
                                textInputLayout4.setErrorEnabled(true);
                            }
                            return false;
                        }
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                TextInputLayout textInputLayout5 = (TextInputLayout) aJRBankAccountDetailsActivity.a(R.id.bank_account_number_layout);
                if (textInputLayout5 != null) {
                    textInputLayout5.setError(aJRBankAccountDetailsActivity.getString(R.string.error_bank_account_number));
                }
                TextInputLayout textInputLayout6 = (TextInputLayout) aJRBankAccountDetailsActivity.a(R.id.bank_account_number_layout);
                if (textInputLayout6 != null) {
                    textInputLayout6.setErrorEnabled(true);
                }
                return false;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final /* synthetic */ void c(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
        String str;
        String str2;
        try {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = aJRBankAccountDetailsActivity;
            a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String C = net.one97.paytm.recharge.automatic.b.a.a.F;
            String str3 = aJRBankAccountDetailsActivity.f62762d;
            String str4 = str3 == null ? "" : str3;
            a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, C, "", str4, net.one97.paytm.recharge.automatic.b.a.a.P, (Object) null, 64);
            net.one97.paytm.recharge.automatic.c.a.a aVar5 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context2 = aJRBankAccountDetailsActivity;
            a.C1160a aVar6 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a3 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar7 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String D = net.one97.paytm.recharge.automatic.b.a.a.G;
            String str5 = aJRBankAccountDetailsActivity.f62762d;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            a.C1160a aVar8 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context2, a3, D, "", str, net.one97.paytm.recharge.automatic.b.a.a.P, (Object) null, 64);
            net.one97.paytm.recharge.automatic.c.a.a aVar9 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context3 = aJRBankAccountDetailsActivity;
            a.C1160a aVar10 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String a4 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
            a.C1160a aVar11 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            String E = net.one97.paytm.recharge.automatic.b.a.a.H;
            String str6 = aJRBankAccountDetailsActivity.f62762d;
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            a.C1160a aVar12 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
            net.one97.paytm.recharge.automatic.c.a.a.a(context3, a4, E, "", str2, net.one97.paytm.recharge.automatic.b.a.a.P, (Object) null, 64);
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ void d(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
        try {
            Object systemService = aJRBankAccountDetailsActivity.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                View currentFocus = aJRBankAccountDetailsActivity.getCurrentFocus();
                inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void h(AJRBankAccountDetailsActivity aJRBankAccountDetailsActivity) {
        Intent intent = new Intent(aJRBankAccountDetailsActivity, AJRAutomaticEMandateConfirmationActivity.class);
        intent.putExtra("pay_channel", aJRBankAccountDetailsActivity.f62760b);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.bank_account_number);
        k.a((Object) autoCompleteTextView, "bank_account_number");
        intent.putExtra("key_account", autoCompleteTextView.getText().toString());
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.ifsc_code);
        k.a((Object) autoCompleteTextView2, "ifsc_code");
        intent.putExtra("key_ifsc_code", autoCompleteTextView2.getText().toString());
        AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) aJRBankAccountDetailsActivity.a(R.id.account_holder_name);
        k.a((Object) autoCompleteTextView3, "account_holder_name");
        intent.putExtra("key_account_holder_name", autoCompleteTextView3.getText().toString());
        intent.putExtra("ga_label_key", aJRBankAccountDetailsActivity.f62762d);
        HashMap<String, Object> hashMap = aJRBankAccountDetailsActivity.f62761c;
        if (hashMap != null) {
            intent.putExtra("e_mandate_bundle", hashMap);
        }
        aJRBankAccountDetailsActivity.startActivityForResult(intent, 1001);
    }
}
