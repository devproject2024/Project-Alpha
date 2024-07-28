package net.one97.paytm.recharge.metro.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.metro.c.q;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;

public class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    CJRMetroStationModel f63170a;

    /* renamed from: b  reason: collision with root package name */
    protected List<CJRMetroStationModel> f63171b;

    /* renamed from: c  reason: collision with root package name */
    final q.a f63172c;

    public f(CJRMetroStationModel cJRMetroStationModel, List<CJRMetroStationModel> list, q.a aVar) {
        this.f63170a = cJRMetroStationModel;
        this.f63171b = list;
        this.f63172c = aVar;
    }

    public int getItemViewType(int i2) {
        return (this.f63170a == null || !this.f63171b.get(i2).getId().equalsIgnoreCase(this.f63170a.getId())) ? 1 : 2;
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view;
        if (i2 == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.station_list_content, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.station_list_content_destination, viewGroup, false);
        }
        return new a(view);
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i2) {
        aVar.f63173a.setText(this.f63171b.get(i2).getName());
    }

    public int getItemCount() {
        return this.f63171b.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f63173a;

        public a(View view) {
            super(view);
            this.f63173a = (TextView) view.findViewById(R.id.tv_station_name);
            this.itemView.setOnClickListener(new View.OnClickListener(f.this) {
                public final void onClick(View view) {
                    if (a.this.getItemViewType() != 2 && f.this.f63172c != null) {
                        CJRMetroStationModel cJRMetroStationModel = f.this.f63171b.get(a.this.getAdapterPosition());
                        if (f.this.f63170a == null) {
                            f.this.f63172c.a(cJRMetroStationModel, (CJRMetroStationModel) null);
                        } else {
                            f.this.f63172c.a(f.this.f63170a, cJRMetroStationModel);
                        }
                    }
                }
            });
        }
    }
}
