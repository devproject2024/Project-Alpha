package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;

public final class i extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f74649a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CJRCinemaV2> f74650b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        final a aVar = (a) vVar;
        CJRCinemaV2 cJRCinemaV2 = this.f74650b.get(i2);
        if (cJRCinemaV2 != null) {
            if (!TextUtils.isEmpty(cJRCinemaV2.getName())) {
                aVar.f74653a.setText(cJRCinemaV2.getName());
            }
            if (!TextUtils.isEmpty(cJRCinemaV2.getAddress())) {
                aVar.f74654b.setText(cJRCinemaV2.getAddress());
            }
            aVar.f74655c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (aVar.f74654b.getVisibility() != 0) {
                        aVar.f74655c.setImageResource(R.drawable.up);
                        aVar.f74654b.setVisibility(0);
                        return;
                    }
                    aVar.f74655c.setImageResource(R.drawable.down);
                    aVar.f74654b.setVisibility(8);
                }
            });
            if (i2 == getItemCount() - 1) {
                aVar.f74656d.setVisibility(8);
            } else {
                aVar.f74656d.setVisibility(0);
            }
        }
    }

    public i(Context context, ArrayList<CJRCinemaV2> arrayList) {
        this.f74650b = arrayList;
        this.f74649a = context;
    }

    public final int getItemCount() {
        ArrayList<CJRCinemaV2> arrayList = this.f74650b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public TextView f74653a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f74654b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f74655c;

        /* renamed from: d  reason: collision with root package name */
        public View f74656d;

        public a(View view) {
            super(view);
            this.f74653a = (TextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.imax_cinema_name);
            this.f74654b = (TextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.imax_cinema_address);
            this.f74655c = (ImageView) view.findViewById(net.one97.paytm.o2o.movies.R.id.expand_collapse_view);
            this.f74656d = view.findViewById(net.one97.paytm.o2o.movies.R.id.imax_cinema_divider);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f74649a).inflate(net.one97.paytm.o2o.movies.R.layout.imax_cinema_row_item, viewGroup, false));
    }
}
