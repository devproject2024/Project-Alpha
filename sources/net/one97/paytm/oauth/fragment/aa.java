package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.activity.UpdatePhoneNumberActivity;
import net.one97.paytm.oauth.fragment.az;
import net.one97.paytm.oauth.fragment.x;
import net.one97.paytm.oauth.models.DeviceBindingStausResModel;
import net.one97.paytm.oauth.models.DeviceStatusData;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.oauth.utils.x;
import net.one97.paytm.oauth.view.OtpView;
import net.one97.paytm.oauth.view.ProgressViewButton;
import net.one97.paytm.upi.util.Events;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa extends x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56276a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.oauth.g.h f56277c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f56278d;

    /* renamed from: e  reason: collision with root package name */
    private String f56279e;

    /* renamed from: f  reason: collision with root package name */
    private String f56280f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f56281g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f56282h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f56283i;
    /* access modifiers changed from: private */
    public ap j;
    private net.one97.paytm.oauth.d k;
    private long l;
    private HashMap m;

    public final View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.m;
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
        final /* synthetic */ aa f56284a;

        b(aa aaVar) {
            this.f56284a = aaVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            k.c(eVar, Payload.RESPONSE);
            if (eVar.f52602a == 101) {
                this.f56284a.a((IJRPaytmDataModel) eVar.f52603b);
            } else if (eVar.f52602a == 102) {
                this.f56284a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f56285a;

        c(aa aaVar) {
            this.f56285a = aaVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            k.c(eVar, Payload.RESPONSE);
            if (eVar.f52602a == 101) {
                this.f56285a.a((IJRPaytmDataModel) eVar.f52603b);
            } else if (eVar.f52602a == 102) {
                this.f56285a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f56286a;

        d(aa aaVar) {
            this.f56286a = aaVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            k.c(eVar, Payload.RESPONSE);
            OAuthUtils.b((LottieAnimationView) this.f56286a.a(R.id.loader1));
            if (eVar.f52602a == 101) {
                this.f56286a.a((IJRPaytmDataModel) eVar.f52603b);
            } else if (eVar.f52602a == 102) {
                this.f56286a.a((ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
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

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ap) {
            this.j = (ap) context;
            if (context instanceof net.one97.paytm.oauth.d) {
                this.k = (net.one97.paytm.oauth.d) context;
                return;
            }
            throw new IllegalStateException("Activity must implement " + net.one97.paytm.oauth.d.class.getName());
        }
        throw new IllegalStateException("Activity must implement " + ap.class.getName());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_device_binding_otp, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        a("autoread_otp_loaded", (ArrayList<String>) kotlin.a.k.d(c()));
        Bundle arguments = getArguments();
        this.f56282h = arguments != null ? arguments.getBoolean("isfromSignup", false) : false;
        Bundle arguments2 = getArguments();
        this.f56279e = arguments2 != null ? arguments2.getString("login_state_token") : null;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str = arguments3.getString("login_mobile")) == null) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            str = com.paytm.utility.b.ab(b2.getApplicationContext());
        }
        this.f56280f = str;
        Bundle arguments4 = getArguments();
        this.f56283i = arguments4 != null ? arguments4.getBoolean("is_sms_device_binding") : false;
        Fragment fragment = this;
        ai a2 = am.a(fragment).a(net.one97.paytm.oauth.g.h.class);
        k.a((Object) a2, "ViewModelProviders.of(th…OTPViewModel::class.java)");
        this.f56277c = (net.one97.paytm.oauth.g.h) a2;
        x.a((x) this, false, 7);
        RoboTextView roboTextView = (RoboTextView) a(R.id.tvDescription);
        if (roboTextView != null) {
            roboTextView.setText(getString(R.string.lbl_we_have_sent_a_otp, OAuthUtils.e(this.f56280f)));
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton != null) {
            progressViewButton.setButtonText(getString(R.string.lbl_login_securely));
        }
        if (this.f56283i) {
            OAuthUtils.a(fragment);
            ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
            if (progressViewButton2 != null) {
                net.one97.paytm.oauth.utils.h.b(progressViewButton2);
            }
        } else {
            ProgressViewButton progressViewButton3 = (ProgressViewButton) a(R.id.btnProceedSecurely);
            if (progressViewButton3 != null) {
                net.one97.paytm.oauth.utils.h.a(progressViewButton3);
            }
        }
        ProgressViewButton progressViewButton4 = (ProgressViewButton) a(R.id.btnProceedSecurely);
        if (progressViewButton4 != null) {
            progressViewButton4.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.resend_otp);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        q qVar = q.f56798a;
        q.h("device_binding_otp");
        k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        this.l = ((long) net.one97.paytm.oauth.a.o()) * 1000;
        this.f56656b = this.l;
    }

    public final void onStart() {
        super.onStart();
        if (this.f56656b > 0) {
            b();
        }
    }

    public final void onClick(View view) {
        String str;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.resend_otp;
        boolean z = false;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.btnProceedSecurely;
            if (valueOf != null && valueOf.intValue() == i3) {
                ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
                if (progressViewButton != null && !progressViewButton.f56843a) {
                    OAuthUtils.a((Activity) getActivity());
                    this.f56281g = false;
                    if (isVisible()) {
                        OtpView otpView = (OtpView) a(R.id.otpContainer);
                        if (otpView == null || (str = otpView.getOtp()) == null) {
                            str = "";
                        }
                        String d2 = d(str);
                        if (TextUtils.isEmpty(d2)) {
                            z = true;
                        } else {
                            String[] strArr = new String[3];
                            strArr[0] = this.f56281g ? "auto_otp" : "otp";
                            strArr[1] = d2;
                            strArr[2] = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
                            a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr));
                            a(false, true, d2);
                            this.f56281g = false;
                        }
                    }
                    if (z) {
                        d();
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = R.id.lblHavingIssues;
            if (valueOf != null && valueOf.intValue() == i4) {
                OAuthUtils.a((Activity) getActivity());
                Intent intent = new Intent(requireContext(), UpdatePhoneNumberActivity.class);
                intent.putExtra(p.f56797b, this.f56282h ? "/signup" : "/login");
                intent.putExtra("login_mobile", this.f56280f);
                intent.putExtra("stateToken", this.f56279e);
                intent.putExtra("screen_name", "otp_page");
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.startActivityForResult(intent, 1093);
                }
            }
        } else if (this.f56283i) {
            OAuthUtils.a((LottieAnimationView) a(R.id.loader1));
            e();
        } else {
            androidx.fragment.app.q a2 = getChildFragmentManager().a();
            k.a((Object) a2, "childFragmentManager.beginTransaction()");
            az.a aVar = az.f56394a;
            az a3 = az.a.a(false);
            a("resend_popup_loaded", (ArrayList<String>) new ArrayList());
            a3.a((az.b) new h(this, a3));
            a2.a((Fragment) a3, az.class.getName());
            a2.c();
        }
    }

    public static final class h implements az.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f56293a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ az f56294b;

        h(aa aaVar, az azVar) {
            this.f56293a = aaVar;
            this.f56294b = azVar;
        }

        public final void onOptionSelected(boolean z) {
            this.f56293a.f56278d = z;
            this.f56293a.e();
            this.f56293a.a(z ? "resend_otp_call" : "resend_otp_sms", (ArrayList<String>) new ArrayList());
            this.f56294b.dismissAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        String str;
        if (isVisible()) {
            a(true);
            net.one97.paytm.oauth.g.h hVar = this.f56277c;
            if (hVar == null) {
                k.a("viewModel");
            }
            OtpView otpView = (OtpView) a(R.id.otpContainer);
            if (otpView == null || (str = otpView.getOtp()) == null) {
                str = "";
            }
            hVar.a(str, this.f56279e, this.f56280f).observe(this, new b(this));
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        net.one97.paytm.oauth.g.h hVar = this.f56277c;
        if (hVar == null) {
            k.a("viewModel");
        }
        hVar.a(this.f56279e, this.f56278d).observe(this, new d(this));
    }

    public final void a(ErrorModel errorModel, Throwable th, String str) {
        Activity activity = getActivity();
        Fragment fragment = this;
        if (th != null) {
            NetworkCustomError networkCustomError = (NetworkCustomError) th;
            if (!OAuthUtils.a(activity, fragment, networkCustomError)) {
                if (l.a(errorModel)) {
                    net.one97.paytm.oauth.d.a.a(requireContext(), getString(R.string.some_went_wrong), (View.OnClickListener) null);
                } else if (!l.a(errorModel, requireContext(), new e(this, str))) {
                    if (k.a((Object) errorModel != null ? Integer.valueOf(errorModel.getStatus()) : null, (Object) n.f56789h)) {
                        Bundle bundle = new Bundle(getArguments());
                        bundle.putString(p.f56797b, f());
                        ap apVar = this.j;
                        if (apVar != null) {
                            apVar.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
                        }
                        Toast.makeText(requireContext(), getString(R.string.lbl_session_expired_proceed_again), 1).show();
                        return;
                    }
                    if (k.a((Object) errorModel != null ? Integer.valueOf(errorModel.getStatus()) : null, (Object) n.f56788g)) {
                        byte[] bArr = networkCustomError.networkResponse.data;
                        k.a((Object) bArr, "throwable.networkResponse.data");
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
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
        }
    }

    static final class e implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f56287a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56288b;

        e(aa aaVar, String str) {
            this.f56287a = aaVar;
            this.f56288b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f56287a.b(this.f56288b);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof SimplifiedLoginInit) {
            SimplifiedLoginInit simplifiedLoginInit = (SimplifiedLoginInit) iJRPaytmDataModel;
            if (!k.a((Object) "BE1400001", (Object) simplifiedLoginInit.getResponseCode())) {
                a(false);
                OtpView otpView = (OtpView) a(R.id.otpContainer);
                if (otpView != null) {
                    otpView.a();
                }
                String str = "auto_otp";
                if (!TextUtils.isEmpty(simplifiedLoginInit.getMessage())) {
                    a(false, true, simplifiedLoginInit.getMessage());
                    String[] strArr = new String[4];
                    if (!this.f56281g) {
                        str = "otp";
                    }
                    strArr[0] = str;
                    strArr[1] = "";
                    strArr[2] = SDKConstants.KEY_API;
                    String responseCode = simplifiedLoginInit.getResponseCode();
                    k.a((Object) responseCode, "model.responseCode");
                    strArr[3] = responseCode;
                    a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr));
                    return;
                }
                String[] strArr2 = new String[4];
                if (!this.f56281g) {
                    str = "otp";
                }
                strArr2[0] = str;
                String string = getString(R.string.some_went_wrong);
                k.a((Object) string, "getString(R.string.some_went_wrong)");
                strArr2[1] = string;
                strArr2[2] = SDKConstants.KEY_API;
                String responseCode2 = simplifiedLoginInit.getResponseCode();
                k.a((Object) responseCode2, "model.responseCode");
                strArr2[3] = responseCode2;
                a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) kotlin.a.k.d(strArr2));
                a(false, true, getString(R.string.some_went_wrong));
            } else if (isVisible()) {
                a(true);
                net.one97.paytm.oauth.g.h hVar = this.f56277c;
                if (hVar == null) {
                    k.a("viewModel");
                }
                hVar.a(this.f56279e).observe(this, new c(this));
            }
        } else {
            String str2 = null;
            if (iJRPaytmDataModel instanceof DeviceBindingStausResModel) {
                DeviceBindingStausResModel deviceBindingStausResModel = (DeviceBindingStausResModel) iJRPaytmDataModel;
                if (k.a((Object) "BE1400001", (Object) deviceBindingStausResModel.getResponseCode())) {
                    DeviceStatusData data = deviceBindingStausResModel.getData();
                    if (data != null) {
                        str2 = data.getDeviceBindingStatus();
                    }
                    if (str2 != null) {
                        int hashCode = str2.hashCode();
                        if (hashCode != -1809526922) {
                            if (hashCode == 1982485311 && str2.equals("CONFIRMED")) {
                                g();
                                net.one97.paytm.oauth.d dVar = this.k;
                                if (dVar != null) {
                                    String str3 = this.f56280f;
                                    String str4 = this.f56279e;
                                    boolean z = this.f56282h;
                                    dVar.a(str3, str4, z, z ? i.SIGNUP : i.LOGIN);
                                    return;
                                }
                                return;
                            }
                        } else if (str2.equals("CLAIMABLE")) {
                            g();
                            Bundle bundle = new Bundle(getArguments());
                            bundle.putString(p.f56797b, f());
                            bundle.putString("login_state_token", this.f56279e);
                            ap apVar = this.j;
                            if (apVar != null) {
                                apVar.a("FRAGMENT_ACCOUNT_CLAIM", bundle, true);
                                return;
                            }
                            return;
                        }
                    }
                    a(false);
                    a(false, true, deviceBindingStausResModel.getMessage());
                    return;
                }
                a(false, true, deviceBindingStausResModel.getMessage());
            } else if (iJRPaytmDataModel instanceof UpdatePhoneResModel) {
                UpdatePhoneResModel updatePhoneResModel = (UpdatePhoneResModel) iJRPaytmDataModel;
                String responseCode3 = updatePhoneResModel.getResponseCode();
                String message = updatePhoneResModel.getMessage();
                String state = updatePhoneResModel.getState();
                OtpView otpView2 = (OtpView) a(R.id.otpContainer);
                if (otpView2 != null) {
                    otpView2.a();
                }
                if (k.a((Object) WebLogin.RESPONSE_CODE_SUCCESS, (Object) responseCode3)) {
                    x.a((x) this, false, 7);
                    this.f56656b = this.l;
                    b();
                    if (!TextUtils.isEmpty(state)) {
                        this.f56279e = state;
                    }
                    a("resend_otp_clicked", (ArrayList<String>) new ArrayList());
                } else if (k.a((Object) "708", (Object) responseCode3)) {
                    net.one97.paytm.oauth.d.a.a(requireContext(), message, (View.OnClickListener) new f(this, message));
                } else {
                    String string2 = TextUtils.isEmpty(message) ? getString(R.string.some_went_wrong) : message;
                    if (message == null) {
                        message = "";
                    }
                    v.a("resend_otp_clicked", message, SDKConstants.KEY_API, (ArrayList) null, 24);
                    a(false, true, string2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, ArrayList<String> arrayList) {
        OauthModule.b().sendGAMultipleLabelEvent(getContext(), this.f56282h ? "signup" : "login", str, arrayList, (String) null, f(), p.f56796a);
    }

    private final void a(boolean z) {
        if (z) {
            if (this.f56283i) {
                OAuthUtils.a((LottieAnimationView) a(R.id.loader1));
                return;
            }
            ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceedSecurely);
            if (progressViewButton != null) {
                progressViewButton.c();
            }
        } else if (this.f56283i) {
            OAuthUtils.b((LottieAnimationView) a(R.id.loader1));
        } else {
            ProgressViewButton progressViewButton2 = (ProgressViewButton) a(R.id.btnProceedSecurely);
            if (progressViewButton2 != null) {
                progressViewButton2.d();
            }
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f56291a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56292b;

        g(aa aaVar, String str) {
            this.f56291a = aaVar;
            this.f56292b = str;
        }

        public final void run() {
            x xVar = x.f56805a;
            String a2 = x.a(this.f56291a.getContext(), this.f56292b);
            "Paytm SenderId:".concat(String.valueOf(a2));
            com.paytm.utility.q.b();
            List<String> c2 = OAuthUtils.c();
            if (a2 != null) {
                k.a((Object) c2, "availableSenderIds");
                Iterable iterable = c2;
                boolean z = false;
                if (!((Collection) iterable).isEmpty()) {
                    Iterator it2 = iterable.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        String str = (String) it2.next();
                        Locale locale = Locale.ROOT;
                        k.a((Object) locale, "Locale.ROOT");
                        if (a2 != null) {
                            String lowerCase = a2.toLowerCase(locale);
                            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            k.a((Object) str, "it");
                            if (kotlin.m.p.a((CharSequence) lowerCase, (CharSequence) str, false)) {
                                z = true;
                                break;
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
                if (z) {
                    this.f56291a.f56281g = true;
                    OtpView otpView = (OtpView) this.f56291a.a(R.id.otpContainer);
                    if (otpView != null) {
                        otpView.setOtp(this.f56292b);
                    }
                    this.f56291a.d();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        k.c(str, "otp");
        new Handler().postDelayed(new g(this, str), 2000);
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aa f56289a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56290b;

        f(aa aaVar, String str) {
            this.f56289a = aaVar;
            this.f56290b = str;
        }

        public final void onClick(View view) {
            Bundle bundle = new Bundle(this.f56289a.getArguments());
            bundle.putString(p.f56797b, this.f56289a.f());
            ap e2 = this.f56289a.j;
            if (e2 != null) {
                e2.a("FRAGMENT_LOGIN_MOBILE", bundle, false);
            }
            String str = this.f56290b;
            if (str == null) {
                str = "";
            }
            v.a("resend_otp_clicked", str, SDKConstants.KEY_API, (ArrayList) null, 24);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(x.a aVar, long j2) {
        k.c(aVar, "state");
        int i2 = ab.f56295a[aVar.ordinal()];
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
            long minutes = TimeUnit.MILLISECONDS.toMinutes(j2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j2));
            long seconds = TimeUnit.MILLISECONDS.toSeconds(j2) - TimeUnit.MINUTES.toMinutes(TimeUnit.MILLISECONDS.toMinutes(j2));
            String string = getString(R.string.lbl_auto_reading_otp, Long.valueOf(minutes), Long.valueOf(seconds));
            k.a((Object) string, "getString(R.string.lbl_a…ng_otp, minutes, seconds)");
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

    /* access modifiers changed from: private */
    public final String f() {
        return this.f56282h ? "/signup-otp" : "/login-otp";
    }

    private final void g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f56281g ? "auto_otp" : "otp");
        a(Events.Action.PROCEED_CLICKED, (ArrayList<String>) arrayList);
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -183116971) {
                if (hashCode == 629923750 && str.equals("oauthdevicebindingConfirmSv1")) {
                    d();
                }
            } else if (str.equals("OauthResendOTPSV1")) {
                e();
            }
        }
    }

    public static final aa a(Bundle bundle) {
        aa aaVar = new aa();
        aaVar.setArguments(bundle);
        return aaVar;
    }
}
