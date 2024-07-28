package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.a.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    private static final Paint f7115a = new Paint(6);

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f7116b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f7117c;

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f7118d;

    /* renamed from: e  reason: collision with root package name */
    private static final Lock f7119e;

    interface a {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    public static int a(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return AppConstants.READ_TIME_OUT;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static boolean b(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f7118d = hashSet;
        f7119e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new b();
        Paint paint = new Paint(7);
        f7117c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static Lock a() {
        return f7119e;
    }

    public static Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f4 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            f3 = ((float) i3) / ((float) bitmap.getHeight());
            f2 = (((float) i2) - (((float) bitmap.getWidth()) * f3)) * 0.5f;
        } else {
            f3 = ((float) i2) / ((float) bitmap.getWidth());
            f4 = (((float) i3) - (((float) bitmap.getHeight()) * f3)) * 0.5f;
            f2 = 0.0f;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((float) ((int) (f2 + 0.5f)), (float) ((int) (f4 + 0.5f)));
        Bitmap a2 = eVar.a(i2, i3, b(bitmap));
        a(bitmap, a2);
        a(bitmap, a2, matrix);
        return a2;
    }

    public static Bitmap b(e eVar, Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        float min = Math.min(((float) i2) / ((float) bitmap.getWidth()), ((float) i3) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        Bitmap a2 = eVar.a((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), b(bitmap));
        a(bitmap, a2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            StringBuilder sb = new StringBuilder("request: ");
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            StringBuilder sb2 = new StringBuilder("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append("x");
            sb2.append(bitmap.getHeight());
            StringBuilder sb3 = new StringBuilder("toReuse: ");
            sb3.append(a2.getWidth());
            sb3.append("x");
            sb3.append(a2.getHeight());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, a2, matrix);
        return a2;
    }

    public static Bitmap c(e eVar, Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            Log.isLoggable("TransformationUtils", 2);
            return b(eVar, bitmap, i2, i3);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        if (i2 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception unused) {
            Log.isLoggable("TransformationUtils", 6);
            return bitmap;
        }
    }

    public static Bitmap a(e eVar, Bitmap bitmap, int i2) {
        if (!b(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap a2 = eVar.a(Math.round(rectF.width()), Math.round(rectF.height()), b(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        a2.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, a2, matrix);
        return a2;
    }

    /* JADX INFO: finally extract failed */
    public static Bitmap d(e eVar, Bitmap bitmap, int i2, int i3) {
        int min = Math.min(i2, i3);
        float f2 = (float) min;
        float f3 = f2 / 2.0f;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float max = Math.max(f2 / width, f2 / height);
        float f4 = width * max;
        float f5 = max * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap a2 = a(eVar, bitmap);
        Bitmap a3 = eVar.a(min, min, a(bitmap));
        a3.setHasAlpha(true);
        f7119e.lock();
        try {
            Canvas canvas = new Canvas(a3);
            canvas.drawCircle(f3, f3, f3, f7116b);
            canvas.drawBitmap(a2, (Rect) null, rectF, f7117c);
            canvas.setBitmap((Bitmap) null);
            f7119e.unlock();
            if (!a2.equals(bitmap)) {
                eVar.a(a2);
            }
            return a3;
        } catch (Throwable th) {
            f7119e.unlock();
            throw th;
        }
    }

    private static Bitmap a(e eVar, Bitmap bitmap) {
        Bitmap.Config a2 = a(bitmap);
        if (a2.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap a3 = eVar.a(bitmap.getWidth(), bitmap.getHeight(), a2);
        new Canvas(a3).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return a3;
    }

    private static Bitmap.Config a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.RGBA_F16;
    }

    public static Bitmap b(e eVar, Bitmap bitmap, final int i2) {
        j.a(i2 > 0, "roundingRadius must be greater than 0.");
        return a(eVar, bitmap, (a) new a() {
            public final void a(Canvas canvas, Paint paint, RectF rectF) {
                int i2 = i2;
                canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
            }
        });
    }

    /* JADX INFO: finally extract failed */
    private static Bitmap a(e eVar, Bitmap bitmap, a aVar) {
        Bitmap.Config a2 = a(bitmap);
        Bitmap a3 = a(eVar, bitmap);
        Bitmap a4 = eVar.a(a3.getWidth(), a3.getHeight(), a2);
        a4.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(a3, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, (float) a4.getWidth(), (float) a4.getHeight());
        f7119e.lock();
        try {
            Canvas canvas = new Canvas(a4);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            aVar.a(canvas, paint, rectF);
            canvas.setBitmap((Bitmap) null);
            f7119e.unlock();
            if (!a3.equals(bitmap)) {
                eVar.a(a3);
            }
            return a4;
        } catch (Throwable th) {
            f7119e.unlock();
            throw th;
        }
    }

    private static Bitmap.Config b(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        f7119e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f7115a);
            canvas.setBitmap((Bitmap) null);
        } finally {
            f7119e.unlock();
        }
    }

    static final class b implements Lock {
        public final void lock() {
        }

        public final void lockInterruptibly() throws InterruptedException {
        }

        public final boolean tryLock() {
            return true;
        }

        public final boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public final void unlock() {
        }

        b() {
        }

        public final Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }
    }
}
