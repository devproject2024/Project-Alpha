package net.one97.paytm.acceptPayment.e;

import com.business.common_module.b.f;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.configs.a;

public final class e implements f {
    public final boolean getBoolean(String str, boolean z) {
        k.d(str, "key");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        return a2.b().a(str, z);
    }

    public final boolean getConsumerBoolean(String str, boolean z) {
        k.d(str, "key");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        return a2.b().a(str, z);
    }

    public final int getConsumerInt(String str, int i2) {
        k.d(str, "key");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        return a2.b().b(str);
    }

    public final long getConsumerLong(String str, long j) {
        k.d(str, "key");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        return a2.b().c(str);
    }

    public final String getConsumerString(String str, String str2) {
        k.d(str, "key");
        k.d(str2, "defaultValue");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        String a3 = a2.b().a(str);
        k.b(a3, "AcceptPaymentsConfig.get…istener.getStringGTM(key)");
        return a3;
    }

    public final int getInt(String str, int i2) {
        k.d(str, "key");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        return a2.b().b(str);
    }

    public final long getLong(String str, long j) {
        k.d(str, "key");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        return a2.b().c(str);
    }

    public final String getString(String str, String str2) {
        k.d(str, "key");
        k.d(str2, "defaultValue");
        a a2 = a.a();
        k.b(a2, "AcceptPaymentsConfig.getInstance()");
        String a3 = a2.b().a(str);
        k.b(a3, "AcceptPaymentsConfig.get…istener.getStringGTM(key)");
        return a3;
    }
}
