package net.one97.paytm.appManager.c;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49041a = new a();

    private a() {
    }

    public static b a(Context context, String str, com.paytm.network.listener.b bVar, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        k.c(context, "context");
        k.c(str, "url");
        k.c(bVar, "listener");
        k.c(iJRPaytmDataModel, "model");
        k.c(map, "headers");
        b bVar2 = new b();
        bVar2.a(context);
        bVar2.a(str);
        bVar2.a(map);
        bVar2.a(iJRPaytmDataModel);
        bVar2.a(a.b.USER_FACING);
        bVar2.a(bVar);
        bVar2.c("AppManager");
        b a2 = bVar2.a(a.c.APP_MANAGER);
        k.a((Object) a2, "setVerticalId(CJRCommonN…l.VerticalId.APP_MANAGER)");
        k.a((Object) a2, "with(CJRCommonNetworkCal…Id.APP_MANAGER)\n        }");
        return a2;
    }
}
