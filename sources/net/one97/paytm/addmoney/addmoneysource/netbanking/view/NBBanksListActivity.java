package net.one97.paytm.addmoney.addmoneysource.netbanking.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.SectionWrapper;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.common.widgets.IndexFastScrollRecyclerView;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.newdesign.addmoney.c.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NBBanksListActivity extends PaytmActivity implements b, f {

    /* renamed from: a  reason: collision with root package name */
    private List<net.one97.paytm.addmoney.common.b> f48334a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public IndexFastScrollRecyclerView f48335b;

    /* renamed from: c  reason: collision with root package name */
    private SearchView f48336c;

    /* renamed from: d  reason: collision with root package name */
    private List<net.one97.paytm.addmoney.common.b> f48337d;

    /* renamed from: e  reason: collision with root package name */
    private List<SectionWrapper> f48338e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public a f48339f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f48340g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f48341h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f48342i;
    private String j;
    private ProgressBar k;
    private ImageView l;
    private String m;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.helper.a.b().a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = false;
        this.f48340g = getIntent().getBooleanExtra("ADD_AND_PAY", false);
        this.m = getIntent().getStringExtra("mid");
        setContentView(R.layout.layout_netbanking_addmoney);
        this.f48341h = (LinearLayout) findViewById(R.id.list_empty_layout_container);
        this.k = (ProgressBar) findViewById(R.id.pb_progress);
        this.f48335b = (IndexFastScrollRecyclerView) findViewById(R.id.rv_bank_list);
        this.f48336c = (SearchView) findViewById(R.id.searchView);
        this.f48342i = (TextView) findViewById(R.id.tv_toolbar_title);
        this.l = (ImageView) findViewById(R.id.iv_back_arrow);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NBBanksListActivity.this.finish();
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (androidx.core.app.a.a((Context) this, "android.permission.READ_PHONE_STATE") == 0) {
            z = true;
        }
        String A = z ? com.paytm.utility.b.A((Context) this) : "";
        String str = com.paytm.utility.b.v((Context) this) + System.currentTimeMillis();
        try {
            jSONObject2.put(com.paytm.utility.b.f43688a, net.one97.paytm.helper.a.b().f());
            jSONObject2.put(e.aT, this.m);
            jSONObject2.put(com.paytm.utility.b.f43690c, str);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(com.paytm.utility.b.f43691d, com.paytm.utility.a.q(this));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put(com.paytm.utility.b.f43692e, "1.0");
            jSONObject3.put(com.paytm.utility.b.f43693f, A);
            jSONObject3.put(com.paytm.utility.b.f43694g, "WEB");
            jSONObject3.put(com.paytm.utility.b.f43695h, SDKConstants.KEY_RETAIL);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("currency", "INR");
            jSONObject4.put("value", "100");
            jSONObject3.put(com.paytm.utility.b.f43696i, "100");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("NB");
            jSONObject3.put(com.paytm.utility.b.j, jSONArray);
            jSONObject3.put(com.paytm.utility.b.k, jSONArray);
            jSONObject3.put(com.paytm.utility.b.l, (Object) null);
            jSONObject3.put(com.paytm.utility.b.m, (Object) null);
            jSONObject3.put(com.paytm.utility.b.r, "123456");
            jSONObject.put(com.paytm.utility.b.n, jSONObject2);
            jSONObject.put(com.paytm.utility.b.o, jSONObject3);
        } catch (JSONException unused) {
        }
        this.j = net.one97.paytm.helper.a.b().f("fetch_offline_instrument_v2");
        com.paytm.network.b b2 = net.one97.paytm.addmoney.common.a.b();
        b2.f42880d = this.j;
        b2.f42877a = this;
        b2.f42884h = jSONObject.toString();
        b2.f42882f = hashMap;
        b2.f42885i = new CJPayMethodResponse();
        b2.j = this;
        b2.o = getClass().getSimpleName();
        com.paytm.network.a l2 = b2.l();
        if (com.paytm.utility.b.c(getApplicationContext())) {
            l2.a();
        } else {
            net.one97.paytm.helper.a.b().e("");
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        List<net.one97.paytm.addmoney.common.b> list;
        if (iJRPaytmDataModel instanceof CJPayMethodResponse) {
            this.k.setVisibility(8);
            CJPayMethodResponse cJPayMethodResponse = (CJPayMethodResponse) iJRPaytmDataModel;
            g a2 = g.a();
            a2.a(this, false, g.a(cJPayMethodResponse, "MERCHANT_SAVED"), "MERCHANT_SAVED");
            a2.a(this, false, g.a(cJPayMethodResponse, "ADD_MONEY_SAVED"), "ADD_MONEY_SAVED");
            g a3 = g.a();
            if (!this.f48340g) {
                list = a3.j;
            } else {
                list = a3.k;
            }
            this.f48334a = list;
            this.f48337d = new ArrayList();
            List<net.one97.paytm.addmoney.common.b> list2 = this.f48334a;
            if (list2 != null) {
                for (net.one97.paytm.addmoney.common.b next : list2) {
                    if (next.f48420b != null) {
                        this.f48337d.add(next);
                    }
                }
            }
            Collections.sort(this.f48337d, new a());
            c();
            this.f48335b.setLayoutManager(new LinearLayoutManager(this));
            this.f48335b.setItemAnimator(new androidx.recyclerview.widget.g());
            List<SectionWrapper> list3 = this.f48338e;
            if (list3 != null) {
                this.f48339f = new a(this, list3, this);
            }
            this.f48335b.setAdapter(this.f48339f);
            this.f48335b.setIndexTextSize(10);
            this.f48335b.setIndexBarColor("#FFFFFF");
            this.f48335b.setIndexBarCornerRadius(0);
            this.f48335b.setTypeface(Typeface.SANS_SERIF);
            this.f48335b.setIndexbarMargin(0.0f);
            this.f48335b.setIndexbarWidth(40.0f);
            this.f48335b.setPreviewPadding(0);
            this.f48335b.setIndexBarTextColor("#999999");
            this.f48335b.setIndexBarVisibility(true);
            this.f48335b.setIndexBarHighLateTextVisibility(true);
            this.f48336c.setOnCloseListener(new SearchView.a() {
                public final boolean a() {
                    NBBanksListActivity.this.f48342i.setVisibility(0);
                    NBBanksListActivity.this.f48335b.setIndexBarVisibility(true);
                    NBBanksListActivity.this.f48335b.invalidate();
                    return false;
                }
            });
            this.f48336c.setOnSearchClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    NBBanksListActivity.this.f48342i.setVisibility(8);
                    NBBanksListActivity.this.f48335b.setIndexBarHighLateTextVisibility(false);
                    NBBanksListActivity.this.f48335b.setIndexBarVisibility(false);
                    NBBanksListActivity.this.f48335b.invalidate();
                }
            });
            this.f48336c.setOnQueryTextListener(new SearchView.b() {
                public final boolean a(String str) {
                    return false;
                }

                public final boolean b(String str) {
                    if (NBBanksListActivity.this.f48339f == null) {
                        return true;
                    }
                    NBBanksListActivity.this.f48339f.getFilter().filter(str);
                    return true;
                }
            });
        }
    }

    private void c() {
        TreeMap treeMap = new TreeMap();
        for (net.one97.paytm.addmoney.common.b next : this.f48337d) {
            StringBuilder sb = new StringBuilder();
            sb.append(next.f48420b.charAt(0));
            if (treeMap.containsKey(sb.toString())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(next.f48420b.charAt(0));
                ((List) treeMap.get(sb2.toString())).add(next);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(next.f48420b.charAt(0));
                treeMap.put(sb3.toString(), arrayList);
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            this.f48338e.add(new SectionWrapper(true, (net.one97.paytm.addmoney.common.b) null, (String) entry.getKey()));
            for (net.one97.paytm.addmoney.common.b sectionWrapper : (List) entry.getValue()) {
                this.f48338e.add(new SectionWrapper(false, sectionWrapper, ""));
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == i3) {
            finish();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.k.setVisibility(8);
        if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getMessage()) || !"401,403,410".contains(networkCustomError.getMessage())) {
            if (networkCustomError != null && networkCustomError.networkResponse != null) {
                if (!(networkCustomError.networkResponse.statusCode == 403 || networkCustomError.networkResponse.statusCode == 401)) {
                    return;
                }
            } else {
                return;
            }
        }
        net.one97.paytm.helper.a.b().a((Activity) this, NBBanksListActivity.class.getCanonicalName(), (Bundle) null);
    }

    public final void a() {
        this.f48341h.setVisibility(0);
    }

    public final void b() {
        this.f48341h.setVisibility(8);
    }

    public final void a(net.one97.paytm.addmoney.common.b bVar) {
        g.a().f48979f = bVar;
        setResult(-1);
        finish();
    }

    class a implements Comparator<net.one97.paytm.addmoney.common.b> {
        a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((net.one97.paytm.addmoney.common.b) obj).f48420b.compareTo(((net.one97.paytm.addmoney.common.b) obj2).f48420b);
        }
    }

    public void onPause() {
        super.onPause();
    }
}
