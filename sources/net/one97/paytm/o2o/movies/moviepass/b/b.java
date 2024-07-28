package net.one97.paytm.o2o.movies.moviepass.b;

import android.app.Activity;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.o2o.movies.d.e;
import net.one97.paytm.o2o.movies.entity.CJRMovieOffers;

public interface b {

    public interface a {
        void a();

        void a(String str);

        void a(String str, String str2, String str3);

        void a(String str, String str2, e.b.a aVar);

        void a(CJRRechargePayment cJRRechargePayment);

        void a(CJRMovieCart cJRMovieCart, String str, String str2);

        void a(CJRMovieCart cJRMovieCart, boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener);

        void a(CJRMovieOffers cJRMovieOffers);

        void c();

        void d();

        Activity e();
    }
}
