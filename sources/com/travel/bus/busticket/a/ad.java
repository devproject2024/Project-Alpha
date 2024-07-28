package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.bus.R;
import com.travel.bus.pojo.busticket.BusRecentLocationData;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.Collections;
import java.util.List;

public final class ad extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    List<BusRecentLocationData> f21569a;

    /* renamed from: b  reason: collision with root package name */
    a f21570b;

    /* renamed from: c  reason: collision with root package name */
    private Context f21571c;

    /* renamed from: d  reason: collision with root package name */
    private BusRecentLocationData f21572d;

    public interface a {
        void a(BusRecentLocationData busRecentLocationData);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        b bVar = (b) vVar;
        this.f21572d = this.f21569a.get(i2);
        ResourceUtils.loadBusImagesFromCDN(bVar.f21578d, "recent_location.png", false, false, n.a.V1);
        if (this.f21572d != null) {
            if (i2 == 0) {
                bVar.f21577c.setVisibility(0);
            } else {
                bVar.f21577c.setVisibility(8);
            }
            if (this.f21572d.getPrimaryText() != null && !this.f21572d.getPrimaryText().isEmpty()) {
                bVar.f21575a.setText(this.f21572d.getPrimaryText());
            }
            if (this.f21572d.getSecondaryText() != null && !this.f21572d.getSecondaryText().isEmpty()) {
                bVar.f21576b.setText(this.f21572d.getSecondaryText());
            }
            bVar.f21579e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ad.this.f21570b.a(ad.this.f21569a.get(i2));
                }
            });
        }
    }

    public ad(Context context, List<BusRecentLocationData> list) {
        this.f21571c = context;
        this.f21569a = list;
        Collections.reverse(this.f21569a);
        this.f21570b = (a) context;
    }

    public final int getItemCount() {
        List<BusRecentLocationData> list = this.f21569a;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f21569a.size();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f21575a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f21576b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f21577c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f21578d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f21579e;

        public b(View view) {
            super(view);
            this.f21578d = (ImageView) view.findViewById(R.id.image);
            this.f21577c = (RoboTextView) view.findViewById(R.id.recent_heading);
            this.f21576b = (RoboTextView) view.findViewById(R.id.secondary_address);
            this.f21575a = (RoboTextView) view.findViewById(R.id.primary_address);
            this.f21579e = (RelativeLayout) view.findViewById(R.id.recentLocationLyt);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_b_bus_location_recents_item, viewGroup, false));
    }
}
