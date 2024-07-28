package com.travel.flight.flightticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.travel.flight.flightticket.f.j;
import com.travel.flight.pojo.f;
import com.travel.flight.pojo.flightticket.CJRAirportCity;
import java.util.ArrayList;

public final class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public CJRAirportCity f24593a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f24594b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public j f24595c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<f> f24596d;

    /* renamed from: e  reason: collision with root package name */
    private Context f24597e;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getViewTypeCount() {
        return 6;
    }

    public a(Context context, CJRAirportCity cJRAirportCity, ArrayList<f> arrayList) {
        this.f24595c = (j) context;
        this.f24594b = (LayoutInflater) context.getSystemService("layout_inflater");
        if (cJRAirportCity != null) {
            this.f24593a = cJRAirportCity;
        }
        this.f24596d = arrayList;
        this.f24597e = context;
    }

    public final int getCount() {
        CJRAirportCity cJRAirportCity = this.f24593a;
        if (cJRAirportCity == null || cJRAirportCity.getCjrAirportCityItemBody() == null) {
            return 0;
        }
        if (this.f24593a.getCjrAirportCityItemBody().getmAirportRouteItems() != null) {
            return this.f24593a.getCjrAirportCityItemBody().getmAirportRouteItems().size();
        }
        return this.f24593a.getCjrAirportCityItemBody().getmAirportCityItems().size();
    }

    public final Object getItem(int i2) {
        if (this.f24593a.getCjrAirportCityItemBody().getmAirportRouteItems() != null) {
            return this.f24593a.getCjrAirportCityItemBody().getmAirportRouteItems().get(i2);
        }
        return this.f24593a.getCjrAirportCityItemBody().getmAirportCityItems().get(i2);
    }

    public final int getItemViewType(int i2) {
        if (this.f24593a.getCjrAirportCityItemBody().getmAirportRouteItems() != null) {
            return this.f24593a.getCjrAirportCityItemBody().getmAirportRouteItems().get(i2).getItemType();
        }
        return this.f24593a.getCjrAirportCityItemBody().getmAirportCityItems().get(i2).getItemType();
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x013e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            r11 = this;
            int r14 = r11.getItemViewType(r12)
            r0 = 2
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 0
            r5 = 0
            if (r13 != 0) goto L_0x00ec
            if (r14 == 0) goto L_0x0043
            if (r14 == r0) goto L_0x003a
            if (r14 == r3) goto L_0x0031
            if (r14 == r2) goto L_0x0028
            if (r14 == r1) goto L_0x001f
            android.view.LayoutInflater r13 = r11.f24594b
            int r6 = com.travel.flight.R.layout.pre_f_airport_search_item
            android.view.View r13 = r13.inflate(r6, r5)
            goto L_0x004b
        L_0x001f:
            android.view.LayoutInflater r13 = r11.f24594b
            int r6 = com.travel.flight.R.layout.pre_f_flight_search_linguistic_item
            android.view.View r13 = r13.inflate(r6, r5)
            goto L_0x004b
        L_0x0028:
            android.view.LayoutInflater r13 = r11.f24594b
            int r6 = com.travel.flight.R.layout.pre_f_item_near_by_airport
            android.view.View r13 = r13.inflate(r6, r5)
            goto L_0x004b
        L_0x0031:
            android.view.LayoutInflater r13 = r11.f24594b
            int r6 = com.travel.flight.R.layout.pre_f_flight_recent_search_item
            android.view.View r13 = r13.inflate(r6, r5)
            goto L_0x004b
        L_0x003a:
            android.view.LayoutInflater r13 = r11.f24594b
            int r6 = com.travel.flight.R.layout.pre_f_airport_search_item
            android.view.View r13 = r13.inflate(r6, r5)
            goto L_0x004b
        L_0x0043:
            android.view.LayoutInflater r13 = r11.f24594b
            int r6 = com.travel.flight.R.layout.pre_f_flight_city_search_header
            android.view.View r13 = r13.inflate(r6, r5)
        L_0x004b:
            com.travel.flight.flightticket.a.a$a r6 = new com.travel.flight.flightticket.a.a$a
            r6.<init>(r11, r4)
            if (r14 == 0) goto L_0x00ca
            if (r14 == r3) goto L_0x00ab
            if (r14 == r2) goto L_0x0082
            if (r14 == r1) goto L_0x0077
            int r7 = com.travel.flight.R.id.flight_city_name
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24599a = r7
            int r7 = com.travel.flight.R.id.city_code
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24600b = r7
            int r7 = com.travel.flight.R.id.flight_airpot_name
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24602d = r7
            goto L_0x00e8
        L_0x0077:
            int r7 = com.travel.flight.R.id.linguistic_name
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24599a = r7
            goto L_0x00e8
        L_0x0082:
            int r7 = com.travel.flight.R.id.nearby_airport_name
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24607i = r7
            int r7 = com.travel.flight.R.id.near_by_airport_action
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.j = r7
            int r7 = com.travel.flight.R.id.near_by_airport_description
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.k = r7
            int r7 = com.travel.flight.R.id.icon_view
            android.view.View r7 = r13.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r6.l = r7
            goto L_0x00e8
        L_0x00ab:
            int r7 = com.travel.flight.R.id.recent_flight_source_name
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24603e = r7
            int r7 = com.travel.flight.R.id.recent_flight_destination_name
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24604f = r7
            int r7 = com.travel.flight.R.id.recent_flight_trip_type_icon
            android.view.View r7 = r13.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r6.f24605g = r7
            goto L_0x00e8
        L_0x00ca:
            int r7 = com.travel.flight.R.id.flight_city_search_header
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24599a = r7
            int r7 = com.travel.flight.R.id.flight_recent_city_clear
            android.view.View r7 = r13.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.f24601c = r7
            int r7 = com.travel.flight.R.id.no_item_lyt
            android.view.View r7 = r13.findViewById(r7)
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            r6.f24606h = r7
        L_0x00e8:
            r13.setTag(r6)
            goto L_0x00f2
        L_0x00ec:
            java.lang.Object r6 = r13.getTag()
            com.travel.flight.flightticket.a.a$a r6 = (com.travel.flight.flightticket.a.a.C0469a) r6
        L_0x00f2:
            com.travel.flight.pojo.flightticket.CJRAirportCity r7 = r11.f24593a
            if (r7 == 0) goto L_0x0139
            com.travel.flight.pojo.flightticket.CJRAirportCityItemBody r7 = r7.getCjrAirportCityItemBody()
            if (r7 == 0) goto L_0x0139
            com.travel.flight.pojo.flightticket.CJRAirportCity r7 = r11.f24593a
            com.travel.flight.pojo.flightticket.CJRAirportCityItemBody r7 = r7.getCjrAirportCityItemBody()
            java.util.ArrayList r7 = r7.getmAirportCityItems()
            if (r7 == 0) goto L_0x011c
            com.travel.flight.pojo.flightticket.CJRAirportCity r7 = r11.f24593a
            com.travel.flight.pojo.flightticket.CJRAirportCityItemBody r7 = r7.getCjrAirportCityItemBody()
            java.util.ArrayList r7 = r7.getmAirportCityItems()
            java.lang.Object r7 = r7.get(r12)
            com.travel.flight.pojo.flightticket.b r7 = (com.travel.flight.pojo.flightticket.b) r7
            r10 = r7
            r7 = r5
            r5 = r10
            goto L_0x013a
        L_0x011c:
            com.travel.flight.pojo.flightticket.CJRAirportCity r7 = r11.f24593a
            com.travel.flight.pojo.flightticket.CJRAirportCityItemBody r7 = r7.getCjrAirportCityItemBody()
            java.util.ArrayList r7 = r7.getmAirportRouteItems()
            if (r7 == 0) goto L_0x0139
            com.travel.flight.pojo.flightticket.CJRAirportCity r7 = r11.f24593a
            com.travel.flight.pojo.flightticket.CJRAirportCityItemBody r7 = r7.getCjrAirportCityItemBody()
            java.util.ArrayList r7 = r7.getmAirportRouteItems()
            java.lang.Object r7 = r7.get(r12)
            com.travel.flight.pojo.flightticket.CJRAirportCityLinguisticItem r7 = (com.travel.flight.pojo.flightticket.CJRAirportCityLinguisticItem) r7
            goto L_0x013a
        L_0x0139:
            r7 = r5
        L_0x013a:
            java.lang.String r8 = ""
            if (r14 == 0) goto L_0x02f7
            java.lang.String r9 = ", "
            if (r14 == r0) goto L_0x026c
            r0 = 1
            if (r14 == r3) goto L_0x020d
            if (r14 == r2) goto L_0x0162
            if (r14 == r1) goto L_0x014b
            goto L_0x035f
        L_0x014b:
            if (r7 == 0) goto L_0x035f
            java.lang.String r12 = r7.getDisplay_name()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x015b
            java.lang.String r8 = r7.getDisplay_name()
        L_0x015b:
            android.widget.TextView r12 = r6.f24599a
            r12.setText(r8)
            goto L_0x035f
        L_0x0162:
            if (r5 == 0) goto L_0x035f
            java.lang.String r12 = r5.getCityName()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0173
            java.lang.String r12 = r5.getCityName()
            goto L_0x0174
        L_0x0173:
            r12 = r8
        L_0x0174:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r12)
            java.lang.String r12 = r5.getState()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            java.lang.String r1 = " - "
            if (r12 != 0) goto L_0x0199
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r1)
            java.lang.String r2 = r5.getState()
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            goto L_0x019a
        L_0x0199:
            r12 = r8
        L_0x019a:
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r12)
            java.lang.String r12 = r5.getCountryName()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x01d1
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r2 = r5.getState()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01c3
            r1 = r9
        L_0x01c3:
            r12.append(r1)
            java.lang.String r1 = r5.getCountryName()
            r12.append(r1)
            java.lang.String r8 = r12.toString()
        L_0x01d1:
            r14.append(r8)
            java.lang.String r12 = r14.toString()
            android.widget.ImageView r14 = r6.l
            com.travel.utils.n$a r1 = com.travel.utils.n.a.V1
            java.lang.String r2 = "near_by_airport_revamp.png"
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r14, r2, r4, r4, r1)
            boolean r14 = android.text.TextUtils.isEmpty(r12)
            if (r14 != 0) goto L_0x01ec
            android.widget.TextView r14 = r6.f24607i
            r14.setText(r12)
        L_0x01ec:
            java.lang.String r12 = r5.getCityName()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x035f
            android.widget.TextView r12 = r6.k
            android.content.Context r14 = r11.f24597e
            int r1 = com.travel.flight.R.string.near_by_airport_desc
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = r5.getCityName()
            r0[r4] = r2
            java.lang.String r14 = r14.getString(r1, r0)
            r12.setText(r14)
            goto L_0x035f
        L_0x020d:
            if (r5 == 0) goto L_0x0260
            java.lang.String r14 = r5.getCityName()
            if (r14 == 0) goto L_0x0260
            java.lang.String r14 = r5.getCityName()
            java.lang.String r1 = "Recent List"
            boolean r14 = r14.equalsIgnoreCase(r1)
            if (r14 == 0) goto L_0x0260
            if (r12 <= 0) goto L_0x0260
            java.util.ArrayList<com.travel.flight.pojo.f> r14 = r11.f24596d
            if (r14 == 0) goto L_0x0260
            int r12 = r12 - r0
            int r14 = r14.size()
            if (r12 >= r14) goto L_0x0260
            java.util.ArrayList<com.travel.flight.pojo.f> r14 = r11.f24596d
            java.lang.Object r12 = r14.get(r12)
            com.travel.flight.pojo.f r12 = (com.travel.flight.pojo.f) r12
            android.widget.TextView r14 = r6.f24603e
            java.lang.String r0 = r12.getSourceCityName()
            r14.setText(r0)
            android.widget.TextView r14 = r6.f24604f
            java.lang.String r0 = r12.getDestCityName()
            r14.setText(r0)
            boolean r12 = r12.isRoundTrip()
            if (r12 == 0) goto L_0x0257
            android.widget.ImageView r12 = r6.f24605g
            int r14 = com.travel.flight.R.drawable.pre_f_actionbar_roundtrip_arrow
            r12.setImageResource(r14)
            goto L_0x035f
        L_0x0257:
            android.widget.ImageView r12 = r6.f24605g
            int r14 = com.travel.flight.R.drawable.pre_f_actionbar_right_arrow
            r12.setImageResource(r14)
            goto L_0x035f
        L_0x0260:
            android.widget.TextView r12 = r6.f24603e
            r12.setText(r8)
            android.widget.TextView r12 = r6.f24604f
            r12.setText(r8)
            goto L_0x035f
        L_0x026c:
            if (r5 == 0) goto L_0x02e7
            java.lang.String r12 = r5.getCityName()
            if (r12 == 0) goto L_0x02e7
            java.lang.String r12 = r5.getCountryName()
            if (r12 == 0) goto L_0x028b
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r9)
            java.lang.String r14 = r5.getCountryName()
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            goto L_0x028c
        L_0x028b:
            r12 = r8
        L_0x028c:
            java.lang.String r14 = r5.getAirPortName()
            if (r14 == 0) goto L_0x0297
            java.lang.String r14 = r5.getAirPortName()
            goto L_0x0298
        L_0x0297:
            r14 = r8
        L_0x0298:
            java.lang.String r0 = r5.getState()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r9)
            java.lang.String r1 = r5.getState()
            r0.append(r1)
            java.lang.String r8 = r0.toString()
        L_0x02b2:
            android.widget.TextView r0 = r6.f24599a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r5.getCityName()
            r1.append(r2)
            r1.append(r8)
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            r0.setText(r12)
            android.widget.TextView r12 = r6.f24602d
            r12.setText(r14)
            java.lang.String r12 = r5.getShortCityName()
            if (r12 == 0) goto L_0x035f
            android.widget.TextView r12 = r6.f24600b
            java.lang.String r14 = r5.getShortCityName()
            java.lang.String r14 = r14.toUpperCase()
            r12.setText(r14)
            goto L_0x035f
        L_0x02e7:
            android.widget.TextView r12 = r6.f24599a
            r12.setText(r8)
            android.widget.TextView r12 = r6.f24602d
            r12.setText(r8)
            android.widget.TextView r12 = r6.f24600b
            r12.setText(r8)
            goto L_0x035f
        L_0x02f7:
            if (r5 == 0) goto L_0x0346
            java.lang.String r12 = r5.getCityName()
            if (r12 == 0) goto L_0x0346
            android.widget.TextView r12 = r6.f24599a
            java.lang.String r14 = r5.getCityName()
            r12.setText(r14)
            java.lang.String r12 = r5.getCityName()
            java.lang.String r14 = "Recent Searches"
            boolean r12 = r12.equalsIgnoreCase(r14)
            if (r12 == 0) goto L_0x0324
            android.widget.TextView r12 = r6.f24601c
            r12.setVisibility(r4)
            android.widget.TextView r12 = r6.f24601c
            com.travel.flight.flightticket.a.a$1 r14 = new com.travel.flight.flightticket.a.a$1
            r14.<init>()
            r12.setOnClickListener(r14)
            goto L_0x035f
        L_0x0324:
            java.lang.String r12 = r5.getCityName()
            boolean r12 = r12.equals(r8)
            r14 = 8
            if (r12 == 0) goto L_0x0340
            android.widget.LinearLayout r12 = r6.f24606h
            r12.setVisibility(r4)
            android.widget.TextView r12 = r6.f24599a
            r12.setVisibility(r14)
            android.widget.TextView r12 = r6.f24601c
            r12.setVisibility(r14)
            goto L_0x035f
        L_0x0340:
            android.widget.TextView r12 = r6.f24601c
            r12.setVisibility(r14)
            goto L_0x035f
        L_0x0346:
            if (r7 == 0) goto L_0x035a
            android.widget.TextView r12 = r6.f24599a
            android.content.Context r14 = r11.f24597e
            android.content.res.Resources r14 = r14.getResources()
            int r0 = com.travel.flight.R.string.flight_suggested_routes
            java.lang.String r14 = r14.getString(r0)
            r12.setText(r14)
            goto L_0x035f
        L_0x035a:
            android.widget.TextView r12 = r6.f24599a
            r12.setText(r8)
        L_0x035f:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.a.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: com.travel.flight.flightticket.a.a$a  reason: collision with other inner class name */
    class C0469a {

        /* renamed from: a  reason: collision with root package name */
        TextView f24599a;

        /* renamed from: b  reason: collision with root package name */
        TextView f24600b;

        /* renamed from: c  reason: collision with root package name */
        TextView f24601c;

        /* renamed from: d  reason: collision with root package name */
        TextView f24602d;

        /* renamed from: e  reason: collision with root package name */
        TextView f24603e;

        /* renamed from: f  reason: collision with root package name */
        TextView f24604f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f24605g;

        /* renamed from: h  reason: collision with root package name */
        LinearLayout f24606h;

        /* renamed from: i  reason: collision with root package name */
        TextView f24607i;
        TextView j;
        TextView k;
        ImageView l;

        private C0469a() {
        }

        /* synthetic */ C0469a(a aVar, byte b2) {
            this();
        }
    }
}
