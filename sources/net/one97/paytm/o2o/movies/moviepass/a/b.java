package net.one97.paytm.o2o.movies.moviepass.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.moviepass.c;
import net.one97.paytm.o2o.movies.moviepass.d.f;
import net.one97.paytm.o2o.movies.moviepass.d.g;
import net.one97.paytm.o2o.movies.moviepass.d.h;
import net.one97.paytm.o2o.movies.moviepass.d.i;
import net.one97.paytm.o2o.movies.moviepass.d.j;
import net.one97.paytm.o2o.movies.moviepass.d.k;
import net.one97.paytm.o2o.movies.moviepass.d.m;
import net.one97.paytm.o2o.movies.moviepass.d.n;
import net.one97.paytm.o2o.movies.moviepass.e.a;

public final class b extends RecyclerView.a<j> {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f75438a;

    /* renamed from: b  reason: collision with root package name */
    private c f75439b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.o2o.movies.moviepass.b f75440c;

    /* renamed from: d  reason: collision with root package name */
    private Context f75441d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        j jVar = (j) vVar;
        if (jVar != null) {
            jVar.a(this.f75438a.get(i2), this.f75440c, this.f75441d);
        }
    }

    public b(List<a> list, net.one97.paytm.o2o.movies.moviepass.b bVar, Context context) {
        this.f75438a = list;
        this.f75440c = bVar;
        this.f75441d = context;
    }

    public final int getItemViewType(int i2) {
        return this.f75438a.get(i2).f75570a;
    }

    public final int getItemCount() {
        return this.f75438a.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        this.f75439b = new c();
        Context context = this.f75441d;
        switch (i2) {
            case 1:
                return new k(LayoutInflater.from(context).inflate(R.layout.moviepass_home_page_city_pass_view, viewGroup, false));
            case 2:
                return new net.one97.paytm.o2o.movies.moviepass.d.a(LayoutInflater.from(context).inflate(R.layout.mp_brand_promotion_item_view, viewGroup, false));
            case 3:
                return new f(LayoutInflater.from(context).inflate(R.layout.mp_benefit_item_view, viewGroup, false));
            case 4:
                return new net.one97.paytm.o2o.movies.moviepass.d.c(LayoutInflater.from(context).inflate(R.layout.empty_grey_item, viewGroup, false));
            case 5:
                return new m(LayoutInflater.from(context).inflate(R.layout.pass_type_selector_item_view, viewGroup, false));
            case 6:
                return new i(LayoutInflater.from(context).inflate(R.layout.movie_pass_upcoming_movies_layout, viewGroup, false));
            case 7:
                return new g(LayoutInflater.from(context).inflate(R.layout.movies_homescreen_horizontal_list, viewGroup, false));
            case 8:
                return new n(LayoutInflater.from(context).inflate(R.layout.user_movie_pass_card_view, viewGroup, false));
            case 9:
                return new h(LayoutInflater.from(context).inflate(R.layout.movie_pass_conditions_item_layout, viewGroup, false));
            default:
                return null;
        }
    }
}
