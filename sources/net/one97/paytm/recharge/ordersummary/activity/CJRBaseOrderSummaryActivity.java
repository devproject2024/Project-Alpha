package net.one97.paytm.recharge.ordersummary.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.m;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ax;
import net.one97.paytm.recharge.common.utils.j;
import net.one97.paytm.recharge.common.utils.y;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.ordersummary.f.h;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class CJRBaseOrderSummaryActivity extends CJRRechargeBaseActivity implements m, ai, h {

    /* renamed from: a  reason: collision with root package name */
    private j f63988a;

    /* renamed from: b  reason: collision with root package name */
    private String f63989b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f63990c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f63991d;

    /* renamed from: e  reason: collision with root package name */
    CJROrderSummary f63992e;

    /* renamed from: f  reason: collision with root package name */
    String f63993f;

    /* renamed from: g  reason: collision with root package name */
    boolean f63994g;

    public final void a() {
    }

    public void a(CJROrderedCart cJROrderedCart, boolean z, boolean z2) {
        k.c(cJROrderedCart, "orderedList");
    }

    public View c(int i2) {
        if (this.f63991d == null) {
            this.f63991d = new HashMap();
        }
        View view = (View) this.f63991d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63991d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void d() {
    }

    public void dismiss() {
    }

    public void show() {
    }

    public void onCreate(Bundle bundle) {
        String id;
        setTheme(R.style.WhiteStatusBarTheme);
        super.onCreate(bundle);
        this.f63993f = getIntent().getStringExtra(UpiConstants.FROM);
        this.f63989b = getIntent().getStringExtra("order_id");
        y yVar = y.f61814b;
        if (y.f() != null) {
            y yVar2 = y.f61814b;
            CJROrderSummary f2 = y.f();
            y yVar3 = y.f61814b;
            y.a((CJROrderSummary) null);
            if (f2 != null && (id = f2.getId()) != null && p.a(id, this.f63989b, true)) {
                this.f63992e = f2;
            }
        }
    }

    public final void b(String str, CJRRechargeErrorModel cJRRechargeErrorModel) {
        k.c(str, "orderId");
        k.c(cJRRechargeErrorModel, "hawkEyeModel");
        this.f63994g = true;
        a(str, cJRRechargeErrorModel);
    }

    public void a(String str, CJRRechargeErrorModel cJRRechargeErrorModel) {
        String str2;
        String stringExtra;
        k.c(str, "orderId");
        k.c(cJRRechargeErrorModel, "hawkEyeModel");
        c cVar = c.f62654a;
        String a2 = c.a(str);
        if (a2 == null) {
            a2 = "";
        }
        if (TextUtils.isEmpty(a2)) {
            w();
            return;
        }
        Context context = this;
        if (!TextUtils.isEmpty(CJRRechargeUtilities.INSTANCE.getSSOToken(context))) {
            String b2 = com.paytm.utility.c.b(a2, context);
            k.a((Object) b2, "CJRDefaultRequestParam.g…tailWithoutSSO(url, this)");
            if (TextUtils.isEmpty(this.f63993f) || (!p.a(this.f63993f, "Payment", true) && !p.a(this.f63993f, "paytm_automatic", true))) {
                str2 = b2 + "&actions=1";
            } else {
                str2 = b2 + "&actions=1";
            }
            if (!(getIntent() == null || (stringExtra = getIntent().getStringExtra("pg_screen")) == null)) {
                str2 = str2 + "&pg_screen=" + stringExtra;
            }
            String str3 = str2;
            Map hashMap = new HashMap();
            String a3 = d.a(context);
            k.a((Object) a3, "CJRNetUtility.getSSOToken(this)");
            hashMap.put(AppConstants.SSO_TOKEN, a3);
            net.one97.paytm.recharge.common.f.b bVar = new net.one97.paytm.recharge.common.f.b("fetch_order_detail", str3, new b(this), new CJROrderSummary(), hashMap, cJRRechargeErrorModel);
            bVar.a("order_detail_request");
            net.one97.paytm.recharge.common.f.a aVar = bVar;
            if (com.paytm.utility.b.c(context)) {
                a(context, getString(R.string.please_wait_re));
                getApplicationContext();
                net.one97.paytm.recharge.common.f.d.a();
                net.one97.paytm.recharge.common.f.d.b(aVar);
            } else if (!isFinishing()) {
                a(aVar);
            }
        } else {
            a(a2, str);
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseOrderSummaryActivity f63996a;

        b(CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity) {
            this.f63996a = cJRBaseOrderSummaryActivity;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            this.f63996a.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            CJRBaseOrderSummaryActivity.a(this.f63996a);
            if (iJRPaytmDataModel instanceof CJROrderSummary) {
                this.f63996a.b((CJROrderSummary) iJRPaytmDataModel);
            }
        }
    }

    public final void b(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, Payload.RESPONSE);
        try {
            if (getIntent().hasExtra("intent_extra_wallet_paytm_assist_gtmevents")) {
                Serializable serializableExtra = getIntent().getSerializableExtra("intent_extra_wallet_paytm_assist_gtmevents");
                if (serializableExtra != null) {
                    net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                    net.one97.paytm.recharge.di.helper.b.a(this.f63992e, (net.one97.paytm.y) serializableExtra, this);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.PaytmAssistGAEventsData");
                }
            }
        } catch (Throwable unused) {
        }
        a(cJROrderSummary);
    }

    public void a(CJROrderSummary cJROrderSummary) {
        CJROrderSummary cJROrderSummary2;
        CJRAttributes attributes;
        CJRAttributes attributes2;
        CJRAttributes attributes3;
        CJRAttributes attributes4;
        k.c(cJROrderSummary, Payload.RESPONSE);
        this.f63992e = cJROrderSummary;
        try {
            if (this.f63992e != null && this.f63988a == null) {
                CJROrderSummary cJROrderSummary3 = this.f63992e;
                ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary3 != null ? cJROrderSummary3.getOrderedCartList() : null;
                if (orderedCartList == null) {
                    k.a();
                }
                CJROrderedCart cJROrderedCart = orderedCartList.get(0);
                if (cJROrderedCart != null && (cJROrderSummary2 = this.f63992e) != null && 2 == cJROrderSummary2.getOrderStatus() && "7".equals(cJROrderedCart.getItemStatus())) {
                    this.f63988a = new j(this);
                    CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
                    Long valueOf = productDetail != null ? Long.valueOf(productDetail.getId()) : null;
                    CJROrderSummaryProductDetail productDetail2 = cJROrderedCart.getProductDetail();
                    String operatorName = (productDetail2 == null || (attributes4 = productDetail2.getAttributes()) == null) ? null : attributes4.getOperatorName();
                    CJROrderSummaryProductDetail productDetail3 = cJROrderedCart.getProductDetail();
                    String service = (productDetail3 == null || (attributes3 = productDetail3.getAttributes()) == null) ? null : attributes3.getService();
                    CJROrderSummaryProductDetail productDetail4 = cJROrderedCart.getProductDetail();
                    String circle = (productDetail4 == null || (attributes2 = productDetail4.getAttributes()) == null) ? null : attributes2.getCircle();
                    CJROrderSummaryProductDetail productDetail5 = cJROrderedCart.getProductDetail();
                    String paytype = (productDetail5 == null || (attributes = productDetail5.getAttributes()) == null) ? null : attributes.getPaytype();
                    Map<String, String> rechargeConfiguration = cJROrderedCart.getRechargeConfiguration();
                    String str = rechargeConfiguration != null ? rechargeConfiguration.get("recharge_number") : null;
                    j jVar = this.f63988a;
                    if (jVar != null) {
                        jVar.a(valueOf, operatorName, str, service, circle, paytype);
                    }
                }
            }
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
            this.f63988a = null;
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "url");
        k.c(str2, "orderId");
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        Intent intent = new Intent(this, net.one97.paytm.recharge.di.helper.a.b());
        intent.putExtra("resultant activity", a((CJRRechargeCart) null).getName());
        Bundle bundle = new Bundle();
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrlType("order_summary");
        cJRHomePageItem.setUrl(str);
        bundle.putSerializable("extra_home_data", cJRHomePageItem);
        bundle.putString("order_id", str2);
        bundle.putString("origin", "deeplinking");
        intent.putExtra("resultant activity_bundle", bundle);
        startActivity(intent);
        finish();
    }

    public final void w() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.error));
        builder.setMessage(getResources().getString(R.string.msg_invalid_url)).setCancelable(false).setPositiveButton(getResources().getString(R.string.ok_re), new a(this));
        builder.create().show();
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRBaseOrderSummaryActivity f63995a;

        a(CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity) {
            this.f63995a = cJRBaseOrderSummaryActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f63995a.finish();
        }
    }

    public void onBackPressed() {
        if (TextUtils.isEmpty(this.f63993f) || ((!p.a(this.f63993f, "Payment", true) && !p.a(this.f63993f, "paytm_automatic", true)) || this.f63992e == null || this.f63990c)) {
            Intent intent = new Intent();
            intent.putExtra("extra_action_updated", false);
            setResult(-1, intent);
            finish();
            return;
        }
        this.f63990c = true;
        c(false);
        CJROrderSummary cJROrderSummary = this.f63992e;
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary != null ? cJROrderSummary.getOrderedCartList() : null;
        if (orderedCartList == null) {
            k.a();
        }
        CJROrderedCart cJROrderedCart = orderedCartList.get(0);
        k.a((Object) cJROrderedCart, "mOrderSummary?.orderedCartList!![0]");
        a(cJROrderedCart, false, true);
        finish();
    }

    public final void c(boolean z) {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        ax.a aVar = ax.f61521a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        cJRHomePageItem.setUrl(ax.a.a(applicationContext).b("home_url", "", true));
        net.one97.paytm.recharge.di.helper.a aVar2 = net.one97.paytm.recharge.di.helper.a.f62650a;
        Intent intent = new Intent(this, net.one97.paytm.recharge.di.helper.a.g());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        if (!TextUtils.isEmpty(this.f63993f) && p.a(this.f63993f, "Payment", true)) {
            intent.putExtra("Reset_fast_farward", true);
        }
        startActivity(intent);
        if (z) {
            finish();
        }
    }

    public Class<?> a(CJRRechargeCart cJRRechargeCart) {
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.a();
    }

    public Class<?> b(CJRRechargeCart cJRRechargeCart) {
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.e();
    }

    public void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        try {
            o();
        } catch (IllegalStateException unused) {
        }
        o();
        CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 0, obj, 52, (Object) null);
    }

    public static final /* synthetic */ void a(CJRBaseOrderSummaryActivity cJRBaseOrderSummaryActivity) {
        try {
            cJRBaseOrderSummaryActivity.o();
        } catch (IllegalStateException unused) {
        }
    }
}
