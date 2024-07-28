package com.travel.bus.busticket.a;

import android.content.Context;
import android.location.Location;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.activity.AJRInfoBoardingDropActivity;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class f extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRLocation> f21629a;

    /* renamed from: b  reason: collision with root package name */
    Context f21630b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21631c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21632d = false;

    /* renamed from: e  reason: collision with root package name */
    public double f21633e;

    /* renamed from: f  reason: collision with root package name */
    public double f21634f;

    /* renamed from: g  reason: collision with root package name */
    private final String f21635g;

    /* renamed from: h  reason: collision with root package name */
    private a f21636h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f21637i = null;
    private int j = -1;
    private int k = -1;

    public interface a {
        void a(int i2);

        void a(CJRLocation cJRLocation, boolean z, int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r11, int r12) {
        /*
            r10 = this;
            com.travel.bus.busticket.a.f$b r11 = (com.travel.bus.busticket.a.f.b) r11
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRLocation> r0 = r10.f21629a
            java.lang.Object r0 = r0.get(r12)
            com.travel.bus.pojo.busticket.CJRLocation r0 = (com.travel.bus.pojo.busticket.CJRLocation) r0
            android.widget.TextView r1 = r11.f21645e
            java.lang.String r2 = r0.getLocationName()
            java.lang.String r2 = com.paytm.utility.v.b(r2)
            r1.setText(r2)
            boolean r1 = r0.getIsPopular()
            r2 = 8
            r3 = 0
            if (r1 == 0) goto L_0x002c
            int r1 = r0.getPriority()
            if (r1 <= 0) goto L_0x002c
            android.widget.TextView r1 = r11.k
            r1.setVisibility(r3)
            goto L_0x0031
        L_0x002c:
            android.widget.TextView r1 = r11.k
            r1.setVisibility(r2)
        L_0x0031:
            java.lang.String r1 = r0.getmStatus()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r4 = 1
            if (r1 != 0) goto L_0x00f6
            java.lang.String r1 = r0.getmStatus()
            java.lang.String r5 = "DEPARTED"
            boolean r1 = r5.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x009d
            java.lang.String r1 = r0.getmStatus()
            java.lang.String r5 = "NOT_ALLOWED"
            boolean r1 = r5.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0055
            goto L_0x009d
        L_0x0055:
            android.content.Context r1 = r10.f21630b
            android.content.res.Resources r1 = r1.getResources()
            int r5 = com.travel.bus.R.color.bus_time_color
            int r1 = r1.getColor(r5)
            android.widget.TextView r5 = r11.f21648h
            r5.setVisibility(r2)
            android.widget.TextView r5 = r11.f21645e
            r5.setTextColor(r1)
            android.widget.TextView r5 = r11.f21644d
            r5.setTextColor(r1)
            android.widget.TextView r5 = r11.f21646f
            android.content.Context r6 = r10.f21630b
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.bus.R.color.color_666666
            int r6 = r6.getColor(r7)
            r5.setTextColor(r6)
            android.widget.TextView r5 = r11.f21649i
            android.content.Context r6 = r10.f21630b
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.bus.R.color.color_999999
            int r6 = r6.getColor(r7)
            r5.setTextColor(r6)
            android.widget.TextView r5 = r11.f21647g
            r5.setTextColor(r1)
            android.widget.ImageView r1 = r11.f21642b
            r1.setVisibility(r3)
            goto L_0x00f6
        L_0x009d:
            android.content.Context r1 = r10.f21630b
            android.content.res.Resources r1 = r1.getResources()
            int r5 = com.travel.bus.R.color.color_FFCCCACA
            int r1 = r1.getColor(r5)
            android.widget.TextView r5 = r11.f21648h
            r5.setVisibility(r3)
            android.widget.TextView r5 = r11.f21645e
            r5.setTextColor(r1)
            android.widget.TextView r5 = r11.f21644d
            r5.setTextColor(r1)
            android.widget.TextView r5 = r11.f21646f
            android.content.Context r6 = r10.f21630b
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.bus.R.color.color_666666
            int r6 = r6.getColor(r7)
            r5.setTextColor(r6)
            android.widget.TextView r5 = r11.f21647g
            r5.setTextColor(r1)
            android.widget.TextView r1 = r11.f21649i
            android.content.Context r5 = r10.f21630b
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.travel.bus.R.color.color_25000000
            int r5 = r5.getColor(r6)
            r1.setTextColor(r5)
            android.widget.LinearLayout r1 = r11.f21641a
            r5 = 0
            r1.setOnClickListener(r5)
            android.widget.TextView r1 = r11.f21644d
            r1.setOnClickListener(r5)
            android.widget.TextView r1 = r11.f21645e
            r1.setOnClickListener(r5)
            android.widget.ImageView r1 = r11.f21642b
            r1.setVisibility(r2)
            r1 = 1
            goto L_0x00f7
        L_0x00f6:
            r1 = 0
        L_0x00f7:
            java.lang.String r5 = r0.getTime()
            java.lang.String r6 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r7 = "EEE, d MMMM"
            java.lang.String r5 = com.paytm.utility.b.b((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7)
            android.widget.TextView r7 = r11.f21649i
            r7.setText(r5)
            java.lang.String r5 = r0.getTime()
            if (r5 == 0) goto L_0x0132
            java.lang.String r7 = ""
            boolean r7 = r5.equals(r7)
            if (r7 != 0) goto L_0x0132
            android.content.Context r7 = r10.f21630b
            android.app.Activity r7 = (android.app.Activity) r7
            com.travel.bus.a.a()
            com.travel.g.a r8 = com.travel.bus.a.b()
            java.lang.String r8 = r8.b()
            java.lang.String r9 = "h:mm a"
            java.lang.String r5 = com.paytm.utility.b.a((android.app.Activity) r7, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r9, (java.lang.String) r8)
            android.widget.TextView r6 = r11.f21644d
            r6.setText(r5)
            goto L_0x0137
        L_0x0132:
            android.widget.TextView r5 = r11.f21644d
            r5.setVisibility(r2)
        L_0x0137:
            boolean r5 = r10.f21632d
            if (r5 == 0) goto L_0x013f
            r10.a(r0, r11)
            goto L_0x016e
        L_0x013f:
            double r5 = r10.f21633e
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x014d
            double r5 = r10.f21634f
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x016e
        L_0x014d:
            double r5 = r0.getSelectedLatitude()
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x016e
            double r5 = r0.getSelectedLongitude()
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x016e
            double r5 = r0.getSelectedLatitude()
            r10.f21633e = r5
            double r5 = r0.getSelectedLongitude()
            r10.f21634f = r5
            r10.f21632d = r4
            r10.a(r0, r11)
        L_0x016e:
            java.lang.String r5 = r0.getLocationAddress()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x01a3
            java.lang.String r5 = r0.getLocationAddress()
            java.lang.String r6 = " "
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x01a3
            java.lang.String r5 = r0.getLocationAddress()
            java.lang.String r6 = "  "
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x01a3
            android.widget.TextView r5 = r11.f21646f
            java.lang.String r6 = r0.getLocationAddress()
            java.lang.String r6 = com.paytm.utility.v.b(r6)
            r5.setText(r6)
            android.widget.TextView r5 = r11.f21646f
            r5.setVisibility(r3)
            goto L_0x01a8
        L_0x01a3:
            android.widget.TextView r5 = r11.f21646f
            r5.setVisibility(r2)
        L_0x01a8:
            android.widget.ImageView r5 = r11.f21643c
            com.travel.bus.busticket.a.f$1 r6 = new com.travel.bus.busticket.a.f$1
            r6.<init>(r11, r0)
            r5.setOnClickListener(r6)
            int r5 = r10.j
            if (r5 != r12) goto L_0x01c0
            android.widget.ImageView r5 = r11.f21642b
            com.travel.utils.n$a r6 = com.travel.utils.n.a.V1
            java.lang.String r7 = "radio_select.png"
            com.travel.cdn.ResourceUtils.loadBusImagesFromCDN(r5, r7, r3, r4, r6)
            goto L_0x01c9
        L_0x01c0:
            android.widget.ImageView r5 = r11.f21642b
            com.travel.utils.n$a r6 = com.travel.utils.n.a.V1
            java.lang.String r7 = "radio_unselect.png"
            com.travel.cdn.ResourceUtils.loadBusImagesFromCDN(r5, r7, r3, r4, r6)
        L_0x01c9:
            android.widget.ImageView r5 = r11.f21642b
            int r6 = com.travel.bus.R.id.imgView_selection
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            r5.setTag(r6, r7)
            android.widget.LinearLayout r5 = r11.f21641a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r5.setTag(r6)
            android.widget.TextView r5 = r11.f21644d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r5.setTag(r6)
            android.widget.TextView r5 = r11.f21645e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            r5.setTag(r6)
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRLocation> r5 = r10.f21629a
            int r5 = r5.size()
            int r5 = r5 - r4
            if (r12 != r5) goto L_0x01fe
            android.view.View r3 = r11.j
            r3.setVisibility(r2)
            goto L_0x0203
        L_0x01fe:
            android.view.View r5 = r11.j
            r5.setVisibility(r3)
        L_0x0203:
            android.content.Context r3 = r10.f21630b
            boolean r3 = r3 instanceof com.travel.bus.busticket.activity.AJRInfoBoardingDropActivity
            if (r3 != 0) goto L_0x0248
            if (r1 != 0) goto L_0x0248
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRLocation> r1 = r10.f21629a
            int r1 = r1.size()
            if (r1 != r4) goto L_0x0218
            android.widget.LinearLayout r1 = r11.f21641a
            r10.d((com.travel.bus.pojo.busticket.CJRLocation) r0, (android.view.View) r1, (int) r12)
        L_0x0218:
            android.widget.ImageView r1 = r11.f21643c
            int r1 = r1.getVisibility()
            if (r1 != r2) goto L_0x022a
            android.widget.LinearLayout r1 = r11.f21641a
            com.travel.bus.busticket.a.-$$Lambda$f$2oeVU9A8A1WpwoHviKTy0ptseQ4 r2 = new com.travel.bus.busticket.a.-$$Lambda$f$2oeVU9A8A1WpwoHviKTy0ptseQ4
            r2.<init>(r0, r12)
            r1.setOnClickListener(r2)
        L_0x022a:
            android.widget.LinearLayout r1 = r11.f21641a
            com.travel.bus.busticket.a.-$$Lambda$f$wO-gnOeHB1LNobI0toPToz-T1nk r2 = new com.travel.bus.busticket.a.-$$Lambda$f$wO-gnOeHB1LNobI0toPToz-T1nk
            r2.<init>(r0, r12)
            r1.setOnClickListener(r2)
            android.widget.TextView r1 = r11.f21644d
            com.travel.bus.busticket.a.-$$Lambda$f$fP09VryRozqZYdNdeAGT-l7xCdo r2 = new com.travel.bus.busticket.a.-$$Lambda$f$fP09VryRozqZYdNdeAGT-l7xCdo
            r2.<init>(r0, r12)
            r1.setOnClickListener(r2)
            android.widget.TextView r11 = r11.f21645e
            com.travel.bus.busticket.a.-$$Lambda$f$EfTAtJze18KG1vg9qUGKk9NduBI r1 = new com.travel.bus.busticket.a.-$$Lambda$f$EfTAtJze18KG1vg9qUGKk9NduBI
            r1.<init>(r0, r12)
            r11.setOnClickListener(r1)
        L_0x0248:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.a.f.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public f(Context context, ArrayList<CJRLocation> arrayList, a aVar, boolean z, String str) {
        this.f21629a = arrayList;
        this.f21630b = context;
        this.f21636h = aVar;
        this.f21631c = z;
        this.f21635g = str;
        a();
    }

    public f(Context context, ArrayList<CJRLocation> arrayList, a aVar, boolean z, String str, double d2, double d3) {
        this.f21629a = arrayList;
        this.f21630b = context;
        this.f21636h = aVar;
        this.f21631c = z;
        this.f21635g = str;
        this.f21632d = true;
        this.f21633e = d2;
        this.f21634f = d3;
    }

    public final int getItemCount() {
        ArrayList<CJRLocation> arrayList = this.f21629a;
        if (arrayList == null || arrayList.size() <= 0) {
            return 0;
        }
        return this.f21629a.size();
    }

    public final void a(int i2) {
        this.j = i2;
        a();
    }

    private void a() {
        if (this.f21629a.size() == 1) {
            this.j = 0;
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f21641a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f21642b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f21643c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f21644d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f21645e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f21646f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f21647g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f21648h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f21649i;
        public View j;
        public TextView k;

        public b(View view) {
            super(view);
            this.f21644d = (TextView) view.findViewById(R.id.text_boarding_dropping_time);
            this.f21645e = (TextView) view.findViewById(R.id.text_boarding_dropping_point);
            this.f21646f = (TextView) view.findViewById(R.id.location_detail);
            this.f21642b = (ImageView) view.findViewById(R.id.imgView_selection);
            this.f21643c = (ImageView) view.findViewById(R.id.img_arrow);
            this.f21641a = (LinearLayout) view.findViewById(R.id.lyt);
            this.f21647g = (TextView) view.findViewById(R.id.distance_text);
            this.f21648h = (TextView) view.findViewById(R.id.bus_departed_text);
            this.f21649i = (TextView) view.findViewById(R.id.boardDropDate);
            this.j = view.findViewById(R.id.viewLineBPItem);
            this.k = (TextView) view.findViewById(R.id.tvPopularTag);
            if (f.this.f21630b instanceof AJRInfoBoardingDropActivity) {
                this.f21642b.setVisibility(8);
                this.f21643c.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void d(CJRLocation cJRLocation, View view, int i2) {
        this.j = ((Integer) view.getTag()).intValue();
        boolean z = this.f21631c;
        String str = "";
        String locationName = cJRLocation != null ? cJRLocation.getLocationName() : str;
        String str2 = z ? "boarding_point_selected" : "dropping_point_selected";
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_search");
        hashMap.put("event_action", str2);
        hashMap.put("event_label", locationName);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.b.n(this.f21630b));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, this.f21630b);
        if (this.f21631c) {
            if (cJRLocation != null) {
                str = cJRLocation.getLocationName();
            }
            HashMap hashMap2 = new HashMap();
            if (cJRLocation != null) {
                hashMap2.put("event_label2", cJRLocation.getProviderLocationId());
            }
            hashMap2.put("event_label", str);
            hashMap2.put("userid", com.paytm.utility.b.n(this.f21630b));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets", "bus_home", "boarding_point_selected", hashMap2);
        } else {
            if (cJRLocation != null) {
                str = cJRLocation.getLocationName();
            }
            HashMap hashMap3 = new HashMap();
            if (cJRLocation != null) {
                hashMap3.put("event_label2", cJRLocation.getProviderLocationId());
            }
            hashMap3.put("event_label", str);
            hashMap3.put("userid", com.paytm.utility.b.n(this.f21630b));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets", "bus_home", "dropping_point_selected", hashMap3);
        }
        if (this.k != this.j) {
            this.k = -1;
        }
        String str3 = this.f21635g;
        if (str3 != null && str3.compareTo("FJRBusRouteFragment") == 0) {
            this.f21636h.a(cJRLocation, this.f21631c, i2);
            if (this.f21631c) {
                this.f21636h.a(1);
            } else {
                this.f21636h.a(0);
            }
        }
        this.f21636h.a(cJRLocation, this.f21631c, i2);
        view.post(new Runnable() {
            public final void run() {
                f.this.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        notifyDataSetChanged();
    }

    private void a(CJRLocation cJRLocation, b bVar) {
        if (cJRLocation.getLatitude() != null && !TextUtils.isEmpty(cJRLocation.getLatitude()) && !cJRLocation.getLatitude().equalsIgnoreCase("null") && cJRLocation.getLongitude() != null && !TextUtils.isEmpty(cJRLocation.getLongitude()) && !cJRLocation.getLongitude().equalsIgnoreCase("null")) {
            Location location = new Location("");
            location.setLatitude(this.f21633e);
            location.setLongitude(this.f21634f);
            Location location2 = new Location("");
            location2.setLatitude(Double.parseDouble(cJRLocation.getLatitude()));
            location2.setLongitude(Double.parseDouble(cJRLocation.getLongitude()));
            float distanceTo = location.distanceTo(location2) / 1000.0f;
            if (distanceTo > 0.0f) {
                String format = String.format("%.1f", new Object[]{Float.valueOf(distanceTo)});
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(format);
                spannableString.setSpan(new ForegroundColorSpan(this.f21630b.getResources().getColor(R.color.bus_time_color)), 0, spannableString.length(), 0);
                spannableStringBuilder.append(spannableString);
                SpannableString spannableString2 = new SpannableString(" km");
                spannableString2.setSpan(new ForegroundColorSpan(this.f21630b.getResources().getColor(R.color.color_999999)), 0, spannableString2.length(), 0);
                spannableStringBuilder.append(spannableString2);
                bVar.f21647g.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                bVar.f21647g.setVisibility(0);
                return;
            }
            bVar.f21647g.setVisibility(8);
            return;
        }
        bVar.f21647g.setVisibility(8);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_boarding_droping_point_item, viewGroup, false));
    }
}
