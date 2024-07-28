package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import java.io.Serializable;
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
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.asynctask.EncryptedTokenWorker;
import net.one97.paytm.oauth.fragment.bf;
import net.one97.paytm.oauth.fragment.bj;
import net.one97.paytm.oauth.fragment.bl;
import net.one97.paytm.oauth.fragment.bn;
import net.one97.paytm.oauth.models.AuthorizationData;
import net.one97.paytm.oauth.models.AuthorizationInitResModel;
import net.one97.paytm.oauth.models.AuthorizationResModel;
import net.one97.paytm.oauth.models.CJRAccessToken;
import net.one97.paytm.oauth.models.DataResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.TokenV3ResModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.i;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;

public final class bi extends u implements net.one97.paytm.oauth.e.d {

    /* renamed from: b  reason: collision with root package name */
    public static final b f56437b = new b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.oauth.e.e f56438c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.oauth.g.g f56439d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.oauth.utils.b f56440e = net.one97.paytm.oauth.utils.b.VERTICAL;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f56441f = "";

    /* renamed from: g  reason: collision with root package name */
    private boolean f56442g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f56443h = "";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f56444i = "login";
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public String k = "";
    private CoroutineScope l;
    /* access modifiers changed from: private */
    public net.one97.paytm.oauth.e.g m;
    /* access modifiers changed from: private */
    public String n = "sms";
    private net.one97.paytm.oauth.utils.e o = new net.one97.paytm.oauth.utils.e();
    private final CoroutineExceptionHandler p = new a(CoroutineExceptionHandler.Key, this);
    private HashMap q;

