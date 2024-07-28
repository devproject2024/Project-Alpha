package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.m.p;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.cb;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.models.VerificationResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;

public final class VerifyEmailPhoneOtpFragment extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ kotlin.k.i[] f56221a = {y.a((t) new u(y.b(VerifyEmailPhoneOtpFragment.class), "args", "<v#0>"))};

    /* renamed from: e  reason: collision with root package name */
    public static final a f56222e = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public String f56223c = "1";

    /* renamed from: d  reason: collision with root package name */
    public boolean f56224d;

    /* renamed from: f  reason: collision with root package name */
    private String f56225f;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.oauth.g.k f56226g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f56227h = "phone_update_logout";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f56228i = "/email_otp";
    private String j = "email_otp";
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
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

    static final class b<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56229a;

        b(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56229a = verifyEmailPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56229a.a(R.id.progressLoader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        VerifyEmailPhoneOtpFragment.a(this.f56229a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56229a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56230a;

        c(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56230a = verifyEmailPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56230a.a(R.id.progressLoader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        VerifyEmailPhoneOtpFragment.a(this.f56230a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56230a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56231a;

        d(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56231a = verifyEmailPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56231a.a(R.id.progressLoader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        VerifyEmailPhoneOtpFragment.a(this.f56231a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56231a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56232a;

        e(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56232a = verifyEmailPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56232a.a(R.id.progressLoader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        VerifyEmailPhoneOtpFragment.a(this.f56232a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56232a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class f<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56233a;

        f(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56233a = verifyEmailPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56233a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        VerifyEmailPhoneOtpFragment.a(this.f56233a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56233a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56234a;

        g(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56234a = verifyEmailPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56234a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        VerifyEmailPhoneOtpFragment.a(this.f56234a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56234a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    static final class h<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56235a;

        h(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56235a = verifyEmailPhoneOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                OAuthUtils.b((LottieAnimationView) this.f56235a.a(R.id.progressLoader));
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        VerifyEmailPhoneOtpFragment.a(this.f56235a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56235a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
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
        return layoutInflater.inflate(R.layout.fragment_verify_email_phone_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        RoboTextView roboTextView;
        super.onActivityCreated(bundle);
        kotlin.g dVar = new androidx.navigation.d(y.b(ca.class), new i(this));
        this.f56224d = ((ca) dVar.getValue()).e();
        this.f56225f = ((ca) dVar.getValue()).b();
        String d2 = ((ca) dVar.getValue()).d();
        kotlin.g.b.k.a((Object) d2, "args.mode");
        this.f56223c = d2;
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.btn_confirm));
        }
        if (kotlin.g.b.k.a((Object) this.f56223c, (Object) "2")) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.lblDesc);
            if (roboTextView2 != null) {
                roboTextView2.setText(getString(R.string.lbl_verify_your_registered_mobile_number, OAuthUtils.e(((ca) dVar.getValue()).c())));
            }
            if (!this.f56224d) {
                kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                if ((net.one97.paytm.oauth.a.e() || !TextUtils.isEmpty(com.paytm.utility.b.m(requireContext()))) && (roboTextView = (RoboTextView) a(R.id.lblTryAnotherWay)) != null) {
                    roboTextView.setVisibility(0);
                }
            }
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.lblResendOtp);
            if (roboTextView3 != null) {
                roboTextView3.setText(getString(R.string.lb_resend_otp_on_sms));
            }
        } else {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.lblDesc);
            if (roboTextView4 != null) {
                roboTextView4.setText(getString(R.string.lbl_verify_your_registered_email_id, ((ca) dVar.getValue()).a()));
            }
        }
        if (com.paytm.utility.b.r(requireContext())) {
            this.f56227h = "phone_update_login";
        }
        if (kotlin.g.b.k.a((Object) this.f56223c, (Object) "2")) {
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.lblOpenEmail);
            if (roboTextView5 != null) {
                net.one97.paytm.oauth.utils.h.b(roboTextView5);
            }
            if (this.f56224d) {
                this.f56228i = "/phone_otp_for_add_email";
                this.f56227h = "add_email";
                this.j = "phone_otp";
                str = "phone_otp_for_add_email_page_loaded";
            } else {
                this.f56228i = "/old_number_otp_page";
                this.j = "old_number_otp";
                str = "old_number_otp_page_loaded";
            }
        } else {
            str = "email_otp_page_loaded";
        }
        v.a(this.f56228i, this.f56227h, str, kotlin.a.k.d(c()), 16);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.k.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…oneViewModel::class.java)");
        this.f56226g = (net.one97.paytm.oauth.g.k) a2;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtpTextChangeListener(new m(this));
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        RoboTextView roboTextView6 = (RoboTextView) a(R.id.lblTryAnotherWay);
        if (roboTextView6 != null) {
            roboTextView6.setOnClickListener(this);
        }
        RoboTextView roboTextView7 = (RoboTextView) a(R.id.lblResendOtp);
        if (roboTextView7 != null) {
            roboTextView7.setOnClickListener(this);
        }
        RoboTextView roboTextView8 = (RoboTextView) a(R.id.lblOpenEmail);
        if (roboTextView8 != null) {
            roboTextView8.setOnClickListener(this);
        }
        x.a((x) this, false, 7);
    }

    public final void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    public static final class m implements OtpView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56239a;

        m(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56239a = verifyEmailPhoneOtpFragment;
        }

        public final void a(Editable editable, boolean z) {
            kotlin.g.b.k.c(editable, "s");
            RoboTextView roboTextView = (RoboTextView) this.f56239a.a(R.id.error_text_otp);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
            if (z) {
                v.a(this.f56239a.f56228i, this.f56239a.f56227h, "otp_entered", (ArrayList) null, 24);
            }
        }
    }

    public final void onClick(View view) {
        String str;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnConfirm;
        if (valueOf != null && valueOf.intValue() == i2) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
            if (progressViewButton == null || !progressViewButton.f56843a) {
                d();
                return;
            }
            return;
        }
        int i3 = R.id.lblTryAnotherWay;
        if (valueOf != null && valueOf.intValue() == i3) {
            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
            if (!net.one97.paytm.oauth.a.e() || !TextUtils.isEmpty(com.paytm.utility.b.m(requireContext()))) {
                kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                if (net.one97.paytm.oauth.a.h()) {
                    e();
                    return;
                }
                kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                if (net.one97.paytm.oauth.a.e()) {
                    i();
                } else {
                    net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.lbl_could_not_verify_you), (View.OnClickListener) new l(this));
                }
            } else {
                i();
            }
        } else {
            int i4 = R.id.lblResendOtp;
            if (valueOf != null && valueOf.intValue() == i4) {
                if (kotlin.g.b.k.a((Object) this.f56223c, (Object) "2")) {
                    if (this.f56224d) {
                        h();
                    } else {
                        f();
                    }
                    str = "resend_otp_sms";
                } else {
                    g();
                    str = "resend_otp_email";
                }
                v.a(this.f56228i, this.f56227h, str, (ArrayList) null, 24);
                return;
            }
            int i5 = R.id.lblOpenEmail;
            if (valueOf != null && valueOf.intValue() == i5) {
                OAuthUtils.a((Context) requireActivity(), getString(R.string.lbl_select_app_to_view_otp));
                v.a(this.f56228i, this.f56227h, "open_email_app", (ArrayList) null, 24);
            }
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56238a;

        l(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56238a = verifyEmailPhoneOtpFragment;
        }

        public final void onClick(View view) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            net.one97.paytm.oauth.b b3 = OauthModule.b();
            kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
            b2.checkDeepLinking(b3.getApplicationContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
            this.f56238a.requireActivity().setResult(-1);
            this.f56238a.requireActivity().finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        kotlin.g.b.k.c(str, "otp");
        if (kotlin.g.b.k.a((Object) this.f56223c, (Object) "2")) {
            OtpView otpView = (OtpView) a(R.id.otpContainer);
            if (otpView != null) {
                otpView.setOtp(str);
            }
            d();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j2) {
        kotlin.g.b.k.c(aVar, "state");
        int i2 = bz.f56557a[aVar.ordinal()];
        if (i2 == 1) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.txtTimer);
            if (roboTextView != null) {
                roboTextView.setVisibility(0);
            }
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.lblResendOtp);
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
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.lblResendOtp);
            if (roboTextView5 != null) {
                roboTextView5.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r2.equals("profileValidateOTPV3") != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r2.equals("validateOtpV4") != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0003
            goto L_0x0050
        L_0x0003:
            int r0 = r2.hashCode()
            switch(r0) {
                case -845623405: goto L_0x0044;
                case -760533911: goto L_0x003b;
                case -430296540: goto L_0x002f;
                case 10476425: goto L_0x0023;
                case 11948129: goto L_0x0017;
                case 2017232921: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0050
        L_0x000b:
            java.lang.String r0 = "oauthResendOtp"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0050
            r1.g()
            goto L_0x0050
        L_0x0017:
            java.lang.String r0 = "sendOtpV4"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0050
            r1.e()
            goto L_0x0050
        L_0x0023:
            java.lang.String r0 = "oauthSendOtpV3"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0050
            r1.f()
            goto L_0x0050
        L_0x002f:
            java.lang.String r0 = "profileResendOTPV3"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0050
            r1.h()
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "profileValidateOTPV3"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0050
            goto L_0x004d
        L_0x0044:
            java.lang.String r0 = "validateOtpV4"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0050
        L_0x004d:
            r1.d()
        L_0x0050:
            r1.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.VerifyEmailPhoneOtpFragment.b(java.lang.String):void");
    }

    private final void d() {
        String otp;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null && (otp = otpView.getOtp()) != null) {
            String d2 = d(otp);
            CharSequence charSequence = d2;
            if (!TextUtils.isEmpty(charSequence)) {
                RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                kotlin.g.b.k.a((Object) roboTextView, "error_text_otp");
                roboTextView.setVisibility(0);
                RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                kotlin.g.b.k.a((Object) roboTextView2, "error_text_otp");
                roboTextView2.setText(charSequence);
                v.a(this.f56228i, this.f56227h, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(this.j, d2, AppManagerUtil.EXTEND_PREFIX_DEFAULT), 16);
                return;
            }
            OAuthUtils.a((Activity) requireActivity());
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
            if (this.f56224d) {
                if (this.f56226g == null) {
                    kotlin.g.b.k.a("viewModel");
                }
                net.one97.paytm.oauth.g.k.c(otp, this.f56225f, VerifyEmailPhoneOtpFragment.class.getName()).observe(this, new f(this));
                return;
            }
            if (this.f56226g == null) {
                kotlin.g.b.k.a("viewModel");
            }
            String str = this.f56225f;
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
            net.one97.paytm.oauth.g.k.b(otp, str, b2.getSSOToken()).observe(this, new g(this));
        }
    }

    private final void e() {
        OAuthUtils.a((LottieAnimationView) a(R.id.progressLoader));
        if (this.f56226g == null) {
            kotlin.g.b.k.a("viewModel");
        }
        String str = this.f56225f;
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
        net.one97.paytm.oauth.g.k.a(str, "1", b2.getSSOToken()).observe(this, new d(this));
    }

    private final void f() {
        OAuthUtils.a((LottieAnimationView) a(R.id.progressLoader));
        if (this.f56226g == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.oauth.g.k.a(com.paytm.utility.b.ab(requireContext()), "UPDATE_PHONE").observe(this, new e(this));
    }

    private final void g() {
        OAuthUtils.a((Activity) requireActivity());
        OAuthUtils.a((LottieAnimationView) a(R.id.progressLoader));
        if (this.f56226g == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.oauth.g.k.a(this.f56225f).observe(this, new b(this));
    }

    private final void h() {
        OAuthUtils.a((Activity) requireActivity());
        OAuthUtils.a((LottieAnimationView) a(R.id.progressLoader));
        if (this.f56226g == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.oauth.g.k.d(this.f56225f, "current", VerifyEmailPhoneOtpFragment.class.getName()).observe(this, new c(this));
    }

    private final void i() {
        OAuthUtils.a((LottieAnimationView) a(R.id.progressLoader));
        if (this.f56226g == null) {
            kotlin.g.b.k.a("viewModel");
        }
        net.one97.paytm.oauth.g.k.d(this.f56225f, "DIY_PHONE_UPDATE_LOGGEDIN").observe(this, new h(this));
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        String str2 = str;
        if (iJRPaytmDataModel2 instanceof UpdatePhoneResModel) {
            UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel2;
            String responseCode = updatePhoneResModel.getResponseCode();
            String str3 = "";
            if (responseCode != null) {
                int hashCode = responseCode.hashCode();
                if (hashCode != -321998554) {
                    if (hashCode != 1537) {
                        if (hashCode != 51511) {
                            if (hashCode != 54399) {
                                if (hashCode != 1541) {
                                    if (hashCode == 1542 && responseCode.equals("06")) {
                                        if (str2 != null && str.hashCode() == -430296540 && str2.equals("profileResendOTPV3")) {
                                            this.f56225f = updatePhoneResModel.getState();
                                            x.a((x) this, false, 7);
                                            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                                            this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
                                            b();
                                            return;
                                        }
                                        return;
                                    }
                                } else if (responseCode.equals("05")) {
                                    if (str2 != null && str.hashCode() == -760533911 && str2.equals("profileValidateOTPV3")) {
                                        v.a(this.f56228i, this.f56227h, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(this.j), 16);
                                        v.a("/email_link_sent_popup", this.f56227h, "email_link_sent_popup_loaded", kotlin.a.k.d(this.f56228i), 16);
                                        String string = getString(R.string.profile_check_email_msg);
                                        String message = updatePhoneResModel.getMessage();
                                        CharSequence charSequence = message;
                                        if (!TextUtils.isEmpty(charSequence)) {
                                            Matcher matcher = Pattern.compile("(\\w+)(\\.\\w+)*@(\\w+\\.)(\\w+)(\\.\\w+)*").matcher(charSequence);
                                            if (matcher.find()) {
                                                str3 = matcher.group();
                                                kotlin.g.b.k.a((Object) str3, "matcher.group()");
                                            }
                                            if (str3 != null) {
                                                str3 = p.b(str3).toString();
                                            } else {
                                                throw new kotlin.u("null cannot be cast to non-null type kotlin.CharSequence");
                                            }
                                        }
                                        Spanned fromHtml = Html.fromHtml(message != null ? new kotlin.m.l(str3).replaceFirst(charSequence, "<p dir=\"ltr\"><font color =\"#00baf2\"><a href=\"" + str3 + "\">" + str3 + "</a></font></p>") : null);
                                        kotlin.g.b.k.a((Object) fromHtml, "Html.fromHtml(message?.r…Regex(), hyperlinkEmail))");
                                        a(string, (CharSequence) fromHtml);
                                        return;
                                    }
                                    return;
                                }
                            } else if (responseCode.equals("708")) {
                                String str4 = this.f56228i;
                                String str5 = this.f56227h;
                                String[] strArr = new String[4];
                                strArr[0] = this.j;
                                String message2 = updatePhoneResModel.getMessage();
                                if (message2 != null) {
                                    str3 = message2;
                                }
                                strArr[1] = str3;
                                strArr[2] = SDKConstants.KEY_API;
                                strArr[3] = updatePhoneResModel.getResponseCode();
                                v.a(str4, str5, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr), 16);
                                net.one97.paytm.oauth.d.a.a(requireContext(), updatePhoneResModel.getMessage(), (View.OnClickListener) new j(this));
                                return;
                            }
                        } else if (responseCode.equals("403")) {
                            RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                            if (roboTextView != null) {
                                roboTextView.setVisibility(0);
                            }
                            RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                            if (roboTextView2 != null) {
                                roboTextView2.setText(updatePhoneResModel.getMessage());
                            }
                            String str6 = this.f56228i;
                            String str7 = this.f56227h;
                            String[] strArr2 = new String[4];
                            strArr2[0] = this.j;
                            String message3 = updatePhoneResModel.getMessage();
                            if (message3 != null) {
                                str3 = message3;
                            }
                            strArr2[1] = str3;
                            strArr2[2] = SDKConstants.KEY_API;
                            strArr2[3] = updatePhoneResModel.getResponseCode();
                            v.a(str6, str7, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr2), 16);
                            return;
                        }
                    } else if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        if (str2 != null) {
                            switch (str.hashCode()) {
                                case -845623405:
                                    if (str2.equals("validateOtpV4")) {
                                        cb.b a2 = cb.a();
                                        kotlin.g.b.k.a((Object) a2, "VerifyEmailPhoneOtpFragm…navActionEnterNewNumber()");
                                        if (kotlin.g.b.k.a((Object) this.f56223c, (Object) "1")) {
                                            a2.c("email_otp");
                                        } else {
                                            a2.c("phone_otp");
                                        }
                                        String state = updatePhoneResModel.getState();
                                        if (state != null) {
                                            str3 = state;
                                        }
                                        a2.a(str3);
                                        a2.b(this.f56228i);
                                        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) a2);
                                        v.a(this.f56228i, this.f56227h, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(this.j), 16);
                                        return;
                                    }
                                    return;
                                case 10476425:
                                    if (str2.equals("oauthSendOtpV3")) {
                                        this.f56225f = updatePhoneResModel.getState();
                                        x.a((x) this, false, 7);
                                        kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                                        this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
                                        b();
                                        return;
                                    }
                                    return;
                                case 11948129:
                                    if (str2.equals("sendOtpV4")) {
                                        v.a(this.f56228i, this.f56227h, "try_another_way_clicked", kotlin.a.k.d("email_present"), 16);
                                        this.f56225f = updatePhoneResModel.getState();
                                        cb.a b2 = cb.b();
                                        kotlin.g.b.k.a((Object) b2, "VerifyEmailPhoneOtpFragm…tions.navActionEmailOtp()");
                                        String meta = updatePhoneResModel.getMeta();
                                        if (meta == null) {
                                            meta = str3;
                                        }
                                        b2.a(meta);
                                        String str8 = this.f56225f;
                                        if (str8 != null) {
                                            str3 = str8;
                                        }
                                        b2.b(str3);
                                        b2.c("1");
                                        b2.d(this.f56228i);
                                        androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) b2);
                                        return;
                                    }
                                    return;
                                case 2017232921:
                                    if (str2.equals("oauthResendOtp")) {
                                        x.a((x) this, false, 7);
                                        kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                                        this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
                                        b();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            return;
                        }
                    }
                } else if (responseCode.equals("PU_DIY_01")) {
                    v.a(this.f56228i, this.f56227h, "try_another_way_clicked", kotlin.a.k.d("no_verification"), 16);
                    String message4 = updatePhoneResModel.getMessage();
                    a((String) null, message4 != null ? message4 : str3);
                    return;
                }
            }
            String str9 = this.f56228i;
            String str10 = this.f56227h;
            String[] strArr3 = new String[4];
            strArr3[0] = this.j;
            String message5 = updatePhoneResModel.getMessage();
            if (message5 == null) {
                message5 = str3;
            }
            strArr3[1] = message5;
            strArr3[2] = SDKConstants.KEY_API;
            String responseCode2 = updatePhoneResModel.getResponseCode();
            if (responseCode2 != null) {
                str3 = responseCode2;
            }
            strArr3[3] = str3;
            v.a(str9, str10, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr3), 16);
            com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), updatePhoneResModel.getMessage());
        } else if (iJRPaytmDataModel2 instanceof VerificationResModel) {
            VerificationResModel verificationResModel = (VerificationResModel) iJRPaytmDataModel2;
            String responseCode3 = verificationResModel.getResponseCode();
            if (responseCode3 != null && responseCode3.hashCode() == -1260518837 && responseCode3.equals("BE1400001")) {
                v.a(this.f56228i, this.f56227h, "try_another_way_clicked", kotlin.a.k.d("saved_cards_present"), 16);
                cb.c c2 = cb.c();
                kotlin.g.b.k.a((Object) c2, "VerifyEmailPhoneOtpFragm….navActionSavedCardList()");
                c2.a(verificationResModel.getStateCode());
                c2.b(verificationResModel.getVerifierId());
                c2.c(this.f56228i);
                androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) c2);
                return;
            }
            v.a(this.f56228i, this.f56227h, "try_another_way_clicked", kotlin.a.k.d("no_verification"), 16);
            net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.lbl_could_not_verify_you), (View.OnClickListener) new k(this));
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56236a;

        j(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56236a = verifyEmailPhoneOtpFragment;
        }

        public final void onClick(View view) {
            this.f56236a.requireActivity().setResult(-1);
            this.f56236a.requireActivity().finish();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56237a;

        k(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment) {
            this.f56237a = verifyEmailPhoneOtpFragment;
        }

        public final void onClick(View view) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            net.one97.paytm.oauth.b b3 = OauthModule.b();
            kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
            b2.checkDeepLinking(b3.getApplicationContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
            this.f56237a.requireActivity().setResult(-1);
            this.f56237a.requireActivity().finish();
        }
    }

    private final void a(String str, CharSequence charSequence) {
        net.one97.paytm.oauth.d.a aVar = new net.one97.paytm.oauth.d.a(requireContext());
        aVar.setTitle(str);
        aVar.setCancelable(false);
        aVar.a(charSequence);
        if (this.f56224d) {
            aVar.a(-2, (CharSequence) getString(R.string.lbl_open_email_app), (View.OnClickListener) new n(this, aVar));
        }
        aVar.a(-1, (CharSequence) getString(R.string.ok), (View.OnClickListener) new o(this, aVar));
        aVar.show();
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56240a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.oauth.d.a f56241b;

        n(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment, net.one97.paytm.oauth.d.a aVar) {
            this.f56240a = verifyEmailPhoneOtpFragment;
            this.f56241b = aVar;
        }

        public final void onClick(View view) {
            if (this.f56240a.f56224d) {
                v.a("/email_link_sent_popup", this.f56240a.f56227h, "open_email_app", (ArrayList) null, 24);
                OAuthUtils.a((Context) this.f56240a.requireActivity(), this.f56240a.getString(R.string.lbl_select_app_to_verify_link));
            }
            this.f56241b.dismiss();
            this.f56240a.requireActivity().setResult(-1);
            this.f56240a.requireActivity().finish();
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerifyEmailPhoneOtpFragment f56242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.oauth.d.a f56243b;

        o(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment, net.one97.paytm.oauth.d.a aVar) {
            this.f56242a = verifyEmailPhoneOtpFragment;
            this.f56243b = aVar;
        }

        public final void onClick(View view) {
            if (this.f56242a.f56224d) {
                v.a("/email_link_sent_popup", this.f56242a.f56227h, "ok_clicked", (ArrayList) null, 24);
                OauthModule.b().openProfileActivity(this.f56242a.requireContext());
            }
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            net.one97.paytm.oauth.b b3 = OauthModule.b();
            kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
            b2.checkDeepLinking(b3.getApplicationContext(), "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15");
            this.f56243b.dismiss();
            this.f56242a.requireActivity().setResult(-1);
            this.f56242a.requireActivity().finish();
        }
    }

    public static final /* synthetic */ void a(VerifyEmailPhoneOtpFragment verifyEmailPhoneOtpFragment, ErrorModel errorModel, String str) {
        String a2 = super.a(errorModel, str);
        if (!TextUtils.isEmpty(a2)) {
            v.a(verifyEmailPhoneOtpFragment.f56228i, verifyEmailPhoneOtpFragment.f56227h, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(verifyEmailPhoneOtpFragment.j, a2, SDKConstants.KEY_API, String.valueOf(errorModel.getStatus())), 16);
        }
    }
}
