package net.one97.paytm.o2o.movies.moviepass.widgets;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.assets.R;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMoviesInfo;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesGridPage;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.common.d;

public final class CJRMoviePassOrderSummaryFooterView extends LinearLayout implements aj.a {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f75636a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f75637b;

    /* renamed from: c  reason: collision with root package name */
    private Context f75638c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f75639d;

    /* renamed from: e  reason: collision with root package name */
    private CJRUpcomingMovies f75640e;

    /* renamed from: f  reason: collision with root package name */
    private View.OnClickListener f75641f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f75642g;

    private View a(int i2) {
        if (this.f75642g == null) {
            this.f75642g = new HashMap();
        }
        View view = (View) this.f75642g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f75642g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str, com.paytm.network.listener.b bVar) {
    }

    public final void c(boolean z) {
    }

    public final Context getMContext() {
        return this.f75638c;
    }

    public final void setMContext(Context context) {
        this.f75638c = context;
    }

    public final LinearLayout getMParentView() {
        return this.f75639d;
    }

    public final void setMParentView(LinearLayout linearLayout) {
        this.f75639d = linearLayout;
    }

    public final CJRUpcomingMovies getMUpcomingMovies() {
        return this.f75640e;
    }

    public final void setMUpcomingMovies(CJRUpcomingMovies cJRUpcomingMovies) {
        this.f75640e = cJRUpcomingMovies;
    }

    public final View.OnClickListener getMClickListener() {
        return this.f75641f;
    }

