package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip;

import android.content.res.Resources;
import android.graphics.RectF;
import android.view.View;

public final class b {
    public static RectF a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getMeasuredWidth()), (float) (iArr[1] + view.getMeasuredHeight()));
    }

    public static float a(float f2) {
        return f2 * Resources.getSystem().getDisplayMetrics().density;
    }
}