    public final View a(int i2) {
        if (this.q == null) {
            this.q = new HashMap();
        }
        View view = (View) this.q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.q;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bi f56447a;

        c(bi biVar) {
            this.f56447a = biVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            k.c(eVar, Payload.RESPONSE);
            if (eVar.f52602a == 101) {
                AuthorizationInitResModel authorizationInitResModel = (AuthorizationInitResModel) eVar.f52603b;
                String str = null;
                if (k.a((Object) "BE1400001", (Object) authorizationInitResModel != null ? authorizationInitResModel.getResponseCode() : null)) {
                    bi biVar = this.f56447a;
                    DataResModel data = authorizationInitResModel.getData();
                    String authenticationValueType = data != null ? data.getAuthenticationValueType() : null;
                    DataResModel data2 = authorizationInitResModel.getData();
                    if (data2 != null) {
                        str = data2.getStateToken();
                    }
                    bi.a(biVar, authenticationValueType, str);
                    return;
                }
                net.one97.paytm.oauth.d.a.a(this.f56447a.requireContext(), authorizationInitResModel != null ? authorizationInitResModel.getMessage() : null, (View.OnClickListener) null);
                this.f56447a.k(new Bundle());
            } else if (eVar.f52602a == 102) {
                this.f56447a.a((ErrorModel) eVar.f52603b, eVar.f52604c, new Bundle(), eVar.f52605d);
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bi f56448a;

        d(bi biVar) {
            this.f56448a = biVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            k.c(eVar, Payload.RESPONSE);
            if (eVar.f52602a == 101) {
                AuthorizationResModel authorizationResModel = (AuthorizationResModel) eVar.f52603b;
                if (k.a((Object) "BE1400001", (Object) authorizationResModel != null ? authorizationResModel.getResponseCode() : null)) {
                    bi biVar = this.f56448a;
                    AuthorizationData data = authorizationResModel.getData();
                    if (data == null || (str = data.getCode()) == null) {
                        str = "";
                    }
                    biVar.a(str, this.f56448a.f56443h, this.f56448a.j);
                    return;
                }
                net.one97.paytm.oauth.d.a.a(this.f56448a.requireContext(), authorizationResModel != null ? authorizationResModel.getMessage() : null, (View.OnClickListener) null);
                this.f56448a.k(new Bundle());
            } else if (eVar.f52602a == 102) {
                this.f56448a.a((ErrorModel) eVar.f52603b, eVar.f52604c, new Bundle(), eVar.f52605d);
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bi f56449a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56450b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f56451c;

        e(bi biVar, String str, boolean z) {
            this.f56449a = biVar;
            this.f56450b = str;
            this.f56451c = z;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar.f52602a == 101) {
                IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) eVar.f52603b;
                if (iJRPaytmDataModel instanceof CJRAccessToken) {
                    T t = eVar.f52603b;
                    if (t != null) {
                        str = ((CJRAccessToken) t).getAccessToken();
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.CJRAccessToken");
                    }
                } else if (iJRPaytmDataModel instanceof TokenV3ResModel) {
                    T t2 = eVar.f52603b;
                    if (t2 != null) {
                        str = l.a((TokenV3ResModel) t2);
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.TokenV3ResModel");
                    }
                } else {
                    str = "";
                }
                OauthModule.b().saveSSOToken(str);
                com.paytm.utility.b.n(this.f56449a.requireContext(), this.f56450b);
                if (!TextUtils.isEmpty(this.f56449a.f56441f)) {
                    q qVar = q.f56798a;
                    q.c(this.f56449a.f56441f);
                }
                EncryptedTokenWorker.a aVar = EncryptedTokenWorker.f52567a;
                EncryptedTokenWorker.a.a();
                if (this.f56449a.f56438c != null) {
                    bi.c(this.f56449a).a(this.f56449a, Boolean.valueOf(this.f56451c), this.f56450b);
                }
            } else if (eVar.f52602a == 102) {
                T t3 = eVar.f52603b;
                if (t3 != null) {
                    this.f56449a.a((ErrorModel) t3, eVar.f52604c, new Bundle(), "");
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.models.ErrorModel");
            }
        }
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bi f56445a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f.c cVar, bi biVar) {
            super(cVar);
            this.f56445a = biVar;
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            th.getLocalizedMessage();
            FragmentActivity activity = this.f56445a.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new C1051a(this));
            }
        }

        /* renamed from: net.one97.paytm.oauth.fragment.bi$a$a  reason: collision with other inner class name */
        static final class C1051a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f56446a;

            C1051a(a aVar) {
                this.f56446a = aVar;
            }

            public final void run() {
                net.one97.paytm.oauth.e.g g2 = this.f56446a.f56445a.m;
                if (g2 != null) {
                    g2.a();
                }
                net.one97.paytm.oauth.d.a.a(this.f56446a.f56445a.getContext(), this.f56446a.f56445a.getString(R.string.some_went_wrong), (View.OnClickListener) null);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.oauth.g.g a(bi biVar) {
        net.one97.paytm.oauth.g.g gVar = biVar.f56439d;
        if (gVar == null) {
            k.a("viewModel");
        }
        return gVar;
    }

    public static final /* synthetic */ net.one97.paytm.oauth.e.e c(bi biVar) {
        net.one97.paytm.oauth.e.e eVar = biVar.f56438c;
        if (eVar == null) {
            k.a("sessionLoginListener");
        }
        return eVar;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogStyle);
    }

    public final void onStart() {
        super.onStart();
        this.l = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(h.f56456a);
        }
        return layoutInflater.inflate(R.layout.fragment_session_login_container, viewGroup, false);
    }

    static final class h implements DialogInterface.OnShowListener {

        /* renamed from: a  reason: collision with root package name */
        public static final h f56456a = new h();

