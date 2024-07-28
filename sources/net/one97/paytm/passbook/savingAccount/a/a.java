package net.one97.paytm.passbook.savingAccount.a;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import easypay.manager.Constants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.passbook.beans.SavingAccountDetailDataModel;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.upi.util.UpiConstants;

public final class a implements g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.savingAccount.a.a.a f58260a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.passbook.savingAccount.a.b.a f58261b;

    public final /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        this.f58261b.b();
        if (iJRDataModel instanceof SavingAccountDetailDataModel) {
            SavingAccountDetailDataModel savingAccountDetailDataModel = (SavingAccountDetailDataModel) iJRDataModel;
            if (TextUtils.isEmpty(savingAccountDetailDataModel.getStatus())) {
                return;
            }
            if (savingAccountDetailDataModel.getStatus().equalsIgnoreCase("SUCCESS")) {
                this.f58261b.a(savingAccountDetailDataModel);
            } else {
                this.f58261b.a(savingAccountDetailDataModel.getStatus(), savingAccountDetailDataModel.getMessage());
            }
        }
    }

    public a(net.one97.paytm.passbook.savingAccount.a.a.a aVar, net.one97.paytm.passbook.savingAccount.a.b.a aVar2) {
        this.f58260a = aVar;
        this.f58261b = aVar2;
    }

    public static net.one97.paytm.passbook.mapping.a.a a(Context context, String str, String str2, String str3, String str4, String str5, String str6, i.a<IJRDataModel> aVar, g gVar, a.c cVar, a.b bVar, String str7) {
        String str8 = str6;
        String str9 = str3;
        String k = c.k("yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd", str3);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", com.paytm.utility.a.q(context));
        hashMap.put("Content-Type", "application/json");
        HashMap hashMap2 = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap2.put(Constants.RISK_TRANSACTION_ID, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap2.put("accountId", str2.trim());
        }
        if (!TextUtils.isEmpty(k)) {
            hashMap2.put("transactionDate", k.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap2.put("txnSerialNumber", str4.trim());
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap2.put("reportCode", str5.trim());
        }
        if (str8 != null) {
            hashMap2.put(UpiConstants.EXTRA_ACCOUNT_TYPE, str8);
        }
        return new net.one97.paytm.passbook.mapping.a.a(a(d.b().a("ppb_transaction_status"), hashMap2), aVar, gVar, new SavingAccountDetailDataModel(), hashMap, cVar, bVar, str7);
    }

    private static String a(String str, HashMap<String, String> hashMap) {
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : hashMap.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (sb.length() > 1) {
                sb.append(AppConstants.AND_SIGN);
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
            } else {
                sb.append("?");
                sb.append(str2);
                sb.append("=");
                sb.append(str3);
            }
        }
        return str + sb.toString();
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f58261b.b();
        this.f58261b.a((Throwable) networkCustomError);
    }
}
