package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.b;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0309a f18227a = new C0309a((byte) 0);

    /* renamed from: net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.a$a  reason: collision with other inner class name */
    public static final class C0309a {
        private C0309a() {
        }

        public /* synthetic */ C0309a(byte b2) {
            this();
        }

        public final void a(Context context, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
            String str3 = str;
            String str4 = str2;
            Context context2 = context;
            k.c(context, "context");
            k.c(str3, "bankScopeToken");
            k.c(str4, "amount");
            k.c(bVar, "listener");
            k.c(aVar, "errorListener");
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            hashMap2.put("screen_name", simpleName);
            Map map = hashMap;
            map.put("Content-Type", "application/json");
            map.put("ssotoken", str3);
            k.a((Object) d.b(), "PBGTMHelper.getInstance()");
            String C = d.C();
            StringBuilder sb = new StringBuilder("");
            if (TextUtils.isEmpty(C)) {
                sb.append("https://bankfulfillment-ite.paytmbank.com/qrcode/ext/v1/generate");
            } else {
                sb.append(C);
            }
            sb.append("?amount=");
            sb.append(str4);
            b bVar2 = new b(sb.toString(), bVar, aVar, new QRCodeResponse(), map, (String) null, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
            context.getApplicationContext();
            c.a();
            c.a(bVar2);
        }
    }
}
