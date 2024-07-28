package com.zhihu.matisse.internal.c;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.android.chat.R;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.zhihu.matisse.c.a;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.entity.b;
import com.zhihu.matisse.internal.entity.c;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f45746a = e.class.getSimpleName();

    private e() {
        throw new AssertionError("oops! the utility class is about to be instantiated...");
    }

    public static Point a(Uri uri, Activity activity) {
        ContentResolver contentResolver = activity.getContentResolver();
        Point b2 = b(contentResolver, uri);
        int i2 = b2.x;
        int i3 = b2.y;
        if (c(contentResolver, uri)) {
            i2 = b2.y;
            i3 = b2.x;
        }
        if (i3 == 0) {
            return new Point(1600, 1600);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f2 = (float) i2;
        float f3 = ((float) displayMetrics.widthPixels) / f2;
        float f4 = (float) i3;
        float f5 = ((float) displayMetrics.heightPixels) / f4;
        if (f3 > f5) {
            return new Point((int) (f2 * f3), (int) (f4 * f5));
        }
        return new Point((int) (f2 * f3), (int) (f4 * f5));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0026 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[SYNTHETIC, Splitter:B:18:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point b(android.content.ContentResolver r3, android.net.Uri r4) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ FileNotFoundException -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0026 }
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch:{ FileNotFoundException -> 0x0026 }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0026 }
            android.graphics.BitmapFactory.decodeStream(r3, r0, r1)     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001f }
            int r4 = r1.outWidth     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001f }
            int r0 = r1.outHeight     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001f }
            android.graphics.Point r1 = new android.graphics.Point     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001f }
            r1.<init>(r4, r0)     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001f }
            if (r3 == 0) goto L_0x001e
            r3.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r1
        L_0x001f:
            r4 = move-exception
            r0 = r3
            goto L_0x0032
        L_0x0022:
            r0 = r3
            goto L_0x0026
        L_0x0024:
            r4 = move-exception
            goto L_0x0032
        L_0x0026:
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ all -> 0x0024 }
            r4 = 0
            r3.<init>(r4, r4)     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            return r3
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhihu.matisse.internal.c.e.b(android.content.ContentResolver, android.net.Uri):android.graphics.Point");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.ContentResolver r9, android.net.Uri r10) {
        /*
            java.lang.String r0 = "_data"
            r1 = 0
            if (r10 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = r10.getScheme()
            java.lang.String r3 = "content"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0046
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch:{ all -> 0x003e }
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r9
            r4 = r10
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x003e }
            if (r9 == 0) goto L_0x0038
            boolean r10 = r9.moveToFirst()     // Catch:{ all -> 0x0036 }
            if (r10 != 0) goto L_0x0028
            goto L_0x0038
        L_0x0028:
            int r10 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x0036 }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x0036 }
            if (r9 == 0) goto L_0x0035
            r9.close()
        L_0x0035:
            return r10
        L_0x0036:
            r10 = move-exception
            goto L_0x0040
        L_0x0038:
            if (r9 == 0) goto L_0x003d
            r9.close()
        L_0x003d:
            return r1
        L_0x003e:
            r10 = move-exception
            r9 = r1
        L_0x0040:
            if (r9 == 0) goto L_0x0045
            r9.close()
        L_0x0045:
            throw r10
        L_0x0046:
            java.lang.String r9 = r10.getPath()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhihu.matisse.internal.c.e.a(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }

    private static boolean c(ContentResolver contentResolver, Uri uri) {
        try {
            String a2 = a(contentResolver, uri);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            int attributeInt = a.a(a2).getAttributeInt("Orientation", -1);
            if (attributeInt == 6 || attributeInt == 8) {
                return true;
            }
            return false;
        } catch (IOException unused) {
            q.b("could not read exif info of the image: ".concat(String.valueOf(uri)));
            return false;
        }
    }

    public static float a(long j) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("0.0");
        String format = decimalFormat.format((double) ((((float) j) / 1024.0f) / 1024.0f));
        q.b("getSizeInMB: ".concat(String.valueOf(format)));
        return Float.valueOf(format.replaceAll(AppConstants.COMMA, AppUtility.CENTER_DOT)).floatValue();
    }

    public static b a(Context context, Item item) {
        boolean z;
        if (context != null) {
            ContentResolver contentResolver = context.getContentResolver();
            Iterator<com.zhihu.matisse.b> it2 = c.a.f45787a.f45778a.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().checkType(contentResolver, item.f45765c)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            return new b(context.getString(R.string.chat_module_error_file_type));
        }
        if (c.a.f45787a.j == null) {
            return null;
        }
        for (a a2 : c.a.f45787a.j) {
            b a3 = a2.a(context, item);
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }
}
