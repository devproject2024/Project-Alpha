package net.one97.paytm.o2o.movies.moviepass.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.o2o.movies.moviepass.b.c;

public final class AJRMoviePassHomePageActivity$mMessageReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AJRMoviePassHomePageActivity f75470a;

    AJRMoviePassHomePageActivity$mMessageReceiver$1(AJRMoviePassHomePageActivity aJRMoviePassHomePageActivity) {
        this.f75470a = aJRMoviePassHomePageActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        if (this.f75470a.f75456a != null) {
            c.a b2 = AJRMoviePassHomePageActivity.b(this.f75470a);
            CJRSelectCityModel d2 = this.f75470a.f75456a;
            if (d2 == null) {
                k.a();
            }
            String value = d2.getValue();
            k.a((Object) value, "mSelectedCityModel!!.value");
            b2.a(value);
            return;
        }
        AJRMoviePassHomePageActivity.b(this.f75470a).a("");
    }
}
