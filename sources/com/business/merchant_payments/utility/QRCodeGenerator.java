package com.business.merchant_payments.utility;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.g.a.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.EnumMap;

public class QRCodeGenerator {
    public static final int DEFAULT_BARCODE_DIMENSION = 500;
    public static final int STANDARD_SHARE_QR_IMAGE_DIMENSION = 775;

    public static Bitmap getQrCodeBitmap(String str, int i2, int i3, int i4) {
        return getQrCodeBitmap(str, i2, i3, i4, 5);
    }

    public static Bitmap getQrCodeBitmap(String str, int i2, int i3, int i4, int i5) {
        if (!TextUtils.isEmpty(str) && i2 > 0 && i3 > 0) {
            EnumMap enumMap = new EnumMap(g.class);
            enumMap.put(g.CHARACTER_SET, AppConstants.UTF_8);
            enumMap.put(g.MARGIN, Integer.valueOf(i5));
            enumMap.put(g.ERROR_CORRECTION, f.M);
            try {
                b a2 = new com.google.zxing.g.b().a(str, a.QR_CODE, i2, i3, enumMap);
                int i6 = a2.f39889a;
                int i7 = a2.f39890b;
                int[] iArr = new int[(i6 * i7)];
                for (int i8 = 0; i8 < i7; i8++) {
                    int i9 = i8 * i6;
                    for (int i10 = 0; i10 < i6; i10++) {
                        iArr[i9 + i10] = a2.a(i10, i8) ? i4 : -1;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.RGB_565);
                createBitmap.setPixels(iArr, 0, i6, 0, 0, i6, i7);
                return createBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static Bitmap getQrCodeBitmap(String str, int i2, int i3) {
        return getQrCodeBitmap(str, i2, i2, i3);
    }

    public static Bitmap getQrCodeBitmap(String str) {
        return getQrCodeBitmap(str, 500, 500, -16777216);
    }

    public static Bitmap getQrCodeBitmap(String str, int i2) {
        return getQrCodeBitmap(str, 500, 500, i2);
    }
}
