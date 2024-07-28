package net.one97.paytm.recharge;

import kotlin.g.b.k;
import net.one97.paytm.j.c;
import net.one97.paytm.recharge.di.d;

public final class i implements d {
    public final boolean isGTMContainerInitialized() {
        return true;
    }

    public final String getString(String str) {
        k.c(str, "key");
        c.a();
        return c.a(str, (String) null);
    }

    public final String getString(String str, String str2) {
        k.c(str, "key");
        k.c(str2, "value");
        c.a();
        String a2 = c.a(str, str2);
        k.a((Object) a2, "GTMLoader.getInstance().getString(key,value)");
        return a2;
    }

    public final boolean getBoolean(String str, boolean z) {
        k.c(str, "key");
        c.a();
        return c.a(str, z);
    }

    public final int getInteger(String str, int i2) {
        k.c(str, "key");
        c.a();
        return c.a(str, i2);
    }

    public final Integer getInteger(String str) {
        k.c(str, "key");
        c.a();
        return Integer.valueOf(c.a(str, 0));
    }

    public final String getStringFromContainer2(String str) {
        k.c(str, "key");
        c.a();
        return c.a(str, (String) null);
    }

    public final boolean getBooleanFromContainer4(String str, boolean z) {
        k.c(str, "key");
        c.a();
        return c.a(str, z);
    }

    public final String getStringFromContainer4(String str) {
        k.c(str, "key");
        c.a();
        return c.a(str, (String) null);
    }
}
