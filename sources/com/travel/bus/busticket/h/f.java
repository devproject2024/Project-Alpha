package com.travel.bus.busticket.h;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.pojo.bussearch.CJRDictionaryItem;
import com.travel.bus.pojo.bussearch.CJRSuggestionZeroSearch;
import com.travel.bus.pojo.bussearch.CJRTravelRoutesZeroSearch;
import java.util.List;

public final class f extends RecyclerView.v implements d {

    /* renamed from: a  reason: collision with root package name */
    private CJRTravelRoutesZeroSearch f22411a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22412b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22413c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22414d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22415e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22416f;

    /* renamed from: g  reason: collision with root package name */
    private g f22417g;

    public f(View view, g gVar) {
        super(view);
        this.f22417g = gVar;
        this.f22412b = (TextView) view.findViewById(R.id.txt_from_route_name);
        this.f22413c = (TextView) view.findViewById(R.id.txt_to_route_name);
        this.f22414d = (TextView) view.findViewById(R.id.txt_from_route_distance);
        this.f22415e = (TextView) view.findViewById(R.id.txt_to_route_distance);
        this.f22416f = (TextView) view.findViewById(R.id.txt_route_distance);
    }

    public final void a(Context context, List<CJRSuggestionZeroSearch> list, CJRTravelRoutesZeroSearch cJRTravelRoutesZeroSearch, int i2) {
        this.f22411a = cJRTravelRoutesZeroSearch;
        if (list != null) {
            if (list.size() == 1) {
                a(list, 0);
            } else if (list.size() == 2) {
                a(list, 1);
            }
        }
        this.itemView.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                f.this.a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        this.f22417g.onZeroSearchItemClick(i2);
    }

    private void a(List<CJRSuggestionZeroSearch> list, int i2) {
        a(list.get(0), true);
        a(list.get(i2), false);
    }

    private void a(CJRSuggestionZeroSearch cJRSuggestionZeroSearch, boolean z) {
        CJRDictionaryItem cJRDictionaryItem = this.f22411a.getDictionary().get(cJRSuggestionZeroSearch.getStart());
        CJRDictionaryItem cJRDictionaryItem2 = this.f22411a.getDictionary().get(cJRSuggestionZeroSearch.getEnd());
        CJRDictionaryItem cJRDictionaryItem3 = this.f22411a.getDictionary().get(cJRSuggestionZeroSearch.getEdge());
        String distance = cJRDictionaryItem3.getDistance();
        if (cJRDictionaryItem3.getType() == null || !cJRDictionaryItem3.getType().equalsIgnoreCase("VIRTUAL")) {
            if (z) {
                this.f22412b.setText(cJRDictionaryItem.getName());
            } else {
                this.f22413c.setText(cJRDictionaryItem2.getName());
            }
            if (!TextUtils.isEmpty(distance)) {
                String format = String.format("%.0f", new Object[]{Double.valueOf(Double.parseDouble(distance))});
                TextView textView = this.f22416f;
                textView.setText((Integer.parseInt(format) / 1000) + " kms");
                return;
            }
            this.f22416f.setVisibility(8);
        } else if (z) {
            Spanned a2 = a(distance, cJRDictionaryItem.getName(), z);
            this.f22412b.setText(cJRDictionaryItem2.getName());
            this.f22414d.setText(a2);
        } else {
            Spanned a3 = a(distance, cJRDictionaryItem2.getName(), z);
            this.f22413c.setText(cJRDictionaryItem.getName());
            this.f22415e.setText(a3);
        }
    }

    private static Spanned a(String str, String str2, boolean z) {
        String str3 = !z ? "to" : "from";
        String format = String.format("%.0f", new Object[]{Double.valueOf(Double.parseDouble(str))});
        return Html.fromHtml("<b>" + (Integer.parseInt(format) / 1000) + " Kms</b> " + str3 + " " + str2);
    }
}
