package net.one97.paytm.moneytransfer.presenter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.gson.f;
import com.google.gson.u;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.GetCredentialsResponse;

class MoneyTransferBeneficiaryPresenter$7 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f54036a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BankAccountDetails.BankAccount f54037b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b f54038c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoneyTransferBeneficiaryPresenter$7(b bVar, Handler handler, String str, BankAccountDetails.BankAccount bankAccount) {
        super(handler);
        this.f54038c = bVar;
        this.f54036a = str;
        this.f54037b = bankAccount;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        b bVar = this.f54038c;
        String str = this.f54036a;
        BankAccountDetails.BankAccount bankAccount = this.f54037b;
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
            bVar.a((List<GetCredentialsResponse>) arrayList, str, bankAccount);
            return;
        }
        try {
            bVar.f54050a.d();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
