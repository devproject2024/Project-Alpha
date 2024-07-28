package com.travel.bus.busticket.h;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.pojo.bussearch.CJRSuggestionZeroSearch;
import com.travel.bus.pojo.bussearch.CJRTravelRoutesZeroSearch;
import java.util.List;

public final class a extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f22403a;

    public a(View view) {
        super(view);
        this.f22403a = (TextView) view.findViewById(R.id.txt_from_route_name);
    }

    public final void a(Context context, List<CJRSuggestionZeroSearch> list, CJRTravelRoutesZeroSearch cJRTravelRoutesZeroSearch, int i2) {
        if (list.size() > 0 && list.get(0) != null && list.get(0).getStart() != null) {
            TextView textView = this.f22403a;
            textView.setText("Via routes to " + list.get(0).getStart());
        }
    }
}
