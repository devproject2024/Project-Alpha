package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.p;

public final class as extends p {
    public as(Context context) {
        super(context);
    }

    public final int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
        return (i4 + ((i5 - i4) / 2)) - (i2 + ((i3 - i2) / 2));
    }

    public final PointF computeScrollVectorForPosition(int i2) {
        return super.computeScrollVectorForPosition(i2);
    }

    public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}
