package net.one97.paytm.paymentsBank.widget.croptool;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.paymentsBank.widget.croptool.PBCropImageView;

final class c {

    /* renamed from: a  reason: collision with root package name */
    static final Rect f19715a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    static final RectF f19716b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    static final RectF f19717c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    static final float[] f19718d = new float[6];

    /* renamed from: e  reason: collision with root package name */
    static final float[] f19719e = new float[6];

    /* renamed from: f  reason: collision with root package name */
    static Pair<String, WeakReference<Bitmap>> f19720f;

    /* renamed from: g  reason: collision with root package name */
    private static int f19721g;

    static b a(Bitmap bitmap, Context context, Uri uri) {
        ExifInterface exifInterface = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                ExifInterface exifInterface2 = new ExifInterface(uri.toString());
                try {
                    openInputStream.close();
                } catch (Exception unused) {
                }
                exifInterface = exifInterface2;
            }
        } catch (Exception unused2) {
        }
        return exifInterface != null ? a(bitmap, exifInterface) : new b(bitmap, 0);
    }

    static b a(Bitmap bitmap, ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
        return new b(bitmap, attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : AppConstants.READ_TIME_OUT);
    }

    static a a(Context context, Uri uri, int i2, int i3) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            BitmapFactory.Options a2 = a(contentResolver, uri);
            int a3 = a(a2.outWidth, a2.outHeight, i2, i3);
            int i4 = a2.outWidth;
            int i5 = a2.outHeight;
            int i6 = 1;
            if (f19721g == 0) {
                f19721g = a();
            }
            if (f19721g > 0) {
                while (true) {
                    if (i5 / i6 <= f19721g && i4 / i6 <= f19721g) {
                        break;
                    }
                    i6 *= 2;
                }
            }
            a2.inSampleSize = Math.max(a3, i6);
            return new a(a(contentResolver, uri, a2), a2.inSampleSize);
        } catch (Exception e2) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e2.getMessage(), e2);
        }
    }

    static a a(Bitmap bitmap, float[] fArr, int i2, boolean z, int i3, int i4, boolean z2, boolean z3) {
        int i5 = 1;
        do {
            try {
                return new a(a(bitmap, fArr, i2, z, i3, i4, 1.0f / ((float) i5), z2, z3), i5);
            } catch (OutOfMemoryError e2) {
                i5 *= 2;
                if (i5 > 8) {
                    throw e2;
                }
            }
        } while (i5 > 8);
        throw e2;
    }

    private static Bitmap a(Bitmap bitmap, float[] fArr, int i2, boolean z, int i3, int i4, float f2, boolean z2, boolean z3) {
        Bitmap bitmap2 = bitmap;
        int i5 = i2;
        float f3 = f2;
        Rect a2 = a(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i3, i4);
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i5, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        float f4 = z2 ? -f3 : f3;
        if (z3) {
            f3 = -f3;
        }
        matrix.postScale(f4, f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, a2.left, a2.top, a2.width(), a2.height(), matrix, true);
        if (createBitmap == bitmap2) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i5 % 90 != 0 ? a(createBitmap, fArr, a2, i2, z, i3, i4) : createBitmap;
    }

    static a a(Context context, Uri uri, float[] fArr, int i2, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, boolean z2, boolean z3) {
        OutOfMemoryError outOfMemoryError;
        int i9 = 1;
        do {
            try {
                return a(context, uri, fArr, i2, i3, i4, z, i5, i6, i7, i8, z2, z3, i9);
            } catch (OutOfMemoryError e2) {
                outOfMemoryError = e2;
                i9 *= 2;
                if (i9 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i9 + "): " + uri + "\r\n" + outOfMemoryError.getMessage(), outOfMemoryError);
                }
            }
        } while (i9 > 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i9 + "): " + uri + "\r\n" + outOfMemoryError.getMessage(), outOfMemoryError);
    }

    static float a(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float b(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float c(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    static float d(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    static float e(float[] fArr) {
        return c(fArr) - a(fArr);
    }

    static float f(float[] fArr) {
        return d(fArr) - b(fArr);
    }

    static float g(float[] fArr) {
        return (c(fArr) + a(fArr)) / 2.0f;
    }

    static float h(float[] fArr) {
        return (d(fArr) + b(fArr)) / 2.0f;
    }

    static Rect a(float[] fArr, int i2, int i3, boolean z, int i4, int i5) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, a(fArr))), Math.round(Math.max(0.0f, b(fArr))), Math.round(Math.min((float) i2, c(fArr))), Math.round(Math.min((float) i3, d(fArr))));
        if (z) {
            a(rect, i4, i5);
        }
        return rect;
    }

    private static void a(Rect rect, int i2, int i3) {
        if (i2 == i3 && rect.width() != rect.height()) {
            if (rect.height() > rect.width()) {
                rect.bottom -= rect.height() - rect.width();
            } else {
                rect.right -= rect.width() - rect.height();
            }
        }
    }

    static Uri a(Context context, Bitmap bitmap, Uri uri) {
        boolean z = true;
        if (uri == null) {
            try {
                uri = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
            } catch (Exception unused) {
                return null;
            }
        } else if (new File(uri.getPath()).exists()) {
            z = false;
        }
        if (z) {
            a(context, bitmap, uri, Bitmap.CompressFormat.JPEG, 95);
        }
        return uri;
    }

    static void a(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i2) throws FileNotFoundException {
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i2, outputStream);
        } finally {
            a((Closeable) outputStream);
        }
    }

    static Bitmap a(Bitmap bitmap, int i2, int i3, PBCropImageView.i iVar) {
        if (i2 > 0 && i3 > 0) {
            try {
                if (iVar == PBCropImageView.i.RESIZE_FIT || iVar == PBCropImageView.i.RESIZE_INSIDE || iVar == PBCropImageView.i.RESIZE_EXACT) {
                    Bitmap bitmap2 = null;
                    if (iVar == PBCropImageView.i.RESIZE_EXACT) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, i2, i3, false);
                    } else {
                        float width = (float) bitmap.getWidth();
                        float height = (float) bitmap.getHeight();
                        float max = Math.max(width / ((float) i2), height / ((float) i3));
                        if (max > 1.0f || iVar == PBCropImageView.i.RESIZE_FIT) {
                            bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (width / max), (int) (height / max), false);
                        }
                    }
                    if (bitmap2 != null) {
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmap2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.paymentsBank.widget.croptool.c.a a(android.content.Context r19, android.net.Uri r20, float[] r21, int r22, int r23, int r24, boolean r25, int r26, int r27, int r28, int r29, boolean r30, boolean r31, int r32) {
        /*
            r0 = r22
            r1 = r21
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            android.graphics.Rect r9 = a((float[]) r1, (int) r2, (int) r3, (boolean) r4, (int) r5, (int) r6)
            if (r28 <= 0) goto L_0x0017
            r10 = r28
            goto L_0x001c
        L_0x0017:
            int r1 = r9.width()
            r10 = r1
        L_0x001c:
            if (r29 <= 0) goto L_0x0021
            r11 = r29
            goto L_0x0026
        L_0x0021:
            int r1 = r9.height()
            r11 = r1
        L_0x0026:
            r1 = 0
            r8 = 1
            r2 = r19
            r3 = r20
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r32
            net.one97.paytm.paymentsBank.widget.croptool.c$a r2 = a((android.content.Context) r2, (android.net.Uri) r3, (android.graphics.Rect) r4, (int) r5, (int) r6, (int) r7)     // Catch:{ Exception -> 0x003a }
            android.graphics.Bitmap r1 = r2.f19722a     // Catch:{ Exception -> 0x003a }
            int r8 = r2.f19723b     // Catch:{ Exception -> 0x003a }
            goto L_0x003b
        L_0x003a:
        L_0x003b:
            if (r1 == 0) goto L_0x009f
            if (r0 > 0) goto L_0x0046
            if (r30 != 0) goto L_0x0046
            if (r31 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r10 = r1
            goto L_0x007b
        L_0x0046:
            android.graphics.Matrix r2 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x0098 }
            r2.<init>()     // Catch:{ OutOfMemoryError -> 0x0098 }
            float r3 = (float) r0     // Catch:{ OutOfMemoryError -> 0x0098 }
            r2.setRotate(r3)     // Catch:{ OutOfMemoryError -> 0x0098 }
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r30 == 0) goto L_0x0058
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x005a
        L_0x0058:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x005a:
            if (r31 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x005f:
            r2.postScale(r5, r3)     // Catch:{ OutOfMemoryError -> 0x0098 }
            r13 = 0
            r14 = 0
            int r15 = r1.getWidth()     // Catch:{ OutOfMemoryError -> 0x0098 }
            int r16 = r1.getHeight()     // Catch:{ OutOfMemoryError -> 0x0098 }
            r18 = 0
            r12 = r1
            r17 = r2
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ OutOfMemoryError -> 0x0098 }
            if (r2 == r1) goto L_0x007a
            r1.recycle()     // Catch:{ OutOfMemoryError -> 0x0098 }
        L_0x007a:
            r10 = r2
        L_0x007b:
            int r1 = r0 % 90
            if (r1 == 0) goto L_0x008f
            r1 = r10
            r2 = r21
            r3 = r9
            r4 = r22
            r5 = r25
            r6 = r26
            r7 = r27
            android.graphics.Bitmap r10 = a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ OutOfMemoryError -> 0x0095 }
        L_0x008f:
            net.one97.paytm.paymentsBank.widget.croptool.c$a r0 = new net.one97.paytm.paymentsBank.widget.croptool.c$a
            r0.<init>(r10, r8)
            return r0
        L_0x0095:
            r0 = move-exception
            r1 = r10
            goto L_0x0099
        L_0x0098:
            r0 = move-exception
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.recycle()
        L_0x009e:
            throw r0
        L_0x009f:
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r32
            r12 = r30
            r13 = r31
            net.one97.paytm.paymentsBank.widget.croptool.c$a r0 = a((android.content.Context) r1, (android.net.Uri) r2, (float[]) r3, (int) r4, (boolean) r5, (int) r6, (int) r7, (int) r8, (android.graphics.Rect) r9, (int) r10, (int) r11, (boolean) r12, (boolean) r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.widget.croptool.c.a(android.content.Context, android.net.Uri, float[], int, int, int, boolean, int, int, int, int, boolean, boolean, int):net.one97.paytm.paymentsBank.widget.croptool.c$a");
    }

    private static a a(Context context, Uri uri, float[] fArr, int i2, boolean z, int i3, int i4, int i5, Rect rect, int i6, int i7, boolean z2, boolean z3) {
        Bitmap a2;
        Uri uri2 = uri;
        float[] fArr2 = fArr;
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int a3 = a(rect.width(), rect.height(), i6, i7) * i5;
            options.inSampleSize = a3;
            a2 = a(context.getContentResolver(), uri2, options);
            if (a2 != null) {
                float[] fArr3 = new float[fArr2.length];
                System.arraycopy(fArr2, 0, fArr3, 0, fArr2.length);
                for (int i8 = 0; i8 < fArr3.length; i8++) {
                    fArr3[i8] = fArr3[i8] / ((float) options.inSampleSize);
                }
                bitmap = a(a2, fArr3, i2, z, i3, i4, 1.0f, z2, z3);
                if (bitmap != a2) {
                    a2.recycle();
                }
            }
            return new a(bitmap, a3);
        } catch (OutOfMemoryError e2) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri2 + "\r\n" + e3.getMessage(), e3);
        } catch (Throwable th) {
            if (a2 != null) {
                a2.recycle();
            }
            throw th;
        }
    }

    private static BitmapFactory.Options a(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        InputStream inputStream;
        try {
            inputStream = contentResolver.openInputStream(uri);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, f19715a, options);
                options.inJustDecodeBounds = false;
                a((Closeable) inputStream);
                return options;
            } catch (Throwable th) {
                th = th;
                a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            a((Closeable) inputStream);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        a((java.io.Closeable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r4.inSampleSize *= 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        a((java.io.Closeable) null);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(android.content.ContentResolver r2, android.net.Uri r3, android.graphics.BitmapFactory.Options r4) throws java.io.FileNotFoundException {
        /*
        L_0x0000:
            r0 = 0
            java.io.InputStream r0 = r2.openInputStream(r3)     // Catch:{ OutOfMemoryError -> 0x0011 }
            android.graphics.Rect r1 = f19715a     // Catch:{ OutOfMemoryError -> 0x0011 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r0, r1, r4)     // Catch:{ OutOfMemoryError -> 0x0011 }
            a((java.io.Closeable) r0)
            return r2
        L_0x000f:
            r2 = move-exception
            goto L_0x0031
        L_0x0011:
            int r1 = r4.inSampleSize     // Catch:{ all -> 0x000f }
            int r1 = r1 * 2
            r4.inSampleSize = r1     // Catch:{ all -> 0x000f }
            a((java.io.Closeable) r0)
            int r0 = r4.inSampleSize
            r1 = 512(0x200, float:7.175E-43)
            if (r0 > r1) goto L_0x0021
            goto L_0x0000
        L_0x0021:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed to decode image: "
            java.lang.String r3 = r4.concat(r3)
            r2.<init>(r3)
            throw r2
        L_0x0031:
            a((java.io.Closeable) r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.widget.croptool.c.a(android.content.ContentResolver, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        r7.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        a((java.io.Closeable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        if (r7 == null) goto L_0x0036;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.one97.paytm.paymentsBank.widget.croptool.c.a a(android.content.Context r4, android.net.Uri r5, android.graphics.Rect r6, int r7, int r8, int r9) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            r1.<init>()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r2 = r6.width()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r3 = r6.height()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r7 = a((int) r2, (int) r3, (int) r7, (int) r8)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            int r9 = r9 * r7
            r1.inSampleSize = r9     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            java.io.InputStream r4 = r4.openInputStream(r5)     // Catch:{ Exception -> 0x0061, all -> 0x005e }
            r7 = 0
            android.graphics.BitmapRegionDecoder r7 = android.graphics.BitmapRegionDecoder.newInstance(r4, r7)     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
        L_0x0023:
            net.one97.paytm.paymentsBank.widget.croptool.c$a r8 = new net.one97.paytm.paymentsBank.widget.croptool.c$a     // Catch:{ OutOfMemoryError -> 0x003b }
            android.graphics.Bitmap r9 = r7.decodeRegion(r6, r1)     // Catch:{ OutOfMemoryError -> 0x003b }
            int r2 = r1.inSampleSize     // Catch:{ OutOfMemoryError -> 0x003b }
            r8.<init>(r9, r2)     // Catch:{ OutOfMemoryError -> 0x003b }
            a((java.io.Closeable) r4)
            if (r7 == 0) goto L_0x0036
            r7.recycle()
        L_0x0036:
            return r8
        L_0x0037:
            r5 = move-exception
            goto L_0x0058
        L_0x0039:
            r6 = move-exception
            goto L_0x005c
        L_0x003b:
            int r8 = r1.inSampleSize     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            int r8 = r8 * 2
            r1.inSampleSize = r8     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            int r8 = r1.inSampleSize     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
            r9 = 512(0x200, float:7.175E-43)
            if (r8 <= r9) goto L_0x0023
            a((java.io.Closeable) r4)
            if (r7 == 0) goto L_0x004f
            r7.recycle()
        L_0x004f:
            net.one97.paytm.paymentsBank.widget.croptool.c$a r4 = new net.one97.paytm.paymentsBank.widget.croptool.c$a
            r5 = 1
            r4.<init>(r0, r5)
            return r4
        L_0x0056:
            r5 = move-exception
            r7 = r0
        L_0x0058:
            r0 = r4
            goto L_0x0084
        L_0x005a:
            r6 = move-exception
            r7 = r0
        L_0x005c:
            r0 = r4
            goto L_0x0063
        L_0x005e:
            r5 = move-exception
            r7 = r0
            goto L_0x0084
        L_0x0061:
            r6 = move-exception
            r7 = r0
        L_0x0063:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            java.lang.String r9 = "Failed to load sampled bitmap: "
            r8.<init>(r9)     // Catch:{ all -> 0x0083 }
            r8.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = "\r\n"
            r8.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r6.getMessage()     // Catch:{ all -> 0x0083 }
            r8.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x0083 }
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0083 }
            throw r4     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r5 = move-exception
        L_0x0084:
            a((java.io.Closeable) r0)
            if (r7 == 0) goto L_0x008c
            r7.recycle()
        L_0x008c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.widget.croptool.c.a(android.content.Context, android.net.Uri, android.graphics.Rect, int, int, int):net.one97.paytm.paymentsBank.widget.croptool.c$a");
    }

    private static Bitmap a(Bitmap bitmap, float[] fArr, Rect rect, int i2, boolean z, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (i2 % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians((double) i2);
        int i8 = (i2 < 90 || (i2 > 180 && i2 < 270)) ? rect.left : rect.right;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i10 < fArr.length) {
                if (fArr[i10] >= ((float) (i8 - 1)) && fArr[i10] <= ((float) (i8 + 1))) {
                    int i11 = i10 + 1;
                    i9 = (int) Math.abs(Math.sin(radians) * ((double) (((float) rect.bottom) - fArr[i11])));
                    i6 = (int) Math.abs(Math.cos(radians) * ((double) (fArr[i11] - ((float) rect.top))));
                    i7 = (int) Math.abs(((double) (fArr[i11] - ((float) rect.top))) / Math.sin(radians));
                    i5 = (int) Math.abs(((double) (((float) rect.bottom) - fArr[i11])) / Math.cos(radians));
                    break;
                }
                i10 += 2;
            } else {
                i5 = 0;
                i6 = 0;
                i7 = 0;
                break;
            }
        }
        rect.set(i9, i6, i7 + i9, i5 + i6);
        if (z) {
            a(rect, i3, i4);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private static int a(int i2, int i3, int i4, int i5) {
        int i6 = 1;
        if (i3 > i5 || i2 > i4) {
            while ((i3 / 2) / i6 > i5 && (i2 / 2) / i6 > i4) {
                i6 *= 2;
            }
        }
        return i6;
    }

    private static int a() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eglGetDisplay, (EGLConfig[]) null, 0, iArr);
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
            egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
            int[] iArr2 = new int[1];
            int i2 = 0;
            for (int i3 = 0; i3 < iArr[0]; i3++) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i3], 12332, iArr2);
                if (i2 < iArr2[0]) {
                    i2 = iArr2[0];
                }
            }
            egl10.eglTerminate(eglGetDisplay);
            return Math.max(i2, EmiUtil.EMI_PLAN_REQUEST_CODE);
        } catch (Exception unused) {
            return EmiUtil.EMI_PLAN_REQUEST_CODE;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f19722a;

        /* renamed from: b  reason: collision with root package name */
        final int f19723b;

        a(Bitmap bitmap, int i2) {
            this.f19722a = bitmap;
            this.f19723b = i2;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f19724a;

        /* renamed from: b  reason: collision with root package name */
        final int f19725b;

        b(Bitmap bitmap, int i2) {
            this.f19724a = bitmap;
            this.f19725b = i2;
        }
    }
}
