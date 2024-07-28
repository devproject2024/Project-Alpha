package net.one97.paytm.o2o.movies.entity;

import java.util.ArrayList;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeat;

public class CJRSetSeatData {
    public final boolean isLoading;
    public final ArrayList<String> missingItem;
    public final CJRSetSeat setSeat;

    public CJRSetSeatData(CJRSetSeat cJRSetSeat, boolean z, ArrayList<String> arrayList) {
        this.setSeat = cJRSetSeat;
        this.isLoading = z;
        this.missingItem = arrayList;
    }
}
