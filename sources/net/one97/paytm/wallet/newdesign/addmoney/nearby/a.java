package net.one97.paytm.wallet.newdesign.addmoney.nearby;

import com.google.gson.f;
import net.one97.paytm.wallet.newdesign.addmoney.nearby.datamodals.FetchCashPointRequestModal;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f70683a;

    public static a a() {
        if (f70683a == null) {
            synchronized (a.class) {
                if (f70683a == null) {
                    f70683a = new a();
                }
            }
        }
        return f70683a;
    }

    public static JSONObject a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            return new JSONObject(new f().b(fetchCashPointRequestModal));
        } catch (Exception unused) {
            return new JSONObject();
        }
    }
}
