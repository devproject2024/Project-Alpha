package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.busticket.h.b;
import com.travel.bus.busticket.h.c;
import com.travel.bus.busticket.h.d;
import com.travel.bus.busticket.h.e;
import com.travel.bus.busticket.h.f;
import com.travel.bus.busticket.h.g;
import com.travel.bus.pojo.bussearch.CJRSuggestionZeroSearch;
import com.travel.bus.pojo.bussearch.CJRTravelRoutesZeroSearch;
import java.util.List;

public final class a extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f21532a;

    /* renamed from: b  reason: collision with root package name */
    private CJRTravelRoutesZeroSearch f21533b;

    /* renamed from: c  reason: collision with root package name */
    private g f21534c;

    /* renamed from: d  reason: collision with root package name */
    private List<List<CJRSuggestionZeroSearch>> f21535d;

    public a(Context context, CJRTravelRoutesZeroSearch cJRTravelRoutesZeroSearch, List<List<CJRSuggestionZeroSearch>> list) {
        this.f21532a = context;
        this.f21535d = list;
        this.f21534c = (g) context;
        this.f21533b = cJRTravelRoutesZeroSearch;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        b fromIndex = b.fromIndex(i2);
        Context context = this.f21532a;
        g gVar = this.f21534c;
        int i3 = c.AnonymousClass1.f22404a[fromIndex.ordinal()];
        if (i3 == 1) {
            return new f(c.a(viewGroup, fromIndex), gVar);
        }
        if (i3 == 2) {
            return new com.travel.bus.busticket.h.a(c.a(viewGroup, fromIndex));
        }
        if (i3 == 3) {
            return new e(context, c.a(viewGroup, fromIndex), gVar);
        }
        throw new IllegalStateException("Unexpected value: ".concat(String.valueOf(fromIndex)));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        ((d) vVar).a(this.f21532a, this.f21535d.get(i2), this.f21533b, i2);
    }

    public final int getItemViewType(int i2) {
        return ((CJRSuggestionZeroSearch) this.f21535d.get(i2).get(0)).getLayoutType().getIndex();
    }

    public final int getItemCount() {
        List<List<CJRSuggestionZeroSearch>> list = this.f21535d;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f21535d.size();
    }
}
