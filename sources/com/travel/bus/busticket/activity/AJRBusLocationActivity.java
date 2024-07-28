package com.travel.bus.busticket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.gms.location.f;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.a.ad;
import com.travel.bus.busticket.a.p;
import com.travel.bus.busticket.i.m;
import com.travel.bus.pojo.busticket.BusRecentLocationData;
import com.travel.bus.pojo.mapmyindia.CJRSuggestedLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRBusLocationActivity extends AJRBusBaseActivity implements View.OnClickListener, e.b, e.c, ad.a, p.a, m.b {

    /* renamed from: a  reason: collision with root package name */
    Context f21836a;

    /* renamed from: b  reason: collision with root package name */
    e f21837b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayoutManager f21838c;

    /* renamed from: d  reason: collision with root package name */
    LinearLayoutManager f21839d;

    /* renamed from: e  reason: collision with root package name */
    RelativeLayout f21840e;

    /* renamed from: f  reason: collision with root package name */
    p f21841f;

    /* renamed from: g  reason: collision with root package name */
    ad f21842g;

    /* renamed from: h  reason: collision with root package name */
    EditText f21843h;

    /* renamed from: i  reason: collision with root package name */
    ImageView f21844i;
    ImageView j;
    RelativeLayout k;
    /* access modifiers changed from: private */
    public boolean l = true;
    /* access modifiers changed from: private */
    public boolean m = false;
    private m n;
    private String o = AJRBusLocationActivity.class.getSimpleName();
    /* access modifiers changed from: private */
    public RecyclerView p;
    private RecyclerView q;
    /* access modifiers changed from: private */
    public String r;

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_bus_bp_dp_location);
        this.f21836a = this;
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getBooleanExtra("isboardingLocation", true);
        }
        this.p = (RecyclerView) findViewById(R.id.list_search);
        this.q = (RecyclerView) findViewById(R.id.list_recents);
        this.p.setHasFixedSize(true);
        this.f21840e = (RelativeLayout) findViewById(R.id.current_location_lyt);
        this.f21840e.setOnClickListener(this);
        this.f21838c = new LinearLayoutManager(this.f21836a);
        this.p.setLayoutManager(this.f21838c);
        this.f21839d = new LinearLayoutManager(this.f21836a);
        this.q.setLayoutManager(this.f21839d);
        this.f21843h = (EditText) findViewById(R.id.search_et);
        if (this.l) {
            this.f21843h.setHint(R.string.search_nearest_boarding);
        } else {
            this.f21843h.setHint(R.string.search_nearest_dropping);
        }
        this.f21844i = (ImageView) findViewById(R.id.clear);
        this.f21844i.setOnClickListener(this);
        this.k = (RelativeLayout) findViewById(R.id.powered_by_google);
        this.j = (ImageView) findViewById(R.id.back_button);
        this.j.setOnClickListener(this);
        this.f21841f = new p(this, R.layout.pre_b_bus_bp_dp_view_search);
        this.p.setAdapter(this.f21841f);
        List<BusRecentLocationData> a2 = a();
        if (a2 != null && a2.size() > 0) {
            this.f21842g = new ad(this, a2);
            this.q.setAdapter(this.f21842g);
        }
        this.f21843h.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (i4 < i3) {
                    boolean unused = AJRBusLocationActivity.this.m = true;
                } else {
                    boolean unused2 = AJRBusLocationActivity.this.m = false;
                }
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                String unused = AJRBusLocationActivity.this.r = charSequence.toString();
                if (charSequence == null || charSequence.length() < 3) {
                    AJRBusLocationActivity.this.f21841f.a();
                    AJRBusLocationActivity.this.p.setVisibility(8);
                    AJRBusLocationActivity.this.k.setVisibility(8);
                    AJRBusLocationActivity.this.f21844i.setVisibility(8);
                } else {
                    AJRBusLocationActivity.this.f21844i.setVisibility(0);
                    if (AJRBusLocationActivity.this.f21841f != null) {
                        AJRBusLocationActivity.this.p.setVisibility(0);
                        AJRBusLocationActivity.this.p.setAdapter(AJRBusLocationActivity.this.f21841f);
                    }
                    AJRBusLocationActivity.this.f21841f.a(AJRBusLocationActivity.this.r);
                }
                if (charSequence != null && charSequence.length() >= 3 && AJRBusLocationActivity.this.f21841f == null) {
                    AJRBusLocationActivity aJRBusLocationActivity = AJRBusLocationActivity.this;
                    AJRBusLocationActivity.a(aJRBusLocationActivity, aJRBusLocationActivity.l, charSequence);
                }
            }

            public final void afterTextChanged(Editable editable) {
                if (AJRBusLocationActivity.this.m) {
                    AJRBusLocationActivity aJRBusLocationActivity = AJRBusLocationActivity.this;
                    aJRBusLocationActivity.a(aJRBusLocationActivity.l, AJRBusLocationActivity.this.r);
                }
            }
        });
    }

    public void onClick(View view) {
        if (view == this.f21844i) {
            a(this.l, this.r);
            this.f21843h.setText("");
            p pVar = this.f21841f;
            if (pVar != null) {
                pVar.a();
            }
        } else if (view == this.j) {
            a(this.l, this.r);
            onBackPressed();
        } else if (view == this.f21840e) {
            boolean z = this.l;
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_boarding");
            hashMap.put("event_action", "use_current_location");
            if (z) {
                hashMap.put("event_label", "boarding");
            } else {
                hashMap.put("event_label", "dropping");
            }
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Boarding screen");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", b.n((Context) this));
            a.a();
            a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
            if (b.O((Context) this) && b.P((Context) this)) {
                try {
                    this.f21837b = new e.a(this).a((e.b) this).a((e.c) this).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) f.f11372a).a();
                    if (this.f21837b != null) {
                        this.n = new m(this, this, this.f21837b, this);
                        this.n.f22449a = false;
                        this.n.b();
                    }
                    if (this.f21837b != null && !this.f21837b.f()) {
                        this.f21837b.d();
                    }
                } catch (Exception e2) {
                    if (b.v) {
                        q.b(e2.getMessage());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_boarding");
        hashMap.put("event_action", "boarding_search_entered");
        if (z) {
            hashMap.put("event_label", "boarding");
        } else {
            hashMap.put("event_label", "dropping");
        }
        hashMap.put("event_label2", str);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Boarding screen");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.f21837b != null) {
                this.f21837b.d();
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        m mVar = this.n;
        if (mVar != null) {
            mVar.a();
        }
    }

    public final void a(CJRSuggestedLocation cJRSuggestedLocation, int i2) {
        if (cJRSuggestedLocation != null) {
            boolean z = this.l;
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_boarding");
            hashMap.put("event_action", "suggestion_selected");
            if (z) {
                hashMap.put("event_label", "boarding&".concat(String.valueOf(cJRSuggestedLocation)));
            } else {
                hashMap.put("event_label", "dropping&".concat(String.valueOf(cJRSuggestedLocation)));
            }
            hashMap.put("event_label2", this.r);
            hashMap.put("event_label3", Integer.valueOf(i2));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Boarding screen");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
            if (cJRSuggestedLocation != null) {
                try {
                    BusRecentLocationData busRecentLocationData = new BusRecentLocationData();
                    busRecentLocationData.setPrimaryText(cJRSuggestedLocation.getPlaceName());
                    busRecentLocationData.setSecondaryText(cJRSuggestedLocation.getPlaceAddress());
                    busRecentLocationData.setLatitude(cJRSuggestedLocation.getLatitude());
                    busRecentLocationData.setLongitude(cJRSuggestedLocation.getLongitude());
                    busRecentLocationData.setPlaceId(cJRSuggestedLocation.getP().toString());
                    b(busRecentLocationData);
                    Intent intent = new Intent();
                    intent.putExtra("intent_extra_place", busRecentLocationData);
                    intent.putExtra("intent_extra_current_location", false);
                    setResult(-1, intent);
                    finish();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void a(BusRecentLocationData busRecentLocationData) {
        String secondaryText = busRecentLocationData.getSecondaryText();
        boolean z = this.l;
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_boarding");
        hashMap.put("event_action", "recent_search_selected");
        if (z) {
            hashMap.put("event_label", "boarding&".concat(String.valueOf(secondaryText)));
        } else {
            hashMap.put("event_label", "dropping&".concat(String.valueOf(secondaryText)));
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-boarding");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        Intent intent = new Intent();
        intent.putExtra("intent_extra_place", busRecentLocationData);
        intent.putExtra("intent_extra_current_location", false);
        setResult(-1, intent);
        finish();
    }

    private void b(BusRecentLocationData busRecentLocationData) {
        boolean z;
        List a2 = a();
        if (a2 == null) {
            a2 = new ArrayList();
        }
        Iterator it2 = a2.iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            BusRecentLocationData busRecentLocationData2 = (BusRecentLocationData) it2.next();
            if (busRecentLocationData2.getPlaceId() == null || busRecentLocationData.getPlaceId() == null || busRecentLocationData2.getPlaceId().isEmpty() || busRecentLocationData.getPlaceId().isEmpty() || !busRecentLocationData2.getPlaceId().equalsIgnoreCase(busRecentLocationData.getPlaceId())) {
                z = false;
                continue;
            }
            if (z) {
                z = false;
                break;
            }
        }
        if (z) {
            a2.add(busRecentLocationData);
            a((List<BusRecentLocationData>) a2);
        }
    }

    private void a(List<BusRecentLocationData> list) {
        if (list != null && list.size() != 0) {
            if (list.size() > 5) {
                int size = list.size() - 5;
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(list.get(i2));
                }
                list.removeAll(arrayList);
            }
            com.travel.bus.b.a.a(this.f21836a.getApplicationContext()).a("recent-location-list", new com.google.gsonhtcfix.f().a((Object) list), false);
        }
    }

    private List<BusRecentLocationData> a() {
        String b2 = com.travel.bus.b.a.a(this.f21836a.getApplicationContext()).b("recent-location-list", "", false);
        AnonymousClass2 r1 = new com.google.gson.b.a<List<BusRecentLocationData>>() {
        };
        if (!TextUtils.isEmpty(b2)) {
            return (List) new com.google.gsonhtcfix.f().a(b2, r1.getType());
        }
        return null;
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        m mVar;
        if (i2 == 57 && s.a(iArr) && (mVar = this.n) != null) {
            mVar.b();
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
        String str;
        String str2;
        if (cJRUtilityLocationModel != null) {
            str2 = cJRUtilityLocationModel.getLatitude();
            str = cJRUtilityLocationModel.getLongitude();
        } else {
            str = "";
            str2 = str;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            b.b((Context) this, "", getResources().getString(R.string.enter_location_address));
            return;
        }
        double parseDouble = Double.parseDouble(str2);
        double parseDouble2 = Double.parseDouble(str);
        Intent intent = new Intent();
        intent.putExtra("intent_extra_current_location", true);
        intent.putExtra("intent_extra_current_location_lat", parseDouble);
        intent.putExtra("intent_extra_current_location_lon", parseDouble2);
        setResult(-1, intent);
        finish();
    }

    public void onConnected(Bundle bundle) {
        m mVar = this.n;
        if (mVar != null) {
            mVar.a();
        }
    }

    static /* synthetic */ void a(AJRBusLocationActivity aJRBusLocationActivity, boolean z, CharSequence charSequence) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_boarding");
        hashMap.put("event_action", "no_results_found");
        if (z) {
            hashMap.put("event_label", "boarding");
        } else {
            hashMap.put("event_label", "dropping");
        }
        hashMap.put("event_label2", charSequence);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Boarding screen");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n((Context) aJRBusLocationActivity));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) aJRBusLocationActivity);
    }
}
