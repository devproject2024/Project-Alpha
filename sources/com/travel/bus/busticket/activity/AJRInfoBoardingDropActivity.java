package com.travel.bus.busticket.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.a;
import com.travel.bus.busticket.a.f;
import com.travel.bus.busticket.fragment.b;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class AJRInfoBoardingDropActivity extends AJRBusBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f21955a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f21956b;

    /* renamed from: c  reason: collision with root package name */
    private CJRBusSearchItem f21957c;

    /* renamed from: d  reason: collision with root package name */
    private b f21958d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f21959e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_b_lyt_bp_dp_info);
        this.f21957c = (CJRBusSearchItem) getIntent().getSerializableExtra("BUS_SEARCH_ITEM");
        this.f21955a = (TextView) findViewById(R.id.text_boarding_dropping_point);
        this.f21956b = (TextView) findViewById(R.id.text_drop_point);
        this.f21959e = (ImageView) findViewById(R.id.filter_close);
        this.f21959e.setOnClickListener(this);
        this.f21955a.setOnClickListener(this);
        this.f21956b.setOnClickListener(this);
        a(true);
        a(this.f21957c.getBoardingLocations(), true);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.text_boarding_dropping_point) {
            a();
            a(this.f21957c.getBoardingLocations(), true);
            a.a();
            a.b().a("bus_search_boarding_clicked", (Map<String, Object>) null, (Context) this);
            a(true);
        } else if (id == R.id.lyt_boarding_point_detail) {
        } else {
            if (id == R.id.text_drop_point) {
                a();
                a(this.f21957c.getDroppingLocations(), false);
                a.a();
                a.b().a("bus_search_drop_clicked", (Map<String, Object>) null, (Context) this);
                a(false);
            } else if (id == R.id.filter_close) {
                finish();
            }
        }
    }

    private void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", "boarding_dropping_clicked");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Search Screen");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        a.a();
        a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private void a(ArrayList<CJRLocation> arrayList, boolean z) {
        b(arrayList, z);
        this.f21958d = new b((f.a) null);
        Bundle bundle = new Bundle();
        bundle.putSerializable("bus_bundle_location_list", arrayList);
        bundle.putBoolean("bus_is_boarding_point", z);
        bundle.putBoolean("bus_bundle_is_lat_long_present", false);
        this.f21958d.setArguments(bundle);
        q a2 = getSupportFragmentManager().a();
        a2.b(R.id.frg_container, this.f21958d, (String) null);
        a2.b();
    }

    private void b(ArrayList<CJRLocation> arrayList, boolean z) {
        Iterator<CJRLocation> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRLocation next = it2.next();
            if (next != null && TextUtils.isEmpty(next.getLocationName())) {
                if (z) {
                    next.setLocationName(this.f21957c.getSource());
                } else {
                    next.setLocationName(this.f21957c.getDestination());
                }
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            this.f21955a.setBackgroundColor(getResources().getColor(R.color.white));
            this.f21955a.setTextColor(getResources().getColor(R.color.passbook_calendar_blue_underline));
            this.f21956b.setBackgroundColor(getResources().getColor(R.color.color_f4f4f4));
            this.f21956b.setTextColor(getResources().getColor(R.color.color_999999));
            return;
        }
        this.f21955a.setBackgroundColor(getResources().getColor(R.color.color_f4f4f4));
        this.f21955a.setTextColor(getResources().getColor(R.color.color_999999));
        this.f21956b.setBackgroundColor(getResources().getColor(R.color.white));
        this.f21956b.setTextColor(getResources().getColor(R.color.passbook_calendar_blue_underline));
    }
}
