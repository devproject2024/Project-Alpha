package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightReviewGst implements IJRDataModel {
    @b(a = "is_enabled")
    private boolean isEnabled;
    @b(a = "message")
    private String message;
    @b(a = "tooltip")
    private String tooltip;

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public String getTooltip() {
        return this.tooltip;
    }

    public String getMessage() {
        return this.message;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
