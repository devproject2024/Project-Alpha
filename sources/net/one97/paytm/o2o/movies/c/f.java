package net.one97.paytm.o2o.movies.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesGridPage;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem;
import net.one97.paytm.o2o.movies.d.i;
import net.one97.paytm.o2o.movies.d.j;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.orders.datamodel.CJRMoviesUpcomingItem;

public final class f extends RecyclerView.v implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f74965a;

    /* renamed from: b  reason: collision with root package name */
    private final i f74966b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f74967c;

    /* renamed from: d  reason: collision with root package name */
    private aj.a f74968d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f74969e;

    public f(Context context, View view, i iVar, aj.a aVar) {
        super(view);
        this.f74965a = context;
        this.f74966b = iVar;
        this.f74968d = aVar;
        this.f74967c = (RecyclerView) view.findViewById(R.id.upcoming_movies_list);
        this.f74969e = (RoboTextView) view.findViewById(R.id.view_all);
    }

    public final void a(Context context, CJRSummaryItem cJRSummaryItem) {
        if (cJRSummaryItem != null) {
            try {
                CJRMoviesUpcomingItem upcomingMoviesItem = cJRSummaryItem.getUpcomingMoviesItem();
                if (upcomingMoviesItem != null && upcomingMoviesItem.getUpcomingMovies() != null && upcomingMoviesItem.getUpcomingMovies().getUpcomingMovieData() != null) {
                    if (!upcomingMoviesItem.getUpcomingMovies().getUpcomingMovieData().isEmpty()) {
                        this.f74967c.setLayoutManager(new LinearLayoutManager(this.f74965a, 0, false));
                        final int a2 = n.a(12, this.f74965a);
                        this.f74967c.addItemDecoration(new RecyclerView.h() {
                            public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                                super.getItemOffsets(rect, view, recyclerView, sVar);
                                rect.right = a2;
                            }
                        });
                        this.f74967c.setHasFixedSize(true);
                        this.f74967c.setAdapter(new aj(upcomingMoviesItem.getUpcomingMovies(), 1, context, this.f74968d));
                        this.f74969e.setOnClickListener(new View.OnClickListener(upcomingMoviesItem) {
                            private final /* synthetic */ CJRMoviesUpcomingItem f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                f.this.a(this.f$1, view);
                            }
                        });
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMoviesUpcomingItem cJRMoviesUpcomingItem, View view) {
        if (!b.c(this.f74965a)) {
            Toast.makeText(this.f74965a, R.string.no_internet, 0).show();
            return;
        }
        Intent intent = new Intent(this.f74965a, AJRUpcomingMoviesGridPage.class);
        intent.putExtra(this.f74965a.getString(R.string.upcoming_movies), cJRMoviesUpcomingItem.getUpcomingMovies());
        this.f74965a.startActivity(intent);
    }
}
