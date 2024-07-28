package com.travel.flight.flightticket.c;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f24841a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f24842b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24843c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f24844d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public k f24845e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f24846f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f24847g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, ArrayList<CJRAncillarySelectedItem>> f24848h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, ArrayList<CJRAncillarySelectedItem>> f24849i;

    public a(Context context, k kVar) {
        super(context, 16973936);
        this.f24843c = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.pre_f_flight_ancillary_dialog_details);
        this.f24845e = kVar;
        b();
        a();
    }

    private void a() {
        this.f24846f = (LinearLayout) findViewById(R.id.meals_item_container);
        this.f24847g = (LinearLayout) findViewById(R.id.baggage_item_container);
        this.f24844d = (ImageView) findViewById(R.id.image_view_conv_fee_details_close_button);
        this.f24844d.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.f24844d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f24845e.reviewIternaryActionClick((String) null, (Intent) null, (Boolean) null, c.ANCILLARY_DETAILS_CLOSE);
            }
        });
        this.f24841a = (LinearLayout) findViewById(R.id.linear_meal_parent);
        this.f24842b = (LinearLayout) findViewById(R.id.linear_baggage_parent);
        Map<String, ArrayList<CJRAncillarySelectedItem>> map = this.f24848h;
        int i2 = 0;
        if (map != null && map.size() > 0) {
            this.f24841a.setVisibility(0);
            int i3 = 0;
            for (Map.Entry next : this.f24848h.entrySet()) {
                a((String) next.getKey(), (ArrayList) next.getValue(), this.f24846f, i3);
                i3++;
            }
        }
        Map<String, ArrayList<CJRAncillarySelectedItem>> map2 = this.f24849i;
        if (map2 != null && map2.size() > 0) {
            this.f24842b.setVisibility(0);
            for (Map.Entry next2 : this.f24849i.entrySet()) {
                a((String) next2.getKey(), (ArrayList) next2.getValue(), this.f24847g, i2);
                i2++;
            }
        }
    }

    private void b() {
        this.f24848h = new HashMap();
        this.f24849i = new HashMap();
        CJRFlightAncillaryReqBody instance = CJRFlightAncillaryReqBody.getInstance();
        if (instance.getOnwardJrny() != null) {
            Iterator<CJRFlightAncillaryReqBodyItemDetail> it2 = instance.getOnwardJrny().iterator();
            while (it2.hasNext()) {
                CJRFlightAncillaryReqBodyItemDetail next = it2.next();
                String str = next.getOrigin() + AppConstants.COLON + next.getDestination();
                Iterator<CJRAncillarySsrsReqBody> it3 = next.getSsrs().iterator();
                while (it3.hasNext()) {
                    Iterator<CJRAncillarySelectedItem> it4 = it3.next().getItems().iterator();
                    while (it4.hasNext()) {
                        CJRAncillarySelectedItem next2 = it4.next();
                        if (next2.isBaggage()) {
                            a(this.f24849i, str, next2);
                        } else {
                            a(this.f24848h, str, next2);
                        }
                    }
                }
            }
        }
        if (instance.getReturnJrny() != null) {
            Iterator<CJRFlightAncillaryReqBodyItemDetail> it5 = instance.getReturnJrny().iterator();
            while (it5.hasNext()) {
                CJRFlightAncillaryReqBodyItemDetail next3 = it5.next();
                String str2 = next3.getOrigin() + AppConstants.COLON + next3.getDestination();
                Iterator<CJRAncillarySsrsReqBody> it6 = next3.getSsrs().iterator();
                while (it6.hasNext()) {
                    Iterator<CJRAncillarySelectedItem> it7 = it6.next().getItems().iterator();
                    while (it7.hasNext()) {
                        CJRAncillarySelectedItem next4 = it7.next();
                        if (next4.isBaggage()) {
                            a(this.f24849i, str2, next4);
                        } else {
                            a(this.f24848h, str2, next4);
                        }
                    }
                }
            }
        }
    }

    private static void a(Map<String, ArrayList<CJRAncillarySelectedItem>> map, String str, CJRAncillarySelectedItem cJRAncillarySelectedItem) {
        ArrayList arrayList;
        if (map.containsKey(str)) {
            arrayList = new ArrayList(map.get(str));
        } else {
            arrayList = new ArrayList();
        }
        arrayList.add(cJRAncillarySelectedItem);
        map.put(str, arrayList);
    }

    private void a(String str, ArrayList<CJRAncillarySelectedItem> arrayList, LinearLayout linearLayout, int i2) {
        String[] split = str.split("\\:");
        if (split != null && split.length == 2) {
            View inflate = LayoutInflater.from(this.f24843c).inflate(R.layout.pre_f_ancillary_dialog_hop_details, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.source_hop_ita)).setText(split[0]);
            ((TextView) inflate.findViewById(R.id.destination_hop_ita)).setText(split[1]);
            LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.item_container);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                CJRAncillarySelectedItem cJRAncillarySelectedItem = arrayList.get(i3);
                if (i2 == 0) {
                    inflate.findViewById(R.id.hop_devider).setVisibility(8);
                }
                a(cJRAncillarySelectedItem, linearLayout2);
            }
            linearLayout.addView(inflate);
        }
    }

    private void a(CJRAncillarySelectedItem cJRAncillarySelectedItem, LinearLayout linearLayout) {
        View inflate = LayoutInflater.from(this.f24843c).inflate(R.layout.pre_f_ancillary_order_summary_item, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_item_name);
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_item_price);
        if (cJRAncillarySelectedItem.isBaggage()) {
            textView.setText(cJRAncillarySelectedItem.getName() + " " + this.f24843c.getResources().getString(R.string.flight_additional_luggage));
        } else {
            textView.setText(cJRAncillarySelectedItem.getName() + " (" + com.travel.flight.utils.c.a(cJRAncillarySelectedItem.getPrice()) + "x" + com.travel.flight.utils.c.a((double) cJRAncillarySelectedItem.getCount()) + ")");
        }
        textView2.setText(this.f24843c.getResources().getString(R.string.rs_symbol) + com.travel.flight.utils.c.a(((double) cJRAncillarySelectedItem.getCount()) * cJRAncillarySelectedItem.getPrice()));
        linearLayout.addView(inflate);
    }
}
