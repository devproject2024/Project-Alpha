package net.one97.paytm.o2o.movies.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import androidx.core.content.FileProvider;
import com.paytm.utility.s;
import java.io.File;
import java.io.FileOutputStream;
import net.one97.paytm.o2o.movies.R;

public final class w {
    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Uri uri) {
    }

    public static Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return createBitmap;
    }

    public static Uri a(Context context, Bitmap bitmap, String str) {
        String concat = "MovieTicket_".concat(String.valueOf(str));
        if (a()) {
            return a(context, bitmap, 85, Environment.DIRECTORY_PICTURES + File.separator + "Paytm" + File.separator + "Movie tickets" + File.separator, concat);
        }
        return a(context, bitmap, Environment.getExternalStorageDirectory() + File.separator + "Paytm" + File.separator + "Movie tickets", concat, 85);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[Catch:{ Exception -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri a(android.content.Context r10, android.graphics.Bitmap r11, int r12, java.lang.String r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "_id"
            r1 = 0
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x0084 }
            r2.<init>()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = "_display_name"
            r2.put(r3, r14)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = "relative_path"
            r2.put(r3, r13)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = "external"
            android.net.Uri r5 = android.provider.MediaStore.Images.Media.getContentUri(r3)     // Catch:{ Exception -> 0x0084 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x0084 }
            android.net.Uri r2 = r3.insert(r5, r2)     // Catch:{ Exception -> 0x0084 }
            if (r2 != 0) goto L_0x0062
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0084 }
            java.lang.String r7 = "_display_name=? AND relative_path=?"
            r3 = 2
            java.lang.String[] r8 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0084 }
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0084 }
            r4.<init>()     // Catch:{ Exception -> 0x0084 }
            r4.append(r14)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r14 = ".jpg"
            r4.append(r14)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r14 = r4.toString()     // Catch:{ Exception -> 0x0084 }
            r8[r3] = r14     // Catch:{ Exception -> 0x0084 }
            r14 = 1
            r8[r14] = r13     // Catch:{ Exception -> 0x0084 }
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch:{ Exception -> 0x0084 }
            r9 = 0
            android.database.Cursor r13 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0084 }
            if (r13 == 0) goto L_0x0062
            boolean r14 = r13.moveToFirst()     // Catch:{ Exception -> 0x0084 }
            if (r14 == 0) goto L_0x0062
            android.net.Uri r14 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x0084 }
            int r0 = r13.getColumnIndex(r0)     // Catch:{ Exception -> 0x0084 }
            int r13 = r13.getInt(r0)     // Catch:{ Exception -> 0x0084 }
            long r2 = (long) r13     // Catch:{ Exception -> 0x0084 }
            android.net.Uri r2 = android.content.ContentUris.withAppendedId(r14, r2)     // Catch:{ Exception -> 0x0084 }
        L_0x0062:
            if (r2 == 0) goto L_0x0084
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ all -> 0x007c }
            java.io.OutputStream r10 = r10.openOutputStream(r2)     // Catch:{ all -> 0x007c }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x007a }
            r11.compress(r13, r12, r10)     // Catch:{ all -> 0x007a }
            if (r10 == 0) goto L_0x0076
            r10.close()     // Catch:{ Exception -> 0x0084 }
        L_0x0076:
            r11.recycle()     // Catch:{ Exception -> 0x0084 }
            return r2
        L_0x007a:
            r11 = move-exception
            goto L_0x007e
        L_0x007c:
            r11 = move-exception
            r10 = r1
        L_0x007e:
            if (r10 == 0) goto L_0x0083
            r10.close()     // Catch:{ Exception -> 0x0084 }
        L_0x0083:
            throw r11     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.utils.w.a(android.content.Context, android.graphics.Bitmap, int, java.lang.String, java.lang.String):android.net.Uri");
    }

    public static void a(Activity activity) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(activity.getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
            builder.setPositiveButton(activity.getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener(true, activity) {
                private final /* synthetic */ boolean f$0;
                private final /* synthetic */ Activity f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    w.a(this.f$0, this.f$1, dialogInterface, i2);
                }
            });
            builder.setNegativeButton(activity.getResources().getString(R.string.cancel), $$Lambda$w$Y16ZpXbXTL2HFPb1Bf4dVIUGjI.INSTANCE);
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, Activity activity, DialogInterface dialogInterface, int i2) {
        if (z) {
            s.b((Context) activity);
            activity.finish();
            return;
        }
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.providers.downloads"));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static Uri a(Context context, Bitmap bitmap, String str, String str2, int i2) {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "Paytm");
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
        }
        try {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, str2 + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            MediaScannerConnection.scanFile(context, new String[]{file3.toString()}, (String[]) null, $$Lambda$w$ElJ4KGXXqYh333MypGmRWvYGVwE.INSTANCE);
            Uri fromFile = Uri.fromFile(file3);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile);
            context.sendBroadcast(intent);
            return FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file3);
        } catch (Exception unused2) {
            return null;
        }
    }
}
