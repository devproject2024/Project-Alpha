package com.google.zxing.client.android.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.g.a.f;
import com.google.zxing.l;
import java.util.HashMap;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {
    public static Bitmap a(String str, int i2, int i3, boolean z) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put(g.ERROR_CORRECTION, f.H);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                str = b.a(str, UpiConstants.QR_KEY);
            }
            try {
                b a2 = new l().a(str, com.google.zxing.a.QR_CODE, i2, i3, hashMap);
                int i4 = a2.f39889a;
                int i5 = a2.f39890b;
                int[] iArr = new int[(i4 * i5)];
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = i6 * i4;
                    for (int i8 = 0; i8 < i4; i8++) {
                        iArr[i7 + i8] = a2.a(i8, i6) ? -16777216 : -1;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.RGB_565);
                createBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i5);
                return createBitmap;
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
