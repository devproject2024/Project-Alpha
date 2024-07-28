package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.oauth.fragment.ar;
import net.one97.paytm.oauth.fragment.w;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.g;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.view.MobilePrefixEditText;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;

public final class aq extends w implements View.OnClickListener, w.b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f56353b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private boolean f56354c;

    /* renamed from: d  reason: collision with root package name */
    private ap f56355d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f56356e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.oauth.d f56357f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f56358g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f56359h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f56360i;

    public final View a(int i2) {
        if (this.f56360i == null) {
            this.f56360i = new HashMap();
        }
        View view = (View) this.f56360i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56360i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56360i;
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

        public static aq a(Bundle bundle) {
            aq aqVar = new aq();
            aqVar.setArguments(bundle);
            return aqVar;
        }
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

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ap) {
            this.f56355d = (ap) context;
            if (context instanceof net.one97.paytm.oauth.d) {
                this.f56357f = (net.one97.paytm.oauth.d) context;
                return;
            }
            return;
        }
        throw new IllegalStateException("Activity must implement " + ap.class.getName());
    }

    public final void onDetach() {
        super.onDetach();
        this.f56355d = null;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_login_create_account, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        net.one97.paytm.oauth.utils.k c2;
        Editable text;
        super.onActivityCreated(bundle);
        String c3 = c();
        k.c(c3, "previousScreen");
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        String str = net.one97.paytm.oauth.utils.p.f56796a;
        Context context = getContext();
        b2.sendOpenScreenWithDeviceInfo("/signup", str, context != null ? context.getApplicationContext() : null);
        a("login_signup_screen_loaded", (ArrayList<String>) kotlin.a.k.d(c3));
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("login_mobile") : null;
        if (!TextUtils.isEmpty(string)) {
            String str2 = "+91 " + OAuthUtils.e(String.valueOf(string));
            MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText != null) {
                mobilePrefixEditText.setText(str2);
            }
            MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText2 != null) {
                MobilePrefixEditText mobilePrefixEditText3 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
                k.a((Object) mobilePrefixEditText3, "et_registered_mobile");
                Editable text2 = mobilePrefixEditText3.getText();
                if (text2 == null) {
                    k.a();
                }
                mobilePrefixEditText2.setSelection(text2.length());
            }
            MobilePrefixEditText mobilePrefixEditText4 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText4 != null) {
                mobilePrefixEditText4.requestFocus();
            }
        } else if (!TextUtils.isEmpty(com.paytm.utility.b.ab(getContext()))) {
            this.f56359h = true;
            String str3 = "+91 " + OAuthUtils.e(com.paytm.utility.b.ab(getContext()));
            MobilePrefixEditText mobilePrefixEditText5 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText5 != null) {
                mobilePrefixEditText5.setText(str3);
            }
            MobilePrefixEditText mobilePrefixEditText6 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (!(mobilePrefixEditText6 == null || (text = mobilePrefixEditText6.getText()) == null)) {
                ((MobilePrefixEditText) a(R.id.et_registered_mobile)).setSelection(text.length());
            }
            MobilePrefixEditText mobilePrefixEditText7 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText7 != null) {
                mobilePrefixEditText7.requestFocus();
            }
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.login_securely));
        }
        MobilePrefixEditText mobilePrefixEditText8 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText8 != null) {
            mobilePrefixEditText8.setTextChangedListener(new b(this));
        }
        MobilePrefixEditText mobilePrefixEditText9 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText9 != null) {
            mobilePrefixEditText9.setOnEditorActionListener(new c(this));
        }
        ap apVar = this.f56355d;
        if (apVar != null) {
            apVar.b((RoboTextView) a(R.id.tnc_bottom_layout));
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton2 != null) {
            progressViewButton2.a();
        }
        MobilePrefixEditText mobilePrefixEditText10 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
        if (mobilePrefixEditText10 != null) {
            mobilePrefixEditText10.setOnClickListener(this);
        }
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_registered_mobile);
        if (textInputLayout != null) {
            textInputLayout.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.txtLoginIssues);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.til_registered_mobile);
        k.a((Object) textInputLayout2, "til_registered_mobile");
        textInputLayout2.setHint(getString(R.string.mobile_number));
        FragmentActivity activity = getActivity();
        if (!(activity instanceof OAuthMainActivity)) {
            activity = null;
        }
        OAuthMainActivity oAuthMainActivity = (OAuthMainActivity) activity;
        if (oAuthMainActivity != null && (c2 = oAuthMainActivity.c()) != null) {
            c2.addObserver(new d(this));
        }
    }

    static final class d implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aq f56363a;

        d(aq aqVar) {
            this.f56363a = aqVar;
        }

        public final void update(Observable observable, Object obj) {
            MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) this.f56363a.a(R.id.et_registered_mobile);
            if (mobilePrefixEditText != null) {
                mobilePrefixEditText.a();
            }
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

    public final void onResume() {
        FragmentActivity activity;
        Window window;
        super.onResume();
        net.one97.paytm.oauth.a.a();
        if (net.one97.paytm.oauth.a.g() && !this.f56358g && TextUtils.isEmpty(g())) {
            OAuthUtils.a((Activity) requireActivity(), (Fragment) this, true);
            a("mobile_number_list_popup_loaded", (ArrayList<String>) new ArrayList());
        } else if (TextUtils.isEmpty(g()) && (activity = getActivity()) != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(5);
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

    static final class b implements MobilePrefixEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aq f56361a;

        b(aq aqVar) {
            this.f56361a = aqVar;
        }

        public final void a(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56361a.a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56361a.a(R.id.til_registered_mobile);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
            int length = editable.length();
            MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) this.f56361a.a(R.id.et_registered_mobile);
            if (mobilePrefixEditText == null || length != mobilePrefixEditText.getMaxLength()) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56361a.a(R.id.btnProceedSecurely);
                if (progressViewButton != null) {
                    progressViewButton.a();
                }
                ProgressViewButton progressViewButton2 = (ProgressViewButton) this.f56361a.a(R.id.btnProceedSecurely);
                if (progressViewButton2 != null) {
                    progressViewButton2.setOnClickListener((View.OnClickListener) null);
                    return;
                }
                return;
            }
            ProgressViewButton progressViewButton3 = (ProgressViewButton) this.f56361a.a(R.id.btnProceedSecurely);
            if (progressViewButton3 != null) {
                progressViewButton3.b();
            }
            ProgressViewButton progressViewButton4 = (ProgressViewButton) this.f56361a.a(R.id.btnProceedSecurely);
            if (progressViewButton4 != null) {
                progressViewButton4.setOnClickListener(this.f56361a);
            }
        }
    }

    static final class c implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aq f56362a;

        c(aq aqVar) {
            this.f56362a = aqVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56362a.a(R.id.btnProceedSecurely);
            if (progressViewButton == null || !progressViewButton.f56843a) {
                aq aqVar = this.f56362a;
                aqVar.c(aqVar.g());
            }
            return true;
        }
    }

    public final void onViewStateRestored(Bundle bundle) {
        Editable text;
        super.onViewStateRestored(bundle);
        if (!TextUtils.isEmpty(com.paytm.utility.b.ab(getContext()))) {
            String str = "+91 " + OAuthUtils.e(com.paytm.utility.b.ab(getContext()));
            MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText != null) {
                mobilePrefixEditText.setText(str);
            }
            MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (!(mobilePrefixEditText2 == null || (text = mobilePrefixEditText2.getText()) == null)) {
                ((MobilePrefixEditText) a(R.id.et_registered_mobile)).setSelection(text.length());
            }
            MobilePrefixEditText mobilePrefixEditText3 = (MobilePrefixEditText) a(R.id.et_registered_mobile);
            if (mobilePrefixEditText3 != null) {
                mobilePrefixEditText3.requestFocus();
            }
        }
    }

    public final void onClick(View view) {
        k.c(view, "view");
        int id = view.getId();
        if (id == R.id.btnProceedSecurely) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
            if (progressViewButton != null && !progressViewButton.f56843a) {
                c(g());
            }
        } else if (id == R.id.et_registered_mobile) {
            this.f56354c = false;
        } else if (id == R.id.txtLoginIssues) {
            a("login_issue_clicked", (ArrayList<String>) new ArrayList());
            String g2 = g();
            q qVar = q.f56798a;
            q.b(g2);
            OauthModule.b().checkDeepLinking(getContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
        }
    }

    /* access modifiers changed from: private */
    public final void c(String str) {
        if (this.f56359h && !str.equals(com.paytm.utility.b.ab(getContext()))) {
            this.f56359h = false;
        }
        CharSequence charSequence = null;
        String str2 = "cache";
        if (TextUtils.isEmpty(str)) {
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.til_registered_mobile);
            if (textInputLayout != null) {
                textInputLayout.setError(getString(R.string.empty_mob_no_error));
            }
            String[] strArr = new String[3];
            if (!this.f56359h) {
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
            if (!this.f56359h) {
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
            q.b(str);
            String[] strArr3 = new String[1];
            if (this.f56356e) {
                str2 = "auto_mobile_number";
            } else if (!this.f56359h) {
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

    private static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "login_signup", str, arrayList, (String) null, "/login-signup", net.one97.paytm.oauth.utils.p.f56796a);
    }

    public final void a(String str, boolean z, boolean z2) {
        Bundle bundle = new Bundle(getArguments());
        bundle.putString(net.one97.paytm.oauth.utils.p.f56797b, "/login-signup");
        bundle.putString("login_state_token", str);
        bundle.putString("login_mobile", g());
        bundle.putBoolean("isfromSignup", z);
        bundle.putBoolean("is_device_binding", z2);
        ap apVar = this.f56355d;
        if (apVar != null) {
            apVar.a("FRAGMENT_OTP_ENTER", bundle, true);
        }
    }

    public final void a(String str) {
        Bundle bundle = new Bundle(getArguments());
        bundle.putString("login_state_token", str);
        bundle.putString("login_mobile", g());
        bundle.putString(net.one97.paytm.oauth.utils.p.f56797b, "/login-signup");
        ap apVar = this.f56355d;
        if (apVar != null) {
            apVar.a("FRAGMENT_LOGIN_PASSWORD", bundle, true);
        }
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
                this.f56358g = true;
                OAuthUtils.a((EditText) (MobilePrefixEditText) a(R.id.et_registered_mobile));
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
                        this.f56356e = true;
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

    public final void onStop() {
        net.one97.paytm.oauth.utils.k c2;
        super.onStop();
        FragmentActivity activity = getActivity();
        if (!(activity instanceof OAuthMainActivity)) {
            activity = null;
        }
        OAuthMainActivity oAuthMainActivity = (OAuthMainActivity) activity;
        if (!(oAuthMainActivity == null || (c2 = oAuthMainActivity.c()) == null)) {
            c2.deleteObservers();
        }
        OAuthUtils.a((Fragment) this);
    }

    public final void a(Bundle bundle, g gVar) {
        k.c(bundle, "bundle");
        k.c(gVar, "deviceBindingState");
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        ar.b bVar = ar.f56364c;
        k.c(gVar, "bindingState");
        k.c(bundle, "bundle");
        ar arVar = new ar();
        bundle.putSerializable("binding_state", gVar);
        arVar.setArguments(bundle);
        a2.a((Fragment) arVar, ar.class.getName());
        a2.c();
    }

    public final void a(String str, String str2, boolean z) {
        ab_();
        net.one97.paytm.oauth.d dVar = this.f56357f;
        if (dVar != null) {
            dVar.a(str, str2, z, z ? i.SIGNUP : i.LOGIN);
        }
    }

    public final String d() {
        return g();
    }
}
