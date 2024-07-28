package net.one97.paytm.o2o.movies.common.c;

import android.app.Activity;
import java.util.Map;

public abstract class c implements a {
    public static c mInstance;
    private Map<String, Class<? extends Activity>> paytmActivityMap;

    public abstract Map<String, String> getConstantMap();

    public abstract Map<String, Class<? extends Activity>> getPaytmActivityMap();

    protected c() {
    }

    public static c getInstance() {
        c cVar = mInstance;
        if (cVar != null) {
            return cVar;
        }
        throw new RuntimeException("getInstance() called before initMovieLib()");
    }
}
