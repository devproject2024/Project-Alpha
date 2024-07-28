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
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.ForgotPasswordContainerActivity;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.utils.u;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag extends h implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static final a f56310d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    String f56311a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public ap f56312b;

    /* renamed from: c  reason: collision with root package name */
    net.one97.paytm.oauth.d f56313c;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.oauth.g.f f56314e;

    /* renamed from: f  reason: collision with root package name */
    private final g f56315f = new g(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56316g;

    public final View a(int i2) {
        if (this.f56316g == null) {
            this.f56316g = new HashMap();
        }
        View view = (View) this.f56316g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56316g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f56317a;

        b(ag agVar) {
            this.f56317a = agVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                int i2 = eVar.f52602a;
                boolean z = false;
                if (i2 == 101) {
                    ag agVar = this.f56317a;
                    IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
                    ap apVar = agVar.f56312b;
                    if (apVar != null) {
                        apVar.b();
                    }
                    if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
                        SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
                        String responseCode = simplifiedLoginInit.getResponseCode();
                        if (responseCode != null) {
                            switch (responseCode.hashCode()) {
                                case 1537:
                                    if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                                        String oauthCode = simplifiedLoginInit.getOauthCode();
                                        k.a((Object) oauthCode, "model.oauthCode");
                                        q qVar = q.f56798a;
                                        Boolean passwordViolation = simplifiedLoginInit.getPasswordViolation();
                                        k.a((Object) passwordViolation, "model.passwordViolation");
                                        q.c(passwordViolation.booleanValue());
                                        net.one97.paytm.oauth.d dVar = agVar.f56313c;
                                        if (dVar != null) {
                                            u.a aVar = u.Companion;
                                            AppCompatEditText appCompatEditText = (AppCompatEditText) agVar.a(R.id.etPassword);
                                            dVar.a(u.a.a(String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null)).getStrength());
                                        }
                                        Bundle arguments = agVar.getArguments();
                                        if (arguments != null) {
                                            z = arguments.getBoolean("isfromSignup", false);
                                        }
                                        net.one97.paytm.oauth.d dVar2 = agVar.f56313c;
                                        if (dVar2 != null) {
                                            dVar2.a(oauthCode, z, agVar.f56311a, z ? i.SIGNUP : i.LOGIN);
                                        }
                                        ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password"));
                                        return;
                                    }
                                    break;
                                case 51672:
                                    if (responseCode.equals("459")) {
                                        net.one97.paytm.oauth.d.a.a(agVar.requireContext(), simplifiedLoginInit.getMessage(), (View.OnClickListener) new f(agVar));
                                        String message = simplifiedLoginInit.getMessage();
                                        k.a((Object) message, "model.message");
                                        String responseCode2 = simplifiedLoginInit.getResponseCode();
                                        k.a((Object) responseCode2, "model.responseCode");
                                        ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password", message, SDKConstants.KEY_API, responseCode2));
                                        return;
                                    }
                                    break;
                                case 54399:
                                    if (responseCode.equals("708")) {
                                        net.one97.paytm.oauth.d.a.a(agVar.requireContext(), simplifiedLoginInit.getMessage(), (View.OnClickListener) new e(agVar));
                                        String message2 = simplifiedLoginInit.getMessage();
                                        k.a((Object) message2, "model.message");
                                        String responseCode3 = simplifiedLoginInit.getResponseCode();
                                        k.a((Object) responseCode3, "model.responseCode");
                                        ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password", message2, SDKConstants.KEY_API, responseCode3));
                                        return;
                                    }
                                    break;
                                case 1567005:
                                    if (responseCode.equals("3000")) {
                                        String stateToken = simplifiedLoginInit.getStateToken();
                                        if (stateToken == null) {
                                            stateToken = "";
                                        }
                                        Bundle bundle = new Bundle(agVar.getArguments());
                                        bundle.putString("login_state_token", stateToken);
                                        bundle.putString("login_mobile", agVar.f56311a);
                                        bundle.putString(p.f56797b, "/login-password");
                                        bundle.putBoolean("is_from_password", true);
                                        net.one97.paytm.oauth.d dVar3 = agVar.f56313c;
                                        if (dVar3 != null) {
                                            u.a aVar2 = u.Companion;
                                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) agVar.a(R.id.etPassword);
                                            dVar3.a(u.a.a(String.valueOf(appCompatEditText2 != null ? appCompatEditText2.getText() : null)).getStrength());
                                        }
                                        ap apVar2 = agVar.f56312b;
                                        if (apVar2 != null) {
                                            apVar2.a("FRAGMENT_OTP_ENTER", bundle, true);
                                        }
                                        ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password"));
                                        return;
                                    }
                                    break;
                                case 1567011:
                                    if (responseCode.equals("3006")) {
                                        simplifiedLoginInit.getStateToken();
                                        Bundle bundle2 = new Bundle(agVar.getArguments());
                                        bundle2.putString("login_mobile", agVar.f56311a);
                                        ap apVar3 = agVar.f56312b;
                                        if (apVar3 != null) {
                                            apVar3.a("FRAGMENT_LOGIN_MOBILE", bundle2, false);
                                        }
                                        Toast.makeText(agVar.requireContext(), agVar.getString(R.string.lbl_session_expired_proceed_again), 1).show();
                                        String message3 = simplifiedLoginInit.getMessage();
                                        k.a((Object) message3, "model.message");
                                        ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password", message3, SDKConstants.KEY_API));
                                        return;
                                    }
                                    break;
                            }
                        }
                        if (!TextUtils.isEmpty(simplifiedLoginInit.getMessage())) {
                            String message4 = simplifiedLoginInit.getMessage();
                            k.a((Object) message4, "model.message");
                            TextInputLayout textInputLayout = (TextInputLayout) agVar.a(R.id.tilPassword);
                            k.a((Object) textInputLayout, "tilPassword");
                            textInputLayout.setErrorEnabled(true);
                            TextInputLayout textInputLayout2 = (TextInputLayout) agVar.a(R.id.tilPassword);
                            k.a((Object) textInputLayout2, "tilPassword");
                            textInputLayout2.setError(message4);
                            String message5 = simplifiedLoginInit.getMessage();
                            k.a((Object) message5, "model.message");
                            String responseCode4 = simplifiedLoginInit.getResponseCode();
                            k.a((Object) responseCode4, "model.responseCode");
                            ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password", message5, SDKConstants.KEY_API, responseCode4));
                            return;
                        }
                        com.paytm.utility.b.b((Context) agVar.getActivity(), (String) null, agVar.getString(R.string.some_went_wrong));
                        String string = agVar.getString(R.string.some_went_wrong);
                        k.a((Object) string, "getString(R.string.some_went_wrong)");
                        String responseCode5 = simplifiedLoginInit.getResponseCode();
                        k.a((Object) responseCode5, "model.responseCode");
                        ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password", string, SDKConstants.KEY_API, responseCode5));
                    }
                } else if (i2 == 102) {
                    ErrorModel errorModel = (ErrorModel) eVar.f52603b;
                    ag agVar2 = this.f56317a;
                    Throwable th = eVar.f52604c;
                    ap apVar4 = agVar2.f56312b;
                    if (apVar4 != null) {
                        apVar4.b();
                    }
                    Activity activity = agVar2.getActivity();
                    Fragment fragment = agVar2;
                    if (th != null) {
                        NetworkCustomError networkCustomError = (NetworkCustomError) th;
                        if (OAuthUtils.a(activity, fragment, networkCustomError)) {
                            return;
                        }
                        if (l.a(errorModel)) {
                            net.one97.paytm.oauth.d.a.a(agVar2.requireContext(), agVar2.getString(R.string.some_went_wrong), (View.OnClickListener) null);
                        } else if (errorModel == null || errorModel.getStatus() != -1) {
                            if (k.a((Object) errorModel != null ? Integer.valueOf(errorModel.getStatus()) : null, (Object) n.f56789h)) {
                                byte[] bArr = networkCustomError.networkResponse.data;
                                k.a((Object) bArr, "throwable.networkResponse.data");
                                String str = new String(bArr, kotlin.m.d.f47971a);
                                if (!TextUtils.isEmpty(str)) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(str);
                                        String string2 = jSONObject.getString("message");
                                        if (k.a((Object) "3006", (Object) jSONObject.getString("responseCode"))) {
                                            Bundle bundle3 = new Bundle(agVar2.getArguments());
                                            bundle3.putString("login_mobile", agVar2.f56311a);
                                            ap apVar5 = agVar2.f56312b;
                                            if (apVar5 != null) {
                                                apVar5.a("FRAGMENT_LOGIN_MOBILE", bundle3, false);
                                            }
                                            Toast.makeText(agVar2.requireContext(), agVar2.getString(R.string.lbl_session_expired_proceed_again), 1).show();
                                            k.a((Object) string2, "message");
                                            ag.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d("password", string2, SDKConstants.KEY_API));
                                        }
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else {
                                net.one97.paytm.oauth.d.a.a(agVar2.requireContext(), agVar2.getString(R.string.some_went_wrong), (View.OnClickListener) null);
                            }
                        } else {
                            String string3 = agVar2.getString(R.string.no_connection);
                            k.a((Object) string3, "getString(R.string.no_connection)");
                            String string4 = agVar2.getString(R.string.no_internet);
                            k.a((Object) string4, "getString(R.string.no_internet)");
                            OAuthUtils.a(agVar2.getActivity(), string3, string4, new c(agVar2));
                        }
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                    }
                }
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Fragment a(Bundle bundle) {
            ag agVar = new ag();
            agVar.setArguments(bundle);
            return agVar;
        }
    }

    public static final class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f56322a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        g(ag agVar) {
            this.f56322a = agVar;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
            AppCompatEditText appCompatEditText = (AppCompatEditText) this.f56322a.a(R.id.etPassword);
            if (String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null).length() >= 5) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56322a.a(R.id.btnProceedSecurely);
                if (progressViewButton != null) {
                    progressViewButton.b();
                }
                ProgressViewButton progressViewButton2 = (ProgressViewButton) this.f56322a.a(R.id.btnProceedSecurely);
                if (progressViewButton2 != null) {
                    progressViewButton2.setOnClickListener(this.f56322a);
                    return;
                }
                return;
            }
            ProgressViewButton progressViewButton3 = (ProgressViewButton) this.f56322a.a(R.id.btnProceedSecurely);
            if (progressViewButton3 != null) {
                progressViewButton3.a();
            }
            ProgressViewButton progressViewButton4 = (ProgressViewButton) this.f56322a.a(R.id.btnProceedSecurely);
            if (progressViewButton4 != null) {
                progressViewButton4.setOnClickListener((View.OnClickListener) null);
            }
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f56322a.a(R.id.tilPassword);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56322a.a(R.id.tilPassword);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragment = this;
        FragmentActivity activity = getActivity();
        String str = null;
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        ai a2 = am.a(fragment, (al.b) new net.one97.paytm.oauth.g.b(application, new String[0])).a(net.one97.paytm.oauth.g.f.class);
        k.a((Object) a2, "ViewModelProviders.of(th…t(LoginPwdVM::class.java)");
        this.f56314e = (net.one97.paytm.oauth.g.f) a2;
        Bundle arguments = getArguments();
        this.f56311a = arguments != null ? arguments.getString("login_mobile") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(p.f56797b);
        }
        if (str != null) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            net.one97.paytm.oauth.b b3 = OauthModule.b();
            k.a((Object) b3, "OauthModule.getOathDataProvider()");
            b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "login", "login_password_screen_loaded", kotlin.a.k.d(str), (String) null, "/login-password", p.f56796a);
        }
        OauthModule.b().sendOpenScreenWithDeviceInfo("/login-password", p.f56796a, getContext());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_enter_password, viewGroup, false);
    }

    static final class d implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f56319a;

        d(ag agVar) {
            this.f56319a = agVar;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            this.f56319a.a();
            return true;
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilPassword);
        if (textInputLayout != null) {
            textInputLayout.setHint(getString(R.string.paytm_password));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.login_securely));
        }
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etPassword);
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(this.f56315f);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.txtForgotPassword);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton2 != null) {
            progressViewButton2.a();
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etPassword);
        if (appCompatEditText2 != null) {
            appCompatEditText2.setOnEditorActionListener(new d(this));
        }
        OAuthUtils.a((EditText) (AppCompatEditText) a(R.id.etPassword));
    }

    public final void onClick(View view) {
        k.c(view, "v");
        int id = view.getId();
        if (id == R.id.btnProceedSecurely) {
            a();
        } else if (id == R.id.txtForgotPassword) {
            a("forgot_password_clicked", new ArrayList());
            Intent intent = new Intent(getContext(), ForgotPasswordContainerActivity.class);
            Bundle arguments = getArguments();
            intent.putExtra("login_mobile", arguments != null ? arguments.getString("login_mobile", "") : null);
            intent.putExtra(p.f56797b, "/login");
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.etPassword);
        CharSequence charSequence = null;
        String valueOf = String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null);
        if (!OAuthUtils.c(valueOf)) {
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilPassword);
            if (textInputLayout != null) {
                textInputLayout.setErrorEnabled(true);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.tilPassword);
            if (textInputLayout2 != null) {
                textInputLayout2.setError(getString(R.string.msg_invalid_password));
            }
            String[] strArr = new String[3];
            strArr[0] = "password";
            TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.tilPassword);
            if (textInputLayout3 != null) {
                charSequence = textInputLayout3.getError();
            }
            strArr[1] = String.valueOf(charSequence);
            strArr[2] = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
            a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr));
            return;
        }
        OAuthUtils.a((Activity) getActivity());
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.etPassword);
        if (appCompatEditText2 != null) {
            appCompatEditText2.clearFocus();
        }
        a(valueOf);
    }

    private final void a(String str) {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("login_state_token") : null;
        ap apVar = this.f56312b;
        if (apVar != null) {
            getString(R.string.txt_verifying_details);
            apVar.a();
        }
        net.one97.paytm.oauth.g.f fVar = this.f56314e;
        if (fVar == null) {
            k.a("viewModel");
        }
        fVar.a(str, string).observe(getViewLifecycleOwner(), new b(this));
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ap) {
            this.f56312b = (ap) context;
            if (context instanceof net.one97.paytm.oauth.d) {
                this.f56313c = (net.one97.paytm.oauth.d) context;
                return;
            }
            throw new IllegalStateException("Activity must implement " + net.one97.paytm.oauth.d.class.getName());
        }
        throw new IllegalStateException("Activity must implement " + ap.class.getName());
    }

    public final void onDetach() {
        super.onDetach();
        this.f56312b = null;
        this.f56313c = null;
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f56320a;

        e(ag agVar) {
            this.f56320a = agVar;
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle(this.f56320a.getArguments());
            ap b2 = this.f56320a.f56312b;
            if (b2 != null) {
                b2.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f56321a;

        f(ag agVar) {
            this.f56321a = agVar;
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle(this.f56321a.getArguments());
            ap b2 = this.f56321a.f56312b;
            if (b2 != null) {
                b2.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
            }
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ag f56318a;

        c(ag agVar) {
            this.f56318a = agVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56318a.a();
        }
    }

    static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "login", str, arrayList, (String) null, "/login-password", p.f56796a);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f56316g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
