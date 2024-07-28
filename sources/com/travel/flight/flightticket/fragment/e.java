package com.travel.flight.flightticket.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.flight.R;
import com.travel.flight.c;
import com.travel.flight.flightorder.i.a;
import com.travel.flight.flightticket.f.f;
import com.travel.flight.flightticket.g.d;
import com.travel.flight.pojo.flightticket.CJRFlightOfferCode;
import com.travel.flight.pojo.flightticket.CJROffers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.i.h;

public class e extends h implements f {

    /* renamed from: a  reason: collision with root package name */
    private View f24967a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f24968b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f24969c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f24970d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d f24971e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f24972f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<CJRFlightOfferCode> f24973g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private HashMap<CJRFlightOfferCode, List<String>> f24974h;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f24967a = layoutInflater.inflate(R.layout.pre_f_flight_pager_layout, viewGroup, false);
        if (this.f24971e == null) {
            this.f24971e = new d(getActivity().getApplicationContext(), this);
        }
        this.f24970d = (ProgressBar) this.f24967a.findViewById(R.id.progress_bar);
        this.f24972f = (LinearLayout) this.f24967a.findViewById(R.id.linear_flight_recent_list);
        d dVar = this.f24971e;
        CJROffers cJROffers = new CJROffers();
        if (URLUtil.isValidUrl(dVar.f25020b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ssotoken", a.a(dVar.f25019a));
            b bVar = new b();
            bVar.f42877a = dVar.f25019a;
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.GET;
            bVar.n = a.b.SILENT;
            bVar.o = dVar.f25019a.getClass().getSimpleName();
            bVar.f42880d = dVar.f25020b;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = cJROffers;
            bVar.j = new com.paytm.network.listener.b() {
                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                }

                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    d.this.f25021c.a(iJRPaytmDataModel);
                }
            };
            bVar.t = null;
            com.paytm.network.a l = bVar.l();
            l.f42860d = true;
            l.a();
        }
        return this.f24967a;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJROffers) {
            this.f24973g = (ArrayList) ((CJROffers) iJRPaytmDataModel).getmOfferCodes();
            this.f24974h = new HashMap<>();
            int i2 = 0;
            Iterator<CJRFlightOfferCode> it2 = this.f24973g.iterator();
            while (it2.hasNext()) {
                CJRFlightOfferCode next = it2.next();
                ArrayList arrayList = new ArrayList();
                arrayList.add((next == null || next.getTerms() == null) ? null : next.getTerms());
                this.f24974h.put(this.f24973g.get(i2), arrayList);
                i2++;
            }
            a();
        }
    }

    private void a() {
        int i2;
        String str;
        String str2 = "<br>";
        try {
            int size = this.f24973g.size();
            this.f24969c = LayoutInflater.from(getActivity().getApplicationContext());
            final ImageView[] imageViewArr = new ImageView[size];
            final LinearLayout[] linearLayoutArr = new LinearLayout[size];
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                CJRFlightOfferCode cJRFlightOfferCode = this.f24973g.get(i4);
                View inflate = this.f24969c.inflate(R.layout.pre_f_utility_offer_item_view, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.offer_item_label);
                TextView textView2 = (TextView) inflate.findViewById(R.id.offer_item_code);
                TextView textView3 = (TextView) inflate.findViewById(R.id.offer_item_hint_text);
                imageViewArr[i4] = (ImageView) inflate.findViewById(R.id.arrow_icon_view);
                linearLayoutArr[i4] = (LinearLayout) inflate.findViewById(R.id.order_datails_linear);
                LinearLayout linearLayout = linearLayoutArr[i4];
                String replace = ((String) this.f24974h.get(cJRFlightOfferCode).get(i3)).replace("*", "");
                if (replace.contains(str2)) {
                    String[] split = replace.split(str2);
                    int i5 = 0;
                    while (i5 < split.length) {
                        String str3 = str2;
                        View inflate2 = this.f24969c.inflate(R.layout.pre_f_offer_list_item_layout, (ViewGroup) null);
                        ((TextView) inflate2.findViewById(R.id.offer_details_text)).setText(split[i5]);
                        linearLayout.addView(inflate2);
                        i5++;
                        str2 = str3;
                        size = size;
                    }
                    str = str2;
                    i2 = size;
                } else {
                    str = str2;
                    i2 = size;
                    View inflate3 = this.f24969c.inflate(R.layout.pre_f_offer_web_view, (ViewGroup) null);
                    ((TextView) inflate3.findViewById(R.id.offer_details_text)).setText(replace);
                    linearLayout.addView(inflate3);
                }
                textView.setText("");
                textView2.setText(getResources().getString(R.string.promocode) + " : " + cJRFlightOfferCode.getCode());
                textView3.setText(cJRFlightOfferCode.getOfferText().trim());
                imageViewArr[i4].setImageResource(R.drawable.pre_f_expand_down_arrow);
                this.f24972f.addView(inflate);
                inflate.setTag(Integer.valueOf(i4));
                inflate.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        if (((CJRFlightOfferCode) e.this.f24973g.get(intValue)).getCode() != null) {
                            d c2 = e.this.f24971e;
                            String b2 = e.this.f24968b;
                            String code = ((CJRFlightOfferCode) e.this.f24973g.get(intValue)).getCode();
                            HashMap hashMap = new HashMap();
                            hashMap.put(b2 + "_promo_code", code);
                            hashMap.put("recharge_business_sub_vertical", b2);
                            com.travel.flight.b.a();
                            c b3 = com.travel.flight.b.b();
                            b3.a(b2 + "_offer_details_selected", (Map<String, Object>) hashMap, c2.f25019a);
                        }
                        if (linearLayoutArr[intValue].getVisibility() == 8) {
                            linearLayoutArr[intValue].setVisibility(0);
                            imageViewArr[intValue].setImageResource(R.drawable.pre_f_expand_up_arrow);
                            LinearLayout[] linearLayoutArr = linearLayoutArr;
                            int length = (linearLayoutArr == null || linearLayoutArr.length <= 0) ? 0 : linearLayoutArr.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (intValue != i2) {
                                    linearLayoutArr[i2].setVisibility(8);
                                    imageViewArr[i2].setImageResource(R.drawable.pre_f_expand_down_arrow);
                                }
                            }
                            return;
                        }
                        linearLayoutArr[intValue].setVisibility(8);
                        imageViewArr[intValue].setImageResource(R.drawable.pre_f_expand_down_arrow);
                    }
                });
                i4++;
                str2 = str;
                size = i2;
                i3 = 0;
            }
            this.f24970d.setVisibility(8);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }
}
