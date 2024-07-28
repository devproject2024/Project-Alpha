package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab;
import net.one97.paytm.o2o.movies.fragment.d;

public final class a extends RecyclerView.a<au> {

    /* renamed from: a  reason: collision with root package name */
    final d.a f74238a;

    /* renamed from: b  reason: collision with root package name */
    final C1481a f74239b;

    /* renamed from: c  reason: collision with root package name */
    private Context f74240c;

    /* renamed from: net.one97.paytm.o2o.movies.adapter.a$a  reason: collision with other inner class name */
    public interface C1481a {
        void a(int i2, CJRMovieDetailsTab cJRMovieDetailsTab);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        au auVar = (au) vVar;
        k.c(auVar, "holder");
        CJRMovieDetailsTab cJRMovieDetailsTab = this.f74238a.f75286a.get(i2);
        auVar.f74476a.setText(cJRMovieDetailsTab.getmDay());
        auVar.f74477b.setText(cJRMovieDetailsTab.getmDayName());
        if (p.a(this.f74238a.f75287b, cJRMovieDetailsTab.getmDate(), true)) {
            RelativeLayout relativeLayout = auVar.f74478c;
            Context context = this.f74240c;
            if (context == null) {
                k.a();
            }
            relativeLayout.setBackground(androidx.core.content.b.a(context, R.drawable.movie_date_selector));
            TextView textView = auVar.f74476a;
            Context context2 = this.f74240c;
            if (context2 == null) {
                k.a();
            }
            textView.setTextColor(androidx.core.content.b.c(context2, R.color.white));
            TextView textView2 = auVar.f74477b;
            Context context3 = this.f74240c;
            if (context3 == null) {
                k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(context3, R.color.white));
        } else {
            RelativeLayout relativeLayout2 = auVar.f74478c;
            Context context4 = this.f74240c;
            if (context4 == null) {
                k.a();
            }
            relativeLayout2.setBackground(androidx.core.content.b.a(context4, R.drawable.movie_date_selector_default));
            TextView textView3 = auVar.f74476a;
            Context context5 = this.f74240c;
            if (context5 == null) {
                k.a();
            }
            textView3.setTextColor(androidx.core.content.b.c(context5, R.color.paytm_blue));
            TextView textView4 = auVar.f74477b;
            Context context6 = this.f74240c;
            if (context6 == null) {
                k.a();
            }
            textView4.setTextColor(androidx.core.content.b.c(context6, R.color.paytm_blue));
        }
        auVar.f74478c.setOnClickListener(new b(this, cJRMovieDetailsTab, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        this.f74240c = viewGroup.getContext();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cinema_tab_view, (ViewGroup) null);
        k.a((Object) inflate, "view");
        return new au(inflate);
    }

    public a(d.a aVar, C1481a aVar2) {
        k.c(aVar, "dateModel");
        k.c(aVar2, "mListener");
        this.f74238a = aVar;
        this.f74239b = aVar2;
    }

    public final int getItemCount() {
        return this.f74238a.f75286a.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f74241a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMovieDetailsTab f74242b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74243c;

        b(a aVar, CJRMovieDetailsTab cJRMovieDetailsTab, int i2) {
            this.f74241a = aVar;
            this.f74242b = cJRMovieDetailsTab;
            this.f74243c = i2;
        }

        public final void onClick(View view) {
            if (!p.a(this.f74241a.f74238a.f75287b, this.f74242b.getmDate(), true)) {
                C1481a aVar = this.f74241a.f74239b;
                int i2 = this.f74243c;
                CJRMovieDetailsTab cJRMovieDetailsTab = this.f74242b;
                k.a((Object) cJRMovieDetailsTab, "cjrMovieDetailsTab");
                aVar.a(i2, cJRMovieDetailsTab);
            }
        }
    }
}
