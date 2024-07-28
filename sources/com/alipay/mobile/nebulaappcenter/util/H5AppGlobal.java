package com.alipay.mobile.nebulaappcenter.util;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulaappcenter.app.H5App;
import com.alipay.mobile.nebulaappcenter.dbdao.H5NebulaAppDao;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class H5AppGlobal {
    public static final String INSTALL_APP_PATH = "/nebulaInstallApps/";
    public static final String OLD_APP_INSTALL_PATH = "/nebulaApps/";
    private static String TAG = "H5AppGlobal";

    public static String getInstallPath(String str) {
        try {
            return H5Utils.getContext().getFilesDir().getAbsolutePath() + str;
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }

    public static boolean hasInstallFile(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            return H5FileUtil.exists(str3);
        }
        H5App h5App = new H5App();
        h5App.setAppInfo(H5NebulaAppDao.getDao().getAppInfo(str, str2));
        return h5App.isInstalled();
    }

    public static String getFromAssets(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder(1000);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return "";
        }
    }
}
