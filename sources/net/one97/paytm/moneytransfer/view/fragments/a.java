package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.l;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.CJRBankDetails;
import net.one97.paytm.upi.common.models.CJRBankDetailsResponse;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public class a extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected AppCompatEditText f54399a;

    /* renamed from: b  reason: collision with root package name */
    protected AppCompatEditText f54400b;

    /* renamed from: c  reason: collision with root package name */
    protected AppCompatEditText f54401c;

    /* renamed from: d  reason: collision with root package name */
    protected TextInputLayout f54402d;

    /* renamed from: e  reason: collision with root package name */
    protected TextInputLayout f54403e;

    /* renamed from: f  reason: collision with root package name */
    protected TextInputLayout f54404f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f54405g;

    /* renamed from: h  reason: collision with root package name */
    protected TextView f54406h;

    /* renamed from: i  reason: collision with root package name */
    protected TextView f54407i;
    protected TextView j;
    protected RelativeLayout k;
    protected RelativeLayout l;
    protected ImageView m;
    String n;
    String o;
    String p;
    String q;
    boolean r;
    boolean s;
    C0975a t;
    private HashMap u;

    /* renamed from: net.one97.paytm.moneytransfer.view.fragments.a$a  reason: collision with other inner class name */
    public enum C0975a {
        ACCOUNT_NUMBER,
        AADHAR,
        VPA
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    public void j() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        j();
    }

    /* access modifiers changed from: protected */
    public final AppCompatEditText a() {
        AppCompatEditText appCompatEditText = this.f54399a;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaEdt");
        }
        return appCompatEditText;
    }

    /* access modifiers changed from: protected */
    public final AppCompatEditText b() {
        AppCompatEditText appCompatEditText = this.f54401c;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        return appCompatEditText;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout c() {
        TextInputLayout textInputLayout = this.f54402d;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout d() {
        TextInputLayout textInputLayout = this.f54403e;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mAccountNameTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout e() {
        TextInputLayout textInputLayout = this.f54404f;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mIfscTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextView f() {
        TextView textView = this.f54405g;
        if (textView == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final ImageView g() {
        ImageView imageView = this.m;
        if (imageView == null) {
            kotlin.g.b.k.a("mIfscVerifiedImage");
        }
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        com.paytm.b.a.a aVar;
        boolean z;
        Context applicationContext;
        kotlin.g.b.k.c(view, "view");
        View findViewById = view.findViewById(R.id.account_number_et);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.account_number_et)");
        this.f54399a = (AppCompatEditText) findViewById;
        View findViewById2 = view.findViewById(R.id.account_name_et);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.account_name_et)");
        this.f54400b = (AppCompatEditText) findViewById2;
        View findViewById3 = view.findViewById(R.id.edit_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.edit_p2b_ifsc_code)");
        this.f54401c = (AppCompatEditText) findViewById3;
        View findViewById4 = view.findViewById(R.id.account_til);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.account_til)");
        this.f54402d = (TextInputLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.account_name_til);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.account_name_til)");
        this.f54403e = (TextInputLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.float_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.float_p2b_ifsc_code)");
        this.f54404f = (TextInputLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.ifsc_verified_image);
        kotlin.g.b.k.a((Object) findViewById7, "view.findViewById(R.id.ifsc_verified_image)");
        this.m = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.lyt_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById8, "view.findViewById(R.id.lyt_p2b_ifsc_code)");
        this.k = (RelativeLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.ifsc_value_rl);
        kotlin.g.b.k.a((Object) findViewById9, "view.findViewById(R.id.ifsc_value_rl)");
        this.l = (RelativeLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.ifsc_verified_value);
        kotlin.g.b.k.a((Object) findViewById10, "view.findViewById(R.id.ifsc_verified_value)");
        this.f54406h = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.btn_proceed);
        kotlin.g.b.k.a((Object) findViewById11, "view.findViewById(R.id.btn_proceed)");
        this.j = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.bank_verified_value);
        kotlin.g.b.k.a((Object) findViewById12, "view.findViewById(R.id.bank_verified_value)");
        this.f54407i = (TextView) findViewById12;
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mIfscFilledRly");
        }
        View.OnClickListener onClickListener = this;
        relativeLayout.setOnClickListener(onClickListener);
        View findViewById13 = view.findViewById(R.id.txt_p2b_ifsc_code_state);
        kotlin.g.b.k.a((Object) findViewById13, "view.findViewById(R.id.txt_p2b_ifsc_code_state)");
        this.f54405g = (TextView) findViewById13;
        TextView textView = this.f54405g;
        if (textView == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        textView.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
        TextView textView2 = this.f54405g;
        if (textView2 == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        textView2.setOnClickListener(onClickListener);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (applicationContext = activity2.getApplicationContext()) == null) {
            aVar = null;
        } else {
            l.a aVar2 = net.one97.paytm.moneytransfer.utils.l.f54175a;
            aVar = l.a.a(applicationContext);
        }
        if (aVar != null) {
            z = aVar.b("is_upi_user", false, true);
        } else {
            z = false;
        }
        if (z) {
            TextInputLayout textInputLayout = this.f54402d;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaTil");
            }
            textInputLayout.setHint(getString(R.string.univ_money_trnsfr_upi_bank_acc_adhaar));
            InputFilter[] inputFilterArr = new InputFilter[0];
            AppCompatEditText appCompatEditText = this.f54399a;
            if (appCompatEditText == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaEdt");
            }
            appCompatEditText.setFilters(inputFilterArr);
            a(C0975a.VPA);
        } else {
            TextInputLayout textInputLayout2 = this.f54402d;
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaTil");
            }
            textInputLayout2.setHint(getString(R.string.money_transfer_account_number));
            InputFilter[] inputFilterArr2 = {new net.one97.paytm.moneytransfer.utils.b()};
            AppCompatEditText appCompatEditText2 = this.f54399a;
            if (appCompatEditText2 == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaEdt");
            }
            appCompatEditText2.setFilters(inputFilterArr2);
            a(C0975a.ACCOUNT_NUMBER);
        }
        AppCompatEditText appCompatEditText3 = this.f54401c;
        if (appCompatEditText3 == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        appCompatEditText3.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(11)});
        AppCompatEditText appCompatEditText4 = this.f54399a;
        if (appCompatEditText4 == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaEdt");
        }
        appCompatEditText4.addTextChangedListener(new b(this));
        AppCompatEditText appCompatEditText5 = this.f54400b;
        if (appCompatEditText5 == null) {
            kotlin.g.b.k.a("mAccountNameEdt");
        }
        appCompatEditText5.addTextChangedListener(new c(this));
        AppCompatEditText appCompatEditText6 = this.f54401c;
        if (appCompatEditText6 == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        appCompatEditText6.addTextChangedListener(new d(this));
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54408a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        b(a aVar) {
            this.f54408a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f54408a.c().setError((CharSequence) null);
            this.f54408a.d().setError((CharSequence) null);
            this.f54408a.e().setError((CharSequence) null);
            if (charSequence == null) {
                kotlin.g.b.k.a();
            }
            if (charSequence.length() <= 0) {
                this.f54408a.a((C0975a) null);
            } else if (UpiAppUtils.checkIsVpa(charSequence.toString())) {
                this.f54408a.a(C0975a.VPA);
                this.f54408a.b(false, "No Error");
            } else {
                this.f54408a.a(C0975a.ACCOUNT_NUMBER);
            }
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54409a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(a aVar) {
            this.f54409a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f54409a.c().setError((CharSequence) null);
            this.f54409a.d().setError((CharSequence) null);
            this.f54409a.e().setError((CharSequence) null);
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54410a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        d(a aVar) {
            this.f54410a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f54410a.c().setError((CharSequence) null);
            this.f54410a.d().setError((CharSequence) null);
            if (charSequence != null && charSequence.length() == 0) {
                TextView f2 = this.f54410a.f();
                FragmentActivity activity = this.f54410a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                f2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
                a aVar = this.f54410a;
                aVar.r = false;
                aVar.g().setVisibility(8);
                this.f54410a.f().setText(this.f54410a.getString(R.string.money_transfer_find_ifsc));
                this.f54410a.f().setVisibility(0);
                this.f54410a.e().setError((CharSequence) null);
            } else if (charSequence == null || charSequence.length() != 11) {
                a aVar2 = this.f54410a;
                aVar2.r = false;
                aVar2.g().setVisibility(8);
                TextView f3 = this.f54410a.f();
                FragmentActivity activity2 = this.f54410a.getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                f3.setTextColor(androidx.core.content.b.c(activity2, R.color.color_blue_ifsc));
                this.f54410a.f().setText(this.f54410a.getString(R.string.money_transfer_verify));
                this.f54410a.f().setVisibility(0);
                this.f54410a.e().setError((CharSequence) null);
            } else if (!this.f54410a.r) {
                a aVar3 = this.f54410a;
                aVar3.a(String.valueOf(aVar3.b().getText()));
            }
        }
    }

    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.txt_p2b_ifsc_code_state;
        if (valueOf != null && valueOf.intValue() == i2) {
            TextInputLayout textInputLayout = this.f54404f;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout.setError((CharSequence) null);
            UpiAppUtils.hideKeyboard(getActivity());
            TextView textView = this.f54405g;
            if (textView == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            if (!p.a(textView.getText().toString(), getResources().getString(R.string.money_transfer_verify), true)) {
                TextView textView2 = this.f54405g;
                if (textView2 == null) {
                    kotlin.g.b.k.a("mFindIfscTv");
                }
                if (p.a(textView2.getText().toString(), getResources().getString(R.string.money_transfer_find_ifsc), true)) {
                    d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                    Intent intent = new Intent(getActivity(), Class.forName(net.one97.paytm.moneytransfer.d.d.b(d.a.a()).e()));
                    intent.putExtra("show_ifsc_new_design", true);
                    startActivityForResult(intent, 106);
                }
            } else if (com.paytm.utility.a.m(getActivity())) {
                AppCompatEditText appCompatEditText = this.f54401c;
                if (appCompatEditText == null) {
                    kotlin.g.b.k.a("mIfscEdt");
                }
                a(String.valueOf(appCompatEditText.getText()));
            } else {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else {
            int i3 = R.id.ifsc_value_rl;
            if (valueOf != null && valueOf.intValue() == i3) {
                RelativeLayout relativeLayout = this.l;
                if (relativeLayout == null) {
                    kotlin.g.b.k.a("mIfscFilledRly");
                }
                relativeLayout.setVisibility(8);
                TextInputLayout textInputLayout2 = this.f54404f;
                if (textInputLayout2 == null) {
                    kotlin.g.b.k.a("mIfscTil");
                }
                textInputLayout2.setVisibility(0);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 106 && i3 == -1 && intent != null) {
            this.n = intent.getStringExtra("intent_extra_ifsc_code");
            this.o = intent.getStringExtra("intent_extra_bank_name");
            if (!TextUtils.isEmpty(this.n)) {
                this.r = true;
                a(this.n, this.o);
                a(true, "");
                TextInputLayout textInputLayout = this.f54402d;
                if (textInputLayout == null) {
                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                }
                textInputLayout.setError((CharSequence) null);
                TextInputLayout textInputLayout2 = this.f54404f;
                if (textInputLayout2 == null) {
                    kotlin.g.b.k.a("mIfscTil");
                }
                textInputLayout2.setError((CharSequence) null);
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    private void a(boolean z, String str) {
        kotlin.g.b.k.c(str, "message");
        this.r = z;
        if (z) {
            TextInputLayout textInputLayout = this.f54404f;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout.setVisibility(8);
            ImageView imageView = this.m;
            if (imageView == null) {
                kotlin.g.b.k.a("mIfscVerifiedImage");
            }
            imageView.setVisibility(0);
            RelativeLayout relativeLayout = this.l;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mIfscFilledRly");
            }
            relativeLayout.setVisibility(0);
            TextView textView = this.f54405g;
            if (textView == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView.setVisibility(8);
            AppCompatEditText appCompatEditText = this.f54400b;
            if (appCompatEditText == null) {
                kotlin.g.b.k.a("mAccountNameEdt");
            }
            appCompatEditText.requestFocus();
        } else if (!z) {
            TextView textView2 = this.f54405g;
            if (textView2 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
            TextView textView3 = this.f54405g;
            if (textView3 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView3.setText(getString(R.string.money_transfer_find_ifsc));
            TextView textView4 = this.f54405g;
            if (textView4 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView4.setVisibility(0);
            TextInputLayout textInputLayout2 = this.f54404f;
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout2.setError(str);
        }
    }

    private void a(String str, String str2) {
        this.n = str;
        this.o = str2;
        TextView textView = this.f54406h;
        if (textView == null) {
            kotlin.g.b.k.a("mIfscVerifiedValueTv");
        }
        textView.setText(str);
        TextView textView2 = this.f54407i;
        if (textView2 == null) {
            kotlin.g.b.k.a("mIfscBankVerifiedTv");
        }
        textView2.setText(str2);
        AppCompatEditText appCompatEditText = this.f54401c;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        appCompatEditText.setText(this.n);
    }

    /* access modifiers changed from: protected */
    public final boolean h() {
        AppCompatEditText appCompatEditText = this.f54400b;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mAccountNameEdt");
        }
        this.p = String.valueOf(appCompatEditText.getText());
        AppCompatEditText appCompatEditText2 = this.f54399a;
        if (appCompatEditText2 == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaEdt");
        }
        this.q = String.valueOf(appCompatEditText2.getText());
        if (this.t == C0975a.ACCOUNT_NUMBER) {
            if (!net.one97.paytm.moneytransfer.utils.m.b(this.q)) {
                TextInputLayout textInputLayout = this.f54402d;
                if (textInputLayout == null) {
                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                }
                textInputLayout.setError(getString(R.string.money_transfer_account_number_error));
                return false;
            } else if (TextUtils.isEmpty(this.n) || !this.r) {
                ImageView imageView = this.m;
                if (imageView == null) {
                    kotlin.g.b.k.a("mIfscVerifiedImage");
                }
                imageView.setVisibility(8);
                RelativeLayout relativeLayout = this.l;
                if (relativeLayout == null) {
                    kotlin.g.b.k.a("mIfscFilledRly");
                }
                relativeLayout.setVisibility(8);
                TextView textView = this.f54405g;
                if (textView == null) {
                    kotlin.g.b.k.a("mFindIfscTv");
                }
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                textView.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
                TextView textView2 = this.f54405g;
                if (textView2 == null) {
                    kotlin.g.b.k.a("mFindIfscTv");
                }
                textView2.setText(getString(R.string.money_transfer_verify));
                TextView textView3 = this.f54405g;
                if (textView3 == null) {
                    kotlin.g.b.k.a("mFindIfscTv");
                }
                textView3.setVisibility(0);
                TextInputLayout textInputLayout2 = this.f54404f;
                if (textInputLayout2 == null) {
                    kotlin.g.b.k.a("mIfscTil");
                }
                textInputLayout2.setVisibility(0);
                TextInputLayout textInputLayout3 = this.f54404f;
                if (textInputLayout3 == null) {
                    kotlin.g.b.k.a("mIfscTil");
                }
                textInputLayout3.setError(getString(R.string.money_transfer_ifsc_code_error));
                return false;
            } else {
                if (!TextUtils.isEmpty(this.p)) {
                    String str = this.p;
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    if (str == null) {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    } else if (p.b(str).toString().length() != 0) {
                        if ((p.a("PYTM0123456", this.n, true) || p.a("PYTM0000001", this.n, true)) && !TextUtils.isEmpty(this.q)) {
                            String str2 = this.q;
                            if (str2 == null) {
                                kotlin.g.b.k.a();
                            }
                            CharSequence charSequence = str2;
                            int length = charSequence.length() - 1;
                            int i2 = 0;
                            boolean z = false;
                            while (i2 <= length) {
                                boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                                if (z) {
                                    if (!z2) {
                                        break;
                                    }
                                    length--;
                                } else if (!z2) {
                                    z = true;
                                } else {
                                    i2++;
                                }
                            }
                            if (charSequence.subSequence(i2, length + 1).toString().length() < 12) {
                                TextInputLayout textInputLayout4 = this.f54402d;
                                if (textInputLayout4 == null) {
                                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                                }
                                textInputLayout4.setError(getString(R.string.money_transfer_paytm_ifsc_check));
                                return false;
                            }
                        }
                        if ((p.a("PYTM0123456", this.n, true) || p.a("PYTM0000001", this.n, true)) && !TextUtils.isEmpty(this.q)) {
                            String str3 = this.q;
                            if (str3 == null) {
                                kotlin.g.b.k.a();
                            }
                            CharSequence charSequence2 = str3;
                            int length2 = charSequence2.length() - 1;
                            int i3 = 0;
                            boolean z3 = false;
                            while (i3 <= length2) {
                                boolean z4 = charSequence2.charAt(!z3 ? i3 : length2) <= ' ';
                                if (z3) {
                                    if (!z4) {
                                        break;
                                    }
                                    length2--;
                                } else if (!z4) {
                                    z3 = true;
                                } else {
                                    i3++;
                                }
                            }
                            if (charSequence2.subSequence(i3, length2 + 1).toString().length() < 12) {
                                TextInputLayout textInputLayout5 = this.f54402d;
                                if (textInputLayout5 == null) {
                                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                                }
                                textInputLayout5.setError(getString(R.string.money_transfer_paytm_ifsc_check));
                                return false;
                            }
                        }
                    }
                }
                TextInputLayout textInputLayout6 = this.f54403e;
                if (textInputLayout6 == null) {
                    kotlin.g.b.k.a("mAccountNameTil");
                }
                textInputLayout6.setError(getString(R.string.money_transfer_account_name_error));
                return false;
            }
        } else if (this.t == C0975a.VPA) {
            AppCompatEditText appCompatEditText3 = this.f54399a;
            if (appCompatEditText3 == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaEdt");
            }
            if (TextUtils.isEmpty(String.valueOf(appCompatEditText3.getText()))) {
                TextInputLayout textInputLayout7 = this.f54402d;
                if (textInputLayout7 == null) {
                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                }
                textInputLayout7.setError(getString(R.string.upi_empty_vpa_error));
                return false;
            }
            AppCompatEditText appCompatEditText4 = this.f54399a;
            if (appCompatEditText4 == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaEdt");
            }
            if (String.valueOf(appCompatEditText4.getText()).length() > 255) {
                TextInputLayout textInputLayout8 = this.f54402d;
                if (textInputLayout8 == null) {
                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                }
                textInputLayout8.setError(getString(R.string.upi_vpa_length_breach));
                return false;
            }
            AppCompatEditText appCompatEditText5 = this.f54399a;
            if (appCompatEditText5 == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaEdt");
            }
            if (!new kotlin.m.l("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+").matches(String.valueOf(appCompatEditText5.getText()))) {
                TextInputLayout textInputLayout9 = this.f54402d;
                if (textInputLayout9 == null) {
                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                }
                textInputLayout9.setError(getString(R.string.upi_invalid_upi));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void b(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getMessage(), true) || p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            String name = a.class.getName();
            kotlin.g.b.k.a((Object) name, "AddBankAccountFragment::class.java.getName()");
            b2.a((Activity) activity, (Exception) upiCustomVolleyError, name);
            return;
        }
        com.paytm.utility.b.b((Context) getActivity(), "Error", upiCustomVolleyError.getAlertMessage());
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (com.paytm.utility.a.m(getActivity())) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            activity.getApplicationContext();
            net.one97.paytm.upi.g.a().b(str, (a.C1382a) new f(this));
            return;
        }
        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
    }

    public static final class f implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54413a;

        f(a aVar) {
            this.f54413a = aVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            kotlin.g.b.k.c(upiBaseDataModel, Payload.RESPONSE);
            a.a(this.f54413a, upiBaseDataModel);
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            kotlin.g.b.k.c(upiCustomVolleyError, "error");
            this.f54413a.b(new UpiCustomVolleyError((Throwable) upiCustomVolleyError));
        }
    }

    static final class g implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54414a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f54415b;

        g(a aVar, BottomSheetBehavior bottomSheetBehavior) {
            this.f54414a = aVar;
            this.f54415b = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f54415b.setState(4);
            UpiAppUtils.hideKeyboard(this.f54414a.getActivity());
        }
    }

    public static final class h extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f54417b;

        public final void onStateChanged(View view, int i2) {
            kotlin.g.b.k.c(view, "bottomSheet");
        }

        h(a aVar, com.google.android.material.bottomsheet.a aVar2) {
            this.f54416a = aVar;
            this.f54417b = aVar2;
        }

        public final void onSlide(View view, float f2) {
            kotlin.g.b.k.c(view, "bottomSheet");
            this.f54417b.cancel();
            UpiAppUtils.hideKeyboard(this.f54416a.getActivity());
        }
    }

    static final class i implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54418a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f54419b;

        i(a aVar, com.google.android.material.bottomsheet.a aVar2) {
            this.f54418a = aVar;
            this.f54419b = aVar2;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4) {
                return false;
            }
            kotlin.g.b.k.a((Object) keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (keyEvent.getAction() != 1) {
                return false;
            }
            this.f54419b.cancel();
            UpiAppUtils.hideKeyboard(this.f54418a.getActivity());
            return true;
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f54421b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f54422c;

        j(a aVar, EditText editText, com.google.android.material.bottomsheet.a aVar2) {
            this.f54420a = aVar;
            this.f54421b = editText;
            this.f54422c = aVar2;
        }

        public final void onClick(View view) {
            UpiAppUtils.hideKeyboard(this.f54420a.getActivity());
            this.f54421b.clearFocus();
            this.f54422c.cancel();
        }
    }

    static final class k implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54423a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f54424b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f54425c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f54426d;

        k(a aVar, EditText editText, TextInputLayout textInputLayout, com.google.android.material.bottomsheet.a aVar2) {
            this.f54423a = aVar;
            this.f54424b = editText;
            this.f54425c = textInputLayout;
            this.f54426d = aVar2;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            EditText editText = this.f54424b;
            kotlin.g.b.k.a((Object) editText, "accountNumberET");
            if (TextUtils.isEmpty(editText.getText())) {
                TextInputLayout textInputLayout = this.f54425c;
                kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setError(this.f54423a.getString(R.string.money_transfer_account_does_not_match));
                return false;
            }
            EditText editText2 = this.f54424b;
            kotlin.g.b.k.a((Object) editText2, "accountNumberET");
            if (!p.a(editText2.getText().toString(), this.f54423a.q, true)) {
                TextInputLayout textInputLayout2 = this.f54425c;
                kotlin.g.b.k.a((Object) textInputLayout2, "accountNumberTIL");
                textInputLayout2.setError(this.f54423a.getString(R.string.money_transfer_account_does_not_match));
                return false;
            }
            this.f54426d.cancel();
            this.f54423a.i();
            return false;
        }
    }

    public static final class l implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f54427a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        l(TextInputLayout textInputLayout) {
            this.f54427a = textInputLayout;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = this.f54427a;
            kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
            textInputLayout.setError((CharSequence) null);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54428a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f54429b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f54430c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f54431d;

        m(a aVar, EditText editText, TextInputLayout textInputLayout, com.google.android.material.bottomsheet.a aVar2) {
            this.f54428a = aVar;
            this.f54429b = editText;
            this.f54430c = textInputLayout;
            this.f54431d = aVar2;
        }

        public final void onClick(View view) {
            EditText editText = this.f54429b;
            kotlin.g.b.k.a((Object) editText, "accountNumberET");
            if (TextUtils.isEmpty(editText.getText())) {
                TextInputLayout textInputLayout = this.f54430c;
                kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setError(this.f54428a.getString(R.string.money_transfer_account_does_not_match));
                return;
            }
            EditText editText2 = this.f54429b;
            kotlin.g.b.k.a((Object) editText2, "accountNumberET");
            if (!p.a(editText2.getText().toString(), this.f54428a.q, true)) {
                TextInputLayout textInputLayout2 = this.f54430c;
                kotlin.g.b.k.a((Object) textInputLayout2, "accountNumberTIL");
                textInputLayout2.setError(this.f54428a.getString(R.string.money_transfer_account_does_not_match));
                return;
            }
            this.f54431d.cancel();
            this.f54428a.i();
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f54411a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f54412b;

        e(a aVar, EditText editText) {
            this.f54411a = aVar;
            this.f54412b = editText;
        }

        public final void run() {
            Window window;
            try {
                FragmentActivity activity = this.f54411a.getActivity();
                InputMethodManager inputMethodManager = (InputMethodManager) (activity != null ? activity.getSystemService("input_method") : null);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f54412b, 1);
                    FragmentActivity activity2 = this.f54411a.getActivity();
                    if (activity2 != null && (window = activity2.getWindow()) != null) {
                        window.setSoftInputMode(20);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(C0975a aVar) {
        this.t = aVar;
        if (this.t == C0975a.ACCOUNT_NUMBER) {
            AppCompatEditText appCompatEditText = this.f54400b;
            if (appCompatEditText == null) {
                kotlin.g.b.k.a("mAccountNameEdt");
            }
            appCompatEditText.setEnabled(true);
            RelativeLayout relativeLayout = this.k;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mIfscParentLayout");
            }
            relativeLayout.setVisibility(0);
            TextInputLayout textInputLayout = this.f54403e;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mAccountNameTil");
            }
            textInputLayout.setVisibility(0);
            TextView textView = this.j;
            if (textView == null) {
                kotlin.g.b.k.a("mProceedBtn");
            }
            textView.setVisibility(0);
        } else if (this.t == C0975a.VPA) {
            this.n = "";
            AppCompatEditText appCompatEditText2 = this.f54400b;
            if (appCompatEditText2 == null) {
                kotlin.g.b.k.a("mAccountNameEdt");
            }
            appCompatEditText2.setText("");
            AppCompatEditText appCompatEditText3 = this.f54400b;
            if (appCompatEditText3 == null) {
                kotlin.g.b.k.a("mAccountNameEdt");
            }
            appCompatEditText3.setEnabled(false);
            RelativeLayout relativeLayout2 = this.k;
            if (relativeLayout2 == null) {
                kotlin.g.b.k.a("mIfscParentLayout");
            }
            relativeLayout2.setVisibility(8);
            TextInputLayout textInputLayout2 = this.f54403e;
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a("mAccountNameTil");
            }
            textInputLayout2.setVisibility(8);
            TextView textView2 = this.j;
            if (textView2 == null) {
                kotlin.g.b.k.a("mProceedBtn");
            }
            textView2.setVisibility(0);
        } else {
            RelativeLayout relativeLayout3 = this.k;
            if (relativeLayout3 == null) {
                kotlin.g.b.k.a("mIfscParentLayout");
            }
            relativeLayout3.setVisibility(8);
            TextInputLayout textInputLayout3 = this.f54403e;
            if (textInputLayout3 == null) {
                kotlin.g.b.k.a("mAccountNameTil");
            }
            textInputLayout3.setVisibility(8);
            TextView textView3 = this.j;
            if (textView3 == null) {
                kotlin.g.b.k.a("mProceedBtn");
            }
            textView3.setVisibility(8);
            AppCompatEditText appCompatEditText4 = this.f54400b;
            if (appCompatEditText4 == null) {
                kotlin.g.b.k.a("mAccountNameEdt");
            }
            appCompatEditText4.setText("");
            ImageView imageView = this.m;
            if (imageView == null) {
                kotlin.g.b.k.a("mIfscVerifiedImage");
            }
            imageView.setVisibility(8);
            RelativeLayout relativeLayout4 = this.l;
            if (relativeLayout4 == null) {
                kotlin.g.b.k.a("mIfscFilledRly");
            }
            relativeLayout4.setVisibility(8);
            TextInputLayout textInputLayout4 = this.f54404f;
            if (textInputLayout4 == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout4.setVisibility(0);
            AppCompatEditText appCompatEditText5 = this.f54401c;
            if (appCompatEditText5 == null) {
                kotlin.g.b.k.a("mIfscEdt");
            }
            appCompatEditText5.setText("");
            this.o = "";
            TextView textView4 = this.f54405g;
            if (textView4 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            textView4.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
            TextView textView5 = this.f54405g;
            if (textView5 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView5.setText(getString(R.string.money_transfer_find_ifsc));
            TextView textView6 = this.f54405g;
            if (textView6 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView6.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z, String str) {
        kotlin.g.b.k.c(str, "message");
        this.s = z;
        if (z) {
            TextInputLayout textInputLayout = this.f54402d;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaTil");
            }
            textInputLayout.setError((CharSequence) null);
            return;
        }
        TextInputLayout textInputLayout2 = this.f54403e;
        if (textInputLayout2 == null) {
            kotlin.g.b.k.a("mAccountNameTil");
        }
        textInputLayout2.setVisibility(8);
        String string = getString(R.string.upi_unable_to_verify_vpa);
        kotlin.g.b.k.a((Object) string, "getString(R.string.upi_unable_to_verify_vpa)");
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, str, true)) {
            d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) activity, "activity!!");
            new NetworkCustomError();
            b2.a((Activity) activity, (String) null, true);
        }
        if (p.a("XH", str, true) || p.a("J02", str, true) || p.a("U17", str, true) || p.a("0037", str, true)) {
            string = getString(R.string.upi_address_incorrect);
            kotlin.g.b.k.a((Object) string, "getString(R.string.upi_address_incorrect)");
        }
        if (p.a("INT-1470", str, true)) {
            string = getString(R.string.mt_vpa_verify_no_bank_linked_err);
            kotlin.g.b.k.a((Object) string, "getString(R.string.mt_vp…erify_no_bank_linked_err)");
        }
        if (!p.a(str, "No Error", true)) {
            TextInputLayout textInputLayout3 = this.f54402d;
            if (textInputLayout3 == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaTil");
            }
            textInputLayout3.setError(string);
        }
        if (p.a("1006", str, true)) {
            Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
            intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public final void d(String str) {
        kotlin.g.b.k.c(str, "name");
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            TextInputLayout textInputLayout = this.f54403e;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mAccountNameTil");
            }
            textInputLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mIfscParentLayout");
        }
        relativeLayout.setVisibility(8);
        TextInputLayout textInputLayout2 = this.f54403e;
        if (textInputLayout2 == null) {
            kotlin.g.b.k.a("mAccountNameTil");
        }
        textInputLayout2.setVisibility(0);
        AppCompatEditText appCompatEditText = this.f54400b;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mAccountNameEdt");
        }
        appCompatEditText.setText(charSequence);
        this.p = str;
    }

    public static final /* synthetic */ void a(a aVar, UpiBaseDataModel upiBaseDataModel) {
        String str;
        String str2;
        if (upiBaseDataModel != null && (upiBaseDataModel instanceof CJRBankDetails)) {
            CJRBankDetails cJRBankDetails = (CJRBankDetails) upiBaseDataModel;
            if (p.a(cJRBankDetails.getStatusCode(), "SUCCESS", true)) {
                aVar.a(true, "");
                CJRBankDetailsResponse response = cJRBankDetails.getResponse();
                if (response == null || (str = response.getIfscCode()) == null) {
                    str = "";
                }
                CJRBankDetailsResponse response2 = cJRBankDetails.getResponse();
                if (response2 == null || (str2 = response2.getBankName()) == null) {
                    str2 = "";
                }
                aVar.a(str, str2);
                return;
            }
            String statusMessage = cJRBankDetails.getStatusMessage();
            kotlin.g.b.k.a((Object) statusMessage, "response.statusMessage");
            aVar.a(false, statusMessage);
        }
    }
}
