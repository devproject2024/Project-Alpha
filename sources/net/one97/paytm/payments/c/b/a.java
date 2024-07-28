package net.one97.paytm.payments.c.b;

import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.utils.e;
import org.json.JSONObject;

public final class a {
    public static final a INSTANCE = new a();

    private a() {
    }

    public final Object isHandledByBank(Context context, int i2, int i3, Intent intent) {
        k.c(context, "context");
        boolean z = false;
        switch (i2) {
            case 6130:
                if (intent != null) {
                    return intent.getStringExtra("passcode");
                }
                return "";
            case 6131:
                return intent != null ? Boolean.valueOf(intent.getBooleanExtra("isPassCodeSet", false)) : Boolean.FALSE;
            case 6132:
                JSONObject jSONObject = new JSONObject();
                if (i3 == -1) {
                    if (intent != null) {
                        z = intent.getBooleanExtra("loginStatus", false);
                    }
                    if (z) {
                        jSONObject.put("loginStatus", z);
                        e.a aVar = e.f16328a;
                        jSONObject.put("bankScopeToken", e.a.a(context));
                    } else {
                        jSONObject.put("loginStatus", z);
                        jSONObject.put("bankScopeToken", "");
                    }
                }
                return jSONObject;
            default:
                return null;
        }
    }
}
