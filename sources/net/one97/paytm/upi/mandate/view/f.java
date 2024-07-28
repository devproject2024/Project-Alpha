package net.one97.paytm.upi.mandate.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import kotlin.g.b.k;

public final class f extends o {
    public final int getCount() {
        return 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(j jVar) {
        super(jVar);
        k.c(jVar, "fragmentManager");
    }

    public final Fragment getItem(int i2) {
        if (i2 == 0) {
            return new ScheduledMandateFragment();
        }
        if (i2 == 1) {
            return new ReceivedMandateFragment();
        }
        throw new IllegalArgumentException();
    }

    public final CharSequence getPageTitle(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? "" : "Received";
        }
        return "Scheduled";
    }
}
