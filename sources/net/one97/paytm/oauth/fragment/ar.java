package net.one97.paytm.oauth.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.e.g;
import net.one97.paytm.oauth.models.DataModel;
import net.one97.paytm.oauth.models.DeviceBindingInitResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.p;

public final class ar extends u implements net.one97.paytm.oauth.e.b {

    /* renamed from: c  reason: collision with root package name */
    public static final b f56364c = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.oauth.g.e f56365b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f56366d = "sms";

    /* renamed from: e  reason: collision with root package name */
    private ap f56367e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.oauth.d f56368f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f56369g = "";
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f56370h = "";

    /* renamed from: i  reason: collision with root package name */
    private CoroutineScope f56371i;
    /* access modifiers changed from: private */
    public g j;
    private net.one97.paytm.oauth.utils.e k = new net.one97.paytm.oauth.utils.e();
    private boolean l;
    private final CoroutineExceptionHandler m = new a(CoroutineExceptionHandler.Key, this);
    private HashMap n;

    public final View a(int i2) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.n.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ar f56372a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f.c cVar, ar arVar) {
            super(cVar);
            this.f56372a = arVar;
        }

        public final void handleException(f fVar, Throwable th) {
            th.getLocalizedMessage();
            FragmentActivity activity = this.f56372a.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new C1050a(this));
            }
        }

        /* renamed from: net.one97.paytm.oauth.fragment.ar$a$a  reason: collision with other inner class name */
        static final class C1050a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f56373a;

            C1050a(a aVar) {
                this.f56373a = aVar;
            }

            public final void run() {
                g a2 = this.f56373a.f56372a.j;
                if (a2 != null) {
                    a2.a();
                }
                net.one97.paytm.oauth.d.a.a(this.f56373a.f56372a.getContext(), this.f56373a.f56372a.getString(R.string.some_went_wrong), (View.OnClickListener) null);
            }
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof ap) {
            this.f56367e = (ap) context;
        }
        if (context instanceof net.one97.paytm.oauth.d) {
            this.f56368f = (net.one97.paytm.oauth.d) context;
        }
    }

    public final void onStart() {
        super.onStart();
        this.f56371i = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(e.f56377a);
        }
        return layoutInflater.inflate(R.layout.fragment_dialog_login_parent, viewGroup, false);
    }

    static final class e implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final e f56377a = new e();

        e() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                Window window = aVar.getWindow();
                if (!(window == null || (findViewById = window.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
                    findViewById.setBackgroundResource(17170445);
                }
                View findViewById2 = aVar.findViewById(com.google.android.material.R.id.design_bottom_sheet);
                if (findViewById2 != null) {
                    BottomSheetBehavior from = BottomSheetBehavior.from(findViewById2);
                    k.a((Object) from, "BottomSheetBehavior.from(it)");
                    from.setState(3);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("login_mobile");
            if (string == null) {
                string = "";
            }
            this.f56369g = string;
            this.l = arguments.getBoolean("is_new_signup");
            String string2 = arguments.getString("login_signup_flow");
            if (string2 == null) {
                string2 = "login";
            }
            this.f56370h = string2;
            String string3 = arguments.getString("device_binding_flow");
            if (string3 == null) {
                string3 = "sms";
            }
            this.f56366d = string3;
        }
        Fragment fragment = this;
        ai a2 = am.a(fragment).a(net.one97.paytm.oauth.g.e.class);
        k.a((Object) a2, "ViewModelProviders.of(th…nitViewModel::class.java)");
        this.f56365b = (net.one97.paytm.oauth.g.e) a2;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("binding_state") : null;
        if (serializable != null) {
            net.one97.paytm.oauth.utils.e.a((net.one97.paytm.oauth.utils.g) serializable, getArguments(), fragment, R.id.container);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.utils.DeviceBindingState");
    }

    public final void onStop() {
        super.onStop();
        CoroutineScope coroutineScope = this.f56371i;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void b() {
        dismissAllowingStateLoss();
    }

    public final void a(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.SELECT_SIM_CARD, bundle, this, R.id.container);
    }

    public final void b(Bundle bundle) {
        k.c(bundle, "bundle");
        try {
            net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.SMS_SEND_FAILED, bundle, this, R.id.container);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.VERIFICATION_SUCCESS, bundle, this, R.id.container);
    }

    public final void d(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.VERIFICATION_FAILED, bundle, this, R.id.container);
    }

    public final void e(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.VERIFYING_NUMBER, bundle, this, R.id.container);
    }

    public final void f(Bundle bundle) {
        k.c(bundle, "bundle");
        dismissAllowingStateLoss();
        bundle.putString("login_state_token", bundle.getString(H5Param.SESSION_ID));
        ap apVar = this.f56367e;
        if (apVar != null) {
            apVar.a("FRAGMENT_ACCOUNT_CLAIM", bundle, true);
        }
    }

    public final void h(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.DONT_HAVE_SIM, bundle, this, R.id.container);
    }

    public final void i(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.SINGLE_SIM_MISMATCH, bundle, this, R.id.container);
    }

    public final void j(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.DUAL_SIM_MISMATCH, bundle, this, R.id.container);
    }

    public final void a(String str, String str2, boolean z, i iVar) {
        k.c(iVar, "flowType");
        net.one97.paytm.oauth.d dVar = this.f56368f;
        if (dVar != null) {
            dVar.a(str, str2, z, iVar);
        }
    }

    public final void a(Bundle bundle, g gVar) {
        k.c(bundle, "bundle");
        String string = bundle.getString("device_binding_flow", "sms");
        k.a((Object) string, "bundle.getString(EXTRA_D…OW,DeviceBindingFlow.SMS)");
        this.f56366d = string;
        this.j = gVar;
        a(bundle, false);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, Bundle bundle) {
        String string;
        String str;
        String sessionId;
        String string2;
        String string3;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        Bundle bundle2 = bundle;
        if (iJRPaytmDataModel2 instanceof DeviceBindingInitResModel) {
            DeviceBindingInitResModel deviceBindingInitResModel = (DeviceBindingInitResModel) iJRPaytmDataModel2;
            String responseCode = deviceBindingInitResModel.getResponseCode();
            String str2 = "signup";
            String str3 = "";
            if (responseCode != null) {
                int hashCode = responseCode.hashCode();
                if (hashCode != -1260518837) {
                    if (hashCode != -1258552631) {
                        if (hashCode == -1258493018 && responseCode.equals("BE1426011")) {
                            String[] strArr = new String[4];
                            if (!(bundle2 == null || (string3 = bundle2.getString(p.f56797b)) == null)) {
                                str3 = string3;
                            }
                            strArr[0] = str3;
                            strArr[1] = String.valueOf(deviceBindingInitResModel.getMessage());
                            strArr[2] = SDKConstants.KEY_API;
                            strArr[3] = deviceBindingInitResModel.getResponseCode();
                            ArrayList d2 = kotlin.a.k.d(strArr);
                            if (!this.l) {
                                str2 = "login";
                            }
                            a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d2, str2);
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("message", String.valueOf(deviceBindingInitResModel.getMessage()));
                            bundle3.putBoolean("IS_SHOW_RAISE_REQUEST", false);
                            OAuthUtils.a(getChildFragmentManager(), bundle3);
                            return;
                        }
                    } else if (responseCode.equals("BE1424001")) {
                        String[] strArr2 = new String[4];
                        if (!(bundle2 == null || (string2 = bundle2.getString(p.f56797b)) == null)) {
                            str3 = string2;
                        }
                        strArr2[0] = str3;
                        strArr2[1] = String.valueOf(deviceBindingInitResModel.getMessage());
                        strArr2[2] = SDKConstants.KEY_API;
                        strArr2[3] = deviceBindingInitResModel.getResponseCode();
                        ArrayList d3 = kotlin.a.k.d(strArr2);
                        if (!this.l) {
                            str2 = "login";
                        }
                        a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d3, str2);
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("message", String.valueOf(deviceBindingInitResModel.getMessage()));
                        bundle4.putBoolean("IS_SHOW_RAISE_REQUEST", true);
                        OAuthUtils.a(getChildFragmentManager(), bundle4);
                        return;
                    }
                } else if (responseCode.equals("BE1400001")) {
                    if (bundle2 == null || (str = bundle2.getString(p.f56797b)) == null) {
                        str = str3;
                    }
                    ArrayList d4 = kotlin.a.k.d(str);
                    if (!this.l) {
                        str2 = "login";
                    }
                    a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d4, str2);
                    if (bundle2 != null) {
                        DataModel data = deviceBindingInitResModel.getData();
                        bundle2.putString(H5Param.SESSION_ID, data != null ? data.getSessionId() : null);
                    }
                    if (k.a((Object) this.f56366d, (Object) "otp")) {
                        DataModel data2 = deviceBindingInitResModel.getData();
                        if (!(data2 == null || (sessionId = data2.getSessionId()) == null)) {
                            str3 = sessionId;
                        }
                        Bundle bundle5 = new Bundle();
                        bundle5.putString(p.f56797b, str);
                        bundle5.putString("login_state_token", str3);
                        bundle5.putString("login_mobile", this.f56369g);
                        bundle5.putBoolean("isfromSignup", this.l);
                        bundle5.putBoolean("is_sms_device_binding", true);
                        ap apVar = this.f56367e;
                        if (apVar != null) {
                            apVar.a("FRAGMENT_DEVICE_BINDING_OTP", bundle5, true);
                        }
                        dismissAllowingStateLoss();
                        return;
                    }
                    e(bundle2 == null ? new Bundle() : bundle2);
                    return;
                }
            }
            String[] strArr3 = new String[4];
            if (!(bundle2 == null || (string = bundle2.getString(p.f56797b)) == null)) {
                str3 = string;
            }
            strArr3[0] = str3;
            strArr3[1] = String.valueOf(deviceBindingInitResModel.getMessage());
            strArr3[2] = SDKConstants.KEY_API;
            strArr3[3] = String.valueOf(deviceBindingInitResModel.getResponseCode());
            ArrayList d5 = kotlin.a.k.d(strArr3);
            if (!this.l) {
                str2 = "login";
            }
            a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d5, str2);
            g gVar = this.j;
            if (gVar != null) {
                gVar.a();
            }
            net.one97.paytm.oauth.d.a.a(getContext(), deviceBindingInitResModel.getMessage(), (View.OnClickListener) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a9, code lost:
        if (r7 != r8.intValue()) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b8, code lost:
        if (r7 == r8.intValue()) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01be, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) "oauthdevicebindinginitSv1") == false) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c0, code lost:
        r0 = new java.lang.String[4];
        r2 = r2.getString(net.one97.paytm.oauth.utils.p.f56797b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c9, code lost:
        if (r2 != null) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cc, code lost:
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cd, code lost:
        r0[0] = r15;
        r2 = r4.getString("message");
        kotlin.g.b.k.a((java.lang.Object) r2, "jsonObj.getString(KEY_MESSAGE)");
        r0[1] = r2;
        r0[2] = net.one97.paytm.nativesdk.Constants.SDKConstants.KEY_API;
        kotlin.g.b.k.a((java.lang.Object) r6, "responseCode");
        r0[3] = r6;
        r0 = kotlin.a.k.d(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ea, code lost:
        if (r1.l == false) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01ec, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01ef, code lost:
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f1, code lost:
        a("/login-signup", "login_signup", "device_binding_successful", (java.util.ArrayList<java.lang.String>) r0, r2);
        com.paytm.utility.b.b(requireContext(), getString(net.one97.paytm.oauth.R.string.oauth_error), getString(net.one97.paytm.oauth.R.string.some_went_wrong));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0207, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.oauth.models.ErrorModel r20, java.lang.Throwable r21, android.os.Bundle r22, java.lang.String r23) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r22
            r3 = r23
            java.lang.String r4 = "bundle"
            kotlin.g.b.k.c(r2, r4)
            androidx.fragment.app.FragmentActivity r4 = r19.getActivity()
            android.app.Activity r4 = (android.app.Activity) r4
            r5 = r1
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            if (r21 == 0) goto L_0x0249
            r6 = r21
            com.paytm.network.model.NetworkCustomError r6 = (com.paytm.network.model.NetworkCustomError) r6
            boolean r4 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r4, (androidx.fragment.app.Fragment) r5, (com.paytm.network.model.NetworkCustomError) r6)
            if (r4 == 0) goto L_0x0026
            r19.dismissAllowingStateLoss()
            return
        L_0x0026:
            boolean r4 = net.one97.paytm.oauth.utils.l.a((net.one97.paytm.oauth.models.ErrorModel) r20)
            r5 = 1
            if (r4 == 0) goto L_0x0031
            r1.a((android.os.Bundle) r2, (boolean) r5)
            return
        L_0x0031:
            android.content.Context r4 = r19.requireContext()
            net.one97.paytm.oauth.fragment.ar$d r6 = new net.one97.paytm.oauth.fragment.ar$d
            r6.<init>(r1, r2)
            android.content.DialogInterface$OnClickListener r6 = (android.content.DialogInterface.OnClickListener) r6
            boolean r4 = net.one97.paytm.oauth.utils.l.a(r0, r4, r6)
            if (r4 != 0) goto L_0x0248
            if (r0 == 0) goto L_0x0049
            com.paytm.network.model.NetworkCustomError r4 = r20.getCustomError()
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            boolean r4 = r4 instanceof com.paytm.network.model.NetworkCustomError
            if (r4 == 0) goto L_0x0235
            com.paytm.network.model.NetworkCustomError r4 = r20.getCustomError()
            com.paytm.network.model.NetworkResponse r4 = r4.networkResponse
            byte[] r4 = r4.data
            if (r4 == 0) goto L_0x0234
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r7 = kotlin.m.d.f47971a
            r6.<init>(r4, r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0221
            java.lang.String r6 = new java.lang.String     // Catch:{ JSONException -> 0x021c }
            java.nio.charset.Charset r7 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x021c }
            r6.<init>(r4, r7)     // Catch:{ JSONException -> 0x021c }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x021c }
            r4.<init>(r6)     // Catch:{ JSONException -> 0x021c }
            java.lang.String r6 = "responseCode"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ JSONException -> 0x021c }
            int r7 = r20.getStatus()     // Catch:{ JSONException -> 0x021c }
            java.lang.Integer r8 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x021c }
            java.lang.String r9 = "signup"
            java.lang.String r10 = "login"
            java.lang.String r12 = "api"
            java.lang.String r14 = "jsonObj.getString(KEY_MESSAGE)"
            java.lang.String r15 = ""
            r16 = 0
            java.lang.String r13 = "device_binding_successful"
            java.lang.String r11 = "login_signup"
            java.lang.String r5 = "/login-signup"
            java.lang.String r0 = "oauthdevicebindinginitSv1"
            r17 = r9
            java.lang.String r9 = "message"
            if (r8 != 0) goto L_0x009a
            goto L_0x00df
        L_0x009a:
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x021c }
            if (r7 != r8) goto L_0x00df
            java.lang.String r7 = "BE1423003"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x021c }
            if (r7 == 0) goto L_0x00df
            r7 = 1
            r1.a((android.os.Bundle) r2, (boolean) r7)     // Catch:{ JSONException -> 0x021c }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x021c }
            if (r0 == 0) goto L_0x0234
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x021c }
            java.lang.String r3 = net.one97.paytm.oauth.utils.p.f56797b     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x021c }
            if (r2 != 0) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r15 = r2
        L_0x00bf:
            r0[r16] = r15     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r4.getString(r9)     // Catch:{ JSONException -> 0x021c }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x021c }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x021c }
            r2 = 2
            r0[r2] = r12     // Catch:{ JSONException -> 0x021c }
            r2 = 3
            r0[r2] = r6     // Catch:{ JSONException -> 0x021c }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x021c }
            boolean r2 = r1.l     // Catch:{ JSONException -> 0x021c }
            if (r2 == 0) goto L_0x00db
            r10 = r17
        L_0x00db:
            a((java.lang.String) r5, (java.lang.String) r11, (java.lang.String) r13, (java.util.ArrayList<java.lang.String>) r0, (java.lang.String) r10)     // Catch:{ JSONException -> 0x021c }
            return
        L_0x00df:
            int r7 = r20.getStatus()     // Catch:{ JSONException -> 0x021c }
            java.lang.Integer r8 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x021c }
            if (r8 != 0) goto L_0x00ea
        L_0x00e7:
            r18 = r10
            goto L_0x0141
        L_0x00ea:
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x021c }
            if (r7 != r8) goto L_0x00e7
            java.lang.String r7 = "BE1423002"
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x021c }
            if (r7 == 0) goto L_0x00e7
            android.content.Context r7 = r19.requireContext()     // Catch:{ JSONException -> 0x021c }
            int r8 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x021c }
            java.lang.String r8 = r1.getString(r8)     // Catch:{ JSONException -> 0x021c }
            r18 = r10
            java.lang.String r10 = r4.getString(r9)     // Catch:{ JSONException -> 0x021c }
            com.paytm.utility.b.b((android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r10)     // Catch:{ JSONException -> 0x021c }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x021c }
            if (r0 == 0) goto L_0x0234
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x021c }
            java.lang.String r3 = net.one97.paytm.oauth.utils.p.f56797b     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x021c }
            if (r2 != 0) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r15 = r2
        L_0x011e:
            r0[r16] = r15     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r4.getString(r9)     // Catch:{ JSONException -> 0x021c }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x021c }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x021c }
            r2 = 2
            r0[r2] = r12     // Catch:{ JSONException -> 0x021c }
            r2 = 3
            r0[r2] = r6     // Catch:{ JSONException -> 0x021c }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x021c }
            boolean r2 = r1.l     // Catch:{ JSONException -> 0x021c }
            if (r2 == 0) goto L_0x013b
            r2 = r17
            goto L_0x013d
        L_0x013b:
            r2 = r18
        L_0x013d:
            a((java.lang.String) r5, (java.lang.String) r11, (java.lang.String) r13, (java.util.ArrayList<java.lang.String>) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x021c }
            return
        L_0x0141:
            int r7 = r20.getStatus()     // Catch:{ JSONException -> 0x021c }
            java.lang.Integer r8 = net.one97.paytm.oauth.utils.n.f56788g     // Catch:{ JSONException -> 0x021c }
            if (r8 != 0) goto L_0x014a
            goto L_0x019c
        L_0x014a:
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x021c }
            if (r7 != r8) goto L_0x019c
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x021c }
            if (r7 == 0) goto L_0x019c
            android.content.Context r0 = r19.requireContext()     // Catch:{ JSONException -> 0x021c }
            int r3 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x021c }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x021c }
            java.lang.String r7 = r4.getString(r9)     // Catch:{ JSONException -> 0x021c }
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r3, (java.lang.String) r7)     // Catch:{ JSONException -> 0x021c }
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x021c }
            java.lang.String r3 = net.one97.paytm.oauth.utils.p.f56797b     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x021c }
            if (r2 != 0) goto L_0x0173
            goto L_0x0174
        L_0x0173:
            r15 = r2
        L_0x0174:
            r0[r16] = r15     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r4.getString(r9)     // Catch:{ JSONException -> 0x021c }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x021c }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x021c }
            r2 = 2
            r0[r2] = r12     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = "responseCode"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)     // Catch:{ JSONException -> 0x021c }
            r2 = 3
            r0[r2] = r6     // Catch:{ JSONException -> 0x021c }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x021c }
            boolean r2 = r1.l     // Catch:{ JSONException -> 0x021c }
            if (r2 == 0) goto L_0x0196
            r2 = r17
            goto L_0x0198
        L_0x0196:
            r2 = r18
        L_0x0198:
            a((java.lang.String) r5, (java.lang.String) r11, (java.lang.String) r13, (java.util.ArrayList<java.lang.String>) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x021c }
            return
        L_0x019c:
            int r7 = r20.getStatus()     // Catch:{ JSONException -> 0x021c }
            java.lang.Integer r8 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x021c }
            if (r8 != 0) goto L_0x01a5
            goto L_0x01ab
        L_0x01a5:
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x021c }
            if (r7 == r8) goto L_0x01ba
        L_0x01ab:
            int r7 = r20.getStatus()     // Catch:{ JSONException -> 0x021c }
            java.lang.Integer r8 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x021c }
            if (r8 != 0) goto L_0x01b4
            goto L_0x0208
        L_0x01b4:
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x021c }
            if (r7 != r8) goto L_0x0208
        L_0x01ba:
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x021c }
            if (r0 == 0) goto L_0x0208
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x021c }
            java.lang.String r3 = net.one97.paytm.oauth.utils.p.f56797b     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x021c }
            if (r2 != 0) goto L_0x01cc
            goto L_0x01cd
        L_0x01cc:
            r15 = r2
        L_0x01cd:
            r0[r16] = r15     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r4.getString(r9)     // Catch:{ JSONException -> 0x021c }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x021c }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x021c }
            r2 = 2
            r0[r2] = r12     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = "responseCode"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)     // Catch:{ JSONException -> 0x021c }
            r2 = 3
            r0[r2] = r6     // Catch:{ JSONException -> 0x021c }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x021c }
            boolean r2 = r1.l     // Catch:{ JSONException -> 0x021c }
            if (r2 == 0) goto L_0x01ef
            r2 = r17
            goto L_0x01f1
        L_0x01ef:
            r2 = r18
        L_0x01f1:
            a((java.lang.String) r5, (java.lang.String) r11, (java.lang.String) r13, (java.util.ArrayList<java.lang.String>) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x021c }
            android.content.Context r0 = r19.requireContext()     // Catch:{ JSONException -> 0x021c }
            int r2 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ JSONException -> 0x021c }
            int r3 = net.one97.paytm.oauth.R.string.some_went_wrong     // Catch:{ JSONException -> 0x021c }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x021c }
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ JSONException -> 0x021c }
            return
        L_0x0208:
            android.content.Context r0 = r19.requireContext()     // Catch:{ JSONException -> 0x021c }
            int r2 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x021c }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ JSONException -> 0x021c }
            int r3 = net.one97.paytm.oauth.R.string.some_went_wrong     // Catch:{ JSONException -> 0x021c }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x021c }
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ JSONException -> 0x021c }
            return
        L_0x021c:
            r0 = move-exception
            r0.printStackTrace()
            return
        L_0x0221:
            android.content.Context r0 = r19.requireContext()
            int r2 = net.one97.paytm.oauth.R.string.oauth_error
            java.lang.String r2 = r1.getString(r2)
            int r3 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r3 = r1.getString(r3)
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0234:
            return
        L_0x0235:
            android.content.Context r0 = r19.requireContext()
            int r2 = net.one97.paytm.oauth.R.string.oauth_error
            java.lang.String r2 = r1.getString(r2)
            int r3 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r3 = r1.getString(r3)
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0248:
            return
        L_0x0249:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.ar.a(net.one97.paytm.oauth.models.ErrorModel, java.lang.Throwable, android.os.Bundle, java.lang.String):void");
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ar f56375a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f56376b;

        d(ar arVar, Bundle bundle) {
            this.f56375a = arVar;
            this.f56376b = bundle;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            ar arVar = this.f56375a;
            arVar.a(this.f56376b, arVar.j);
        }
    }

    private final void a(Bundle bundle, boolean z) {
        CoroutineScope coroutineScope = this.f56371i;
        if (coroutineScope != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, this.m, (CoroutineStart) null, new c(this, z, bundle, (kotlin.d.d) null), 2, (Object) null);
        }
    }

    @kotlin.d.b.a.f(b = "LoginParentDialogFragment.kt", c = {278}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.LoginParentDialogFragment$checkKeysAndCallInitApi$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ Bundle $bundle;
        final /* synthetic */ boolean $deleteKeys;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ ar this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ar arVar, boolean z, Bundle bundle, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = arVar;
            this.$deleteKeys = z;
            this.$bundle = bundle;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$deleteKeys, this.$bundle, dVar);
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
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new m<CoroutineScope, kotlin.d.d<? super Boolean>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private CoroutineScope p$;
                    final /* synthetic */ c this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        public final void g(Bundle bundle) {
                            k.c(bundle, "bundle");
                            dismissAllowingStateLoss();
                        }
                    }
