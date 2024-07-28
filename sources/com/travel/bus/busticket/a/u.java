package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.busticket.e.j;
import com.travel.bus.busticket.e.l;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.Iterator;

public final class u extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f21767a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<CJRBusSearchAmenitiesInfo> f21768b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<CJRBusSearchAmenitiesInfo> f21769c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJRBusSearchAmenitiesInfo> f21770d;

    /* renamed from: e  reason: collision with root package name */
    private String f21771e = "";

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public u(Context context, ArrayList<CJRBusSearchAmenitiesInfo> arrayList, ArrayList<CJRBusSearchAmenitiesInfo> arrayList2, String str) {
        this.f21767a = context;
        this.f21768b = arrayList;
        this.f21770d = arrayList2;
        this.f21771e = str;
        a();
    }

    private void a() {
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.f21768b;
        if (arrayList != null) {
            Iterator<CJRBusSearchAmenitiesInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRBusSearchAmenitiesInfo next = it2.next();
                if (next != null && next.isSelected()) {
                    this.f21769c.add(next);
                }
            }
        }
    }

    public final int getItemViewType(int i2) {
        if (!this.f21771e.equals("bottomDialog") && this.f21771e.equals("amenityfilter")) {
            return 1;
        }
        return 0;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new j(LayoutInflater.from(this.f21767a).inflate(R.layout.pre_b_item_bus_amenity_icon_description, (ViewGroup) null));
        }
        if (i2 != 1) {
            return null;
        }
        return new l(LayoutInflater.from(this.f21767a).inflate(R.layout.pre_b_lyt_amenity_filter_item, (ViewGroup) null));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        String str;
        if (vVar instanceof j) {
            j jVar = (j) vVar;
            ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.f21768b;
            if (arrayList != null && arrayList.get(i2) != null) {
                Context context = this.f21767a;
                CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = this.f21768b.get(i2);
                if (cJRBusSearchAmenitiesInfo != null) {
                    if (!TextUtils.isEmpty(cJRBusSearchAmenitiesInfo.getIcon()) && URLUtil.isValidUrl(cJRBusSearchAmenitiesInfo.getIcon())) {
                        b.a.C0750a a2 = b.a(context);
                        a2.f43753a = cJRBusSearchAmenitiesInfo.getIcon();
                        b.a.C0750a b2 = a2.b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity));
                        b2.m = true;
                        b.a.C0750a.a(b2, jVar.f22163a, (com.paytm.utility.b.b.b) null, 2);
                    }
                    if (!TextUtils.isEmpty(cJRBusSearchAmenitiesInfo.getLabel())) {
                        jVar.f22164b.setText(cJRBusSearchAmenitiesInfo.getLabel());
                    }
                }
            }
        } else if (vVar instanceof l) {
            final l lVar = (l) vVar;
            ArrayList<CJRBusSearchAmenitiesInfo> arrayList2 = this.f21768b;
            if (!(arrayList2 == null || arrayList2.get(i2) == null)) {
                Context context2 = this.f21767a;
                CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo2 = this.f21768b.get(i2);
                if (cJRBusSearchAmenitiesInfo2.isSelected()) {
                    str = cJRBusSearchAmenitiesInfo2.getIconSelected();
                    lVar.f22177d.setImageResource(R.drawable.travel_res_bus_filter_blue_tick);
                    lVar.f22175b.setTextColor(context2.getResources().getColor(R.color.color_222222));
                    lVar.f22178e.setTextColor(context2.getResources().getColor(R.color.color_222222));
                } else {
                    str = cJRBusSearchAmenitiesInfo2.getIcon();
                    lVar.f22177d.setImageResource(R.drawable.travel_res_bus_filter_grey_tick);
                    lVar.f22175b.setTextColor(context2.getResources().getColor(R.color.color_999999));
                    lVar.f22178e.setTextColor(context2.getResources().getColor(R.color.color_999999));
                }
                if (!TextUtils.isEmpty(str) && URLUtil.isValidUrl(str)) {
                    b.a.C0750a a3 = b.a(context2);
                    a3.f43753a = str;
                    b.a.C0750a b3 = a3.b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity));
                    b3.m = true;
                    b.a.C0750a.a(b3, lVar.f22174a, (com.paytm.utility.b.b.b) null, 2);
                }
                lVar.f22175b.setText(cJRBusSearchAmenitiesInfo2.getLabel());
                lVar.f22178e.setText(String.valueOf(cJRBusSearchAmenitiesInfo2.getCount()));
            }
            if (lVar != null) {
                lVar.f22176c.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (u.this.f21768b == null || u.this.f21768b.get(i2) == null || !u.this.f21768b.get(i2).isSelected()) {
                            CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = u.this.f21768b.get(i2);
                            cJRBusSearchAmenitiesInfo.setSelected(true);
                            u.this.f21768b.get(i2).setSelected(true);
                            u.this.f21769c.add(cJRBusSearchAmenitiesInfo);
                            lVar.a(u.this.f21767a, cJRBusSearchAmenitiesInfo);
                        } else if (u.this.f21769c != null && u.this.f21769c.size() > 0) {
                            u uVar = u.this;
                            CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo2 = uVar.f21768b.get(i2);
                            ArrayList arrayList = new ArrayList();
                            if (!(cJRBusSearchAmenitiesInfo2 == null || uVar.f21769c == null || uVar.f21769c.size() <= 0)) {
                                Iterator<CJRBusSearchAmenitiesInfo> it2 = uVar.f21769c.iterator();
                                while (it2.hasNext()) {
                                    CJRBusSearchAmenitiesInfo next = it2.next();
                                    if (!(next == null || next.getName() == null || next.getName().equalsIgnoreCase(cJRBusSearchAmenitiesInfo2.getName()))) {
                                        arrayList.add(next);
                                    }
                                }
                                uVar.f21769c.clear();
                                uVar.f21769c.addAll(arrayList);
                            }
                            u.this.f21768b.get(i2).setSelected(false);
                            lVar.a(u.this.f21767a, u.this.f21768b.get(i2));
                            u.this.f21769c.remove(u.this.f21768b.get(i2));
                        }
                    }
                });
            }
        }
    }

    public final int getItemCount() {
        ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.f21768b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
