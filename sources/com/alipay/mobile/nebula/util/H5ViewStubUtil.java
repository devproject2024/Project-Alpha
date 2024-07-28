package com.alipay.mobile.nebula.util;

import android.view.View;
import android.view.ViewStub;

public class H5ViewStubUtil {
    public static <T> T getView(View view, int i2, int i3) {
        ViewStub viewStub = (ViewStub) view.findViewById(i2);
        if (viewStub != null) {
            return viewStub.inflate();
        }
        return view.findViewById(i3);
    }

    public static boolean isViewVisible(View view, int i2, int i3) {
        View findViewById;
        if (((ViewStub) view.findViewById(i2)) == null && (findViewById = view.findViewById(i3)) != null && findViewById.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static void setViewVisibility(View view, int i2, int i3, int i4) {
        if (view != null) {
            if (view.findViewById(i2) == null) {
                View findViewById = view.findViewById(i3);
                if (findViewById != null) {
                    findViewById.setVisibility(i4);
                }
            } else if (i4 == 0) {
                ((ViewStub) view.findViewById(i2)).inflate().setVisibility(i4);
            }
        }
    }
}
