package com.paytmmall.a.a;

import com.paytm.utility.q;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private static String f15370a = "H5DeeplinkPlugin";

    public d() {
        super("mpOpenDeeplink", "DEBUG_MODE_CLICKED");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        if (h5Event == null || h5Event.getParams() == null || h5Event.getParams().opt("action") == null || !h5Event.getParams().opt("action").toString().equalsIgnoreCase("DEBUG_MODE_CLICKED")) {
            try {
                com.paytmmall.artifact.d.a.a().a(h5Event.getActivity(), h5Event.getParams().getString("deeplink"));
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        return super.a(h5Event, bVar);
    }
}
