package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.busticket.a.d;
import com.travel.bus.pojo.busticket.halfcardmodel.CJRRNROptions;
import java.util.List;

public final class d extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    a f21622a;

    /* renamed from: b  reason: collision with root package name */
    private Context f21623b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRRNROptions> f21624c;

    public interface a {
        void a(int i2);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        String icon = this.f21624c.get(i2).getIcon();
        int color = this.f21623b.getResources().getColor(R.color.color_506d85);
        int i3 = R.drawable.travel_res_bus_rounded_rect_with_3dp_grey_radius;
        bVar.f21627c.setBackgroundResource(R.drawable.travel_res_bus_rounded_rect_with_3dp_grey_radius);
        if (this.f21624c.get(i2).isSelected()) {
            icon = this.f21624c.get(i2).getIconSelected();
            color = this.f21623b.getResources().getColor(R.color.color_00aced);
            i3 = R.drawable.travel_res_bus_rounded_rect_with_3dp_blue_radius;
        }
        if (URLUtil.isValidUrl(icon)) {
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f21623b);
            a2.f43753a = icon;
            b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.drawable.travel_res_bus_placeholder_amenity)), bVar.f21625a, (com.paytm.utility.b.b.b) null, 2);
        }
        bVar.f21626b.setTextColor(color);
        bVar.f21626b.setText(this.f21624c.get(i2).getName());
        bVar.f21627c.setBackgroundResource(i3);
    }

    public d(Context context, List<CJRRNROptions> list, a aVar) {
        this.f21623b = context;
        this.f21622a = aVar;
        this.f21624c = list;
    }

    public final int getItemCount() {
        return this.f21624c.size();
    }

    class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f21625a;

        /* renamed from: b  reason: collision with root package name */
        TextView f21626b;

        /* renamed from: c  reason: collision with root package name */
        RelativeLayout f21627c;

        public b(View view) {
            super(view);
            this.f21625a = (ImageView) view.findViewById(R.id.img_bus_questions_icon);
            this.f21626b = (TextView) view.findViewById(R.id.txt_title);
            this.f21627c = (RelativeLayout) view.findViewById(R.id.rl_rating_bottom_view);
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.b.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            d.this.f21622a.a(getAdapterPosition());
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f21623b).inflate(R.layout.adapter_bus_questions_vh, (ViewGroup) null));
    }
}
