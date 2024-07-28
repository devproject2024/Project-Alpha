package com.travel.bus.busticket.h;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.busticket.a.b;
import com.travel.bus.pojo.bussearch.CJRSuggestionZeroSearch;
import com.travel.bus.pojo.bussearch.CJRTravelRoutesZeroSearch;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.List;

public final class e extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private CJRTravelRoutesZeroSearch f22405a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f22406b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22407c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f22408d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f22409e;

    /* renamed from: f  reason: collision with root package name */
    private g f22410f;

    public e(Context context, View view, g gVar) {
        super(view);
        this.f22410f = gVar;
        this.f22406b = (RecyclerView) view.findViewById(R.id.n_hop_recycler_view);
        this.f22407c = (TextView) view.findViewById(R.id.txt_route_name);
        this.f22408d = (RelativeLayout) view.findViewById(R.id.nhop_expand_view);
        this.f22409e = (ImageView) view.findViewById(R.id.img_arrow);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        this.f22406b.setLayoutManager(linearLayoutManager);
    }

    public final void a(Context context, List<CJRSuggestionZeroSearch> list, CJRTravelRoutesZeroSearch cJRTravelRoutesZeroSearch, int i2) {
        this.f22405a = cJRTravelRoutesZeroSearch;
        this.f22406b.setAdapter(new b(context, list, cJRTravelRoutesZeroSearch));
        boolean isExpanded = list.get(0).isExpanded();
        ResourceUtils.loadBusImagesFromCDN(this.f22409e, "arrow_down.png", false, true, n.a.V1);
        if (isExpanded) {
            ResourceUtils.loadBusImagesFromCDN(this.f22409e, "arrow_up.png", false, true, n.a.V1);
            this.f22408d.setVisibility(0);
        } else {
            this.f22408d.setVisibility(8);
        }
        int size = list.size() - 1;
        this.f22407c.setText(Html.fromHtml(cJRTravelRoutesZeroSearch.getDictionary().get(list.get(0).getStart()).getName() + " to " + cJRTravelRoutesZeroSearch.getDictionary().get(list.get(size).getEnd()).getName() + " via <b>" + cJRTravelRoutesZeroSearch.getDictionary().get(list.get(size).getStart()).getName() + "</b>"));
        this.itemView.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                e.this.a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        this.f22410f.onZeroSearchItemClick(i2);
    }
}
