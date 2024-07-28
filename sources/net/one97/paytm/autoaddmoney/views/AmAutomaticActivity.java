package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.q;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoney;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyCreditCard;
import net.one97.paytm.addmoney.common.model.CJRAvailableInstrumentsAddMoneyPPBL;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.autoaddmoney.c.b;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.autoaddmoney.views.b;
import net.one97.paytm.autoaddmoney.views.g;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.wallet.CJRCashWalletResponse;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeDisableAutoAdd;
import net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeFetchStatus;

public final class AmAutomaticActivity extends PaytmActivity {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public String f49286a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public IJRDataModel f49287b;

    /* renamed from: c  reason: collision with root package name */
    private View f49288c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f49289d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f49290e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f49291f;

    /* renamed from: g  reason: collision with root package name */
    private String f49292g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f49293h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f49294i;
    /* access modifiers changed from: private */
    public net.one97.paytm.autoaddmoney.c.b j;
    /* access modifiers changed from: private */
    public Boolean k = Boolean.FALSE;
    /* access modifiers changed from: private */
    public ArrayList<IJRDataModel> l = new ArrayList<>();
    /* access modifiers changed from: private */
    public boolean m;
    private String n = "";

    static final class b<T> implements z<net.one97.paytm.autoaddmoney.a<? extends ArrayList<IJRDataModel>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49297a;

