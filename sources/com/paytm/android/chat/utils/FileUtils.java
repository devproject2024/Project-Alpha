package com.paytm.android.chat.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.business.merchant_payments.common.utility.AppUtility;
import com.sendbird.android.SendBird;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.File;
import java.text.DecimalFormat;

public class FileUtils {
    private static final String[][] MIME_MapTable = {new String[]{".3gp", "video/3gpp"}, new String[]{".apk", "application/vnd.android.package-archive"}, new String[]{".asf", "video/x-ms-asf"}, new String[]{".avi", "video/x-msvideo"}, new String[]{".bin", "application/octet-stream"}, new String[]{".bmp", "image/bmp"}, new String[]{".c", "text/plain"}, new String[]{".class", "application/octet-stream"}, new String[]{".conf", "text/plain"}, new String[]{".cpp", "text/plain"}, new String[]{".doc", "application/msword"}, new String[]{".docx", "application/msword"}, new String[]{".exe", "application/octet-stream"}, new String[]{".gif", "image/gif"}, new String[]{".gtar", "application/x-gtar"}, new String[]{".gz", "application/x-gzip"}, new String[]{".h", "text/plain"}, new String[]{".htm", "text/html"}, new String[]{".html", "text/html"}, new String[]{".jar", "application/java-archive"}, new String[]{".java", "text/plain"}, new String[]{".jpeg", "image/jpeg"}, new String[]{".JPEG", "image/jpeg"}, new String[]{".jpg", "image/jpeg"}, new String[]{".js", "application/x-javascript"}, new String[]{".log", "text/plain"}, new String[]{".m3u", "audio/x-mpegurl"}, new String[]{".m4a", "audio/mp4a-latm"}, new String[]{".m4b", "audio/mp4a-latm"}, new String[]{".m4p", "audio/mp4a-latm"}, new String[]{".m4u", "video/vnd.mpegurl"}, new String[]{".m4v", "video/x-m4v"}, new String[]{".mov", "video/quicktime"}, new String[]{".mp2", "audio/x-mpeg"}, new String[]{".mp3", "audio/x-mpeg"}, new String[]{".mp4", "video/mp4"}, new String[]{".mpc", "application/vnd.mpohun.certificate"}, new String[]{".mpe", "video/mpeg"}, new String[]{".mpeg", "video/mpeg"}, new String[]{".mpg", "video/mpeg"}, new String[]{".mpg4", "video/mp4"}, new String[]{".mpga", "audio/mpeg"}, new String[]{".msg", "application/vnd.ms-outlook"}, new String[]{".ogg", "audio/ogg"}, new String[]{".pdf", "application/pdf"}, new String[]{".png", "image/png"}, new String[]{".pps", "application/vnd.ms-powerpoint"}, new String[]{".ppt", "application/vnd.ms-powerpoint"}, new String[]{".pptx", "application/vnd.ms-powerpoint"}, new String[]{".prop", "text/plain"}, new String[]{".rar", "application/x-rar-compressed"}, new String[]{".rc", "text/plain"}, new String[]{".rmvb", "audio/x-pn-realaudio"}, new String[]{".rtf", "application/rtf"}, new String[]{".sh", "text/plain"}, new String[]{".tar", "application/x-tar"}, new String[]{".tgz", "application/x-compressed"}, new String[]{".txt", "text/plain"}, new String[]{".wav", "audio/x-wav"}, new String[]{".wma", "audio/x-ms-wma"}, new String[]{".wmv", "audio/x-ms-wmv"}, new String[]{".wps", "application/vnd.ms-works"}, new String[]{".xml", "text/plain"}, new String[]{".z", "application/x-compress"}, new String[]{".zip", "application/zip"}, new String[]{"", "*/*"}};

    public static String getCameraPath() {
        return "/payTM/image";
    }

    private FileUtils() {
    }

