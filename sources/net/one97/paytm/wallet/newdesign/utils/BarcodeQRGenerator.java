package net.one97.paytm.wallet.newdesign.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.google.zxing.l;
import com.paytm.e.a.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.Arrays;
import java.util.Map;

public enum BarcodeQRGenerator {
    INSTANCE;
    
    private int barQRHeight;

    public final String getOfflineBarcodeQRSoundData(String str, long j, String str2, String str3, String str4, String str5, int i2) {
        String str6;
        try {
            new a();
            str6 = a.a(str, "6", j, i2);
        } catch (Exception unused) {
            str6 = "0";
        }
        return str2 + str3 + str6 + str4 + str5;
    }

    public final Bitmap getBarcode(Activity activity, String str) {
        try {
            if (this.barQRHeight == 0) {
                this.barQRHeight = b.a(100, (Context) activity);
            }
            com.google.zxing.b.b a2 = new l().a(Uri.encode(str), com.google.zxing.a.CODE_128, getBarcodeWidth(activity), 1);
            int i2 = a2.f39889a;
            Bitmap createBitmap = Bitmap.createBitmap(i2, this.barQRHeight, Bitmap.Config.ARGB_8888);
            for (int i3 = 0; i3 < i2; i3++) {
                int[] iArr = new int[this.barQRHeight];
                Arrays.fill(iArr, a2.a(i3, 0) ? -16777216 : -1);
                createBitmap.setPixels(iArr, 0, 1, i3, 0, 1, this.barQRHeight);
            }
            return createBitmap;
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return null;
        }
    }

    public final Bitmap getQRcode(Activity activity, String str) {
        l lVar = new l();
        try {
            if (this.barQRHeight == 0) {
                this.barQRHeight = b.a(100, (Context) activity);
            }
            com.google.zxing.b.b a2 = lVar.a(str, com.google.zxing.a.QR_CODE, this.barQRHeight, this.barQRHeight);
            Bitmap createBitmap = Bitmap.createBitmap(a2.f39889a, a2.f39890b, Bitmap.Config.ARGB_8888);
            for (int i2 = 0; i2 < a2.f39889a; i2++) {
                for (int i3 = 0; i3 < a2.f39890b; i3++) {
                    createBitmap.setPixel(i2, i3, a2.a(i2, i3) ? -16777216 : -1);
                }
            }
            return createBitmap;
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return null;
        }
    }

    public final Bitmap getQRcodeHints(Activity activity, String str, Map map) {
        l lVar = new l();
        try {
            if (this.barQRHeight == 0) {
                this.barQRHeight = b.a(100, (Context) activity);
            }
            com.google.zxing.b.b a2 = lVar.a(str, com.google.zxing.a.QR_CODE, this.barQRHeight, this.barQRHeight, map);
            Bitmap createBitmap = Bitmap.createBitmap(a2.f39889a, a2.f39890b, Bitmap.Config.ARGB_8888);
            for (int i2 = 0; i2 < a2.f39889a; i2++) {
                for (int i3 = 0; i3 < a2.f39890b; i3++) {
                    createBitmap.setPixel(i2, i3, a2.a(i2, i3) ? -16777216 : -1);
                }
            }
            return createBitmap;
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
            return null;
        }
    }

    private int getBarcodeWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
