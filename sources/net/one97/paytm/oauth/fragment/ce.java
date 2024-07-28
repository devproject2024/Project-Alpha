package net.one97.paytm.oauth.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.telephony.SubscriptionInfo;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.d.f;
import kotlin.g.b.x;
import kotlin.m.p;
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
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.fragment.y;
import net.one97.paytm.oauth.models.DataModel;
import net.one97.paytm.oauth.models.DeviceBindingInitResModel;
import net.one97.paytm.oauth.models.DeviceBindingStausResModel;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.CircleProgressBar;
import org.json.JSONException;
import org.json.JSONObject;

public final class ce extends v implements View.OnClickListener, net.one97.paytm.oauth.e.f, y.b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f56565a = new b((byte) 0);
    private final ArrayList<String> A;
    private final ArrayList<String> B;
    private ArrayList<String> C;
    /* access modifiers changed from: private */
    public final long D;
    private int E;
    private final Handler F;
    /* access modifiers changed from: private */
    public int G;
    private int H;
    /* access modifiers changed from: private */
    public final z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> I;
    /* access modifiers changed from: private */
    public final CoroutineExceptionHandler J;
    private HashMap K;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f56566b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f56567c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<String> f56568d;

    /* renamed from: e  reason: collision with root package name */
    private int f56569e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public net.one97.paytm.oauth.e.b f56570f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public List<SubscriptionInfo> f56571g;

    /* renamed from: h  reason: collision with root package name */
    private CountDownTimer f56572h;

    /* renamed from: i  reason: collision with root package name */
    private net.one97.paytm.oauth.g.e f56573i;
    /* access modifiers changed from: private */
    public Handler j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public boolean n;
    private int o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public boolean q;
    private int r;
    private String s;
    /* access modifiers changed from: private */
    public final CoroutineScope t;
    /* access modifiers changed from: private */
    public int u;
    /* access modifiers changed from: private */
    public boolean v;
    private List<String> w;
    private int x;
    /* access modifiers changed from: private */
    public boolean y;
    private String z;

    static final class c<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f56574a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    public final View a(int i2) {
        if (this.K == null) {
            this.K = new HashMap();
        }
        View view = (View) this.K.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.K.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.K;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            th.getLocalizedMessage();
        }
    }

    static final class e<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ce f56577a;

        e(ce ceVar) {
            this.f56577a = ceVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                ce.a(this.f56577a, (ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
                return;
            }
            this.f56577a.a((IJRPaytmDataModel) eVar.f52603b, false);
        }
    }

    static final class j<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ce f56582a;

        j(ce ceVar) {
            this.f56582a = ceVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                ce.a(this.f56582a, (ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
                return;
            }
            this.f56582a.a((IJRPaytmDataModel) eVar.f52603b, false);
        }
    }

    static final class k<T> implements z<net.one97.paytm.oauth.e<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ce f56583a;

        k(ce ceVar) {
            this.f56583a = ceVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.oauth.e eVar = (net.one97.paytm.oauth.e) obj;
            if (eVar == null) {
                return;
            }
            if (eVar.f52602a != 101) {
                ce.a(this.f56583a, (ErrorModel) eVar.f52603b, eVar.f52604c, eVar.f52605d);
                return;
            }
            this.f56583a.a((IJRPaytmDataModel) eVar.f52603b, true);
        }
    }

    public ce() {
        this.f56566b = Payload.RESPONSE_TIMEOUT;
        this.f56567c = "";
        this.f56568d = new ArrayList();
        this.f56571g = new ArrayList();
        this.j = new Handler();
        this.k = 30;
        this.l = 1;
        this.m = 15;
        this.q = true;
        this.r = 2;
        this.s = "login";
        this.t = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.w = kotlin.a.k.c("5", "3", "3");
        this.z = "";
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.C = new ArrayList<>();
        this.D = 10000;
        this.E = 5;
        this.F = new Handler();
        this.H = 2;
        this.I = new k(this);
        this.J = new a(CoroutineExceptionHandler.Key);
    }

    public static final /* synthetic */ net.one97.paytm.oauth.g.e w(ce ceVar) {
        net.one97.paytm.oauth.g.e eVar = ceVar.f56573i;
        if (eVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return eVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ce(net.one97.paytm.oauth.e.b bVar) {
        this();
        kotlin.g.b.k.c(bVar, "listener");
        this.f56570f = bVar;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static ce a(Bundle bundle, net.one97.paytm.oauth.e.b bVar) {
            kotlin.g.b.k.c(bVar, "listener");
            ce ceVar = new ce(bVar);
            ceVar.setArguments(bundle);
            return ceVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_verifying_mobile_number, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        String str2;
        String str3;
        List<SubscriptionInfo> list;
        List<String> list2;
        List b2;
        ArrayList parcelableArrayList;
        String string;
        super.onActivityCreated(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.oauth.g.e.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(th…nitViewModel::class.java)");
        this.f56573i = (net.one97.paytm.oauth.g.e) a2;
        Bundle arguments = getArguments();
        String str4 = "";
        if (arguments == null || (str = arguments.getString("iccid")) == null) {
            str = str4;
        }
        this.z = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("login_signup_flow")) == null) {
            str2 = "login";
        }
        this.s = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("login_mobile")) == null) {
            str3 = str4;
        }
        this.f56567c = str3;
        List<String> list3 = this.f56568d;
        Bundle arguments4 = getArguments();
        if (!(arguments4 == null || (string = arguments4.getString(H5Param.SESSION_ID)) == null)) {
            str4 = string;
        }
        list3.add(str4);
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (parcelableArrayList = arguments5.getParcelableArrayList("simInfoList")) == null) {
            list = new ArrayList<>();
        } else {
            list = parcelableArrayList;
        }
        this.f56571g = list;
        Bundle arguments6 = getArguments();
        this.l = (arguments6 != null ? arguments6.getInt("sms_retry_count", 1) : 1) - 1;
        Bundle arguments7 = getArguments();
        int i2 = 15;
        if (arguments7 != null) {
            i2 = arguments7.getInt("sms_retry_interval", 15);
        }
        this.m = i2;
        Bundle arguments8 = getArguments();
        int i3 = 30;
        if (arguments8 != null) {
            i3 = arguments8.getInt("binding_timeout", 30);
        }
        this.k = i3;
        this.k += this.l * this.m;
        Bundle arguments9 = getArguments();
        this.y = arguments9 != null ? arguments9.getBoolean("is_new_signup") : false;
        Bundle arguments10 = getArguments();
        String string2 = arguments10 != null ? arguments10.getString("sms_polling_frequency") : null;
        CharSequence charSequence = string2;
        if (!TextUtils.isEmpty(charSequence)) {
            if (string2 == null || (b2 = p.a(charSequence, new String[]{AppConstants.COMMA})) == null) {
                list2 = kotlin.a.k.c("5", "3", "3");
            } else {
                list2 = kotlin.a.k.c(b2);
            }
            this.w = list2;
        }
        Bundle arguments11 = getArguments();
        int i4 = 5;
        if (arguments11 != null) {
            i4 = arguments11.getInt("sms_time_out", 5);
        }
        this.E = i4;
        Bundle arguments12 = getArguments();
        this.H = arguments12 != null ? arguments12.getInt("send_sms_delay") : 2;
        RoboTextView roboTextView = (RoboTextView) a(R.id.tvTimer);
        if (roboTextView != null) {
            roboTextView.setText(String.valueOf(this.D / 1000));
        }
        String string3 = getString(R.string.lbl_important_colon);
        kotlin.g.b.k.a((Object) string3, "getString(R.string.lbl_important_colon)");
        Spannable spannableString = new SpannableString(string3 + ' ' + getString(R.string.donot_switch_to_another_app));
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(requireContext(), R.color.color_ffad00)), 0, string3.length(), 33);
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_description);
        if (roboTextView2 != null) {
            roboTextView2.setText(spannableString);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        this.f56569e = OAuthUtils.a(this.z, this.f56571g);
        i();
        if (this.A.size() + this.B.size() == 1) {
            this.r = 1;
        }
        this.o = 0;
        b(this.f56568d.get(0));
        net.one97.paytm.oauth.a.a();
        if (!net.one97.paytm.oauth.a.q()) {
            h();
        } else {
            this.F.postDelayed(new m(this), ((long) this.E) * 1000);
        }
        OauthModule.b().logHawEyeEvent(new net.one97.paytm.oauth.models.a(l(), "", this.f56567c, "", "verification_started", 0, 32));
    }

    static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ce f56587a;

        m(ce ceVar) {
            this.f56587a = ceVar;
        }

        public final void run() {
            if (!this.f56587a.n) {
                this.f56587a.q = false;
                Bundle bundle = new Bundle(this.f56587a.getArguments());
                bundle.putString(Item.KEY_REASON, this.f56587a.f56566b);
                net.one97.paytm.oauth.e.b d2 = this.f56587a.f56570f;
                if (d2 != null) {
                    d2.b(bundle);
                }
            }
        }
    }

    private final void f() {
        long j2 = ((long) this.k) * 1000;
        kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        CountDownTimer start = new l(this, j2, net.one97.paytm.oauth.a.k(), j2).start();
        kotlin.g.b.k.a((Object) start, "object : CountDownTimer(…      }\n        }.start()");
        this.f56572h = start;
    }

    public static final class l extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ce f56584a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f56585b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f56586c;

        /*  JADX ERROR: ArrayIndexOutOfBoundsException in pass: SSATransform
            java.lang.ArrayIndexOutOfBoundsException
            */
        l(long r0, int r2, long r3, long r5) {
            /*
                r-1 = this;
                r0.f56584a = r1
                r0.f56585b = r2
                r0.f56586c = r4
                r1 = 5
                r0.<init>(r5, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.fragment.ce.l.<init>(net.one97.paytm.oauth.fragment.ce, long, int, long):void");
        }

        public final void onTick(long j) {
            AppCompatImageView appCompatImageView;
            this.f56584a.G = (int) ((this.f56585b - j) / 1000);
            if (this.f56584a.k - ((int) (j / 1000)) == this.f56586c && (appCompatImageView = (AppCompatImageView) this.f56584a.a(R.id.imgCross)) != null) {
                net.one97.paytm.oauth.utils.h.a(appCompatImageView);
            }
            if (j > this.f56585b - this.f56584a.D) {
                ce ceVar = this.f56584a;
                ce.a(ceVar, j - (this.f56585b - ceVar.D), this.f56584a.D);
            } else {
                ce ceVar2 = this.f56584a;
                ce.a(ceVar2, j, this.f56585b - ceVar2.D);
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.f56584a.t, this.f56584a.J, (CoroutineStart) null, new a(this, j, (kotlin.d.d) null), 2, (Object) null);
        }

        public final void onFinish() {
            if (this.f56584a.isAdded()) {
                CircleProgressBar circleProgressBar = (CircleProgressBar) this.f56584a.a(R.id.circleProgressBar);
                if (circleProgressBar != null) {
                    circleProgressBar.setProgress(1.0f);
                }
                this.f56584a.j.removeCallbacksAndMessages((Object) null);
                this.f56584a.q = false;
                if (!this.f56584a.p) {
                    if (!this.f56584a.n) {
                        OauthModule.b().logHawEyeEvent(new net.one97.paytm.oauth.models.a("sms_send_failed_popup_loaded", "/login-signup", this.f56584a.f56567c, this.f56584a.f56566b, this.f56584a.k(), 0, 32));
                    }
                    String[] strArr = new String[4];
                    strArr[0] = this.f56584a.k();
                    strArr[1] = String.valueOf(this.f56584a.G);
                    strArr[2] = H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT;
                    strArr[3] = !this.f56584a.n ? "sms_timeout" : "";
                    ce.a("/login-signup", "login_signup", "verification_successful", (ArrayList<String>) kotlin.a.k.d(strArr), this.f56584a.y ? "signup" : "login");
                    Bundle arguments = this.f56584a.getArguments();
                    if (arguments != null) {
                        arguments.putString("gaLabel", H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT);
                    }
                    Bundle arguments2 = this.f56584a.getArguments();
                    if (arguments2 != null) {
                        arguments2.putString("timer", String.valueOf(this.f56584a.G));
                    }
                    net.one97.paytm.oauth.e.b d2 = this.f56584a.f56570f;
                    if (d2 != null) {
                        d2.d(new Bundle(this.f56584a.getArguments()));
                    }
                }
            }
        }

        @kotlin.d.b.a.f(b = "VerifyingMobileNumberFragment.kt", c = {197}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.VerifyingMobileNumberFragment$startCountDownTimer$1$onTick$1")
        static final class a extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ long $millisUntilFinished;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ l this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(l lVar, long j, kotlin.d.d dVar) {
                super(2, dVar);
                this.this$0 = lVar;
                this.$millisUntilFinished = j;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                kotlin.g.b.k.c(dVar, "completion");
                a aVar = new a(this.this$0, this.$millisUntilFinished, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
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
                    if (BuildersKt.withContext(Dispatchers.getIO(), new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object>(this, (kotlin.d.d) null) {
                        int label;
                        private CoroutineScope p$;
                        final /* synthetic */ a this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                            kotlin.g.b.k.c(dVar, "completion");
                            AnonymousClass1 r0 = 
                        }

                        /* access modifiers changed from: private */
                        public final void g() {
                            int i2;
                            if (this.x < this.w.size()) {
                                i2 = Integer.parseInt(this.w.get(this.x));
                                this.x++;
                            } else {
                                List<String> list = this.w;
                                i2 = Integer.parseInt(list.get(list.size() - 1));
                            }
                            x.e eVar = new x.e();
                            eVar.element = (z) new e(this);
                            this.j.postDelayed(new d(this, eVar), ((long) i2) * 1000);
                        }

                        static final class d implements Runnable {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ ce f56575a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ x.e f56576b;

                            d(ce ceVar, x.e eVar) {
                                this.f56575a = ceVar;
                                this.f56576b = eVar;
                            }

                            public final void run() {
                                int i2 = 0;
                                try {
                                    for (String str : this.f56575a.f56568d) {
                                        if (i2 == 1) {
                                            this.f56576b.element = this.f56575a.I;
                                        }
                                        ce.w(this.f56575a).a(str).observe(this.f56575a, (z) this.f56576b.element);
                                        i2++;
                                    }
                                } catch (ConcurrentModificationException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }

                        /* access modifiers changed from: private */
                        public final void a(IJRPaytmDataModel iJRPaytmDataModel, boolean z2) {
                            String string;
                            String sessionId;
                            String string2;
                            String string3;
                            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
                            if (isAdded()) {
                                if (iJRPaytmDataModel2 instanceof DeviceBindingStausResModel) {
                                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.t, this.J, (CoroutineStart) null, new g(this, iJRPaytmDataModel2, z2, (kotlin.d.d) null), 2, (Object) null);
                                } else if (iJRPaytmDataModel2 instanceof DeviceBindingInitResModel) {
                                    DeviceBindingInitResModel deviceBindingInitResModel = (DeviceBindingInitResModel) iJRPaytmDataModel2;
                                    String responseCode = deviceBindingInitResModel.getResponseCode();
                                    String str = "signup";
                                    String str2 = "";
                                    if (responseCode != null) {
                                        int hashCode = responseCode.hashCode();
                                        if (hashCode != -1260518837) {
                                            if (hashCode != -1258552631) {
                                                if (hashCode == -1258493018 && responseCode.equals("BE1426011")) {
                                                    String[] strArr = new String[4];
                                                    Bundle arguments = getArguments();
                                                    if (!(arguments == null || (string3 = arguments.getString(net.one97.paytm.oauth.utils.p.f56797b)) == null)) {
                                                        str2 = string3;
                                                    }
                                                    strArr[0] = str2;
                                                    strArr[1] = String.valueOf(deviceBindingInitResModel.getMessage());
                                                    strArr[2] = SDKConstants.KEY_API;
                                                    strArr[3] = deviceBindingInitResModel.getResponseCode();
                                                    ArrayList d2 = kotlin.a.k.d(strArr);
                                                    if (!this.y) {
                                                        str = "login";
                                                    }
                                                    a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d2, str);
                                                    Bundle bundle = new Bundle();
                                                    bundle.putString("message", String.valueOf(deviceBindingInitResModel.getMessage()));
                                                    bundle.putBoolean("IS_SHOW_RAISE_REQUEST", false);
                                                    OAuthUtils.a(getChildFragmentManager(), bundle);
                                                    return;
                                                }
                                            } else if (responseCode.equals("BE1424001")) {
                                                String[] strArr2 = new String[4];
                                                Bundle arguments2 = getArguments();
                                                if (!(arguments2 == null || (string2 = arguments2.getString(net.one97.paytm.oauth.utils.p.f56797b)) == null)) {
                                                    str2 = string2;
                                                }
                                                strArr2[0] = str2;
                                                strArr2[1] = String.valueOf(deviceBindingInitResModel.getMessage());
                                                strArr2[2] = SDKConstants.KEY_API;
                                                strArr2[3] = deviceBindingInitResModel.getResponseCode();
                                                ArrayList d3 = kotlin.a.k.d(strArr2);
                                                if (!this.y) {
                                                    str = "login";
                                                }
                                                a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d3, str);
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putString("message", String.valueOf(deviceBindingInitResModel.getMessage()));
                                                bundle2.putBoolean("IS_SHOW_RAISE_REQUEST", true);
                                                OAuthUtils.a(getChildFragmentManager(), bundle2);
                                                return;
                                            }
                                        } else if (responseCode.equals("BE1400001")) {
                                            OauthModule.b().logHawEyeEvent(new net.one97.paytm.oauth.models.a("device_binding_retry", "/login-signup", "device_binding_retry", (String) null, (String) null, 0, 56));
                                            ArrayList d4 = kotlin.a.k.d(str2);
                                            if (!this.y) {
                                                str = "login";
                                            }
                                            a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d4, str);
                                            DataModel data = deviceBindingInitResModel.getData();
                                            if (!(data == null || (sessionId = data.getSessionId()) == null)) {
                                                str2 = sessionId;
                                            }
                                            this.f56568d.add(str2);
                                            Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.t, this.J, (CoroutineStart) null, new h(this, str2, (kotlin.d.d) null), 2, (Object) null);
                                            return;
                                        }
                                    }
                                    String[] strArr3 = new String[4];
                                    Bundle arguments3 = getArguments();
                                    if (!(arguments3 == null || (string = arguments3.getString(net.one97.paytm.oauth.utils.p.f56797b)) == null)) {
                                        str2 = string;
                                    }
                                    strArr3[0] = str2;
                                    strArr3[1] = String.valueOf(deviceBindingInitResModel.getMessage());
                                    strArr3[2] = SDKConstants.KEY_API;
                                    strArr3[3] = String.valueOf(deviceBindingInitResModel.getResponseCode());
                                    ArrayList d5 = kotlin.a.k.d(strArr3);
                                    if (!this.y) {
                                        str = "login";
                                    }
                                    a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d5, str);
                                }
                            }
                        }

                        static final class f implements DialogInterface.OnClickListener {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ ce f56578a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f56579b;

                            f(ce ceVar, String str) {
                                this.f56578a = ceVar;
                                this.f56579b = str;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                ce.b(this.f56578a, this.f56579b);
                            }
                        }

                        public final void onStop() {
                            super.onStop();
                            CoroutineScopeKt.cancel$default(this.t, (CancellationException) null, 1, (Object) null);
                            try {
                                if (this.f56572h != null) {
                                    CountDownTimer countDownTimer = this.f56572h;
                                    if (countDownTimer == null) {
                                        kotlin.g.b.k.a("timer");
                                    }
                                    countDownTimer.cancel();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            this.j.removeCallbacksAndMessages((Object) null);
                            this.F.removeCallbacksAndMessages((Object) null);
                            net.one97.paytm.oauth.utils.x xVar = net.one97.paytm.oauth.utils.x.f56805a;
                            net.one97.paytm.oauth.utils.x.a(getContext());
                            net.one97.paytm.oauth.utils.x xVar2 = net.one97.paytm.oauth.utils.x.f56805a;
                            net.one97.paytm.oauth.utils.x.b();
                            if (this.q) {
                                net.one97.paytm.oauth.g.e eVar = this.f56573i;
                                if (eVar == null) {
                                    kotlin.g.b.k.a("viewModel");
                                }
                                List<String> list = this.f56568d;
                                eVar.b(list.get(list.size() - 1)).observe(this, c.f56574a);
                                Bundle bundle = new Bundle(getArguments());
                                bundle.putBoolean("intervene", true);
                                a("/login-signup", "login_signup", "verification_successful", (ArrayList<String>) kotlin.a.k.d(k(), String.valueOf(this.G), "switch_app"), this.y ? "signup" : "login");
                                bundle.putString("gaLabel", "backend_error");
                                bundle.putString("timer", String.valueOf(this.G));
                                net.one97.paytm.oauth.e.b bVar = this.f56570f;
                                if (bVar != null) {
                                    bVar.d(bundle);
                                }
                            }
                        }

                        public final void onClick(View view) {
                            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
                            int i2 = R.id.imgCross;
                            if (valueOf != null && valueOf.intValue() == i2) {
                                String str = "signup";
                                a("/login-signup", "login_signup", "verifying_popup_close_clicked", (ArrayList<String>) kotlin.a.k.d(String.valueOf(this.G)), this.y ? str : "login");
                                ArrayList d2 = kotlin.a.k.d(k(), String.valueOf(this.G), "close_verification_popup");
                                if (!this.y) {
                                    str = "login";
                                }
                                a("/login-signup", "login_signup", "verification_successful", (ArrayList<String>) d2, str);
                                q a2 = getChildFragmentManager().a();
                                kotlin.g.b.k.a((Object) a2, "childFragmentManager.beginTransaction()");
                                Bundle arguments = getArguments();
                                if (arguments != null) {
                                    arguments.putString("timer", String.valueOf(this.G));
                                }
                                Bundle bundle = new Bundle(getArguments());
                                y.a aVar = y.f56672a;
                                y.b bVar = this;
                                kotlin.g.b.k.c(bundle, "bundle");
                                kotlin.g.b.k.c(bVar, "cancelListener");
                                y yVar = new y(bVar);
                                yVar.setArguments(bundle);
                                a2.a((Fragment) yVar, y.class.getName());
                                a2.c();
                            }
                        }

                        public final void d() {
                            if (!this.n) {
                                this.n = true;
                                net.one97.paytm.oauth.a.a();
                                if (net.one97.paytm.oauth.a.q()) {
                                    h();
                                }
                            }
                        }

                        private final void h() {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgPhone);
                            if (appCompatImageView != null) {
                                appCompatImageView.setImageResource(R.drawable.ic_oauth_verifying);
                            }
                            RoboTextView roboTextView = (RoboTextView) a(R.id.tvHeader);
                            if (roboTextView != null) {
                                roboTextView.setText(getString(R.string.verifying_mobile_number));
                            }
                            f();
                            g();
                        }

                        public final void a(String str) {
                            kotlin.g.b.k.c(str, Item.KEY_REASON);
                            this.o++;
                            if (this.o == this.r && !this.n) {
                                this.q = false;
                                Iterator<String> it2 = this.C.iterator();
                                while (it2.hasNext()) {
                                    String next = it2.next();
                                    net.one97.paytm.oauth.b b2 = OauthModule.b();
                                    kotlin.g.b.k.a((Object) next, "number");
                                    b2.logHawEyeEvent(new net.one97.paytm.oauth.models.a("send_sms_failed", "/login-signup", next, (String) null, (String) null, 0, 56));
                                }
                                if (isVisible()) {
                                    new Handler().postDelayed(new i(this, str), 1000);
                                }
                            }
                        }

                        static final class i implements Runnable {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ ce f56580a;

                            /* renamed from: b  reason: collision with root package name */
                            final /* synthetic */ String f56581b;

                            i(ce ceVar, String str) {
                                this.f56580a = ceVar;
                                this.f56581b = str;
                            }

                            public final void run() {
                                Bundle bundle = new Bundle(this.f56580a.getArguments());
                                bundle.putString(Item.KEY_REASON, this.f56581b);
                                net.one97.paytm.oauth.e.b d2 = this.f56580a.f56570f;
                                if (d2 != null) {
                                    d2.b(bundle);
                                }
                            }
                        }

                        public final void b() {
                            this.q = false;
                            net.one97.paytm.oauth.e.b bVar = this.f56570f;
                            if (bVar != null) {
                                bVar.b();
                            }
                        }

                        private final void i() {
                            String carrierName = this.f56571g.size() > 0 ? this.f56571g.get(this.f56569e).getCarrierName() : "";
                            Map linkedHashMap = new LinkedHashMap();
                            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                            String j2 = net.one97.paytm.oauth.a.j();
                            if (j2 != null) {
                                Iterator it2 = kotlin.m.p.a((CharSequence) j2, new String[]{"#"}).iterator();
                                while (true) {
                                    int i2 = 0;
                                    if (it2.hasNext()) {
                                        List b2 = kotlin.m.p.a((CharSequence) (String) it2.next(), new String[]{"="});
                                        Object obj = b2.get(0);
                                        String str = (String) b2.get(1);
                                        if (str != null) {
                                            linkedHashMap.put(obj, kotlin.a.k.e(kotlin.m.p.a((CharSequence) kotlin.m.p.b(str).toString(), new String[]{AppConstants.COMMA})));
                                        } else {
                                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                                        }
                                    } else {
                                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                                            String obj2 = carrierName.toString();
                                            Locale locale = Locale.getDefault();
                                            kotlin.g.b.k.a((Object) locale, "Locale.getDefault()");
                                            if (obj2 != null) {
                                                String lowerCase = obj2.toLowerCase(locale);
                                                kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                                                CharSequence charSequence = lowerCase;
                                                String str2 = (String) entry.getKey();
                                                Locale locale2 = Locale.ROOT;
                                                kotlin.g.b.k.a((Object) locale2, "Locale.ROOT");
                                                if (str2 != null) {
                                                    String lowerCase2 = str2.toLowerCase(locale2);
                                                    kotlin.g.b.k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                                                    if (kotlin.m.p.a(charSequence, (CharSequence) lowerCase2, false)) {
                                                        this.A.addAll((Collection) entry.getValue());
                                                    } else if (i2 != linkedHashMap.size() - 1 || !this.A.isEmpty()) {
                                                        this.B.addAll((Collection) entry.getValue());
                                                    } else {
                                                        this.A.addAll((Collection) entry.getValue());
                                                    }
                                                    i2++;
                                                } else {
                                                    throw new u("null cannot be cast to non-null type java.lang.String");
                                                }
                                            } else {
                                                throw new u("null cannot be cast to non-null type java.lang.String");
                                            }
                                        }
                                        Random random = new Random();
                                        Collections.shuffle(this.A, random);
                                        Collections.shuffle(this.B, random);
                                        return;
                                    }
                                }
                            }
                        }

                        private final List<String> j() {
                            long j2;
                            int size = this.A.size() + this.B.size();
                            try {
                                String str = this.f56567c;
                                if (str != null) {
                                    j2 = Long.parseLong(kotlin.m.p.b(str).toString());
                                    Set linkedHashSet = new LinkedHashSet();
                                    int i2 = 0;
                                    kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                                    int t2 = net.one97.paytm.oauth.a.t();
                                    while (i2 < t2) {
                                        if (this.A.size() > 0) {
                                            int size2 = (int) (j2 % ((long) this.A.size()));
                                            String str2 = this.A.get(size2);
                                            kotlin.g.b.k.a((Object) str2, "operatorVmnList[operatorIndex]");
                                            boolean add = linkedHashSet.add(str2);
                                            i2++;
                                            if (size > 2) {
                                                this.A.remove(size2);
                                                size--;
                                            } else if (size == 2 && !add) {
                                                if (size2 == size - 1) {
                                                    String str3 = this.A.get(size2 - 1);
                                                    kotlin.g.b.k.a((Object) str3, "operatorVmnList[operatorIndex - 1]");
                                                    linkedHashSet.add(str3);
                                                } else {
                                                    String str4 = this.A.get(size2 + 1);
                                                    kotlin.g.b.k.a((Object) str4, "operatorVmnList[operatorIndex + 1]");
                                                    linkedHashSet.add(str4);
                                                }
                                            }
                                        }
                                        if (this.B.size() > 0 && i2 < t2) {
                                            int size3 = (int) (j2 % ((long) this.B.size()));
                                            String str5 = this.B.get(size3);
                                            kotlin.g.b.k.a((Object) str5, "otherVmnList[otherIndex]");
                                            boolean add2 = linkedHashSet.add(str5);
                                            i2++;
                                            if (size > 2) {
                                                this.B.remove(size3);
                                                size--;
                                            } else if (size == 2 && !add2) {
                                                if (size3 == size - 1) {
                                                    String str6 = this.B.get(size3 - 1);
                                                    kotlin.g.b.k.a((Object) str6, "otherVmnList[otherIndex - 1]");
                                                    linkedHashSet.add(str6);
                                                } else {
                                                    String str7 = this.B.get(size3 + 1);
                                                    kotlin.g.b.k.a((Object) str7, "otherVmnList[otherIndex + 1]");
                                                    linkedHashSet.add(str7);
                                                }
                                            }
                                        }
                                    }
                                    this.C.clear();
                                    this.C.addAll(linkedHashSet);
                                    return kotlin.a.k.e(linkedHashSet);
                                }
                                throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                            } catch (NumberFormatException unused) {
                                j2 = 0;
                            }
                        }

                        /* access modifiers changed from: private */
                        public final void b(String str) {
                            int subscriptionId = this.f56571g.size() > 0 ? this.f56571g.get(this.f56569e).getSubscriptionId() : 0;
                            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                            if (net.one97.paytm.oauth.a.r()) {
                                net.one97.paytm.oauth.utils.x xVar = net.one97.paytm.oauth.utils.x.f56805a;
                                Context requireContext = requireContext();
                                kotlin.g.b.k.a((Object) requireContext, "requireContext()");
                                List<String> j2 = j();
                                net.one97.paytm.oauth.a.a();
                                net.one97.paytm.oauth.utils.x.b(requireContext, subscriptionId, str, (net.one97.paytm.oauth.e.f) this, j2, net.one97.paytm.oauth.a.s());
                                return;
                            }
                            net.one97.paytm.oauth.utils.x xVar2 = net.one97.paytm.oauth.utils.x.f56805a;
                            Context requireContext2 = requireContext();
                            kotlin.g.b.k.a((Object) requireContext2, "requireContext()");
                            net.one97.paytm.oauth.utils.x.a(requireContext2, subscriptionId, str, (net.one97.paytm.oauth.e.f) this, j(), this.H);
                        }

                        /* access modifiers changed from: private */
                        public final String k() {
                            return (Build.VERSION.SDK_INT >= 22 ? this.f56571g.get(this.f56569e).getSimSlotIndex() : 0) == 0 ? "sim 1" : "sim 2";
                        }

                        /* access modifiers changed from: private */
                        public static String l() {
                            kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
                            boolean r2 = net.one97.paytm.oauth.a.r();
                            net.one97.paytm.oauth.a.a();
                            boolean q2 = net.one97.paytm.oauth.a.q();
                            if (r2 && q2) {
                                return "sequential_and_check_receipt";
                            }
                            if (!r2 && q2) {
                                return "parallel_and_check_receipt";
                            }
                            if (!r2 || q2) {
                                return (r2 || q2) ? "default" : "parallel_and_without_receipt";
                            }
                            return "sequential_and_without_receipt";
                        }

                        @kotlin.d.b.a.f(b = "VerifyingMobileNumberFragment.kt", c = {306}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.VerifyingMobileNumberFragment$onApiSuccess$1")
                        static final class g extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                            final /* synthetic */ IJRPaytmDataModel $dataModel;
                            final /* synthetic */ boolean $isRetryStatusCall;
                            int label;
                            private CoroutineScope p$;
                            final /* synthetic */ ce this$0;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            g(ce ceVar, IJRPaytmDataModel iJRPaytmDataModel, boolean z, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.this$0 = ceVar;
                                this.$dataModel = iJRPaytmDataModel;
                                this.$isRetryStatusCall = z;
                            }

                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                kotlin.g.b.k.c(dVar, "completion");
                                g gVar = new g(this.this$0, this.$dataModel, this.$isRetryStatusCall, dVar);
                                gVar.p$ = (CoroutineScope) obj;
                                return gVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((g) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
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
                                    if (BuildersKt.withContext(Dispatchers.getIO(), new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                        int label;
                                        private CoroutineScope p$;
                                        final /* synthetic */ g this$0;

                                        {
                                            this.this$0 = r1;
                                        }

                                        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                            kotlin.g.b.k.c(dVar, "completion");
                                            AnonymousClass1 r0 = 

                                            @kotlin.d.b.a.f(b = "VerifyingMobileNumberFragment.kt", c = {364}, d = "invokeSuspend", e = "net.one97.paytm.oauth.fragment.VerifyingMobileNumberFragment$onApiSuccess$2")
                                            static final class h extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                                                final /* synthetic */ String $sessionId;
                                                int label;
                                                private CoroutineScope p$;
                                                final /* synthetic */ ce this$0;

                                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                                h(ce ceVar, String str, kotlin.d.d dVar) {
                                                    super(2, dVar);
                                                    this.this$0 = ceVar;
                                                    this.$sessionId = str;
                                                }

                                                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                    kotlin.g.b.k.c(dVar, "completion");
                                                    h hVar = new h(this.this$0, this.$sessionId, dVar);
                                                    hVar.p$ = (CoroutineScope) obj;
                                                    return hVar;
                                                }

                                                public final Object invoke(Object obj, Object obj2) {
                                                    return ((h) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
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
                                                        if (BuildersKt.withContext(Dispatchers.getIO(), new kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                                                            int label;
                                                            private CoroutineScope p$;
                                                            final /* synthetic */ h this$0;

                                                            {
                                                                this.this$0 = r1;
                                                            }

                                                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                                                kotlin.g.b.k.c(dVar, "completion");
                                                                AnonymousClass1 r0 = 

                                                                public static final /* synthetic */ void a(ce ceVar, long j2, long j3) {
                                                                    if (ceVar.isAdded()) {
                                                                        RoboTextView roboTextView = (RoboTextView) ceVar.a(R.id.tvTimer);
                                                                        if (roboTextView != null) {
                                                                            roboTextView.setText(String.valueOf(((int) (j2 / 1000)) + 1));
                                                                        }
                                                                        CircleProgressBar circleProgressBar = (CircleProgressBar) ceVar.a(R.id.circleProgressBar);
                                                                        if (circleProgressBar != null) {
                                                                            circleProgressBar.setProgress(((float) (j3 - j2)) / ((float) j3));
                                                                        }
                                                                    }
                                                                }

                                                                public static final /* synthetic */ void n(ce ceVar) {
                                                                    net.one97.paytm.oauth.g.e eVar = ceVar.f56573i;
                                                                    if (eVar == null) {
                                                                        kotlin.g.b.k.a("viewModel");
                                                                    }
                                                                    eVar.a(ceVar.f56567c, ceVar.s, "sms", ceVar.z).observe(ceVar, new j(ceVar));
                                                                }

                                                                public static final /* synthetic */ void a(ce ceVar, ErrorModel errorModel, Throwable th, String str) {
                                                                    String str2;
                                                                    String str3;
                                                                    ce ceVar2 = ceVar;
                                                                    String str4 = str;
                                                                    Activity activity = ceVar.getActivity();
                                                                    Fragment fragment = ceVar2;
                                                                    if (th == null) {
                                                                        throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                                                                    } else if (OAuthUtils.a(activity, fragment, (NetworkCustomError) th)) {
                                                                        net.one97.paytm.oauth.e.b bVar = ceVar2.f56570f;
                                                                        if (bVar != null) {
                                                                            bVar.b();
                                                                        }
                                                                    } else if (net.one97.paytm.oauth.utils.l.a(errorModel)) {
                                                                        ceVar2.q = false;
                                                                        Bundle arguments = ceVar.getArguments();
                                                                        if (arguments != null) {
                                                                            arguments.putString("gaLabel", "backend_error");
                                                                        }
                                                                        net.one97.paytm.oauth.e.b bVar2 = ceVar2.f56570f;
                                                                        if (bVar2 != null) {
                                                                            bVar2.d(new Bundle(ceVar.getArguments()));
                                                                        }
                                                                    } else if (errorModel == null || errorModel.getStatus() != -1) {
                                                                        String str5 = "signup";
                                                                        if ((errorModel != null ? errorModel.getCustomError() : null) instanceof NetworkCustomError) {
                                                                            byte[] bArr = errorModel.getCustomError().networkResponse.data;
                                                                            if (bArr != null && !TextUtils.isEmpty(new String(bArr, kotlin.m.d.f47971a))) {
                                                                                try {
                                                                                    JSONObject jSONObject = new JSONObject(new String(bArr, kotlin.m.d.f47971a));
                                                                                    String string = jSONObject.getString("responseCode");
                                                                                    if (kotlin.g.b.k.a((Object) str4, (Object) "oauthdevicebindingstatusSv1")) {
                                                                                        kotlin.g.b.k.a((Object) string, "responseCode");
                                                                                        ArrayList d2 = kotlin.a.k.d(ceVar.k(), String.valueOf(ceVar2.G), "backend_error", string);
                                                                                        if (!ceVar2.y) {
                                                                                            str5 = "login";
                                                                                        }
                                                                                        a("/login-signup", "login_signup", "verification_successful", (ArrayList<String>) d2, str5);
                                                                                    } else if (kotlin.g.b.k.a((Object) str4, (Object) "oauthdevicebindinginitSv1")) {
                                                                                        String[] strArr = new String[4];
                                                                                        Bundle arguments2 = ceVar.getArguments();
                                                                                        if (arguments2 == null || (str3 = arguments2.getString(net.one97.paytm.oauth.utils.p.f56797b)) == null) {
                                                                                            str3 = "";
                                                                                        }
                                                                                        strArr[0] = str3;
                                                                                        String string2 = jSONObject.getString("message");
                                                                                        kotlin.g.b.k.a((Object) string2, "jsonObj.getString(KEY_MESSAGE)");
                                                                                        strArr[1] = string2;
                                                                                        strArr[2] = SDKConstants.KEY_API;
                                                                                        kotlin.g.b.k.a((Object) string, "responseCode");
                                                                                        strArr[3] = string;
                                                                                        ArrayList d3 = kotlin.a.k.d(strArr);
                                                                                        if (!ceVar2.y) {
                                                                                            str5 = "login";
                                                                                        }
                                                                                        a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d3, str5);
                                                                                    }
                                                                                } catch (JSONException unused) {
                                                                                }
                                                                            }
                                                                        } else if (kotlin.g.b.k.a((Object) str4, (Object) "oauthdevicebindingstatusSv1")) {
                                                                            ArrayList d4 = kotlin.a.k.d(ceVar.k(), String.valueOf(ceVar2.G), "backend_error", "");
                                                                            if (!ceVar2.y) {
                                                                                str5 = "login";
                                                                            }
                                                                            a("/login-signup", "login_signup", "verification_successful", (ArrayList<String>) d4, str5);
                                                                        } else if (kotlin.g.b.k.a((Object) str4, (Object) "oauthdevicebindinginitSv1")) {
                                                                            String[] strArr2 = new String[4];
                                                                            Bundle arguments3 = ceVar.getArguments();
                                                                            if (arguments3 == null || (str2 = arguments3.getString(net.one97.paytm.oauth.utils.p.f56797b)) == null) {
                                                                                str2 = "";
                                                                            }
                                                                            strArr2[0] = str2;
                                                                            String string3 = ceVar2.getString(R.string.some_went_wrong);
                                                                            kotlin.g.b.k.a((Object) string3, "getString(R.string.some_went_wrong)");
                                                                            strArr2[1] = string3;
                                                                            strArr2[2] = SDKConstants.KEY_API;
                                                                            strArr2[3] = "";
                                                                            ArrayList d5 = kotlin.a.k.d(strArr2);
                                                                            if (!ceVar2.y) {
                                                                                str5 = "login";
                                                                            }
                                                                            a("/login-signup", "login_signup", "device_binding_successful", (ArrayList<String>) d5, str5);
                                                                        }
                                                                        ceVar2.q = false;
                                                                        Bundle arguments4 = ceVar.getArguments();
                                                                        if (arguments4 != null) {
                                                                            arguments4.putString("gaLabel", "backend_error");
                                                                        }
                                                                        net.one97.paytm.oauth.e.b bVar3 = ceVar2.f56570f;
                                                                        if (bVar3 != null) {
                                                                            bVar3.d(new Bundle(ceVar.getArguments()));
                                                                        }
                                                                    } else {
                                                                        String string4 = ceVar2.getString(R.string.no_connection);
                                                                        kotlin.g.b.k.a((Object) string4, "getString(R.string.no_connection)");
                                                                        String string5 = ceVar2.getString(R.string.no_internet);
                                                                        kotlin.g.b.k.a((Object) string5, "getString(R.string.no_internet)");
                                                                        OAuthUtils.a(ceVar.requireContext(), string4, string5, new f(ceVar2, str4));
                                                                    }
                                                                }

                                                                public static final /* synthetic */ void y(ce ceVar) {
                                                                    if (ceVar.f56568d.size() > 1) {
                                                                        Bundle arguments = ceVar.getArguments();
                                                                        if (arguments != null) {
                                                                            arguments.putString(H5Param.SESSION_ID, ceVar.f56568d.get(1));
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    Bundle arguments2 = ceVar.getArguments();
                                                                    if (arguments2 != null) {
                                                                        arguments2.putString(H5Param.SESSION_ID, ceVar.f56568d.get(0));
                                                                    }
                                                                }

                                                                public static final /* synthetic */ void b(ce ceVar, String str) {
                                                                    if (str != null && str.hashCode() == 629577124 && str.equals("oauthdevicebindingstatusSv1")) {
                                                                        ceVar.g();
                                                                    }
                                                                }
                                                            }
