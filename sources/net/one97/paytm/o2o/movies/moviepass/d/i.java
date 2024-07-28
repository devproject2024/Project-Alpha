package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.a;
import net.one97.paytm.o2o.movies.utils.n;

public final class i extends j {

    /* renamed from: a  reason: collision with root package name */
    TextView f75539a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f75540b;

    /* renamed from: c  reason: collision with root package name */
    RoboTextView f75541c;

    public i(View view) {
        super(view);
        this.f75539a = (TextView) view.findViewById(R.id.upcoming_container_title);
        this.f75540b = (RecyclerView) view.findViewById(R.id.upcoming_container_list);
        this.f75541c = (RoboTextView) view.findViewById(R.id.view_all);
    }

    public final void a(a aVar, final b bVar, final Context context) {
        if (aVar.f75574e != null && aVar.f75574e.f75596b != null && aVar.f75574e.f75596b.getUpcomingMovieData() != null && !aVar.f75574e.f75596b.getUpcomingMovieData().isEmpty()) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
            final CJRUpcomingMovies cJRUpcomingMovies = aVar.f75574e.f75596b;
            this.f75540b.setLayoutManager(linearLayoutManager);
            if (this.f75540b.getItemDecorationCount() == 0) {
                this.f75540b.addItemDecoration(new RecyclerView.h() {
                    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                        super.getItemOffsets(rect, view, recyclerView, sVar);
                        if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                            rect.left = n.a(20, context);
                        }
                        rect.right = n.a(12, context);
                    }
                });
            }
            if (!TextUtils.isEmpty(aVar.f75574e.f75595a)) {
                this.f75539a.setText(com.paytm.utility.b.E(aVar.f75574e.f75595a));
            }
            aj ajVar = new aj(cJRUpcomingMovies, 1, context, aVar.f75574e.f75597c);
            this.f75540b.setHasFixedSize(true);
            if (cJRUpcomingMovies.getUpcomingMovieData().size() > 4) {
                this.f75541c.setVisibility(0);
                this.f75541c.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        bVar.a(view, cJRUpcomingMovies);
                    }
                });
            } else {
                this.f75541c.setVisibility(8);
            }
            this.f75540b.setAdapter(ajVar);
        }
    }
}
