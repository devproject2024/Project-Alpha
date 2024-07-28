package net.one97.paytm.recharge.common.f;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f61102a;

    public static d a() {
        if (f61102a == null) {
            synchronized (d.class.getName()) {
                if (f61102a == null) {
                    f61102a = new d();
                }
            }
        }
        return f61102a;
    }

    public static void a(a aVar) {
        a();
        b(aVar);
    }

    public static IJRPaytmDataModel a(String str, Context context, IJRPaytmDataModel iJRPaytmDataModel) {
        return f.a(str, context, iJRPaytmDataModel);
    }

    public static void b(a aVar) {
        if (aVar instanceof b) {
            ((b) aVar).a();
        } else if (aVar instanceof c) {
            ((c) aVar).a();
        }
    }

    public static void a(Context context, String str) {
        a.a(context, (Object) str);
    }
}
