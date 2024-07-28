package com.paytm.paymentsettings.merchantSubscriptions.view;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.common.data.PaymentSettingsCallBacks;
import com.paytm.paymentsettings.common.data.PaymentSettingsHelper;
import com.paytm.paymentsettings.merchantSubscriptions.a.a;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem;
import com.paytm.paymentsettings.merchantSubscriptions.view.d;
import com.paytm.paymentsettings.merchantSubscriptions.view.e;
import com.paytm.paymentsettings.merchantSubscriptions.view.f;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import java.util.List;
import kotlin.m.p;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.activity.PaytmActivity;

public final class ActiveSubscriptionActivity extends PaytmActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public AlertDialog alertDialog;
    /* access modifiers changed from: private */
    public String mActionType;
    /* access modifiers changed from: private */
    public String mOtp;
    /* access modifiers changed from: private */
    public String mState;
    /* access modifiers changed from: private */
    public com.paytm.paymentsettings.merchantSubscriptions.a.a mViewModel;
    private AlertDialog networkDialog;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class f<T> implements z<List<ActiveSubscriptionDetailsItem>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43471a;

        f(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43471a = activeSubscriptionActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.util.List} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r6) {
            /*
                r5 = this;
                java.util.List r6 = (java.util.List) r6
                com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity r0 = r5.f43471a
                androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
                java.lang.String r1 = "activeSubscription"
                androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r1)
                if (r0 == 0) goto L_0x0093
                boolean r1 = r0.isAdded()
                if (r1 == 0) goto L_0x0093
                com.paytm.paymentsettings.merchantSubscriptions.view.e r0 = (com.paytm.paymentsettings.merchantSubscriptions.view.e) r0
                if (r6 == 0) goto L_0x0020
                int r1 = r6.size()
                if (r1 == 0) goto L_0x008f
            L_0x0020:
                r1 = 1
                r0.a((boolean) r1)
                r1 = 0
                if (r6 == 0) goto L_0x004f
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r6 = r6.iterator()
            L_0x0034:
                boolean r3 = r6.hasNext()
                if (r3 == 0) goto L_0x004b
                java.lang.Object r3 = r6.next()
                r4 = r3
                com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r4 = (com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem) r4
                boolean r4 = r4.isOnusMerchant()
                if (r4 != 0) goto L_0x0034
                r2.add(r3)
                goto L_0x0034
            L_0x004b:
                r6 = r2
                java.util.List r6 = (java.util.List) r6
                goto L_0x0050
            L_0x004f:
                r6 = r1
            L_0x0050:
                if (r6 == 0) goto L_0x0060
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                com.paytm.paymentsettings.merchantSubscriptions.view.e$e r2 = new com.paytm.paymentsettings.merchantSubscriptions.view.e$e
                r2.<init>()
                java.util.Comparator r2 = (java.util.Comparator) r2
                java.util.List r6 = kotlin.a.k.a(r6, r2)
                goto L_0x0061
            L_0x0060:
                r6 = r1
            L_0x0061:
                if (r6 == 0) goto L_0x006b
                boolean r1 = r6.isEmpty()
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            L_0x006b:
                if (r1 != 0) goto L_0x0070
                kotlin.g.b.k.a()
            L_0x0070:
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L_0x008f
                java.util.List<com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem> r1 = r0.f43508b
                r1.clear()
                java.util.List<com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem> r1 = r0.f43508b
                if (r6 != 0) goto L_0x0082
                kotlin.g.b.k.a()
            L_0x0082:
                java.util.Collection r6 = (java.util.Collection) r6
                r1.addAll(r6)
                com.paytm.paymentsettings.merchantSubscriptions.view.b r6 = r0.f43507a
                if (r6 == 0) goto L_0x008e
                r6.notifyDataSetChanged()
            L_0x008e:
                return
            L_0x008f:
                r6 = 0
                r0.a((boolean) r6)
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity.f.onChanged(java.lang.Object):void");
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43472a;

        g(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43472a = activeSubscriptionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (!((Boolean) obj).booleanValue()) {
                ActiveSubscriptionActivity activeSubscriptionActivity = this.f43472a;
                com.paytm.utility.b.k(activeSubscriptionActivity, activeSubscriptionActivity.getString(R.string.please_wait_subscriptions));
                return;
            }
            com.paytm.utility.b.Z((Context) this.f43472a);
        }
    }

    static final class h<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43473a;

        h(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43473a = activeSubscriptionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            if (networkCustomError != null) {
                ActiveSubscriptionActivity activeSubscriptionActivity = this.f43473a;
                String alertTitle = networkCustomError.getAlertTitle();
                if (alertTitle == null) {
                    alertTitle = this.f43473a.getString(R.string.error);
                    kotlin.g.b.k.a((Object) alertTitle, "getString(R.string.error)");
                }
                String alertMessage = networkCustomError.getAlertMessage();
                if (alertMessage == null) {
                    alertMessage = this.f43473a.getString(R.string.something_went_wrong);
                    kotlin.g.b.k.a((Object) alertMessage, "getString(R.string.something_went_wrong)");
                }
                activeSubscriptionActivity.showAlert(alertTitle, alertMessage);
            }
        }
    }

    static final class i<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43474a;

        i(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43474a = activeSubscriptionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            Fragment c2 = this.f43474a.getSupportFragmentManager().c("activeSubscription");
            if (c2 != null && c2.isAdded()) {
                ((e) c2).a(!bool.booleanValue());
            }
        }
    }

    static final class k<T> implements z<a.C0737a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43476a;

        k(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43476a = activeSubscriptionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            y<ActiveSubscriptionDetailsItem> yVar;
            ActiveSubscriptionDetailsItem value;
            y<ActiveSubscriptionDetailsItem> yVar2;
            ActiveSubscriptionDetailsItem value2;
            a.C0737a aVar = (a.C0737a) obj;
            if (aVar != null) {
                int i2 = a.f43480a[aVar.ordinal()];
                String str = null;
                if (i2 == 1) {
                    ActiveSubscriptionActivity activeSubscriptionActivity = this.f43476a;
                    com.paytm.paymentsettings.merchantSubscriptions.a.a access$getMViewModel$p = activeSubscriptionActivity.mViewModel;
                    if (!(access$getMViewModel$p == null || (yVar = access$getMViewModel$p.j) == null || (value = yVar.getValue()) == null)) {
                        str = value.getMerchantName();
                    }
                    activeSubscriptionActivity.showStatusToast(str, false);
                } else if (i2 == 2) {
                    ActiveSubscriptionActivity activeSubscriptionActivity2 = this.f43476a;
                    com.paytm.paymentsettings.merchantSubscriptions.a.a access$getMViewModel$p2 = activeSubscriptionActivity2.mViewModel;
                    if (!(access$getMViewModel$p2 == null || (yVar2 = access$getMViewModel$p2.j) == null || (value2 = yVar2.getValue()) == null)) {
                        str = value2.getMerchantName();
                    }
                    activeSubscriptionActivity2.showStatusToast(str, true);
                    androidx.fragment.app.j supportFragmentManager = this.f43476a.getSupportFragmentManager();
                    kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
                    for (int f2 = supportFragmentManager.f(); f2 != 0; f2--) {
                        this.f43476a.getSupportFragmentManager().d();
                    }
                    this.f43476a.startActiveSubscriptionFragment();
                } else if (i2 == 3) {
                    this.f43476a.showStatusToast("", false);
                }
            }
        }
    }

    static final class l<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43477a;

        l(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43477a = activeSubscriptionActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            r1 = r1.j;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.String r3 = (java.lang.String) r3
                com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity r0 = r2.f43477a
                com.paytm.paymentsettings.merchantSubscriptions.a.a r1 = r0.mViewModel
                if (r1 == 0) goto L_0x0015
                androidx.lifecycle.y<com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem> r1 = r1.j
                if (r1 == 0) goto L_0x0015
                java.lang.Object r1 = r1.getValue()
                com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem r1 = (com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem) r1
                goto L_0x0016
            L_0x0015:
                r1 = 0
            L_0x0016:
                r0.startCancelConfirmationFragment(r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity.l.onChanged(java.lang.Object):void");
        }
    }

    static final class m<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43478a;

        m(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43478a = activeSubscriptionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            Fragment c2 = this.f43478a.getSupportFragmentManager().c("cancelConfirmation");
            if (!(c2 instanceof f)) {
                c2 = null;
            }
            f fVar = (f) c2;
            if (fVar != null) {
                kotlin.g.b.k.a((Object) bool, "it");
                if (bool.booleanValue()) {
                    TextView textView = fVar.f43518a;
                    if (textView != null) {
                        textView.setVisibility(0);
                        return;
                    }
                    return;
                }
                TextView textView2 = fVar.f43518a;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
        }
    }

    static final class n<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43479a;

        n(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43479a = activeSubscriptionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                this.f43479a.showSessionTimeoutAlert();
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_active_subscription);
        com.paytm.paymentsettings.common.a aVar = com.paytm.paymentsettings.common.a.f43393b;
        Context context = this;
        com.paytm.paymentsettings.common.a.a(context);
        com.paytm.paymentsettings.common.a aVar2 = com.paytm.paymentsettings.common.a.f43393b;
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "this.application");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(application, "application");
        com.paytm.network.b a2 = new com.paytm.network.b().a(context).a(a.c.AUTH).a(a.b.SILENT);
        kotlin.g.b.k.a((Object) a2, "CJRCommonNetworkCallBuil…rkCall.UserFacing.SILENT)");
        this.mViewModel = (com.paytm.paymentsettings.merchantSubscriptions.a.a) am.a((FragmentActivity) this, (al.b) new com.paytm.paymentsettings.common.b(new com.paytm.paymentsettings.common.data.a(context, a2), application, context.getClass().getCanonicalName())).a(com.paytm.paymentsettings.merchantSubscriptions.a.a.class);
        startObservingVariables();
        startActiveSubscriptionFragment();
    }

    private final void startObservingVariables() {
        LiveData liveData;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        LiveData liveData5;
        LiveData liveData6;
        LiveData liveData7;
        LiveData liveData8;
        LiveData liveData9;
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar = this.mViewModel;
        if (!(aVar == null || (liveData9 = aVar.f43454a) == null)) {
            liveData9.observe(this, new f(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar2 = this.mViewModel;
        if (!(aVar2 == null || (liveData8 = aVar2.f43456c) == null)) {
            liveData8.observe(this, new g(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar3 = this.mViewModel;
        if (!(aVar3 == null || (liveData7 = aVar3.f43455b) == null)) {
            liveData7.observe(this, new h(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar4 = this.mViewModel;
        if (!(aVar4 == null || (liveData6 = aVar4.f43457d) == null)) {
            liveData6.observe(this, new i(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar5 = this.mViewModel;
        if (!(aVar5 == null || (liveData5 = aVar5.f43458e) == null)) {
            liveData5.observe(this, new j(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar6 = this.mViewModel;
        if (!(aVar6 == null || (liveData4 = aVar6.f43462i) == null)) {
            liveData4.observe(this, new k(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar7 = this.mViewModel;
        if (!(aVar7 == null || (liveData3 = aVar7.k) == null)) {
            liveData3.observe(this, new l(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar8 = this.mViewModel;
        if (!(aVar8 == null || (liveData2 = aVar8.f43459f) == null)) {
            liveData2.observe(this, new m(this));
        }
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar9 = this.mViewModel;
        if (aVar9 != null && (liveData = aVar9.l) != null) {
            liveData.observe(this, new n(this));
        }
    }

    /* access modifiers changed from: private */
    public final void startCancelConfirmationFragment(ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem, String str) {
        String str2;
        String str3;
        Context context = this;
        String l2 = com.paytm.utility.b.l(context);
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar = this.mViewModel;
        if (aVar != null) {
            str2 = aVar.f43461h;
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = "Otp would be sent on your number ";
        } else {
            str3 = kotlin.g.b.k.a(str2, (Object) l2);
        }
        Toast.makeText(context, str3, 0).show();
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar2 = this.mViewModel;
        if (aVar2 == null) {
            kotlin.g.b.k.a();
        }
        if (aVar2.f43460g) {
            com.paytm.paymentsettings.merchantSubscriptions.a.a aVar3 = this.mViewModel;
            if (aVar3 == null) {
                kotlin.g.b.k.a();
            }
            aVar3.f43460g = false;
        }
        Fragment c2 = getSupportFragmentManager().c("cancelConfirmation");
        if (c2 == null || !c2.isVisible()) {
            f.a aVar4 = f.f43517b;
            com.paytm.paymentsettings.merchantSubscriptions.a.a aVar5 = this.mViewModel;
            f fVar = new f();
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", activeSubscriptionDetailsItem);
            bundle.putString("state", str);
            fVar.setArguments(bundle);
            fVar.f43520d = aVar5;
            addFragment(fVar, "cancelConfirmation");
        }
    }

    /* access modifiers changed from: private */
    public final void callSubscriptionAPI() {
        if (com.paytm.utility.b.c((Context) this)) {
            com.paytm.paymentsettings.merchantSubscriptions.a.a aVar = this.mViewModel;
            if (aVar != null) {
                aVar.f43456c.postValue(Boolean.FALSE);
                Job unused = BuildersKt__Builders_commonKt.launch$default(aVar.m, (kotlin.d.f) null, (CoroutineStart) null, new a.d(aVar, (kotlin.d.d) null), 3, (Object) null);
                return;
            }
            return;
        }
        showNetworkDialog(1);
    }

    /* access modifiers changed from: private */
    public final void showNetworkDialog(int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.no_connection_subscriptions));
        builder.setMessage(getString(R.string.no_internet_subscriptions));
        builder.setPositiveButton(getString(R.string.network_retry_yes_subscriptions), new b(this, i2));
        this.networkDialog = builder.show();
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43464a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f43465b;

        b(ActiveSubscriptionActivity activeSubscriptionActivity, int i2) {
            this.f43464a = activeSubscriptionActivity;
            this.f43465b = i2;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f43464a)) {
                int i3 = this.f43465b;
                if (i3 == 1) {
                    this.f43464a.callSubscriptionAPI();
                } else if (i3 == 2) {
                    ActiveSubscriptionActivity activeSubscriptionActivity = this.f43464a;
                    activeSubscriptionActivity.callEditSubscriptionAPI(activeSubscriptionActivity.mActionType);
                } else if (i3 == 3) {
                    ActiveSubscriptionActivity activeSubscriptionActivity2 = this.f43464a;
                    activeSubscriptionActivity2.callAuthorisedEditSubscriptionAPI(activeSubscriptionActivity2.mState, this.f43464a.mOtp);
                }
            } else {
                this.f43464a.showNetworkDialog(this.f43465b);
            }
        }
    }

    public final void callEditSubscriptionAPI(String str) {
        if (com.paytm.utility.b.c((Context) this)) {
            this.mActionType = str;
            com.paytm.paymentsettings.merchantSubscriptions.a.a aVar = this.mViewModel;
            if (aVar != null) {
                aVar.f43456c.postValue(Boolean.FALSE);
                Job unused = BuildersKt__Builders_commonKt.launch$default(aVar.m, (kotlin.d.f) null, (CoroutineStart) null, new a.c(aVar, str, (kotlin.d.d) null), 3, (Object) null);
                return;
            }
            return;
        }
        showNetworkDialog(2);
    }

    public final void callAuthorisedEditSubscriptionAPI(String str, String str2) {
        if (com.paytm.utility.b.c((Context) this)) {
            this.mState = str;
            this.mOtp = str2;
            com.paytm.paymentsettings.merchantSubscriptions.a.a aVar = this.mViewModel;
            if (aVar != null) {
                aVar.f43456c.postValue(Boolean.FALSE);
                Job unused = BuildersKt__Builders_commonKt.launch$default(aVar.m, (kotlin.d.f) null, (CoroutineStart) null, new a.b(aVar, str, str2, (kotlin.d.d) null), 3, (Object) null);
                return;
            }
            return;
        }
        showNetworkDialog(3);
    }

    /* access modifiers changed from: private */
    public final void startActiveSubscriptionFragment() {
        callSubscriptionAPI();
        e.a aVar = e.f43506c;
        addFragment(new e(), "activeSubscription");
    }

    public final void startActiveSubscriptionDetailFragment(ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem) {
        y<ActiveSubscriptionDetailsItem> yVar;
        d.a aVar = d.f43497a;
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("dataList", activeSubscriptionDetailsItem);
        dVar.setArguments(bundle);
        com.paytm.paymentsettings.merchantSubscriptions.a.a aVar2 = this.mViewModel;
        if (!(aVar2 == null || (yVar = aVar2.j) == null)) {
            yVar.postValue(activeSubscriptionDetailsItem);
        }
        addFragment(dVar, "activeSubscriptionDetail");
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f43466a;

        c(AlertDialog alertDialog) {
            this.f43466a = alertDialog;
        }

        public final void onClick(View view) {
            this.f43466a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43467a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f43468b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AlertDialog f43469c;

        d(ActiveSubscriptionActivity activeSubscriptionActivity, boolean z, AlertDialog alertDialog) {
            this.f43467a = activeSubscriptionActivity;
            this.f43468b = z;
            this.f43469c = alertDialog;
        }

        public final void onClick(View view) {
            if (this.f43468b) {
                this.f43469c.dismiss();
            } else {
                this.f43467a.callEditSubscriptionAPI(TransactionType.CANCEL);
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f43470a;

        e(AlertDialog alertDialog) {
            this.f43470a = alertDialog;
        }

        public final void run() {
            if (this.f43470a.isShowing()) {
                this.f43470a.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showAlert(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        kotlin.g.b.k.a((Object) layoutInflater, "this.layoutInflater");
        View inflate = layoutInflater.inflate(R.layout.layout_sucess_otp_dialog, (ViewGroup) null);
        kotlin.g.b.k.a((Object) inflate, "inflater.inflate(R.layou…_sucess_otp_dialog, null)");
        View findViewById = inflate.findViewById(R.id.dialog_title);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.sucess_msg);
            if (findViewById2 != null) {
                TextView textView2 = (TextView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.sucess_number);
                if (findViewById3 != null) {
                    View findViewById4 = inflate.findViewById(R.id.seperator);
                    kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.seperator)");
                    ((TextView) findViewById3).setVisibility(8);
                    findViewById4.setVisibility(8);
                    textView.setText(str);
                    textView2.setText(str2);
                    View findViewById5 = inflate.findViewById(R.id.btn_ok);
                    if (findViewById5 != null) {
                        Button button = (Button) findViewById5;
                        button.setText(R.string.ok);
                        builder.setCancelable(false);
                        builder.setView(inflate);
                        this.alertDialog = builder.show();
                        button.setOnClickListener(new a(this));
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.Button");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43463a;

        a(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43463a = activeSubscriptionActivity;
        }

        public final void onClick(View view) {
            AlertDialog access$getAlertDialog$p = this.f43463a.alertDialog;
            if (access$getAlertDialog$p != null) {
                access$getAlertDialog$p.dismiss();
            }
            this.f43463a.finish();
        }
    }

    private final void addFragment(Fragment fragment, String str) {
        getSupportFragmentManager().a().b(R.id.fl_active_subscription_list_as, fragment, str).a((String) null).c();
    }

    /* access modifiers changed from: private */
    public final void showSessionTimeoutAlert() {
        PaymentSettingsHelper.Companion companion = PaymentSettingsHelper.Companion;
        PaymentSettingsCallBacks b2 = PaymentSettingsHelper.Companion.b();
        if (b2 != null) {
            b2.showSessionTimeoutAlert(this);
        }
    }

    public final void onDestroy() {
        dismissDialog();
        super.onDestroy();
    }

    private final void dismissDialog() {
        AlertDialog alertDialog2 = this.networkDialog;
        if (alertDialog2 != null) {
            if (alertDialog2 != null) {
                Boolean.valueOf(alertDialog2.isShowing());
            }
            AlertDialog alertDialog3 = this.networkDialog;
            if (alertDialog3 != null) {
                alertDialog3.dismiss();
            }
        }
        AlertDialog alertDialog4 = this.alertDialog;
        if (alertDialog4 != null) {
            if (alertDialog4 != null) {
                Boolean.valueOf(alertDialog4.isShowing());
            }
            AlertDialog alertDialog5 = this.alertDialog;
            if (alertDialog5 != null) {
                alertDialog5.dismiss();
            }
        }
    }

    public final void onBackPressed() {
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.f() == 1) {
            finish();
        } else {
            getSupportFragmentManager().d();
        }
    }

    static final class j<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActiveSubscriptionActivity f43475a;

        j(ActiveSubscriptionActivity activeSubscriptionActivity) {
            this.f43475a = activeSubscriptionActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ActiveSubscriptionActivity activeSubscriptionActivity = this.f43475a;
            String string = activeSubscriptionActivity.getString(R.string.error);
            kotlin.g.b.k.a((Object) string, "getString(R.string.error)");
            String string2 = this.f43475a.getString(R.string.something_went_wrong);
            kotlin.g.b.k.a((Object) string2, "getString(R.string.something_went_wrong)");
            activeSubscriptionActivity.showAlert(string, string2);
        }
    }

    /* access modifiers changed from: private */
    public final void showStatusToast(String str, boolean z) {
        if (!p.a(str, "", false)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TransparentDialog);
            LayoutInflater layoutInflater = getLayoutInflater();
            kotlin.g.b.k.a((Object) layoutInflater, "layoutInflater");
            View inflate = layoutInflater.inflate(R.layout.layout_subscription_toast, (ViewGroup) null);
            kotlin.g.b.k.a((Object) inflate, "inflater.inflate(R.layou…subscription_toast, null)");
            builder.setView(inflate);
            AlertDialog create = builder.create();
            kotlin.g.b.k.a((Object) create, "builder.create()");
            View findViewById = inflate.findViewById(R.id.tv_toast_text);
            if (findViewById != null) {
                RoboTextView roboTextView = (RoboTextView) findViewById;
                View findViewById2 = inflate.findViewById(R.id.tv_toast_retry_text);
                if (findViewById2 != null) {
                    RoboTextView roboTextView2 = (RoboTextView) findViewById2;
                    if (z) {
                        roboTextView.setText(getString(R.string.subscription_successfully_cancelled, new Object[]{str}));
                        roboTextView.setTextColor(Color.parseColor("#000000"));
                        roboTextView2.setText(getString(R.string.subscription_ok));
                        roboTextView2.setBackgroundResource(R.drawable.bg_rounded_rectangle_transparent_black);
                        roboTextView2.setTextColor(Color.parseColor("#000000"));
                        roboTextView2.setOnClickListener(new c(create));
                        inflate.setBackgroundColor(Color.parseColor("#fff5e5"));
                        create.show();
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        Window window = create.getWindow();
                        if (window != null) {
                            layoutParams.copyFrom(window.getAttributes());
                            layoutParams.gravity = 8388663;
                            window.setAttributes(layoutParams);
                        }
                    } else {
                        roboTextView.setText(getString(R.string.subscription_failed_to_cancel, new Object[]{str}));
                        roboTextView.setTextColor(Color.parseColor("#ffffff"));
                        roboTextView2.setText(getString(R.string.subscription_retry));
                        roboTextView2.setBackgroundResource(R.drawable.bg_rounded_rectangle_transparent_white);
                        inflate.setBackgroundColor(Color.parseColor("#ff585d"));
                        create.show();
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        Window window2 = create.getWindow();
                        if (window2 != null) {
                            layoutParams2.copyFrom(window2.getAttributes());
                            layoutParams2.gravity = 8388663;
                            window2.setAttributes(layoutParams2);
                        }
                    }
                    roboTextView2.setOnClickListener(new d(this, z, create));
                    Handler handler = new Handler();
                    if (!isFinishing()) {
                        handler.postDelayed(new e(create), 8000);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
            }
            throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
        }
    }
}
