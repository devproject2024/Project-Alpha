package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.o2o.movies.adapter.an;
import net.one97.paytm.o2o.movies.common.movies.CJRUpcomingMovieReleaseDate;

public final class am extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    Context f74415a;

    /* renamed from: b  reason: collision with root package name */
    a f74416b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRUpcomingMovieReleaseDate> f74417c;

    /* renamed from: d  reason: collision with root package name */
    private an.b f74418d;

    public interface a {
        void a(int i2);

        void a(RecyclerView recyclerView);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        a aVar;
        b bVar = (b) vVar;
        CJRUpcomingMovieReleaseDate cJRUpcomingMovieReleaseDate = this.f74417c.get(i2);
        if (cJRUpcomingMovieReleaseDate != null) {
            bVar.f74421a.setText(cJRUpcomingMovieReleaseDate.getYear());
            if (cJRUpcomingMovieReleaseDate.isExpanded()) {
                bVar.f74422b.setVisibility(0);
                bVar.f74421a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0);
            } else {
                bVar.f74422b.setVisibility(8);
                bVar.f74421a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0);
            }
            bVar.f74421a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (am.this.f74416b != null) {
                        am.this.f74416b.a(i2);
                    }
                }
            });
            if (bVar.f74423c == null) {
                bVar.f74423c = new an(this.f74415a, cJRUpcomingMovieReleaseDate.getReleaseMonths(), i2);
                bVar.f74423c.f74426b = this.f74418d;
                bVar.f74422b.setAdapter(bVar.f74423c);
                if (cJRUpcomingMovieReleaseDate.isExpanded() && (aVar = this.f74416b) != null) {
                    aVar.a(bVar.f74422b);
                    return;
                }
                return;
            }
            an anVar = bVar.f74423c;
            anVar.f74427c = cJRUpcomingMovieReleaseDate.getReleaseMonths();
            anVar.notifyDataSetChanged();
        }
    }

    public am(ArrayList<CJRUpcomingMovieReleaseDate> arrayList, a aVar, an.b bVar) {
        this.f74417c = arrayList;
        this.f74416b = aVar;
        this.f74418d = bVar;
    }

    public final int getItemCount() {
        ArrayList<CJRUpcomingMovieReleaseDate> arrayList = this.f74417c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f74421a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f74422b;

        /* renamed from: c  reason: collision with root package name */
        an f74423c;

        public b(View view) {
            super(view);
            this.f74421a = (TextView) view.findViewById(net.one97.paytm.o2o.movies.R.id.upcoming_rel_year);
            this.f74422b = (RecyclerView) view.findViewById(net.one97.paytm.o2o.movies.R.id.upcoming_rel_months_recycler);
            this.f74422b.setLayoutManager(new GridLayoutManager(am.this.f74415a, 4));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.f74415a = viewGroup.getContext();
        return new b(LayoutInflater.from(this.f74415a).inflate(net.one97.paytm.o2o.movies.R.layout.upcoming_filter_reldate_layout, viewGroup, false));
    }
}
