package net.one97.paytm.p2b.view.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.common.entity.wallet.CJRBankDetailsResponse;
import net.one97.paytm.i.h;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.a.a;
import net.one97.paytm.p2b.d.c;
import net.one97.paytm.p2b.d.g;
import net.one97.paytm.p2b.d.i;
import net.one97.paytm.p2b.d.k;
import net.one97.paytm.p2b.data.a.b;
import net.one97.paytm.upi.util.UpiUtils;

public class f extends h implements View.OnClickListener, a.b {
    private String A;
    private g B;
    private boolean C;
    private boolean D;
    private String E;
    private boolean F;
    private RelativeLayout G;
    private String H = getClass().getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    TextWatcher f12964a = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() == 0) {
                f.d(f.this);
            } else if (charSequence.length() != 11) {
                boolean unused = f.this.n = false;
                f.this.f12971h.setVisibility(4);
                f.this.j.setTextColor(f.this.getResources().getColor(R.color.p2b_blue));
                f.this.j.setText(f.this.getString(R.string.p2b_verify_ifsc));
                f.this.f12966c.setError((CharSequence) null);
            } else if (!f.this.n) {
                f.this.x.c(f.this.f12970g.getText().toString());
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextInputLayout f12965b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextInputLayout f12966c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextInputLayout f12967d;

    /* renamed from: e  reason: collision with root package name */
    private EditText f12968e;

    /* renamed from: f  reason: collision with root package name */
    private EditText f12969f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f12970g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageView f12971h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f12972i;
    /* access modifiers changed from: private */
    public TextView j;
    private String k;
    private String l;
    private String m;
    /* access modifiers changed from: private */
    public boolean n;
    private final int o = 1;
    private final int p = 2;
    private final int q = 3;
    private int r = 2;
    private TextView s;
    private double t;
    private double u;
    private double v;
    private double w;
    /* access modifiers changed from: private */
    public a.C1057a x;
    private LottieAnimationView y;
    private String z;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.p2b_layout_enter_bank_details, viewGroup, false);
        this.y = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.f12965b = (TextInputLayout) inflate.findViewById(R.id.til_p2b_account_number);
        this.f12968e = (EditText) inflate.findViewById(R.id.tv_acc_no);
        this.f12972i = (RelativeLayout) inflate.findViewById(R.id.lyt_p2b_ifsc_code);
        this.f12966c = (TextInputLayout) inflate.findViewById(R.id.til_p2b_ifsc_code);
        this.f12970g = (EditText) inflate.findViewById(R.id.et_p2b_ifsc_code);
        this.f12971h = (ImageView) inflate.findViewById(R.id.iv_ifsc_verify);
        this.j = (TextView) inflate.findViewById(R.id.tv_p2b_ifsc_code_state);
        this.f12969f = (EditText) inflate.findViewById(R.id.edit_p2b_account_holder_name);
        this.f12967d = (TextInputLayout) inflate.findViewById(R.id.til_p2b_account_name);
        this.s = (TextView) inflate.findViewById(R.id.btn_proceed);
        this.s.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.f12969f.setImeOptions(5);
        this.G = (RelativeLayout) inflate.findViewById(R.id.rl_loader);
        this.f12969f.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 5) {
                    return false;
                }
                f.this.g();
                return true;
            }
        });
        this.f12970g.addTextChangedListener(this.f12964a);
        this.f12968e.setFilters(new InputFilter[]{new a()});
        this.f12968e.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                f.this.f12965b.setError((CharSequence) null);
            }
        });
        this.f12969f.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                f.this.f12967d.setError((CharSequence) null);
            }
        });
        this.j.setOnClickListener(this);
        if (this.x.b()) {
            a();
        }
        k.a((Activity) getActivity());
        this.f12965b.requestFocus();
        this.f12968e.requestFocus();
        k.a(this.f12968e, (Activity) getActivity());
        this.f12968e.requestFocus();
        k.a(this.f12968e, (Activity) getActivity());
        return inflate;
    }

    public static f a(double d2, double d3, double d4, double d5, boolean z2, boolean z3) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putDouble(c.f12671a, d2);
        bundle.putDouble(c.f12674d, d4);
        bundle.putDouble(c.f12672b, d3);
        bundle.putDouble(c.f12673c, d5);
        bundle.putBoolean(c.f12678h, z2);
        bundle.putBoolean(c.f12679i, z3);
        fVar.setArguments(bundle);
        return fVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_proceed) {
            g();
        } else if (id != R.id.tv_p2b_ifsc_code_state) {
        } else {
            if (this.j.getText().toString().equalsIgnoreCase(getResources().getString(R.string.p2b_verify_ifsc))) {
                this.x.c(this.f12970g.getText().toString());
            } else if (this.j.getText().toString().equalsIgnoreCase(getResources().getString(R.string.p2b_find_ifsc))) {
                this.l = "";
                this.m = "";
                startActivityForResult(net.one97.paytm.p2b.d.h.b().f(getActivity()), 106);
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        k.a((Activity) getActivity());
        int i2 = this.r;
        if (i2 == 1) {
            b("Proceed from BeneficiaryList clicked");
        } else if (i2 == 2) {
            h();
        } else if (i2 == 3) {
            h();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof g) {
            this.B = (g) context;
        }
        if (getArguments() != null) {
            this.t = getArguments().getDouble(c.f12671a);
            this.u = getArguments().getDouble(c.f12674d);
            this.v = getArguments().getDouble(c.f12672b);
            this.w = getArguments().getDouble(c.f12673c);
            this.C = getArguments().getBoolean(c.f12678h);
            this.F = getArguments().getBoolean(c.f12679i);
        }
        this.E = getString(R.string.p2b_rupee_prefix);
        this.x = new net.one97.paytm.p2b.c.a(this, b.a(getContext()), this.C, this.H);
        if (this.F) {
            i.a(getContext(), c.L, (String) null, (String) null, (String) null);
        }
    }

    private void h() {
        this.z = this.f12965b.getEditText().getText().toString();
        this.A = this.f12967d.getEditText().getText().toString();
        this.k = this.f12966c.getEditText().getText().toString();
        this.D = false;
        if (this.x.a(this.z) && this.x.a(this.k, this.n, this.z) && this.x.b(this.A)) {
            if (this.F) {
                i.a(getContext(), c.u, c.v, c.C, this.l);
            }
            if (TextUtils.isEmpty(this.m)) {
                this.x.d(this.k);
            } else {
                j();
            }
        }
    }

    private void b(String str) {
        Toast.makeText(getContext(), str, 0).show();
    }

    private void i() {
        this.f12971h.setVisibility(0);
        this.f12970g.setText(this.k);
        this.j.setText(getResources().getString(R.string.p2b_verified_ifsc));
        this.j.setTextColor(getResources().getColor(R.color.p2b_ifsc_verified_color));
        this.f12965b.setError((CharSequence) null);
        this.f12966c.setError((CharSequence) null);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 106 && intent != null) {
            this.k = intent.getStringExtra("intent_extra_ifsc_code");
            this.l = intent.getStringExtra("intent_extra_bank_name");
            if (!TextUtils.isEmpty(this.k)) {
                this.n = true;
                i();
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.f12971h.setVisibility(4);
            this.n = false;
            this.j.setTextColor(getResources().getColor(R.color.p2b_blue));
            this.j.setText(getString(R.string.p2b_find_ifsc));
            if (networkCustomError instanceof NetworkCustomError) {
                try {
                    if (!getActivity().isFinishing() && networkCustomError != null) {
                        String message = networkCustomError.getMessage();
                        if ((TextUtils.isEmpty(message) || (!message.equalsIgnoreCase("410") && !message.equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) && !message.equalsIgnoreCase("403")) {
                            CJRError a2 = net.one97.paytm.p2b.d.h.b().a((Context) getActivity(), networkCustomError);
                            if (a2 != null && !TextUtils.isEmpty(a2.getTitle()) && !TextUtils.isEmpty(a2.getMessage())) {
                                c(a2.getMessage());
                            } else if (message == null || !message.equalsIgnoreCase("parsing_error")) {
                                c(getString(R.string.p2b_network_error_message));
                            } else {
                                c(net.one97.paytm.p2b.d.h.b().c(getActivity(), networkCustomError.getUrl()).getMessage());
                            }
                            if (networkCustomError != null) {
                                net.one97.paytm.p2b.d.h.b().a((Context) getActivity(), networkCustomError, "error.wallet@paytm.com");
                                return;
                            }
                            return;
                        }
                        this.B.e();
                    }
                } catch (Resources.NotFoundException | Exception unused) {
                }
            }
        }
    }

    public final void a() {
        this.s.setVisibility(8);
        this.G.setVisibility(0);
        k.a(this.y);
        a(false);
    }

    private void a(boolean z2) {
        this.s.setVisibility(0);
        this.G.setVisibility(8);
        TextView textView = this.s;
        if (textView != null) {
            textView.setEnabled(z2);
        }
    }

    public final void b() {
        this.s.setVisibility(0);
        this.G.setVisibility(8);
        k.b(this.y);
        a(true);
    }

    public final void c() {
        String string = getString(R.string.p2b_account_number_error);
        if (TextUtils.isEmpty(this.f12968e.getText())) {
            string = getString(R.string.p2b_empty_account_number);
        }
        this.f12965b.setError(string);
        ViewParent parent = this.f12968e.getParent();
        EditText editText = this.f12968e;
        parent.requestChildFocus(editText, editText);
        this.f12968e.requestFocus();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_error_type", "send_money_error");
            hashMap.put("wallet_error_text", string);
            i.a(getContext(), (Map<String, Object>) hashMap, this.F);
        } catch (Exception unused) {
        }
    }

    public final void d() {
        this.f12967d.setError(getString(R.string.p2b_account_holder_name_incorrect_error));
        ViewParent parent = this.f12969f.getParent();
        EditText editText = this.f12969f;
        parent.requestChildFocus(editText, editText);
        this.f12969f.requestFocus();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_error_type", "send_money_error");
            hashMap.put("wallet_error_text", getString(R.string.p2b_account_holder_name_incorrect_error));
            i.a(getContext(), (Map<String, Object>) hashMap, this.F);
        } catch (Exception unused) {
        }
    }

    public final void e() {
        this.f12966c.setError(getString(R.string.p2b_ifsc_incorrect_error));
        ViewParent parent = this.f12970g.getParent();
        EditText editText = this.f12970g;
        parent.requestChildFocus(editText, editText);
        this.f12970g.requestFocus();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_error_type", "send_money_error");
            hashMap.put("wallet_error_text", getString(R.string.p2b_ifsc_incorrect_error));
            i.a(getContext(), (Map<String, Object>) hashMap, this.F);
        } catch (Exception unused) {
        }
    }

    public final void f() {
        this.f12965b.setError(getString(R.string.p2b_paytm_ifsc_check));
        ViewParent parent = this.f12968e.getParent();
        EditText editText = this.f12968e;
        parent.requestChildFocus(editText, editText);
        this.f12968e.requestFocus();
    }

    public final void a(String str) {
        this.m = str;
        j();
    }

    public final void a(Object obj) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            CJRBankDetails cJRBankDetails = (CJRBankDetails) obj;
            if (getActivity().isFinishing()) {
                return;
            }
            if (cJRBankDetails.getStatusCode() == null || !cJRBankDetails.getStatusCode().equalsIgnoreCase("SUCCESS") || cJRBankDetails.getResponse() == null) {
                this.j.setTextColor(getResources().getColor(R.color.p2b_blue));
                this.j.setText(getString(R.string.p2b_find_ifsc));
                this.f12966c.setError(cJRBankDetails.getStatusMessage());
                ViewParent parent = this.f12970g.getParent();
                EditText editText = this.f12970g;
                parent.requestChildFocus(editText, editText);
                this.f12970g.requestFocus();
                return;
            }
            this.n = true;
            CJRBankDetailsResponse response = cJRBankDetails.getResponse();
            try {
                if (!this.F) {
                    net.one97.paytm.p2b.d.h.b().a("wallet_send_ifsc_continue_clicked", "BOTTOM NAV", "wallet_send_ifsc_input_type", "ifsc_manual", getActivity());
                }
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(response.getIfscCode())) {
                this.k = response.getIfscCode();
            }
            if (!TextUtils.isEmpty(response.getBankName())) {
                this.l = response.getBankName();
            }
            if (!TextUtils.isEmpty(response.getmBranchAddress())) {
                if (response.getmBranchAddress().length() >= 2) {
                    this.m = response.getmBranchAddress();
                } else {
                    this.m = response.getBranch();
                }
            }
            this.f12969f.requestFocus();
            i();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (getActivity() != null && isAdded()) {
            k.a((Activity) getActivity());
        }
    }

    public static class a implements InputFilter {
        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (int i6 = 0; i6 < i3; i6++) {
                char charAt = charSequence.charAt(i6);
                if (Character.isDigit(charAt)) {
                    sb.append(charAt);
                }
            }
            if (sb.length() == i3 - i2) {
                z = true;
            }
            if (z) {
                return null;
            }
            return sb.toString();
        }
    }

    private void c(String str) {
        this.f12966c.setError(str);
        ViewParent parent = this.f12970g.getParent();
        EditText editText = this.f12970g;
        parent.requestChildFocus(editText, editText);
        this.f12970g.requestFocus();
    }

    public void onDestroy() {
        super.onDestroy();
        a.C1057a aVar = this.x;
        if (aVar != null) {
            aVar.a();
        }
        k.a((Activity) getActivity());
    }

    public final void b(NetworkCustomError networkCustomError) {
        if (networkCustomError instanceof NetworkCustomError) {
            String valueOf = String.valueOf(networkCustomError.getStatusCode());
            if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(valueOf) || "403".equalsIgnoreCase(valueOf) || "410".equalsIgnoreCase(valueOf)) {
                this.B.e();
            } else {
                a((String) null);
            }
        } else {
            a((String) null);
        }
    }

    private void j() {
        View inflate = getLayoutInflater().inflate(R.layout.p2b_reenter_bank_account, (ViewGroup) null);
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(getContext(), R.style.p2bAppBottomSheetDialogTheme);
        aVar.setContentView(inflate);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        a(aVar, from);
        b(true);
        final EditText editText = (EditText) inflate.findViewById(R.id.edit_p2b_account_number);
        if (this.z.trim().replaceAll("[0123456789]", "").length() == 0) {
            editText.setInputType(2);
        } else {
            editText.setInputType(129);
        }
        inflate.findViewById(R.id.cross_iv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.a((Activity) f.this.getActivity());
                if (f.this.getActivity().getCurrentFocus() != null) {
                    f.this.getActivity().getCurrentFocus().clearFocus();
                }
                editText.clearFocus();
                f.a(f.this, from, aVar);
            }
        });
        ((TextView) inflate.findViewById(R.id.name_tv)).setText(this.A);
        ((TextView) inflate.findViewById(R.id.bank_ifsc_tv)).setText(getString(R.string.p2b_ifsc_code_with_value, this.k));
        ((TextView) inflate.findViewById(R.id.bank_name_tv)).setText(this.m);
        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.float_p2b_account_number);
        editText.requestFocus();
        k.a(editText, (Activity) getActivity());
        textInputLayout.setVisibility(0);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                f.a(f.this, textInputLayout, aVar);
                return true;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                textInputLayout.setError((CharSequence) null);
            }
        });
        inflate.findViewById(R.id.w_custom_dialog_btn_positive).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                f.a(f.this, textInputLayout, aVar);
            }
        });
    }

    private void a(final com.google.android.material.bottomsheet.a aVar, final BottomSheetBehavior bottomSheetBehavior) {
        aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                f.a(f.this, bottomSheetBehavior, aVar);
            }
        });
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onStateChanged(View view, int i2) {
            }

            public final void onSlide(View view, float f2) {
                f.a(f.this, bottomSheetBehavior, aVar);
            }
        });
        bottomSheetBehavior.setState(3);
        bottomSheetBehavior.setPeekHeight(com.paytm.utility.b.b((Activity) getActivity()));
        aVar.show();
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                f.a(f.this, bottomSheetBehavior, aVar);
                return true;
            }
        });
    }

    private void b(boolean z2) {
        if (z2) {
            this.f12968e.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            this.f12968e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }

    static /* synthetic */ void d(f fVar) {
        fVar.n = false;
        fVar.l = "";
        fVar.m = "";
        fVar.j.setTextColor(fVar.getResources().getColor(R.color.p2b_blue));
        fVar.f12971h.setVisibility(4);
        fVar.j.setText(fVar.getString(R.string.p2b_find_ifsc));
    }

    static /* synthetic */ void a(f fVar, BottomSheetBehavior bottomSheetBehavior, com.google.android.material.bottomsheet.a aVar) {
        bottomSheetBehavior.setState(4);
        fVar.b(false);
        k.a((Activity) fVar.getActivity());
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    static /* synthetic */ void a(f fVar, TextInputLayout textInputLayout, com.google.android.material.bottomsheet.a aVar) {
        if (fVar.x.e(textInputLayout.getEditText().getText().toString())) {
            if (fVar.x.a(fVar.z, textInputLayout.getEditText().getText().toString())) {
                aVar.dismiss();
                k.a((Activity) fVar.getActivity());
                fVar.b(false);
                fVar.B.a(fVar.z, fVar.A, fVar.k, false, fVar.l, fVar.m);
                fVar.B.b(false);
                return;
            }
            textInputLayout.setError(fVar.getString(R.string.p2b_confirm_account_incorrect_error));
        } else if (TextUtils.isEmpty(textInputLayout.getEditText().getText().toString())) {
            textInputLayout.setError(fVar.getString(R.string.p2b_reenter_account_empty));
        } else {
            textInputLayout.setError(fVar.getString(R.string.p2b_reenter_valid_account_number));
        }
        textInputLayout.setErrorEnabled(true);
    }
}
