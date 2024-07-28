package net.one97.paytm.utils;

import com.google.gson.f;
import com.paytm.utility.q;
import java.lang.reflect.Type;

public final class ak {
    public static <T> Object a(String str, Type type) {
        try {
            return new f().a(str, type);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }
}
