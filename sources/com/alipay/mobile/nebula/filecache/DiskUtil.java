package com.alipay.mobile.nebula.filecache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import java.io.File;

public class DiskUtil {
    public static final String TAG = "DiskUtil";

    public static String getAppDir(Context context) {
        File filesDir = context.getFilesDir();
        if (H5FileUtil.exists(filesDir)) {
            return filesDir.getParent();
        }
        return null;
    }

    public static String getSubDir(Context context, String str) {
        String appDir = getAppDir(context);
        if (TextUtils.isEmpty(appDir)) {
            return null;
        }
        return appDir + "/" + str;
    }

    public static boolean mediaMounted() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return false;
        }
    }
}
