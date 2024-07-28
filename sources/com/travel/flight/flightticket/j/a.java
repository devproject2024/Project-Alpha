package com.travel.flight.flightticket.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.h;
import com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRDisplayElements;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySelectedItem;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRAncillarySsrsReqBody;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBodyItemDetail;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.model.CJRSeatSelectedItem;
import com.travel.flight.pojo.model.CJRSeatSelection;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a extends RecyclerView.v implements View.OnClickListener {
    private int A = 0;
    private int B = 0;

    /* renamed from: a  reason: collision with root package name */
    HashMap<String, Integer> f25041a;

    /* renamed from: b  reason: collision with root package name */
    HashMap<String, Integer> f25042b;

    /* renamed from: c  reason: collision with root package name */
    HashMap<String, Double> f25043c;

    /* renamed from: d  reason: collision with root package name */
    HashMap<String, Double> f25044d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f25045e;

    /* renamed from: f  reason: collision with root package name */
    private h f25046f;

    /* renamed from: g  reason: collision with root package name */
    private View f25047g;

    /* renamed from: h  reason: collision with root package name */
    private CJRFlightDetails f25048h;

    /* renamed from: i  reason: collision with root package name */
    private CJRAncillaryDisplayElement f25049i;
    private CJRDisplayElements j;
    private View k;
    private View l;
    private View m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private String x;
    private String y;
    private String z;

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.view.View r4, com.travel.flight.pojo.flightticket.CJRFlightDetails r5, com.travel.flight.flightticket.f.h r6, com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRDisplayElements r7, com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement r8) {
        /*
            r3 = this;
            r3.<init>(r4)
            r0 = 0
            r3.A = r0
            r3.B = r0
            r3.f25046f = r6
            r3.f25047g = r4
            r3.f25048h = r5
            r3.f25049i = r8
            android.content.Context r5 = r4.getContext()
            r3.f25045e = r5
            r3.j = r7
            int r5 = com.travel.flight.R.id.ancillary_seats
            android.view.View r5 = r4.findViewById(r5)
            r3.m = r5
            int r5 = com.travel.flight.R.id.ancillary_baggage
            android.view.View r5 = r4.findViewById(r5)
            r3.k = r5
            int r5 = com.travel.flight.R.id.ancillary_meals
            android.view.View r5 = r4.findViewById(r5)
            r3.l = r5
            int r5 = com.travel.flight.R.id.ancillary_baggage_icon
            android.view.View r5 = r4.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.u = r5
            int r5 = com.travel.flight.R.id.ancillary_meals_icon
            android.view.View r5 = r4.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.v = r5
            int r5 = com.travel.flight.R.id.ancillary_seats_select
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.t = r5
            int r5 = com.travel.flight.R.id.ancillary_baggage_add
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.r = r5
            int r5 = com.travel.flight.R.id.ancillary_meals_add
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.s = r5
            int r5 = com.travel.flight.R.id.ancillary_nonveg_meals_added_value
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.o = r5
            int r5 = com.travel.flight.R.id.ancillary_veg_meals_added_value
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.n = r5
            int r5 = com.travel.flight.R.id.ancillary_seats_added_value
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.q = r5
            int r5 = com.travel.flight.R.id.ancillary_baggage_weight
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.p = r4
            android.view.View r4 = r3.l
            r4.setOnClickListener(r3)
            android.view.View r4 = r3.k
            r4.setOnClickListener(r3)
            android.view.View r4 = r3.m
            if (r4 == 0) goto L_0x009b
            r4.setOnClickListener(r3)
        L_0x009b:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r3.f25048h
            r5 = 1
            if (r4 == 0) goto L_0x00d1
            if (r4 == 0) goto L_0x00be
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmOnwardJourney()
            if (r4 == 0) goto L_0x00be
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r3.f25048h
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmOnwardJourney()
            boolean r4 = r4.isSeatAncillaryEligible()
            if (r4 == 0) goto L_0x00be
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r3.f25048h
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmReturnJourney()
            if (r4 != 0) goto L_0x00be
            r4 = 1
            goto L_0x00d2
        L_0x00be:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r3.f25048h
            if (r4 == 0) goto L_0x00d1
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmReturnJourney()
            if (r4 == 0) goto L_0x00d1
            com.travel.flight.pojo.flightticket.CJRFlightDetails r4 = r3.f25048h
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r4 = r4.getmReturnJourney()
            r4.isSeatAncillaryEligible()
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r3.f25048h
            if (r6 == 0) goto L_0x0102
            if (r6 == 0) goto L_0x00eb
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r6.getmOnwardJourney()
            if (r6 == 0) goto L_0x00eb
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r3.f25048h
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r6.getmOnwardJourney()
            boolean r6 = r6.isAncillaryEligible()
            if (r6 == 0) goto L_0x00eb
            goto L_0x0103
        L_0x00eb:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r3.f25048h
            if (r6 == 0) goto L_0x0102
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r6.getmReturnJourney()
            if (r6 == 0) goto L_0x0102
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r3.f25048h
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r6.getmReturnJourney()
            boolean r6 = r6.isAncillaryEligible()
            if (r6 == 0) goto L_0x0102
            goto L_0x0103
        L_0x0102:
            r5 = 0
        L_0x0103:
            r6 = 2
            r7 = 0
            r8 = 8
            if (r5 == 0) goto L_0x0171
            android.view.View r1 = r3.l
            r1.setVisibility(r0)
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement r1 = r3.f25049i
            if (r1 == 0) goto L_0x013f
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElementItem r1 = r1.getFood()
            if (r1 == 0) goto L_0x013f
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement r1 = r3.f25049i
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElementItem r1 = r1.getFood()
            java.lang.String r1 = r1.getIcon()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x013f
            android.content.Context r1 = r3.f25045e
            com.paytm.utility.b.b$a$a r1 = com.paytm.utility.b.b.a(r1)
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement r2 = r3.f25049i
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElementItem r2 = r2.getFood()
            java.lang.String r2 = r2.getIcon()
            r1.f43753a = r2
            android.widget.ImageView r2 = r3.v
            com.paytm.utility.b.b.a.C0750a.a(r1, r2, r7, r6)
        L_0x013f:
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement r1 = r3.f25049i
            if (r1 == 0) goto L_0x017b
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElementItem r1 = r1.getBaggage()
            if (r1 == 0) goto L_0x017b
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement r1 = r3.f25049i
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElementItem r1 = r1.getBaggage()
            java.lang.String r1 = r1.getIcon()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x017b
            android.content.Context r1 = r3.f25045e
            com.paytm.utility.b.b$a$a r1 = com.paytm.utility.b.b.a(r1)
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement r2 = r3.f25049i
            com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElementItem r2 = r2.getBaggage()
            java.lang.String r2 = r2.getIcon()
            r1.f43753a = r2
            android.widget.ImageView r2 = r3.u
            com.paytm.utility.b.b.a.C0750a.a(r1, r2, r7, r6)
            goto L_0x017b
        L_0x0171:
            android.view.View r1 = r3.l
            r1.setVisibility(r8)
            android.view.View r1 = r3.l
            r1.setEnabled(r0)
        L_0x017b:
            if (r5 == 0) goto L_0x0183
            android.view.View r5 = r3.k
            r5.setVisibility(r0)
            goto L_0x018d
        L_0x0183:
            android.view.View r5 = r3.k
            r5.setVisibility(r8)
            android.view.View r5 = r3.k
            r5.setEnabled(r0)
        L_0x018d:
            if (r4 == 0) goto L_0x01ec
            android.view.View r4 = r3.m
            r4.setVisibility(r0)
            android.content.Context r4 = r3.f25045e
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.flight.R.string.flight_ancillary_prerselect_seat
            java.lang.String r4 = r4.getString(r5)
            r3.x = r4
            android.view.View r4 = r3.f25047g
            int r5 = com.travel.flight.R.id.ancillary_seats_icon
            android.view.View r4 = r4.findViewById(r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.w = r4
            com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRDisplayElements r4 = r3.j
            if (r4 == 0) goto L_0x01e0
            com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRAncillarySeat r4 = r4.getSeat()
            if (r4 == 0) goto L_0x01e0
            com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRDisplayElements r4 = r3.j
            com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRAncillarySeat r4 = r4.getSeat()
            java.lang.String r4 = r4.getIcon()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01eb
            android.content.Context r4 = r3.f25045e
            com.paytm.utility.b.b$a$a r4 = com.paytm.utility.b.b.a(r4)
            com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRDisplayElements r5 = r3.j
            com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRAncillarySeat r5 = r5.getSeat()
            java.lang.String r5 = r5.getIcon()
            r4.f43753a = r5
            android.widget.ImageView r5 = r3.w
            com.paytm.utility.b.b.a.C0750a.a(r4, r5, r7, r6)
            return
        L_0x01e0:
            android.view.View r4 = r3.m
            r5 = 4
            r4.setVisibility(r5)
            android.view.View r4 = r3.m
            r4.setEnabled(r0)
        L_0x01eb:
            return
        L_0x01ec:
            android.view.View r4 = r3.m
            r4.setVisibility(r8)
            android.view.View r4 = r3.m
            r4.setEnabled(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.j.a.<init>(android.view.View, com.travel.flight.pojo.flightticket.CJRFlightDetails, com.travel.flight.flightticket.f.h, com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRDisplayElements, com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDisplayElement):void");
    }

    public final void onClick(View view) {
        h hVar;
        if (view == this.l) {
            h hVar2 = this.f25046f;
            if (hVar2 != null) {
                hVar2.a(Boolean.FALSE, c.ANCILLARY_BUY_MEAL);
            }
        } else if (view == this.k) {
            h hVar3 = this.f25046f;
            if (hVar3 != null) {
                hVar3.a(Boolean.FALSE, c.ANCILLARY_BUY_BAG);
            }
        } else if (view == this.m && (hVar = this.f25046f) != null) {
            hVar.a(Boolean.FALSE, c.ANCILLARY_SELECT_SEAT);
        }
    }

    public final void a(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
        String str = "";
        if (cJRTravellerSeatTransition != null) {
            for (int i2 = 0; i2 < cJRTravellerSeatTransition.getOnwardSeatSelections().size(); i2++) {
                CJRSeatSelection cJRSeatSelection = cJRTravellerSeatTransition.getOnwardSeatSelections().get(i2);
                if (cJRSeatSelection != null && cJRSeatSelection.getmSelectedSeatsCount() == cJRSeatSelection.getmSeatSelectedItems().size()) {
                    String str2 = str;
                    for (int i3 = 0; i3 < cJRSeatSelection.getmSeatSelectedItems().size(); i3++) {
                        CJRSeatSelectedItem cJRSeatSelectedItem = cJRSeatSelection.getmSeatSelectedItems().get(i3);
                        if (cJRSeatSelectedItem != null) {
                            String str3 = cJRSeatSelectedItem.getmSeatNumber();
                            if (!TextUtils.isEmpty(str2)) {
                                str2 = str2 + ", " + str3;
                            } else {
                                str2 = str3;
                            }
                        }
                    }
                    str = str2;
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.q.setText(str);
            this.q.setVisibility(0);
            this.t.setVisibility(8);
            return;
        }
        this.q.setVisibility(8);
        this.t.setVisibility(0);
        this.q.setText("");
    }

    public final void a() {
        int i2;
        int i3;
        this.f25041a = new HashMap<>();
        this.f25042b = new HashMap<>();
        this.f25044d = new HashMap<>();
        this.f25043c = new HashMap<>();
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        StringBuilder sb3 = new StringBuilder("");
        CJRFlightAncillaryReqBody instance = CJRFlightAncillaryReqBody.getInstance();
        if (instance.getOnwardJrny() != null) {
            Iterator<CJRFlightAncillaryReqBodyItemDetail> it2 = instance.getOnwardJrny().iterator();
            i3 = 0;
            i2 = 0;
            while (it2.hasNext()) {
                Iterator<CJRAncillarySsrsReqBody> it3 = it2.next().getSsrs().iterator();
                while (it3.hasNext()) {
                    Iterator<CJRAncillarySelectedItem> it4 = it3.next().getItems().iterator();
                    while (it4.hasNext()) {
                        CJRAncillarySelectedItem next = it4.next();
                        if (!next.isBaggage()) {
                            if (next.isVeg()) {
                                i3 += next.getCount();
                            } else {
                                i2 += next.getCount();
                            }
                            if (this.f25042b.containsKey(next.getName())) {
                                this.f25042b.put(next.getName(), Integer.valueOf(next.getCount() + this.f25042b.get(next.getName()).intValue()));
                            } else {
                                this.f25042b.put(next.getName(), Integer.valueOf(next.getCount()));
                                this.f25043c.put(next.getName(), Double.valueOf(next.getPrice()));
                            }
                        } else if (this.f25041a.containsKey(next.getName())) {
                            this.f25041a.put(next.getName(), Integer.valueOf(next.getCount() + this.f25041a.get(next.getName()).intValue()));
                        } else {
                            this.f25041a.put(next.getName(), Integer.valueOf(next.getCount()));
                            this.f25044d.put(next.getName(), Double.valueOf(next.getPrice()));
                        }
                    }
                }
            }
        } else {
            i3 = 0;
            i2 = 0;
        }
        if (instance.getReturnJrny() != null) {
            Iterator<CJRFlightAncillaryReqBodyItemDetail> it5 = instance.getReturnJrny().iterator();
            while (it5.hasNext()) {
                Iterator<CJRAncillarySsrsReqBody> it6 = it5.next().getSsrs().iterator();
                while (it6.hasNext()) {
                    Iterator<CJRAncillarySelectedItem> it7 = it6.next().getItems().iterator();
                    while (it7.hasNext()) {
                        CJRAncillarySelectedItem next2 = it7.next();
                        if (!next2.isBaggage()) {
                            if (next2.isVeg()) {
                                i3 += next2.getCount();
                            } else {
                                i2 += next2.getCount();
                            }
                            if (this.f25042b.containsKey(next2.getName())) {
                                this.f25042b.put(next2.getName(), Integer.valueOf(next2.getCount() + this.f25042b.get(next2.getName()).intValue()));
                            } else {
                                this.f25042b.put(next2.getName(), Integer.valueOf(next2.getCount()));
                                this.f25043c.put(next2.getName(), Double.valueOf(next2.getPrice()));
                            }
                        } else if (this.f25041a.containsKey(next2.getName())) {
                            this.f25041a.put(next2.getName(), Integer.valueOf(next2.getCount() + this.f25041a.get(next2.getName()).intValue()));
                        } else {
                            this.f25041a.put(next2.getName(), Integer.valueOf(next2.getCount()));
                            this.f25044d.put(next2.getName(), Double.valueOf(next2.getPrice()));
                        }
                    }
                }
            }
        }
        int i4 = 1;
        if (this.f25041a.size() > 0) {
            this.r.setVisibility(8);
            String str = "";
            boolean z2 = true;
            for (Map.Entry next3 : this.f25041a.entrySet()) {
                if (!z2) {
                    str = str + ",\n";
                }
                if (((Integer) next3.getValue()).intValue() > i4) {
                    str = str + ((String) next3.getKey()) + " (" + next3.getValue() + ")";
                } else {
                    str = str + ((String) next3.getKey());
                }
                if (TextUtils.isEmpty(sb)) {
                    sb.append(((String) next3.getKey()).replaceAll(AppConstants.AND_SIGN, " "));
                    sb2.append(this.f25044d.get(next3.getKey()));
                    sb3.append(next3.getValue());
                } else {
                    sb.append(AppConstants.AND_SIGN + ((String) next3.getKey()).replaceAll(AppConstants.AND_SIGN, " "));
                    sb2.append(AppConstants.AND_SIGN + this.f25044d.get(next3.getKey()));
                    sb3.append(AppConstants.AND_SIGN + next3.getValue());
                }
                this.z = sb + "|" + sb2 + "|" + sb3;
                i4 = 1;
                z2 = false;
            }
            this.p.setText(str);
            this.p.setVisibility(0);
        } else {
            this.r.setVisibility(0);
            this.p.setVisibility(8);
        }
        if (this.f25042b.size() > 0) {
            StringBuilder sb4 = new StringBuilder("");
            StringBuilder sb5 = new StringBuilder("");
            StringBuilder sb6 = new StringBuilder("");
            this.s.setVisibility(8);
            for (Map.Entry next4 : this.f25042b.entrySet()) {
                if (TextUtils.isEmpty(sb4)) {
                    sb4.append(((String) next4.getKey()).replaceAll(AppConstants.AND_SIGN, " "));
                    sb5.append(this.f25043c.get(next4.getKey()));
                    sb6.append(next4.getValue());
                } else {
                    sb4.append(AppConstants.AND_SIGN + ((String) next4.getKey()).replaceAll(AppConstants.AND_SIGN, " "));
                    sb5.append(AppConstants.AND_SIGN + this.f25043c.get(next4.getKey()));
                    sb6.append(AppConstants.AND_SIGN + next4.getValue());
                }
                this.y = sb4 + "|" + sb5 + "|" + sb6;
            }
            if (i3 > 0) {
                TextView textView = this.n;
                textView.setText(String.format(textView.getResources().getString(R.string.veg_meals), new Object[]{String.valueOf(i3)}));
                this.n.setVisibility(0);
            } else {
                this.n.setText("");
                this.n.setVisibility(8);
            }
            if (i2 > 0) {
                this.o.setText(String.format(this.n.getResources().getString(R.string.non_veg_meals), new Object[]{String.valueOf(i2)}));
                this.o.setVisibility(0);
                return;
            }
            this.o.setText("");
            this.o.setVisibility(8);
            return;
        }
        this.s.setVisibility(0);
        this.n.setText("");
        this.n.setVisibility(8);
        this.o.setText("");
        this.o.setVisibility(8);
    }
}
