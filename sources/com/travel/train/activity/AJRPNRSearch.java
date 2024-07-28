package com.travel.train.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.am;
import com.travel.train.i.v;
import com.travel.train.j.l;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.model.trainticket.h;
import java.util.ArrayList;

public class AJRPNRSearch extends CJRTrainBaseActivity implements v {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRBookings> f25900a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f25901b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f25902c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public EditText f25903d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f25904e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f25905f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f25906g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Handler f25907h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Runnable f25908i;
    private ArrayList<h> j;
    private ArrayList<CJRBookings> k;
    private am l;
    private am m;
    /* access modifiers changed from: private */
    public TextView n;
    private InputMethodManager o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_pnr_search);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("intent_extra_train_upcoming_trips")) {
            this.f25900a = (ArrayList) intent.getSerializableExtra("intent_extra_train_upcoming_trips");
        }
        this.f25903d = (EditText) findViewById(R.id.search_box);
        this.f25903d.requestFocus();
        this.o = (InputMethodManager) getSystemService("input_method");
        this.o.toggleSoftInput(2, 1);
        this.f25903d.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(final Editable editable) {
                if (editable == null || editable.length() != 0) {
                    AJRPNRSearch.this.f25903d.setTextSize(2, 25.0f);
                    AJRPNRSearch.this.f25903d.setTypeface(AJRPNRSearch.this.f25903d.getTypeface(), 1);
                } else {
                    AJRPNRSearch.this.f25903d.setTextSize(2, 17.0f);
                    AJRPNRSearch.this.f25903d.setTypeface(AJRPNRSearch.this.f25903d.getTypeface(), 0);
                }
                if (editable == null || editable.length() != 10) {
                    AJRPNRSearch.this.n.setVisibility(8);
                } else {
                    AJRPNRSearch.this.n.setVisibility(0);
                }
                if (AJRPNRSearch.this.f25907h == null) {
                    Handler unused = AJRPNRSearch.this.f25907h = new Handler();
                }
                Runnable unused2 = AJRPNRSearch.this.f25908i = new Runnable() {
                    public final void run() {
                        AJRPNRSearch.a(AJRPNRSearch.this, editable.toString());
                        AJRPNRSearch.e(AJRPNRSearch.this);
                    }
                };
                AJRPNRSearch.this.f25907h.postDelayed(AJRPNRSearch.this.f25908i, 900);
            }
        });
        ((ImageView) findViewById(R.id.close_icon)).setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        findViewById(R.id.close_icon_lyt).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRPNRSearch.this.finish();
            }
        });
        this.f25905f = (LinearLayout) findViewById(R.id.suggested_lyt);
        this.f25906g = (LinearLayout) findViewById(R.id.non_suggested_lyt);
        this.f25904e = (LinearLayout) findViewById(R.id.recent_searches_lyt);
        this.f25901b = (RecyclerView) findViewById(R.id.recent_searches_list);
        this.f25902c = (RecyclerView) findViewById(R.id.suggested_list);
        this.n = (TextView) findViewById(R.id.pnr_check_txt);
        this.f25901b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f25902c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(AJRPNRSearch.this, AJRPNRStatus.class);
                intent.putExtra("pnr_number", AJRPNRSearch.this.f25903d.getText().toString());
                intent.putExtra("pnr_from_page", "pnr_search");
                if (AJRPNRSearch.this.f25900a != null) {
                    intent.putExtra("intent_extra_pnr_list", AJRPNRSearch.this.f25900a);
                }
                AJRPNRSearch.this.startActivityForResult(intent, 570);
            }
        });
        this.f25903d.setText("");
        d();
        a();
    }

    private void a() {
        if (TextUtils.isEmpty(this.f25903d.getText())) {
            ArrayList<h> arrayList = this.j;
            if (arrayList == null || arrayList.size() <= 0) {
                ArrayList<CJRBookings> arrayList2 = this.k;
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    this.f25906g.setVisibility(8);
                    this.f25905f.setVisibility(8);
                    return;
                }
                this.f25906g.setVisibility(8);
                b();
                return;
            }
            c();
            return;
        }
        ArrayList<CJRBookings> arrayList3 = this.k;
        if (arrayList3 == null || arrayList3.size() <= 0) {
            ArrayList<h> arrayList4 = this.j;
            if (arrayList4 == null || arrayList4.size() <= 0) {
                this.f25906g.setVisibility(8);
                this.f25905f.setVisibility(8);
                return;
            }
            c();
            return;
        }
        this.f25906g.setVisibility(8);
        b();
    }

    private void b() {
        this.f25905f.setVisibility(0);
        this.m = new am(this, this.k, this);
        this.f25902c.setAdapter(this.m);
    }

    private void c() {
        this.f25906g.setVisibility(0);
        this.f25905f.setVisibility(8);
        ArrayList<h> arrayList = this.j;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f25904e.setVisibility(8);
            return;
        }
        this.f25904e.setVisibility(0);
        this.l = new am(this, this.j, this);
        this.f25901b.setAdapter(this.l);
    }

    private void d() {
        this.j = l.a().f27576a;
    }

    public final void a(Object obj) {
        if (obj instanceof CJRBookings) {
            CJRBookings cJRBookings = (CJRBookings) obj;
            h hVar = new h();
            hVar.setPNRNumber(cJRBookings.getmPNRNumber());
            hVar.setFrom(cJRBookings.getmBoardingStationName());
            hVar.setTo(cJRBookings.getmReservationUpToStationName());
            hVar.setDate(cJRBookings.getmBoardingDate());
            a(hVar);
            return;
        }
        a((h) obj);
    }

    private void a(h hVar) {
        Intent intent = new Intent(this, AJRPNRStatus.class);
        intent.putExtra("pnr_number", hVar.getPNRNumber());
        intent.putExtra("pnr_from_page", "pnr_search");
        if (hVar != null) {
            intent.putExtra("pnr_item_model", hVar);
        }
        ArrayList<CJRBookings> arrayList = this.f25900a;
        if (arrayList != null) {
            intent.putExtra("intent_extra_pnr_list", arrayList);
        }
        startActivityForResult(intent, 570);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 570) {
            d();
            a();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        InputMethodManager inputMethodManager = this.o;
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(1, 1);
        }
    }

    static /* synthetic */ void a(AJRPNRSearch aJRPNRSearch, String str) {
        ArrayList<CJRBookings> arrayList = aJRPNRSearch.k;
        if (arrayList != null && arrayList.size() > 0) {
            aJRPNRSearch.k.clear();
        }
        aJRPNRSearch.k = new ArrayList<>();
        if (aJRPNRSearch.f25900a != null) {
            int i2 = 0;
            if (!TextUtils.isEmpty(str)) {
                while (i2 < aJRPNRSearch.f25900a.size()) {
                    if (aJRPNRSearch.f25900a.get(i2).getmPNRNumber().trim().contains(str)) {
                        aJRPNRSearch.k.add(aJRPNRSearch.f25900a.get(i2));
                    }
                    i2++;
                }
            } else {
                while (i2 < aJRPNRSearch.f25900a.size()) {
                    aJRPNRSearch.k.add(aJRPNRSearch.f25900a.get(i2));
                    i2++;
                }
            }
        }
        aJRPNRSearch.a();
    }

    static /* synthetic */ void e(AJRPNRSearch aJRPNRSearch) {
        Handler handler = aJRPNRSearch.f25907h;
        if (handler != null) {
            handler.removeCallbacks(aJRPNRSearch.f25908i);
        }
    }
}
