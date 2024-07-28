package com.paytm.network.errorlogging;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.b.i;
import com.paytm.network.j;
import com.paytm.network.model.ConnectionMatrices;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f42925a;

    public static void a(Context context, int i2, String str, String str2, String str3, long j, a.b bVar, HashMap<String, String> hashMap, a.c cVar, com.paytm.network.listener.a aVar, j jVar, Map<String, String> map) {
        b bVar2 = new b();
        final Context context2 = context;
        bVar2.f42877a = context2;
        bVar2.n = a.b.USER_FACING;
        bVar2.f42880d = "https://www.google.com";
        bVar2.o = "Network";
        bVar2.p = "networkError";
        bVar2.z = false;
        bVar2.k = false;
        bVar2.l = true;
        bVar2.u = false;
        bVar2.f42878b = a.c.BUS;
        bVar2.f42885i = new ErrorSimpleModel();
        final j jVar2 = jVar;
        final int i3 = i2;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final long j2 = j;
        final a.b bVar3 = bVar;
        final HashMap<String, String> hashMap2 = hashMap;
        final a.c cVar2 = cVar;
        AnonymousClass1 r15 = r1;
        final com.paytm.network.listener.a aVar2 = aVar;
        final Map<String, String> map2 = map;
        AnonymousClass1 r1 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                ConnectionMatrices connectionMatrices;
                if (jVar2 != null) {
                    q.d("https://www.google.com|" + iJRPaytmDataModel.getNetworkResponse().statusCode);
                    j f2 = i.f();
                    Context context = context2;
                    int i2 = i3;
                    String str = str4;
                    String str2 = str5;
                    String str3 = str6;
                    long j2 = j2;
                    a.b bVar = bVar3;
                    HashMap hashMap = hashMap2;
                    a.c cVar = cVar2;
                    com.paytm.network.listener.a aVar = aVar2;
                    if (aVar == null) {
                        connectionMatrices = null;
                    } else {
                        connectionMatrices = aVar.a();
                    }
                    ConnectionMatrices connectionMatrices2 = connectionMatrices;
                    f2.a(context, i2, str, str2, str3, j2, bVar, hashMap, cVar, connectionMatrices2, "https://www.google.com|" + iJRPaytmDataModel.getNetworkResponse().statusCode);
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                ConnectionMatrices connectionMatrices;
                int i3 = i2;
                if (jVar2 != null) {
                    q.d(networkCustomError.getUrl() + "|" + a.f42925a + "|" + i3);
                    j f2 = i.f();
                    Context context = context2;
                    String str = str4;
                    String str2 = str5;
                    String str3 = str6;
                    long j2 = j2;
                    a.b bVar = bVar3;
                    HashMap hashMap = hashMap2;
                    a.c cVar = cVar2;
                    com.paytm.network.listener.a aVar = aVar2;
                    if (aVar == null) {
                        connectionMatrices = null;
                    } else {
                        connectionMatrices = aVar.a();
                    }
                    f2.a(context, i2, str, str2, str3, j2, bVar, hashMap, cVar, connectionMatrices, "https://www.google.com|" + a.f42925a + "|" + i3);
                }
            }
        };
        bVar2.j = r15;
        bVar2.w = 30;
        bVar2.l = true;
        bVar2.x = 0;
        bVar2.f42879c = a.C0715a.GET;
        com.paytm.network.a l = bVar2.l();
        l.a((Object) "ErrorTracer");
        l.a();
    }

    public static byte a(String str, String str2) {
        q.d(str + "|" + str2);
        if ("https://www.google.com".equals(str)) {
            return 3;
        }
        return str2.contains("Exception") ? (byte) 2 : 1;
    }
}
