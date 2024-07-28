package com.travel.bus.busticket.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.ab;
import com.travel.bus.busticket.b.h;
import com.travel.bus.busticket.i.d;
import com.travel.bus.busticket.i.o;
import com.travel.bus.c.a;
import com.travel.bus.pojo.busticket.BusRecentsData;
import com.travel.bus.pojo.busticket.CJRBusOriginCity;
import com.travel.bus.pojo.busticket.CJRBusOriginCityItem;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.d.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRBusSelectCityActivity extends AJRBusBaseActivity implements View.OnClickListener, Response.ErrorListener, Response.Listener<IJRDataModel>, b, ab.b, h {
    private String A = "busSearchTag";
    /* access modifiers changed from: private */
    public boolean B = false;
    /* access modifiers changed from: private */
    public String C = "0";
    private final String D = "1";
    private final String E = "2";
    private String F;
    private TextWatcher G = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            if (AJRBusSelectCityActivity.this.y) {
                AJRBusSelectCityActivity.this.b();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (i4 >= i3 || charSequence.length() != 1) {
                boolean unused = AJRBusSelectCityActivity.this.y = false;
            } else {
                boolean unused2 = AJRBusSelectCityActivity.this.y = true;
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AJRBusSelectCityActivity.this.f21871i.setTag((Object) null);
            if (charSequence.length() > 0) {
                AJRBusSelectCityActivity aJRBusSelectCityActivity = AJRBusSelectCityActivity.this;
                aJRBusSelectCityActivity.f21865c = charSequence.toString();
                aJRBusSelectCityActivity.f21867e.setVisibility(0);
                return;
            }
            AJRBusSelectCityActivity.this.c();
            AJRBusSelectCityActivity.this.f21867e.setVisibility(8);
        }
    };
    private TextWatcher H = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            if (AJRBusSelectCityActivity.this.B) {
                AJRBusSelectCityActivity.this.b();
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (i4 >= i3 || charSequence.length() != 1) {
                boolean unused = AJRBusSelectCityActivity.this.B = false;
            } else {
                boolean unused2 = AJRBusSelectCityActivity.this.B = true;
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AJRBusSelectCityActivity.this.j.setTag((Object) null);
            if (charSequence.length() > 0) {
                AJRBusSelectCityActivity aJRBusSelectCityActivity = AJRBusSelectCityActivity.this;
                aJRBusSelectCityActivity.f21866d = charSequence.toString();
                aJRBusSelectCityActivity.f21868f.setVisibility(0);
                return;
            }
            AJRBusSelectCityActivity.this.c();
            AJRBusSelectCityActivity.this.f21868f.setVisibility(8);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    ConstraintLayout f21863a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintLayout f21864b;

    /* renamed from: c  reason: collision with root package name */
    String f21865c;

    /* renamed from: d  reason: collision with root package name */
    String f21866d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21867e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21868f;

    /* renamed from: g  reason: collision with root package name */
    CJRBusOriginCity f21869g;

    /* renamed from: h  reason: collision with root package name */
    List<BusRecentsData> f21870h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public EditText f21871i;
    /* access modifiers changed from: private */
    public EditText j;
    private ab k = null;
    private String l;
    private String m;
    private String n;
    private ProgressBar o;
    private ListView p;
    private boolean q = true;
    private LinearLayout r;
    private RoboTextView s;
    private ArrayList<CJRBusOriginCityItem> t;
    private AppCompatImageView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    /* access modifiers changed from: private */
    public boolean y = false;
    /* access modifiers changed from: private */
    public boolean z = true;

    public void onErrorResponse(VolleyError volleyError) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_select_origin_city);
        this.o = (ProgressBar) findViewById(R.id.progress_city);
        this.f21867e = (ImageView) findViewById(R.id.close_source);
        this.f21868f = (ImageView) findViewById(R.id.close_destination);
        this.F = o.a();
        this.f21870h = o.a(this.F, getApplicationContext());
        this.f21871i = (EditText) findViewById(R.id.city_search_source);
        this.j = (EditText) findViewById(R.id.city_search_destination);
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getStringExtra("activity_name");
            this.m = intent.getStringExtra("city_source_name");
            this.n = intent.getStringExtra("city_destination_name");
            this.f21871i.setTag((CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_source_item"));
            this.j.setTag((CJRBusOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_destination_item"));
        }
        this.f21871i.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AJRBusSelectCityActivity.this.b(view, motionEvent);
            }
        });
        this.j.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AJRBusSelectCityActivity.this.a(view, motionEvent);
            }
        });
        this.f21863a = (ConstraintLayout) findViewById(R.id.city_search_cl);
        this.f21864b = (ConstraintLayout) findViewById(R.id.city_search_destination_cl);
        this.v = (ImageView) findViewById(R.id.imageView11);
        this.x = (ImageView) findViewById(R.id.imageView10);
        this.w = (ImageView) findViewById(R.id.imageView9);
        this.r = (LinearLayout) findViewById(R.id.err_lyt);
        this.p = (ListView) findViewById(R.id.city_listview);
        this.s = (RoboTextView) findViewById(R.id.error_text_quote);
        String str = this.l;
        if (str == null || !str.equalsIgnoreCase("source")) {
            String str2 = this.m;
            if (str2 != null) {
                this.f21871i.setText(str2);
                this.f21863a.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
                this.f21864b.setBackground((Drawable) null);
                this.v.setVisibility(0);
                this.w.setVisibility(0);
                this.x.setVisibility(0);
                this.j.requestFocus();
                this.C = "2";
            } else {
                this.f21864b.setVisibility(8);
                this.f21863a.setBackground((Drawable) null);
                this.v.setVisibility(8);
                this.w.setVisibility(8);
                this.x.setVisibility(8);
                this.f21871i.requestFocus();
                this.C = "1";
            }
            String str3 = this.n;
            if (str3 != null) {
                this.j.setText(str3);
                this.f21864b.setVisibility(0);
                this.f21864b.setBackground((Drawable) null);
                this.f21863a.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
                this.v.setVisibility(0);
                this.w.setVisibility(0);
                this.x.setVisibility(0);
                this.j.requestFocus();
                this.C = "2";
                this.f21868f.setVisibility(0);
                this.j.setSelection(this.n.length());
            }
        } else {
            String str4 = this.m;
            if (str4 != null) {
                this.f21871i.setText(str4);
                this.f21864b.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
                this.f21863a.setBackground((Drawable) null);
                this.v.setVisibility(0);
                this.w.setVisibility(0);
                this.x.setVisibility(0);
                this.f21867e.setVisibility(0);
                this.f21871i.setSelection(this.m.length());
            } else {
                this.f21864b.setVisibility(8);
                this.f21863a.setBackground((Drawable) null);
                this.v.setVisibility(8);
                this.w.setVisibility(8);
                this.x.setVisibility(8);
            }
            String str5 = this.n;
            if (str5 != null) {
                this.j.setText(str5);
            }
            this.f21871i.requestFocus();
            this.C = "1";
        }
        this.f21871i.addTextChangedListener(this.G);
        this.j.addTextChangedListener(this.H);
        a.a(this.f21871i).debounce(500, TimeUnit.MILLISECONDS).filter(new q<String>() {
            public final /* synthetic */ boolean test(Object obj) throws Throwable {
                return !((String) obj).isEmpty();
            }
        }).distinctUntilChanged().subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).doOnNext(new g<String>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                String str = (String) obj;
                if (AJRBusSelectCityActivity.this.z) {
                    boolean unused = AJRBusSelectCityActivity.this.z = false;
                    AJRBusSelectCityActivity.this.c();
                    return;
                }
                String unused2 = AJRBusSelectCityActivity.this.C = "1";
                AJRBusSelectCityActivity.this.a(str);
            }
        }).subscribe(new g<String>() {
            public final /* bridge */ /* synthetic */ void accept(Object obj) throws Throwable {
            }
        });
        a.a(this.j).debounce(500, TimeUnit.MILLISECONDS).filter(new q<String>() {
            public final /* synthetic */ boolean test(Object obj) throws Throwable {
                return !((String) obj).isEmpty();
            }
        }).distinctUntilChanged().subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).doOnNext(new g<String>() {
            public final /* synthetic */ void accept(Object obj) throws Throwable {
                String unused = AJRBusSelectCityActivity.this.C = "2";
                AJRBusSelectCityActivity.this.a((String) obj);
            }
        }).subscribe(new g<String>() {
            public final /* bridge */ /* synthetic */ void accept(Object obj) throws Throwable {
            }
        });
        this.u = (AppCompatImageView) findViewById(R.id.back_button);
        this.u.setOnClickListener(this);
        this.f21867e.setOnClickListener(this);
        this.f21868f.setOnClickListener(this);
        c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.C = "1";
            this.f21864b.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
            this.f21863a.setBackground((Drawable) null);
            if (this.f21871i.getText().length() != 0) {
                this.f21867e.setVisibility(0);
                this.f21868f.setVisibility(8);
                a(this.f21871i.getText().toString());
            } else {
                this.f21867e.setVisibility(8);
                c();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.C = "2";
            this.f21864b.setBackground((Drawable) null);
            this.f21863a.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
            if (this.j.getText().length() != 0) {
                this.f21868f.setVisibility(0);
                this.f21867e.setVisibility(8);
                a(this.j.getText().toString());
            } else {
                this.f21868f.setVisibility(8);
                c();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void b() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_home");
        hashMap.put("event_action", "auto_suggest_ignored");
        hashMap.put("event_label", this.f21865c);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: private */
    public void c() {
        this.r.setVisibility(8);
        com.travel.bus.a.a();
        String f2 = com.travel.bus.a.b().f("busSearchPopularCityUrl");
        this.q = true;
        this.z = true;
        b(f2);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        com.travel.bus.a.a();
        String f2 = com.travel.bus.a.b().f("busSearchCityUrl");
        String uri = (f2 == null || f2.isEmpty()) ? "" : Uri.parse(f2).buildUpon().appendPath(str).build().toString();
        this.q = false;
        b(uri);
    }

    private void b(String str) {
        if (str != null) {
            new ArrayList().add(Integer.valueOf(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE));
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str;
            bVar.f42881e = null;
            bVar.f42882f = null;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new CJRBusOriginCity();
            bVar.j = this;
            bVar.t = d();
            bVar.n = a.b.SILENT;
            bVar.o = "bus-seat-layout-page";
            com.paytm.network.a l2 = bVar.l();
            l2.a((Object) this.A);
            l2.a();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f21871i != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f21871i.getWindowToken(), 0);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (!isFinishing() && (iJRPaytmDataModel instanceof CJRBusOriginCity)) {
            ProgressBar progressBar = this.o;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this.f21869g = (CJRBusOriginCity) iJRPaytmDataModel;
            CJRBusOriginCity cJRBusOriginCity = this.f21869g;
            if (cJRBusOriginCity == null || cJRBusOriginCity.getmOriginCityItems() == null || this.f21869g.getmOriginCityItems().size() <= 0) {
                this.r.setVisibility(0);
                this.p.setVisibility(8);
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus home page");
                hashMap.put("bus_city_search_keyword", this.f21871i.getText().toString().trim());
                com.travel.bus.a.a();
                com.travel.bus.a.b().a("bus_home_city_search_no_result_found", (Map<String, Object>) hashMap, (Context) this);
                return;
            }
            this.p.setVisibility(0);
            this.r.setVisibility(8);
            a(this.f21869g);
            if (this.z) {
                this.z = false;
            }
        }
    }

    private void a(CJRBusOriginCity cJRBusOriginCity) {
        if (cJRBusOriginCity != null && cJRBusOriginCity.getmOriginCityItems() != null && cJRBusOriginCity.getmOriginCityItems().size() > 0) {
            ArrayList arrayList = new ArrayList();
            a((ArrayList<CJRBusOriginCityItem>) arrayList);
            int size = cJRBusOriginCity.getmOriginCityItems().size();
            Iterator<CJRBusOriginCityItem> it2 = cJRBusOriginCity.getmOriginCityItems().iterator();
            while (it2.hasNext()) {
                CJRBusOriginCityItem next = it2.next();
                next.setItemType(this.z ? 3 : 0);
                arrayList.add(next);
            }
            this.k = new ab(this, arrayList, this, (this.C.equalsIgnoreCase("1") ? this.f21871i : this.j).getText().toString());
            this.p.setAdapter(this.k);
            this.p.setOnItemClickListener(new AdapterView.OnItemClickListener(arrayList, size) {
                private final /* synthetic */ ArrayList f$1;
                private final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                    AJRBusSelectCityActivity.this.a(this.f$1, this.f$2, adapterView, view, i2, j);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ArrayList arrayList, int i2, AdapterView adapterView, View view, int i3, long j2) {
        int i4;
        String str;
        int i5;
        EditText editText;
        CJRBusOriginCityItem cJRBusOriginCityItem = (CJRBusOriginCityItem) this.k.getItem(i3);
        if (cJRBusOriginCityItem.getItemType() != 2) {
            if (cJRBusOriginCityItem != null) {
                i4 = cJRBusOriginCityItem.getItemType();
            } else {
                i4 = -1;
            }
            if (i4 == 3 || i4 == 0) {
                String str2 = i4 == 3 ? "Popular City" : "Suggested City";
                ArrayList<CJRBusOriginCityItem> arrayList2 = this.t;
                if (arrayList2 == null || arrayList2.size() <= 0 || (editText = this.f21871i) == null || !editText.getText().toString().trim().equalsIgnoreCase("")) {
                    i5 = arrayList.indexOf(cJRBusOriginCityItem);
                } else {
                    i5 = (arrayList.indexOf(cJRBusOriginCityItem) - this.t.size()) - 1;
                }
                if (this.f21871i.getText().length() == 0 || !"2".equals(this.C)) {
                    a(i2, cJRBusOriginCityItem, str2, true);
                    this.f21871i.setText(cJRBusOriginCityItem.getDisplayCityName());
                    if (cJRBusOriginCityItem != null && cJRBusOriginCityItem.isMultiDistrict()) {
                        a(cJRBusOriginCityItem);
                    }
                    this.f21871i.setTag(cJRBusOriginCityItem);
                    this.f21864b.setVisibility(0);
                    this.f21863a.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
                    this.f21864b.setBackground((Drawable) null);
                    this.v.setVisibility(0);
                    this.w.setVisibility(0);
                    this.x.setVisibility(0);
                    this.j.requestFocus();
                    this.C = "2";
                    this.z = true;
                } else {
                    this.j.setText(cJRBusOriginCityItem.getDisplayCityName());
                    if (cJRBusOriginCityItem != null && cJRBusOriginCityItem.isMultiDistrict()) {
                        a(cJRBusOriginCityItem);
                    }
                    this.j.setTag(cJRBusOriginCityItem);
                    a(i2, cJRBusOriginCityItem, str2, false);
                }
                String str3 = str2;
                i3 = i5;
                str = str3;
            } else {
                if (i3 != 0) {
                    EditText editText2 = this.f21871i;
                    List<BusRecentsData> list = this.f21870h;
                    editText2.setText(list.get(list.size() - i3).getSource().getDisplayCityName());
                    if (cJRBusOriginCityItem != null && cJRBusOriginCityItem.isMultiDistrict()) {
                        a(cJRBusOriginCityItem);
                    }
                    EditText editText3 = this.j;
                    List<BusRecentsData> list2 = this.f21870h;
                    editText3.setText(list2.get(list2.size() - i3).getDestination().getDisplayCityName());
                    if (cJRBusOriginCityItem != null && cJRBusOriginCityItem.isMultiDistrict()) {
                        a(cJRBusOriginCityItem);
                    }
                    EditText editText4 = this.f21871i;
                    List<BusRecentsData> list3 = this.f21870h;
                    editText4.setTag(list3.get(list3.size() - i3).getSource());
                    EditText editText5 = this.j;
                    List<BusRecentsData> list4 = this.f21870h;
                    editText5.setTag(list4.get(list4.size() - i3).getDestination());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("event_label", this.f21871i.getText().toString() + "/" + this.j.getText().toString());
                hashMap.put("event_label2", String.valueOf(i3));
                hashMap.put("userid", com.paytm.utility.b.n((Context) this));
                com.travel.bus.a.a();
                com.travel.bus.a.a("customEvent", "/bus-tickets", "bus_home", "recent_searches_selection", hashMap);
                str = "Recent Search";
            }
            if (this.f21871i.getText().length() != 0 && this.j.getText().length() != 0) {
                Intent intent = new Intent();
                if (this.f21871i.getText().toString().trim().length() != 0) {
                    if (this.f21871i.getTag() != null) {
                        intent.putExtra("intent_extra_selected_source_city_name", this.f21871i.getText().toString());
                        intent.putExtra("intent_extra_selected_city_source_item", (CJRBusOriginCityItem) this.f21871i.getTag());
                    } else {
                        this.f21871i.requestFocus();
                        this.f21863a.setBackground((Drawable) null);
                        this.f21864b.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
                        return;
                    }
                }
                if (this.j.getText().toString().trim().length() != 0) {
                    if (this.j.getTag() != null) {
                        intent.putExtra("intent_extra_selected_destination_city_name", this.j.getText().toString());
                        intent.putExtra("intent_extra_selected_city_destination_item", (CJRBusOriginCityItem) this.j.getTag());
                    } else {
                        this.j.requestFocus();
                        this.f21864b.setBackground((Drawable) null);
                        this.f21863a.setBackgroundColor(getResources().getColor(R.color.light_gray_filter_screen));
                        return;
                    }
                }
                intent.putExtra("intent_extra_selected_city_position", i3);
                intent.putExtra("intent_extra_city_catagory", str);
                intent.putExtra("intent_extra_last_known_search_keyword", this.f21871i.getText().toString().trim());
                setResult(-1, intent);
                finish();
            }
        }
    }

    public void onDestroy() {
        try {
            if (this.k != null) {
                ab abVar = this.k;
                if (abVar.f21544a != null) {
                    abVar.f21544a.clear();
                    abVar.f21544a = null;
                }
                if (abVar.f21545b != null) {
                    abVar.f21545b.clear();
                    abVar.f21545b = null;
                }
            }
            com.paytm.network.a.a(getApplicationContext(), (Object) this.A);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
        super.onDestroy();
    }

    public final void a(boolean z2) {
        TextView textView = (TextView) findViewById(R.id.no_result_text);
        textView.setText(getResources().getString(R.string.bus_no_city_result));
        if (z2) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    private void a(ArrayList<CJRBusOriginCityItem> arrayList) {
        if (this.q) {
            CJRBusOriginCityItem cJRBusOriginCityItem = new CJRBusOriginCityItem();
            cJRBusOriginCityItem.setCityName(getResources().getText(R.string.bus_city_popular_cities).toString());
            cJRBusOriginCityItem.setItemType(2);
            arrayList.add(0, cJRBusOriginCityItem);
            this.f21870h = o.a(this.F, getApplicationContext());
            String str = this.l;
            if (str == null || !str.equalsIgnoreCase("source")) {
                this.t = c(this.F + "RecentSearchDestinationCity");
            } else {
                this.t = c(this.F + "RecentSearchOriginCity");
            }
            List<BusRecentsData> list = this.f21870h;
            if (list != null) {
                for (BusRecentsData next : list) {
                    CJRBusOriginCityItem cJRBusOriginCityItem2 = new CJRBusOriginCityItem();
                    cJRBusOriginCityItem2.setCityName(next.getSource().getDisplayCityName());
                    cJRBusOriginCityItem2.setDestinationCityName(next.getDestination().getDisplayCityName());
                    cJRBusOriginCityItem2.setItemType(1);
                    arrayList.add(0, cJRBusOriginCityItem2);
                }
                if (this.f21870h.size() > 0) {
                    CJRBusOriginCityItem cJRBusOriginCityItem3 = new CJRBusOriginCityItem();
                    cJRBusOriginCityItem3.setCityName("Recent Searches");
                    cJRBusOriginCityItem3.setItemType(2);
                    arrayList.add(0, cJRBusOriginCityItem3);
                    return;
                }
                return;
            }
            return;
        }
        CJRBusOriginCityItem cJRBusOriginCityItem4 = new CJRBusOriginCityItem();
        cJRBusOriginCityItem4.setCityName(getResources().getText(R.string.suggested_cities).toString());
        cJRBusOriginCityItem4.setItemType(2);
        arrayList.add(0, cJRBusOriginCityItem4);
    }

    private ArrayList<CJRBusOriginCityItem> c(String str) {
        com.paytm.b.a.a a2 = com.travel.bus.b.a.a(getApplicationContext());
        if (!a2.b(str, false)) {
            return null;
        }
        return (ArrayList) new f().a(a2.b(str, "", false), new com.google.gson.b.a<ArrayList<CJRBusOriginCityItem>>() {
        }.getType());
    }

    public final void a() {
        com.travel.bus.b.a.a(getApplicationContext()).a("recent-search-list", "", false);
        o.a(this.F + "recent-search-list");
        c();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close_source) {
            this.f21871i.setText("");
            b();
            a(this.f21869g);
        } else if (id == R.id.close_destination) {
            this.j.setText("");
            b();
            a(this.f21869g);
        } else if (id == R.id.back_button) {
            b();
            EditText editText = this.f21871i;
            if (!(editText == null || editText.getText() == null || this.f21871i.getText().length() == 0 || this.f21871i.getTag() == null)) {
                CJRBusOriginCityItem cJRBusOriginCityItem = (CJRBusOriginCityItem) this.f21871i.getTag();
                if (cJRBusOriginCityItem.getItemType() != 2) {
                    int itemType = cJRBusOriginCityItem != null ? cJRBusOriginCityItem.getItemType() : -1;
                    String str = (itemType == 3 || itemType == 0) ? itemType == 3 ? "Popular City" : "Suggested City" : "Recent Search";
                    Intent intent = new Intent();
                    intent.putExtra("intent_extra_selected_source_city_name", this.f21871i.getText().toString());
                    intent.putExtra("intent_extra_selected_city_source_item", cJRBusOriginCityItem);
                    intent.putExtra("intent_extra_city_catagory", str);
                    intent.putExtra("intent_extra_last_known_search_keyword", this.f21871i.getText().toString().trim());
                    setResult(-1, intent);
                }
            }
            finish();
        }
    }

    private void a(int i2, CJRBusOriginCityItem cJRBusOriginCityItem, String str, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_home");
        if (z2) {
            hashMap.put("event_action", "from_selected");
        } else {
            hashMap.put("event_action", "to_selected");
        }
        hashMap.put("event_label3", cJRBusOriginCityItem.getMatchType());
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, Integer.valueOf(i2));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-home-screen");
        hashMap.put("vertical_name", "bus");
        hashMap.put("event_label", cJRBusOriginCityItem.getDisplayCityName());
        hashMap.put("event_label2", str);
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private void a(CJRBusOriginCityItem cJRBusOriginCityItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", "city=" + cJRBusOriginCityItem.getDisplayCityName() + ";district=" + cJRBusOriginCityItem.getDistrict() + ";state=" + cJRBusOriginCityItem.getState());
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets", "bus_home", "multi_district_selected", hashMap);
    }

    private static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusSelectCityScreen");
            if (d.a().f22430h != null) {
                jSONObject.put("requestId", d.a().f22430h);
            }
        } catch (JSONException e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", "error_popup");
        if (!(networkCustomError == null || networkCustomError.getAlertMessage() == null)) {
            hashMap.put("event_label", networkCustomError.getAlertMessage());
            hashMap.put("event_label2", Integer.valueOf(i2));
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        if (!isFinishing()) {
            this.o.setVisibility(8);
        }
    }

    public /* synthetic */ void onResponse(Object obj) {
        isFinishing();
    }
}
