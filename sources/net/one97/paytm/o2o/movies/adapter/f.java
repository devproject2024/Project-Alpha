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
import net.one97.paytm.o2o.movies.fragment.i;

public final class f extends RecyclerView.a<aw> {

    /* renamed from: a  reason: collision with root package name */
    final i.b f74620a;

    /* renamed from: b  reason: collision with root package name */
    final a f74621b;

    /* renamed from: c  reason: collision with root package name */
    private Context f74622c;

    public interface a {
        void a(int i2, CJRMovieDetailsTab cJRMovieDetailsTab);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        aw awVar = (aw) vVar;
        k.c(awVar, "holder");
        CJRMovieDetailsTab cJRMovieDetailsTab = this.f74620a.f75363a.get(i2);
        awVar.f74488a.setText(cJRMovieDetailsTab.getmDay());
        awVar.f74489b.setText(cJRMovieDetailsTab.getmDayName());
        if (p.a(this.f74620a.f75364b, cJRMovieDetailsTab.getmDate(), true)) {
            RelativeLayout relativeLayout = awVar.f74490c;
            Context context = this.f74622c;
            if (context == null) {
                k.a();
            }
            relativeLayout.setBackground(androidx.core.content.b.a(context, R.drawable.movie_date_selector));
            TextView textView = awVar.f74488a;
            Context context2 = this.f74622c;
            if (context2 == null) {
                k.a();
            }
            textView.setTextColor(androidx.core.content.b.c(context2, R.color.white));
            TextView textView2 = awVar.f74489b;
            Context context3 = this.f74622c;
            if (context3 == null) {
                k.a();
            }
            textView2.setTextColor(androidx.core.content.b.c(context3, R.color.white));
        } else {
            RelativeLayout relativeLayout2 = awVar.f74490c;
            Context context4 = this.f74622c;
            if (context4 == null) {
                k.a();
            }
            relativeLayout2.setBackground(androidx.core.content.b.a(context4, R.drawable.movie_date_selector_default));
            TextView textView3 = awVar.f74488a;
            Context context5 = this.f74622c;
            if (context5 == null) {
                k.a();
            }
            textView3.setTextColor(androidx.core.content.b.c(context5, R.color.paytm_blue));
            TextView textView4 = awVar.f74489b;
            Context context6 = this.f74622c;
            if (context6 == null) {
                k.a();
            }
            textView4.setTextColor(androidx.core.content.b.c(context6, R.color.paytm_blue));
        }
        awVar.f74490c.setOnClickListener(new b(this, cJRMovieDetailsTab, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        this.f74622c = viewGroup.getContext();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_tab_view, (ViewGroup) null);
        k.a((Object) inflate, "view");
        return new aw(inflate);
    }

    public f(i.b bVar, a aVar) {
        k.c(bVar, "dateModel");
        k.c(aVar, "mListener");
        this.f74620a = bVar;
        this.f74621b = aVar;
    }

    public final int getItemCount() {
        return this.f74620a.f75363a.size();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f74623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMovieDetailsTab f74624b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f74625c;

        b(f fVar, CJRMovieDetailsTab cJRMovieDetailsTab, int i2) {
            this.f74623a = fVar;
            this.f74624b = cJRMovieDetailsTab;
            this.f74625c = i2;
        }

        public final void onClick(View view) {
            if (!p.a(this.f74623a.f74620a.f75364b, this.f74624b.getmDate(), true)) {
                a aVar = this.f74623a.f74621b;
                int i2 = this.f74625c;
                CJRMovieDetailsTab cJRMovieDetailsTab = this.f74624b;
                k.a((Object) cJRMovieDetailsTab, "cjrMovieDetailsTab");
                aVar.a(i2, cJRMovieDetailsTab);
            }
        }
    }
}
