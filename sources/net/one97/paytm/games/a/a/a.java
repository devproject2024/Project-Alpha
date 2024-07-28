package net.one97.paytm.games.a.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import net.one97.paytm.games.fragment.pfg.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends o {
    public final int getCount() {
        return 3;
    }

    public a(j jVar) {
        super(jVar, 1);
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0) {
            return c.a(SDKConstants.ALL_TYPE);
        }
        if (i2 != 1) {
            return c.a("BURN");
        }
        return c.a("EARN");
    }
}
