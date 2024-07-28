package com.travel.flight.flightticket.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.flight.utils.c;
import com.travel.utils.n;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;

public class AJRAncillaryOrderDetails extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f24734a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f24735b;

    /* renamed from: c  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24736c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJROrderSummaryFlights> f24737d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJROrderSummaryFlights> f24738e;

    /* renamed from: f  reason: collision with root package name */
    private String f24739f;

    /* renamed from: g  reason: collision with root package name */
    private String f24740g;

    /* renamed from: h  reason: collision with root package name */
    private String f24741h;

    /* renamed from: i  reason: collision with root package name */
    private String f24742i;
    private String j;
    private String k;
    private LinearLayout l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ImageView t;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_order_summary_details_activity);
        if (getIntent() != null) {
            this.f24736c = (CJRFlightOrderSummaryResponse) getIntent().getSerializableExtra("orderSummary");
        }
        this.t = (ImageView) findViewById(R.id.back_btn);
        this.f24734a = (LinearLayout) findViewById(R.id.order_summary_ancillary_details_continer_onward);
        this.f24735b = (LinearLayout) findViewById(R.id.order_summary_ancillary_details_continer_return);
        this.l = (LinearLayout) findViewById(R.id.onward_details);
        this.m = (LinearLayout) findViewById(R.id.return_details);
        this.n = (TextView) findViewById(R.id.onward_source_hops);
        this.o = (TextView) findViewById(R.id.onward_destination_hops);
        this.p = (TextView) findViewById(R.id.onward_date);
        this.q = (TextView) findViewById(R.id.return_source_hops);
        this.r = (TextView) findViewById(R.id.return_destination_hops);
        this.s = (TextView) findViewById(R.id.return_date);
        this.t.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        this.t.setRotation(180.0f);
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRAncillaryOrderDetails.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f24737d = new ArrayList<>();
        this.f24738e = new ArrayList<>();
        Iterator<CJROrderSummaryItems> it2 = this.f24736c.getBody().getItems().iterator();
        CJROrderSummaryItems cJROrderSummaryItems = null;
        CJROrderSummaryItems cJROrderSummaryItems2 = null;
        while (it2.hasNext()) {
            CJROrderSummaryItems next = it2.next();
            if ("Flights".equalsIgnoreCase(next.getType())) {
                if ("O".equalsIgnoreCase(next.getF_Dir())) {
                    if (cJROrderSummaryItems == null) {
                        cJROrderSummaryItems = next;
                    }
                } else if (cJROrderSummaryItems2 == null) {
                    cJROrderSummaryItems2 = next;
                }
            } else if ("ancillary".equalsIgnoreCase(next.getType())) {
                if ("onward".equalsIgnoreCase(next.getDirection())) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
        }
        this.f24737d = a(cJROrderSummaryItems, (ArrayList<CJROrderSummaryItems>) arrayList);
        this.f24738e = b(cJROrderSummaryItems2, arrayList2);
        a();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        b.a();
        super.attachBaseContext(b.b().d(context));
        q.a(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        q.a(this);
    }

    private View a(String str, CJROrderSummaryFlights cJROrderSummaryFlights) {
        String[] split = str.split("\\:");
        View inflate = LayoutInflater.from(this).inflate(R.layout.pre_f_ancillary_order_details_hop_item, (ViewGroup) null, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.lyt_baggage_header);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_meal_header);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.meals_item_container);
        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.baggage_item_container);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) inflate.findViewById(R.id.flight_meal_ancillary_icon), "meal_ancillary_order.png", false, false, n.a.V1);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) inflate.findViewById(R.id.flight_baggage_ancillary_icon), "baggage_ancillary.png", false, false, n.a.V1);
        ((TextView) inflate.findViewById(R.id.source_hop_ita)).setText(split[0]);
        ((TextView) inflate.findViewById(R.id.destination_hop_ita)).setText(split[1]);
        HashMap<String, CJROrderSummaryFlights.HopWiseAncillaryItems> hpWiseAncillariesMap = cJROrderSummaryFlights.getHpWiseAncillariesMap();
        boolean z = false;
        boolean z2 = false;
        for (String next : hpWiseAncillariesMap.keySet()) {
            ArrayList<CJROrderSummaryItems> baggageAncillary = hpWiseAncillariesMap.get(next).getBaggageAncillary();
            ArrayList<CJROrderSummaryItems> mealsAncillary = hpWiseAncillariesMap.get(next).getMealsAncillary();
            if (mealsAncillary == null || mealsAncillary.isEmpty()) {
                linearLayout2.setVisibility(8);
            } else {
                Iterator<CJROrderSummaryItems> it2 = mealsAncillary.iterator();
                while (it2.hasNext()) {
                    a(next, it2.next(), linearLayout3, true);
                }
                z2 = true;
            }
            if (baggageAncillary == null || baggageAncillary.isEmpty()) {
                linearLayout.setVisibility(8);
            } else {
                Iterator<CJROrderSummaryItems> it3 = baggageAncillary.iterator();
                while (it3.hasNext()) {
                    a(next, it3.next(), linearLayout4, false);
                }
                z = true;
            }
        }
        if (z) {
            linearLayout.setVisibility(0);
        }
        if (z2) {
            linearLayout2.setVisibility(0);
        }
        return inflate;
    }

    private void a(String str, CJROrderSummaryItems cJROrderSummaryItems, LinearLayout linearLayout, boolean z) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.pre_f_ancillary_order_summary_item, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_name);
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_item_name);
        TextView textView3 = (TextView) inflate.findViewById(R.id.txt_item_price);
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
            inflate.findViewById(R.id.devider).setVisibility(8);
        }
        if (z) {
            textView2.setText(cJROrderSummaryItems.getAncillary_name() + " (" + c.h(cJROrderSummaryItems.getTotal_price()) + "x" + c.a((double) cJROrderSummaryItems.sameTypeAncillaryCount) + ")");
        } else {
            textView2.setText(cJROrderSummaryItems.getAncillary_name());
        }
        textView3.setText(getResources().getString(R.string.rs_symbol) + c.h(cJROrderSummaryItems.getTotal_price()));
        linearLayout.addView(inflate);
    }

    private void a() {
        ArrayList<CJROrderSummaryFlights> arrayList = this.f24737d;
        if (arrayList == null || arrayList.size() <= 0) {
            this.l.setVisibility(8);
        } else {
            this.n.setText(this.f24739f);
            this.o.setText(this.f24740g);
            this.p.setText(c.d(com.paytm.utility.b.f(this.f24741h, "yyyy-MM-dd", "EEEE, dd MMMM yyyy")));
            Iterator<CJROrderSummaryFlights> it2 = this.f24737d.iterator();
            while (it2.hasNext()) {
                CJROrderSummaryFlights next = it2.next();
                this.f24734a.addView(a(next.getOrigin().getIata() + AppConstants.COLON + next.getDestination().getIata(), next));
            }
        }
        ArrayList<CJROrderSummaryFlights> arrayList2 = this.f24738e;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            this.m.setVisibility(8);
            return;
        }
        this.q.setText(this.f24742i);
        this.r.setText(this.j);
        this.s.setText(com.paytm.utility.b.f(this.k, "yyyy-MM-dd", "EEEE, dd MMMM yyyy"));
        Iterator<CJROrderSummaryFlights> it3 = this.f24738e.iterator();
        while (it3.hasNext()) {
            CJROrderSummaryFlights next2 = it3.next();
            this.f24735b.addView(a(next2.getOrigin().getIata() + AppConstants.COLON + next2.getDestination().getIata(), next2));
        }
    }

    private static CJROrderSummaryFlights a(CJROrderSummaryFlights cJROrderSummaryFlights, ArrayList<CJROrderSummaryItems> arrayList) {
        Iterator<CJROrderSummaryItems> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJROrderSummaryItems next = it2.next();
            if (cJROrderSummaryFlights.getOrigin().getIata().equalsIgnoreCase(next.getOrigin_iata())) {
                cJROrderSummaryFlights.setPassengerWiseAncillary(next.getPax_info().getName(), next);
            }
        }
        return cJROrderSummaryFlights;
    }

    private ArrayList<CJROrderSummaryFlights> a(CJROrderSummaryItems cJROrderSummaryItems, ArrayList<CJROrderSummaryItems> arrayList) {
        ArrayList<CJROrderSummaryFlights> arrayList2 = new ArrayList<>();
        if (!(cJROrderSummaryItems == null || cJROrderSummaryItems.getJourney_details() == null || cJROrderSummaryItems.getJourney_details().getFlights() == null)) {
            Iterator<CJROrderSummaryFlights> it2 = cJROrderSummaryItems.getJourney_details().getFlights().iterator();
            while (it2.hasNext()) {
                CJROrderSummaryFlights next = it2.next();
                a(next, arrayList);
                if (TextUtils.isEmpty(this.f24739f)) {
                    this.f24739f = next.getOrigin().getCity();
                    this.f24741h = cJROrderSummaryItems.getTravel_date();
                }
                this.f24740g = next.getDestination().getCity();
                if (!next.isPassengerAncillaryMapEmpty()) {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }

    private ArrayList<CJROrderSummaryFlights> b(CJROrderSummaryItems cJROrderSummaryItems, ArrayList<CJROrderSummaryItems> arrayList) {
        ArrayList<CJROrderSummaryFlights> arrayList2 = new ArrayList<>();
        if (!(cJROrderSummaryItems == null || cJROrderSummaryItems.getJourney_details() == null || cJROrderSummaryItems.getJourney_details().getFlights() == null)) {
            Iterator<CJROrderSummaryFlights> it2 = cJROrderSummaryItems.getJourney_details().getFlights().iterator();
            while (it2.hasNext()) {
                CJROrderSummaryFlights next = it2.next();
                a(next, arrayList);
                if (TextUtils.isEmpty(this.f24742i)) {
                    this.f24742i = next.getOrigin().getCity();
                    this.j = next.getDestination().getCity();
                    this.k = cJROrderSummaryItems.getTravel_date();
                }
                if (!next.isPassengerAncillaryMapEmpty()) {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }
}
