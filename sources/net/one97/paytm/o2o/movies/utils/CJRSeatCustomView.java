package net.one97.paytm.o2o.movies.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;

public class CJRSeatCustomView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private CJRObjSeat f75885a;

    public CJRSeatCustomView(Context context) {
        super(context);
    }

    public CJRSeatCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CJRSeatCustomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setObjSeat(CJRObjSeat cJRObjSeat) {
        this.f75885a = cJRObjSeat;
    }

    public CJRObjSeat getObjSeat() {
        return this.f75885a;
    }
}
