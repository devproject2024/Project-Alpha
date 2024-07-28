package com.alipay.mobile.nebula.wallet;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alipay.mobile.framework.a;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.framework.c;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.H5BaseApp;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.provider.H5ThreadPoolProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.tar.TarEntry;
import com.alipay.mobile.nebula.util.tar.TarInputStream;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public class H5WalletWrapper {
    public static final String HPM_FILE_NAME = "hpmfile.json";
    public static final String TAG = "H5WalletWrapper";

    public static Resources getNebulaResources() {
        b.a().b();
        return a.a();
    }

    public static Resources getNebulaBizResources() {
        b.a().b();
        return a.a();
    }

    public static Resources getNebulaCoreResources() {
        b.a().b();
        return a.a();
    }

    public static Class<?> getClass(String str, String str2) {
        return getClass(str, str2, false);
    }

    public static Class<?> getClass(String str, String str2, boolean z) {
        H5Log.d("H5WalletWrapper", "getClass " + str + AppConstants.COLON + str2);
        try {
            b.a().b();
            ClassLoader b2 = a.b();
            if (b2 != null) {
                return b2.loadClass(str2);
            }
            return null;
        } catch (Throwable th) {
            if (z) {
                return null;
            }
            H5Log.e("H5WalletWrapper", "failed to load class bundle.", th);
            return null;
        }
    }

    public static final <T> T findServiceByInterface(String str) {
        b.a();
        return c.a(str);
    }

    public static String getHpmFile(String str, String str2) {
        H5AppCenterService h5AppCenterService;
        TarInputStream tarInputStream;
        byte[] bArr;
        TarInputStream tarInputStream2;
        TarEntry nextEntry;
        byte[] bArr2 = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (h5AppCenterService = (H5AppCenterService) findServiceByInterface(H5AppCenterService.class.getName())) != null) {
            H5BaseApp h5App = h5AppCenterService.getH5App();
            AppInfo appInfo = new AppInfo();
            appInfo.app_id = str;
            appInfo.version = str2;
            String installedPath = h5App.getInstalledPath();
            try {
                if (!H5FileUtil.exists(new File(installedPath))) {
                    H5Log.e("H5WalletWrapper", "getHPMFileConfig path" + installedPath + " not exist, return");
                    H5IOUtils.returnBuf((byte[]) null);
                    H5IOUtils.closeQuietly((Closeable) null);
                    return null;
                }
                tarInputStream = new TarInputStream(new BufferedInputStream(new FileInputStream(new File(installedPath))));
                try {
                    byte[] buf = H5IOUtils.getBuf(EmiUtil.EMI_PLAN_REQUEST_CODE);
                    do {
                        try {
                            nextEntry = tarInputStream.getNextEntry();
                            if (nextEntry == null) {
                                H5IOUtils.returnBuf(buf);
                                H5IOUtils.closeQuietly(tarInputStream);
                            }
                        } catch (Exception e2) {
                            TarInputStream tarInputStream3 = tarInputStream;
                            bArr = buf;
                            e = e2;
                            tarInputStream2 = tarInputStream3;
                            try {
                                H5Log.e("H5WalletWrapper", (Throwable) e);
                                H5IOUtils.returnBuf(bArr);
                                H5IOUtils.closeQuietly(tarInputStream2);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                bArr2 = bArr;
                                tarInputStream = tarInputStream2;
                                H5IOUtils.returnBuf(bArr2);
                                H5IOUtils.closeQuietly(tarInputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            bArr2 = buf;
                            th = th2;
                            H5IOUtils.returnBuf(bArr2);
                            H5IOUtils.closeQuietly(tarInputStream);
                            throw th;
                        }
                    } while (!TextUtils.equals(nextEntry.getName(), HPM_FILE_NAME));
                    PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                    while (true) {
                        int read = tarInputStream.read(buf);
                        if (read != -1) {
                            poolingByteArrayOutputStream.write(buf, 0, read);
                        } else {
                            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                            String str3 = new String(byteArray);
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(tarInputStream);
                            return str3;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    tarInputStream2 = tarInputStream;
                    bArr = null;
                    H5Log.e("H5WalletWrapper", (Throwable) e);
                    H5IOUtils.returnBuf(bArr);
                    H5IOUtils.closeQuietly(tarInputStream2);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    H5IOUtils.returnBuf(bArr2);
                    H5IOUtils.closeQuietly(tarInputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                bArr = null;
                tarInputStream2 = null;
                H5Log.e("H5WalletWrapper", (Throwable) e);
                H5IOUtils.returnBuf(bArr);
                H5IOUtils.closeQuietly(tarInputStream2);
                return null;
            } catch (Throwable th4) {
                th = th4;
                tarInputStream = null;
                H5IOUtils.returnBuf(bArr2);
                H5IOUtils.closeQuietly(tarInputStream);
                throw th;
            }
        }
        return null;
    }

    public static ThreadPoolExecutor getExecutor(String str) {
        return H5ThreadPoolFactory.getExecutor(str);
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        return H5ThreadPoolFactory.getScheduledExecutor();
    }

    public static void executeOrdered(String str, Runnable runnable) {
        H5ThreadPoolProvider h5ThreadPoolProvider;
        H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
        if (h5Service == null || (h5ThreadPoolProvider = (H5ThreadPoolProvider) h5Service.getProviderManager().getProvider(H5ThreadPoolProvider.class.getName())) == null) {
            H5ThreadPoolFactory.getSingleThreadExecutor().execute(runnable);
        } else {
            h5ThreadPoolProvider.submitOrdered(str, runnable);
        }
    }

    public static H5ProviderManager getH5ProviderManager() {
        b.a();
        H5Service h5Service = (H5Service) c.a(H5Service.class.getName());
        if (h5Service != null) {
            return h5Service.getProviderManager();
        }
        H5Log.e("H5WalletWrapper", "h5Service == null");
        return null;
    }

    public static Context getContext() {
        b.a();
        return b.c();
    }
}
