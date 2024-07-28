package com.travel.flight.flightticket.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.c.c.a;
import com.travel.flight.flightticket.f.j;
import com.travel.flight.flightticket.k.c;
import com.travel.flight.pojo.f;
import com.travel.flight.pojo.flightticket.CJRAirportCity;
import com.travel.flight.pojo.flightticket.CJRAirportCityLinguisticItem;
import com.travel.flight.utils.i;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;

public class AJRSelectAirportActivity extends PaytmActivity implements View.OnClickListener, AbsListView.OnScrollListener, a, j {

    /* renamed from: a  reason: collision with root package name */
    CJRAirportCity f24824a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f24825b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.travel.flight.flightticket.a.a f24826c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f24827d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f24828e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f24829f;

    /* renamed from: g  reason: collision with root package name */
    private String f24830g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f24831h = "";

    /* renamed from: i  reason: collision with root package name */
    private TextView f24832i;
    /* access modifiers changed from: private */
    public String j = "";
    /* access modifiers changed from: private */
    public String k = null;
    /* access modifiers changed from: private */
    public ArrayList<f> l = new ArrayList<>();
    private FrameLayout m;
    private LinearLayout n;
    private String o;
    private String p;
    /* access modifiers changed from: private */
    public boolean q = false;
    /* access modifiers changed from: private */
    public c r;
    private TextWatcher s = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            String unused = AJRSelectAirportActivity.this.k = (editable == null || editable.length() <= 0) ? null : editable.toString();
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            try {
                if (charSequence.length() == 0) {
                    AJRSelectAirportActivity.this.a(AJRSelectAirportActivity.this.f24824a);
                    AJRSelectAirportActivity.this.f24829f.setVisibility(8);
                }
            } catch (Exception unused) {
            }
            AJRSelectAirportActivity.this.a(charSequence.toString());
        }
    };

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_select_airport);
        this.f24828e = (ProgressBar) findViewById(R.id.progress_city);
        Intent intent = getIntent();
        if (intent != null) {
            this.f24827d = intent.getStringExtra("option");
            if (intent.hasExtra("source")) {
                this.f24830g = intent.getStringExtra("source");
            }
            if (intent.hasExtra("destination")) {
                this.f24831h = intent.getStringExtra("destination");
            }
            if (intent.hasExtra("isRoundTrip")) {
                this.q = intent.getBooleanExtra("isRoundTrip", false);
            }
        }
        if (!((intent == null || !intent.hasExtra("isd_from_search_modification")) ? false : intent.getBooleanExtra("isd_from_search_modification", false))) {
            this.l = com.travel.flight.utils.c.a((Context) this, "flight_recent_search_details");
        }
        if (intent != null && intent.hasExtra("source_iata_code")) {
            this.o = intent.getStringExtra("source_iata_code");
        }
        if (intent != null && intent.hasExtra("dest_iata_code")) {
            this.p = intent.getStringExtra("dest_iata_code");
        }
        this.f24825b = (EditText) findViewById(R.id.city_search);
        this.f24829f = (RelativeLayout) findViewById(R.id.suggestion_lyt);
        this.n = (LinearLayout) findViewById(R.id.airport_lyt);
        this.m = (FrameLayout) findViewById(R.id.fragment_container);
        String str = this.f24827d;
        if (str == null || !str.equalsIgnoreCase("source")) {
            this.f24825b.setHint(R.string.flight_destination_city_name);
            setTitle(R.string.search_for_destination_city);
            findViewById(R.id.source_city_devider).setVisibility(8);
            findViewById(R.id.dest_city_devider).setVisibility(0);
        } else {
            this.f24825b.setHint(R.string.flight_origin_city_name);
            setTitle(R.string.search_for_origin_city);
            findViewById(R.id.source_city_devider).setVisibility(0);
            findViewById(R.id.dest_city_devider).setVisibility(8);
        }
        this.f24825b.setFilters(new InputFilter[]{new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                if (charSequence.equals("") || charSequence.toString().matches("[a-zA-Z ]+")) {
                    return charSequence;
                }
                if (charSequence.toString() == null || charSequence.toString().length() <= 0) {
                    return "";
                }
                return charSequence.toString().substring(0, charSequence.length() - 1);
            }
        }});
        this.f24825b.addTextChangedListener(this.s);
        this.f24825b.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 3) {
                    return false;
                }
                AJRSelectAirportActivity aJRSelectAirportActivity = AJRSelectAirportActivity.this;
                aJRSelectAirportActivity.a(aJRSelectAirportActivity.f24825b.getText().toString());
                return true;
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.flight_search_close_view);
        imageView.setOnClickListener(this);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.f24832i = (TextView) findViewById(R.id.airport_same_error_message);
        this.r = (c) am.a((FragmentActivity) this, (al.b) new c.a(getApplication(), this.o, this.p, this.f24830g, this.f24831h, this.f24827d, this.l)).a(c.class);
        this.r.f25281g.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.a((com.paytm.network.a) obj);
            }
        });
        this.r.f25282h.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.b((CJRAirportCity) obj);
            }
        });
        this.r.f25283i.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.a((Boolean) obj);
            }
        });
        this.r.j.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.a((CJRAirportCity) obj);
            }
        });
        this.r.l.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.b(obj);
            }
        });
        this.r.m.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.a(obj);
            }
        });
        this.r.n.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.c((Pair<String, String>) (Pair) obj);
            }
        });
        this.r.o.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.b((Pair<String, String>) (Pair) obj);
            }
        });
        this.r.p.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRSelectAirportActivity.this.a((Pair<Boolean, String>) (Pair) obj);
            }
        });
    }

    public void attachBaseContext(Context context) {
        b.a();
        super.attachBaseContext(b.b().d(context));
        q.a(this);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }

    public void onBackPressed() {
        c();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public void a(final com.paytm.network.a aVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (com.paytm.utility.b.c((Context) AJRSelectAirportActivity.this)) {
                    aVar.a();
                } else {
                    AJRSelectAirportActivity.this.a(aVar);
                }
            }
        });
        builder.show();
    }

    public void a(CJRAirportCity cJRAirportCity) {
        ListView listView = (ListView) findViewById(R.id.airport_listview);
        if (cJRAirportCity == null || cJRAirportCity.getCjrAirportCityItemBody() == null || (cJRAirportCity.getCjrAirportCityItemBody().getmAirportCityItems() == null && cJRAirportCity.getCjrAirportCityItemBody().getmAirportRouteItems() == null)) {
            listView.setAdapter((ListAdapter) null);
            return;
        }
        this.f24826c = new com.travel.flight.flightticket.a.a(this, cJRAirportCity, this.l);
        listView.setAdapter(this.f24826c);
        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                int i3;
                com.travel.flight.pojo.flightticket.b bVar;
                int i4;
                CJRAirportCityLinguisticItem cJRAirportCityLinguisticItem = null;
                if (AJRSelectAirportActivity.this.f24826c.getItem(i2) instanceof com.travel.flight.pojo.flightticket.b) {
                    bVar = (com.travel.flight.pojo.flightticket.b) AJRSelectAirportActivity.this.f24826c.getItem(i2);
                    i3 = bVar.getItemType();
                } else {
                    CJRAirportCityLinguisticItem cJRAirportCityLinguisticItem2 = (CJRAirportCityLinguisticItem) AJRSelectAirportActivity.this.f24826c.getItem(i2);
                    i3 = cJRAirportCityLinguisticItem2.getItemType();
                    cJRAirportCityLinguisticItem = cJRAirportCityLinguisticItem2;
                    bVar = null;
                }
                if (bVar != null && bVar.getmNearbyAirportData() != null && bVar.getmNearbyAirportData().size() > 0) {
                    c f2 = AJRSelectAirportActivity.this.r;
                    String unused = AJRSelectAirportActivity.this.k;
                    String unused2 = AJRSelectAirportActivity.this.j;
                    if (!f2.a(bVar, true)) {
                        AJRSelectAirportActivity.a(AJRSelectAirportActivity.this, bVar);
                    }
                } else if (i3 != 0) {
                    c f3 = AJRSelectAirportActivity.this.r;
                    String unused3 = AJRSelectAirportActivity.this.k;
                    String unused4 = AJRSelectAirportActivity.this.j;
                    if (!f3.a(bVar, false)) {
                        Intent intent = new Intent();
                        intent.putExtra("intent_extra_selected_city_position", i2);
                        intent.putExtra("search_key", AJRSelectAirportActivity.this.j);
                        if (AJRSelectAirportActivity.this.l != null && (i4 = i2 - 1) < AJRSelectAirportActivity.this.l.size() && i3 == 3) {
                            f fVar = (f) AJRSelectAirportActivity.this.l.get(i4);
                            com.travel.flight.pojo.flightticket.b bVar2 = new com.travel.flight.pojo.flightticket.b();
                            bVar2.setCityName(fVar.getSourceCityName());
                            bVar2.setAirPortName(fVar.getSourceAirportName());
                            bVar2.setShortCityName(fVar.getSourceShortCityName());
                            bVar2.setCountryCode(fVar.getSourceCountryCode());
                            bVar2.setCountryName(fVar.getSourceCountryName());
                            com.travel.flight.pojo.flightticket.b bVar3 = new com.travel.flight.pojo.flightticket.b();
                            bVar3.setCityName(fVar.getDestCityName());
                            bVar3.setCountryCode(fVar.getDestCountryCode());
                            bVar3.setAirPortName(fVar.getDestAirportName());
                            bVar3.setShortCityName(fVar.getDestShortCityName());
                            bVar3.setCountryName(fVar.getDestCountryName());
                            intent.putExtra("flight_source_recent_search_selected", bVar2);
                            intent.putExtra("flight_dest_recent_search_selected", bVar3);
                            intent.putExtra("is_recent_search_selected", true);
                            intent.putExtra("INTENT_EXTRA_FLIGHT_SEARCH_IS_ROUND_TRIP", fVar.isRoundTrip());
                        } else if (cJRAirportCityLinguisticItem == null || i3 != 5) {
                            intent.putExtra("intent_extra_selected_city_name", bVar);
                            intent.putExtra("is_recent_search_selected", false);
                        } else {
                            com.travel.flight.pojo.flightticket.b bVar4 = new com.travel.flight.pojo.flightticket.b();
                            bVar4.setCityName(cJRAirportCityLinguisticItem.getmSource().getCityName());
                            bVar4.setAirPortName(cJRAirportCityLinguisticItem.getmSource().getAirPortName());
                            bVar4.setShortCityName(cJRAirportCityLinguisticItem.getmSource().getShortCityName());
                            bVar4.setCountryName(cJRAirportCityLinguisticItem.getmSource().getCountryName());
                            bVar4.setCountryCode(cJRAirportCityLinguisticItem.getmSource().getCountryCode());
                            com.travel.flight.pojo.flightticket.b bVar5 = new com.travel.flight.pojo.flightticket.b();
                            bVar5.setCityName(cJRAirportCityLinguisticItem.getmDestination().getCityName());
                            bVar5.setAirPortName(cJRAirportCityLinguisticItem.getmDestination().getAirPortName());
                            bVar5.setShortCityName(cJRAirportCityLinguisticItem.getmDestination().getShortCityName());
                            bVar5.setCountryName(cJRAirportCityLinguisticItem.getmDestination().getCountryName());
                            bVar5.setCountryCode(cJRAirportCityLinguisticItem.getmDestination().getCountryCode());
                            intent.putExtra("flight_source_recent_search_selected", bVar4);
                            intent.putExtra("flight_dest_recent_search_selected", bVar5);
                            intent.putExtra("is_recent_search_selected", true);
                            intent.putExtra("INTENT_EXTRA_FLIGHT_SEARCH_IS_ROUND_TRIP", AJRSelectAirportActivity.this.q);
                        }
                        AJRSelectAirportActivity.this.setResult(-1, intent);
                        AJRSelectAirportActivity.this.finish();
                    }
                }
            }
        });
    }

    public void onDestroy() {
        try {
            if (this.f24826c != null) {
                com.travel.flight.flightticket.a.a aVar = this.f24826c;
                if (aVar.f24593a != null) {
                    aVar.f24593a = null;
                }
            }
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public final void a(String str) {
        if (str != null && !TextUtils.isEmpty(str) && str.length() >= 2) {
            this.j = str;
            c cVar = this.r;
            String obj = this.f24825b.getText().toString();
            cVar.f25278d = str;
            cVar.f25279e = obj;
            cVar.f25275a = false;
            b.a();
            String str2 = b.b().h() + str.trim().replace(" ", "%20");
            if (URLUtil.isValidUrl(str2)) {
                String s2 = com.paytm.utility.b.s(cVar.f25277c, str2);
                HashMap hashMap = new HashMap();
                hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(cVar.f25277c));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = cVar.f25277c;
                bVar.n = a.b.SILENT;
                bVar.o = AJRSelectAirportActivity.class.getSimpleName();
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = s2 + c.b();
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRAirportCity();
                bVar.j = cVar;
                com.paytm.network.a l2 = bVar.l();
                l2.a((Object) "searchApiTag");
                if (com.paytm.utility.b.c(cVar.f25277c)) {
                    l2.f42860d = true;
                    l2.a();
                    return;
                }
                cVar.f25281g.setValue(l2);
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.flight_search_close_view) {
            finish();
        }
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        i.a(getApplicationContext().getApplicationContext()).a("flight_recent_search_details", new com.google.gsonhtcfix.f().a((Object) arrayList, new com.google.gson.b.a<ArrayList<com.travel.flight.pojo.flightticket.b>>() {
        }.getType()), false);
        this.l = null;
        this.r.a();
        this.r.f25280f = this.l;
    }

    private void c() {
        com.travel.flight.c.b.a aVar = (com.travel.flight.c.b.a) getSupportFragmentManager().c("srp_farerules_fragment");
        if (aVar == null || !aVar.isVisible()) {
            super.onBackPressed();
            return;
        }
        androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.f() > 0) {
            supportFragmentManager.d();
            this.n.setVisibility(0);
            this.m.setVisibility(8);
        }
    }

    public final void a(com.travel.flight.pojo.flightticket.b bVar, int i2, com.travel.flight.pojo.flightticket.b bVar2) {
        if (!this.r.a(bVar, false)) {
            Intent intent = new Intent();
            if (bVar2 != null && bVar2.getShortCityName() != null && "source".equalsIgnoreCase(this.f24827d)) {
                intent.putExtra("source_iata_code", bVar2.getShortCityName());
            } else if (!(bVar2 == null || bVar2.getShortCityName() == null || !"destination".equalsIgnoreCase(this.f24827d))) {
                intent.putExtra("dest_iata_code", bVar2.getShortCityName());
            }
            intent.putExtra("intent_extra_selected_city_name", bVar);
            intent.putExtra("intent_extra_selected_city_position", i2);
            intent.putExtra("search_key", this.j);
            intent.putExtra("is_recent_search_selected", false);
            setResult(-1, intent);
            finish();
            return;
        }
        c();
    }

    public final void a() {
        c();
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        EditText editText;
        if ((i2 == 0 || i2 == 1) && (editText = this.f24825b) != null) {
            com.travel.flight.utils.c.a((View) editText, (Context) this);
        }
    }

    public void a(Boolean bool) {
        if (this.f24828e == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.f24828e.setVisibility(0);
        } else {
            this.f24828e.setVisibility(8);
        }
    }

    public void b(CJRAirportCity cJRAirportCity) {
        this.f24824a = cJRAirportCity;
        c cVar = this.r;
        ArrayList<com.travel.flight.pojo.flightticket.b> arrayList = this.f24824a.getCjrAirportCityItemBody().getmAirportCityItems();
        ArrayList<f> arrayList2 = cVar.f25280f;
        if (arrayList != null && arrayList.size() > 0) {
            com.travel.flight.pojo.flightticket.b bVar = new com.travel.flight.pojo.flightticket.b();
            bVar.setCityName("Popular Cities");
            bVar.setItemType(0);
            arrayList.add(0, bVar);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<f> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next();
                    com.travel.flight.pojo.flightticket.b bVar2 = new com.travel.flight.pojo.flightticket.b();
                    bVar2.setCityName("Recent List");
                    bVar2.setItemType(3);
                    arrayList.add(0, bVar2);
                }
                com.travel.flight.pojo.flightticket.b bVar3 = new com.travel.flight.pojo.flightticket.b();
                bVar3.setCityName("Recent Searches");
                bVar3.setItemType(0);
                arrayList.add(0, bVar3);
            }
        }
        a(this.f24824a);
    }

    public void a(Pair<Boolean, String> pair) {
        if (this.f24832i == null) {
            return;
        }
        if (((Boolean) pair.first).booleanValue()) {
            this.f24832i.setVisibility(0);
            this.f24832i.setText((CharSequence) pair.second);
            return;
        }
        this.f24832i.setVisibility(8);
    }

    public void b(Pair<String, String> pair) {
        com.paytm.utility.b.b((Context) this, (String) pair.first, (String) pair.second);
    }

    public void c(Pair<String, String> pair) {
        com.paytm.utility.b.d((Context) this, (String) pair.first, (String) pair.second);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        if (!isFinishing()) {
            String string = getResources().getString(R.string.bus_maintenance_error_title);
            String string2 = getResources().getString(R.string.bus_maintenance_error_description);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(string).setMessage(string2).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    AJRSelectAirportActivity aJRSelectAirportActivity = AJRSelectAirportActivity.this;
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(268435456);
                    b.a();
                    b.b().b(aJRSelectAirportActivity, intent);
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Object obj) {
        this.f24829f.setVisibility(0);
        a((CJRAirportCity) null);
    }

    static /* synthetic */ void a(AJRSelectAirportActivity aJRSelectAirportActivity, com.travel.flight.pojo.flightticket.b bVar) {
        aJRSelectAirportActivity.n.setVisibility(8);
        aJRSelectAirportActivity.m.setVisibility(0);
        com.travel.flight.utils.c.a((View) aJRSelectAirportActivity.f24825b, (Context) aJRSelectAirportActivity);
        if (!aJRSelectAirportActivity.isFinishing()) {
            com.travel.flight.c.b.a aVar = new com.travel.flight.c.b.a();
            Bundle bundle = new Bundle();
            bundle.putSerializable("bundle_airport_list", bVar);
            aVar.setArguments(bundle);
            androidx.fragment.app.q a2 = aJRSelectAirportActivity.getSupportFragmentManager().a();
            a2.a(17498112, 17498113);
            a2.a(R.id.fragment_container, aVar, "srp_farerules_fragment").a("airport_backstack_tag");
            try {
                a2.b();
            } catch (IllegalStateException unused) {
                a2.c();
            }
        }
    }
}
