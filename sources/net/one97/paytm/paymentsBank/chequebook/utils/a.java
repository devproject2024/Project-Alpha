package net.one97.paytm.paymentsBank.chequebook.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static int f17945a;

    public static void a(String str) {
        f17945a = 0;
        while (new File(str).length() > 512000) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = 3;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                decodeFile.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream);
                decodeFile.recycle();
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception unused) {
                int i2 = f17945a;
                if (i2 != 3) {
                    f17945a = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
