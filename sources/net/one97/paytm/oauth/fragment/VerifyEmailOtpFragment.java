package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public final class VerifyEmailOtpFragment extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f56201a = {y.a((t) new u(y.b(VerifyEmailOtpFragment.class), "args", "<v#0>"))};

    /* renamed from: c  reason: collision with root package name */
    private String f56202c;

    /* renamed from: d  reason: collision with root package name */
    private String f56203d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f56204e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.oauth.g.j f56205f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56206g;

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final f f56213a = new f();

        f() {
        }

        public final void onClick(View view) {
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final g f56214a = new g();

        g() {
        }

        public final void onClick(View view) {
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final h f56215a = new h();

        h() {
        }

        public final void onClick(View view) {
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final m f56219a = new m();

        m() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.f56206g == null) {
            this.f56206g = new HashMap();
        }
        View view = (View) this.f56206g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56206g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56206g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        kotlin.g.b.k.c(str, "otp");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class i extends kotlin.g.b.l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment) {
            super(0);
            this.$this_navArgs = fragment;
        }

        public final Bundle invoke() {
            Bundle arguments = this.$this_navArgs.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException("Fragment " + this.$this_navArgs + " has null arguments");
        }
    }

    static final class a<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56207a;

        a(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56207a = verifyEmailOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56207a.a(R.id.btnConfirm);
            if (progressViewButton != null) {
                progressViewButton.d();
            }
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                T t = eVar.f52603b;
                if (t != null) {
                    this.f56207a.b((ErrorModel) t, eVar.f52605d);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
            }
            this.f56207a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        }
    }

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56208a;

        b(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56208a = verifyEmailOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56208a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56208a.b((ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56208a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_verify_email_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        kotlin.g dVar = new androidx.navigation.d(y.b(by.class), new i(this));
        this.f56202c = ((by) dVar.getValue()).a();
        this.f56204e = ((by) dVar.getValue()).b();
        this.f56203d = ((by) dVar.getValue()).c();
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.btn_confirm));
        }
        RoboTextView roboTextView = (RoboTextView) a(R.id.requestOtp);
        if (roboTextView != null) {
            roboTextView.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.lblOpenEmail);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtpTextChangeListener(new n(this));
        }
        x.a((x) this, false, 7);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.j.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…ailViewModel::class.java)");
        this.f56205f = (net.one97.paytm.oauth.g.j) a2;
        a("email_otp_for_add_email_page_loaded", (ArrayList<String>) kotlin.a.k.d(c()));
    }

    public final void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    public static final class n implements OtpView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56220a;

        n(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56220a = verifyEmailOtpFragment;
        }

        public final void a(Editable editable, boolean z) {
            kotlin.g.b.k.c(editable, "s");
            RoboTextView roboTextView = (RoboTextView) this.f56220a.a(R.id.error_text_otp);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.requestOtp;
        if (valueOf != null && valueOf.intValue() == i2) {
            a("resend_otp_email", (ArrayList<String>) new ArrayList());
            d();
            return;
        }
        int i3 = R.id.btnConfirm;
        if (valueOf != null && valueOf.intValue() == i3) {
            e();
            return;
        }
        int i4 = R.id.lblOpenEmail;
        if (valueOf != null && valueOf.intValue() == i4) {
            OAuthUtils.a((Context) requireActivity(), getString(R.string.lbl_select_app_to_view_otp));
            a("open_email_app_clicked", (ArrayList<String>) new ArrayList());
        }
    }

    private final void d() {
        OAuthUtils.a((Activity) requireActivity());
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.c();
        }
        if (this.f56205f == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.oauth.g.j.a(this.f56202c).observe(this, new a(this));
    }

    private final void e() {
        String otp;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null && (otp = otpView.getOtp()) != null) {
            String d2 = d(otp);
            CharSequence charSequence = d2;
            if (!TextUtils.isEmpty(charSequence)) {
                a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d("email_otp", d2, AppManagerUtil.EXTEND_PREFIX_DEFAULT));
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
            if (this.f56205f == null) {
                kotlin.g.b.k.a("viewModel");
            }
            net.one97.paytm.oauth.g.j.c(otp, this.f56202c).observe(this, new b(this));
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        String str2;
        String str3;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        String str4 = str;
        if (iJRPaytmDataModel2 instanceof UpdatePhoneResModel) {
            UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel2;
            String responseCode = updatePhoneResModel.getResponseCode();
            if (responseCode != null) {
                int hashCode = responseCode.hashCode();
                if (hashCode != 1537) {
                    if (hashCode != 51511) {
                        if (hashCode == 54399 && responseCode.equals("708")) {
                            if (str4 != null) {
                                int hashCode2 = str.hashCode();
                                if (hashCode2 != -183116971) {
                                    if (hashCode2 == 1298539355 && str4.equals("OauthUserValidateOTPSV1")) {
                                        String[] strArr = new String[4];
                                        strArr[0] = "email_otp";
                                        String message = updatePhoneResModel.getMessage();
                                        if (message == null) {
                                            message = "";
                                        }
                                        strArr[1] = message;
                                        strArr[2] = SDKConstants.KEY_API;
                                        strArr[3] = updatePhoneResModel.getResponseCode();
                                        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr));
                                        net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new k(this));
                                        return;
                                    }
                                    return;
                                } else if (str4.equals("OauthResendOTPSV1")) {
                                    net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new l(this));
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    } else if (responseCode.equals("403")) {
                        String[] strArr2 = new String[4];
                        strArr2[0] = "email_otp";
                        String message2 = updatePhoneResModel.getMessage();
                        if (message2 == null) {
                            message2 = "";
                        }
                        strArr2[1] = message2;
                        strArr2[2] = SDKConstants.KEY_API;
                        strArr2[3] = updatePhoneResModel.getResponseCode();
                        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr2));
                        if (str4 != null && str.hashCode() == 1298539355 && str4.equals("OauthUserValidateOTPSV1")) {
                            String message3 = updatePhoneResModel.getMessage();
                            RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                            kotlin.g.b.k.a((Object) roboTextView, "error_text_otp");
                            roboTextView.setVisibility(0);
                            RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                            kotlin.g.b.k.a((Object) roboTextView2, "error_text_otp");
                            roboTextView2.setText(message3);
                            return;
                        }
                        return;
                    }
                } else if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                    if (str4 != null) {
                        int hashCode3 = str.hashCode();
                        if (hashCode3 != -183116971) {
                            if (hashCode3 == 1298539355 && str4.equals("OauthUserValidateOTPSV1")) {
                                a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d("email_otp"));
                                a("email_added_success_popup_loaded", (ArrayList<String>) new ArrayList());
                                String string = getString(R.string.email_added_successfully);
                                kotlin.g.b.k.a((Object) string, "getString(R.string.email_added_successfully)");
                                if (!TextUtils.isEmpty(com.paytm.utility.b.m(requireContext()))) {
                                    string = getString(R.string.email_updated_successfully);
                                    kotlin.g.b.k.a((Object) string, "getString(R.string.email_updated_successfully)");
                                }
                                net.one97.paytm.oauth.d.a.a(requireContext(), string, (View.OnClickListener) new j(this));
                                return;
                            }
                            return;
                        } else if (str4.equals("OauthResendOTPSV1")) {
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
            }
            if (TextUtils.isEmpty(updatePhoneResModel.getMessage())) {
                str2 = getString(R.string.oauth_error);
            } else {
                str2 = updatePhoneResModel.getMessage();
            }
            String[] strArr3 = new String[4];
            strArr3[0] = "email_otp";
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
            }
            strArr3[1] = str3;
            strArr3[2] = SDKConstants.KEY_API;
            String responseCode2 = updatePhoneResModel.getResponseCode();
            if (responseCode2 == null) {
                responseCode2 = "";
            }
            strArr3[3] = responseCode2;
            a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr3));
            net.one97.paytm.oauth.d.a.a(requireContext(), str2, (View.OnClickListener) m.f56219a);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56216a;

        j(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56216a = verifyEmailOtpFragment;
        }

        public final void onClick(View view) {
            q qVar = q.f56798a;
            q.g(this.f56216a.f56204e);
            Intent intent = new Intent();
            intent.putExtra(AppConstants.KEY_EMAIL, this.f56216a.f56204e);
            VerifyEmailOtpFragment.a("email_added_success_popup_clicked", (ArrayList<String>) new ArrayList());
            this.f56216a.requireActivity().setResult(-1, intent);
            this.f56216a.requireActivity().finish();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56217a;

        k(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56217a = verifyEmailOtpFragment;
        }

        public final void onClick(View view) {
            this.f56217a.requireActivity().setResult(-1);
            this.f56217a.requireActivity().finish();
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56218a;

        l(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56218a = verifyEmailOtpFragment;
        }

        public final void onClick(View view) {
            this.f56218a.requireActivity().setResult(-1);
            this.f56218a.requireActivity().finish();
        }
    }

    public final void b(ErrorModel errorModel, String str) {
        kotlin.g.b.k.c(errorModel, "model");
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, errorModel.getCustomError())) {
            if (errorModel.getStatus() == -1) {
                String string = getString(R.string.no_connection);
                kotlin.g.b.k.a((Object) string, "getString(R.string.no_connection)");
                String string2 = getString(R.string.no_internet);
                kotlin.g.b.k.a((Object) string2, "getString(R.string.no_internet)");
                OAuthUtils.a(requireContext(), string, string2, new c(this, str));
                return;
            }
            int status = errorModel.getStatus();
            Integer num = net.one97.paytm.oauth.utils.n.f56789h;
            if (num != null && status == num.intValue()) {
                byte[] bArr = errorModel.getCustomError().networkResponse.data;
                kotlin.g.b.k.a((Object) bArr, "model.customError.networkResponse.data");
                String str2 = new String(bArr, kotlin.m.d.f47971a);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        String string3 = jSONObject.getString("message");
                        if (kotlin.g.b.k.a((Object) "3006", (Object) jSONObject.getString("responseCode")) || kotlin.g.b.k.a((Object) "BE1426002", (Object) jSONObject.getString("responseCode"))) {
                            kotlin.g.b.k.a((Object) string3, "message");
                            a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d("email_otp", string3, SDKConstants.KEY_API));
                            net.one97.paytm.oauth.d.a.a(requireContext(), string3, (View.OnClickListener) new d(this));
                        }
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
                    String str3 = new String(bArr2, kotlin.m.d.f47971a);
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str3);
                            String string4 = jSONObject2.getString("message");
                            if (kotlin.g.b.k.a((Object) "PU_DIY_03", (Object) jSONObject2.getString("responseCode"))) {
                                kotlin.g.b.k.a((Object) string4, "message");
                                a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d("email_otp", string4, SDKConstants.KEY_API));
                                net.one97.paytm.oauth.d.a.a(requireContext(), string4, (View.OnClickListener) new e(this));
                                return;
                            }
                            net.one97.paytm.oauth.d.a.a(requireContext(), string4, (View.OnClickListener) f.f56213a);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                } else {
                    byte[] bArr3 = errorModel.getCustomError().networkResponse.data;
                    kotlin.g.b.k.a((Object) bArr3, "model.customError.networkResponse.data");
                    String str4 = new String(bArr3, kotlin.m.d.f47971a);
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            String string5 = new JSONObject(str4).getString("message");
                            if (!TextUtils.isEmpty(string5)) {
                                net.one97.paytm.oauth.d.a.a(requireContext(), string5, (View.OnClickListener) g.f56214a);
                            } else {
                                net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) h.f56215a);
                            }
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56209a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56210b;

        c(VerifyEmailOtpFragment verifyEmailOtpFragment, String str) {
            this.f56209a = verifyEmailOtpFragment;
            this.f56210b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56209a.b(this.f56210b);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56211a;

        d(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56211a = verifyEmailOtpFragment;
        }

        public final void onClick(View view) {
            this.f56211a.requireActivity().setResult(-1);
            this.f56211a.requireActivity().finish();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailOtpFragment f56212a;

        e(VerifyEmailOtpFragment verifyEmailOtpFragment) {
            this.f56212a = verifyEmailOtpFragment;
        }

        public final void onClick(View view) {
            this.f56212a.requireActivity().setResult(-1);
            this.f56212a.requireActivity().finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j2) {
        kotlin.g.b.k.c(aVar, "state");
        int i2 = bx.f56555a[aVar.ordinal()];
        if (i2 == 1) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView != null) {
                roboTextView.setVisibility(0);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.requestOtp);
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
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.requestOtp);
            if (roboTextView5 != null) {
                roboTextView5.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -183116971) {
                if (hashCode == 1298539355 && str.equals("OauthUserValidateOTPSV1")) {
                    e();
                }
            } else if (str.equals("OauthResendOTPSV1")) {
                d();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "add_email", str, arrayList, (String) null, "/email_otp_for_add_email", p.f56796a);
    }
}
