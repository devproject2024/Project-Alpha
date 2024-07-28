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

public final class an extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    Context f74425a;

    /* renamed from: b  reason: collision with root package name */
    b f74426b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<CJRMovieLanguages> f74427c;

    /* renamed from: d  reason: collision with root package name */
    int f74428d;

    /* renamed from: e  reason: collision with root package name */
    int f74429e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f74430f;

    public interface b {
        void a(int i2, int i3);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar = (a) vVar;
        CJRMovieLanguages cJRMovieLanguages = this.f74427c.get(i2);
        if (cJRMovieLanguages != null) {
            aVar.f74433a.setText(cJRMovieLanguages.getLanguage());
            if (cJRMovieLanguages.getIsSelected()) {
                aVar.f74433a.setBackground(androidx.core.content.b.a(this.f74425a, R.drawable.rounded_corner_3dp_blue));
                aVar.f74433a.setTextColor(androidx.core.content.b.c(this.f74425a, net.one97.paytm.o2o.movies.R.color.white));
            } else {
                aVar.f74433a.setBackground(androidx.core.content.b.a(this.f74425a, R.drawable.bg_bright_sky_blue_3dp_rounded));
                aVar.f74433a.setTextColor(androidx.core.content.b.c(this.f74425a, net.one97.paytm.o2o.movies.R.color.paytm_blue));
            }
        }
        aVar.f74433a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (an.this.f74426b != null) {
                    b bVar = an.this.f74426b;
                    an.this.f74427c.get(i2).getLanguage();
                    bVar.a(an.this.f74429e, i2);
                }
            }
        });
    }

    public an(Context context, ArrayList<CJRMovieLanguages> arrayList, int i2) {
        this.f74425a = context;
        Context context2 = this.f74425a;
        if (context2 != null) {
            this.f74430f = LayoutInflater.from(context2);
        }
        this.f74427c = arrayList;
        this.f74429e = i2;
    }

    public final int getItemCount() {
        ArrayList<CJRMovieLanguages> arrayList = this.f74427c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74433a;

        /* renamed from: c  reason: collision with root package name */
        private LinearLayout f74435c;

        public a(View view) {
            super(view);
            int g2 = com.paytm.utility.b.g(an.this.f74425a);
            this.f74435c = (LinearLayout) view;
            this.f74433a = (TextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.price_txtvw);
            this.f74433a.setPadding(g2, 0, g2, 0);
            an.this.f74428d = g2;
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f74430f.inflate(net.one97.paytm.o2o.movies.R.layout.upcoming_release_month_row, viewGroup, false));
    }
}
