package net.one97.paytm.recharge.dth;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.k.d;
import kotlin.k.e;
import kotlin.x;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeToolbarActivity;
import net.one97.paytm.recharge.common.h.d;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.dth.a.g;
import net.one97.paytm.recharge.legacy.catalog.fragment.FJRRechargeUtilityBaseV2;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;
import net.one97.paytm.recharge.model.v4.CJRCategoryDataHelper;
import net.one97.paytm.recharge.model.v4.CJRSelectedGroupItem;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class AJRDTHRechargeActivity extends CJRRechargeToolbarActivity implements FJRRechargeUtilityBaseV2.b {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.recharge.dth.c.a f62656a;

    public final void a() {
    }

    static final /* synthetic */ class b extends i implements q<String, NetworkCustomError, Object, x> {
        b(AJRDTHRechargeActivity aJRDTHRechargeActivity) {
            super(3, aJRDTHRechargeActivity);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final d getOwner() {
            return y.b(AJRDTHRechargeActivity.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }
    }

    public final void onCreate(Bundle bundle) {
        com.paytm.utility.b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_dth_recharge);
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            k.a((Object) window, "window");
            View decorView = window.getDecorView();
            k.a((Object) decorView, "window.decorView");
            decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(19);
        }
        Serializable serializable = getIntent().getBundleExtra("bundle_data").getSerializable("recharge_item");
        if (!(serializable instanceof CJRItem)) {
            serializable = null;
        }
        CJRItem cJRItem = (CJRItem) serializable;
        if (cJRItem != null) {
            w d2 = net.one97.paytm.recharge.common.b.d.d(this);
            d2.o = true;
            d.a a2 = new d.a(d.b.DTH).a(cJRItem);
            Context applicationContext = getApplicationContext();
            k.a((Object) applicationContext, "applicationContext");
            d.a a3 = a2.a(net.one97.paytm.recharge.common.b.d.b(applicationContext)).a((e<x>) new b(this)).a(d2);
            Context applicationContext2 = getApplicationContext();
            k.a((Object) applicationContext2, "this@AJRDTHRechargeActivity.applicationContext");
            net.one97.paytm.recharge.ordersummary.h.d dVar = new net.one97.paytm.recharge.ordersummary.h.d(applicationContext2);
            dVar.f64343a = cJRItem;
            ai a4 = am.a((FragmentActivity) this, (al.b) new net.one97.paytm.recharge.common.h.d(a3.a(dVar))).a(net.one97.paytm.recharge.dth.c.a.class);
            k.a((Object) a4, "ViewModelProviders.of(th…elFactory)[T::class.java]");
            net.one97.paytm.recharge.dth.c.a aVar = (net.one97.paytm.recharge.dth.c.a) a4;
            this.f62656a = aVar;
            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
            aVar.b("frequent_api", "DTH", net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
        }
        net.one97.paytm.recharge.dth.c.a aVar2 = this.f62656a;
        if (aVar2 == null) {
            k.a("viewModel");
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("category_data");
        if (!(serializableExtra instanceof CJRCategoryData)) {
            serializableExtra = null;
        }
        aVar2.O = (CJRCategoryData) serializableExtra;
        net.one97.paytm.recharge.dth.c.a aVar3 = this.f62656a;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        Serializable serializableExtra2 = getIntent().getSerializableExtra("selected_item");
        if (!(serializableExtra2 instanceof CJRSelectedGroupItem)) {
            serializableExtra2 = null;
        }
        aVar3.P = (CJRSelectedGroupItem) serializableExtra2;
        net.one97.paytm.recharge.dth.c.a aVar4 = this.f62656a;
        if (aVar4 == null) {
            k.a("viewModel");
        }
        aVar4.m.clear();
        Serializable serializableExtra3 = getIntent().getSerializableExtra("deeplink_data");
        if (!(serializableExtra3 instanceof HashMap)) {
            serializableExtra3 = null;
        }
        HashMap hashMap = (HashMap) serializableExtra3;
        if (hashMap != null) {
            net.one97.paytm.recharge.dth.c.a aVar5 = this.f62656a;
            if (aVar5 == null) {
                k.a("viewModel");
            }
            aVar5.m.putAll(hashMap);
        }
        net.one97.paytm.recharge.dth.c.a aVar6 = this.f62656a;
        if (aVar6 == null) {
            k.a("viewModel");
        }
        CJRCategoryDataHelper cJRCategoryDataHelper = aVar6.f61409b;
        net.one97.paytm.recharge.dth.c.a aVar7 = this.f62656a;
        if (aVar7 == null) {
            k.a("viewModel");
        }
        cJRCategoryDataHelper.setCategoryData(aVar7.O);
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            androidx.fragment.app.q a5 = supportFragmentManager.a();
            int i2 = R.id.lyt_container;
            g.a aVar8 = g.v;
            Bundle bundleExtra = getIntent().getBundleExtra("bundle_data");
            k.a((Object) bundleExtra, "intent.getBundleExtra(CJ…lityConstant.BUNDLE_DATA)");
            a5.a(i2, (Fragment) g.a.a(bundleExtra)).a((Runnable) new a(this)).b();
        }
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Context context = this;
            StringBuilder sb = new StringBuilder("/");
            net.one97.paytm.recharge.dth.c.a aVar9 = this.f62656a;
            if (aVar9 == null) {
                k.a("viewModel");
            }
            sb.append(aVar9.b());
            sb.append("/amount");
            net.one97.paytm.recharge.di.helper.b.a(context, sb.toString());
        } catch (Throwable unused) {
        }
    }

    public final int m() {
        return R.style.Recharge_NoTitle;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            b(false);
            this.t.a();
        } else if (!r()) {
            b(true);
            this.t.a(str);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRDTHRechargeActivity f62657a;

        a(AJRDTHRechargeActivity aJRDTHRechargeActivity) {
            this.f62657a = aJRDTHRechargeActivity;
        }

        public final void run() {
            this.f62657a.al_();
        }
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public final void onDestroy() {
        q();
        super.onDestroy();
    }

    public final void onBackPressed() {
        q();
        super.onBackPressed();
    }

    public final void onPause() {
        q();
        super.onPause();
    }
}
