package com.alipay.mobile.nebula.util;

import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public class H5FileUtil {
    private static final int IO_BUFFER_SIZE = 2048;
    public static final String TAG = "H5FileUtil";

    public static boolean create(String str) {
        return create(str, false);
    }

    public static boolean create(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_CREATE_FILE).appendMessage("path is empty"));
            return false;
        } else if (exists(str)) {
            return true;
        } else {
            mkdirs(getParent(str), z);
            try {
                return new File(str).createNewFile();
            } catch (Exception e2) {
                H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_CREATE_FILE).appendMessage("create file fail").appendExceptionName(e2.getClass().getName()).appendExceptionMessage(e2.getMessage()).appendExtParams(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, str));
                H5Log.e(TAG, "exception detail", e2);
                return false;
            }
        }
    }

    public static boolean mkdirs(String str) {
        return mkdirs(str, false);
    }

    public static boolean mkdirs(String str, boolean z) {
        File file = new File(str);
        if (exists(str) && !isFolder(str)) {
            if (!z) {
                return false;
            }
            delete(file);
        }
        try {
            file.mkdirs();
        } catch (Exception e2) {
            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_CREATE_FILE).appendMessage("create dir fail").appendExceptionName(e2.getClass().getName()).appendExceptionMessage(e2.getMessage()).appendExtParams(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, str));
            H5Log.e(TAG, "exception detail", e2);
        }
        return exists(file);
    }

    public static boolean move(String str, String str2) {
        return move(str, str2, false);
    }

    public static boolean move(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !exists(str)) {
            return false;
        }
        if (exists(str2)) {
            if (!z) {
                return false;
            }
            delete(str2);
        }
        try {
            return new File(str).renameTo(new File(str2));
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail", e2);
            return false;
        }
    }

    public static boolean delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return delete(new File(str));
    }

    public static boolean delete(File file) {
        boolean z = true;
        if (!exists(file)) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File delete : listFiles) {
            z |= delete(delete);
        }
        boolean delete2 = file.delete() | z;
        H5Log.d(TAG, "deleteFile:" + file.getAbsolutePath() + " result:" + delete2);
        return delete2;
    }

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return exists(new File(str));
    }

    public static boolean exists(File file) {
        return file != null && file.exists();
    }

    public static String getParent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getParent(new File(cleanPath(str)));
    }

    public static String getParent(File file) {
        if (file == null) {
            return null;
        }
        return file.getParent();
    }

    public static boolean childOf(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String cleanPath = cleanPath(str);
        String cleanPath2 = cleanPath(str2);
        return cleanPath.startsWith(cleanPath2 + File.separator);
    }

    public static int childCount(String str) {
        File[] listFiles;
        if (!exists(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
            return 0;
        }
        return listFiles.length;
    }

    public static String cleanPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return new File(str).getCanonicalPath();
        } catch (Exception e2) {
            H5Log.e(TAG, "Exception", e2);
            return str;
        }
    }

    public static long size(String str) {
        if (str == null) {
            return 0;
        }
        return size(new File(str));
    }

    public static long size(File file) {
        long j = 0;
        if (!exists(file)) {
            return 0;
        }
        if (isFile(file)) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File size : listFiles) {
                j += size(size);
            }
        }
        return j;
    }

    public static boolean copy(String str, String str2) {
        return copy(str, str2, false);
    }

    public static boolean copy(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.equals(str2)) {
                return true;
            }
            if (exists(str) && isFile(str)) {
                if (exists(str2)) {
                    if (!z) {
                        return false;
                    }
                    delete(str2);
                }
                if (!create(str2)) {
                    return false;
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    byte[] buf = H5IOUtils.getBuf(2048);
                    while (true) {
                        try {
                            int read = fileInputStream.read(buf);
                            if (read != -1) {
                                fileOutputStream.write(buf, 0, read);
                            } else {
                                fileOutputStream.flush();
                                return true;
                            }
                        } catch (Exception e2) {
                            H5Log.e(TAG, "exception detail", e2);
                            return false;
                        } finally {
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(fileInputStream);
                            H5IOUtils.closeQuietly(fileOutputStream);
                        }
                    }
                } catch (Exception e3) {
                    H5Log.e(TAG, "exception detail", e3);
                }
            }
        }
        return false;
    }

    public static String fileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(cleanPath(str)).getName();
    }

    public static String getExtension(File file) {
        if (file == null) {
            return null;
        }
        return getExtension(file.getName());
    }

    public static String getFileExtensionFromUrl(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
            return fileExtensionFromUrl;
        }
        String extension = getExtension(str);
        if (TextUtils.isEmpty(extension) || !MimeTypeMap.getSingleton().hasExtension(extension.toLowerCase())) {
            return null;
        }
        return extension;
    }

    @Deprecated
    public static String getExtension(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
            return str.substring(lastIndexOf + 1);
        }
        return "";
    }

    public static String getMimeType(File file) {
        if (file == null) {
            return "*/*";
        }
        return getMimeType(file.getName());
    }

    public static String getMimeType(String str) {
        String fileExtensionFromUrl = getFileExtensionFromUrl(str);
        if ("js".equalsIgnoreCase(fileExtensionFromUrl)) {
            return "application/javascript";
        }
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public static String getExtensionFromMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public static boolean isFile(String str) {
        if (!exists(str)) {
            return false;
        }
        return isFile(new File(str));
    }

    public static boolean isFile(File file) {
        return file != null && file.isFile();
    }

    public static boolean isFolder(String str) {
        if (!exists(str)) {
            return false;
        }
        return new File(str).isDirectory();
    }

    public static String getFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        return (lastIndexOf <= 0 || lastIndexOf >= str.length() + -1) ? str : str.substring(lastIndexOf + 1, str.length());
    }

    public static String getFileStem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(AppUtility.CENTER_DOT);
        return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : "";
    }

    public static String getFileSHA1(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e2) {
            H5Log.e(TAG, "exception detail.", e2);
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        byte[] buf = H5IOUtils.getBuf(2048);
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            while (true) {
                int read = fileInputStream.read(buf);
                if (read <= 0) {
                    break;
                }
                instance.update(buf, 0, read);
            }
            str2 = H5SecurityUtil.bytes2Hex(instance.digest());
        } catch (Exception e3) {
            H5Log.e(TAG, "exception detail", e3);
        } catch (Throwable th) {
            H5IOUtils.returnBuf(buf);
            H5IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
        H5IOUtils.returnBuf(buf);
        H5IOUtils.closeQuietly(fileInputStream);
        return !TextUtils.isEmpty(str2) ? str2.trim() : str2;
    }

    public static String getFileMD5(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e2) {
            H5Log.e(TAG, "exception detail.", e2);
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        byte[] buf = H5IOUtils.getBuf(2048);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(buf);
                if (read <= 0) {
                    break;
                }
                instance.update(buf, 0, read);
            }
            str2 = H5SecurityUtil.bytes2Hex(instance.digest());
        } catch (Exception e3) {
            H5Log.e(TAG, "exception detail", e3);
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                H5Log.e(TAG, "IOException", e4);
            }
        } catch (Throwable th) {
            H5IOUtils.returnBuf(buf);
            H5IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
        H5IOUtils.returnBuf(buf);
        H5IOUtils.closeQuietly(fileInputStream);
        return !TextUtils.isEmpty(str2) ? str2.trim() : str2;
    }

    public static String getText(String str) {
        BufferedInputStream bufferedInputStream;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        if (!exists(str)) {
            return null;
        }
        File file = new File(str);
        int length = (int) file.length();
        if (length > 20480) {
            return null;
        }
        byte[] buf = H5IOUtils.getBuf(TarConstants.EOF_BLOCK);
        try {
            poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(length);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream.read(buf);
                        if (-1 != read) {
                            poolingByteArrayOutputStream.write(buf, 0, read);
                        } else {
                            String byteArrayOutputStream = poolingByteArrayOutputStream.toString();
                            H5IOUtils.getByteArrayPool().returnBuf(buf);
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                            H5IOUtils.closeQuietly(bufferedInputStream);
                            return byteArrayOutputStream;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            H5Log.e(TAG, "exception detail", e);
                            H5IOUtils.getByteArrayPool().returnBuf(buf);
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                            H5IOUtils.closeQuietly(bufferedInputStream);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            H5IOUtils.getByteArrayPool().returnBuf(buf);
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                            H5IOUtils.closeQuietly(bufferedInputStream);
                            throw th;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
                H5Log.e(TAG, "exception detail", e);
                H5IOUtils.getByteArrayPool().returnBuf(buf);
                H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                H5IOUtils.closeQuietly(bufferedInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                H5IOUtils.getByteArrayPool().returnBuf(buf);
                H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                H5IOUtils.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream = null;
            poolingByteArrayOutputStream = null;
            H5Log.e(TAG, "exception detail", e);
            H5IOUtils.getByteArrayPool().returnBuf(buf);
            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
            H5IOUtils.closeQuietly(bufferedInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            poolingByteArrayOutputStream = null;
            H5IOUtils.getByteArrayPool().returnBuf(buf);
            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
            H5IOUtils.closeQuietly(bufferedInputStream);
            throw th;
        }
    }

    public static final String read(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                str2 = read((InputStream) fileInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    H5Log.e(TAG, "Exception", e);
                    H5IOUtils.closeQuietly(fileInputStream);
                    return str2;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            H5Log.e(TAG, "Exception", e);
            H5IOUtils.closeQuietly(fileInputStream);
            return str2;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            H5IOUtils.closeQuietly(fileInputStream);
            throw th;
        }
        H5IOUtils.closeQuietly(fileInputStream);
        return str2;
    }

    public static final String read(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[2048];
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, AppConstants.UTF_8);
            while (true) {
                int read = inputStreamReader.read(cArr, 0, 2048);
                if (read < 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e2) {
            H5Log.e(TAG, "Exception", e2);
        }
        return sb.toString();
    }

    public static String getLastModified(String str) {
        if (!exists(str)) {
            return null;
        }
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(new File(str).lastModified()));
    }

    public static long getCreateTime(String str) {
        if (!exists(str)) {
            return 0;
        }
        return new Date(new File(str).lastModified()).getTime();
    }

    public static boolean copyFile(File file, File file2) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            boolean copyToFile = copyToFile(fileInputStream, file2);
            fileInputStream.close();
            return copyToFile;
        } catch (IOException e2) {
            H5Log.e(TAG, (Throwable) e2);
            return false;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[SYNTHETIC, Splitter:B:33:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005c A[SYNTHETIC, Splitter:B:37:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyToFile(java.io.FileInputStream r8, java.io.File r9) {
        /*
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x000a
            r9.delete()
            goto L_0x0017
        L_0x000a:
            java.io.File r0 = r9.getParentFile()
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0017
            r0.mkdirs()
        L_0x0017:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004b }
            r1.<init>(r9)     // Catch:{ Exception -> 0x004b }
            java.nio.channels.FileChannel r9 = r1.getChannel()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.nio.channels.FileChannel r8 = r8.getChannel()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r3 = 0
            long r5 = r8.size()     // Catch:{ all -> 0x003b }
            r2 = r8
            r7 = r9
            r2.transferTo(r3, r5, r7)     // Catch:{ all -> 0x003b }
            r9.close()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r8.close()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r1.close()     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            r8 = 1
            return r8
        L_0x003b:
            r0 = move-exception
            r9.close()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r8.close()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            throw r0     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
        L_0x0043:
            r8 = move-exception
            goto L_0x005a
        L_0x0045:
            r8 = move-exception
            r0 = r1
            goto L_0x004c
        L_0x0048:
            r8 = move-exception
            r1 = r0
            goto L_0x005a
        L_0x004b:
            r8 = move-exception
        L_0x004c:
            java.lang.String r9 = "FileUtils"
            java.lang.String r1 = "copy file error!"
            com.alipay.mobile.nebula.util.H5Log.e(r9, r1, r8)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            r8 = 0
            return r8
        L_0x005a:
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5FileUtil.copyToFile(java.io.FileInputStream, java.io.File):boolean");
    }

    public static boolean copyToFile(InputStream inputStream, File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = null;
            byte[] buf = H5IOUtils.getBuf(4096);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(buf);
                        if (read >= 0) {
                            fileOutputStream2.write(buf, 0, read);
                        } else {
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(fileOutputStream2);
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        H5IOUtils.returnBuf(buf);
                        H5IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                H5IOUtils.returnBuf(buf);
                H5IOUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            H5Log.e(TAG, (Throwable) e2);
            return false;
        }
    }

    public static String getSDPath() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return Environment.getExternalStorageDirectory().getPath();
            }
            return null;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return null;
        }
    }
}
