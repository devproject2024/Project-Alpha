package com.travel.bus.busticket.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.travel.bus.busticket.b.h;
import com.travel.bus.pojo.busticket.CJRBusOriginCityItem;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ab extends BaseAdapter implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<CJRBusOriginCityItem> f21544a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRBusOriginCityItem> f21545b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f21546c;

    /* renamed from: d  reason: collision with root package name */
    private a f21547d;

    /* renamed from: e  reason: collision with root package name */
    private b f21548e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public h f21549f;

    /* renamed from: g  reason: collision with root package name */
    private int f21550g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f21551h = -1;

    /* renamed from: i  reason: collision with root package name */
    private String f21552i;

    public interface b {
        void a(boolean z);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getViewTypeCount() {
        return 4;
    }

    public ab(Context context, ArrayList<CJRBusOriginCityItem> arrayList, b bVar, String str) {
        this.f21549f = (h) context;
        this.f21546c = (LayoutInflater) context.getSystemService("layout_inflater");
        if (arrayList.size() > 0) {
            this.f21544a = arrayList;
            this.f21545b = new ArrayList<>();
            this.f21545b.addAll(arrayList);
        }
        this.f21548e = bVar;
        this.f21552i = str.toLowerCase().trim();
    }

    public final int getCount() {
        ArrayList<CJRBusOriginCityItem> arrayList = this.f21545b;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList.size() == 0) {
            this.f21548e.a(true);
        } else {
            this.f21548e.a(false);
        }
        return this.f21545b.size();
    }

    public final Object getItem(int i2) {
        return this.f21545b.get(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            r11 = this;
            r0 = 2
            r1 = 0
            if (r13 != 0) goto L_0x00d3
            int r13 = r11.getItemViewType(r12)
            if (r13 != r0) goto L_0x0086
            int r13 = r11.f21550g
            r2 = -1
            if (r13 != r2) goto L_0x0027
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusOriginCityItem> r13 = r11.f21545b
            java.lang.Object r13 = r13.get(r12)
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r13 = (com.travel.bus.pojo.busticket.CJRBusOriginCityItem) r13
            java.lang.String r13 = r13.getCityName()
            java.lang.String r3 = "Recent Searches"
            boolean r13 = r13.equalsIgnoreCase(r3)
            if (r13 == 0) goto L_0x0027
            int r13 = r12 + 1
            r11.f21550g = r13
        L_0x0027:
            int r13 = r11.f21551h
            if (r13 != r2) goto L_0x0043
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusOriginCityItem> r13 = r11.f21545b
            java.lang.Object r13 = r13.get(r12)
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r13 = (com.travel.bus.pojo.busticket.CJRBusOriginCityItem) r13
            java.lang.String r13 = r13.getCityName()
            java.lang.String r2 = "Popular Cities"
            boolean r13 = r13.equalsIgnoreCase(r2)
            if (r13 == 0) goto L_0x0043
            int r13 = r12 + 1
            r11.f21551h = r13
        L_0x0043:
            android.view.LayoutInflater r13 = r11.f21546c
            int r2 = com.travel.bus.R.layout.pre_b_bus_search_sub_header
            android.view.View r13 = r13.inflate(r2, r14, r1)
            com.travel.bus.busticket.a.ab$c r14 = new com.travel.bus.busticket.a.ab$c
            r14.<init>(r11, r1)
            int r2 = com.travel.bus.R.id.bus_city_search_header
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r14.f21555a = r2
            int r2 = com.travel.bus.R.id.bus_recent_city_clear
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r14.f21557c = r2
            int r2 = com.travel.bus.R.id.header_container
            android.view.View r2 = r13.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r14.f21558d = r2
            int r2 = com.travel.bus.R.id.arrow_right
            android.view.View r2 = r13.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r14.f21559e = r2
            int r2 = com.travel.bus.R.id.destinationText
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r14.f21560f = r2
            r13.setTag(r14)
            goto L_0x00d9
        L_0x0086:
            android.view.LayoutInflater r13 = r11.f21546c
            int r2 = com.travel.bus.R.layout.pre_b_city_search_item
            android.view.View r13 = r13.inflate(r2, r14, r1)
            com.travel.bus.busticket.a.ab$c r14 = new com.travel.bus.busticket.a.ab$c
            r14.<init>(r11, r1)
            int r2 = com.travel.bus.R.id.city_name
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r14.f21555a = r2
            int r2 = com.travel.bus.R.id.text_view_sub_text
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r14.f21556b = r2
            int r2 = com.travel.bus.R.id.bus_recent_city_clear
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r14.f21557c = r2
            int r2 = com.travel.bus.R.id.header_container
            android.view.View r2 = r13.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r14.f21558d = r2
            int r2 = com.travel.bus.R.id.arrow_right
            android.view.View r2 = r13.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r14.f21559e = r2
            int r2 = com.travel.bus.R.id.destinationText
            android.view.View r2 = r13.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r14.f21560f = r2
            r13.setTag(r14)
            goto L_0x00d9
        L_0x00d3:
            java.lang.Object r14 = r13.getTag()
            com.travel.bus.busticket.a.ab$c r14 = (com.travel.bus.busticket.a.ab.c) r14
        L_0x00d9:
            if (r14 == 0) goto L_0x0216
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusOriginCityItem> r2 = r11.f21545b
            java.lang.Object r12 = r2.get(r12)
            net.one97.paytm.common.entity.IJRDataModel r12 = (net.one97.paytm.common.entity.IJRDataModel) r12
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r12 = (com.travel.bus.pojo.busticket.CJRBusOriginCityItem) r12
            if (r12 == 0) goto L_0x0216
            int r2 = r12.getItemType()
            r3 = 8
            r4 = 1
            if (r2 != r0) goto L_0x011d
            android.widget.TextView r0 = r14.f21555a
            java.lang.String r2 = r12.getCityName()
            r0.setText(r2)
            java.lang.String r0 = r12.getCityName()
            java.lang.String r2 = "Recent Search"
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0116
            android.widget.TextView r0 = r14.f21557c
            r0.setVisibility(r1)
            android.widget.TextView r0 = r14.f21557c
            com.travel.bus.busticket.a.ab$1 r2 = new com.travel.bus.busticket.a.ab$1
            r2.<init>()
            r0.setOnClickListener(r2)
            goto L_0x01e9
        L_0x0116:
            android.widget.TextView r0 = r14.f21557c
            r0.setVisibility(r3)
            goto L_0x01e9
        L_0x011d:
            java.lang.String r0 = r12.getCityName()
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x01da
            int r0 = r12.getItemType()
            r5 = 3
            if (r0 != r5) goto L_0x013c
            android.widget.TextView r0 = r14.f21555a
            java.lang.String r2 = r12.getCityName()
            a((android.widget.TextView) r0, (java.lang.String) r2)
            android.widget.TextView r0 = r14.f21556b
            r0.setVisibility(r3)
            goto L_0x01e9
        L_0x013c:
            android.widget.TextView r0 = r14.f21555a
            java.lang.String r5 = r12.getCityName()
            java.lang.String r6 = r11.f21552i
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r7 = 33
            if (r6 != 0) goto L_0x017e
            android.text.SpannableString r6 = new android.text.SpannableString
            r6.<init>(r5)
            java.lang.String r8 = r5.toLowerCase()
            java.lang.String r9 = r11.f21552i
            int r8 = r8.indexOf(r9)
            if (r8 < 0) goto L_0x017e
            java.lang.String r5 = r11.f21552i
            int r5 = r5.length()
            int r5 = r5 + r8
            android.text.style.StyleSpan r9 = new android.text.style.StyleSpan
            r9.<init>(r4)
            r6.setSpan(r9, r8, r5, r7)
            android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
            java.lang.String r10 = "#222222"
            int r10 = android.graphics.Color.parseColor(r10)
            r9.<init>(r10)
            r6.setSpan(r9, r8, r5, r7)
            r0.setText(r6)
            goto L_0x0181
        L_0x017e:
            r0.setText(r5)
        L_0x0181:
            java.lang.String r0 = r12.getDistrict()
            java.lang.String r5 = r12.getState()
            android.widget.TextView r6 = r14.f21556b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            r9 = r9 ^ r4
            boolean r10 = android.text.TextUtils.isEmpty(r5)
            r10 = r10 ^ r4
            if (r9 != 0) goto L_0x01a5
            if (r10 != 0) goto L_0x01a5
            r6.setText(r2)
            r6.setVisibility(r3)
            goto L_0x01e9
        L_0x01a5:
            r6.setVisibility(r1)
            if (r9 == 0) goto L_0x01ad
            r8.append(r0)
        L_0x01ad:
            if (r9 == 0) goto L_0x01b6
            if (r10 == 0) goto L_0x01b6
            java.lang.String r2 = ", "
            r8.append(r2)
        L_0x01b6:
            if (r10 == 0) goto L_0x01bb
            r8.append(r5)
        L_0x01bb:
            java.lang.String r2 = r8.toString()
            android.text.SpannableString r5 = new android.text.SpannableString
            r5.<init>(r2)
            if (r9 == 0) goto L_0x01d6
            int r0 = r0.length()
            if (r10 == 0) goto L_0x01ce
            int r0 = r0 + 1
        L_0x01ce:
            android.text.style.StyleSpan r2 = new android.text.style.StyleSpan
            r2.<init>(r4)
            r5.setSpan(r2, r1, r0, r7)
        L_0x01d6:
            r6.setText(r5)
            goto L_0x01e9
        L_0x01da:
            android.widget.TextView r0 = r14.f21555a
            r0.setText(r2)
            android.widget.TextView r0 = r14.f21556b
            r0.setText(r2)
            android.widget.TextView r0 = r14.f21556b
            r0.setVisibility(r3)
        L_0x01e9:
            int r0 = r12.getItemType()
            if (r0 != r4) goto L_0x020c
            android.widget.TextView r0 = r14.f21555a
            java.lang.String r2 = r12.getCityName()
            a((android.widget.TextView) r0, (java.lang.String) r2)
            android.widget.TextView r0 = r14.f21560f
            java.lang.String r12 = r12.getDestinationCityName()
            a((android.widget.TextView) r0, (java.lang.String) r12)
            android.widget.TextView r12 = r14.f21560f
            r12.setVisibility(r1)
            android.widget.ImageView r12 = r14.f21559e
            r12.setVisibility(r1)
            goto L_0x0216
        L_0x020c:
            android.widget.TextView r12 = r14.f21560f
            r12.setVisibility(r3)
            android.widget.ImageView r12 = r14.f21559e
            r12.setVisibility(r3)
        L_0x0216:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.a.ab.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final Filter getFilter() {
        if (this.f21547d == null) {
            this.f21547d = new a(this, (byte) 0);
        }
        return this.f21547d;
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        TextView f21555a;

        /* renamed from: b  reason: collision with root package name */
        TextView f21556b;

        /* renamed from: c  reason: collision with root package name */
        TextView f21557c;

        /* renamed from: d  reason: collision with root package name */
        RelativeLayout f21558d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f21559e;

        /* renamed from: f  reason: collision with root package name */
        TextView f21560f;

        private c() {
        }

        /* synthetic */ c(ab abVar, byte b2) {
            this();
        }
    }

    class a extends Filter {
        private a() {
        }

        /* synthetic */ a(ab abVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.values = ab.this.f21544a;
                filterResults.count = ab.this.f21544a.size();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = ab.this.f21544a.iterator();
                while (it2.hasNext()) {
                    CJRBusOriginCityItem cJRBusOriginCityItem = (CJRBusOriginCityItem) ((IJRDataModel) it2.next());
                    if (!(cJRBusOriginCityItem == null || cJRBusOriginCityItem.getCityName() == null || !cJRBusOriginCityItem.getCityName().toUpperCase().trim().startsWith(charSequence.toString().toUpperCase().trim()))) {
                        arrayList.add(cJRBusOriginCityItem);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults != null && filterResults.values != null) {
                ArrayList unused = ab.this.f21545b = (ArrayList) filterResults.values;
                ab.this.notifyDataSetChanged();
            }
        }
    }

    public final int getItemViewType(int i2) {
        return this.f21545b.get(i2).getItemType();
    }

    private static void a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setText(str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#222222")), 0, str.length(), 33);
        textView.setText(spannableString);
    }
}
