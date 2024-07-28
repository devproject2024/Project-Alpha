package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class bh {
    public static int[] a(Context context) {
        int[] iArr = {0, 0};
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        iArr[0] = point.x;
        iArr[1] = point.y;
        if (!a(iArr)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        }
        if (!a(iArr)) {
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    private static boolean a(int[] iArr) {
        return (iArr[0] == 0 || iArr[1] == 0) ? false : true;
    }
}
