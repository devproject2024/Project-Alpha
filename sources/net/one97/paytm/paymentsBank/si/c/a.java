package net.one97.paytm.paymentsBank.si.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CJRBankDetails;
import net.one97.paytm.bankCommon.model.CJRBankDetailsResponse;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiUtils;

public class a extends net.one97.paytm.i.h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected TextInputEditText f18831a;

    /* renamed from: b  reason: collision with root package name */
    protected TextInputEditText f18832b;

    /* renamed from: c  reason: collision with root package name */
    protected TextInputEditText f18833c;

    /* renamed from: d  reason: collision with root package name */
    protected TextInputLayout f18834d;

    /* renamed from: e  reason: collision with root package name */
    protected TextInputLayout f18835e;

    /* renamed from: f  reason: collision with root package name */
    protected TextInputLayout f18836f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f18837g;

    /* renamed from: h  reason: collision with root package name */
    protected TextView f18838h;

    /* renamed from: i  reason: collision with root package name */
    protected TextView f18839i;
    protected RelativeLayout j;
    protected RelativeLayout k;
    protected ImageView l;
    String m;
    String n;
    String o;
    String p;
    boolean q;
    C0324a r;
    public net.one97.paytm.bankCommon.f.d s;
    private HashMap t;

    /* renamed from: net.one97.paytm.paymentsBank.si.c.a$a  reason: collision with other inner class name */
    public enum C0324a {
        ACCOUNT_NUMBER,
        AADHAR,
        VPA
    }

    public void h() {
        HashMap hashMap = this.t;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        h();
    }

    static final class f<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18845a;

        f(a aVar) {
            this.f18845a = aVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            a.a(this.f18845a, (IJRPaytmDataModel) obj);
        }
    }

    /* access modifiers changed from: protected */
    public final TextInputEditText a() {
        TextInputEditText textInputEditText = this.f18833c;
        if (textInputEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        return textInputEditText;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout b() {
        TextInputLayout textInputLayout = this.f18834d;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout c() {
        TextInputLayout textInputLayout = this.f18835e;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mAccountNameTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout d() {
        TextInputLayout textInputLayout = this.f18836f;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mIfscTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextView e() {
        TextView textView = this.f18837g;
        if (textView == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final ImageView f() {
        ImageView imageView = this.l;
        if (imageView == null) {
            kotlin.g.b.k.a("mIfscVerifiedImage");
        }
        return imageView;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof net.one97.paytm.bankCommon.f.d) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.s = (net.one97.paytm.bankCommon.f.d) activity;
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.bankCommon.listeners.FragmentActionListener");
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        kotlin.g.b.k.c(view, "view");
        View findViewById = view.findViewById(R.id.account_number_et);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.account_number_et)");
        this.f18831a = (TextInputEditText) findViewById;
        View findViewById2 = view.findViewById(R.id.account_name_et);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.account_name_et)");
        this.f18832b = (TextInputEditText) findViewById2;
        View findViewById3 = view.findViewById(R.id.edit_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.edit_p2b_ifsc_code)");
        this.f18833c = (TextInputEditText) findViewById3;
        View findViewById4 = view.findViewById(R.id.account_til);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.account_til)");
        this.f18834d = (TextInputLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.account_name_til);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.account_name_til)");
        this.f18835e = (TextInputLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.float_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.float_p2b_ifsc_code)");
        this.f18836f = (TextInputLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.ifsc_verified_image);
        kotlin.g.b.k.a((Object) findViewById7, "view.findViewById(R.id.ifsc_verified_image)");
        this.l = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.lyt_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById8, "view.findViewById(R.id.lyt_p2b_ifsc_code)");
        this.j = (RelativeLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.ifsc_value_rl);
        kotlin.g.b.k.a((Object) findViewById9, "view.findViewById(R.id.ifsc_value_rl)");
        this.k = (RelativeLayout) findViewById9;
        View findViewById10 = view.findViewById(R.id.ifsc_verified_value);
        kotlin.g.b.k.a((Object) findViewById10, "view.findViewById(R.id.ifsc_verified_value)");
        this.f18838h = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.bank_verified_value);
        kotlin.g.b.k.a((Object) findViewById11, "view.findViewById(R.id.bank_verified_value)");
        this.f18839i = (TextView) findViewById11;
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mIfscFilledRly");
        }
        View.OnClickListener onClickListener = this;
        relativeLayout.setOnClickListener(onClickListener);
        View findViewById12 = view.findViewById(R.id.txt_p2b_ifsc_code_state);
        kotlin.g.b.k.a((Object) findViewById12, "view.findViewById(R.id.txt_p2b_ifsc_code_state)");
        this.f18837g = (TextView) findViewById12;
        TextView textView = this.f18837g;
        if (textView == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        textView.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
        TextView textView2 = this.f18837g;
        if (textView2 == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        textView2.setOnClickListener(onClickListener);
        TextInputEditText textInputEditText = this.f18833c;
        if (textInputEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        textInputEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(11)});
        TextInputEditText textInputEditText2 = this.f18831a;
        if (textInputEditText2 == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaEdt");
        }
        textInputEditText2.addTextChangedListener(new b(this));
        TextInputEditText textInputEditText3 = this.f18832b;
        if (textInputEditText3 == null) {
            kotlin.g.b.k.a("mAccountNameEdt");
        }
        textInputEditText3.addTextChangedListener(new c(this));
        TextInputEditText textInputEditText4 = this.f18833c;
        if (textInputEditText4 == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        textInputEditText4.addTextChangedListener(new d(this));
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18840a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        b(a aVar) {
            this.f18840a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f18840a.r = C0324a.ACCOUNT_NUMBER;
            this.f18840a.b().setError((CharSequence) null);
            this.f18840a.c().setError((CharSequence) null);
            this.f18840a.d().setError((CharSequence) null);
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18841a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(a aVar) {
            this.f18841a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f18841a.b().setError((CharSequence) null);
            this.f18841a.c().setError((CharSequence) null);
            this.f18841a.d().setError((CharSequence) null);
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18842a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        d(a aVar) {
            this.f18842a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence != null && charSequence.length() == 0) {
                TextView e2 = this.f18842a.e();
                FragmentActivity activity = this.f18842a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                e2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
                a aVar = this.f18842a;
                aVar.q = false;
                aVar.f().setVisibility(8);
                this.f18842a.e().setText(this.f18842a.getString(R.string.find_ifsc));
                this.f18842a.e().setVisibility(0);
                this.f18842a.d().setError((CharSequence) null);
            } else if (charSequence == null || charSequence.length() != 11) {
                a aVar2 = this.f18842a;
                aVar2.q = false;
                aVar2.f().setVisibility(8);
                TextView e3 = this.f18842a.e();
                FragmentActivity activity2 = this.f18842a.getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                e3.setTextColor(androidx.core.content.b.c(activity2, R.color.color_blue_ifsc));
                this.f18842a.e().setText(this.f18842a.getString(R.string.verify));
                this.f18842a.e().setVisibility(0);
                this.f18842a.d().setError((CharSequence) null);
            } else if (!this.f18842a.q) {
                a aVar3 = this.f18842a;
                aVar3.a(String.valueOf(aVar3.a().getText()));
            }
        }
    }

    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.txt_p2b_ifsc_code_state;
        if (valueOf != null && valueOf.intValue() == i2) {
            TextInputLayout textInputLayout = this.f18836f;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout.setError((CharSequence) null);
            net.one97.paytm.bankCommon.mapping.a.c((Activity) getActivity());
            TextView textView = this.f18837g;
            if (textView == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            if (!p.a(textView.getText().toString(), getResources().getString(R.string.verify), true)) {
                TextView textView2 = this.f18837g;
                if (textView2 == null) {
                    kotlin.g.b.k.a("mFindIfscTv");
                }
                if (p.a(textView2.getText().toString(), getResources().getString(R.string.find_ifsc), true)) {
                    net.one97.paytm.paymentsBank.h.a a2 = o.a();
                    kotlin.g.b.k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
                    Intent intent = new Intent(getActivity(), a2.getAJRConfirmIFSCActivityClass());
                    intent.putExtra("show_ifsc_new_design", true);
                    startActivityForResult(intent, 106);
                }
            } else if (com.paytm.utility.b.c((Context) getActivity())) {
                TextInputEditText textInputEditText = this.f18833c;
                if (textInputEditText == null) {
                    kotlin.g.b.k.a("mIfscEdt");
                }
                a(String.valueOf(textInputEditText.getText()));
            } else {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else {
            int i3 = R.id.ifsc_value_rl;
            if (valueOf != null && valueOf.intValue() == i3) {
                RelativeLayout relativeLayout = this.k;
                if (relativeLayout == null) {
                    kotlin.g.b.k.a("mIfscFilledRly");
                }
                relativeLayout.setVisibility(8);
                TextInputLayout textInputLayout2 = this.f18836f;
                if (textInputLayout2 == null) {
                    kotlin.g.b.k.a("mIfscTil");
                }
                textInputLayout2.setVisibility(0);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 106 && i3 == -1 && intent != null) {
            this.m = intent.getStringExtra("intent_extra_ifsc_code");
            this.n = intent.getStringExtra("intent_extra_bank_name");
            if (!TextUtils.isEmpty(this.m)) {
                this.q = true;
                a(this.m, this.n);
                a(true, "");
                TextInputLayout textInputLayout = this.f18834d;
                if (textInputLayout == null) {
                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                }
                textInputLayout.setError((CharSequence) null);
                TextInputLayout textInputLayout2 = this.f18836f;
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
        this.q = z;
        if (z) {
            TextInputLayout textInputLayout = this.f18836f;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout.setVisibility(8);
            ImageView imageView = this.l;
            if (imageView == null) {
                kotlin.g.b.k.a("mIfscVerifiedImage");
            }
            imageView.setVisibility(0);
            RelativeLayout relativeLayout = this.k;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mIfscFilledRly");
            }
            relativeLayout.setVisibility(0);
            TextView textView = this.f18837g;
            if (textView == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView.setVisibility(8);
            TextInputEditText textInputEditText = this.f18832b;
            if (textInputEditText == null) {
                kotlin.g.b.k.a("mAccountNameEdt");
            }
            textInputEditText.requestFocus();
        } else if (!z) {
            TextView textView2 = this.f18837g;
            if (textView2 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
            TextView textView3 = this.f18837g;
            if (textView3 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView3.setText(getString(R.string.find_ifsc));
            TextView textView4 = this.f18837g;
            if (textView4 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView4.setVisibility(0);
            TextInputLayout textInputLayout2 = this.f18836f;
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout2.setError(str);
        }
    }

    private void a(String str, String str2) {
        this.m = str;
        this.n = str2;
        TextView textView = this.f18838h;
        if (textView == null) {
            kotlin.g.b.k.a("mIfscVerifiedValueTv");
        }
        textView.setText(str);
        TextView textView2 = this.f18839i;
        if (textView2 == null) {
            kotlin.g.b.k.a("mIfscBankVerifiedTv");
        }
        textView2.setText(str2);
        TextInputEditText textInputEditText = this.f18833c;
        if (textInputEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        textInputEditText.setText(this.m);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        TextInputEditText textInputEditText = this.f18832b;
        if (textInputEditText == null) {
            kotlin.g.b.k.a("mAccountNameEdt");
        }
        this.o = String.valueOf(textInputEditText.getText());
        TextInputEditText textInputEditText2 = this.f18831a;
        if (textInputEditText2 == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaEdt");
        }
        this.p = String.valueOf(textInputEditText2.getText());
        if (this.r != C0324a.ACCOUNT_NUMBER) {
            C0324a aVar = C0324a.VPA;
        } else if (!net.one97.paytm.bankCommon.mapping.e.ab(this.p)) {
            TextInputLayout textInputLayout = this.f18834d;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mAccountNoOrVpaTil");
            }
            textInputLayout.setError(getString(R.string.wallet_account_number_error));
            return false;
        } else if (TextUtils.isEmpty(this.m) || !this.q) {
            ImageView imageView = this.l;
            if (imageView == null) {
                kotlin.g.b.k.a("mIfscVerifiedImage");
            }
            imageView.setVisibility(8);
            RelativeLayout relativeLayout = this.k;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mIfscFilledRly");
            }
            relativeLayout.setVisibility(8);
            TextView textView = this.f18837g;
            if (textView == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            textView.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
            TextView textView2 = this.f18837g;
            if (textView2 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView2.setText(getString(R.string.verify));
            TextView textView3 = this.f18837g;
            if (textView3 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView3.setVisibility(0);
            TextInputLayout textInputLayout2 = this.f18836f;
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout2.setVisibility(0);
            TextInputLayout textInputLayout3 = this.f18836f;
            if (textInputLayout3 == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout3.setError(getString(R.string.wallet_ifsc_code_error));
            return false;
        } else {
            if (!TextUtils.isEmpty(this.o)) {
                String str = this.o;
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                if (str == null) {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                } else if (p.b(str).toString().length() != 0) {
                    if (p.a("PYTM0123456", this.m, true) && !TextUtils.isEmpty(this.p)) {
                        String str2 = this.p;
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
                            TextInputLayout textInputLayout4 = this.f18834d;
                            if (textInputLayout4 == null) {
                                kotlin.g.b.k.a("mAccountNoOrVpaTil");
                            }
                            textInputLayout4.setError(getString(R.string.money_transfer_paytm_ifsc_check));
                            return false;
                        }
                    }
                }
            }
            TextInputLayout textInputLayout5 = this.f18835e;
            if (textInputLayout5 == null) {
                kotlin.g.b.k.a("mAccountNameTil");
            }
            textInputLayout5.setError(getString(R.string.wallet_account_name_error));
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (com.paytm.utility.b.c((Context) getActivity())) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                net.one97.paytm.paymentsBank.b.a.a((Activity) activity, str, (g.b<IJRPaytmDataModel>) new f(this), (g.a) new g(this), a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
    }

    static final class g implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18846a;

        g(a aVar) {
            this.f18846a = aVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            a aVar = this.f18846a;
            if (networkCustomError == null) {
                throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
            } else if (networkCustomError == null) {
            } else {
                if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, networkCustomError.getMessage(), true)) {
                    net.one97.paytm.bankCommon.utils.f.a((Activity) aVar.getActivity(), (Exception) networkCustomError, a.class.getName());
                } else {
                    com.paytm.utility.b.b((Context) aVar.getActivity(), "Error", networkCustomError.getAlertMessage());
                }
            }
        }
    }

    static final class h implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18847a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f18848b;

        h(a aVar, BottomSheetBehavior bottomSheetBehavior) {
            this.f18847a = aVar;
            this.f18848b = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f18848b.setState(4);
            net.one97.paytm.bankCommon.mapping.a.c((Activity) this.f18847a.getActivity());
        }
    }

    public static final class i extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18849a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f18850b;

        public final void onStateChanged(View view, int i2) {
            kotlin.g.b.k.c(view, "bottomSheet");
        }

        i(a aVar, com.google.android.material.bottomsheet.a aVar2) {
            this.f18849a = aVar;
            this.f18850b = aVar2;
        }

        public final void onSlide(View view, float f2) {
            kotlin.g.b.k.c(view, "bottomSheet");
            this.f18850b.cancel();
            net.one97.paytm.bankCommon.mapping.a.c((Activity) this.f18849a.getActivity());
        }
    }

    static final class j implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18851a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f18852b;

        j(a aVar, com.google.android.material.bottomsheet.a aVar2) {
            this.f18851a = aVar;
            this.f18852b = aVar2;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4) {
                return false;
            }
            kotlin.g.b.k.a((Object) keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (keyEvent.getAction() != 1) {
                return false;
            }
            this.f18852b.cancel();
            net.one97.paytm.bankCommon.mapping.a.c((Activity) this.f18851a.getActivity());
            return true;
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18853a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f18854b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f18855c;

        k(a aVar, EditText editText, com.google.android.material.bottomsheet.a aVar2) {
            this.f18853a = aVar;
            this.f18854b = editText;
            this.f18855c = aVar2;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.a.c((Activity) this.f18853a.getActivity());
            this.f18854b.clearFocus();
            this.f18855c.cancel();
        }
    }

    static final class l implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18856a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f18857b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f18858c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f18859d;

        l(a aVar, EditText editText, TextInputLayout textInputLayout, com.google.android.material.bottomsheet.a aVar2) {
            this.f18856a = aVar;
            this.f18857b = editText;
            this.f18858c = textInputLayout;
            this.f18859d = aVar2;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            EditText editText = this.f18857b;
            kotlin.g.b.k.a((Object) editText, "accountNumberET");
            if (TextUtils.isEmpty(editText.getText())) {
                TextInputLayout textInputLayout = this.f18858c;
                kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setError(this.f18856a.getString(R.string.money_transfer_account_does_not_match));
                return false;
            }
            EditText editText2 = this.f18857b;
            kotlin.g.b.k.a((Object) editText2, "accountNumberET");
            if (!p.a(editText2.getText().toString(), this.f18856a.p, true)) {
                TextInputLayout textInputLayout2 = this.f18858c;
                kotlin.g.b.k.a((Object) textInputLayout2, "accountNumberTIL");
                textInputLayout2.setError(this.f18856a.getString(R.string.money_transfer_account_does_not_match));
                return false;
            }
            this.f18859d.cancel();
            if (this.f18856a.s == null) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ifsc", this.f18856a.m);
            hashMap.put("holdername", this.f18856a.o);
            hashMap.put("bankname", this.f18856a.n);
            hashMap.put("acc_no", this.f18856a.p);
            net.one97.paytm.bankCommon.f.d dVar = this.f18856a.s;
            if (dVar == null) {
                return false;
            }
            dVar.onFragmentAction(103, hashMap);
            return false;
        }
    }

    public static final class m implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f18860a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        m(TextInputLayout textInputLayout) {
            this.f18860a = textInputLayout;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = this.f18860a;
            kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
            textInputLayout.setError((CharSequence) null);
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18861a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f18862b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f18863c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f18864d;

        n(a aVar, EditText editText, TextInputLayout textInputLayout, com.google.android.material.bottomsheet.a aVar2) {
            this.f18861a = aVar;
            this.f18862b = editText;
            this.f18863c = textInputLayout;
            this.f18864d = aVar2;
        }

        public final void onClick(View view) {
            EditText editText = this.f18862b;
            kotlin.g.b.k.a((Object) editText, "accountNumberET");
            if (TextUtils.isEmpty(editText.getText())) {
                TextInputLayout textInputLayout = this.f18863c;
                kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setError(this.f18861a.getString(R.string.money_transfer_account_does_not_match));
                return;
            }
            EditText editText2 = this.f18862b;
            kotlin.g.b.k.a((Object) editText2, "accountNumberET");
            if (!p.a(editText2.getText().toString(), this.f18861a.p, true)) {
                TextInputLayout textInputLayout2 = this.f18863c;
                kotlin.g.b.k.a((Object) textInputLayout2, "accountNumberTIL");
                textInputLayout2.setError(this.f18861a.getString(R.string.money_transfer_account_does_not_match));
                return;
            }
            if (this.f18861a.s != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("ifsc", this.f18861a.m);
                hashMap.put("holdername", this.f18861a.o);
                hashMap.put("bankname", this.f18861a.n);
                hashMap.put("acc_no", this.f18861a.p);
                net.one97.paytm.bankCommon.f.d dVar = this.f18861a.s;
                if (dVar != null) {
                    dVar.onFragmentAction(103, hashMap);
                }
            }
            this.f18864d.cancel();
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f18843a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f18844b;

        e(a aVar, EditText editText) {
            this.f18843a = aVar;
            this.f18844b = editText;
        }

        public final void run() {
            Window window;
            try {
                FragmentActivity activity = this.f18843a.getActivity();
                InputMethodManager inputMethodManager = (InputMethodManager) (activity != null ? activity.getSystemService("input_method") : null);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f18844b, 1);
                    FragmentActivity activity2 = this.f18843a.getActivity();
                    if (activity2 != null && (window = activity2.getWindow()) != null) {
                        window.setSoftInputMode(20);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) getActivity());
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public static final /* synthetic */ void a(a aVar, IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRBankDetails)) {
            CJRBankDetails cJRBankDetails = (CJRBankDetails) iJRPaytmDataModel;
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
