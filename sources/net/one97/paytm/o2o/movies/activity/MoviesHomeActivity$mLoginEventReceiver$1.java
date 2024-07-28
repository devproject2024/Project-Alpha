package net.one97.paytm.o2o.movies.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.z;
import io.reactivex.rxjava3.a.y;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicketResponse;
import net.one97.paytm.o2o.movies.entity.Optional;
import net.one97.paytm.o2o.movies.viewmodel.c;

public final class MoviesHomeActivity$mLoginEventReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoviesHomeActivity f74204a;

    static final class a<T> implements z<CJRBookedMovieTicketResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity$mLoginEventReceiver$1 f74205a;

        a(MoviesHomeActivity$mLoginEventReceiver$1 moviesHomeActivity$mLoginEventReceiver$1) {
            this.f74205a = moviesHomeActivity$mLoginEventReceiver$1;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRBookedMovieTicketResponse cJRBookedMovieTicketResponse = (CJRBookedMovieTicketResponse) obj;
            k.c(cJRBookedMovieTicketResponse, "upcomingBooking");
            if (cJRBookedMovieTicketResponse.getResult() != null && cJRBookedMovieTicketResponse.getResult().size() > 0) {
                this.f74205a.f74204a.f74171d = cJRBookedMovieTicketResponse.getResult();
                MoviesHomeActivity.g(this.f74205a.f74204a);
            }
        }
    }

    MoviesHomeActivity$mLoginEventReceiver$1(MoviesHomeActivity moviesHomeActivity) {
        this.f74204a = moviesHomeActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        String value;
        k.c(context, "context");
        k.c(intent, "intent");
        CJRSelectCityModel cJRSelectCityModel = this.f74204a.a().u.f75234d;
        if (!(cJRSelectCityModel == null || (value = cJRSelectCityModel.getValue()) == null)) {
            this.f74204a.a().a(value);
        }
        c a2 = this.f74204a.a();
        Context context2 = a2.f76061a;
        y<Optional<CJRBookedMovieTicketResponse>> a3 = context2 != null ? a2.a(context2) : null;
        if (a3 == null) {
            k.a();
        }
        a3.b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).c(new c.u(a2));
        this.f74204a.a().s.removeObservers(this.f74204a);
        this.f74204a.a().s.observe(this.f74204a, new a(this));
    }
}
