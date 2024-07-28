package net.one97.paytm.addmoney;

import android.app.Activity;
import net.one97.paytm.wallet.d.a;
import net.one97.paytm.wallet.d.b;
import net.one97.paytm.wallet.d.c;
import net.one97.paytm.wallet.f.f;

public class AddMoneyCommunicator implements a, f {
    c addMoneyHelper;
    b walletAddMoneyHelperListener;

    public void onAddMoneyVerifyResponse(String str) {
    }

    public void onAttachToFragment(Activity activity, b bVar) {
        this.addMoneyHelper = new c();
        this.walletAddMoneyHelperListener = bVar;
        this.addMoneyHelper.a(activity, (f) this);
    }

    public void onDetachFromFragment() {
        c cVar = this.addMoneyHelper;
        if (cVar != null) {
            cVar.a();
        }
        this.addMoneyHelper = null;
        this.walletAddMoneyHelperListener = null;
    }

    public void addMoneyForInsufficientBalanceError(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        c cVar = this.addMoneyHelper;
        if (cVar != null) {
            cVar.f70165b = str;
            cVar.f70170g = z;
            cVar.f70171h = str2;
            cVar.f70172i = str3;
            cVar.j = str4;
            cVar.k = str5;
            cVar.l = str6;
            cVar.m = str7;
            cVar.n = str8;
            cVar.o = str9;
            cVar.p = str10;
            cVar.d(str);
        }
    }

    public void setIsForGiftVoucher(boolean z) {
        c cVar = this.addMoneyHelper;
        if (cVar != null) {
            cVar.q = z;
        }
    }

    public void addMoneyForInsufficientBalanceError(String str, boolean z, String str2, String str3, String str4) {
        c cVar = this.addMoneyHelper;
        if (cVar != null) {
            cVar.f70165b = str;
            cVar.f70170g = z;
            cVar.p = str2;
            cVar.r = str3;
            cVar.s = str4;
            cVar.d(str);
        }
    }

    public void addMoneyForInsufficientBalanceError(String str, boolean z, String str2) {
        c cVar = this.addMoneyHelper;
        if (cVar != null) {
            cVar.a(str, z, str2);
        }
    }

    public void onAddMoneyInvalidAmountEntered(String str) {
        b bVar = this.walletAddMoneyHelperListener;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void onAddMoneyRequestStart() {
        b bVar = this.walletAddMoneyHelperListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void onAddMoneyRequestComplete() {
        b bVar = this.walletAddMoneyHelperListener;
        if (bVar != null) {
            bVar.b();
        }
    }
}
