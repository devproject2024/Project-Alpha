package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.ForgotPasswordContainerActivity;
import net.one97.paytm.oauth.fragment.w;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.u;
import net.one97.paytm.oauth.view.ProgressViewButton;
import org.json.JSONException;
import org.json.JSONObject;

public final class bn extends w implements View.OnClickListener, w.b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f56487d = new a((byte) 0);
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f56488b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.oauth.e.d f56489c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.oauth.g.f f56490e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f56491f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f56492g;

    /* renamed from: h  reason: collision with root package name */
    private String f56493h = "";

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.oauth.utils.b f56494i;
    /* access modifiers changed from: private */
    public final kotlin.g.a.a<x> j = new b(this);
    /* access modifiers changed from: private */
    public final z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> k = new i(this);
    private HashMap l;

    public final View a(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void a(Bundle bundle, net.one97.paytm.oauth.utils.g gVar) {
        k.c(bundle, "bundle");
        k.c(gVar, "deviceBindingState");
    }

    public final void a(String str, String str2, boolean z) {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    static final class i<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bn f56501a;

        i(bn bnVar) {
            this.f56501a = bnVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar.f52602a == 101) {
                bn bnVar = this.f56501a;
                T t = eVar.f52603b;
                if (t != null) {
                    bn.a(bnVar, (SimplifiedLoginInit) t);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.SimplifiedLoginInit");
            } else if (eVar.f52602a == 102) {
                T t2 = eVar.f52603b;
                if (t2 != null) {
                    ErrorModel errorModel = (ErrorModel) t2;
                    bn bnVar2 = this.f56501a;
                    Throwable th = eVar.f52604c;
                    kotlin.g.a.a j = this.f56501a.j;
                    k.c(errorModel, "model");
                    k.c(j, "retryFunc");
                    bnVar2.f56488b = false;
                    bnVar2.b(false);
                    Activity activity = bnVar2.getActivity();
                    Fragment fragment = bnVar2;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        if (OAuthUtils.a(activity, fragment, networkCustomError)) {
                            return;
                        }
                        if (l.a(errorModel)) {
                            net.one97.paytm.oauth.d.a.a(bnVar2.requireContext(), bnVar2.getString(R.string.some_went_wrong), (View.OnClickListener) null);
                        } else if (errorModel.getStatus() == -1) {
                            String string = bnVar2.getString(R.string.no_connection);
                            k.a((Object) string, "getString(R.string.no_connection)");
                            String string2 = bnVar2.getString(R.string.no_internet);
                            k.a((Object) string2, "getString(R.string.no_internet)");
                            OAuthUtils.a(bnVar2.getActivity(), string, string2, new c(j));
                        } else {
                            int status = errorModel.getStatus();
                            Integer num = n.f56789h;
                            if (num != null && status == num.intValue()) {
                                byte[] bArr = networkCustomError.networkResponse.data;
                                k.a((Object) bArr, "throwable.networkResponse.data");
                                String str = new String(bArr, kotlin.m.d.f47971a);
                                if (!TextUtils.isEmpty(str)) {
                                    try {
                                        if (k.a((Object) "3006", (Object) new JSONObject(str).getString("responseCode"))) {
                                            bnVar2.f56488b = true;
                                            bnVar2.e();
                                        }
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else {
                                net.one97.paytm.oauth.d.a.a(bnVar2.requireContext(), bnVar2.getString(R.string.some_went_wrong), (View.OnClickListener) null);
                            }
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.oauth.e.d c(bn bnVar) {
        net.one97.paytm.oauth.e.d dVar = bnVar.f56489c;
        if (dVar == null) {
            k.a("sessionContainerListener");
        }
        return dVar;
    }

    public static final /* synthetic */ net.one97.paytm.oauth.g.f g(bn bnVar) {
        net.one97.paytm.oauth.g.f fVar = bnVar.f56490e;
        if (fVar == null) {
            k.a("pwdViewModel");
        }
        return fVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dialog_session_login, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        a("password_popup_loaded", (ArrayList<String>) kotlin.a.k.d(c()));
        Fragment fragment = this;
        FragmentActivity activity = getActivity();
        String str2 = null;
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        ai a2 = am.a(fragment, (al.b) new net.one97.paytm.oauth.g.b(application, new String[0])).a(net.one97.paytm.oauth.g.f.class);
        k.a((Object) a2, "ViewModelProviders.of(th…t(LoginPwdVM::class.java)");
        this.f56490e = (net.one97.paytm.oauth.g.f) a2;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("login_mobile")) == null) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            str = com.paytm.utility.b.ab(b2.getApplicationContext());
            k.a((Object) str, "CJRAppCommonUtility.getE…der().applicationContext)");
        }
        this.f56493h = str;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("auth_flow") : null;
        if (!(serializable instanceof net.one97.paytm.oauth.utils.b)) {
            serializable = null;
        }
        this.f56494i = (net.one97.paytm.oauth.utils.b) serializable;
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.login_securely));
        }
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilPassword);
        if (textInputLayout != null) {
            textInputLayout.setHint(getString(R.string.paytm_password));
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.tvForgotPassword);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvLoginDiffAccount);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton2 != null) {
            progressViewButton2.a();
        }
        View a3 = a(R.id.blockView);
        if (a3 != null) {
            a3.setOnTouchListener(new f(this));
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etPassword);
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(new g(this));
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etPassword);
        if (appCompatEditText2 != null) {
            appCompatEditText2.setOnEditorActionListener(new h(this));
        }
        Bundle arguments3 = getArguments();
        if (TextUtils.isEmpty(arguments3 != null ? arguments3.getString("login_state_token") : null)) {
            e();
            return;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            str2 = arguments4.getString("login_state_token");
        }
        this.f56491f = String.valueOf(str2);
    }

    public final void ac_() {
        b(false);
    }

    public final void ab_() {
        b(true);
    }

    static final class f implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bn f56498a;

        f(bn bnVar) {
            this.f56498a = bnVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f56498a.f56492g;
        }
    }

    public static final class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bn f56499a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        g(bn bnVar) {
            this.f56499a = bnVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
            AppCompatEditText appCompatEditText = (AppCompatEditText) this.f56499a.a(R.id.etPassword);
            if (String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null).length() >= 5) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56499a.a(R.id.btnProceedSecurely);
                if (progressViewButton != null) {
                    progressViewButton.b();
                }
                ProgressViewButton progressViewButton2 = (ProgressViewButton) this.f56499a.a(R.id.btnProceedSecurely);
                if (progressViewButton2 != null) {
                    progressViewButton2.setOnClickListener(this.f56499a);
                    return;
                }
                return;
            }
            ProgressViewButton progressViewButton3 = (ProgressViewButton) this.f56499a.a(R.id.btnProceedSecurely);
            if (progressViewButton3 != null) {
                progressViewButton3.a();
            }
            ProgressViewButton progressViewButton4 = (ProgressViewButton) this.f56499a.a(R.id.btnProceedSecurely);
            if (progressViewButton4 != null) {
                progressViewButton4.setOnClickListener((View.OnClickListener) null);
            }
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f56499a.a(R.id.tilPassword);
            if (textInputLayout != null) {
                textInputLayout.setError("");
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56499a.a(R.id.tilPassword);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
        }
    }

    static final class h implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bn f56500a;

        h(bn bnVar) {
            this.f56500a = bnVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            this.f56500a.g();
            return false;
        }
    }

    public final void onClick(View view) {
        Bundle arguments;
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("popup_discarded", (ArrayList<String>) kotlin.a.k.d("password"));
            net.one97.paytm.oauth.e.d dVar = this.f56489c;
            if (dVar == null) {
                k.a("sessionContainerListener");
            }
            dVar.b();
            if (this.f56494i == net.one97.paytm.oauth.utils.b.SESSION_EXPIRY && (arguments = getArguments()) != null && !arguments.getBoolean("close_pop_up")) {
                OauthModule.b().signOutAndLogin(getActivity(), true, OAuthUtils.b.SESSION_TIME_OUT);
                return;
            }
            return;
        }
        int i3 = R.id.tvLoginDiffAccount;
        if (valueOf != null && valueOf.intValue() == i3) {
            a("login_to_a_diff_account", (ArrayList<String>) new ArrayList());
            com.paytm.utility.b.n(requireContext(), "");
            Bundle bundle = new Bundle();
            bundle.putSerializable("auth_flow", this.f56494i);
            bundle.putBoolean("is_from_session_expiry", false);
            bundle.putString(p.f56797b, "/session-expiry-password-prompt");
            net.one97.paytm.oauth.e.d dVar2 = this.f56489c;
            if (dVar2 == null) {
                k.a("sessionContainerListener");
            }
            dVar2.g(bundle);
            return;
        }
        int i4 = R.id.tvForgotPassword;
        if (valueOf != null && valueOf.intValue() == i4) {
            a("forgot_password_clicked", (ArrayList<String>) new ArrayList());
            Intent intent = new Intent(getContext(), ForgotPasswordContainerActivity.class);
            intent.putExtra(p.f56797b, "/session-expiry-password-prompt");
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str = arguments2.getString("login_mobile", "");
            }
            intent.putExtra("login_mobile", str);
            startActivity(intent);
            return;
        }
        int i5 = R.id.btnProceedSecurely;
        if (valueOf != null && valueOf.intValue() == i5 && !((ProgressViewButton) a(R.id.btnProceedSecurely)).f56843a) {
            g();
        }
    }

    /* access modifiers changed from: private */
    public final void g() {
        if (isVisible()) {
            AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etPassword);
            if (!OAuthUtils.c(String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null))) {
                TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilPassword);
                k.a((Object) textInputLayout, "tilPassword");
                textInputLayout.setErrorEnabled(true);
                TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.tilPassword);
                k.a((Object) textInputLayout2, "tilPassword");
                textInputLayout2.setError(getString(R.string.msg_invalid_password));
                TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.tilPassword);
                k.a((Object) textInputLayout3, "tilPassword");
                a("login_securely_clicked", (ArrayList<String>) kotlin.a.k.d("password", String.valueOf(textInputLayout3.getError()), AppManagerUtil.EXTEND_PREFIX_DEFAULT));
                return;
            }
            this.j.invoke();
        }
    }

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ bn this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bn bnVar) {
            super(0);
            this.this$0 = bnVar;
        }

        public final void invoke() {
            OAuthUtils.a((Activity) this.this$0.getActivity());
            AppCompatEditText appCompatEditText = (AppCompatEditText) this.this$0.a(R.id.etPassword);
            if (appCompatEditText != null) {
                appCompatEditText.clearFocus();
            }
            this.this$0.b(true);
            if (TextUtils.isEmpty(this.this$0.f56491f)) {
                this.this$0.f56488b = true;
                this.this$0.e();
                return;
            }
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) this.this$0.a(R.id.etPassword);
            String valueOf = String.valueOf(appCompatEditText2 != null ? appCompatEditText2.getText() : null);
            if (valueOf != null) {
                String obj = kotlin.m.p.b(valueOf).toString();
                if (this.this$0.f56490e != null) {
                    LiveData<net.one97.paytm.oauth.e<IJRPaytmDataModel>> a2 = bn.g(this.this$0).a(obj, this.this$0.f56491f);
                    bn bnVar = this.this$0;
                    a2.observe(bnVar, bnVar.k);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bn f56496a;

        d(bn bnVar) {
            this.f56496a = bnVar;
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle(this.f56496a.getArguments());
            bundle.putBoolean("is_from_session_expiry", false);
            bundle.putString(p.f56797b, "/session-expiry-password-prompt");
            bn.c(this.f56496a).g(bundle);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bn f56497a;

        e(bn bnVar) {
            this.f56497a = bnVar;
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle(this.f56497a.getArguments());
            bundle.putBoolean("is_from_session_expiry", false);
            bundle.putString(p.f56797b, "/session-expiry-password-prompt");
            bn.c(this.f56497a).g(bundle);
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.a f56495a;

        c(kotlin.g.a.a aVar) {
            this.f56495a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56495a.invoke();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(boolean z) {
        if (z) {
            ((ProgressViewButton) a(R.id.btnProceedSecurely)).c();
            View a2 = a(R.id.blockView);
            k.a((Object) a2, "blockView");
            net.one97.paytm.oauth.utils.h.a(a2);
        } else {
            ((ProgressViewButton) a(R.id.btnProceedSecurely)).d();
            View a3 = a(R.id.blockView);
            k.a((Object) a3, "blockView");
            net.one97.paytm.oauth.utils.h.b(a3);
        }
        this.f56492g = z;
    }

    private final void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), "session_expiry_prompt", str, arrayList, (String) null, "/session-expiry-password-prompt", p.f56796a);
    }

    public final void a(String str, boolean z, boolean z2) {
        net.one97.paytm.oauth.e.d dVar = this.f56489c;
        if (dVar == null) {
            k.a("sessionContainerListener");
        }
        dVar.a(str, this.f56493h, z, true, "/session-expiry-password-prompt", z2);
    }

    public final void a(String str) {
        if (str != null) {
            this.f56491f = str;
        }
        if (this.f56488b) {
            this.j.invoke();
        }
    }

    public final void ad_() {
        Bundle bundle = new Bundle(getArguments());
        bundle.putSerializable("auth_flow", this.f56494i);
        bundle.putBoolean("is_from_session_expiry", false);
        bundle.putString(p.f56797b, "/session-expiry-password-prompt");
        net.one97.paytm.oauth.e.d dVar = this.f56489c;
        if (dVar == null) {
            k.a("sessionContainerListener");
        }
        dVar.g(bundle);
    }

    public final String d() {
        return this.f56493h;
    }

    public static final /* synthetic */ void a(bn bnVar, SimplifiedLoginInit simplifiedLoginInit) {
        String responseCode = simplifiedLoginInit.getResponseCode();
        Editable editable = null;
        if (responseCode != null) {
            switch (responseCode.hashCode()) {
                case 1537:
                    if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        bnVar.a("login_securely_clicked", (ArrayList<String>) kotlin.a.k.d("password"));
                        net.one97.paytm.oauth.e.d dVar = bnVar.f56489c;
                        if (dVar == null) {
                            k.a("sessionContainerListener");
                        }
                        String oauthCode = simplifiedLoginInit.getOauthCode();
                        k.a((Object) oauthCode, "resModel.oauthCode");
                        dVar.a(oauthCode, bnVar.f56493h, false);
                        net.one97.paytm.oauth.e.d dVar2 = bnVar.f56489c;
                        if (dVar2 == null) {
                            k.a("sessionContainerListener");
                        }
                        u.a aVar = net.one97.paytm.oauth.utils.u.Companion;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) bnVar.a(R.id.etPassword);
                        if (appCompatEditText != null) {
                            editable = appCompatEditText.getText();
                        }
                        dVar2.a(u.a.a(String.valueOf(editable)).getStrength());
                        return;
                    }
                    break;
                case 51672:
                    if (responseCode.equals("459")) {
                        net.one97.paytm.oauth.d.a.a(bnVar.requireContext(), simplifiedLoginInit.getMessage(), (View.OnClickListener) new e(bnVar));
                        return;
                    }
                    break;
                case 54399:
                    if (responseCode.equals("708")) {
                        net.one97.paytm.oauth.d.a.a(bnVar.requireContext(), simplifiedLoginInit.getMessage(), (View.OnClickListener) new d(bnVar));
                        return;
                    }
                    break;
                case 1567005:
                    if (responseCode.equals("3000")) {
                        net.one97.paytm.oauth.e.d dVar3 = bnVar.f56489c;
                        if (dVar3 == null) {
                            k.a("sessionContainerListener");
                        }
                        u.a aVar2 = net.one97.paytm.oauth.utils.u.Companion;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) bnVar.a(R.id.etPassword);
                        if (appCompatEditText2 != null) {
                            editable = appCompatEditText2.getText();
                        }
                        dVar3.a(u.a.a(String.valueOf(editable)).getStrength());
                        bnVar.a(simplifiedLoginInit.getStateToken(), false, false);
                        bnVar.a("login_securely_clicked", (ArrayList<String>) kotlin.a.k.d("password"));
                        return;
                    }
                    break;
                case 1567011:
                    if (responseCode.equals("3006")) {
                        bnVar.f56488b = true;
                        bnVar.e();
                        return;
                    }
                    break;
            }
        }
        bnVar.b(false);
        if (!TextUtils.isEmpty(simplifiedLoginInit.getMessage())) {
            TextInputLayout textInputLayout = (TextInputLayout) bnVar.a(R.id.tilPassword);
            k.a((Object) textInputLayout, "tilPassword");
            textInputLayout.setErrorEnabled(true);
            TextInputLayout textInputLayout2 = (TextInputLayout) bnVar.a(R.id.tilPassword);
            k.a((Object) textInputLayout2, "tilPassword");
            textInputLayout2.setError(simplifiedLoginInit.getMessage());
            String message = simplifiedLoginInit.getMessage();
            k.a((Object) message, "resModel.message");
            String responseCode2 = simplifiedLoginInit.getResponseCode();
            k.a((Object) responseCode2, "resModel.responseCode");
            bnVar.a("login_securely_clicked", (ArrayList<String>) kotlin.a.k.d("password", message, SDKConstants.KEY_API, responseCode2));
            return;
        }
        String string = bnVar.getString(R.string.some_went_wrong);
        k.a((Object) string, "getString(R.string.some_went_wrong)");
        String responseCode3 = simplifiedLoginInit.getResponseCode();
        k.a((Object) responseCode3, "resModel.responseCode");
        bnVar.a("login_securely_clicked", (ArrayList<String>) kotlin.a.k.d("password", string, SDKConstants.KEY_API, responseCode3));
        com.paytm.utility.b.b((Context) bnVar.getActivity(), (String) null, bnVar.getString(R.string.some_went_wrong));
    }
}
