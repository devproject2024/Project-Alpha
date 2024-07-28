package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.utils.ae;

public class AppBaseActivity extends PaytmActivity {
    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }

    public void attachBaseContext(Context context) {
        if (b.f75032a == null) {
            new ae();
            Class[] clsArr = new Class[0];
            try {
                Class<?> cls = Class.forName("net.one97.paytm.dynamic.module.movie.MovieInitActivity");
                cls.getDeclaredMethod("initialize", clsArr).invoke(cls.newInstance(), (Object[]) null);
            } catch (Exception unused) {
            }
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(b.f75032a.f75033b.getBaseContext(context));
        }
        a.a((Context) this);
        a.b((Context) this);
    }
}
