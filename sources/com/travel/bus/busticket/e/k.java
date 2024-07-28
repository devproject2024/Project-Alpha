package com.travel.bus.busticket.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.a.c;
import com.travel.bus.busticket.a.t;
import com.travel.bus.busticket.a.w;
import com.travel.bus.busticket.b.d;
import com.travel.bus.model.a;
import com.travel.bus.pojo.busticket.BusEcosystemOfferInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class k extends RecyclerView.v {
    public View A;
    public ImageView B;
    public TextView C;
    public HashMap<String, CJRBusSearchOperatorTagInfo> D;
    public HashMap<String, ArrayList<BusEcosystemOfferInfo>> E;
    private t F;
    private c G;
    private ArrayList<CJRBusSearchItem> H;
    private HashMap<String, CJRBusSearchAmenitiesInfo> I;
    private d J;
    private w.c K;

    /* renamed from: a  reason: collision with root package name */
    public Context f22165a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22166b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22167c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22168d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f22169e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f22170f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22171g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22172h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f22173i;
    public RecyclerView j;
    public RecyclerView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public ViewGroup y;
    public View z;

    public k(Context context, View view, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap, HashMap<String, CJRBusSearchOperatorTagInfo> hashMap2, HashMap<String, ArrayList<BusEcosystemOfferInfo>> hashMap3, d dVar, ArrayList<CJRBusSearchItem> arrayList, w.c cVar) {
        super(view);
        this.f22165a = context;
        this.I = hashMap;
        this.D = hashMap2;
        this.E = hashMap3;
        this.J = dVar;
        this.K = cVar;
        this.H = arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0604  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0636  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0646  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x064c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.bus.pojo.busticket.CJRBusSearchItem r15) {
        /*
            r14 = this;
            if (r15 == 0) goto L_0x0677
            java.lang.String r0 = r15.getDepartureDatetime()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r15.getArrivalDatetime()
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r15.getDepartureDatetime()
            java.lang.String r2 = "h:mm a"
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r0 = com.paytm.utility.b.a((java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r2)
            java.lang.String r4 = r15.getArrivalDatetime()
            java.lang.String r2 = com.paytm.utility.b.a((java.lang.String) r4, (java.lang.String) r3, (java.lang.String) r2)
            if (r0 == 0) goto L_0x0046
            if (r2 == 0) goto L_0x0046
            android.widget.TextView r3 = r14.u
            java.lang.String r0 = r0.toUpperCase()
            r3.setText(r0)
            android.widget.TextView r0 = r14.v
            java.lang.String r2 = r2.toUpperCase()
            r0.setText(r2)
            goto L_0x0046
        L_0x003c:
            android.widget.TextView r0 = r14.u
            r0.setText(r1)
            android.widget.TextView r0 = r14.v
            r0.setText(r1)
        L_0x0046:
            android.widget.ImageView r0 = r14.B
            r2 = 8
            r0.setVisibility(r2)
            android.view.View r0 = r14.A
            r0.setVisibility(r2)
            java.util.List r0 = r15.getDetailedFare()
            int r0 = r0.size()
            java.lang.String r3 = "###,###,###.##"
            java.lang.String r4 = " "
            r5 = 1
            r6 = 0
            if (r0 <= 0) goto L_0x011d
            java.util.List r0 = r15.getDetailedFare()
            java.lang.Object r0 = r0.get(r6)
            com.travel.bus.pojo.bussearch.CJRDetailedFare r0 = (com.travel.bus.pojo.bussearch.CJRDetailedFare) r0
            java.lang.Double r7 = r0.getBaseFare()
            double r7 = r7.doubleValue()
            android.content.Context r9 = r14.f22165a
            int r10 = com.travel.bus.R.string.rs
            java.lang.String r9 = r9.getString(r10)
            boolean r10 = r0.bHasDeals()
            if (r10 == 0) goto L_0x00d8
            com.travel.bus.pojo.bussearch.CJRDeal r10 = r0.getDeal()
            java.lang.Double r10 = r10.getRevisedBaseFare()
            double r10 = r10.doubleValue()
            java.lang.String r10 = com.paytm.utility.b.a((double) r10, (java.lang.String) r3)
            android.widget.TextView r11 = r14.x
            r11.setVisibility(r6)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            r11.append(r4)
            java.lang.String r3 = com.paytm.utility.b.a((double) r7, (java.lang.String) r3)
            r11.append(r3)
            java.lang.String r3 = r11.toString()
            android.widget.TextView r7 = r14.x
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r3)
            android.text.style.StrikethroughSpan r11 = new android.text.style.StrikethroughSpan
            r11.<init>()
            int r3 = r3.length()
            r12 = 33
            r8.setSpan(r11, r6, r3, r12)
            r7.setText(r8)
            android.widget.TextView r3 = r14.C
            com.travel.bus.pojo.bussearch.CJRDeal r0 = r0.getDeal()
            java.lang.String r0 = r0.getDisplayText()
            r3.setText(r0)
            android.view.View r0 = r14.A
            r0.setVisibility(r6)
            goto L_0x00e1
        L_0x00d8:
            java.lang.String r10 = com.paytm.utility.b.a((double) r7, (java.lang.String) r3)
            android.widget.TextView r0 = r14.x
            r0.setVisibility(r2)
        L_0x00e1:
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r15.getFlags()
            if (r0 == 0) goto L_0x00fb
            com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags r0 = r15.getFlags()
            boolean r0 = r0.getSocialDistancingGuaranteed()
            if (r0 == 0) goto L_0x00fb
            android.widget.ImageView r0 = r14.B
            r0.setVisibility(r6)
            android.view.View r0 = r14.A
            r0.setVisibility(r2)
        L_0x00fb:
            java.lang.Integer r0 = r15.getAvalableSeats()
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x0111
            android.widget.TextView r0 = r14.f22167c
            r0.setText(r9)
            android.widget.TextView r0 = r14.f22166b
            r0.setText(r10)
            goto L_0x0195
        L_0x0111:
            android.widget.TextView r0 = r14.f22166b
            r0.setText(r1)
            android.widget.TextView r0 = r14.f22167c
            r0.setText(r1)
            goto L_0x0195
        L_0x011d:
            android.widget.TextView r0 = r14.x
            r0.setVisibility(r2)
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r0 = r15.getFare()
            if (r0 == 0) goto L_0x018b
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r0 = r15.getFare()
            double[] r0 = r0.getPrices()
            int r0 = r0.length
            if (r0 <= 0) goto L_0x018b
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFare r0 = r15.getFare()
            double[] r0 = r0.getPrices()
            int r7 = r0.length
            if (r7 != r5) goto L_0x015b
            r7 = r0[r6]
            java.lang.String r0 = com.paytm.utility.b.a((double) r7, (java.lang.String) r3)
            java.lang.Integer r3 = r15.getAvalableSeats()
            int r3 = r3.intValue()
            if (r3 <= 0) goto L_0x0195
            android.widget.TextView r3 = r14.f22166b
            r3.setText(r0)
            android.widget.TextView r0 = r14.f22167c
            int r3 = com.travel.bus.R.string.rs
            r0.setText(r3)
            goto L_0x0195
        L_0x015b:
            int r7 = r0.length
            if (r7 <= r5) goto L_0x0195
            r7 = r0[r6]
            r8 = r7
            r7 = 0
        L_0x0162:
            int r10 = r0.length
            if (r7 >= r10) goto L_0x0170
            r10 = r0[r7]
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x016d
            r8 = r0[r7]
        L_0x016d:
            int r7 = r7 + 1
            goto L_0x0162
        L_0x0170:
            java.lang.String r0 = com.paytm.utility.b.a((double) r8, (java.lang.String) r3)
            java.lang.Integer r3 = r15.getAvalableSeats()
            int r3 = r3.intValue()
            if (r3 <= 0) goto L_0x0195
            android.widget.TextView r3 = r14.f22166b
            r3.setText(r0)
            android.widget.TextView r0 = r14.f22167c
            int r3 = com.travel.bus.R.string.rs
            r0.setText(r3)
            goto L_0x0195
        L_0x018b:
            android.widget.TextView r0 = r14.f22166b
            r0.setText(r1)
            android.widget.TextView r0 = r14.f22167c
            r0.setText(r1)
        L_0x0195:
            if (r15 == 0) goto L_0x01d2
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            if (r0 == 0) goto L_0x01d2
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getSoldOut()
            if (r0 == 0) goto L_0x01d2
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getSoldOut()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01d2
            android.widget.TextView r0 = r14.w
            r0.setVisibility(r6)
            android.view.View r0 = r14.A
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r14.B
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.w
            android.content.Context r3 = r14.f22165a
            int r7 = com.travel.bus.R.string.bus_ticket_sold_out
            java.lang.String r3 = r3.getString(r7)
            r0.setText(r3)
            goto L_0x01d7
        L_0x01d2:
            android.widget.TextView r0 = r14.w
            r0.setVisibility(r2)
        L_0x01d7:
            r0 = 3
            r3 = 2
            com.travel.bus.pojo.busticket.BusRatingModel r7 = r15.getBusRating()     // Catch:{ Exception -> 0x029c }
            if (r7 == 0) goto L_0x028c
            com.travel.bus.pojo.busticket.BusRatingModel r7 = r15.getBusRating()     // Catch:{ Exception -> 0x029c }
            int r7 = r7.getCount()     // Catch:{ Exception -> 0x029c }
            com.travel.bus.pojo.busticket.BusRatingModel r8 = r15.getBusRating()     // Catch:{ Exception -> 0x029c }
            double r8 = r8.getAvgRating()     // Catch:{ Exception -> 0x029c }
            com.travel.bus.pojo.busticket.BusRatingModel r10 = r15.getBusRating()     // Catch:{ Exception -> 0x029c }
            java.lang.String r10 = r10.getColor_code()     // Catch:{ Exception -> 0x029c }
            r11 = 0
            int r13 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x0275
            if (r7 <= 0) goto L_0x0275
            android.widget.TextView r11 = r14.n     // Catch:{ Exception -> 0x029c }
            r11.setVisibility(r6)     // Catch:{ Exception -> 0x029c }
            android.widget.TextView r11 = r14.o     // Catch:{ Exception -> 0x029c }
            r11.setVisibility(r6)     // Catch:{ Exception -> 0x029c }
            android.view.View r11 = r14.r     // Catch:{ Exception -> 0x029c }
            r11.setVisibility(r6)     // Catch:{ Exception -> 0x029c }
            android.widget.TextView r11 = r14.n     // Catch:{ Exception -> 0x029c }
            java.lang.String r12 = "%.1f"
            java.lang.Object[] r13 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x029c }
            java.lang.Double r8 = java.lang.Double.valueOf(r8)     // Catch:{ Exception -> 0x029c }
            r13[r6] = r8     // Catch:{ Exception -> 0x029c }
            java.lang.String r8 = java.lang.String.format(r12, r13)     // Catch:{ Exception -> 0x029c }
            r11.setText(r8)     // Catch:{ Exception -> 0x029c }
            android.content.Context r8 = r14.f22165a     // Catch:{ Exception -> 0x029c }
            int r9 = com.travel.bus.R.drawable.travel_res_bus_rating_background     // Catch:{ Exception -> 0x029c }
            android.graphics.drawable.Drawable r8 = androidx.core.content.b.a((android.content.Context) r8, (int) r9)     // Catch:{ Exception -> 0x029c }
            android.graphics.drawable.Drawable r8 = androidx.core.graphics.drawable.a.f(r8)     // Catch:{ Exception -> 0x029c }
            android.widget.TextView r9 = r14.n     // Catch:{ Exception -> 0x029c }
            r9.setBackground(r8)     // Catch:{ Exception -> 0x029c }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x029c }
            r11 = 21
            if (r9 < r11) goto L_0x0240
            int r9 = android.graphics.Color.parseColor(r10)     // Catch:{ Exception -> 0x029c }
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r8, (int) r9)     // Catch:{ Exception -> 0x029c }
            goto L_0x024d
        L_0x0240:
            android.graphics.drawable.Drawable r8 = r8.mutate()     // Catch:{ Exception -> 0x029c }
            int r9 = android.graphics.Color.parseColor(r10)     // Catch:{ Exception -> 0x029c }
            android.graphics.PorterDuff$Mode r10 = android.graphics.PorterDuff.Mode.SRC_IN     // Catch:{ Exception -> 0x029c }
            r8.setColorFilter(r9, r10)     // Catch:{ Exception -> 0x029c }
        L_0x024d:
            if (r7 <= 0) goto L_0x02a4
            if (r7 <= r5) goto L_0x025a
            android.content.Context r8 = r14.f22165a     // Catch:{ Exception -> 0x029c }
            int r9 = com.travel.bus.R.string.other     // Catch:{ Exception -> 0x029c }
        L_0x0255:
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x029c }
            goto L_0x025f
        L_0x025a:
            android.content.Context r8 = r14.f22165a     // Catch:{ Exception -> 0x029c }
            int r9 = com.travel.bus.R.string.one     // Catch:{ Exception -> 0x029c }
            goto L_0x0255
        L_0x025f:
            android.widget.TextView r9 = r14.o     // Catch:{ Exception -> 0x029c }
            java.lang.String[] r10 = new java.lang.String[r0]     // Catch:{ Exception -> 0x029c }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x029c }
            r10[r6] = r7     // Catch:{ Exception -> 0x029c }
            r10[r5] = r4     // Catch:{ Exception -> 0x029c }
            r10[r3] = r8     // Catch:{ Exception -> 0x029c }
            java.lang.String r7 = com.paytm.utility.v.a((java.lang.String[]) r10)     // Catch:{ Exception -> 0x029c }
            r9.setText(r7)     // Catch:{ Exception -> 0x029c }
            goto L_0x02a4
        L_0x0275:
            android.widget.TextView r7 = r14.n     // Catch:{ Exception -> 0x029c }
            r7.setVisibility(r2)     // Catch:{ Exception -> 0x029c }
            android.widget.TextView r7 = r14.o     // Catch:{ Exception -> 0x029c }
            int r8 = com.travel.bus.R.string.bus_no_rating     // Catch:{ Exception -> 0x029c }
            r7.setText(r8)     // Catch:{ Exception -> 0x029c }
            android.widget.TextView r7 = r14.o     // Catch:{ Exception -> 0x029c }
            r7.setVisibility(r2)     // Catch:{ Exception -> 0x029c }
            android.view.View r7 = r14.r     // Catch:{ Exception -> 0x029c }
            r7.setVisibility(r2)     // Catch:{ Exception -> 0x029c }
            goto L_0x02a4
        L_0x028c:
            android.widget.TextView r7 = r14.n     // Catch:{ Exception -> 0x029c }
            r7.setVisibility(r2)     // Catch:{ Exception -> 0x029c }
            android.widget.TextView r7 = r14.o     // Catch:{ Exception -> 0x029c }
            r7.setVisibility(r2)     // Catch:{ Exception -> 0x029c }
            android.view.View r7 = r14.r     // Catch:{ Exception -> 0x029c }
            r7.setVisibility(r2)     // Catch:{ Exception -> 0x029c }
            goto L_0x02a4
        L_0x029c:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.q.c(r7)
        L_0x02a4:
            java.lang.String r7 = r15.getTravelsName()
            if (r7 == 0) goto L_0x02b4
            android.widget.TextView r7 = r14.f22168d
            java.lang.String r8 = r15.getTravelsName()
            r7.setText(r8)
            goto L_0x02b9
        L_0x02b4:
            android.widget.TextView r7 = r14.f22168d
            r7.setText(r1)
        L_0x02b9:
            java.util.ArrayList r7 = r15.getBusTypeTags()
            java.lang.String r8 = r15.getBusTypeName()
            java.lang.String r7 = com.travel.bus.busticket.i.o.a((java.util.List<java.lang.String>) r7, (java.lang.String) r8)
            android.widget.TextView r8 = r14.f22171g
            r8.setVisibility(r6)
            android.widget.LinearLayout r8 = r14.f22169e
            r8.setVisibility(r2)
            android.widget.TextView r8 = r14.f22171g
            r8.setText(r7)
            r7 = 4
            java.lang.String r8 = r15.getDuration()     // Catch:{ Exception -> 0x0351 }
            if (r8 == 0) goto L_0x034b
            java.lang.String r8 = r15.getDuration()     // Catch:{ Exception -> 0x0351 }
            int r8 = r8.length()     // Catch:{ Exception -> 0x0351 }
            if (r8 != r7) goto L_0x034b
            java.lang.String r8 = r15.getDuration()     // Catch:{ Exception -> 0x0351 }
            java.lang.String r9 = r8.substring(r6, r3)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r8 = r8.substring(r3, r7)     // Catch:{ Exception -> 0x0351 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x0351 }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x0351 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0351 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x0351 }
            if (r9 <= 0) goto L_0x0319
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0351 }
            r10.<init>()     // Catch:{ Exception -> 0x0351 }
            java.lang.String r11 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0351 }
            r10.append(r11)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r11 = "h"
            r10.append(r11)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0351 }
            goto L_0x031a
        L_0x0319:
            r10 = r1
        L_0x031a:
            if (r8 <= 0) goto L_0x0332
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0351 }
            r11.<init>()     // Catch:{ Exception -> 0x0351 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0351 }
            r11.append(r8)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r8 = "m"
            r11.append(r8)     // Catch:{ Exception -> 0x0351 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x0351 }
            goto L_0x0333
        L_0x0332:
            r8 = r1
        L_0x0333:
            if (r9 <= 0) goto L_0x0341
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0351 }
            r0[r6] = r10     // Catch:{ Exception -> 0x0351 }
            r0[r5] = r4     // Catch:{ Exception -> 0x0351 }
            r0[r3] = r8     // Catch:{ Exception -> 0x0351 }
            java.lang.String r8 = com.paytm.utility.v.a((java.lang.String[]) r0)     // Catch:{ Exception -> 0x0351 }
        L_0x0341:
            android.widget.TextView r0 = r14.f22172h     // Catch:{ Exception -> 0x0351 }
            java.lang.String r3 = r8.trim()     // Catch:{ Exception -> 0x0351 }
            r0.setText(r3)     // Catch:{ Exception -> 0x0351 }
            goto L_0x035e
        L_0x034b:
            android.widget.TextView r0 = r14.f22172h     // Catch:{ Exception -> 0x0351 }
            r0.setText(r1)     // Catch:{ Exception -> 0x0351 }
            goto L_0x035e
        L_0x0351:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
            android.widget.TextView r0 = r14.f22172h
            r0.setText(r1)
        L_0x035e:
            java.lang.Integer r0 = r15.getAvalableSeats()
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x049f
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getDeparted()
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x049f
            java.lang.Integer r0 = r15.getAvalableSeats()
            int r0 = r0.intValue()
            r3 = 6
            if (r0 >= r3) goto L_0x0384
            int r0 = com.travel.bus.R.color.color_b80d22
            goto L_0x0386
        L_0x0384:
            int r0 = com.travel.bus.R.color.bus_type_text
        L_0x0386:
            java.lang.Integer r3 = r15.getAvalableSeats()
            int r3 = r3.intValue()
            r8 = 5
            if (r3 > r8) goto L_0x03a4
            java.lang.Integer r3 = r15.getAvalableSeats()
            int r3 = r3.intValue()
            if (r3 <= r5) goto L_0x03a4
            android.content.Context r3 = r14.f22165a
            int r5 = com.travel.bus.R.string.bus_seats_left_for_booking
            java.lang.String r3 = r3.getString(r5)
            goto L_0x03bf
        L_0x03a4:
            java.lang.Integer r3 = r15.getAvalableSeats()
            int r3 = r3.intValue()
            if (r3 != r5) goto L_0x03b7
            android.content.Context r3 = r14.f22165a
            int r5 = com.travel.bus.R.string.bus_seats_one_left_for_booking
            java.lang.String r3 = r3.getString(r5)
            goto L_0x03bf
        L_0x03b7:
            android.content.Context r3 = r14.f22165a
            int r5 = com.travel.bus.R.string.bus_seats_avaliable_for_booking
            java.lang.String r3 = r3.getString(r5)
        L_0x03bf:
            android.widget.TextView r5 = r14.l
            r5.setVisibility(r7)
            android.widget.TextView r5 = r14.m
            r5.setVisibility(r2)
            android.widget.TextView r5 = r14.f22166b
            r5.setVisibility(r6)
            android.widget.TextView r5 = r14.f22167c
            r5.setVisibility(r6)
            android.widget.TextView r5 = r14.u
            r5.setVisibility(r6)
            android.widget.TextView r5 = r14.v
            r5.setVisibility(r6)
            android.widget.TextView r5 = r14.w
            r5.setVisibility(r2)
            java.lang.String r5 = "left"
            boolean r5 = r3.contains(r5)
            if (r5 != 0) goto L_0x0417
            java.lang.String r5 = "Left"
            boolean r5 = r3.contains(r5)
            if (r5 != 0) goto L_0x0417
            java.lang.String r5 = "LEFT"
            boolean r5 = r3.contains(r5)
            if (r5 == 0) goto L_0x03fb
            goto L_0x0417
        L_0x03fb:
            android.widget.TextView r5 = r14.f22173i
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.Integer r8 = r15.getAvalableSeats()
            r7.append(r8)
            r7.append(r4)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r5.setText(r3)
            goto L_0x0440
        L_0x0417:
            android.widget.TextView r5 = r14.f22173i
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            android.content.Context r8 = r14.f22165a
            int r9 = com.travel.bus.R.string.only
            java.lang.String r8 = r8.getString(r9)
            r7.append(r8)
            r7.append(r4)
            java.lang.Integer r8 = r15.getAvalableSeats()
            r7.append(r8)
            r7.append(r4)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r5.setText(r3)
        L_0x0440:
            android.widget.TextView r3 = r14.f22173i
            android.content.Context r4 = r14.f22165a
            int r0 = androidx.core.content.b.c(r4, r0)
            r3.setTextColor(r0)
            android.widget.TextView r0 = r14.f22171g
            android.content.Context r3 = r14.f22165a
            int r4 = com.travel.bus.R.color.bus_type_text
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            android.widget.TextView r0 = r14.f22172h
            android.content.Context r3 = r14.f22165a
            int r4 = com.travel.bus.R.color.color_999999
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            android.widget.TextView r0 = r14.f22166b
            android.content.Context r3 = r14.f22165a
            int r4 = com.travel.bus.R.color.black
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            android.widget.TextView r0 = r14.f22168d
            android.content.Context r3 = r14.f22165a
            int r4 = com.travel.bus.R.color.black
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            android.widget.TextView r0 = r14.u
            android.content.Context r3 = r14.f22165a
            int r4 = com.travel.bus.R.color.black
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setTextColor(r3)
            android.view.View r0 = r14.s
            r0.setVisibility(r2)
            android.view.View r0 = r14.t
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.n
            r3 = 1065353216(0x3f800000, float:1.0)
            r0.setAlpha(r3)
            goto L_0x05d8
        L_0x049f:
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getDeparted()
            boolean r0 = r0.booleanValue()
            r3 = 1050253722(0x3e99999a, float:0.3)
            if (r0 == 0) goto L_0x04ff
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getDeparted()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x05d8
            android.widget.TextView r0 = r14.m
            r0.setVisibility(r6)
            android.widget.TextView r0 = r14.l
            r0.setVisibility(r7)
            android.view.View r0 = r14.s
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.u
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.f22166b
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.f22167c
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.v
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.f22173i
            r0.setText(r1)
            android.widget.TextView r0 = r14.f22173i
            android.content.Context r4 = r14.f22165a
            int r5 = com.travel.bus.R.color.gray
            int r4 = androidx.core.content.b.c(r4, r5)
            r0.setTextColor(r4)
            android.widget.TextView r0 = r14.n
            r0.setAlpha(r3)
            android.view.View r0 = r14.t
            r0.setVisibility(r6)
            goto L_0x05d8
        L_0x04ff:
            java.lang.Integer r0 = r15.getAvalableSeats()
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x057f
            android.widget.TextView r0 = r14.f22173i
            java.lang.String r4 = "   "
            r0.setText(r4)
            android.widget.TextView r0 = r14.m
            r0.setVisibility(r2)
            android.view.View r0 = r14.t
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.l
            r0.setVisibility(r6)
            android.widget.TextView r0 = r14.u
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.f22166b
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.f22167c
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.v
            r0.setVisibility(r7)
            if (r15 == 0) goto L_0x055f
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getSoldOut()
            if (r0 == 0) goto L_0x055f
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getSoldOut()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x055f
            android.widget.TextView r0 = r14.w
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.w
            android.content.Context r4 = r14.f22165a
            int r5 = com.travel.bus.R.string.bus_ticket_sold_out
            java.lang.String r4 = r4.getString(r5)
            r0.setText(r4)
        L_0x055f:
            android.widget.TextView r0 = r14.f22173i
            android.content.Context r4 = r14.f22165a
            int r5 = com.travel.bus.R.color.cart_oos_text
            int r4 = androidx.core.content.b.c(r4, r5)
            r0.setTextColor(r4)
            android.view.View r0 = r14.s
            r0.setVisibility(r6)
            android.widget.TextView r0 = r14.f22173i
            android.content.Context r4 = r14.f22165a
            int r5 = com.travel.bus.R.color.gray
            int r4 = androidx.core.content.b.c(r4, r5)
            r0.setTextColor(r4)
            goto L_0x05d3
        L_0x057f:
            android.widget.TextView r0 = r14.f22173i
            r0.setText(r1)
            android.widget.TextView r0 = r14.l
            r0.setVisibility(r6)
            android.widget.TextView r0 = r14.m
            r0.setVisibility(r2)
            android.view.View r0 = r14.t
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.u
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.f22166b
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.f22167c
            r0.setVisibility(r7)
            android.widget.TextView r0 = r14.v
            r0.setVisibility(r7)
            if (r15 == 0) goto L_0x05d3
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getSoldOut()
            if (r0 == 0) goto L_0x05d3
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag r0 = r15.getFlag()
            java.lang.Boolean r0 = r0.getSoldOut()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x05d3
            android.widget.TextView r0 = r14.w
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.w
            android.content.Context r4 = r14.f22165a
            int r5 = com.travel.bus.R.string.bus_ticket_sold_out
            java.lang.String r4 = r4.getString(r5)
            r0.setText(r4)
        L_0x05d3:
            android.widget.TextView r0 = r14.n
            r0.setAlpha(r3)
        L_0x05d8:
            java.lang.String r0 = r15.getArrivalDatetime()
            if (r0 == 0) goto L_0x05f4
            java.lang.String r0 = r15.getArrivalDatetime()
            java.lang.String r3 = "NA"
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L_0x05f4
            java.lang.String r0 = r15.getArrivalDatetime()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x05fe
        L_0x05f4:
            android.widget.TextView r0 = r14.f22172h
            r0.setVisibility(r2)
            android.widget.TextView r0 = r14.v
            r0.setVisibility(r2)
        L_0x05fe:
            java.util.ArrayList r0 = r15.getAmenities()
            if (r0 == 0) goto L_0x0636
            androidx.recyclerview.widget.RecyclerView r0 = r14.j
            r0.setVisibility(r6)
            r14.b()
            java.util.ArrayList r10 = r15.getAmenities()
            java.util.HashMap<java.lang.String, com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> r0 = r14.I
            java.util.ArrayList r9 = com.travel.bus.b.b.a(r10, r0)
            com.travel.bus.busticket.a.t r0 = new com.travel.bus.busticket.a.t
            android.content.Context r8 = r14.f22165a
            java.util.HashMap<java.lang.String, com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> r11 = r14.I
            com.travel.bus.busticket.b.d r12 = r14.J
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            r14.F = r0
            androidx.recyclerview.widget.RecyclerView r0 = r14.j
            com.travel.bus.busticket.a.t r1 = r14.F
            r0.setAdapter(r1)
            com.travel.bus.busticket.a.t r0 = r14.F
            r0.notifyDataSetChanged()
            androidx.recyclerview.widget.RecyclerView r0 = r14.j
            r0.setNestedScrollingEnabled(r6)
            goto L_0x0639
        L_0x0636:
            r14.b()
        L_0x0639:
            java.util.ArrayList r0 = r15.getOperatorTags()
            if (r0 != 0) goto L_0x064c
            java.util.ArrayList r0 = r15.getEcosystemOffers()
            if (r0 == 0) goto L_0x0646
            goto L_0x064c
        L_0x0646:
            androidx.recyclerview.widget.RecyclerView r15 = r14.k
            r15.setVisibility(r2)
            goto L_0x0677
        L_0x064c:
            androidx.recyclerview.widget.RecyclerView r0 = r14.k
            r0.setVisibility(r6)
            com.travel.bus.busticket.a.c r0 = new com.travel.bus.busticket.a.c
            android.content.Context r1 = r14.f22165a
            java.util.ArrayList r2 = r15.getOperatorTags()
            java.util.ArrayList r15 = r15.getEcosystemOffers()
            java.util.ArrayList r15 = r14.a((java.util.ArrayList<java.lang.Integer>) r2, (java.util.ArrayList<java.lang.String>) r15)
            r0.<init>(r1, r15)
            r14.G = r0
            androidx.recyclerview.widget.RecyclerView r15 = r14.k
            com.travel.bus.busticket.a.c r0 = r14.G
            r15.setAdapter(r0)
            com.travel.bus.busticket.a.c r15 = r14.G
            r15.notifyDataSetChanged()
            androidx.recyclerview.widget.RecyclerView r15 = r14.k
            r15.setNestedScrollingEnabled(r6)
        L_0x0677:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.e.k.a(com.travel.bus.pojo.busticket.CJRBusSearchItem):void");
    }

    private void b() {
        ((ViewGroup.MarginLayoutParams) this.f22170f.getLayoutParams()).setMargins(0, b.c(13), 0, 0);
        this.f22170f.requestLayout();
    }

    private ArrayList<a> a(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        ArrayList<a> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        boolean z2 = false;
        if (!(this.D == null || arrayList == null || arrayList.size() <= 0)) {
            Iterator<Integer> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = this.D.get(String.valueOf(it2.next().intValue()));
                if (cJRBusSearchOperatorTagInfo != null) {
                    if (cJRBusSearchOperatorTagInfo.getTagType().toLowerCase().equals("offer")) {
                        z2 = true;
                        arrayList4.add(new a(cJRBusSearchOperatorTagInfo.getLabel(), cJRBusSearchOperatorTagInfo.getIcon()));
                    } else {
                        arrayList5.add(new a(cJRBusSearchOperatorTagInfo.getLabel(), cJRBusSearchOperatorTagInfo.getIcon()));
                    }
                }
            }
        }
        ArrayList arrayList6 = new ArrayList();
        if (!z2 && this.E != null && arrayList2 != null && arrayList2.size() > 0) {
            Iterator<String> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                ArrayList arrayList7 = this.E.get(String.valueOf(it3.next()));
                if (arrayList7 != null) {
                    Iterator it4 = arrayList7.iterator();
                    while (it4.hasNext()) {
                        BusEcosystemOfferInfo busEcosystemOfferInfo = (BusEcosystemOfferInfo) it4.next();
                        if (busEcosystemOfferInfo != null) {
                            if (busEcosystemOfferInfo.getCampaignType() == null || !busEcosystemOfferInfo.getCampaignType().toLowerCase().equals("paytm_offer")) {
                                if (busEcosystemOfferInfo.getBusEcosystemOffer() != null && !TextUtils.isEmpty(busEcosystemOfferInfo.getBusEcosystemOffer().getTitle())) {
                                    arrayList6.add(new a(busEcosystemOfferInfo.getBusEcosystemOffer().getTitle(), busEcosystemOfferInfo.getBusEcosystemOffer().getIcon()));
                                }
                            } else if (busEcosystemOfferInfo.getBusEcosystemOffer() != null && !TextUtils.isEmpty(busEcosystemOfferInfo.getBusEcosystemOffer().getTitle())) {
                                arrayList3.add(new a(busEcosystemOfferInfo.getBusEcosystemOffer().getTitle(), busEcosystemOfferInfo.getBusEcosystemOffer().getIcon()));
                            }
                        }
                    }
                }
            }
            arrayList3.addAll(arrayList6);
        }
        arrayList3.addAll(arrayList4);
        arrayList3.addAll(arrayList5);
        return arrayList3;
    }

    public final void a() {
        int dimension = (int) this.f22165a.getResources().getDimension(R.dimen.dimen_5dp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dimension, 0, dimension, (int) this.f22165a.getResources().getDimension(R.dimen.dimen_1dp));
        this.y.setLayoutParams(layoutParams);
        this.y.setBackgroundResource(R.drawable.travel_res_bus_shadow_left_right_normal);
    }

    public final void a(ArrayList<CJRBusSearchItem> arrayList, int i2) {
        this.H = arrayList;
        this.z.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                k.this.e(this.f$1, view);
            }
        });
        this.o.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                k.this.d(this.f$1, view);
            }
        });
        this.p.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                k.this.c(this.f$1, view);
            }
        });
        this.q.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                k.this.b(this.f$1, view);
            }
        });
        this.f22169e.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                k.this.a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(int i2, View view) {
        CJRBusSearchItem cJRBusSearchItem = (CJRBusSearchItem) a(i2);
        if (cJRBusSearchItem != null && cJRBusSearchItem.getAvalableSeats().intValue() > 0 && !cJRBusSearchItem.getFlag().getDeparted().booleanValue()) {
            this.K.onChildClicked(cJRBusSearchItem, i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(int i2, View view) {
        CJRBusSearchItem cJRBusSearchItem = (CJRBusSearchItem) a(i2);
        if (cJRBusSearchItem != null && cJRBusSearchItem.getAvalableSeats().intValue() > 0 && !cJRBusSearchItem.getFlag().getDeparted().booleanValue()) {
            this.K.onRatingsClick(cJRBusSearchItem, 0, i2);
            double avgRating = cJRBusSearchItem.getBusRating().getAvgRating();
            int count = cJRBusSearchItem.getBusRating().getCount();
            HashMap hashMap = new HashMap();
            hashMap.put("event_label", this.f22165a.getResources().getString(R.string.avg_rating) + avgRating + "; " + this.f22165a.getResources().getString(R.string.ratings_count) + String.format("%.1f", new Object[]{Double.valueOf(avgRating)}) + "; " + this.f22165a.getResources().getString(R.string.reviews_count) + count);
            StringBuilder sb = new StringBuilder();
            sb.append(cJRBusSearchItem.getSourceCity());
            sb.append("/");
            sb.append(cJRBusSearchItem.getDestinationCity());
            hashMap.put("event_label2", sb.toString());
            hashMap.put("event_label3", cJRBusSearchItem.getOperatorObj().getName().replace(AppConstants.AND_SIGN, "&amp;"));
            hashMap.put("userid", b.n(this.f22165a));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "reviews_clicked", hashMap);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, View view) {
        CJRBusSearchItem cJRBusSearchItem = (CJRBusSearchItem) a(i2);
        if (cJRBusSearchItem != null && cJRBusSearchItem.getAvalableSeats().intValue() > 0 && !cJRBusSearchItem.getFlag().getDeparted().booleanValue()) {
            this.K.onRatingsClick(cJRBusSearchItem, 2, i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        CJRBusSearchItem cJRBusSearchItem = (CJRBusSearchItem) a(i2);
        if (cJRBusSearchItem != null && cJRBusSearchItem.getAvalableSeats().intValue() > 0 && !cJRBusSearchItem.getFlag().getDeparted().booleanValue()) {
            this.K.onHorizontalScrollClicked(cJRBusSearchItem, i2);
        }
    }

    private Object a(int i2) {
        return this.H.get(i2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(int i2, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_boarding");
        hashMap.put("event_action", "screen_load");
        hashMap.put("event_label", "SRP");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-boarding");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n(this.f22165a));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, this.f22165a);
        CJRBusSearchItem cJRBusSearchItem = (CJRBusSearchItem) a(i2);
        if (cJRBusSearchItem != null && cJRBusSearchItem.getAvalableSeats().intValue() > 0 && !cJRBusSearchItem.getFlag().getDeparted().booleanValue()) {
            this.K.onRatingsClick(cJRBusSearchItem, 1, i2);
        }
    }
}
