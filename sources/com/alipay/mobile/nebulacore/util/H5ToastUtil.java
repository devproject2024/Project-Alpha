package com.alipay.mobile.nebulacore.util;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.alipay.mobile.nebula.util.H5Log;

public class H5ToastUtil {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_IGNORED = 1;
    private static final int NOT_SUPPORTED = -1;
    public static final int OP_POST_NOTIFICATION = 11;

    public static int checkOp(Context context, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            return -1;
        }
        Object systemService = context.getSystemService("appops");
        try {
            return ((Integer) systemService.getClass().getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(systemService, new Object[]{Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue();
        } catch (Throwable th) {
            H5Log.e("SimpleToast", th.getMessage());
            return -1;
        }
    }
}
