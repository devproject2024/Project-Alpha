package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.OAuthBaseActivity;
import net.one97.paytm.oauth.fragment.ak;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.MobilePrefixEditText;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public final class ForgotEnterNumberFragment extends v implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final b f56112b = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    final CoroutineExceptionHandler f56113a = new a(CoroutineExceptionHandler.Key, this);

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.oauth.g.d f56114c;

    /* renamed from: d  reason: collision with root package name */
    private String f56115d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f56116e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f56117f;

    public final View a(int i2) {
        if (this.f56117f == null) {
            this.f56117f = new HashMap();
        }
        View view = (View) this.f56117f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56117f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56117f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final /* synthetic */ net.one97.paytm.oauth.g.d b(ForgotEnterNumberFragment forgotEnterNumberFragment) {
        net.one97.paytm.oauth.g.d dVar = forgotEnterNumberFragment.f56114c;
        if (dVar == null) {
            k.a("viewModel");
        }
        return dVar;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterNumberFragment f56118a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f.c cVar, ForgotEnterNumberFragment forgotEnterNumberFragment) {
            super(cVar);
            this.f56118a = forgotEnterNumberFragment;
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            th.getLocalizedMessage();
            FragmentActivity activity = this.f56118a.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new C1048a(this));
            }
        }

        /* renamed from: net.one97.paytm.oauth.fragment.ForgotEnterNumberFragment$a$a  reason: collision with other inner class name */
        static final class C1048a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f56119a;

            C1048a(a aVar) {
                this.f56119a = aVar;
            }

            public final void run() {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56119a.f56118a.a(R.id.btnProceedSecurely);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                com.paytm.utility.b.b(this.f56119a.f56118a.requireContext(), (String) null, this.f56119a.f56118a.getString(R.string.some_went_wrong));
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.d.class);
        k.a((Object) a2, "ViewModelProviders.of(th…PwdViewModel::class.java)");
        this.f56114c = (net.one97.paytm.oauth.g.d) a2;
        return layoutInflater.inflate(R.layout.fragment_forgot_enter_number, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        MobilePrefixEditText mobilePrefixEditText;
        Window window;
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            window.setSoftInputMode(32);
        }
        OauthModule.b().sendOpenScreenWithDeviceInfo("/forgot-password-phone-number", p.f56796a, requireContext());
        FragmentActivity requireActivity = requireActivity();
        k.a((Object) requireActivity, "requireActivity()");
        Intent intent = requireActivity.getIntent();
        k.a((Object) intent, "requireActivity().intent");
        Bundle extras = intent.getExtras();
        String str = null;
        this.f56115d = extras != null ? extras.getString("login_mobile", "") : null;
        FragmentActivity requireActivity2 = requireActivity();
        k.a((Object) requireActivity2, "requireActivity()");
        Intent intent2 = requireActivity2.getIntent();
        k.a((Object) intent2, "requireActivity().intent");
        Bundle extras2 = intent2.getExtras();
        if (extras2 != null) {
            str = extras2.getString(p.f56797b, "");
        }
        String[] strArr = new String[1];
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        a("forgot_password_phone_number_screen_loaded", kotlin.a.k.d(strArr));
        if (TextUtils.isEmpty(this.f56115d) && !TextUtils.isEmpty(com.paytm.utility.b.ab(getContext()))) {
            this.f56115d = com.paytm.utility.b.ab(getContext());
        }
        String str2 = "+91 " + OAuthUtils.e(this.f56115d);
        MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.etMobileNo);
        if (mobilePrefixEditText2 != null) {
            mobilePrefixEditText2.setText(str2);
        }
        if (str2.length() <= 15 && (mobilePrefixEditText = (MobilePrefixEditText) a(R.id.etMobileNo)) != null) {
            mobilePrefixEditText.setSelection(str2.length());
        }
        MobilePrefixEditText mobilePrefixEditText3 = (MobilePrefixEditText) a(R.id.etMobileNo);
        if (mobilePrefixEditText3 != null) {
            mobilePrefixEditText3.setTextChangedListener(new f(this));
        }
        MobilePrefixEditText mobilePrefixEditText4 = (MobilePrefixEditText) a(R.id.etMobileNo);
        if (mobilePrefixEditText4 != null) {
            mobilePrefixEditText4.setOnEditorActionListener(new g(this));
        }
        TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilMobileNo);
        if (textInputLayout != null) {
            textInputLayout.setHint(getString(R.string.mobile_number));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.login_securely));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            ((OAuthBaseActivity) activity2).a((TextView) (RoboTextView) a(R.id.tvTnC));
            ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
            if (progressViewButton2 != null) {
                progressViewButton2.setOnClickListener(this);
            }
            RoboTextView roboTextView = (RoboTextView) a(R.id.lblResetPwd);
            if (roboTextView != null) {
                roboTextView.setOnClickListener(this);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.lblUnableOtp);
            if (roboTextView2 != null) {
                roboTextView2.setOnClickListener(this);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.activity.OAuthBaseActivity");
    }

    static final class f implements MobilePrefixEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterNumberFragment f56123a;

        f(ForgotEnterNumberFragment forgotEnterNumberFragment) {
            this.f56123a = forgotEnterNumberFragment;
        }

        public final void a(Editable editable) {
            TextInputLayout textInputLayout = (TextInputLayout) this.f56123a.a(R.id.tilMobileNo);
            if (textInputLayout != null) {
                textInputLayout.setError((CharSequence) null);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f56123a.a(R.id.tilMobileNo);
            if (textInputLayout2 != null) {
                textInputLayout2.setErrorEnabled(false);
            }
        }
    }

    static final class g implements TextView.OnEditorActionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterNumberFragment f56124a;

        g(ForgotEnterNumberFragment forgotEnterNumberFragment) {
            this.f56124a = forgotEnterNumberFragment;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return false;
            }
            this.f56124a.e();
            return true;
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnProceedSecurely;
        if (valueOf != null && valueOf.intValue() == i2) {
            e();
            return;
        }
        int i3 = R.id.lblUnableOtp;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.lblResetPwd;
            if (valueOf == null || valueOf.intValue() != i4) {
                return;
            }
        }
        OAuthUtils.a(getFragmentManager(), d());
    }

    /* access modifiers changed from: private */
    public final void e() {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton == null || !progressViewButton.f56843a) {
            b(8);
            String d2 = d();
            if (!OAuthUtils.a(d2)) {
                TextInputLayout textInputLayout = (TextInputLayout) a(R.id.tilMobileNo);
                k.a((Object) textInputLayout, "tilMobileNo");
                textInputLayout.setErrorEnabled(true);
                TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.tilMobileNo);
                k.a((Object) textInputLayout2, "tilMobileNo");
                textInputLayout2.setError(getString(R.string.msg_invalid_mobile));
                String string = getString(R.string.msg_invalid_mobile);
                k.a((Object) string, "getString(R.string.msg_invalid_mobile)");
                a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(b(), string, AppManagerUtil.EXTEND_PREFIX_DEFAULT));
                return;
            }
            TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.tilMobileNo);
            k.a((Object) textInputLayout3, "tilMobileNo");
            textInputLayout3.setErrorEnabled(false);
            TextInputLayout textInputLayout4 = (TextInputLayout) a(R.id.tilMobileNo);
            k.a((Object) textInputLayout4, "tilMobileNo");
            textInputLayout4.setError((CharSequence) null);
            b(d2);
        }
    }

    private final void b(String str) {
        OAuthUtils.a((Activity) requireActivity());
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().plus(this.f56113a), (CoroutineStart) null, new c(this, str, (kotlin.d.d) null), 2, (Object) null);
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterNumberFragment f56122a;

        e(ForgotEnterNumberFragment forgotEnterNumberFragment) {
            this.f56122a = forgotEnterNumberFragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56122a.e();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        o oVar = o.f56791a;
        o.b(str);
        if (this.f56116e < 2) {
            b(str);
            this.f56116e++;
            return;
        }
        this.f56116e = 0;
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton2 != null) {
            progressViewButton2.d();
        }
        com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), getString(R.string.some_went_wrong));
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return k.a((Object) d(), (Object) this.f56115d) ? "same_mobile_number" : "diff_mobile_number";
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgOtpError);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(i2);
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
        if (roboTextView != null) {
            roboTextView.setVisibility(i2);
        }
        Group group = (Group) a(R.id.groupResetPwd);
        if (group != null) {
            group.setVisibility(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final String d() {
        MobilePrefixEditText mobilePrefixEditText = (MobilePrefixEditText) a(R.id.etMobileNo);
        k.a((Object) mobilePrefixEditText, "etMobileNo");
        if (TextUtils.isEmpty(String.valueOf(mobilePrefixEditText.getText()))) {
            return "";
        }
        MobilePrefixEditText mobilePrefixEditText2 = (MobilePrefixEditText) a(R.id.etMobileNo);
        return new l("\\s+").replace((CharSequence) kotlin.m.p.a(String.valueOf(mobilePrefixEditText2 != null ? mobilePrefixEditText2.getText() : null), "+91 ", "", false), "");
    }

    static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "forgot_password", str, arrayList, (String) null, "/forgot-password-phone-number", p.f56796a);
    }

    @kotlin.d.b.a.f(b = "ForgotEnterNumberFragment.kt", c = {135}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.ForgotEnterNumberFragment$execForgotPwdApi$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $mobileNo;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ ForgotEnterNumberFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ForgotEnterNumberFragment forgotEnterNumberFragment, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = forgotEnterNumberFragment;
            this.$mobileNo = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$mobileNo, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                o oVar = o.f56791a;
                if (o.a()) {
                    ForgotEnterNumberFragment forgotEnterNumberFragment = this.this$0;
                    String str = this.$mobileNo;
                    this.label = 1;
                    obj = BuildersKt__Builders_commonKt.async$default(GlobalScope.INSTANCE, Dispatchers.getIO().plus(forgotEnterNumberFragment.f56113a), (CoroutineStart) null, new d(str, (kotlin.d.d) null), 2, (Object) null).await(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                }
                ForgotEnterNumberFragment.b(this.this$0);
                Context requireContext = this.this$0.requireContext();
                k.a((Object) requireContext, "requireContext()");
                net.one97.paytm.oauth.g.d.a(requireContext, this.$mobileNo, "OTP").observe(this.this$0.getViewLifecycleOwner(), new z<net.one97.paytm.oauth.e<IJRPaytmDataModel>>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ c f56121a;

                    {
                        this.f56121a = r1;
                    }

                    public final /* synthetic */ void onChanged(Object obj) {
                        net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
                        if (eVar != null) {
                            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56121a.this$0.a(R.id.btnProceedSecurely);
                            if (progressViewButton != null) {
                                progressViewButton.d();
                            }
                            if (eVar.f52602a != 101) {
                                T t = eVar.f52603b;
                                if (t != null) {
                                    ErrorModel errorModel = (ErrorModel) t;
                                    ForgotEnterNumberFragment forgotEnterNumberFragment = this.f56121a.this$0;
                                    String str = this.f56121a.$mobileNo;
                                    k.c(errorModel, "model");
                                    k.c(str, "mobileNo");
                                    if (OAuthUtils.a((Activity) forgotEnterNumberFragment.getActivity(), (Fragment) forgotEnterNumberFragment, errorModel.getCustomError())) {
                                        return;
                                    }
                                    if (net.one97.paytm.oauth.utils.l.a(errorModel)) {
                                        forgotEnterNumberFragment.a(str);
                                    } else if (errorModel.getStatus() == -1) {
                                        String string = forgotEnterNumberFragment.getString(R.string.no_connection);
                                        k.a((Object) string, "getString(R.string.no_connection)");
                                        String string2 = forgotEnterNumberFragment.getString(R.string.no_internet);
                                        k.a((Object) string2, "getString(R.string.no_internet)");
                                        OAuthUtils.a(forgotEnterNumberFragment.requireContext(), string, string2, new e(forgotEnterNumberFragment));
                                    } else {
                                        if (errorModel.getCustomError() instanceof NetworkCustomError) {
                                            byte[] bArr = errorModel.getCustomError().networkResponse.data;
                                            if (bArr != null) {
                                                try {
                                                    JSONObject jSONObject = new JSONObject(new String(bArr, kotlin.m.d.f47971a));
                                                    String string3 = jSONObject.getString("message");
                                                    String string4 = jSONObject.getString("responseCode");
                                                    k.a((Object) string3, "message");
                                                    k.a((Object) string4, "responseCode");
                                                    ForgotEnterNumberFragment.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(forgotEnterNumberFragment.b(), string3, SDKConstants.KEY_API, string4));
                                                    int status = errorModel.getStatus();
                                                    Integer num = n.f56784c;
                                                    if (num != null) {
                                                        if (status == num.intValue() && k.a((Object) "BE1423003", (Object) string4)) {
                                                            forgotEnterNumberFragment.a(str);
                                                            return;
                                                        }
                                                    }
                                                    com.paytm.utility.b.b(forgotEnterNumberFragment.requireContext(), forgotEnterNumberFragment.getString(R.string.oauth_error), string3);
                                                    return;
                                                } catch (JSONException unused) {
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        com.paytm.utility.b.b(forgotEnterNumberFragment.requireContext(), forgotEnterNumberFragment.getString(R.string.oauth_error), forgotEnterNumberFragment.getString(R.string.some_went_wrong));
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                                }
                            } else {
                                ForgotEnterNumberFragment forgotEnterNumberFragment2 = this.f56121a.this$0;
                                IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
                                String str2 = this.f56121a.$mobileNo;
                                k.c(str2, "mobileNo");
                                if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
                                    SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
                                    String responseCode = simplifiedLoginInit.getResponseCode();
                                    if (responseCode != null) {
                                        int hashCode = responseCode.hashCode();
                                        if (hashCode != 1537) {
                                            if (hashCode != 54399) {
                                                if (hashCode == 2080801056 && responseCode.equals("FP_115")) {
                                                    String message = simplifiedLoginInit.getMessage();
                                                    k.a((Object) message, "model.message");
                                                    String responseCode2 = simplifiedLoginInit.getResponseCode();
                                                    k.a((Object) responseCode2, "model.responseCode");
                                                    ForgotEnterNumberFragment.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(forgotEnterNumberFragment2.b(), message, SDKConstants.KEY_API, responseCode2));
                                                    OAuthUtils.a(forgotEnterNumberFragment2.getFragmentManager(), forgotEnterNumberFragment2.d());
                                                    return;
                                                }
                                            } else if (responseCode.equals("708")) {
                                                forgotEnterNumberFragment2.b(0);
                                                return;
                                            }
                                        } else if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                                            ForgotEnterNumberFragment.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(forgotEnterNumberFragment2.b()));
                                            ak.a a2 = ak.a();
                                            k.a((Object) a2, "ForgotEnterNumberFragmen…tions.navActionEnterOtp()");
                                            a2.a(str2);
                                            String stateToken = simplifiedLoginInit.getStateToken();
                                            if (stateToken == null) {
                                                stateToken = "";
                                            }
                                            a2.b(stateToken);
                                            androidx.navigation.fragment.a.a(forgotEnterNumberFragment2).a((androidx.navigation.l) a2);
                                            return;
                                        }
                                    }
                                    com.paytm.utility.b.b(forgotEnterNumberFragment2.requireContext(), forgotEnterNumberFragment2.getString(R.string.oauth_error), simplifiedLoginInit.getMessage());
                                }
                            }
                        }
                    }
                });
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
            if (!((Boolean) obj).booleanValue()) {
                if (this.this$0.isVisible()) {
                    net.one97.paytm.oauth.d.a.a(this.this$0.requireContext(), this.this$0.getString(R.string.some_went_wrong), (View.OnClickListener) AnonymousClass1.f56120a);
                }
                return x.f47997a;
            }
            ForgotEnterNumberFragment.b(this.this$0);
            Context requireContext2 = this.this$0.requireContext();
            k.a((Object) requireContext2, "requireContext()");
            net.one97.paytm.oauth.g.d.a(requireContext2, this.$mobileNo, "OTP").observe(this.this$0.getViewLifecycleOwner(), new z<net.one97.paytm.oauth.e<IJRPaytmDataModel>>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f56121a;

                {
                    this.f56121a = r1;
                }

                public final /* synthetic */ void onChanged(Object obj) {
                    net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
                    if (eVar != null) {
                        ProgressViewButton progressViewButton = (ProgressViewButton) this.f56121a.this$0.a(R.id.btnProceedSecurely);
                        if (progressViewButton != null) {
                            progressViewButton.d();
                        }
                        if (eVar.f52602a != 101) {
                            T t = eVar.f52603b;
                            if (t != null) {
                                ErrorModel errorModel = (ErrorModel) t;
                                ForgotEnterNumberFragment forgotEnterNumberFragment = this.f56121a.this$0;
                                String str = this.f56121a.$mobileNo;
                                k.c(errorModel, "model");
                                k.c(str, "mobileNo");
                                if (OAuthUtils.a((Activity) forgotEnterNumberFragment.getActivity(), (Fragment) forgotEnterNumberFragment, errorModel.getCustomError())) {
                                    return;
                                }
                                if (net.one97.paytm.oauth.utils.l.a(errorModel)) {
                                    forgotEnterNumberFragment.a(str);
                                } else if (errorModel.getStatus() == -1) {
                                    String string = forgotEnterNumberFragment.getString(R.string.no_connection);
                                    k.a((Object) string, "getString(R.string.no_connection)");
                                    String string2 = forgotEnterNumberFragment.getString(R.string.no_internet);
                                    k.a((Object) string2, "getString(R.string.no_internet)");
                                    OAuthUtils.a(forgotEnterNumberFragment.requireContext(), string, string2, new e(forgotEnterNumberFragment));
                                } else {
                                    if (errorModel.getCustomError() instanceof NetworkCustomError) {
                                        byte[] bArr = errorModel.getCustomError().networkResponse.data;
                                        if (bArr != null) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(new String(bArr, kotlin.m.d.f47971a));
                                                String string3 = jSONObject.getString("message");
                                                String string4 = jSONObject.getString("responseCode");
                                                k.a((Object) string3, "message");
                                                k.a((Object) string4, "responseCode");
                                                ForgotEnterNumberFragment.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(forgotEnterNumberFragment.b(), string3, SDKConstants.KEY_API, string4));
                                                int status = errorModel.getStatus();
                                                Integer num = n.f56784c;
                                                if (num != null) {
                                                    if (status == num.intValue() && k.a((Object) "BE1423003", (Object) string4)) {
                                                        forgotEnterNumberFragment.a(str);
                                                        return;
                                                    }
                                                }
                                                com.paytm.utility.b.b(forgotEnterNumberFragment.requireContext(), forgotEnterNumberFragment.getString(R.string.oauth_error), string3);
                                                return;
                                            } catch (JSONException unused) {
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                    com.paytm.utility.b.b(forgotEnterNumberFragment.requireContext(), forgotEnterNumberFragment.getString(R.string.oauth_error), forgotEnterNumberFragment.getString(R.string.some_went_wrong));
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                            }
                        } else {
                            ForgotEnterNumberFragment forgotEnterNumberFragment2 = this.f56121a.this$0;
                            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
                            String str2 = this.f56121a.$mobileNo;
                            k.c(str2, "mobileNo");
                            if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
                                SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
                                String responseCode = simplifiedLoginInit.getResponseCode();
                                if (responseCode != null) {
                                    int hashCode = responseCode.hashCode();
                                    if (hashCode != 1537) {
                                        if (hashCode != 54399) {
                                            if (hashCode == 2080801056 && responseCode.equals("FP_115")) {
                                                String message = simplifiedLoginInit.getMessage();
                                                k.a((Object) message, "model.message");
                                                String responseCode2 = simplifiedLoginInit.getResponseCode();
                                                k.a((Object) responseCode2, "model.responseCode");
                                                ForgotEnterNumberFragment.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(forgotEnterNumberFragment2.b(), message, SDKConstants.KEY_API, responseCode2));
                                                OAuthUtils.a(forgotEnterNumberFragment2.getFragmentManager(), forgotEnterNumberFragment2.d());
                                                return;
                                            }
                                        } else if (responseCode.equals("708")) {
                                            forgotEnterNumberFragment2.b(0);
                                            return;
                                        }
                                    } else if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                                        ForgotEnterNumberFragment.a(Events.Action.PROCEED_CLICKED, kotlin.a.k.d(forgotEnterNumberFragment2.b()));
                                        ak.a a2 = ak.a();
                                        k.a((Object) a2, "ForgotEnterNumberFragmen…tions.navActionEnterOtp()");
                                        a2.a(str2);
                                        String stateToken = simplifiedLoginInit.getStateToken();
                                        if (stateToken == null) {
                                            stateToken = "";
                                        }
                                        a2.b(stateToken);
                                        androidx.navigation.fragment.a.a(forgotEnterNumberFragment2).a((androidx.navigation.l) a2);
                                        return;
                                    }
                                }
                                com.paytm.utility.b.b(forgotEnterNumberFragment2.requireContext(), forgotEnterNumberFragment2.getString(R.string.oauth_error), simplifiedLoginInit.getMessage());
                            }
                        }
                    }
                }
            });
            return x.f47997a;
        }
    }

    @kotlin.d.b.a.f(b = "ForgotEnterNumberFragment.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.ForgotEnterNumberFragment$generatePublicPrivateKey$isSuccess$1")
    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super Boolean>, Object> {
        final /* synthetic */ String $mobile;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.$mobile = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.$mobile, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                o oVar = o.f56791a;
                return Boolean.valueOf(o.a(this.$mobile));
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }
}
