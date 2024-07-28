package com.alipay.mobile.nebula.filecache;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.nebula.provider.H5LoginProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SecurityUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.business.merchant_payments.common.utility.AppUtility;
import java.io.File;
import java.util.Stack;

public class FileCache {
    public static final long EXPIRE_TIME = 604800000;
    public static final String TAG = "FileCache";
    private String subPath;

    public FileCache(Context context) {
        clearExpired(context);
    }

    public FileCache(final Context context, String str) {
        H5LoginProvider h5LoginProvider = (H5LoginProvider) H5Utils.getProvider(H5LoginProvider.class.getName());
        if (h5LoginProvider != null) {
            this.subPath = str + "/" + H5SecurityUtil.getMD5(h5LoginProvider.getUserId());
        } else {
            this.subPath = str;
        }
        H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                FileCache.this.clearExpired(context);
            }
        });
    }

    public String getCachePath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = H5SecurityUtil.getSHA1(str) + AppUtility.CENTER_DOT + H5FileUtil.getExtension(str);
        String str3 = "/h5/download/cache/";
        if (!TextUtils.isEmpty(this.subPath)) {
            str3 = str3 + this.subPath + "/";
        }
        return DiskUtil.getSubDir(context, str3 + str2);
    }

    public String getCacheDir(Context context) {
        String str = "/h5/download/cache/";
        if (!TextUtils.isEmpty(this.subPath)) {
            str = str + this.subPath + "/";
        }
        return DiskUtil.getSubDir(context, str);
    }

    public String getTempPath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = H5SecurityUtil.getSHA1(str) + AppUtility.CENTER_DOT + H5FileUtil.getExtension(str);
        String str3 = "/h5/download/temp/";
        if (!TextUtils.isEmpty(this.subPath)) {
            str3 = str3 + this.subPath + "/";
        }
        String subDir = DiskUtil.getSubDir(context, str3 + str2);
        if (!H5FileUtil.exists(subDir)) {
            H5FileUtil.create(subDir);
        }
        return subDir;
    }

    public String getTempPath(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = H5SecurityUtil.getSHA1(str) + AppUtility.CENTER_DOT + str2;
        String str4 = "/h5/download/temp/";
        if (!TextUtils.isEmpty(this.subPath)) {
            str4 = str4 + this.subPath + "/";
        }
        String subDir = DiskUtil.getSubDir(context, str4 + str3);
        if (!H5FileUtil.exists(subDir)) {
            H5FileUtil.create(subDir);
        }
        return subDir;
    }

    public void clearExpired(Context context) {
        String str;
        String str2;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(this.subPath)) {
                    str = DiskUtil.getSubDir(context, "/h5/download/temp/" + this.subPath);
                } else {
                    str = DiskUtil.getSubDir(context, "/h5/download/temp");
                }
                if (H5FileUtil.exists(str)) {
                    clearPath(str);
                }
                if (!TextUtils.isEmpty(this.subPath)) {
                    str2 = DiskUtil.getSubDir(context, "/h5/download/cache/" + this.subPath);
                } else {
                    str2 = DiskUtil.getSubDir(context, "/h5/download/cache");
                }
                if (H5FileUtil.exists(str2)) {
                    clearPath(str2);
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
    }

    public void clearTempPath(Context context) {
        String str;
        if (!TextUtils.isEmpty(this.subPath)) {
            str = DiskUtil.getSubDir(context, "/h5/download/temp/" + this.subPath);
        } else {
            str = DiskUtil.getSubDir(context, "/h5/download/temp");
        }
        H5FileUtil.delete(new File(str));
    }

    private void clearPath(String str) {
        File[] listFiles;
        if (H5FileUtil.exists(str)) {
            Stack stack = new Stack();
            stack.push(str);
            long currentTimeMillis = System.currentTimeMillis();
            while (!stack.isEmpty()) {
                File file = new File((String) stack.pop());
                if (currentTimeMillis - file.lastModified() > EXPIRE_TIME) {
                    H5FileUtil.delete(file);
                } else if (!(!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0)) {
                    for (File absolutePath : listFiles) {
                        stack.push(absolutePath.getAbsolutePath());
                    }
                }
            }
        }
    }

    public String getSubPath() {
        return this.subPath;
    }

    public static boolean containCachePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("/h5/download/temp") || str.contains("/h5/download/cache")) {
            return true;
        }
        return false;
    }
}
