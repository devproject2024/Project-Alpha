package net.one97.paytm.q;

import com.google.gson.f;
import com.google.gson.u;
import com.paytm.utility.q;

public final class c {
    public static <T> T a(String str, Class<T> cls) {
        try {
            return new f().a(str, cls);
        } catch (u e2) {
            q.b(e2.getMessage());
            return null;
        } catch (Exception e3) {
            q.b(e3.getMessage());
            return null;
        }
    }
}
