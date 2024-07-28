package net.one97.paytm.autoaddmoney.views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import com.paytm.network.a;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.newaddmoney.utils.e;

public final class AmAutomaticResultActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    public String f49307a;

    /* renamed from: b  reason: collision with root package name */
    public String f49308b;

    /* renamed from: c  reason: collision with root package name */
    public String f49309c;

    /* renamed from: d  reason: collision with root package name */
    public String f49310d;

    /* renamed from: e  reason: collision with root package name */
    private IJRDataModel f49311e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f49312f = Boolean.FALSE;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f49313g;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.am_result_activity);
        if (getSupportActionBar() != null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                k.a();
            }
            supportActionBar.f();
        }
        Activity activity = this;
        int i2 = R.id.iv_back_arrow;
        if (this.f49313g == null) {
            this.f49313g = new HashMap();
        }
        View view = (View) this.f49313g.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this.f49313g.put(Integer.valueOf(i2), view);
        }
        ImageView imageView = (ImageView) view;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        e.a(activity, net.one97.paytm.helper.a.f50546a.a().a("automatic_addmoney_home_url", "https://storefront.paytm.com/v2/h/post-txn-page-new"), new a(this), a.c.ADDMONEY.name());
        String stringExtra = getIntent().getStringExtra("min_amount");
        k.a((Object) stringExtra, "intent.getStringExtra(CJ…aramConstants.MIN_AMOUNT)");
        this.f49307a = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("auto_amount");
        k.a((Object) stringExtra2, "intent.getStringExtra(CJ…ramConstants.AUTO_AMOUNT)");
        this.f49308b = stringExtra2;
        this.f49312f = Boolean.valueOf(getIntent().getBooleanExtra("isTransactionOrSubscriptionFailed", false));
        if (getIntent().hasExtra(SDKConstants.STATUS)) {
            String stringExtra3 = getIntent().getStringExtra(SDKConstants.STATUS);
            k.a((Object) stringExtra3, "intent.getStringExtra(UtilsConstants.STATUS)");
            this.f49309c = stringExtra3;
        }
        if (getIntent().hasExtra("STATUS_MESSAGE")) {
            String stringExtra4 = getIntent().getStringExtra("STATUS_MESSAGE");
            k.a((Object) stringExtra4, "intent.getStringExtra(Ut…Constants.STATUS_MESSAGE)");
            this.f49310d = stringExtra4;
        }
        Bundle bundle2 = new Bundle();
        String str = this.f49307a;
        if (str == null) {
            k.a("mMinAmount");
        }
        bundle2.putString("min_amount", str);
        String str2 = this.f49308b;
        if (str2 == null) {
            k.a("mAutoAmount");
        }
        bundle2.putString("auto_amount", str2);
        String str3 = this.f49310d;
        if (str3 == null) {
            k.a("mStatusMessage");
        }
        bundle2.putString("STATUS_MESSAGE", str3);
        if (getIntent().hasExtra("SAVED_CARD") && getIntent().getSerializableExtra("SAVED_CARD") != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("SAVED_CARD");
            if (serializableExtra != null) {
                this.f49311e = (IJRDataModel) serializableExtra;
                bundle2.putSerializable("SAVED_CARD", this.f49311e);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.IJRDataModel");
            }
        }
        String str4 = this.f49309c;
        if (str4 == null) {
            k.a("mStatus");
        }
        if (str4.equals("SUCCESS")) {
            h hVar = new h();
            hVar.setArguments(bundle2);
            getSupportFragmentManager().a().b(R.id.framelayout, hVar).c();
            return;
        }
        Boolean bool = this.f49312f;
        if (bool == null) {
            k.a();
        }
        bundle2.putBoolean("isTransactionOrSubscriptionFailed", bool.booleanValue());
        f fVar = new f();
        fVar.setArguments(bundle2);
        getSupportFragmentManager().a().b(R.id.framelayout, fVar).c();
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(net.one97.paytm.helper.a.f50546a.a().a(context));
    }

    public final void onBackPressed() {
        finish();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticResultActivity f49315a;

        b(AmAutomaticResultActivity amAutomaticResultActivity) {
            this.f49315a = amAutomaticResultActivity;
        }

        public final void onClick(View view) {
            this.f49315a.onBackPressed();
        }
    }

    public static final class a implements net.one97.paytm.helper.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AmAutomaticResultActivity f49314a;

        a(AmAutomaticResultActivity amAutomaticResultActivity) {
            this.f49314a = amAutomaticResultActivity;
        }

        public final void onWidgetLoaded(SanitizedResponseModel sanitizedResponseModel) {
            if (sanitizedResponseModel != null) {
                AmAutomaticResultActivity.a(this.f49314a, sanitizedResponseModel.getSfWidgets(), sanitizedResponseModel.getGaListener());
            }
        }
    }

    public static final /* synthetic */ void a(AmAutomaticResultActivity amAutomaticResultActivity, LinkedHashMap linkedHashMap, StoreFrontGAHandler storeFrontGAHandler) {
        IWidgetProvider iWidgetProvider = (IWidgetProvider) linkedHashMap.get(104);
        SFWidget widget = iWidgetProvider != null ? iWidgetProvider.getWidget(amAutomaticResultActivity, storeFrontGAHandler) : null;
        if (widget instanceof IStaticWidget) {
            ((FrameLayout) amAutomaticResultActivity.findViewById(R.id.lyt_bottom_tab_bar)).addView(((IStaticWidget) widget).getView());
        }
    }
}
