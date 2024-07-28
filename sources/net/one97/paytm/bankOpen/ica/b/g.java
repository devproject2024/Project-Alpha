package net.one97.paytm.bankOpen.ica.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.model.CJRBankDetails;
import net.one97.paytm.bankCommon.model.CJRBankDetailsResponse;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.bankOpen.ica.model.ICALoanModel;

public final class g extends e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    boolean f16528b;

    /* renamed from: c  reason: collision with root package name */
    protected TextInputEditText f16529c;

    /* renamed from: d  reason: collision with root package name */
    protected TextInputLayout f16530d;

    /* renamed from: e  reason: collision with root package name */
    protected TextView f16531e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f16532f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f16533g;

    /* renamed from: h  reason: collision with root package name */
    protected RelativeLayout f16534h;

    /* renamed from: i  reason: collision with root package name */
    protected RelativeLayout f16535i;
    protected ImageView j;
    /* access modifiers changed from: private */
    public String k = "";
    /* access modifiers changed from: private */
    public String l = "";
    /* access modifiers changed from: private */
    public String m = "";
    private net.one97.paytm.bankOpen.ica.d.a n;
    /* access modifiers changed from: private */
    public boolean o;
    private HashMap p;

    public final View a(int i2) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.p.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void f() {
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        f();
    }

    static final class e<T> implements z<net.one97.paytm.bankCommon.b.c<? extends Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f16540a;

        e(g gVar) {
            this.f16540a = gVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.bankCommon.b.c cVar = (net.one97.paytm.bankCommon.b.c) obj;
            this.f16540a.W_();
            this.f16540a.f16528b = false;
            if (cVar == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.api.Resource<kotlin.Any>");
            } else if (cVar != null && cVar.f16216a == net.one97.paytm.bankCommon.b.d.SUCCESS) {
                T t = cVar.f16217b;
                if (t != null) {
                    g.a(this.f16540a, (IJRPaytmDataModel) (CJRBankDetails) t);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.model.CJRBankDetails");
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.txt_p2b_ifsc_code_state;
        if (valueOf != null && valueOf.intValue() == i2) {
            TextInputLayout textInputLayout = this.f16530d;
            if (textInputLayout == null) {
                k.a("mIfscTil");
            }
            textInputLayout.setError((CharSequence) null);
            net.one97.paytm.bankCommon.mapping.a.c((Activity) getActivity());
            TextView textView = this.f16531e;
            if (textView == null) {
                k.a("mFindIfscTv");
            }
            if (!p.a(textView.getText().toString(), getResources().getString(R.string.verify), true)) {
                TextView textView2 = this.f16531e;
                if (textView2 == null) {
                    k.a("mFindIfscTv");
                }
                if (p.a(textView2.getText().toString(), getResources().getString(R.string.find_ifsc), true)) {
                    f.c();
                }
            } else if (com.paytm.utility.b.c((Context) getActivity())) {
                TextInputEditText textInputEditText = this.f16529c;
                if (textInputEditText == null) {
                    k.a("mIfscEdt");
                }
                a(String.valueOf(textInputEditText.getText()));
            } else {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else {
            int i3 = R.id.ifsc_value_rl;
            if (valueOf != null && valueOf.intValue() == i3) {
                RelativeLayout relativeLayout = this.f16535i;
                if (relativeLayout == null) {
                    k.a("mIfscFilledRly");
                }
                relativeLayout.setVisibility(8);
                TextInputLayout textInputLayout2 = this.f16530d;
                if (textInputLayout2 == null) {
                    k.a("mIfscTil");
                }
                textInputLayout2.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final TextInputEditText g() {
        TextInputEditText textInputEditText = this.f16529c;
        if (textInputEditText == null) {
            k.a("mIfscEdt");
        }
        return textInputEditText;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout h() {
        TextInputLayout textInputLayout = this.f16530d;
        if (textInputLayout == null) {
            k.a("mIfscTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextView i() {
        TextView textView = this.f16531e;
        if (textView == null) {
            k.a("mFindIfscTv");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final ImageView j() {
        ImageView imageView = this.j;
        if (imageView == null) {
            k.a("mIfscVerifiedImage");
        }
        return imageView;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.pb_ca_add_load_fragment, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        k.c(view, "view");
        ((ImageView) a(R.id.iv_back_arrow)).setOnClickListener(new a(this));
        ((Button) a(R.id.proced_button)).setOnClickListener(new b(this));
        View findViewById = view.findViewById(R.id.edit_p2b_ifsc_code);
        k.a((Object) findViewById, "view.findViewById(R.id.edit_p2b_ifsc_code)");
        this.f16529c = (TextInputEditText) findViewById;
        View findViewById2 = view.findViewById(R.id.float_p2b_ifsc_code);
        k.a((Object) findViewById2, "view.findViewById(R.id.float_p2b_ifsc_code)");
        this.f16530d = (TextInputLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.ifsc_verified_image);
        k.a((Object) findViewById3, "view.findViewById(R.id.ifsc_verified_image)");
        this.j = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.lyt_p2b_ifsc_code);
        k.a((Object) findViewById4, "view.findViewById(R.id.lyt_p2b_ifsc_code)");
        this.f16534h = (RelativeLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.ifsc_value_rl);
        k.a((Object) findViewById5, "view.findViewById(R.id.ifsc_value_rl)");
        this.f16535i = (RelativeLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.ifsc_verified_value);
        k.a((Object) findViewById6, "view.findViewById(R.id.ifsc_verified_value)");
        this.f16532f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.bank_verified_value);
        k.a((Object) findViewById7, "view.findViewById(R.id.bank_verified_value)");
        this.f16533g = (TextView) findViewById7;
        RelativeLayout relativeLayout = this.f16535i;
        if (relativeLayout == null) {
            k.a("mIfscFilledRly");
        }
        View.OnClickListener onClickListener = this;
        relativeLayout.setOnClickListener(onClickListener);
        View findViewById8 = view.findViewById(R.id.txt_p2b_ifsc_code_state);
        k.a((Object) findViewById8, "view.findViewById(R.id.txt_p2b_ifsc_code_state)");
        this.f16531e = (TextView) findViewById8;
        TextView textView = this.f16531e;
        if (textView == null) {
            k.a("mFindIfscTv");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        textView.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
        TextView textView2 = this.f16531e;
        if (textView2 == null) {
            k.a("mFindIfscTv");
        }
        textView2.setOnClickListener(onClickListener);
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.loan_amt_sac_til);
        k.a((Object) textInputLayout, "loan_amt_sac_til");
        textInputLayout.setHint(getString(R.string.pb_ca_loan_amt_sanction) + " (" + getString(R.string.si_rupee) + ")");
        TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.cop_til);
        k.a((Object) textInputLayout2, "cop_til");
        textInputLayout2.setHint(getString(R.string.pb_ca_current_outstanding_principal) + " (" + getString(R.string.si_rupee) + ")");
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.bankOpen.ica.d.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…oanViewModel::class.java)");
        this.n = (net.one97.paytm.bankOpen.ica.d.a) a2;
        TextInputEditText textInputEditText = this.f16529c;
        if (textInputEditText == null) {
            k.a("mIfscEdt");
        }
        textInputEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(11)});
        TextInputEditText textInputEditText2 = this.f16529c;
        if (textInputEditText2 == null) {
            k.a("mIfscEdt");
        }
        textInputEditText2.addTextChangedListener(new c(this));
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        if (arguments.containsKey("loan")) {
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            Serializable serializable = arguments2.getSerializable("loan");
            if (serializable != null) {
                ICALoanModel iCALoanModel = (ICALoanModel) serializable;
                TextInputEditText textInputEditText3 = this.f16529c;
                if (textInputEditText3 == null) {
                    k.a("mIfscEdt");
                }
                textInputEditText3.setText(iCALoanModel.getIfscCode());
                ((TextInputEditText) a(R.id.cop_et)).setText(iCALoanModel.getCurrentPrincipalOutstanding());
                ((TextInputEditText) a(R.id.loan_amt_sac_et)).setText(iCALoanModel.getLoanAmount());
                ((TextInputEditText) a(R.id.account_number_et)).setText(iCALoanModel.getAccountNumber());
                ((TextInputEditText) a(R.id.loan_et)).setText(iCALoanModel.getTypeOfLoan());
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.bankOpen.ica.model.ICALoanModel");
            }
        }
        net.one97.paytm.bankOpen.ica.c.b bVar = net.one97.paytm.bankOpen.ica.c.b.f16584a;
        TextInputEditText textInputEditText4 = (TextInputEditText) a(R.id.cop_et);
        k.a((Object) textInputEditText4, "cop_et");
        net.one97.paytm.bankOpen.ica.c.b.a(textInputEditText4);
        net.one97.paytm.bankOpen.ica.c.b bVar2 = net.one97.paytm.bankOpen.ica.c.b.f16584a;
        TextInputEditText textInputEditText5 = (TextInputEditText) a(R.id.loan_amt_sac_et);
        k.a((Object) textInputEditText5, "loan_amt_sac_et");
        net.one97.paytm.bankOpen.ica.c.b.a(textInputEditText5);
        TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.cop_til);
        k.a((Object) textInputLayout3, "cop_til");
        TextInputEditText textInputEditText6 = (TextInputEditText) a(R.id.cop_et);
        k.a((Object) textInputEditText6, "cop_et");
        a(textInputLayout3, textInputEditText6);
        TextInputLayout textInputLayout4 = (TextInputLayout) a(R.id.loan_type_til);
        k.a((Object) textInputLayout4, "loan_type_til");
        TextInputEditText textInputEditText7 = (TextInputEditText) a(R.id.loan_et);
        k.a((Object) textInputEditText7, "loan_et");
        a(textInputLayout4, textInputEditText7);
        TextInputLayout textInputLayout5 = (TextInputLayout) a(R.id.loan_amt_sac_til);
        k.a((Object) textInputLayout5, "loan_amt_sac_til");
        TextInputEditText textInputEditText8 = (TextInputEditText) a(R.id.loan_amt_sac_et);
        k.a((Object) textInputEditText8, "loan_amt_sac_et");
        a(textInputLayout5, textInputEditText8);
        TextInputLayout textInputLayout6 = this.f16530d;
        if (textInputLayout6 == null) {
            k.a("mIfscTil");
        }
        TextInputEditText textInputEditText9 = this.f16529c;
        if (textInputEditText9 == null) {
            k.a("mIfscEdt");
        }
        a(textInputLayout6, textInputEditText9);
        TextInputLayout textInputLayout7 = (TextInputLayout) a(R.id.account_til);
        k.a((Object) textInputLayout7, "account_til");
        TextInputEditText textInputEditText10 = (TextInputEditText) a(R.id.account_number_et);
        k.a((Object) textInputEditText10, "account_number_et");
        a(textInputLayout7, textInputEditText10);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f16536a;

        a(g gVar) {
            this.f16536a = gVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f16536a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f16537a;

        b(g gVar) {
            this.f16537a = gVar;
        }

        public final void onClick(View view) {
            if (g.a(this.f16537a)) {
                ICALoanModel iCALoanModel = new ICALoanModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (kotlin.g.b.g) null);
                TextInputEditText textInputEditText = (TextInputEditText) this.f16537a.a(R.id.account_number_et);
                k.a((Object) textInputEditText, "account_number_et");
                iCALoanModel.setAccountNumber(String.valueOf(textInputEditText.getText()));
                iCALoanModel.setBankName(this.f16537a.l);
                iCALoanModel.setIfscCode(this.f16537a.m);
                iCALoanModel.setBranchName(this.f16537a.k);
                TextInputEditText textInputEditText2 = (TextInputEditText) this.f16537a.a(R.id.loan_et);
                k.a((Object) textInputEditText2, "loan_et");
                iCALoanModel.setTypeOfLoan(String.valueOf(textInputEditText2.getText()));
                TextInputEditText textInputEditText3 = (TextInputEditText) this.f16537a.a(R.id.cop_et);
                k.a((Object) textInputEditText3, "cop_et");
                iCALoanModel.setCurrentPrincipalOutstanding(String.valueOf(textInputEditText3.getText()));
                TextInputEditText textInputEditText4 = (TextInputEditText) this.f16537a.a(R.id.loan_amt_sac_et);
                k.a((Object) textInputEditText4, "loan_amt_sac_et");
                iCALoanModel.setLoanAmount(String.valueOf(textInputEditText4.getText()));
                Intent intent = new Intent();
                intent.putExtra("loan", iCALoanModel);
                Bundle arguments = this.f16537a.getArguments();
                if (arguments == null) {
                    k.a();
                }
                if (arguments.containsKey("loan_position")) {
                    Bundle arguments2 = this.f16537a.getArguments();
                    if (arguments2 == null) {
                        k.a();
                    }
                    intent.putExtra("loan_position", arguments2.getInt("loan_position"));
                }
                FragmentActivity activity = this.f16537a.getActivity();
                if (activity != null) {
                    activity.setResult(-1, intent);
                }
                FragmentActivity activity2 = this.f16537a.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f16538a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(g gVar) {
            this.f16538a = gVar;
        }

        public final void afterTextChanged(Editable editable) {
            if (editable != null && editable.length() == 0) {
                TextView i2 = this.f16538a.i();
                FragmentActivity activity = this.f16538a.getActivity();
                if (activity == null) {
                    k.a();
                }
                i2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
                this.f16538a.o = false;
                this.f16538a.j().setVisibility(8);
                this.f16538a.i().setText(this.f16538a.getString(R.string.find_ifsc));
                this.f16538a.i().setVisibility(0);
                this.f16538a.h().setError((CharSequence) null);
            } else if (editable == null || editable.length() != 11) {
                this.f16538a.o = false;
                this.f16538a.j().setVisibility(8);
                TextView i3 = this.f16538a.i();
                FragmentActivity activity2 = this.f16538a.getActivity();
                if (activity2 == null) {
                    k.a();
                }
                i3.setTextColor(androidx.core.content.b.c(activity2, R.color.color_blue_ifsc));
                this.f16538a.i().setText(this.f16538a.getString(R.string.verify));
                this.f16538a.i().setVisibility(0);
                this.f16538a.h().setError((CharSequence) null);
            } else {
                this.f16538a.h().setError((CharSequence) null);
                if (!this.f16538a.o) {
                    g gVar = this.f16538a;
                    gVar.a(String.valueOf(gVar.g().getText()));
                }
            }
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f16539a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        d(TextInputLayout textInputLayout) {
            this.f16539a = textInputLayout;
        }

        public final void afterTextChanged(Editable editable) {
            this.f16539a.setError((CharSequence) null);
        }
    }

    private static void a(TextInputLayout textInputLayout, TextInputEditText textInputEditText) {
        textInputEditText.addTextChangedListener(new d(textInputLayout));
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        this.f16528b = true;
        a(getActivity(), getString(R.string.please_wait));
        if (this.n == null) {
            k.a("viewModel");
        }
        net.one97.paytm.bankOpen.ica.d.a.a(str).observe(this, new e(this));
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 106 && i3 == -1 && intent != null) {
            this.m = intent.getStringExtra("intent_extra_ifsc_code");
            this.l = intent.getStringExtra("intent_extra_bank_name");
            if (!TextUtils.isEmpty(this.m)) {
                this.o = true;
                a(this.m, this.l);
                a(true, "");
                TextInputLayout textInputLayout = this.f16530d;
                if (textInputLayout == null) {
                    k.a("mIfscTil");
                }
                textInputLayout.setError((CharSequence) null);
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    private void a(boolean z, String str) {
        k.c(str, "message");
        this.o = z;
        if (z) {
            TextInputLayout textInputLayout = this.f16530d;
            if (textInputLayout == null) {
                k.a("mIfscTil");
            }
            textInputLayout.setVisibility(8);
            ImageView imageView = this.j;
            if (imageView == null) {
                k.a("mIfscVerifiedImage");
            }
            imageView.setVisibility(0);
            RelativeLayout relativeLayout = this.f16535i;
            if (relativeLayout == null) {
                k.a("mIfscFilledRly");
            }
            relativeLayout.setVisibility(0);
            TextView textView = this.f16531e;
            if (textView == null) {
                k.a("mFindIfscTv");
            }
            textView.setVisibility(8);
            TextInputLayout textInputLayout2 = this.f16530d;
            if (textInputLayout2 == null) {
                k.a("mIfscTil");
            }
            textInputLayout2.setError((CharSequence) null);
            ((TextInputEditText) a(R.id.cop_et)).requestFocus();
        } else if (!z) {
            ImageView imageView2 = this.j;
            if (imageView2 == null) {
                k.a("mIfscVerifiedImage");
            }
            imageView2.setVisibility(8);
            TextView textView2 = this.f16531e;
            if (textView2 == null) {
                k.a("mFindIfscTv");
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
            TextView textView3 = this.f16531e;
            if (textView3 == null) {
                k.a("mFindIfscTv");
            }
            textView3.setText(getString(R.string.find_ifsc));
            TextView textView4 = this.f16531e;
            if (textView4 == null) {
                k.a("mFindIfscTv");
            }
            textView4.setVisibility(0);
            TextInputLayout textInputLayout3 = this.f16530d;
            if (textInputLayout3 == null) {
                k.a("mIfscTil");
            }
            textInputLayout3.setError(str);
        }
    }

    private void a(String str, String str2) {
        this.m = str;
        this.l = str2;
        TextView textView = this.f16532f;
        if (textView == null) {
            k.a("mIfscVerifiedValueTv");
        }
        textView.setText(str);
        TextView textView2 = this.f16533g;
        if (textView2 == null) {
            k.a("mIfscBankVerifiedTv");
        }
        textView2.setText(str2);
        TextInputEditText textInputEditText = this.f16529c;
        if (textInputEditText == null) {
            k.a("mIfscEdt");
        }
        textInputEditText.setText(this.m);
    }

    public static final /* synthetic */ boolean a(g gVar) {
        TextInputEditText textInputEditText = (TextInputEditText) gVar.a(R.id.loan_et);
        k.a((Object) textInputEditText, "loan_et");
        CharSequence text = textInputEditText.getText();
        if (text == null || text.length() == 0) {
            TextInputLayout textInputLayout = (TextInputLayout) gVar.a(R.id.loan_type_til);
            k.a((Object) textInputLayout, "loan_type_til");
            textInputLayout.setError(gVar.getString(R.string.pb_ca_error_loan_type));
            return false;
        }
        TextInputEditText textInputEditText2 = (TextInputEditText) gVar.a(R.id.account_number_et);
        k.a((Object) textInputEditText2, "account_number_et");
        CharSequence text2 = textInputEditText2.getText();
        if (text2 == null || text2.length() == 0) {
            TextInputLayout textInputLayout2 = (TextInputLayout) gVar.a(R.id.account_til);
            k.a((Object) textInputLayout2, "account_til");
            textInputLayout2.setError(gVar.getString(R.string.pb_ca_error_acc_no));
            return false;
        } else if (gVar.o) {
            TextInputEditText textInputEditText3 = (TextInputEditText) gVar.a(R.id.cop_et);
            k.a((Object) textInputEditText3, "cop_et");
            CharSequence text3 = textInputEditText3.getText();
            if (text3 == null || text3.length() == 0) {
                TextInputLayout textInputLayout3 = (TextInputLayout) gVar.a(R.id.cop_til);
                k.a((Object) textInputLayout3, "cop_til");
                textInputLayout3.setError(gVar.getString(R.string.pb_ca_error_cop, gVar.getString(R.string.pb_ca_current_outstanding_principal)));
                return false;
            }
            TextInputEditText textInputEditText4 = (TextInputEditText) gVar.a(R.id.loan_amt_sac_et);
            k.a((Object) textInputEditText4, "loan_amt_sac_et");
            CharSequence text4 = textInputEditText4.getText();
            if (text4 == null || text4.length() == 0) {
                TextInputLayout textInputLayout4 = (TextInputLayout) gVar.a(R.id.loan_amt_sac_til);
                k.a((Object) textInputLayout4, "loan_amt_sac_til");
                textInputLayout4.setError(gVar.getString(R.string.pb_ca_error_loan_amt_sac));
                return false;
            }
            TextInputEditText textInputEditText5 = (TextInputEditText) gVar.a(R.id.loan_amt_sac_et);
            k.a((Object) textInputEditText5, "loan_amt_sac_et");
            double parseDouble = Double.parseDouble(String.valueOf(textInputEditText5.getText()));
            TextInputEditText textInputEditText6 = (TextInputEditText) gVar.a(R.id.loan_amt_sac_et);
            k.a((Object) textInputEditText6, "loan_amt_sac_et");
            if (Double.compare(parseDouble, Double.parseDouble(String.valueOf(textInputEditText6.getText()))) <= 0) {
                return true;
            }
            TextInputLayout textInputLayout5 = (TextInputLayout) gVar.a(R.id.cop_til);
            k.a((Object) textInputLayout5, "cop_til");
            textInputLayout5.setError(gVar.getString(R.string.pb_ca_cop_greater_error));
            return false;
        } else if (!gVar.f16528b) {
            TextInputLayout textInputLayout6 = gVar.f16530d;
            if (textInputLayout6 == null) {
                k.a("mIfscTil");
            }
            textInputLayout6.setError(gVar.getString(R.string.pb_ca_error_ifsc));
            return false;
        } else {
            TextInputLayout textInputLayout7 = gVar.f16530d;
            if (textInputLayout7 == null) {
                k.a("mIfscTil");
            }
            textInputLayout7.setError(gVar.getString(R.string.please_wait));
            return false;
        }
    }

    public static final /* synthetic */ void a(g gVar, IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRBankDetails)) {
            CJRBankDetails cJRBankDetails = (CJRBankDetails) iJRPaytmDataModel;
            if (p.a(cJRBankDetails.getStatusCode(), "SUCCESS", true)) {
                gVar.a(true, "");
                CJRBankDetailsResponse response = cJRBankDetails.getResponse();
                k.a((Object) response, "response.response");
                gVar.k = response.getBankName();
                CJRBankDetailsResponse response2 = cJRBankDetails.getResponse();
                if (response2 == null || (str = response2.getIfscCode()) == null) {
                    str = "";
                }
                CJRBankDetailsResponse response3 = cJRBankDetails.getResponse();
                if (response3 == null || (str2 = response3.getBankName()) == null) {
                    str2 = "";
                }
                gVar.a(str, str2);
                return;
            }
            String statusMessage = cJRBankDetails.getStatusMessage();
            k.a((Object) statusMessage, "response.statusMessage");
            gVar.a(false, statusMessage);
        }
    }
}
