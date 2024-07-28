package com.business.merchant_payments.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import java.io.ByteArrayOutputStream;

public class ShareDownloadImageGenerator {
    public static final int LOW_MEMORY = 0;
    public static final int NO_MEMORY = -1;
    public static final int NO_MEMORY_CONSTRAINTS = 2;
    public static final String TAG = "ShareDownloadImageGenerator";

    public static Bitmap getShareDownloadQrBitmap(String str, Bitmap bitmap, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (str == null || !str.equalsIgnoreCase(AppConstants.UPI_QR_CODE)) {
            BitmapFactory.decodeResource(PaymentsConfig.getInstance().getAppContext().getResources(), R.drawable.mp_paytm_download_qr_new, options);
        } else {
            BitmapFactory.decodeResource(PaymentsConfig.getInstance().getAppContext().getResources(), R.drawable.mp_all_in_one_qr_new, options);
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inMutable = true;
        options2.inJustDecodeBounds = false;
        int memoryConstraints = getMemoryConstraints(options);
        if (memoryConstraints != -1) {
            if (memoryConstraints == 0) {
                options2.inPreferredConfig = Bitmap.Config.RGB_565;
            } else if (memoryConstraints == 2) {
                options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            if (str != null) {
                try {
                    if (str.equalsIgnoreCase(AppConstants.UPI_QR_CODE)) {
                        return addQrAndNameInAllInOneQRImage(BitmapFactory.decodeResource(PaymentsConfig.getInstance().getAppContext().getResources(), R.drawable.mp_all_in_one_qr_new, options2), bitmap, str2);
                    }
                } catch (OutOfMemoryError unused) {
                    LogUtility.d(TAG, "Device does not have enough memory to load image in memory for drawing name and qr");
                    return null;
                }
            }
            return addQrAndNameInImage(str, BitmapFactory.decodeResource(PaymentsConfig.getInstance().getAppContext().getResources(), R.drawable.mp_paytm_download_qr_new, options2), bitmap, str2);
        }
        LogUtility.d(TAG, "Device does not have enough memory to load image in memory for drawing name and qr");
        return null;
    }

    public static Bitmap addQrAndNameInAllInOneQRImage(Bitmap bitmap, Bitmap bitmap2, String str) {
        Typeface typeface;
        int i2;
        LogUtility.d(TAG, "Size of background image =" + (bitmap.getByteCount() / TarConstants.EOF_BLOCK));
        Canvas canvas = new Canvas(bitmap);
        LogUtility.d(TAG, "canvas dimensions, Width =" + canvas.getWidth() + " Height =" + canvas.getHeight());
        String[] firstSecondNameLine = getFirstSecondNameLine(str);
        String str2 = firstSecondNameLine[0];
        String str3 = firstSecondNameLine[1];
        float width = (float) (bitmap.getWidth() / 2);
        float height = (float) ((bitmap.getHeight() / 2) + 820);
        if (AppUtility.getOSVersion() >= 14) {
            typeface = Typeface.create("sans-serif", 1);
        } else {
            typeface = Typeface.create(Typeface.SANS_SERIF, 1);
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-16777216);
        paint.setAntiAlias(true);
        paint.setTextSize(70.0f);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(typeface);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        if (!TextUtils.isEmpty(str3)) {
            canvas.drawText(str3, width, height, paint);
            i2 = rect.height() + 40;
        } else {
            i2 = 0;
        }
        canvas.drawText(str2, width, height - ((float) i2), paint);
        canvas.drawBitmap(bitmap2, (float) ((bitmap.getWidth() - bitmap2.getWidth()) / 2), (float) ((bitmap.getHeight() / 2) - 300), (Paint) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap addQrAndNameInImage(String str, Bitmap bitmap, Bitmap bitmap2, String str2) {
        Typeface typeface;
        int i2;
        LogUtility.d(TAG, "Size of background image =" + (bitmap.getByteCount() / TarConstants.EOF_BLOCK));
        Canvas canvas = new Canvas(bitmap);
        LogUtility.d(TAG, "canvas dimensions, Width =" + canvas.getWidth() + " Height =" + canvas.getHeight());
        if (str != null) {
            String[] firstSecondNameLine = getFirstSecondNameLine(str2);
            String str3 = firstSecondNameLine[0];
            String str4 = firstSecondNameLine[1];
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(-16777216);
            paint.setAntiAlias(true);
            paint.setTextSize(65.0f);
            paint.setTextAlign(Paint.Align.CENTER);
            if (AppUtility.getOSVersion() >= 14) {
                typeface = Typeface.create("sans-serif", 1);
            } else {
                typeface = Typeface.create(Typeface.SANS_SERIF, 1);
            }
            paint.setTypeface(typeface);
            Rect rect = new Rect();
            paint.getTextBounds(str2, 0, str2.length(), rect);
            float width = (float) (bitmap.getWidth() / 2);
            float height = (float) ((bitmap.getHeight() / 2) - 510);
            if (!TextUtils.isEmpty(str4)) {
                canvas.drawText(str4, width, height, paint);
                i2 = rect.height() + 15;
            } else {
                i2 = 0;
            }
            canvas.drawText(str3, width, height - ((float) i2), paint);
        }
        canvas.drawBitmap(bitmap2, (float) ((bitmap.getWidth() - bitmap2.getWidth()) / 2), (float) ((bitmap.getHeight() / 2) - 400), (Paint) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static String[] getFirstSecondNameLine(String str) {
        StringBuilder sb = new StringBuilder(20);
        StringBuilder sb2 = new StringBuilder(20);
        if (str.length() > 20) {
            String[] split = str.split(" ");
            if (split.length == 1) {
                sb.append(split[0].substring(0, 17));
                sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.DOTS);
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= split.length) {
                        break;
                    }
                    if (sb.length() < 20) {
                        if (sb.length() + split[i2].length() < 20) {
                            sb.append(split[i2]);
                            sb.append(" ");
                        } else if (sb.length() == 0) {
                            sb.append(split[0].substring(0, 17));
                            sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.DOTS);
                        }
                    }
                    i2++;
                }
                while (true) {
                    if (i2 >= split.length) {
                        break;
                    } else if (sb2.length() + split[i2].length() < 20) {
                        sb2.append(split[i2]);
                        sb2.append(" ");
                        i2++;
                    } else if (sb2.length() == 0) {
                        sb2.append(split[i2].substring(0, 17));
                        sb2.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.DOTS);
                    } else if (sb2.charAt(sb2.length() - 1) == '.') {
                        sb2.append("..");
                    } else {
                        sb2.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.DOTS);
                    }
                }
            }
        } else {
            sb.append(str);
        }
        return new String[]{sb.toString(), sb2.toString()};
    }

    public static int getMemoryConstraints(BitmapFactory.Options options) {
        int i2 = options.outWidth * options.outHeight;
        long runTimeFreeMemory = getRunTimeFreeMemory();
        if (runTimeFreeMemory > ((long) (getBytesPerPixel(options.inPreferredConfig) * i2))) {
            return 2;
        }
        return runTimeFreeMemory > ((long) (i2 * getBytesPerPixel(Bitmap.Config.RGB_565))) ? 0 : -1;
    }

    public static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    public static long getRunTimeFreeMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }
}
