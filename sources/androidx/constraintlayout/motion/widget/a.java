package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.view.View;
import com.alipay.mobile.nebula.util.H5Utils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class a {
    public static void a(String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(2, stackTrace.length - 1);
        String str2 = " ";
        for (int i2 = 1; i2 <= min; i2++) {
            str2 = str2 + " ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append(".(" + stackTrace[i2].getFileName() + AppConstants.COLON + stackTrace[i2].getLineNumber() + ") " + stackTrace[i2].getMethodName());
            sb.append(str2);
        }
    }

    public static String a(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return H5Utils.NETWORK_TYPE_UNKNOWN;
        }
    }

    public static String a(Context context, int i2) {
        if (i2 == -1) {
            return H5Utils.NETWORK_TYPE_UNKNOWN;
        }
        try {
            return context.getResources().getResourceEntryName(i2);
        } catch (Exception unused) {
            return "?".concat(String.valueOf(i2));
        }
    }

    public static String a(MotionLayout motionLayout, int i2) {
        if (i2 == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(i2);
    }

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + AppConstants.COLON + stackTraceElement.getLineNumber() + ")";
    }
}
