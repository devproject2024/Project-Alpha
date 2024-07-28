package net.one97.paytm.phoenix.util;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public b f19891a;

    public static a a(Context context, String str, com.paytm.network.listener.b bVar, Map<String, String> map, a.C0715a aVar, IJRPaytmDataModel iJRPaytmDataModel, a.c cVar, a.b bVar2, String str2) {
        k.c(context, "context");
        k.c(map, "headers");
        b a2 = new b().a(context).a(cVar).a(aVar).a(bVar2).c(context.getClass().getSimpleName()).a(str).d(str2).a(iJRPaytmDataModel).a(bVar);
        k.a((Object) a2, "networkCallBuilder");
        a2.a(map);
        if (!TextUtils.isEmpty((CharSequence) null)) {
            a2.b((String) null);
        }
        return a2.l();
    }
}
