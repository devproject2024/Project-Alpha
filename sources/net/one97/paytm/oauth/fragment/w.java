package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.ba;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.j;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;

public abstract class w extends v implements ba.b {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.oauth.g.e f56633a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f56634b;

    /* renamed from: c  reason: collision with root package name */
    private int f56635c;

    /* renamed from: d  reason: collision with root package name */
    private List<SubscriptionInfo> f56636d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f56637e = 30;

    /* renamed from: f  reason: collision with root package name */
    private int f56638f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f56639g = 15;

    /* renamed from: h  reason: collision with root package name */
    private boolean f56640h;

    /* renamed from: i  reason: collision with root package name */
    private String f56641i = "login";
    private String j = "";
    private String k = "sms";
    private String l;
    private boolean m;
    private String n;
    private String o = "";
    private final String p = "BaseApiFragment";
    private int q = 5;
    private net.one97.paytm.oauth.utils.j r;
    private String s = "simple_login";
    private int t = 2;
    private final CoroutineExceptionHandler u = new a(CoroutineExceptionHandler.Key, this);
    private final h v = new h(this);
    private HashMap w;

    public interface b {
        void a(Bundle bundle, net.one97.paytm.oauth.utils.g gVar);

        void a(String str);

        void a(String str, String str2, boolean z);

        void a(String str, boolean z, boolean z2);

        void ab_();

        void ac_();

        void ad_();
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final j f56653a = new j();

        j() {
        }

        public final void onClick(View view) {
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final k f56654a = new k();

        k() {
        }

        public final void onClick(View view) {
        }
    }

