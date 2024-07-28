package net.one97.paytm.o2o.movies.moviepass.b;

import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassStorefrontModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassWrapperModel;
import net.one97.paytm.o2o.movies.d.e;
import net.one97.paytm.o2o.movies.entity.CJRCinemaV1;

public interface c {

    public interface a {
        void a();

        void a(String str);

        void b(String str);

        void c(String str);

        void d(String str);
    }

    public interface b {
        void a();

        void a(String str, String str2);

        void a(CJRUpcomingMovies cJRUpcomingMovies);

        void a(CJRMoviePassStorefrontModel cJRMoviePassStorefrontModel);

        void a(CJRUserMoviePassWrapperModel cJRUserMoviePassWrapperModel);

        void a(e.b.a aVar);

        void a(CJRCinemaV1 cJRCinemaV1);

        void a(boolean z);

        void b();

        void c(String str);
    }
}
