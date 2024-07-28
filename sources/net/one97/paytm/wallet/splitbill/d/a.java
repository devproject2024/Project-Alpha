package net.one97.paytm.wallet.splitbill.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.z;
import java.util.HashMap;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.utils.DelegateUtil;
import net.one97.paytm.wallet.splitbill.b.c;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementBaseResponse;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f72228c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f72229a;

    /* renamed from: b  reason: collision with root package name */
    public C1463a f72230b;

    /* renamed from: net.one97.paytm.wallet.splitbill.d.a$a  reason: collision with other inner class name */
    public enum C1463a {
        FIRST_TIME,
        NO_DATA,
        DATA
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f72228c == null) {
                f72228c = new a(context);
            }
            aVar = f72228c;
        }
        return aVar;
    }

    private a(Context context) {
        this.f72229a = context;
    }

    public final void a(c cVar) {
        b(cVar);
    }

    private void b(c cVar) {
        String str;
        if (!TextUtils.isEmpty(b.a().getStringFromGTM(this.f72229a, "getUserSettlementUrl"))) {
            str = b.a().getStringFromGTM(this.f72229a, "getUserSettlementUrl") + "?limit=10&offset=0";
        } else {
            str = "https://prms.paytmbank.com/prms/ext/v1/user/expenses?limit=10&offset=0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", com.paytm.utility.a.q(this.f72229a));
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        new net.one97.paytm.network.a(str, new SBUserSettlementBaseResponse(), hashMap, hashMap2).c().observeForever(new z(cVar) {
            private final /* synthetic */ c f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                a.this.a(this.f$1, (f) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(c cVar, f fVar) {
        if (fVar.f55796a == h.SUCCESS) {
            if (fVar.f55797b instanceof SBUserSettlementBaseResponse) {
                SBUserSettlementBaseResponse sBUserSettlementBaseResponse = (SBUserSettlementBaseResponse) fVar.f55797b;
                if (sBUserSettlementBaseResponse.getResponse() == null) {
                    this.f72230b = C1463a.FIRST_TIME;
                } else if (sBUserSettlementBaseResponse.getResponse().getUserSnapShotPojos() == null || sBUserSettlementBaseResponse.getResponse().getUserSnapShotPojos().size() == 0) {
                    this.f72230b = C1463a.NO_DATA;
                    DelegateUtil.INSTANCE.writeObjectToFile(this.f72229a, sBUserSettlementBaseResponse, "user_settlement_data");
                } else {
                    this.f72230b = C1463a.DATA;
                    DelegateUtil.INSTANCE.writeObjectToFile(this.f72229a, sBUserSettlementBaseResponse, "user_settlement_data");
                }
                cVar.onInitSuccessful();
            }
        } else if (fVar.f55796a == h.ERROR) {
            g gVar = fVar.f55798c;
            if (gVar == null || !(gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                this.f72230b = C1463a.FIRST_TIME;
                cVar.onInitSuccessful();
                return;
            }
            b.a().handleError((Activity) this.f72229a, gVar.f55801c, a.class.getName(), (Bundle) null, false);
        }
    }
}
