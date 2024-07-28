package net.one97.paytm.acceptPayment.utils;

import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;

public final class a {
    public static com.paytm.network.a a(a.C0715a aVar, String str, IJRPaytmDataModel iJRPaytmDataModel, b bVar, Map<String, String> map, a.b bVar2, Map<String, String> map2) {
        return a(aVar, str, iJRPaytmDataModel, bVar, map, "", bVar2, map2);
    }

    public static com.paytm.network.a a(a.C0715a aVar, String str, IJRPaytmDataModel iJRPaytmDataModel, b bVar, Map<String, String> map, String str2, a.b bVar2, Map<String, String> map2) {
        return b(aVar, str, iJRPaytmDataModel, bVar, map, str2, bVar2, map2);
    }

    public static com.paytm.network.a a(a.C0715a aVar, String str, IJRPaytmDataModel iJRPaytmDataModel, b bVar, Map<String, String> map, Map<String, String> map2) {
        return b(aVar, str, iJRPaytmDataModel, bVar, map, (String) null, a.b.SILENT, map2);
    }

    private static com.paytm.network.a b(a.C0715a aVar, String str, IJRPaytmDataModel iJRPaytmDataModel, b bVar, Map<String, String> map, String str2, a.b bVar2, Map<String, String> map2) {
        return a(aVar, str, iJRPaytmDataModel, bVar, map, str2, a.c.ACCEPTPAYMENT, bVar2, map2);
    }

    private static com.paytm.network.a a(a.C0715a aVar, String str, IJRPaytmDataModel iJRPaytmDataModel, b bVar, Map<String, String> map, String str2, a.c cVar, a.b bVar2, Map<String, String> map2) {
        com.paytm.network.b a2 = a();
        a2.f42879c = aVar;
        a2.f42880d = str;
        a2.f42885i = iJRPaytmDataModel;
        a2.f42877a = net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a();
        a2.f42878b = cVar;
        a2.j = bVar;
        a2.f42884h = str2;
        a2.f42883g = null;
        a2.f42882f = map;
        a2.n = bVar2;
        a2.f42883g = map2;
        return a2.l();
    }

    private static com.paytm.network.b a() {
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = net.one97.paytm.acceptPayment.configs.a.f52046a.f52049d.a();
        bVar.f42878b = a.c.ACCEPTPAYMENT;
        bVar.n = a.b.USER_FACING;
        bVar.o = "Accept Money";
        return bVar;
    }
}
