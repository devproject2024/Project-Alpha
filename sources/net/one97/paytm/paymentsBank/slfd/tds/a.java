package net.one97.paytm.paymentsBank.slfd.tds;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.b;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.paymentsBank.slfd.tds.modal.CertificateResponseModal;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f19339a;

    /* renamed from: b  reason: collision with root package name */
    private Context f19340b;

    private a(Context context) {
        this.f19340b = context;
    }

    public static a a(Context context) {
        if (f19339a == null) {
            synchronized (a.class) {
                f19339a = new a(context);
            }
        }
        return f19339a;
    }

    public final void a(String str, String str2, g.b bVar, g.a aVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        hashMap.put("authorization", com.paytm.utility.a.q(this.f19340b));
        hashMap.put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("financial_year", str);
            jSONObject.put("quarter", str2);
        } catch (JSONException unused) {
        }
        d.b();
        b bVar2 = new b(d.a("fdTdsCertificate"), bVar, aVar, new CertificateResponseModal(), hashMap, jSONObject.toString(), a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap2);
        this.f19340b.getApplicationContext();
        new c();
        c.a(bVar2);
    }

    public final void a(String str, g.b bVar, g.a aVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", getClass().getSimpleName());
        hashMap.put("authorization", com.paytm.utility.a.q(this.f19340b));
        hashMap.put("Content-Type", "application/json");
        d.b();
        String a2 = d.a("fdInterestCertificate");
        net.one97.paytm.bankCommon.g.a aVar2 = new net.one97.paytm.bankCommon.g.a(a2 + "?financial_year=" + str, bVar, aVar, (IJRPaytmDataModel) new CertificateResponseModal(), (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2, 0);
        this.f19340b.getApplicationContext();
        new c();
        c.a(aVar2);
    }
}
