package net.one97.paytm.upi.requestmoney.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.gson.f;
import com.google.gson.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;

class RequestMoneyV2Presenter$4 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f69169a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ UpiProfileDefaultBank f69170b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f69171c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RequestMoneyV2Presenter$4(d dVar, Handler handler, String str, UpiProfileDefaultBank upiProfileDefaultBank) {
        super(handler);
        this.f69171c = dVar;
        this.f69169a = str;
        this.f69170b = upiProfileDefaultBank;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        d dVar = this.f69171c;
        String str = this.f69169a;
        UpiProfileDefaultBank upiProfileDefaultBank = this.f69170b;
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
            upiProfileDefaultBank.setDebitBank(upiProfileDefaultBank.getCreditBank());
            dVar.a((List<GetCredentialsResponse>) arrayList, str, upiProfileDefaultBank);
            return;
        }
        try {
            dVar.f69188c.a(false, (RequestMoneyV2Activity.b) null);
            dVar.f69188c.a("", "", "");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
