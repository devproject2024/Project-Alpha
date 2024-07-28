package com.travel.citybus.best.b;

import com.travel.citybus.best.model.BestEPurse;

public interface b {
    void onApiError();

    void onOrderSummaryReceived(BestEPurse bestEPurse);
}
