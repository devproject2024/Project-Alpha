package net.one97.paytm.addmoney.utils;

import android.content.Context;
import com.paytm.utility.b;
import net.one97.paytm.helper.a;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public Context f49000a;

    public p(Context context) {
        this.f49000a = context;
    }

    public final String a() {
        try {
            StringBuilder sb = new StringBuilder(a.b().f("paymentCombinations"));
            int indexOf = sb.indexOf("{userID}");
            sb.replace(indexOf, indexOf + 8, b.n(this.f49000a));
            sb.append("?nonDefaultBankAccounts=true");
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
