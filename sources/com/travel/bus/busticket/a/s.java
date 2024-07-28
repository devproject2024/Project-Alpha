package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.busticket.b.b;
import com.travel.bus.busticket.e.e;
import com.travel.bus.busticket.e.f;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.HashMap;

public final class s extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private Context f21754a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f21755b;

    /* renamed from: c  reason: collision with root package name */
    private int f21756c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, CJRBusSearchAmenitiesInfo> f21757d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Integer> f21758e;

    /* renamed from: f  reason: collision with root package name */
    private b f21759f;

    /* renamed from: g  reason: collision with root package name */
    private int f21760g;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public s(Context context, ArrayList<String> arrayList, ArrayList<Integer> arrayList2, int i2, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap, b bVar) {
        this.f21755b = arrayList;
        this.f21754a = context;
        this.f21756c = arrayList2.size();
        this.f21758e = arrayList2;
        this.f21757d = hashMap;
        this.f21759f = bVar;
        this.f21760g = i2;
    }

    public final int getItemViewType(int i2) {
        return i2 >= this.f21760g - 1 ? 1 : 0;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new f(LayoutInflater.from(this.f21754a).inflate(R.layout.pre_b_item_bus_review_amenity_icon, (ViewGroup) null));
        }
        if (i2 != 1) {
            return null;
        }
        return new e(LayoutInflater.from(this.f21754a).inflate(R.layout.pre_b_item_bus_review_amenity_count, (ViewGroup) null), this.f21759f);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof f) {
            f fVar = (f) vVar;
            Context context = this.f21754a;
            String str = this.f21755b.get(i2);
            if (URLUtil.isValidUrl(str)) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                a2.f43753a = str;
                b.a.C0750a b2 = a2.b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity));
                b2.m = true;
                b.a.C0750a.a(b2, fVar.f22154a, (com.paytm.utility.b.b.b) null, 2);
            }
        } else if (vVar instanceof e) {
            ((e) vVar).a(this.f21758e, this.f21756c - (this.f21760g - 1), this.f21757d);
        }
    }

    public final int getItemCount() {
        ArrayList<String> arrayList = this.f21755b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
