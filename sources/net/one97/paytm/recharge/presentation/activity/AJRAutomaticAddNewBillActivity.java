package net.one97.paytm.recharge.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.y;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.a.a.b;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.b.a.d;
import net.one97.paytm.recharge.automatic.b.a.f;
import net.one97.paytm.recharge.domain.entities.CJRABCHLItems;
import net.one97.paytm.recharge.domain.entities.CJRABCHLItemsKt;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse;
import net.one97.paytm.recharge.presentation.a.a;
import net.one97.paytm.recharge.presentation.g.a;

public final class AJRAutomaticAddNewBillActivity extends PaytmActivity implements View.OnClickListener, a.C1273a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64627a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private long f64628b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<CJRABCHLItems> f64629c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.recharge.presentation.a.a f64630d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f64631e;

    private View a(int i2) {
        if (this.f64631e == null) {
            this.f64631e = new HashMap();
        }
        View view = (View) this.f64631e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f64631e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class c extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRAutomaticBillCategoriesResponse>, x> {
        final /* synthetic */ AJRAutomaticAddNewBillActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AJRAutomaticAddNewBillActivity aJRAutomaticAddNewBillActivity) {
            super(1);
            this.this$0 = aJRAutomaticAddNewBillActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRAutomaticBillCategoriesResponse>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
            r3 = r3.get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse> r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L_0x003a
                net.one97.paytm.recharge.presentation.g.c r0 = r3.f64955c
                int[] r1 = net.one97.paytm.recharge.presentation.activity.a.f64711a
                int r0 = r0.ordinal()
                r0 = r1[r0]
                r1 = 1
                if (r0 == r1) goto L_0x0010
                goto L_0x0015
            L_0x0010:
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity r0 = r2.this$0
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity.a((net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity) r0)
            L_0x0015:
                T r3 = r3.f64954b
                net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse r3 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse) r3
                if (r3 == 0) goto L_0x003a
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity r0 = r2.this$0
                java.util.List r3 = r3.getHomepageLayouts()
                if (r3 == 0) goto L_0x0031
                r1 = 0
                java.lang.Object r3 = r3.get(r1)
                net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesHomepageLayout r3 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesHomepageLayout) r3
                if (r3 == 0) goto L_0x0031
                java.util.List r3 = r3.getItems()
                goto L_0x0032
            L_0x0031:
                r3 = 0
            L_0x0032:
                r0.f64629c = r3
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity r3 = r2.this$0
                net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity.a((net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity) r3)
            L_0x003a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.activity.AJRAutomaticAddNewBillActivity.c.invoke(net.one97.paytm.recharge.presentation.g.b):void");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(Integer num) {
        ShimmerFrameLayout shimmerFrameLayout;
        String str;
        String urlType$recharge_automatic_release;
        if (num != null && (shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmerLayout)) != null && (!shimmerFrameLayout.c())) {
            List<CJRABCHLItems> list = this.f64629c;
            CJRHomePageItem cJRHomePageItem = null;
            CJRABCHLItems cJRABCHLItems = list != null ? list.get(num.intValue()) : null;
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            if (cJRABCHLItems == null || (urlType$recharge_automatic_release = cJRABCHLItems.getUrlType$recharge_automatic_release()) == null) {
                str = null;
            } else if (urlType$recharge_automatic_release != null) {
                str = urlType$recharge_automatic_release.toLowerCase();
                k.a((Object) str, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppManagerUtil.EXTEND_TYPE, cJRABCHLItems != null ? cJRABCHLItems.getUrlType$recharge_automatic_release() : null);
            bundle.putString("url", cJRABCHLItems != null ? cJRABCHLItems.getUrl$recharge_automatic_release() : null);
            if (cJRABCHLItems != null) {
                cJRHomePageItem = CJRABCHLItemsKt.createRechargeItem(cJRABCHLItems);
            }
            bundle.putSerializable("extra_home_data", cJRHomePageItem);
            bundle.putBoolean("open_activity_in_automatic_mode", true);
            bundle.putString("title", getString(R.string.atm_module_automatic_bill_payment_for_mobile));
            net.one97.paytm.recharge.automatic.c.a.a.a(str, bundle, (Context) this);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.revamp_automatic_add_new_bill);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.b(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.a(0.0f);
        }
        setTitle("");
        TextView textView = (TextView) a(R.id.tv_know_more_id);
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ai a2 = am.a((FragmentActivity) this, (al.b) new net.one97.paytm.recharge.presentation.e.a()).a(net.one97.paytm.recharge.presentation.g.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ntsViewModel::class.java)");
        net.one97.paytm.recharge.presentation.g.a aVar = (net.one97.paytm.recharge.presentation.g.a) a2;
        Context context = this;
        if (com.paytm.network.b.b.a(context)) {
            d.a(this, aVar.f64925b, new c(this));
            k.c(context, "context");
            aVar.f64925b.postValue(new net.one97.paytm.recharge.presentation.g.b((NetworkCustomError) null, null, net.one97.paytm.recharge.presentation.g.c.LOADING, (String) null));
            k.c(context, "context");
            k.c(context, "context");
            y a3 = y.a(new b.d(context));
            k.a((Object) a3, "Single.create { emitter …)\n            }\n        }");
            a3.b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new a.k(aVar));
        }
        net.one97.paytm.recharge.automatic.c.a.a aVar2 = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
        a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
        net.one97.paytm.recharge.automatic.c.a.a.a(context, net.one97.paytm.recharge.automatic.b.a.a.V);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRAutomaticAddNewBillActivity f64632a;

        b(AJRAutomaticAddNewBillActivity aJRAutomaticAddNewBillActivity) {
            this.f64632a = aJRAutomaticAddNewBillActivity;
        }

        public final void run() {
            this.f64632a.a();
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        net.one97.paytm.recharge.presentation.a.a aVar = this.f64630d;
        if (aVar != null) {
            aVar.f64563a = this.f64629c;
        }
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmerLayout);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.b();
        }
        net.one97.paytm.recharge.presentation.a.a aVar2 = this.f64630d;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.tv_know_more_id;
        if (valueOf != null && valueOf.intValue() == i2) {
            startActivity(new Intent(this, AJRAutomaticPaymentKnowMore.class));
        }
    }

    public static final /* synthetic */ void a(AJRAutomaticAddNewBillActivity aJRAutomaticAddNewBillActivity) {
        ViewFlipper viewFlipper = (ViewFlipper) aJRAutomaticAddNewBillActivity.a(R.id.vf_add_new_bill);
        if (viewFlipper != null) {
            viewFlipper.setDisplayedChild(0);
        }
        if (aJRAutomaticAddNewBillActivity.f64630d == null || aJRAutomaticAddNewBillActivity.f64629c == null) {
            Context context = aJRAutomaticAddNewBillActivity;
            aJRAutomaticAddNewBillActivity.f64630d = new net.one97.paytm.recharge.presentation.a.a(context, aJRAutomaticAddNewBillActivity.f64629c, aJRAutomaticAddNewBillActivity);
            RecyclerView recyclerView = (RecyclerView) aJRAutomaticAddNewBillActivity.a(R.id.rv_add_new_bill);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
            }
            ((RecyclerView) aJRAutomaticAddNewBillActivity.a(R.id.rv_add_new_bill)).addItemDecoration(new f());
            RecyclerView recyclerView2 = (RecyclerView) aJRAutomaticAddNewBillActivity.a(R.id.rv_add_new_bill);
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(aJRAutomaticAddNewBillActivity.f64630d);
            }
            net.one97.paytm.recharge.presentation.a.a aVar = aJRAutomaticAddNewBillActivity.f64630d;
            if (aVar != null) {
                aVar.f64563a = aJRAutomaticAddNewBillActivity.f64629c;
            }
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aJRAutomaticAddNewBillActivity.a(R.id.shimmerLayout);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
            aJRAutomaticAddNewBillActivity.f64628b = new Date().getTime();
            net.one97.paytm.recharge.presentation.a.a aVar2 = aJRAutomaticAddNewBillActivity.f64630d;
            if (aVar2 != null) {
                aVar2.notifyDataSetChanged();
                return;
            }
            return;
        }
        long time = new Date().getTime() - aJRAutomaticAddNewBillActivity.f64628b;
        if (time >= 1500) {
            aJRAutomaticAddNewBillActivity.a();
            return;
        }
        new Handler().postDelayed(new b(aJRAutomaticAddNewBillActivity), 1500 - time);
    }
}
