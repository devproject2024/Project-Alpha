package net.one97.paytm.wallet.newdesign.d;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.ai;
import com.paytm.network.a;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import java.util.HashMap;
import kotlin.g.b.k;

public final class b extends ai {
    public static void a(Context context, com.paytm.network.listener.b bVar, a.c cVar, String str) {
        k.c(context, "context");
        k.c(bVar, "listener");
        k.c(cVar, "verticalId");
        try {
            String e2 = com.paytm.utility.b.e(context, str);
            HashMap hashMap = new HashMap();
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Content-Type", "application/json");
            hashMap.put("user_id", com.paytm.utility.a.a(context));
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = context;
            bVar2.f42878b = cVar;
            bVar2.f42879c = a.C0715a.POST;
            bVar2.n = a.b.SILENT;
            bVar2.o = ((Activity) context).getLocalClassName();
            bVar2.f42882f = hashMap;
            bVar2.f42880d = e2;
            bVar2.f42885i = new StringResponseModel();
            bVar2.j = bVar;
            bVar2.x = 0;
            bVar2.l().a();
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
    }
}
