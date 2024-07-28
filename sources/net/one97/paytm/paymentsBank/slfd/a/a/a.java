package net.one97.paytm.paymentsBank.slfd.a.a;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBTncData;
import org.json.JSONArray;

public interface a {
    void a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str);

    void a(String str, Double d2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void a(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void a(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void a(g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, int i2);

    void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2);

    void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, String str3);

    void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, boolean z, String str3);

    void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, ArrayList<PBTncData> arrayList);

    void a(JSONArray jSONArray, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void b(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void b(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void b(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void b(g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void c(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void c(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void c(g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void d(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void d(g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void e(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void e(g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void f(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void f(g.b<IJRPaytmDataModel> bVar, g.a aVar);

    void g(g.b<IJRPaytmDataModel> bVar, g.a aVar);
}
