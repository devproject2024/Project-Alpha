package com.alipay.mobile.nebula.util;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public class H5ZipUtil {
    private static final String TAG = "H5ZipUtil";

    public static boolean unZip(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        boolean z = h5ConfigProvider != null ? !TextUtils.equals(H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO, h5ConfigProvider.getConfig("h5_amrUnzipSecCheck")) : true;
        byte[] buf = H5IOUtils.getBuf(EmiUtil.EMI_PLAN_REQUEST_CODE);
        ZipInputStream zipInputStream = null;
        try {
            ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(inputStream));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!z || H5SecurityUtil.pathSecurityCheck(name)) {
                            File file = new File(str + name);
                            if (nextEntry.isDirectory()) {
                                file.mkdirs();
                            } else {
                                File parentFile = file.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    while (true) {
                                        try {
                                            int read = zipInputStream2.read(buf);
                                            if (read <= 0) {
                                                break;
                                            }
                                            fileOutputStream.write(buf, 0, read);
                                        } catch (Throwable th) {
                                            th = th;
                                            H5IOUtils.closeQuietly(fileOutputStream);
                                            throw th;
                                        }
                                    }
                                    H5IOUtils.closeQuietly(fileOutputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = null;
                                    H5IOUtils.closeQuietly(fileOutputStream);
                                    throw th;
                                }
                            }
                        } else {
                            H5Log.w(TAG, "zipEntry is illegal");
                        }
                    } else {
                        H5IOUtils.returnBuf(buf);
                        H5IOUtils.closeQuietly(zipInputStream2);
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                    zipInputStream = zipInputStream2;
                    try {
                        H5Log.e(TAG, (Throwable) e);
                        H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_UNZIP_FLOW).appendMessage("unzip failed with exception").appendExceptionName(e.getClass().getName()).appendExceptionMessage(e.getMessage()).appendExtParams("destPath", str));
                        H5IOUtils.returnBuf(buf);
                        H5IOUtils.closeQuietly(zipInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream2 = zipInputStream;
                        H5IOUtils.returnBuf(buf);
                        H5IOUtils.closeQuietly(zipInputStream2);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    H5IOUtils.returnBuf(buf);
                    H5IOUtils.closeQuietly(zipInputStream2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            H5Log.e(TAG, (Throwable) e);
            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_UNZIP_FLOW).appendMessage("unzip failed with exception").appendExceptionName(e.getClass().getName()).appendExceptionMessage(e.getMessage()).appendExtParams("destPath", str));
            H5IOUtils.returnBuf(buf);
            H5IOUtils.closeQuietly(zipInputStream);
            return false;
        }
    }

    public static boolean unZip(String str, String str2) {
        try {
            return unZip((InputStream) new FileInputStream(str), str2);
        } catch (FileNotFoundException e2) {
            H5Log.e(TAG, "exception", e2);
            H5Monitor.exception(new H5MonitorModel().exceptionType(H5MonitorModel.EXCEPTION_UNZIP_FLOW).appendMessage("unzip failed with exception").appendExceptionName(e2.getClass().getName()).appendExceptionMessage(e2.getMessage()).appendExtParams("unzipFileName", str).appendExtParams("destPath", str2));
            return false;
        }
    }
}
