package net.one97.paytm.oauth.fragment;

import android.app.Activity;
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
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.l;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.g.b.y;
import kotlin.k.i;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.av;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.g.k;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;

public final class NewNumberOtpFragment extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f56141a = {y.a((t) new u(y.b(NewNumberOtpFragment.class), "args", "<v#0>"))};

    /* renamed from: c  reason: collision with root package name */
    public static final a f56142c = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private String f56143d;

    /* renamed from: e  reason: collision with root package name */
    private String f56144e;

    /* renamed from: f  reason: collision with root package name */
    private k f56145f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f56146g = "phone_update_logout";

    /* renamed from: h  reason: collision with root package name */
    private String f56147h = "";

    /* renamed from: i  reason: collision with root package name */
    private HashMap f56148i;

    public final View a(int i2) {
        if (this.f56148i == null) {
            this.f56148i = new HashMap();
        }
        View view = (View) this.f56148i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56148i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56148i;
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
        final /* synthetic */ NewNumberOtpFragment f56149a;

        b(NewNumberOtpFragment newNumberOtpFragment) {
            this.f56149a = newNumberOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                T t = eVar.f52603b;
                if (t != null) {
                    NewNumberOtpFragment.a(this.f56149a, (ErrorModel) t, eVar.f52605d);
                    return;
                }
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
            }
            this.f56149a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NewNumberOtpFragment f56150a;

        c(NewNumberOtpFragment newNumberOtpFragment) {
            this.f56150a = newNumberOtpFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                ProgressViewButton progressViewButton = (ProgressViewButton) this.f56150a.a(R.id.btnConfirm);
                if (progressViewButton != null) {
                    progressViewButton.d();
                }
                if (eVar.f52602a != 101) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        NewNumberOtpFragment.a(this.f56150a, (ErrorModel) t, eVar.f52605d);
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
                }
                this.f56150a.a((IJRPaytmDataModel) eVar.f52603b, eVar.f52605d);
            }
        }
    }

    public static final class d extends l implements kotlin.g.a.a<Bundle> {
        final /* synthetic */ Fragment $this_navArgs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
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

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_new_number_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (com.paytm.utility.b.r(requireContext())) {
            this.f56146g = "phone_update_login";
        }
        v.a("/new_phone_number_otp", this.f56146g, "new_phone_number_otp_page_loaded", kotlin.a.k.d(c()), 16);
        ai a2 = am.a((Fragment) this).a(k.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…oneViewModel::class.java)");
        this.f56145f = (k) a2;
        g dVar = new androidx.navigation.d(y.b(au.class), new d(this));
        this.f56143d = ((au) dVar.getValue()).b();
        this.f56144e = ((au) dVar.getValue()).a();
        this.f56147h = ((au) dVar.getValue()).c();
        RoboTextView roboTextView = (RoboTextView) a(R.id.lblDesc);
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.lbl_verify_your_new_number, OAuthUtils.e(this.f56144e)));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.btn_confirm));
        }
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtpTextChangeListener(new e(this));
        }
        ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnConfirm);
        if (progressViewButton2 != null) {
            progressViewButton2.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.requestOtp);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        x.a((x) this, false, 7);
    }

    public final void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    public static final class e implements OtpView.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NewNumberOtpFragment f56151a;

        e(NewNumberOtpFragment newNumberOtpFragment) {
            this.f56151a = newNumberOtpFragment;
        }

        public final void a(Editable editable, boolean z) {
            kotlin.g.b.k.c(editable, "s");
            RoboTextView roboTextView = (RoboTextView) this.f56151a.a(R.id.error_text_otp);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
            if (z) {
                v.a("/new_phone_number_otp", this.f56151a.f56146g, "otp_entered", (ArrayList) null, 24);
            }
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.btnConfirm;
        if (valueOf != null && valueOf.intValue() == i2) {
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnConfirm);
            if (progressViewButton == null || !progressViewButton.f56843a) {
                e();
                return;
            }
            return;
        }
        int i3 = R.id.requestOtp;
        if (valueOf != null && valueOf.intValue() == i3 && this.f56144e != null) {
            OtpView otpView = (OtpView) a(R.id.otpContainer);
            if (otpView != null) {
                otpView.a();
            }
            RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
            if (roboTextView != null) {
                roboTextView.setVisibility(8);
            }
            d();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        kotlin.g.b.k.c(str, "otp");
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null) {
            otpView.setOtp(str);
        }
        e();
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j) {
        kotlin.g.b.k.c(aVar, "state");
        int i2 = at.f56384a[aVar.ordinal()];
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
            if (hashCode != 934663560) {
                if (hashCode == 2017232921 && str.equals("oauthResendOtp")) {
                    d();
                }
            } else if (str.equals("userValidateOtpV4")) {
                e();
            }
        }
    }

    private final void d() {
        OAuthUtils.a((Activity) requireActivity());
        if (this.f56145f == null) {
            kotlin.g.b.k.a("viewModel");
        }
        k.a(this.f56143d).observe(this, new b(this));
    }

    private final void e() {
        String otp;
        OtpView otpView = (OtpView) a(R.id.otpContainer);
        if (otpView != null && (otp = otpView.getOtp()) != null) {
            String d2 = d(otp);
            CharSequence charSequence = d2;
            if (!TextUtils.isEmpty(charSequence)) {
                v.a("/new_phone_number_otp", this.f56146g, Events.Action.PROCEED_CLICKED, kotlin.a.k.d("new_number_otp", d2, AppManagerUtil.EXTEND_PREFIX_DEFAULT), 16);
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
            if (this.f56145f == null) {
                kotlin.g.b.k.a("viewModel");
            }
            k.c(otp, this.f56143d).observe(this, new c(this));
        }
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
                if (hashCode != 1537) {
                    if (hashCode == 51511 && responseCode.equals("403")) {
                        RoboTextView roboTextView = (RoboTextView) a(R.id.error_text_otp);
                        if (roboTextView != null) {
                            roboTextView.setVisibility(0);
                        }
                        RoboTextView roboTextView2 = (RoboTextView) a(R.id.error_text_otp);
                        if (roboTextView2 != null) {
                            roboTextView2.setText(updatePhoneResModel.getMessage());
                        }
                        if (kotlin.g.b.k.a((Object) str2, (Object) "userValidateOtpV4")) {
                            String str4 = this.f56146g;
                            String[] strArr = new String[4];
                            strArr[0] = "new_number_otp";
                            String message = updatePhoneResModel.getMessage();
                            if (message != null) {
                                str3 = message;
                            }
                            strArr[1] = str3;
                            strArr[2] = SDKConstants.KEY_API;
                            strArr[3] = updatePhoneResModel.getResponseCode();
                            v.a("/new_phone_number_otp", str4, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr), 16);
                            return;
                        }
                        return;
                    }
                } else if (responseCode.equals(WebLogin.RESPONSE_CODE_SUCCESS)) {
                    if (str2 != null) {
                        int hashCode2 = str.hashCode();
                        if (hashCode2 != 934663560) {
                            if (hashCode2 == 2017232921 && str2.equals("oauthResendOtp")) {
                                kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                                this.f56656b = (long) (net.one97.paytm.oauth.a.b() * 1000);
                                b();
                                x.a((x) this, false, 7);
                                return;
                            }
                            return;
                        } else if (str2.equals("userValidateOtpV4")) {
                            o oVar = o.f56791a;
                            String str5 = this.f56144e;
                            if (str5 != null) {
                                str3 = str5;
                            }
                            o.b(str3);
                            av.a a2 = av.a();
                            kotlin.g.b.k.a((Object) a2, "NewNumberOtpFragmentDire….navNumberUpdateSuccess()");
                            a2.a(this.f56144e);
                            a2.b("/new_phone_number_otp");
                            a2.c(this.f56147h);
                            androidx.navigation.fragment.a.a(this).a((androidx.navigation.l) a2);
                            v.a("/new_phone_number_otp", this.f56146g, "phone_update_successful", kotlin.a.k.d("new_number_otp"), 16);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            if (kotlin.g.b.k.a((Object) str2, (Object) "userValidateOtpV4")) {
                String str6 = this.f56146g;
                String[] strArr2 = new String[4];
                strArr2[0] = "new_number_otp";
                String message2 = updatePhoneResModel.getMessage();
                if (message2 == null) {
                    message2 = str3;
                }
                strArr2[1] = message2;
                strArr2[2] = SDKConstants.KEY_API;
                String responseCode2 = updatePhoneResModel.getResponseCode();
                if (responseCode2 != null) {
                    str3 = responseCode2;
                }
                strArr2[3] = str3;
                v.a("/new_phone_number_otp", str6, Events.Action.PROCEED_CLICKED, kotlin.a.k.d(strArr2), 16);
            }
            com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), updatePhoneResModel.getMessage());
        }
    }

    public static final /* synthetic */ void a(NewNumberOtpFragment newNumberOtpFragment, ErrorModel errorModel, String str) {
        String a2 = super.a(errorModel, str);
        if (!TextUtils.isEmpty(a2)) {
            v.a("/new_phone_number_otp", newNumberOtpFragment.f56146g, Events.Action.PROCEED_CLICKED, kotlin.a.k.d("new_number_otp", a2, SDKConstants.KEY_API, String.valueOf(errorModel.getStatus())), 16);
        }
    }
}
