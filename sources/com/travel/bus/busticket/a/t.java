package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.busticket.b.d;
import com.travel.bus.busticket.e.h;
import com.travel.bus.busticket.e.i;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import java.util.ArrayList;
import java.util.HashMap;

public final class t extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private Context f21761a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f21762b;

    /* renamed from: c  reason: collision with root package name */
    private int f21763c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, CJRBusSearchAmenitiesInfo> f21764d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Integer> f21765e;

    /* renamed from: f  reason: collision with root package name */
    private d f21766f;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        return i2 < 4 ? 0 : 1;
    }

    public t(Context context, ArrayList<String> arrayList, ArrayList<Integer> arrayList2, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap, d dVar) {
        this.f21762b = arrayList;
        this.f21761a = context;
        this.f21763c = arrayList2.size();
        this.f21765e = arrayList2;
        this.f21764d = hashMap;
        this.f21766f = dVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new i(LayoutInflater.from(this.f21761a).inflate(R.layout.pre_b_item_bus_amenity_icon, (ViewGroup) null));
        }
        if (i2 != 1) {
            return null;
        }
        return new h(LayoutInflater.from(this.f21761a).inflate(R.layout.pre_b_item_bus_amenity_count, (ViewGroup) null), this.f21766f);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar instanceof i) {
            i iVar = (i) vVar;
            Context context = this.f21761a;
            String str = this.f21762b.get(i2);
            if (URLUtil.isValidUrl(str)) {
                b.a.C0750a a2 = b.a(context);
                a2.f43753a = str;
                b.a.C0750a b2 = a2.b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity));
                b2.m = true;
                b.a.C0750a.a(b2, iVar.f22162a, (com.paytm.utility.b.b.b) null, 2);
            }
        } else if (vVar instanceof h) {
            ((h) vVar).a(this.f21765e, this.f21763c - (this.f21762b.size() - 1), this.f21764d);
        }
    }

    public final int getItemCount() {
        ArrayList<String> arrayList = this.f21762b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
