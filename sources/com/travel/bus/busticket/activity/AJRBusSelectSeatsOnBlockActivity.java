package com.travel.bus.busticket.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.ac;
import com.travel.bus.busticket.a.q;
import com.travel.bus.busticket.b.c;
import com.travel.bus.busticket.b.e;
import com.travel.bus.busticket.fragment.j;
import com.travel.bus.busticket.i.o;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRBusSelectSeatsOnBlockActivity extends CJRActionBarBaseActivity implements View.OnClickListener, b, c, j.a {

    /* renamed from: b  reason: collision with root package name */
    static e f21893b;
    /* access modifiers changed from: private */
    public ArrayList<TripBusDetailsItem> A;
    /* access modifiers changed from: private */
    public ArrayList<TripBusDetailsItem> B;
    /* access modifiers changed from: private */
    public ArrayList<TripBusDetailsItem> C;
    private int D;
    private int E;
    /* access modifiers changed from: private */
    public HashMap<Long, Long> F;
    /* access modifiers changed from: private */
    public HashMap<Long, Long> G;
    /* access modifiers changed from: private */
    public int H = 0;
    /* access modifiers changed from: private */
    public int I = 0;
    private LinearLayout J;
    private LinearLayout K;
    /* access modifiers changed from: private */
    public LinearLayout L;
    private LinearLayout M;
    private Button N;
    private Button O;
    /* access modifiers changed from: private */
    public View P;
    /* access modifiers changed from: private */
    public View Q;
    private View R;
    private q S;
    private String T;
    private String U = "";
    private Toast V;
    private ImageView W;
    private boolean X = false;
    private String Y;
    private com.travel.bus.d.a Z;

    /* renamed from: a  reason: collision with root package name */
    Bundle f21894a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TripBusDetail f21895c;

    /* renamed from: d  reason: collision with root package name */
    private int f21896d;

    /* renamed from: e  reason: collision with root package name */
    private int f21897e;

    /* renamed from: f  reason: collision with root package name */
    private CJRBusSearchInput f21898f;

    /* renamed from: g  reason: collision with root package name */
    private CJRBusSearchItem f21899g;

    /* renamed from: h  reason: collision with root package name */
    private String f21900h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<TripBusDetailsItem> f21901i;
    private ArrayList<TripBusDetailsItem> j;
    private ac k;
    private TextView l;
    private TextView m;
    private TextView n;
    private CJRLocation o;
    private CJRLocation p;
    private ArrayList<CJRPassengerDetails> q;
    private RelativeLayout r;
    private RelativeLayout s;
    private boolean t = false;
    private long u;
    private RecyclerView v;
    /* access modifiers changed from: private */
    public RelativeLayout w;
    /* access modifiers changed from: private */
    public TextView x;
    /* access modifiers changed from: private */
    public TextView y;
    private ViewPager z;

    static /* synthetic */ int e(AJRBusSelectSeatsOnBlockActivity aJRBusSelectSeatsOnBlockActivity) {
        int i2 = aJRBusSelectSeatsOnBlockActivity.H;
        aJRBusSelectSeatsOnBlockActivity.H = i2 + 1;
        return i2;
    }

    static /* synthetic */ int g(AJRBusSelectSeatsOnBlockActivity aJRBusSelectSeatsOnBlockActivity) {
        int i2 = aJRBusSelectSeatsOnBlockActivity.I;
        aJRBusSelectSeatsOnBlockActivity.I = i2 + 1;
        return i2;
    }

    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onCreate(Bundle bundle) {
        this.f21894a = bundle;
        this.Z = (com.travel.bus.d.a) am.a((FragmentActivity) this).a(com.travel.bus.d.a.class);
        this.Z.f22537a.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJRBusSelectSeatsOnBlockActivity.this.a((List) obj);
            }
        });
        super.onCreate(bundle);
        this.mFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        setBackButtonEnabled(false);
        Intent intent = getIntent();
        this.f21901i = new ArrayList<>();
        if (intent != null) {
            if (intent.hasExtra("intent_extra_bus_search_result_item")) {
                this.f21899g = (CJRBusSearchItem) intent.getSerializableExtra("intent_extra_bus_search_result_item");
            }
            if (intent.hasExtra("intent_extra_bus_search")) {
                this.f21900h = intent.getStringExtra("intent_extra_bus_search");
            }
            if (intent.hasExtra("intent_extra_bus_search_input")) {
                this.f21898f = (CJRBusSearchInput) intent.getSerializableExtra("intent_extra_bus_search_input");
            }
            if (intent.hasExtra("intent_extra_selected_seats")) {
                this.j = (ArrayList) intent.getSerializableExtra("intent_extra_selected_seats");
            }
            if (intent.hasExtra("intent_extra_passenger_details")) {
                this.q = (ArrayList) intent.getSerializableExtra("intent_extra_passenger_details");
            }
            if (intent.hasExtra("intent_extra_bus_trip_detail")) {
                this.f21895c = (TripBusDetail) intent.getSerializableExtra("intent_extra_bus_trip_detail");
            }
            if (intent.hasExtra("intent_extra_selected_boarding_point")) {
                this.o = (CJRLocation) intent.getSerializableExtra("intent_extra_selected_boarding_point");
            }
            if (intent.hasExtra("intent_extra_selected_dropping_point")) {
                this.p = (CJRLocation) intent.getSerializableExtra("intent_extra_selected_dropping_point");
            }
            if (intent.hasExtra("bus_intent_block_action_error")) {
                this.Y = intent.getStringExtra("bus_intent_block_action_error");
            }
        }
        if (this.mActionBar == null) {
            this.mActionBar = getSupportActionBar();
        }
        this.mActionBar.a(false);
        this.mActionBar.b(false);
        this.mActionBar.f();
        CJRBusSearchItem cJRBusSearchItem = this.f21899g;
        if (cJRBusSearchItem != null) {
            a(cJRBusSearchItem.getTripId(), String.valueOf(this.f21899g.getOperatorObj().getProviderId()), this.f21899g.getDepartureDatetime());
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private void a() {
        this.l = (TextView) findViewById(R.id.txt_selected_seats);
        this.m = (TextView) findViewById(R.id.txt_label_selected_seats);
        this.n = (TextView) findViewById(R.id.txt_total_fare);
        this.v = (RecyclerView) findViewById(R.id.horizontal_list_view_price_filter);
        this.v.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.x = (TextView) findViewById(R.id.lower_birth_selection);
        this.y = (TextView) findViewById(R.id.upper_birth_selection);
        this.s = (RelativeLayout) findViewById(R.id.bus_price_filter_recycler_layout);
        this.w = (RelativeLayout) findViewById(R.id.top_bar_conatiner);
        this.L = (LinearLayout) findViewById(R.id.lower_upper_root_layout);
        this.M = (LinearLayout) findViewById(R.id.ladies_seat_info_layout);
        this.J = (LinearLayout) findViewById(R.id.seat_root_layout);
        this.K = (LinearLayout) findViewById(R.id.fare_root_layout);
        this.N = (Button) findViewById(R.id.btn_proceed);
        this.N.setClickable(true);
        this.N.setOnClickListener(this);
        this.O = (Button) findViewById(R.id.btn_change_bus);
        this.O.setClickable(true);
        this.O.setOnClickListener(this);
        this.P = findViewById(R.id.root_divider2);
        this.Q = findViewById(R.id.separator_indicator);
        this.R = findViewById(R.id.ladies_seat_info_layout_divider);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.W = (ImageView) findViewById(R.id.select_seat_close);
        this.W.setOnClickListener(this);
        com.paytm.utility.b.a(this.l);
        com.paytm.utility.b.a(this.n);
        com.paytm.utility.b.a(this.m);
        com.paytm.utility.b.a((TextView) findViewById(R.id.txt_label_total_fare));
        this.r = (RelativeLayout) findViewById(R.id.lyt_progress_bar);
        p();
    }

    private void b() {
        try {
            TextView textView = (TextView) findViewById(R.id.txt_ladies_seat_info);
            com.travel.bus.a.a();
            String f2 = com.travel.bus.a.b().f("showLadiesSeatMessage");
            if (!TextUtils.isEmpty(f2)) {
                textView.setVisibility(0);
                textView.setText(f2);
                return;
            }
            textView.setVisibility(8);
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (list.size() > 1) {
            this.s.setVisibility(0);
            this.v.setVisibility(0);
            this.S = new q(this, list);
            this.v.setAdapter(this.S);
            this.S.notifyDataSetChanged();
            return;
        }
        this.v.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ee A[LOOP:2: B:48:0x00ee->B:55:0x010b, LOOP_START, PHI: r1 
      PHI: (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:47:0x00ec, B:55:0x010b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            r6.T = r0
            if (r7 == 0) goto L_0x0008
            r6.T = r7
        L_0x0008:
            java.lang.String r0 = "All"
            boolean r0 = r7.equalsIgnoreCase(r0)
            r1 = 0
            if (r0 == 0) goto L_0x001e
            android.widget.TextView r0 = r6.x
            int r2 = com.travel.bus.R.string.lower_deck
            java.lang.String r2 = r6.getString(r2)
            r0.setText(r2)
            goto L_0x00df
        L_0x001e:
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r6.A
            if (r0 == 0) goto L_0x004b
            r0 = 0
            r2 = 0
        L_0x0024:
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r3 = r6.A
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x004c
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r3 = r6.A
            java.lang.Object r3 = r3.get(r0)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r3 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r3
            if (r3 == 0) goto L_0x0048
            boolean r4 = r3.getAvailable()
            if (r4 == 0) goto L_0x0048
            java.lang.String r3 = r3.getFare()
            boolean r3 = r3.equalsIgnoreCase(r7)
            if (r3 == 0) goto L_0x0048
            int r2 = r2 + 1
        L_0x0048:
            int r0 = r0 + 1
            goto L_0x0024
        L_0x004b:
            r2 = 0
        L_0x004c:
            r6.D = r2
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r6.B
            if (r0 == 0) goto L_0x007b
            r0 = 0
            r2 = 0
        L_0x0054:
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r3 = r6.B
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x007c
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r3 = r6.B
            java.lang.Object r3 = r3.get(r0)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r3 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r3
            if (r3 == 0) goto L_0x0078
            boolean r4 = r3.getAvailable()
            if (r4 == 0) goto L_0x0078
            java.lang.String r3 = r3.getFare()
            boolean r3 = r3.equalsIgnoreCase(r7)
            if (r3 == 0) goto L_0x0078
            int r2 = r2 + 1
        L_0x0078:
            int r0 = r0 + 1
            goto L_0x0054
        L_0x007b:
            r2 = 0
        L_0x007c:
            r6.E = r2
            int r0 = r6.D
            java.lang.String r2 = ")"
            java.lang.String r3 = " ("
            if (r0 == 0) goto L_0x00ab
            android.widget.TextView r0 = r6.x
            if (r0 == 0) goto L_0x00ab
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = com.travel.bus.R.string.lower_deck
            java.lang.String r5 = r6.getString(r5)
            r4.append(r5)
            r4.append(r3)
            int r5 = r6.D
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r0.setText(r4)
            goto L_0x00b6
        L_0x00ab:
            android.widget.TextView r0 = r6.x
            int r4 = com.travel.bus.R.string.lower_deck
            java.lang.String r4 = r6.getString(r4)
            r0.setText(r4)
        L_0x00b6:
            int r0 = r6.E
            if (r0 == 0) goto L_0x00df
            android.widget.TextView r0 = r6.y
            if (r0 == 0) goto L_0x00df
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = com.travel.bus.R.string.upper_deck
            java.lang.String r5 = r6.getString(r5)
            r4.append(r5)
            r4.append(r3)
            int r3 = r6.E
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.setText(r2)
            goto L_0x00ea
        L_0x00df:
            android.widget.TextView r0 = r6.y
            int r2 = com.travel.bus.R.string.upper_deck
            java.lang.String r2 = r6.getString(r2)
            r0.setText(r2)
        L_0x00ea:
            com.travel.bus.busticket.a.ac r0 = r6.k
            if (r0 == 0) goto L_0x010e
        L_0x00ee:
            com.travel.bus.busticket.a.ac r0 = r6.k
            int r0 = r0.getCount()
            if (r1 >= r0) goto L_0x010e
            com.travel.bus.busticket.a.ac r0 = r6.k
            androidx.fragment.app.Fragment r0 = r0.a(r1)
            if (r0 == 0) goto L_0x010b
            com.travel.bus.busticket.a.ac r0 = r6.k
            androidx.fragment.app.Fragment r0 = r0.a(r1)
            com.travel.bus.busticket.fragment.j r0 = (com.travel.bus.busticket.fragment.j) r0
            if (r0 == 0) goto L_0x010b
            r0.a((java.lang.String) r7)
        L_0x010b:
            int r1 = r1 + 1
            goto L_0x00ee
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSelectSeatsOnBlockActivity.a(java.lang.String):void");
    }

    class a extends AsyncTask<Void, Void, Void> {
        private a() {
        }

        /* synthetic */ a(AJRBusSelectSeatsOnBlockActivity aJRBusSelectSeatsOnBlockActivity, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AJRBusSelectSeatsOnBlockActivity.this.w.setVisibility(0);
            if (AJRBusSelectSeatsOnBlockActivity.this.B.size() > 0) {
                AJRBusSelectSeatsOnBlockActivity.this.L.setVisibility(0);
                AJRBusSelectSeatsOnBlockActivity.this.P.setVisibility(0);
                AJRBusSelectSeatsOnBlockActivity.this.Q.setVisibility(0);
            }
            if (AJRBusSelectSeatsOnBlockActivity.this.A.size() == 0) {
                AJRBusSelectSeatsOnBlockActivity.this.x.setVisibility(8);
                AJRBusSelectSeatsOnBlockActivity.this.y.setBackgroundResource(R.drawable.travel_res_bus_right_selected_upper_only);
                AJRBusSelectSeatsOnBlockActivity.this.y.setTextColor(AJRBusSelectSeatsOnBlockActivity.this.getResources().getColor(R.color.white));
            }
            AJRBusSelectSeatsOnBlockActivity.this.c();
            try {
                AJRBusSelectSeatsOnBlockActivity aJRBusSelectSeatsOnBlockActivity = AJRBusSelectSeatsOnBlockActivity.this;
                ArrayList i2 = AJRBusSelectSeatsOnBlockActivity.this.A;
                ArrayList j = AJRBusSelectSeatsOnBlockActivity.this.B;
                ArrayList unused = AJRBusSelectSeatsOnBlockActivity.this.C;
                AJRBusSelectSeatsOnBlockActivity.a(aJRBusSelectSeatsOnBlockActivity, i2, j, (long) (AJRBusSelectSeatsOnBlockActivity.this.F.size() + AJRBusSelectSeatsOnBlockActivity.this.H), (long) (AJRBusSelectSeatsOnBlockActivity.this.G.size() + AJRBusSelectSeatsOnBlockActivity.this.I));
            } catch (IllegalStateException e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            long j;
            long j2;
            AJRBusSelectSeatsOnBlockActivity aJRBusSelectSeatsOnBlockActivity = AJRBusSelectSeatsOnBlockActivity.this;
            ArrayList unused = aJRBusSelectSeatsOnBlockActivity.C = aJRBusSelectSeatsOnBlockActivity.f21895c.getBody();
            if (AJRBusSelectSeatsOnBlockActivity.this.C == null || AJRBusSelectSeatsOnBlockActivity.this.C.size() <= 0) {
                return null;
            }
            ArrayList unused2 = AJRBusSelectSeatsOnBlockActivity.this.A = new ArrayList();
            ArrayList unused3 = AJRBusSelectSeatsOnBlockActivity.this.B = new ArrayList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Iterator it2 = AJRBusSelectSeatsOnBlockActivity.this.C.iterator();
            while (it2.hasNext()) {
                TripBusDetailsItem tripBusDetailsItem = (TripBusDetailsItem) it2.next();
                if (tripBusDetailsItem.getLowerBerth().booleanValue()) {
                    if (!hashMap.containsKey(Long.valueOf(tripBusDetailsItem.getRow()))) {
                        hashMap.put(Long.valueOf(tripBusDetailsItem.getRow()), tripBusDetailsItem);
                    } else if (tripBusDetailsItem.getWidth() > ((TripBusDetailsItem) hashMap.get(Long.valueOf(tripBusDetailsItem.getRow()))).getWidth()) {
                        hashMap.put(Long.valueOf(tripBusDetailsItem.getRow()), tripBusDetailsItem);
                    }
                } else if (!hashMap2.containsKey(Long.valueOf(tripBusDetailsItem.getRow()))) {
                    hashMap2.put(Long.valueOf(tripBusDetailsItem.getRow()), tripBusDetailsItem);
                } else if (tripBusDetailsItem.getWidth() > ((TripBusDetailsItem) hashMap2.get(Long.valueOf(tripBusDetailsItem.getRow()))).getWidth()) {
                    hashMap2.put(Long.valueOf(tripBusDetailsItem.getRow()), tripBusDetailsItem);
                }
            }
            TreeMap treeMap = new TreeMap(hashMap);
            TreeMap treeMap2 = new TreeMap(hashMap2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry value : treeMap.entrySet()) {
                arrayList.add(value.getValue());
            }
            for (Map.Entry value2 : treeMap2.entrySet()) {
                arrayList2.add(value2.getValue());
            }
            HashMap unused4 = AJRBusSelectSeatsOnBlockActivity.this.F = new HashMap();
            HashMap unused5 = AJRBusSelectSeatsOnBlockActivity.this.G = new HashMap();
            if (!arrayList.isEmpty()) {
                long j3 = 0;
                int i2 = 0;
                while (i2 < arrayList.size() - 1) {
                    if (((TripBusDetailsItem) arrayList.get(i2)).getWidth() == 1) {
                        int i3 = i2 + 1;
                        if (((TripBusDetailsItem) arrayList.get(i3)).getRow() - ((TripBusDetailsItem) arrayList.get(i2)).getRow() > 1) {
                            AJRBusSelectSeatsOnBlockActivity.e(AJRBusSelectSeatsOnBlockActivity.this);
                            j3 += 2;
                            i2++;
                            AJRBusSelectSeatsOnBlockActivity.this.F.put(Long.valueOf(((TripBusDetailsItem) arrayList.get(i2)).getRow()), Long.valueOf(j3));
                        } else {
                            j2 = ((TripBusDetailsItem) arrayList.get(i3)).getRow() - ((TripBusDetailsItem) arrayList.get(i2)).getRow();
                        }
                    } else {
                        j2 = ((TripBusDetailsItem) arrayList.get(i2)).getWidth();
                    }
                    j3 += j2;
                    i2++;
                    AJRBusSelectSeatsOnBlockActivity.this.F.put(Long.valueOf(((TripBusDetailsItem) arrayList.get(i2)).getRow()), Long.valueOf(j3));
                }
                AJRBusSelectSeatsOnBlockActivity.this.F.put(Long.valueOf(((TripBusDetailsItem) arrayList.get(0)).getRow()), 0L);
            }
            if (!arrayList2.isEmpty()) {
                long j4 = 0;
                int i4 = 0;
                while (i4 < arrayList2.size() - 1) {
                    if (((TripBusDetailsItem) arrayList2.get(i4)).getWidth() == 1) {
                        int i5 = i4 + 1;
                        if (((TripBusDetailsItem) arrayList2.get(i5)).getRow() - ((TripBusDetailsItem) arrayList2.get(i4)).getRow() > 1) {
                            AJRBusSelectSeatsOnBlockActivity.g(AJRBusSelectSeatsOnBlockActivity.this);
                            j4 += 2;
                            i4++;
                            AJRBusSelectSeatsOnBlockActivity.this.G.put(Long.valueOf(((TripBusDetailsItem) arrayList2.get(i4)).getRow()), Long.valueOf(j4));
                        } else {
                            j = ((TripBusDetailsItem) arrayList2.get(i5)).getRow() - ((TripBusDetailsItem) arrayList2.get(i4)).getRow();
                        }
                    } else {
                        j = ((TripBusDetailsItem) arrayList2.get(i4)).getWidth();
                    }
                    j4 += j;
                    i4++;
                    AJRBusSelectSeatsOnBlockActivity.this.G.put(Long.valueOf(((TripBusDetailsItem) arrayList2.get(i4)).getRow()), Long.valueOf(j4));
                }
                AJRBusSelectSeatsOnBlockActivity.this.G.put(Long.valueOf(((TripBusDetailsItem) arrayList2.get(0)).getRow()), 0L);
            }
            Iterator it3 = AJRBusSelectSeatsOnBlockActivity.this.C.iterator();
            while (it3.hasNext()) {
                TripBusDetailsItem tripBusDetailsItem2 = (TripBusDetailsItem) it3.next();
                if (tripBusDetailsItem2 != null) {
                    if (tripBusDetailsItem2.getLowerBerth().booleanValue()) {
                        if (AJRBusSelectSeatsOnBlockActivity.this.F.containsKey(Long.valueOf(tripBusDetailsItem2.getRow()))) {
                            tripBusDetailsItem2.setRow(((Long) AJRBusSelectSeatsOnBlockActivity.this.F.get(Long.valueOf(tripBusDetailsItem2.getRow()))).longValue());
                        }
                        AJRBusSelectSeatsOnBlockActivity.this.A.add(tripBusDetailsItem2);
                    } else {
                        if (AJRBusSelectSeatsOnBlockActivity.this.G.containsKey(Long.valueOf(tripBusDetailsItem2.getRow()))) {
                            tripBusDetailsItem2.setRow(((Long) AJRBusSelectSeatsOnBlockActivity.this.G.get(Long.valueOf(tripBusDetailsItem2.getRow()))).longValue());
                        }
                        AJRBusSelectSeatsOnBlockActivity.this.B.add(tripBusDetailsItem2);
                    }
                }
            }
            return null;
        }
    }

    public final void a(TripBusDetailsItem tripBusDetailsItem, View view) {
        ac acVar;
        if (!(tripBusDetailsItem == null || this.f21901i == null)) {
            if (tripBusDetailsItem.getFare() != null) {
                this.U = tripBusDetailsItem.getFare();
            }
            if (this.f21901i.contains(tripBusDetailsItem)) {
                this.f21901i.remove(tripBusDetailsItem);
            } else {
                TripBusDetail tripBusDetail = this.f21895c;
                if (!(tripBusDetail == null || tripBusDetail.getBody() == null || this.f21895c.getBody().size() <= 0)) {
                    this.f21896d = this.j.size();
                }
                if (this.f21901i.size() >= this.f21896d) {
                    a(true);
                } else {
                    this.f21901i.add(tripBusDetailsItem);
                    if (tripBusDetailsItem != null) {
                        try {
                            if (!TextUtils.isEmpty(tripBusDetailsItem.getSeatName())) {
                                com.travel.bus.a.a();
                                com.travel.bus.a.b().a("bus_seat_selected", "/bus-tickets/seat-selection", "SEAT_NUM", tripBusDetailsItem.getSeatName(), (Context) this);
                            }
                        } catch (Exception e2) {
                            if (com.paytm.utility.b.v) {
                                com.paytm.utility.q.c(e2.getMessage());
                            }
                        }
                    }
                }
            }
        }
        ArrayList<TripBusDetailsItem> arrayList = this.f21901i;
        String string = getString((arrayList == null || arrayList.size() <= 0 || this.f21901i.size() != this.j.size()) ? R.string.select_seats_title : R.string.proceed);
        Button button = this.N;
        if (button != null) {
            button.setText(string);
            if (string.equalsIgnoreCase("proceed")) {
                this.N.setBackgroundResource(R.drawable.travel_res_bus_bg_btn_blue_background);
            }
        }
        ViewPager viewPager = this.z;
        if (!(viewPager == null || (acVar = this.k) == null || acVar.a(viewPager.getCurrentItem()) == null)) {
            ((j) this.k.a(this.z.getCurrentItem())).a(tripBusDetailsItem, view, "");
        }
        c();
    }

    /* access modifiers changed from: private */
    public void c() {
        ArrayList<TripBusDetailsItem> arrayList = this.f21901i;
        if (arrayList == null || arrayList.size() <= 0) {
            q qVar = this.S;
            if (qVar != null) {
                qVar.a(false, "");
            }
            this.R.setVisibility(8);
            this.M.setVisibility(8);
            this.l.setText("");
            this.m.setText(getResources().getString(R.string.selected_seat));
            this.n.setText("");
            this.J.setVisibility(8);
            this.K.setVisibility(8);
            this.O.setVisibility(0);
            this.N.setBackgroundResource(R.drawable.travel_res_bus_proceed_button_unselected);
            return;
        }
        this.O.setVisibility(8);
        this.J.setVisibility(0);
        this.K.setVisibility(0);
        double d2 = 0.0d;
        boolean z2 = false;
        String str = "";
        for (int i2 = 0; i2 < this.f21901i.size(); i2++) {
            TripBusDetailsItem tripBusDetailsItem = this.f21901i.get(i2);
            if (!tripBusDetailsItem.getFare().equalsIgnoreCase(this.U) && this.f21901i.size() > 1) {
                z2 = true;
            }
            q qVar2 = this.S;
            if (qVar2 != null) {
                if (z2) {
                    qVar2.a(false, tripBusDetailsItem.getFare());
                } else {
                    qVar2.a(true, tripBusDetailsItem.getFare());
                }
            }
            if (tripBusDetailsItem.getLadiesSeat().booleanValue()) {
                this.R.setVisibility(0);
                this.M.setVisibility(0);
            } else {
                this.R.setVisibility(8);
                this.M.setVisibility(8);
            }
            if (tripBusDetailsItem != null) {
                d2 += Double.parseDouble(tripBusDetailsItem.getFare());
                if (i2 == this.f21901i.size() - 1) {
                    str = str + tripBusDetailsItem.getSeatName();
                } else {
                    str = str + tripBusDetailsItem.getSeatName() + ", ";
                }
            }
        }
        this.l.setText(str);
        if (this.f21901i.size() == 1) {
            this.m.setText(getResources().getString(R.string.selected_seat));
        } else {
            this.m.setText(getResources().getString(R.string.selected_seats));
        }
        String a2 = com.paytm.utility.b.a(d2, "###,###,###.##");
        if (a2 != null) {
            this.n.setText(getResources().getString(R.string.rs) + " " + a2);
            return;
        }
        this.n.setText("");
    }

    public final ArrayList<TripBusDetailsItem> h() {
        return this.f21901i;
    }

    public final void i() {
        q();
    }

    private Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("intent_extra_selected_seats", this.f21901i);
        bundle.putSerializable("intent_extra_bus_search_input", this.f21898f);
        bundle.putSerializable("intent_extra_bus_search_result_item", this.f21899g);
        bundle.putSerializable("intent_extra_passenger_details", this.q);
        bundle.putSerializable("requestid", this.f21900h);
        bundle.putSerializable("intent_extra_bus_trip_detail", this.f21895c);
        bundle.putSerializable("intent_extra_selected_boarding_point", this.o);
        bundle.putSerializable("intent_extra_selected_dropping_point", this.p);
        return bundle;
    }

    public void onClick(View view) {
        String str;
        String str2;
        int id = view.getId();
        if (id == R.id.btn_proceed) {
            Toast toast = this.V;
            if (toast != null) {
                toast.cancel();
            }
            ArrayList<TripBusDetailsItem> arrayList = this.f21901i;
            if (arrayList == null || arrayList.size() == 0) {
                if (this.j.size() > this.f21901i.size()) {
                    int size = this.j.size() - this.f21901i.size();
                    String valueOf = String.valueOf(size);
                    if (size == 1) {
                        str = "Please select " + valueOf + " more seat to proceed";
                    } else {
                        str = "Please select " + valueOf + " more seats to proceed";
                    }
                    this.V = Toast.makeText(this, str, 0);
                    this.V.show();
                }
            } else if (this.j.size() > this.f21901i.size()) {
                int size2 = this.j.size() - this.f21901i.size();
                String valueOf2 = String.valueOf(size2);
                if (size2 == 1) {
                    str2 = "Please select " + valueOf2 + " more seat to proceed";
                } else {
                    str2 = "Please select " + valueOf2 + " more seats to proceed";
                }
                this.V = Toast.makeText(this, str2, 0);
                this.V.show();
            } else {
                r();
                CJRBusSearchItem cJRBusSearchItem = this.f21899g;
                if (cJRBusSearchItem == null || cJRBusSearchItem.getBoardingLocations() == null || this.f21899g.getBoardingLocations().size() <= 0) {
                    if (l()) {
                        f();
                    } else {
                        k();
                    }
                } else if (l()) {
                    f();
                } else {
                    k();
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "bus_seat");
            hashMap.put("event_action", "proceed_new_seat");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
            hashMap.put("vertical_name", "bus");
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } else if (id == R.id.btn_change_bus) {
            e();
            finish();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("event_category", "bus_seat");
            hashMap2.put("event_action", "proceed_change_bus");
            hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
            hashMap2.put("vertical_name", "bus");
            hashMap2.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, (Context) this);
        } else if (id == R.id.select_seat_close) {
            finish();
            e();
        } else if (id == R.id.lower_birth_selection) {
            ViewPager viewPager = this.z;
            if (viewPager != null) {
                viewPager.setCurrentItem(0, true);
            }
            this.x.setBackgroundResource(R.drawable.travel_res_bus_left_selected);
            this.x.setTextColor(getResources().getColor(R.color.white));
            this.y.setBackgroundResource(R.drawable.travel_res_bus_right_default);
            this.y.setTextColor(getResources().getColor(R.color.bus_default_color));
            b("LOWER");
        } else if (id == R.id.upper_birth_selection && this.z != null) {
            b("UPPER");
            this.z.setCurrentItem(1, true);
            this.y.setBackgroundResource(R.drawable.travel_res_bus_right_selected);
            this.y.setTextColor(getResources().getColor(R.color.white));
            this.x.setBackgroundResource(R.drawable.travel_res_bus_left_default);
            this.x.setTextColor(getResources().getColor(R.color.bus_default_color));
        }
    }

    private void e() {
        Intent intent = new Intent(this, AJRBusSearchSRPActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    private void b(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        if (str.equals("LOWER")) {
            str2 = "bus_seat_lower_option_clicked";
        } else if (str.equals("UPPER")) {
            str2 = "bus_seat_upper_option_clicked";
        } else {
            str2 = str.equals("INFO") ? "bus_seat_info_icon_clicked" : "";
        }
        hashMap.put("user_id", com.paytm.utility.b.n(getApplicationContext()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(str2, (Map<String, Object>) hashMap, (Context) this);
    }

    private void f() {
        if (g()) {
            j();
        } else {
            a(false);
        }
    }

    private boolean g() {
        this.f21897e = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f21901i.size(); i3++) {
            String gender = this.q.get(i3).getGender();
            if (this.f21901i.get(i3).getLadiesSeat().booleanValue()) {
                this.f21897e++;
            }
            if (gender.equalsIgnoreCase("female")) {
                i2++;
            }
            if (this.f21897e <= i2) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        if (this.f21897e == 0) {
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                this.q.get(i2).setSeatNumber(this.f21901i.get(i2).getSeatName());
            }
        } else {
            for (int i3 = 0; i3 < this.q.size(); i3++) {
                if (this.f21901i.get(i3).getLadiesSeat().booleanValue()) {
                    for (int i4 = 0; i4 < this.f21901i.size(); i4++) {
                        if (this.q.get(i4).getGender().equalsIgnoreCase("female") && !this.q.get(i4).isCheckedOnBlock()) {
                            this.q.get(i4).setSeatNumber(this.f21901i.get(i3).getSeatName());
                            this.q.get(i4).setCheckedOnBlock(true);
                        }
                    }
                }
            }
            for (int i5 = 0; i5 < this.q.size(); i5++) {
                if (!this.f21901i.get(i5).getLadiesSeat().booleanValue()) {
                    for (int i6 = 0; i6 < this.f21901i.size(); i6++) {
                        if (!this.q.get(i6).isCheckedOnBlock()) {
                            this.q.get(i6).setSeatNumber(this.f21901i.get(i5).getSeatName());
                            this.q.get(i6).setCheckedOnBlock(true);
                        }
                    }
                }
            }
        }
        showProgressDialog(this, getResources().getString(R.string.please_wait_progress_msg));
        e eVar = f21893b;
        if (eVar != null) {
            eVar.a(d());
        }
        finish();
    }

    private void k() {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", "BusTicket");
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent, 1);
    }

    private boolean l() {
        if (com.travel.bus.b.a.a(getApplicationContext()).b("sso_token=", "", true).length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r1 = "yyyy-MM-dd"
            java.lang.String r9 = com.paytm.utility.b.d((java.lang.String) r9, (java.lang.String) r0, (java.lang.String) r1)
            android.content.res.Resources r0 = r6.getResources()
            int r1 = com.travel.bus.R.string.please_wait_progress_msg
            java.lang.String r0 = r0.getString(r1)
            r6.showProgressDialog(r6, r0)
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            r1 = 0
            if (r0 == 0) goto L_0x003a
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r0 = r0.c()
            if (r0 == 0) goto L_0x003a
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r0 = r0.c()
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            if (r0 == 0) goto L_0x00ea
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r3.put(r4, r5)
            java.lang.String r4 = com.paytm.utility.a.q(r6)
            java.lang.String r5 = "sso_token"
            r3.put(r5, r4)
            java.lang.String r4 = "tripId"
            r2.put(r4, r7)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r7 = "providerId"
            r2.put(r7, r8)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r7 = "requestid"
            java.lang.String r8 = r6.f21900h     // Catch:{ JSONException -> 0x0070 }
            r2.put(r7, r8)     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r7 = "date"
            r2.put(r7, r9)     // Catch:{ JSONException -> 0x0070 }
            goto L_0x0078
        L_0x0070:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.q.c(r7)
        L_0x0078:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.add(r8)
            r8 = 753(0x2f1, float:1.055E-42)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.add(r8)
            r6.p()
            if (r0 == 0) goto L_0x00ea
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "json input : "
            r7.<init>(r8)
            java.lang.String r8 = r2.toString()
            r7.append(r8)
            com.paytm.utility.b.j()
            boolean r7 = com.paytm.utility.b.c((android.content.Context) r6)
            if (r7 == 0) goto L_0x00e7
            com.paytm.network.b r7 = new com.paytm.network.b
            r7.<init>()
            r7.f42877a = r6
            com.paytm.network.a$c r8 = com.paytm.network.a.c.BUS
            r7.f42878b = r8
            com.paytm.network.a$a r8 = com.paytm.network.a.C0715a.POST
            r7.f42879c = r8
            r7.f42880d = r0
            java.lang.String r8 = r2.toString()
            r7.f42884h = r8
            r7.f42881e = r1
            r7.f42882f = r3
            r7.f42883g = r1
            com.travel.bus.pojo.busticket.TripBusDetail r8 = new com.travel.bus.pojo.busticket.TripBusDetail
            r8.<init>()
            r7.f42885i = r8
            r7.j = r6
            org.json.JSONObject r8 = s()
            r7.t = r8
            com.paytm.network.a$b r8 = com.paytm.network.a.b.SILENT
            r7.n = r8
            java.lang.String r8 = "bus-seat-layout-page"
            r7.o = r8
            com.paytm.network.a r7 = r7.l()
            r7.a()
            return
        L_0x00e7:
            r6.m()
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSelectSeatsOnBlockActivity.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private void m() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRBusSelectSeatsOnBlockActivity.this.b(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        CJRBusSearchItem cJRBusSearchItem = this.f21899g;
        if (cJRBusSearchItem != null) {
            a(cJRBusSearchItem.getTripId(), String.valueOf(this.f21899g.getOperatorObj().getProviderId()), this.f21899g.getDepartureDatetime());
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        q();
        removeProgressDialog();
        if (iJRPaytmDataModel instanceof TripBusDetail) {
            this.X = true;
            TripBusDetail tripBusDetail = (TripBusDetail) iJRPaytmDataModel;
            if (tripBusDetail != null && tripBusDetail.getBody() != null && tripBusDetail.getBody().size() > 0) {
                this.f21895c = tripBusDetail;
                this.C = this.f21895c.getBody();
                TripBusDetail tripBusDetail2 = this.f21895c;
                if (!(tripBusDetail2 == null || tripBusDetail2.getBody() == null || this.f21895c.getBody().size() <= 0)) {
                    this.u = this.f21895c.getMeta().getServerTime();
                }
                String str = this.Y;
                if (str == null || !str.equals("open_seat_layout") || o.c(this.C) < this.q.size()) {
                    String str2 = this.Y;
                    if (str2 == null || !str2.equals("open_seat_layout_single_female") || o.b(this.C) < o.a(this.q)) {
                        String str3 = this.Y;
                        if (str3 == null || !str3.equals("open_seat_layout_single_pax") || o.d(this.C) <= 0) {
                            String str4 = this.Y;
                            if (str4 == null || !str4.equals("open_seat_layout_female_reserved") || o.b(this.C) < o.a(this.q)) {
                                String str5 = this.Y;
                                if (str5 == null || !str5.equals("open_seat_layout_opp_gender") || o.c(this.C) < this.q.size()) {
                                    String str6 = this.Y;
                                    if (str6 == null || !str6.equals("no_actions")) {
                                        e();
                                    } else if (o.c(this.C) >= this.q.size()) {
                                        n();
                                    } else {
                                        this.mFrameLayout.addView(getLayoutInflater().inflate(R.layout.pre_b_lyt_bus_no_seats_on_block, (ViewGroup) null));
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("event_category", "bus_seat");
                                        hashMap.put("event_action", "no_seats_available");
                                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
                                        hashMap.put("vertical_name", "bus");
                                        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
                                        com.travel.bus.a.a();
                                        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put("event_label", this.f21899g.getOperatorObj().getName());
                                        hashMap2.put("event_label2", this.f21898f.getSource().getDisplayCityName() + "/" + this.f21898f.getDestination().getDisplayCityName());
                                        hashMap2.put("event_label3", this.f21895c.getMeta().getProvider().getName());
                                        hashMap2.put("userid", com.paytm.utility.b.n((Context) this));
                                        com.travel.bus.a.a();
                                        com.travel.bus.a.a("customEvent", "/bus-tickets-seatlayout", "bus_seat", "seat_layout_not_displayed", hashMap2);
                                        o();
                                    }
                                } else {
                                    n();
                                }
                            } else {
                                n();
                            }
                        } else {
                            n();
                        }
                    } else {
                        n();
                    }
                } else {
                    n();
                }
            } else if (tripBusDetail == null || TextUtils.isEmpty((String) tripBusDetail.getError())) {
                a(getResources().getString(R.string.error), getResources().getString(R.string.error));
            } else {
                a(getResources().getString(R.string.error), (String) tripBusDetail.getError());
            }
        }
    }

    private void n() {
        this.mFrameLayout.addView(getLayoutInflater().inflate(R.layout.pre_b_lyt_bus_select_seats_on_failure_root, (ViewGroup) null));
        a();
        b();
        new a(this, (byte) 0).execute(new Void[0]);
    }

    private void o() {
        this.O = (Button) findViewById(R.id.btn_change_bus);
        this.O.setClickable(true);
        this.O.setOnClickListener(this);
        this.W = (ImageView) findViewById(R.id.select_seat_close);
        this.W.setOnClickListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059 A[Catch:{ Exception -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[Catch:{ Exception -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0112 A[Catch:{ Exception -> 0x0152 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleErrorCode(int r8, com.paytm.network.model.IJRPaytmDataModel r9, com.paytm.network.model.NetworkCustomError r10) {
        /*
            r7 = this;
            r7.q()
            r7.removeProgressDialog()
            if (r10 == 0) goto L_0x0028
            java.lang.String r9 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0044 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0044 }
            if (r9 != 0) goto L_0x0028
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0044 }
            com.travel.g.a r0 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r1 = "bus_bus_selection_error"
            java.lang.String r2 = "/bus-tickets/search-results"
            java.lang.String r3 = "ERROR_MESSAGE"
            java.lang.String r4 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0044 }
            r5 = r7
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (android.content.Context) r5)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0050
        L_0x0028:
            android.content.res.Resources r9 = r7.getResources()     // Catch:{ Exception -> 0x0044 }
            int r0 = com.travel.bus.R.string.network_error_message     // Catch:{ Exception -> 0x0044 }
            java.lang.String r5 = r9.getString(r0)     // Catch:{ Exception -> 0x0044 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0044 }
            com.travel.g.a r1 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = "bus_bus_selection_error"
            java.lang.String r3 = "/bus-tickets/search-results"
            java.lang.String r4 = "ERROR_MESSAGE"
            r6 = r7
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (android.content.Context) r6)     // Catch:{ Exception -> 0x0044 }
            goto L_0x0050
        L_0x0044:
            r9 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x0050
            java.lang.String r9 = r9.getMessage()
            com.paytm.utility.q.c(r9)
        L_0x0050:
            com.travel.bus.pojo.busticket.CJRNewErrorFormat r9 = new com.travel.bus.pojo.busticket.CJRNewErrorFormat     // Catch:{ Exception -> 0x0152 }
            r9.<init>()     // Catch:{ Exception -> 0x0152 }
            com.paytm.network.model.NetworkResponse r0 = r10.networkResponse     // Catch:{ Exception -> 0x0152 }
            if (r0 == 0) goto L_0x007b
            com.paytm.network.model.NetworkResponse r0 = r10.networkResponse     // Catch:{ Exception -> 0x0152 }
            byte[] r1 = r0.data     // Catch:{ Exception -> 0x0152 }
            if (r1 == 0) goto L_0x007b
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x0077 }
            byte[] r0 = r0.data     // Catch:{ Exception -> 0x0077 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0077 }
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0077 }
            r0.<init>()     // Catch:{ Exception -> 0x0077 }
            java.lang.Class r2 = r9.getClass()     // Catch:{ Exception -> 0x0077 }
            java.lang.Object r0 = r0.a((java.lang.String) r1, r2)     // Catch:{ Exception -> 0x0077 }
            com.travel.bus.pojo.busticket.CJRNewErrorFormat r0 = (com.travel.bus.pojo.busticket.CJRNewErrorFormat) r0     // Catch:{ Exception -> 0x0077 }
            r9 = r0
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x0152 }
        L_0x007b:
            r0 = 503(0x1f7, float:7.05E-43)
            if (r8 == r0) goto L_0x0112
            r0 = 753(0x2f1, float:1.055E-42)
            if (r8 == r0) goto L_0x00fe
            com.travel.bus.pojo.busticket.i r8 = r9.getStatus()     // Catch:{ Exception -> 0x0152 }
            if (r8 == 0) goto L_0x00b6
            android.content.Context r0 = r7.getApplicationContext()     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.pojo.busticket.i r8 = r9.getStatus()     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.pojo.busticket.j r8 = r8.getMessage()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r1 = r8.f22819b     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.pojo.busticket.i r8 = r9.getStatus()     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.pojo.busticket.j r8 = r8.getMessage()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r2 = r8.f22820c     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.pojo.busticket.i r8 = r9.getStatus()     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.pojo.busticket.j r8 = r8.getMessage()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r3 = r8.a()     // Catch:{ Exception -> 0x0152 }
            r4 = 0
            android.view.LayoutInflater r5 = r7.getLayoutInflater()     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.busticket.i.o.a(r0, r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0152 }
            return
        L_0x00b6:
            java.lang.String r8 = r10.getAlertTitle()     // Catch:{ Exception -> 0x0152 }
            if (r8 == 0) goto L_0x00ce
            java.lang.String r8 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0152 }
            if (r8 == 0) goto L_0x00ce
            java.lang.String r8 = r10.getAlertTitle()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r9 = r10.getAlertMessage()     // Catch:{ Exception -> 0x0152 }
            r7.a((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x0152 }
            return
        L_0x00ce:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0152 }
            r8.<init>()     // Catch:{ Exception -> 0x0152 }
            android.content.res.Resources r9 = r7.getResources()     // Catch:{ Exception -> 0x0152 }
            int r0 = com.travel.bus.R.string.network_error_message     // Catch:{ Exception -> 0x0152 }
            java.lang.String r9 = r9.getString(r0)     // Catch:{ Exception -> 0x0152 }
            r8.append(r9)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r9 = " "
            r8.append(r9)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r9 = r10.getUrl()     // Catch:{ Exception -> 0x0152 }
            r8.append(r9)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0152 }
            android.content.res.Resources r9 = r7.getResources()     // Catch:{ Exception -> 0x0152 }
            int r10 = com.travel.bus.R.string.network_error_heading     // Catch:{ Exception -> 0x0152 }
            java.lang.String r9 = r9.getString(r10)     // Catch:{ Exception -> 0x0152 }
            r7.a((java.lang.String) r9, (java.lang.String) r8)     // Catch:{ Exception -> 0x0152 }
            return
        L_0x00fe:
            android.widget.FrameLayout r8 = r7.mFrameLayout     // Catch:{ Exception -> 0x0152 }
            android.view.LayoutInflater r9 = r7.getLayoutInflater()     // Catch:{ Exception -> 0x0152 }
            int r10 = com.travel.bus.R.layout.pre_b_lyt_bus_no_seats_on_block     // Catch:{ Exception -> 0x0152 }
            r0 = 0
            android.view.View r9 = r9.inflate(r10, r0)     // Catch:{ Exception -> 0x0152 }
            r8.addView(r9)     // Catch:{ Exception -> 0x0152 }
            r7.o()     // Catch:{ Exception -> 0x0152 }
            return
        L_0x0112:
            boolean r8 = r7.isFinishing()     // Catch:{ Exception -> 0x0152 }
            if (r8 != 0) goto L_0x0152
            android.content.res.Resources r8 = r7.getResources()     // Catch:{ Exception -> 0x0152 }
            int r9 = com.travel.bus.R.string.bus_maintenance_error_title     // Catch:{ Exception -> 0x0152 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x0152 }
            android.content.res.Resources r9 = r7.getResources()     // Catch:{ Exception -> 0x0152 }
            int r10 = com.travel.bus.R.string.bus_maintenance_error_description     // Catch:{ Exception -> 0x0152 }
            java.lang.String r9 = r9.getString(r10)     // Catch:{ Exception -> 0x0152 }
            android.app.AlertDialog$Builder r10 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x0152 }
            r10.<init>(r7)     // Catch:{ Exception -> 0x0152 }
            android.app.AlertDialog$Builder r8 = r10.setTitle(r8)     // Catch:{ Exception -> 0x0152 }
            android.app.AlertDialog$Builder r8 = r8.setMessage(r9)     // Catch:{ Exception -> 0x0152 }
            r9 = 0
            r8.setCancelable(r9)     // Catch:{ Exception -> 0x0152 }
            android.content.res.Resources r8 = r7.getResources()     // Catch:{ Exception -> 0x0152 }
            int r9 = com.travel.bus.R.string.ok     // Catch:{ Exception -> 0x0152 }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x0152 }
            com.travel.bus.busticket.activity.-$$Lambda$AJRBusSelectSeatsOnBlockActivity$tpeL_sujFOdXX6kWuqtruATiB6I r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRBusSelectSeatsOnBlockActivity$tpeL_sujFOdXX6kWuqtruATiB6I     // Catch:{ Exception -> 0x0152 }
            r9.<init>()     // Catch:{ Exception -> 0x0152 }
            r10.setPositiveButton(r8, r9)     // Catch:{ Exception -> 0x0152 }
            r10.show()     // Catch:{ Exception -> 0x0152 }
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSelectSeatsOnBlockActivity.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }

    private void a(String str, String str2) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(str).setMessage(str2).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener(false) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRBusSelectSeatsOnBlockActivity.this.a(this.f$1, dialogInterface, i2);
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (z2) {
            Intent intent = new Intent();
            intent.putExtra("trip_id", this.f21899g.getTripId());
            setResult(2, intent);
        }
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && l()) {
            f();
        }
    }

    private void p() {
        RelativeLayout relativeLayout = this.r;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private void q() {
        RelativeLayout relativeLayout = this.r;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void r() {
        String str = "";
        try {
            Iterator<TripBusDetailsItem> it2 = this.f21901i.iterator();
            while (it2.hasNext()) {
                TripBusDetailsItem next = it2.next();
                if (next.getSeatName() != null) {
                    str = str + next.getSeatName() + " ";
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("bus_seat_numbers", str);
            hashMap.put("bus_number_of_seats", Integer.valueOf(this.f21901i.size()));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a("bus_seat_proceed_clicked", (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
    }

    private void a(boolean z2) {
        TextView textView = (TextView) findViewById(R.id.txt_bottom_bus_error);
        textView.setVisibility(0);
        textView.setText("");
        if (!z2) {
            textView.setText("\"Can't proceed with booking.\"\nThe seat that you have chosen cannot be booked by male. Operators do not allow male travellers to be seated next to female travellers unless both the seats are reserved in the same booking");
        } else if (this.f21896d > 1) {
            textView.setText("\"Can't proceed with booking.\"\nOnly " + this.f21896d + " no of seats can be reserved in this booking.");
        } else {
            textView.setText("\"Can't proceed with booking.\"\nOnly " + this.f21896d + " seat can be reserved in this booking.");
        }
        new Handler().postDelayed(new Runnable(textView) {
            private final /* synthetic */ TextView f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                this.f$0.setVisibility(8);
            }
        }, 3000);
    }

    public void onBackPressed() {
        Toast toast = this.V;
        if (toast != null) {
            toast.cancel();
        }
        e();
        finish();
    }

    public void onStop() {
        super.onStop();
    }

    public void onUserInteraction() {
        super.onUserInteraction();
    }

    public static void a(e eVar) {
        f21893b = eVar;
    }

    private static JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusTravellersScreen");
        } catch (JSONException e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        return jSONObject;
    }

    static /* synthetic */ void a(AJRBusSelectSeatsOnBlockActivity aJRBusSelectSeatsOnBlockActivity, final ArrayList arrayList, ArrayList arrayList2, long j2, long j3) {
        AJRBusSelectSeatsOnBlockActivity aJRBusSelectSeatsOnBlockActivity2 = aJRBusSelectSeatsOnBlockActivity;
        aJRBusSelectSeatsOnBlockActivity2.z = (ViewPager) aJRBusSelectSeatsOnBlockActivity.findViewById(R.id.view_pager_select_seats);
        aJRBusSelectSeatsOnBlockActivity2.k = new ac(aJRBusSelectSeatsOnBlockActivity.getSupportFragmentManager(), arrayList, arrayList2, j2, j3, aJRBusSelectSeatsOnBlockActivity2.f21899g.getFlags().getSocialDistancingGuaranteed());
        aJRBusSelectSeatsOnBlockActivity2.z.setAdapter(aJRBusSelectSeatsOnBlockActivity2.k);
        aJRBusSelectSeatsOnBlockActivity2.Z.a(aJRBusSelectSeatsOnBlockActivity2.C);
        aJRBusSelectSeatsOnBlockActivity2.z.setCurrentItem(0, true);
        ViewPager viewPager = aJRBusSelectSeatsOnBlockActivity2.z;
        if (viewPager != null) {
            ArrayList arrayList3 = arrayList;
            viewPager.addOnPageChangeListener(new ViewPager.e() {
                public final void onPageScrollStateChanged(int i2) {
                }

                public final void onPageScrolled(int i2, float f2, int i3) {
                }

                public final void onPageSelected(int i2) {
                    if (AJRBusSelectSeatsOnBlockActivity.this.x != null && AJRBusSelectSeatsOnBlockActivity.this.y != null) {
                        if (i2 != 0 || arrayList.size() == 0) {
                            AJRBusSelectSeatsOnBlockActivity.this.y.setBackgroundResource(R.drawable.travel_res_bus_right_selected);
                            AJRBusSelectSeatsOnBlockActivity.this.y.setTextColor(AJRBusSelectSeatsOnBlockActivity.this.getResources().getColor(R.color.white));
                            AJRBusSelectSeatsOnBlockActivity.this.x.setBackgroundResource(R.drawable.travel_res_bus_left_default);
                            AJRBusSelectSeatsOnBlockActivity.this.x.setTextColor(AJRBusSelectSeatsOnBlockActivity.this.getResources().getColor(R.color.bus_default_color));
                            return;
                        }
                        AJRBusSelectSeatsOnBlockActivity.this.x.setBackgroundResource(R.drawable.travel_res_bus_left_selected);
                        AJRBusSelectSeatsOnBlockActivity.this.x.setTextColor(AJRBusSelectSeatsOnBlockActivity.this.getResources().getColor(R.color.white));
                        AJRBusSelectSeatsOnBlockActivity.this.y.setBackgroundResource(R.drawable.travel_res_bus_right_default);
                        AJRBusSelectSeatsOnBlockActivity.this.y.setTextColor(AJRBusSelectSeatsOnBlockActivity.this.getResources().getColor(R.color.bus_default_color));
                    }
                }
            });
        }
        try {
            if (!aJRBusSelectSeatsOnBlockActivity2.t) {
                com.travel.bus.a.a();
                com.travel.bus.a.b().a("/bus-tickets/seat-selection", "BusTicket", (Context) aJRBusSelectSeatsOnBlockActivity);
                aJRBusSelectSeatsOnBlockActivity2.t = true;
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
    }
}
