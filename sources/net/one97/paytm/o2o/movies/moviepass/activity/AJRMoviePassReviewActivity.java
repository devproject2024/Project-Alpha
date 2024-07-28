package net.one97.paytm.o2o.movies.moviepass.activity;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.u;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AppBaseActivity;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew;

public final class AJRMoviePassReviewActivity extends AppBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private CJRMoviePassModelNew f75471a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_movie_pass_review);
        Serializable serializableExtra = getIntent().getSerializableExtra("movie_pass_object");
        if (serializableExtra != null) {
            this.f75471a = (CJRMoviePassModelNew) serializableExtra;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew");
    }
}