        h() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            View findViewById;
            if (dialogInterface != null) {
                com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogInterface;
                aVar.setCanceledOnTouchOutside(false);
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
        Application application = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("auth_flow") : null;
        if (serializable != null) {
            this.f56440e = (net.one97.paytm.oauth.utils.b) serializable;
            Bundle arguments2 = getArguments();
            boolean z = false;
            this.f56442g = arguments2 != null ? arguments2.getBoolean("close_pop_up") : false;
            Fragment fragment = this;
            FragmentActivity activity = getActivity();
            if (activity != null) {
                application = activity.getApplication();
            }
            if (application == null) {
                k.a();
            }
            ai a2 = am.a(fragment, (al.b) new net.one97.paytm.oauth.g.b(application, new String[0])).a(net.one97.paytm.oauth.g.g.class);
            k.a((Object) a2, "ViewModelProviders.of(th…uthViewModel::class.java)");
            this.f56439d = (net.one97.paytm.oauth.g.g) a2;
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("auth_flow", this.f56440e);
            if (this.f56440e == net.one97.paytm.oauth.utils.b.SESSION_EXPIRY) {
                z = true;
            }
            bundle2.putBoolean("is_from_session_expiry", z);
            String str = p.f56797b;
            String str2 = this.f56629a;
            if (str2 == null) {
                str2 = "";
            }
            bundle2.putString(str, str2);
            g(bundle2);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.oauth.utils.AuthFlow");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101) {
            Fragment c2 = getChildFragmentManager().c(bj.class.getName());
            if ((c2 instanceof bj) && c2.isVisible()) {
                c2.onActivityResult(i2, i3, intent);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        CoroutineScope coroutineScope = this.l;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void a(String str, String str2, boolean z, boolean z2, String str3, boolean z3) {
        k.c(str3, "previousScreenName");
        Bundle bundle = new Bundle();
        bundle.putSerializable("auth_flow", this.f56440e);
        bundle.putBoolean("close_pop_up", this.f56442g);
        bundle.putString("login_state_token", str);
        bundle.putString("login_mobile", str2);
        bundle.putBoolean("isfromSignup", z);
        bundle.putBoolean("hide_login_another_account", z2);
        bundle.putBoolean("is_device_binding", z3);
        bundle.putString(p.f56797b, str3);
        bl.a aVar = bl.f56466c;
        k.c(bundle, "bundle");
        bl blVar = new bl();
        blVar.setArguments(bundle);
        net.one97.paytm.oauth.e.d dVar = this;
        k.c(dVar, "listener");
        blVar.f56467a = dVar;
        a((Fragment) blVar);
    }

    public final void a(String str) {
        k.c(str, "passwordStrength");
        this.f56441f = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if ((r0.length() == 0) != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            java.lang.String r0 = "authCode"
            kotlin.g.b.k.c(r3, r0)
            if (r4 != 0) goto L_0x000a
            java.lang.String r0 = ""
            goto L_0x000b
        L_0x000a:
            r0 = r4
        L_0x000b:
            r2.f56443h = r0
            r2.j = r5
            r2.k = r3
            net.one97.paytm.oauth.utils.b r0 = r2.f56440e
            net.one97.paytm.oauth.utils.b r1 = net.one97.paytm.oauth.utils.b.VERTICAL
            if (r0 != r1) goto L_0x0049
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.oauth.utils.q.a((boolean) r5)
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            r0 = -1
            net.one97.paytm.oauth.utils.q.a((long) r0)
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            java.lang.String r0 = net.one97.paytm.oauth.utils.q.f()
            if (r0 == 0) goto L_0x0038
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0035
            r0 = 1
            goto L_0x0036
        L_0x0035:
            r0 = 0
        L_0x0036:
            if (r0 == 0) goto L_0x0049
        L_0x0038:
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.oauth.utils.a.a r0 = net.one97.paytm.oauth.utils.a.a.f56764a
            androidx.fragment.app.FragmentActivity r0 = r2.requireActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.String r0 = net.one97.paytm.oauth.utils.a.a.a(r0)
            net.one97.paytm.oauth.utils.q.a((java.lang.String) r0)
        L_0x0049:
            r2.b(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.bi.a(java.lang.String, java.lang.String, boolean):void");
    }

    public final void a(String str, String str2, boolean z, i iVar) {
        k.c(iVar, "flowType");
        this.f56443h = str == null ? "" : str;
        this.j = z;
        if (this.f56439d == null) {
            k.a("viewModel");
        }
        net.one97.paytm.oauth.g.g.a(str, str2).observe(this, new c(this));
    }

    public final void b() {
        dismissAllowingStateLoss();
        if (OAuthUtils.b((Activity) requireActivity())) {
            requireActivity().finish();
        }
    }

    private final void a(Fragment fragment) {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        a2.b(R.id.container, fragment, fragment.getClass().getName());
        a2.c();
    }

    public final void a(net.one97.paytm.oauth.e.e eVar) {
        k.c(eVar, "listener");
        this.f56438c = eVar;
    }

    public final void a(String str, String str2, String str3) {
        k.c(str3, "previousScreenName");
        Bundle bundle = new Bundle();
        bundle.putSerializable("auth_flow", this.f56440e);
        bundle.putBoolean("close_pop_up", this.f56442g);
        bundle.putString("login_state_token", str);
        bundle.putString("login_mobile", str2);
        bundle.putString(p.f56797b, str3);
        bn.a aVar = bn.f56487d;
        k.c(bundle, "bundle");
        bn bnVar = new bn();
        bnVar.setArguments(bundle);
        net.one97.paytm.oauth.e.d dVar = this;
        k.c(dVar, "listener");
        bnVar.f56489c = dVar;
        a((Fragment) bnVar);
    }

    public final void g(Bundle bundle) {
        k.c(bundle, "bundle");
        bundle.putBoolean("close_pop_up", this.f56442g);
        bj.a aVar = bj.f56457b;
        bj a2 = bj.a.a(bundle);
        if (!TextUtils.isEmpty(bundle.getString(BaseDialogFragment.ERROR_MESSAGE))) {
            com.paytm.utility.b.b(requireContext(), (String) null, bundle.getString(BaseDialogFragment.ERROR_MESSAGE));
        }
        a2.a((net.one97.paytm.oauth.e.d) this);
        a((Fragment) a2);
    }

    /* access modifiers changed from: private */
    public final void b(String str, String str2, boolean z) {
        if (this.f56439d != null) {
            net.one97.paytm.oauth.g.g gVar = this.f56439d;
            if (gVar == null) {
                k.a("viewModel");
            }
            gVar.a(str).observe(this, new e(this, str2, z));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fa, code lost:
        if (r4 != r5.intValue()) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0109, code lost:
        if (r9 == r4.intValue()) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010f, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) "oauthdevicebindinginitSv1") == false) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0111, code lost:
        r4 = new java.lang.String[4];
        r7 = r11.getString(net.one97.paytm.oauth.utils.p.f56797b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0121, code lost:
        if (r7 != null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0123, code lost:
        r7 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0125, code lost:
        r4[0] = r7;
        r1 = r1.getString("message");
        kotlin.g.b.k.a((java.lang.Object) r1, "jsonObj.getString(KEY_MESSAGE)");
        r4[1] = r1;
        r4[2] = net.one97.paytm.nativesdk.Constants.SDKConstants.KEY_API;
        kotlin.g.b.k.a((java.lang.Object) r3, "responseCode");
        r4[3] = r3;
        r0 = kotlin.a.k.d(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0143, code lost:
        if (r8.j == false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0145, code lost:
        r1 = "signup";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0149, code lost:
        r1 = "login";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014b, code lost:
        a("/login-signup", "login_signup", "device_binding_successful", (java.util.ArrayList<java.lang.String>) r0, r1);
        com.paytm.utility.b.b(requireContext(), getString(net.one97.paytm.oauth.R.string.oauth_error), getString(net.one97.paytm.oauth.R.string.some_went_wrong));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.oauth.models.ErrorModel r9, java.lang.Throwable r10, android.os.Bundle r11, java.lang.String r12) {
        /*
            r8 = this;
            java.lang.String r0 = "responseCode"
            java.lang.String r1 = "bundle"
            kotlin.g.b.k.c(r11, r1)
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()
            android.app.Activity r1 = (android.app.Activity) r1
            r2 = r8
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            if (r10 == 0) goto L_0x01bc
            com.paytm.network.model.NetworkCustomError r10 = (com.paytm.network.model.NetworkCustomError) r10
            boolean r10 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r1, (androidx.fragment.app.Fragment) r2, (com.paytm.network.model.NetworkCustomError) r10)
            if (r10 == 0) goto L_0x001e
            r8.b()
            return
        L_0x001e:
            java.lang.String r10 = "oauthdevicebindinginitSv1"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r10)
            r2 = 1
            if (r1 == 0) goto L_0x0031
            boolean r1 = net.one97.paytm.oauth.utils.l.a((net.one97.paytm.oauth.models.ErrorModel) r9)
            if (r1 == 0) goto L_0x0031
            r8.a((android.os.Bundle) r11, (boolean) r2)
            return
        L_0x0031:
            android.content.Context r1 = r8.requireContext()
            net.one97.paytm.oauth.fragment.bi$g r3 = new net.one97.paytm.oauth.fragment.bi$g
            r3.<init>(r8, r12, r11)
            android.content.DialogInterface$OnClickListener r3 = (android.content.DialogInterface.OnClickListener) r3
            boolean r1 = net.one97.paytm.oauth.utils.l.a(r9, r1, r3)
            if (r1 != 0) goto L_0x01bb
            if (r9 == 0) goto L_0x0049
            com.paytm.network.model.NetworkCustomError r1 = r9.getCustomError()
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            boolean r1 = r1 instanceof com.paytm.network.model.NetworkCustomError
            if (r1 == 0) goto L_0x01a5
            com.paytm.network.model.NetworkCustomError r1 = r9.getCustomError()
            com.paytm.network.model.NetworkResponse r1 = r1.networkResponse
            byte[] r1 = r1.data
            if (r1 == 0) goto L_0x01a4
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = kotlin.m.d.f47971a
            r3.<init>(r1, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x018e
            java.lang.String r3 = new java.lang.String     // Catch:{ JSONException -> 0x0176 }
            java.nio.charset.Charset r4 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x0176 }
            r3.<init>(r1, r4)     // Catch:{ JSONException -> 0x0176 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0176 }
            r1.<init>(r3)     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r3 = r1.getString(r0)     // Catch:{ JSONException -> 0x0176 }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x0176 }
            if (r4 == 0) goto L_0x0099
            int r4 = r9.getStatus()     // Catch:{ JSONException -> 0x0176 }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x0176 }
            if (r5 != 0) goto L_0x0086
            goto L_0x0099
        L_0x0086:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0176 }
            if (r4 != r5) goto L_0x0099
            java.lang.String r4 = "BE1423003"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0176 }
            if (r4 == 0) goto L_0x0099
            r8.a((android.os.Bundle) r11, (boolean) r2)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x01a1
        L_0x0099:
            int r4 = r9.getStatus()     // Catch:{ JSONException -> 0x0176 }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r6 = "message"
            if (r5 != 0) goto L_0x00a4
            goto L_0x00c5
        L_0x00a4:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0176 }
            if (r4 != r5) goto L_0x00c5
            java.lang.String r4 = "BE1423002"
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0176 }
            if (r4 == 0) goto L_0x00c5
            android.content.Context r9 = r8.requireContext()     // Catch:{ JSONException -> 0x0176 }
            int r10 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r10 = r8.getString(r10)     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r12 = r1.getString(r6)     // Catch:{ JSONException -> 0x0176 }
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x01a1
        L_0x00c5:
            int r4 = r9.getStatus()     // Catch:{ JSONException -> 0x0176 }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56788g     // Catch:{ JSONException -> 0x0176 }
            if (r5 != 0) goto L_0x00ce
            goto L_0x00ed
        L_0x00ce:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0176 }
            if (r4 != r5) goto L_0x00ed
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x0176 }
            if (r4 == 0) goto L_0x00ed
            android.content.Context r9 = r8.requireContext()     // Catch:{ JSONException -> 0x0176 }
            int r10 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r10 = r8.getString(r10)     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r12 = r1.getString(r6)     // Catch:{ JSONException -> 0x0176 }
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x01a1
        L_0x00ed:
            int r4 = r9.getStatus()     // Catch:{ JSONException -> 0x0176 }
            java.lang.Integer r5 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x0176 }
            if (r5 != 0) goto L_0x00f6
            goto L_0x00fc
        L_0x00f6:
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x0176 }
            if (r4 == r5) goto L_0x010b
        L_0x00fc:
            int r9 = r9.getStatus()     // Catch:{ JSONException -> 0x0176 }
            java.lang.Integer r4 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x0176 }
            if (r4 != 0) goto L_0x0105
            goto L_0x0162
        L_0x0105:
            int r4 = r4.intValue()     // Catch:{ JSONException -> 0x0176 }
            if (r9 != r4) goto L_0x0162
        L_0x010b:
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x0176 }
            if (r9 == 0) goto L_0x0162
            java.lang.String r9 = "/login-signup"
            java.lang.String r10 = "login_signup"
            java.lang.String r12 = "device_binding_successful"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0176 }
            r5 = 0
            java.lang.String r7 = net.one97.paytm.oauth.utils.p.f56797b     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r7 = r11.getString(r7)     // Catch:{ JSONException -> 0x0176 }
            if (r7 != 0) goto L_0x0125
            java.lang.String r7 = ""
        L_0x0125:
            r4[r5] = r7     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r1 = r1.getString(r6)     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r5 = "jsonObj.getString(KEY_MESSAGE)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ JSONException -> 0x0176 }
            r4[r2] = r1     // Catch:{ JSONException -> 0x0176 }
            r1 = 2
            java.lang.String r2 = "api"
            r4[r1] = r2     // Catch:{ JSONException -> 0x0176 }
            r1 = 3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0176 }
            r4[r1] = r3     // Catch:{ JSONException -> 0x0176 }
            java.util.ArrayList r0 = kotlin.a.k.d(r4)     // Catch:{ JSONException -> 0x0176 }
            boolean r1 = r8.j     // Catch:{ JSONException -> 0x0176 }
            if (r1 == 0) goto L_0x0149
            java.lang.String r1 = "signup"
            goto L_0x014b
        L_0x0149:
            java.lang.String r1 = "login"
        L_0x014b:
            a((java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r12, (java.util.ArrayList<java.lang.String>) r0, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0176 }
            android.content.Context r9 = r8.requireContext()     // Catch:{ JSONException -> 0x0176 }
            int r10 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r10 = r8.getString(r10)     // Catch:{ JSONException -> 0x0176 }
            int r12 = net.one97.paytm.oauth.R.string.some_went_wrong     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r12 = r8.getString(r12)     // Catch:{ JSONException -> 0x0176 }
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x01a1
        L_0x0162:
            android.content.Context r9 = r8.requireContext()     // Catch:{ JSONException -> 0x0176 }
            int r10 = net.one97.paytm.oauth.R.string.oauth_error     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r10 = r8.getString(r10)     // Catch:{ JSONException -> 0x0176 }
            int r12 = net.one97.paytm.oauth.R.string.some_went_wrong     // Catch:{ JSONException -> 0x0176 }
            java.lang.String r12 = r8.getString(r12)     // Catch:{ JSONException -> 0x0176 }
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r12)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x01a1
        L_0x0176:
            r9 = move-exception
            android.content.Context r10 = r8.requireContext()
            int r12 = net.one97.paytm.oauth.R.string.oauth_error
            java.lang.String r12 = r8.getString(r12)
            int r0 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r0 = r8.getString(r0)
            com.paytm.utility.b.b((android.content.Context) r10, (java.lang.String) r12, (java.lang.String) r0)
            r9.printStackTrace()
            goto L_0x01a1
        L_0x018e:
            android.content.Context r9 = r8.requireContext()
            int r10 = net.one97.paytm.oauth.R.string.oauth_error
            java.lang.String r10 = r8.getString(r10)
            int r12 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r12 = r8.getString(r12)
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r12)
        L_0x01a1:
            r8.k((android.os.Bundle) r11)
        L_0x01a4:
            return
        L_0x01a5:
            android.content.Context r9 = r8.requireContext()
            int r10 = net.one97.paytm.oauth.R.string.oauth_error
            java.lang.String r10 = r8.getString(r10)
            int r12 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r12 = r8.getString(r12)
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r12)
            r8.k((android.os.Bundle) r11)
        L_0x01bb:
            return
        L_0x01bc:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.bi.a(net.one97.paytm.oauth.models.ErrorModel, java.lang.Throwable, android.os.Bundle, java.lang.String):void");
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ bi f56453a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56454b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bundle f56455c;

        g(bi biVar, String str, Bundle bundle) {
            this.f56453a = biVar;
            this.f56454b = str;
            this.f56455c = bundle;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (k.a((Object) this.f56454b, (Object) "oauthdevicebindinginitSv1")) {
                bi biVar = this.f56453a;
                biVar.a(this.f56455c, biVar.m);
            } else if (k.a((Object) this.f56454b, (Object) "oauthTokenV3")) {
                bi biVar2 = this.f56453a;
                biVar2.b(biVar2.k, this.f56453a.f56443h, this.f56453a.j);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void k(Bundle bundle) {
        bundle.putSerializable("auth_flow", this.f56440e);
        g(bundle);
    }

    private final void a(Bundle bundle, boolean z) {
        CoroutineScope coroutineScope = this.l;
        if (coroutineScope != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, this.p, (CoroutineStart) null, new f(this, z, bundle, (kotlin.d.d) null), 2, (Object) null);
        }
    }

    public final void a(Bundle bundle) {
        k.c(bundle, "bundle");
        l(bundle);
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
        l(bundle);
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.VERIFYING_NUMBER, bundle, this, R.id.container);
    }

    public final void f(Bundle bundle) {
        k.c(bundle, "bundle");
        bundle.putString("screen_name", "FRAGMENT_ACCOUNT_CLAIM");
        bundle.putString("login_state_token", bundle.getString(H5Param.SESSION_ID));
        OauthModule.b().launchAJRAuthActivity(getContext(), bundle);
        b();
    }

    public final void h(Bundle bundle) {
        k.c(bundle, "bundle");
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.DONT_HAVE_SIM, bundle, this, R.id.container);
    }

    public final void i(Bundle bundle) {
        k.c(bundle, "bundle");
        l(bundle);
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.SINGLE_SIM_MISMATCH, bundle, this, R.id.container);
    }

    public final void j(Bundle bundle) {
        k.c(bundle, "bundle");
        l(bundle);
        net.one97.paytm.oauth.utils.e.a(net.one97.paytm.oauth.utils.g.DUAL_SIM_MISMATCH, bundle, this, R.id.container);
    }

    public final void a(Bundle bundle, net.one97.paytm.oauth.e.g gVar) {
        k.c(bundle, "bundle");
        String string = bundle.getString("device_binding_flow", "sms");
        k.a((Object) string, "bundle.getString(EXTRA_D…W, DeviceBindingFlow.SMS)");
        this.n = string;
        this.m = gVar;
        a(bundle, false);
    }

    private final void l(Bundle bundle) {
        String str;
        Bundle arguments = getArguments();
        this.j = arguments != null ? arguments.getBoolean("is_new_signup") : false;
        String string = bundle.getString("login_mobile");
        if (string == null) {
            string = "";
        }
        this.f56443h = string;
        String string2 = bundle.getString("login_signup_flow");
        if (string2 == null) {
            string2 = "login";
        }
        this.f56444i = string2;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("device_binding_flow")) == null) {
            str = "sms";
        }
        this.n = str;
    }

    @kotlin.d.b.a.f(b = "SessionLoginDialogFragment.kt", c = {327}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.SessionLoginDialogFragment$checkKeysAndCallInitApi$1")
    static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ Bundle $bundle;
        final /* synthetic */ boolean $deleteKeys;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ bi this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(bi biVar, boolean z, Bundle bundle, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = biVar;
            this.$deleteKeys = z;
            this.$bundle = bundle;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            f fVar = new f(this.this$0, this.$deleteKeys, this.$bundle, dVar);
            fVar.p$ = (CoroutineScope) obj;
            return fVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
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
                    final /* synthetic */ f this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        public static final /* synthetic */ void a(bi biVar, String str, String str2) {
                            if (biVar.f56439d == null) {
                                k.a("viewModel");
                            }
                            net.one97.paytm.oauth.g.g.b(str, str2).observe(biVar, new d(biVar));
                        }

                        public static final /* synthetic */ void a(bi biVar, String str, String str2, String str3) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("auth_flow", biVar.f56440e);
                            bundle.putString(net.one97.paytm.oauth.utils.p.f56797b, str2);
                            bundle.putBoolean("close_pop_up", biVar.f56442g);
                            bundle.putString("login_state_token", str);
                            bundle.putString("login_mobile", str3);
                            bundle.putBoolean("isfromSignup", biVar.j);
                            bundle.putBoolean("is_sms_device_binding", true);
                            bf.a aVar = bf.f56414a;
                            net.one97.paytm.oauth.e.d dVar = biVar;
                            k.c(dVar, "listener");
                            bf bfVar = new bf(dVar);
                            bfVar.setArguments(bundle);
                            biVar.a((Fragment) bfVar);
                        }
                    }
