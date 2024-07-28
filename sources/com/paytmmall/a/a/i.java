package com.paytmmall.a.a;

import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;

public final class i extends a {
    public i() {
        super("mpMystore", "H5_MYSTORE_SHARE", "IS_APP_PRESENT");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        String.valueOf(h5Event.getParams().opt("action"));
        return super.a(h5Event, bVar);
    }
}
