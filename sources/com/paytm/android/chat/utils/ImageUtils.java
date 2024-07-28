package com.paytm.android.chat.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.core.graphics.drawable.d;
import com.bumptech.glide.b;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.b.f;
import com.bumptech.glide.e.g;
import com.bumptech.glide.e.h;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.d.a.ab;
import com.bumptech.glide.load.d.a.l;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.load.m;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.glide.GlideBlurformation;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ImageUtils {
    private static final int SIZE_DEFAULT = 2048;
    private static final int SIZE_LIMIT = 4096;
    private static final String TAG = ImageUtils.class.getSimpleName();
    public static int sInputImageHeight = 0;
    public static int sInputImageWidth = 0;

    public static int getRotateDegreeFromOrientation(int i2) {
        if (i2 == 3) {
            return AppConstants.READ_TIME_OUT;
        }
        if (i2 != 6) {
            return i2 != 8 ? 0 : 270;
        }
        return 90;
    }

    private ImageUtils() {
    }

    public static void displayRoundImageFromUrl(final Context context, String str, final ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            try {
                b.b(context).d().b((a<?>) (h) ((h) ((h) new h().f()).d(androidx.core.content.b.a(context, R.drawable.chat_icon_group_chat_deful_contact_pic))).l()).b((Object) str).a(new com.bumptech.glide.e.a.b(imageView) {
                    public final void a(Bitmap bitmap) {
                        androidx.core.graphics.drawable.b a2 = d.a(context.getResources(), bitmap);
                        a2.b();
                        imageView.setImageDrawable(a2);
                    }
                });
            } catch (Exception unused) {
                q.d();
            }
        }
    }

    public static void displayCircleCropFromUrl(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            try {
                b.b(context).a(str).b((a<?>) ((h) ((h) ((h) ((h) ((h) new h().l()).b(androidx.core.content.b.a(context, R.drawable.chat_ic_head_pic_def))).d(androidx.core.content.b.a(context, R.drawable.chat_ic_head_pic_def))).j()).a(j.f6875a)).a(false)).a(imageView);
            } catch (Exception unused) {
                q.d();
            }
        }
    }

    public static void displayRoundImageFromUrl(final Context context, int i2, final ImageView imageView) {
        try {
            b.b(context).d().b((a<?>) (h) ((h) new h().f()).l()).a(Integer.valueOf(i2)).a(new com.bumptech.glide.e.a.b(imageView) {
                public final void a(Bitmap bitmap) {
                    androidx.core.graphics.drawable.b a2 = d.a(context.getResources(), bitmap);
                    a2.b();
                    imageView.setImageDrawable(a2);
                }
            });
        } catch (Exception unused) {
            q.d();
        }
    }

    public static void displayConnerImageFromUrl(Context context, String str, ImageView imageView) {
        try {
            b.b(context).d().b((a<?>) (h) ((h) h.b((m<Bitmap>) new ab(dp2px(context, 5.0f))).a(300, 300)).a(j.f6879e)).b((Object) str).a(imageView);
        } catch (Exception unused) {
            q.d();
        }
    }

    public static void displayImageFromUrl(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            displayImageFromUrl(context, str, imageView, androidx.core.content.b.a(context, R.drawable.chat_icon_group_chat_deful_contact_pic), (g) null);
        }
    }

    public static void displayImageFromUrl(Context context, String str, ImageView imageView, Drawable drawable) {
        displayImageFromUrl(context, str, imageView, drawable, (g) null);
    }

    public static void displayImageBlurreFromUrl(Context context, String str, ImageView imageView) {
        displayImageBluuedFromUrl(context, str, imageView);
    }

    public static void displayImageFromUrl(Context context, String str, ImageView imageView, Drawable drawable, g gVar) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            h hVar = (h) ((h) ((h) ((h) new h().l()).a(j.f6879e)).b(drawable)).a(300, 300);
            if (gVar != null) {
                try {
                    b.b(context).a(str).b((a<?>) hVar).a(gVar).a(imageView);
                } catch (Exception unused) {
                    q.d();
                }
            } else {
                b.b(context).a(str).b((a<?>) hVar).a(gVar).a(imageView);
            }
        }
    }

    public static void displayImageFromUrl2(Context context, String str, final ImageView imageView, Drawable drawable, g gVar, final int i2) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            ((h) ((h) ((h) new h().l()).a(j.f6879e)).b(drawable)).a(300, 300);
            if (gVar != null) {
                try {
                    b.b(context).a(str).a(gVar).a(imageView);
                } catch (Exception unused) {
                    q.d();
                }
            } else {
                b.b(context).a(str).a(gVar).a(new com.bumptech.glide.e.a.h<BitmapDrawable>() {
                    public final /* synthetic */ void a(Object obj, f fVar) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) obj;
                        int width = bitmapDrawable.getBitmap().getWidth();
                        int height = bitmapDrawable.getBitmap().getHeight();
                        if (height > width) {
                            ImageView imageView = imageView;
                            Bitmap createBitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap(), 0, 0, width, width);
                            int i2 = i2;
                            imageView.setImageBitmap(ImageUtils.getScaledBitmap(createBitmap, i2, i2));
                            return;
                        }
                        ImageView imageView2 = imageView;
                        Bitmap bitmap = bitmapDrawable.getBitmap();
                        int i3 = i2;
                        imageView2.setImageBitmap(ImageUtils.getScaledBitmap(bitmap, i3, Math.abs(height * i3) / width));
                    }
                });
            }
        }
    }

    public static void displayImageBluuedFromUrl(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            try {
                b.b(context).a(str).b((a<?>) (h) ((h) ((h) h.b((m<Bitmap>) new GlideBlurformation(context)).l()).a(j.f6879e)).a(300, 300)).a(imageView);
            } catch (Exception unused) {
                q.d();
            }
        }
    }

    public static void displayImageFromFile(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            try {
                b.b(context).d().b((Object) Uri.fromFile(new File(str))).b((a<?>) (h) h.b((m<Bitmap>) new ab(dp2px(context, 5.0f))).a(300, 300)).a(imageView);
            } catch (Exception unused) {
                q.d();
            }
        }
    }

    public static void displayCornersImageFromUrl(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            try {
                b.b(context).a(str).b((a<?>) (h) ((h) ((h) h.b((m<Bitmap>) new ab(dp2px(context, 30.0f))).a(300, 300)).b(androidx.core.content.b.a(context, R.drawable.chat_icon_group_chat_deful_contact_pic))).d(androidx.core.content.b.a(context, R.drawable.chat_icon_group_chat_deful_contact_pic))).a(imageView);
            } catch (Exception unused) {
                q.d();
            }
        }
    }

    public static int dp2px(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static void displayRoundImageFromUrlWithoutCache(Context context, String str, ImageView imageView) {
        displayRoundImageFromUrlWithoutCache(context, str, imageView, (g) null);
    }

    public static void displayRoundImageFromUrlWithoutCache(final Context context, String str, final ImageView imageView, g gVar) {
        h hVar = (h) ((h) ((h) ((h) new h().f()).l()).a(j.f6876b)).a(true);
        if (gVar != null) {
            try {
                b.b(context).d().b((Object) str).b((a<?>) hVar).a(gVar).a(new com.bumptech.glide.e.a.b(imageView) {
                    public final void a(Bitmap bitmap) {
                        androidx.core.graphics.drawable.b a2 = d.a(context.getResources(), bitmap);
                        a2.b();
                        imageView.setImageDrawable(a2);
                    }
                });
            } catch (Exception unused) {
                q.d();
            }
        } else {
            b.b(context).d().b((Object) str).b((a<?>) hVar).a(new com.bumptech.glide.e.a.b(imageView) {
                public final void a(Bitmap bitmap) {
                    androidx.core.graphics.drawable.b a2 = d.a(context.getResources(), bitmap);
                    a2.b();
                    imageView.setImageDrawable(a2);
                }
            });
        }
    }

    public static void displayImageFromUrlWithPlaceHolder(Context context, String str, ImageView imageView, int i2) {
        b.b(context).a(str).b((a<?>) (h) ((h) ((h) new h().l()).a(j.f6879e)).a(i2)).a(imageView);
    }

    public static void displayGifImageFromUrl(Context context, String str, ImageView imageView, Drawable drawable, g gVar) {
        h hVar = (h) ((h) ((h) new h().l()).a(j.f6879e)).b(drawable);
        if (gVar != null) {
            try {
                b.b(context).e().b((Object) str).b((a<?>) hVar).a(gVar).a(imageView);
            } catch (Exception unused) {
                q.d();
            }
        } else {
            b.b(context).e().b((Object) str).b((a<?>) hVar).a(imageView);
        }
    }

    public static void displayGifImageFromUrl(Context context, String str, ImageView imageView, String str2, Drawable drawable) {
        h hVar = (h) ((h) ((h) new h().l()).a(j.f6879e)).b(drawable);
        if (str2 != null) {
            try {
                com.bumptech.glide.h<c> a2 = b.b(context).e().b((Object) str).b((a<?>) hVar);
                a2.f6659b = b.b(context).e().b((Object) str2);
                a2.a(imageView);
            } catch (Exception unused) {
                q.d();
            }
        } else {
            b.b(context).e().b((Object) str).b((a<?>) hVar).a(imageView);
        }
    }

    public static String imageToBase64(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return imageToBase64(new File(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        if (r1 != null) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A[SYNTHETIC, Splitter:B:17:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String imageToBase64(java.io.File r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0037
            boolean r1 = r4.exists()
            if (r1 != 0) goto L_0x000a
            goto L_0x0037
        L_0x000a:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0033, all -> 0x002b }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0033, all -> 0x002b }
            int r4 = r1.available()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r1.read(r4)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r3 = 8
            if (r2 < r3) goto L_0x0023
            r2 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
        L_0x0023:
            r1.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x0037
        L_0x0027:
            r4 = move-exception
            goto L_0x002d
        L_0x0029:
            goto L_0x0034
        L_0x002b:
            r4 = move-exception
            r1 = r0
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            throw r4
        L_0x0033:
            r1 = r0
        L_0x0034:
            if (r1 == 0) goto L_0x0037
            goto L_0x0023
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ImageUtils.imageToBase64(java.io.File):java.lang.String");
    }

    public static Bitmap getCircleBitmap(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-65536);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static void displayCircleCropFromDrawable(Context context, ImageView imageView, Drawable drawable) {
        if (context != null) {
            try {
                b.b(context).a(drawable).b((a<?>) ((h) new h().f()).l()).a(imageView);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void disPlayProfileImage(Context context, String str, ImageView imageView) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
            }
            b.b(context).a(str).b((a<?>) ((h) h.b((m<Bitmap>) new l()).d(androidx.core.content.b.a(context, R.drawable.chat_icon_group_chat_deful_contact_pic))).l()).a(imageView);
        }
    }

    public static void copyExifInfo(Context context, Uri uri, Uri uri2, int i2, int i3) {
        if (uri != null && uri2 != null) {
            try {
                File fileFromUri = getFileFromUri(context, uri);
                File fileFromUri2 = getFileFromUri(context, uri2);
                if (fileFromUri == null) {
                    return;
                }
                if (fileFromUri2 != null) {
                    String absolutePath = fileFromUri.getAbsolutePath();
                    String absolutePath2 = fileFromUri2.getAbsolutePath();
                    ExifInterface exifInterface = new ExifInterface(absolutePath);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add("DateTime");
                    arrayList.add("Flash");
                    arrayList.add("FocalLength");
                    arrayList.add("GPSAltitude");
                    arrayList.add("GPSAltitudeRef");
                    arrayList.add("GPSDateStamp");
                    arrayList.add("GPSLatitude");
                    arrayList.add("GPSLatitudeRef");
                    arrayList.add("GPSLongitude");
                    arrayList.add("GPSLongitudeRef");
                    arrayList.add("GPSProcessingMethod");
                    arrayList.add("GPSTimeStamp");
                    arrayList.add("Make");
                    arrayList.add("Model");
                    arrayList.add("WhiteBalance");
                    if (Build.VERSION.SDK_INT >= 11) {
                        arrayList.add("ExposureTime");
                        arrayList.add("FNumber");
                        arrayList.add("ISOSpeedRatings");
                    }
                    if (Build.VERSION.SDK_INT >= 23) {
                        arrayList.add("DateTimeDigitized");
                        arrayList.add("SubSecTime");
                        arrayList.add("SubSecTimeDigitized");
                        arrayList.add("SubSecTimeOriginal");
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        arrayList.add("FNumber");
                        arrayList.add("ISOSpeedRatings");
                        arrayList.add("SubSecTimeDigitized");
                        arrayList.add("SubSecTimeOriginal");
                    }
                    ExifInterface exifInterface2 = new ExifInterface(absolutePath2);
                    for (String str : arrayList) {
                        String attribute = exifInterface.getAttribute(str);
                        if (!TextUtils.isEmpty(attribute)) {
                            exifInterface2.setAttribute(str, attribute);
                        }
                    }
                    exifInterface2.setAttribute("ImageWidth", String.valueOf(i2));
                    exifInterface2.setAttribute("ImageLength", String.valueOf(i3));
                    exifInterface2.setAttribute("Orientation", "0");
                    exifInterface2.saveAttributes();
                }
            } catch (IOException unused) {
            }
        }
    }

    public static int getExifRotation(File file) {
        if (file == null) {
            return 0;
        }
        try {
            return getRotateDegreeFromOrientation(new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0));
        } catch (IOException e2) {
            q.b(e2.getMessage());
            return 0;
        }
    }

    public static int getExifRotation(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i2 = query.getInt(0);
                    if (query != null) {
                        query.close();
                    }
                    return i2;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static int getExifOrientation(Context context, Uri uri) {
        if (uri.getAuthority().toLowerCase().endsWith("media")) {
            return getExifRotation(context, uri);
        }
        return getExifRotation(getFileFromUri(context, uri));
    }

    public static Matrix getMatrixFromExifOrientation(int i2) {
        Matrix matrix = new Matrix();
        switch (i2) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(1.0f, -1.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postRotate(-90.0f);
                matrix.postScale(1.0f, -1.0f);
                break;
            case 8:
                matrix.postRotate(-90.0f);
                break;
        }
        return matrix;
    }

    public static int getExifOrientationFromAngle(int i2) {
        int i3 = i2 % 360;
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 90) {
            return 6;
        }
        if (i3 != 180) {
            return i3 != 270 ? 1 : 8;
        }
        return 3;
    }

    public static Uri ensureUriPermission(Context context, Intent intent) {
        Uri data = intent.getData();
        if (Build.VERSION.SDK_INT >= 19) {
            context.getContentResolver().takePersistableUriPermission(data, intent.getFlags() & 1);
        }
        return data;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f9 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getFileFromUri(android.content.Context r5, android.net.Uri r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 0
            r3 = 19
            if (r0 < r3) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            r3 = 0
            if (r0 == 0) goto L_0x00c3
            boolean r0 = android.provider.DocumentsContract.isDocumentUri(r5, r6)
            if (r0 == 0) goto L_0x00c3
            boolean r0 = isExternalStorageDocument(r6)
            java.lang.String r4 = ":"
            if (r0 == 0) goto L_0x004a
            java.lang.String r5 = android.provider.DocumentsContract.getDocumentId(r6)
            java.lang.String[] r5 = r5.split(r4)
            r6 = r5[r2]
            java.lang.String r0 = "primary"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x00f0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            r6.append(r0)
            java.lang.String r0 = "/"
            r6.append(r0)
            r5 = r5[r1]
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto L_0x00f1
        L_0x004a:
            boolean r0 = isDownloadsDocument(r6)
            if (r0 == 0) goto L_0x0078
            java.lang.String r6 = android.provider.DocumentsContract.getDocumentId(r6)
            boolean r0 = com.paytm.android.chat.utils.ImageUtils.RawDocumentsHelper.isRawDocId(r6)
            if (r0 == 0) goto L_0x0060
            java.lang.String r5 = com.paytm.android.chat.utils.ImageUtils.RawDocumentsHelper.getAbsoluteFilePath(r6)
            goto L_0x00f1
        L_0x0060:
            java.lang.String r0 = "content://downloads/public_downloads"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            long r1 = r6.longValue()
            android.net.Uri r6 = android.content.ContentUris.withAppendedId(r0, r1)
            java.lang.String r5 = getDataColumn(r5, r6, r3, r3)
            goto L_0x00f1
        L_0x0078:
            boolean r0 = isMediaDocument(r6)
            if (r0 == 0) goto L_0x00b8
            java.lang.String r6 = android.provider.DocumentsContract.getDocumentId(r6)
            java.lang.String[] r6 = r6.split(r4)
            r0 = r6[r2]
            java.lang.String r4 = "image"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0093
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x00ab
        L_0x0093:
            java.lang.String r4 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x009f
            android.net.Uri r0 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x00ab
        L_0x009f:
            java.lang.String r4 = "audio"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x00aa
            android.net.Uri r0 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            goto L_0x00ab
        L_0x00aa:
            r0 = r3
        L_0x00ab:
            java.lang.String[] r4 = new java.lang.String[r1]
            r6 = r6[r1]
            r4[r2] = r6
            java.lang.String r6 = "_id=?"
            java.lang.String r5 = getDataColumn(r5, r0, r6, r4)
            goto L_0x00f1
        L_0x00b8:
            boolean r0 = isGoogleDriveDocument(r6)
            if (r0 == 0) goto L_0x00f0
            java.io.File r5 = getGoogleDriveFile(r5, r6)
            return r5
        L_0x00c3:
            java.lang.String r0 = r6.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00df
            boolean r0 = isGooglePhotosUri(r6)
            if (r0 == 0) goto L_0x00da
            java.lang.String r5 = r6.getLastPathSegment()
            goto L_0x00f1
        L_0x00da:
            java.lang.String r5 = getDataColumn(r5, r6, r3, r3)
            goto L_0x00f1
        L_0x00df:
            java.lang.String r5 = r6.getScheme()
            java.lang.String r0 = "file"
            boolean r5 = r0.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00f0
            java.lang.String r5 = r6.getPath()
            goto L_0x00f1
        L_0x00f0:
            r5 = r3
        L_0x00f1:
            if (r5 == 0) goto L_0x00f9
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            return r6
        L_0x00f9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ImageUtils.getFileFromUri(android.content.Context, android.net.Uri):java.io.File");
    }

    public static class RawDocumentsHelper {
        public static final String RAW_PREFIX = "raw:";

        public static boolean isRawDocId(String str) {
            return str != null && str.startsWith(RAW_PREFIX);
        }

        public static String getDocIdForFile(File file) {
            return RAW_PREFIX + file.getAbsolutePath();
        }

        public static String getAbsoluteFilePath(String str) {
            return str.substring(4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            java.lang.String r0 = "_display_name"
            java.lang.String r1 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r1, r0}
            r8 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ all -> 0x0047 }
            r7 = 0
            r3 = r10
            r5 = r11
            r6 = r12
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0047 }
            if (r9 == 0) goto L_0x0041
            boolean r11 = r9.moveToFirst()     // Catch:{ all -> 0x003f }
            if (r11 == 0) goto L_0x0041
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x003f }
            java.lang.String r11 = "content://com.google.android.gallery3d"
            boolean r10 = r10.startsWith(r11)     // Catch:{ all -> 0x003f }
            if (r10 == 0) goto L_0x002e
            int r10 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x003f }
            goto L_0x0032
        L_0x002e:
            int r10 = r9.getColumnIndex(r1)     // Catch:{ all -> 0x003f }
        L_0x0032:
            r11 = -1
            if (r10 == r11) goto L_0x0041
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x003f }
            if (r9 == 0) goto L_0x003e
            r9.close()
        L_0x003e:
            return r10
        L_0x003f:
            r10 = move-exception
            goto L_0x0049
        L_0x0041:
            if (r9 == 0) goto L_0x0046
            r9.close()
        L_0x0046:
            return r8
        L_0x0047:
            r10 = move-exception
            r9 = r8
        L_0x0049:
            if (r9 == 0) goto L_0x004e
            r9.close()
        L_0x004e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ImageUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isGoogleDriveDocument(Uri uri) {
        return "com.google.android.apps.docs.storage".equals(uri.getAuthority());
    }

    private static File getGoogleDriveFile(Context context, Uri uri) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (uri == null) {
            return null;
        }
        String absolutePath = new File(context.getCacheDir(), "tmp").getAbsolutePath();
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                closeQuietly((Closeable) null);
                closeQuietly((Closeable) null);
                return null;
            }
            fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                fileOutputStream = new FileOutputStream(absolutePath);
            } catch (IOException unused) {
                fileOutputStream = null;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream2);
                throw th;
            }
            try {
                byte[] bArr = new byte[SIZE_LIMIT];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        File file = new File(absolutePath);
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        return file;
                    }
                }
            } catch (IOException unused2) {
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                return null;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileOutputStream2 = fileOutputStream;
                th = th3;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream2);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            closeQuietly(fileOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034 A[SYNTHETIC, Splitter:B:16:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC, Splitter:B:25:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeSampledBitmapFromUri(android.content.Context r3, android.net.Uri r4, int r5) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0041, all -> 0x0030 }
            java.io.InputStream r1 = r1.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0041, all -> 0x0030 }
            if (r1 == 0) goto L_0x0021
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ FileNotFoundException -> 0x0042, all -> 0x001f }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0042, all -> 0x001f }
            int r3 = calculateInSampleSize(r3, r4, r5)     // Catch:{ FileNotFoundException -> 0x0042, all -> 0x001f }
            r2.inSampleSize = r3     // Catch:{ FileNotFoundException -> 0x0042, all -> 0x001f }
            r3 = 0
            r2.inJustDecodeBounds = r3     // Catch:{ FileNotFoundException -> 0x0042, all -> 0x001f }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch:{ FileNotFoundException -> 0x0042, all -> 0x001f }
            r0 = r3
            goto L_0x0021
        L_0x001f:
            r3 = move-exception
            goto L_0x0032
        L_0x0021:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0047
        L_0x0027:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.d(r3)
            goto L_0x0047
        L_0x0030:
            r3 = move-exception
            r1 = r0
        L_0x0032:
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.d(r4)
        L_0x0040:
            throw r3
        L_0x0041:
            r1 = r0
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ImageUtils.decodeSampledBitmapFromUri(android.content.Context, android.net.Uri, int):android.graphics.Bitmap");
    }

    public static int calculateInSampleSize(Context context, Uri uri, int i2) {
        InputStream inputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        InputStream inputStream2 = null;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            try {
                BitmapFactory.decodeStream(inputStream, (Rect) null, options);
            } catch (FileNotFoundException unused) {
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                closeQuietly(inputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(inputStream2);
            throw th;
        }
        closeQuietly(inputStream);
        sInputImageWidth = options.outWidth;
        sInputImageHeight = options.outHeight;
        while (true) {
            if (options.outWidth / i3 <= i2 && options.outHeight / i3 <= i2) {
                return i3;
            }
            i3 *= 2;
        }
    }

    public static Bitmap getScaledBitmapForHeight(Bitmap bitmap, int i2) {
        return getScaledBitmap(bitmap, Math.round(((float) i2) * (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()))), i2);
    }

    public static Bitmap getScaledBitmapForWidth(Bitmap bitmap, int i2) {
        return getScaledBitmap(bitmap, i2, Math.round(((float) i2) / (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()))));
    }

    public static Bitmap getScaledBitmap(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i2) / ((float) width), ((float) i3) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static int getMaxSize() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        if (iArr[0] > 0) {
            return Math.min(iArr[0], SIZE_LIMIT);
        }
        return 2048;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void updateGalleryInfo(Context context, Uri uri) {
        if ("content".equals(uri.getScheme())) {
            ContentValues contentValues = new ContentValues();
            File fileFromUri = getFileFromUri(context, uri);
            if (fileFromUri != null && fileFromUri.exists()) {
                contentValues.put("_size", Long.valueOf(fileFromUri.length()));
            }
            context.getContentResolver().update(uri, contentValues, (String) null, (String[]) null);
        }
    }
}
