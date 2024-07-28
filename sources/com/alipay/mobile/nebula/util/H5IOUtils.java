package com.alipay.mobile.nebula.util;

import com.alipay.mobile.nebula.io.ByteArrayPool;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public class H5IOUtils {
    private static final String TAG = "H5IOUtils";
    private static final ByteArrayPool sByteArrayPool = new ByteArrayPool(20480);

    public static ByteArrayPool getByteArrayPool() {
        return sByteArrayPool;
    }

    public static byte[] getBuf(int i2) {
        return getByteArrayPool().getBuf(i2);
    }

    public static void returnBuf(byte[] bArr) {
        getByteArrayPool().returnBuf(bArr);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
    }

    public static byte[] inputToByte(InputStream inputStream) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        byte[] bArr;
        if (inputStream == null) {
            returnBuf((byte[]) null);
            closeQuietly((Closeable) null);
            return null;
        }
        try {
            bArr = getBuf(EmiUtil.EMI_PLAN_REQUEST_CODE);
            try {
                poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            poolingByteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                            returnBuf(bArr);
                            closeQuietly(poolingByteArrayOutputStream);
                            return byteArray;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            H5Log.e(TAG, (Throwable) e);
                            returnBuf(bArr);
                            closeQuietly(poolingByteArrayOutputStream);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            returnBuf(bArr);
                            closeQuietly(poolingByteArrayOutputStream);
                            throw th;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                poolingByteArrayOutputStream = null;
                H5Log.e(TAG, (Throwable) e);
                returnBuf(bArr);
                closeQuietly(poolingByteArrayOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                poolingByteArrayOutputStream = null;
                returnBuf(bArr);
                closeQuietly(poolingByteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bArr = null;
            poolingByteArrayOutputStream = null;
            H5Log.e(TAG, (Throwable) e);
            returnBuf(bArr);
            closeQuietly(poolingByteArrayOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            bArr = null;
            poolingByteArrayOutputStream = null;
            returnBuf(bArr);
            closeQuietly(poolingByteArrayOutputStream);
            throw th;
        }
    }
}
