package net.one97.paytm.acceptPayment.webviewutils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.FileProvider;
import androidx.core.content.b;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a {
    public static Uri a(Context context) {
        File file;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uri = null;
        try {
            File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            file = File.createTempFile("img_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_", ".png", externalFilesDir);
            new Thread(new Runnable(externalFilesDir, file) {
                private final /* synthetic */ File f$0;
                private final /* synthetic */ File f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    a.a(this.f$0, this.f$1);
                }
            }).start();
        } catch (Exception unused) {
            file = null;
        }
        if (file != null) {
            uri = FileProvider.getUriForFile(context, "net.one97.paytm.acceptPayment.share_provider", file);
            intent.putExtra("output", uri);
            if (Build.VERSION.SDK_INT >= 21) {
                intent.addFlags(1);
                intent.addFlags(2);
            } else if (context.getPackageManager() != null) {
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
                    context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
                }
            }
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                ((Activity) context).startActivityForResult(intent, 5000);
            }
        }
        return uri;
    }

    public static void b(Context context) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        ((Activity) context).startActivityForResult(intent, 5001);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(File file, File file2) {
        if (file != null && file.exists()) {
            for (File file3 : file.listFiles()) {
                if (!file3.getName().equalsIgnoreCase(file2.getName())) {
                    file3.delete();
                }
            }
        }
    }

    public static boolean c(Context context) {
        return b.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && b.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }
}
