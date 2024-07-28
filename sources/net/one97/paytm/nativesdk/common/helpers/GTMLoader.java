package net.one97.paytm.nativesdk.common.helpers;

import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.DirectPaymentBL;

public final class GTMLoader {
    public static final GTMLoader INSTANCE = new GTMLoader();

    private GTMLoader() {
    }

    public static final String getString(String str) {
        k.c(str, "key");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        HashMap<String, Object> gtmStringValues = instance.getGtmStringValues();
        return (String) (gtmStringValues != null ? gtmStringValues.get(str) : null);
    }

    public static final Integer getInt(String str) {
        k.c(str, "key");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        HashMap<String, Object> gtmStringValues = instance.getGtmStringValues();
        return (Integer) (gtmStringValues != null ? gtmStringValues.get(str) : null);
    }

    public static final boolean getBoolean(String str, boolean z) {
        Object obj;
        k.c(str, "key");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        HashMap<String, Object> gtmStringValues = instance.getGtmStringValues();
        if (gtmStringValues == null || (obj = gtmStringValues.get(str)) == null) {
            return z;
        }
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        throw new u("null cannot be cast to non-null type kotlin.Boolean");
    }
}
