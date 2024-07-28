package net.one97.paytm.o2o.movies.utils;

import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.utils.SFInterface;
import java.util.HashMap;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f75896a = new a();

    private a() {
    }

    public static void a(String str, SFCallbackListener sFCallbackListener) {
        k.c(str, "url");
        k.c(sFCallbackListener, H5Event.TYPE_CALL_BACK);
        HashMap hashMap = new HashMap();
        hashMap.put("ClientId", "paytm");
        SFInterface.INSTANCE.getStoreFrontReponse(str, hashMap, a.c.MOVIES, sFCallbackListener);
    }
}
