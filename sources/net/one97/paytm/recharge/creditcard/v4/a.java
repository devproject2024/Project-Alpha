package net.one97.paytm.recharge.creditcard.v4;

import android.content.Context;
import android.view.View;
import java.util.Map;
import net.one97.paytm.recharge.creditcard.modal.CJRCreditCardModelV8;

public interface a {
    void a(CJRCreditCardModelV8 cJRCreditCardModelV8);

    void a(CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, Map<String, ? extends View> map, boolean z2, boolean z3);

    Context d();

    /* renamed from: net.one97.paytm.recharge.creditcard.v4.a$a  reason: collision with other inner class name */
    public static final class C1204a {
        public static /* synthetic */ void a(a aVar, CJRCreditCardModelV8 cJRCreditCardModelV8, boolean z, Map map, boolean z2, boolean z3, int i2) {
            if ((i2 & 4) != 0) {
                map = null;
            }
            aVar.a(cJRCreditCardModelV8, z, map, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? false : z3);
        }
    }
}
