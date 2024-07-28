package net.one97.paytm.upi.registration.presenter;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.gson.f;
import com.google.gson.u;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;

class UpiLinkedAccountPresenter$6 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f68590a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BankAccountDetails.BankAccount f68591b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g f68592c;

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        g gVar = this.f68592c;
        String str = this.f68590a;
        BankAccountDetails.BankAccount bankAccount = this.f68591b;
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
            gVar.a(arrayList, str, bankAccount);
            return;
        }
        try {
            gVar.f68658a.a(false, "");
            gVar.f68658a.a(false);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
