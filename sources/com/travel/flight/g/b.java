package com.travel.flight.g;

import com.paytm.network.model.NetworkCustomError;
import net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse;

public interface b {
    void a(NetworkCustomError networkCustomError);

    void a(IJRPriorityCheckinResponse iJRPriorityCheckinResponse);
}
