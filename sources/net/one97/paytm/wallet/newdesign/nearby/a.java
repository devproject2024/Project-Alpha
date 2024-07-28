package net.one97.paytm.wallet.newdesign.nearby;

import com.google.gson.f;
import net.one97.paytm.wallet.newdesign.nearby.datamodals.FetchCashPointRequestModal;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f71002a;

    public static a a() {
        if (f71002a == null) {
            synchronized (a.class) {
                if (f71002a == null) {
                    f71002a = new a();
                }
            }
        }
        return f71002a;
    }

    public static JSONObject a(FetchCashPointRequestModal fetchCashPointRequestModal) {
        try {
            return new JSONObject(new f().b(fetchCashPointRequestModal));
        } catch (Exception unused) {
            return new JSONObject();
        }
    }
}
