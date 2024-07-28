package com.alipay.mobile.nebula.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.h5container.api.H5ImageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5ImageProvider;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class H5ImageUtil {
    static final String TAG = "ImageUtil";
    public static String gifBase64 = "data:image/gif;base64,";
    public static String iconBase64 = "data:image/x-icon;base64,";
    public static String jpgBae64 = "data:image/jpeg;base64,";
    public static String pngBase64 = "data:image/png;base64,";

    public static Bitmap scaleBitmap(Bitmap bitmap, int i2, int i3) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(((float) i2) / ((float) width), ((float) i3) / ((float) height));
        Matrix matrix = new Matrix();
        matrix.postScale(min, min);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e2) {
            H5Log.e(TAG, "OutOfMemoryError", e2);
            return null;
        }
    }

    public static Drawable byteToDrawable(String str) {
        byte[] decode = Base64.decode(base64Deal(str), 0);
        if (decode != null) {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        }
        return null;
    }

    public static String getImageTempDir(Context context) {
        return context.getFilesDir() + "/h5container/image/temp" + File.separator;
    }

    public static Bitmap imageQuality(Bitmap bitmap, int i2) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        if (i2 >= 100) {
            return bitmap;
        }
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, poolingByteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(poolingByteArrayOutputStream.toByteArray());
        try {
            bitmap2 = BitmapFactory.decodeStream(byteArrayInputStream, (Rect) null, new BitmapFactory.Options());
        } catch (OutOfMemoryError e2) {
            H5Log.e(TAG, "exception detail", e2);
        } catch (Throwable th) {
            H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
            H5IOUtils.closeQuietly(byteArrayInputStream);
            throw th;
        }
        H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
        H5IOUtils.closeQuietly(byteArrayInputStream);
        return bitmap2;
    }

    public static Bitmap getDiskBitmap(String str, int i2, int i3) {
        FileInputStream fileInputStream;
        Bitmap bitmap = null;
        if (!H5FileUtil.exists(str)) {
            return null;
        }
        H5Log.debug(TAG, "getDiskBitmap begin");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ALPHA_8;
        options.inJustDecodeBounds = true;
        options.inDither = false;
        options.inTempStorage = new byte[32768];
        H5Log.debug(TAG, "getDiskBitmap decodeFile begin");
        BitmapFactory.decodeFile(str, options);
        H5Log.debug(TAG, "getDiskBitmap decodeFile after");
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if ((i4 <= i2 && i5 <= i3) || i2 <= 0 || i3 <= 0) {
            return BitmapFactory.decodeFile(str);
        }
        float f2 = (float) i4;
        float f3 = f2 / ((float) i2);
        float f4 = (float) i5;
        float f5 = f4 / ((float) i3);
        if (f3 > f5) {
            i3 = (int) (f4 / f3);
        } else {
            i2 = (int) (f2 / f5);
        }
        options.inSampleSize = Math.min(i4 / i2, i5 / i3);
        options.inJustDecodeBounds = false;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (FileNotFoundException e2) {
            H5Log.e(TAG, String.valueOf(e2));
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                H5Log.debug(TAG, "getDiskBitmap decodeFileDescriptor begin");
                Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), (Rect) null, options);
                H5Log.debug(TAG, "getDiskBitmap decodeFileDescriptor after");
                bitmap = Bitmap.createScaledBitmap(decodeFileDescriptor, i2, i3, true);
                if (decodeFileDescriptor != bitmap) {
                    decodeFileDescriptor.recycle();
                }
                fileInputStream.close();
            } catch (IOException e3) {
                H5Log.e("create bitmap exception:".concat(String.valueOf(e3)));
            }
        } else {
            H5Log.e(TAG, "not file.".concat(String.valueOf(str)));
        }
        H5Log.debug(TAG, "getDiskBitmap after");
        return bitmap;
    }

    public static Bitmap getDiskBitmap(String str, int i2, int i3, int i4) {
        Bitmap diskBitmap = getDiskBitmap(str, i2, i3);
        if (diskBitmap == null) {
            return null;
        }
        if (i4 < 50 || i4 > 100) {
            H5Log.d(TAG, "set quality as default 75.");
            i4 = 75;
        }
        if (i4 == 100) {
            return diskBitmap;
        }
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
        diskBitmap.compress(Bitmap.CompressFormat.JPEG, i4, poolingByteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(poolingByteArrayOutputStream.toByteArray());
        diskBitmap.recycle();
        Bitmap decodeStream = BitmapFactory.decodeStream(byteArrayInputStream, (Rect) null, (BitmapFactory.Options) null);
        H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
        return decodeStream;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x002a A[SYNTHETIC, Splitter:B:24:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0035 A[SYNTHETIC, Splitter:B:31:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeImage(android.graphics.Bitmap r4, android.graphics.Bitmap.CompressFormat r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "Exception"
            java.lang.String r1 = "ImageUtil"
            if (r4 == 0) goto L_0x003e
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0022 }
            r6 = 100
            r4.compress(r5, r6, r3)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
            r3.close()     // Catch:{ IOException -> 0x0015 }
            return
        L_0x0015:
            r4 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r4)
            return
        L_0x001a:
            r4 = move-exception
            r2 = r3
            goto L_0x0033
        L_0x001d:
            r4 = move-exception
            r2 = r3
            goto L_0x0023
        L_0x0020:
            r4 = move-exception
            goto L_0x0033
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            java.lang.String r5 = "exception detail."
            com.alipay.mobile.nebula.util.H5Log.e(r1, r5, r4)     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ IOException -> 0x002e }
            return
        L_0x002e:
            r4 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r4)
            return
        L_0x0033:
            if (r2 == 0) goto L_0x003d
            r2.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r5 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r5)
        L_0x003d:
            throw r4
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5ImageUtil.writeImage(android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, java.lang.String):void");
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, float f2) {
        Bitmap bitmap2;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f2);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e2) {
            H5Log.e(TAG, "OutOfMemoryError", e2);
            bitmap2 = null;
        }
        return bitmap2 == null ? bitmap : bitmap2;
    }

    public static String bitmapToString(Bitmap bitmap, String str) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
        bitmap.compress("jpg".equals(str) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, poolingByteArrayOutputStream);
        byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
        H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
        return Base64.encodeToString(byteArray, 2);
    }

    public static Bitmap base64ToBitmap(String str) {
        try {
            byte[] decode = Base64.decode(base64Deal(str), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }

    @Deprecated
    public static String getMimeType(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        byte[] decode = Base64.decode(base64Deal(str), 0);
        BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
        H5Log.d(TAG, "--type is " + options.outMimeType);
        return options.outMimeType;
    }

    public static long getBitmapSize(Bitmap bitmap) {
        try {
            if (Build.VERSION.SDK_INT >= 12) {
                return (long) bitmap.getByteCount();
            }
            return (long) (bitmap.getRowBytes() * bitmap.getHeight());
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return 0;
        }
    }

    public static String base64Deal(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(gifBase64)) {
            return str.replace(gifBase64, "");
        }
        if (str.startsWith(pngBase64)) {
            return str.replace(pngBase64, "");
        }
        if (str.startsWith(jpgBae64)) {
            return str.replace(jpgBae64, "");
        }
        return str.startsWith(iconBase64) ? str.replace(iconBase64, "") : str;
    }

    public static String getExtensionFromBase64(String str) {
        String mimeType = getMimeType(str);
        if (!TextUtils.isEmpty(str)) {
            if ("image/gif".equals(mimeType)) {
                return "gif";
            }
            if ("image/png".equals(mimeType)) {
                return "png";
            }
            if ("image/jpg".equals(mimeType)) {
                return "jpg";
            }
            if ("image/icon".equals(mimeType)) {
                return H5Param.MENU_ICON;
            }
        }
        return "";
    }

    public static InputStream base64ToInputStream(String str) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null && !"no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_base64ToInputStream"))) {
            return base64ToInput(str);
        }
        try {
            byte[] decode = Base64.decode(base64Deal(str), 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
            try {
                decodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, poolingByteArrayOutputStream);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(poolingByteArrayOutputStream.toByteArray());
                H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                return byteArrayInputStream;
            } catch (Throwable unused) {
                try {
                    H5Log.d(TAG, "base64ToInputStream, inputStream is null");
                    return null;
                } finally {
                    H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                }
            }
        } catch (Throwable unused2) {
            poolingByteArrayOutputStream = null;
            H5Log.d(TAG, "base64ToInputStream, inputStream is null");
            return null;
        }
    }

    private static InputStream base64ToInput(String str) {
        try {
            H5Log.d(TAG, "");
            return new ByteArrayInputStream(Base64.decode(base64Deal(str), 0));
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }

    public static void loadImage(String str, final H5ImageListener h5ImageListener) {
        H5ImageProvider h5ImageProvider = (H5ImageProvider) H5Utils.getProvider(H5ImageProvider.class.getName());
        if (TextUtils.isEmpty(str)) {
            if (h5ImageListener != null) {
                h5ImageListener.onImage((Bitmap) null);
            }
        } else if (h5ImageProvider != null) {
            h5ImageProvider.loadImage(str, new H5ImageListener() {
                public final void onImage(Bitmap bitmap) {
                    H5ImageListener h5ImageListener = h5ImageListener;
                    if (h5ImageListener != null) {
                        h5ImageListener.onImage(bitmap);
                    }
                }
            });
        } else {
            H5Utils.getExecutor(H5ThreadType.RPC).execute(new H5ImageLoader(str, new H5ImageListener() {
                public final void onImage(Bitmap bitmap) {
                    H5ImageListener h5ImageListener = h5ImageListener;
                    if (h5ImageListener != null) {
                        h5ImageListener.onImage(bitmap);
                    }
                }
            }));
        }
    }
}
