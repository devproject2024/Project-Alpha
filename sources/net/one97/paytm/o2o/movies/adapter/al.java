package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieLanguages;

public final class al extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f74403a;

    /* renamed from: b  reason: collision with root package name */
    b f74404b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<CJRMovieLanguages> f74405c;

    /* renamed from: d  reason: collision with root package name */
    int f74406d;

    /* renamed from: e  reason: collision with root package name */
    String f74407e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f74408f;

    /* renamed from: g  reason: collision with root package name */
    private int f74409g;

    public interface b {
        void a(int i2, String str);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        CJRMovieLanguages cJRMovieLanguages = this.f74405c.get(i2);
        if (cJRMovieLanguages != null) {
            aVar.f74412a.setText(cJRMovieLanguages.getLanguage());
            if (cJRMovieLanguages.getIsSelected()) {
                aVar.f74412a.setBackground(androidx.core.content.b.a(this.f74403a, R.drawable.rounded_corner_3dp_blue));
                aVar.f74412a.setTextColor(androidx.core.content.b.c(this.f74403a, net.one97.paytm.o2o.movies.R.color.white));
            } else {
                aVar.f74412a.setBackground(androidx.core.content.b.a(this.f74403a, R.drawable.bg_bright_sky_blue_3dp_rounded));
                aVar.f74412a.setTextColor(androidx.core.content.b.c(this.f74403a, net.one97.paytm.o2o.movies.R.color.paytm_blue));
            }
        }
        aVar.f74412a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (al.this.f74404b != null) {
                    b bVar = al.this.f74404b;
                    al.this.f74405c.get(i2).getLanguage();
                    bVar.a(i2, al.this.f74407e);
                }
            }
        });
    }

    public al(Context context, ArrayList<CJRMovieLanguages> arrayList, String str) {
        this.f74403a = context;
        Context context2 = this.f74403a;
        if (context2 != null) {
            this.f74408f = LayoutInflater.from(context2);
        }
        this.f74407e = str;
        this.f74405c = arrayList;
        this.f74409g = -1;
    }

    public final int getItemCount() {
        ArrayList<CJRMovieLanguages> arrayList = this.f74405c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void a(ArrayList<CJRMovieLanguages> arrayList) {
        this.f74405c = arrayList;
        notifyDataSetChanged();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74412a;

        /* renamed from: c  reason: collision with root package name */
        private LinearLayout f74414c;

        public a(View view) {
            super(view);
            int g2 = com.paytm.utility.b.g(al.this.f74403a);
            this.f74414c = (LinearLayout) view;
            this.f74412a = (TextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.price_txtvw);
            this.f74412a.setPadding(g2, 0, g2, 0);
            al.this.f74406d = g2;
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f74408f.inflate(net.one97.paytm.o2o.movies.R.layout.movies_gift_card_prices_layout, viewGroup, false));
    }
}
