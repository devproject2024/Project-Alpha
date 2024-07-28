package com.travel.flight.c.b;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.b;
import com.travel.utils.n;
import java.util.HashMap;

public class a extends com.travel.flight.d.a implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f24062a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.travel.flight.c.c.a f24063b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f24064c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("bundle_airport_list")) {
            this.f24062a = (b) arguments.getSerializable("bundle_airport_list");
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof com.travel.flight.c.c.a) {
            this.f24063b = (com.travel.flight.c.c.a) activity;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.pre_f_fragment_near_by_airport, (ViewGroup) null);
        if (inflate != null) {
            this.f24064c = (ProgressBar) inflate.findViewById(R.id.progress_city);
            this.f24064c.setVisibility(0);
            if (!(inflate == null || this.f24062a == null)) {
                TextView textView = (TextView) inflate.findViewById(R.id.nearby_airport_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.near_by_airport_description);
                TextView textView3 = (TextView) inflate.findViewById(R.id.near_airport_desc);
                ResourceUtils.loadFlightImagesFromCDN((ImageView) inflate.findViewById(R.id.icon_view), "near_by_airport_revamp.png", false, false, n.a.V1);
                ResourceUtils.loadFlightImagesFromCDN((ImageView) inflate.findViewById(R.id.close_view), "back_button.svg", true, true, n.a.V1);
                String str2 = "";
                String cityName = !TextUtils.isEmpty(this.f24062a.getCityName()) ? this.f24062a.getCityName() : str2;
                StringBuilder sb = new StringBuilder();
                sb.append(cityName);
                String str3 = " - ";
                if (!TextUtils.isEmpty(this.f24062a.getState())) {
                    str = str3 + this.f24062a.getState();
                } else {
                    str = str2;
                }
                sb.append(str);
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                if (!TextUtils.isEmpty(this.f24062a.getCountryName())) {
                    StringBuilder sb4 = new StringBuilder();
                    if (!TextUtils.isEmpty(this.f24062a.getState())) {
                        str3 = ", ";
                    }
                    sb4.append(str3);
                    sb4.append(this.f24062a.getCountryName());
                    str2 = sb4.toString();
                }
                sb3.append(str2);
                String sb5 = sb3.toString();
                if (!TextUtils.isEmpty(sb5)) {
                    textView.setText(sb5);
                }
                if (!TextUtils.isEmpty(this.f24062a.getCityName())) {
                    textView2.setText(getString(R.string.near_by_airport_desc, this.f24062a.getCityName()));
                    textView3.setText(getString(R.string.near_by_airport_info, this.f24062a.getCityName()));
                }
                ListView listView = (ListView) inflate.findViewById(R.id.airport_listview);
                final com.travel.flight.c.a.a aVar = new com.travel.flight.c.a.a(getActivity(), this.f24062a.getmNearbyAirportData());
                listView.setAdapter(aVar);
                this.f24064c.setVisibility(8);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        b bVar = (b) aVar.getItem(i2);
                        a.a(bVar, a.this.f24062a);
                        a.this.f24063b.a(bVar, i2, a.this.f24062a);
                    }
                });
            }
            inflate.findViewById(R.id.close_view).setOnClickListener(this);
        }
        return inflate;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.close_view) {
            this.f24063b.a();
        }
    }

    static /* synthetic */ void a(b bVar, b bVar2) {
        if (bVar2 != null && bVar != null) {
            String cityName = bVar2.getCityName();
            String cityName2 = bVar.getCityName();
            HashMap hashMap = new HashMap();
            hashMap.put("event_label", cityName);
            hashMap.put("event_label2", cityName2);
            com.travel.flight.b.a();
            com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights", "flights_home", "nearby_airport_selected", hashMap);
        }
    }
}
