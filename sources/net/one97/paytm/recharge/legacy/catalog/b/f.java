package net.one97.paytm.recharge.legacy.catalog.b;

import android.graphics.BitmapFactory;
import android.util.Base64;
import com.paytm.utility.q;

@Deprecated
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static int f62817a = -1;

    public static boolean a() {
        if (f62817a == -1) {
            byte[] decode = Base64.decode("UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA", 2);
            try {
                f62817a = BitmapFactory.decodeByteArray(decode, 0, decode.length) != null ? 1 : 0;
            } catch (Exception e2) {
                f62817a = 0;
                q.d(e2.getMessage());
            }
        }
        return f62817a == 1;
    }
}
