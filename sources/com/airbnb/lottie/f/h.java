package com.airbnb.lottie.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import com.airbnb.lottie.a.a.s;
import com.airbnb.lottie.c;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final PathMeasure f6122a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private static final Path f6123b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private static final Path f6124c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private static final float[] f6125d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    private static final float f6126e = ((float) (Math.sqrt(2.0d) / 2.0d));

    /* renamed from: f  reason: collision with root package name */
    private static float f6127f = -1.0f;

    public static int a(float f2, float f3, float f4, float f5) {
        int i2 = f2 != 0.0f ? (int) (f2 * 527.0f) : 17;
        if (f3 != 0.0f) {
            i2 = (int) (((float) (i2 * 31)) * f3);
        }
        if (f4 != 0.0f) {
            i2 = (int) (((float) (i2 * 31)) * f4);
        }
        return f5 != 0.0f ? (int) (((float) (i2 * 31)) * f5) : i2;
    }

    public static boolean a(int i2, int i3, int i4) {
        if (i2 < 4) {
            return false;
        }
        if (i2 > 4) {
            return true;
        }
        if (i3 < 4) {
            return false;
        }
        return i3 > 4 || i4 >= 0;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static float a(Matrix matrix) {
        float[] fArr = f6125d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = f6126e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = f6125d;
        return (float) Math.hypot((double) (fArr2[2] - fArr2[0]), (double) (fArr2[3] - fArr2[1]));
    }

    public static boolean b(Matrix matrix) {
        float[] fArr = f6125d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        float[] fArr2 = f6125d;
        return fArr2[0] == fArr2[2] || fArr2[1] == fArr2[3];
    }

    public static void a(Path path, float f2, float f3, float f4) {
        c.a("applyTrimPathIfNeeded");
        f6122a.setPath(path, false);
        float length = f6122a.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            c.b("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f3 - f2) - 1.0f)) < 0.01d) {
            c.b("applyTrimPathIfNeeded");
        } else {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = (float) g.a(min, length);
                max = (float) g.a(max, length);
            }
            if (min < 0.0f) {
                min = (float) g.a(min, length);
            }
            if (max < 0.0f) {
                max = (float) g.a(max, length);
            }
            int i2 = (min > max ? 1 : (min == max ? 0 : -1));
            if (i2 == 0) {
                path.reset();
                c.b("applyTrimPathIfNeeded");
                return;
            }
            if (i2 >= 0) {
                min -= length;
            }
            f6123b.reset();
            f6122a.getSegment(min, max, f6123b, true);
            if (max > length) {
                f6124c.reset();
                f6122a.getSegment(0.0f, max % length, f6124c, true);
                f6123b.addPath(f6124c);
            } else if (min < 0.0f) {
                f6124c.reset();
                f6122a.getSegment(min + length, length, f6124c, true);
                f6123b.addPath(f6124c);
            }
            path.set(f6123b);
            c.b("applyTrimPathIfNeeded");
        }
    }

    public static float a() {
        if (f6127f == -1.0f) {
            f6127f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f6127f;
    }

    public static float a(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static boolean a(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void a(Canvas canvas, RectF rectF, Paint paint) {
        a(canvas, rectF, paint, 31);
    }

    public static void a(Canvas canvas, RectF rectF, Paint paint, int i2) {
        c.a("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i2);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        c.b("Utils#saveLayer");
    }

    public static void a(Path path, s sVar) {
        if (sVar != null && !sVar.f5742a) {
            a(path, ((com.airbnb.lottie.a.b.c) sVar.f5744c).h() / 100.0f, ((com.airbnb.lottie.a.b.c) sVar.f5745d).h() / 100.0f, ((com.airbnb.lottie.a.b.c) sVar.f5746e).h() / 360.0f);
        }
    }
}
