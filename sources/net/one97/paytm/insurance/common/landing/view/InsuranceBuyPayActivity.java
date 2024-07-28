package net.one97.paytm.insurance.common.landing.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.GAUtil;
import common.landing.b.a;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.activities.InsuranceBaseActivity;
import net.one97.paytm.insurance.b.c;

public final class InsuranceBuyPayActivity extends InsuranceBaseActivity implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private common.landing.a.a f14020a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f14021b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f14022c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f14023d;

    /* renamed from: e  reason: collision with root package name */
    private a.C0181a f14024e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f14025f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f14026g;

    public final View a(int i2) {
        if (this.f14026g == null) {
            this.f14026g = new HashMap();
        }
        View view = (View) this.f14026g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f14026g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_buy_pay);
        defpackage.a aVar = defpackage.a.f13404a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        this.f14024e = new common.landing.d.a(defpackage.a.b(applicationContext), this);
        a.C0181a aVar2 = this.f14024e;
        if (aVar2 == null) {
            k.a("mPresenter");
        }
        Context context = this;
        this.f14020a = new common.landing.a.a(aVar2, context);
        this.f14021b = (RecyclerView) findViewById(R.id.rvBuyPayOptionList);
        this.f14022c = (TextView) findViewById(R.id.tvSubHeading);
        this.f14023d = (TextView) findViewById(R.id.tvHeading);
        if (com.paytm.utility.b.c(context)) {
            a.C0181a aVar3 = this.f14024e;
            if (aVar3 == null) {
                k.a("mPresenter");
            }
            aVar3.a();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(getResources().getString(R.string.ins_no_connection));
            builder.setMessage(getResources().getString(R.string.ins_no_internet));
            builder.setPositiveButton(getResources().getString(R.string.ins_ok), new a(this));
            if (!isFinishing()) {
                builder.show();
            }
        }
        this.f14025f = (ImageView) findViewById(R.id.ivBackBtn);
        ImageView imageView = this.f14025f;
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
        RecyclerView recyclerView = this.f14021b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    static final class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceBuyPayActivity f14027a;

        a(InsuranceBuyPayActivity insuranceBuyPayActivity) {
            this.f14027a = insuranceBuyPayActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            this.f14027a.finish();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InsuranceBuyPayActivity f14028a;

        b(InsuranceBuyPayActivity insuranceBuyPayActivity) {
            this.f14028a = insuranceBuyPayActivity;
        }

        public final void onClick(View view) {
            this.f14028a.finish();
        }
    }

    public final void a(InsuranceBuyPayOptionModel insuranceBuyPayOptionModel) {
        String deeplink = insuranceBuyPayOptionModel != null ? insuranceBuyPayOptionModel.getDeeplink() : null;
        Boolean valueOf = deeplink != null ? Boolean.valueOf(p.a((CharSequence) deeplink, (CharSequence) "paytm.com", false)) : null;
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.booleanValue()) {
            c.a().handleDeepLink(this, deeplink, (Bundle) null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_internal_flow", true);
        c.a().handleDeepLink(this, deeplink, bundle);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "insurance_home");
            hashMap.put("event_action", "buypolicy_selected");
            hashMap.put("vertical_name", "Insurance");
            if (com.paytm.utility.b.r((Context) this)) {
                String n = com.paytm.utility.b.n((Context) this);
                k.a((Object) n, "CJRAppCommonUtility.getUserId(this)");
                hashMap.put("user_id", n);
            }
            c.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.printStackTrace();
            }
        }
    }

    public final void a() {
        a.C0181a aVar = this.f14024e;
        if (aVar == null) {
            k.a("mPresenter");
        }
        this.f14020a = new common.landing.a.a(aVar, this);
        RecyclerView recyclerView = this.f14021b;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f14020a);
        }
    }

    public final void a(boolean z) {
        if (z) {
            String string = getString(R.string.please_wait);
            k.a((Object) string, "getString(R.string.please_wait)");
            a(this, string);
            return;
        }
        d();
    }

    public final void a(String str) {
        TextView textView = this.f14022c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void b(String str) {
        TextView textView = this.f14023d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r1 = r9.getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.NetworkCustomError r9) {
        /*
            r8 = this;
            r0 = 0
            r8.a((boolean) r0)
            r0 = 1
            if (r9 == 0) goto L_0x0019
            java.lang.String r1 = r9.getMessage()
            if (r1 == 0) goto L_0x0019
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "401"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r0)
            if (r1 == r0) goto L_0x0039
        L_0x0019:
            if (r9 == 0) goto L_0x0030
            java.lang.String r1 = r9.getMessage()
            if (r1 == 0) goto L_0x0030
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "410"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0055
        L_0x0039:
            net.one97.paytm.insurance.a.a r0 = net.one97.paytm.insurance.b.c.a()
            java.lang.String r1 = "InsuranceHelper.getInsuranceListener()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r5 = r0.getLandingActivityClassName()
            net.one97.paytm.insurance.a.a r2 = net.one97.paytm.insurance.b.c.a()
            r3 = r8
            android.app.Activity r3 = (android.app.Activity) r3
            r6 = 0
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r4 = r9
            r2.handleError(r3, r4, r5, r6, r7)
            goto L_0x0063
        L_0x0055:
            r9 = r8
            android.content.Context r9 = (android.content.Context) r9
            int r0 = net.one97.paytm.insurance.R.string.oops_something_went_wrong
            java.lang.String r0 = r8.getString(r0)
            java.lang.String r1 = "Error"
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r1, (java.lang.String) r0)
        L_0x0063:
            r8.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.common.landing.view.InsuranceBuyPayActivity.a(com.paytm.network.model.NetworkCustomError):void");
    }

    public final void finish() {
        super.finish();
    }
}
