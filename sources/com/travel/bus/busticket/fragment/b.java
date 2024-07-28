package com.travel.bus.busticket.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.google.android.play.core.splitcompat.a;
import com.travel.bus.R;
import com.travel.bus.busticket.a.f;
import com.travel.bus.pojo.busticket.CJRLocation;
import java.util.ArrayList;
import net.one97.paytm.i.h;

public class b extends h {

    /* renamed from: a  reason: collision with root package name */
    f.a f22217a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f22218b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRLocation> f22219c;

    /* renamed from: d  reason: collision with root package name */
    private f f22220d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22221e;

    /* renamed from: f  reason: collision with root package name */
    private int f22222f = -1;

    /* renamed from: g  reason: collision with root package name */
    private String f22223g;

    /* renamed from: h  reason: collision with root package name */
    private double f22224h;

    /* renamed from: i  reason: collision with root package name */
    private double f22225i;
    private String j;

    public b() {
    }

    public b(f.a aVar) {
        this.f22217a = aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("bus_bundle_location_list")) {
            this.f22219c = (ArrayList) getArguments().getSerializable("bus_bundle_location_list");
        }
        boolean z = false;
        if (getArguments() != null) {
            this.f22221e = getArguments().getBoolean("bus_is_boarding_point", false);
        }
        if (getArguments() != null && getArguments().containsKey("bus_bundle_latitude")) {
            this.f22224h = getArguments().getDouble("bus_bundle_latitude");
        }
        if (getArguments() != null && getArguments().containsKey("bus_bundle_longitude")) {
            this.f22225i = getArguments().getDouble("bus_bundle_longitude");
        }
        if (getArguments() != null) {
            z = getArguments().getBoolean("bus_bundle_is_lat_long_present", false);
        }
        if (z) {
            this.f22220d = new f(getActivity(), this.f22219c, this.f22217a, this.f22221e, this.f22223g, this.f22224h, this.f22225i);
            return;
        }
        this.f22220d = new f(getActivity(), this.f22219c, this.f22217a, this.f22221e, this.f22223g);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_b_boarding_drop_point_fragment, viewGroup, false);
        this.f22218b = (RecyclerView) inflate.findViewById(R.id.location_point_list);
        this.f22218b.setNestedScrollingEnabled(false);
        this.f22218b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.f22218b.setItemAnimator(new g());
        f fVar = this.f22220d;
        if (fVar != null) {
            fVar.a(this.f22222f);
            this.f22218b.setAdapter(this.f22220d);
        }
        return inflate;
    }

    public final void a(int i2, int i3, boolean z) {
        if (z) {
            this.f22222f = i2;
        } else {
            this.f22222f = i3;
        }
    }

    public final void a(double d2, double d3, boolean z, ArrayList<CJRLocation> arrayList) {
        f fVar;
        if (this.j != null && arrayList != null && arrayList.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 < arrayList.size()) {
                    if (this.j.equalsIgnoreCase(arrayList.get(i2).getLocationName()) && (fVar = this.f22220d) != null) {
                        fVar.a(i2);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        f fVar2 = this.f22220d;
        fVar2.f21632d = true;
        fVar2.f21633e = d2;
        fVar2.f21634f = d3;
        fVar2.f21631c = z;
        fVar2.f21629a = arrayList;
        fVar2.notifyDataSetChanged();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f22218b != null) {
            this.f22218b = null;
        }
        if (this.f22220d != null) {
            this.f22220d = null;
        }
    }
}
