package com.travel.flight.flightticket.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.flightticket.d.a;
import com.travel.flight.flightticket.f.n;
import com.travel.flight.flightticket.j.e;
import com.travel.flight.flightticket.j.f;
import com.travel.flight.flightticket.j.h;
import com.travel.flight.flightticket.j.j;
import com.travel.flight.flightticket.j.r;
import com.travel.flight.flightticket.j.s;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.FareRules.CJRMiniRulesLayoutItem;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class g extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private a f24652a;

    /* renamed from: b  reason: collision with root package name */
    private Context f24653b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRMiniRulesLayoutItem> f24654c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private int f24655d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24656e;

    /* renamed from: f  reason: collision with root package name */
    private List<CJRFlightStops> f24657f;

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
    }

    public g(Context context, ArrayList<CJRMiniRulesLayoutItem> arrayList, a aVar, boolean z, List<CJRFlightStops> list) {
        this.f24654c = arrayList;
        this.f24652a = aVar;
        this.f24653b = context;
        this.f24656e = z;
        this.f24657f = list;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        RecyclerView.v vVar;
        n fromIndex = n.fromIndex(i2);
        int i3 = s.AnonymousClass1.f25208a[fromIndex.ordinal()];
        if (i3 == 1) {
            vVar = new com.travel.flight.flightticket.j.g(s.a(viewGroup, fromIndex));
        } else if (i3 == 2) {
            vVar = new f(s.a(viewGroup, fromIndex));
        } else if (i3 == 3) {
            vVar = new h(s.a(viewGroup, fromIndex));
        } else if (i3 == 4 || i3 == 5) {
            vVar = new e(s.a(viewGroup, fromIndex));
        } else {
            vVar = new j(s.a(viewGroup, fromIndex));
        }
        r rVar = (r) vVar;
        Context context = this.f24653b;
        IJRDataModel iJRDataModel = this.f24654c.get(this.f24655d);
        a aVar = this.f24652a;
        rVar.a(context, iJRDataModel, aVar != null ? aVar.name() : null, this.f24656e, this.f24657f);
        return vVar;
    }

    public final int getItemViewType(int i2) {
        n nVar;
        ArrayList<CJRMiniRulesLayoutItem> arrayList = this.f24654c;
        if (arrayList == null || i2 >= arrayList.size()) {
            nVar = n.ITEM_TANDC_WITH_TEXT;
        } else {
            nVar = n.ITEM_TANDC_WITH_TEXT;
            ArrayList<CJRMiniRulesLayoutItem> arrayList2 = this.f24654c;
            if (arrayList2 != null && i2 < arrayList2.size()) {
                nVar = n.fromName(this.f24654c.get(i2).getmLayoutType());
            }
        }
        this.f24655d = i2;
        return nVar.getIndex();
    }

    public final int getItemCount() {
        int i2;
        ArrayList<CJRMiniRulesLayoutItem> arrayList = this.f24654c;
        if (arrayList != null) {
            i2 = arrayList.get(arrayList.size() + -1).getmLayoutType() == null ? this.f24654c.size() - 1 : this.f24654c.size();
        } else {
            i2 = 0;
        }
        if (this.f24654c != null) {
            return i2;
        }
        return 0;
    }
}
