package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.pojo.bussearch.CJRDictionaryItem;
import com.travel.bus.pojo.bussearch.CJRSuggestionZeroSearch;
import com.travel.bus.pojo.bussearch.CJRTravelRoutesZeroSearch;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.List;

public final class b extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f21610a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRSuggestionZeroSearch> f21611b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTravelRoutesZeroSearch f21612c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        CJRSuggestionZeroSearch cJRSuggestionZeroSearch = this.f21611b.get(i2);
        CJRDictionaryItem cJRDictionaryItem = this.f21612c.getDictionary().get(cJRSuggestionZeroSearch.getEnd());
        CJRDictionaryItem cJRDictionaryItem2 = this.f21612c.getDictionary().get(cJRSuggestionZeroSearch.getEdge());
        ResourceUtils.loadBusImagesFromCDN(aVar.f21618f, "dotted_path.png", false, false, n.a.V1);
        aVar.f21613a.setText(this.f21612c.getDictionary().get(cJRSuggestionZeroSearch.getStart()).getName());
        if (!TextUtils.isEmpty(cJRDictionaryItem2.getDistance())) {
            String format = String.format("%.0f", new Object[]{Double.valueOf(Double.parseDouble(cJRDictionaryItem2.getDistance()))});
            TextView textView = aVar.f21616d;
            textView.setText((Integer.parseInt(format) / 1000) + " kms");
        } else {
            aVar.f21616d.setVisibility(4);
        }
        aVar.f21614b.setVisibility(8);
        aVar.f21615c.setVisibility(0);
        aVar.f21617e.setVisibility(0);
        if (i2 == this.f21611b.size() - 1 || this.f21611b.size() == 1) {
            aVar.f21614b.setText(cJRDictionaryItem.getName());
            aVar.f21614b.setVisibility(0);
        }
        if (this.f21611b.size() == 1) {
            aVar.f21615c.setVisibility(4);
            aVar.f21617e.setVisibility(4);
        } else if (i2 == 0) {
            aVar.f21615c.setVisibility(4);
            aVar.f21617e.setVisibility(4);
        }
    }

    public b(Context context, List<CJRSuggestionZeroSearch> list, CJRTravelRoutesZeroSearch cJRTravelRoutesZeroSearch) {
        this.f21610a = context;
        this.f21611b = list;
        this.f21612c = cJRTravelRoutesZeroSearch;
    }

    public final int getItemViewType(int i2) {
        return this.f21611b.size();
    }

    public final int getItemCount() {
        List<CJRSuggestionZeroSearch> list = this.f21611b;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f21611b.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f21613a;

        /* renamed from: b  reason: collision with root package name */
        TextView f21614b;

        /* renamed from: c  reason: collision with root package name */
        View f21615c;

        /* renamed from: d  reason: collision with root package name */
        TextView f21616d;

        /* renamed from: e  reason: collision with root package name */
        TextView f21617e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f21618f;

        public a(View view) {
            super(view);
            this.f21613a = (TextView) view.findViewById(R.id.txt_start_name);
            this.f21614b = (TextView) view.findViewById(R.id.txt_end_name);
            this.f21615c = view.findViewById(R.id.view_circle_dot);
            this.f21616d = (TextView) view.findViewById(R.id.txt_start_route_distance);
            this.f21617e = (TextView) view.findViewById(R.id.txt_bus_change_name);
            this.f21618f = (ImageView) view.findViewById(R.id.dotted_path);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f21610a).inflate(R.layout.bus_search_n_hop_item, viewGroup, false));
    }
}
