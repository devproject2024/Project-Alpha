package net.one97.paytm.o2o.movies.moviepass.d;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew;
import net.one97.paytm.o2o.movies.moviepass.b;
import net.one97.paytm.o2o.movies.moviepass.e.a;
import net.one97.paytm.o2o.movies.moviepass.widgets.CJRMoviePassCardView;
import net.one97.paytm.o2o.movies.utils.n;

public final class k extends j {

    /* renamed from: a  reason: collision with root package name */
    View f75547a;

    public k(View view) {
        super(view);
        this.f75547a = view;
    }

    public final void a(a aVar, final b bVar, final Context context) {
        CJRMoviePassCardView cJRMoviePassCardView = (CJRMoviePassCardView) this.f75547a.findViewById(R.id.city_movie_pass);
        final CJRMoviePassModelNew cJRMoviePassModelNew = aVar.f75571b;
        if (cJRMoviePassModelNew != null) {
            cJRMoviePassCardView.setData(n.a(cJRMoviePassModelNew, false, context));
            cJRMoviePassCardView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (cJRMoviePassModelNew.getIsOutOfStock() == 1) {
                        Toast.makeText(context, "This pass is Out of Stock. Check Back later", 0).show();
                    } else {
                        bVar.a((IJRDataModel) cJRMoviePassModelNew, view);
                    }
                }
            });
        }
    }
}