    public View a(int i2) {
        if (this.w == null) {
            this.w = new HashMap();
        }
        View view = (View) this.w.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.w.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.w;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public abstract String d();

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f56642a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f.c cVar, w wVar) {
            super(cVar);
            this.f56642a = wVar;
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            th.getLocalizedMessage();
            FragmentActivity activity = this.f56642a.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new C1052a(this));
            }
        }

        /* renamed from: net.one97.paytm.oauth.fragment.w$a$a  reason: collision with other inner class name */
        static final class C1052a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f56643a;

            C1052a(a aVar) {
                this.f56643a = aVar;
            }

            public final void run() {
                b b2 = this.f56643a.f56642a.f56634b;
                if (b2 != null) {
                    b2.ac_();
                }
                com.paytm.utility.b.b(this.f56643a.f56642a.requireContext(), (String) null, this.f56643a.f56642a.getString(R.string.some_went_wrong));
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f56644a;

        c(w wVar) {
            this.f56644a = wVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar != null) {
                b b2 = this.f56644a.f56634b;
                if (b2 != null) {
                    b2.ac_();
                }
                if (eVar.f52602a != 101) {
                    this.f56644a.a((ErrorModel) eVar.f52603b, eVar.f52604c, this.f56644a.d(), eVar.f52605d);
                    return;
                }
                this.f56644a.a((IJRPaytmDataModel) eVar.f52603b);
            }
        }
    }

    public final net.one97.paytm.oauth.g.e b() {
        net.one97.paytm.oauth.g.e eVar = this.f56633a;
        if (eVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return eVar;
    }

    public void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        this.m = OAuthUtils.a(context);
        if (this instanceof b) {
            this.f56634b = (b) this;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.e.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…nitViewModel::class.java)");
        this.f56633a = (net.one97.paytm.oauth.g.e) a2;
        j.a aVar = net.one97.paytm.oauth.utils.j.f56769c;
        net.one97.paytm.oauth.e.c cVar = this.v;
        kotlin.g.b.k.c(cVar, "listener");
        this.r = new net.one97.paytm.oauth.utils.j(cVar);
        net.one97.paytm.oauth.utils.j jVar = this.r;
        if (jVar != null) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            Activity activity = requireActivity;
            kotlin.g.b.k.c(activity, "activity");
            com.google.android.gms.location.b b2 = com.google.android.gms.location.f.b(activity);
            kotlin.g.b.k.a((Object) b2, "LocationServices.getFuse…nProviderClient(activity)");
            jVar.f56770a = b2;
            jVar.a();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.oauth.utils.j jVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101 && (jVar = this.r) != null) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            Activity activity = requireActivity;
            kotlin.g.b.k.c(activity, "activity");
            if (i2 != 101) {
                return;
            }
            if (i3 != -1) {
                jVar.a(activity);
                net.one97.paytm.oauth.e.c cVar = jVar.f56771b;
                if (cVar != null) {
                    cVar.b();
                    return;
                }
                return;
            }
            jVar.a(activity);
            net.one97.paytm.oauth.e.c cVar2 = jVar.f56771b;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
    }

    public void onStop() {
        super.onStop();
        net.one97.paytm.oauth.utils.j jVar = this.r;
        if (jVar != null) {
            jVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(String str, kotlin.d.d<? super Boolean> dVar) {
        return BuildersKt__Builders_commonKt.async$default(GlobalScope.INSTANCE, Dispatchers.getIO().plus(this.u), (CoroutineStart) null, new f(str, (kotlin.d.d) null), 2, (Object) null).await(dVar);
    }

    public final void e() {
        q qVar = q.f56798a;
        q.h("simple_login");
        b bVar = this.f56634b;
        if (bVar != null) {
            bVar.ab_();
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().plus(this.u), (CoroutineStart) null, new e(this, (kotlin.d.d) null), 2, (Object) null);
    }

    private void g() {
        if (isAdded()) {
            b bVar = this.f56634b;
            if (bVar != null) {
                bVar.ab_();
            }
            net.one97.paytm.oauth.g.e eVar = this.f56633a;
            if (eVar == null) {
                kotlin.g.b.k.a("viewModel");
            }
            eVar.a(d(), OAuthUtils.a(this.f56636d, requireContext()), "LOGIN_REGISTER").observe(this, new c(this));
        }
    }

    private final void a(String str, String str2, String str3) {
        b bVar = this.f56634b;
        if (bVar != null) {
            bVar.ab_();
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().plus(this.u), (CoroutineStart) null, new d(this, str, str2, str3, (kotlin.d.d) null), 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        if (r0.equals("3000") != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        r0 = r13.f56634b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03e5, code lost:
        if (r0 == null) goto L_0x03d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0.a(r14.getStateToken(), kotlin.g.b.k.a((java.lang.Object) r14.getResponseCode(), (java.lang.Object) "3004"), false);
        r14 = kotlin.x.f47997a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04ad, code lost:
        if (r1 == null) goto L_0x0498;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05a9, code lost:
        if (r1 == null) goto L_0x0594;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0648, code lost:
        if (r0 == null) goto L_0x0633;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011b, code lost:
        if (r0.equals("BE1424005") != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0124, code lost:
        if (r0.equals("BE1424004") != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0126, code lost:
        r5 = r14.getMessage();
        kotlin.g.b.k.a((java.lang.Object) r5, "model.message");
        r2 = r14.getResponseCode();
        kotlin.g.b.k.a((java.lang.Object) r2, "model.responseCode");
        a(net.one97.paytm.upi.util.Events.Action.PROCEED_CLICKED, kotlin.a.k.d("mobile_number", r5, net.one97.paytm.nativesdk.Constants.SDKConstants.KEY_API, r2), 4);
        r0 = new android.os.Bundle();
        r0.putString("message", r14.getMessage());
        r0.putBoolean("IS_SHOW_RAISE_REQUEST", true);
        net.one97.paytm.oauth.utils.OAuthUtils.a(getChildFragmentManager(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x015f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (r0.equals("3004") != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02b7, code lost:
        if (r0 == null) goto L_0x02a2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof net.one97.paytm.oauth.models.SimplifiedLoginInit
            r1 = 3
            java.lang.String r2 = "api"
            r3 = 2
            r4 = 4
            r5 = 0
            r6 = 0
            r7 = 1
            if (r0 == 0) goto L_0x01ec
            net.one97.paytm.oauth.models.SimplifiedLoginInit r14 = (net.one97.paytm.oauth.models.SimplifiedLoginInit) r14
            java.lang.String r0 = r14.getResponseCode()
            java.lang.String r8 = "model.responseCode"
            java.lang.String r9 = "model.message"
            java.lang.String r10 = "mobile_number"
            java.lang.String r11 = "proceed_clicked"
            if (r0 != 0) goto L_0x001e
            goto L_0x0160
        L_0x001e:
            int r12 = r0.hashCode()
            switch(r12) {
                case -1258552628: goto L_0x011e;
                case -1258552627: goto L_0x0115;
                case -1258552626: goto L_0x00d3;
                case 51604: goto L_0x00a0;
                case 54399: goto L_0x0066;
                case 1567005: goto L_0x0046;
                case 1567006: goto L_0x0030;
                case 1567009: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0160
        L_0x0027:
            java.lang.String r12 = "3004"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
            goto L_0x004e
        L_0x0030:
            java.lang.String r12 = "3001"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
            net.one97.paytm.oauth.fragment.w$b r0 = r13.f56634b
            if (r0 == 0) goto L_0x0045
            java.lang.String r14 = r14.getStateToken()
            r0.a(r14)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x0045:
            return
        L_0x0046:
            java.lang.String r12 = "3000"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
        L_0x004e:
            net.one97.paytm.oauth.fragment.w$b r0 = r13.f56634b
            if (r0 == 0) goto L_0x0065
            java.lang.String r1 = r14.getStateToken()
            java.lang.String r14 = r14.getResponseCode()
            java.lang.String r2 = "3004"
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            r0.a((java.lang.String) r1, (boolean) r14, (boolean) r6)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x0065:
            return
        L_0x0066:
            java.lang.String r12 = "708"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r6] = r10
            java.lang.String r5 = r14.getMessage()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            r0[r7] = r5
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            a((java.lang.String) r11, (java.util.ArrayList) r0, (int) r4)
            android.content.Context r0 = r13.requireContext()
            java.lang.String r14 = r14.getMessage()
            net.one97.paytm.oauth.fragment.w$i r1 = new net.one97.paytm.oauth.fragment.w$i
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            net.one97.paytm.oauth.d.a.a((android.content.Context) r0, (java.lang.String) r14, (android.view.View.OnClickListener) r1)
            return
        L_0x00a0:
            java.lang.String r12 = "433"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r6] = r10
            java.lang.String r5 = r14.getMessage()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            r0[r7] = r5
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            a((java.lang.String) r11, (java.util.ArrayList) r0, (int) r4)
            java.lang.String r14 = r14.getMessage()
            android.content.Context r0 = r13.requireContext()
            net.one97.paytm.oauth.utils.OAuthUtils.a((java.lang.String) r14, (android.content.Context) r0)
            return
        L_0x00d3:
            java.lang.String r12 = "BE1424006"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r6] = r10
            java.lang.String r5 = r14.getMessage()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            r0[r7] = r5
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            a((java.lang.String) r11, (java.util.ArrayList) r0, (int) r4)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r14 = r14.getMessage()
            java.lang.String r1 = "message"
            r0.putString(r1, r14)
            java.lang.String r14 = "IS_SHOW_RAISE_REQUEST"
            r0.putBoolean(r14, r6)
            androidx.fragment.app.j r14 = r13.getChildFragmentManager()
            net.one97.paytm.oauth.utils.OAuthUtils.a((androidx.fragment.app.j) r14, (android.os.Bundle) r0)
            return
        L_0x0115:
            java.lang.String r12 = "BE1424005"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
            goto L_0x0126
        L_0x011e:
            java.lang.String r12 = "BE1424004"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0160
        L_0x0126:
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r6] = r10
            java.lang.String r5 = r14.getMessage()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            r0[r7] = r5
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            a((java.lang.String) r11, (java.util.ArrayList) r0, (int) r4)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r14 = r14.getMessage()
            java.lang.String r1 = "message"
            r0.putString(r1, r14)
            java.lang.String r14 = "IS_SHOW_RAISE_REQUEST"
            r0.putBoolean(r14, r7)
            androidx.fragment.app.j r14 = r13.getChildFragmentManager()
            net.one97.paytm.oauth.utils.OAuthUtils.a((androidx.fragment.app.j) r14, (android.os.Bundle) r0)
            return
        L_0x0160:
            java.lang.String r0 = r14.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x019d
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r6] = r10
            java.lang.String r5 = r14.getMessage()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r9)
            r0[r7] = r5
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            a((java.lang.String) r11, (java.util.ArrayList) r0, (int) r4)
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r14 = r14.getMessage()
            net.one97.paytm.oauth.fragment.w$j r1 = net.one97.paytm.oauth.fragment.w.j.f56653a
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            net.one97.paytm.oauth.d.a.a((android.content.Context) r0, (java.lang.String) r14, (android.view.View.OnClickListener) r1)
            return
        L_0x019d:
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r8 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r8 = r13.getString(r8)
            net.one97.paytm.oauth.fragment.w$k r9 = net.one97.paytm.oauth.fragment.w.k.f56654a
            android.view.View$OnClickListener r9 = (android.view.View.OnClickListener) r9
            net.one97.paytm.oauth.d.a.a((android.content.Context) r0, (java.lang.String) r8, (android.view.View.OnClickListener) r9)
            androidx.fragment.app.FragmentActivity r0 = r13.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r8 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r8 = r13.getString(r8)
            com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r5, (java.lang.String) r8)
            java.lang.String[] r0 = new java.lang.String[r4]
            r0[r6] = r10
            int r5 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r5 = r13.getString(r5)
            java.lang.String r6 = "getString(R.string.some_went_wrong)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r0[r7] = r5
            r0[r3] = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r14 = r14.getResponseCode()
            r2.append(r14)
            java.lang.String r14 = r2.toString()
            r0[r1] = r14
            java.util.ArrayList r14 = kotlin.a.k.d(r0)
            a((java.lang.String) r11, (java.util.ArrayList) r14, (int) r4)
            return
        L_0x01ec:
            boolean r0 = r14 instanceof net.one97.paytm.oauth.models.DeviceBindingConfigResModel
            java.lang.String r8 = "signup"
            java.lang.String r9 = "login"
            java.lang.String r10 = ""
            if (r0 == 0) goto L_0x069b
            net.one97.paytm.oauth.models.DeviceBindingConfigResModel r14 = (net.one97.paytm.oauth.models.DeviceBindingConfigResModel) r14
            java.lang.String r0 = r14.getResponseCode()
            if (r0 != 0) goto L_0x0200
            goto L_0x0693
        L_0x0200:
            int r1 = r0.hashCode()
            r2 = -1260518837(0xffffffffb4de024b, float:-4.135239E-7)
            if (r1 == r2) goto L_0x020b
            goto L_0x0693
        L_0x020b:
            java.lang.String r1 = "BE1400001"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0693
            net.one97.paytm.oauth.models.Data r0 = r14.getData()
            if (r0 == 0) goto L_0x021f
            java.lang.String r0 = r0.getSelectedAppFlow()
            if (r0 != 0) goto L_0x0221
        L_0x021f:
            java.lang.String r0 = "simple_login"
        L_0x0221:
            r13.s = r0
            net.one97.paytm.oauth.models.Data r0 = r14.getData()
            if (r0 == 0) goto L_0x022e
            java.lang.String r0 = r0.getFlow()
            goto L_0x022f
        L_0x022e:
            r0 = r5
        L_0x022f:
            r13.f56641i = r0
            java.lang.String r0 = r13.f56641i
            java.lang.String r1 = "REGISTER"
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r7)
            if (r0 == 0) goto L_0x023d
            r13.f56640h = r7
        L_0x023d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r0 = r13.s
            java.lang.String r1 = "device_binding"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            r0 = r0 ^ r7
            java.lang.String r1 = "single_sim"
            if (r0 == 0) goto L_0x02d4
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r14.add(r10)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            int r0 = r0.size()
            if (r0 <= r7) goto L_0x0297
            java.lang.String r0 = "dual_sim"
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r6)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x0275
            r0 = r5
        L_0x0275:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x027a
            r0 = r10
        L_0x027a:
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r7)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x028e
            r0 = r5
        L_0x028e:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0293
            r0 = r10
        L_0x0293:
            r14.add(r0)
            goto L_0x02c0
        L_0x0297:
            r14.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            int r0 = r0.size()
            if (r0 != 0) goto L_0x02a4
        L_0x02a2:
            r0 = r10
            goto L_0x02ba
        L_0x02a4:
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r6)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x02b5
            r0 = r5
        L_0x02b5:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x02ba
            goto L_0x02a2
        L_0x02ba:
            r14.add(r0)
            r14.add(r10)
        L_0x02c0:
            java.lang.String r0 = "Simple Login"
            r14.add(r0)
            boolean r0 = r13.f56640h
            if (r0 == 0) goto L_0x02ca
            goto L_0x02cb
        L_0x02ca:
            r8 = r9
        L_0x02cb:
            java.lang.String r0 = "device_binding_config_successful"
            b(r0, r14, r8)
            r13.e()
            return
        L_0x02d4:
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            java.lang.String r0 = "device_binding"
            net.one97.paytm.oauth.utils.q.h(r0)
            net.one97.paytm.oauth.models.Data r0 = r14.getData()
            if (r0 == 0) goto L_0x02f4
            java.util.ArrayList r0 = r0.getStrategies()
            if (r0 == 0) goto L_0x02f4
            java.lang.Object r0 = r0.get(r6)
            net.one97.paytm.oauth.models.Strategy r0 = (net.one97.paytm.oauth.models.Strategy) r0
            if (r0 == 0) goto L_0x02f4
            java.util.ArrayList r0 = r0.getMethods()
            goto L_0x02f5
        L_0x02f4:
            r0 = r5
        L_0x02f5:
            if (r0 == 0) goto L_0x0692
            java.util.Iterator r0 = r0.iterator()
        L_0x02fb:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0371
            java.lang.Object r2 = r0.next()
            net.one97.paytm.oauth.models.Method r2 = (net.one97.paytm.oauth.models.Method) r2
            int r4 = r2.getPriority()
            if (r4 != r7) goto L_0x02fb
            java.lang.String r0 = r2.getKey()
            if (r0 != 0) goto L_0x0315
            java.lang.String r0 = "sms"
        L_0x0315:
            r13.k = r0
            java.lang.String r0 = r2.getTimeout()
            if (r0 == 0) goto L_0x0322
            int r0 = java.lang.Integer.parseInt(r0)
            goto L_0x0324
        L_0x0322:
            r0 = 30
        L_0x0324:
            r13.f56637e = r0
            java.lang.String r0 = r2.getMaxRetryCount()
            if (r0 == 0) goto L_0x0331
            int r0 = java.lang.Integer.parseInt(r0)
            goto L_0x0332
        L_0x0331:
            r0 = 1
        L_0x0332:
            r13.f56638f = r0
            java.lang.String r0 = r2.getRetryInterval()
            if (r0 == 0) goto L_0x033f
            int r0 = java.lang.Integer.parseInt(r0)
            goto L_0x0341
        L_0x033f:
            r0 = 15
        L_0x0341:
            r13.f56639g = r0
            net.one97.paytm.oauth.models.Config r0 = r2.getConfig()
            if (r0 == 0) goto L_0x034e
            java.lang.String r0 = r0.getPollingFrequency()
            goto L_0x034f
        L_0x034e:
            r0 = r5
        L_0x034f:
            r13.n = r0
            net.one97.paytm.oauth.models.Config r0 = r2.getConfig()
            if (r0 == 0) goto L_0x0362
            java.lang.Integer r0 = r0.getSmsTimeOut()
            if (r0 == 0) goto L_0x0362
            int r0 = r0.intValue()
            goto L_0x0363
        L_0x0362:
            r0 = 5
        L_0x0363:
            r13.q = r0
            net.one97.paytm.oauth.models.Config r0 = r2.getConfig()
            if (r0 == 0) goto L_0x036f
            int r3 = r0.getSendSmsDelay()
        L_0x036f:
            r13.t = r3
        L_0x0371:
            java.lang.String r0 = r13.k
            java.lang.String r2 = "otp"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0417
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.lang.String r0 = "4"
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            int r0 = r0.size()
            if (r0 <= r7) goto L_0x03c5
            java.lang.String r0 = "dual_sim"
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r6)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x03a3
            r0 = r5
        L_0x03a3:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x03a8
            r0 = r10
        L_0x03a8:
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r7)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x03bc
            r0 = r5
        L_0x03bc:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x03c1
            r0 = r10
        L_0x03c1:
            r14.add(r0)
            goto L_0x03ee
        L_0x03c5:
            r14.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            int r0 = r0.size()
            if (r0 != 0) goto L_0x03d2
        L_0x03d0:
            r0 = r10
            goto L_0x03e8
        L_0x03d2:
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r6)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x03e3
            r0 = r5
        L_0x03e3:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x03e8
            goto L_0x03d0
        L_0x03e8:
            r14.add(r0)
            r14.add(r10)
        L_0x03ee:
            java.lang.String r0 = "otp"
            r14.add(r0)
            boolean r0 = r13.f56640h
            if (r0 == 0) goto L_0x03f8
            goto L_0x03f9
        L_0x03f8:
            r8 = r9
        L_0x03f9:
            java.lang.String r0 = "device_binding_config_successful"
            b(r0, r14, r8)
            java.lang.String r14 = "otp"
            r13.k = r14
            net.one97.paytm.oauth.utils.q r14 = net.one97.paytm.oauth.utils.q.f56798a
            java.lang.String r14 = "device_binding_otp"
            net.one97.paytm.oauth.utils.q.h(r14)
            r13.d()
            java.lang.String r14 = r13.f56641i
            java.lang.String r0 = r13.k
            java.lang.String r1 = r13.l
            r13.a((java.lang.String) r14, (java.lang.String) r0, (java.lang.String) r1)
            goto L_0x0690
        L_0x0417:
            net.one97.paytm.oauth.models.Data r0 = r14.getData()
            net.one97.paytm.oauth.models.Iccid r0 = r0.getIccidResponse()
            if (r0 == 0) goto L_0x0426
            java.lang.String r0 = r0.getResponseCode()
            goto L_0x0427
        L_0x0426:
            r0 = r5
        L_0x0427:
            if (r0 != 0) goto L_0x042b
            goto L_0x05de
        L_0x042b:
            int r2 = r0.hashCode()
            r3 = -635548540(0xffffffffda1e4c84, float:-1.1139294E16)
            if (r2 == r3) goto L_0x0537
            r3 = -109543131(0xfffffffff9788125, float:-8.064431E34)
            if (r2 == r3) goto L_0x043b
            goto L_0x05de
        L_0x043b:
            java.lang.String r2 = "MAPPING_FOUND_WITH_OTHER_USER"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x05de
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r2 = "2"
            r0.add(r2)
            java.util.List<android.telephony.SubscriptionInfo> r2 = r13.f56636d
            int r2 = r2.size()
            if (r2 <= r7) goto L_0x048d
            java.lang.String r1 = "dual_sim"
            r0.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            java.lang.Object r1 = r1.get(r6)
            android.telephony.SubscriptionInfo r1 = (android.telephony.SubscriptionInfo) r1
            java.lang.CharSequence r1 = r1.getCarrierName()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x046b
            r1 = r5
        L_0x046b:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0470
            r1 = r10
        L_0x0470:
            r0.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            java.lang.Object r1 = r1.get(r7)
            android.telephony.SubscriptionInfo r1 = (android.telephony.SubscriptionInfo) r1
            java.lang.CharSequence r1 = r1.getCarrierName()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0484
            r1 = r5
        L_0x0484:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0489
            r1 = r10
        L_0x0489:
            r0.add(r1)
            goto L_0x04b6
        L_0x048d:
            r0.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            int r1 = r1.size()
            if (r1 != 0) goto L_0x049a
        L_0x0498:
            r1 = r10
            goto L_0x04b0
        L_0x049a:
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            java.lang.Object r1 = r1.get(r6)
            android.telephony.SubscriptionInfo r1 = (android.telephony.SubscriptionInfo) r1
            java.lang.CharSequence r1 = r1.getCarrierName()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x04ab
            r1 = r5
        L_0x04ab:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x04b0
            goto L_0x0498
        L_0x04b0:
            r0.add(r1)
            r0.add(r10)
        L_0x04b6:
            java.lang.String r1 = "SMS"
            r0.add(r1)
            boolean r1 = r13.f56640h
            if (r1 == 0) goto L_0x04c0
            goto L_0x04c1
        L_0x04c0:
            r8 = r9
        L_0x04c1:
            java.lang.String r1 = "device_binding_config_successful"
            b(r1, r0, r8)
            net.one97.paytm.oauth.models.Data r14 = r14.getData()
            net.one97.paytm.oauth.models.Iccid r14 = r14.getIccidResponse()
            java.lang.String r14 = r14.getVerifiedIccid()
            if (r14 == 0) goto L_0x04e0
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r0 = ","
            java.lang.String[] r0 = new java.lang.String[]{r0}
            java.util.List r5 = kotlin.m.p.a((java.lang.CharSequence) r14, (java.lang.String[]) r0)
        L_0x04e0:
            java.util.List<android.telephony.SubscriptionInfo> r14 = r13.f56636d
            int r14 = r14.size()
            if (r14 <= r7) goto L_0x0521
            if (r5 == 0) goto L_0x0521
            int r14 = r5.size()
            if (r14 != r7) goto L_0x0521
            java.lang.Object r14 = r5.get(r6)
            java.lang.String r14 = (java.lang.String) r14
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            int r14 = net.one97.paytm.oauth.utils.OAuthUtils.a((java.lang.String) r14, (java.util.List<android.telephony.SubscriptionInfo>) r0)
            if (r14 != 0) goto L_0x0505
            java.util.List<android.telephony.SubscriptionInfo> r14 = r13.f56636d
            java.lang.Object r14 = r14.get(r7)
            goto L_0x050b
        L_0x0505:
            java.util.List<android.telephony.SubscriptionInfo> r14 = r13.f56636d
            java.lang.Object r14 = r14.get(r6)
        L_0x050b:
            android.telephony.SubscriptionInfo r14 = (android.telephony.SubscriptionInfo) r14
            java.lang.String r14 = r14.getIccId()
            r13.l = r14
            r13.d()
            java.lang.String r14 = r13.f56641i
            java.lang.String r0 = r13.k
            java.lang.String r1 = r13.l
            r13.a((java.lang.String) r14, (java.lang.String) r0, (java.lang.String) r1)
            goto L_0x0690
        L_0x0521:
            java.util.List<android.telephony.SubscriptionInfo> r14 = r13.f56636d
            int r14 = r14.size()
            if (r14 <= r7) goto L_0x0530
            net.one97.paytm.oauth.utils.g r14 = net.one97.paytm.oauth.utils.g.DUAL_SIM_MISMATCH
            r13.a((net.one97.paytm.oauth.utils.g) r14)
            goto L_0x0690
        L_0x0530:
            net.one97.paytm.oauth.utils.g r14 = net.one97.paytm.oauth.utils.g.SINGLE_SIM_MISMATCH
            r13.a((net.one97.paytm.oauth.utils.g) r14)
            goto L_0x0690
        L_0x0537:
            java.lang.String r2 = "MAPPING_FOUND_WITH_USER_ID"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x05de
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r2 = "1"
            r0.add(r2)
            java.util.List<android.telephony.SubscriptionInfo> r2 = r13.f56636d
            int r2 = r2.size()
            if (r2 <= r7) goto L_0x0589
            java.lang.String r1 = "dual_sim"
            r0.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            java.lang.Object r1 = r1.get(r6)
            android.telephony.SubscriptionInfo r1 = (android.telephony.SubscriptionInfo) r1
            java.lang.CharSequence r1 = r1.getCarrierName()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0567
            r1 = r5
        L_0x0567:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x056c
            r1 = r10
        L_0x056c:
            r0.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            java.lang.Object r1 = r1.get(r7)
            android.telephony.SubscriptionInfo r1 = (android.telephony.SubscriptionInfo) r1
            java.lang.CharSequence r1 = r1.getCarrierName()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x0580
            r1 = r5
        L_0x0580:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0585
            r1 = r10
        L_0x0585:
            r0.add(r1)
            goto L_0x05b2
        L_0x0589:
            r0.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0596
        L_0x0594:
            r1 = r10
            goto L_0x05ac
        L_0x0596:
            java.util.List<android.telephony.SubscriptionInfo> r1 = r13.f56636d
            java.lang.Object r1 = r1.get(r6)
            android.telephony.SubscriptionInfo r1 = (android.telephony.SubscriptionInfo) r1
            java.lang.CharSequence r1 = r1.getCarrierName()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 != 0) goto L_0x05a7
            r1 = r5
        L_0x05a7:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x05ac
            goto L_0x0594
        L_0x05ac:
            r0.add(r1)
            r0.add(r10)
        L_0x05b2:
            java.lang.String r1 = "SMS"
            r0.add(r1)
            boolean r1 = r13.f56640h
            if (r1 == 0) goto L_0x05bc
            goto L_0x05bd
        L_0x05bc:
            r8 = r9
        L_0x05bd:
            java.lang.String r1 = "device_binding_config_successful"
            b(r1, r0, r8)
            net.one97.paytm.oauth.models.Data r14 = r14.getData()
            net.one97.paytm.oauth.models.Iccid r14 = r14.getIccidResponse()
            java.lang.String r14 = r14.getVerifiedIccid()
            r13.l = r14
            r13.d()
            java.lang.String r14 = r13.f56641i
            java.lang.String r0 = r13.k
            java.lang.String r1 = r13.l
            r13.a((java.lang.String) r14, (java.lang.String) r0, (java.lang.String) r1)
            goto L_0x0690
        L_0x05de:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.lang.String r0 = "3"
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            int r0 = r0.size()
            if (r0 <= r7) goto L_0x0628
            java.lang.String r0 = "dual_sim"
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r6)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x0606
            r0 = r5
        L_0x0606:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x060b
            r0 = r10
        L_0x060b:
            r14.add(r0)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r7)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x061f
            r0 = r5
        L_0x061f:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0624
            r0 = r10
        L_0x0624:
            r14.add(r0)
            goto L_0x0651
        L_0x0628:
            r14.add(r1)
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0635
        L_0x0633:
            r0 = r10
            goto L_0x064b
        L_0x0635:
            java.util.List<android.telephony.SubscriptionInfo> r0 = r13.f56636d
            java.lang.Object r0 = r0.get(r6)
            android.telephony.SubscriptionInfo r0 = (android.telephony.SubscriptionInfo) r0
            java.lang.CharSequence r0 = r0.getCarrierName()
            boolean r1 = r0 instanceof java.lang.String
            if (r1 != 0) goto L_0x0646
            r0 = r5
        L_0x0646:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x064b
            goto L_0x0633
        L_0x064b:
            r14.add(r0)
            r14.add(r10)
        L_0x0651:
            java.lang.String r0 = "SMS"
            r14.add(r0)
            boolean r0 = r13.f56640h
            if (r0 == 0) goto L_0x065b
            goto L_0x065c
        L_0x065b:
            r8 = r9
        L_0x065c:
            java.lang.String r0 = "device_binding_config_successful"
            b(r0, r14, r8)
            java.util.List<android.telephony.SubscriptionInfo> r14 = r13.f56636d
            int r14 = r14.size()
            if (r14 <= r7) goto L_0x066f
            net.one97.paytm.oauth.utils.g r14 = net.one97.paytm.oauth.utils.g.SELECT_SIM_CARD
            r13.a((net.one97.paytm.oauth.utils.g) r14)
            goto L_0x0690
        L_0x066f:
            java.util.List<android.telephony.SubscriptionInfo> r14 = r13.f56636d
            net.one97.paytm.oauth.b r0 = net.one97.paytm.oauth.OauthModule.b()
            java.lang.String r1 = "OauthModule.getOathDataProvider()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r14 = net.one97.paytm.oauth.utils.OAuthUtils.a((java.util.List<android.telephony.SubscriptionInfo>) r14, (android.content.Context) r0)
            r13.l = r14
            r13.d()
            java.lang.String r14 = r13.f56641i
            java.lang.String r0 = r13.k
            java.lang.String r1 = r13.l
            r13.a((java.lang.String) r14, (java.lang.String) r0, (java.lang.String) r1)
        L_0x0690:
            kotlin.x r14 = kotlin.x.f47997a
        L_0x0692:
            return
        L_0x0693:
            java.lang.String r14 = r14.getMessage()
            r13.e(r14)
            return
        L_0x069b:
            boolean r0 = r14 instanceof net.one97.paytm.oauth.models.DeviceBindingInitResModel
            if (r0 == 0) goto L_0x07f4
            net.one97.paytm.oauth.models.DeviceBindingInitResModel r14 = (net.one97.paytm.oauth.models.DeviceBindingInitResModel) r14
            java.lang.String r0 = r14.getResponseCode()
            if (r0 != 0) goto L_0x06a9
            goto L_0x07c2
        L_0x06a9:
            int r5 = r0.hashCode()
            r11 = -1260518837(0xffffffffb4de024b, float:-4.135239E-7)
            if (r5 == r11) goto L_0x075a
            r10 = -1258552631(0xffffffffb4fc02c9, float:-4.6940684E-7)
            if (r5 == r10) goto L_0x070c
            r10 = -1258493018(0xffffffffb4fceba6, float:-4.7110115E-7)
            if (r5 == r10) goto L_0x06be
            goto L_0x07c2
        L_0x06be:
            java.lang.String r5 = "BE1426011"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x07c2
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.String r4 = r13.o
            r0[r6] = r4
            java.lang.String r4 = r14.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0[r7] = r4
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            boolean r1 = r13.f56640h
            if (r1 == 0) goto L_0x06e7
            goto L_0x06e8
        L_0x06e7:
            r8 = r9
        L_0x06e8:
            java.lang.String r1 = "device_binding_successful"
            b(r1, r0, r8)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r14 = r14.getMessage()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r1 = "message"
            r0.putString(r1, r14)
            java.lang.String r14 = "IS_SHOW_RAISE_REQUEST"
            r0.putBoolean(r14, r6)
            androidx.fragment.app.j r14 = r13.getChildFragmentManager()
            net.one97.paytm.oauth.utils.OAuthUtils.a((androidx.fragment.app.j) r14, (android.os.Bundle) r0)
            return
        L_0x070c:
            java.lang.String r5 = "BE1424001"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x07c2
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.String r4 = r13.o
            r0[r6] = r4
            java.lang.String r4 = r14.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0[r7] = r4
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            boolean r1 = r13.f56640h
            if (r1 == 0) goto L_0x0735
            goto L_0x0736
        L_0x0735:
            r8 = r9
        L_0x0736:
            java.lang.String r1 = "device_binding_successful"
            b(r1, r0, r8)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r14 = r14.getMessage()
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r1 = "message"
            r0.putString(r1, r14)
            java.lang.String r14 = "IS_SHOW_RAISE_REQUEST"
            r0.putBoolean(r14, r7)
            androidx.fragment.app.j r14 = r13.getChildFragmentManager()
            net.one97.paytm.oauth.utils.OAuthUtils.a((androidx.fragment.app.j) r14, (android.os.Bundle) r0)
            return
        L_0x075a:
            java.lang.String r5 = "BE1400001"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x07c2
            net.one97.paytm.oauth.models.DataModel r0 = r14.getData()
            if (r0 == 0) goto L_0x076e
            java.lang.String r0 = r0.getSessionId()
            if (r0 != 0) goto L_0x076f
        L_0x076e:
            r0 = r10
        L_0x076f:
            r13.j = r0
            java.lang.String[] r0 = new java.lang.String[r7]
            java.lang.String r1 = r13.o
            r0[r6] = r1
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            boolean r1 = r13.f56640h
            if (r1 == 0) goto L_0x0780
            goto L_0x0781
        L_0x0780:
            r8 = r9
        L_0x0781:
            java.lang.String r1 = "device_binding_successful"
            b(r1, r0, r8)
            net.one97.paytm.oauth.models.DataModel r14 = r14.getData()
            if (r14 == 0) goto L_0x07a4
            boolean r14 = r14.getDeviceBindingExist()
            if (r14 != r7) goto L_0x07a4
            net.one97.paytm.oauth.fragment.w$b r14 = r13.f56634b
            if (r14 == 0) goto L_0x07a3
            java.lang.String r0 = r13.d()
            java.lang.String r1 = r13.j
            boolean r2 = r13.f56640h
            r14.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r2)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x07a3:
            return
        L_0x07a4:
            java.lang.String r14 = r13.k
            java.lang.String r0 = "sms"
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r0)
            if (r14 == 0) goto L_0x07b4
            net.one97.paytm.oauth.utils.g r14 = net.one97.paytm.oauth.utils.g.VERIFYING_NUMBER
            r13.a((net.one97.paytm.oauth.utils.g) r14)
            return
        L_0x07b4:
            net.one97.paytm.oauth.fragment.w$b r14 = r13.f56634b
            if (r14 == 0) goto L_0x07c1
            java.lang.String r0 = r13.j
            boolean r1 = r13.f56640h
            r14.a((java.lang.String) r0, (boolean) r1, (boolean) r7)
            kotlin.x r14 = kotlin.x.f47997a
        L_0x07c1:
            return
        L_0x07c2:
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.String r4 = r13.o
            r0[r6] = r4
            java.lang.String r4 = r14.getMessage()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0[r7] = r4
            r0[r3] = r2
            java.lang.String r2 = r14.getResponseCode()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0[r1] = r2
            java.util.ArrayList r0 = kotlin.a.k.d(r0)
            boolean r1 = r13.f56640h
            if (r1 == 0) goto L_0x07e7
            goto L_0x07e8
        L_0x07e7:
            r8 = r9
        L_0x07e8:
            java.lang.String r1 = "device_binding_successful"
            b(r1, r0, r8)
            java.lang.String r14 = r14.getMessage()
            r13.e(r14)
        L_0x07f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.w.a(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f56652a;

        i(w wVar) {
            this.f56652a = wVar;
        }

        public final void onClick(View view) {
            b b2 = this.f56652a.f56634b;
            if (b2 != null) {
                b2.ad_();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d8, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) "oauthdevicebindinginitSv1") == false) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01da, code lost:
        r2 = r5.getString("message");
        kotlin.g.b.k.a((java.lang.Object) r2, "jsonObj.getString(KEY_MESSAGE)");
        kotlin.g.b.k.a((java.lang.Object) r9, "responseCode");
        r0 = kotlin.a.k.d(r1.o, r2, net.one97.paytm.nativesdk.Constants.SDKConstants.KEY_API, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01fa, code lost:
        if (r1.f56640h == false) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01fd, code lost:
        r12 = "login";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01fe, code lost:
        b("device_binding_successful", r0, r12);
        e(getString(net.one97.paytm.oauth.R.string.some_went_wrong));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x020a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0170, code lost:
        if (r2 != r10.intValue()) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017f, code lost:
        if (r2 == r10.intValue()) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0185, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) "oauthdevicebindinginitSv1") == false) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0187, code lost:
        r2 = r5.getString("message");
        kotlin.g.b.k.a((java.lang.Object) r2, "jsonObj.getString(KEY_MESSAGE)");
        kotlin.g.b.k.a((java.lang.Object) r9, "responseCode");
        r0 = kotlin.a.k.d(r1.o, r2, net.one97.paytm.nativesdk.Constants.SDKConstants.KEY_API, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a7, code lost:
        if (r1.f56640h == false) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01aa, code lost:
        r12 = "login";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01ab, code lost:
        b("device_binding_successful", r0, r12);
        e(r5.getString("message"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c3, code lost:
        if (r2 != r10.intValue()) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01d2, code lost:
        if (r0 == r2.intValue()) goto L_0x01d4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.oauth.models.ErrorModel r18, java.lang.Throwable r19, java.lang.String r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r20
            r3 = r21
            java.lang.String r4 = "responseCode"
            java.lang.String r5 = "mobile"
            kotlin.g.b.k.c(r2, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = " "
            r5.<init>(r6)
            if (r0 == 0) goto L_0x0026
            com.paytm.network.model.NetworkCustomError r6 = r18.getCustomError()
            if (r6 == 0) goto L_0x0026
            com.paytm.network.model.NetworkResponse r6 = r6.networkResponse
            if (r6 == 0) goto L_0x0026
            byte[] r6 = r6.data
            if (r6 != 0) goto L_0x0033
        L_0x0026:
            java.nio.charset.Charset r6 = kotlin.m.d.f47971a
            java.lang.String r7 = "No response"
            byte[] r6 = r7.getBytes(r6)
            java.lang.String r7 = "(this as java.lang.String).getBytes(charset)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
        L_0x0033:
            java.lang.String r7 = new java.lang.String
            java.nio.charset.Charset r8 = kotlin.m.d.f47971a
            r7.<init>(r6, r8)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.paytm.utility.q.b(r5)
            net.one97.paytm.oauth.fragment.w$b r5 = r1.f56634b
            if (r5 == 0) goto L_0x004b
            r5.ac_()
        L_0x004b:
            androidx.fragment.app.FragmentActivity r5 = r17.getActivity()
            android.app.Activity r5 = (android.app.Activity) r5
            r6 = r1
            androidx.fragment.app.Fragment r6 = (androidx.fragment.app.Fragment) r6
            if (r19 == 0) goto L_0x0237
            r7 = r19
            com.paytm.network.model.NetworkCustomError r7 = (com.paytm.network.model.NetworkCustomError) r7
            boolean r5 = net.one97.paytm.oauth.utils.OAuthUtils.a((android.app.Activity) r5, (androidx.fragment.app.Fragment) r6, (com.paytm.network.model.NetworkCustomError) r7)
            if (r5 == 0) goto L_0x0061
            return
        L_0x0061:
            java.lang.String r5 = "oauthLoginInitSv1"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r5)
            java.lang.String r7 = "oauthdevicebindinginitSv1"
            if (r5 != 0) goto L_0x0074
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r7)
            if (r5 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r5 = 0
            goto L_0x0075
        L_0x0074:
            r5 = 1
        L_0x0075:
            if (r5 == 0) goto L_0x0081
            boolean r5 = net.one97.paytm.oauth.utils.l.a((net.one97.paytm.oauth.models.ErrorModel) r18)
            if (r5 == 0) goto L_0x0081
            r1.c(r2)
            return
        L_0x0081:
            android.content.Context r5 = r17.requireContext()
            net.one97.paytm.oauth.fragment.w$g r9 = new net.one97.paytm.oauth.fragment.w$g
            r9.<init>(r1, r3)
            android.content.DialogInterface$OnClickListener r9 = (android.content.DialogInterface.OnClickListener) r9
            boolean r5 = net.one97.paytm.oauth.utils.l.a(r0, r5, r9)
            if (r5 != 0) goto L_0x0236
            if (r0 == 0) goto L_0x0099
            com.paytm.network.model.NetworkCustomError r5 = r18.getCustomError()
            goto L_0x009a
        L_0x0099:
            r5 = 0
        L_0x009a:
            boolean r5 = r5 instanceof com.paytm.network.model.NetworkCustomError
            if (r5 == 0) goto L_0x022d
            com.paytm.network.model.NetworkCustomError r5 = r18.getCustomError()
            com.paytm.network.model.NetworkResponse r5 = r5.networkResponse
            byte[] r5 = r5.data
            if (r5 == 0) goto L_0x022c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = kotlin.m.d.f47971a
            r9.<init>(r5, r10)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0223
            java.lang.String r9 = new java.lang.String     // Catch:{ JSONException -> 0x0215 }
            java.nio.charset.Charset r10 = kotlin.m.d.f47971a     // Catch:{ JSONException -> 0x0215 }
            r9.<init>(r5, r10)     // Catch:{ JSONException -> 0x0215 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0215 }
            r5.<init>(r9)     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r9 = r5.getString(r4)     // Catch:{ JSONException -> 0x0215 }
            int r10 = r18.getStatus()     // Catch:{ JSONException -> 0x0215 }
            java.lang.Integer r11 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r12 = "signup"
            java.lang.String r13 = "login"
            java.lang.String r15 = "api"
            r16 = 2
            java.lang.String r14 = "jsonObj.getString(KEY_MESSAGE)"
            java.lang.String r6 = "device_binding_successful"
            java.lang.String r8 = "message"
            if (r11 != 0) goto L_0x00de
            goto L_0x011a
        L_0x00de:
            int r11 = r11.intValue()     // Catch:{ JSONException -> 0x0215 }
            if (r10 != r11) goto L_0x011a
            java.lang.String r10 = "BE1423003"
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x0215 }
            if (r10 == 0) goto L_0x011a
            r1.c(r2)     // Catch:{ JSONException -> 0x0215 }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x0215 }
            if (r0 == 0) goto L_0x022c
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r1.o     // Catch:{ JSONException -> 0x0215 }
            r3 = 0
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r5.getString(r8)     // Catch:{ JSONException -> 0x0215 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x0215 }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            r0[r16] = r15     // Catch:{ JSONException -> 0x0215 }
            r2 = 3
            r0[r2] = r9     // Catch:{ JSONException -> 0x0215 }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x0215 }
            boolean r2 = r1.f56640h     // Catch:{ JSONException -> 0x0215 }
            if (r2 == 0) goto L_0x0115
            goto L_0x0116
        L_0x0115:
            r12 = r13
        L_0x0116:
            b(r6, r0, r12)     // Catch:{ JSONException -> 0x0215 }
            return
        L_0x011a:
            int r2 = r18.getStatus()     // Catch:{ JSONException -> 0x0215 }
            java.lang.Integer r10 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x0215 }
            if (r10 != 0) goto L_0x0123
            goto L_0x0163
        L_0x0123:
            int r10 = r10.intValue()     // Catch:{ JSONException -> 0x0215 }
            if (r2 != r10) goto L_0x0163
            java.lang.String r2 = "BE1423002"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x0215 }
            if (r2 == 0) goto L_0x0163
            java.lang.String r0 = r5.getString(r8)     // Catch:{ JSONException -> 0x0215 }
            r1.e(r0)     // Catch:{ JSONException -> 0x0215 }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x0215 }
            if (r0 == 0) goto L_0x022c
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r1.o     // Catch:{ JSONException -> 0x0215 }
            r3 = 0
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r5.getString(r8)     // Catch:{ JSONException -> 0x0215 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x0215 }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            r0[r16] = r15     // Catch:{ JSONException -> 0x0215 }
            r2 = 3
            r0[r2] = r9     // Catch:{ JSONException -> 0x0215 }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x0215 }
            boolean r2 = r1.f56640h     // Catch:{ JSONException -> 0x0215 }
            if (r2 == 0) goto L_0x015e
            goto L_0x015f
        L_0x015e:
            r12 = r13
        L_0x015f:
            b(r6, r0, r12)     // Catch:{ JSONException -> 0x0215 }
            return
        L_0x0163:
            int r2 = r18.getStatus()     // Catch:{ JSONException -> 0x0215 }
            java.lang.Integer r10 = net.one97.paytm.oauth.utils.n.f56788g     // Catch:{ JSONException -> 0x0215 }
            if (r10 != 0) goto L_0x016c
            goto L_0x0172
        L_0x016c:
            int r10 = r10.intValue()     // Catch:{ JSONException -> 0x0215 }
            if (r2 == r10) goto L_0x0181
        L_0x0172:
            int r2 = r18.getStatus()     // Catch:{ JSONException -> 0x0215 }
            java.lang.Integer r10 = net.one97.paytm.oauth.utils.n.j     // Catch:{ JSONException -> 0x0215 }
            if (r10 != 0) goto L_0x017b
            goto L_0x01b6
        L_0x017b:
            int r10 = r10.intValue()     // Catch:{ JSONException -> 0x0215 }
            if (r2 != r10) goto L_0x01b6
        L_0x0181:
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x0215 }
            if (r2 == 0) goto L_0x01b6
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r1.o     // Catch:{ JSONException -> 0x0215 }
            r3 = 0
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r5.getString(r8)     // Catch:{ JSONException -> 0x0215 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x0215 }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            r0[r16] = r15     // Catch:{ JSONException -> 0x0215 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)     // Catch:{ JSONException -> 0x0215 }
            r2 = 3
            r0[r2] = r9     // Catch:{ JSONException -> 0x0215 }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x0215 }
            boolean r2 = r1.f56640h     // Catch:{ JSONException -> 0x0215 }
            if (r2 == 0) goto L_0x01aa
            goto L_0x01ab
        L_0x01aa:
            r12 = r13
        L_0x01ab:
            b(r6, r0, r12)     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r0 = r5.getString(r8)     // Catch:{ JSONException -> 0x0215 }
            r1.e(r0)     // Catch:{ JSONException -> 0x0215 }
            return
        L_0x01b6:
            int r2 = r18.getStatus()     // Catch:{ JSONException -> 0x0215 }
            java.lang.Integer r10 = net.one97.paytm.oauth.utils.n.f56783b     // Catch:{ JSONException -> 0x0215 }
            if (r10 != 0) goto L_0x01bf
            goto L_0x01c5
        L_0x01bf:
            int r10 = r10.intValue()     // Catch:{ JSONException -> 0x0215 }
            if (r2 == r10) goto L_0x01d4
        L_0x01c5:
            int r0 = r18.getStatus()     // Catch:{ JSONException -> 0x0215 }
            java.lang.Integer r2 = net.one97.paytm.oauth.utils.n.f56784c     // Catch:{ JSONException -> 0x0215 }
            if (r2 != 0) goto L_0x01ce
            goto L_0x020b
        L_0x01ce:
            int r2 = r2.intValue()     // Catch:{ JSONException -> 0x0215 }
            if (r0 != r2) goto L_0x020b
        L_0x01d4:
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x0215 }
            if (r0 == 0) goto L_0x020b
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r1.o     // Catch:{ JSONException -> 0x0215 }
            r3 = 0
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r2 = r5.getString(r8)     // Catch:{ JSONException -> 0x0215 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)     // Catch:{ JSONException -> 0x0215 }
            r3 = 1
            r0[r3] = r2     // Catch:{ JSONException -> 0x0215 }
            r0[r16] = r15     // Catch:{ JSONException -> 0x0215 }
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)     // Catch:{ JSONException -> 0x0215 }
            r2 = 3
            r0[r2] = r9     // Catch:{ JSONException -> 0x0215 }
            java.util.ArrayList r0 = kotlin.a.k.d(r0)     // Catch:{ JSONException -> 0x0215 }
            boolean r2 = r1.f56640h     // Catch:{ JSONException -> 0x0215 }
            if (r2 == 0) goto L_0x01fd
            goto L_0x01fe
        L_0x01fd:
            r12 = r13
        L_0x01fe:
            b(r6, r0, r12)     // Catch:{ JSONException -> 0x0215 }
            int r0 = net.one97.paytm.oauth.R.string.some_went_wrong     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ JSONException -> 0x0215 }
            r1.e(r0)     // Catch:{ JSONException -> 0x0215 }
            return
        L_0x020b:
            int r0 = net.one97.paytm.oauth.R.string.some_went_wrong     // Catch:{ JSONException -> 0x0215 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ JSONException -> 0x0215 }
            r1.e(r0)     // Catch:{ JSONException -> 0x0215 }
            return
        L_0x0215:
            r0 = move-exception
            int r2 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r2 = r1.getString(r2)
            r1.e(r2)
            r0.printStackTrace()
            return
        L_0x0223:
            int r0 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r0 = r1.getString(r0)
            r1.e(r0)
        L_0x022c:
            return
        L_0x022d:
            int r0 = net.one97.paytm.oauth.R.string.some_went_wrong
            java.lang.String r0 = r1.getString(r0)
            r1.e(r0)
        L_0x0236:
            return
        L_0x0237:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.w.a(net.one97.paytm.oauth.models.ErrorModel, java.lang.Throwable, java.lang.String, java.lang.String):void");
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f56649a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f56650b;

        g(w wVar, String str) {
            this.f56649a = wVar;
            this.f56650b = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            b b2 = this.f56649a.f56634b;
            if (b2 != null) {
                b2.ab_();
            }
            w.a(this.f56649a, this.f56650b);
        }
    }

    private final void c(String str) {
        b bVar = this.f56634b;
        if (bVar != null) {
            bVar.ab_();
        }
        o oVar = o.f56791a;
        o.b(str);
        if (this.f56635c < 2) {
            if (!this.m || !kotlin.g.b.k.a((Object) this.s, (Object) "device_binding")) {
                e();
            } else {
                a(this.f56641i, this.k, this.l);
            }
            this.f56635c++;
            return;
        }
        b bVar2 = this.f56634b;
        if (bVar2 != null) {
            bVar2.ac_();
        }
        com.paytm.utility.b.b(requireContext(), getString(R.string.oauth_error), getString(R.string.some_went_wrong));
    }

    static /* synthetic */ void a(String str, ArrayList arrayList, int i2) {
        if ((i2 & 2) != 0) {
            arrayList = new ArrayList();
        }
        b(str, arrayList, (String) null);
    }

    /* access modifiers changed from: private */
    public static void b(String str, ArrayList<String> arrayList, String str2) {
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        net.one97.paytm.oauth.b b3 = OauthModule.b();
        kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
        b2.sendGAMultipleLabelEvent(b3.getApplicationContext(), "login_signup", str, arrayList, str2, "/login-signup", p.f56796a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean h() {
        /*
            r5 = this;
            java.util.List r0 = net.one97.paytm.oauth.utils.OAuthUtils.a()
            java.lang.String r1 = "OAuthUtils.getAvailableSimCards()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r5.f56636d = r0
            java.util.List<android.telephony.SubscriptionInfo> r0 = r5.f56636d
            int r0 = r0.size()
            r1 = 1
            if (r0 > 0) goto L_0x0069
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 22
            r3 = 0
            if (r0 >= r2) goto L_0x003b
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            r2 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.String r4 = "phone"
            java.lang.Object r0 = r0.getSystemService(r4)
            goto L_0x002a
        L_0x0029:
            r0 = r2
        L_0x002a:
            boolean r4 = r0 instanceof android.telephony.TelephonyManager
            if (r4 != 0) goto L_0x002f
            r0 = r2
        L_0x002f:
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            if (r0 == 0) goto L_0x0037
            java.lang.String r2 = r0.getSimSerialNumber()
        L_0x0037:
            if (r2 == 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x003f
            goto L_0x0069
        L_0x003f:
            net.one97.paytm.oauth.fragment.aw$a r0 = net.one97.paytm.oauth.fragment.aw.f56387b
            net.one97.paytm.oauth.fragment.aw r0 = new net.one97.paytm.oauth.fragment.aw
            r0.<init>()
            androidx.fragment.app.j r1 = r5.getChildFragmentManager()
            androidx.fragment.app.q r1 = r1.a()
            java.lang.String r2 = "childFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            java.lang.Class<net.one97.paytm.oauth.fragment.aw> r2 = net.one97.paytm.oauth.fragment.aw.class
            java.lang.String r2 = r2.getName()
            r1.a((androidx.fragment.app.Fragment) r0, (java.lang.String) r2)
            r1.c()
            net.one97.paytm.oauth.fragment.w$b r0 = r5.f56634b
            if (r0 == 0) goto L_0x0068
            r0.ac_()
        L_0x0068:
            return r3
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.w.h():boolean");
    }

    private final void a(net.one97.paytm.oauth.utils.g gVar) {
        Bundle bundle = new Bundle();
        bundle.putString("login_mobile", d());
        bundle.putString("login_signup_flow", this.f56641i);
        bundle.putInt("binding_timeout", this.f56637e);
        bundle.putInt("sms_retry_count", this.f56638f);
        bundle.putInt("sms_retry_interval", this.f56639g);
        bundle.putBoolean("is_new_signup", this.f56640h);
        bundle.putString("sms_polling_frequency", this.n);
        bundle.putString("device_binding_flow", this.k);
        bundle.putInt("sms_time_out", this.q);
        bundle.putInt("send_sms_delay", this.t);
        bundle.putParcelableArrayList("simInfoList", new ArrayList(this.f56636d));
        if (gVar == net.one97.paytm.oauth.utils.g.VERIFYING_NUMBER) {
            bundle.putString(H5Param.SESSION_ID, this.j);
            bundle.putString("iccid", this.l);
        } else if (gVar == net.one97.paytm.oauth.utils.g.SINGLE_SIM_MISMATCH || gVar == net.one97.paytm.oauth.utils.g.DUAL_SIM_MISMATCH) {
            bundle.putBoolean("before_ver", true);
            bundle.putString("iccid", this.l);
        }
        b bVar = this.f56634b;
        if (bVar != null) {
            bVar.a(bundle, gVar);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 100) {
            int length = iArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = iArr[i3];
                if (kotlin.g.b.k.a((Object) strArr[i3], (Object) "android.permission.ACCESS_FINE_LOCATION")) {
                    if (a("location", i4)) {
                        ArrayList arrayList = new ArrayList();
                        q qVar = q.f56798a;
                        b("location_permission_allow", arrayList, String.valueOf(q.B() + 1));
                        OAuthUtils.a((Activity) getActivity());
                        net.one97.paytm.oauth.utils.j jVar = this.r;
                        if (jVar != null) {
                            FragmentActivity requireActivity = requireActivity();
                            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
                            jVar.a((Activity) requireActivity);
                        }
                    }
                } else if (kotlin.g.b.k.a((Object) strArr[i3], (Object) "android.permission.READ_PHONE_STATE")) {
                    if (a("phone_state", i4)) {
                        a("phone_state_permission_allow", new ArrayList(), 4);
                        b("sms_state");
                    }
                } else if (kotlin.g.b.k.a((Object) strArr[i3], (Object) "android.permission.SEND_SMS") && a("sms_state", i4) && h()) {
                    a("send_sms_permission_allow", new ArrayList(), 4);
                    ay ayVar = ay.f56391a;
                    Context requireContext = requireContext();
                    kotlin.g.b.k.a((Object) requireContext, "requireContext()");
                    if (ay.a(requireContext, d())) {
                        b("location");
                    } else {
                        a(false);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            java.lang.String r1 = "phone_state"
            r2 = 1901043637(0x714f9fb5, float:1.0281035E30)
            r3 = -707913088(0xffffffffd5ce1a80, float:-2.83266515E13)
            java.lang.String r4 = "location"
            if (r0 == r3) goto L_0x001c
            if (r0 == r2) goto L_0x0013
            goto L_0x0025
        L_0x0013:
            boolean r0 = r8.equals(r4)
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            goto L_0x0027
        L_0x001c:
            boolean r0 = r8.equals(r1)
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            goto L_0x0027
        L_0x0025:
            java.lang.String r0 = "android.permission.SEND_SMS"
        L_0x0027:
            int r5 = r8.hashCode()
            if (r5 == r3) goto L_0x0039
            if (r5 == r2) goto L_0x0030
            goto L_0x0042
        L_0x0030:
            boolean r5 = r8.equals(r4)
            if (r5 == 0) goto L_0x0042
            java.lang.String r5 = "location_permission_deny"
            goto L_0x0044
        L_0x0039:
            boolean r5 = r8.equals(r1)
            if (r5 == 0) goto L_0x0042
            java.lang.String r5 = "phone_state_permission_deny"
            goto L_0x0044
        L_0x0042:
            java.lang.String r5 = "send_sms_permission_deny"
        L_0x0044:
            int r6 = r8.hashCode()
            if (r6 == r3) goto L_0x0056
            if (r6 == r2) goto L_0x004d
            goto L_0x005f
        L_0x004d:
            boolean r1 = r8.equals(r4)
            if (r1 == 0) goto L_0x005f
            java.lang.String r1 = "location_permission_deny_dont_ask"
            goto L_0x0061
        L_0x0056:
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x005f
            java.lang.String r1 = "phone_state_permission_deny_dont_ask"
            goto L_0x0061
        L_0x005f:
            java.lang.String r1 = "send_sms_permission_deny_dont_ask"
        L_0x0061:
            boolean r0 = r7.shouldShowRequestPermissionRationale(r0)
            r2 = 1
            r3 = 4
            if (r0 == 0) goto L_0x008e
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            a((java.lang.String) r5, (java.util.ArrayList) r9, (int) r3)
            net.one97.paytm.oauth.fragment.w$b r9 = r7.f56634b
            if (r9 == 0) goto L_0x0078
            r9.ac_()
        L_0x0078:
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.Object) r4)
            if (r9 == 0) goto L_0x008a
            net.one97.paytm.oauth.utils.q r9 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.oauth.utils.q r9 = net.one97.paytm.oauth.utils.q.f56798a
            int r9 = net.one97.paytm.oauth.utils.q.B()
            int r9 = r9 + r2
            net.one97.paytm.oauth.utils.q.d((int) r9)
        L_0x008a:
            r7.d(r8)
            goto L_0x00b1
        L_0x008e:
            r8 = -1
            if (r9 != r8) goto L_0x00b3
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            a((java.lang.String) r1, (java.util.ArrayList) r8, (int) r3)
            net.one97.paytm.oauth.fragment.w$b r8 = r7.f56634b
            if (r8 == 0) goto L_0x00a0
            r8.ac_()
        L_0x00a0:
            boolean r8 = r7.isAdded()
            if (r8 == 0) goto L_0x00b1
            net.one97.paytm.oauth.fragment.ay r8 = net.one97.paytm.oauth.fragment.ay.f56391a
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            android.app.Activity r8 = (android.app.Activity) r8
            net.one97.paytm.oauth.fragment.ay.d(r8)
        L_0x00b1:
            r8 = 0
            return r8
        L_0x00b3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.w.a(java.lang.String, int):boolean");
    }

    private final void d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("permissionstate", str);
        ba.a aVar = ba.f56399a;
        ba a2 = ba.a.a(bundle);
        a2.a((ba.b) this);
        a((Fragment) a2);
    }

    public final void a_(String str) {
        b(str);
    }

    private final void a(Fragment fragment) {
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
        a2.a(fragment, ba.class.getName());
        a2.c();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r5) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            if (r5 != 0) goto L_0x0009
            goto L_0x004d
        L_0x0009:
            int r2 = r5.hashCode()
            r3 = -707913088(0xffffffffd5ce1a80, float:-2.83266515E13)
            if (r2 == r3) goto L_0x0035
            r3 = 1901043637(0x714f9fb5, float:1.0281035E30)
            if (r2 == r3) goto L_0x0018
            goto L_0x004d
        L_0x0018:
            java.lang.String r2 = "location"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x004d
            java.lang.String r5 = "android.permission.ACCESS_FINE_LOCATION"
            r0.add(r5)
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            r0.add(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r2 = "location_permission_popup_loaded"
            a((java.lang.String) r2, (java.util.ArrayList) r5, (int) r1)
            goto L_0x0061
        L_0x0035:
            java.lang.String r2 = "phone_state"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x004d
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            r0.add(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r2 = "phone_state_permission_popup_loaded"
            a((java.lang.String) r2, (java.util.ArrayList) r5, (int) r1)
            goto L_0x0061
        L_0x004d:
            java.lang.String r5 = "android.permission.SEND_SMS"
            r0.add(r5)
            java.lang.String r5 = "android.permission.READ_SMS"
            r0.add(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r2 = "send_sms_permission_popup_loaded"
            a((java.lang.String) r2, (java.util.ArrayList) r5, (int) r1)
        L_0x0061:
            int r5 = r0.size()
            if (r5 <= 0) goto L_0x0090
            java.util.Collection r0 = (java.util.Collection) r0
            r5 = 0
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r5 = r0.toArray(r5)
            if (r5 == 0) goto L_0x0088
            java.lang.String[] r5 = (java.lang.String[]) r5
            net.one97.paytm.oauth.fragment.ay r0 = net.one97.paytm.oauth.fragment.ay.f56391a     // Catch:{ ActivityNotFoundException -> 0x007f }
            r0 = r4
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0     // Catch:{ ActivityNotFoundException -> 0x007f }
            r1 = 100
            net.one97.paytm.oauth.fragment.ay.a(r5, r0, r1)     // Catch:{ ActivityNotFoundException -> 0x007f }
            return
        L_0x007f:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.paytm.utility.q.d(r5)
            goto L_0x0090
        L_0x0088:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r5.<init>(r0)
            throw r5
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.w.b(java.lang.String):void");
    }

    private final void e(String str) {
        OAuthUtils.a((Activity) getActivity(), str);
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        this.f56635c = 0;
        if (z) {
            ay ayVar = ay.f56391a;
            Context requireContext = requireContext();
            kotlin.g.b.k.a((Object) requireContext, "requireContext()");
            if (ay.a(requireContext, d())) {
                net.one97.paytm.oauth.utils.j jVar = this.r;
                if (jVar != null) {
                    FragmentActivity requireActivity = requireActivity();
                    kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
                    jVar.a((Activity) requireActivity);
                    return;
                }
                return;
            }
        }
        b bVar = this.f56634b;
        if (bVar != null) {
            bVar.ab_();
        }
        if (!this.m) {
            e();
        } else if (h()) {
            this.o = this instanceof aq ? "post_config_fullpage" : "post_config_session_expiry";
            g();
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        ay ayVar = ay.f56391a;
        FragmentActivity requireActivity = requireActivity();
        kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
        if (!ay.a((Activity) requireActivity)) {
            b("phone_state");
            return;
        }
        ay ayVar2 = ay.f56391a;
        FragmentActivity requireActivity2 = requireActivity();
        kotlin.g.b.k.a((Object) requireActivity2, "requireActivity()");
        if (!ay.b((Activity) requireActivity2)) {
            b("sms_state");
            return;
        }
        ay ayVar3 = ay.f56391a;
        Context requireContext = requireContext();
        kotlin.g.b.k.a((Object) requireContext, "requireContext()");
        if (ay.a(requireContext)) {
            net.one97.paytm.oauth.utils.j jVar = this.r;
            if (jVar != null) {
                FragmentActivity requireActivity3 = requireActivity();
                kotlin.g.b.k.a((Object) requireActivity3, "requireActivity()");
                jVar.a((Activity) requireActivity3);
                return;
            }
            return;
        }
        b("location");
    }

    public static final class h implements net.one97.paytm.oauth.e.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w f56651a;

        h(w wVar) {
            this.f56651a = wVar;
        }

        public final void a(double d2, double d3, long j) {
            new StringBuilder("End time:").append(System.currentTimeMillis());
            StringBuilder sb = new StringBuilder("Latitude:");
            sb.append(d2);
            sb.append(",longitude:");
            sb.append(d3);
            w.b("location_fetch_success", new ArrayList(), String.valueOf(j));
            b b2 = this.f56651a.f56634b;
            if (b2 != null) {
                b2.ac_();
            }
            q qVar = q.f56798a;
            q.j(String.valueOf(d2));
            q qVar2 = q.f56798a;
            q.k(String.valueOf(d3));
            ay ayVar = ay.f56391a;
            FragmentActivity requireActivity = this.f56651a.requireActivity();
            kotlin.g.b.k.a((Object) requireActivity, "requireActivity()");
            if (ay.a((Activity) requireActivity, this.f56651a.d())) {
                this.f56651a.a(false);
                return;
            }
            ay ayVar2 = ay.f56391a;
            FragmentActivity requireActivity2 = this.f56651a.requireActivity();
            kotlin.g.b.k.a((Object) requireActivity2, "requireActivity()");
            if (!ay.a((Activity) requireActivity2)) {
                this.f56651a.b("phone_state");
            } else {
                this.f56651a.b("sms_state");
            }
        }

        public final void a() {
            b b2 = this.f56651a.f56634b;
            if (b2 != null) {
                b2.ab_();
            }
            w.a("gps_ok", (ArrayList) null, 6);
        }

        public final void b() {
            b b2 = this.f56651a.f56634b;
            if (b2 != null) {
                b2.ac_();
            }
            w.a("gps_no_thanks", (ArrayList) null, 6);
        }

        public final void c() {
            w.a("gps_popup_loaded", (ArrayList) null, 6);
        }
    }

    @kotlin.d.b.a.f(b = "BaseLoginFragment.kt", c = {163}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.BaseLoginFragment$callDeviceBindingInitApi$1")
    static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $iccids;
        final /* synthetic */ String $loginSignUpFlow;
        final /* synthetic */ String $method;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ w this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(w wVar, String str, String str2, String str3, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = wVar;
            this.$loginSignUpFlow = str;
            this.$method = str2;
            this.$iccids = str3;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            d dVar2 = new d(this.this$0, this.$loginSignUpFlow, this.$method, this.$iccids, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
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
                w wVar = this.this$0;
                String d2 = wVar.d();
                this.label = 1;
                obj = wVar.a(d2, (kotlin.d.d<? super Boolean>) this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            if (((Boolean) obj).booleanValue()) {
                this.this$0.b().a(this.this$0.d(), this.$loginSignUpFlow, this.$method, this.$iccids).observe(this.this$0, new z<net.one97.paytm.oauth.e<IJRPaytmDataModel>>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ d f56646a;

                    {
                        this.f56646a = r1;
                    }

                    public final /* synthetic */ void onChanged(Object obj) {
                        net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
                        if (eVar != null) {
                            b b2 = this.f56646a.this$0.f56634b;
                            if (b2 != null) {
                                b2.ac_();
                            }
                            if (eVar.f52602a != 101) {
                                this.f56646a.this$0.a((ErrorModel) eVar.f52603b, eVar.f52604c, this.f56646a.this$0.d(), eVar.f52605d);
                                return;
                            }
                            this.f56646a.this$0.a((IJRPaytmDataModel) eVar.f52603b);
                        }
                    }
                });
            } else if (this.this$0.isVisible()) {
                net.one97.paytm.oauth.d.a.a(this.this$0.requireContext(), this.this$0.getString(R.string.some_went_wrong), (View.OnClickListener) AnonymousClass1.f56645a);
            }
            return x.f47997a;
        }
    }

    @kotlin.d.b.a.f(b = "BaseLoginFragment.kt", c = {115}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.BaseLoginFragment$callLoginInitApi$1")
    static final class e extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ w this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(w wVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = wVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            e eVar = new e(this.this$0, dVar);
            eVar.p$ = (CoroutineScope) obj;
            return eVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((e) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
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
                    w wVar = this.this$0;
                    String d2 = wVar.d();
                    this.label = 1;
                    obj = wVar.a(d2, (kotlin.d.d<? super Boolean>) this);
                    if (obj == aVar) {
                        return aVar;
                    }
                }
                this.this$0.b().a(this.this$0.getContext(), this.this$0.d(), "signup").observe(this.this$0, new z<net.one97.paytm.oauth.e<IJRPaytmDataModel>>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ e f56648a;

                    {
                        this.f56648a = r1;
                    }

                    public final /* synthetic */ void onChanged(Object obj) {
                        net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
                        if (eVar != null) {
                            b b2 = this.f56648a.this$0.f56634b;
                            if (b2 != null) {
                                b2.ac_();
                            }
                            if (eVar.f52602a != 101) {
                                this.f56648a.this$0.a((ErrorModel) eVar.f52603b, eVar.f52604c, this.f56648a.this$0.d(), eVar.f52605d);
                                return;
                            }
                            this.f56648a.this$0.a((IJRPaytmDataModel) eVar.f52603b);
                        }
                    }
                });
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
            if (!((Boolean) obj).booleanValue()) {
                if (this.this$0.isVisible()) {
                    net.one97.paytm.oauth.d.a.a(this.this$0.requireContext(), this.this$0.getString(R.string.some_went_wrong), (View.OnClickListener) AnonymousClass1.f56647a);
                }
                return x.f47997a;
            }
            this.this$0.b().a(this.this$0.getContext(), this.this$0.d(), "signup").observe(this.this$0, new z<net.one97.paytm.oauth.e<IJRPaytmDataModel>>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ e f56648a;

                {
                    this.f56648a = r1;
                }

                public final /* synthetic */ void onChanged(Object obj) {
                    net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
                    if (eVar != null) {
                        b b2 = this.f56648a.this$0.f56634b;
                        if (b2 != null) {
                            b2.ac_();
                        }
                        if (eVar.f52602a != 101) {
                            this.f56648a.this$0.a((ErrorModel) eVar.f52603b, eVar.f52604c, this.f56648a.this$0.d(), eVar.f52605d);
                            return;
                        }
                        this.f56648a.this$0.a((IJRPaytmDataModel) eVar.f52603b);
                    }
                }
            });
            return x.f47997a;
        }
    }

    @kotlin.d.b.a.f(b = "BaseLoginFragment.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.BaseLoginFragment$generatePublicPrivateKey$isSuccess$1")
    static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super Boolean>, Object> {
        final /* synthetic */ String $mobile;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.$mobile = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            f fVar = new f(this.$mobile, dVar);
            fVar.p$ = (CoroutineScope) obj;
            return fVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
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

    public static final /* synthetic */ void a(w wVar, String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1311435322) {
                if (hashCode != 747466636) {
                    if (hashCode == 1895325780 && str.equals("oauthdevicebindingconfigSv1")) {
                        wVar.g();
                    }
                } else if (str.equals("oauthLoginInitSv1")) {
                    wVar.e();
                }
            } else if (str.equals("oauthdevicebindinginitSv1")) {
                wVar.d();
                wVar.a(wVar.f56641i, wVar.k, wVar.l);
            }
        }
    }
}
