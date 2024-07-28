package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.cd;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public final class VerifyPhoneOtpFragment extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56244a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private String f56245c;

    /* renamed from: d  reason: collision with root package name */
    private String f56246d;

    /* renamed from: e  reason: collision with root package name */
    private String f56247e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.oauth.g.j f56248f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f56249g;

    /* renamed from: h  reason: collision with root package name */
    private final String f56250h = "VerifyPhoneOtpFragment";

    /* renamed from: i  reason: collision with root package name */
    private HashMap f56251i;

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final g f56258a = new g();

        g() {
        }

        public final void onClick(View view) {
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final i f56260a = new i();

        i() {
        }

        public final void onClick(View view) {
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final j f56261a = new j();

        j() {
        }

        public final void onClick(View view) {
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final k f56262a = new k();

        k() {
        }

        public final void onClick(View view) {
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final l f56263a = new l();

        l() {
        }

        public final void onClick(View view) {
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final s f56270a = new s();

        s() {
        }

        public final void onClick(View view) {
        }
    }

    static final class t implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final t f56271a = new t();

        t() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.f56251i == null) {
            this.f56251i = new HashMap();
        }
        View view = (View) this.f56251i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56251i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56251i;
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
        final /* synthetic */ VerifyPhoneOtpFragment f56252a;

        b(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56252a = verifyPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56252a.a(R.id.btnConfirm);
            if (progressViewButton != null) {
                progressViewButton.d();
            }
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                T t = eVar.f52603b;
                if (t != null) {
                    this.f56252a.b((ErrorModel) t, eVar.f52605d);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
            }
            this.f56252a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56253a;

        c(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56253a = verifyPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                T t = eVar.f52603b;
                if (t != null) {
                    this.f56253a.b((ErrorModel) t, eVar.f52605d);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
            }
            this.f56253a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56254a;

        d(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56254a = verifyPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56254a.a(R.id.btnConfirm);
            if (progressViewButton != null) {
                progressViewButton.d();
            }
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                T t = eVar.f52603b;
                if (t != null) {
                    this.f56254a.b((ErrorModel) t, eVar.f52605d);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
            }
            this.f56254a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        }
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
        return layoutInflater.inflate(R.layout.fragment_verify_number_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        String str = null;
        this.f56246d = arguments != null ? arguments.getString("mobile") : null;
        Bundle arguments2 = getArguments();
        this.f56247e = arguments2 != null ? arguments2.getString(AppConstants.KEY_EMAIL) : null;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str = arguments3.getString("stateToken");
        }
        this.f56245c = str;
        RoboTextView roboTextView = (RoboTextView) a(R.id.lblDesc);
        kotlin.g.b.k.a((Object) roboTextView, "lblDesc");
        aa aaVar = aa.f47921a;
        String string = getString(R.string.lbl_verify_your_registered_mobile_number);
        kotlin.g.b.k.a((Object) string, "getString(R.string.lbl_v…registered_mobile_number)");
        String format = String.format(string, Arrays.copyOf(new Object[]{OAuthUtils.e(this.f56246d)}, 1));
        kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
        roboTextView.setText(format);
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.btn_confirm));
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.resendOtp);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtpTextChangeListener(new u(this));
        }
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.j.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ailViewModel::class.java)");
        this.f56248f = (net.one97.paytm.oauth.g.j) a2;
        x.a((x) this, false, 7);
        a("phone_otp_for_add_email_page_loaded", (ArrayList<String>) kotlin.a.k.d(c()));
    }

    public final void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    public static final class u implements OtpView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56272a;

        u(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56272a = verifyPhoneOtpFragment;
        }

        public final void a(Editable editable, boolean z) {
            kotlin.g.b.k.c(editable, "s");
            RoboTextView roboTextView = (RoboTextView) this.f56272a.a(R.id.error_text_otp);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.resendOtp;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("resend_otp_sms", (ArrayList<String>) new ArrayList());
            d();
            return;
        }
        int i3 = R.id.btnConfirm;
        if (valueOf != null && valueOf.intValue() == i3) {
            e();
        }
    }

    private final void d() {
        OAuthUtils.a((Activity) requireActivity());
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56248f == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.oauth.g.j.a(this.f56245c).observe(this, new b(this));
    }

    private final void e() {
        String otp;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null && (otp = otpView.getOtp()) != null) {
            String d2 = d(otp);
            CharSequence charSequence = d2;
            if (!TextUtils.isEmpty(charSequence)) {
                a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d("phone_otp", d2, AppManagerUtil.EXTEND_PREFIX_DEFAULT));
                RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                kotlin.g.b.k.a((Object) roboTextView, "error_text_otp");
                roboTextView.setVisibility(0);
                RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                kotlin.g.b.k.a((Object) roboTextView2, "error_text_otp");
                roboTextView2.setText(charSequence);
                return;
            }
            OAuthUtils.a((Activity) requireActivity());
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            if (this.f56248f == null) {
                kotlin.g.b.k.a("viewModel");
            }
            String str = this.f56245c;
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
            net.one97.paytm.oauth.g.j.a(otp, str, b2.getSSOToken()).observe(this, new d(this));
        }
    }

    private final void f() {
        if (this.f56248f == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.oauth.g.j.b(this.f56245c, this.f56247e).observe(this, new c(this));
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        String str2 = str;
        if (iJRPaytmDataModel2 instanceof UpdatePhoneResModel) {
            UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel2;
            String responseCode = updatePhoneResModel.getResponseCode();
            String str3 = "";
            String str4 = "auto_otp";
            if (responseCode != null) {
                switch (responseCode.hashCode()) {
                    case -1260518837:
                        if (responseCode.equals("BE1400001")) {
                            if (str2 != null && str.hashCode() == -1984296405 && str2.equals("OauthsendOTPUserEmailV4SV1")) {
                                this.f56245c = updatePhoneResModel.getState();
                                cd.a a2 = cd.a();
                                kotlin.g.b.k.a((Object) a2, "VerifyPhoneOtpFragmentDi….navActionEmailEnterOtp()");
                                a2.b(this.f56247e);
                                a2.c("/phone_otp_for_add_email");
                                a2.a(updatePhoneResModel.getState());
                                androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) a2);
                                return;
                            }
                            return;
                        }
                        break;
                    case -1258552630:
                        if (responseCode.equals("BE1424002")) {
                            if (str2 != null && str.hashCode() == -1984296405 && str2.equals("OauthsendOTPUserEmailV4SV1")) {
                                net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new q(this));
                                return;
                            }
                            return;
                        }
                        break;
                    case -1258552629:
                        if (responseCode.equals("BE1424003")) {
                            if (str2 != null && str.hashCode() == -1984296405 && str2.equals("OauthsendOTPUserEmailV4SV1")) {
                                net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new p(this));
                                return;
                            }
                            return;
                        }
                        break;
                    case -1258522837:
                        if (responseCode.equals("BE1425004")) {
                            if (str2 != null && str.hashCode() == -1984296405 && str2.equals("OauthsendOTPUserEmailV4SV1")) {
                                net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new r(this));
                                return;
                            }
                            return;
                        }
                        break;
                    case -1258493019:
                        if (responseCode.equals("BE1426010")) {
                            if (str2 != null && str.hashCode() == -1984296405 && str2.equals("OauthsendOTPUserEmailV4SV1")) {
                                net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new o(this));
                                return;
                            }
                            return;
                        }
                        break;
                    case 1537:
                        if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                            if (str2 != null) {
                                int hashCode = str.hashCode();
                                if (hashCode != -183116971) {
                                    if (hashCode == 27786834 && str2.equals("OauthValidateOTPV4SV1")) {
                                        String[] strArr = new String[1];
                                        if (!this.f56249g) {
                                            str4 = "otp";
                                        }
                                        strArr[0] = str4;
                                        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr));
                                        this.f56245c = updatePhoneResModel.getState();
                                        f();
                                        return;
                                    }
                                    return;
                                } else if (str2.equals("OauthResendOTPSV1")) {
                                    x.a((x) this, false, 7);
                                    kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                                    this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
                                    b();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        break;
                    case 51511:
                        if (responseCode.equals("403")) {
                            if (str2 != null && str.hashCode() == 27786834 && str2.equals("OauthValidateOTPV4SV1")) {
                                String message = updatePhoneResModel.getMessage();
                                String[] strArr2 = new String[3];
                                if (!this.f56249g) {
                                    str4 = "otp";
                                }
                                strArr2[0] = str4;
                                if (message != null) {
                                    str3 = message;
                                }
                                strArr2[1] = str3;
                                strArr2[2] = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
                                a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr2));
                                RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                                kotlin.g.b.k.a((Object) roboTextView, "error_text_otp");
                                roboTextView.setVisibility(0);
                                RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                                kotlin.g.b.k.a((Object) roboTextView2, "error_text_otp");
                                roboTextView2.setText(message);
                                return;
                            }
                            return;
                        }
                        break;
                    case 54399:
                        if (responseCode.equals("708")) {
                            if (str2 != null) {
                                int hashCode2 = str.hashCode();
                                if (hashCode2 != -183116971) {
                                    if (hashCode2 == 27786834 && str2.equals("OauthValidateOTPV4SV1")) {
                                        String[] strArr3 = new String[4];
                                        if (!this.f56249g) {
                                            str4 = "otp";
                                        }
                                        strArr3[0] = str4;
                                        String message2 = updatePhoneResModel.getMessage();
                                        if (message2 == null) {
                                            message2 = str3;
                                        }
                                        strArr3[1] = message2;
                                        strArr3[2] = SDKConstants.KEY_API;
                                        strArr3[3] = updatePhoneResModel.getResponseCode();
                                        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr3));
                                        net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new m(this));
                                        return;
                                    }
                                    return;
                                } else if (str2.equals("OauthResendOTPSV1")) {
                                    net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new n(this));
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        break;
                }
            }
            if (!TextUtils.isEmpty(updatePhoneResModel.getMessage())) {
                if (str2 != null && str.hashCode() == 27786834 && str2.equals("OauthValidateOTPV4SV1")) {
                    String[] strArr4 = new String[4];
                    if (!this.f56249g) {
                        str4 = "otp";
                    }
                    strArr4[0] = str4;
                    String message3 = updatePhoneResModel.getMessage();
                    if (message3 == null) {
                        message3 = str3;
                    }
                    strArr4[1] = message3;
                    strArr4[2] = SDKConstants.KEY_API;
                    String responseCode2 = updatePhoneResModel.getResponseCode();
                    if (responseCode2 == null) {
                        responseCode2 = str3;
                    }
                    strArr4[3] = responseCode2;
                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr4));
                }
                net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) s.f56270a);
                return;
            }
            if (str2 != null && str.hashCode() == 27786834 && str2.equals("OauthValidateOTPV4SV1")) {
                String[] strArr5 = new String[4];
                if (!this.f56249g) {
                    str4 = "otp";
                }
                strArr5[0] = str4;
                String string = getString(R.string.oauth_error);
                kotlin.g.b.k.a((Object) string, "getString(R.string.oauth_error)");
                strArr5[1] = string;
                strArr5[2] = SDKConstants.KEY_API;
                String responseCode3 = updatePhoneResModel.getResponseCode();
                if (responseCode3 == null) {
                    responseCode3 = str3;
                }
                strArr5[3] = responseCode3;
                a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr5));
            }
            net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.oauth_error), (View.OnClickListener) t.f56271a);
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56264a;

        m(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56264a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56264a.requireActivity().setResult(-1);
            this.f56264a.requireActivity().finish();
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56265a;

        n(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56265a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56265a.requireActivity().setResult(-1);
            this.f56265a.requireActivity().finish();
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56266a;

        o(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56266a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56266a.requireActivity().setResult(-1);
            this.f56266a.requireActivity().finish();
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56267a;

        p(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56267a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56267a.requireActivity().setResult(-1);
            this.f56267a.requireActivity().finish();
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56268a;

        q(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56268a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56268a.requireActivity().setResult(-1);
            this.f56268a.requireActivity().finish();
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56269a;

        r(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56269a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56269a.requireActivity().setResult(-1);
            this.f56269a.requireActivity().finish();
        }
    }

    public final void b(ErrorModel errorModel, String str) {
        String str2 = str;
        kotlin.g.b.k.c(errorModel, "model");
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, errorModel.getCustomError())) {
            if (errorModel.getStatus() == -1) {
                String string = getString(R.string.no_connection);
                kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                String string2 = getString(R.string.no_internet);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.no_internet)");
                OAuthUtils.a(requireContext(), string, string2, new e(this, str2));
                return;
            }
            int status = errorModel.getStatus();
            Integer num = net.one97.paytm.oauth.utils.n.f56789h;
            String str3 = "auto_otp";
            if (num != null && status == num.intValue()) {
                byte[] bArr = errorModel.getCustomError().networkResponse.data;
                kotlin.g.b.k.a((Object) bArr, "model.customError.networkResponse.data");
                String str4 = new String(bArr, kotlin.m.d.f47971a);
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        String string3 = jSONObject.getString("message");
                        if (!kotlin.g.b.k.a((Object) "3006", (Object) jSONObject.getString("responseCode"))) {
                            if (!kotlin.g.b.k.a((Object) "BE1426002", (Object) jSONObject.getString("responseCode"))) {
                                net.one97.paytm.oauth.d.a.a(requireContext(), string3, (View.OnClickListener) g.f56258a);
                                return;
                            }
                        }
                        if (str2 != null) {
                            if (str.hashCode() == 27786834) {
                                if (str2.equals("OauthValidateOTPV4SV1")) {
                                    String[] strArr = new String[3];
                                    if (!this.f56249g) {
                                        str3 = "otp";
                                    }
                                    strArr[0] = str3;
                                    kotlin.g.b.k.a((Object) string3, "message");
                                    strArr[1] = string3;
                                    strArr[2] = SDKConstants.KEY_API;
                                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr));
                                }
                            }
                        }
                        net.one97.paytm.oauth.d.a.a(requireContext(), string3, (View.OnClickListener) new f(this));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                int status2 = errorModel.getStatus();
                Integer num2 = net.one97.paytm.oauth.utils.n.f56783b;
                if (num2 != null && status2 == num2.intValue()) {
                    byte[] bArr2 = errorModel.getCustomError().networkResponse.data;
                    kotlin.g.b.k.a((Object) bArr2, "model.customError.networkResponse.data");
                    String str5 = new String(bArr2, kotlin.m.d.f47971a);
                    if (!TextUtils.isEmpty(str5)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str5);
                            String string4 = jSONObject2.getString("message");
                            if (!kotlin.g.b.k.a((Object) "PU_DIY_03", (Object) jSONObject2.getString("responseCode"))) {
                                if (!kotlin.g.b.k.a((Object) "BE1426009", (Object) jSONObject2.getString("responseCode"))) {
                                    net.one97.paytm.oauth.d.a.a(requireContext(), string4, (View.OnClickListener) i.f56260a);
                                    return;
                                }
                            }
                            if (str2 != null) {
                                if (str.hashCode() == 27786834) {
                                    if (str2.equals("OauthValidateOTPV4SV1")) {
                                        String[] strArr2 = new String[3];
                                        if (!this.f56249g) {
                                            str3 = "otp";
                                        }
                                        strArr2[0] = str3;
                                        kotlin.g.b.k.a((Object) string4, "message");
                                        strArr2[1] = string4;
                                        strArr2[2] = SDKConstants.KEY_API;
                                        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr2));
                                    }
                                }
                            }
                            net.one97.paytm.oauth.d.a.a(requireContext(), string4, (View.OnClickListener) new h(this));
                        } catch (JSONException e3) {
                            com.paytm.utility.q.b(e3.getMessage());
                        }
                    }
                } else {
                    int status3 = errorModel.getStatus();
                    Integer num3 = net.one97.paytm.oauth.utils.n.f56785d;
                    if (num3 != null && status3 == num3.intValue()) {
                        byte[] bArr3 = errorModel.getCustomError().networkResponse.data;
                        kotlin.g.b.k.a((Object) bArr3, "model.customError.networkResponse.data");
                        String str6 = new String(bArr3, kotlin.m.d.f47971a);
                        if (!TextUtils.isEmpty(str6)) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(str6);
                                String string5 = jSONObject3.getString("message");
                                if (!kotlin.g.b.k.a((Object) "BE1422002", (Object) jSONObject3.getString("responseCode"))) {
                                    if (!kotlin.g.b.k.a((Object) "BE1422003", (Object) jSONObject3.getString("responseCode"))) {
                                        net.one97.paytm.oauth.d.a.a(requireContext(), string5, (View.OnClickListener) j.f56261a);
                                        return;
                                    }
                                }
                                if (str2 != null) {
                                    if (str.hashCode() == 27786834) {
                                        if (str2.equals("OauthValidateOTPV4SV1")) {
                                            net.one97.paytm.oauth.b b2 = OauthModule.b();
                                            FragmentActivity requireActivity = requireActivity();
                                            if (requireActivity != null) {
                                                b2.handleSessionTimeOut((AppCompatActivity) requireActivity, errorModel.getCustomError(), (String) null, (Bundle) null, false, true);
                                                return;
                                            }
                                            throw new kotlin.u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                                        }
                                    }
                                }
                            } catch (JSONException e4) {
                                com.paytm.utility.q.b(e4.getMessage());
                            }
                        }
                    } else {
                        byte[] bArr4 = errorModel.getCustomError().networkResponse.data;
                        kotlin.g.b.k.a((Object) bArr4, "model.customError.networkResponse.data");
                        String str7 = new String(bArr4, kotlin.m.d.f47971a);
                        if (!TextUtils.isEmpty(str7)) {
                            try {
                                String string6 = new JSONObject(str7).getString("message");
                                if (!TextUtils.isEmpty(string6)) {
                                    net.one97.paytm.oauth.d.a.a(requireContext(), string6, (View.OnClickListener) k.f56262a);
                                } else {
                                    net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) l.f56263a);
                                }
                            } catch (JSONException e5) {
                                com.paytm.utility.q.b(e5.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56255a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56256b;

        e(VerifyPhoneOtpFragment verifyPhoneOtpFragment, String str) {
            this.f56255a = verifyPhoneOtpFragment;
            this.f56256b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56255a.b(this.f56256b);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56257a;

        f(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56257a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56257a.requireActivity().setResult(-1);
            this.f56257a.requireActivity().finish();
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyPhoneOtpFragment f56259a;

        h(VerifyPhoneOtpFragment verifyPhoneOtpFragment) {
            this.f56259a = verifyPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56259a.requireActivity().setResult(-1);
            this.f56259a.requireActivity().finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        kotlin.g.b.k.c(str, "otp");
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtp(str);
        }
        this.f56249g = true;
        e();
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j2) {
        kotlin.g.b.k.c(aVar, "state");
        int i2 = cc.f56563a[aVar.ordinal()];
        if (i2 == 1) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView != null) {
                roboTextView.setVisibility(0);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.resendOtp);
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
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.resendOtp);
            if (roboTextView5 != null) {
                roboTextView5.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1984296405) {
                if (hashCode != -183116971) {
                    if (hashCode == 27786834 && str.equals("OauthValidateOTPV4SV1")) {
                        e();
                    }
                } else if (str.equals("OauthResendOTPSV1")) {
                    d();
                }
            } else if (str.equals("OauthsendOTPUserEmailV4SV1")) {
                f();
            }
        }
    }

    private static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "add_email", str, arrayList, (String) null, "/phone_otp_for_add_email", net.one97.paytm.oauth.utils.p.f56796a);
    }
}
