package common.landing.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.insurance.InsuranceBuyPayOptionModel;
import net.one97.paytm.common.entity.insurance.InsuranceCategoryModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.activities.InsuranceBaseActivity;
import net.one97.paytm.insurance.common.landing.a.a;

public final class CategorySelectionActivity extends InsuranceBaseActivity implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private common.landing.a.b f13503a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f13504b;

    /* renamed from: c  reason: collision with root package name */
    private a.C0193a f13505c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f13506d;

    /* renamed from: e  reason: collision with root package name */
    private Object f13507e;

    /* renamed from: f  reason: collision with root package name */
    private String f13508f;

    /* renamed from: g  reason: collision with root package name */
    private String f13509g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f13510h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f13511i;
    private Boolean j;
    private String k;
    private HashMap l;

    public final View a(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        ImageView imageView;
        super.onCreate(bundle);
        setContentView(R.layout.activity_category_selection);
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        if (intent.getExtras() != null) {
            Intent intent2 = getIntent();
            k.a((Object) intent2, "intent");
            this.j = Boolean.valueOf(intent2.getExtras().getBoolean("bundle_buy_flow"));
            Intent intent3 = getIntent();
            k.a((Object) intent3, "intent");
            this.f13511i = Boolean.valueOf(intent3.getExtras().getBoolean("isNativeInsuranceListing"));
            Intent intent4 = getIntent();
            k.a((Object) intent4, "intent");
            this.k = intent4.getExtras().getString("url_bundle_buy");
        }
        if (getIntent().getBundleExtra("resultant activity_bundle") != null) {
            Serializable serializable = getIntent().getBundleExtra("resultant activity_bundle").getSerializable("extra_home_data");
            if (!(serializable instanceof InsuranceBuyPayOptionModel)) {
                serializable = null;
            }
            this.f13507e = (InsuranceBuyPayOptionModel) serializable;
        } else {
            this.f13508f = getIntent().getStringExtra("id");
            this.f13509g = getIntent().getStringExtra("source");
            if (!TextUtils.isEmpty(this.f13508f) && !TextUtils.isEmpty(this.f13509g) && p.a("SE", this.f13509g, true)) {
                this.f13510h = Boolean.TRUE;
            }
        }
        defpackage.a aVar = defpackage.a.f13404a;
        Context context = this;
        this.f13505c = new net.one97.paytm.insurance.common.landing.b.a(defpackage.a.a(context), this);
        a.C0193a aVar2 = this.f13505c;
        if (aVar2 == null) {
            k.a("mPresenter");
        }
        this.f13503a = new common.landing.a.b(aVar2, context);
        this.f13504b = (RecyclerView) findViewById(R.id.rvCategoryList);
        this.f13506d = (ImageView) findViewById(R.id.ivBackBtn);
        if (k.a((Object) this.f13511i, (Object) Boolean.TRUE) && (imageView = this.f13506d) != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.f13506d;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new b(this));
        }
        if (!com.paytm.utility.b.c(context)) {
            e();
        } else if (k.a((Object) this.f13511i, (Object) Boolean.TRUE)) {
            a.C0193a aVar3 = this.f13505c;
            if (aVar3 == null) {
                k.a("mPresenter");
            }
            aVar3.a();
        }
        k.a((Object) this.f13510h, (Object) Boolean.TRUE);
        RecyclerView recyclerView = this.f13504b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CategorySelectionActivity f13513a;

        b(CategorySelectionActivity categorySelectionActivity) {
            this.f13513a = categorySelectionActivity;
        }

        public final void onClick(View view) {
            this.f13513a.finish();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    private final void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.ins_no_connection));
        builder.setMessage(getResources().getString(R.string.ins_no_internet));
        builder.setPositiveButton(getResources().getString(R.string.ins_ok), c.f13514a);
        builder.show();
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f13514a = new c();

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
        }
    }

    public final void a(InsuranceCategoryModel insuranceCategoryModel) {
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            Boolean bool = null;
            String url = insuranceCategoryModel != null ? insuranceCategoryModel.getUrl() : null;
            if (url != null) {
                bool = Boolean.valueOf(p.a((CharSequence) url, (CharSequence) "paytm.com", false));
            }
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue()) {
                CJRHomePageItem deeplinkDataItem = net.one97.paytm.insurance.b.c.a().getDeeplinkDataItem(context, url);
                if (deeplinkDataItem != null) {
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("extra_home_data", deeplinkDataItem);
                    hashMap.put("origin", "deeplinking");
                    net.one97.paytm.insurance.b.c.a().loadMallPage(context, deeplinkDataItem.getURLType(), hashMap);
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_internal_flow", true);
                if ((TextUtils.isEmpty(insuranceCategoryModel.getUrl()) || (!p.a((CharSequence) insuranceCategoryModel.getUrl(), (CharSequence) "fillnbuyins", true) && !p.a((CharSequence) insuranceCategoryModel.getUrl(), (CharSequence) "fillandbuyins", true))) && !p.a((CharSequence) insuranceCategoryModel.getUrl(), (CharSequence) "fillnbuyreact", true)) {
                    net.one97.paytm.insurance.b.c.a().handleDeepLink(context, insuranceCategoryModel.getUrl(), bundle);
                } else {
                    net.one97.paytm.insurance.a.a a2 = net.one97.paytm.insurance.b.c.a();
                    a2.handleDeepLink(context, insuranceCategoryModel.getUrl() + "?insurance_type=" + insuranceCategoryModel.getInsurance_type(), bundle);
                    f.a.a aVar = f.a.a.f13515a;
                    f.a.a.a(Integer.valueOf(Integer.parseInt(insuranceCategoryModel.getInsurance_type())));
                }
            }
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event_category", "buy_insurance");
                hashMap2.put("event_action", "insurance_subvertical_dropdown_item_selected");
                hashMap2.put("vertical_name", "Insurance");
                hashMap2.put("event_label2", insuranceCategoryModel.getTitle());
                if (com.paytm.utility.b.r((Context) this)) {
                    String n = com.paytm.utility.b.n((Context) this);
                    k.a((Object) n, "CJRAppCommonUtility.getUserId(this)");
                    hashMap2.put("user_id", n);
                }
                net.one97.paytm.insurance.b.c.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap2, this);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        } else {
            e();
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

    public final void a() {
        a.C0193a aVar = this.f13505c;
        if (aVar == null) {
            k.a("mPresenter");
        }
        this.f13503a = new common.landing.a.b(aVar, this);
        RecyclerView recyclerView = this.f13504b;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f13503a);
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        finish();
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
            android.os.Handler r9 = new android.os.Handler
            r9.<init>()
            common.landing.view.CategorySelectionActivity$a r0 = new common.landing.view.CategorySelectionActivity$a
            r0.<init>(r8)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r9.post(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: common.landing.view.CategorySelectionActivity.a(com.paytm.network.model.NetworkCustomError):void");
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CategorySelectionActivity f13512a;

        a(CategorySelectionActivity categorySelectionActivity) {
            this.f13512a = categorySelectionActivity;
        }

        public final void run() {
            this.f13512a.finish();
        }
    }

    public final void a(String str) {
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = (TextView) a(R.id.tvTitle);
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        TextView textView2 = (TextView) a(R.id.tvTitle);
        if (textView2 != null) {
            textView2.setText(getString(R.string.label_select_insurance_category));
        }
    }

    public final Boolean b() {
        return this.j;
    }

    public final String c() {
        return this.k;
    }

    public final void finish() {
        super.finish();
    }
}