    public static String toReadableFileSize(long j) {
        if (j <= 0) {
            return "0KB";
        }
        double d2 = (double) j;
        int log10 = (int) (Math.log10(d2) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d2 / Math.pow(1024.0d, (double) log10)) + " " + new String[]{"B", "KB", "MB", "GB", "TB"}[log10];
    }

    public static boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static String getFormatName(String str) {
        String[] split = str.trim().split("\\.");
        return split.length >= 2 ? split[split.length - 1] : "";
    }

    public static String getPackageFilePath(String str, String str2) {
        return File.separator + str + File.separator + str2;
    }

    public static String getPackageFilePath(String str, String str2, String str3) {
        return File.separator + str + File.separator + str2 + File.separator + str3;
    }

    public static String getTempPath(Context context, String str, String str2) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2, "temp");
    }

    public static String getFilePath(Context context, String str, String str2) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2, CommunityPostActivity.TYPE_FILE);
    }

    public static String getVideoPath(Context context, String str, String str2) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2, H5ResourceHandlerUtil.VIDEO);
    }

    public static String getAudioPath(Context context, String str, String str2) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2, H5ResourceHandlerUtil.AUDIO);
    }

    public static String getIMagePath(Context context, String str, String str2) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2, H5ResourceHandlerUtil.IMAGE);
    }

    public static String getAbsCameraPath() {
        return Environment.getExternalStorageDirectory().getPath() + "/payTM/image";
    }

    public static String getTypePath(Context context, String str, String str2, String str3) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2, str3);
    }

    public static String getAllFIlePath(Context context, String str, String str2) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2);
    }

    public static String getPath(Context context, String str, String str2, String str3) {
        return "/Android/data/" + context.getPackageName() + "/cache" + getPackageFilePath(str, str2, str3);
    }

    public static void initCacheFile(Context context, String str, String str2) {
        File file = new File(getAudioPath(context, str, str2));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(getIMagePath(context, str, str2));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(getVideoPath(context, str, str2));
        if (!file3.exists()) {
            file3.mkdirs();
        }
        File file4 = new File(getFilePath(context, str, str2));
        if (!file4.exists()) {
            file4.mkdirs();
        }
        File file5 = new File(getTempPath(context, str, str2));
        if (!file5.exists()) {
            file5.mkdirs();
        }
        File file6 = new File(getAbsCameraPath());
        if (!file6.exists()) {
            file6.mkdirs();
        }
    }

    public static Uri getUriByFile(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
    }

    public static String getMIMEType(File file) {
        String lowerCase;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(AppUtility.CENTER_DOT);
        if (lastIndexOf < 0 || (lowerCase = name.substring(lastIndexOf).toLowerCase()) == null || "".equals(lowerCase)) {
            return "*/*";
        }
        String str = "*/*";
        int i2 = 0;
        while (true) {
            String[][] strArr = MIME_MapTable;
            if (i2 >= strArr.length) {
                return str;
            }
            if (lowerCase.equals(strArr[i2][0])) {
                str = MIME_MapTable[i2][1];
            }
            i2++;
        }
    }

    public static void renameFile(String str, String str2) {
        new File(str).renameTo(new File(str2));
    }

    public static boolean deleteDirectory(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        boolean z = true;
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (!listFiles[i2].isFile()) {
                z = deleteDirectory(listFiles[i2].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = deleteFile(new File(listFiles[i2].getAbsolutePath()));
                if (!z) {
                    break;
                }
            }
        }
        if (!z) {
            return false;
        }
        return file.delete();
    }

    public static boolean fileExists(File file) {
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    public static void deleteCacheFile(Context context, String str) {
        File file = new File(context.getCacheDir(), SendBird.getApplicationId());
        file.mkdirs();
        String userId = SharedPreferencesUtil.getUserId();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(TextUtils.generateMD5(userId + str));
            sb.append(".data");
            new File(file, sb.toString()).delete();
        } catch (Exception unused) {
        }
    }
}