        b(AmAutomaticActivity amAutomaticActivity) {
            this.f49297a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            ArrayList arrayList = aVar != null ? (ArrayList) aVar.a() : null;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    IJRDataModel iJRDataModel = (IJRDataModel) it2.next();
                    if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyCreditCard.Card) {
                        if (((CJRAvailableInstrumentsAddMoneyCreditCard.Card) iJRDataModel).getSavedCardId().equals(this.f49297a.f49286a)) {
                            this.f49297a.f49287b = iJRDataModel;
                            break;
                        }
                    } else if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoney.Card) {
                        if (((CJRAvailableInstrumentsAddMoney.Card) iJRDataModel).getSavedCardId().equals(this.f49297a.f49286a)) {
                            this.f49297a.f49287b = iJRDataModel;
                            break;
                        }
                    } else if (iJRDataModel instanceof CJRAvailableInstrumentsAddMoneyPPBL.Card) {
                        this.f49297a.f49287b = iJRDataModel;
                        break;
                    }
                }
                ArrayList b2 = this.f49297a.l;
                if (b2 != null) {
                    b2.clear();
                }
                ArrayList b3 = this.f49297a.l;
                if (b3 != null) {
                    b3.addAll(arrayList);
                }
            }
            net.one97.paytm.autoaddmoney.c.b c2 = this.f49297a.j;
            if (c2 != null) {
                c2.b(true);
                c2.s.a((net.one97.paytm.addmoney.h) new b.d(c2));
            }
        }
    }

    static final class c<T> implements z<net.one97.paytm.autoaddmoney.a<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49298a;

        c(AmAutomaticActivity amAutomaticActivity) {
            this.f49298a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            Boolean bool = aVar != null ? (Boolean) aVar.a() : null;
            AmAutomaticActivity amAutomaticActivity = this.f49298a;
            if (bool == null) {
                kotlin.g.b.k.a();
            }
            amAutomaticActivity.f49290e = bool.booleanValue();
            AmAutomaticActivity.f(this.f49298a);
        }
    }

    static final class d<T> implements z<net.one97.paytm.autoaddmoney.a<? extends CJRCashWalletResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49299a;

        d(AmAutomaticActivity amAutomaticActivity) {
            this.f49299a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            CJRCashWalletResponse cJRCashWalletResponse = aVar != null ? (CJRCashWalletResponse) aVar.a() : null;
            if (cJRCashWalletResponse != null) {
                net.one97.paytm.addmoney.utils.j.a((Context) this.f49299a, cJRCashWalletResponse.getWalletGrade());
                String a2 = net.one97.paytm.newaddmoney.utils.e.a(this.f49299a);
                if (kotlin.g.b.k.a((Object) a2, (Object) net.one97.paytm.newaddmoney.utils.d.PAYTM_PRIME_WALLET.name()) || kotlin.g.b.k.a((Object) a2, (Object) net.one97.paytm.newaddmoney.utils.d.PAYTM_ADHAAR_OTP_KYC.name()) || kotlin.g.b.k.a((Object) a2, (Object) net.one97.paytm.newaddmoney.utils.d.PAYTM_MIN_KYC.name())) {
                    Boolean d2 = this.f49299a.k;
                    if (d2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (d2.booleanValue() || this.f49299a.f49290e) {
                        AmAutomaticActivity.f(this.f49299a);
                        return;
                    }
                    this.f49299a.f49291f = true;
                    AmAutomaticActivity amAutomaticActivity = this.f49299a;
                    AmAutomaticActivity.a(amAutomaticActivity, amAutomaticActivity.l, net.one97.paytm.addmoney.utils.j.a(cJRCashWalletResponse));
                    return;
                }
                net.one97.paytm.helper.a.f50546a.a().a((Context) this.f49299a, "paytmmp://min_kyc?featuretype=popup");
                this.f49299a.finish();
            }
        }
    }

    static final class e<T> implements z<net.one97.paytm.autoaddmoney.a<? extends CJRSubscribeDisableAutoAdd>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49300a;

        e(AmAutomaticActivity amAutomaticActivity) {
            this.f49300a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            CJRSubscribeDisableAutoAdd cJRSubscribeDisableAutoAdd = aVar != null ? (CJRSubscribeDisableAutoAdd) aVar.f49111a : null;
            if (cJRSubscribeDisableAutoAdd == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.wallet.newdesign.addmoney.model.CJRSubscribeDisableAutoAdd");
            } else if (p.a(cJRSubscribeDisableAutoAdd.getStatusMessage(), "SUCCESS", true)) {
                this.f49300a.f49290e = true;
                this.f49300a.m = true;
                AmAutomaticActivity.h(this.f49300a);
            }
        }
    }

    static final class f<T> implements z<net.one97.paytm.autoaddmoney.a<? extends Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49301a;

        f(AmAutomaticActivity amAutomaticActivity) {
            this.f49301a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            if (kotlin.g.b.k.a((Object) aVar != null ? (Boolean) aVar.a() : null, (Object) Boolean.TRUE)) {
                this.f49301a.finish();
            } else {
                this.f49301a.onBackPressed();
            }
        }
    }

    static final class g<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49302a;

        g(AmAutomaticActivity amAutomaticActivity) {
            this.f49302a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            Bundle bundle = null;
            net.one97.paytm.autoaddmoney.b.f fVar = aVar != null ? (net.one97.paytm.autoaddmoney.b.f) aVar.a() : null;
            net.one97.paytm.helper.c a2 = net.one97.paytm.helper.a.f50546a.a();
            Activity activity = this.f49302a;
            String canonicalName = AmAutomaticActivity.class.getCanonicalName();
            if (fVar != null) {
                bundle = fVar.f49164b;
            }
            a2.a(activity, canonicalName, bundle);
        }
    }

    static final class h<T> implements z<net.one97.paytm.autoaddmoney.a<? extends com.paytm.network.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49303a;

        h(AmAutomaticActivity amAutomaticActivity) {
            this.f49303a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            this.f49303a.a(aVar != null ? (com.paytm.network.a) aVar.a() : null);
        }
    }

    static final class i<T> implements z<net.one97.paytm.autoaddmoney.a<? extends net.one97.paytm.autoaddmoney.b.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49304a;

        i(AmAutomaticActivity amAutomaticActivity) {
            this.f49304a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            AmAutomaticActivity.a(this.f49304a, aVar != null ? (net.one97.paytm.autoaddmoney.b.d) aVar.a() : null);
        }
    }

    static final class j<T> implements z<net.one97.paytm.autoaddmoney.a<? extends CJRSubscribeFetchStatus>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49305a;

        j(AmAutomaticActivity amAutomaticActivity) {
            this.f49305a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            String str = null;
            CJRSubscribeFetchStatus cJRSubscribeFetchStatus = aVar != null ? (CJRSubscribeFetchStatus) aVar.a() : null;
            boolean z = true;
            if (cJRSubscribeFetchStatus != null) {
                if (cJRSubscribeFetchStatus.getStatusMessage() != null && cJRSubscribeFetchStatus.getStatusMessage().equals("SUCCESS")) {
                    CJRSubscribeFetchStatus.Response response = cJRSubscribeFetchStatus.getResponse();
                    String statusOfSubscription = response != null ? response.getStatusOfSubscription() : null;
                    AmAutomaticActivity amAutomaticActivity = this.f49305a;
                    CJRSubscribeFetchStatus.Response response2 = cJRSubscribeFetchStatus.getResponse();
                    amAutomaticActivity.f49286a = response2 != null ? response2.getCardId() : null;
                    if (p.a(statusOfSubscription, "ACTIVE", false)) {
                        AmAutomaticActivity amAutomaticActivity2 = this.f49305a;
                        CJRSubscribeFetchStatus.Response response3 = cJRSubscribeFetchStatus.getResponse();
                        amAutomaticActivity2.f49293h = response3 != null ? response3.getSubscriptionAmount() : null;
                        this.f49305a.f49290e = false;
                        AmAutomaticActivity amAutomaticActivity3 = this.f49305a;
                        CJRSubscribeFetchStatus.Response response4 = cJRSubscribeFetchStatus.getResponse();
                        if (response4 != null) {
                            str = response4.getTopUpAmount();
                        }
                        amAutomaticActivity3.f49294i = str;
                    } else if (p.a(statusOfSubscription, "FAILED", false)) {
                        this.f49305a.f49290e = false;
                        this.f49305a.k = Boolean.TRUE;
                    } else if (p.a(statusOfSubscription, "DISABLED_BY_USER", false) || p.a(statusOfSubscription, "INACTIVE", false)) {
                        AmAutomaticActivity amAutomaticActivity4 = this.f49305a;
                        CJRSubscribeFetchStatus.Response response5 = cJRSubscribeFetchStatus.getResponse();
                        amAutomaticActivity4.f49293h = response5 != null ? response5.getSubscriptionAmount() : null;
                        this.f49305a.f49290e = true;
                        this.f49305a.f49291f = p.a(statusOfSubscription, "INACTIVE", false);
                        AmAutomaticActivity amAutomaticActivity5 = this.f49305a;
                        CJRSubscribeFetchStatus.Response response6 = cJRSubscribeFetchStatus.getResponse();
                        if (response6 != null) {
                            str = response6.getTopUpAmount();
                        }
                        amAutomaticActivity5.f49294i = str;
                    }
                } else if (cJRSubscribeFetchStatus.getStatusCode() != null && cJRSubscribeFetchStatus.getStatusCode().equals("FAILURE")) {
                    this.f49305a.k = Boolean.TRUE;
                } else if (cJRSubscribeFetchStatus.getStatusCode() != null && cJRSubscribeFetchStatus.getStatusCode().equals("USD_1027")) {
                    this.f49305a.k = Boolean.TRUE;
                }
            }
            net.one97.paytm.autoaddmoney.c.b c2 = this.f49305a.j;
            if (c2 != null) {
                Boolean d2 = this.f49305a.k;
                if (d2 == null) {
                    kotlin.g.b.k.a();
                }
                if (d2.booleanValue() || this.f49305a.f49290e) {
                    z = false;
                }
                c2.c(z);
            }
        }
    }

    static final class k<T> implements z<net.one97.paytm.autoaddmoney.a<? extends NetworkCustomError>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49306a;

        k(AmAutomaticActivity amAutomaticActivity) {
            this.f49306a = amAutomaticActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.autoaddmoney.a aVar = (net.one97.paytm.autoaddmoney.a) obj;
            AddMoneyUtils.a(this.f49306a, aVar != null ? (NetworkCustomError) aVar.a() : null, AmAutomaticActivity.class.getCanonicalName(), Boolean.FALSE);
        }
    }

    public final void onCreate(Bundle bundle) {
        LiveData liveData;
        LiveData liveData2;
        LiveData liveData3;
        LiveData liveData4;
        LiveData liveData5;
        LiveData liveData6;
        LiveData liveData7;
        LiveData liveData8;
        LiveData liveData9;
        LiveData liveData10;
        super.onCreate(bundle);
        setContentView(R.layout.am_activity_editautomatic);
        if (net.one97.paytm.newaddmoney.utils.e.a()) {
            net.one97.paytm.helper.a.f50546a.a().a((Context) this, "paytmmp://min_kyc?featuretype=popup");
            finish();
            return;
        }
        this.f49288c = findViewById(R.id.lyt_wallet_loader);
        this.f49289d = (LinearLayout) findViewById(R.id.snackbarlayout);
        this.j = (net.one97.paytm.autoaddmoney.c.b) net.one97.paytm.autoaddmoney.util.a.a(this, net.one97.paytm.autoaddmoney.c.b.class);
        if (getIntent().hasExtra("which_page")) {
            this.f49292g = getIntent().getStringExtra("which_page");
        }
        this.f49291f = getIntent().getBooleanExtra("isEditMode", false);
        this.f49290e = getIntent().getBooleanExtra("fetch_status", false);
        this.f49286a = getIntent().getStringExtra("card_id");
        this.f49294i = getIntent().getStringExtra("top_up_amount");
        this.f49293h = getIntent().getStringExtra("amount");
        if (getIntent().hasExtra("source")) {
            String stringExtra = getIntent().getStringExtra("source");
            kotlin.g.b.k.a((Object) stringExtra, "intent.getStringExtra(UtilsConstants.SOURCE)");
            this.n = stringExtra;
        }
        net.one97.paytm.autoaddmoney.c.b bVar = this.j;
        if (!(bVar == null || (liveData10 = bVar.f49201h) == null)) {
            liveData10.observe(this, new b(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar2 = this.j;
        if (!(bVar2 == null || (liveData9 = bVar2.p) == null)) {
            liveData9.observe(this, new d(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar3 = this.j;
        if (!(bVar3 == null || (liveData8 = bVar3.l) == null)) {
            liveData8.observe(this, new e(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar4 = this.j;
        if (!(bVar4 == null || (liveData7 = bVar4.k) == null)) {
            liveData7.observe(this, new f(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar5 = this.j;
        if (!(bVar5 == null || (liveData6 = bVar5.f49200g) == null)) {
            liveData6.observe(this, new g(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar6 = this.j;
        if (!(bVar6 == null || (liveData5 = bVar6.f49197d) == null)) {
            liveData5.observe(this, new h(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar7 = this.j;
        if (!(bVar7 == null || (liveData4 = bVar7.f49194a) == null)) {
            liveData4.observe(this, new i(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar8 = this.j;
        if (!(bVar8 == null || (liveData3 = bVar8.o) == null)) {
            liveData3.observe(this, new j(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar9 = this.j;
        if (!(bVar9 == null || (liveData2 = bVar9.q) == null)) {
            liveData2.observe(this, new k(this));
        }
        net.one97.paytm.autoaddmoney.c.b bVar10 = this.j;
        if (!(bVar10 == null || (liveData = bVar10.r) == null)) {
            liveData.observe(this, new c(this));
        }
        if (this.f49286a == null) {
            net.one97.paytm.autoaddmoney.c.b bVar11 = this.j;
            if (bVar11 != null) {
                bVar11.b(true);
                bVar11.s.a((a.d) new b.c(bVar11));
                return;
            }
            return;
        }
        net.one97.paytm.autoaddmoney.c.b bVar12 = this.j;
        if (bVar12 != null) {
            bVar12.c(true);
        }
    }

    public final void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.helper.a.f50546a.a().a(context));
    }

    public final void a(com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new a(this, aVar));
        builder.show();
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticActivity f49295a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.a f49296b;

        a(AmAutomaticActivity amAutomaticActivity, com.paytm.network.a aVar) {
            this.f49295a = amAutomaticActivity;
            this.f49296b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (com.paytm.utility.b.c((Context) this.f49295a)) {
                net.one97.paytm.autoaddmoney.c.b c2 = this.f49295a.j;
                if (c2 != null) {
                    c2.b(true);
                }
                com.paytm.network.a aVar = this.f49296b;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            this.f49295a.a(this.f49296b);
        }
    }

    public final void onBackPressed() {
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
        if (supportFragmentManager.f() > 1) {
            getSupportFragmentManager().d();
            return;
        }
        androidx.fragment.app.j supportFragmentManager2 = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager2, "supportFragmentManager");
        if (supportFragmentManager2.f() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public static final /* synthetic */ void f(AmAutomaticActivity amAutomaticActivity) {
        g.a aVar = g.f49415b;
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putString("min_amount", amAutomaticActivity.f49293h);
        bundle.putString("auto_amount", amAutomaticActivity.f49294i);
        bundle.putSerializable("SAVED_CARDS", amAutomaticActivity.l);
        bundle.putBoolean("IS_DEACTIVATED", amAutomaticActivity.f49290e);
        bundle.putBoolean("EDIT_MODE", amAutomaticActivity.f49291f);
        bundle.putString("source", amAutomaticActivity.n);
        gVar.setArguments(bundle);
        q a2 = amAutomaticActivity.getSupportFragmentManager().a();
        a2.a(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        a2.b(R.id.framelayout, gVar).a(g.class.getName()).c();
        net.one97.paytm.helper.a.f50546a.a().a((Context) amAutomaticActivity, "Auto Add Money", "Auto_add_money_screen_loaded", (ArrayList<String>) kotlin.a.k.d("Creation_page", amAutomaticActivity.n), "", "", "");
    }

    public static final /* synthetic */ void a(AmAutomaticActivity amAutomaticActivity, ArrayList arrayList, double d2) {
        b.a aVar = b.f49323d;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("which_page", "add_money");
        bundle.putBoolean("isEditMode", amAutomaticActivity.f49291f);
        bundle.putBoolean("fetch_status", amAutomaticActivity.f49290e);
        bundle.putString("min_amount", amAutomaticActivity.f49293h);
        bundle.putString("auto_amount", amAutomaticActivity.f49294i);
        bundle.putString("card_id", amAutomaticActivity.f49286a);
        bundle.putSerializable("SAVED_CARD", amAutomaticActivity.f49287b);
        bundle.putSerializable("SAVED_CARDS", arrayList);
        bundle.putDouble("walletBalance", d2);
        bundle.putString("source", amAutomaticActivity.n);
        bVar.setArguments(bundle);
        amAutomaticActivity.getSupportFragmentManager().a().b(R.id.framelayout, bVar).a((String) null).c();
        net.one97.paytm.helper.a.f50546a.a().a((Context) amAutomaticActivity, "Auto Add Money", "Auto_add_money_screen_loaded", (ArrayList<String>) kotlin.a.k.d("Subscription_page", amAutomaticActivity.n), "", "", "");
    }

    public static final /* synthetic */ void h(AmAutomaticActivity amAutomaticActivity) {
        a aVar = new a();
        androidx.fragment.app.j supportFragmentManager = amAutomaticActivity.getSupportFragmentManager();
        if (supportFragmentManager == null) {
            kotlin.g.b.k.a();
        }
        aVar.show(supportFragmentManager, AmAutomaticActivity.class.getName());
    }

    public static final /* synthetic */ void a(AmAutomaticActivity amAutomaticActivity, net.one97.paytm.autoaddmoney.b.d dVar) {
        Boolean bool;
        View view = null;
        if (dVar != null) {
            bool = Boolean.valueOf(dVar.f49160b);
        } else {
            bool = null;
        }
        if (bool == null || !dVar.f49160b) {
            View view2 = amAutomaticActivity.f49288c;
            if (view2 != null) {
                if ((view2 != null ? view2.findViewById(R.id.wallet_loader) : null) != null) {
                    View view3 = amAutomaticActivity.f49288c;
                    if (view3 != null) {
                        view = view3.findViewById(R.id.wallet_loader);
                    }
                    if (view != null) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) view);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                }
                return;
            }
            return;
        }
        View view4 = amAutomaticActivity.f49288c;
        if (view4 != null) {
            if ((view4 != null ? view4.findViewById(R.id.wallet_loader) : null) != null) {
                View view5 = amAutomaticActivity.f49288c;
                if (view5 != null) {
                    view = view5.findViewById(R.id.wallet_loader);
                }
                if (view != null) {
                    net.one97.paytm.common.widgets.a.a((LottieAnimationView) view);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            }
        }
    }
}
