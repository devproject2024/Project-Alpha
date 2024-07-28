package net.one97.paytm.addmoney.towallet.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.common.a;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.wallet.newdesign.addmoney.c.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f48829a = new a();

    private a() {
    }

    public static com.paytm.network.a a(Context context, String str, b bVar) {
        k.c(bVar, "listener");
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    String f2 = net.one97.paytm.helper.a.f50546a.a().f("orderdetail");
                    if (f2 == null) {
                        return null;
                    }
                    String str2 = f2 + str;
                    String str3 = com.paytm.utility.b.b(context, str2) + "&actions=1&post_payment=1";
                    a.C0848a aVar = net.one97.paytm.addmoney.common.a.f48418a;
                    return a.C0848a.a().a((IJRPaytmDataModel) new CJROrderSummary()).a(str3).a(bVar).a(context).a((Map<String, String>) null).l();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void a(Context context, c cVar) {
        k.c(context, "context");
        k.c(cVar, "listener");
        j.a(context.getApplicationContext(), cVar);
    }
}
