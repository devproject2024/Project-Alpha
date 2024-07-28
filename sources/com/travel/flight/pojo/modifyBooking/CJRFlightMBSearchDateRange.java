package com.travel.flight.pojo.modifyBooking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CJRFlightMBSearchDateRange extends IJRPaytmDataModel {
    @b(a = "end")
    private String end;
    @b(a = "start")
    private String start;

    public CJRFlightMBSearchDateRange() {
        this((String) null, (String) null, 3, (g) null);
    }

    public final String getStart() {
        return this.start;
    }

    public final void setStart(String str) {
        this.start = str;
    }

    public CJRFlightMBSearchDateRange(String str, String str2) {
        this.start = str;
        this.end = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRFlightMBSearchDateRange(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getEnd() {
        return this.end;
    }

    public final void setEnd(String str) {
        this.end = str;
    }
}
