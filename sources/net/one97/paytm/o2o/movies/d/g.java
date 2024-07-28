package net.one97.paytm.o2o.movies.d;

import android.app.ProgressDialog;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;

public interface g {
    void a(String str);

    void a(String str, String str2, String str3);

    void a(CJRMovieCart cJRMovieCart, boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, ProgressDialog progressDialog);

    void b();
}
