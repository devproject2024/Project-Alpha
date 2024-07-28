package net.one97.paytm.contacts.c;

import android.content.Context;
import com.paytm.network.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRAcceptTncModel;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.communicator.c;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f50123a = new a();

    private a() {
    }

    public static void a() {
        c a2 = b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        Context context = a2.getContext();
        String a3 = net.one97.paytm.paymentslimit.b.c.a(context);
        CharSequence charSequence = a3;
        boolean z = false;
        if (!(charSequence == null || p.a(charSequence))) {
            String stringFromGTM = b.a().getStringFromGTM(context, "acceptTncURL");
            CharSequence charSequence2 = stringFromGTM;
            if (charSequence2 == null || p.a(charSequence2)) {
                stringFromGTM = "https://kyc.paytmbank.com/kyc/tnc/user";
            }
            String str = stringFromGTM;
            String stringFromGTM2 = b.a().getStringFromGTM(context, "contactSyncTncConcentMode");
            CharSequence charSequence3 = stringFromGTM2;
            if (charSequence3 == null || p.a(charSequence3)) {
                stringFromGTM2 = "clickthrough";
            }
            String stringFromGTM3 = b.a().getStringFromGTM(context, "contactSyncTncConcentCode");
            CharSequence charSequence4 = stringFromGTM3;
            if (charSequence4 == null || p.a(charSequence4)) {
                z = true;
            }
            if (z) {
                stringFromGTM3 = "PhoneBook";
            }
            int integerFromGTM = b.a().getIntegerFromGTM(context, "contactSyncTncConcentVersion");
            if (integerFromGTM == 0) {
                integerFromGTM = 1;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("session_token", a3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mode", stringFromGTM2);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", stringFromGTM3);
            jSONObject2.put("version", integerFromGTM);
            jSONArray.put(jSONObject2);
            jSONObject.put("tnCList", jSONArray);
            new net.one97.paytm.network.b(str, new CJRAcceptTncModel(), (Map<String, String>) null, hashMap, jSONObject.toString(), a.C0715a.PUT, a.c.WALLET, a.b.SILENT, "PaymentsBankServerRepository").a();
        }
    }
}
