package net.one97.paytm.p2mNewDesign.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.g;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.common.widgets.IndexFastScrollRecyclerView;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchNBResponse;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.b;
import net.one97.paytm.p2mNewDesign.f.d;
import net.one97.paytm.wallet.R;
import org.json.JSONException;
import org.json.JSONObject;

public class NetBankingListActivity extends AppCompatLockActivity implements d {

    /* renamed from: e  reason: collision with root package name */
    private static final String f13195e = NetBankingListActivity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private List<InstrumentInfo> f13196f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public IndexFastScrollRecyclerView f13197g;

    /* renamed from: h  reason: collision with root package name */
    private SearchView f13198h;

    /* renamed from: i  reason: collision with root package name */
    private List<InstrumentInfo> f13199i;
    private List<b> j = new ArrayList();
    /* access modifiers changed from: private */
    public net.one97.paytm.p2mNewDesign.a.a k;
    private boolean l;
    private LinearLayout m;
    /* access modifiers changed from: private */
    public TextView n;
    private String o;
    private ProgressBar p;
    private ImageView q;

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.wallet.communicator.b.a().wrapContextByRestring(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = getIntent().getBooleanExtra("ADD_AND_PAY", false);
        setContentView(R.layout.lyt_netbanking_bank_list);
        this.m = (LinearLayout) findViewById(R.id.list_empty_layout_container);
        this.p = (ProgressBar) findViewById(R.id.pb_progress);
        this.f13197g = (IndexFastScrollRecyclerView) findViewById(R.id.rv_bank_list);
        this.f13198h = (SearchView) findViewById(R.id.searchView);
        this.n = (TextView) findViewById(R.id.tv_toolbar_title);
        this.q = (ImageView) findViewById(R.id.iv_back_arrow);
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                NetBankingListActivity.this.finish();
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(StringSet.token, com.paytm.utility.a.q(this));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put("version", net.one97.paytm.wallet.communicator.b.a().getVersionName());
            jSONObject2.put("channelId", "WEB");
            jSONObject3.put("mid", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e);
            jSONObject3.put("type", "MERCHANT");
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException unused) {
        }
        this.o = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this, "offlinepg_nb_url_v2") + "?mid=" + net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e;
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(this.o, new CJRFetchNBResponse(), (Map<String, String>) null, hashMap, jSONObject.toString());
        if (com.paytm.utility.b.c((Context) this)) {
            bVar.c().observeForever(new z() {
                public final void onChanged(Object obj) {
                    NetBankingListActivity.this.a((f) obj);
                }
            });
        } else {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13086b = "";
        }
    }

    public final void a() {
        this.f51786a = 102;
    }

    private void e() {
        TreeMap treeMap = new TreeMap();
        for (InstrumentInfo next : this.f13199i) {
            StringBuilder sb = new StringBuilder();
            sb.append(next.getDisplaySecondaryInfo().charAt(0));
            if (treeMap.containsKey(sb.toString())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(next.getDisplaySecondaryInfo().charAt(0));
                ((List) treeMap.get(sb2.toString())).add(next);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(next.getDisplaySecondaryInfo().charAt(0));
                treeMap.put(sb3.toString(), arrayList);
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            this.j.add(new b(true, (InstrumentInfo) null, (String) entry.getKey()));
            for (InstrumentInfo bVar : (List) entry.getValue()) {
                this.j.add(new b(false, bVar, ""));
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

    public final void c() {
        this.m.setVisibility(0);
    }

    public final void d() {
        this.m.setVisibility(8);
    }

    public final void a(InstrumentInfo instrumentInfo) {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(instrumentInfo);
        try {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
        setResult(-1);
        finish();
    }

    class a implements Comparator<InstrumentInfo> {
        a() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((InstrumentInfo) obj).getDisplaySecondaryInfo().compareTo(((InstrumentInfo) obj2).getDisplaySecondaryInfo());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar) {
        List<InstrumentInfo> list;
        if (fVar.f55796a == h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            if (iJRPaytmDataModel instanceof CJRFetchNBResponse) {
                this.p.setVisibility(8);
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((Context) this, (CJRFetchNBResponse) iJRPaytmDataModel);
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                if (!this.l) {
                    list = f2.s;
                } else {
                    list = f2.t;
                }
                this.f13196f = list;
                this.f13199i = new ArrayList();
                List<InstrumentInfo> list2 = this.f13196f;
                if (list2 != null) {
                    for (InstrumentInfo next : list2) {
                        if (next.getDisplaySecondaryInfo() != null) {
                            this.f13199i.add(next);
                        }
                    }
                }
                Collections.sort(this.f13199i, new a());
                e();
                String str = null;
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase("NET_BANKING")) {
                    str = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplaySecondaryInfo();
                }
                this.f13197g.setLayoutManager(new LinearLayoutManager(this));
                this.f13197g.setItemAnimator(new g());
                List<b> list3 = this.j;
                if (list3 == null || list3.size() <= 0) {
                    c();
                } else {
                    this.k = new net.one97.paytm.p2mNewDesign.a.a(this, this.j, this, str);
                }
                this.f13197g.setAdapter(this.k);
                this.f13197g.setIndexTextSize(10);
                this.f13197g.setIndexBarColor("#FFFFFF");
                this.f13197g.setIndexBarCornerRadius(0);
                this.f13197g.setTypeface(Typeface.SANS_SERIF);
                this.f13197g.setIndexbarMargin(0.0f);
                this.f13197g.setIndexbarWidth(40.0f);
                this.f13197g.setPreviewPadding(0);
                this.f13197g.setIndexBarTextColor("#999999");
                this.f13197g.setIndexBarVisibility(true);
                this.f13197g.setIndexBarHighLateTextVisibility(true);
                this.f13198h.setOnCloseListener(new SearchView.a() {
                    public final boolean a() {
                        NetBankingListActivity.this.n.setVisibility(0);
                        NetBankingListActivity.this.f13197g.setIndexBarVisibility(true);
                        NetBankingListActivity.this.f13197g.invalidate();
                        return false;
                    }
                });
                this.f13198h.setOnSearchClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        NetBankingListActivity.this.n.setVisibility(8);
                        NetBankingListActivity.this.f13197g.setIndexBarHighLateTextVisibility(false);
                        NetBankingListActivity.this.f13197g.setIndexBarVisibility(false);
                        NetBankingListActivity.this.f13197g.invalidate();
                    }
                });
                this.f13198h.setOnQueryTextListener(new SearchView.b() {
                    public final boolean a(String str) {
                        return false;
                    }

                    public final boolean b(String str) {
                        if (NetBankingListActivity.this.k == null) {
                            return true;
                        }
                        NetBankingListActivity.this.k.getFilter().filter(str);
                        return true;
                    }
                });
            }
        } else if (fVar.f55796a == h.ERROR) {
            this.p.setVisibility(8);
        }
    }
}
