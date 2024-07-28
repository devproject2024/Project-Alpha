package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.e.d;
import net.one97.paytm.oauth.fragment.w;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.g;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.view.MobilePrefixEditText;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;

public final class bj extends w implements View.OnClickListener, w.b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f56457b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private d f56458c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.oauth.utils.b f56459d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f56460e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f56461f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56462g;

    public final View a(int i2) {
        if (this.f56462g == null) {
            this.f56462g = new HashMap();
        }
        View view = (View) this.f56462g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56462g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56462g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void ad_() {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static bj a(Bundle bundle) {
            k.c(bundle, "bundle");
            bj bjVar = new bj();
            bjVar.setArguments(bundle);
            return bjVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_session_login, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        ProgressViewButton progressViewButton;
        MobilePrefixEditText mobilePrefixEditText;
        Editable text;
        Editable text2;
        super.onActivityCreated(bundle);
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton2 != null) {
            progressViewButton2.a();
        }
        Bundle arguments = getArguments();
        Editable editable = null;
        String string = arguments != null ? arguments.getString("login_mobile") : null;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("auth_flow") : null;
        if (!(serializable instanceof net.one97.paytm.oauth.utils.b)) {
            serializable = null;
        }
        this.f56459d = (net.one97.paytm.oauth.utils.b) serializable;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || !arguments3.getBoolean("clear_mobile_number", false)) {
            if (!TextUtils.isEmpty(string)) {
                String str = "+91 " + OAuthUtils.e(String.valueOf(string));
                MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                if (mobilePrefixEditText2 != null) {
                    mobilePrefixEditText2.setText(str);
                }
                MobilePrefixEditText mobilePrefixEditText3 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                if (mobilePrefixEditText3 != null) {
                    MobilePrefixEditText mobilePrefixEditText4 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                    if (mobilePrefixEditText4 != null) {
                        editable = mobilePrefixEditText4.getText();
                    }
                    mobilePrefixEditText3.setSelection(String.valueOf(editable).length());
                }
                MobilePrefixEditText mobilePrefixEditText5 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                if (mobilePrefixEditText5 != null) {
                    mobilePrefixEditText5.requestFocus();
                }
                ProgressViewButton progressViewButton3 = (ProgressViewButton) a(R.id.btnProceedSecurely);
                if (progressViewButton3 != null) {
                    progressViewButton3.b();
                }
                ProgressViewButton progressViewButton4 = (ProgressViewButton) a(R.id.btnProceedSecurely);
                if (progressViewButton4 != null) {
                    progressViewButton4.setOnClickListener(this);
                }
            } else if (!TextUtils.isEmpty(com.paytm.utility.b.ab(getContext()))) {
                this.f56461f = true;
                String str2 = "+91 " + OAuthUtils.e(com.paytm.utility.b.ab(getContext()));
                MobilePrefixEditText mobilePrefixEditText6 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                if (mobilePrefixEditText6 != null) {
                    mobilePrefixEditText6.setText(str2);
                }
                MobilePrefixEditText mobilePrefixEditText7 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                if (!(mobilePrefixEditText7 == null || (text2 = mobilePrefixEditText7.getText()) == null)) {
                    ((MobilePrefixEditText) a(R.id.et_registered_mobile)).setSelection(text2.length());
                }
                MobilePrefixEditText mobilePrefixEditText8 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                if (mobilePrefixEditText8 != null) {
                    mobilePrefixEditText8.requestFocus();
                }
                ProgressViewButton progressViewButton5 = (ProgressViewButton) a(R.id.btnProceedSecurely);
                if (progressViewButton5 != null) {
                    progressViewButton5.b();
                }
                ProgressViewButton progressViewButton6 = (ProgressViewButton) a(R.id.btnProceedSecurely);
                if (progressViewButton6 != null) {
                    progressViewButton6.setOnClickListener(this);
                }
            }
        }
        Bundle arguments4 = getArguments();
        if (!(arguments4 == null || !arguments4.getBoolean("is_from_session_expiry") || (mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile)) == null || (text = mobilePrefixEditText.getText()) == null || text.length() != 15)) {
            a("mobile_number_entered", (ArrayList<String>) new ArrayList());
        }
        ProgressViewButton progressViewButton7 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton7 != null) {
            progressViewButton7.setButtonText(getString(R.string.login_securely));
        }
        MobilePrefixEditText mobilePrefixEditText9 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText9 != null) {
            mobilePrefixEditText9.setTextChangedListener(new b(this));
        }
        MobilePrefixEditText mobilePrefixEditText10 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText10 != null) {
            mobilePrefixEditText10.setOnEditorActionListener(new c(this));
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        MobilePrefixEditText mobilePrefixEditText11 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText11 != null) {
            mobilePrefixEditText11.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.txtLoginIssues);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null && arguments5.getBoolean("is_from_session_expiry") && !OAuthUtils.a(requireContext()) && (progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely)) != null) {
            progressViewButton.performClick();
        }
        a("phone_number_popup_loaded", (ArrayList<String>) kotlin.a.k.d(c()));
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        if (net.one97.paytm.oauth.a.g() && TextUtils.isEmpty(g())) {
            FragmentActivity requireActivity = requireActivity();
            if (requireActivity != null) {
                OAuthUtils.a((Activity) (AppCompatActivity) requireActivity, (Fragment) this, true);
                a("mobile_number_list_popup_loaded", (ArrayList<String>) new ArrayList());
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        } else if (TextUtils.isEmpty(g())) {
            OAuthUtils.a((EditText) (MobilePrefixEditText) a(R.id.et_registered_mobile));
        }
    }

    static final class b implements MobilePrefixEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bj f56463a;

        b(bj bjVar) {
            this.f56463a = bjVar;
        }

        public final void a(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56463a.a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56463a.a(R.id.til_registered_mobile);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
            int length = editable.length();
            MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) this.f56463a.a(R.id.et_registered_mobile);
            if (mobilePrefixEditText == null || length != mobilePrefixEditText.getMaxLength()) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56463a.a(R.id.btnProceedSecurely);
                if (progressViewButton != null) {
                    progressViewButton.a();
                }
                ProgressViewButton progressViewButton2 = (ProgressViewButton) this.f56463a.a(R.id.btnProceedSecurely);
                if (progressViewButton2 != null) {
                    progressViewButton2.setOnClickListener((View.OnClickListener) null);
                    return;
                }
                return;
            }
            ProgressViewButton progressViewButton3 = (ProgressViewButton) this.f56463a.a(R.id.btnProceedSecurely);
            if (progressViewButton3 != null) {
                progressViewButton3.b();
            }
            ProgressViewButton progressViewButton4 = (ProgressViewButton) this.f56463a.a(R.id.btnProceedSecurely);
            if (progressViewButton4 != null) {
                progressViewButton4.setOnClickListener(this.f56463a);
            }
        }
    }

    static final class c implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bj f56464a;

        c(bj bjVar) {
            this.f56464a = bjVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56464a.a(R.id.btnProceedSecurely);
            if (progressViewButton == null || !progressViewButton.f56843a) {
                bj bjVar = this.f56464a;
                bjVar.c(bjVar.g());
            }
            return true;
        }
    }

    public final void ac_() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.d();
        }
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText != null) {
            mobilePrefixEditText.setEnabled(true);
        }
    }

    public final void ab_() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText != null) {
            mobilePrefixEditText.setEnabled(false);
        }
    }

    public final void onClick(View view) {
        Bundle arguments;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("popup_discarded", (ArrayList<String>) new ArrayList());
            d dVar = this.f56458c;
            if (dVar == null) {
                k.a("sessionContainerListener");
            }
            dVar.b();
            if (this.f56459d == net.one97.paytm.oauth.utils.b.SESSION_EXPIRY && (arguments = getArguments()) != null && !arguments.getBoolean("close_pop_up")) {
                OauthModule.b().signOutAndLogin(getActivity(), true, OAuthUtils.b.SESSION_TIME_OUT);
                return;
            }
            return;
        }
        int i3 = R.id.btnProceedSecurely;
        if (valueOf != null && valueOf.intValue() == i3) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
            if (progressViewButton == null || !progressViewButton.f56843a) {
                c(g());
                return;
            }
            return;
        }
        int i4 = R.id.txtLoginIssues;
        if (valueOf != null && valueOf.intValue() == i4) {
            String g2 = g();
            q qVar = q.f56798a;
            q.b(g2);
            OauthModule.b().checkDeepLinking(getContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
        }
    }

    /* access modifiers changed from: private */
    public final void c(String str) {
        if (this.f56461f && !str.equals(com.paytm.utility.b.ab(getContext()))) {
            this.f56461f = false;
        }
        CharSequence charSequence = null;
        String str2 = "cache";
        if (TextUtils.isEmpty(str)) {
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setError(getString(R.string.empty_mob_no_error));
            }
            String[] strArr = new String[3];
            if (!this.f56461f) {
                str2 = "mobile_number";
            }
            strArr[0] = str2;
            TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout2 != null) {
                charSequence = textInputLayout2.getError();
            }
            strArr[1] = String.valueOf(charSequence);
            strArr[2] = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
            a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr));
        } else if (!OAuthUtils.a(str)) {
            TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout3 != null) {
                textInputLayout3.setError(getString(R.string.enter_valid_mobile));
            }
            String[] strArr2 = new String[3];
            if (!this.f56461f) {
                str2 = "mobile_number";
            }
            strArr2[0] = str2;
            TextInputLayout textInputLayout4 = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout4 != null) {
                charSequence = textInputLayout4.getError();
            }
            strArr2[1] = String.valueOf(charSequence);
            strArr2[2] = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
            a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr2));
        } else {
            OAuthUtils.a((Activity) getActivity());
            MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText != null) {
                mobilePrefixEditText.clearFocus();
            }
            q qVar = q.f56798a;
            q.b(g());
            String[] strArr3 = new String[1];
            if (this.f56460e) {
                str2 = "auto_mobile_number";
            } else if (!this.f56461f) {
                str2 = "mobile_number";
            }
            strArr3[0] = str2;
            a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr3));
            ay ayVar = ay.f56391a;
            FragmentActivity requireActivity = requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            if (ay.a((Activity) requireActivity, g())) {
                a(true);
            } else {
                f();
            }
        }
    }

    public final void a(d dVar) {
        k.c(dVar, "listener");
        this.f56458c = dVar;
    }

    /* access modifiers changed from: private */
    public final String g() {
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        Editable editable = null;
        if (TextUtils.isEmpty(String.valueOf(mobilePrefixEditText != null ? mobilePrefixEditText.getText() : null))) {
            return "";
        }
        MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText2 != null) {
            editable = mobilePrefixEditText2.getText();
        }
        String replace = new l("\\s").replace((CharSequence) p.a(String.valueOf(editable), "+91 ", "", false), "");
        if (replace != null) {
            return p.b(replace).toString();
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final void a(String str, boolean z, boolean z2) {
        d dVar = this.f56458c;
        if (dVar == null) {
            k.a("sessionContainerListener");
        }
        dVar.a(str, g(), z, false, "/session_expiry_phone_number_prompt", z2);
    }

    public final void a(String str) {
        d dVar = this.f56458c;
        if (dVar == null) {
            k.a("sessionContainerListener");
        }
        dVar.a(str, g(), "/session_expiry_phone_number_prompt");
    }

    private final void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), "session_expiry", str, arrayList, (String) null, "/session_expiry", net.one97.paytm.oauth.utils.p.f56796a);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1094) {
            MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText != null) {
                mobilePrefixEditText.requestFocus();
            }
            if (i3 != -1) {
                a("mobile_number_list_popup_dismissed", (ArrayList<String>) new ArrayList());
            } else if (intent != null) {
                Parcelable parcelableExtra = intent.getParcelableExtra("com.google.android.gms.credentials.Credential");
                if (parcelableExtra != null) {
                    String h2 = OAuthUtils.h(((Credential) parcelableExtra).a());
                    StringBuilder sb = new StringBuilder("+91 ");
                    k.a((Object) h2, "mobile");
                    if (h2 != null) {
                        sb.append(OAuthUtils.e(p.b(h2).toString()));
                        String sb2 = sb.toString();
                        a("mobile_number_selected", (ArrayList<String>) new ArrayList());
                        this.f56460e = true;
                        OAuthUtils.a((Activity) getActivity());
                        MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                        if (mobilePrefixEditText2 != null) {
                            mobilePrefixEditText2.setText(sb2);
                        }
                        int length = sb2.length();
                        if (length > 15) {
                            length = 15;
                        }
                        MobilePrefixEditText mobilePrefixEditText3 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                        if (mobilePrefixEditText3 != null) {
                            mobilePrefixEditText3.setSelection(length);
                        }
                        c(h2);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                }
                throw new u("null cannot be cast to non-null type com.google.android.gms.auth.api.credentials.Credential");
            }
        }
    }

    public final void a(Bundle bundle, g gVar) {
        k.c(bundle, "bundle");
        k.c(gVar, "deviceBindingState");
        Bundle arguments = getArguments();
        bundle.putSerializable("auth_flow", arguments != null ? arguments.getSerializable("auth_flow") : null);
        int i2 = bk.f56465a[gVar.ordinal()];
        if (i2 == 1) {
            d dVar = this.f56458c;
            if (dVar == null) {
                k.a("sessionContainerListener");
            }
            dVar.e(bundle);
        } else if (i2 == 2) {
            d dVar2 = this.f56458c;
            if (dVar2 == null) {
                k.a("sessionContainerListener");
            }
            dVar2.a(bundle);
        } else if (i2 == 3) {
            d dVar3 = this.f56458c;
            if (dVar3 == null) {
                k.a("sessionContainerListener");
            }
            dVar3.i(bundle);
        } else if (i2 == 4) {
            d dVar4 = this.f56458c;
            if (dVar4 == null) {
                k.a("sessionContainerListener");
            }
            dVar4.j(bundle);
        }
    }

    public final void a(String str, String str2, boolean z) {
        ab_();
        d dVar = this.f56458c;
        if (dVar == null) {
            k.a("sessionContainerListener");
        }
        dVar.a(str, str2, z, z ? i.SIGNUP : i.LOGIN);
    }

    public final String d() {
        return g();
    }
}
