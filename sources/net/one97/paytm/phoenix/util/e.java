package net.one97.paytm.phoenix.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import com.alipay.mobile.nebula.refresh.H5PullContainer;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import kotlin.g.b.k;
import kotlin.o;
import kotlin.t;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f59639a = new e();

    private e() {
    }

    private static final int a(BitmapFactory.Options options, int i2, int i3) {
        o a2 = t.a(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) a2.component1()).intValue();
        int intValue2 = ((Number) a2.component2()).intValue();
        int i4 = 1;
        if (intValue > i3 || intValue2 > i2) {
            int i5 = intValue / 2;
            int i6 = intValue2 / 2;
            while (i5 / i4 >= i3 && i6 / i4 >= i2) {
                i4 *= 2;
            }
        }
        return i4;
    }

    public static final Bitmap a(File file) {
        k.c(file, CommunityPostActivity.TYPE_FILE);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(new FileInputStream(file), (Rect) null, options);
        options.inSampleSize = a(options, H5PullContainer.DEFALUT_DURATION, H5PullContainer.DEFALUT_DURATION);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(new FileInputStream(file), (Rect) null, options);
    }

    public static Uri a(Context context, Bitmap bitmap) {
        k.c(context, "context");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = a(options, 100, 100);
            options.inJustDecodeBounds = false;
            if (bitmap == null) {
                k.a();
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, true);
            File filesDir = context.getFilesDir();
            File file = new File(filesDir, "Image" + new Random().nextInt() + ".jpeg");
            FileOutputStream openFileOutput = context.openFileOutput(file.getName(), 0);
            k.a((Object) openFileOutput, "context.openFileOutput(\n…ODE_PRIVATE\n            )");
            createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, openFileOutput);
            openFileOutput.flush();
            openFileOutput.close();
            String absolutePath = file.getAbsolutePath();
            k.a((Object) absolutePath, "file.absolutePath");
            return Uri.fromFile(new File(absolutePath));
        } catch (Exception e2) {
            j jVar = j.f59646a;
            String message = e2.getMessage();
            if (message == null) {
                k.a();
            }
            j.c("Your Error Message", message);
            return null;
        }
    }
}
