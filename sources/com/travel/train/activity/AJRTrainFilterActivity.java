package com.travel.train.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.ac;
import com.travel.train.b.ad;
import com.travel.train.i.q;
import com.travel.train.j.g;
import com.travel.train.j.j;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainFilterItem;
import com.travel.train.model.trainticket.CJRTrainFilterModel;
import com.travel.train.model.trainticket.CJRTrainFilters;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.orflow.Utility;

public class AJRTrainFilterActivity extends CJRTrainBaseActivity implements View.OnClickListener, q {
    private boolean A = false;
    private String B = "AJRTrainFilterActivity";

    /* renamed from: a  reason: collision with root package name */
    private CJRTrainSearchResults f25955a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f25956b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f25957c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f25958d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f25959e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f25960f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CJRTrainFilterModel f25961g = new CJRTrainFilterModel();

    /* renamed from: h  reason: collision with root package name */
    private Button f25962h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f25963i;
    private j j;
    private boolean k = false;
    private ac l;
    private ad m;
    private ad n;
    private RecyclerView o;
    private RecyclerView p;
    private RecyclerView q;
    private ArrayList<CJRTrainFilterItem> r = new ArrayList<>();
    private String s;
    private RoboTextView t;
    private boolean u = false;
    private String v;
    private String w;
    private TextView x;
    private TextView y;
    private ScrollView z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_lyt_train_filter_bottom);
        this.f25958d = LayoutInflater.from(this);
        this.j = new j(this);
        this.f25956b = (LinearLayout) findViewById(R.id.lyt_train_filter_source_cities);
        this.t = (RoboTextView) findViewById(R.id.filter_trains_title);
        if (!(g.f27551a == null || g.f27551a.getFilterTitle() == null || TextUtils.isEmpty(g.f27551a.getFilterTitle().trim()))) {
            this.t.setText(g.f27551a.getFilterTitle());
        }
        this.f25957c = (LinearLayout) findViewById(R.id.lyt_train_filter_destionation_cities);
        this.f25962h = (Button) findViewById(R.id.lyt_filter_apply_click);
        this.f25962h.setOnClickListener(this);
        this.f25963i = (TextView) findViewById(R.id.txt_no_result);
        this.z = (ScrollView) findViewById(R.id.scroll_layout);
        this.f25959e = (RelativeLayout) findViewById(R.id.lyt_filter_reset_all);
        this.f25959e.setVisibility(0);
        this.f25959e.setOnClickListener(this);
        this.f25960f = (RelativeLayout) findViewById(R.id.train_filter_close);
        this.f25960f.setOnClickListener(this);
        this.x = (TextView) findViewById(R.id.departure_title);
        this.y = (TextView) findViewById(R.id.arrival_title);
        this.f25955a = (CJRTrainSearchResults) getIntent().getSerializableExtra("intent_search_result");
        this.f25961g = (CJRTrainFilterModel) getIntent().getSerializableExtra("intent_filter_result");
        this.s = getIntent().getStringExtra("alreadyFilterApplied");
        this.r = (ArrayList) getIntent().getSerializableExtra("train_filter_ac_and_non_ac_list");
        this.v = getIntent().getStringExtra("source_station_name");
        this.w = getIntent().getStringExtra("destination_station_name");
        a();
        if (!TextUtils.isEmpty(this.s)) {
            ArrayList<CJRTrainFilterItem> arrayList = this.r;
            boolean equalsIgnoreCase = "NonAcType".equalsIgnoreCase(this.s);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (equalsIgnoreCase && "nonac".equalsIgnoreCase(arrayList.get(i2).getId())) {
                    arrayList.get(i2).setSelectValue(true);
                } else if (!equalsIgnoreCase && "ac".equalsIgnoreCase(arrayList.get(i2).getId())) {
                    arrayList.get(i2).setSelectValue(true);
                }
            }
            ac acVar = this.l;
            if (acVar != null) {
                k.c(arrayList, "coachTypeList");
                acVar.f26174d = equalsIgnoreCase;
                acVar.f26173c = arrayList;
                acVar.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            this.f25963i.setVisibility(0);
            this.z.setVisibility(8);
            this.f25962h.setVisibility(8);
            return;
        }
        this.f25963i.setVisibility(8);
        this.z.setVisibility(0);
        this.f25962h.setVisibility(0);
    }

    private void a() {
        this.x.setText(getResources().getString(R.string.departure_from, new Object[]{this.v}));
        this.y.setText(getResources().getString(R.string.arrival_in, new Object[]{this.w}));
        HashMap<String, String> d2 = d();
        HashMap<String, String> e2 = e();
        c();
        this.f25957c.removeAllViews();
        this.f25956b.removeAllViews();
        a(d2, Boolean.TRUE);
        a(e2, Boolean.FALSE);
        this.o = (RecyclerView) findViewById(R.id.ac_recycler);
        this.o.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.p = (RecyclerView) findViewById(R.id.departue_list);
        this.p.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.m = new ad(this);
        this.p.setAdapter(this.m);
        this.q = (RecyclerView) findViewById(R.id.arrival_list);
        this.q.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.n = new ad(this);
        this.q.setAdapter(this.n);
        f();
        if (this.r.size() > 0) {
            this.l = new ac(this, this.r);
        } else {
            this.l = new ac(this, b());
        }
        this.o.setAdapter(this.l);
    }

    private ArrayList<CJRTrainFilterItem> b() {
        ArrayList<CJRTrainFilters> filters;
        new ArrayList();
        CJRTrainSearchResults cJRTrainSearchResults = this.f25955a;
        if (!(cJRTrainSearchResults == null || cJRTrainSearchResults.getBody() == null || (filters = this.f25955a.getBody().getFilters()) == null || filters.size() <= 0)) {
            for (int i2 = 0; i2 < filters.size(); i2++) {
                if ("ac".equalsIgnoreCase(filters.get(i2).getId()) || "nonac".equalsIgnoreCase(filters.get(i2).getId())) {
                    for (int i3 = 0; i3 < filters.get(i2).getFilters().size(); i3++) {
                        filters.get(i2).getFilters().get(i3).setSelectValue(false);
                        filters.get(i2).getFilters().get(i3).setId(filters.get(i2).getId());
                        this.r.add(filters.get(i2).getFilters().get(i3));
                    }
                }
            }
        }
        return this.r;
    }

    private void c() {
        CJRTrainSearchResults cJRTrainSearchResults = this.f25955a;
        if (cJRTrainSearchResults == null || cJRTrainSearchResults.getTrainClassesLinkedMap() == null) {
        }
    }

    private HashMap<String, String> d() {
        HashMap<String, String> hashMap = new HashMap<>();
        CJRTrainSearchResults cJRTrainSearchResults = this.f25955a;
        if (cJRTrainSearchResults != null) {
            int size = cJRTrainSearchResults.getBody().getTrains().size();
            for (int i2 = 0; i2 < size; i2++) {
                String source = this.f25955a.getBody().getTrains().get(i2).getSource();
                String sourceName = this.f25955a.getBody().getTrains().get(i2).getSourceName();
                if (!hashMap.containsKey(source) && !hashMap.containsKey(sourceName)) {
                    hashMap.put(source, sourceName);
                }
            }
        }
        return hashMap;
    }

    private HashMap<String, String> e() {
        HashMap<String, String> hashMap = new HashMap<>();
        CJRTrainSearchResults cJRTrainSearchResults = this.f25955a;
        if (cJRTrainSearchResults != null) {
            int size = cJRTrainSearchResults.getBody().getTrains().size();
            for (int i2 = 0; i2 < size; i2++) {
                String destination = this.f25955a.getBody().getTrains().get(i2).getDestination();
                String destinationName = this.f25955a.getBody().getTrains().get(i2).getDestinationName();
                if (!hashMap.containsKey(destinationName)) {
                    hashMap.put(destination, destinationName);
                }
            }
        }
        return hashMap;
    }

    private void a(HashMap<String, String> hashMap, Boolean bool) {
        LinearLayout linearLayout = null;
        int i2 = 1;
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View inflate = this.f25958d.inflate(R.layout.pre_t_lyt_train_filter_checkbox, (ViewGroup) null);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 0.5f));
            TextView textView = (TextView) inflate.findViewById(R.id.lyt_filter_name);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.lyt_filter_checkbox);
            checkBox.setChecked(false);
            textView.setText((String) next.getValue());
            ((TextView) inflate.findViewById(R.id.lyt_filter_code)).setText(str);
            a(inflate, next, bool, checkBox);
            if (i2 % 2 == 1) {
                linearLayout = new LinearLayout(this);
                if (bool.booleanValue()) {
                    this.f25956b.addView(linearLayout);
                } else {
                    this.f25957c.addView(linearLayout);
                }
            }
            if (this.f25961g.getmSelectedSourceList().containsKey(str)) {
                checkBox.setChecked(true);
            }
            if (this.f25961g.getmSelectedDestinationList().containsKey(str)) {
                checkBox.setChecked(true);
            }
            linearLayout.addView(inflate);
            i2++;
        }
    }

    private void a(View view, Map.Entry entry, final Boolean bool, final CheckBox checkBox) {
        view.setTag(entry);
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainFilterActivity.this.a(false);
                Map.Entry entry = (Map.Entry) view.getTag();
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey());
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(entry.getValue());
                String sb4 = sb3.toString();
                if (bool.booleanValue()) {
                    if (!AJRTrainFilterActivity.this.f25961g.getmSelectedSourceList().containsKey(sb2)) {
                        checkBox.setChecked(true);
                        AJRTrainFilterActivity.this.a(d.cY);
                        AJRTrainFilterActivity.this.f25961g.getmSelectedSourceList().put(sb2, sb4);
                        return;
                    }
                    checkBox.setChecked(false);
                    AJRTrainFilterActivity.this.f25961g.getmSelectedSourceList().remove(sb2);
                } else if (!AJRTrainFilterActivity.this.f25961g.getmSelectedDestinationList().containsKey(sb2)) {
                    checkBox.setChecked(true);
                    AJRTrainFilterActivity.this.a(d.cZ);
                    AJRTrainFilterActivity.this.f25961g.getmSelectedDestinationList().put(sb2, sb4);
                } else {
                    checkBox.setChecked(false);
                    AJRTrainFilterActivity.this.f25961g.getmSelectedDestinationList().remove(sb2);
                }
            }
        });
    }

    private void f() {
        ad adVar;
        ad adVar2;
        if (this.f25961g.getmSelecteddepartureList().size() > 0 && (adVar2 = this.m) != null) {
            adVar2.a(this.f25961g.getmSelecteddepartureList());
        }
        if (this.f25961g.getmSelectedArrivaList().size() > 0 && (adVar = this.n) != null) {
            adVar.a(this.f25961g.getmSelectedArrivaList());
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        String str;
        String str2;
        int id = view.getId();
        if (id == R.id.lyt_filter_apply_click) {
            ArrayList<CJRTrainFilterItem> arrayList = this.l.f26171a;
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = true;
            if (arrayList == null || arrayList.size() <= 0) {
                this.u = true;
                arrayList2.addAll(this.r);
            } else {
                arrayList2.addAll(arrayList);
            }
            if (this.f25955a != null) {
                HashMap hashMap = new HashMap();
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    CJRTrainFilterItem cJRTrainFilterItem = (CJRTrainFilterItem) arrayList2.get(i2);
                    if (cJRTrainFilterItem != null) {
                        for (int i3 = 0; i3 < cJRTrainFilterItem.getValues().size(); i3++) {
                            hashMap.put(cJRTrainFilterItem.getValues().get(i3), (String) this.f25955a.getTrainClassesMap().get(cJRTrainFilterItem.getValues().get(i3)));
                        }
                    }
                }
                HashMap<String, String> hashMap2 = this.m.f26189b;
                HashMap<String, String> hashMap3 = this.n.f26189b;
                this.f25961g.getmSelectedFareCalssesList().clear();
                this.f25961g.getmSelecteddepartureList().clear();
                this.f25961g.getmSelectedArrivaList().clear();
                this.f25961g.setmSelectedFareCalssesList(hashMap);
                this.f25961g.setmSelecteddepartureList(hashMap2);
                this.f25961g.setmSelectedArrivaList(hashMap3);
            }
            if (this.f25961g.getmSelectedFareCalssesList().size() > 0 || this.f25961g.getmSelectedSourceList().size() > 0 || this.f25961g.getmSelectedDestinationList().size() > 0 || this.f25961g.getmSelecteddepartureList().size() > 0 || this.f25961g.getmSelectedArrivaList().size() > 0 || !this.u) {
                if (this.f25961g.getmSelectedSourceList().size() <= 0 && this.f25961g.getmSelectedDestinationList().size() <= 0 && this.f25961g.getmSelecteddepartureList().size() <= 0 && this.f25961g.getmSelectedArrivaList().size() <= 0 && this.u) {
                    z2 = false;
                }
                this.k = z2;
                this.j.a(this.f25955a, this.f25961g);
            } else {
                this.k = false;
                CJRTrainSearchResults cJRTrainSearchResults = this.f25955a;
                if (cJRTrainSearchResults != null) {
                    a(cJRTrainSearchResults.getBody().getTrains());
                }
            }
            HashMap hashMap4 = new HashMap();
            String str3 = "";
            for (int i4 = 0; i4 < this.f25961g.getmSelectedSourceList().size(); i4++) {
                str3 = str3 + this.f25961g.getmSelectedSourceList().keySet().toArray()[i4] + AppConstants.COMMA;
            }
            String str4 = "";
            for (int i5 = 0; i5 < this.f25961g.getmSelectedDestinationList().size(); i5++) {
                str4 = str4 + this.f25961g.getmSelectedDestinationList().keySet().toArray()[i5] + AppConstants.COMMA;
            }
            String str5 = "";
            for (int i6 = 0; i6 < this.f25961g.getmSelectedFareCalssesList().size(); i6++) {
                str5 = str5 + this.f25961g.getmSelectedFareCalssesList().keySet().toArray()[i6] + AppConstants.COMMA;
            }
            hashMap4.put("train_filter_fare_class", str5);
            hashMap4.put("train_filter_destination", str4);
            hashMap4.put("train_filter_origin", str3);
            if (this.f25955a.getBody().getTrains() == null || this.f25955a.getBody().getTrains().size() <= 0) {
                str2 = "";
            } else {
                str2 = this.f25955a.getBody().getTrains().get(0).getDeparture();
            }
            o.a("train_search_results", this.v, this.w, str2, this.f25961g.toString(), (String) null, (String) null, Utility.ACTION_APPLY_CLICKED, "/trains/search-results", this, hashMap4);
        } else if (id == R.id.lyt_filter_reset_all) {
            a(d.cX);
            this.f25961g = new CJRTrainFilterModel();
            this.f25961g.setmSelectedSourceList(new HashMap());
            this.f25961g.setmSelectedDestinationList(new HashMap());
            this.f25961g.setmSelectedFareCalssesList(new HashMap());
            this.f25961g.setmSelecteddepartureList(new HashMap());
            this.f25961g.setmSelectedArrivaList(new HashMap());
            this.f25961g.getmSelecteddepartureList().clear();
            this.f25961g.getmSelectedArrivaList().clear();
            this.f25961g.getmSelectedFareCalssesList().clear();
            this.r = new ArrayList<>();
            a();
            a(false);
            this.k = false;
            CJRTrainSearchResults cJRTrainSearchResults2 = this.f25955a;
            if (cJRTrainSearchResults2 != null) {
                a(cJRTrainSearchResults2.getBody().getTrains());
            }
            if (b.n(getApplicationContext()) != null) {
                str = b.n(getApplicationContext());
            } else {
                str = "";
            }
            try {
                HashMap hashMap5 = new HashMap();
                if (str == null) {
                    str = "";
                }
                hashMap5.put("train_user_id", str);
                hashMap5.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.t);
                com.travel.train.b.a();
                com.travel.train.b.b().a("train_search_results_reset_all_clicked", (Map<String, Object>) hashMap5, (Context) this);
            } catch (Exception e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        } else if (id == R.id.train_filter_close) {
            finish();
        }
    }

    public final void a(List<CJRTrainSearchResultsTrain> list) {
        CJRTrainSearchResults cJRTrainSearchResults;
        if (list.size() <= 0 || (cJRTrainSearchResults = this.f25955a) == null) {
            a(true);
            if (g.f27551a != null && g.f27551a.getZeroTrainsFilter() != null) {
                this.f25963i.setText(g.f27551a.getZeroTrainsFilter());
                return;
            }
            return;
        }
        cJRTrainSearchResults.getBody().setTrains(list);
        Intent intent = new Intent();
        intent.putExtra("intent_search_result", this.f25955a);
        intent.putExtra("intent_filter_result", this.f25961g);
        intent.putExtra("train_filter_check", this.k);
        intent.putExtra("train_filter_ac_and_non_ac_list", this.r);
        setResult(123, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", b.n((Context) this) != null ? b.n((Context) this) : "");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }
}