    public final void setMClickListener(View.OnClickListener onClickListener) {
        k.c(onClickListener, "<set-?>");
        this.f75641f = onClickListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRMoviePassOrderSummaryFooterView(Context context, LinearLayout linearLayout, CJRUpcomingMovies cJRUpcomingMovies, View.OnClickListener onClickListener) {
        super(context);
        k.c(onClickListener, "mClickListener");
        this.f75638c = context;
        this.f75639d = linearLayout;
        this.f75640e = cJRUpcomingMovies;
        this.f75641f = onClickListener;
    }

    public final void a(String str) {
        AJRUpcomingMoviesActivity.a aVar = AJRUpcomingMoviesActivity.f74111b;
        Context context = this.f75638c;
        if (context != null) {
            Intent a2 = AJRUpcomingMoviesActivity.a.a((FragmentActivity) context, str, (String) null);
            if (a2 != null) {
                a2.putExtra("movie_code", str);
                Context context2 = this.f75638c;
                if (context2 != null) {
                    ((FragmentActivity) context2).startActivityForResult(a2, 7);
                    Context context3 = this.f75638c;
                    if (context3 != null) {
                        ((FragmentActivity) context3).overridePendingTransition(R.anim.slide_in_right, 17432577);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                }
                throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
            return;
        }
        throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void a() {
        View findViewById;
        try {
            this.f75636a = LayoutInflater.from(this.f75638c);
            LayoutInflater layoutInflater = this.f75636a;
            View inflate = layoutInflater != null ? layoutInflater.inflate(net.one97.paytm.o2o.movies.R.layout.mp_order_summary_footer, this) : null;
            if (!(inflate == null || (findViewById = inflate.findViewById(net.one97.paytm.o2o.movies.R.id.view_all)) == null)) {
                findViewById.setOnClickListener(new a(this));
            }
            setUpcomingMoviesAdapter(this.f75640e);
            LinearLayout linearLayout = this.f75639d;
            if (linearLayout != null) {
                linearLayout.addView(inflate);
            }
        } catch (Exception unused) {
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMoviePassOrderSummaryFooterView f75643a;

        a(CJRMoviePassOrderSummaryFooterView cJRMoviePassOrderSummaryFooterView) {
            this.f75643a = cJRMoviePassOrderSummaryFooterView;
        }

        public final void onClick(View view) {
            Context mContext;
            if (!com.paytm.utility.b.c(this.f75643a.getMContext())) {
                Toast.makeText(this.f75643a.getMContext(), net.one97.paytm.o2o.movies.R.string.no_internet, 0).show();
                return;
            }
            CJRUpcomingMovies mUpcomingMovies = this.f75643a.getMUpcomingMovies();
            if (mUpcomingMovies != null && (mContext = this.f75643a.getMContext()) != null) {
                Intent intent = new Intent(mContext, AJRUpcomingMoviesGridPage.class);
                intent.putExtra(mContext.getString(net.one97.paytm.o2o.movies.R.string.upcoming_movies), mUpcomingMovies);
                mContext.startActivity(intent);
            }
        }
    }

    private final void setUpcomingMoviesAdapter(CJRUpcomingMovies cJRUpcomingMovies) {
        if (cJRUpcomingMovies == null || d.a((List) cJRUpcomingMovies.getUpcomingMovieData())) {
            RoboTextView roboTextView = (RoboTextView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_title);
            k.a((Object) roboTextView, "upcoming_container_title");
            roboTextView.setVisibility(8);
            RecyclerView recyclerView = (RecyclerView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_list);
            k.a((Object) recyclerView, "upcoming_container_list");
            recyclerView.setVisibility(8);
            return;
        }
        RoboTextView roboTextView2 = (RoboTextView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_title);
        k.a((Object) roboTextView2, "upcoming_container_title");
        roboTextView2.setVisibility(0);
        RecyclerView recyclerView2 = (RecyclerView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_list);
        k.a((Object) recyclerView2, "upcoming_container_list");
        recyclerView2.setVisibility(0);
        RoboTextView roboTextView3 = (RoboTextView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_title);
        k.a((Object) roboTextView3, "upcoming_container_title");
        roboTextView3.setText("Upcoming Movies");
        RecyclerView recyclerView3 = (RecyclerView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_list);
        k.a((Object) recyclerView3, "upcoming_container_list");
        recyclerView3.setLayoutManager(new LinearLayoutManager(this.f75638c, 0, false));
        CJRUpcomingMovies cJRUpcomingMovies2 = new CJRUpcomingMovies();
        List arrayList = new ArrayList();
        if (cJRUpcomingMovies.getUpcomingMovieData().size() > 5) {
            arrayList.addAll(cJRUpcomingMovies.getUpcomingMovieData().subList(0, 5));
        } else {
            List<CJRUpcomingMoviesInfo> upcomingMovieData = cJRUpcomingMovies.getUpcomingMovieData();
            k.a((Object) upcomingMovieData, "mUpcomingMovies.upcomingMovieData");
            arrayList.addAll(upcomingMovieData);
        }
        cJRUpcomingMovies2.setKeys(cJRUpcomingMovies.getKeys());
        cJRUpcomingMovies2.setLanguageScored(cJRUpcomingMovies.getLanguageScored());
        cJRUpcomingMovies2.setUpcomingMovieData(arrayList);
        Context context = this.f75638c;
        if (context != null) {
            aj ajVar = new aj(cJRUpcomingMovies2, 2, (FragmentActivity) context, this);
            ((RecyclerView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_list)).setHasFixedSize(true);
            RecyclerView recyclerView4 = (RecyclerView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_list);
            k.a((Object) recyclerView4, "upcoming_container_list");
            recyclerView4.setAdapter(ajVar);
            Context context2 = this.f75638c;
            if (context2 != null) {
                this.f75637b = com.paytm.utility.b.f((Context) (FragmentActivity) context2) / 4;
                ((RecyclerView) a(net.one97.paytm.o2o.movies.R.id.upcoming_container_list)).addItemDecoration(new b(this));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
        throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public static final class b extends RecyclerView.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMoviePassOrderSummaryFooterView f75644a;

        b(CJRMoviePassOrderSummaryFooterView cJRMoviePassOrderSummaryFooterView) {
            this.f75644a = cJRMoviePassOrderSummaryFooterView;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            k.c(rect, "outRect");
            k.c(view, "view");
            k.c(recyclerView, "parent");
            k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            rect.left = this.f75644a.f75637b;
            rect.right = this.f75644a.f75637b;
        }
    }
}
