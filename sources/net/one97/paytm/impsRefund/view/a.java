package net.one97.paytm.impsRefund.view;

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
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.m.p;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.common.entity.wallet.CJRBankDetailsResponse;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.r;

public class a extends net.one97.paytm.i.h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected AppCompatEditText f50616a;

    /* renamed from: b  reason: collision with root package name */
    protected AppCompatEditText f50617b;

    /* renamed from: c  reason: collision with root package name */
    protected AppCompatEditText f50618c;

    /* renamed from: d  reason: collision with root package name */
    protected TextInputLayout f50619d;

    /* renamed from: e  reason: collision with root package name */
    protected TextInputLayout f50620e;

    /* renamed from: f  reason: collision with root package name */
    protected TextInputLayout f50621f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f50622g;

    /* renamed from: h  reason: collision with root package name */
    protected TextView f50623h;

    /* renamed from: i  reason: collision with root package name */
    protected TextView f50624i;
    protected RelativeLayout j;
    protected RelativeLayout k;
    protected ImageView l;
    String m;
    String n;
    String o;
    String p;
    boolean q;
    C0919a r = C0919a.ACCOUNT_NUMBER;
    private HashMap s;

    /* renamed from: net.one97.paytm.impsRefund.view.a$a  reason: collision with other inner class name */
    public enum C0919a {
        ACCOUNT_NUMBER,
        AADHAR,
        VPA
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    public void j() {
        HashMap hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        j();
    }

    /* access modifiers changed from: protected */
    public final AppCompatEditText b() {
        AppCompatEditText appCompatEditText = this.f50618c;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        return appCompatEditText;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout c() {
        TextInputLayout textInputLayout = this.f50619d;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout d() {
        TextInputLayout textInputLayout = this.f50620e;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mAccountNameTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextInputLayout e() {
        TextInputLayout textInputLayout = this.f50621f;
        if (textInputLayout == null) {
            kotlin.g.b.k.a("mIfscTil");
        }
        return textInputLayout;
    }

    /* access modifiers changed from: protected */
    public final TextView f() {
        TextView textView = this.f50622g;
        if (textView == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public final ImageView g() {
        ImageView imageView = this.l;
        if (imageView == null) {
            kotlin.g.b.k.a("mIfscVerifiedImage");
        }
        return imageView;
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        kotlin.g.b.k.c(view, "view");
        View findViewById = view.findViewById(R.id.account_number_et);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.account_number_et)");
        this.f50616a = (AppCompatEditText) findViewById;
        View findViewById2 = view.findViewById(R.id.account_name_et);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.account_name_et)");
        this.f50617b = (AppCompatEditText) findViewById2;
        View findViewById3 = view.findViewById(R.id.edit_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.edit_p2b_ifsc_code)");
        this.f50618c = (AppCompatEditText) findViewById3;
        View findViewById4 = view.findViewById(R.id.account_til);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.account_til)");
        this.f50619d = (TextInputLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.account_name_til);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.account_name_til)");
        this.f50620e = (TextInputLayout) findViewById5;
        View findViewById6 = view.findViewById(R.id.float_p2b_ifsc_code);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.float_p2b_ifsc_code)");
        this.f50621f = (TextInputLayout) findViewById6;
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
        this.f50623h = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.bank_verified_value);
        kotlin.g.b.k.a((Object) findViewById11, "view.findViewById(R.id.bank_verified_value)");
        this.f50624i = (TextView) findViewById11;
        RelativeLayout relativeLayout = this.k;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mIfscFilledRly");
        }
        View.OnClickListener onClickListener = this;
        relativeLayout.setOnClickListener(onClickListener);
        View findViewById12 = view.findViewById(R.id.txt_p2b_ifsc_code_state);
        kotlin.g.b.k.a((Object) findViewById12, "view.findViewById(R.id.txt_p2b_ifsc_code_state)");
        this.f50622g = (TextView) findViewById12;
        TextView textView = this.f50622g;
        if (textView == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        textView.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
        TextView textView2 = this.f50622g;
        if (textView2 == null) {
            kotlin.g.b.k.a("mFindIfscTv");
        }
        textView2.setOnClickListener(onClickListener);
        AppCompatEditText appCompatEditText = this.f50618c;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        appCompatEditText.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(11)});
        AppCompatEditText appCompatEditText2 = this.f50616a;
        if (appCompatEditText2 == null) {
            kotlin.g.b.k.a("mAccountNoOrVpaEdt");
        }
        appCompatEditText2.addTextChangedListener(new b(this));
        AppCompatEditText appCompatEditText3 = this.f50617b;
        if (appCompatEditText3 == null) {
            kotlin.g.b.k.a("mAccountNameEdt");
        }
        appCompatEditText3.addTextChangedListener(new c(this));
        AppCompatEditText appCompatEditText4 = this.f50618c;
        if (appCompatEditText4 == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        appCompatEditText4.addTextChangedListener(new d(this));
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50625a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        b(a aVar) {
            this.f50625a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            a aVar = this.f50625a;
            C0919a aVar2 = C0919a.ACCOUNT_NUMBER;
            kotlin.g.b.k.c(aVar2, "<set-?>");
            aVar.r = aVar2;
            this.f50625a.c().setError((CharSequence) null);
            this.f50625a.d().setError((CharSequence) null);
            this.f50625a.e().setError((CharSequence) null);
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50626a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        c(a aVar) {
            this.f50626a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f50626a.c().setError((CharSequence) null);
            this.f50626a.d().setError((CharSequence) null);
            this.f50626a.e().setError((CharSequence) null);
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50627a;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        d(a aVar) {
            this.f50627a = aVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence != null && charSequence.length() == 0) {
                TextView f2 = this.f50627a.f();
                FragmentActivity activity = this.f50627a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                f2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
                a aVar = this.f50627a;
                aVar.q = false;
                aVar.g().setVisibility(8);
                this.f50627a.f().setText(this.f50627a.getString(R.string.find_ifsc));
                this.f50627a.f().setVisibility(0);
                this.f50627a.e().setError((CharSequence) null);
            } else if (charSequence == null || charSequence.length() != 11) {
                a aVar2 = this.f50627a;
                aVar2.q = false;
                aVar2.g().setVisibility(8);
                TextView f3 = this.f50627a.f();
                FragmentActivity activity2 = this.f50627a.getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                f3.setTextColor(androidx.core.content.b.c(activity2, R.color.color_blue_ifsc));
                this.f50627a.f().setText(this.f50627a.getString(R.string.verify));
                this.f50627a.f().setVisibility(0);
                this.f50627a.e().setError((CharSequence) null);
            } else if (!this.f50627a.q) {
                a aVar3 = this.f50627a;
                aVar3.a(String.valueOf(aVar3.b().getText()));
            }
        }
    }

    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.txt_p2b_ifsc_code_state) {
            TextInputLayout textInputLayout = this.f50621f;
            if (textInputLayout == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout.setError((CharSequence) null);
            com.paytm.utility.b.c((Activity) getActivity());
            TextView textView = this.f50622g;
            if (textView == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            if (!p.a(textView.getText().toString(), getResources().getString(R.string.verify), true)) {
                TextView textView2 = this.f50622g;
                if (textView2 == null) {
                    kotlin.g.b.k.a("mFindIfscTv");
                }
                if (p.a(textView2.getText().toString(), getResources().getString(R.string.find_ifsc), true)) {
                    Intent r2 = net.one97.paytm.common.b.d.a().r(getActivity());
                    r2.putExtra("show_ifsc_new_design", true);
                    startActivityForResult(r2, 106);
                }
            } else if (com.paytm.utility.a.m(getActivity())) {
                AppCompatEditText appCompatEditText = this.f50618c;
                if (appCompatEditText == null) {
                    kotlin.g.b.k.a("mIfscEdt");
                }
                a(String.valueOf(appCompatEditText.getText()));
            } else {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.ifsc_value_rl) {
            RelativeLayout relativeLayout = this.k;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mIfscFilledRly");
            }
            relativeLayout.setVisibility(8);
            TextInputLayout textInputLayout2 = this.f50621f;
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout2.setVisibility(0);
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
                TextInputLayout textInputLayout = this.f50619d;
                if (textInputLayout == null) {
                    kotlin.g.b.k.a("mAccountNoOrVpaTil");
                }
                textInputLayout.setError((CharSequence) null);
                TextInputLayout textInputLayout2 = this.f50621f;
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
            TextInputLayout textInputLayout = this.f50621f;
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
            TextView textView = this.f50622g;
            if (textView == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView.setVisibility(8);
            AppCompatEditText appCompatEditText = this.f50617b;
            if (appCompatEditText == null) {
                kotlin.g.b.k.a("mAccountNameEdt");
            }
            appCompatEditText.requestFocus();
        } else if (!z) {
            TextView textView2 = this.f50622g;
            if (textView2 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(activity, R.color.color_blue_ifsc));
            TextView textView3 = this.f50622g;
            if (textView3 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView3.setText(getString(R.string.find_ifsc));
            TextView textView4 = this.f50622g;
            if (textView4 == null) {
                kotlin.g.b.k.a("mFindIfscTv");
            }
            textView4.setVisibility(0);
            TextInputLayout textInputLayout2 = this.f50621f;
            if (textInputLayout2 == null) {
                kotlin.g.b.k.a("mIfscTil");
            }
            textInputLayout2.setError(str);
        }
    }

    private void a(String str, String str2) {
        this.m = str;
        this.n = str2;
        TextView textView = this.f50623h;
        if (textView == null) {
            kotlin.g.b.k.a("mIfscVerifiedValueTv");
        }
        textView.setText(str);
        TextView textView2 = this.f50624i;
        if (textView2 == null) {
            kotlin.g.b.k.a("mIfscBankVerifiedTv");
        }
        textView2.setText(str2);
        AppCompatEditText appCompatEditText = this.f50618c;
        if (appCompatEditText == null) {
            kotlin.g.b.k.a("mIfscEdt");
        }
        appCompatEditText.setText(this.m);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h() {
        /*
            r9 = this;
            androidx.appcompat.widget.AppCompatEditText r0 = r9.f50617b
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "mAccountNameEdt"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r9.o = r0
            androidx.appcompat.widget.AppCompatEditText r0 = r9.f50616a
            if (r0 != 0) goto L_0x001c
            java.lang.String r1 = "mAccountNoOrVpaEdt"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x001c:
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r9.p = r0
            net.one97.paytm.impsRefund.view.a$a r0 = r9.r
            net.one97.paytm.impsRefund.view.a$a r1 = net.one97.paytm.impsRefund.view.a.C0919a.ACCOUNT_NUMBER
            r2 = 1
            if (r0 != r1) goto L_0x0240
            java.lang.String r0 = r9.p
            if (r0 != 0) goto L_0x0034
            kotlin.g.b.k.a()
        L_0x0034:
            java.lang.String r1 = "accNumber"
            kotlin.g.b.k.c(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r3 = 32
            r4 = 0
            if (r1 != 0) goto L_0x00f7
            int r1 = r0.length()
            int r1 = r1 - r2
            r5 = r1
            r1 = 0
            r6 = 0
        L_0x004c:
            if (r1 > r5) goto L_0x006a
            if (r6 != 0) goto L_0x0052
            r7 = r1
            goto L_0x0053
        L_0x0052:
            r7 = r5
        L_0x0053:
            char r7 = r0.charAt(r7)
            if (r7 > r3) goto L_0x005b
            r7 = 1
            goto L_0x005c
        L_0x005b:
            r7 = 0
        L_0x005c:
            if (r6 != 0) goto L_0x0065
            if (r7 != 0) goto L_0x0062
            r6 = 1
            goto L_0x004c
        L_0x0062:
            int r1 = r1 + 1
            goto L_0x004c
        L_0x0065:
            if (r7 == 0) goto L_0x006a
            int r5 = r5 + -1
            goto L_0x004c
        L_0x006a:
            int r5 = r5 + r2
            java.lang.CharSequence r1 = r0.subSequence(r1, r5)
            java.lang.String r1 = r1.toString()
            int r1 = r1.length()
            r5 = 6
            if (r1 < r5) goto L_0x00f7
            int r1 = r0.length()
            int r1 = r1 - r2
            r5 = r1
            r1 = 0
            r6 = 0
        L_0x0082:
            if (r1 > r5) goto L_0x00a0
            if (r6 != 0) goto L_0x0088
            r7 = r1
            goto L_0x0089
        L_0x0088:
            r7 = r5
        L_0x0089:
            char r7 = r0.charAt(r7)
            if (r7 > r3) goto L_0x0091
            r7 = 1
            goto L_0x0092
        L_0x0091:
            r7 = 0
        L_0x0092:
            if (r6 != 0) goto L_0x009b
            if (r7 != 0) goto L_0x0098
            r6 = 1
            goto L_0x0082
        L_0x0098:
            int r1 = r1 + 1
            goto L_0x0082
        L_0x009b:
            if (r7 == 0) goto L_0x00a0
            int r5 = r5 + -1
            goto L_0x0082
        L_0x00a0:
            int r5 = r5 + r2
            java.lang.CharSequence r1 = r0.subSequence(r1, r5)
            java.lang.String r1 = r1.toString()
            int r1 = r1.length()
            r5 = 18
            if (r1 > r5) goto L_0x00f7
            int r1 = r0.length()
            int r1 = r1 - r2
            r5 = r1
            r1 = 0
            r6 = 0
        L_0x00b9:
            if (r1 > r5) goto L_0x00d7
            if (r6 != 0) goto L_0x00bf
            r7 = r1
            goto L_0x00c0
        L_0x00bf:
            r7 = r5
        L_0x00c0:
            char r7 = r0.charAt(r7)
            if (r7 > r3) goto L_0x00c8
            r7 = 1
            goto L_0x00c9
        L_0x00c8:
            r7 = 0
        L_0x00c9:
            if (r6 != 0) goto L_0x00d2
            if (r7 != 0) goto L_0x00cf
            r6 = 1
            goto L_0x00b9
        L_0x00cf:
            int r1 = r1 + 1
            goto L_0x00b9
        L_0x00d2:
            if (r7 == 0) goto L_0x00d7
            int r5 = r5 + -1
            goto L_0x00b9
        L_0x00d7:
            int r5 = r5 + r2
            java.lang.CharSequence r0 = r0.subSequence(r1, r5)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.m.l r1 = new kotlin.m.l
            java.lang.String r5 = "[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789]"
            r1.<init>((java.lang.String) r5)
            java.lang.String r5 = ""
            java.lang.String r0 = r1.replace((java.lang.CharSequence) r0, (java.lang.String) r5)
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            java.lang.String r1 = "mAccountNoOrVpaTil"
            if (r0 != 0) goto L_0x0110
            com.google.android.material.textfield.TextInputLayout r0 = r9.f50619d
            if (r0 != 0) goto L_0x0103
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0103:
            r1 = 2131966188(0x7f1338ec, float:1.9569207E38)
            java.lang.String r1 = r9.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setError(r1)
            return r4
        L_0x0110:
            java.lang.String r0 = r9.m
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01cb
            boolean r0 = r9.q
            if (r0 != 0) goto L_0x0120
            goto L_0x01cb
        L_0x0120:
            java.lang.String r0 = r9.o
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01b5
            java.lang.String r0 = r9.o
            if (r0 != 0) goto L_0x0131
            kotlin.g.b.k.a()
        L_0x0131:
            if (r0 == 0) goto L_0x01ad
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0145
            goto L_0x01b5
        L_0x0145:
            java.lang.String r0 = r9.m
            java.lang.String r5 = "PYTM0123456"
            boolean r0 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r0, (boolean) r2)
            if (r0 == 0) goto L_0x0242
            java.lang.String r0 = r9.p
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0242
            java.lang.String r0 = r9.p
            if (r0 != 0) goto L_0x0160
            kotlin.g.b.k.a()
        L_0x0160:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r5 = r0.length()
            int r5 = r5 - r2
            r6 = r5
            r5 = 0
            r7 = 0
        L_0x016a:
            if (r5 > r6) goto L_0x0188
            if (r7 != 0) goto L_0x0170
            r8 = r5
            goto L_0x0171
        L_0x0170:
            r8 = r6
        L_0x0171:
            char r8 = r0.charAt(r8)
            if (r8 > r3) goto L_0x0179
            r8 = 1
            goto L_0x017a
        L_0x0179:
            r8 = 0
        L_0x017a:
            if (r7 != 0) goto L_0x0183
            if (r8 != 0) goto L_0x0180
            r7 = 1
            goto L_0x016a
        L_0x0180:
            int r5 = r5 + 1
            goto L_0x016a
        L_0x0183:
            if (r8 == 0) goto L_0x0188
            int r6 = r6 + -1
            goto L_0x016a
        L_0x0188:
            int r6 = r6 + r2
            java.lang.CharSequence r0 = r0.subSequence(r5, r6)
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            r3 = 12
            if (r0 >= r3) goto L_0x0242
            com.google.android.material.textfield.TextInputLayout r0 = r9.f50619d
            if (r0 != 0) goto L_0x01a0
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01a0:
            r1 = 2131962392(0x7f132a18, float:1.9561508E38)
            java.lang.String r1 = r9.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setError(r1)
            return r4
        L_0x01ad:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            throw r0
        L_0x01b5:
            com.google.android.material.textfield.TextInputLayout r0 = r9.f50620e
            if (r0 != 0) goto L_0x01be
            java.lang.String r1 = "mAccountNameTil"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01be:
            r1 = 2131966187(0x7f1338eb, float:1.9569205E38)
            java.lang.String r1 = r9.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setError(r1)
            return r4
        L_0x01cb:
            android.widget.ImageView r0 = r9.l
            if (r0 != 0) goto L_0x01d4
            java.lang.String r1 = "mIfscVerifiedImage"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01d4:
            r1 = 8
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r9.k
            if (r0 != 0) goto L_0x01e2
            java.lang.String r2 = "mIfscFilledRly"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01e2:
            r0.setVisibility(r1)
            android.widget.TextView r0 = r9.f50622g
            java.lang.String r1 = "mFindIfscTv"
            if (r0 != 0) goto L_0x01ee
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01ee:
            androidx.fragment.app.FragmentActivity r2 = r9.getActivity()
            if (r2 != 0) goto L_0x01f7
            kotlin.g.b.k.a()
        L_0x01f7:
            android.content.Context r2 = (android.content.Context) r2
            r3 = 2131100124(0x7f0601dc, float:1.781262E38)
            int r2 = androidx.core.content.b.c(r2, r3)
            r0.setTextColor(r2)
            android.widget.TextView r0 = r9.f50622g
            if (r0 != 0) goto L_0x020a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x020a:
            r2 = 2131966047(0x7f13385f, float:1.9568921E38)
            java.lang.String r2 = r9.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r9.f50622g
            if (r0 != 0) goto L_0x021d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x021d:
            r0.setVisibility(r4)
            com.google.android.material.textfield.TextInputLayout r0 = r9.f50621f
            java.lang.String r1 = "mIfscTil"
            if (r0 != 0) goto L_0x0229
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0229:
            r0.setVisibility(r4)
            com.google.android.material.textfield.TextInputLayout r0 = r9.f50621f
            if (r0 != 0) goto L_0x0233
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0233:
            r1 = 2131966243(0x7f133923, float:1.9569319E38)
            java.lang.String r1 = r9.getString(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setError(r1)
            return r4
        L_0x0240:
            net.one97.paytm.impsRefund.view.a$a r0 = net.one97.paytm.impsRefund.view.a.C0919a.VPA
        L_0x0242:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.impsRefund.view.a.h():boolean");
    }

    /* access modifiers changed from: protected */
    public final void b(NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return;
        }
        if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, networkCustomError.getMessage(), true)) {
            r.a((Activity) getActivity(), (Exception) networkCustomError, a.class.getName(), (Bundle) null);
        } else {
            com.paytm.utility.b.b((Context) getActivity(), "Error", networkCustomError.getAlertMessage());
        }
    }

    public static final class f implements net.one97.paytm.landingpage.c.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50630a;

        f(a aVar) {
            this.f50630a = aVar;
        }

        public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
            kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
            a.a(this.f50630a, iJRPaytmDataModel);
        }

        public final void a(NetworkCustomError networkCustomError) {
            kotlin.g.b.k.c(networkCustomError, "error");
            this.f50630a.b(networkCustomError);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (com.paytm.utility.a.m(getActivity())) {
            net.one97.paytm.common.b.d.a().a((Activity) getActivity(), str, (net.one97.paytm.landingpage.c.d) new f(this));
        } else {
            com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        }
    }

    static final class g implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50631a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f50632b;

        g(a aVar, BottomSheetBehavior bottomSheetBehavior) {
            this.f50631a = aVar;
            this.f50632b = bottomSheetBehavior;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f50632b.setState(4);
            com.paytm.utility.b.c((Activity) this.f50631a.getActivity());
        }
    }

    public static final class h extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50633a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50634b;

        public final void onStateChanged(View view, int i2) {
            kotlin.g.b.k.c(view, "bottomSheet");
        }

        h(a aVar, com.google.android.material.bottomsheet.a aVar2) {
            this.f50633a = aVar;
            this.f50634b = aVar2;
        }

        public final void onSlide(View view, float f2) {
            kotlin.g.b.k.c(view, "bottomSheet");
            this.f50634b.cancel();
            com.paytm.utility.b.c((Activity) this.f50633a.getActivity());
        }
    }

    static final class i implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50635a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50636b;

        i(a aVar, com.google.android.material.bottomsheet.a aVar2) {
            this.f50635a = aVar;
            this.f50636b = aVar2;
        }

        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
            if (i2 != 4) {
                return false;
            }
            kotlin.g.b.k.a((Object) keyEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
            if (keyEvent.getAction() != 1) {
                return false;
            }
            this.f50636b.cancel();
            com.paytm.utility.b.c((Activity) this.f50635a.getActivity());
            return true;
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50637a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f50638b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50639c;

        j(a aVar, EditText editText, com.google.android.material.bottomsheet.a aVar2) {
            this.f50637a = aVar;
            this.f50638b = editText;
            this.f50639c = aVar2;
        }

        public final void onClick(View view) {
            com.paytm.utility.b.c((Activity) this.f50637a.getActivity());
            this.f50638b.clearFocus();
            this.f50639c.cancel();
        }
    }

    static final class k implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50640a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f50641b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f50642c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50643d;

        k(a aVar, EditText editText, TextInputLayout textInputLayout, com.google.android.material.bottomsheet.a aVar2) {
            this.f50640a = aVar;
            this.f50641b = editText;
            this.f50642c = textInputLayout;
            this.f50643d = aVar2;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            EditText editText = this.f50641b;
            kotlin.g.b.k.a((Object) editText, "accountNumberET");
            if (TextUtils.isEmpty(editText.getText())) {
                TextInputLayout textInputLayout = this.f50642c;
                kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setError(this.f50640a.getString(R.string.refund_account_does_not_match));
                return false;
            }
            EditText editText2 = this.f50641b;
            kotlin.g.b.k.a((Object) editText2, "accountNumberET");
            if (!p.a(editText2.getText().toString(), this.f50640a.p, true)) {
                TextInputLayout textInputLayout2 = this.f50642c;
                kotlin.g.b.k.a((Object) textInputLayout2, "accountNumberTIL");
                textInputLayout2.setError(this.f50640a.getString(R.string.refund_account_does_not_match));
                return false;
            }
            this.f50643d.cancel();
            this.f50640a.i();
            return false;
        }
    }

    public static final class l implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f50644a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        l(TextInputLayout textInputLayout) {
            this.f50644a = textInputLayout;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
            TextInputLayout textInputLayout = this.f50644a;
            kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
            textInputLayout.setError((CharSequence) null);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50645a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f50646b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f50647c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f50648d;

        m(a aVar, EditText editText, TextInputLayout textInputLayout, com.google.android.material.bottomsheet.a aVar2) {
            this.f50645a = aVar;
            this.f50646b = editText;
            this.f50647c = textInputLayout;
            this.f50648d = aVar2;
        }

        public final void onClick(View view) {
            EditText editText = this.f50646b;
            kotlin.g.b.k.a((Object) editText, "accountNumberET");
            if (TextUtils.isEmpty(editText.getText())) {
                TextInputLayout textInputLayout = this.f50647c;
                kotlin.g.b.k.a((Object) textInputLayout, "accountNumberTIL");
                textInputLayout.setError(this.f50645a.getString(R.string.refund_account_does_not_match));
                return;
            }
            EditText editText2 = this.f50646b;
            kotlin.g.b.k.a((Object) editText2, "accountNumberET");
            if (!p.a(editText2.getText().toString(), this.f50645a.p, true)) {
                TextInputLayout textInputLayout2 = this.f50647c;
                kotlin.g.b.k.a((Object) textInputLayout2, "accountNumberTIL");
                textInputLayout2.setError(this.f50645a.getString(R.string.refund_account_does_not_match));
                return;
            }
            this.f50648d.cancel();
            this.f50645a.i();
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f50628a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f50629b;

        e(a aVar, EditText editText) {
            this.f50628a = aVar;
            this.f50629b = editText;
        }

        public final void run() {
            Window window;
            try {
                FragmentActivity activity = this.f50628a.getActivity();
                InputMethodManager inputMethodManager = (InputMethodManager) (activity != null ? activity.getSystemService("input_method") : null);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f50629b, 1);
                    FragmentActivity activity2 = this.f50628a.getActivity();
                    if (activity2 != null && (window = activity2.getWindow()) != null) {
                        window.setSoftInputMode(20);
                    }
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
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
