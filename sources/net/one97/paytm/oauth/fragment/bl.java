package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.u;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.az;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.models.DeviceBindingStausResModel;
import net.one97.paytm.oauth.models.DeviceStatusData;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.oauth.view.ProgressViewButton;
import org.json.JSONException;
import org.json.JSONObject;

public final class bl extends x implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final a f56466c = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.oauth.e.d f56467a;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.oauth.g.h f56468d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f56469e;

    /* renamed from: f  reason: collision with root package name */
    private String f56470f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.oauth.utils.b f56471g;

    /* renamed from: h  reason: collision with root package name */
    private String f56472h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f56473i;
    private boolean j;
    private boolean k;
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

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56474a;

        b(bl blVar) {
            this.f56474a = blVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            kotlin.g.b.k.c(eVar, Payload.RESPONSE);
            if (eVar.f52602a == 101) {
                this.f56474a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            } else if (eVar.f52602a == 102) {
                this.f56474a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56475a;

        c(bl blVar) {
            this.f56475a = blVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            kotlin.g.b.k.c(eVar, Payload.RESPONSE);
            if (eVar.f52602a == 101) {
                this.f56475a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            } else if (eVar.f52602a == 102) {
                this.f56475a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56476a;

        d(bl blVar) {
            this.f56476a = blVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            kotlin.g.b.k.c(eVar, Payload.RESPONSE);
            if (eVar.f52602a == 101) {
                this.f56476a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            } else if (eVar.f52602a == 102) {
                this.f56476a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56477a;

        e(bl blVar) {
            this.f56477a = blVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                int i2 = eVar.f52602a;
                if (i2 == 101) {
                    this.f56477a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
                } else if (i2 == 102) {
                    this.f56477a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
                }
            }
        }
    }

    static final class f<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56478a;

        f(bl blVar) {
            this.f56478a = blVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            this.f56478a.a(false);
            if (eVar != null) {
                int i2 = eVar.f52602a;
                if (i2 == 101) {
                    this.f56478a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
                } else if (i2 == 102) {
                    this.f56478a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.oauth.e.d c(bl blVar) {
        net.one97.paytm.oauth.e.d dVar = blVar.f56467a;
        if (dVar == null) {
            kotlin.g.b.k.a("sessionContainerListener");
        }
        return dVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dialog_session_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        b("otp_popup_loaded", kotlin.a.k.d(c()));
        Bundle arguments = getArguments();
        this.k = arguments != null ? arguments.getBoolean("isfromSignup", false) : false;
        Bundle arguments2 = getArguments();
        this.f56470f = arguments2 != null ? arguments2.getString("login_state_token") : null;
        Bundle arguments3 = getArguments();
        this.j = arguments3 != null ? arguments3.getBoolean("is_device_binding") : false;
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.h.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…OTPViewModel::class.java)");
        this.f56468d = (net.one97.paytm.oauth.g.h) a2;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str = arguments4.getString("login_mobile")) == null) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
            str = com.paytm.utility.b.ab(b2.getApplicationContext());
        }
        this.f56472h = str;
        Bundle arguments5 = getArguments();
        Serializable serializable = arguments5 != null ? arguments5.getSerializable("auth_flow") : null;
        if (!(serializable instanceof net.one97.paytm.oauth.utils.b)) {
            serializable = null;
        }
        this.f56471g = (net.one97.paytm.oauth.utils.b) serializable;
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.a();
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton2 != null) {
            progressViewButton2.setButtonText(getString(R.string.lbl_login_securely));
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.tvMobileNumber);
        if (roboTextView != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.lbl_verify_mobile);
            kotlin.g.b.k.a((Object) string, "getString(R.string.lbl_verify_mobile)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.f56472h}, 1));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView.setText(format);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tvLoginDiffAccount);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.resend_otp);
        if (roboTextView3 != null) {
            roboTextView3.setOnClickListener(this);
        }
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtpTextChangeListener(new j(this));
        }
    }

    public final void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    public static final class j implements OtpView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56483a;

        j(bl blVar) {
            this.f56483a = blVar;
        }

        public final void a(Editable editable, boolean z) {
            kotlin.g.b.k.c(editable, "s");
            RoboTextView roboTextView = (RoboTextView) this.f56483a.a(R.id.error_text_otp);
            kotlin.g.b.k.a((Object) roboTextView, "error_text_otp");
            roboTextView.setVisibility(8);
            if (z) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56483a.a(R.id.btnProceedSecurely);
                if (progressViewButton != null) {
                    progressViewButton.b();
                }
                ProgressViewButton progressViewButton2 = (ProgressViewButton) this.f56483a.a(R.id.btnProceedSecurely);
                if (progressViewButton2 != null) {
                    progressViewButton2.setOnClickListener(this.f56483a);
                    return;
                }
                return;
            }
            ProgressViewButton progressViewButton3 = (ProgressViewButton) this.f56483a.a(R.id.btnProceedSecurely);
            if (progressViewButton3 != null) {
                progressViewButton3.a();
            }
            ProgressViewButton progressViewButton4 = (ProgressViewButton) this.f56483a.a(R.id.btnProceedSecurely);
            if (progressViewButton4 != null) {
                progressViewButton4.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public final void onClick(View view) {
        ProgressViewButton progressViewButton;
        String str;
        Bundle arguments;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tvLoginDiffAccount;
        boolean z = false;
        if (valueOf != null && valueOf.intValue() == i2) {
            b("login_to_a_diff_account", new ArrayList());
            com.paytm.utility.b.n(requireContext(), "");
            Bundle bundle = new Bundle();
            bundle.putSerializable("auth_flow", this.f56471g);
            bundle.putBoolean("is_from_session_expiry", false);
            bundle.putString(p.f56797b, "/session-expiry-otp-prompt");
            net.one97.paytm.oauth.e.d dVar = this.f56467a;
            if (dVar == null) {
                kotlin.g.b.k.a("sessionContainerListener");
            }
            dVar.g(bundle);
            return;
        }
        int i3 = R.id.imgCross;
        String str2 = "otp";
        if (valueOf != null && valueOf.intValue() == i3) {
            b("popup_discarded", kotlin.a.k.d(str2));
            net.one97.paytm.oauth.e.d dVar2 = this.f56467a;
            if (dVar2 == null) {
                kotlin.g.b.k.a("sessionContainerListener");
            }
            dVar2.b();
            if (this.f56471g == net.one97.paytm.oauth.utils.b.SESSION_EXPIRY && (arguments = getArguments()) != null && !arguments.getBoolean("close_pop_up")) {
                OauthModule.b().signOutAndLogin(getActivity(), true, OAuthUtils.b.SESSION_TIME_OUT);
                return;
            }
            return;
        }
        int i4 = R.id.resend_otp;
        if (valueOf != null && valueOf.intValue() == i4) {
            b("resend_otp_clicked", new ArrayList());
            q a2 = getChildFragmentManager().a();
            kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
            az.a aVar = az.f56394a;
            az a3 = az.a.a(false);
            b("resend_popup_loaded", new ArrayList());
            a3.a((az.b) new k(this, a3));
            a2.a((Fragment) a3, az.class.getName());
            a2.c();
            return;
        }
        int i5 = R.id.btnProceedSecurely;
        if (valueOf != null && valueOf.intValue() == i5 && (progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely)) != null && !progressViewButton.f56843a) {
            OAuthUtils.a((Activity) getActivity());
            this.f56473i = false;
            if (isVisible()) {
                OtpView otpView = (OtpView) a(R.id.otpContainer);
                if (otpView == null || (str = otpView.getOtp()) == null) {
                    str = "";
                }
                String d2 = d(str);
                CharSequence charSequence = d2;
                if (TextUtils.isEmpty(charSequence)) {
                    z = true;
                } else {
                    String[] strArr = new String[3];
                    if (this.f56473i) {
                        str2 = "auto_otp";
                    }
                    strArr[0] = str2;
                    strArr[1] = d2;
                    strArr[2] = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
                    b("login_securely_clicked", kotlin.a.k.d(strArr));
                    RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                    kotlin.g.b.k.a((Object) roboTextView, "error_text_otp");
                    roboTextView.setVisibility(0);
                    RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                    kotlin.g.b.k.a((Object) roboTextView2, "error_text_otp");
                    roboTextView2.setText(charSequence);
                    this.f56473i = false;
                }
            }
            if (z) {
                d();
            }
        }
    }

    public static final class k implements az.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ az f56485b;

        k(bl blVar, az azVar) {
            this.f56484a = blVar;
            this.f56485b = azVar;
        }

        public final void onOptionSelected(boolean z) {
            this.f56484a.f56469e = z;
            this.f56484a.g();
            bl.b(z ? "resend_otp_call" : "resend_otp_sms", new ArrayList());
            this.f56485b.dismissAllowingStateLoss();
        }
    }

    private final void d() {
        if (this.j) {
            f();
        } else {
            e();
        }
    }

    private final void e() {
        String str;
        a(true);
        net.one97.paytm.oauth.g.h hVar = this.f56468d;
        if (hVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        Context activity = getActivity();
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView == null || (str = otpView.getOtp()) == null) {
            str = "";
        }
        hVar.a(activity, str, this.f56470f).observe(this, new f(this));
    }

    private final void f() {
        String str;
        if (isVisible()) {
            a(true);
            net.one97.paytm.oauth.g.h hVar = this.f56468d;
            if (hVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            OtpView otpView = (OtpView) a(R.id.otpContainer);
            if (otpView == null || (str = otpView.getOtp()) == null) {
                str = "";
            }
            hVar.a(str, this.f56470f, this.f56472h).observe(this, new b(this));
        }
    }

    /* access modifiers changed from: private */
    public final void g() {
        if (this.j) {
            net.one97.paytm.oauth.g.h hVar = this.f56468d;
            if (hVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            hVar.a(this.f56470f, this.f56469e).observe(this, new d(this));
            return;
        }
        net.one97.paytm.oauth.g.h hVar2 = this.f56468d;
        if (hVar2 == null) {
            kotlin.g.b.k.a("viewModel");
        }
        hVar2.a((Context) getActivity(), this.f56470f, this.f56469e).observe(this, new e(this));
    }

    public final void a(ErrorModel errorModel, Throwable th, String str) {
        Activity activity = getActivity();
        Fragment fragment = this;
        if (th != null) {
            NetworkCustomError networkCustomError = (NetworkCustomError) th;
            if (!OAuthUtils.a(activity, fragment, networkCustomError)) {
                if (l.a(errorModel)) {
                    net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
                } else if (errorModel == null || errorModel.getStatus() != -1) {
                    if (kotlin.g.b.k.a((Object) errorModel != null ? Integer.valueOf(errorModel.getStatus()) : null, (Object) n.f56789h)) {
                        Bundle bundle = new Bundle(getArguments());
                        bundle.putBoolean("is_from_session_expiry", false);
                        net.one97.paytm.oauth.e.d dVar = this.f56467a;
                        if (dVar == null) {
                            kotlin.g.b.k.a("sessionContainerListener");
                        }
                        dVar.g(bundle);
                        Toast.makeText(requireContext(), getString(R.string.lbl_session_expired_proceed_again), 1).show();
                        return;
                    }
                    if (kotlin.g.b.k.a((Object) errorModel != null ? Integer.valueOf(errorModel.getStatus()) : null, (Object) n.f56788g)) {
                        byte[] bArr = networkCustomError.networkResponse.data;
                        kotlin.g.b.k.a((Object) bArr, "throwable.networkResponse.data");
                        String str2 = new String(bArr, kotlin.m.d.f47971a);
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                net.one97.paytm.oauth.d.a.a(requireContext(), new JSONObject(str2).getString("message"), (View.OnClickListener) null);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
                    }
                } else {
                    String string = getString(R.string.no_connection);
                    kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                    String string2 = getString(R.string.no_internet);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.no_internet)");
                    OAuthUtils.a(getActivity(), string, string2, new g(this, str));
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
        }
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56479a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56480b;

        g(bl blVar, String str) {
            this.f56479a = blVar;
            this.f56480b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56479a.b(this.f56480b);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        String str2 = str;
        String str3 = "auto_otp";
        if (iJRPaytmDataModel2 instanceof SimplifiedLoginInit) {
            if (kotlin.g.b.k.a((Object) "oauthSimpleResendOtpSv1", (Object) str2)) {
                SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel2;
                a(simplifiedLoginInit.getResponseCode(), simplifiedLoginInit.getMessage(), simplifiedLoginInit.getStateToken());
            } else if (kotlin.g.b.k.a((Object) "oauthValidateOtpSv1", (Object) str2)) {
                SimplifiedLoginInit simplifiedLoginInit2 = (SimplifiedLoginInit) iJRPaytmDataModel2;
                String responseCode = simplifiedLoginInit2.getResponseCode();
                if (responseCode != null) {
                    int hashCode = responseCode.hashCode();
                    if (hashCode != 1537) {
                        if (hashCode != 1567008) {
                            if (hashCode == 1567012 && responseCode.equals("3007")) {
                                net.one97.paytm.oauth.d.a.a(requireContext(), simplifiedLoginInit2.getMessage(), (View.OnClickListener) new i(this));
                                return;
                            }
                        } else if (responseCode.equals("3003")) {
                            String[] strArr = new String[1];
                            if (!this.f56473i) {
                                str3 = "otp";
                            }
                            strArr[0] = str3;
                            b("login_securely_clicked", kotlin.a.k.d(strArr));
                            Bundle bundle = new Bundle();
                            bundle.putString("screen_name", "FRAGMENT_ACCOUNT_CLAIM");
                            bundle.putString("login_state_token", simplifiedLoginInit2.getStateToken());
                            bundle.putString("login_mobile", this.f56472h);
                            OauthModule.b().launchAJRAuthActivity(getContext(), bundle);
                            net.one97.paytm.oauth.e.d dVar = this.f56467a;
                            if (dVar == null) {
                                kotlin.g.b.k.a("sessionContainerListener");
                            }
                            dVar.b();
                            return;
                        }
                    } else if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        net.one97.paytm.oauth.e.d dVar2 = this.f56467a;
                        if (dVar2 == null) {
                            kotlin.g.b.k.a("sessionContainerListener");
                        }
                        String oauthCode = simplifiedLoginInit2.getOauthCode();
                        if (oauthCode == null) {
                            oauthCode = "";
                        }
                        dVar2.a(oauthCode, this.f56472h, this.k);
                        String[] strArr2 = new String[1];
                        if (!this.f56473i) {
                            str3 = "otp";
                        }
                        strArr2[0] = str3;
                        b("login_securely_clicked", kotlin.a.k.d(strArr2));
                        return;
                    }
                }
                if (!TextUtils.isEmpty(simplifiedLoginInit2.getMessage())) {
                    String message = simplifiedLoginInit2.getMessage();
                    kotlin.g.b.k.a((Object) message, "model.message");
                    RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                    kotlin.g.b.k.a((Object) roboTextView, "error_text_otp");
                    roboTextView.setVisibility(0);
                    RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                    kotlin.g.b.k.a((Object) roboTextView2, "error_text_otp");
                    roboTextView2.setText(message);
                    String[] strArr3 = new String[4];
                    if (!this.f56473i) {
                        str3 = "otp";
                    }
                    strArr3[0] = str3;
                    strArr3[1] = message;
                    strArr3[2] = SDKConstants.KEY_API;
                    String responseCode2 = simplifiedLoginInit2.getResponseCode();
                    kotlin.g.b.k.a((Object) responseCode2, "model.responseCode");
                    strArr3[3] = responseCode2;
                    b("login_securely_clicked", kotlin.a.k.d(strArr3));
                    return;
                }
                String[] strArr4 = new String[4];
                if (!this.f56473i) {
                    str3 = "otp";
                }
                strArr4[0] = str3;
                String string = getString(R.string.some_went_wrong);
                kotlin.g.b.k.a((Object) string, "getString(R.string.some_went_wrong)");
                strArr4[1] = string;
                strArr4[2] = SDKConstants.KEY_API;
                String responseCode3 = simplifiedLoginInit2.getResponseCode();
                kotlin.g.b.k.a((Object) responseCode3, "model.responseCode");
                strArr4[3] = responseCode3;
                b("login_securely_clicked", kotlin.a.k.d(strArr4));
                com.paytm.utility.b.b((Context) getActivity(), (String) null, getString(R.string.some_went_wrong));
            } else if (kotlin.g.b.k.a((Object) "oauthdevicebindingConfirmSv1", (Object) str2)) {
                SimplifiedLoginInit simplifiedLoginInit3 = (SimplifiedLoginInit) iJRPaytmDataModel2;
                if (!kotlin.g.b.k.a((Object) "BE1400001", (Object) simplifiedLoginInit3.getResponseCode())) {
                    a(false);
                    OtpView otpView = (OtpView) a(R.id.otpContainer);
                    if (otpView != null) {
                        otpView.a();
                    }
                    if (!TextUtils.isEmpty(simplifiedLoginInit3.getMessage())) {
                        String message2 = simplifiedLoginInit3.getMessage();
                        kotlin.g.b.k.a((Object) message2, "model.message");
                        RoboTextView roboTextView3 = (RoboTextView) a(R.id.error_text_otp);
                        kotlin.g.b.k.a((Object) roboTextView3, "error_text_otp");
                        roboTextView3.setVisibility(0);
                        RoboTextView roboTextView4 = (RoboTextView) a(R.id.error_text_otp);
                        kotlin.g.b.k.a((Object) roboTextView4, "error_text_otp");
                        roboTextView4.setText(message2);
                        String[] strArr5 = new String[4];
                        if (!this.f56473i) {
                            str3 = "otp";
                        }
                        strArr5[0] = str3;
                        strArr5[1] = message2;
                        strArr5[2] = SDKConstants.KEY_API;
                        String responseCode4 = simplifiedLoginInit3.getResponseCode();
                        kotlin.g.b.k.a((Object) responseCode4, "model.responseCode");
                        strArr5[3] = responseCode4;
                        b("login_securely_clicked", kotlin.a.k.d(strArr5));
                        return;
                    }
                    String[] strArr6 = new String[4];
                    if (!this.f56473i) {
                        str3 = "otp";
                    }
                    strArr6[0] = str3;
                    String string2 = getString(R.string.some_went_wrong);
                    kotlin.g.b.k.a((Object) string2, "getString(R.string.some_went_wrong)");
                    strArr6[1] = string2;
                    strArr6[2] = SDKConstants.KEY_API;
                    String responseCode5 = simplifiedLoginInit3.getResponseCode();
                    kotlin.g.b.k.a((Object) responseCode5, "model.responseCode");
                    strArr6[3] = responseCode5;
                    b("login_securely_clicked", kotlin.a.k.d(strArr6));
                    com.paytm.utility.b.b((Context) getActivity(), (String) null, getString(R.string.some_went_wrong));
                } else if (isVisible()) {
                    a(true);
                    net.one97.paytm.oauth.g.h hVar = this.f56468d;
                    if (hVar == null) {
                        kotlin.g.b.k.a("viewModel");
                    }
                    hVar.a(this.f56470f).observe(this, new c(this));
                }
            }
        } else if (iJRPaytmDataModel2 instanceof DeviceBindingStausResModel) {
            DeviceBindingStausResModel deviceBindingStausResModel = (DeviceBindingStausResModel) iJRPaytmDataModel2;
            if (kotlin.g.b.k.a((Object) "BE1400001", (Object) deviceBindingStausResModel.getResponseCode())) {
                DeviceStatusData data = deviceBindingStausResModel.getData();
                String deviceBindingStatus = data != null ? data.getDeviceBindingStatus() : null;
                if (deviceBindingStatus != null) {
                    int hashCode2 = deviceBindingStatus.hashCode();
                    if (hashCode2 != -1809526922) {
                        if (hashCode2 == 1982485311 && deviceBindingStatus.equals("CONFIRMED")) {
                            net.one97.paytm.oauth.e.d dVar3 = this.f56467a;
                            if (dVar3 == null) {
                                kotlin.g.b.k.a("sessionContainerListener");
                            }
                            String str4 = this.f56472h;
                            String str5 = this.f56470f;
                            boolean z = this.k;
                            dVar3.a(str4, str5, z, z ? net.one97.paytm.oauth.utils.i.SIGNUP : net.one97.paytm.oauth.utils.i.LOGIN);
                            String[] strArr7 = new String[1];
                            if (!this.f56473i) {
                                str3 = "otp";
                            }
                            strArr7[0] = str3;
                            b("login_securely_clicked", kotlin.a.k.d(strArr7));
                            return;
                        }
                    } else if (deviceBindingStatus.equals("CLAIMABLE")) {
                        String[] strArr8 = new String[1];
                        if (!this.f56473i) {
                            str3 = "otp";
                        }
                        strArr8[0] = str3;
                        b("login_securely_clicked", kotlin.a.k.d(strArr8));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("screen_name", "FRAGMENT_ACCOUNT_CLAIM");
                        bundle2.putString("login_state_token", this.f56470f);
                        bundle2.putString("login_mobile", this.f56472h);
                        OauthModule.b().launchAJRAuthActivity(getContext(), bundle2);
                        net.one97.paytm.oauth.e.d dVar4 = this.f56467a;
                        if (dVar4 == null) {
                            kotlin.g.b.k.a("sessionContainerListener");
                        }
                        dVar4.b();
                        return;
                    }
                }
                a(false);
                net.one97.paytm.oauth.d.a.a(getContext(), deviceBindingStausResModel.getMessage(), (View.OnClickListener) null);
                return;
            }
            net.one97.paytm.oauth.d.a.a(getContext(), deviceBindingStausResModel.getMessage(), (View.OnClickListener) null);
        } else if (iJRPaytmDataModel2 instanceof UpdatePhoneResModel) {
            UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel2;
            a(updatePhoneResModel.getResponseCode(), updatePhoneResModel.getMessage(), updatePhoneResModel.getState());
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56482a;

        i(bl blVar) {
            this.f56482a = blVar;
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle(this.f56482a.getArguments());
            bundle.putBoolean("is_from_session_expiry", false);
            bundle.putString(p.f56797b, "/session-expiry-otp-prompt");
            bl.c(this.f56482a).g(bundle);
        }
    }

    /* access modifiers changed from: private */
    public static void b(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "session_expiry_prompt", str, arrayList, (String) null, "/session-expiry-otp-prompt", p.f56796a);
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        if (z) {
            ((ProgressViewButton) a(R.id.btnProceedSecurely)).c();
            View a2 = a(R.id.blockView);
            kotlin.g.b.k.a((Object) a2, "blockView");
            net.one97.paytm.oauth.utils.h.a(a2);
            return;
        }
        ((ProgressViewButton) a(R.id.btnProceedSecurely)).d();
        View a3 = a(R.id.blockView);
        kotlin.g.b.k.a((Object) a3, "blockView");
        net.one97.paytm.oauth.utils.h.b(a3);
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        kotlin.g.b.k.c(str, "otp");
        this.f56473i = true;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtp(str);
        }
        d();
    }

    private final void a(String str, String str2, String str3) {
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.a();
        }
        if (kotlin.g.b.k.a((Object) WebLogin.RESPONSE_CODE_SUCCESS, (Object) str)) {
            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "getInstance()");
            long b2 = ((long) net.one97.paytm.oauth.a.b()) * 1000;
            if (this.f56469e) {
                kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "getInstance()");
                b2 = ((long) net.one97.paytm.oauth.a.c()) * 1000;
            }
            this.f56656b = b2;
            b();
            if (!TextUtils.isEmpty(str3)) {
                this.f56470f = str3;
            }
        } else if (kotlin.g.b.k.a((Object) "708", (Object) str)) {
            net.one97.paytm.oauth.d.a.a(requireContext(), str2, (View.OnClickListener) new h(this));
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.some_went_wrong);
            }
            net.one97.paytm.oauth.d.a.a(requireContext(), str2, (View.OnClickListener) null);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bl f56481a;

        h(bl blVar) {
            this.f56481a = blVar;
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle(this.f56481a.getArguments());
            bundle.putBoolean("is_from_session_expiry", false);
            bundle.putString(p.f56797b, "/session-expiry-otp-prompt");
            bl.c(this.f56481a).g(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j2) {
        kotlin.g.b.k.c(aVar, "state");
        int i2 = bm.f56486a[aVar.ordinal()];
        if (i2 == 1) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView != null) {
                roboTextView.setVisibility(0);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.resend_otp);
            if (roboTextView2 != null) {
                roboTextView2.setVisibility(8);
            }
        } else if (i2 == 2) {
            String string = getString(R.string.lbl_resend_otp_in_seconds, Long.valueOf(j2 / 1000));
            kotlin.g.b.k.a((Object) string, "getString(R.string.lbl_r…llisUntilFinished / 1000)");
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView3 != null) {
                roboTextView3.setText(string);
            }
        } else if (i2 == 3) {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView4 != null) {
                roboTextView4.setVisibility(8);
            }
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.resend_otp);
            if (roboTextView5 != null) {
                roboTextView5.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -422762960:
                    if (str.equals("oauthValidateOtpSv1")) {
                        e();
                        return;
                    }
                    return;
                case -183116971:
                    if (!str.equals("OauthResendOTPSV1")) {
                        return;
                    }
                    break;
                case 629923750:
                    if (str.equals("oauthdevicebindingConfirmSv1")) {
                        f();
                        return;
                    }
                    return;
                case 1126981863:
                    if (!str.equals("oauthSimpleResendOtpSv1")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            g();
        }
    }
}
