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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.an;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.upi.util.CJRGTMConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class ForgotEnterOtpFragment extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56125a = {y.a((t) new u(y.b(ForgotEnterOtpFragment.class), "args", "<v#0>"))};

    /* renamed from: c  reason: collision with root package name */
    public static final a f56126c = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private String f56127d;

    /* renamed from: e  reason: collision with root package name */
    private String f56128e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.oauth.g.d f56129f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f56130g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f56131h;

    public final View a(int i2) {
        if (this.f56131h == null) {
            this.f56131h = new HashMap();
        }
        View view = (View) this.f56131h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56131h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56131h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class e extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
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

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterOtpFragment f56132a;

        b(ForgotEnterOtpFragment forgotEnterOtpFragment) {
            this.f56132a = forgotEnterOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56132a.a(R.id.loader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        this.f56132a.a((ErrorModel) t);
                    } else {
                        throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                    }
                } else {
                    this.f56132a.a((IJRPaytmDataModel) eVar.f52603b);
                }
            }
            this.f56132a.f56130g = false;
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterOtpFragment f56133a;

        c(ForgotEnterOtpFragment forgotEnterOtpFragment) {
            this.f56133a = forgotEnterOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            OAuthUtils.b((LottieAnimationView) this.f56133a.a(R.id.loader));
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                T t = eVar.f52603b;
                if (t != null) {
                    this.f56133a.a((ErrorModel) t);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
            }
            this.f56133a.a((IJRPaytmDataModel) eVar.f52603b);
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
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_forgot_enter_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!(this.f56129f != null)) {
            FragmentActivity requireActivity = requireActivity();
            k.a((Object) requireActivity, "requireActivity()");
            Intent intent = requireActivity.getIntent();
            k.a((Object) intent, "requireActivity().intent");
            Bundle extras = intent.getExtras();
            String string = extras != null ? extras.getString(p.f56797b, "") : null;
            String[] strArr = new String[1];
            if (string == null) {
                string = "";
            }
            strArr[0] = string;
            a("forgot_password_sms_screen_loaded", (ArrayList<String>) kotlin.a.k.d(strArr));
            OauthModule.b().sendOpenScreenWithDeviceInfo("/forgot-password-sms", p.f56796a, requireContext());
        }
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.d.class);
        k.a((Object) a2, "ViewModelProviders.of(th…PwdViewModel::class.java)");
        this.f56129f = (net.one97.paytm.oauth.g.d) a2;
        g dVar = new androidx.navigation.d(y.b(am.class), new e(this));
        this.f56128e = ((am) dVar.getValue()).a();
        this.f56127d = ((am) dVar.getValue()).b();
        RoboTextView roboTextView = (RoboTextView) a(R.id.lblDesc);
        k.a((Object) roboTextView, "lblDesc");
        aa aaVar = aa.f47921a;
        String string2 = getString(R.string.lbl_verify_your_mobile_number);
        k.a((Object) string2, "getString(R.string.lbl_verify_your_mobile_number)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{OAuthUtils.e(this.f56128e)}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        roboTextView.setText(format);
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtpTextChangeListener(new f(this));
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.btnConfirm);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.requestOtp);
        if (roboTextView3 != null) {
            roboTextView3.setOnClickListener(this);
        }
        RoboTextView roboTextView4 = (RoboTextView) a(R.id.lblResetPwd);
        if (roboTextView4 != null) {
            roboTextView4.setOnClickListener(this);
        }
        RoboTextView roboTextView5 = (RoboTextView) a(R.id.lblUnableOtp);
        if (roboTextView5 != null) {
            roboTextView5.setOnClickListener(this);
        }
    }

    public final void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    public static final class f implements OtpView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterOtpFragment f56135a;

        f(ForgotEnterOtpFragment forgotEnterOtpFragment) {
            this.f56135a = forgotEnterOtpFragment;
        }

        public final void a(Editable editable, boolean z) {
            k.c(editable, "s");
            RoboTextView roboTextView = (RoboTextView) this.f56135a.a(R.id.error_text_otp);
            k.a((Object) roboTextView, "error_text_otp");
            roboTextView.setVisibility(8);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnConfirm;
        if (valueOf != null && valueOf.intValue() == i2) {
            d();
            return;
        }
        int i3 = R.id.requestOtp;
        if (valueOf != null && valueOf.intValue() == i3) {
            String str = this.f56128e;
            if (str != null) {
                a("forgot_password_resend_otp", (ArrayList<String>) new ArrayList());
                OAuthUtils.a((LottieAnimationView) a(R.id.loader));
                OtpView otpView = (OtpView) a(R.id.otpContainer);
                if (otpView != null) {
                    otpView.a();
                }
                this.f56130g = true;
                if (this.f56129f == null) {
                    k.a("viewModel");
                }
                Context requireContext = requireContext();
                k.a((Object) requireContext, "requireContext()");
                net.one97.paytm.oauth.g.d.a(requireContext, str, "OTP").observe(this, new b(this));
                return;
            }
            return;
        }
        int i4 = R.id.lblUnableOtp;
        if (valueOf == null || valueOf.intValue() != i4) {
            int i5 = R.id.lblResetPwd;
            if (valueOf == null || valueOf.intValue() != i5) {
                return;
            }
        }
        OAuthUtils.a(getFragmentManager(), this.f56128e);
    }

    /* access modifiers changed from: private */
    public final void d() {
        String otp;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null && (otp = otpView.getOtp()) != null) {
            String d2 = d(otp);
            CharSequence charSequence = d2;
            if (!TextUtils.isEmpty(charSequence)) {
                a(CJRGTMConstants.MT_V4_CONFIRM_CLICKED, (ArrayList<String>) kotlin.a.k.d("otp", d2, AppManagerUtil.EXTEND_PREFIX_DEFAULT));
                RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                k.a((Object) roboTextView, "error_text_otp");
                roboTextView.setVisibility(0);
                RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                k.a((Object) roboTextView2, "error_text_otp");
                roboTextView2.setText(charSequence);
                return;
            }
            OAuthUtils.a((Activity) requireActivity());
            OAuthUtils.a((LottieAnimationView) a(R.id.loader));
            if (this.f56129f == null) {
                k.a("viewModel");
            }
            net.one97.paytm.oauth.g.d.a(otp, this.f56127d).observe(this, new c(this));
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        String str2;
        String str3;
        if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
            SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
            str3 = simplifiedLoginInit.getResponseCode();
            str2 = simplifiedLoginInit.getMessage();
            str = simplifiedLoginInit.getStateToken();
        } else if (iJRPaytmDataModel instanceof UpdatePhoneResModel) {
            UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel;
            str3 = updatePhoneResModel.getResponseCode();
            str2 = updatePhoneResModel.getMessage();
            str = updatePhoneResModel.getState();
        } else {
            str = "";
            str3 = str;
            str2 = str3;
        }
        if (str3 != null) {
            int hashCode = str3.hashCode();
            if (hashCode != 1537) {
                if (hashCode != 51511) {
                    if (hashCode != 54399) {
                        if (hashCode == 2080801056 && str3.equals("FP_115")) {
                            a(CJRGTMConstants.MT_V4_CONFIRM_CLICKED, (ArrayList<String>) kotlin.a.k.d("otp"));
                            OAuthUtils.a(getFragmentManager(), this.f56128e);
                            return;
                        }
                    } else if (str3.equals("708")) {
                        RoboTextView roboTextView = (RoboTextView) a(R.id.requestOtp);
                        if (roboTextView != null) {
                            roboTextView.setVisibility(8);
                        }
                        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgOtpError);
                        if (appCompatImageView != null) {
                            appCompatImageView.setVisibility(0);
                        }
                        RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                        if (roboTextView2 != null) {
                            roboTextView2.setVisibility(0);
                        }
                        RoboTextView roboTextView3 = (RoboTextView) a(R.id.error_text_otp);
                        if (roboTextView3 != null) {
                            roboTextView3.setTextColor(androidx.core.content.b.c(requireContext(), R.color.color_ffad00));
                        }
                        RoboTextView roboTextView4 = (RoboTextView) a(R.id.error_text_otp);
                        if (roboTextView4 != null) {
                            roboTextView4.setText(getString(R.string.lbl_otp_limit_reached));
                        }
                        Group group = (Group) a(R.id.groupResetPwd);
                        if (group != null) {
                            group.setVisibility(0);
                            return;
                        }
                        return;
                    }
                } else if (str3.equals("403")) {
                    RoboTextView roboTextView5 = (RoboTextView) a(R.id.error_text_otp);
                    if (roboTextView5 != null) {
                        roboTextView5.setVisibility(0);
                    }
                    RoboTextView roboTextView6 = (RoboTextView) a(R.id.error_text_otp);
                    k.a((Object) roboTextView6, "error_text_otp");
                    roboTextView6.setText(str2);
                    return;
                }
            } else if (str3.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                if (this.f56130g) {
                    this.f56127d = str;
                    k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                    this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
                    b();
                    return;
                }
                a(CJRGTMConstants.MT_V4_CONFIRM_CLICKED, (ArrayList<String>) kotlin.a.k.d("otp"));
                an.a a2 = an.a();
                k.a((Object) a2, "ForgotEnterOtpFragmentDi…ns.navActionSetPassword()");
                a2.a(this.f56128e);
                if (str == null) {
                    str = "";
                }
                a2.b(str);
                androidx.navigation.k e2 = androidx.navigation.fragment.a.a(this).e();
                if (e2 == null || e2.b() != a2.a()) {
                    androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) a2);
                    return;
                }
                return;
            }
        }
        com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), str2);
    }

    public final void a(ErrorModel errorModel) {
        k.c(errorModel, "model");
        if (!OAuthUtils.a((Activity) getActivity(), (Fragment) this, errorModel.getCustomError())) {
            if (errorModel.getStatus() == -1) {
                String string = getString(R.string.no_connection);
                k.a((Object) string, "getString(R.string.no_connection)");
                String string2 = getString(R.string.no_internet);
                k.a((Object) string2, "getString(R.string.no_internet)");
                OAuthUtils.a(requireContext(), string, string2, new d(this));
                return;
            }
            if (errorModel.getCustomError() instanceof NetworkCustomError) {
                byte[] bArr = errorModel.getCustomError().networkResponse.data;
                if (bArr != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, kotlin.m.d.f47971a));
                        String string3 = jSONObject.getString("message");
                        String string4 = jSONObject.getString("responseCode");
                        int status = errorModel.getStatus();
                        Integer num = n.f56784c;
                        if (num != null) {
                            if (status == num.intValue() && k.a((Object) "BE1423003", (Object) string4)) {
                                net.one97.paytm.oauth.b b2 = OauthModule.b();
                                FragmentActivity requireActivity = requireActivity();
                                if (requireActivity != null) {
                                    b2.handleSessionTimeOut((AppCompatActivity) requireActivity, errorModel.getCustomError(), (String) null, (Bundle) null, true, false);
                                    return;
                                }
                                throw new kotlin.u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                            }
                        }
                        OAuthUtils.a((Activity) requireActivity(), string3);
                        return;
                    } catch (JSONException unused) {
                    }
                } else {
                    return;
                }
            }
            com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), getString(R.string.some_went_wrong));
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ForgotEnterOtpFragment f56134a;

        d(ForgotEnterOtpFragment forgotEnterOtpFragment) {
            this.f56134a = forgotEnterOtpFragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56134a.d();
        }
    }

    private static void a(String str, ArrayList<String> arrayList) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "forgot_password", str, arrayList, (String) null, "/forgot-password-sms", p.f56796a);
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        k.c(str, "otp");
        a("otp_autofilled", (ArrayList<String>) kotlin.a.k.d("otp"));
        a("proceed_auto", (ArrayList<String>) kotlin.a.k.d("otp"));
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtp(str);
        }
        d();
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j) {
        k.c(aVar, "state");
        int i2 = al.f56347a[aVar.ordinal()];
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
            String string = getString(R.string.lbl_resend_otp_in_seconds, Long.valueOf(j / 1000));
            k.a((Object) string, "getString(R.string.lbl_r…llisUntilFinished / 1000)");
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
}
