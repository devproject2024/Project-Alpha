package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.g;
import net.one97.paytm.upgradeKyc.d.h;
import net.one97.paytm.upgradeKyc.d.j;
import net.one97.paytm.upgradeKyc.d.l;
import net.one97.paytm.upgradeKyc.d.s;
import net.one97.paytm.upgradeKyc.f.d;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.e;

public final class KycFlowActivity extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65324a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f65325b;

    /* renamed from: d  reason: collision with root package name */
    private String f65326d;

    /* renamed from: e  reason: collision with root package name */
    private String f65327e;

    /* renamed from: f  reason: collision with root package name */
    private String f65328f;

    /* renamed from: g  reason: collision with root package name */
    private String f65329g;

    /* renamed from: h  reason: collision with root package name */
    private String f65330h;

    /* renamed from: i  reason: collision with root package name */
    private l f65331i;
    /* access modifiers changed from: private */
    public ArrayList<PayTMPartnerListModal.Response> j;
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.payments_bank_info_btn_close;
        if (valueOf != null && valueOf.intValue() == i2) {
            onBackPressed();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.activity_kyc_flow;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getExtras() != null) {
                Intent intent2 = getIntent();
                k.a((Object) intent2, "intent");
                Bundle extras = intent2.getExtras();
                if (extras == null) {
                    k.a();
                }
                this.f65325b = extras.getString("name");
                this.f65326d = extras.getString("doc_number");
                this.f65327e = extras.getString("doc_type");
                this.f65328f = extras.getString("doc_expiry");
                this.f65329g = extras.getString("vertical");
                this.f65330h = extras.getString("call_back_url");
                this.j = (ArrayList) extras.getSerializable("kyc_center_list");
            }
        }
        if (p.a(this.f65329g, CJRPGTransactionRequestUtils.PAYER_BANK_NAME, true)) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.f();
            }
            View a2 = a(R.id.lyt_bank_header);
            k.a((Object) a2, "lyt_bank_header");
            a2.setVisibility(0);
            ((ImageView) findViewById(R.id.payments_bank_info_btn_close)).setOnClickListener(this);
        } else {
            View a3 = a(R.id.lyt_bank_header);
            k.a((Object) a3, "lyt_bank_header");
            a3.setVisibility(8);
        }
        int intExtra = getIntent().getIntExtra("kyc_flow_purpose", 1);
        Fragment hVar = new h();
        Intent intent3 = getIntent();
        k.a((Object) intent3, "intent");
        hVar.setArguments(intent3.getExtras());
        if (intExtra == 1) {
            this.f65331i = new l();
            l lVar = this.f65331i;
            if (lVar != null) {
                Intent intent4 = getIntent();
                k.a((Object) intent4, "intent");
                lVar.setArguments(intent4.getExtras());
            }
            l lVar2 = this.f65331i;
            if (lVar2 == null) {
                k.a();
            }
            hVar = lVar2;
        } else if (intExtra == 2) {
            hVar = new s();
            Intent intent5 = getIntent();
            k.a((Object) intent5, "intent");
            ((s) hVar).setArguments(intent5.getExtras());
        } else if (intExtra == 3) {
            hVar = new s();
            Intent intent6 = getIntent();
            k.a((Object) intent6, "intent");
            ((s) hVar).setArguments(intent6.getExtras());
        } else if (intExtra == 4) {
            hVar = new net.one97.paytm.upgradeKyc.d.c();
            Intent intent7 = getIntent();
            k.a((Object) intent7, "intent");
            ((net.one97.paytm.upgradeKyc.d.c) hVar).setArguments(intent7.getExtras());
        } else if (intExtra == 5) {
            hVar = new j();
        } else if (intExtra == 10) {
            hVar = new g();
            Bundle bundle2 = new Bundle();
            bundle2.putString("vertical", this.f65329g);
            ((g) hVar).setArguments(bundle2);
        }
        if (intExtra != 11) {
            a(hVar);
            return;
        }
        e.a aVar = e.f66028b;
        String s = com.paytm.utility.b.s(e.a.b().a());
        k.a((Object) s, "CJRAppCommonUtility.getL….getApplicationContext())");
        Double b2 = p.b(s);
        e.a aVar2 = e.f66028b;
        String t = com.paytm.utility.b.t(e.a.b().a());
        k.a((Object) t, "CJRAppCommonUtility.getL….getApplicationContext())");
        Double b3 = p.b(t);
        if (b2 == null || b3 == null) {
            a(0.0d, 0.0d);
        } else {
            a(b2.doubleValue(), b3.doubleValue());
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 220) {
            l lVar = this.f65331i;
            if (lVar != null) {
                lVar.onActivityResult(i2, i3, intent);
                return;
            }
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycFlowActivity f65333a;

        public final void a() {
        }

        c(KycFlowActivity kycFlowActivity) {
            this.f65333a = kycFlowActivity;
        }

        public final void b() {
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f65333a.a(R.id.wallet_loader));
        }

        public final void a(ArrayList<PayTMPartnerListModal.Response> arrayList) {
            k.c(arrayList, "centerList");
            this.f65333a.j = arrayList;
            KycFlowActivity kycFlowActivity = this.f65333a;
            ArrayList a2 = kycFlowActivity.j;
            Integer valueOf = a2 != null ? Integer.valueOf(a2.size()) : null;
            if (valueOf == null) {
                k.a();
            }
            new net.one97.paytm.upgradeKyc.f.h(kycFlowActivity, valueOf.intValue(), new b(kycFlowActivity)).a();
        }

        public final void a(NetworkCustomError networkCustomError) {
            if (networkCustomError != null) {
                net.one97.paytm.upgradeKyc.utils.l.a();
                net.one97.paytm.upgradeKyc.utils.l.a((Context) this.f65333a, networkCustomError);
            }
        }
    }

    private final void a(double d2, double d3) {
        new net.one97.paytm.upgradeKyc.f.e(this, d2, d3, new c(this)).a();
    }

    private final void a(Fragment fragment) {
        q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        a2.a(R.id.fragment_container, fragment);
        a2.c();
    }

    public final void d() {
        Intent intent = new Intent(this, KycVisitActivity.class);
        Bundle bundle = new Bundle();
        ArrayList<PayTMPartnerListModal.Response> arrayList = this.j;
        if (arrayList != null) {
            bundle.putSerializable("kyc_center_list", arrayList);
            bundle.putString("doc_type", this.f65327e);
            bundle.putString("doc_number", this.f65326d);
            bundle.putString("vertical", this.f65329g);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public static final class b implements net.one97.paytm.upgradeKyc.f.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycFlowActivity f65332a;

        b(KycFlowActivity kycFlowActivity) {
            this.f65332a = kycFlowActivity;
        }

        public final void a(ScreenTabModel screenTabModel) {
            k.c(screenTabModel, "model");
            if (TextUtils.isEmpty(screenTabModel.getTab1()) && TextUtils.isEmpty(screenTabModel.getTab2())) {
                KycFlowActivity.b(this.f65332a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && !TextUtils.isEmpty(screenTabModel.getTab2())) {
                KycFlowActivity.b(this.f65332a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && p.a(screenTabModel.getTab1(), "request", true)) {
                KycFlowActivity.c(this.f65332a);
            } else if (!TextUtils.isEmpty(screenTabModel.getTab2()) && p.a(screenTabModel.getTab2(), "dynamic", true)) {
                this.f65332a.d();
            } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && p.a(screenTabModel.getTab1(), "dynamic", true)) {
                this.f65332a.d();
            } else if (!TextUtils.isEmpty(screenTabModel.getTab2()) && p.a(screenTabModel.getTab2(), "request", true)) {
                KycFlowActivity.c(this.f65332a);
            }
        }

        public final void a(NetworkCustomError networkCustomError) {
            if (networkCustomError != null) {
                net.one97.paytm.upgradeKyc.utils.l.a();
                if (!net.one97.paytm.upgradeKyc.utils.l.a((Context) this.f65332a, networkCustomError)) {
                    net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65332a.a(R.id.wallet_loader));
                    a.C1317a aVar = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    a.C1317a.a((Context) this.f65332a, networkCustomError);
                    KycFlowActivity.b(this.f65332a);
                }
            }
        }

        public final void a() {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f65332a.a(R.id.wallet_loader));
        }
    }

    public static final /* synthetic */ void b(KycFlowActivity kycFlowActivity) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putSerializable("kyc_center_list", kycFlowActivity.j);
        hVar.setArguments(bundle);
        kycFlowActivity.a((Fragment) hVar);
    }

    public static final /* synthetic */ void c(KycFlowActivity kycFlowActivity) {
        s sVar = new s();
        Intent intent = kycFlowActivity.getIntent();
        k.a((Object) intent, "intent");
        sVar.setArguments(intent.getExtras());
        kycFlowActivity.a((Fragment) sVar);
    }
}
