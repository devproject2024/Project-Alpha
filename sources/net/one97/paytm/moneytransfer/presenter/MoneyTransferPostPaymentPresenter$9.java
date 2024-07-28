package net.one97.paytm.moneytransfer.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.gson.f;
import com.google.gson.u;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

class MoneyTransferPostPaymentPresenter$9 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f54041a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ UpiProfileDefaultBank f54042b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f54043c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoneyTransferPostPaymentPresenter$9(d dVar, Handler handler, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        super(handler);
        this.f54043c = dVar;
        this.f54041a = str;
        this.f54042b = upiProfileDefaultBank;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        if (this.f54043c.c()) {
            d dVar = this.f54043c;
            String str = this.f54041a;
            UpiProfileDefaultBank upiProfileDefaultBank = this.f54042b;
            String string = bundle.getString("error");
            if (string == null || string.isEmpty()) {
                HashMap hashMap = (HashMap) bundle.getSerializable("credBlocks");
                ArrayList arrayList = new ArrayList();
                for (String str2 : hashMap.keySet()) {
                    try {
                        GetCredentialsResponse getCredentialsResponse = (GetCredentialsResponse) new f().a((String) hashMap.get(str2), GetCredentialsResponse.class);
                        getCredentialsResponse.setSubtype(str2);
                        arrayList.add(getCredentialsResponse);
                    } catch (u e2) {
                        e2.printStackTrace();
                    }
                }
                q.d(hashMap.toString());
                q.d(arrayList.toString());
                dVar.a(arrayList, str, upiProfileDefaultBank);
                return;
            }
            try {
                dVar.f54078a.a(false);
                dVar.f54078a.a("", "");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
